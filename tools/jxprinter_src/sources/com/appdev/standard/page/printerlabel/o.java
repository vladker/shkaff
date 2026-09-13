package com.appdev.standard.page.printerlabel;

import androidx.activity.result.ActivityResult;
import com.appdev.standard.page.printerlabel.widget.DrawingBoardView;
import com.appdev.standard.page.printerlabel.widget.LineProgressWidget;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class o implements p056k0.s, DrawingBoardView.OnScaleChangeListener, LineProgressWidget.OnProgressChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f2738a;
    public final /* synthetic */ Object b;

    public /* synthetic */ o(Object obj, Object obj2) {
        this.f2738a = obj;
        this.b = obj2;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.LineProgressWidget.OnProgressChangeListener
    public void onProgressChanged(float f6) {
        ((TemplateEditActivity) this.f2738a).lambda$initComponent$1((DrawingBoardView) this.b, f6);
    }

    @Override // p056k0.s
    public void onResult(ActivityResult activityResult) {
        ((AttributeTextDataFragment.AnonymousClass3) this.f2738a).lambda$onRequestPermissionSuccess$1((HashMap) this.b, activityResult);
    }

    @Override // com.appdev.standard.page.printerlabel.widget.DrawingBoardView.OnScaleChangeListener
    public void onScaleChanged(float f6) {
        ((TemplateEditActivity) this.f2738a).lambda$initComponent$0((LineProgressWidget) this.b, f6);
    }
}
