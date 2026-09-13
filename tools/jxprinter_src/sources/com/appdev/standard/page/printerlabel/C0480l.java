package com.appdev.standard.page.printerlabel;

import com.appdev.standard.page.printerlabel.widget.BaseControlView;

/* JADX INFO: renamed from: com.appdev.standard.page.printerlabel.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0480l implements BaseControlView.TemplateEditTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2735a;
    public final /* synthetic */ AttributeTextDataFragment b;
    public final /* synthetic */ String c;

    public /* synthetic */ C0480l(AttributeTextDataFragment attributeTextDataFragment, String str, int i5) {
        this.f2735a = i5;
        this.b = attributeTextDataFragment;
        this.c = str;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
    public final void run() {
        switch (this.f2735a) {
            case 0:
                this.b.lambda$onViewCreated$0(this.c);
                break;
            default:
                this.b.lambda$onViewCreated$4(this.c);
                break;
        }
    }
}
