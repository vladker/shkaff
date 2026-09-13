package com.appdev.standard.page.printerlabel;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2712a;
    public final /* synthetic */ Integer b;
    public final /* synthetic */ int c;

    public /* synthetic */ C(Integer num, int i5, int i6) {
        this.f2712a = i6;
        this.b = num;
        this.c = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2712a) {
            case 0:
                PDFPrintActivity.AnonymousClass12.lambda$run$2(this.b, this.c);
                break;
            case 1:
                PDFPrintActivity.AnonymousClass12.lambda$run$0(this.b, this.c);
                break;
            case 2:
                PicturePrintActivity.AnonymousClass13.lambda$run$0(this.b, this.c);
                break;
            default:
                PicturePrintActivity.AnonymousClass13.lambda$run$2(this.b, this.c);
                break;
        }
    }
}
