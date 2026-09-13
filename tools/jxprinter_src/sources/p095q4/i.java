package p095q4;

import O3.l;
import V3.c;
import kotlin.jvm.internal.E;
import p060k4.b;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class i {
    public static final g EmptySerializersModule() {
        return m.getEmptySerializersModule();
    }

    public static final g SerializersModule(l builderAction) {
        E.f(builderAction, "builderAction");
        h hVar = new h();
        builderAction.invoke(hVar);
        return hVar.build();
    }

    public static final <Base> void polymorphic(h hVar, c baseClass, b bVar, l builderAction) {
        E.f(hVar, "<this>");
        E.f(baseClass, "baseClass");
        E.f(builderAction, "builderAction");
        d dVar = new d(baseClass, bVar);
        builderAction.invoke(dVar);
        dVar.buildTo(hVar);
    }

    public static final <T> g serializersModuleOf(c kClass, b serializer) {
        E.f(kClass, "kClass");
        E.f(serializer, "serializer");
        h hVar = new h();
        hVar.contextual(kClass, serializer);
        return hVar.build();
    }
}
