package p084o4;

import A3.T;
import X3.D;
import java.util.Iterator;
import kotlin.jvm.internal.E;
import p072m4.r;
import p072m4.v;
import p072m4.y;
import p072m4.z;
import p147z3.AbstractC1935o;
import p147z3.InterfaceC1934n;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class I extends G0 {
    private final InterfaceC1934n elementDescriptors$delegate;
    private final z kind;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public I(String name, int i5) {
        super(name, null, i5);
        E.f(name, "name");
        this.kind = y.INSTANCE;
        this.elementDescriptors$delegate = AbstractC1935o.lazy(new D(i5, name, this));
    }

    @Override // p084o4.G0
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return rVar.getKind() == y.INSTANCE && E.a(getSerialName(), rVar.getSerialName()) && E.a(D0.cachedSerialNames(this), D0.cachedSerialNames(rVar));
    }

    @Override // p084o4.G0, p072m4.r
    public r getElementDescriptor(int i5) {
        return ((r[]) this.elementDescriptors$delegate.getValue())[i5];
    }

    @Override // p084o4.G0, p072m4.r
    public z getKind() {
        return this.kind;
    }

    @Override // p084o4.G0
    public final int hashCode() {
        int iHashCode = getSerialName().hashCode();
        Iterator<String> it = v.getElementNames(this).iterator();
        int iHashCode2 = 1;
        while (it.hasNext()) {
            int i5 = iHashCode2 * 31;
            String next = it.next();
            iHashCode2 = i5 + (next != null ? next.hashCode() : 0);
        }
        return (iHashCode * 31) + iHashCode2;
    }

    @Override // p084o4.G0
    public String toString() {
        return T.g(v.getElementNames(this), ", ", getSerialName() + '(', ")", null, 56);
    }
}
