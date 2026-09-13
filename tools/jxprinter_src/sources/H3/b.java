package H3;

import kotlin.jvm.internal.E;
import p147z3.r;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    public static final /* synthetic */ <T extends Enum<T>> a enumEntries() {
        throw new r();
    }

    public static final <E extends Enum<E>> a enumEntries(O3.a entriesProvider) {
        E.f(entriesProvider, "entriesProvider");
        return new c((Enum[]) entriesProvider.invoke());
    }

    public static final <E extends Enum<E>> a enumEntries(E[] entries) {
        E.f(entries, "entries");
        return new c(entries);
    }
}
