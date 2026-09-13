package V4;

import U4.j;
import U4.k;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.webkit.ProxyConfig;
import com.google.common.net.HttpHeaders;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import javax.net.ssl.HttpsURLConnection;
import kotlinx.serialization.json.internal.AbstractC1125a;
import org.apache.commons.compress.compressors.CompressorStreamFactory;
import org.jsoup.nodes.i;
import org.jsoup.parser.E;
import org.jsoup.parser.P;
import org.jsoup.parser.j1;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class f extends d implements U4.e {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Pattern f778j = Pattern.compile("(application|text)/\\w*\\+?xml.*");
    private InputStream bodyStream;
    private ByteBuffer byteData;
    private String charset;
    private HttpURLConnection conn;
    private final String contentType;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f779f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f780g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f781h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final e f782i;

    private f(HttpURLConnection httpURLConnection, e eVar, f fVar) throws IOException {
        int i5 = 0;
        this.f781h = 0;
        this.conn = httpURLConnection;
        this.f782i = eVar;
        this.b = U4.c.valueOf(httpURLConnection.getRequestMethod());
        this.f767a = httpURLConnection.getURL();
        httpURLConnection.getResponseCode();
        httpURLConnection.getResponseMessage();
        this.contentType = httpURLConnection.getContentType();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (true) {
            String headerFieldKey = httpURLConnection.getHeaderFieldKey(i5);
            String headerField = httpURLConnection.getHeaderField(i5);
            if (headerFieldKey == null && headerField == null) {
                break;
            }
            i5++;
            if (headerFieldKey != null && headerField != null) {
                if (linkedHashMap.containsKey(headerFieldKey)) {
                    ((List) linkedHashMap.get(headerFieldKey)).add(headerField);
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(headerField);
                    linkedHashMap.put(headerFieldKey, arrayList);
                }
            }
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str = (String) entry.getKey();
            if (str != null) {
                List<String> list = (List) entry.getValue();
                if (str.equalsIgnoreCase(HttpHeaders.SET_COOKIE)) {
                    for (String str2 : list) {
                        if (str2 != null) {
                            P p6 = new P(str2);
                            String strE = p6.e("=");
                            p6.h("=");
                            String strTrim = strE.trim();
                            String strTrim2 = p6.e(";").trim();
                            if (strTrim.length() > 0 && !this.d.containsKey(strTrim)) {
                                h.notEmpty(strTrim, "Cookie name must not be empty");
                                h.notNull(strTrim2, "Cookie value must not be null");
                                this.d.put(strTrim, strTrim2);
                            }
                        }
                    }
                }
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    a(str, (String) it.next());
                }
            }
        }
        a.storeCookies(this.f782i, this.f767a, linkedHashMap);
        if (fVar != null) {
            for (Map.Entry entry2 : fVar.d.entrySet()) {
                String str3 = (String) entry2.getKey();
                h.notEmpty(str3, "Cookie name must not be empty");
                if (!this.d.containsKey(str3)) {
                    String str4 = (String) entry2.getKey();
                    String str5 = (String) entry2.getValue();
                    h.notEmpty(str4, "Cookie name must not be empty");
                    h.notNull(str5, "Cookie value must not be null");
                    this.d.put(str4, str5);
                }
            }
            fVar.g();
            int i6 = fVar.f781h + 1;
            this.f781h = i6;
            if (i6 < 20) {
                return;
            }
            throw new IOException("Too many redirects occurred trying to load URL " + fVar.e());
        }
    }

    private static HttpURLConnection createConnection(e eVar) throws ProtocolException {
        Proxy proxy = eVar.proxy();
        HttpURLConnection httpURLConnection = (HttpURLConnection) (proxy == null ? eVar.e().openConnection() : eVar.e().openConnection(proxy));
        httpURLConnection.setRequestMethod(eVar.b.name());
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setConnectTimeout(eVar.f768f);
        httpURLConnection.setReadTimeout(eVar.f768f / 2);
        if (eVar.sslSocketFactory() != null && (httpURLConnection instanceof HttpsURLConnection)) {
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(eVar.sslSocketFactory());
        }
        if (eVar.b.f738a) {
            httpURLConnection.setDoOutput(true);
        }
        a.applyCookiesToRequest(eVar, httpURLConnection);
        for (Map.Entry entry : eVar.c.entrySet()) {
            Iterator it = ((List) entry.getValue()).iterator();
            while (it.hasNext()) {
                httpURLConnection.addRequestProperty((String) entry.getKey(), (String) it.next());
            }
        }
        return httpURLConnection;
    }

    public static f execute(e eVar) {
        return execute(eVar, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void serialiseRequestUrl(U4.d dVar) {
        d dVar2 = (d) dVar;
        URL urlE = dVar2.e();
        StringBuilder sbB = W4.b.b();
        sbB.append(urlE.getProtocol());
        sbB.append("://");
        sbB.append(urlE.getAuthority());
        sbB.append(urlE.getPath());
        sbB.append("?");
        if (urlE.getQuery() != null) {
            sbB.append(urlE.getQuery());
        }
        ArrayList arrayList = ((e) dVar).f771i;
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            throw AbstractC1125a.g(it);
        }
        URL url = new URL(W4.b.g(sbB));
        dVar2.getClass();
        h.notNull(url, "URL must not be null");
        dVar2.f767a = g.b(url);
        arrayList.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static String setOutputContentType(U4.d dVar) {
        d dVar2 = (d) dVar;
        String strHeader = dVar2.header(HttpHeaders.CONTENT_TYPE);
        if (strHeader == null) {
            Charset charset = g.b;
            e eVar = (e) dVar;
            Iterator it = eVar.f771i.iterator();
            if (it.hasNext()) {
                throw AbstractC1125a.g(it);
            }
            String str = "application/x-www-form-urlencoded; charset=" + eVar.f775m;
            dVar2.getClass();
            h.notEmpty(HttpHeaders.CONTENT_TYPE, "Header name must not be empty");
            dVar2.d(HttpHeaders.CONTENT_TYPE);
            dVar2.a(HttpHeaders.CONTENT_TYPE, str);
            return null;
        }
        if (!strHeader.contains(ShareTarget.ENCODING_TYPE_MULTIPART) || strHeader.contains("boundary")) {
            return null;
        }
        Pattern pattern = c.f766a;
        StringBuilder sbB = W4.b.b();
        Random random = new Random();
        for (int i5 = 0; i5 < 32; i5++) {
            char[] cArr = c.d;
            sbB.append(cArr[random.nextInt(cArr.length)]);
        }
        String strG = W4.b.g(sbB);
        dVar2.getClass();
        h.notEmpty(HttpHeaders.CONTENT_TYPE, "Header name must not be empty");
        dVar2.d(HttpHeaders.CONTENT_TYPE);
        dVar2.a(HttpHeaders.CONTENT_TYPE, "multipart/form-data; boundary=" + strG);
        return strG;
    }

    private static void writePost(U4.d dVar, OutputStream outputStream, String str) throws IOException {
        e eVar = (e) dVar;
        ArrayList arrayList = eVar.f771i;
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, eVar.f775m));
        if (str != null) {
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                if (it.next() != null) {
                    throw new ClassCastException();
                }
                bufferedWriter.write("--");
                bufferedWriter.write(str);
                bufferedWriter.write("\r\n");
                bufferedWriter.write("Content-Disposition: form-data; name=\"");
                throw null;
            }
            bufferedWriter.write("--");
            bufferedWriter.write(str);
            bufferedWriter.write("--");
        } else {
            String strRequestBody = eVar.requestBody();
            if (strRequestBody != null) {
                bufferedWriter.write(strRequestBody);
            } else {
                Iterator it2 = arrayList.iterator();
                if (it2.hasNext()) {
                    throw AbstractC1125a.g(it2);
                }
            }
        }
        bufferedWriter.close();
    }

    @Override // U4.e
    public final String charset() {
        return this.charset;
    }

    @Override // U4.e
    public final String contentType() {
        return this.contentType;
    }

    public final String f() {
        h.a("Request must be executed (with .execute(), .get(), or .post() before getting response body", this.f779f);
        InputStream inputStream = this.bodyStream;
        if (inputStream != null && this.byteData == null) {
            if (this.f780g) {
                throw new IllegalArgumentException("Request has already been read (with .parse())");
            }
            try {
                try {
                    this.byteData = c.readToByteBuffer(inputStream, this.f782i.f769g);
                    this.f780g = true;
                    g();
                } catch (IOException e) {
                    throw new j(e);
                }
            } catch (Throwable th) {
                this.f780g = true;
                g();
                throw th;
            }
        }
        h.notNull(this.byteData);
        String str = this.charset;
        String string = (str == null ? c.b : Charset.forName(str)).decode(this.byteData).toString();
        this.byteData.rewind();
        return string;
    }

    public final void g() {
        InputStream inputStream = this.bodyStream;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            } finally {
                this.bodyStream = null;
            }
        }
        HttpURLConnection httpURLConnection = this.conn;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            this.conn = null;
        }
    }

    @Override // U4.e
    public i parse() throws IOException {
        h.a("Request must be executed (with .execute(), .get(), or .post() before parsing response", this.f779f);
        if (this.byteData != null) {
            this.bodyStream = new ByteArrayInputStream(this.byteData.array());
            this.f780g = false;
        }
        if (this.f780g) {
            throw new IllegalArgumentException("Input stream already read and parsed, cannot re-read.");
        }
        InputStream inputStream = this.bodyStream;
        String str = this.charset;
        String externalForm = this.f767a.toExternalForm();
        e eVar = this.f782i;
        i inputStream2 = c.parseInputStream(inputStream, str, externalForm, eVar.f773k);
        inputStream2.V(new g(eVar, this));
        this.charset = inputStream2.f7471g.b.name();
        this.f780g = true;
        g();
        return inputStream2;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0089 A[Catch: all -> 0x0094, IOException -> 0x0097, TRY_LEAVE, TryCatch #0 {IOException -> 0x0097, blocks: (B:33:0x0080, B:35:0x0089, B:37:0x0090, B:48:0x00a1, B:49:0x00a4, B:50:0x00a5), top: B:124:0x0080 }] */
    public static f execute(e eVar, f fVar) throws ProtocolException, MalformedURLException {
        String outputContentType;
        HttpURLConnection httpURLConnectionCreateConnection;
        int responseCode;
        f fVar2;
        W4.a aVar;
        OutputStream outputStream;
        synchronized (eVar) {
            if (eVar.f777o) {
                throw new IllegalArgumentException("Multiple threads were detected trying to execute the same request concurrently. Make sure to use Connection#newRequest() and do not share an executing request between threads.");
            }
            eVar.f777o = true;
        }
        h.notNull(eVar, "Request must not be null");
        URL urlE = eVar.e();
        h.notNull(urlE, "URL must be specified to connect");
        String protocol = urlE.getProtocol();
        if (!protocol.equals(ProxyConfig.MATCH_HTTP) && !protocol.equals(ProxyConfig.MATCH_HTTPS)) {
            throw new MalformedURLException("Only http & https protocols supported");
        }
        boolean z6 = eVar.b.f738a;
        boolean z7 = eVar.requestBody() != null;
        if (!z6) {
            String str = "Cannot set a request body for HTTP method " + eVar.b;
            if (z7) {
                throw new IllegalArgumentException(str);
            }
        }
        f fVar3 = null;
        try {
            try {
                try {
                    if (eVar.f771i.size() <= 0 || (z6 && !z7)) {
                        if (z6) {
                            outputContentType = setOutputContentType(eVar);
                        }
                        long jNanoTime = System.nanoTime();
                        httpURLConnectionCreateConnection = createConnection(eVar);
                        httpURLConnectionCreateConnection.connect();
                        if (httpURLConnectionCreateConnection.getDoOutput()) {
                            outputStream = httpURLConnectionCreateConnection.getOutputStream();
                            try {
                                try {
                                    writePost(eVar, outputStream, outputContentType);
                                    outputStream.close();
                                } catch (Throwable th) {
                                    outputStream.close();
                                    throw th;
                                }
                            } catch (IOException e) {
                                httpURLConnectionCreateConnection.disconnect();
                                throw e;
                            }
                        }
                        responseCode = httpURLConnectionCreateConnection.getResponseCode();
                        fVar2 = new f(httpURLConnectionCreateConnection, eVar, fVar);
                        h.notEmpty(HttpHeaders.LOCATION, "Header name must not be empty");
                        if (fVar2.b(HttpHeaders.LOCATION).isEmpty() && eVar.f770h) {
                            if (responseCode != 307) {
                                U4.c cVar = U4.c.GET;
                                h.notNull(cVar, "Method must not be null");
                                eVar.b = cVar;
                                eVar.f771i.clear();
                                eVar.requestBody(null);
                                eVar.d(HttpHeaders.CONTENT_TYPE);
                            }
                            String strHeader = fVar2.header(HttpHeaders.LOCATION);
                            h.notNull(strHeader);
                            if (strHeader.startsWith("http:/") && strHeader.charAt(6) != '/') {
                                strHeader = strHeader.substring(6);
                            }
                            URL urlA = g.a(W4.b.resolve(eVar.e(), strHeader));
                            h.notNull(urlA, "URL must not be null");
                            eVar.f767a = g.b(urlA);
                            eVar.f777o = false;
                            f fVarExecute = execute(eVar, fVar2);
                            eVar.f777o = false;
                            return fVarExecute;
                        }
                        if (responseCode >= 200 || responseCode >= 400) {
                            throw new U4.g(responseCode, eVar.e().toString());
                        }
                        String str2 = fVar2.contentType;
                        if (str2 != null && !eVar.f772j && !str2.startsWith("text/") && !f778j.matcher(str2).matches()) {
                            throw new k(str2, eVar.e().toString());
                        }
                        if (str2 != null && f778j.matcher(str2).matches() && !eVar.f774l) {
                            eVar.f773k = new E(new j1());
                            eVar.f774l = true;
                        }
                        fVar2.charset = c.getCharsetFromContentType(fVar2.contentType);
                        if (httpURLConnectionCreateConnection.getContentLength() == 0 || eVar.b == U4.c.HEAD) {
                            fVar2.byteData = ByteBuffer.allocate(0);
                        } else {
                            InputStream errorStream = httpURLConnectionCreateConnection.getErrorStream() != null ? httpURLConnectionCreateConnection.getErrorStream() : httpURLConnectionCreateConnection.getInputStream();
                            fVar2.bodyStream = errorStream;
                            h.notNull(errorStream);
                            if (fVar2.c("gzip")) {
                                fVar2.bodyStream = new GZIPInputStream(fVar2.bodyStream);
                            } else if (fVar2.c(CompressorStreamFactory.DEFLATE)) {
                                fVar2.bodyStream = new InflaterInputStream(fVar2.bodyStream, new Inflater(true));
                            }
                            InputStream inputStream = fVar2.bodyStream;
                            int i5 = eVar.f769g;
                            if (inputStream instanceof W4.a) {
                                int i6 = W4.a.f827g;
                                aVar = (W4.a) inputStream;
                            } else {
                                aVar = new W4.a(inputStream, i5);
                            }
                            long j6 = eVar.f768f;
                            aVar.c = jNanoTime;
                            aVar.d = j6 * 1000000;
                            fVar2.bodyStream = aVar;
                        }
                        eVar.f777o = false;
                        fVar2.f779f = true;
                        return fVar2;
                    }
                    serialiseRequestUrl(eVar);
                    h.notEmpty(HttpHeaders.LOCATION, "Header name must not be empty");
                    if (fVar2.b(HttpHeaders.LOCATION).isEmpty()) {
                    }
                    if (responseCode >= 200) {
                    }
                    throw new U4.g(responseCode, eVar.e().toString());
                } catch (IOException e6) {
                    e = e6;
                    fVar3 = fVar2;
                    if (fVar3 != null) {
                        fVar3.g();
                    }
                    throw e;
                }
                httpURLConnectionCreateConnection.connect();
                if (httpURLConnectionCreateConnection.getDoOutput()) {
                    outputStream = httpURLConnectionCreateConnection.getOutputStream();
                    writePost(eVar, outputStream, outputContentType);
                    outputStream.close();
                }
                responseCode = httpURLConnectionCreateConnection.getResponseCode();
                fVar2 = new f(httpURLConnectionCreateConnection, eVar, fVar);
            } catch (IOException e7) {
                e = e7;
            }
        } catch (Throwable th2) {
            eVar.f777o = false;
            throw th2;
        }
        outputContentType = null;
        long jNanoTime2 = System.nanoTime();
        httpURLConnectionCreateConnection = createConnection(eVar);
    }
}
