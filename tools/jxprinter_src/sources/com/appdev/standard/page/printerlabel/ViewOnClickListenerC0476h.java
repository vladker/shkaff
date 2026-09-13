package com.appdev.standard.page.printerlabel;

import android.view.View;

/* JADX INFO: renamed from: com.appdev.standard.page.printerlabel.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ViewOnClickListenerC0476h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2731a;
    public final /* synthetic */ AttributeTableStyleFragment b;

    public /* synthetic */ ViewOnClickListenerC0476h(AttributeTableStyleFragment attributeTableStyleFragment, int i5) {
        this.f2731a = i5;
        this.b = attributeTableStyleFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f2731a) {
            case 0:
                this.b.lambda$handleLogic$6(view);
                break;
            case 1:
                this.b.lambda$handleLogic$7(view);
                break;
            case 2:
                this.b.lambda$handleLogic$8(view);
                break;
            default:
                this.b.lambda$initComponent$0(view);
                break;
        }
    }
}
