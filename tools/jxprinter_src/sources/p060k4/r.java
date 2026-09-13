package p060k4;

import A3.AbstractC0151t;
import A3.C0152u;
import A3.I;
import A3.J;
import S2.d;
import V3.c;
import V3.p;
import V3.t;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.U;
import p066l4.a;
import p084o4.C0;
import p084o4.C1306e0;
import p084o4.C1307f;
import p084o4.C1310g0;
import p084o4.D0;
import p084o4.N0;
import p084o4.Q;
import p084o4.T;
import p095q4.e;
import p095q4.g;
import p095q4.i;
import p147z3.C1929i;
import p147z3.C1938s;
import p147z3.u;
import p147z3.z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class r {
    /* JADX WARN: Code duplicated, block: B:12:0x0042  */
    /* JADX WARN: Code duplicated, block: B:33:0x007e  */
    /* JADX WARN: Code duplicated, block: B:46:0x00a9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:47:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:49:0x00b0 A[RETURN] */
    public static final b a(g gVar, p pVar, boolean z6) {
        b bVarFindCachedSerializer;
        b contextual;
        e eVar;
        c cVarKclass = D0.kclass(pVar);
        boolean zB = pVar.b();
        List<t> arguments = pVar.getArguments();
        ArrayList arrayList = new ArrayList(J.collectionSizeOrDefault(arguments, 10));
        Iterator<T> it = arguments.iterator();
        while (it.hasNext()) {
            arrayList.add(D0.typeOrThrow((t) it.next()));
        }
        if (arrayList.isEmpty()) {
            if (!C0.isInterface(cVarKclass) || gVar.getContextual(cVarKclass, I.emptyList()) == null) {
                bVarFindCachedSerializer = o.findCachedSerializer(cVarKclass, zB);
            } else {
                bVarFindCachedSerializer = null;
            }
        } else if (((e) gVar).f7850a) {
            bVarFindCachedSerializer = null;
        } else {
            Object objFindParametrizedCachedSerializer = o.findParametrizedCachedSerializer(cVarKclass, arrayList, zB);
            if (objFindParametrizedCachedSerializer instanceof u.a) {
                objFindParametrizedCachedSerializer = null;
            }
            bVarFindCachedSerializer = (b) objFindParametrizedCachedSerializer;
        }
        if (bVarFindCachedSerializer != null) {
            return bVarFindCachedSerializer;
        }
        if (arrayList.isEmpty()) {
            contextual = p.serializerOrNull(cVarKclass);
            if (contextual == null && (contextual = gVar.getContextual(cVarKclass, I.emptyList())) == null) {
                if (C0.isInterface(cVarKclass)) {
                    eVar = new e(cVarKclass);
                    contextual = eVar;
                } else {
                    contextual = null;
                }
            }
            if (contextual != null) {
                if (zB) {
                    return a.getNullable(contextual);
                }
                return contextual;
            }
        } else {
            List<b> listSerializersForParameters = p.serializersForParameters(gVar, arrayList, z6);
            if (listSerializersForParameters != null) {
                b bVarParametrizedSerializerOrNull = p.parametrizedSerializerOrNull(cVarKclass, listSerializersForParameters, new C0152u(arrayList, 9));
                if (bVarParametrizedSerializerOrNull == null) {
                    contextual = gVar.getContextual(cVarKclass, listSerializersForParameters);
                    if (contextual == null) {
                        if (C0.isInterface(cVarKclass)) {
                            eVar = new e(cVarKclass);
                            contextual = eVar;
                        } else {
                            contextual = null;
                        }
                    }
                } else {
                    contextual = bVarParametrizedSerializerOrNull;
                }
                if (contextual != null) {
                    if (zB) {
                        return a.getNullable(contextual);
                    }
                    return contextual;
                }
            }
        }
        return null;
    }

    public static final b moduleThenPolymorphic(g module, c kClass) {
        E.f(module, "module");
        E.f(kClass, "kClass");
        b contextual = module.getContextual(kClass, I.emptyList());
        return contextual == null ? new e(kClass) : contextual;
    }

    public static final b noCompiledSerializer(String forClass) {
        E.f(forClass, "forClass");
        throw new l(D0.notRegisteredMessage(forClass));
    }

    public static final b parametrizedSerializerOrNull(c cVar, List<? extends b> serializers, O3.a elementClassifierIfArray) {
        b c1307f;
        E.f(cVar, "<this>");
        E.f(serializers, "serializers");
        E.f(elementClassifierIfArray, "elementClassifierIfArray");
        if (cVar.equals(U.a(Collection.class)) || cVar.equals(U.a(List.class)) || cVar.equals(U.a(List.class)) || cVar.equals(U.a(ArrayList.class))) {
            c1307f = new C1307f(serializers.get(0));
        } else if (cVar.equals(U.a(HashSet.class))) {
            c1307f = new T(serializers.get(0));
        } else if (cVar.equals(U.a(Set.class)) || cVar.equals(U.a(Set.class)) || cVar.equals(U.a(LinkedHashSet.class))) {
            c1307f = new C1310g0(serializers.get(0));
        } else if (cVar.equals(U.a(HashMap.class))) {
            c1307f = new Q(serializers.get(0), serializers.get(1));
        } else if (cVar.equals(U.a(Map.class)) || cVar.equals(U.a(Map.class)) || cVar.equals(U.a(LinkedHashMap.class))) {
            c1307f = new C1306e0(serializers.get(0), serializers.get(1));
        } else if (cVar.equals(U.a(Map.Entry.class))) {
            c1307f = a.MapEntrySerializer(serializers.get(0), serializers.get(1));
        } else if (cVar.equals(U.a(C1938s.class))) {
            c1307f = a.PairSerializer(serializers.get(0), serializers.get(1));
        } else if (cVar.equals(U.a(z.class))) {
            c1307f = a.TripleSerializer(serializers.get(0), serializers.get(1), serializers.get(2));
        } else if (C0.isReferenceArray(cVar)) {
            Object objInvoke = elementClassifierIfArray.invoke();
            E.d(objInvoke, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            c1307f = a.ArraySerializer((c) objInvoke, serializers.get(0));
        } else {
            c1307f = null;
        }
        if (c1307f != null) {
            return c1307f;
        }
        b[] bVarArr = (b[]) serializers.toArray(new b[0]);
        return C0.constructSerializerForGivenTypeArgs(cVar, (b[]) Arrays.copyOf(bVarArr, bVarArr.length));
    }

    public static final b serializer(p type) {
        E.f(type, "type");
        return p.serializer(i.EmptySerializersModule(), type);
    }

    public static final b serializerOrNull(p type) {
        E.f(type, "type");
        return p.serializerOrNull(i.EmptySerializersModule(), type);
    }

    public static final List<b> serializersForParameters(g gVar, List<? extends p> typeArguments, boolean z6) {
        E.f(gVar, "<this>");
        E.f(typeArguments, "typeArguments");
        if (z6) {
            ArrayList arrayList = new ArrayList(J.collectionSizeOrDefault(typeArguments, 10));
            Iterator<T> it = typeArguments.iterator();
            while (it.hasNext()) {
                arrayList.add(p.serializer(gVar, (p) it.next()));
            }
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(J.collectionSizeOrDefault(typeArguments, 10));
        Iterator<T> it2 = typeArguments.iterator();
        while (it2.hasNext()) {
            b bVarSerializerOrNull = p.serializerOrNull(gVar, (p) it2.next());
            if (bVarSerializerOrNull == null) {
                return null;
            }
            arrayList2.add(bVarSerializerOrNull);
        }
        return arrayList2;
    }

    public static final b moduleThenPolymorphic(g module, c kClass, b[] argSerializers) {
        E.f(module, "module");
        E.f(kClass, "kClass");
        E.f(argSerializers, "argSerializers");
        b contextual = module.getContextual(kClass, AbstractC0151t.asList(argSerializers));
        return contextual == null ? new e(kClass) : contextual;
    }

    public static final b noCompiledSerializer(g module, c kClass) {
        E.f(module, "module");
        E.f(kClass, "kClass");
        b contextual = module.getContextual(kClass, I.emptyList());
        if (contextual != null) {
            return contextual;
        }
        D0.serializerNotRegistered(kClass);
        throw new C1929i();
    }

    public static final b serializer(c kClass, List<? extends b> typeArgumentsSerializers, boolean z6) {
        E.f(kClass, "kClass");
        E.f(typeArgumentsSerializers, "typeArgumentsSerializers");
        return p.serializer(i.EmptySerializersModule(), kClass, typeArgumentsSerializers, z6);
    }

    public static final b serializerOrNull(g gVar, p type) {
        E.f(gVar, "<this>");
        E.f(type, "type");
        return a(gVar, type, false);
    }

    public static final b serializer(g gVar, p type) {
        E.f(gVar, "<this>");
        E.f(type, "type");
        b bVarA = a(gVar, type, true);
        if (bVarA != null) {
            return bVarA;
        }
        C0.platformSpecificSerializerNotRegistered(D0.kclass(type));
        throw new C1929i();
    }

    public static final <T> b serializerOrNull(c cVar) {
        E.f(cVar, "<this>");
        b bVarCompiledSerializerImpl = C0.compiledSerializerImpl(cVar);
        return bVarCompiledSerializerImpl == null ? N0.builtinSerializerOrNull(cVar) : bVarCompiledSerializerImpl;
    }

    public static final b noCompiledSerializer(g module, c kClass, b[] argSerializers) {
        E.f(module, "module");
        E.f(kClass, "kClass");
        E.f(argSerializers, "argSerializers");
        b contextual = module.getContextual(kClass, AbstractC0151t.asList(argSerializers));
        if (contextual != null) {
            return contextual;
        }
        D0.serializerNotRegistered(kClass);
        throw new C1929i();
    }

    public static final b serializer(g gVar, c kClass, List<? extends b> typeArgumentsSerializers, boolean z6) {
        b contextual;
        E.f(gVar, "<this>");
        E.f(kClass, "kClass");
        E.f(typeArgumentsSerializers, "typeArgumentsSerializers");
        if (typeArgumentsSerializers.isEmpty()) {
            contextual = p.serializerOrNull(kClass);
            if (contextual == null) {
                contextual = gVar.getContextual(kClass, I.emptyList());
            }
        } else {
            try {
                b bVarParametrizedSerializerOrNull = p.parametrizedSerializerOrNull(kClass, typeArgumentsSerializers, new d(6));
                contextual = bVarParametrizedSerializerOrNull == null ? gVar.getContextual(kClass, typeArgumentsSerializers) : bVarParametrizedSerializerOrNull;
            } catch (IndexOutOfBoundsException e) {
                throw new l("Unable to retrieve a serializer, the number of passed type serializers differs from the actual number of generic parameters", e);
            }
        }
        if (contextual == null) {
            contextual = null;
        } else if (z6) {
            contextual = a.getNullable(contextual);
        }
        if (contextual != null) {
            return contextual;
        }
        C0.platformSpecificSerializerNotRegistered(kClass);
        throw new C1929i();
    }

    public static final <T> b serializer(c cVar) {
        E.f(cVar, "<this>");
        b bVarSerializerOrNull = p.serializerOrNull(cVar);
        if (bVarSerializerOrNull != null) {
            return bVarSerializerOrNull;
        }
        D0.serializerNotRegistered(cVar);
        throw new C1929i();
    }
}
