package com.appdev.standard.dialog;

import android.view.View;

/* JADX INFO: renamed from: com.appdev.standard.dialog.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C0449b extends butterknife.internal.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2638a;
    public final /* synthetic */ CommonContentEditDialog b;

    public /* synthetic */ C0449b(CommonContentEditDialog commonContentEditDialog, int i5) {
        this.f2638a = i5;
        this.b = commonContentEditDialog;
    }

    @Override // butterknife.internal.b
    public final void doClick(View view) {
        switch (this.f2638a) {
            case 0:
                this.b.onConfirmClick(view);
                break;
            default:
                this.b.onRootClick(view);
                break;
        }
    }
}
