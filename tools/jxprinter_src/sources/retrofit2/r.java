package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class r extends AbstractC1614l {
    @Override // retrofit2.AbstractC1614l
    public InterfaceC1615m get(Type type, Annotation[] annotationArr, u0 u0Var) {
        if (B0.e(type) != CompletableFuture.class) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
        }
        Type typeD = B0.d(0, (ParameterizedType) type);
        if (B0.e(typeD) != r0.class) {
            return new C1618p(0, typeD);
        }
        if (!(typeD instanceof ParameterizedType)) {
            throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
        }
        return new C1618p(1, B0.d(0, (ParameterizedType) typeD));
    }
}
