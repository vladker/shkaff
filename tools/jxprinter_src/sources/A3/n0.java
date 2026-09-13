package A3;

import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class n0 extends AbstractC0139g implements RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f42a;
    public int b;
    private final List<Object> list;

    public n0(List<Object> list) {
        kotlin.jvm.internal.E.f(list, "list");
        this.list = list;
    }

    @Override // A3.AbstractC0132b
    public final int b() {
        return this.b;
    }

    public final void c(int i5, int i6) {
        C0136d c0136d = AbstractC0139g.Companion;
        int size = this.list.size();
        c0136d.getClass();
        C0136d.d(i5, i6, size);
        this.f42a = i5;
        this.b = i6 - i5;
    }

    @Override // java.util.List
    public final Object get(int i5) {
        C0136d c0136d = AbstractC0139g.Companion;
        int i6 = this.b;
        c0136d.getClass();
        C0136d.b(i5, i6);
        return this.list.get(this.f42a + i5);
    }
}
