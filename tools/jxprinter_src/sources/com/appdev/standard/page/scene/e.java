package com.appdev.standard.page.scene;

import com.appdev.standard.model.PrintTaskBean;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2833a;
    public final /* synthetic */ CloudSpaceFragment b;
    public final /* synthetic */ PrintTaskBean c;

    public /* synthetic */ e(CloudSpaceFragment cloudSpaceFragment, PrintTaskBean printTaskBean, int i5) {
        this.f2833a = i5;
        this.b = cloudSpaceFragment;
        this.c = printTaskBean;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2833a) {
            case 0:
                this.b.lambda$preShowLabel$7(this.c);
                break;
            case 1:
                this.b.lambda$startPrintLabel$9(this.c);
                break;
            default:
                this.b.lambda$startBatchPrint$3(this.c);
                break;
        }
    }
}
