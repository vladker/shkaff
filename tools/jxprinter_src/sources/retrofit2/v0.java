package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import okhttp3.InterfaceC1352e;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class v0 {
    public static A a(u0 u0Var, Class cls, Method method) {
        Type genericReturnType;
        boolean z6;
        boolean z7;
        boolean z8;
        q0 q0VarB = new p0(u0Var, cls, method).b();
        Type genericReturnType2 = method.getGenericReturnType();
        if (B0.hasUnresolvableType(genericReturnType2)) {
            throw B0.methodError(method, null, "Method return type must not include a type variable or wildcard: %s", genericReturnType2);
        }
        if (genericReturnType2 == Void.TYPE) {
            throw B0.methodError(method, null, "Service methods cannot return void.", new Object[0]);
        }
        boolean z9 = q0VarB.f8158i;
        Annotation[] annotations = method.getAnnotations();
        if (z9) {
            Type[] genericParameterTypes = method.getGenericParameterTypes();
            Type typeD = ((ParameterizedType) genericParameterTypes[genericParameterTypes.length - 1]).getActualTypeArguments()[0];
            if (typeD instanceof WildcardType) {
                typeD = ((WildcardType) typeD).getLowerBounds()[0];
            }
            if (B0.e(typeD) == r0.class && (typeD instanceof ParameterizedType)) {
                typeD = B0.d(0, (ParameterizedType) typeD);
                z8 = false;
                z7 = true;
            } else {
                if (B0.e(typeD) == InterfaceC1613k.class) {
                    throw B0.methodError(method, null, "Suspend functions should not return Call, as they already execute asynchronously.\nChange its return type to %s", B0.d(0, (ParameterizedType) typeD));
                }
                z8 = B0.b && typeD == p147z3.Q.class;
                z7 = false;
            }
            genericReturnType = new z0(null, InterfaceC1613k.class, typeD);
            if (!B0.g(annotations, w0.class)) {
                Annotation[] annotationArr = new Annotation[annotations.length + 1];
                annotationArr[0] = x0.f8166a;
                System.arraycopy(annotations, 0, annotationArr, 1, annotations.length);
                annotations = annotationArr;
            }
            z6 = z8;
        } else {
            genericReturnType = method.getGenericReturnType();
            z6 = false;
            z7 = false;
        }
        try {
            InterfaceC1615m interfaceC1615mNextCallAdapter = u0Var.nextCallAdapter(null, genericReturnType, annotations);
            Type typeA = interfaceC1615mNextCallAdapter.a();
            if (typeA == okhttp3.T.class) {
                throw B0.methodError(method, null, "'" + B0.e(typeA).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
            }
            if (typeA == r0.class) {
                throw B0.methodError(method, null, "Response must include generic type (e.g., Response<String>)", new Object[0]);
            }
            if (q0VarB.d.equals("HEAD") && !Void.class.equals(typeA) && (!B0.b || typeA != p147z3.Q.class)) {
                throw B0.methodError(method, null, "HEAD method must use Void or Unit as response type.", new Object[0]);
            }
            try {
                InterfaceC1621t interfaceC1621tNextResponseBodyConverter = u0Var.nextResponseBodyConverter(null, typeA, method.getAnnotations());
                InterfaceC1352e interfaceC1352e = u0Var.b;
                if (z9) {
                    return z7 ? new C1626y(q0VarB, interfaceC1352e, interfaceC1621tNextResponseBodyConverter, interfaceC1615mNextCallAdapter, 1) : new C1627z(q0VarB, interfaceC1352e, interfaceC1621tNextResponseBodyConverter, interfaceC1615mNextCallAdapter, z6);
                }
                return new C1626y(q0VarB, interfaceC1352e, interfaceC1621tNextResponseBodyConverter, interfaceC1615mNextCallAdapter, 0);
            } catch (RuntimeException e) {
                throw B0.methodError(method, e, "Unable to create converter for %s", typeA);
            }
        } catch (RuntimeException e6) {
            throw B0.methodError(method, e6, "Unable to create call adapter for %s", genericReturnType);
        }
    }

    public abstract Object invoke(Object obj, Object[] objArr);
}
