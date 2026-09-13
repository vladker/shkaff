package com.appdev.standard.page.printerlabel;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class D implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2713a;
    public final /* synthetic */ p056k0.m b;
    public final /* synthetic */ int c;
    public final /* synthetic */ String d;
    public final /* synthetic */ p056k0.l e;

    public /* synthetic */ D(p056k0.l lVar, p056k0.m mVar, int i5, String str, int i6) {
        this.f2713a = i6;
        this.e = lVar;
        this.b = mVar;
        this.c = i5;
        this.d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2713a) {
            case 0:
                ((PDFPrintActivity.AnonymousClass17) this.e).lambda$onState$0(this.b, this.c, this.d);
                break;
            default:
                ((PicturePrintActivity.AnonymousClass16) this.e).lambda$onState$0(this.b, this.c, this.d);
                break;
        }
    }
}
