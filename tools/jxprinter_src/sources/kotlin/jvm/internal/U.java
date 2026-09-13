package kotlin.jvm.internal;

import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class U {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final V f5690a;

    static {
        V v6 = null;
        try {
            v6 = (V) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (v6 == null) {
            v6 = new V();
        }
        f5690a = v6;
    }

    public static C1105t a(Class cls) {
        f5690a.getClass();
        return new C1105t(cls);
    }

    public static V3.f getOrCreateKotlinPackage(Class cls) {
        f5690a.getClass();
        return new H(cls, "");
    }

    public static V3.p mutableCollectionType(V3.p pVar) {
        return f5690a.mutableCollectionType(pVar);
    }

    public static V3.p nothingType(V3.p pVar) {
        return f5690a.nothingType(pVar);
    }

    public static V3.p nullableTypeOf(V3.e eVar) {
        return f5690a.typeOf(eVar, Collections.EMPTY_LIST, true);
    }

    public static V3.p platformType(V3.p pVar, V3.p pVar2) {
        return f5690a.platformType(pVar, pVar2);
    }

    public static String renderLambdaToString(F f6) {
        return f5690a.renderLambdaToString(f6);
    }

    public static void setUpperBounds(V3.q qVar, V3.p pVar) {
        f5690a.setUpperBounds(qVar, Collections.singletonList(pVar));
    }

    public static V3.p typeOf(V3.e eVar) {
        return f5690a.typeOf(eVar, Collections.EMPTY_LIST, false);
    }

    public static V3.q typeParameter(Object obj, String str, V3.u uVar, boolean z6) {
        return f5690a.typeParameter(obj, str, uVar, z6);
    }

    public static V3.p nullableTypeOf(Class cls) {
        return f5690a.typeOf(a(cls), Collections.EMPTY_LIST, true);
    }

    public static String renderLambdaToString(InterfaceC1111z interfaceC1111z) {
        return f5690a.renderLambdaToString(interfaceC1111z);
    }

    public static void setUpperBounds(V3.q qVar, V3.p... pVarArr) {
        f5690a.setUpperBounds(qVar, A3.C.toList(pVarArr));
    }

    public static V3.p typeOf(Class cls) {
        return f5690a.typeOf(a(cls), Collections.EMPTY_LIST, false);
    }

    public static V3.p nullableTypeOf(Class cls, V3.t tVar) {
        return f5690a.typeOf(a(cls), Collections.singletonList(tVar), true);
    }

    public static V3.p typeOf(Class cls, V3.t tVar) {
        return f5690a.typeOf(a(cls), Collections.singletonList(tVar), false);
    }

    public static V3.p nullableTypeOf(Class cls, V3.t tVar, V3.t tVar2) {
        return f5690a.typeOf(a(cls), Arrays.asList(tVar, tVar2), true);
    }

    public static V3.p typeOf(Class cls, V3.t tVar, V3.t tVar2) {
        return f5690a.typeOf(a(cls), Arrays.asList(tVar, tVar2), false);
    }

    public static V3.p nullableTypeOf(Class cls, V3.t... tVarArr) {
        return f5690a.typeOf(a(cls), A3.C.toList(tVarArr), true);
    }

    public static V3.p typeOf(Class cls, V3.t... tVarArr) {
        return f5690a.typeOf(a(cls), A3.C.toList(tVarArr), false);
    }
}
