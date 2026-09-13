package com.appdev.standard.page.document;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class DocumentFragment_ViewBinding implements Unbinder {
    private DocumentFragment target;
    private View view14f9;

    @UiThread
    public DocumentFragment_ViewBinding(final DocumentFragment documentFragment, View view) {
        this.target = documentFragment;
        documentFragment.rvDocumentType = (RecyclerView) d.findRequiredViewAsType(view, p113u.d.rv_document_type, "field 'rvDocumentType'", RecyclerView.class);
        int i5 = p113u.d.ll_document_add;
        View viewFindRequiredView = d.findRequiredView(view, i5, "field 'llDocumentAdd' and method 'onDocumentAddClick'");
        documentFragment.llDocumentAdd = (LinearLayout) d.castView(viewFindRequiredView, i5, "field 'llDocumentAdd'", LinearLayout.class);
        this.view14f9 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.document.DocumentFragment_ViewBinding.1
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                documentFragment.onDocumentAddClick(view2);
            }
        });
        documentFragment.flDocumentView = (FrameLayout) d.findRequiredViewAsType(view, p113u.d.fl_document_view, "field 'flDocumentView'", FrameLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        DocumentFragment documentFragment = this.target;
        if (documentFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        documentFragment.rvDocumentType = null;
        documentFragment.llDocumentAdd = null;
        documentFragment.flDocumentView = null;
        this.view14f9.setOnClickListener(null);
        this.view14f9 = null;
    }
}
