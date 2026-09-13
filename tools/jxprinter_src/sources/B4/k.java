package B4;

import kotlin.jvm.internal.E;
import kotlin.jvm.internal.F;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class k extends F implements O3.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f110a = new k(1);

    @Override // O3.l
    public final Boolean invoke(o entry) {
        E.f(entry, "entry");
        return Boolean.valueOf(l.a(n.Companion, entry.getCanonicalPath()));
    }
}
