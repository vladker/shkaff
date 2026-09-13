package com.bumptech.glide;

import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f2913a;

    public l(p075n1.a aVar) {
        this.f2913a = Collections.unmodifiableMap(new HashMap((HashMap) aVar.b));
    }

    @Nullable
    public <T extends k> T get(Class<T> cls) {
        if (this.f2913a.get(cls) == null) {
            return null;
        }
        throw new ClassCastException();
    }
}
