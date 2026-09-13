package W3;

import A3.AbstractC0157z;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class M implements InterfaceC0233q, InterfaceC0222f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f809a;
    public final int b;
    private final InterfaceC0233q sequence;

    public M(InterfaceC0233q sequence, int i5, int i6) {
        kotlin.jvm.internal.E.f(sequence, "sequence");
        this.sequence = sequence;
        this.f809a = i5;
        this.b = i6;
        if (i5 < 0) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "startIndex should be non-negative, but is ").toString());
        }
        if (i6 < 0) {
            throw new IllegalArgumentException(AbstractC0157z.k(i6, "endIndex should be non-negative, but is ").toString());
        }
        if (i6 < i5) {
            throw new IllegalArgumentException(androidx.collection.a.h(i6, i5, "endIndex should be not less than startIndex, but was ", " < ").toString());
        }
    }

    @Override // W3.InterfaceC0222f
    public InterfaceC0233q drop(int i5) {
        int i6 = this.b;
        int i7 = this.f809a;
        return i5 >= i6 - i7 ? z.emptySequence() : new M(this.sequence, i7 + i5, i6);
    }

    @Override // W3.InterfaceC0233q
    public Iterator<Object> iterator() {
        return new C0228l(this);
    }

    @Override // W3.InterfaceC0222f
    public InterfaceC0233q take(int i5) {
        int i6 = this.b;
        int i7 = this.f809a;
        return i5 >= i6 - i7 ? this : new M(this.sequence, i7, i5 + i7);
    }
}
