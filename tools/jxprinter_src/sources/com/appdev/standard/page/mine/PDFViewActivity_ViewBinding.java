package com.appdev.standard.page.mine;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.github.barteksc.pdfviewer.PDFView;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class PDFViewActivity_ViewBinding implements Unbinder {
    private PDFViewActivity target;

    @UiThread
    public PDFViewActivity_ViewBinding(PDFViewActivity pDFViewActivity) {
        this(pDFViewActivity, pDFViewActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PDFViewActivity pDFViewActivity = this.target;
        if (pDFViewActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        pDFViewActivity.tvTitle = null;
        pDFViewActivity.pdfvMain = null;
    }

    @UiThread
    public PDFViewActivity_ViewBinding(PDFViewActivity pDFViewActivity, View view) {
        this.target = pDFViewActivity;
        pDFViewActivity.tvTitle = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_title, "field 'tvTitle'", TextView.class);
        pDFViewActivity.pdfvMain = (PDFView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.pdfv_main, "field 'pdfvMain'", PDFView.class);
    }
}
