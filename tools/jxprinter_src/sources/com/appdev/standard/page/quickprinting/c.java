package com.appdev.standard.page.quickprinting;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2826a;

    public /* synthetic */ c(int i5) {
        this.f2826a = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2826a) {
            case 0:
                QuickPrintingActivity.AnonymousClass9.lambda$run$0();
                break;
            case 1:
                QuickPrintingActivity.AnonymousClass9.lambda$run$2();
                break;
            case 2:
                QuickPrintingActivity.AnonymousClass9.lambda$run$3();
                break;
            case 3:
                QuickPrintingActivity.lambda$printTextBitmap$1();
                break;
            default:
                QuickPrintingActivity.lambda$printTextBitmap$3();
                break;
        }
    }
}
