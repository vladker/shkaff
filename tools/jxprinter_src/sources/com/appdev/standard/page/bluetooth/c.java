package com.appdev.standard.page.bluetooth;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2681a;
    public final /* synthetic */ PrintDeviceInfoActivity b;
    public final /* synthetic */ boolean c;

    public /* synthetic */ c(PrintDeviceInfoActivity printDeviceInfoActivity, boolean z6, int i5) {
        this.f2681a = i5;
        this.b = printDeviceInfoActivity;
        this.c = z6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2681a) {
            case 0:
                this.b.lambda$updateZipSetting$2(this.c);
                break;
            default:
                this.b.lambda$updateZipSetting$0(this.c);
                break;
        }
    }
}
