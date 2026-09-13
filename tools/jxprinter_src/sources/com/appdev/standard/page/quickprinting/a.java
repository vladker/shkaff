package com.appdev.standard.page.quickprinting;

import com.appdev.standard.model.PrintTaskBean;
import com.appdev.standard.model.TemplateConfigBean;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2824a;
    public final /* synthetic */ Runnable b;
    public final /* synthetic */ Object c;

    public /* synthetic */ a(Object obj, int i5, Runnable runnable) {
        this.f2824a = i5;
        this.b = runnable;
        this.c = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2824a) {
            case 0:
                ((QuickPrintingActivity.AnonymousClass8) this.b).lambda$run$0((PrintTaskBean) this.c);
                break;
            default:
                ((QuickPrintingActivity.AnonymousClass9) this.b).lambda$run$1((TemplateConfigBean) this.c);
                break;
        }
    }
}
