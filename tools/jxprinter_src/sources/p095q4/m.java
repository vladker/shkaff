package p095q4;

import A3.k0;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class m {
    private static final g EmptySerializersModule = new e(k0.emptyMap(), k0.emptyMap(), k0.emptyMap(), k0.emptyMap(), k0.emptyMap(), false);

    public static final g getEmptySerializersModule() {
        return EmptySerializersModule;
    }

    public static final g overwriteWith(g gVar, g other) {
        E.f(gVar, "<this>");
        E.f(other, "other");
        h hVar = new h();
        hVar.include(gVar);
        other.dumpTo(new l(hVar));
        return hVar.build();
    }

    public static final g plus(g gVar, g other) {
        E.f(gVar, "<this>");
        E.f(other, "other");
        h hVar = new h();
        hVar.include(gVar);
        hVar.include(other);
        return hVar.build();
    }

    public static /* synthetic */ void getEmptySerializersModule$annotations() {
    }
}
