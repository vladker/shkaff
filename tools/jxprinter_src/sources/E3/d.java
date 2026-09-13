package E3;

import V3.p;
import java.util.List;
import kotlin.jvm.internal.E;
import p007a4.L;
import p007a4.o1;
import p028e4.P;
import p147z3.A;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class d implements O3.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f228a;

    public /* synthetic */ d(int i5) {
        this.f228a = i5;
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        f fVar;
        p060k4.b nullable;
        switch (this.f228a) {
            case 0:
                String acc = (String) obj;
                o element = (o) obj2;
                E.f(acc, "acc");
                E.f(element, "element");
                if (acc.length() == 0) {
                    return element.toString();
                }
                return acc + ", " + element;
            case 1:
                q acc2 = (q) obj;
                o element2 = (o) obj2;
                E.f(acc2, "acc");
                E.f(element2, "element");
                q qVarMinusKey = acc2.minusKey(element2.getKey());
                r rVar = r.INSTANCE;
                if (qVarMinusKey == rVar) {
                    return element2;
                }
                i iVar = j.Key;
                j jVar = (j) qVarMinusKey.get(iVar);
                if (jVar == null) {
                    fVar = new f(qVarMinusKey, element2);
                } else {
                    q qVarMinusKey2 = qVarMinusKey.minusKey(iVar);
                    if (qVarMinusKey2 == rVar) {
                        return new f(element2, jVar);
                    }
                    fVar = new f(new f(qVarMinusKey2, element2), jVar);
                }
                return fVar;
            case 2:
                return A.to(obj, obj2);
            case 3:
                return A.to(obj, obj2);
            case 4:
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                return bool;
            case 5:
                return ((q) obj).plus((o) obj2);
            case 6:
                return ((q) obj).plus((o) obj2);
            case 7:
                return A.to(obj, obj2);
            case 8:
                return Boolean.valueOf(E.a(obj, obj2));
            case 9:
                o oVar = (o) obj2;
                if (!(oVar instanceof o1)) {
                    return obj;
                }
                Integer num = obj instanceof Integer ? (Integer) obj : null;
                int iIntValue = num != null ? num.intValue() : 1;
                return iIntValue == 0 ? oVar : Integer.valueOf(iIntValue + 1);
            case 10:
                o1 o1Var = (o1) obj;
                o oVar2 = (o) obj2;
                if (o1Var != null) {
                    return o1Var;
                }
                if (oVar2 instanceof o1) {
                    return (o1) oVar2;
                }
                return null;
            case 11:
                P p6 = (P) obj;
                o oVar3 = (o) obj2;
                if (oVar3 instanceof o1) {
                    o1 o1Var2 = (o1) oVar3;
                    p6.append(o1Var2, ((L) o1Var2).c(p6.context));
                }
                return p6;
            case 12:
                V3.c clazz = (V3.c) obj;
                final List types = (List) obj2;
                E.f(clazz, "clazz");
                E.f(types, "types");
                List<p060k4.b> listSerializersForParameters = p060k4.p.serializersForParameters(p095q4.i.EmptySerializersModule(), types, true);
                E.c(listSerializersForParameters);
                final int i5 = 0;
                return p060k4.p.parametrizedSerializerOrNull(clazz, listSerializersForParameters, new O3.a() { // from class: k4.n
                    @Override // O3.a
                    public final Object invoke() {
                        switch (i5) {
                            case 0:
                                break;
                        }
                        return ((p) types.get(0)).getClassifier();
                    }
                });
            case 13:
                V3.c clazz2 = (V3.c) obj;
                final List types2 = (List) obj2;
                E.f(clazz2, "clazz");
                E.f(types2, "types");
                List<p060k4.b> listSerializersForParameters2 = p060k4.p.serializersForParameters(p095q4.i.EmptySerializersModule(), types2, true);
                E.c(listSerializersForParameters2);
                final int i6 = 1;
                p060k4.b bVarParametrizedSerializerOrNull = p060k4.p.parametrizedSerializerOrNull(clazz2, listSerializersForParameters2, new O3.a() { // from class: k4.n
                    @Override // O3.a
                    public final Object invoke() {
                        switch (i6) {
                            case 0:
                                break;
                        }
                        return ((p) types2.get(0)).getClassifier();
                    }
                });
                if (bVarParametrizedSerializerOrNull == null || (nullable = p066l4.a.getNullable(bVarParametrizedSerializerOrNull)) == null) {
                    return null;
                }
                return nullable;
            default:
                return Integer.valueOf(((Integer) obj).intValue() + 1);
        }
    }
}
