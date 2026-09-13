package com.appdev.standard.page.mine;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2709a;
    public final /* synthetic */ PersonalInfomationActivity.AnonymousClass4 b;

    public /* synthetic */ h(PersonalInfomationActivity.AnonymousClass4 anonymousClass4, int i5) {
        this.f2709a = i5;
        this.b = anonymousClass4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2709a) {
            case 0:
                this.b.lambda$onCheckError$3();
                break;
            case 1:
                this.b.lambda$onNoStoreInstalled$2();
                break;
            case 2:
                this.b.lambda$onUpdateAvailable$0();
                break;
            default:
                this.b.lambda$onNoUpdateAvailable$1();
                break;
        }
    }
}
