package W3;

import java.util.Iterator;

/* JADX INFO: renamed from: W3.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0221e implements InterfaceC0233q, InterfaceC0222f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f813a;
    private final InterfaceC0233q sequence;

    public C0221e(InterfaceC0233q sequence, int i5) {
        kotlin.jvm.internal.E.f(sequence, "sequence");
        this.sequence = sequence;
        this.f813a = i5;
        if (i5 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i5 + '.').toString());
    }

    @Override // W3.InterfaceC0222f
    public InterfaceC0233q drop(int i5) {
        int i6 = this.f813a + i5;
        return i6 < 0 ? new C0221e(this, i5) : new C0221e(this.sequence, i6);
    }

    @Override // W3.InterfaceC0233q
    public Iterator<Object> iterator() {
        return new C0220d(this);
    }

    @Override // W3.InterfaceC0222f
    public InterfaceC0233q take(int i5) {
        int i6 = this.f813a;
        int i7 = i6 + i5;
        return i7 < 0 ? new N(this, i5) : new M(this.sequence, i6, i7);
    }
}
