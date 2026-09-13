package retrofit2;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class A0 implements WildcardType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f8090a;
    private final Type lowerBound;

    public A0(Type[] typeArr, Type[] typeArr2) {
        if (typeArr2.length > 1) {
            throw new IllegalArgumentException();
        }
        if (typeArr.length != 1) {
            throw new IllegalArgumentException();
        }
        if (typeArr2.length != 1) {
            typeArr[0].getClass();
            B0.a(typeArr[0]);
            this.lowerBound = null;
            this.f8090a = typeArr[0];
            return;
        }
        typeArr2[0].getClass();
        B0.a(typeArr2[0]);
        if (typeArr[0] != Object.class) {
            throw new IllegalArgumentException();
        }
        this.lowerBound = typeArr2[0];
        this.f8090a = Object.class;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof WildcardType) && B0.b(this, (WildcardType) obj);
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getLowerBounds() {
        Type type = this.lowerBound;
        return type != null ? new Type[]{type} : B0.f8092a;
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getUpperBounds() {
        return new Type[]{this.f8090a};
    }

    public final int hashCode() {
        Type type = this.lowerBound;
        return (type != null ? type.hashCode() + 31 : 1) ^ (this.f8090a.hashCode() + 31);
    }

    public final String toString() {
        if (this.lowerBound != null) {
            return "? super " + B0.l(this.lowerBound);
        }
        Type type = this.f8090a;
        if (type == Object.class) {
            return "?";
        }
        return "? extends " + B0.l(type);
    }
}
