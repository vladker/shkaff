package p095q4;

import V3.c;
import kotlin.jvm.internal.E;
import p060k4.b;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class l implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f7852a;

    public l(h hVar) {
        this.f7852a = hVar;
    }

    @Override // p095q4.k
    public final void contextual(c kClass, b serializer) {
        E.f(kClass, "kClass");
        E.f(serializer, "serializer");
        this.f7852a.registerSerializer(kClass, new a(serializer), true);
    }

    @Override // p095q4.k
    public final void polymorphic(c baseClass, c actualClass, b actualSerializer) {
        E.f(baseClass, "baseClass");
        E.f(actualClass, "actualClass");
        E.f(actualSerializer, "actualSerializer");
        this.f7852a.registerPolymorphicSerializer(baseClass, actualClass, actualSerializer, true);
    }

    @Override // p095q4.k
    public <Base> void polymorphicDefault(c cVar, O3.l lVar) {
        j.polymorphicDefault(this, cVar, lVar);
    }

    @Override // p095q4.k
    public final void polymorphicDefaultDeserializer(c baseClass, O3.l defaultDeserializerProvider) {
        E.f(baseClass, "baseClass");
        E.f(defaultDeserializerProvider, "defaultDeserializerProvider");
        this.f7852a.registerDefaultPolymorphicDeserializer(baseClass, defaultDeserializerProvider, true);
    }

    @Override // p095q4.k
    public final void polymorphicDefaultSerializer(c baseClass, O3.l defaultSerializerProvider) {
        E.f(baseClass, "baseClass");
        E.f(defaultSerializerProvider, "defaultSerializerProvider");
        this.f7852a.registerDefaultPolymorphicSerializer(baseClass, defaultSerializerProvider, true);
    }

    @Override // p095q4.k
    public final void contextual(c kClass, O3.l provider) {
        E.f(kClass, "kClass");
        E.f(provider, "provider");
        this.f7852a.registerSerializer(kClass, new b(provider), true);
    }
}
