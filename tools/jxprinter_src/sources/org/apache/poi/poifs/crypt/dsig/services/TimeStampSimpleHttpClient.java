package org.apache.poi.poifs.crypt.dsig.services;

import androidx.browser.trusted.sharing.ShareTarget;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import l5.g2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.poifs.crypt.dsig.SignatureConfig;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.RandomSingleton;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class TimeStampSimpleHttpClient implements TimeStampHttpClient {
    protected static final String BASIC_AUTH = "Authorization";
    protected static final String CONTENT_TYPE = "Content-Type";
    private static final int DEFAULT_TIMESTAMP_RESPONSE_SIZE = 10000000;
    private static final Logger LOG = LogManager.getLogger((Class<?>) TimeStampSimpleHttpClient.class);
    private static int MAX_TIMESTAMP_RESPONSE_SIZE = 10000000;
    protected static final String REDIRECT_LOCATION = "Location";
    protected static final String USER_AGENT = "User-Agent";
    protected SignatureConfig config;
    protected Proxy proxy = Proxy.NO_PROXY;
    protected final Map<String, String> header = new HashMap();
    protected String contentTypeOut = null;
    protected boolean ignoreHttpsCertificates = false;
    protected boolean followRedirects = false;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface MethodHandler {
        void handle(HttpURLConnection httpURLConnection);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class TimeStampSimpleHttpClientResponse implements TimeStampHttpClient.TimeStampHttpClientResponse {
        private final byte[] responseBytes;
        private final int responseCode;

        public TimeStampSimpleHttpClientResponse(int i5, byte[] bArr) {
            this.responseCode = i5;
            this.responseBytes = bArr;
        }

        @Override // org.apache.poi.poifs.crypt.dsig.services.TimeStampHttpClient.TimeStampHttpClientResponse
        public byte[] getResponseBytes() {
            return this.responseBytes;
        }

        @Override // org.apache.poi.poifs.crypt.dsig.services.TimeStampHttpClient.TimeStampHttpClientResponse
        public int getResponseCode() {
            return this.responseCode;
        }
    }

    public static int getMaxTimestampResponseSize() {
        return MAX_TIMESTAMP_RESPONSE_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$post$0(byte[] bArr, HttpURLConnection httpURLConnection) throws IOException {
        httpURLConnection.setRequestMethod(ShareTarget.METHOD_POST);
        httpURLConnection.setDoOutput(true);
        OutputStream outputStream = httpURLConnection.getOutputStream();
        try {
            outputStream.write(bArr);
            outputStream.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$recklessConnection$2(String str, SSLSession sSLSession) {
        return true;
    }

    public static void setMaxTimestampResponseSize(int i5) {
        MAX_TIMESTAMP_RESPONSE_SIZE = i5;
    }

    @Override // org.apache.poi.poifs.crypt.dsig.services.TimeStampHttpClient
    public TimeStampHttpClient.TimeStampHttpClientResponse get(String str) {
        return handleRedirect(str, new F4.e(28), isFollowRedirects());
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public TimeStampHttpClient.TimeStampHttpClientResponse handleRedirect(String str, MethodHandler methodHandler, boolean z6) throws IOException {
        byte[] bArr;
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection(this.proxy);
        if (this.ignoreHttpsCertificates) {
            recklessConnection(httpURLConnection);
        }
        httpURLConnection.setConnectTimeout(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
        httpURLConnection.setReadTimeout(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
        this.header.forEach(new g2(httpURLConnection, 3));
        try {
            methodHandler.handle(httpURLConnection);
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 200) {
                switch (responseCode) {
                    case 301:
                    case 302:
                    case 303:
                        String headerField = httpURLConnection.getHeaderField("Location");
                        if (headerField != null && z6) {
                            LOG.atWarn().log("Received redirect: {} -> {}", str, headerField);
                            TimeStampHttpClient.TimeStampHttpClientResponse timeStampHttpClientResponseHandleRedirect = handleRedirect(headerField, methodHandler, false);
                            httpURLConnection.disconnect();
                            return timeStampHttpClientResponseHandleRedirect;
                        }
                        LOG.atWarn().log("Redirect ignored - giving up: {} -> {}", str, headerField);
                        bArr = null;
                        break;
                        break;
                    default:
                        String str2 = "Error contacting TSP server " + str + ", had status code " + responseCode + PackagingURIHelper.FORWARD_SLASH_STRING + httpURLConnection.getResponseMessage();
                        LOG.atError().log(str2);
                        throw new IOException(str2);
                }
            } else {
                String headerField2 = httpURLConnection.getHeaderField("Content-Type");
                String str3 = this.contentTypeOut;
                if (str3 != null && !str3.equals(headerField2)) {
                    throw new IOException("Content-Type mismatch - expected `" + this.contentTypeOut + "', received '" + headerField2 + "'");
                }
                InputStream inputStream = httpURLConnection.getInputStream();
                try {
                    byte[] byteArrayWithMaxLength = IOUtils.toByteArrayWithMaxLength(inputStream, getMaxTimestampResponseSize());
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    bArr = byteArrayWithMaxLength;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                        }
                        throw th2;
                    }
                }
            }
            TimeStampSimpleHttpClientResponse timeStampSimpleHttpClientResponse = new TimeStampSimpleHttpClientResponse(responseCode, bArr);
            httpURLConnection.disconnect();
            return timeStampSimpleHttpClientResponse;
        } catch (Throwable th4) {
            httpURLConnection.disconnect();
            throw th4;
        }
    }

    @Override // org.apache.poi.poifs.crypt.dsig.services.TimeStampHttpClient
    public void init(SignatureConfig signatureConfig) {
        this.config = signatureConfig;
        this.header.clear();
        this.header.put("User-Agent", signatureConfig.getUserAgent());
        this.contentTypeOut = null;
        setProxy(signatureConfig.getProxyUrl());
        setBasicAuthentication(signatureConfig.getTspUser(), signatureConfig.getTspPass());
    }

    @Override // org.apache.poi.poifs.crypt.dsig.services.TimeStampHttpClient
    public boolean isFollowRedirects() {
        return this.followRedirects;
    }

    @Override // org.apache.poi.poifs.crypt.dsig.services.TimeStampHttpClient
    public boolean isIgnoreHttpsCertificates() {
        return this.ignoreHttpsCertificates;
    }

    @Override // org.apache.poi.poifs.crypt.dsig.services.TimeStampHttpClient
    public TimeStampHttpClient.TimeStampHttpClientResponse post(String str, byte[] bArr) {
        return handleRedirect(str, new org.apache.poi.poifs.crypt.a(bArr), isFollowRedirects());
    }

    public void recklessConnection(HttpURLConnection httpURLConnection) throws IOException {
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, new TrustManager[]{new UnsafeTrustManager()}, RandomSingleton.getInstance());
                httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
                httpsURLConnection.setHostnameVerifier(new k());
            } catch (GeneralSecurityException e) {
                throw new IOException("Unable to reckless wrap connection.", e);
            }
        }
    }

    @Override // org.apache.poi.poifs.crypt.dsig.services.TimeStampHttpClient
    public void setBasicAuthentication(String str, String str2) {
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty()) {
            this.header.remove("Authorization");
            return;
        }
        String strEncodeToString = Base64.getEncoder().encodeToString(androidx.collection.a.o(str, ParameterizedMessage.ERROR_MSG_SEPARATOR, str2).getBytes(StandardCharsets.ISO_8859_1));
        this.header.put("Authorization", "Basic " + strEncodeToString);
    }

    @Override // org.apache.poi.poifs.crypt.dsig.services.TimeStampHttpClient
    public void setContentTypeIn(String str) {
        this.header.put("Content-Type", str);
    }

    @Override // org.apache.poi.poifs.crypt.dsig.services.TimeStampHttpClient
    public void setContentTypeOut(String str) {
        this.contentTypeOut = str;
    }

    @Override // org.apache.poi.poifs.crypt.dsig.services.TimeStampHttpClient
    public void setFollowRedirects(boolean z6) {
        this.followRedirects = z6;
    }

    @Override // org.apache.poi.poifs.crypt.dsig.services.TimeStampHttpClient
    public void setIgnoreHttpsCertificates(boolean z6) {
        this.ignoreHttpsCertificates = z6;
    }

    public void setProxy(String str) {
        if (str == null || str.isEmpty()) {
            this.proxy = Proxy.NO_PROXY;
            return;
        }
        try {
            URL url = new URL(str);
            String host = url.getHost();
            int port = url.getPort();
            Proxy.Type type = Proxy.Type.HTTP;
            InetAddress byName = InetAddress.getByName(host);
            if (port == -1) {
                port = 80;
            }
            this.proxy = new Proxy(type, new InetSocketAddress(byName, port));
        } catch (IOException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$get$1(HttpURLConnection httpURLConnection) {
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class UnsafeTrustManager implements X509TrustManager {
        private UnsafeTrustManager() {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }
    }
}
