package com.appdev.standard.dialog;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class U extends butterknife.internal.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2636a;
    public final /* synthetic */ TimeOffsetDialog b;

    public /* synthetic */ U(TimeOffsetDialog timeOffsetDialog, int i5) {
        this.f2636a = i5;
        this.b = timeOffsetDialog;
    }

    @Override // butterknife.internal.b
    public final void doClick(View view) {
        switch (this.f2636a) {
            case 0:
                this.b.onDialogTypeDayClick(view);
                break;
            case 1:
                this.b.onDialogTypeTimeClick(view);
                break;
            case 2:
                this.b.onDialogCancelClick(view);
                break;
            default:
                this.b.onDialogConfirmClick(view);
                break;
        }
    }
}
