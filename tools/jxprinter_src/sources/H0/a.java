package H0;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f282a;
    public final p126w0.d b;

    public a(@NonNull Class<Object> cls, @NonNull p126w0.d dVar) {
        this.f282a = cls;
        this.b = dVar;
    }

    public boolean handles(@NonNull Class<?> cls) {
        return this.f282a.isAssignableFrom(cls);
    }
}
