package com.appdev.standard.page.printerlabel;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class AttributeLayoutFragment_ViewBinding implements Unbinder {
    private AttributeLayoutFragment target;
    private View view1438;
    private View view1439;
    private View view143a;
    private View view143b;
    private View view143c;
    private View view143d;
    private View view143e;
    private View view143f;
    private View view1440;
    private View view1441;
    private View view1442;
    private View view1443;
    private View view1444;

    @UiThread
    public AttributeLayoutFragment_ViewBinding(final AttributeLayoutFragment attributeLayoutFragment, View view) {
        this.target = attributeLayoutFragment;
        View viewFindRequiredView = butterknife.internal.d.findRequiredView(view, p113u.d.iv_attribute_layout_to_top, "method 'onLayoutToTopClick'");
        this.view1442 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeLayoutFragment_ViewBinding.1
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeLayoutFragment.onLayoutToTopClick(view2);
            }
        });
        View viewFindRequiredView2 = butterknife.internal.d.findRequiredView(view, p113u.d.iv_attribute_layout_to_left, "method 'onLayoutToLeftClick'");
        this.view1440 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeLayoutFragment_ViewBinding.2
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeLayoutFragment.onLayoutToLeftClick(view2);
            }
        });
        View viewFindRequiredView3 = butterknife.internal.d.findRequiredView(view, p113u.d.iv_attribute_layout_to_right, "method 'onLayoutToRightClick'");
        this.view1441 = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeLayoutFragment_ViewBinding.3
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeLayoutFragment.onLayoutToRightClick(view2);
            }
        });
        View viewFindRequiredView4 = butterknife.internal.d.findRequiredView(view, p113u.d.iv_attribute_layout_to_bottom, "method 'onLayoutToBottomClick'");
        this.view143f = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeLayoutFragment_ViewBinding.4
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeLayoutFragment.onLayoutToBottomClick(view2);
            }
        });
        View viewFindRequiredView5 = butterknife.internal.d.findRequiredView(view, p113u.d.iv_attribute_layout_left, "method 'onLayoutLeftClick'");
        this.view143c = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeLayoutFragment_ViewBinding.5
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeLayoutFragment.onLayoutLeftClick(view2);
            }
        });
        View viewFindRequiredView6 = butterknife.internal.d.findRequiredView(view, p113u.d.iv_attribute_layout_center_horizontal, "method 'onLayoutCenterHorizontalClick'");
        this.view1439 = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeLayoutFragment_ViewBinding.6
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeLayoutFragment.onLayoutCenterHorizontalClick(view2);
            }
        });
        View viewFindRequiredView7 = butterknife.internal.d.findRequiredView(view, p113u.d.iv_attribute_layout_right, "method 'onLayoutRightClick'");
        this.view143d = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeLayoutFragment_ViewBinding.7
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeLayoutFragment.onLayoutRightClick(view2);
            }
        });
        View viewFindRequiredView8 = butterknife.internal.d.findRequiredView(view, p113u.d.iv_attribute_layout_top, "method 'onLayoutTopClick'");
        this.view1443 = viewFindRequiredView8;
        viewFindRequiredView8.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeLayoutFragment_ViewBinding.8
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeLayoutFragment.onLayoutTopClick(view2);
            }
        });
        View viewFindRequiredView9 = butterknife.internal.d.findRequiredView(view, p113u.d.iv_attribute_layout_center_vertical, "method 'onLayoutCenterVerticalClick'");
        this.view143a = viewFindRequiredView9;
        viewFindRequiredView9.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeLayoutFragment_ViewBinding.9
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeLayoutFragment.onLayoutCenterVerticalClick(view2);
            }
        });
        View viewFindRequiredView10 = butterknife.internal.d.findRequiredView(view, p113u.d.iv_attribute_layout_bottom, "method 'onLayoutBottomClick'");
        this.view1438 = viewFindRequiredView10;
        viewFindRequiredView10.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeLayoutFragment_ViewBinding.10
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeLayoutFragment.onLayoutBottomClick(view2);
            }
        });
        View viewFindRequiredView11 = butterknife.internal.d.findRequiredView(view, p113u.d.iv_attribute_layout_horizontal_isometric, "method 'onLayoutHorizontalIsometric'");
        this.view143b = viewFindRequiredView11;
        viewFindRequiredView11.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeLayoutFragment_ViewBinding.11
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeLayoutFragment.onLayoutHorizontalIsometric(view2);
            }
        });
        View viewFindRequiredView12 = butterknife.internal.d.findRequiredView(view, p113u.d.iv_attribute_layout_vertical_isometric, "method 'onLayoutVerticalIsometric'");
        this.view1444 = viewFindRequiredView12;
        viewFindRequiredView12.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeLayoutFragment_ViewBinding.12
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeLayoutFragment.onLayoutVerticalIsometric(view2);
            }
        });
        View viewFindRequiredView13 = butterknife.internal.d.findRequiredView(view, p113u.d.iv_attribute_layout_select_all, "method 'onLayoutSelectAll'");
        this.view143e = viewFindRequiredView13;
        viewFindRequiredView13.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeLayoutFragment_ViewBinding.13
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeLayoutFragment.onLayoutSelectAll(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        if (this.target == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        this.view1442.setOnClickListener(null);
        this.view1442 = null;
        this.view1440.setOnClickListener(null);
        this.view1440 = null;
        this.view1441.setOnClickListener(null);
        this.view1441 = null;
        this.view143f.setOnClickListener(null);
        this.view143f = null;
        this.view143c.setOnClickListener(null);
        this.view143c = null;
        this.view1439.setOnClickListener(null);
        this.view1439 = null;
        this.view143d.setOnClickListener(null);
        this.view143d = null;
        this.view1443.setOnClickListener(null);
        this.view1443 = null;
        this.view143a.setOnClickListener(null);
        this.view143a = null;
        this.view1438.setOnClickListener(null);
        this.view1438 = null;
        this.view143b.setOnClickListener(null);
        this.view143b = null;
        this.view1444.setOnClickListener(null);
        this.view1444 = null;
        this.view143e.setOnClickListener(null);
        this.view143e = null;
    }
}
