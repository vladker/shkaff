package E3;

import java.io.Serializable;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class r implements q, Serializable {
    public static final r INSTANCE = new r();
    private static final long serialVersionUID = 0;

    private final Object readResolve() {
        return INSTANCE;
    }

    @Override // E3.q
    public <R> R fold(R r6, O3.p operation) {
        E.f(operation, "operation");
        return r6;
    }

    @Override // E3.q
    public <E extends o> E get(p key) {
        E.f(key, "key");
        return null;
    }

    public final int hashCode() {
        return 0;
    }

    @Override // E3.q
    public q minusKey(p key) {
        E.f(key, "key");
        return this;
    }

    @Override // E3.q
    public q plus(q context) {
        E.f(context, "context");
        return context;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
