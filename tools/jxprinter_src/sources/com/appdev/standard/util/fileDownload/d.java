package com.appdev.standard.util.fileDownload;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements p027e3.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2843a;

    public d(String str) {
        this.f2843a = str;
    }

    @Override // p027e3.g
    public void accept(Throwable th) {
        Log.e("rustAppDownloadCenter", "accept on error: " + this.f2843a, th);
    }
}
