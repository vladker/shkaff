package cn.fly.tools.network;

import A3.AbstractC0157z;
import android.os.Handler;
import android.os.Message;
import android.util.Base64;
import androidx.collection.a;
import cn.fly.FlySDK;
import cn.fly.commons.C0396r;
import cn.fly.commons.FlyProduct;
import cn.fly.commons.ad;
import cn.fly.commons.f;
import cn.fly.commons.q;
import cn.fly.commons.x;
import cn.fly.tools.FlyLog;
import cn.fly.tools.b.c;
import cn.fly.tools.log.NLog;
import cn.fly.tools.proguard.PublicMemberKeeper;
import cn.fly.tools.utils.Data;
import cn.fly.tools.utils.FlyRSA;
import cn.fly.tools.utils.HashonHelper;
import cn.fly.tools.utils.UIHandler;
import cn.fly.tools.utils.i;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPOutputStream;
import org.apache.commons.math3.optimization.direct.CMAESOptimizer;

/* JADX INFO: loaded from: classes.dex */
public class NetCommunicator implements PublicMemberKeeper {
    public static final String KEY_DUID_PREVIOUS = "duidPrevious";
    public static final String KEY_IS_MODIFIED = "isModified";
    private BigInteger b;
    private BigInteger c;
    private FlyRSA d;
    private NetworkHelper e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private NetworkHelper.NetworkTimeOut f1808f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ThreadPoolExecutor f1809g;
    public static final String KEY_DUID = x.b("004Ncbcfchcb");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadPoolExecutor f1807a = new ThreadPoolExecutor(3, 20, 60, TimeUnit.SECONDS, new LinkedBlockingDeque());

    public static class NetworkError extends Exception implements PublicMemberKeeper {
        private static final long serialVersionUID = -8447657431687664787L;

        public NetworkError(String str) {
            super(str);
        }
    }

    public NetCommunicator(int i5, String str, String str2) {
        this(i5, str, str2, null);
    }

    public static String checkHRU(String str) {
        return C0396r.b(str, true);
    }

    public static String checkHttpRequestUrl(String str) {
        return C0396r.b(str);
    }

    public static String dynaMU(String str) {
        return C0396r.a(str, true);
    }

    public static String dynamicModifyUrl(String str) {
        return C0396r.a(str);
    }

    public static HashMap<String, String> getCommonDefaultHeaders() {
        HashMap<String, String> map = new HashMap<>();
        map.put(x.b("003Wdg)e,db"), q.a());
        map.put(x.b("0137djehIeJcigjddcb(edh]ch$hRdb"), ad.e());
        map.put(x.b("004Gcecjchcb"), c.a(FlySDK.getContext()).d().ap());
        return map;
    }

    public static synchronized String getDUID(FlyProduct flyProduct) {
        return f.a(flyProduct);
    }

    public static synchronized HashMap<String, Object> getDUIDWithModifyInfo(FlyProduct flyProduct) {
        return f.b(flyProduct);
    }

    public <T> void request(HashMap<String, Object> map, String str, boolean z6, Callback<T> callback) {
        request(true, null, map, str, z6, callback);
    }

    public <T> T requestSynchronized(HashMap<String, Object> map, String str, boolean z6) {
        return (T) requestSynchronized((HashMap<String, String>) null, map, str, z6);
    }

    public String requestSynchronizedGet(String str, HashMap<String, Object> map, HashMap<String, String> map2) {
        return this.e.httpGetNew(str, map, map2, this.f1808f);
    }

    public <T> T requestWithoutEncode(boolean z6, HashMap<String, String> map, HashMap<String, Object> map2, String str, boolean z7) {
        return (T) a(z6, map, a(map2), str, true, false, z7);
    }

    public void setThreadPool(ThreadPoolExecutor threadPoolExecutor) {
        this.f1809g = threadPoolExecutor;
    }

