package cn.fly.commons;

import android.text.TextUtils;
import cn.fly.FlySDK;
import cn.fly.tools.FlyLog;
import cn.fly.tools.network.NetCommunicator;
import cn.fly.tools.network.NetworkHelper;
import cn.fly.tools.utils.DH;
import cn.fly.tools.utils.HashonHelper;
import cn.fly.tools.utils.ResHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.math3.optimization.direct.CMAESOptimizer;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private static volatile b c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f1289a;
    private byte[] b;
    private final HashMap<String, Object> d;

    private b() {
        HashMap<String, Object> map = new HashMap<>();
        this.d = map;
        File dataCacheFile = ResHelper.getDataCacheFile(FlySDK.getContext(), o.a("005<dlSccVdchf"));
        this.f1289a = dataCacheFile;
        if (!dataCacheFile.exists() || dataCacheFile.length() <= 0) {
            return;
        }
        try {
            Map<? extends String, ? extends Object> map2 = (Map) C0396r.a(dataCacheFile, b());
            if (map2 == null || map2.isEmpty()) {
                return;
            }
            map.putAll(map2);
        } catch (Throwable unused) {
        }
    }

    public static b a() {
        if (c == null) {
            synchronized (b.class) {
                try {
                    if (c == null) {
                        c = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] b() {
        if (this.b == null) {
            try {
                this.b = Arrays.copyOf(o.a("012<difl=f>fgdgicjfhjhcdkijdf").getBytes("UTF-8"), 16);
            } catch (Throwable unused) {
            }
        }
        return this.b;
    }

    private void c() {
        synchronized (this) {
            this.d.clear();
            C0396r.a(this.f1289a, b(), this.d);
        }
    }

    public void a(final String str, final Object obj) {
        ac.f1261a.execute(new cn.fly.tools.utils.i() { // from class: cn.fly.commons.b.1
            @Override // cn.fly.tools.utils.i
            public void a() {
                synchronized (b.this) {
                    b.this.d.put(str, obj);
                    C0396r.a(b.this.f1289a, b.this.b(), b.this.d);
                }
            }
        });
    }

    public void a(String str, String str2) {
        if (this.d.isEmpty()) {
            return;
        }
        try {
            HashMap<String, Object> map = new HashMap<>();
            map.put(o.a("004jgdi"), Integer.valueOf(DH.SyncMtd.getPlatformCode()));
            map.put(o.a("005Cdfdkdc+fg"), DH.SyncMtd.getModel());
            if (!TextUtils.isEmpty(str2)) {
                map.put(o.a("004Rdcdgdidc"), str2);
            }
            map.put("usridt", ad.i());
            map.put(o.a("004;dfdkdidc"), str);
            ArrayList arrayList = new ArrayList();
            Iterator<Object> it = this.d.values().iterator();
            while (it.hasNext()) {
                arrayList.add((HashMap) it.next());
            }
            map.put(o.a("005BdcGdid2fi"), arrayList);
            map.put(o.a("005i0dkehWfe"), null);
            NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
            networkTimeOut.readTimout = CMAESOptimizer.DEFAULT_MAXITERATIONS;
            networkTimeOut.connectionTimeout = 15000;
            if ("200".equals(String.valueOf(HashonHelper.fromJson((String) new NetCommunicator(1024, "ceeef5035212dfe7c6a0acdc0ef35ce5b118aab916477037d7381f85c6b6176fcf57b1d1c3296af0bb1c483fe5e1eb0ce9eb2953b44e494ca60777a1b033cc07", "191737288d17e660c4b61440d5d14228a0bf9854499f9d68d8274db55d6d954489371ecf314f26bec236e58fac7fffa9b27bcf923e1229c4080d49f7758739e5bd6014383ed2a75ce1be9b0ab22f283c5c5e11216c5658ba444212b6270d629f2d615b8dfdec8545fb7d4f935b0cc10b6948ab4fc1cb1dd496a8f94b51e888dd", networkTimeOut).requestWithoutEncode(false, null, map, j.a().a("gclg") + "/v6/gcl", false)).get(o.a("006%fi@idiSdgfi"))))) {
                c();
            }
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
        }
    }
}
