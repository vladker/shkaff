package com.appdev.standard.page.printerlabel;

import com.appdev.standard.page.printerlabel.widget.BaseControlView;
import com.appdev.standard.page.printerlabel.widget.LineProgressWidget;

/* JADX INFO: renamed from: com.appdev.standard.page.printerlabel.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0478j implements BaseControlView.TemplateEditTaskWithResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2733a;
    public final /* synthetic */ float b;
    public final /* synthetic */ LineProgressWidget.OnRangeUpListener c;

    public /* synthetic */ C0478j(LineProgressWidget.OnRangeUpListener onRangeUpListener, float f6, int i5) {
        this.f2733a = i5;
        this.c = onRangeUpListener;
        this.b = f6;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTaskWithResult
    public final boolean run() {
        switch (this.f2733a) {
            case 0:
                return ((AttributeTableStyleFragment.AnonymousClass10) this.c).lambda$onRangeUp$0(this.b);
            case 1:
                return ((AttributeTableStyleFragment.AnonymousClass3) this.c).lambda$onRangeUp$0(this.b);
            case 2:
                return ((AttributeTableStyleFragment.AnonymousClass4) this.c).lambda$onRangeUp$0(this.b);
            default:
                return ((AttributeTableStyleFragment.AnonymousClass9) this.c).lambda$onRangeUp$0(this.b);
        }
    }
}
