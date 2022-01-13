package de.onyxbits.raccoon.finsky;

import de.onyxbits.raccoon.mockup.Device;
import de.onyxbits.raccoon.mockup.MockUtil;
import de.onyxbits.raccoon.proto.AndroidBuildProto;
import de.onyxbits.raccoon.proto.BulkDetailsRequest;
import de.onyxbits.raccoon.proto.ClientLibraryState;
import de.onyxbits.raccoon.proto.DeviceConfigurationProto;
import de.onyxbits.raccoon.proto.EarlyUpdateRequest;
import de.onyxbits.raccoon.proto.LibraryReplicationRequest;
import de.onyxbits.raccoon.proto.ModifyLibraryRequest;
import de.onyxbits.raccoon.proto.ModuleDeliveryRequest;
import de.onyxbits.raccoon.proto.PreFetch;
import de.onyxbits.raccoon.proto.ResponseWrapper;
import de.onyxbits.raccoon.proto.TestingProgramOptRequest;
import de.onyxbits.raccoon.proto.UploadDeviceConfigRequest;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class DfeApi implements DfeHeaders {
   private static final String HOST = "android.clients.google.com";
   private static final URI BASE = URI.create("https://android.clients.google.com/fdfe/");
   private WeakHashMap cache;
   private ClientProvider clientProvider;
   private HeaderProvider headerProvider;

   public DfeApi(HttpClient client, Header... headers) {
      this((ClientProvider)(new DefaultClientProvider(client)), (HeaderProvider)(new DefaultHeaderProvider(headers)));
   }

   public DfeApi(ClientProvider cp, HeaderProvider hp) {
      if (cp != null && hp != null) {
         this.clientProvider = cp;
         this.headerProvider = hp;
         this.cache = new WeakHashMap();
      } else {
         throw new NullPointerException();
      }
   }

   public ResponseWrapper requestSelfUpdate(String configToken) throws HttpResponseException, IOException {
      HttpGet get = new HttpGet(BASE.resolve("selfUpdate"));
      get.setHeader("X-DFE-Device-Config-Token", configToken);
      return this.send(get);
   }

   public ResponseWrapper requestUploadDeviceConfig(Device device, String deviceConfigToken) throws IOException {
      AndroidBuildProto abp = MockUtil.toAndroidBuildProto(device);
      DeviceConfigurationProto dcp = MockUtil.toDeviceConfigurationProto(device);
      UploadDeviceConfigRequest request = UploadDeviceConfigRequest.newBuilder().setManufacturer(abp.getManufacturer()).setDeviceConfiguration(dcp).build();
      HttpPost httpPost = new HttpPost(BASE.resolve("uploadDeviceConfig"));
      httpPost.setEntity(new ByteArrayEntity(request.toByteArray()));
      httpPost.setHeader("X-DFE-Client-Id", "am-android-google");
      httpPost.setHeader(Headers.protobuf());
      if (deviceConfigToken != null) {
         httpPost.setHeader("X-DFE-Device-Config-Token", deviceConfigToken);
      }

      return this.send(httpPost);
   }

   public ResponseWrapper requestToc(String deviceConfigToken) throws IOException, HttpResponseException {
      HttpGet get = new HttpGet(BASE.resolve("toc"));
      get.setHeader("X-DFE-Device-Config-Token", deviceConfigToken);
      return this.send(get);
   }

   public ResponseWrapper requestAcceptTos(String tosToken, String checkinConsistencyToken, Boolean emailOptIn, Boolean unknownOptIn) throws HttpResponseException, IOException {
      List param = new ArrayList();
      param.add(new BasicNameValuePair("tost", tosToken));
      param.add(new BasicNameValuePair("toscme", emailOptIn.toString()));
      param.add(new BasicNameValuePair("tosaia", unknownOptIn.toString()));
      URI u = BASE.resolve("acceptTos?" + URLEncodedUtils.format((List)param, (String)"UTF-8"));
      HttpPost hp = new HttpPost(u);
      hp.setHeader("X-DFE-Device-Checkin-Consistency-Token", checkinConsistencyToken);
      return this.send(hp);
   }

   public ResponseWrapper requestAckNotification(String nid) throws HttpResponseException, IOException {
      List param = new ArrayList();
      param.add(new BasicNameValuePair("nid", nid));
      URI u = BASE.resolve("ack?" + URLEncodedUtils.format((List)param, (String)"UTF-8"));
      HttpGet get = new HttpGet(u);
      return this.send(get);
   }

   public ResponseWrapper requestDetails(String docId) throws HttpResponseException, IOException {
      List param = new ArrayList();
      param.add(new BasicNameValuePair("doc", docId));
      URI u = BASE.resolve("details?" + URLEncodedUtils.format((List)param, (String)"UTF-8"));
      HttpGet get = new HttpGet(u);
      return this.send(get);
   }

   public ResponseWrapper requestMyAccount() throws HttpResponseException, IOException {
      HttpGet get = new HttpGet(BASE.resolve("myAccount"));
      return this.send(get);
   }

   public ResponseWrapper requestUrl(String url) throws HttpResponseException, IOException {
      HttpGet get = new HttpGet(BASE.resolve(url));
      return this.send(get);
   }

   public ResponseWrapper requestPurchaseHistory() throws HttpResponseException, IOException {
      HttpGet get = new HttpGet(BASE.resolve("purchaseHistory"));
      return this.send(get);
   }

   public ResponseWrapper requestBulkDetails(List docIds, boolean includeChildDocs, boolean includeDetails) throws HttpResponseException, IOException {
      ArrayList tmp = new ArrayList(docIds.size());
      Iterator var5 = docIds.iterator();

      while(var5.hasNext()) {
         String docId = (String)var5.next();
         if (!tmp.contains(docId)) {
            tmp.add(docId);
         }
      }

      BulkDetailsRequest bdr = BulkDetailsRequest.newBuilder().addAllDocid(tmp).setIncludeDetails(includeDetails).setIncludeChildDocs(includeChildDocs).build();
      HttpPost httpPost = new HttpPost(BASE.resolve("bulkDetails"));
      httpPost.setHeader(Headers.protobuf());
      httpPost.setEntity(new ByteArrayEntity(bdr.toByteArray()));
      return this.send(httpPost);
   }

   public ResponseWrapper requestSearch(Category cat, String query) throws HttpResponseException, IOException {
      List params = new ArrayList();
      params.add(new BasicNameValuePair("c", "" + cat.ordinal()));
      params.add(new BasicNameValuePair("q", query));
      URI uri = BASE.resolve("search?" + URLEncodedUtils.format((List)params, (String)"UTF-8"));
      HttpGet get = new HttpGet(uri);
      return this.send(get);
   }

   @Experimental
   public ResponseWrapper requestSearchSuggest(String query, int backEndId, int iconSize, boolean requestNavigationSuggestions) throws HttpResponseException, IOException {
      List params = new ArrayList();
      params.add(new BasicNameValuePair("c", Integer.toString(backEndId)));
      params.add(new BasicNameValuePair("q", query));
      params.add(new BasicNameValuePair("sst", "2"));
      if (requestNavigationSuggestions) {
         params.add(new BasicNameValuePair("sst", "3"));
      }

      params.add(new BasicNameValuePair("ssis", Integer.toString(iconSize)));
      URI uri = BASE.resolve("searchSuggest?" + URLEncodedUtils.format((List)params, (String)"UTF-8"));
      HttpGet get = new HttpGet(uri);
      return this.send(get);
   }

   public ResponseWrapper requestReviews(String reviewUrl, SortType st, int rating, int versionCode, boolean device) throws HttpResponseException, IOException {
      List params = new ArrayList();
      params.add(new BasicNameValuePair("sort", "" + st.ordinal()));
      if (rating > 0) {
         params.add(new BasicNameValuePair("rating", "" + rating));
      }

      if (versionCode > 0) {
         params.add(new BasicNameValuePair("vc", "" + versionCode));
      }

      if (device) {
         params.add(new BasicNameValuePair("dfil", "1"));
      }

      URI uri = BASE.resolve(reviewUrl + "&" + URLEncodedUtils.format((List)params, (String)"UTF-8"));
      HttpGet get = new HttpGet(uri);
      return this.send(get);
   }

   public ResponseWrapper requestSetReview(String docId, String title, String content, int rating, boolean ipr) throws HttpResponseException, IOException {
      List params = new ArrayList();
      params.add(new BasicNameValuePair("doc", docId));
      if (title != null) {
         params.add(new BasicNameValuePair("title", title));
      }

      if (content != null) {
         params.add(new BasicNameValuePair("content", content));
      }

      params.add(new BasicNameValuePair("rating", "" + rating));
      params.add(new BasicNameValuePair("ipr", Boolean.toString(ipr)));
      URI u = BASE.resolve("addReview?" + URLEncodedUtils.format((List)params, (String)"UTF-8"));
      HttpPost httpPost = new HttpPost(u);
      return this.send(httpPost);
   }

   public ResponseWrapper requestUnsetReview(String docId) throws HttpResponseException, IOException {
      List params = new ArrayList();
      params.add(new BasicNameValuePair("doc", docId));
      URI u = BASE.resolve("deleteReview?" + URLEncodedUtils.format((List)params, (String)"UTF-8"));
      HttpPost httpPost = new HttpPost(u);
      return this.send(httpPost);
   }

   public ResponseWrapper requestCheckReview(String docId) throws HttpResponseException, IOException {
      List params = new ArrayList();
      params.add(new BasicNameValuePair("doc", docId));
      URI u = BASE.resolve("userReview?" + URLEncodedUtils.format((List)params, (String)"UTF-8"));
      HttpGet get = new HttpGet(u);
      return this.send(get);
   }

   public ResponseWrapper requestPurchaseApp(String docId, int versionCode) throws HttpResponseException, IOException {
      List params = new ArrayList();
      params.add(new BasicNameValuePair("ot", "" + OfferType.PURCHASE.value));
      params.add(new BasicNameValuePair("doc", docId));
      params.add(new BasicNameValuePair("vc", "" + versionCode));
      URI u = BASE.resolve("purchase?" + URLEncodedUtils.format((List)params, (String)"UTF-8"));
      HttpPost httpPost = new HttpPost(u);
      httpPost.setHeader(Headers.urlEnc());
      return this.send(httpPost);
   }

   @Experimental
   public ResponseWrapper requestPurchaseBook(String docId) throws HttpResponseException, IOException {
      List params = new ArrayList();
      params.add(new BasicNameValuePair("ot", "" + OfferType.PURCHASE.value));
      params.add(new BasicNameValuePair("doc", docId));
      URI u = BASE.resolve("purchase?" + URLEncodedUtils.format((List)params, (String)"UTF-8"));
      HttpPost httpPost = new HttpPost(u);
      httpPost.setHeader(Headers.urlEnc());
      return this.send(httpPost);
   }

   public ResponseWrapper requestDeliverApp(String docId, int versionCode) throws HttpResponseException, IOException {
      List params = new ArrayList();
      params.add(new BasicNameValuePair("ot", "" + OfferType.PURCHASE.value));
      params.add(new BasicNameValuePair("vc", "" + versionCode));
      params.add(new BasicNameValuePair("doc", docId));
      URI u = BASE.resolve("delivery?" + URLEncodedUtils.format((List)params, (String)"UTF-8"));
      HttpGet get = new HttpGet(u);
      return this.send(get);
   }

   @Experimental
   public ResponseWrapper requestEarlyDeliverApp(String docId, int versionCode) throws HttpResponseException, IOException {
      List params = new ArrayList();
      params.add(new BasicNameValuePair("ot", "" + OfferType.PURCHASE.value));
      params.add(new BasicNameValuePair("vc", "" + versionCode));
      params.add(new BasicNameValuePair("doc", docId));
      URI u = BASE.resolve("earlyDelivery?" + URLEncodedUtils.format((List)params, (String)"UTF-8"));
      HttpGet get = new HttpGet(u);
      return this.send(get);
   }

   @Experimental
   public ResponseWrapper requestEarlyUpdate(Device device) throws HttpResponseException, IOException {
      DeviceConfigurationProto dcp = MockUtil.toDeviceConfigurationProto(device);
      EarlyUpdateRequest req = EarlyUpdateRequest.newBuilder().setDeviceConfiguration(dcp).build();
      HttpPost httpPost = new HttpPost(BASE.resolve("earlyUpdate"));
      httpPost.setEntity(new ByteArrayEntity(req.toByteArray()));
      httpPost.setHeader("X-DFE-Client-Id", "am-android-google");
      httpPost.setHeader(Headers.protobuf());
      return this.send(httpPost);
   }

   public ResponseWrapper requestDeliverPatch(String docId, int fromVersion, int toVersion, PatchFormat pf) throws HttpResponseException, IOException {
      List params = new ArrayList();
      params.add(new BasicNameValuePair("ot", "" + OfferType.PURCHASE.value));
      params.add(new BasicNameValuePair("vc", "" + toVersion));
      params.add(new BasicNameValuePair("bvc", "" + fromVersion));
      params.add(new BasicNameValuePair("pf", pf.value + ""));
      params.add(new BasicNameValuePair("doc", docId));
      URI u = BASE.resolve("delivery?" + URLEncodedUtils.format((List)params, (String)"UTF-8"));
      HttpGet get = new HttpGet(u);
      return this.send(get);
   }

   public ResponseWrapper requestDeliverSelfUpdate(int versionCode, String certificateHashSelfUpdateMD5, String certificateHash) throws HttpResponseException, IOException {
      List params = new ArrayList();
      params.add(new BasicNameValuePair("ot", "" + OfferType.PURCHASE.ordinal()));
      params.add(new BasicNameValuePair("vc", "" + versionCode));
      params.add(new BasicNameValuePair("doc", "com.android.vending"));
      if (certificateHashSelfUpdateMD5 == null) {
         params.add(new BasicNameValuePair("shh", "signature-hash-NameNotFoundException"));
      } else {
         params.add(new BasicNameValuePair("shh", certificateHashSelfUpdateMD5));
      }

      if (certificateHash == null) {
         params.add(new BasicNameValuePair("ch", "certificate-hash-NameNotFoundException"));
      } else {
         params.add(new BasicNameValuePair("ch", certificateHash));
      }

      URI u = BASE.resolve("delivery?" + URLEncodedUtils.format((List)params, (String)"UTF-8"));
      HttpGet get = new HttpGet(u);
      return this.send(get);
   }

   @Experimental
   public ResponseWrapper requestSyncAccount() throws HttpResponseException, IOException {
      URI u = BASE.resolve("accountSync");
      HttpPost httpPost = new HttpPost(u);
      return this.send(httpPost);
   }

   @Experimental
   public ResponseWrapper requestCheckLicense(String packageName, int versionCode, long nnc) throws HttpResponseException, IOException {
      List params = new ArrayList();
      params.add(new BasicNameValuePair("pkgn", packageName));
      params.add(new BasicNameValuePair("vc", "" + versionCode));
      params.add(new BasicNameValuePair("nnc", "" + nnc));
      URI u = BASE.resolve("apps/checkLicense?" + URLEncodedUtils.format((List)params, (String)"UTF-8"));
      HttpGet get = new HttpGet(u);
      return this.send(get);
   }

   @Experimental
   public ResponseWrapper requestRichUserNotification() throws HttpResponseException, IOException {
      URI u = BASE.resolve("richUserNotification");
      HttpPost httpPost = new HttpPost(u);
      return this.send(httpPost);
   }

   @Experimental
   public ResponseWrapper requestLauncherSearchSuggest() throws HttpResponseException, IOException {
      URI u = BASE.resolve("apps/launcherSearchSuggest");
      HttpGet get = new HttpGet(u);
      return this.send(get);
   }

   public ResponseWrapper requestContactEmail() throws HttpResponseException, IOException {
      HttpGet get = new HttpGet(BASE.resolve("contactEmail"));
      return this.send(get);
   }

   public ResponseWrapper requestListBetaPrograms() throws IOException {
      return this.requestLibrary("u-tpl", Category.ANDROID_APPS.ordinal(), 1, (byte[])null);
   }

   public ResponseWrapper requestJoinBetaTest(String docId) throws HttpResponseException, IOException {
      TestingProgramOptRequest req = TestingProgramOptRequest.newBuilder().setPackageName(docId).setSubscribe(true).build();
      HttpPost httpPost = new HttpPost(BASE.resolve("apps/testingProgram"));
      httpPost.setEntity(new ByteArrayEntity(req.toByteArray()));
      httpPost.setHeader(Headers.protobuf());
      return this.send(httpPost);
   }

   public ResponseWrapper requestLeaveBetaTest(String docId) throws HttpResponseException, IOException {
      TestingProgramOptRequest req = TestingProgramOptRequest.newBuilder().setPackageName(docId).setSubscribe(false).build();
      HttpPost httpPost = new HttpPost(BASE.resolve("apps/testingProgram"));
      httpPost.setEntity(new ByteArrayEntity(req.toByteArray()));
      httpPost.setHeader(Headers.protobuf());
      return this.send(httpPost);
   }

   @Experimental
   public ResponseWrapper requestDeviceSettings(String docId, OfferType ot) throws HttpResponseException, IOException {
      List params = new ArrayList();
      params.add(new BasicNameValuePair("docId", docId));
      params.add(new BasicNameValuePair("ot", "" + ot.value));
      URI u = BASE.resolve("deviceSettings?" + URLEncodedUtils.format((List)params, (String)"UTF-8"));
      HttpGet get = new HttpGet(u);
      return this.send(get);
   }

   @Experimental
   public ResponseWrapper requestResolveWebApk(String docId, String wamToken) throws HttpResponseException, IOException {
      List params = new ArrayList();
      params.add(new BasicNameValuePair("doc", docId));
      params.add(new BasicNameValuePair("wamToken", wamToken));
      URI u = BASE.resolve("resolveWebApk?" + URLEncodedUtils.format((List)params, (String)"UTF-8"));
      HttpGet get = new HttpGet(u);
      return this.send(get);
   }

   @Experimental
   public ResponseWrapper requestDebugSettingsCountryOverride(String countryOverride) throws HttpResponseException, IOException {
      List params = new ArrayList();
      if (countryOverride != null) {
         params.add(new BasicNameValuePair("playCountryOverride", countryOverride));
      }

      URI u = BASE.resolve("debugSettings?" + URLEncodedUtils.format((List)params, (String)"UTF-8"));
      HttpGet get = new HttpGet(u);
      return this.send(get);
   }

   @Experimental
   public ResponseWrapper requestPreloads(String docId, Device dev) throws HttpResponseException, IOException {
      List params = new ArrayList();
      params.add(new BasicNameValuePair("doc", docId));
      if (dev != null) {
         AndroidBuildProto abp = MockUtil.toAndroidBuildProto(dev);
         params.add(new BasicNameValuePair("build_fingerprint", abp.getId()));
      }

      URI u = BASE.resolve("preloads?" + URLEncodedUtils.format((List)params, (String)"UTF-8"));
      HttpGet get = new HttpGet(u);
      return this.send(get);
   }

   public ResponseWrapper requestAddToLibrary(String libId, List docId) throws HttpResponseException, IOException {
      ModifyLibraryRequest request = ModifyLibraryRequest.newBuilder().addAllAddDocId(docId).setLibraryId(libId).build();
      HttpPost httpPost = new HttpPost(BASE.resolve("modifyLibrary"));
      httpPost.setEntity(new ByteArrayEntity(request.toByteArray()));
      httpPost.setHeader(Headers.protobuf());
      return this.send(httpPost);
   }

   public ResponseWrapper requestRemoveFromLibrary(String libId, List docId) throws HttpResponseException, IOException {
      ModifyLibraryRequest request = ModifyLibraryRequest.newBuilder().addAllRemovalDocId(docId).setLibraryId(libId).build();
      HttpPost httpPost = new HttpPost(BASE.resolve("modifyLibrary"));
      httpPost.setEntity(new ByteArrayEntity(request.toByteArray()));
      httpPost.setHeader(Headers.protobuf());
      return this.send(httpPost);
   }

   public ResponseWrapper requestReplicateLibrary(String libraryId, int version, byte[] serverToken) throws HttpResponseException, IOException {
      ClientLibraryState cls = ClientLibraryState.newBuilder().setLibraryId(libraryId).setCorpus(3).build();
      LibraryReplicationRequest request = LibraryReplicationRequest.newBuilder().addLibraryState(cls).setLibraryMutationVersion(version).build();
      HttpPost httpPost = new HttpPost(BASE.resolve("replicateLibrary"));
      httpPost.setEntity(new ByteArrayEntity(request.toByteArray()));
      httpPost.setHeader(Headers.protobuf());
      return this.send(httpPost);
   }

   public ResponseWrapper requestLibrary(String libraryId, int category, int docType, byte[] serverToken) throws IOException {
      List params = new ArrayList();
      params.add(new BasicNameValuePair("c", category + ""));
      params.add(new BasicNameValuePair("libid", libraryId));
      params.add(new BasicNameValuePair("dt", docType + ""));
      if (serverToken != null) {
         params.add(new BasicNameValuePair("st", Base64G.encodeToString(serverToken, 0)));
      }

      URI u = BASE.resolve("library?" + URLEncodedUtils.format((List)params, (String)"UTF-8"));
      HttpGet get = new HttpGet(u);
      return this.send(get);
   }

   public ResponseWrapper requestMyApps() throws IOException {
      return this.requestLibrary("3", Category.ANDROID_APPS.ordinal(), 1, (byte[])null);
   }

   @Experimental
   public ResponseWrapper requestMyWishlist() throws IOException {
      return this.requestLibrary("u-wl", Category.UNKNOWN.ordinal(), 7, (byte[])null);
   }

   public ResponseWrapper requestContentFilterSettings(boolean at) throws IOException {
      URI u = BASE.resolve("contentFilterSettings");
      if (at) {
         u = BASE.resolve("contentFilterSettings?at=true");
      }

      HttpGet get = new HttpGet(u);
      return this.send(get);
   }

   @Experimental
   public ResponseWrapper requestSaveContentFilterSettings(String deviceConfigToken, String tocCookie, String checkingConsistencyToken) throws IOException {
      URI u = BASE.resolve("contentFilterSettings");
      HttpPost httpPost = new HttpPost(u);
      httpPost.setHeader(Headers.urlEnc());
      httpPost.setHeader("X-DFE-Content-Filters", "");
      httpPost.setHeader("X-DFE-Filter-Level", "-1");
      httpPost.setHeader("X-DFE-Device-Checkin-Consistency-Token", checkingConsistencyToken);
      return this.send(httpPost);
   }

   @Experimental
   public ResponseWrapper requestCheckInstrument() throws IOException {
      URI u = BASE.resolve("checkInstrument");
      HttpPost httpPost = new HttpPost(u);
      return this.send(httpPost);
   }

   @Experimental
   public ResponseWrapper requestUserSettings(int ddt) throws IOException, HttpResponseException {
      HttpGet get = new HttpGet(BASE.resolve("userSettings"));
      return this.send(get);
   }

   @Experimental
   public ResponseWrapper requestBackupDeviceChoices(String deviceCheckinConsistencyToken) throws IOException, HttpResponseException {
      URI u = BASE.resolve("getBackupDeviceChoices");
      HttpGet httpGet = new HttpGet(u);
      httpGet.addHeader(Headers.checkinConsistency(deviceCheckinConsistencyToken));
      return this.send(httpGet);
   }

   public DfeApi clearCache() {
      this.cache.clear();
      return this;
   }

   @Experimental
   public ResponseWrapper requestDeliverModule(String doc, int vc, List modules) throws IOException, HttpResponseException {
      List params = new ArrayList();
      params.add(new BasicNameValuePair("doc", doc));
      URI u = BASE.resolve("moduleDelivery?" + URLEncodedUtils.format((List)params, (String)"UTF-8"));
      ModuleDeliveryRequest.Builder builder = ModuleDeliveryRequest.newBuilder().setPackageName(doc).setVersionCode(125800).addCompressionFormat(ModuleDeliveryRequest.CompressionFormat.GZIP);
      ModuleDeliveryRequest mdr = builder.build();
      System.err.println(mdr);
      HttpPost post = new HttpPost(u);
      post.setHeader(Headers.protobuf());
      post.setEntity(new ByteArrayEntity(mdr.toByteArray()));
      return this.send(post);
   }

   private ResponseWrapper send(HttpUriRequest hur) throws HttpResponseException, IOException {
      CacheEntry cached = (CacheEntry)this.cache.get(hur.getURI());
      long now = System.currentTimeMillis();
      if (cached != null) {
         if (now < cached.ttl) {
            return cached.content;
         }

         this.cache.remove(hur.getURI());
      }

      hur.addHeader(Headers.host("android.clients.google.com"));
      this.applyHeader(hur, "Accept-Language");
      this.applyHeader(hur, "Authorization");
      this.applyHeader(hur, "User-Agent");
      this.applyHeader(hur, "X-DFE-No-Prefetch");
      this.applyHeader(hur, "X-DFE-Device-Id");
      this.applyHeader(hur, "X-DFE-MCCMNC");
      HttpResponse response = this.clientProvider.getClient().execute(hur);
      HttpEntity entity = response.getEntity();
      String reasonPhrase = response.getStatusLine().getReasonPhrase();
      int statusCode = response.getStatusLine().getStatusCode();
      ResponseWrapper ret;
      switch(statusCode) {
      case 200:
         ret = this.unpack(entity);
         if (hur instanceof HttpGet) {
            CacheEntry ce = new CacheEntry();
            ce.content = ret;
            ce.softTtl = now + this.parse("X-DFE-Soft-TTL", response);
            ce.ttl = now + this.parse("X-DFE-HARD-TTL", response);
            this.cache.put(hur.getURI(), ce);
         }

         Iterator var14 = ret.getPreFetchList().iterator();

         while(var14.hasNext()) {
            PreFetch preFetch = (PreFetch)var14.next();
            CacheEntry ce = new CacheEntry();
            ce.content = ResponseWrapper.parseFrom(preFetch.getResponse());
            ce.ttl = preFetch.getTtl() + now;
            ce.softTtl = preFetch.getSoftTtl() + now;
            String uri = preFetch.getUrl();
            if (preFetch.getPreFetchData().getPreFetchUri().hasUri()) {
               uri = preFetch.getPreFetchData().getPreFetchUri().getUri();
            }

            if (uri != null && ce.content != null) {
               this.cache.put(BASE.resolve(uri), ce);
            }
         }

         return ret;
      case 400:
      case 401:
      case 402:
      case 403:
      case 404:
      case 500:
         ret = this.unpack(entity);
         if (ret.hasCommands() && ret.getCommands().hasDisplayErrorMessage()) {
            reasonPhrase = ret.getCommands().getDisplayErrorMessage();
         }

         throw new DisplayErrorMessageException(statusCode, reasonPhrase);
      default:
         EntityUtils.consumeQuietly(entity);
         throw new HttpResponseException(statusCode, reasonPhrase);
      }
   }

   private void applyHeader(HttpUriRequest hur, String name) {
      Header h = this.headerProvider.headerFor(name);
      if (h != null) {
         hur.setHeader(h);
      }

   }

   private long parse(String header, HttpResponse response) {
      try {
         Header h = response.getFirstHeader(header);
         return Long.parseLong(h.getValue());
      } catch (Exception var4) {
         return 0L;
      }
   }

   private ResponseWrapper unpack(HttpEntity entity) throws UnsupportedOperationException, IOException {
      ResponseWrapper rw = ResponseWrapper.parseFrom(entity.getContent());
      EntityUtils.consumeQuietly(entity);
      return rw;
   }
}
