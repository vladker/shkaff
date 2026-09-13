package com.appdev.standard.page.printerlabel;

import com.appdev.standard.page.printerlabel.widget.BaseControlView;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2744a;
    public final /* synthetic */ int b;
    public final /* synthetic */ BaseControlView.TemplateEditTask c;

    public /* synthetic */ u(BaseControlView.TemplateEditTask templateEditTask, int i5, int i6) {
        this.f2744a = i6;
        this.c = templateEditTask;
        this.b = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2744a) {
            case 0:
                ((AttributeTextStyleFragment.AnonymousClass1) this.c).lambda$run$0(this.b);
                break;
            default:
                ((AttributeTextStyleFragment.AnonymousClass7) this.c).lambda$run$0(this.b);
                break;
        }
    }
}
