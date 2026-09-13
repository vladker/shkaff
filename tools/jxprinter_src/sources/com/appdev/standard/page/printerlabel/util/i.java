package com.appdev.standard.page.printerlabel.util;

import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2789a;
    public final /* synthetic */ DataCreateUtil.StreamPrintListener b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Looper d;

    public /* synthetic */ i(DataCreateUtil.StreamPrintListener streamPrintListener, int i5, Looper looper, int i6) {
        this.f2789a = i6;
        this.b = streamPrintListener;
        this.c = i5;
        this.d = looper;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2789a) {
            case 0:
                DataCreateUtil.lambda$processESCPageByPage$1(this.b, this.c, this.d);
                break;
            default:
                DataCreateUtil.lambda$processTSCPageByPage$5(this.b, this.c, this.d);
                break;
        }
    }
}
