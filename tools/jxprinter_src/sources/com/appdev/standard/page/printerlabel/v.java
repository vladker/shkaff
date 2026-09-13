package com.appdev.standard.page.printerlabel;

import android.view.View;
import android.widget.PopupWindow;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class v implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2808a;
    public final /* synthetic */ Object b;

    public /* synthetic */ v(Object obj, int i5) {
        this.f2808a = i5;
        this.b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f2808a) {
            case 0:
                ((AttributeTimeFontFragment) this.b).lambda$initComponent$0(view);
                break;
            default:
                ((PopupWindow) this.b).dismiss();
                break;
        }
    }
}
