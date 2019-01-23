package com.workerthread.retrofit_networkutils;

import javax.net.ssl.HttpsURLConnection;

public class ZencodeErrorCodes {
        public static final String HTTP_ACCEPTED = "Accepted";


        public static final String HTTP_BAD_GATEWAY = "502-Bad Gateway";


        public static final String HTTP_BAD_METHOD = "405-Bad Method";


        public static final String HTTP_BAD_REQUEST = "400: Bad Request";


        public static final String HTTP_CLIENT_TIMEOUT = "408: Client Timeout";


        public static final String HTTP_CONFLICT = "409: Conflict";


        public static final String HTTP_CREATED = "201: Created";


        public static final String HTTP_ENTITY_TOO_LARGE = "413: Entity too large";


        public static final String HTTP_FORBIDDEN = "403: Forbidden";


        public static final String HTTP_GATEWAY_TIMEOUT = "504: Gateway timeout";


        public static final String HTTP_GONE = "410: Gone";


        public static final String HTTP_INTERNAL_ERROR = "500: Internal error";


        public static final String HTTP_LENGTH_REQUIRED = "411: Length required";


        public static final String HTTP_MOVED_PERM = "301 Moved permanently";


        public static final String HTTP_MOVED_TEMP = "302: Moved temporarily";


        public static final String HTTP_MULT_CHOICE = "300: Multiple choices";


        public static final String HTTP_NO_CONTENT = "204: No content";


        public static final String HTTP_NOT_ACCEPTABLE = "406: Not acceptable";


        public static final String HTTP_NOT_AUTHORITATIVE = "203: Not authoritative";


        public static final String HTTP_NOT_FOUND = "404: Not found";


        public static final String HTTP_NOT_IMPLEMENTED = "501: Not implemented";


        public static final String HTTP_NOT_MODIFIED = "304: Not modified";


        public static final String HTTP_OK = "200: OK";


        public static final String HTTP_PARTIAL = "206: Partial";


        public static final String HTTP_PAYMENT_REQUIRED = "402: Payment required";


        public static final String HTTP_PRECON_FAILED = "412: Precondition failed";


        public static final String HTTP_PROXY_AUTH = "407: Proxy authentication required";


        public static final String HTTP_REQ_TOO_LONG = "414: Request too long";


        public static final String HTTP_RESET = "205: Reset";


        public static final String HTTP_SEE_OTHER = "303: See other";

        public static final String HTTP_USE_PROXY = "305: Use proxy";


        public static final String HTTP_UNAUTHORIZED = "401: Unauthorized";


        public static final String HTTP_UNSUPPORTED_TYPE = "415: Unsupported type";


        public static final String HTTP_UNAVAILABLE = "503: Unavailable";


        public static final String HTTP_VERSION = "505: Version not supported";

