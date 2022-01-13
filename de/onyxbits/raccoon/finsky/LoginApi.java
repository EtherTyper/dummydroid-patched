package de.onyxbits.raccoon.finsky;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class LoginApi {
   private static final String HOST = "android.clients.google.com";
   private static final String AUTH_SERVLET = "https://android.clients.google.com/auth";
   private static final String PUBKEY = "AAAAgMom/1a/v0lblO2Ubrt60J2gcuXSljGFQXgcyZWveWLEwo6prwgi3iJIZdodyhKZQrNWp5nKJ3srRXcUW+F1BD3baEVGcmEgqaLZUNBjm057pKRI16kB0YppeGx5qIQ5QjKzsR8ETQbKLNWgRY0QRNVz34kMJR3P/LgHax/6rmf5AAAAAwEAAQ==";
   private Locale locale;
   private int sdk;
   private long gsfId;
   private ClientProvider clientProvider;
   private HeaderProvider headerProvider;

   public LoginApi(HttpClient client, Header... headers) {
      this((ClientProvider)(new DefaultClientProvider(client)), (HeaderProvider)(new DefaultHeaderProvider(headers)));
   }

   public LoginApi(ClientProvider cp, HeaderProvider hp) {
      if (cp != null && hp != null) {
         this.clientProvider = cp;
         this.headerProvider = hp;
      } else {
         throw new NullPointerException();
      }
   }

   public Locale getLocale() {
      return this.locale;
   }

   public void setLocale(Locale locale) {
      this.locale = locale;
   }

   public int getSdk() {
      return this.sdk;
   }

   public void setSdk(int sdk) {
      this.sdk = sdk;
   }

   public long getGsfId() {
      return this.gsfId;
   }

   public void setGsfId(long gsfId) {
      this.gsfId = gsfId;
   }

   public AuthenticatedUser requestSignIn(String uid, String epwd, Captcha captcha, boolean created) throws IOException, BadAuthenticationException, CaptchaException, ClientLoginDisabledException {
      List baseList = new ArrayList();
      addTo(baseList, "accountType", "HOSTED_OR_GOOGLE");
      addTo(baseList, "has_permission", "1");
      addTo(baseList, "add_account", "1");
      addTo(baseList, "source", "android");
      addTo(baseList, "Email", uid);
      if (this.sdk != 0) {
         addTo(baseList, "sdk_version", "" + this.sdk);
      }

      if (this.gsfId != 0L) {
         addTo(baseList, "androidId", Long.toHexString(this.gsfId));
      }

      if (created) {
         addTo(baseList, "created", "1");
      }

      if (this.locale != null) {
         String country = this.locale.getCountry().toLowerCase();
         addTo(baseList, "device_country", country);
         addTo(baseList, "operatorCountry", country);
         addTo(baseList, "lang", this.locale.getLanguage());
      }

      if (captcha != null && captcha.token != null && captcha.solution != null) {
         addTo(baseList, "logintoken", captcha.token);
         addTo(baseList, "logincaptcha", captcha.solution);
      }

      List list = new ArrayList(baseList);
      addTo(list, "EncryptedPasswd", epwd);
      addTo(list, "service", "ac2dm");
      Map map = this.send(list);
      if (map.containsKey("Token")) {
         list = new ArrayList(baseList);
         addTo(list, "Token", (String)map.get("Token"));
         addTo(list, "service", "androidmarket");
         map.put("Auth", this.send(list).get("Auth"));
      }

      return new AuthenticatedUser(uid, (String)map.get("firstName"), (String)map.get("lastName"), (String)map.get("Email"), splitCsv((String)map.get("services")), (String)map.get("Auth"));
   }

   public AuthenticatedUser requestFirstSignIn(String uid, String epwd) throws UnsupportedOperationException, IOException, ClientLoginDisabledException {
      List baseList = new ArrayList();
      addTo(baseList, "accountType", "HOSTED_OR_GOOGLE");
      addTo(baseList, "has_permission", "1");
      addTo(baseList, "source", "android");
      addTo(baseList, "Email", uid);
      addTo(baseList, "created", "1");
      if (this.locale != null) {
         String country = this.locale.getCountry().toLowerCase();
         addTo(baseList, "device_country", country);
         addTo(baseList, "operatorCountry", country);
         addTo(baseList, "lang", this.locale.getLanguage());
      }

      List list = new ArrayList(baseList);
      addTo(list, "EncryptedPasswd", epwd);
      addTo(list, "service", "ac2dm");
      Map map = this.send(list);
      return new AuthenticatedUser(uid, (String)map.get("firstName"), (String)map.get("lastName"), (String)map.get("Email"), splitCsv((String)map.get("services")), (String)map.get("Auth"));
   }

   private Map send(List formFields) throws UnsupportedOperationException, IOException, ClientLoginDisabledException {
      HttpPost httppost = new HttpPost("https://android.clients.google.com/auth");
      httppost.setEntity(new UrlEncodedFormEntity(formFields));
      httppost.addHeader(Headers.urlEnc());
      httppost.addHeader(Headers.host("android.clients.google.com"));
      Header agent = this.headerProvider.headerFor("User-Agent");
      if (agent != null) {
         httppost.addHeader(agent);
      }

      HttpResponse res = this.clientProvider.getClient().execute(httppost);
      HttpEntity entity = res.getEntity();
      Map map = parseContent(entity.getContent());
      StatusLine sl = res.getStatusLine();
      int sc = sl.getStatusCode();
      switch(sc) {
      case 200:
         return map;
      default:
         if ("BadAuthentication".equals(map.get("Error"))) {
            if ("InvalidSecondFactor".equals(map.get("Info"))) {
               throw new InvalidSecondFactorException(sc, sl.getReasonPhrase());
            } else if ("WebLoginRequired".equals(map.get("Info"))) {
               throw new WebLoginRequiredException(sc, sl.getReasonPhrase(), (String)map.get("Url"));
            } else {
               throw new BadAuthenticationException(sc, sl.getReasonPhrase());
            }
         } else if ("ClientLoginDisabled".equals(map.get("Error"))) {
            throw new ClientLoginDisabledException(sc, sl.getReasonPhrase());
         } else if ("NeedsBrowser".equals(map.get("Error"))) {
            throw new NeedsBrowserException(sc, sl.getReasonPhrase(), (String)map.get("ErrorDetail"), (String)map.get("Url"));
         } else if ("CaptchaRequired".equals(map.get("Error"))) {
            Captcha c = new Captcha();
            c.token = (String)map.get("CaptchaToken");
            HttpGet get = new HttpGet((String)map.get("CaptchaUrl"));
            if (agent != null) {
               get.addHeader(agent);
            }

            HttpResponse response = this.clientProvider.getClient().execute(get);
            c.data = EntityUtils.toByteArray(response.getEntity());
            throw new CaptchaException(sc, sl.getReasonPhrase(), c);
         } else {
            throw new HttpResponseException(sc, sl.getReasonPhrase());
         }
      }
   }

   private static void addTo(List lst, String key, String val) {
      lst.add(new BasicNameValuePair(key, val));
   }

   private static List splitCsv(String csv) {
      ArrayList ret = new ArrayList();
      if (csv != null) {
         String[] tmp = csv.split(" *, *");
         String[] var3 = tmp;
         int var4 = tmp.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            String s = var3[var5];
            ret.add(s);
         }
      }

      return ret;
   }

   private static Map parseContent(InputStream in) throws IOException {
      HashMap ret = new HashMap();
      int k = false;
      boolean value = false;
      StringBuilder key = new StringBuilder();
      StringBuilder val = new StringBuilder();

      while(true) {
         while(true) {
            int k = in.read();
            if (k == -1) {
               ret.put(key.toString(), val.toString());
               in.close();
               return ret;
            }

            if (k == 61 && !value) {
               value = true;
            } else if (k == 10) {
               value = false;
               ret.put(key.toString(), val.toString());
               key.setLength(0);
               val.setLength(0);
            } else if (k != 13) {
               if (value) {
                  val.append((char)k);
               } else {
                  key.append((char)k);
               }
            }
         }
      }
   }

   public static String encryptPassword(String uid, char[] pwd) {
      try {
         byte[] tmpuid = uid.getBytes("UTF-8");
         CharBuffer charBuffer = CharBuffer.wrap(pwd);
         ByteBuffer byteBuffer = Charset.forName("UTF-8").encode(charBuffer);
         byte[] tmppwd = Arrays.copyOfRange(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit());
         Arrays.fill(byteBuffer.array(), (byte)0);
         byte[] buffer = new byte[tmpuid.length + tmppwd.length + 1];
         System.arraycopy(tmpuid, 0, buffer, 0, tmpuid.length);
         buffer[tmpuid.length] = 0;
         System.arraycopy(tmppwd, 0, buffer, tmpuid.length + 1, tmppwd.length);
         String ret = encrypt(buffer);

         int i;
         for(i = 0; i < buffer.length; ++i) {
            buffer[i] = 0;
         }

         for(i = 0; i < tmppwd.length; ++i) {
            tmppwd[i] = 0;
         }

         return ret;
      } catch (Exception var9) {
         throw new RuntimeException("Java installation lacks crypt support", var9);
      }
   }

   private static String encrypt(byte[] bytes) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, UnsupportedEncodingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
      int i = 0;
      byte[] obj = new byte[5];
      Key createKeyFromString = createKeyFromString("AAAAgMom/1a/v0lblO2Ubrt60J2gcuXSljGFQXgcyZWveWLEwo6prwgi3iJIZdodyhKZQrNWp5nKJ3srRXcUW+F1BD3baEVGcmEgqaLZUNBjm057pKRI16kB0YppeGx5qIQ5QjKzsR8ETQbKLNWgRY0QRNVz34kMJR3P/LgHax/6rmf5AAAAAwEAAQ==", obj);
      if (createKeyFromString == null) {
         return null;
      } else {
         Cipher instance = Cipher.getInstance("RSA/ECB/OAEPWITHSHA1ANDMGF1PADDING");
         int length = (bytes.length - 1) / 86 + 1;

         byte[] obj2;
         for(obj2 = new byte[length * 133]; i < length; ++i) {
            instance.init(1, createKeyFromString);
            byte[] doFinal = instance.doFinal(bytes, i * 86, i == length + -1 ? bytes.length - i * 86 : 86);
            System.arraycopy(obj, 0, obj2, i * 133, obj.length);
            System.arraycopy(doFinal, 0, obj2, i * 133 + obj.length, doFinal.length);
         }

         return Base64G.encodeToString(obj2, 10);
      }
   }

   private static PublicKey createKeyFromString(String str, byte[] bArr) throws NoSuchAlgorithmException, InvalidKeySpecException {
      byte[] decode = Base64G.decode((String)str, 0);
      int readInt = readInt(decode, 0);
      byte[] obj = new byte[readInt];
      System.arraycopy(decode, 4, obj, 0, readInt);
      BigInteger bigInteger = new BigInteger(1, obj);
      int readInt2 = readInt(decode, readInt + 4);
      byte[] obj2 = new byte[readInt2];
      System.arraycopy(decode, readInt + 8, obj2, 0, readInt2);
      BigInteger bigInteger2 = new BigInteger(1, obj2);
      decode = MessageDigest.getInstance("SHA-1").digest(decode);
      bArr[0] = 0;
      System.arraycopy(decode, 0, bArr, 1, 4);
      return KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(bigInteger, bigInteger2));
   }

   private static int readInt(byte[] bArr, int i) {
      return (bArr[i] & 255) << 24 | 0 | (bArr[i + 1] & 255) << 16 | (bArr[i + 2] & 255) << 8 | bArr[i + 3] & 255;
   }
}
