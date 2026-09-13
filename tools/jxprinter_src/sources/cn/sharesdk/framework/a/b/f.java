package cn.sharesdk.framework.a.b;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class f extends e {
    private static int d;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static long f2146o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2147a;
    public int b;
    public String c = "";

    @Override // cn.sharesdk.framework.a.b.e
    public String a() {
        return "[EVT]";
    }

    @Override // cn.sharesdk.framework.a.b.e
    public int b() {
        return 5000;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public int c() {
        return 30;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public long d() {
        return d;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public long e() {
        return f2146o;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public void f() {
        d++;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public String toString() {
        return super.toString() + '|' + this.f2147a + '|' + this.b + '|' + this.c;
    }

    @Override // cn.sharesdk.framework.a.b.e
    public void a(long j6) {
        f2146o = j6;
    }
}
