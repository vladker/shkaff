package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: retrofit2.v, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class C1623v extends AbstractC1614l {
    private final Executor callbackExecutor;

    public C1623v(Executor executor) {
        this.callbackExecutor = executor;
    }

    @Override // retrofit2.AbstractC1614l
    public InterfaceC1615m get(Type type, Annotation[] annotationArr, u0 u0Var) {
        if (B0.e(type) != InterfaceC1613k.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            return new xyz.doikki.videoplayer.player.k(B0.d(0, (ParameterizedType) type), 7, B0.g(annotationArr, w0.class) ? null : this.callbackExecutor, false);
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