    public NetCommunicator(int i5, String str, String str2, NetworkHelper.NetworkTimeOut networkTimeOut) {
        this.d = new FlyRSA(i5);
        this.b = new BigInteger(str, 16);
        this.c = new BigInteger(str2, 16);
        this.e = new NetworkHelper();
        if (networkTimeOut != null) {
            this.f1808f = networkTimeOut;
        } else {
            NetworkHelper.NetworkTimeOut networkTimeOut2 = new NetworkHelper.NetworkTimeOut();
            this.f1808f = networkTimeOut2;
            networkTimeOut2.readTimout = CMAESOptimizer.DEFAULT_MAXITERATIONS;
            networkTimeOut2.connectionTimeout = 5000;
        }
        this.f1809g = f1807a;
    }

    public <T> void request(HashMap<String, String> map, HashMap<String, Object> map2, String str, boolean z6, Callback<T> callback) {
        request(true, map, map2, str, z6, callback);
    }

    public <T> T requestSynchronized(HashMap<String, String> map, HashMap<String, Object> map2, String str, boolean z6) {
        return (T) requestSynchronized(true, map, map2, str, z6);
    }

    private String a(HashMap<String, Object> map) {
        if (map == null) {
            return "{}";
        }
        String strFromHashMap = HashonHelper.fromHashMap(map);
        return strFromHashMap.length() == 0 ? "{}" : strFromHashMap;
    }

