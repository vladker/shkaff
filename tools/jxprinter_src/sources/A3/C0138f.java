package A3;

import java.util.RandomAccess;

/* JADX INFO: renamed from: A3.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0138f extends AbstractC0139g implements RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f39a;
    public final int b;
    private final AbstractC0139g list;

    public C0138f(AbstractC0139g list, int i5, int i6) {
        kotlin.jvm.internal.E.f(list, "list");
        this.list = list;
        this.f39a = i5;
        C0136d c0136d = AbstractC0139g.Companion;
        int iB = list.b();
        c0136d.getClass();
        C0136d.d(i5, i6, iB);
        this.b = i6 - i5;
    }

    @Override // A3.AbstractC0132b
    public final int b() {
        return this.b;
    }

    @Override // java.util.List
    public final Object get(int i5) {
        AbstractC0139g.Companion.getClass();
        C0136d.b(i5, this.b);
        return this.list.get(this.f39a + i5);
    }
}
