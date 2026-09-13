package com.google.android.material.textfield;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3365a;
    public final /* synthetic */ EndIconDelegate b;

    public /* synthetic */ b(EndIconDelegate endIconDelegate, int i5) {
        this.f3365a = i5;
        this.b = endIconDelegate;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z6) {
        switch (this.f3365a) {
            case 0:
                ((ClearTextEndIconDelegate) this.b).lambda$new$1(view, z6);
                break;
            default:
                ((DropdownMenuEndIconDelegate) this.b).lambda$new$1(view, z6);
                break;
        }
    }
}
