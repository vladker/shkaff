package p060k4;

import O3.a;
import V3.c;
import java.lang.reflect.Type;
import java.util.List;
import p095q4.g;

/* JADX INFO: loaded from: classes3.dex */
public abstract class p {
    public static final b moduleThenPolymorphic(g gVar, c cVar) {
        return r.moduleThenPolymorphic(gVar, cVar);
    }

    public static final b noCompiledSerializer(String str) {
        return r.noCompiledSerializer(str);
    }

    public static final b parametrizedSerializerOrNull(c cVar, List<? extends b> list, a aVar) {
        return r.parametrizedSerializerOrNull(cVar, list, aVar);
    }

    public static final <T> b serializer(c cVar) {
        return r.serializer(cVar);
    }

    public static final <T> b serializerOrNull(c cVar) {
        return r.serializerOrNull(cVar);
    }

    public static final List<b> serializersForParameters(g gVar, List<? extends V3.p> list, boolean z6) {
        return r.serializersForParameters(gVar, list, z6);
    }

    public static final b moduleThenPolymorphic(g gVar, c cVar, b[] bVarArr) {
        return r.moduleThenPolymorphic(gVar, cVar, bVarArr);
    }

    public static final b noCompiledSerializer(g gVar, c cVar) {
        return r.noCompiledSerializer(gVar, cVar);
    }

    public static final b serializer(c cVar, List<? extends b> list, boolean z6) {
        return r.serializer(cVar, list, z6);
    }

    public static final b serializerOrNull(V3.p pVar) {
        return r.serializerOrNull(pVar);
    }

    public static final b noCompiledSerializer(g gVar, c cVar, b[] bVarArr) {
        return r.noCompiledSerializer(gVar, cVar, bVarArr);
    }

    public static final b serializer(V3.p pVar) {
        return r.serializer(pVar);
    }

    public static final b serializerOrNull(Type type) {
        return q.serializerOrNull(type);
    }

    public static final b serializer(Type type) {
        return q.serializer(type);
    }

    public static final b serializerOrNull(g gVar, V3.p pVar) {
        return r.serializerOrNull(gVar, pVar);
    }

    public static final b serializer(g gVar, c cVar, List<? extends b> list, boolean z6) {
        return r.serializer(gVar, cVar, list, z6);
    }

    public static final b serializerOrNull(g gVar, Type type) {
        return q.serializerOrNull(gVar, type);
    }

    public static final b serializer(g gVar, V3.p pVar) {
        return r.serializer(gVar, pVar);
    }

    public static final b serializer(g gVar, Type type) {
        return q.serializer(gVar, type);
    }
}
