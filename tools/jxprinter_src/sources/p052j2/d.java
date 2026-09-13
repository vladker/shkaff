package p052j2;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements ParameterizedType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f5402a;
    public final Type[] b;

    public d(Class cls, Type[] typeArr) {
        this.f5402a = cls;
        this.b = typeArr;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type[] getActualTypeArguments() {
        return this.b;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getOwnerType() {
        return null;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getRawType() {
        return this.f5402a;
    }
}
