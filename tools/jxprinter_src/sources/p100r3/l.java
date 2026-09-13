package p100r3;

import java.io.Serializable;
import p039g3.A;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class l implements Serializable {
    private static final long serialVersionUID = -8759979445933046293L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f7966a;

    public l(Throwable th) {
        this.f7966a = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof l) {
            return A.a(this.f7966a, ((l) obj).f7966a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f7966a.hashCode();
    }

    public final String toString() {
        return "NotificationLite.Error[" + this.f7966a + "]";
    }
}
