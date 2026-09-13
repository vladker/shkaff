package cn.fly.commons.a;

import android.content.pm.ApplicationInfo;
import android.util.Base64;
import cn.fly.FlySDK;
import cn.fly.commons.CSCenter;
import cn.fly.commons.FlyProduct;
import cn.fly.commons.ae;
import cn.fly.commons.q;
import cn.fly.commons.x;
import cn.fly.tools.FlyLog;
import cn.fly.tools.network.NetCommunicator;
import cn.fly.tools.utils.DH;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes.dex */
public class m extends c {
    private static final String b = x.b("016-edecdkebcgdjfkedfgecekcgebddgbfh");
    private static final String c = x.b("0165edecdkebcgfbecddedfhekcgekecebec");

    public m() {
        super(x.b("002if"), 0L, x.b("005if0diKci"), 86400L, c.a(x.b("002if"), (Long) 0L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object b(HashMap<String, Object> map) {
        try {
            map.put(x.b("005bif4ec(h"), Long.valueOf(System.currentTimeMillis()));
            return b(map, cn.fly.commons.j.a().a("gclg") + x.b("004kbif"));
        } catch (Throwable th) {
            FlyLog.getInstance().w(th);
            return null;
        }
    }

    private void o() {
        DH.requester(FlySDK.getContext()).getDetailNetworkTypeForStatic().request(new DH.DHResponder() { // from class: cn.fly.commons.a.m.1
            @Override // cn.fly.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                final List list;
                HashMap<String, Object> map = new HashMap<>();
                String strA = q.a();
                String strA2 = cn.fly.commons.f.a((FlyProduct) null);
                map.put(x.b("006cii^dgDe;db"), strA);
                map.put(x.b("006ciii-dgdi"), DH.SyncMtd.getPackageName());
                map.put(x.b("006ciiQccDeVci"), Integer.valueOf(DH.SyncMtd.getAppVersion()));
                map.put(x.b("004Zcbcfchcb"), strA2);
                map.put(x.b("004ifch"), Integer.valueOf(DH.SyncMtd.getPlatformCode()));
                map.put(x.b("011dehLefcjcidg-h7dbXie"), dHResponse.getDetailNetworkTypeForStatic());
                map.put(x.b("009fc4ehQh.fjXif0ec+h"), Long.valueOf(ae.b().b(m.b, 0L)));
                String strEncodeToString = Base64.encodeToString((strA + ParameterizedMessage.ERROR_MSG_SEPARATOR + strA2).getBytes("utf-8"), 2);
                map.put(x.b("009fc<eh9h=fj^if,ddcb"), strEncodeToString);
                HashMap map2 = (HashMap) m.b(map, cn.fly.commons.j.a().a("gclg") + x.b("004kCcc0if"));
                if (map2 == null || map2.size() == 0 || (list = (List) map2.get(x.b("004i>dgdieh"))) == null || list.size() <= 0) {
                    return;
                }
                ae.b().a(m.b, System.currentTimeMillis());
                final ArrayList arrayList = new ArrayList();
                FlyLog.getInstance().d("[dhss] vpl", new Object[0]);
                DH.RequestBuilder requestBuilderRequester = DH.requester(FlySDK.getContext());
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    requestBuilderRequester.getMpfos(DH.GPI_STRATEGY_VALIDITY_3_MINUTE, (String) it.next(), 0);
                }
                requestBuilderRequester.request(new DH.DHResponder() { // from class: cn.fly.commons.a.m.1.1
                    @Override // cn.fly.tools.utils.DH.DHResponder
                    public void onResponse(DH.DHResponse dHResponse2) {
                        int size = list.size();
                        for (int i5 = 0; i5 < size; i5++) {
                            try {
                                Object mpfos = dHResponse2.getMpfos(i5);
                                if (mpfos != null) {
                                    String str = (String) list.get(i5);
                                    ApplicationInfo applicationInfoA = cn.fly.tools.c.a(mpfos, str);
                                    HashMap map3 = new HashMap();
                                    map3.put(x.b("006ciii*dgdi"), str);
                                    map3.put(x.b("006cii5cc1eHci"), cn.fly.tools.c.c(mpfos, str));
                                    if (applicationInfoA != null) {
                                        int i6 = applicationInfoA.flags;
                                        boolean z6 = true;
                                        boolean z7 = (i6 & 1) == 1;
                                        boolean z8 = (i6 & 128) != 0;
                                        String strB = x.b("0059chehehdbeh");
                                        if (!z7 && !z8) {
                                            z6 = false;
                                        }
                                        map3.put(strB, Boolean.valueOf(z6));
                                    }
                                    arrayList.add(map3);
                                }
                            } catch (Throwable th) {
                                FlyLog.getInstance().d(th);
                            }
                        }
                    }
                });
                map.remove(x.b("011dehOefcjcidg^h>db+ie"));
                map.remove(x.b("009fc^eh6hAfj=ifLec4h"));
                map.remove(x.b("009fcYehAh,fj]if]ddcb"));
                map.put(x.b("005.cecjcbAef"), DH.SyncMtd.getModelForFly());
                map.put(x.b("008Ccb2cheh%chceHe"), Long.valueOf(System.currentTimeMillis()));
                map.put(x.b("002Echcb"), strEncodeToString);
                map.put(x.b("004iNdgdieh"), arrayList);
                Object objB = m.this.b(map);
                if (objB == null) {
                    objB = m.this.b(map);
                }
                if (objB == null) {
                    m.this.a(map);
                }
            }
        });
    }

    @Override // cn.fly.commons.a.c
    public void a() {
        if (CSCenter.getInstance().isAppListDataEnable()) {
            try {
                Thread.sleep(((Long) a(e(), 0L)).longValue() * 1000);
                HashMap<String, Object> map = (HashMap) ae.b().c(c, null);
                if (map != null && !map.isEmpty() && b(map) != null) {
                    a((HashMap<String, Object>) null);
                }
            } catch (Throwable unused) {
            }
            o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object b(HashMap<String, Object> map, String str) {
        if (!cn.fly.commons.c.d()) {
            return null;
        }
        return new NetCommunicator(1024, "009cbd92ccef123be840deec0c6ed0547194c1e471d11b6f375e56038458fb18833e5bab2e1206b261495d7e2d1d9e5aa859e6d4b67" + x.b("023.ge5cOgc;bcXghcbhjgc^e!deSe1cb,e4gkgc4e!gdgige7c,iede"), "1dfd1d615cb891ce9a76f42d036af7fce5f8b8efaa11b2f42590ecc4ea4cff28f5f6b0726aeb76254ab5b02a58c1d5b486c39d9da1a58fa6ba2f22196493b3a4cbc283dcf749bf63679ee24d185de70c8dfe05605886c9b53e9f569082eabdf98c4fb0dcf07eb9bb3e647903489ff0b5d933bd004af5be4a1022fdda41f347f1").requestSynchronized(map, str, false);
    }

    public synchronized void a(HashMap<String, Object> map) {
        try {
            if (map == null) {
                ae.b().b(c);
            } else {
                ae.b().b(c, map);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
