package p004a1;

import V1.b;
import io.reactivex.internal.operators.observable.C0953x2;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f907a;
    public String b;
    public boolean c;
    public boolean d;
    public String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f908f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f909g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f910h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f911i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f912j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public C0953x2 f913k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public b f914l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b f915m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public HashMap f916n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayList f917o;

    public a(b bVar) {
        this.f907a = Integer.MIN_VALUE;
        this.b = "X-LOG";
        int i5 = bVar.f918a;
        ArrayList arrayList = bVar.f928o;
        this.f907a = i5;
        this.b = bVar.b;
        this.c = bVar.c;
        this.d = bVar.d;
        this.e = bVar.e;
        this.f908f = bVar.f919f;
        this.f909g = bVar.f920g;
        this.f910h = bVar.f921h;
        this.f911i = bVar.f922i;
        this.f912j = bVar.f923j;
        this.f913k = bVar.f924k;
        this.f914l = bVar.f925l;
        this.f915m = bVar.f926m;
        HashMap map = bVar.f927n;
        if (map != null) {
            this.f916n = new HashMap(map);
        }
        if (arrayList != null) {
            this.f917o = new ArrayList(arrayList);
        }
    }

    public final b a() {
        if (this.f910h == null) {
            this.f910h = new b(18);
        }
        if (this.f911i == null) {
            this.f911i = new b(28);
        }
        if (this.f912j == null) {
            this.f912j = new b(21);
        }
        if (this.f913k == null) {
            this.f913k = new C0953x2(3);
        }
        if (this.f914l == null) {
            this.f914l = new b(29);
        }
        if (this.f915m == null) {
            this.f915m = new b(17);
        }
        if (this.f916n == null) {
            this.f916n = new HashMap(p057k1.b.f5472a.a());
        }
        return new b(this);
    }
}
