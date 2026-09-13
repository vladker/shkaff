package p095q4;

import A3.m0;
import O3.l;
import V3.c;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.E;
import org.apache.logging.log4j.util.Chars;
import p060k4.b;
import p084o4.C0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class h implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f7851a;
    private final Map<c, c> class2ContextualProvider = new HashMap();
    private final Map<c, Map<c, b>> polyBase2Serializers = new HashMap();
    private final Map<c, l> polyBase2DefaultSerializerProvider = new HashMap();
    private final Map<c, Map<String, b>> polyBase2NamedSerializers = new HashMap();
    private final Map<c, l> polyBase2DefaultDeserializerProvider = new HashMap();

    public final g build() {
        return new e(this.class2ContextualProvider, this.polyBase2Serializers, this.polyBase2DefaultSerializerProvider, this.polyBase2NamedSerializers, this.polyBase2DefaultDeserializerProvider, this.f7851a);
    }

    @Override // p095q4.k
    public <T> void contextual(c kClass, b serializer) {
        E.f(kClass, "kClass");
        E.f(serializer, "serializer");
        registerSerializer(kClass, new a(serializer), false);
    }

    public final void include(g module) {
        E.f(module, "module");
        module.dumpTo(this);
    }

    @Override // p095q4.k
    public <Base, Sub extends Base> void polymorphic(c baseClass, c actualClass, b actualSerializer) {
        E.f(baseClass, "baseClass");
        E.f(actualClass, "actualClass");
        E.f(actualSerializer, "actualSerializer");
        registerPolymorphicSerializer(baseClass, actualClass, actualSerializer, false);
    }

    @Override // p095q4.k
    public <Base> void polymorphicDefault(c cVar, l lVar) {
        j.polymorphicDefault(this, cVar, lVar);
    }

    @Override // p095q4.k
    public <Base> void polymorphicDefaultDeserializer(c baseClass, l defaultDeserializerProvider) {
        E.f(baseClass, "baseClass");
        E.f(defaultDeserializerProvider, "defaultDeserializerProvider");
        registerDefaultPolymorphicDeserializer(baseClass, defaultDeserializerProvider, false);
    }

    @Override // p095q4.k
    public <Base> void polymorphicDefaultSerializer(c baseClass, l defaultSerializerProvider) {
        E.f(baseClass, "baseClass");
        E.f(defaultSerializerProvider, "defaultSerializerProvider");
        registerDefaultPolymorphicSerializer(baseClass, defaultSerializerProvider, false);
    }

    public final <Base> void registerDefaultPolymorphicDeserializer(c baseClass, l defaultDeserializerProvider, boolean z6) {
        E.f(baseClass, "baseClass");
        E.f(defaultDeserializerProvider, "defaultDeserializerProvider");
        l lVar = this.polyBase2DefaultDeserializerProvider.get(baseClass);
        if (lVar == null || lVar.equals(defaultDeserializerProvider) || z6) {
            this.polyBase2DefaultDeserializerProvider.put(baseClass, defaultDeserializerProvider);
            return;
        }
        throw new IllegalArgumentException("Default deserializers provider for " + baseClass + " is already registered: " + lVar);
    }

    public final <Base> void registerDefaultPolymorphicSerializer(c baseClass, l defaultSerializerProvider, boolean z6) {
        E.f(baseClass, "baseClass");
        E.f(defaultSerializerProvider, "defaultSerializerProvider");
        l lVar = this.polyBase2DefaultSerializerProvider.get(baseClass);
        if (lVar == null || lVar.equals(defaultSerializerProvider) || z6) {
            this.polyBase2DefaultSerializerProvider.put(baseClass, defaultSerializerProvider);
            return;
        }
        throw new IllegalArgumentException("Default serializers provider for " + baseClass + " is already registered: " + lVar);
    }

    public final <Base, Sub extends Base> void registerPolymorphicSerializer(c baseClass, c concreteClass, b concreteSerializer, boolean z6) {
        E.f(baseClass, "baseClass");
        E.f(concreteClass, "concreteClass");
        E.f(concreteSerializer, "concreteSerializer");
        String serialName = concreteSerializer.getDescriptor().getSerialName();
        Map<c, Map<c, b>> map = this.polyBase2Serializers;
        Map<c, b> map2 = map.get(baseClass);
        if (map2 == null) {
            map2 = new HashMap<>();
            map.put(baseClass, map2);
        }
        Map<c, b> map3 = map2;
        b bVar = map3.get(concreteClass);
        Map<c, Map<String, b>> map4 = this.polyBase2NamedSerializers;
        Map<String, b> map5 = map4.get(baseClass);
        if (map5 == null) {
            map5 = new HashMap<>();
            map4.put(baseClass, map5);
        }
        Map<String, b> map6 = map5;
        if (z6) {
            if (bVar != null) {
                map6.remove(bVar.getDescriptor().getSerialName());
            }
            map3.put(concreteClass, concreteSerializer);
            map6.put(serialName, concreteSerializer);
            return;
        }
        if (bVar != null) {
            if (!bVar.equals(concreteSerializer)) {
                throw new f(baseClass, concreteClass);
            }
            map6.remove(bVar.getDescriptor().getSerialName());
        }
        b bVar2 = map6.get(serialName);
        if (bVar2 == null) {
            map3.put(concreteClass, concreteSerializer);
            map6.put(serialName, concreteSerializer);
            return;
        }
        Map<c, b> map7 = this.polyBase2Serializers.get(baseClass);
        E.c(map7);
        for (Object obj : m0.asSequence(map7)) {
            if (((Map.Entry) obj).getValue() == bVar2) {
                throw new IllegalArgumentException("Multiple polymorphic serializers for base class '" + baseClass + "' have the same serial name '" + serialName + "': '" + concreteClass + "' and '" + ((Map.Entry) obj) + Chars.QUOTE);
            }
        }
        obj = null;
        throw new IllegalArgumentException("Multiple polymorphic serializers for base class '" + baseClass + "' have the same serial name '" + serialName + "': '" + concreteClass + "' and '" + ((Map.Entry) obj) + Chars.QUOTE);
    }

    public final <T> void registerSerializer(c forClass, c provider, boolean z6) {
        c cVar;
        E.f(forClass, "forClass");
        E.f(provider, "provider");
        if (!z6 && (cVar = this.class2ContextualProvider.get(forClass)) != null && !cVar.equals(provider)) {
            throw new f("Contextual serializer or serializer provider for " + forClass + " already registered in this module");
        }
        this.class2ContextualProvider.put(forClass, provider);
        if (C0.isInterface(forClass)) {
            this.f7851a = true;
        }
    }

    @Override // p095q4.k
    public <T> void contextual(c kClass, l provider) {
        E.f(kClass, "kClass");
        E.f(provider, "provider");
        registerSerializer(kClass, new b(provider), false);
    }
}
