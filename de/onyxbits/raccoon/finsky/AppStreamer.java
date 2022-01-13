package de.onyxbits.raccoon.finsky;

import de.onyxbits.raccoon.proto.AndroidAppDeliveryData;
import de.onyxbits.raccoon.proto.AppFileMetadata;
import de.onyxbits.raccoon.proto.HttpCookie;
import de.onyxbits.raccoon.proto.SplitDeliveryData;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPInputStream;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

public class AppStreamer {
   public static final int MAIN_OBB = 0;
   public static final int PATCH_OBB = 1;
   private AndroidAppDeliveryData aadd;
   private boolean compress;
   private String userAgent;
   private ClientProvider clientProvider;

   public AppStreamer(HttpClient client, String userAgent, boolean compress, AndroidAppDeliveryData aadd) {
      this((ClientProvider)(new DefaultClientProvider(client)), userAgent, compress, aadd);
   }

   public AppStreamer(ClientProvider provider, String userAgent, boolean compress, AndroidAppDeliveryData aadd) {
      this.aadd = aadd;
      this.clientProvider = provider;
      this.compress = compress;
   }

   public long sizeOf() {
      return this.aadd.getDownloadSize();
   }

   public long sizeOfAdditionalFiles() {
      long ret = 0L;

      AppFileMetadata afm;
      for(Iterator var3 = this.aadd.getAdditionalFileList().iterator(); var3.hasNext(); ret += afm.getSize()) {
         afm = (AppFileMetadata)var3.next();
      }

      return ret;
   }

   public long sizeOfSplitFiles() {
      long ret = 0L;

      SplitDeliveryData sdd;
      for(Iterator var3 = this.aadd.getSplitDeliveryDataList().iterator(); var3.hasNext(); ret += sdd.getDownloadSize()) {
         sdd = (SplitDeliveryData)var3.next();
      }

      return ret;
   }

   public int countFiles() {
      int ret = 1;
      int ret = ret + this.aadd.getAdditionalFileCount();
      ret += this.aadd.getSplitDeliveryDataCount();
      return ret;
   }

   public AndroidAppDeliveryData getAndroidAppDeliveryData() {
      return this.aadd;
   }

   public List getAdditionalFiles() {
      return this.aadd.getAdditionalFileList();
   }

   public List getSplitFiles() {
      return this.aadd.getSplitDeliveryDataList();
   }

   public InputStream open() throws IOException, HttpResponseException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException, ClientProtocolException, InvalidAlgorithmParameterException {
      InputStream ret = null;
      if (this.compress && this.aadd.hasGzippedDownloadUrl()) {
         ret = new GZIPInputStream(this.open(this.aadd.getGzippedDownloadUrl(), this.aadd.getDownloadAuthCookieList()));
      } else {
         ret = this.open(this.aadd.getDownloadUrl(), this.aadd.getDownloadAuthCookieList());
      }

      if (this.aadd.hasEncryptionParams()) {
         int version = ((InputStream)ret).read();
         if (version != 0) {
            throw new ClientProtocolException("Unknown crypto container!");
         } else {
            ((InputStream)ret).skip(4L);
            byte[] iv = new byte[16];
            ((InputStream)ret).read(iv);
            byte[] encoded = this.aadd.getEncryptionParams().getEncryptionKey().getBytes("UTF-8");
            byte[] decoded = Base64G.decode((byte[])encoded, 0);
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding", "SunJCE");
            SecretKeySpec key = new SecretKeySpec(decoded, "AES");
            cipher.init(2, key, new IvParameterSpec(iv));
            return new CipherInputStream((InputStream)ret, cipher);
         }
      } else {
         return (InputStream)ret;
      }
   }

   public InputStream openPatch() throws HttpResponseException, IOException {
      return this.aadd.hasPatchData() ? this.open(this.aadd.getPatchData().getDownloadUrl(), this.aadd.getDownloadAuthCookieList()) : null;
   }

   public InputStream openPatch(AppFileMetadata afm) throws HttpResponseException, IOException {
      return afm.hasAndroidAppPatchData() ? this.open(afm.getAndroidAppPatchData().getDownloadUrl(), this.aadd.getDownloadAuthCookieList()) : null;
   }

   public InputStream open(AppFileMetadata afm) throws HttpResponseException, IOException {
      return (InputStream)(this.compress && afm.hasCompressedDownloadUrl() ? new GZIPInputStream(this.open(afm.getCompressedDownloadUrl(), this.aadd.getDownloadAuthCookieList())) : this.open(afm.getDownloadUrl(), this.aadd.getDownloadAuthCookieList()));
   }

   public InputStream open(SplitDeliveryData sdd) throws HttpResponseException, IOException {
      return (InputStream)(this.compress && sdd.hasGzippedDownloadUrl() ? new GZIPInputStream(this.open(sdd.getGzippedDownloadUrl(), this.aadd.getDownloadAuthCookieList())) : this.open(sdd.getDownloadUrl(), this.aadd.getDownloadAuthCookieList()));
   }

   public InputStream openPatch(SplitDeliveryData sdd) throws HttpResponseException, IOException {
      return sdd.hasPatchData() ? this.open(sdd.getPatchData().getDownloadUrl(), this.aadd.getDownloadAuthCookieList()) : null;
   }

   private InputStream open(String url, List cookies) throws HttpResponseException, IOException {
      HttpGet get = new HttpGet(url);
      if (this.userAgent != null) {
         get.setHeader(Headers.agent(this.userAgent));
      }

      Iterator var4 = cookies.iterator();

      while(var4.hasNext()) {
         HttpCookie hc = (HttpCookie)var4.next();
         get.setHeader(Headers.cookie(hc.getName() + "=" + hc.getValue()));
      }

      HttpResponse response = this.clientProvider.getClient().execute(get);
      StatusLine sl = response.getStatusLine();
      if (sl.getStatusCode() != 200) {
         EntityUtils.consumeQuietly(response.getEntity());
         throw new HttpResponseException(sl.getStatusCode(), sl.getReasonPhrase());
      } else {
         return response.getEntity().getContent();
      }
   }
}
