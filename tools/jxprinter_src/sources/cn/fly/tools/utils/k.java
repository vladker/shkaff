package cn.fly.tools.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import cn.fly.FlySDK;
import cn.fly.commons.C0396r;
import cn.fly.commons.a.l;
import cn.fly.commons.ae;
import cn.fly.commons.m;
import cn.fly.tools.FlyLog;
import cn.fly.tools.log.NLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile k f1990a;
    private BroadcastReceiver b;
    private final ConcurrentHashMap<String, a> c = new ConcurrentHashMap<>();
    private volatile long d = 0;

    public interface a {
        void a();
    }

    private k() {
        this.b = null;
        if (cn.fly.commons.e.c() || cn.fly.commons.e.d()) {
            this.b = new BroadcastReceiver() { // from class: cn.fly.tools.utils.k.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    k.a().a(context, intent);
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(m.a("029fg7feflfmfkfefnWghkOfnhifkghfkfngnhehfheikfjgfhmhfgikfik"));
            C0396r.a(this.b, intentFilter);
        }
    }

    public static k a() {
        if (f1990a == null) {
            synchronized (k.class) {
                try {
                    if (f1990a == null) {
                        f1990a = new k();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f1990a;
    }

    public void a(String str, a aVar) {
        if (aVar == null || str == null || this.c.containsKey(str)) {
            return;
        }
        this.c.put(str, aVar);
    }

    public void a(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            if (!m.a("029fg'feflfmfkfefn1ghk+fnhifkghfkfngnhehfheikfjgfhmhfgikfik").equals(intent.getAction()) || intent.getParcelableExtra(m.a("011ghk5hifmflgjggOgRghfm")) == null) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.d > 2000) {
                this.d = jCurrentTimeMillis;
                l.a().b(2500L, new i() { // from class: cn.fly.tools.utils.k.2
                    @Override // cn.fly.tools.utils.i
                    public void a() {
                        if (cn.fly.commons.e.j()) {
                            DH.requester(FlySDK.getContext()).getMwfoForce(true).request(new DH.DHResponder() { // from class: cn.fly.tools.utils.k.2.1
                                @Override // cn.fly.tools.utils.DH.DHResponder
                                public void onResponse(DH.DHResponse dHResponse) {
                                    HashMap<String, Object> mwfoForce = dHResponse.getMwfoForce(new int[0]);
                                    if (mwfoForce == null) {
                                        return;
                                    }
                                    String str = (String) mwfoForce.get("ssmt");
                                    String str2 = (String) mwfoForce.get("bsmt");
                                    NLog flyLog = FlyLog.getInstance();
                                    StringBuilder sbU = androidx.collection.a.u("[MCM] cdi ", str, " bcdi ", str2, " len ");
                                    sbU.append(k.a().c.size());
                                    flyLog.d(sbU.toString(), new Object[0]);
                                    if (TextUtils.isEmpty(str2) && (TextUtils.isEmpty(str) || m.a("014)kgfiCg=gjIg'fmhiUg5khhkhkfkfeki").equalsIgnoreCase(str))) {
                                        return;
                                    }
                                    TreeMap treeMap = new TreeMap();
                                    treeMap.put("ssmt", str);
                                    treeMap.put("bsmt", str2);
                                    String strMD5 = Data.MD5(new JSONObject(treeMap).toString());
                                    String strB = ae.b().b(ae.f1271i, (String) null);
                                    if (strB == null || !strB.equals(strMD5)) {
                                        Iterator it = k.this.c.values().iterator();
                                        while (it.hasNext()) {
                                            ((a) it.next()).a();
                                        }
                                    }
                                }
                            });
                        }
                    }
                });
            }
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
        }
    }
}
