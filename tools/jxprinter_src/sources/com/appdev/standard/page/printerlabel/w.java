package com.appdev.standard.page.printerlabel;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class w implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2809a;
    public final /* synthetic */ Uri b;

    public /* synthetic */ w(Uri uri, int i5) {
        this.f2809a = i5;
        this.b = uri;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2809a) {
            case 0:
                ElementAllFragment.lambda$selectPicture$1(this.b);
                break;
            default:
                MaterialLibraryPageActivity.lambda$downloadAndSaveImage$3(this.b);
                break;
        }
    }
}
