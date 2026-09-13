package com.appdev.standard.page.printerlabel;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class AttributeTextSerialNumberFragment_ViewBinding implements Unbinder {
    private AttributeTextSerialNumberFragment target;
    private View view1791;
    private View view1792;
    private View view1793;
    private View view1794;

    @UiThread
    public AttributeTextSerialNumberFragment_ViewBinding(final AttributeTextSerialNumberFragment attributeTextSerialNumberFragment, View view) {
        this.target = attributeTextSerialNumberFragment;
        int i5 = p113u.d.tv_attribute_text_incremental_content;
        View viewFindRequiredView = butterknife.internal.d.findRequiredView(view, i5, "field 'tvAttributeTextIncrementalContent' and method 'onIncrementalContentClick'");
        attributeTextSerialNumberFragment.tvAttributeTextIncrementalContent = (TextView) butterknife.internal.d.castView(viewFindRequiredView, i5, "field 'tvAttributeTextIncrementalContent'", TextView.class);
        this.view1791 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeTextSerialNumberFragment_ViewBinding.1
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeTextSerialNumberFragment.onIncrementalContentClick();
            }
        });
        int i6 = p113u.d.tv_attribute_text_interval;
        View viewFindRequiredView2 = butterknife.internal.d.findRequiredView(view, i6, "field 'tvAttributeTextInterval' and method 'onIntervalClick'");
        attributeTextSerialNumberFragment.tvAttributeTextInterval = (TextView) butterknife.internal.d.castView(viewFindRequiredView2, i6, "field 'tvAttributeTextInterval'", TextView.class);
        this.view1792 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeTextSerialNumberFragment_ViewBinding.2
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeTextSerialNumberFragment.onIntervalClick();
            }
        });
        int i7 = p113u.d.tv_attribute_text_prefix;
        View viewFindRequiredView3 = butterknife.internal.d.findRequiredView(view, i7, "field 'tvAttributeTextPrefix' and method 'onPrefixClick'");
        attributeTextSerialNumberFragment.tvAttributeTextPrefix = (TextView) butterknife.internal.d.castView(viewFindRequiredView3, i7, "field 'tvAttributeTextPrefix'", TextView.class);
        this.view1793 = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeTextSerialNumberFragment_ViewBinding.3
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeTextSerialNumberFragment.onPrefixClick();
            }
        });
        int i8 = p113u.d.tv_attribute_text_suffix;
        View viewFindRequiredView4 = butterknife.internal.d.findRequiredView(view, i8, "field 'tvAttributeTextSuffix' and method 'onSuffixClick'");
        attributeTextSerialNumberFragment.tvAttributeTextSuffix = (TextView) butterknife.internal.d.castView(viewFindRequiredView4, i8, "field 'tvAttributeTextSuffix'", TextView.class);
        this.view1794 = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeTextSerialNumberFragment_ViewBinding.4
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeTextSerialNumberFragment.onSuffixClick();
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AttributeTextSerialNumberFragment attributeTextSerialNumberFragment = this.target;
        if (attributeTextSerialNumberFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        attributeTextSerialNumberFragment.tvAttributeTextIncrementalContent = null;
        attributeTextSerialNumberFragment.tvAttributeTextInterval = null;
        attributeTextSerialNumberFragment.tvAttributeTextPrefix = null;
        attributeTextSerialNumberFragment.tvAttributeTextSuffix = null;
        this.view1791.setOnClickListener(null);
        this.view1791 = null;
        this.view1792.setOnClickListener(null);
        this.view1792 = null;
        this.view1793.setOnClickListener(null);
        this.view1793 = null;
        this.view1794.setOnClickListener(null);
        this.view1794 = null;
    }
}
