package com.appdev.standard.util.fileDownload;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class h {
    public abstract void onError(String str, Throwable th);

    public abstract void onSuccess(String str);

    public void onExists() {
    }

    public void onStartShowLoading() {
    }

    public void onDeleted(String str) {
    }

    public void onPaused(String str) {
    }

    public void onStart(a aVar) {
    }

    public void onProgress(String str, long j6, long j7, boolean z6) {
    }
}
