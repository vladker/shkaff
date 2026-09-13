package y5;

import io.reactivex.AbstractC0676c;
import io.reactivex.AbstractC0979l;
import io.reactivex.AbstractC0985s;
import io.reactivex.B;
import io.reactivex.N;
import io.reactivex.O;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import retrofit2.AbstractC1614l;
import retrofit2.B0;
import retrofit2.InterfaceC1615m;
import retrofit2.r0;
import retrofit2.u0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class i extends AbstractC1614l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f9053a;
    private final N scheduler;

    private i(N n6, boolean z6) {
        this.scheduler = n6;
        this.f9053a = z6;
    }

    public static i a() {
        return new i(null, false);
    }

    @Override // retrofit2.AbstractC1614l
    public final InterfaceC1615m get(Type type, Annotation[] annotationArr, u0 u0Var) {
        Type typeD;
        boolean z6;
        boolean z7;
        String str;
        Class clsE = B0.e(type);
        if (clsE == AbstractC0676c.class) {
            return new h(Void.class, this.scheduler, this.f9053a, false, true, false, false, false, true);
        }
        boolean z8 = clsE == AbstractC0979l.class;
        boolean z9 = clsE == O.class;
        boolean z10 = clsE == AbstractC0985s.class;
        if (clsE != B.class && !z8 && !z9 && !z10) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            if (z8) {
                str = "Flowable";
            } else if (z9) {
                str = "Single";
            } else {
                str = z10 ? "Maybe" : "Observable";
            }
            throw new IllegalStateException(str + " return type must be parameterized as " + str + "<Foo> or " + str + "<? extends Foo>");
        }
        Type typeD2 = B0.d(0, (ParameterizedType) type);
        Class clsE2 = B0.e(typeD2);
        if (clsE2 == r0.class) {
            if (!(typeD2 instanceof ParameterizedType)) {
                throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
            }
            typeD = B0.d(0, (ParameterizedType) typeD2);
            z7 = false;
            z6 = false;
        } else if (clsE2 != g.class) {
            typeD = typeD2;
            z6 = true;
            z7 = false;
        } else {
            if (!(typeD2 instanceof ParameterizedType)) {
                throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
            }
            typeD = B0.d(0, (ParameterizedType) typeD2);
            z7 = true;
            z6 = false;
        }
        return new h(typeD, this.scheduler, this.f9053a, z7, z6, z8, z9, z10, false);
    }
}
