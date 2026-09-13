package p147z3;

import java.io.Serializable;
import kotlin.jvm.internal.E;

/* JADX INFO: renamed from: z3.s, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1938s implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f9134a;
    public final Object b;

    public C1938s(Object obj, Object obj2) {
        this.f9134a = obj;
        this.b = obj2;
    }

    public final C1938s copy(Object obj, Object obj2) {
        return new C1938s(obj, obj2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1938s)) {
            return false;
        }
        C1938s c1938s = (C1938s) obj;
        return E.a(this.f9134a, c1938s.f9134a) && E.a(this.b, c1938s.b);
    }

    public final int hashCode() {
        Object obj = this.f9134a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.b;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return "(" + this.f9134a + ", " + this.b + ')';
    }
}
