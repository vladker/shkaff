package com.appdev.standard.page.document;

import android.view.View;
import com.appdev.standard.page.quickprinting.QuickPrintingActivity;
import com.google.android.material.datepicker.MaterialDatePicker;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2694a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a(Object obj, int i5) {
        this.f2694a = i5;
        this.b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f2694a) {
            case 0:
                ((MineLabelFragment) this.b).lambda$initListener$0(view);
                break;
            case 1:
                ((QuickPrintingActivity) this.b).lambda$initComponent$0(view);
                break;
            case 2:
                ((MaterialDatePicker) this.b).lambda$initHeaderToggle$0(view);
                break;
            default:
                ((p068m0.b) this.b).dismiss();
                break;
        }
    }
}
