package com.appdev.standard.dialog;

import android.view.View;

/* JADX INFO: renamed from: com.appdev.standard.dialog.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C0457j extends butterknife.internal.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2647a;
    public final /* synthetic */ DefaultTipDialog b;

    public /* synthetic */ C0457j(DefaultTipDialog defaultTipDialog, int i5) {
        this.f2647a = i5;
        this.b = defaultTipDialog;
    }

    @Override // butterknife.internal.b
    public final void doClick(View view) {
        switch (this.f2647a) {
            case 0:
                this.b.onBtnClick(view);
                break;
            default:
                this.b.onBtnClick(view);
                break;
        }
    }
}
