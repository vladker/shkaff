package cn.fly.tools.network;

import cn.fly.commons.C0396r;
import cn.fly.commons.j;
import cn.fly.commons.m;
import cn.fly.commons.q;
import cn.fly.tools.FlyLog;
import cn.fly.tools.log.NLog;
import cn.fly.tools.proguard.EverythingKeeper;
import cn.fly.tools.proguard.PublicMemberKeeper;
import cn.fly.tools.utils.DH;
import cn.fly.tools.utils.Data;
import cn.fly.tools.utils.HashonHelper;
import cn.fly.tools.utils.ReflectHelper;
import com.google.common.net.HttpHeaders;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.commons.math3.optimization.direct.CMAESOptimizer;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: loaded from: classes.dex */
public class NetworkHelper implements EverythingKeeper {
    private static final String CONTENT_TYPE_FORM = m.a("033flli4fk<efkDfkfmOgn@gkjmhihihijmghfmflfhjmfifl(ihge%fmfe>hLfe");
    private static final String CONTENT_TYPE_JSON = "application/json";
    public static int connectionTimeout = 0;
    private static boolean followRedirects = true;
    public static int readTimout;
    public boolean instanceFollowRedirects = followRedirects;

    public static class NetworkTimeOut implements PublicMemberKeeper {
        public int connectionTimeout;
        public int readTimout;
    }

    public static class a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Object f1818a;
        private String b;

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, CertificateException, InvocationTargetException {
            String name = method.getName();
            if (!name.equals("checkClientTrusted")) {
                if (name.equals("checkServerTrusted")) {
                    Object[] objArr2 = (Object[]) objArr[0];
                    String str = (String) objArr[1];
                    if (objArr2 == null) {
                        throw new IllegalArgumentException("there were no certificates.");
                    }
                    if (objArr2.length == 0) {
                        throw new IllegalArgumentException("certificates is empty.");
                    }
                    if (this.f1818a == null) {
                        throw new CertificateException("there were one more certificates but no trust manager found.");
                    }
                    for (Object obj2 : objArr2) {
                        Method declaredMethod = obj2.getClass().getDeclaredMethod("checkValidity", null);
                        declaredMethod.setAccessible(true);
                        declaredMethod.invoke(obj2, null);
                    }
                    if (DH.SyncMtd.getOSVersionIntForFly() >= 17) {
                        Object objNewInstance = Class.forName("android.net.http.X509TrustManagerExtensions").getConstructor(Class.forName(m.a("0306ji5f9ff=f-gkfn4ghkAfnhkhkUi*fniijkhjjlheflfihk%kNjeWfgfJgl0h=fl"))).newInstance(this.f1818a);
                        Method declaredMethod2 = objNewInstance.getClass().getDeclaredMethod("checkServerTrusted", Array.newInstance(Class.forName(m.a("034Oji'fRffOfMfnhk-he<fiflfkQkJgefn$ehDfl8kAfniijkhjjlgf h.fl9kMfkghfkHefkh")), 0).getClass(), String.class, String.class);
                        declaredMethod2.setAccessible(true);
                        declaredMethod2.invoke(objNewInstance, objArr2, str, this.b);
                    } else {
                        Method declaredMethod3 = this.f1818a.getClass().getDeclaredMethod("checkServerTrusted", Array.newInstance(Class.forName(m.a("034(ji$f^ff6fVfnhk!he9fiflfk;k8gefn6eh0flOk]fniijkhjjlgfYh4flKkBfkghfkFefkh")), 0).getClass(), String.class);
                        declaredMethod3.setAccessible(true);
                        declaredMethod3.invoke(this.f1818a, objArr2, str);
                    }
                } else {
                    if (name.equals(m.a("018NglOhk@hfQeehlkhEfegghkhkfi3h(flhk"))) {
                        return Array.newInstance(Class.forName(m.a("034,ji9f)ff)f7fnhkFhe4fiflfk.k(gefnTehCfl%kZfniijkhjjlgf3hUflOkFfkghfk?efkh")), 0);
                    }
                    if (name.equals(m.a("008jfDhk j=gffmfe9h"))) {
                        return Integer.valueOf(hashCode());
                    }
                    if (name.equals("toString")) {
                        return toString();
                    }
                }
            }
            return null;
        }

