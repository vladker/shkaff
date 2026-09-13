package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: renamed from: retrofit2.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class C1610h extends AbstractC1620s {
    @Override // retrofit2.AbstractC1620s
    public InterfaceC1621t requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, u0 u0Var) {
        if (okhttp3.Q.class.isAssignableFrom(B0.e(type))) {
            return C1605c.f8119a;
        }
        return null;
    }

    @Override // retrofit2.AbstractC1620s
    public InterfaceC1621t responseBodyConverter(Type type, Annotation[] annotationArr, u0 u0Var) {
        if (type == okhttp3.W.class) {
            return B0.g(annotationArr, A5.w.class) ? C1606d.f8121a : C1603b.f8117a;
        }
        if (type == Void.class) {
            return C1609g.f8127a;
        }
        if (B0.b && type == p147z3.Q.class) {
            return C1608f.f8125a;
        }
        return null;
    }
}
