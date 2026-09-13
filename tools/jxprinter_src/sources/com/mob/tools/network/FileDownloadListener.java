package com.mob.tools.network;

import com.mob.tools.proguard.EverythingKeeper;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public abstract class FileDownloadListener implements EverythingKeeper {
    private boolean isCanceled = false;

    public void cancel() {
        this.isCanceled = true;
    }

    public boolean isCanceled() {
        return this.isCanceled;
    }

    public abstract void onProgress(int i5, long j6, long j7);
}
