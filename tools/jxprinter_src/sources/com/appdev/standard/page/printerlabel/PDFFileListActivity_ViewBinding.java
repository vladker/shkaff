package com.appdev.standard.page.printerlabel;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class PDFFileListActivity_ViewBinding implements Unbinder {
    private PDFFileListActivity target;

    @UiThread
    public PDFFileListActivity_ViewBinding(PDFFileListActivity pDFFileListActivity) {
        this(pDFFileListActivity, pDFFileListActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PDFFileListActivity pDFFileListActivity = this.target;
        if (pDFFileListActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        pDFFileListActivity.tvTitle = null;
        pDFFileListActivity.rvPdfFileListData = null;
    }

    @UiThread
    public PDFFileListActivity_ViewBinding(PDFFileListActivity pDFFileListActivity, View view) {
        this.target = pDFFileListActivity;
        pDFFileListActivity.tvTitle = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_title, "field 'tvTitle'", TextView.class);
        pDFFileListActivity.rvPdfFileListData = (RecyclerView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rv_pdf_file_list_data, "field 'rvPdfFileListData'", RecyclerView.class);
    }
}
