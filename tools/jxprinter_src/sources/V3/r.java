package V3;

import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class r {
    public final t contravariant(p type) {
        E.f(type, "type");
        return new t(u.b, type);
    }

    public final t covariant(p type) {
        E.f(type, "type");
        return new t(u.c, type);
    }

    public final t getSTAR() {
        return t.star;
    }

    public final t invariant(p type) {
        E.f(type, "type");
        return new t(u.f762a, type);
    }

    public static /* synthetic */ void getStar$annotations() {
    }
}
