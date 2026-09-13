package p096r;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements ParameterizedType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type[] f7919a;
    public final Type b;
    public final Type c;

    public h(Type type, Type type2, Type[] typeArr) {
        this.f7919a = typeArr;
        this.b = type;
        this.c = type2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && h.class == obj.getClass()) {
            h hVar = (h) obj;
            Type type = hVar.c;
            Type type2 = hVar.b;
            if (!Arrays.equals(this.f7919a, hVar.f7919a)) {
                return false;
            }
            Type type3 = this.b;
            if (type3 == null ? type2 != null : !type3.equals(type2)) {
                return false;
            }
            Type type4 = this.c;
            if (type4 != null) {
                return type4.equals(type);
            }
            if (type == null) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type[] getActualTypeArguments() {
        return this.f7919a;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getOwnerType() {
        return this.b;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getRawType() {
        return this.c;
    }

    public final int hashCode() {
        Type[] typeArr = this.f7919a;
        int iHashCode = (typeArr != null ? Arrays.hashCode(typeArr) : 0) * 31;
        Type type = this.b;
        int iHashCode2 = (iHashCode + (type != null ? type.hashCode() : 0)) * 31;
        Type type2 = this.c;
        return iHashCode2 + (type2 != null ? type2.hashCode() : 0);
    }
}
