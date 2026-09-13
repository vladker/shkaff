package com.appdev.standard.page.printerlabel;

import com.appdev.standard.model.TextFontModel;
import com.appdev.standard.page.printerlabel.widget.BaseControlView;

/* JADX INFO: renamed from: com.appdev.standard.page.printerlabel.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0479k implements BaseControlView.TemplateEditTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2734a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ TextFontModel c;
    public final /* synthetic */ int d;

    public /* synthetic */ C0479k(Object obj, TextFontModel textFontModel, int i5, int i6) {
        this.f2734a = i6;
        this.b = obj;
        this.c = textFontModel;
        this.d = i5;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
    public final void run() {
        switch (this.f2734a) {
            case 0:
                ((AttributeTableStyleFragment.AnonymousClass2) this.b).lambda$onItemClick$0(this.c, this.d);
                break;
            case 1:
                ((AttributeTableStyleFragment.AnonymousClass2) this.b).lambda$onItemClick$1(this.c, this.d);
                break;
            case 2:
                ((AttributeTableStyleFragment.AnonymousClass2) this.b).lambda$onItemClick$2(this.c, this.d);
                break;
            default:
                ((AttributeTimeFontFragment) this.b).lambda$applyFontDirectly$1(this.c, this.d);
                break;
        }
    }
}
