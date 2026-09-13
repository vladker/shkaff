package com.google.android.material.timepicker;

import com.google.android.material.button.MaterialButtonToggleGroup;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements MaterialButtonToggleGroup.OnButtonCheckedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3373a;
    public final /* synthetic */ Object b;

    public /* synthetic */ c(Object obj, int i5) {
        this.f3373a = i5;
        this.b = obj;
    }

    @Override // com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener
    public final void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup, int i5, boolean z6) {
        switch (this.f3373a) {
            case 0:
                ((TimePickerTextInputPresenter) this.b).lambda$setupPeriodToggle$0(materialButtonToggleGroup, i5, z6);
                break;
            default:
                ((TimePickerView) this.b).lambda$new$0(materialButtonToggleGroup, i5, z6);
                break;
        }
    }
}
