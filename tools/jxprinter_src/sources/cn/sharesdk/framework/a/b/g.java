package cn.sharesdk.framework.a.b;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class g extends e {
    private static int b;
    private static long c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f2148a;

    @Override // cn.sharesdk.framework.a.b.e
    public String a() {
        return "[EXT]";
    }

    @Override // cn.sharesdk.framework.a.b.e
    public int b() {
        return 5000;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public int c() {
        return 5;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public long d() {
        return b;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public long e() {
        return c;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public void f() {
        b++;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public boolean g() {
        cn.sharesdk.framework.a.a.e eVarA = cn.sharesdk.framework.a.a.e.a();
        b = eVarA.k("insertExitEventCount");
        c = eVarA.j("lastInsertExitEventTime");
        return super.g();
    }

    @Override // cn.sharesdk.framework.a.b.e
    public void h() {
        super.h();
        cn.sharesdk.framework.a.a.e eVarA = cn.sharesdk.framework.a.a.e.a();
        eVarA.a("lastInsertExitEventTime", Long.valueOf(c));
        eVarA.a("insertExitEventCount", b);
    }

    @Override // cn.sharesdk.framework.a.b.e
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append('|');
        if (!TextUtils.isEmpty(this.f2143l)) {
            sb.append(this.f2143l);
        }
        sb.append('|');
        sb.append(Math.round(this.f2148a / 1000.0f));
        return sb.toString();
    }

    @Override // cn.sharesdk.framework.a.b.e
    public void a(long j6) {
        c = j6;
    }
}
