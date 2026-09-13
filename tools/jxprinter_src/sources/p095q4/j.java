package p095q4;

import A3.C0130a;
import O3.l;
import V3.c;
import kotlin.jvm.internal.E;
import p060k4.b;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class j {
    public static <T> void contextual(k kVar, c kClass, b serializer) {
        E.f(kClass, "kClass");
        E.f(serializer, "serializer");
        kVar.contextual(kClass, new C0130a(serializer, 21));
    }

    public static <Base> void polymorphicDefault(k kVar, c baseClass, l defaultDeserializerProvider) {
        E.f(baseClass, "baseClass");
        E.f(defaultDeserializerProvider, "defaultDeserializerProvider");
        kVar.polymorphicDefaultDeserializer(baseClass, defaultDeserializerProvider);
    }
}
