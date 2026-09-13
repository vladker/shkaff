package com.appdev.standard.page.mine;

import com.library.base.frame.MvpActivity;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2708a;
    public final /* synthetic */ MvpActivity b;

    public /* synthetic */ g(MvpActivity mvpActivity, int i5) {
        this.f2708a = i5;
        this.b = mvpActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2708a) {
            case 0:
                ((MemberBuyActivity) this.b).lambda$checkPendingGooglePayment$4();
                break;
            default:
                ((PersonalInfomationActivity) this.b).lambda$checkAppUpdate$1();
                break;
        }
    }
}