    public static String getErrorMessage(int responseCode) {
        switch (responseCode) {
            case HttpsURLConnection.HTTP_ACCEPTED:
                return ZencodeErrorCodes.HTTP_ACCEPTED;
            case HttpsURLConnection.HTTP_BAD_GATEWAY:
                return ZencodeErrorCodes.HTTP_BAD_GATEWAY;
            case HttpsURLConnection.HTTP_BAD_METHOD:
                return ZencodeErrorCodes.HTTP_BAD_METHOD;
            case HttpsURLConnection.HTTP_BAD_REQUEST:
                return ZencodeErrorCodes.HTTP_BAD_REQUEST;
            case HttpsURLConnection.HTTP_CLIENT_TIMEOUT:
                return ZencodeErrorCodes.HTTP_CLIENT_TIMEOUT;
            case HttpsURLConnection.HTTP_CONFLICT:
                return ZencodeErrorCodes.HTTP_CONFLICT;
            case HttpsURLConnection.HTTP_CREATED:
                return ZencodeErrorCodes.HTTP_CREATED;
            case HttpsURLConnection.HTTP_ENTITY_TOO_LARGE:
                return ZencodeErrorCodes.HTTP_ENTITY_TOO_LARGE;
            case HttpsURLConnection.HTTP_FORBIDDEN:
                return ZencodeErrorCodes.HTTP_FORBIDDEN;
            case HttpsURLConnection.HTTP_GATEWAY_TIMEOUT:
                return ZencodeErrorCodes.HTTP_GATEWAY_TIMEOUT;
            case HttpsURLConnection.HTTP_VERSION:
                return ZencodeErrorCodes.HTTP_VERSION;
            case HttpsURLConnection.HTTP_USE_PROXY:
                return ZencodeErrorCodes.HTTP_USE_PROXY;
            case HttpsURLConnection.HTTP_GONE:
                return ZencodeErrorCodes.HTTP_GONE;
            case HttpsURLConnection.HTTP_INTERNAL_ERROR:
                return ZencodeErrorCodes.HTTP_INTERNAL_ERROR;
            case HttpsURLConnection.HTTP_LENGTH_REQUIRED:
                return ZencodeErrorCodes.HTTP_LENGTH_REQUIRED;
            case HttpsURLConnection.HTTP_MOVED_PERM:
                return ZencodeErrorCodes.HTTP_MOVED_PERM;
            case HttpsURLConnection.HTTP_MOVED_TEMP:
                return ZencodeErrorCodes.HTTP_MOVED_TEMP;
            case HttpsURLConnection.HTTP_NO_CONTENT:
                return ZencodeErrorCodes.HTTP_NO_CONTENT;
            case HttpsURLConnection.HTTP_NOT_ACCEPTABLE:
                return ZencodeErrorCodes.HTTP_NOT_ACCEPTABLE;
            case HttpsURLConnection.HTTP_NOT_AUTHORITATIVE:
                return ZencodeErrorCodes.HTTP_NOT_AUTHORITATIVE;
            case HttpsURLConnection.HTTP_NOT_FOUND:
                return ZencodeErrorCodes.HTTP_NOT_FOUND;
            case HttpsURLConnection.HTTP_NOT_IMPLEMENTED:
                return ZencodeErrorCodes.HTTP_NOT_IMPLEMENTED;
            case HttpsURLConnection.HTTP_NOT_MODIFIED:
                return ZencodeErrorCodes.HTTP_NOT_MODIFIED;
            case HttpsURLConnection.HTTP_MULT_CHOICE:
                return ZencodeErrorCodes.HTTP_MULT_CHOICE;
            case HttpsURLConnection.HTTP_PARTIAL:
                return ZencodeErrorCodes.HTTP_PARTIAL;
            case HttpsURLConnection.HTTP_PAYMENT_REQUIRED:
                return ZencodeErrorCodes.HTTP_PAYMENT_REQUIRED;
            case HttpsURLConnection.HTTP_PRECON_FAILED:
                return ZencodeErrorCodes.HTTP_PRECON_FAILED;
            case HttpsURLConnection.HTTP_PROXY_AUTH:
                return ZencodeErrorCodes.HTTP_PROXY_AUTH;
            case HttpsURLConnection.HTTP_REQ_TOO_LONG:
                return ZencodeErrorCodes.HTTP_REQ_TOO_LONG;
            case HttpsURLConnection.HTTP_RESET:
                return ZencodeErrorCodes.HTTP_RESET;
            case HttpsURLConnection.HTTP_SEE_OTHER:
                return ZencodeErrorCodes.HTTP_SEE_OTHER;
            case HttpsURLConnection.HTTP_UNAUTHORIZED:
                return ZencodeErrorCodes.HTTP_UNAUTHORIZED;
            case HttpsURLConnection.HTTP_UNAVAILABLE:
                return ZencodeErrorCodes.HTTP_UNAVAILABLE;
            case HttpsURLConnection.HTTP_UNSUPPORTED_TYPE:
                return ZencodeErrorCodes.HTTP_UNSUPPORTED_TYPE;
            default:
                return null;
        }
    }
}
