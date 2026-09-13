package com.appdev.standard.page.printerlabel;

import com.appdev.standard.page.printerlabel.widget.BaseControlView;

/* JADX INFO: renamed from: com.appdev.standard.page.printerlabel.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0475g implements BaseControlView.TemplateEditTaskWithResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2730a;
    public final /* synthetic */ AttributeTableStyleFragment b;

    public /* synthetic */ C0475g(AttributeTableStyleFragment attributeTableStyleFragment, int i5) {
        this.f2730a = i5;
        this.b = attributeTableStyleFragment;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTaskWithResult
    public final boolean run() {
        switch (this.f2730a) {
            case 0:
                return this.b.lambda$onUnderlineClick$3();
            case 1:
                return this.b.lambda$onItalicClick$2();
            case 2:
                return this.b.lambda$onStrikethroughClick$4();
            default:
                return this.b.lambda$onBoldClick$1();
        }
    }
}
