package com.google.android.gms.internal.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public interface zaq {
    ExecutorService zaa(ThreadFactory threadFactory, int i5);

    ExecutorService zab(int i5, int i6);

    ExecutorService zac(int i5, ThreadFactory threadFactory, int i6);
}
