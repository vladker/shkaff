package cn.fly.tcp.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.PointerIconCompat;
import cn.fly.FlySDK;
import cn.fly.commons.FlyProduct;
import cn.fly.commons.a.l;
import cn.fly.commons.ac;
import cn.fly.commons.ad;
import cn.fly.commons.ae;
import cn.fly.commons.j;
import cn.fly.commons.o;
import cn.fly.mcl.BusinessCallBack;
import cn.fly.mcl.BusinessMessageCallback;
import cn.fly.mcl.BusinessMessageListener;
import cn.fly.mcl.TcpStatus;
import cn.fly.mcl.TcpStatusListener;
import cn.fly.mgs.OnIdChangeListener;
import cn.fly.tools.network.NetworkHelper;
import cn.fly.tools.utils.ActivityTracker;
import cn.fly.tools.utils.DH;
import cn.fly.tools.utils.Data;
import cn.fly.tools.utils.HashonHelper;
import cn.fly.tools.utils.UIHandler;
import cn.fly.tools.utils.i;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.math3.geometry.VectorFormat;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.poi.ss.usermodel.DateUtil;
import org.opencv.videoio.Videoio;

/* JADX INFO: loaded from: classes.dex */
public class h implements d {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static volatile h f1555l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f1556a;
    public String b;
    public ArrayList<String> d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f1558g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1559h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1560i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f1561j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f1562k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private NetworkHelper f1563m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private HashonHelper f1564n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private f f1565o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f1566p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f1567q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Context f1568r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private HashMap<Integer, HashSet<BusinessMessageListener>> f1569s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f1570t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private cn.fly.tcp.a.b f1571u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private TcpStatusListener f1572v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private TcpStatus f1573w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private OnIdChangeListener f1574x;
    public AtomicLong c = new AtomicLong(0);
    public int e = 270;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1557f = Videoio.CAP_QT;

    private h() {
        cn.fly.tcp.a.c.a().b("TP tpHelper init");
        this.f1565o = new f(this);
        this.f1563m = new NetworkHelper();
        this.f1564n = new HashonHelper();
        this.f1569s = new HashMap<>();
        this.f1571u = new cn.fly.tcp.a.b(FlySDK.getContext());
        this.f1568r = FlySDK.getContext();
    }

