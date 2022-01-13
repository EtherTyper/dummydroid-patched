package de.onyxbits.raccoon.finsky;

import de.onyxbits.raccoon.mockup.Device;
import de.onyxbits.raccoon.mockup.MockUtil;
import de.onyxbits.raccoon.proto.AndroidBuildProto;
import de.onyxbits.raccoon.proto.AndroidCheckinProto;
import de.onyxbits.raccoon.proto.AndroidCheckinRequest;
import de.onyxbits.raccoon.proto.AndroidCheckinResponse;
import de.onyxbits.raccoon.proto.DeviceConfigurationProto;
import java.io.IOException;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.util.EntityUtils;

public class CheckinApi {
   public static final int SETTLE = 2000;
   private static final String HOST = "android.clients.google.com";
   private static final String CHECKIN_URL = "https://android.clients.google.com/checkin";
   private ClientProvider clientProvider;
   private String simOperator;
   private String cellOperator;
   private HeaderProvider headerProvider;

   public CheckinApi(HttpClient client, Header... headers) {
      this((ClientProvider)(new DefaultClientProvider(client)), (HeaderProvider)(new DefaultHeaderProvider(headers)));
   }

   public CheckinApi(ClientProvider cp, HeaderProvider hp) {
      if (cp != null && hp != null) {
         this.clientProvider = cp;
         this.headerProvider = hp;
      } else {
         throw new NullPointerException();
      }
   }

   public CheckinApi withSimOperator(String mccmnc) {
      this.simOperator = mccmnc;
      return this;
   }

   public CheckinApi withCellOperator(String mccmnc) {
      this.cellOperator = mccmnc;
      return this;
   }

   private AndroidCheckinProto checkin(Device device, long lastCheckin) {
      AndroidBuildProto abp = MockUtil.toAndroidBuildProto(device);
      AndroidCheckinProto.Builder builder = AndroidCheckinProto.newBuilder().setBuild(abp);
      if (this.simOperator != null) {
         builder.setSimOperator(this.simOperator);
      }

      if (this.cellOperator != null) {
         builder.setCellOperator(this.cellOperator);
      }

      if (lastCheckin > -1L) {
         builder.setLastCheckinMsec(lastCheckin);
      }

      return builder.build();
   }

   public AndroidCheckinResponse requestId(Locale locale, TimeZone timezone, Device device) throws IOException {
      DeviceConfigurationProto dcp = MockUtil.toDeviceConfigurationProto(device);
      AndroidCheckinRequest request = AndroidCheckinRequest.newBuilder().setId(0L).setLocale(locale.toString()).setTimeZone(timezone.getID()).setVersion(3).setFragment(0).setDeviceConfiguration(dcp).setCheckin(this.checkin(device, -1L)).build();
      return this.send(request.toByteArray());
   }

   public AndroidCheckinResponse requestBindId(Locale locale, TimeZone timezone, Device device, String uid, String auth, long gsfId, long securityToken) throws IOException {
      DeviceConfigurationProto dcp = MockUtil.toDeviceConfigurationProto(device);
      AndroidCheckinRequest request = AndroidCheckinRequest.newBuilder().setId(gsfId).setLocale(locale.toString()).setTimeZone(timezone.getID()).setVersion(3).setSecurityToken(securityToken).setFragment(0).addAccountCookie("[" + uid + "]").addAccountCookie(auth).setDeviceConfiguration(dcp).setCheckin(this.checkin(device, -1L)).build();
      return this.send(request.toByteArray());
   }

   public AndroidCheckinResponse requestCheckin(Locale locale, TimeZone timezone, Device device, long gsfId, long securityToken, long lastCheckin) throws IOException {
      DeviceConfigurationProto dcp = MockUtil.toDeviceConfigurationProto(device);
      AndroidCheckinRequest request = AndroidCheckinRequest.newBuilder().setId(gsfId).setSecurityToken(securityToken).setLocale(locale.toString()).setTimeZone(timezone.getID()).setVersion(3).setDeviceConfiguration(dcp).setCheckin(this.checkin(device, lastCheckin)).build();
      return this.send(request.toByteArray());
   }

   private AndroidCheckinResponse send(byte[] data) throws ClientProtocolException, IOException {
      HttpPost httppost = new HttpPost("https://android.clients.google.com/checkin");
      httppost.setEntity(new ByteArrayEntity(data));
      httppost.addHeader(Headers.host("android.clients.google.com"));
      httppost.addHeader(Headers.protobuf());
      Header agent = this.headerProvider.headerFor("User-Agent");
      if (agent != null) {
         httppost.addHeader(agent);
      }

      HttpResponse response = this.clientProvider.getClient().execute(httppost);
      StatusLine sl = response.getStatusLine();
      HttpEntity entity = response.getEntity();
      switch(sl.getStatusCode()) {
      case 200:
         AndroidCheckinResponse ret = AndroidCheckinResponse.parseFrom(entity.getContent());
         EntityUtils.consumeQuietly(entity);
         return ret;
      default:
         EntityUtils.consumeQuietly(entity);
         throw new HttpResponseException(sl.getStatusCode(), sl.getReasonPhrase());
      }
   }
}
