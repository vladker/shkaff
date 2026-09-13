package com.google.android.material.textfield;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3364a;
    public final /* synthetic */ EndIconDelegate b;

    public /* synthetic */ a(EndIconDelegate endIconDelegate, int i5) {
        this.f3364a = i5;
        this.b = endIconDelegate;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f3364a) {
            case 0:
                ((ClearTextEndIconDelegate) this.b).lambda$new$0(view);
                break;
            case 1:
                ((DropdownMenuEndIconDelegate) this.b).lambda$new$0(view);
                break;
            default:
                ((PasswordToggleEndIconDelegate) this.b).lambda$new$0(view);
                break;
        }
    }
}
