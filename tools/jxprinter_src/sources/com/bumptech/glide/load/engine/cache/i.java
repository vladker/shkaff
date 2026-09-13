package com.bumptech.glide.load.engine.cache;

import android.app.ActivityManager;
import android.content.Context;
import androidx.annotation.VisibleForTesting;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class i {

    @VisibleForTesting
    static final int MEMORY_CACHE_TARGET_SCREENS = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3007a;
    public ActivityManager b;
    public j c;
    public final float d;

    public i(Context context) {
        this.d = 1;
        this.f3007a = context;
        this.b = (ActivityManager) context.getSystemService("activity");
        this.c = new p075n1.a(context.getResources().getDisplayMetrics(), 8);
        if (k.isLowMemoryDevice(this.b)) {
            this.d = 0.0f;
        }
    }

    @VisibleForTesting
    public i setActivityManager(ActivityManager activityManager) {
        this.b = activityManager;
        return this;
    }

    @VisibleForTesting
    public i setScreenDimensions(j jVar) {
        this.c = jVar;
        return this;
    }
}
