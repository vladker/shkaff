package com.appdev.standard.page.mine;

import android.app.AlertDialog;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2707a;
    public final /* synthetic */ Object b;

    public /* synthetic */ f(Object obj, int i5) {
        this.f2707a = i5;
        this.b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f2707a) {
            case 0:
                ((MemberBuyActivity) this.b).lambda$initComponent$0(view);
                break;
            default:
                ((AlertDialog) this.b).dismiss();
                break;
        }
    }
}
