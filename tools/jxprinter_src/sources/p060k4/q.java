package p060k4;

import A3.C;
import A3.I;
import A3.J;
import N3.a;
import V3.c;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.U;
import p084o4.C0;
import p084o4.N0;
import p095q4.g;
import p095q4.i;
import p147z3.C1929i;
import p147z3.C1938s;
import p147z3.z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class q {
    public static final Class a(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            E.e(rawType, "getRawType(...)");
            return a(rawType);
        }
        if (type instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type).getUpperBounds();
            E.e(upperBounds, "getUpperBounds(...)");
            Object objFirst = C.first(upperBounds);
            E.e(objFirst, "first(...)");
            return a((Type) objFirst);
        }
        if (type instanceof GenericArrayType) {
            Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
            E.e(genericComponentType, "getGenericComponentType(...)");
            return a(genericComponentType);
        }
        throw new IllegalArgumentException("type should be an instance of Class<?>, GenericArrayType, ParametrizedType or WildcardType, but actual argument " + type + " has type " + U.a(type.getClass()));
    }

    public static final b b(g gVar, Class cls, List list) throws IllegalAccessException, InvocationTargetException {
        b[] bVarArr = (b[]) list.toArray(new b[0]);
        b bVarConstructSerializerForGivenTypeArgs = C0.constructSerializerForGivenTypeArgs(cls, (b[]) Arrays.copyOf(bVarArr, bVarArr.length));
        if (bVarConstructSerializerForGivenTypeArgs != null) {
            return bVarConstructSerializerForGivenTypeArgs;
        }
        c kotlinClass = a.getKotlinClass(cls);
        b bVarBuiltinSerializerOrNull = N0.builtinSerializerOrNull(kotlinClass);
        if (bVarBuiltinSerializerOrNull != null) {
            return bVarBuiltinSerializerOrNull;
        }
        b contextual = gVar.getContextual(kotlinClass, list);
        if (contextual != null) {
            return contextual;
        }
        if (cls.isInterface()) {
            return new e(a.getKotlinClass(cls));
        }
        return null;
    }

    public static final b c(g gVar, Type type, boolean z6) {
        ArrayList arrayList;
        b bVarSerializerOrNull;
        b bVarSerializerOrNull2;
        c kotlinClass;
        if (type instanceof GenericArrayType) {
            Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
            if (genericComponentType instanceof WildcardType) {
                Type[] upperBounds = ((WildcardType) genericComponentType).getUpperBounds();
                E.e(upperBounds, "getUpperBounds(...)");
                genericComponentType = (Type) C.first(upperBounds);
            }
            E.c(genericComponentType);
            if (z6) {
                bVarSerializerOrNull2 = p.serializer(gVar, genericComponentType);
            } else {
                bVarSerializerOrNull2 = p.serializerOrNull(gVar, genericComponentType);
                if (bVarSerializerOrNull2 == null) {
                    return null;
                }
            }
            if (genericComponentType instanceof ParameterizedType) {
                Type rawType = ((ParameterizedType) genericComponentType).getRawType();
                E.d(rawType, "null cannot be cast to non-null type java.lang.Class<*>");
                kotlinClass = a.getKotlinClass((Class) rawType);
            } else {
                if (!(genericComponentType instanceof c)) {
                    throw new IllegalStateException("unsupported type in GenericArray: " + U.a(genericComponentType.getClass()));
                }
                kotlinClass = (c) genericComponentType;
            }
            E.d(kotlinClass, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            b bVarArraySerializer = p066l4.a.ArraySerializer(kotlinClass, bVarSerializerOrNull2);
            E.d(bVarArraySerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
            return bVarArraySerializer;
        }
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (!cls.isArray() || cls.getComponentType().isPrimitive()) {
                return b(gVar, cls, I.emptyList());
            }
            Class<?> componentType = cls.getComponentType();
            E.e(componentType, "getComponentType(...)");
            if (z6) {
                bVarSerializerOrNull = p.serializer(gVar, componentType);
            } else {
                bVarSerializerOrNull = p.serializerOrNull(gVar, componentType);
                if (bVarSerializerOrNull == null) {
                    return null;
                }
            }
            c kotlinClass2 = a.getKotlinClass(componentType);
            E.d(kotlinClass2, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            b bVarArraySerializer2 = p066l4.a.ArraySerializer(kotlinClass2, bVarSerializerOrNull);
            E.d(bVarArraySerializer2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
            return bVarArraySerializer2;
        }
        if (!(type instanceof ParameterizedType)) {
            if (type instanceof WildcardType) {
                Type[] upperBounds2 = ((WildcardType) type).getUpperBounds();
                E.e(upperBounds2, "getUpperBounds(...)");
                Object objFirst = C.first(upperBounds2);
                E.e(objFirst, "first(...)");
                return c(gVar, (Type) objFirst, true);
            }
            throw new IllegalArgumentException("type should be an instance of Class<?>, GenericArrayType, ParametrizedType or WildcardType, but actual argument " + type + " has type " + U.a(type.getClass()));
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type rawType2 = parameterizedType.getRawType();
        E.d(rawType2, "null cannot be cast to non-null type java.lang.Class<*>");
        Class cls2 = (Class) rawType2;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        int i5 = 0;
        E.c(actualTypeArguments);
        if (z6) {
            arrayList = new ArrayList(actualTypeArguments.length);
            for (Type type2 : actualTypeArguments) {
                E.c(type2);
                arrayList.add(p.serializer(gVar, type2));
            }
        } else {
            arrayList = new ArrayList(actualTypeArguments.length);
            for (Type type3 : actualTypeArguments) {
                E.c(type3);
                b bVarSerializerOrNull3 = p.serializerOrNull(gVar, type3);
                if (bVarSerializerOrNull3 == null) {
                    return null;
                }
                arrayList.add(bVarSerializerOrNull3);
            }
        }
        if (Set.class.isAssignableFrom(cls2)) {
            b bVarSetSerializer = p066l4.a.SetSerializer((b) arrayList.get(0));
            E.d(bVarSetSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
            return bVarSetSerializer;
        }
        if (List.class.isAssignableFrom(cls2) || Collection.class.isAssignableFrom(cls2)) {
            b bVarListSerializer = p066l4.a.ListSerializer((b) arrayList.get(0));
            E.d(bVarListSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
            return bVarListSerializer;
        }
        if (Map.class.isAssignableFrom(cls2)) {
            b bVarMapSerializer = p066l4.a.MapSerializer((b) arrayList.get(0), (b) arrayList.get(1));
            E.d(bVarMapSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
            return bVarMapSerializer;
        }
        if (Map.Entry.class.isAssignableFrom(cls2)) {
            b bVarMapEntrySerializer = p066l4.a.MapEntrySerializer((b) arrayList.get(0), (b) arrayList.get(1));
            E.d(bVarMapEntrySerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
            return bVarMapEntrySerializer;
        }
        if (C1938s.class.isAssignableFrom(cls2)) {
            b bVarPairSerializer = p066l4.a.PairSerializer((b) arrayList.get(0), (b) arrayList.get(1));
            E.d(bVarPairSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
            return bVarPairSerializer;
        }
        if (z.class.isAssignableFrom(cls2)) {
            b bVarTripleSerializer = p066l4.a.TripleSerializer((b) arrayList.get(0), (b) arrayList.get(1), (b) arrayList.get(2));
            E.d(bVarTripleSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
            return bVarTripleSerializer;
        }
        ArrayList arrayList2 = new ArrayList(J.collectionSizeOrDefault(arrayList, 10));
        int size = arrayList.size();
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            b bVar = (b) obj;
            E.d(bVar, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any?>");
            arrayList2.add(bVar);
        }
        return b(gVar, cls2, arrayList2);
    }

    public static final b serializer(Type type) {
        E.f(type, "type");
        return p.serializer(i.EmptySerializersModule(), type);
    }

    public static final b serializerOrNull(Type type) {
        E.f(type, "type");
        return p.serializerOrNull(i.EmptySerializersModule(), type);
    }

    public static final b serializer(g gVar, Type type) {
        E.f(gVar, "<this>");
        E.f(type, "type");
        b bVarC = c(gVar, type, true);
        if (bVarC != null) {
            return bVarC;
        }
        C0.serializerNotRegistered(a(type));
        throw new C1929i();
    }

    public static final b serializerOrNull(g gVar, Type type) {
        E.f(gVar, "<this>");
        E.f(type, "type");
        return c(gVar, type, false);
    }
}
