package kotlin.jvm.internal;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class V {
    public V3.p mutableCollectionType(V3.p pVar) {
        d0 d0Var = (d0) pVar;
        return new d0(pVar.getClassifier(), pVar.getArguments(), d0Var.getPlatformTypeUpperBound$kotlin_stdlib(), d0Var.f5697a | 2);
    }

    public V3.p nothingType(V3.p pVar) {
        d0 d0Var = (d0) pVar;
        return new d0(pVar.getClassifier(), pVar.getArguments(), d0Var.getPlatformTypeUpperBound$kotlin_stdlib(), d0Var.f5697a | 4);
    }

    public V3.p platformType(V3.p pVar, V3.p pVar2) {
        return new d0(pVar.getClassifier(), pVar.getArguments(), pVar2, ((d0) pVar).f5697a);
    }

    public String renderLambdaToString(F f6) {
        return renderLambdaToString((InterfaceC1111z) f6);
    }

    public void setUpperBounds(V3.q qVar, List<V3.p> list) {
        ((a0) qVar).setUpperBounds(list);
    }

    public V3.p typeOf(V3.e eVar, List<V3.t> list, boolean z6) {
        return new d0(eVar, list, z6);
    }

    public V3.q typeParameter(Object obj, String str, V3.u uVar, boolean z6) {
        return new a0(obj, str, uVar, z6);
    }

    public String renderLambdaToString(InterfaceC1111z interfaceC1111z) {
        String string = interfaceC1111z.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }
}