    public static h b() {
        if (f1555l == null) {
            synchronized (h.class) {
                try {
                    if (f1555l == null) {
                        f1555l = new h();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f1555l;
    }

    private String h() {
        ArrayList<FlyProduct> arrayListB = ad.b();
        HashMap<String, Object> mapB = o.a().b();
        StringBuilder sb = new StringBuilder("COMMON;" + FlySDK.SDK_VERSION_CODE);
        int size = arrayListB.size();
        for (int i5 = 0; i5 < size; i5++) {
            try {
                FlyProduct flyProduct = arrayListB.get(i5);
                if (!TextUtils.equals(l.a("006*fehiididhifh"), flyProduct.getProductTag())) {
                    sb.append(",");
                    sb.append(flyProduct.getProductTag());
                    sb.append(";");
                    sb.append(flyProduct.getSdkver());
                    sb.append(";");
                    sb.append(mapB.get(flyProduct.getProductTag()));
                }
            } catch (Throwable unused) {
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (c()) {
            return;
        }
        j();
    }

    private void j() {
        cn.fly.tcp.a.f1524a.execute(new Runnable() { // from class: cn.fly.tcp.impl.h.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (h.this.c()) {
                        return;
                    }
                    if (!h.this.d()) {
                        h.this.e();
                    }
                    h.this.a(new cn.fly.tools.utils.d<Boolean>() { // from class: cn.fly.tcp.impl.h.2.1
                        @Override // cn.fly.tools.utils.d
                        public void a(Boolean bool) {
                        }
                    });
                } catch (Throwable unused) {
                }
            }
        });
    }

    public boolean c() {
        f fVar = this.f1565o;
        return (fVar == null || !fVar.b() || this.c.get() == 0) ? false : true;
    }

    public boolean d() {
        ArrayList<String> arrayList;
        return this.f1558g && this.f1559h && !this.f1570t && (arrayList = this.d) != null && arrayList.size() > 0 && !TextUtils.isEmpty(this.b);
    }

    public void e() {
        boolean zBooleanValue;
        long jIntValue;
        if (TextUtils.isEmpty(this.f1567q) || this.f1568r == null) {
            cn.fly.tcp.a.c.a().b("TPH has not been initialized");
            return;
        }
        try {
            String strB = ae.b().b("tcp_config", (String) null);
            if (!TextUtils.isEmpty(strB)) {
                HashMap<String, Object> mapFromJson = HashonHelper.fromJson(strB);
                if (mapFromJson.containsKey("requestTimes")) {
                    Object obj = mapFromJson.get("requestTimes");
                    if (obj == null || !(obj instanceof Long)) {
                        jIntValue = (obj == null || !(obj instanceof Integer)) ? 0L : ((Integer) obj).intValue();
                    } else {
                        jIntValue = ((Long) obj).longValue();
                    }
                    if (jIntValue + DateUtil.DAY_MILLISECONDS > System.currentTimeMillis() && b().a(mapFromJson) && ae.b().b("use_config", true)) {
                        cn.fly.tcp.a.c.a().b("TP cfg src: cc" + strB);
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            cn.fly.tcp.a.c.a().b(th.getMessage());
        }
        try {
            cn.fly.tcp.a.c.a().b("TP cfg no cc");
            HashMap map = (HashMap) cn.fly.commons.c.a("sti", (Object) null);
            HashMap<String, Object> map2 = new HashMap<>();
            if (map == null || map.isEmpty() || PSIDManager.a().e()) {
                final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
                DH.requester(FlySDK.getContext()).checkNetworkAvailableForce(true).request(new DH.DHResponder() { // from class: cn.fly.tcp.impl.h.6
                    @Override // cn.fly.tools.utils.DH.DHResponder
                    public void onResponse(DH.DHResponse dHResponse) {
                        linkedBlockingQueue.offer(Boolean.valueOf(dHResponse.checkNetworkAvailableForce(new int[0])));
                    }
                });
                try {
                    zBooleanValue = ((Boolean) linkedBlockingQueue.poll(1000L, TimeUnit.MILLISECONDS)).booleanValue();
                } catch (Throwable th2) {
                    cn.fly.tcp.a.c.a().a(th2);
                    zBooleanValue = false;
                }
                cn.fly.tcp.a.c.a().b("TP cfg net: " + zBooleanValue);
                if (zBooleanValue) {
                    cn.fly.tcp.a.c.a().b("TP cfg src: init");
                    NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
                    networkTimeOut.readTimout = 10000;
                    networkTimeOut.connectionTimeout = 5000;
                    String str = "/tcp/config/init";
                    HashMap<String, Object> map3 = new HashMap<>();
                    map3.put(l.a("006ekk7fi@gCfd"), this.f1566p);
                    map3.put("pushId", PSIDManager.a().d());
                    map3.put("products", h());
                    if (ad.d() == 2) {
                        map3.put(l.a("004Sedehejed"), this.f1567q);
                        map3.put(l.a("006ekkkIfifk"), DH.SyncMtd.getPackageName());
                        str = "/tcp/config/v2/init";
                    }
                    String str2 = j.a().a("tcig") + str;
                    cn.fly.tcp.a.c.a().b("TP cf url : " + str2 + " -> bd : " + map3);
                    String strHttpPostNew = this.f1563m.httpPostNew(str2, map3, null, networkTimeOut);
                    cn.fly.tcp.a.c.a().b("TP cf url : " + str2 + " -> rp : " + strHttpPostNew);
                    map2 = HashonHelper.fromJson(strHttpPostNew);
                }
            } else {
                cn.fly.tcp.a.c.a().b("TP cfg src: g*f");
                map2.put(l.a("004d<eledGg"), 200);
                map2.put(l.a("0049ed4eje"), map);
            }
            if (map2.isEmpty()) {
                return;
            }
            map2.put("requestTimes", Long.valueOf(System.currentTimeMillis()));
            if (b().a(map2)) {
                ae.b().a("use_config", true);
                ae.b().a("tcp_config", HashonHelper.fromHashMap(map2));
            }
        } catch (Throwable th3) {
            cn.fly.tcp.a.c.a().b(th3.getMessage());
        }
    }

    public void f() {
        this.f1573w = null;
    }

    public void g() {
        if (TextUtils.isEmpty(this.f1561j) || this.f1562k <= 0) {
            String strB = ae.b().b("suid", "");
            long jB = ae.b().b("create_suid_time", 0L);
            if (TextUtils.isEmpty(strB)) {
                strB = UUID.randomUUID().toString();
            }
            if (jB <= 0) {
                jB = System.currentTimeMillis();
            }
            a(strB, jB);
        }
    }

    public boolean a() {
        return this.f1570t;
    }

    public void a(String str) {
        this.f1571u.b(str);
    }

    public void a(int i5, BusinessMessageListener businessMessageListener) {
        HashSet<BusinessMessageListener> hashSet;
        int i6;
        try {
            cn.fly.tcp.a.c.a().b("TP tpHelper addBMListener: bisType = " + i5 + ", listener = " + businessMessageListener);
            Integer numValueOf = Integer.valueOf(i5);
            if (businessMessageListener == null) {
                cn.fly.tcp.a.c.a().b("TP tpHelper addBMListener: remove key = " + numValueOf);
                this.f1569s.remove(numValueOf);
                return;
            }
            if (this.f1569s.containsKey(numValueOf)) {
                hashSet = this.f1569s.get(numValueOf);
            } else {
                hashSet = new HashSet<>();
                this.f1569s.put(numValueOf, hashSet);
            }
            hashSet.add(businessMessageListener);
            if (g.a().b()) {
                cn.fly.tcp.a.c.a().b("TP tpHelper addBMListener: has cached msg");
                List<Map<String, Object>> listC = g.a().c();
                ArrayList arrayList = new ArrayList();
                Iterator<Map<String, Object>> it = listC.iterator();
                while (true) {
                    i6 = 0;
                    if (!it.hasNext()) {
                        break;
                    }
                    Map<String, Object> next = it.next();
                    Object obj = next.get("bisType");
                    final int iIntValue = obj != null ? ((Integer) obj).intValue() : 0;
                    final String str = (String) next.get("workId");
                    final String str2 = (String) next.get(g.f1554a);
                    cn.fly.tcp.a.c.a().b("TP tpHelper addBMListener: cachedBisType = " + iIntValue + ", target bisType = " + numValueOf);
                    if (iIntValue == i5) {
                        for (final BusinessMessageListener businessMessageListener2 : hashSet) {
                            UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: cn.fly.tcp.impl.h.1
                                @Override // android.os.Handler.Callback
                                public boolean handleMessage(Message message) {
                                    if (businessMessageListener2 == null) {
                                        return false;
                                    }
                                    try {
                                        cn.fly.tcp.a.c.a().b("TP tpHelper addBMListener: callback to messageReceived. bisType: " + iIntValue + ", workId: " + str + ", msg: " + str2);
                                        businessMessageListener2.messageReceived(iIntValue, str, str2);
                                        return false;
                                    } catch (Throwable th) {
                                        cn.fly.tcp.a.c.a().a(th);
                                        return false;
                                    }
                                }
                            });
                        }
                        cn.fly.tcp.a.c.a().b("TP tpHelper addBMListener: mark msg to rm. msg = " + next);
                        arrayList.add(next);
                    }
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                int size = arrayList.size();
                while (i6 < size) {
                    Object obj2 = arrayList.get(i6);
                    i6++;
                    Map<String, Object> map = (Map) obj2;
                    cn.fly.tcp.a.c.a().b("TP tpHelper addBMListener: rm msg = " + map);
                    g.a().b(map);
                }
                return;
            }
            cn.fly.tcp.a.c.a().b("TP tpHelper addBMListener: no cached msg");
        } catch (Throwable th) {
            cn.fly.tcp.a.c.a().b("TP tpHelper addBMListener: error");
            cn.fly.tcp.a.c.a().a(th);
        }
    }

    public void b(final BusinessCallBack<Boolean> businessCallBack) {
        final boolean zC = c();
        UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: cn.fly.tcp.impl.h.5
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    BusinessCallBack businessCallBack2 = businessCallBack;
                    if (businessCallBack2 == null) {
                        return false;
                    }
                    businessCallBack2.callback(Boolean.valueOf(zC));
                    return false;
                } catch (Throwable th) {
                    cn.fly.tcp.a.c.a().a(th);
                    return false;
                }
            }
        });
    }

    private void b(cn.fly.tools.utils.d<String> dVar) {
        HashMap map = new HashMap();
        try {
            map.put(l.a("006ekkZfiIgDfd"), this.f1566p);
            map.put(l.a("006ekkkDfifk"), this.f1568r.getPackageName());
            map.put(l.a("004khej"), 1);
            map.put("pushId", PSIDManager.a().d());
            if (ad.d() == 2) {
                map.put(l.a("004Sedehejed"), this.f1567q);
            }
        } catch (Throwable th) {
            cn.fly.tcp.a.c.a().a(th);
        }
        String strFromHashMap = HashonHelper.fromHashMap(map);
        if (dVar != null) {
            dVar.a(strFromHashMap);
        }
    }

    private String b(String str, String str2) {
        return Base64.encodeToString(Data.AES128Encode(str, str2), 2);
    }

    private String b(long j6) {
        return String.format("%16s", Integer.valueOf(Math.abs(Arrays.hashCode(new long[]{j6})))).replaceAll(" ", "0").substring(0, 16);
    }

    private HashMap<String, Object> b(HashMap<String, Object> map) {
        return (a(map, l.a("004dJeled:g"), 0) == 200 && map.containsKey(l.a("004MedQeje"))) ? (HashMap) map.get(l.a("004SedHeje")) : new HashMap<>();
    }

    private HashMap<String, Object> b(String str) {
        HashMap<String, Object> map = new HashMap<>();
        try {
            if (TextUtils.isEmpty(str) || !str.startsWith(VectorFormat.DEFAULT_PREFIX)) {
                return map;
            }
            cn.fly.tcp.a.c.a().b(str);
            return b(HashonHelper.fromJson(str));
        } catch (Throwable th) {
            cn.fly.tcp.a.c.a().a(th);
            return map;
        }
    }

    public void b(TcpStatusListener tcpStatusListener) {
        if (this.f1572v == tcpStatusListener) {
            this.f1572v = null;
        }
    }

    public void b(TcpStatus tcpStatus) {
        TcpStatusListener tcpStatusListener = this.f1572v;
        if (tcpStatusListener != null) {
            TcpStatus tcpStatus2 = this.f1573w;
            if (tcpStatus2 != null) {
                tcpStatus = tcpStatus2;
            }
            tcpStatusListener.onStatus(tcpStatus);
            f();
        }
    }

    public void a(Context context, String str, String str2) {
        this.f1568r = context;
        this.f1566p = str;
        if (!TextUtils.isEmpty(str2)) {
            this.f1567q = str2;
        }
        ActivityTracker.getInstance(context).addTracker(cn.fly.tcp.c.a(new cn.fly.tcp.c.a() { // from class: cn.fly.tcp.impl.h.3
            @Override // cn.fly.tcp.c.a
            public void a() {
                h.this.i();
            }

            @Override // cn.fly.tcp.c.a
            public void b() {
                h.this.i();
            }
        }));
        this.f1571u.a();
    }

    public HashMap<String, Object> a(String str, String str2, int i5) throws TimeoutException, IOException {
        if (this.f1565o == null) {
            return null;
        }
        cn.fly.tcp.a.c cVarA = cn.fly.tcp.a.c.a();
        StringBuilder sbU = androidx.collection.a.u("TP rg main = ", str, " , bo = ", str2, " , out = ");
        sbU.append(i5);
        cVarA.b(sbU.toString());
        String[] strArrSplit = str.split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        this.f1565o.a(new InetSocketAddress(strArrSplit[0], Integer.parseInt(strArrSplit[1])), true, true, 5000);
        e eVar = new e(1001, b(this.b, str2));
        eVar.c = this.f1556a;
        e eVar2 = this.f1565o.a(eVar).get(i5, TimeUnit.MILLISECONDS);
        if (eVar2 != null && eVar2.b == 1000) {
            String strA = a(this.b, eVar2.d);
            eVar2.d = strA;
            return b(strA);
        }
        cn.fly.tcp.a.c.a().b("TP rp : " + eVar2);
        return null;
    }

    public HashMap<String, Object> a(int i5, int i6, String str) {
        e eVar;
        if (this.f1565o == null) {
            return null;
        }
        try {
            String strB = b(this.c.get());
            cn.fly.tcp.a.c.a().b("TP sd ty = " + i5 + " , bo = " + str + " , out = " + i6);
            if (TextUtils.isEmpty(str)) {
                eVar = new e(i5);
            } else {
                eVar = new e(i5, b(strB, str));
            }
            c cVarA = this.f1565o.a(eVar);
            if (cVarA != null) {
                e eVar2 = cVarA.get(i6, TimeUnit.MILLISECONDS);
                if (eVar2 != null && eVar2.b == 1000) {
                    String strA = a(strB, eVar2.d);
                    eVar2.d = strA;
                    return b(strA);
                }
                cn.fly.tcp.a.c.a().b("TP rp : " + eVar2);
                return null;
            }
            cn.fly.tcp.a.c.a().b("TP rp : null");
            return null;
        } catch (Throwable th) {
            cn.fly.tcp.a.c.a().a(th);
            return null;
        }
    }

    private c a(long j6) {
        if (this.f1565o == null) {
            return null;
        }
        try {
            e eVar = new e(GeofenceStatusCodes.GEOFENCE_REQUEST_TOO_FREQUENT);
            eVar.c = j6;
            c cVarA = this.f1565o.a(eVar);
            cn.fly.tcp.a.c.a().b("TP sd ty = " + eVar.b + " , u = " + j6 + " bo : " + eVar.d);
            return cVarA;
        } catch (Throwable th) {
            cn.fly.tcp.a.c.a().a(th);
            return null;
        }
    }

    private void a(long j6, boolean z6) {
        if (this.f1565o != null) {
            try {
                String strB = b(this.c.get());
                HashMap map = new HashMap();
                map.put("repeat", Boolean.valueOf(z6));
                String strFromHashMap = HashonHelper.fromHashMap(map);
                e eVar = new e(PointerIconCompat.TYPE_CROSSHAIR, b(strB, strFromHashMap));
                eVar.c = j6;
                this.f1565o.a(eVar);
                cn.fly.tcp.a.c.a().b("TP sd ty = " + eVar.b + " , u = " + j6 + " bo : " + strFromHashMap);
            } catch (Throwable th) {
                cn.fly.tcp.a.c.a().a(th);
            }
        }
    }

    public boolean a(int i5, int i6) {
        if (i6 >= 4) {
            return false;
        }
        if (a(1002, i5, (String) null) != null) {
            return true;
        }
        if (i6 != 0 && i6 != 1) {
            a(3000, i6 + 1);
            return false;
        }
        a(1000, i6 + 1);
        return false;
    }

    public void a(BusinessCallBack<Boolean> businessCallBack) {
        boolean zC = c();
        if (businessCallBack != null) {
            businessCallBack.callback(Boolean.valueOf(zC));
        }
        if (zC) {
            return;
        }
        cn.fly.tcp.a.f1524a.execute(new Runnable() { // from class: cn.fly.tcp.impl.h.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (!h.b().d()) {
                        h.b().e();
                    }
                    h.this.a(new cn.fly.tools.utils.d<Boolean>() { // from class: cn.fly.tcp.impl.h.4.1
                        @Override // cn.fly.tools.utils.d
                        public void a(Boolean bool) {
                        }
                    });
                } catch (Throwable unused) {
                }
            }
        });
    }

    private boolean a(HashMap<String, Object> map) {
        try {
            this.f1560i = false;
            HashMap<String, Object> mapB = b(map);
            if (mapB.containsKey("domains") && mapB.containsKey("uniqueId") && mapB.containsKey("uniqueKey")) {
                this.d = (ArrayList) mapB.get("domains");
                this.f1556a = ((Long) mapB.get("uniqueId")).longValue();
                this.b = (String) mapB.get("uniqueKey");
                this.e = a(mapB, "tick", this.e);
                this.f1558g = a(mapB, "globalSwitch", 0) == 1;
                this.f1559h = a(mapB, "connectSwitch", 0) == 1;
                this.f1557f = a(mapB, "wr", this.f1557f);
                if (mapB.containsKey("determineDomain")) {
                    String str = (String) mapB.get("determineDomain");
                    if (!TextUtils.isEmpty(str)) {
                        if (this.d == null) {
                            this.d = new ArrayList<>();
                        }
                        this.d.remove(str);
                        this.d.add(0, str);
                    }
                }
                ArrayList<String> arrayList = this.d;
                if (arrayList != null && arrayList.size() > 0 && !TextUtils.isEmpty(this.b)) {
                    cn.fly.tcp.a.c.a().b("tp cfg load: s");
                    return true;
                }
            }
        } catch (Throwable th) {
            cn.fly.tcp.a.c.a().a(th);
        }
        cn.fly.tcp.a.c.a().b("tp cfg load: f");
        return false;
    }

    public void a(cn.fly.tools.utils.d<Boolean> dVar) {
        a(5000, dVar);
    }

    public synchronized void a(final int i5, final cn.fly.tools.utils.d<Boolean> dVar) {
        try {
            if (d()) {
                b(new cn.fly.tools.utils.d<String>() { // from class: cn.fly.tcp.impl.h.7
                    @Override // cn.fly.tools.utils.d
                    public void a(String str) {
                        h hVar = h.this;
                        boolean zA = hVar.a(hVar.f1560i, hVar.d.get(0), 0, str, i5);
                        cn.fly.tools.utils.d dVar2 = dVar;
                        if (dVar2 != null) {
                            dVar2.a(Boolean.valueOf(zA));
                        }
                    }
                });
            } else {
                b().a(TcpStatus.obtain(21).setDetailedMsg("unavailable(global: " + this.f1558g + ", connect: " + this.f1559h + ", forceClose:" + this.f1570t + ")"));
                if (dVar != null) {
                    dVar.a(Boolean.FALSE);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean a(boolean z6, String str, int i5, String str2, int i6) {
        String message;
        try {
            if (i5 < this.d.size() && i5 < 3) {
                cn.fly.tcp.a.c.a().b("TP rg domain : " + str + " count : " + i5);
                try {
                    HashMap<String, Object> mapA = a(str, str2, i6);
                    if (mapA != null && mapA.containsKey(l.a("004jQfd'kg"))) {
                        int iIntValue = ((Integer) mapA.get(l.a("004jOfd(kg"))).intValue();
                        if (iIntValue == 1 && mapA.containsKey(l.a("005j:elfi$gf"))) {
                            this.c.set(((Long) mapA.get(l.a("005j,elfi$gf"))).longValue());
                            b.a().b();
                            cn.fly.tcp.a.c.a().a("TP register success");
                            PSIDManager.a().f();
                            b().a(TcpStatus.obtain(10));
                            return true;
                        }
                        if (iIntValue == 2 && mapA.containsKey(l.a("006Tedeleg^e[ej7f"))) {
                            String str3 = (String) mapA.get(l.a("006Kedeleg,e3ej;f"));
                            if (!TextUtils.isEmpty(str3)) {
                                return a(true, str3, 2, str2, i6);
                            }
                        } else if (iIntValue == 3) {
                            this.f1570t = true;
                            this.f1565o.a();
                            PSIDManager.a().f();
                            b().a(TcpStatus.obtain(24).setDetailedMsg("Connection out of limit"));
                            return false;
                        }
                    }
                } catch (Throwable th) {
                    cn.fly.tcp.a.c.a().b("TP register exp : " + th.getMessage());
                }
                int i7 = i5 + 1;
                if (i7 < this.d.size() && !z6) {
                    return a(false, this.d.get(i7), i7, str2, i6);
                }
            }
            message = null;
            ae.b().a("tcp_config", (String) null);
            this.d = null;
        } catch (Throwable th2) {
            message = th2.getMessage();
            cn.fly.tcp.a.c.a().a(th2);
        }
        PSIDManager.a().f();
        b().a(TcpStatus.obtain(24).setDetailedMsg("Exception: " + message));
        return false;
    }

    @Override // cn.fly.tcp.impl.d
    public void a(a aVar, e eVar) {
        try {
            c cVarA = a(eVar.c);
            if (TextUtils.isEmpty(eVar.d)) {
                return;
            }
            if (this.c.get() == 0) {
                cn.fly.tcp.a.c.a().b("rcv pu5h msg, but send token is 0");
                return;
            }
            eVar.d = a(b(this.c.get()), eVar.d);
            int i5 = eVar.b;
            if (i5 != 9001) {
                if (i5 != 9002) {
                    if (i5 == 9004) {
                        cn.fly.tcp.a.c.a().b("trans-msg msgType: " + eVar.b + " body = " + eVar.d);
                        return;
                    }
                    return;
                }
                cn.fly.tcp.a.c.a().b("redir-msg msgType: " + eVar.b + " body = " + eVar.d);
                final String str = (String) b(eVar.d).get(l.a("006Ledeleg1e^ejTf"));
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.f1560i = true;
                b(new cn.fly.tools.utils.d<String>() { // from class: cn.fly.tcp.impl.h.8
                    @Override // cn.fly.tools.utils.d
                    public void a(String str2) {
                        h.this.a(true, str, 2, str2, 5000);
                    }
                });
                return;
            }
            cn.fly.tcp.a.c.a().b("pu5h-msg msgType: " + eVar.b + " body = " + eVar.d);
            HashMap<String, Object> mapB = b(eVar.d);
            if (mapB.containsKey(l.a("004*ed@eje"))) {
                int iA = a(mapB, "expire", 0);
                String str2 = (String) mapB.get("workId");
                String str3 = (String) mapB.get(l.a("004;edAeje"));
                boolean z6 = a(mapB, "needRepeat", 0) == 1;
                int iA2 = a(mapB, l.a("004j8fd9kg"), 0);
                if (iA2 != 1 && iA2 != 2) {
                    cn.fly.tcp.a.c.a().b("innermsg-pu5h msgType: " + eVar.b + " data = " + str3);
                    boolean zA = a(eVar.c, str2, iA, iA2, str3, cVarA);
                    if (z6) {
                        a(eVar.c, zA);
                        return;
                    }
                    return;
                }
                cn.fly.tcp.a.c.a().b("innermsg-mlp msgType: " + eVar.b + " data = " + str3);
            }
        } catch (Throwable th) {
            cn.fly.tcp.a.c.a().a(th);
        }
    }

    private synchronized boolean a(String str, int i5) {
        if (i5 != 0) {
            if (!TextUtils.isEmpty(str)) {
                if (System.currentTimeMillis() <= this.f1571u.a(str)) {
                    return true;
                }
                this.f1571u.a(str, System.currentTimeMillis() + ((long) (i5 * 1000)));
            }
        }
        return false;
    }

    public boolean a(final long j6, final String str, int i5, final int i6, final String str2, final c cVar) {
        try {
            if (a(str, i5)) {
                return true;
            }
            ac.f1261a.execute(new i() { // from class: cn.fly.tcp.impl.h.9
                @Override // cn.fly.tools.utils.i
                public void a() {
                    e eVar;
                    int i7;
                    c cVar2 = cVar;
                    if (cVar2 != null) {
                        try {
                            eVar = cVar2.get(h.this.f1557f, TimeUnit.MILLISECONDS);
                        } catch (Throwable th) {
                            cn.fly.tcp.a.c.a().a(th);
                            eVar = null;
                        }
                        if (eVar == null || eVar.b != 1000) {
                            cn.fly.tcp.a.c.a().b("TP rp : " + eVar);
                            i7 = 0;
                        } else {
                            cn.fly.tcp.a.c.a().b("TP rp acked: ");
                            i7 = 1;
                        }
                    } else {
                        i7 = 0;
                    }
                    h.this.a(j6, str, i6, str2, i7);
                }
            });
            return false;
        } catch (Throwable th) {
            cn.fly.tcp.a.c.a().a(th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j6, final String str, int i5, String str2, final int i6) {
        try {
            HashMap mapFromJson = HashonHelper.fromJson(str2);
            mapFromJson.put("uniqueId", Long.valueOf(j6));
            final String strFromHashMap = HashonHelper.fromHashMap(mapFromJson);
            final Integer numValueOf = Integer.valueOf(i5);
            if (this.f1569s.containsKey(numValueOf)) {
                cn.fly.tcp.a.c.a().b("[dealBusinessMsg]TP Biz msg listener detected, callback directly. bisType: " + numValueOf);
                for (final BusinessMessageListener businessMessageListener : this.f1569s.get(numValueOf)) {
                    UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: cn.fly.tcp.impl.h.10
                        @Override // android.os.Handler.Callback
                        public boolean handleMessage(Message message) {
                            try {
                                BusinessMessageListener businessMessageListener2 = businessMessageListener;
                                if (businessMessageListener2 != null) {
                                    if (businessMessageListener2 instanceof BusinessMessageCallback) {
                                        cn.fly.tcp.a.c.a().b("[dealBusinessMsg]TP callback to messageReceived with st. bisType: " + numValueOf + ", workId: " + str + ", msg: " + strFromHashMap);
                                        ((BusinessMessageCallback) businessMessageListener).messageReceived(i6, numValueOf.intValue(), str, strFromHashMap);
                                    } else {
                                        cn.fly.tcp.a.c.a().b("[dealBusinessMsg]TP callback to messageReceived. bisType: " + numValueOf + ", workId: " + str + ", msg: " + strFromHashMap);
                                        businessMessageListener.messageReceived(numValueOf.intValue(), str, strFromHashMap);
                                    }
                                }
                                return false;
                            } catch (Throwable th) {
                                cn.fly.tcp.a.c.a().a(th);
                                return false;
                            }
                        }
                    });
                }
                return;
            }
            cn.fly.tcp.a.c.a().b("[dealBusinessMsg]TP No biz msg listener detected, cache msg. bisType: " + numValueOf);
            HashMap map = new HashMap();
            map.put("bisType", numValueOf);
            map.put("workId", str);
            map.put(g.f1554a, strFromHashMap);
            g.a().a(map);
        } catch (Throwable th) {
            cn.fly.tcp.a.c.a().a(th);
        }
    }

    @Override // cn.fly.tcp.impl.d
    public void a(a aVar, Throwable th) {
        cn.fly.tcp.a.c cVarA = cn.fly.tcp.a.c.a();
        StringBuilder sb = new StringBuilder("TP exceptionCaught : ");
        sb.append(th != null ? th.getMessage() : "");
        cVarA.b(sb.toString());
    }

    @Override // cn.fly.tcp.impl.d
    public void a(a aVar) {
        cn.fly.tcp.a.c.a().b("TP sessionOpened");
    }

    @Override // cn.fly.tcp.impl.d
    public void a(a aVar, boolean z6) {
        cn.fly.tcp.a.c.a().b("TP sessionClosed " + z6);
        b.a().c();
        if (z6) {
            j();
        }
    }

    public String a(String str, String str2) {
        return Data.AES128Decode(str, Base64.decode(str2, 2));
    }

    public static int a(HashMap<String, Object> map, String str, int i5) {
        if (map != null && map.containsKey(str)) {
            Object obj = map.get(str);
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
        }
        return i5;
    }

    public void a(TcpStatusListener tcpStatusListener) {
        cn.fly.tcp.a.c.a().b("reg TpSt lis. prev: " + this.f1572v + ", curr: " + tcpStatusListener);
        this.f1572v = tcpStatusListener;
    }

    public void a(TcpStatus tcpStatus) {
        this.f1573w = tcpStatus;
    }

    public synchronized void a(String str, long j6) {
        try {
            if (this.f1574x != null && !String.valueOf(this.f1561j).equals(str)) {
                this.f1574x.onChanged(this.f1561j, str);
            }
            this.f1561j = str;
            this.f1562k = j6;
            ae.b().a("suid", this.f1561j);
            ae.b().a("create_suid_time", this.f1562k);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void a(OnIdChangeListener onIdChangeListener) {
        this.f1574x = onIdChangeListener;
    }
}
