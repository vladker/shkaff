package cn.sharesdk.framework.a.b;

import com.mob.MobSDK;
import org.apache.xmlbeans.impl.common.NameUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e {
    public long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f2137f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f2138g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2139h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f2140i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f2141j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f2142k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f2143l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f2144m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f2145n;

    public abstract String a();

    public abstract void a(long j6);

    public abstract int b();

    public abstract int c();

    public abstract long d();

    public abstract long e();

    public abstract void f();

    public boolean g() {
        int iB = b();
        int iC = c();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - e() < iB) {
            return d() < ((long) iC);
        }
        a(jCurrentTimeMillis);
        return true;
    }

    public void h() {
        f();
    }

    public String toString() {
        return a() + NameUtil.COLON + this.e + '|' + this.f2137f + '|' + MobSDK.getAppkey() + '|' + this.f2138g + '|' + this.f2139h + '|' + this.f2140i + '|' + this.f2141j + '|' + this.f2142k;
    }
}
