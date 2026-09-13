package com.appdev.standard.page.bluetooth;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2684a;

    public /* synthetic */ f(int i5) {
        this.f2684a = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2684a) {
            case 0:
                PrintDeviceInfoActivity.AnonymousClass4.lambda$onConfirm$0();
                break;
            case 1:
                PrintSetting.AnonymousClass10.lambda$run$0();
                break;
            case 2:
                PrintSetting.AnonymousClass10.lambda$run$2();
                break;
            default:
                PrintDeviceInfoActivity.lambda$onPrintCheckClick$4();
                break;
        }
    }
}
