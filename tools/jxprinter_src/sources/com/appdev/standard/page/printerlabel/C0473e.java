package com.appdev.standard.page.printerlabel;

import com.appdev.standard.page.printerlabel.widget.BaseControlView;

/* JADX INFO: renamed from: com.appdev.standard.page.printerlabel.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0473e implements BaseControlView.TemplateEditTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2728a;
    public final /* synthetic */ AttributeQrcodeDataFragment b;
    public final /* synthetic */ String c;

    public /* synthetic */ C0473e(AttributeQrcodeDataFragment attributeQrcodeDataFragment, String str, int i5) {
        this.f2728a = i5;
        this.b = attributeQrcodeDataFragment;
        this.c = str;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
    public final void run() {
        switch (this.f2728a) {
            case 0:
                this.b.lambda$onViewCreated$0(this.c);
                break;
            default:
                this.b.lambda$onViewCreated$4(this.c);
                break;
        }
    }
}
