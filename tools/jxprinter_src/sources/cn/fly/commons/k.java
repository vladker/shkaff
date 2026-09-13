package cn.fly.commons;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import cn.fly.FlySDK;
import cn.fly.tools.FlyLog;
import cn.fly.tools.utils.DH;
import cn.fly.tools.utils.HashonHelper;
import cn.fly.tools.utils.ResHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.logging.log4j.message.StructuredDataId;
import org.apache.poi.ss.formula.functions.Complex;

/* JADX INFO: loaded from: classes.dex */
public class k {
    private static k b = new k();
    private volatile boolean c = false;
    private volatile long d = 0;
    private final ConcurrentHashMap<String, Object> e = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ConcurrentHashMap<String, Object> f1459f = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f1458a = new AtomicBoolean(false);

    private k() {
    }

    private boolean d() {
        long jB = cn.fly.tools.utils.h.a(FlySDK.getContext()).b("ncat", 0L);
        if (jB > 0) {
            if (System.currentTimeMillis() - jB <= 604800000) {
                return true;
            }
            cn.fly.tools.utils.h.a(FlySDK.getContext()).a("ncat");
        }
        return false;
    }

    private boolean e() {
        final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        DH.requester(FlySDK.getContext()).getCarrierStrict(false).request(new DH.DHResponder() { // from class: cn.fly.commons.k.2
            @Override // cn.fly.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                String carrierStrict = dHResponse.getCarrierStrict(new int[0]);
                if (!TextUtils.isEmpty(carrierStrict) && !TextUtils.equals(StructuredDataId.RESERVED, carrierStrict)) {
                    linkedBlockingQueue.offer(Boolean.valueOf(!carrierStrict.startsWith("460")));
                }
                linkedBlockingQueue.offer(Boolean.valueOf(!k.this.a(FlySDK.getContext())));
            }
        });
        try {
            Boolean bool = (Boolean) linkedBlockingQueue.poll(120L, TimeUnit.MILLISECONDS);
            return bool != null && bool.booleanValue();
        } catch (Throwable unused) {
        }
    }

    public boolean b() {
        return a(false);
    }

    public ConcurrentHashMap<String, Object> c() {
        return this.e;
    }

    private synchronized boolean b(boolean z6) {
        long jLongValue;
        String str;
        try {
            if (z6) {
                HashMap mapFromJson = HashonHelper.fromJson(ae.b().e());
                if (mapFromJson.isEmpty()) {
                    mapFromJson = HashonHelper.fromJson(ae.b().d());
                }
                jLongValue = ((Long) ResHelper.forceCast(mapFromJson.get(n.a("004dad:cg")), 5L)).longValue() * 1000;
                str = (String) ResHelper.forceCast(mapFromJson.get(n.a("002a ba")), n.a("006Vfcfcfdfdfdfd"));
            } else {
                jLongValue = ((Long) c.a(n.a("004dad9cg"), 5L)).longValue() * 1000;
                str = (String) c.a(n.a("002aVba"), n.a("006@fcfcfdfdfdfd"));
            }
            if (this.d != 0 && System.currentTimeMillis() - this.d <= jLongValue) {
                return this.c;
            }
            boolean z7 = a(str) || d();
            if (this.d == 0 || z7 != this.c) {
                c(z7);
            }
            this.d = System.currentTimeMillis();
            this.c = z7;
            return z7;
        } catch (Throwable th) {
            FlyLog.getInstance().e(th);
            return true;
        }
    }

    private void c(boolean z6) {
        HashMap map = new HashMap();
        map.put(n.a("005aedb(bh"), Integer.valueOf(!z6 ? 1 : 0));
        map.put(n.a("002]be)a"), ResHelper.forceCast(this.e.get(n.a("002]be)a")), 0));
        map.put(n.a("002Kbeba"), ResHelper.forceCast(this.e.get(n.a("002Kbeba")), 0));
        map.put(n.a("002YbbOh"), ResHelper.forceCast(this.e.get(n.a("002YbbOh")), 0));
        map.put(n.a("002Pde]h"), ResHelper.forceCast(this.e.get(n.a("002Pde]h")), 0));
        map.put(n.a("002$bh'g"), ResHelper.forceCast(this.e.get(n.a("002$bh'g")), 0));
        map.put(n.a("002@cg.h"), ResHelper.forceCast(this.e.get(n.a("002@cg.h")), 0));
        map.put("ncr", Integer.valueOf(d() ? 1 : 0));
        long jCurrentTimeMillis = System.currentTimeMillis();
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put(n.a("004gUca<hd"), "ECMT");
        map2.put(n.a("004+ba4bgb"), map);
        map2.put(n.a("0083ba4bgdgXbgbd9d"), Long.valueOf(jCurrentTimeMillis));
        d.a().a(jCurrentTimeMillis, map2);
    }

    public static k a() {
        return b;
    }

    public synchronized boolean a(boolean z6) {
        return !b(z6);
    }

    private boolean a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            char[] charArray = str.toCharArray();
            HashMap map = new HashMap();
            boolean zA = false;
            for (int i5 = 0; i5 < charArray.length; i5++) {
                char c = charArray[i5];
                if (c == '1') {
                    zA |= a(i5);
                } else if (c != '0') {
                    List arrayList = (List) map.get(Character.valueOf(c));
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(Integer.valueOf(i5));
                    map.put(Character.valueOf(charArray[i5]), arrayList);
                }
            }
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                Iterator it2 = ((List) ((Map.Entry) it.next()).getValue()).iterator();
                boolean zA2 = true;
                while (it2.hasNext()) {
                    zA2 &= a(((Integer) it2.next()).intValue());
                }
                zA |= zA2;
            }
            return zA;
        } catch (Throwable th) {
            FlyLog.getInstance().e(th);
            return true;
        }
    }

    private boolean a(final int i5) {
        final boolean[] zArr = {true};
        DH.RequestBuilder requestBuilderRequester = DH.requester(FlySDK.getContext());
        if (i5 == 0) {
            requestBuilderRequester.checkUA();
        } else if (i5 == 1) {
            requestBuilderRequester.usbEnable();
        } else if (i5 == 2) {
            requestBuilderRequester.vpn();
        } else if (i5 == 3) {
            requestBuilderRequester.isMwpy();
        } else if (i5 == 4) {
            requestBuilderRequester.isRooted();
        } else if (i5 == 5) {
            requestBuilderRequester.cx();
        }
        requestBuilderRequester.request(new DH.DHResponder() { // from class: cn.fly.commons.k.1
            @Override // cn.fly.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                int i6 = i5;
                if (i6 == 0) {
                    zArr[0] = dHResponse.checkUA();
                    k.this.e.put(n.a("002 be;a"), Integer.valueOf(zArr[0] ? 1 : 0));
                    return;
                }
                if (i6 == 1) {
                    zArr[0] = dHResponse.usbEnable();
                    k.this.e.put(n.a("002Nbeba"), Integer.valueOf(zArr[0] ? 1 : 0));
                    return;
                }
                if (i6 == 2) {
                    zArr[0] = dHResponse.vpn();
                    k.this.e.put(n.a("002XbbKh"), Integer.valueOf(zArr[0] ? 1 : 0));
                    return;
                }
                if (i6 == 3) {
                    zArr[0] = dHResponse.isMwpy();
                    k.this.e.put(n.a("002_de*h"), Integer.valueOf(zArr[0] ? 1 : 0));
                } else if (i6 == 4) {
                    zArr[0] = dHResponse.isRooted();
                    k.this.e.put(n.a("002$bh6g"), Integer.valueOf(zArr[0] ? 1 : 0));
                } else {
                    if (i6 != 5) {
                        return;
                    }
                    zArr[0] = dHResponse.cx();
                    k.this.e.put(n.a("002.cg_h"), Integer.valueOf(zArr[0] ? 1 : 0));
                }
            }
        });
        return zArr[0];
    }

    private boolean b(String str) {
        String strD = C0396r.d();
        int i5 = 0;
        if (TextUtils.isEmpty(strD) || strD.length() < str.length()) {
            return false;
        }
        String[] strArrSplit = strD.split("");
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList();
        boolean zEquals = false;
        for (int i6 = 0; i6 < charArray.length; i6++) {
            char c = charArray[i6];
            if (c == '1') {
                zEquals |= TextUtils.equals(strArrSplit[i6], "1");
            } else if (c == '2') {
                arrayList.add(Integer.valueOf(i6));
            }
        }
        if (arrayList.size() <= 0) {
            return zEquals;
        }
        int size = arrayList.size();
        boolean zEquals2 = true;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            zEquals2 &= TextUtils.equals(strArrSplit[((Integer) obj).intValue()], "1");
        }
        return zEquals | zEquals2;
    }

    public boolean a(HashMap<String, Object> map) {
        try {
            List<String> list = (List) ResHelper.forceCast(map.get(Complex.SUPPORTED_SUFFIX), null);
            if (list != null && list.size() > 0) {
                boolean zA = false;
                for (String str : list) {
                    if (str.contains(",")) {
                        boolean zA2 = true;
                        for (String str2 : str.split(",")) {
                            zA2 &= a(str2, map);
                        }
                        zA |= zA2;
                    } else {
                        zA |= a(str, map);
                    }
                }
                this.e.put(n.a("0068ch7hVbfbh6dDdg"), Boolean.valueOf(!zA));
                return !zA;
            }
        } catch (Throwable th) {
            FlyLog.getInstance().e(th);
        }
        this.e.put(n.a("006+chFh>bfbh,dYdg"), Boolean.TRUE);
        return true;
    }

    private boolean b(final ArrayList<Boolean> arrayList, final List<String> list) {
        DH.RequestBuilder requestBuilderRequester = DH.requester(FlySDK.getContext());
        if (list == null || list.size() == 0) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            requestBuilderRequester.isPackageInstalled(it.next());
        }
        final boolean[] zArr = {false};
        requestBuilderRequester.request(new DH.DHResponder() { // from class: cn.fly.commons.k.4
            @Override // cn.fly.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                for (int i5 = 0; i5 < list.size(); i5++) {
                    boolean zIsPackageInstalled = dHResponse.isPackageInstalled(i5);
                    arrayList.add(Boolean.valueOf(zIsPackageInstalled));
                    boolean[] zArr2 = zArr;
                    boolean z6 = zIsPackageInstalled | zArr2[0];
                    zArr2[0] = z6;
                    if (z6) {
                        return;
                    }
                }
            }
        });
        return zArr[0];
    }

    private boolean a(String str, HashMap<String, Object> map) {
        boolean z6 = false;
        if (TextUtils.equals(str, "a")) {
            if (((Integer) ResHelper.forceCast(map.get("a"), 0)).intValue() == 1 && e()) {
                z6 = true;
            }
            this.f1459f.put("a", Boolean.valueOf(z6));
            return z6;
        }
        if (TextUtils.equals(str, "p")) {
            List<String> list = (List) ResHelper.forceCast(map.get("p"), null);
            ArrayList<Boolean> arrayList = new ArrayList<>();
            boolean zB = b(arrayList, list);
            this.f1459f.put("p", arrayList);
            return zB;
        }
        if (TextUtils.equals(str, "fp")) {
            List<String> list2 = (List) ResHelper.forceCast(map.get("fp"), null);
            ArrayList<Boolean> arrayList2 = new ArrayList<>();
            boolean zB2 = b(arrayList2, list2);
            this.f1459f.put("fp", arrayList2);
            return zB2;
        }
        if (TextUtils.equals(str, "s")) {
            boolean zA = a(new ArrayList<>(), (List<String>) ResHelper.forceCast(map.get("s"), null));
            this.f1459f.put("s", Boolean.valueOf(zA));
            return zA;
        }
        if (TextUtils.equals(str, "fs")) {
            boolean zA2 = a(new ArrayList<>(), (List<String>) ResHelper.forceCast(map.get("fs"), null));
            this.f1459f.put("fs", Boolean.valueOf(zA2));
            return zA2;
        }
        if (TextUtils.equals(str, "d")) {
            if (((Integer) ResHelper.forceCast(map.get("d"), 0)).intValue() == 1 && cn.fly.tools.b.c.a(FlySDK.getContext()).d().aE()) {
                z6 = true;
            }
            this.f1459f.put("d", Boolean.valueOf(z6));
            return z6;
        }
        if (TextUtils.equals(str, "bl")) {
            boolean zB3 = b((String) ResHelper.forceCast(map.get("bl"), ""));
            this.f1459f.put("bl", Boolean.valueOf(zB3));
            return zB3;
        }
        if (!TextUtils.equals(str, "fda")) {
            return false;
        }
        boolean zA3 = s.a();
        this.f1459f.put("fda", Boolean.valueOf(zA3));
        return zA3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context) {
        Locale locale = context.getResources().getConfiguration().locale;
        return locale.getLanguage().startsWith("zh") && TextUtils.equals(locale.getCountry(), "CN");
    }

    private boolean a(ArrayList<Boolean> arrayList, final List<String> list) {
        final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        if (list != null && list.size() > 0) {
            DH.RequestBuilder requestBuilderRequester = DH.requester(FlySDK.getContext());
            for (int i5 = 0; i5 < list.size(); i5++) {
                requestBuilderRequester.queryIntentServices(new Intent(list.get(i5)), 0);
            }
            requestBuilderRequester.request(new DH.DHResponder() { // from class: cn.fly.commons.k.3
                @Override // cn.fly.tools.utils.DH.DHResponder
                public void onResponse(DH.DHResponse dHResponse) {
                    for (int i6 = 0; i6 < list.size(); i6++) {
                        List<ResolveInfo> listQueryIntentServices = dHResponse.queryIntentServices(i6);
                        if (listQueryIntentServices != null && listQueryIntentServices.size() > 0) {
                            linkedBlockingQueue.offer(Boolean.TRUE);
                        }
                    }
                    linkedBlockingQueue.offer(Boolean.FALSE);
                }
            });
        }
        try {
            Boolean bool = (Boolean) linkedBlockingQueue.poll(150L, TimeUnit.MILLISECONDS);
            return bool != null && bool.booleanValue();
        } catch (Throwable unused) {
        }
    }

    public void a(HashMap<String, Object> map, HashMap<String, Object> map2, HashMap<String, Object> map3) {
        try {
            Object obj = this.e.get(n.a("006d(bdbfbhWd8dg"));
            Boolean bool = Boolean.FALSE;
            Boolean bool2 = (Boolean) ResHelper.forceCast(obj, bool);
            boolean zBooleanValue = bool2.booleanValue();
            Boolean bool3 = (Boolean) ResHelper.forceCast(this.e.get(n.a("006(ch-hDbfbhNdRdg")), bool);
            boolean zBooleanValue2 = bool3.booleanValue();
            HashMap map4 = new HashMap(4);
            map4.put(n.a("003Qbh6dBdg"), bool2);
            map4.put(n.a("003]bhbgba"), ResHelper.forceCast(map.get(n.a("003]bhbgba")), null));
            if (!zBooleanValue && map2 != null) {
                map4.put(n.a("003_dgbgba"), ResHelper.forceCast(map2.get(n.a("003_dgbgba")), null));
            } else {
                map4.put(n.a("003>dgbgba"), ResHelper.forceCast(map.get(n.a("003>dgbgba")), null));
            }
            this.e.put(n.a("006dKbdbfbh(d0dg"), HashonHelper.fromHashMap(map4));
            if (zBooleanValue) {
                HashMap map5 = new HashMap(4);
                map5.put(n.a("0031bh-dFdg"), bool3);
                map5.put(n.a("003Vbhbgba"), ResHelper.forceCast(map.get(n.a("003Vbhbgba")), null));
                if (zBooleanValue2 || map3 == null) {
                    map5.put(n.a("003Adgbgba"), ResHelper.forceCast(map.get(n.a("003Adgbgba")), null));
                } else {
                    map5.put(n.a("003'dgbgba"), ResHelper.forceCast(map3.get(n.a("003'dgbgba")), null));
                }
                map5.putAll(this.f1459f);
                this.e.put(n.a("0068chLh:bfbh3d^dg"), HashonHelper.fromHashMap(map5));
            }
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
        }
    }
}
