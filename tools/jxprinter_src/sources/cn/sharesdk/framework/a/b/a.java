package cn.sharesdk.framework.a.b;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class a extends e {
    private static int c;
    private static long d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2133a;
    public String b;

    @Override // cn.sharesdk.framework.a.b.e
    public String a() {
        return "[API]";
    }

    @Override // cn.sharesdk.framework.a.b.e
    public int b() {
        return 5000;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public int c() {
        return 50;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public long d() {
        return c;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public long e() {
        return d;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public void f() {
        c++;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public String toString() {
        return super.toString() + '|' + this.f2133a + '|' + this.b;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public void a(long j6) {
        d = j6;
    }
}
