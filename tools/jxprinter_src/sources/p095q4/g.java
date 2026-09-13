package p095q4;

import A3.I;
import V3.c;
import java.util.List;
import kotlin.jvm.internal.E;
import p060k4.a;
import p060k4.b;
import p060k4.m;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class g {
    public abstract void dumpTo(k kVar);

    public final /* synthetic */ b getContextual(c kclass) {
        E.f(kclass, "kclass");
        return getContextual(kclass, I.emptyList());
    }

    public abstract <T> b getContextual(c cVar, List<? extends b> list);

    public abstract <T> a getPolymorphic(c cVar, String str);

    public abstract <T> m getPolymorphic(c cVar, T t6);

    public static /* synthetic */ void getHasInterfaceContextualSerializers$kotlinx_serialization_core$annotations() {
    }
}
