package H0;

import androidx.annotation.NonNull;
import p126w0.y;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f289a;
    public final y b;

    public h(@NonNull Class<Object> cls, @NonNull y yVar) {
        this.f289a = cls;
        this.b = yVar;
    }

    public boolean handles(@NonNull Class<?> cls) {
        return this.f289a.isAssignableFrom(cls);
    }
}
