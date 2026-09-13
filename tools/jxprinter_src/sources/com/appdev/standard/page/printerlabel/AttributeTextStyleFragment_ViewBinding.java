package com.appdev.standard.page.printerlabel;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.appdev.standard.page.printerlabel.widget.LineProgressWidget;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class AttributeTextStyleFragment_ViewBinding implements Unbinder {
    private AttributeTextStyleFragment target;
    private View view1445;
    private View view1446;
    private View view1447;
    private View view1448;
    private View view1449;
    private View view144a;
    private View view144b;
    private View view144c;
    private View view14b8;
    private View view14b9;
    private View view14ba;
    private View view14bb;

    @UiThread
    public AttributeTextStyleFragment_ViewBinding(final AttributeTextStyleFragment attributeTextStyleFragment, View view) {
        this.target = attributeTextStyleFragment;
        attributeTextStyleFragment.lpwTextSize = (LineProgressWidget) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.lpw_text_size, "field 'lpwTextSize'", LineProgressWidget.class);
        int i5 = p113u.d.iv_attribute_text_style_bold;
        View viewFindRequiredView = butterknife.internal.d.findRequiredView(view, i5, "field 'ivAttributeTextStyleBold' and method 'onBoldClick'");
        attributeTextStyleFragment.ivAttributeTextStyleBold = (ImageView) butterknife.internal.d.castView(viewFindRequiredView, i5, "field 'ivAttributeTextStyleBold'", ImageView.class);
        this.view1445 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeTextStyleFragment_ViewBinding.1
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeTextStyleFragment.onBoldClick(view2);
            }
        });
        int i6 = p113u.d.iv_attribute_text_style_italic;
        View viewFindRequiredView2 = butterknife.internal.d.findRequiredView(view, i6, "field 'ivAttributeTextStyleItalic' and method 'onItalicClick'");
        attributeTextStyleFragment.ivAttributeTextStyleItalic = (ImageView) butterknife.internal.d.castView(viewFindRequiredView2, i6, "field 'ivAttributeTextStyleItalic'", ImageView.class);
        this.view1447 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeTextStyleFragment_ViewBinding.2
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeTextStyleFragment.onItalicClick(view2);
            }
        });
        int i7 = p113u.d.iv_attribute_text_style_underline;
        View viewFindRequiredView3 = butterknife.internal.d.findRequiredView(view, i7, "field 'ivAttributeTextStyleUnderline' and method 'onUnderlineClick'");
        attributeTextStyleFragment.ivAttributeTextStyleUnderline = (ImageView) butterknife.internal.d.castView(viewFindRequiredView3, i7, "field 'ivAttributeTextStyleUnderline'", ImageView.class);
        this.view144c = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeTextStyleFragment_ViewBinding.3
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeTextStyleFragment.onUnderlineClick(view2);
            }
        });
        int i8 = p113u.d.iv_attribute_text_style_strikethrough;
        View viewFindRequiredView4 = butterknife.internal.d.findRequiredView(view, i8, "field 'ivAttributeTextStyleStrikethrough' and method 'onStrikethroughClick'");
        attributeTextStyleFragment.ivAttributeTextStyleStrikethrough = (ImageView) butterknife.internal.d.castView(viewFindRequiredView4, i8, "field 'ivAttributeTextStyleStrikethrough'", ImageView.class);
        this.view144b = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeTextStyleFragment_ViewBinding.4
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeTextStyleFragment.onStrikethroughClick(view2);
            }
        });
        int i9 = p113u.d.iv_attribute_text_style_left;
        View viewFindRequiredView5 = butterknife.internal.d.findRequiredView(view, i9, "field 'ivAttributeTextStyleLeft' and method 'onLeftClick'");
        attributeTextStyleFragment.ivAttributeTextStyleLeft = (ImageView) butterknife.internal.d.castView(viewFindRequiredView5, i9, "field 'ivAttributeTextStyleLeft'", ImageView.class);
        this.view1448 = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeTextStyleFragment_ViewBinding.5
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeTextStyleFragment.onLeftClick(view2);
            }
        });
        int i10 = p113u.d.iv_attribute_text_style_center;
        View viewFindRequiredView6 = butterknife.internal.d.findRequiredView(view, i10, "field 'ivAttributeTextStyleCenter' and method 'onCenterClick'");
        attributeTextStyleFragment.ivAttributeTextStyleCenter = (ImageView) butterknife.internal.d.castView(viewFindRequiredView6, i10, "field 'ivAttributeTextStyleCenter'", ImageView.class);
        this.view1446 = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeTextStyleFragment_ViewBinding.6
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeTextStyleFragment.onCenterClick(view2);
            }
        });
        int i11 = p113u.d.iv_attribute_text_style_right;
        View viewFindRequiredView7 = butterknife.internal.d.findRequiredView(view, i11, "field 'ivAttributeTextStyleRight' and method 'onRightClick'");
        attributeTextStyleFragment.ivAttributeTextStyleRight = (ImageView) butterknife.internal.d.castView(viewFindRequiredView7, i11, "field 'ivAttributeTextStyleRight'", ImageView.class);
        this.view1449 = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeTextStyleFragment_ViewBinding.7
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeTextStyleFragment.onRightClick(view2);
            }
        });
        int i12 = p113u.d.iv_attribute_text_style_stretch;
        View viewFindRequiredView8 = butterknife.internal.d.findRequiredView(view, i12, "field 'ivAttributeTextStyleStretch' and method 'onStretchClick'");
        attributeTextStyleFragment.ivAttributeTextStyleStretch = (ImageView) butterknife.internal.d.castView(viewFindRequiredView8, i12, "field 'ivAttributeTextStyleStretch'", ImageView.class);
        this.view144a = viewFindRequiredView8;
        viewFindRequiredView8.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeTextStyleFragment_ViewBinding.8
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeTextStyleFragment.onStretchClick(view2);
            }
        });
        int i13 = p113u.d.iv_text_style_horizontal;
        View viewFindRequiredView9 = butterknife.internal.d.findRequiredView(view, i13, "field 'ivTextStyleHorizontal' and method 'onHorizontalStyleClick'");
        attributeTextStyleFragment.ivTextStyleHorizontal = (ImageView) butterknife.internal.d.castView(viewFindRequiredView9, i13, "field 'ivTextStyleHorizontal'", ImageView.class);
        this.view14b9 = viewFindRequiredView9;
        viewFindRequiredView9.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeTextStyleFragment_ViewBinding.9
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeTextStyleFragment.onHorizontalStyleClick(view2);
            }
        });
        int i14 = p113u.d.iv_text_style_scroll_pair;
        View viewFindRequiredView10 = butterknife.internal.d.findRequiredView(view, i14, "field 'ivTextStyleScrollPair' and method 'onScrollPairStyleClick'");
        attributeTextStyleFragment.ivTextStyleScrollPair = (ImageView) butterknife.internal.d.castView(viewFindRequiredView10, i14, "field 'ivTextStyleScrollPair'", ImageView.class);
        this.view14ba = viewFindRequiredView10;
        viewFindRequiredView10.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeTextStyleFragment_ViewBinding.10
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeTextStyleFragment.onScrollPairStyleClick(view2);
            }
        });
        int i15 = p113u.d.iv_text_style_vertical_pair;
        View viewFindRequiredView11 = butterknife.internal.d.findRequiredView(view, i15, "field 'ivTextStyleVerticalPair' and method 'onVerticalPairStyleClick'");
        attributeTextStyleFragment.ivTextStyleVerticalPair = (ImageView) butterknife.internal.d.castView(viewFindRequiredView11, i15, "field 'ivTextStyleVerticalPair'", ImageView.class);
        this.view14bb = viewFindRequiredView11;
        viewFindRequiredView11.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeTextStyleFragment_ViewBinding.11
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeTextStyleFragment.onVerticalPairStyleClick(view2);
            }
        });
        int i16 = p113u.d.iv_text_style_arch_curve;
        View viewFindRequiredView12 = butterknife.internal.d.findRequiredView(view, i16, "field 'ivTextStyleArchCurve' and method 'onArchCurveStyleClick'");
        attributeTextStyleFragment.ivTextStyleArchCurve = (ImageView) butterknife.internal.d.castView(viewFindRequiredView12, i16, "field 'ivTextStyleArchCurve'", ImageView.class);
        this.view14b8 = viewFindRequiredView12;
        viewFindRequiredView12.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeTextStyleFragment_ViewBinding.12
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeTextStyleFragment.onArchCurveStyleClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AttributeTextStyleFragment attributeTextStyleFragment = this.target;
        if (attributeTextStyleFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        attributeTextStyleFragment.lpwTextSize = null;
        attributeTextStyleFragment.ivAttributeTextStyleBold = null;
        attributeTextStyleFragment.ivAttributeTextStyleItalic = null;
        attributeTextStyleFragment.ivAttributeTextStyleUnderline = null;
        attributeTextStyleFragment.ivAttributeTextStyleStrikethrough = null;
        attributeTextStyleFragment.ivAttributeTextStyleLeft = null;
        attributeTextStyleFragment.ivAttributeTextStyleCenter = null;
        attributeTextStyleFragment.ivAttributeTextStyleRight = null;
        attributeTextStyleFragment.ivAttributeTextStyleStretch = null;
        attributeTextStyleFragment.ivTextStyleHorizontal = null;
        attributeTextStyleFragment.ivTextStyleScrollPair = null;
        attributeTextStyleFragment.ivTextStyleVerticalPair = null;
        attributeTextStyleFragment.ivTextStyleArchCurve = null;
        this.view1445.setOnClickListener(null);
        this.view1445 = null;
        this.view1447.setOnClickListener(null);
        this.view1447 = null;
        this.view144c.setOnClickListener(null);
        this.view144c = null;
        this.view144b.setOnClickListener(null);
        this.view144b = null;
        this.view1448.setOnClickListener(null);
        this.view1448 = null;
        this.view1446.setOnClickListener(null);
        this.view1446 = null;
        this.view1449.setOnClickListener(null);
        this.view1449 = null;
        this.view144a.setOnClickListener(null);
        this.view144a = null;
        this.view14b9.setOnClickListener(null);
        this.view14b9 = null;
        this.view14ba.setOnClickListener(null);
        this.view14ba = null;
        this.view14bb.setOnClickListener(null);
        this.view14bb = null;
        this.view14b8.setOnClickListener(null);
        this.view14b8 = null;
    }
}
