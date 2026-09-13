package com.appdev.standard.dialog;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class w extends butterknife.internal.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2658a;
    public final /* synthetic */ LogoffTipDialog b;

    public /* synthetic */ w(LogoffTipDialog logoffTipDialog, int i5) {
        this.f2658a = i5;
        this.b = logoffTipDialog;
    }

    @Override // butterknife.internal.b
    public final void doClick(View view) {
        switch (this.f2658a) {
            case 0:
                this.b.onBtnClick(view);
                break;
            default:
                this.b.onBtnClick(view);
                break;
        }
    }
}
