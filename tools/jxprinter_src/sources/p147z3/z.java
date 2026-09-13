package p147z3;

import java.io.Serializable;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class z implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f9136a;
    public final Object b;
    public final Object c;

    public z(Object obj, Object obj2, Object obj3) {
        this.f9136a = obj;
        this.b = obj2;
        this.c = obj3;
    }

    public final z copy(Object obj, Object obj2, Object obj3) {
        return new z(obj, obj2, obj3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return E.a(this.f9136a, zVar.f9136a) && E.a(this.b, zVar.b) && E.a(this.c, zVar.c);
    }

    public final int hashCode() {
        Object obj = this.f9136a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.b;
        int iHashCode2 = (iHashCode + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Object obj3 = this.c;
        return iHashCode2 + (obj3 != null ? obj3.hashCode() : 0);
    }

    public String toString() {
        return "(" + this.f9136a + ", " + this.b + ", " + this.c + ')';
    }
}
