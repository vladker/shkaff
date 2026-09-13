package com.appdev.standard.dialog;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class F extends butterknife.internal.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2610a;
    public final /* synthetic */ ServerSwitchDialog b;

    public /* synthetic */ F(ServerSwitchDialog serverSwitchDialog, int i5) {
        this.f2610a = i5;
        this.b = serverSwitchDialog;
    }

    @Override // butterknife.internal.b
    public final void doClick(View view) {
        switch (this.f2610a) {
            case 0:
                this.b.onBtnClick(view);
                break;
            default:
                this.b.onBtnClick(view);
                break;
        }
    }
}
