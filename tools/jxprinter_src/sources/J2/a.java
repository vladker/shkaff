package J2;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final a c;
    public static final a d;
    public static final a e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f352f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f353g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a[] f354h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f355a;
    public final boolean b;

    static {
        a aVar = new a(0, false);
        c = aVar;
        a aVar2 = new a(1, true);
        a aVar3 = new a(2, false);
        d = aVar3;
        a aVar4 = new a(3, true);
        a aVar5 = new a(4, false);
        e = aVar5;
        a aVar6 = new a(5, true);
        a aVar7 = new a(6, false);
        f352f = aVar7;
        a aVar8 = new a(7, true);
        a aVar9 = new a(8, false);
        a aVar10 = new a(9, true);
        f353g = aVar10;
        f354h = new a[]{aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9, aVar10, new a(10, false), new a(10, true)};
    }

    public a(int i5, boolean z6) {
        this.f355a = i5;
        this.b = z6;
    }

    public final boolean a(a aVar) {
        int i5 = aVar.f355a;
        int i6 = this.f355a;
        if (i6 >= i5) {
            return (!this.b || f353g == this) && i6 == i5;
        }
        return true;
    }

    public final a b() {
        if (!this.b) {
            return this;
        }
        a aVar = f354h[this.f355a - 1];
        return !aVar.b ? aVar : c;
    }
}
