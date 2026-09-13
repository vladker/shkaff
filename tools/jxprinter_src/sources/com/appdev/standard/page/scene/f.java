package com.appdev.standard.page.scene;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2834a;
    public final /* synthetic */ Object b;

    public /* synthetic */ f(Object obj, int i5) {
        this.f2834a = i5;
        this.b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2834a) {
            case 0:
                ((CloudSpaceFragment) this.b).lambda$startPrintLabel$8();
                break;
            case 1:
                ((CloudSpaceFragment) this.b).lambda$startBatchPrint$5();
                break;
            case 2:
                ((CloudSpaceFragment) this.b).lambda$startPrintLabel$10();
                break;
            case 3:
                ((CloudSpaceFragment) this.b).lambda$startBatchPrint$1();
                break;
            default:
                ((CloudSpaceCloudLabelManageActivity.AnonymousClass9) this.b).lambda$run$2();
                break;
        }
    }
}
