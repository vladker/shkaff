package com.appdev.standard.page.bluetooth;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2685a;
    public final /* synthetic */ Object b;

    public /* synthetic */ g(Object obj, int i5) {
        this.f2685a = i5;
        this.b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2685a) {
            case 0:
                ((PrintDeviceInfoActivity.AnonymousClass4) this.b).lambda$onConfirm$1();
                break;
            case 1:
                ((PrintSetting.AnonymousClass10) this.b).lambda$run$1();
                break;
            default:
                ((PrintDeviceInfoActivity) this.b).lambda$onPrintCheckClick$5();
                break;
        }
    }
}
