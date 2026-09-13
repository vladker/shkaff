package W3;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class N implements InterfaceC0233q, InterfaceC0222f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f810a;
    private final InterfaceC0233q sequence;

    public N(InterfaceC0233q sequence, int i5) {
        kotlin.jvm.internal.E.f(sequence, "sequence");
        this.sequence = sequence;
        this.f810a = i5;
        if (i5 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i5 + '.').toString());
    }

    @Override // W3.InterfaceC0222f
    public InterfaceC0233q drop(int i5) {
        int i6 = this.f810a;
        return i5 >= i6 ? z.emptySequence() : new M(this.sequence, i5, i6);
    }

    @Override // W3.InterfaceC0233q
    public Iterator<Object> iterator() {
        return new C0220d(this);
    }

    @Override // W3.InterfaceC0222f
    public InterfaceC0233q take(int i5) {
        return i5 >= this.f810a ? this : new N(this.sequence, i5);
    }
}
