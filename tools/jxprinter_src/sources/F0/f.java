package F0;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f240a;
    public final Class b;
    public final e c;

    public f(@NonNull Class<Object> cls, @NonNull Class<Object> cls2, @NonNull e eVar) {
        this.f240a = cls;
        this.b = cls2;
        this.c = eVar;
    }

    public boolean handles(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
        return this.f240a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.b);
    }
}
