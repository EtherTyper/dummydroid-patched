package de.onyxbits.raccoon.finsky;

public interface DfeHeaders {
   String SIGNATURE_REQUEST = "X-DFE-Signature-Request";
   String REQUEST_PARAMS = "X-DFE-Request-Params";
   String DEVICE_ID = "X-DFE-Device-Id";
   String MCCMNC = "X-DFE-MCCMNC";
   String CLIENT_ID = "X-DFE-Client-Id";
   String LOGGING_ID = "X-DFE-Logging-Id";
   String NETWORK_TYPE = "X-DFE-Network-Type";
   String USER_CONTEXT = "X-DFE-User-Context";
   String HARDWARE_ID = "X-DFE-Hardware-Id";
   String NO_PREFETCH = "X-DFE-No-Prefetch";
   String CLIENT_HAS_VOUCHER = "X-DFE-Client-Has-Vouchers";
   String VOUCHERS_BACKEND_DOCIDS_CSV = "X-DFE-Vouchers-Backend-Docids-CSV";
   String DEVICE_CONFIG_TOKEN = "X-DFE-Device-Config-Token";
   String FILTER_LEVEL = "X-DFE-Filter-Level";
   String CONTENT_FILTERS = "X-DFE-Content-Filters";
   String SUPPORTED_TARGETS = "X-DFE-Supported-Targets";
   String SIGNATURE_PARAMS = "X-DFE-Request-Params";
   String SERVER_COOKIES = "X-DFE-Server-Cookies";
   String MANAGED_CONTEXT = "X-DFE-Managed-Context";
   String DEVICE_CHECKIN_CONSISTENCY_TOKEN = "X-DFE-Device-Checkin-Consistency-Token";
   String FAMILY_CONSISTENCY_TOKEN = "X-DFE-Family-Consistency-Token";
   String PROXY_DEVICE_CHECKING_CONSISTENCY_TOKEN = "X-DFE-Proxy-Device-Checkin-Consistency-Token";
   String COOKIE = "X-DFE-Cookie";
   String PUBLIC_ANDROID_ID = "X-Public-Android-Id";
   String AD_ID = "X-Ad-Id";
   String SOFT_TTL = "X-DFE-Soft-TTL";
   String HARD_TTL = "X-DFE-HARD-TTL";
}
