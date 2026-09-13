package com.appdev.standard.dialog;

import com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class M implements QuantitySelectorWidget.OnValueChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TimeOffsetDialog f2618a;

    public M(TimeOffsetDialog timeOffsetDialog) {
        this.f2618a = timeOffsetDialog;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget.OnValueChangeListener
    public final void onValue(int i5) {
        this.f2618a.f2632a = i5;
    }
}
