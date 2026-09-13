package com.appdev.standard.page.printerlabel;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class q implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2740a;
    public final /* synthetic */ AttributeTextFontFragment b;

    public /* synthetic */ q(AttributeTextFontFragment attributeTextFontFragment, int i5) {
        this.f2740a = i5;
        this.b = attributeTextFontFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f2740a) {
            case 0:
                this.b.lambda$initComponent$0(view);
                break;
            case 1:
                this.b.lambda$handleLogic$1(view);
                break;
            case 2:
                this.b.lambda$handleLogic$2(view);
                break;
            default:
                this.b.lambda$handleLogic$3(view);
                break;
        }
    }
}
