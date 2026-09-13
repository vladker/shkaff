package cn.fly.commons;

import android.text.TextUtils;
import cn.fly.FlySDK;
import cn.fly.tools.FlyLog;
import cn.fly.tools.utils.DH;
import cn.fly.tools.utils.FileLocker;
import cn.fly.tools.utils.ResHelper;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile z f1519a;
    private a b = new a();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final File f1520a;
        private volatile byte[] b;
        private final ReentrantReadWriteLock c;
        private Map<String, Object> d;
        private volatile boolean e;

        private Map<String, Object> c() {
            final Map<String, Object>[] mapArr = {null};
            v.a(v.a(v.f1487n), new u() { // from class: cn.fly.commons.z.a.2
                @Override // cn.fly.commons.u
                public boolean a(FileLocker fileLocker) {
                    try {
                        mapArr[0] = (Map) C0396r.a(a.this.f1520a, a.this.b());
                    } catch (Throwable th) {
                        FlyLog.getInstance().d(th);
                    }
                    return false;
                }
            });
            return mapArr[0];
        }

        private a() {
            Map<String, Object> mapC;
            this.c = new ReentrantReadWriteLock();
            this.d = new HashMap();
            this.e = false;
            File dataCacheFile = ResHelper.getDataCacheFile(FlySDK.getContext(), x.b("005[ck%ii6cbge"));
            this.f1520a = dataCacheFile;
            if (!dataCacheFile.exists() || dataCacheFile.length() <= 0 || (mapC = c()) == null || mapC.isEmpty()) {
                return;
            }
            this.d.putAll(mapC);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public byte[] b() {
            if (this.b == null) {
                try {
                    this.b = x.b("016>ci+cdQcbcj-c5cbee+cPcbdigegdiegkgh").getBytes("UTF-8");
                } catch (Throwable unused) {
                }
            }
            return this.b;
        }

        public a a(String str, Object obj) {
            this.c.writeLock().lock();
            try {
                this.d.put(str, obj);
                this.e = true;
                return this;
            } finally {
                this.c.writeLock().unlock();
            }
        }

        public <T> T b(String str, T t6) {
            this.c.readLock().lock();
            try {
                return (T) ResHelper.forceCast(this.d.get(str), t6);
            } finally {
                this.c.readLock().unlock();
            }
        }

        public boolean a() {
            this.c.writeLock().lock();
            try {
                if (this.e) {
                    a(this.d);
                }
                this.c.writeLock().unlock();
                return true;
            } catch (Throwable unused) {
                this.c.writeLock().unlock();
                return false;
            }
        }

        private void a(final Map<String, Object> map) {
            v.a(v.a(v.f1487n), new u() { // from class: cn.fly.commons.z.a.1
                @Override // cn.fly.commons.u
                public boolean a(FileLocker fileLocker) {
                    C0396r.a(a.this.f1520a, a.this.b(), map);
                    a.this.e = false;
                    return false;
                }
            });
        }
    }

    private z() {
    }

    public static z a() {
        if (f1519a == null) {
            synchronized (z.class) {
                try {
                    if (f1519a == null) {
                        f1519a = new z();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f1519a;
    }

    public int b() {
        a aVar = this.b;
        String str = ae.e;
        int iIntValue = ((Integer) aVar.b(str, -1)).intValue();
        if (iIntValue == -1 && (iIntValue = ae.b().b(str, -1)) != -1) {
            a(iIntValue);
        }
        return iIntValue;
    }

    public int c(int i5) {
        int iIntValue = ((Integer) this.b.b("key_wt_tms", Integer.valueOf(i5))).intValue();
        if (iIntValue != i5) {
            return iIntValue;
        }
        int iC = ae.b().c(i5);
        if (iC != i5) {
            this.b.a("key_wt_tms", Integer.valueOf(iC)).a();
        }
        return iC;
    }

    public z d(int i5) {
        this.b.a("key_wt_dys", Integer.valueOf(Math.min(10000, i5)));
        return this;
    }

    public z e(int i5) {
        this.b.a("key_lch_tms", Integer.valueOf(Math.min(10000, i5)));
        return this;
    }

    public long f() {
        long jCurrentTimeMillis = System.currentTimeMillis() - ((Long) b("key_cvi", Long.valueOf(System.currentTimeMillis()))).longValue();
        if (jCurrentTimeMillis > 1000) {
            return jCurrentTimeMillis / 1000;
        }
        return 0L;
    }

    public boolean g() {
        if (((Boolean) this.b.b("keyR_drt_lch", Boolean.FALSE)).booleanValue()) {
            return true;
        }
        boolean zK = ae.b().k();
        if (zK) {
            this.b.a("keyR_drt_lch", Boolean.TRUE).a();
        }
        return zK;
    }

    public boolean h() {
        return this.b.a();
    }

    public long d() {
        if (!DH.SyncMtd.isAut()) {
            return System.currentTimeMillis();
        }
        long jLongValue = ((Long) this.b.b("key_fst_lnch_tm", 0L)).longValue();
        if (jLongValue > 0) {
            return jLongValue;
        }
        long jS = ae.b().s();
        if (jS > 0) {
            a(jS).h();
        } else {
            jS = ae.b().i();
            if (jS > 0) {
                a(jS).h();
            }
        }
        if (jS == 0) {
            a(System.currentTimeMillis()).h();
        }
        return jS;
    }

    public int e() {
        int iIntValue = ((Integer) this.b.b("key_lch_tms", Integer.MIN_VALUE)).intValue();
        if (iIntValue != Integer.MIN_VALUE) {
            return iIntValue;
        }
        int iJ = ae.b().j();
        e(iJ);
        return iJ;
    }

    public int b(int i5) {
        int iIntValue = ((Integer) this.b.b("key_wt_dys", Integer.valueOf(i5))).intValue();
        if (iIntValue != i5) {
            return iIntValue;
        }
        int iB = ae.b().b(i5);
        if (iB != i5) {
            this.b.a("key_wt_dys", Integer.valueOf(iB)).a();
        }
        return iB;
    }

    public void c() {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (!TextUtils.equals((String) this.b.b("key_acv", FlySDK.SDK_VERSION_NAME), DH.SyncMtd.getAppVersionName())) {
                a("key_acv", DH.SyncMtd.getAppVersionName()).a("key_cvi", Long.valueOf(System.currentTimeMillis())).h();
            } else if (jCurrentTimeMillis == ((Long) this.b.b("key_cvi", Long.valueOf(jCurrentTimeMillis))).longValue()) {
                a("key_cvi", Long.valueOf(System.currentTimeMillis())).h();
            }
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
        }
    }

    public void a(int i5) {
        this.b.a(ae.e, Integer.valueOf(i5)).a();
    }

    public <T> T b(String str, T t6) {
        return (T) this.b.b(str, t6);
    }

    public z a(long j6) {
        if (DH.SyncMtd.isAut()) {
            this.b.a("key_fst_lnch_tm", Long.valueOf(j6));
        }
        return this;
    }

    public z a(boolean z6) {
        this.b.a("keyR_drt_lch", Boolean.valueOf(z6));
        return this;
    }

    public z a(String str, Object obj) {
        this.b.a(str, obj);
        return this;
    }
}
