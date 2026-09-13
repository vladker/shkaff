package retrofit2;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class y0 implements GenericArrayType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f8167a;

    public y0(Type type) {
        this.f8167a = type;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && B0.b(this, (GenericArrayType) obj);
    }

    @Override // java.lang.reflect.GenericArrayType
    public final Type getGenericComponentType() {
        return this.f8167a;
    }

    public final int hashCode() {
        return this.f8167a.hashCode();
    }

    public final String toString() {
        return B0.l(this.f8167a) + "[]";
    }
}
