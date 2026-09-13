package com.appdev.standard.dialog;

import android.app.Dialog;
import android.view.View;

/* JADX INFO: renamed from: com.appdev.standard.dialog.t, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C0466t extends butterknife.internal.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2656a;
    public final /* synthetic */ Dialog b;

    public /* synthetic */ C0466t(Dialog dialog, int i5) {
        this.f2656a = i5;
        this.b = dialog;
    }

    @Override // butterknife.internal.b
    public final void doClick(View view) {
        switch (this.f2656a) {
            case 0:
                ((InvitationNotificationDialog) this.b).onContainerClick();
                break;
            case 1:
                ((MemberBuySuccessDialog) this.b).onBtnClick(view);
                break;
            default:
                ((OpenBluetoothFailedDialog) this.b).onBtnClick(view);
                break;
        }
    }
}
