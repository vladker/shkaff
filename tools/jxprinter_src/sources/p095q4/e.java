package p095q4;

import O3.l;
import V3.c;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.U;
import kotlin.jvm.internal.Y;
import p060k4.a;
import p060k4.b;
import p060k4.m;
import p147z3.C1937q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class e extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f7850a;
    private final Map<c, c> class2ContextualFactory;
    private final Map<c, l> polyBase2DefaultDeserializerProvider;
    private final Map<c, l> polyBase2DefaultSerializerProvider;
    private final Map<c, Map<String, b>> polyBase2NamedSerializers;
    public final Map<c, Map<c, b>> polyBase2Serializers;

    /* JADX WARN: Multi-variable type inference failed */
    public e(Map<c, ? extends c> class2ContextualFactory, Map<c, ? extends Map<c, ? extends b>> polyBase2Serializers, Map<c, ? extends l> polyBase2DefaultSerializerProvider, Map<c, ? extends Map<String, ? extends b>> polyBase2NamedSerializers, Map<c, ? extends l> polyBase2DefaultDeserializerProvider, boolean z6) {
        E.f(class2ContextualFactory, "class2ContextualFactory");
        E.f(polyBase2Serializers, "polyBase2Serializers");
        E.f(polyBase2DefaultSerializerProvider, "polyBase2DefaultSerializerProvider");
        E.f(polyBase2NamedSerializers, "polyBase2NamedSerializers");
        E.f(polyBase2DefaultDeserializerProvider, "polyBase2DefaultDeserializerProvider");
        this.class2ContextualFactory = class2ContextualFactory;
        this.polyBase2Serializers = polyBase2Serializers;
        this.polyBase2DefaultSerializerProvider = polyBase2DefaultSerializerProvider;
        this.polyBase2NamedSerializers = polyBase2NamedSerializers;
        this.polyBase2DefaultDeserializerProvider = polyBase2DefaultDeserializerProvider;
        this.f7850a = z6;
    }

    @Override // p095q4.g
    public void dumpTo(k collector) {
        E.f(collector, "collector");
        for (Map.Entry<c, c> entry : this.class2ContextualFactory.entrySet()) {
            c key = entry.getKey();
            c value = entry.getValue();
            if (value instanceof a) {
                E.d(key, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                b serializer = ((a) value).getSerializer();
                E.d(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
                collector.contextual(key, serializer);
            } else {
                if (!(value instanceof b)) {
                    throw new C1937q();
                }
                collector.contextual(key, ((b) value).getProvider());
            }
        }
        for (Map.Entry<c, Map<c, b>> entry2 : this.polyBase2Serializers.entrySet()) {
            c key2 = entry2.getKey();
            for (Map.Entry<c, b> entry3 : entry2.getValue().entrySet()) {
                c key3 = entry3.getKey();
                b value2 = entry3.getValue();
                E.d(key2, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                E.d(key3, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                E.d(value2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                collector.polymorphic(key2, key3, value2);
            }
        }
        for (Map.Entry<c, l> entry4 : this.polyBase2DefaultSerializerProvider.entrySet()) {
            c key4 = entry4.getKey();
            l value3 = entry4.getValue();
            E.d(key4, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            E.d(value3, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = \"value\")] kotlin.Any, kotlinx.serialization.SerializationStrategy<kotlin.Any>?>");
            Y.c(1, value3);
            collector.polymorphicDefaultSerializer(key4, value3);
        }
        for (Map.Entry<c, l> entry5 : this.polyBase2DefaultDeserializerProvider.entrySet()) {
            c key5 = entry5.getKey();
            l value4 = entry5.getValue();
            E.d(key5, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            E.d(value4, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = \"className\")] kotlin.String?, kotlinx.serialization.DeserializationStrategy<kotlin.Any>?>");
            Y.c(1, value4);
            collector.polymorphicDefaultDeserializer(key5, value4);
        }
    }

    @Override // p095q4.g
    public <T> b getContextual(c kClass, List<? extends b> typeArgumentsSerializers) {
        E.f(kClass, "kClass");
        E.f(typeArgumentsSerializers, "typeArgumentsSerializers");
        c cVar = this.class2ContextualFactory.get(kClass);
        b bVarInvoke = cVar != null ? cVar.invoke(typeArgumentsSerializers) : null;
        if (bVarInvoke != null) {
            return bVarInvoke;
        }
        return null;
    }

    @Override // p095q4.g
    public <T> m getPolymorphic(c baseClass, T value) {
        E.f(baseClass, "baseClass");
        E.f(value, "value");
        if (baseClass.isInstance(value)) {
            Map<c, b> map = this.polyBase2Serializers.get(baseClass);
            b bVar = map != null ? map.get(U.a(value.getClass())) : null;
            if (bVar == null) {
                bVar = null;
            }
            if (bVar != null) {
                return bVar;
            }
            l lVar = this.polyBase2DefaultSerializerProvider.get(baseClass);
            l lVar2 = Y.g(1, lVar) ? lVar : null;
            if (lVar2 != null) {
                return (m) lVar2.invoke(value);
            }
        }
        return null;
    }

    @Override // p095q4.g
    public <T> a getPolymorphic(c baseClass, String str) {
        E.f(baseClass, "baseClass");
        Map<String, b> map = this.polyBase2NamedSerializers.get(baseClass);
        b bVar = map != null ? map.get(str) : null;
        if (bVar == null) {
            bVar = null;
        }
        if (bVar != null) {
            return bVar;
        }
        l lVar = this.polyBase2DefaultDeserializerProvider.get(baseClass);
        l lVar2 = Y.g(1, lVar) ? lVar : null;
        if (lVar2 != null) {
            return (a) lVar2.invoke(str);
        }
        return null;
    }
}
