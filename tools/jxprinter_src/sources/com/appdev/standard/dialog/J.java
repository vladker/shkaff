package com.appdev.standard.dialog;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class J extends butterknife.internal.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2614a;
    public final /* synthetic */ ShareLabelDialog b;

    public /* synthetic */ J(ShareLabelDialog shareLabelDialog, int i5) {
        this.f2614a = i5;
        this.b = shareLabelDialog;
    }

    @Override // butterknife.internal.b
    public final void doClick(View view) {
        switch (this.f2614a) {
            case 0:
                this.b.onBtnClick(view);
                break;
            default:
                this.b.onBtnClick(view);
                break;
        }
    }
}
