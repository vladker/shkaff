package com.appdev.standard.page.printerlabel;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ElementAttributeFragment_ViewBinding implements Unbinder {
    private ElementAttributeFragment target;
    private View view17c0;
    private View view1876;
    private View view1877;
    private View view1878;
    private View view1879;

    @UiThread
    public ElementAttributeFragment_ViewBinding(final ElementAttributeFragment elementAttributeFragment, View view) {
        this.target = elementAttributeFragment;
        int i5 = p113u.d.tv_tab1;
        View viewFindRequiredView = butterknife.internal.d.findRequiredView(view, i5, "field 'tvTab1' and method 'onTab1Click'");
        elementAttributeFragment.tvTab1 = (TextView) butterknife.internal.d.castView(viewFindRequiredView, i5, "field 'tvTab1'", TextView.class);
        this.view1876 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.ElementAttributeFragment_ViewBinding.1
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                elementAttributeFragment.onTab1Click();
            }
        });
        int i6 = p113u.d.tv_tab2;
        View viewFindRequiredView2 = butterknife.internal.d.findRequiredView(view, i6, "field 'tvTab2' and method 'onTab2Click'");
        elementAttributeFragment.tvTab2 = (TextView) butterknife.internal.d.castView(viewFindRequiredView2, i6, "field 'tvTab2'", TextView.class);
        this.view1877 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.ElementAttributeFragment_ViewBinding.2
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                elementAttributeFragment.onTab2Click();
            }
        });
        int i7 = p113u.d.tv_tab3;
        View viewFindRequiredView3 = butterknife.internal.d.findRequiredView(view, i7, "field 'tvTab3' and method 'onTab3Click'");
        elementAttributeFragment.tvTab3 = (TextView) butterknife.internal.d.castView(viewFindRequiredView3, i7, "field 'tvTab3'", TextView.class);
        this.view1878 = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.ElementAttributeFragment_ViewBinding.3
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                elementAttributeFragment.onTab3Click();
            }
        });
        int i8 = p113u.d.tv_tab4;
        View viewFindRequiredView4 = butterknife.internal.d.findRequiredView(view, i8, "field 'tvTab4' and method 'onTab4Click'");
        elementAttributeFragment.tvTab4 = (TextView) butterknife.internal.d.castView(viewFindRequiredView4, i8, "field 'tvTab4'", TextView.class);
        this.view1879 = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.ElementAttributeFragment_ViewBinding.4
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                elementAttributeFragment.onTab4Click();
            }
        });
        elementAttributeFragment.flElementAttribute = (FrameLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.fl_element_attribute, "field 'flElementAttribute'", FrameLayout.class);
        elementAttributeFragment.rvElementAttribute = (RecyclerView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rv_element_attribute, "field 'rvElementAttribute'", RecyclerView.class);
        View viewFindRequiredView5 = butterknife.internal.d.findRequiredView(view, p113u.d.tv_element_attribute_back, "method 'onElementAttributeBackClick'");
        this.view17c0 = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.ElementAttributeFragment_ViewBinding.5
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                elementAttributeFragment.onElementAttributeBackClick();
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ElementAttributeFragment elementAttributeFragment = this.target;
        if (elementAttributeFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        elementAttributeFragment.tvTab1 = null;
        elementAttributeFragment.tvTab2 = null;
        elementAttributeFragment.tvTab3 = null;
        elementAttributeFragment.tvTab4 = null;
        elementAttributeFragment.flElementAttribute = null;
        elementAttributeFragment.rvElementAttribute = null;
        this.view1876.setOnClickListener(null);
        this.view1876 = null;
        this.view1877.setOnClickListener(null);
        this.view1877 = null;
        this.view1878.setOnClickListener(null);
        this.view1878 = null;
        this.view1879.setOnClickListener(null);
        this.view1879 = null;
        this.view17c0.setOnClickListener(null);
        this.view17c0 = null;
    }
}
