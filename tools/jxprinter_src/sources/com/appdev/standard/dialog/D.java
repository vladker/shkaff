package com.appdev.standard.dialog;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class D extends butterknife.internal.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2606a;
    public final /* synthetic */ SaveTipsDialog b;

    public /* synthetic */ D(SaveTipsDialog saveTipsDialog, int i5) {
        this.f2606a = i5;
        this.b = saveTipsDialog;
    }

    @Override // butterknife.internal.b
    public final void doClick(View view) {
        switch (this.f2606a) {
            case 0:
                this.b.onBtnClick(view);
                break;
            case 1:
                this.b.onBtnClick(view);
                break;
            default:
                this.b.onBtnClick(view);
                break;
        }
    }
}
