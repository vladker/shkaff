package com.appdev.standard.dialog;

import com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class P implements QuantitySelectorWidget.OnValueChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TimeOffsetDialog f2623a;

    public P(TimeOffsetDialog timeOffsetDialog) {
        this.f2623a = timeOffsetDialog;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget.OnValueChangeListener
    public final void onValue(int i5) {
        this.f2623a.d = i5;
    }
}
