package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class j {
    public static final h b = new h();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f2920a = new HashMap();

    @NonNull
    public synchronized <T> g build(@NonNull T t6) {
        f fVar;
        try {
            L0.q.checkNotNull(t6);
            fVar = (f) this.f2920a.get(t6.getClass());
            if (fVar == null) {
                for (f fVar2 : this.f2920a.values()) {
                    if (fVar2.getDataClass().isAssignableFrom(t6.getClass())) {
                        fVar = fVar2;
                        break;
                    }
                }
            }
            if (fVar == null) {
                fVar = b;
            }
        } catch (Throwable th) {
            throw th;
        }
        return fVar.build(t6);
    }

    public synchronized void register(@NonNull f fVar) {
        this.f2920a.put(fVar.getDataClass(), fVar);
    }
}