    public <T> void request(final boolean z6, final HashMap<String, String> map, final HashMap<String, Object> map2, final String str, final boolean z7, final Callback<T> callback) {
        this.f1809g.execute(new i() { // from class: cn.fly.tools.network.NetCommunicator.1
            @Override // cn.fly.tools.utils.i
            public void a() {
                try {
                    final Object objRequestSynchronized = NetCommunicator.this.requestSynchronized(z6, map, map2, str, z7);
                    if (callback != null) {
                        UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: cn.fly.tools.network.NetCommunicator.1.1
                            @Override // android.os.Handler.Callback
                            public boolean handleMessage(Message message) {
                                callback.onResultOk(objRequestSynchronized);
                                return false;
                            }
                        });
                    }
                } catch (Throwable th) {
                    FlyLog.getInstance().d(th);
                    if (callback != null) {
                        UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: cn.fly.tools.network.NetCommunicator.1.2
                            @Override // android.os.Handler.Callback
                            public boolean handleMessage(Message message) {
                                callback.onResultError(th);
                                return false;
                            }
                        });
                    }
                }
            }
        });
    }

    public <T> T requestSynchronized(String str, String str2, boolean z6) {
        return (T) requestSynchronized((HashMap<String, String>) null, str, str2, z6);
    }

    public <T> T requestSynchronized(HashMap<String, String> map, String str, String str2, boolean z6) {
        return (T) requestSynchronized(true, map, str, str2, z6);
    }

    public <T> T requestSynchronized(boolean z6, HashMap<String, String> map, HashMap<String, Object> map2, String str, boolean z7) {
        return (T) a(z6, map, a(map2), str, z7, true, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> T a(boolean z6, HashMap<String, String> map, String str, String str2, boolean z7, boolean z8, boolean z9) throws Throwable {
        String str3;
        byte[] bArrC = C0396r.c();
        byte[] bArrA = a(bArrC, str, z7);
        String[] strArr = new String[1];
        HttpResponseCallback httpResponseCallbackA = a(bArrC, strArr, z9);
        if (z8) {
            String strEncodeToString = Base64.encodeToString(bArrA, 2);
            HashMap<String, String> mapA = a(z6, map, str, strEncodeToString.getBytes("utf-8").length);
            StringPart stringPart = new StringPart();
            stringPart.append(strEncodeToString);
            NLog flyLog = FlyLog.getInstance();
            StringBuilder sbU = a.u(">>>  request(", str2, "): ", str, "\nheader = ");
            sbU.append(mapA.toString());
            flyLog.d(sbU.toString(), new Object[0]);
            str3 = str2;
            this.e.rawPost(str3, mapA, stringPart, -1, httpResponseCallbackA, this.f1808f);
        } else {
            HashMap<String, String> mapA2 = a(z6, map, str, -1);
            NLog flyLog2 = FlyLog.getInstance();
            StringBuilder sbU2 = a.u(">>>  request(", str2, "): ", str, "\nheader = ");
            sbU2.append(mapA2.toString());
            flyLog2.d(sbU2.toString(), new Object[0]);
            str3 = str2;
            this.e.httpPostWithBytes(str3, bArrA, mapA2, -1, httpResponseCallbackA, this.f1808f);
        }
        if (strArr[0] == 0) {
            return null;
        }
        NLog flyLog3 = FlyLog.getInstance();
        StringBuilder sbY = AbstractC0157z.y(">>> response(", str3, "): ");
        sbY.append(strArr[0]);
        flyLog3.d(sbY.toString(), new Object[0]);
        if (z9) {
            return (T) a(strArr[0]);
        }
        return (T) strArr[0];
    }

    public <T> T requestSynchronized(boolean z6, HashMap<String, String> map, String str, String str2, boolean z7) {
        return (T) a(z6, map, str, str2, z7, true, true);
    }

    public static class Callback<T> implements PublicMemberKeeper {
        public void onResultError(Throwable th) {
        }

        public void onResultOk(T t6) {
        }
    }

    public void addTcpIntercept(String str) {
    }

    public void removeTcpIntercept(String str) {
    }

    private byte[] a(byte[] bArr, String str, boolean z6) throws Throwable {
        byte[] bytes;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        GZIPOutputStream gZIPOutputStream;
        Closeable closeable = null;
        if (z6) {
            try {
                byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream2);
                    try {
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(gZIPOutputStream);
                        try {
                            bufferedOutputStream.write(str.getBytes("utf-8"));
                            bufferedOutputStream.flush();
                            C0396r.a(bufferedOutputStream, gZIPOutputStream, byteArrayOutputStream2);
                            bytes = byteArrayOutputStream2.toByteArray();
                        } catch (Throwable th) {
                            th = th;
                            closeable = bufferedOutputStream;
                            C0396r.a(closeable, gZIPOutputStream, byteArrayOutputStream2);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    gZIPOutputStream = null;
                }
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream2 = null;
                gZIPOutputStream = null;
            }
        } else {
            bytes = str.getBytes("utf-8");
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                try {
                    byte[] bArrEncode = this.d.encode(bArr, this.b, this.c);
                    dataOutputStream.writeInt(bArrEncode.length);
                    dataOutputStream.write(bArrEncode);
                    byte[] bArrAES128Encode = Data.AES128Encode(bArr, bytes);
                    dataOutputStream.writeInt(bArrAES128Encode.length);
                    dataOutputStream.write(bArrAES128Encode);
                    dataOutputStream.flush();
                    C0396r.a(dataOutputStream, byteArrayOutputStream);
                    return byteArrayOutputStream.toByteArray();
                } catch (Throwable th5) {
                    th = th5;
                    closeable = dataOutputStream;
                    C0396r.a(closeable, byteArrayOutputStream);
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Throwable th7) {
            th = th7;
            byteArrayOutputStream = null;
        }
    }

    private HashMap<String, String> a(boolean z6, HashMap<String, String> map, String str, int i5) {
        HashMap<String, String> map2;
        if (!z6) {
            map2 = null;
        } else if (i5 > 0) {
            map2 = a(str, i5);
        } else {
            map2 = getCommonDefaultHeaders();
        }
        if (map2 == null) {
            map2 = new HashMap<>();
        }
        if (map != null) {
            map2.putAll(map);
        }
        return map2;
    }

    private HashMap<String, String> a(String str, int i5) {
        HashMap<String, String> commonDefaultHeaders = getCommonDefaultHeaders();
        String strB = x.b("004*ehchdiTd");
        StringBuilder sbR = a.r(str);
        sbR.append(FlySDK.getAppSecret());
        commonDefaultHeaders.put(strB, Data.MD5(sbR.toString()));
        commonDefaultHeaders.put(x.b("014ZdccjDdhedh(gjed ed4diZhg"), String.valueOf(i5));
        return commonDefaultHeaders;
    }

    private HttpResponseCallback a(final byte[] bArr, final String[] strArr, final boolean z6) {
        return new HttpResponseCallback() { // from class: cn.fly.tools.network.NetCommunicator.2
            @Override // cn.fly.tools.network.HttpResponseCallback
            public void onResponse(HttpConnection httpConnection) throws Throwable {
                InputStream inputStream;
                int responseCode = httpConnection.getResponseCode();
                ByteArrayOutputStream byteArrayOutputStream = null;
                try {
                    inputStream = responseCode == 200 ? httpConnection.getInputStream() : httpConnection.getErrorStream();
                    try {
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                        try {
                            byte[] bArr2 = new byte[1024];
                            for (int i5 = inputStream.read(bArr2); i5 != -1; i5 = inputStream.read(bArr2)) {
                                byteArrayOutputStream2.write(bArr2, 0, i5);
                            }
                            byte[] byteArray = byteArrayOutputStream2.toByteArray();
                            if (responseCode != 200) {
                                HashMap mapFromJson = HashonHelper.fromJson(new String(byteArray, "utf-8"));
                                mapFromJson.put(x.b("010ghhiTdkVhch+cfeh"), Integer.valueOf(responseCode));
                                throw new NetworkError(HashonHelper.fromHashMap(mapFromJson));
                            }
                            if (z6) {
                                long jA = NetCommunicator.this.a(httpConnection);
                                if (jA == -1 || jA != byteArray.length) {
                                    HashMap map = new HashMap();
                                    map.put(x.b("010ghhiOdk%hchAcfeh"), Integer.valueOf(responseCode));
                                    map.put(x.b("006MehChch2cfeh"), -2);
                                    map.put(x.b("005eXcicicjci"), "Illegal content length");
                                    throw new NetworkError(HashonHelper.fromHashMap(map));
                                }
                                strArr[0] = NetCommunicator.this.a(bArr, byteArray);
                            } else {
                                strArr[0] = new String(byteArray, "utf-8");
                            }
                            C0396r.a(byteArrayOutputStream2, inputStream);
                        } catch (Throwable th) {
                            th = th;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            C0396r.a(byteArrayOutputStream, inputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long a(HttpConnection httpConnection) {
        List<String> listA = a(httpConnection, x.b("014=dccj%dhedh>gjed%ed1diUhg"));
        if (listA == null || listA.size() <= 0) {
            return -1L;
        }
        return Long.parseLong(listA.get(0));
    }

    private List<String> a(HttpConnection httpConnection, String str) {
        Map<String, List<String>> headerFields = httpConnection.getHeaderFields();
        if (headerFields == null || headerFields.isEmpty()) {
            return null;
        }
        for (String str2 : headerFields.keySet()) {
            if (str2 != null && str2.equals(str)) {
                return headerFields.get(str2);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(byte[] bArr, byte[] bArr2) {
        return new String(Data.AES128Decode(bArr, Base64.decode(bArr2, 2)), "utf-8");
    }

    private Object a(String str) throws NetworkError {
        if (str != null) {
            HashMap mapFromJson = HashonHelper.fromJson(str.trim());
            if (!mapFromJson.isEmpty()) {
                Object obj = mapFromJson.get(x.b("0034ciGe*eh"));
                return obj == null ? mapFromJson.get(x.b("004IcbSchc")) : obj;
            }
            HashMap map = new HashMap();
            map.put(x.b("0067eh hchGcfeh"), -1);
            map.put(x.b("005eFcicicjci"), "RS is empty");
            throw new NetworkError(HashonHelper.fromHashMap(map));
        }
        HashMap map2 = new HashMap();
        map2.put(x.b("006NehMhchAcfeh"), -1);
        map2.put(x.b("005eZcicicjci"), "RS is empty");
        throw new NetworkError(HashonHelper.fromHashMap(map2));
    }
}
