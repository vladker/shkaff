package kotlin.jvm.internal;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: kotlin.jvm.internal.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1087a implements InterfaceC1111z, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f5692a;
    public final boolean b = false;
    public final int c = 2;

    public C1087a(Object obj) {
        this.f5692a = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1087a)) {
            return false;
        }
        C1087a c1087a = (C1087a) obj;
        return this.b == c1087a.b && this.c == c1087a.c && E.a(this.f5692a, c1087a.f5692a) && AtomicReference.class.equals(AtomicReference.class);
    }

    @Override // kotlin.jvm.internal.InterfaceC1111z
    public final int getArity() {
        return 2;
    }

    public final int hashCode() {
        Object obj = this.f5692a;
        return ((((((((((AtomicReference.class.hashCode() + ((obj != null ? obj.hashCode() : 0) * 31)) * 31) + 113762) * 31) - 869290769) * 31) + (this.b ? 1231 : 1237)) * 31) + 2) * 31) + this.c;
    }

    public final String toString() {
        return U.renderLambdaToString(this);
    }
}
