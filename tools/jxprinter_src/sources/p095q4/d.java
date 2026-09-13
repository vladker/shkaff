package p095q4;

import O3.l;
import V3.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.E;
import p060k4.b;
import p147z3.A;
import p147z3.C1938s;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class d {
    private final c baseClass;
    private final b baseSerializer;
    private l defaultDeserializerProvider;
    private l defaultSerializerProvider;
    private final List<C1938s> subclasses;

    public d(c baseClass, b bVar) {
        E.f(baseClass, "baseClass");
        this.baseClass = baseClass;
        this.baseSerializer = bVar;
        this.subclasses = new ArrayList();
    }

    public final void buildTo(h builder) {
        E.f(builder, "builder");
        b bVar = this.baseSerializer;
        if (bVar != null) {
            c cVar = this.baseClass;
            builder.registerPolymorphicSerializer(cVar, cVar, bVar, false);
        }
        for (C1938s c1938s : this.subclasses) {
            c cVar2 = (c) c1938s.f9134a;
            b bVar2 = (b) c1938s.b;
            c cVar3 = this.baseClass;
            E.d(cVar2, "null cannot be cast to non-null type kotlin.reflect.KClass<Base of kotlinx.serialization.modules.PolymorphicModuleBuilder>");
            E.d(bVar2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            builder.registerPolymorphicSerializer(cVar3, cVar2, bVar2, false);
        }
        l lVar = this.defaultSerializerProvider;
        if (lVar != null) {
            builder.registerDefaultPolymorphicSerializer(this.baseClass, lVar, false);
        }
        l lVar2 = this.defaultDeserializerProvider;
        if (lVar2 != null) {
            builder.registerDefaultPolymorphicDeserializer(this.baseClass, lVar2, false);
        }
    }

    /* JADX INFO: renamed from: default, reason: not valid java name */
    public final void m1094default(l defaultSerializerProvider) {
        E.f(defaultSerializerProvider, "defaultSerializerProvider");
        defaultDeserializer(defaultSerializerProvider);
    }

    public final void defaultDeserializer(l defaultDeserializerProvider) {
        E.f(defaultDeserializerProvider, "defaultDeserializerProvider");
        if (this.defaultDeserializerProvider == null) {
            this.defaultDeserializerProvider = defaultDeserializerProvider;
            return;
        }
        throw new IllegalArgumentException(("Default deserializer provider is already registered for class " + this.baseClass + ": " + this.defaultDeserializerProvider).toString());
    }

    public final <T> void subclass(c subclass, b serializer) {
        E.f(subclass, "subclass");
        E.f(serializer, "serializer");
        this.subclasses.add(A.to(subclass, serializer));
    }
}
