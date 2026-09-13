package com.appdev.standard.page.receipt.operate;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2827a;
    public final /* synthetic */ ReceiptTextOperate b;

    public /* synthetic */ a(ReceiptTextOperate receiptTextOperate, int i5) {
        this.f2827a = i5;
        this.b = receiptTextOperate;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f2827a) {
            case 0:
                this.b.lambda$handleLogic$1(view);
                break;
            case 1:
                this.b.lambda$handleLogic$2(view);
                break;
            case 2:
                this.b.lambda$handleLogic$3(view);
                break;
            default:
                this.b.lambda$initTextTitle5$0(view);
                break;
        }
    }
}
