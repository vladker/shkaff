package com.appdev.standard.page.auth;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.d;
import com.github.barteksc.pdfviewer.PDFView;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class AgreementActivity_ViewBinding implements Unbinder {
    private AgreementActivity target;

    @UiThread
    public AgreementActivity_ViewBinding(AgreementActivity agreementActivity) {
        this(agreementActivity, agreementActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AgreementActivity agreementActivity = this.target;
        if (agreementActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        agreementActivity.tvTitle = null;
        agreementActivity.mPdfView = null;
    }

    @UiThread
    public AgreementActivity_ViewBinding(AgreementActivity agreementActivity, View view) {
        this.target = agreementActivity;
        agreementActivity.tvTitle = (TextView) d.findRequiredViewAsType(view, p113u.d.tv_title, "field 'tvTitle'", TextView.class);
        agreementActivity.mPdfView = (PDFView) d.findRequiredViewAsType(view, p113u.d.pdf_view, "field 'mPdfView'", PDFView.class);
    }
}
