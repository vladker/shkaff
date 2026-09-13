package com.appdev.standard.page.printerlabel;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class AttributeTableDataFragment_ViewBinding implements Unbinder {
    private AttributeTableDataFragment target;
    private View view14de;
    private View view14e4;

    @UiThread
    public AttributeTableDataFragment_ViewBinding(final AttributeTableDataFragment attributeTableDataFragment, View view) {
        this.target = attributeTableDataFragment;
        attributeTableDataFragment.tvAttributeTableContent = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_attribute_table_content, "field 'tvAttributeTableContent'", TextView.class);
        View viewFindRequiredView = butterknife.internal.d.findRequiredView(view, p113u.d.ll_attribute_text_ocr, "method 'onOCRClick'");
        this.view14e4 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeTableDataFragment_ViewBinding.1
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeTableDataFragment.onOCRClick(view2);
            }
        });
        View viewFindRequiredView2 = butterknife.internal.d.findRequiredView(view, p113u.d.ll_attribute_asr, "method 'onASRClick'");
        this.view14de = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeTableDataFragment_ViewBinding.2
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeTableDataFragment.onASRClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AttributeTableDataFragment attributeTableDataFragment = this.target;
        if (attributeTableDataFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        attributeTableDataFragment.tvAttributeTableContent = null;
        this.view14e4.setOnClickListener(null);
        this.view14e4 = null;
        this.view14de.setOnClickListener(null);
        this.view14de = null;
    }
}
