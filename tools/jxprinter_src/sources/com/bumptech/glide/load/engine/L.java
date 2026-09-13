package com.bumptech.glide.load.engine;

import androidx.annotation.VisibleForTesting;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class L {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f2962a = new HashMap();
    public final HashMap b = new HashMap();

    @VisibleForTesting
    public Map<p126w0.q, C> getAll() {
        return Collections.unmodifiableMap(this.f2962a);
    }
}
