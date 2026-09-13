package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: renamed from: com.bumptech.glide.load.engine.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class ThreadFactoryC0485a implements ThreadFactory {
    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(@NonNull Runnable runnable) {
        return new Thread(new H2.c(runnable, 11), "glide-active-resources");
    }
}