        private a(String str) {
            try {
                this.b = str;
                Method declaredMethod = Class.forName(m.a("033ZjiWfOff[f9gkfn ghk+fnhkhk6iMfnheflfihkXk<je0fgf$gl8h(flie<fek,fmflge")).getDeclaredMethod(m.a("0115gl$hkDggTg:hk<kfgeh"), String.class);
                declaredMethod.setAccessible(true);
                Object objInvoke = declaredMethod.invoke(null, m.a("004(iijkhjjl"));
                Method method = objInvoke.getClass().getMethod(m.a("004<fk(g%fkRk"), Class.forName(m.a("022[ji<f$ff fIfnhkYhe%fiflfkAk$gefnkeXhHgegn)kIfmflPh")));
                method.setAccessible(true);
                method.invoke(objInvoke, null);
                Method method2 = objInvoke.getClass().getMethod(m.a("016[gl-hk$heflfihk!kZje1fgfDglSh.flhk"), null);
                method2.setAccessible(true);
                Object[] objArr = (Object[]) method2.invoke(objInvoke, null);
                if (objArr == null || objArr.length == 0) {
                    throw new NoSuchAlgorithmException("no trust manager found.");
                }
                this.f1818a = objArr[0];
            } catch (Exception e) {
                FlyLog.getInstance().d("failed to initialize the standard trust manager: " + e.getMessage(), new Object[0]);
                this.f1818a = null;
            }
        }
    }

    public static Object getTrustManager(String str) throws ClassNotFoundException {
        Class<?> cls = Class.forName(m.a("030%ji f@ff*f*gkfn!ghkEfnhkhk!i)fniijkhjjlheflfihk k_je(fgf-glShIfl"));
        return Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{cls}, new a(str));
    }

    private String handleResponse(HttpURLConnection httpURLConnection, int i5, HttpResponseCallback httpResponseCallback, long j6) {
        try {
            if (i5 != 200 && i5 >= 300) {
                String stream = readStream(httpURLConnection.getErrorStream());
                HashMap map = new HashMap();
                map.put(m.a("005hQflflfmfl"), stream);
                map.put(m.a("006Ihk2kfkCfihk"), Integer.valueOf(i5));
                throw new Throwable(HashonHelper.fromHashMap(map));
            }
            if (httpResponseCallback == null) {
                String stream2 = readStream(httpURLConnection.getInputStream());
                httpURLConnection.disconnect();
                return stream2;
            }
            httpResponseCallback.onResponse(new HttpConnectionImpl23(httpURLConnection));
            FlyLog.getInstance().i("use time: " + (System.currentTimeMillis() - j6));
            httpURLConnection.disconnect();
            return null;
        } catch (Throwable th) {
            httpURLConnection.disconnect();
            throw th;
        }
    }

    public static boolean isRedirects(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseCode() == 301 || httpURLConnection.getResponseCode() == 302 || httpURLConnection.getResponseCode() == 304 || httpURLConnection.getResponseCode() == 307 || httpURLConnection.getResponseCode() == 308;
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
            return false;
        }
    }

    private String postRequest(String str, HashMap<String, Object> map, HashMap<String, String> map2, NetworkTimeOut networkTimeOut, String str2, HttpResponseCallback httpResponseCallback) throws Throwable {
        Throwable th;
        Throwable th2;
        OutputStream outputStream;
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            FlyLog.getInstance().d("postRequest: " + str + "\nhd: " + map2, new Object[0]);
            HttpURLConnection connection = getConnection(str, networkTimeOut);
            connection.setDoOutput(true);
            connection.setRequestProperty(m.a("010GgffmUgghekIfkfm%g"), HttpHeaders.KEEP_ALIVE);
            connection.setRequestProperty(HttpHeaders.CONTENT_TYPE, str2);
            if (map2 != null) {
                try {
                    for (Map.Entry<String, String> entry : map2.entrySet()) {
                        connection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                } catch (Throwable th3) {
                    th = th3;
                    handleNetworkError(th);
                    throw th;
                }
            }
            StringPart stringPart = new StringPart();
            if (map != null) {
                if (CONTENT_TYPE_JSON.equals(str2)) {
                    stringPart.append(HashonHelper.fromHashMap(map));
                } else {
                    stringPart.append(requestParamsToUrl(map));
                }
            }
            if (CONTENT_TYPE_JSON.equals(str2)) {
                connection.setChunkedStreamingMode(0);
            } else if (CONTENT_TYPE_FORM.equals(str2)) {
                connection.setFixedLengthStreamingMode((int) stringPart.length());
            }
            connection.setInstanceFollowRedirects(this.instanceFollowRedirects);
            connection.connect();
            InputStream inputStream = null;
            try {
                try {
                    outputStream = connection.getOutputStream();
                    try {
                        inputStream = stringPart.toInputStream();
                        transferData(inputStream, outputStream);
                        C0396r.a(inputStream, outputStream);
                        return handleResponse(connection, connection.getResponseCode(), httpResponseCallback, jCurrentTimeMillis);
                    } catch (Throwable th4) {
                        th2 = th4;
                        C0396r.a(inputStream, outputStream);
                        throw th2;
                    }
                } catch (Throwable th5) {
                    th2 = th5;
                    outputStream = null;
                }
            } catch (Throwable th6) {
                th = th6;
                th = th;
                handleNetworkError(th);
                throw th;
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }

    private String readStream(InputStream inputStream) throws Throwable {
        InputStreamReader inputStreamReader;
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            try {
                BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            C0396r.a(bufferedReader2, inputStreamReader);
                            return sb.toString();
                        }
                        if (sb.length() > 0) {
                            sb.append('\n');
                        }
                        sb.append(line);
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        C0396r.a(bufferedReader, inputStreamReader);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStreamReader = null;
        }
    }

    private void transferData(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[65536];
        while (true) {
            int i5 = inputStream.read(bArr);
            if (i5 <= 0) {
                outputStream.flush();
                return;
            }
            outputStream.write(bArr, 0, i5);
        }
    }

    public void download(String str, final OutputStream outputStream, NetworkTimeOut networkTimeOut) throws IOException {
        final byte[] bArr = new byte[1024];
        rawGet(str, new RawNetworkCallback() { // from class: cn.fly.tools.network.NetworkHelper.1
            @Override // cn.fly.tools.network.RawNetworkCallback
            public void onResponse(InputStream inputStream) throws IOException {
                int i5 = inputStream.read(bArr);
                while (i5 != -1) {
                    outputStream.write(bArr, 0, i5);
                    i5 = inputStream.read(bArr);
                }
            }
        }, networkTimeOut);
        outputStream.flush();
    }

    public HttpURLConnection getConnection(String str, NetworkTimeOut networkTimeOut) throws Throwable {
        Object staticField;
        boolean z6;
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        String strA = m.a("0120fh3hkj2fmfehefmgj5hg*hk");
        try {
            staticField = ReflectHelper.getInstanceField(httpURLConnection, strA);
        } catch (Throwable unused) {
            staticField = null;
        }
        if (staticField == null) {
            strA = "PERMITTED_USER_METHODS";
            try {
                staticField = ReflectHelper.getStaticField("HttpURLConnection", "PERMITTED_USER_METHODS");
            } catch (Throwable unused2) {
            }
            z6 = true;
        } else {
            z6 = false;
        }
        if (staticField != null) {
            String[] strArr = (String[]) staticField;
            String[] strArr2 = new String[strArr.length + 1];
            System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
            strArr2[strArr.length] = m.a("005_inhfhegfhm");
            if (z6) {
                ReflectHelper.setStaticField("HttpURLConnection", strA, strArr2);
            } else {
                ReflectHelper.setInstanceField(httpURLConnection, strA, strArr2);
            }
        }
        System.setProperty("http.keepAlive", "false");
        if (httpURLConnection instanceof HttpsURLConnection) {
            X509HostnameVerifier x509HostnameVerifier = SSLSocketFactory.STRICT_HOSTNAME_VERIFIER;
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            SSLContext sSLContext = SSLContext.getInstance(m.a("0037hehggn"));
            TrustManager[] trustManagerArr = new TrustManager[0];
            try {
                trustManagerArr = new TrustManager[]{(TrustManager) getTrustManager(httpsURLConnection.getURL().getHost())};
            } catch (Throwable th) {
                FlyLog.getInstance().e(th);
            }
            sSLContext.init(null, trustManagerArr, new SecureRandom());
            httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
            httpsURLConnection.setHostnameVerifier(x509HostnameVerifier);
        }
        int i5 = networkTimeOut == null ? connectionTimeout : networkTimeOut.connectionTimeout;
        if (i5 > 0) {
            httpURLConnection.setConnectTimeout(i5);
        }
        int i6 = networkTimeOut == null ? readTimout : networkTimeOut.readTimout;
        if (i6 > 0) {
            httpURLConnection.setReadTimeout(i6);
        }
        return httpURLConnection;
    }

    public void handleNetworkError(Throwable th) {
        if ((th instanceof UnknownHostException) || (th instanceof NoRouteToHostException) || (th instanceof SocketTimeoutException) || (th instanceof ConnectException)) {
            j.a().d();
        }
    }

    public String httpGet(String str, HashMap<String, Object> map, HashMap<String, String> map2) {
        NetworkTimeOut networkTimeOut = new NetworkTimeOut();
        networkTimeOut.readTimout = CMAESOptimizer.DEFAULT_MAXITERATIONS;
        networkTimeOut.connectionTimeout = 10000;
        return httpGetNew(str, map, map2, networkTimeOut);
    }

    public String httpGetNew(String str, HashMap<String, Object> map, HashMap<String, String> map2, NetworkTimeOut networkTimeOut) {
        InputStreamReader inputStreamReader;
        InputStreamReader inputStreamReader2;
        try {
            NLog flyLog = FlyLog.getInstance();
            StringBuilder sb = new StringBuilder();
            sb.append("hgt: " + str);
            sb.append("\n");
            sb.append(String.format("hd: %s", map2));
            flyLog.d(sb.toString(), new Object[0]);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (map != null) {
                String strRequestParamsToUrl = requestParamsToUrl(map);
                if (strRequestParamsToUrl.length() > 0) {
                    str = str + "?" + strRequestParamsToUrl;
                }
            }
            HttpURLConnection connection = getConnection(str, networkTimeOut);
            setHeader(connection, map2);
            connection.setInstanceFollowRedirects(this.instanceFollowRedirects);
            connection.connect();
            int responseCode = connection.getResponseCode();
            BufferedReader bufferedReader = null;
            if (responseCode == 200) {
                StringBuilder sb2 = new StringBuilder();
                try {
                    inputStreamReader2 = new InputStreamReader(connection.getInputStream(), Charset.forName("utf-8"));
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader2);
                        try {
                            for (String line = bufferedReader2.readLine(); line != null; line = bufferedReader2.readLine()) {
                                if (sb2.length() > 0) {
                                    sb2.append('\n');
                                }
                                sb2.append(line);
                            }
                            C0396r.a(bufferedReader2, inputStreamReader2);
                            connection.disconnect();
                            String string = sb2.toString();
                            FlyLog.getInstance().d("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
                            return string;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            C0396r.a(bufferedReader, inputStreamReader2);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStreamReader2 = null;
                }
            } else {
                StringBuilder sb3 = new StringBuilder();
                try {
                    inputStreamReader = new InputStreamReader(connection.getErrorStream(), Charset.forName("utf-8"));
                    try {
                        BufferedReader bufferedReader3 = new BufferedReader(inputStreamReader);
                        try {
                            for (String line2 = bufferedReader3.readLine(); line2 != null; line2 = bufferedReader3.readLine()) {
                                if (sb3.length() > 0) {
                                    sb3.append('\n');
                                }
                                sb3.append(line2);
                            }
                            C0396r.a(bufferedReader3, inputStreamReader);
                            connection.disconnect();
                            HashMap map3 = new HashMap();
                            map3.put(m.a("005h[flflfmfl"), sb3.toString());
                            map3.put(m.a("006YhkOkfkJfihk"), Integer.valueOf(responseCode));
                            throw new Throwable(HashonHelper.fromHashMap(map3));
                        } catch (Throwable th4) {
                            th = th4;
                            bufferedReader = bufferedReader3;
                            C0396r.a(bufferedReader, inputStreamReader);
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    inputStreamReader = null;
                }
            }
        } catch (Throwable th7) {
            handleNetworkError(th7);
            throw th7;
        }
    }

    public String httpPostNew(String str, HashMap<String, Object> map, HashMap<String, String> map2, NetworkTimeOut networkTimeOut) {
        return postRequest(str, map, map2, networkTimeOut, CONTENT_TYPE_FORM, null);
    }

    public void httpPostWithBytes(String str, byte[] bArr, HashMap<String, String> map, int i5, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) {
        OutputStream outputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        Closeable closeable;
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            FlyLog.getInstance().d("hpt: " + str, new Object[0]);
            HttpURLConnection connection = getConnection(str, networkTimeOut);
            char c = 1;
            connection.setDoOutput(true);
            if (i5 >= 0) {
                connection.setChunkedStreamingMode(0);
            }
            setHeader(connection, map);
            connection.setRequestProperty(m.a("010^gffm gghekUfkfmMg"), HttpHeaders.KEEP_ALIVE);
            connection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/octet-stream");
            connection.setInstanceFollowRedirects(this.instanceFollowRedirects);
            connection.connect();
            ByteArrayInputStream byteArrayInputStream = null;
            try {
                outputStream = connection.getOutputStream();
                try {
                    String strA = q.a();
                    if (strA == null) {
                        strA = "";
                    }
                    byte[] bytes = strA.getBytes("utf-8");
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                        c = 1;
                        try {
                            dataOutputStream.writeInt(bytes.length);
                            dataOutputStream.write(bytes);
                            dataOutputStream.write(bArr);
                            dataOutputStream.flush();
                            ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                            try {
                                transferData(byteArrayInputStream2, outputStream);
                                if (httpResponseCallback != null) {
                                    try {
                                        httpResponseCallback.onResponse(new HttpConnectionImpl23(connection));
                                        connection.disconnect();
                                    } catch (Throwable th) {
                                        try {
                                            throw th;
                                        } catch (Throwable th2) {
                                            connection.disconnect();
                                            throw th2;
                                        }
                                    }
                                } else {
                                    connection.disconnect();
                                }
                                connection.disconnect();
                                C0396r.a(byteArrayInputStream2, outputStream, dataOutputStream, byteArrayOutputStream);
                                FlyLog.getInstance().d("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
                            } catch (Throwable th3) {
                                th = th3;
                                byteArrayInputStream = byteArrayInputStream2;
                                closeable = dataOutputStream;
                                connection.disconnect();
                                Closeable[] closeableArr = new Closeable[4];
                                closeableArr[0] = byteArrayInputStream;
                                closeableArr[c] = outputStream;
                                closeableArr[2] = closeable;
                                closeableArr[3] = byteArrayOutputStream;
                                C0396r.a(closeableArr);
                                FlyLog.getInstance().d("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            closeable = dataOutputStream;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        c = 1;
                        closeable = null;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    byteArrayOutputStream = null;
                    closeable = byteArrayOutputStream;
                    connection.disconnect();
                    Closeable[] closeableArr2 = new Closeable[4];
                    closeableArr2[0] = byteArrayInputStream;
                    closeableArr2[c] = outputStream;
                    closeableArr2[2] = closeable;
                    closeableArr2[3] = byteArrayOutputStream;
                    C0396r.a(closeableArr2);
                    FlyLog.getInstance().d("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
                    throw th;
                }
            } catch (Throwable th7) {
                th = th7;
                outputStream = null;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th8) {
            handleNetworkError(th8);
            throw th8;
        }
    }

    public String jsonPost(String str, HashMap<String, Object> map, HashMap<String, String> map2, NetworkTimeOut networkTimeOut) throws Throwable {
        final HashMap map3 = new HashMap();
        postRequest(str, map, map2, networkTimeOut, CONTENT_TYPE_JSON, new HttpResponseCallback() { // from class: cn.fly.tools.network.NetworkHelper.2
            @Override // cn.fly.tools.network.HttpResponseCallback
            public void onResponse(HttpConnection httpConnection) throws Throwable {
                InputStreamReader inputStreamReader;
                InputStreamReader inputStreamReader2;
                int responseCode = httpConnection.getResponseCode();
                StringBuilder sb = new StringBuilder();
                BufferedReader bufferedReader = null;
                if (responseCode == 200 || responseCode == 201) {
                    try {
                        inputStreamReader = new InputStreamReader(httpConnection.getInputStream(), Charset.forName("utf-8"));
                        try {
                            BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                            try {
                                for (String line = bufferedReader2.readLine(); line != null; line = bufferedReader2.readLine()) {
                                    if (sb.length() > 0) {
                                        sb.append('\n');
                                    }
                                    sb.append(line);
                                }
                                C0396r.a(bufferedReader2, inputStreamReader);
                                map3.put(m.a("003=flVh^hk"), sb.toString());
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                C0396r.a(bufferedReader, inputStreamReader);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        inputStreamReader = null;
                    }
                } else {
                    try {
                        inputStreamReader2 = new InputStreamReader(httpConnection.getErrorStream(), Charset.forName("utf-8"));
                        try {
                            BufferedReader bufferedReader3 = new BufferedReader(inputStreamReader2);
                            try {
                                for (String line2 = bufferedReader3.readLine(); line2 != null; line2 = bufferedReader3.readLine()) {
                                    if (sb.length() > 0) {
                                        sb.append('\n');
                                    }
                                    sb.append(line2);
                                }
                                C0396r.a(bufferedReader3, inputStreamReader2);
                                HashMap map4 = new HashMap();
                                map4.put(m.a("005hTflflfmfl"), sb.toString());
                                map4.put(m.a("0064hk3kfk fihk"), Integer.valueOf(responseCode));
                                new HashonHelper();
                                throw new Throwable(HashonHelper.fromHashMap(map4));
                            } catch (Throwable th4) {
                                th = th4;
                                bufferedReader = bufferedReader3;
                                C0396r.a(bufferedReader, inputStreamReader2);
                                throw th;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        inputStreamReader2 = null;
                    }
                }
            }
        });
        if (map3.containsKey(m.a("003Efl9hDhk"))) {
            return (String) map3.get(m.a("0030flYh*hk"));
        }
        return null;
    }

    public void rawGet(String str, RawNetworkCallback rawNetworkCallback, NetworkTimeOut networkTimeOut) {
        rawGet(str, new HashMap<>(), rawNetworkCallback, networkTimeOut);
    }

    public void rawPost(String str, HashMap<String, String> map, HTTPPart hTTPPart, int i5, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) {
        OutputStream outputStream;
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            FlyLog.getInstance().d("hptr: " + str, new Object[0]);
            HttpURLConnection connection = getConnection(str, networkTimeOut);
            connection.setDoOutput(true);
            if (i5 >= 0) {
                connection.setChunkedStreamingMode(0);
            }
            setHeader(connection, map);
            connection.setInstanceFollowRedirects(this.instanceFollowRedirects);
            connection.connect();
            InputStream inputStream = null;
            try {
                outputStream = connection.getOutputStream();
                try {
                    inputStream = hTTPPart.toInputStream();
                    byte[] bArr = new byte[65536];
                    for (int i6 = inputStream.read(bArr); i6 > 0; i6 = inputStream.read(bArr)) {
                        outputStream.write(bArr, 0, i6);
                    }
                    outputStream.flush();
                    C0396r.a(inputStream, outputStream);
                    if (httpResponseCallback != null) {
                        try {
                            httpResponseCallback.onResponse(new HttpConnectionImpl23(connection));
                            connection.disconnect();
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                connection.disconnect();
                                throw th2;
                            }
                        }
                    } else {
                        connection.disconnect();
                    }
                    FlyLog.getInstance().d("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
                } catch (Throwable th3) {
                    th = th3;
                    C0396r.a(inputStream, outputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                outputStream = null;
            }
        } catch (Throwable th5) {
            handleNetworkError(th5);
            throw th5;
        }
    }

    public String requestParamsToUrl(HashMap<String, Object> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String strUrlEncode = Data.urlEncode(entry.getKey(), "utf-8");
            String strUrlEncode2 = entry.getValue() == null ? "" : Data.urlEncode(String.valueOf(entry.getValue()), "utf-8");
            if (sb.length() > 0) {
                sb.append('&');
            }
            sb.append(strUrlEncode);
            sb.append(Chars.EQ);
            sb.append(strUrlEncode2);
        }
        return sb.toString();
    }

    public void setHeader(URLConnection uRLConnection, HashMap<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            uRLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    public void rawGet(String str, HashMap<String, String> map, RawNetworkCallback rawNetworkCallback, NetworkTimeOut networkTimeOut) {
        InputStreamReader inputStreamReader;
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            FlyLog.getInstance().d("rawGet: " + str, new Object[0]);
            HttpURLConnection connection = getConnection(str, networkTimeOut);
            setHeader(connection, map);
            connection.setInstanceFollowRedirects(this.instanceFollowRedirects);
            connection.connect();
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                if (rawNetworkCallback != null) {
                    InputStream inputStream = connection.getInputStream();
                    try {
                        rawNetworkCallback.onResponse(inputStream);
                        C0396r.a(inputStream);
                        connection.disconnect();
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            C0396r.a(inputStream);
                            connection.disconnect();
                            throw th2;
                        }
                    }
                } else {
                    connection.disconnect();
                }
                FlyLog.getInstance().d("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
                return;
            }
            if (isRedirects(connection)) {
                rawGet(connection.getHeaderField(m.a("008^hgfmUefkWfkfmTg")), new HashMap<>(), rawNetworkCallback, networkTimeOut);
                return;
            }
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = null;
            try {
                inputStreamReader = new InputStreamReader(connection.getErrorStream(), Charset.forName("utf-8"));
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                    try {
                        for (String line = bufferedReader2.readLine(); line != null; line = bufferedReader2.readLine()) {
                            if (sb.length() > 0) {
                                sb.append('\n');
                            }
                            sb.append(line);
                        }
                        C0396r.a(bufferedReader2, inputStreamReader);
                        connection.disconnect();
                        HashMap map2 = new HashMap();
                        map2.put(m.a("005hFflflfmfl"), sb.toString());
                        map2.put(m.a("006Chk kfk,fihk"), Integer.valueOf(responseCode));
                        throw new Throwable(HashonHelper.fromHashMap(map2));
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader = bufferedReader2;
                        C0396r.a(bufferedReader, inputStreamReader);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (Throwable th5) {
                th = th5;
                inputStreamReader = null;
            }
        } catch (Throwable th6) {
            handleNetworkError(th6);
            throw th6;
        }
    }

    public void jsonPost(String str, HashMap<String, Object> map, HashMap<String, String> map2, NetworkTimeOut networkTimeOut, HttpResponseCallback httpResponseCallback) throws Throwable {
        postRequest(str, map, map2, networkTimeOut, CONTENT_TYPE_JSON, httpResponseCallback);
    }

    public void rawGet(String str, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) {
        rawGet(str, new HashMap<>(), httpResponseCallback, networkTimeOut);
    }

    public void rawGet(String str, HashMap<String, String> map, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            FlyLog.getInstance().d("rawGet: " + str, new Object[0]);
            HttpURLConnection connection = getConnection(str, networkTimeOut);
            setHeader(connection, map);
            connection.setInstanceFollowRedirects(this.instanceFollowRedirects);
            connection.connect();
            if (isRedirects(connection)) {
                rawGet(connection.getHeaderField(m.a("008(hgfm_efkBfkfmCg")), new HashMap<>(), httpResponseCallback, networkTimeOut);
            } else if (httpResponseCallback != null) {
                try {
                    httpResponseCallback.onResponse(new HttpConnectionImpl23(connection));
                    connection.disconnect();
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        connection.disconnect();
                        throw th2;
                    }
                }
            } else {
                connection.disconnect();
            }
            FlyLog.getInstance().d("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
        } catch (Throwable th3) {
            handleNetworkError(th3);
            throw th3;
        }
    }
}
