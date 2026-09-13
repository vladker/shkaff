package com.appdev.standard.page.printerlabel;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.appdev.standard.page.printerlabel.widget.LineProgressWidget;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class AttributeLineStyleFragment_ViewBinding implements Unbinder {
    private AttributeLineStyleFragment target;
    private View view14cf;
    private View view14d0;
    private View view14d1;
    private View view14d2;

    @UiThread
    public AttributeLineStyleFragment_ViewBinding(final AttributeLineStyleFragment attributeLineStyleFragment, View view) {
        this.target = attributeLineStyleFragment;
        attributeLineStyleFragment.lpwLineWidth = (LineProgressWidget) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.lpw_line_width, "field 'lpwLineWidth'", LineProgressWidget.class);
        int i5 = p113u.d.line_style_1;
        View viewFindRequiredView = butterknife.internal.d.findRequiredView(view, i5, "field 'ivLineStyle1' and method 'onLineStyle1Click'");
        attributeLineStyleFragment.ivLineStyle1 = (ImageView) butterknife.internal.d.castView(viewFindRequiredView, i5, "field 'ivLineStyle1'", ImageView.class);
        this.view14cf = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeLineStyleFragment_ViewBinding.1
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeLineStyleFragment.onLineStyle1Click(view2);
            }
        });
        int i6 = p113u.d.line_style_2;
        View viewFindRequiredView2 = butterknife.internal.d.findRequiredView(view, i6, "field 'ivLineStyle2' and method 'onLineStyle2Click'");
        attributeLineStyleFragment.ivLineStyle2 = (ImageView) butterknife.internal.d.castView(viewFindRequiredView2, i6, "field 'ivLineStyle2'", ImageView.class);
        this.view14d0 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeLineStyleFragment_ViewBinding.2
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeLineStyleFragment.onLineStyle2Click(view2);
            }
        });
        int i7 = p113u.d.line_style_3;
        View viewFindRequiredView3 = butterknife.internal.d.findRequiredView(view, i7, "field 'ivLineStyle3' and method 'onLineStyle3Click'");
        attributeLineStyleFragment.ivLineStyle3 = (ImageView) butterknife.internal.d.castView(viewFindRequiredView3, i7, "field 'ivLineStyle3'", ImageView.class);
        this.view14d1 = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeLineStyleFragment_ViewBinding.3
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeLineStyleFragment.onLineStyle3Click(view2);
            }
        });
        int i8 = p113u.d.line_style_4;
        View viewFindRequiredView4 = butterknife.internal.d.findRequiredView(view, i8, "field 'ivLineStyle4' and method 'onLineStyle4Click'");
        attributeLineStyleFragment.ivLineStyle4 = (ImageView) butterknife.internal.d.castView(viewFindRequiredView4, i8, "field 'ivLineStyle4'", ImageView.class);
        this.view14d2 = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeLineStyleFragment_ViewBinding.4
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeLineStyleFragment.onLineStyle4Click(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AttributeLineStyleFragment attributeLineStyleFragment = this.target;
        if (attributeLineStyleFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        attributeLineStyleFragment.lpwLineWidth = null;
        attributeLineStyleFragment.ivLineStyle1 = null;
        attributeLineStyleFragment.ivLineStyle2 = null;
        attributeLineStyleFragment.ivLineStyle3 = null;
        attributeLineStyleFragment.ivLineStyle4 = null;
        this.view14cf.setOnClickListener(null);
        this.view14cf = null;
        this.view14d0.setOnClickListener(null);
        this.view14d0 = null;
        this.view14d1.setOnClickListener(null);
        this.view14d1 = null;
        this.view14d2.setOnClickListener(null);
        this.view14d2 = null;
    }
}
