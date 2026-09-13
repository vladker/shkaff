package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class P extends AbstractC1620s {
    @Override // retrofit2.AbstractC1620s
    public InterfaceC1621t responseBodyConverter(Type type, Annotation[] annotationArr, u0 u0Var) {
        if (B0.e(type) != Optional.class) {
            return null;
        }
        return new O(u0Var.nextResponseBodyConverter(null, B0.d(0, (ParameterizedType) type), annotationArr));
    }
}
