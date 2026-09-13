package com.appdev.standard.page.printerlabel;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import com.appdev.standard.page.printerlabel.widget.LineProgressWidget;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class AttributeBarcodeStyleFragment_ViewBinding implements Unbinder {
    private AttributeBarcodeStyleFragment target;
    private View view1445;
    private View view1446;
    private View view1447;
    private View view1448;
    private View view1449;
    private View view144a;
    private View view144b;
    private View view144c;
    private View view14e7;
    private View view14e8;
    private View view14e9;
    private View view14ea;
    private View view1795;
    private View view1796;
    private View view1798;
    private View view1799;

    @UiThread
    public AttributeBarcodeStyleFragment_ViewBinding(final AttributeBarcodeStyleFragment attributeBarcodeStyleFragment, View view) {
        this.target = attributeBarcodeStyleFragment;
        int i5 = p113u.d.tv_barcode_style_type;
        View viewFindRequiredView = butterknife.internal.d.findRequiredView(view, i5, "field 'tvBarcodeStyleType' and method 'onBarcodeStyleTypeClick'");
        attributeBarcodeStyleFragment.tvBarcodeStyleType = (TextView) butterknife.internal.d.castView(viewFindRequiredView, i5, "field 'tvBarcodeStyleType'", TextView.class);
        this.view1799 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeStyleFragment_ViewBinding.1
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeBarcodeStyleFragment.onBarcodeStyleTypeClick(view2);
            }
        });
        int i6 = p113u.d.tv_barcode_style_font;
        View viewFindRequiredView2 = butterknife.internal.d.findRequiredView(view, i6, "field 'tvBarcodeStyleFont' and method 'onBarcodeStyleFontClick'");
        attributeBarcodeStyleFragment.tvBarcodeStyleFont = (TextView) butterknife.internal.d.castView(viewFindRequiredView2, i6, "field 'tvBarcodeStyleFont'", TextView.class);
        this.view1795 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeStyleFragment_ViewBinding.2
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeBarcodeStyleFragment.onBarcodeStyleFontClick(view2);
            }
        });
        int i7 = p113u.d.tv_barcode_style_font_location;
        View viewFindRequiredView3 = butterknife.internal.d.findRequiredView(view, i7, "field 'tvBarcodeStyleFontLocation' and method 'onBarcodeStyleFontLocationClick'");
        attributeBarcodeStyleFragment.tvBarcodeStyleFontLocation = (TextView) butterknife.internal.d.castView(viewFindRequiredView3, i7, "field 'tvBarcodeStyleFontLocation'", TextView.class);
        this.view1796 = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeStyleFragment_ViewBinding.3
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeBarcodeStyleFragment.onBarcodeStyleFontLocationClick(view2);
            }
        });
        int i8 = p113u.d.tv_barcode_style_text_style;
        View viewFindRequiredView4 = butterknife.internal.d.findRequiredView(view, i8, "field 'tvBarcodeStyleTextStyle' and method 'onBarcodeStyleTextStyleClick'");
        attributeBarcodeStyleFragment.tvBarcodeStyleTextStyle = (TextView) butterknife.internal.d.castView(viewFindRequiredView4, i8, "field 'tvBarcodeStyleTextStyle'", TextView.class);
        this.view1798 = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeStyleFragment_ViewBinding.4
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeBarcodeStyleFragment.onBarcodeStyleTextStyleClick(view2);
            }
        });
        attributeBarcodeStyleFragment.llBarcodeStyleType = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_barcode_style_type, "field 'llBarcodeStyleType'", LinearLayout.class);
        attributeBarcodeStyleFragment.llBarcodeStyleFont = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_barcode_style_font, "field 'llBarcodeStyleFont'", LinearLayout.class);
        attributeBarcodeStyleFragment.llBarcodeStyleFontLocation = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_barcode_style_font_location, "field 'llBarcodeStyleFontLocation'", LinearLayout.class);
        attributeBarcodeStyleFragment.llBarcodeStyleTextStyle = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_barcode_style_text_style, "field 'llBarcodeStyleTextStyle'", LinearLayout.class);
        attributeBarcodeStyleFragment.ivBarcodeStyleLocationTop = (ImageView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.iv_barcode_style_location_top, "field 'ivBarcodeStyleLocationTop'", ImageView.class);
        attributeBarcodeStyleFragment.ivBarcodeStyleLocationBottom = (ImageView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.iv_barcode_style_location_bottom, "field 'ivBarcodeStyleLocationBottom'", ImageView.class);
        attributeBarcodeStyleFragment.ivBarcodeStyleLocationGone = (ImageView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.iv_barcode_style_location_gone, "field 'ivBarcodeStyleLocationGone'", ImageView.class);
        attributeBarcodeStyleFragment.tvFormat = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_barcode_style_format, "field 'tvFormat'", TextView.class);
        attributeBarcodeStyleFragment.ivMore = (ImageView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.iv_barcode_style_format_more, "field 'ivMore'", ImageView.class);
        int i9 = p113u.d.ll_barcode_style_format;
        View viewFindRequiredView5 = butterknife.internal.d.findRequiredView(view, i9, "field 'llFormat' and method 'onFormatClick'");
        attributeBarcodeStyleFragment.llFormat = (LinearLayout) butterknife.internal.d.castView(viewFindRequiredView5, i9, "field 'llFormat'", LinearLayout.class);
        this.view14e7 = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeStyleFragment_ViewBinding.5
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeBarcodeStyleFragment.onFormatClick(view2);
            }
        });
        attributeBarcodeStyleFragment.lpwTextSize = (LineProgressWidget) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.lpw_text_size, "field 'lpwTextSize'", LineProgressWidget.class);
        attributeBarcodeStyleFragment.rvAttributeTextFont = (RecyclerView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rv_attribute_text_font, "field 'rvAttributeTextFont'", RecyclerView.class);
        int i10 = p113u.d.iv_attribute_text_style_bold;
        View viewFindRequiredView6 = butterknife.internal.d.findRequiredView(view, i10, "field 'ivAttributeTextStyleBold' and method 'onBoldClick'");
        attributeBarcodeStyleFragment.ivAttributeTextStyleBold = (ImageView) butterknife.internal.d.castView(viewFindRequiredView6, i10, "field 'ivAttributeTextStyleBold'", ImageView.class);
        this.view1445 = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeStyleFragment_ViewBinding.6
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeBarcodeStyleFragment.onBoldClick(view2);
            }
        });
        int i11 = p113u.d.iv_attribute_text_style_italic;
        View viewFindRequiredView7 = butterknife.internal.d.findRequiredView(view, i11, "field 'ivAttributeTextStyleItalic' and method 'onItalicClick'");
        attributeBarcodeStyleFragment.ivAttributeTextStyleItalic = (ImageView) butterknife.internal.d.castView(viewFindRequiredView7, i11, "field 'ivAttributeTextStyleItalic'", ImageView.class);
        this.view1447 = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeStyleFragment_ViewBinding.7
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeBarcodeStyleFragment.onItalicClick(view2);
            }
        });
        int i12 = p113u.d.iv_attribute_text_style_underline;
        View viewFindRequiredView8 = butterknife.internal.d.findRequiredView(view, i12, "field 'ivAttributeTextStyleUnderline' and method 'onUnderlineClick'");
        attributeBarcodeStyleFragment.ivAttributeTextStyleUnderline = (ImageView) butterknife.internal.d.castView(viewFindRequiredView8, i12, "field 'ivAttributeTextStyleUnderline'", ImageView.class);
        this.view144c = viewFindRequiredView8;
        viewFindRequiredView8.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeStyleFragment_ViewBinding.8
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeBarcodeStyleFragment.onUnderlineClick(view2);
            }
        });
        int i13 = p113u.d.iv_attribute_text_style_strikethrough;
        View viewFindRequiredView9 = butterknife.internal.d.findRequiredView(view, i13, "field 'ivAttributeTextStyleStrikethrough' and method 'onStrikethroughClick'");
        attributeBarcodeStyleFragment.ivAttributeTextStyleStrikethrough = (ImageView) butterknife.internal.d.castView(viewFindRequiredView9, i13, "field 'ivAttributeTextStyleStrikethrough'", ImageView.class);
        this.view144b = viewFindRequiredView9;
        viewFindRequiredView9.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeStyleFragment_ViewBinding.9
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeBarcodeStyleFragment.onStrikethroughClick(view2);
            }
        });
        int i14 = p113u.d.iv_attribute_text_style_left;
        View viewFindRequiredView10 = butterknife.internal.d.findRequiredView(view, i14, "field 'ivAttributeTextStyleLeft' and method 'onLeftClick'");
        attributeBarcodeStyleFragment.ivAttributeTextStyleLeft = (ImageView) butterknife.internal.d.castView(viewFindRequiredView10, i14, "field 'ivAttributeTextStyleLeft'", ImageView.class);
        this.view1448 = viewFindRequiredView10;
        viewFindRequiredView10.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeStyleFragment_ViewBinding.10
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeBarcodeStyleFragment.onLeftClick(view2);
            }
        });
        int i15 = p113u.d.iv_attribute_text_style_center;
        View viewFindRequiredView11 = butterknife.internal.d.findRequiredView(view, i15, "field 'ivAttributeTextStyleCenter' and method 'onCenterClick'");
        attributeBarcodeStyleFragment.ivAttributeTextStyleCenter = (ImageView) butterknife.internal.d.castView(viewFindRequiredView11, i15, "field 'ivAttributeTextStyleCenter'", ImageView.class);
        this.view1446 = viewFindRequiredView11;
        viewFindRequiredView11.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeStyleFragment_ViewBinding.11
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeBarcodeStyleFragment.onCenterClick(view2);
            }
        });
        int i16 = p113u.d.iv_attribute_text_style_right;
        View viewFindRequiredView12 = butterknife.internal.d.findRequiredView(view, i16, "field 'ivAttributeTextStyleRight' and method 'onRightClick'");
        attributeBarcodeStyleFragment.ivAttributeTextStyleRight = (ImageView) butterknife.internal.d.castView(viewFindRequiredView12, i16, "field 'ivAttributeTextStyleRight'", ImageView.class);
        this.view1449 = viewFindRequiredView12;
        viewFindRequiredView12.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeStyleFragment_ViewBinding.12
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeBarcodeStyleFragment.onRightClick(view2);
            }
        });
        int i17 = p113u.d.iv_attribute_text_style_stretch;
        View viewFindRequiredView13 = butterknife.internal.d.findRequiredView(view, i17, "field 'ivAttributeTextStyleStretch' and method 'onStretchClick'");
        attributeBarcodeStyleFragment.ivAttributeTextStyleStretch = (ImageView) butterknife.internal.d.castView(viewFindRequiredView13, i17, "field 'ivAttributeTextStyleStretch'", ImageView.class);
        this.view144a = viewFindRequiredView13;
        viewFindRequiredView13.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeStyleFragment_ViewBinding.13
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeBarcodeStyleFragment.onStretchClick(view2);
            }
        });
        View viewFindRequiredView14 = butterknife.internal.d.findRequiredView(view, p113u.d.ll_barcode_style_location_bottom, "method 'onLocationBottomClick'");
        this.view14e8 = viewFindRequiredView14;
        viewFindRequiredView14.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeStyleFragment_ViewBinding.14
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeBarcodeStyleFragment.onLocationBottomClick(view2);
            }
        });
        View viewFindRequiredView15 = butterknife.internal.d.findRequiredView(view, p113u.d.ll_barcode_style_location_top, "method 'onLocationTopClick'");
        this.view14ea = viewFindRequiredView15;
        viewFindRequiredView15.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeStyleFragment_ViewBinding.15
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeBarcodeStyleFragment.onLocationTopClick(view2);
            }
        });
        View viewFindRequiredView16 = butterknife.internal.d.findRequiredView(view, p113u.d.ll_barcode_style_location_gone, "method 'onLocationGoneClick'");
        this.view14e9 = viewFindRequiredView16;
        viewFindRequiredView16.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeStyleFragment_ViewBinding.16
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeBarcodeStyleFragment.onLocationGoneClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AttributeBarcodeStyleFragment attributeBarcodeStyleFragment = this.target;
        if (attributeBarcodeStyleFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        attributeBarcodeStyleFragment.tvBarcodeStyleType = null;
        attributeBarcodeStyleFragment.tvBarcodeStyleFont = null;
        attributeBarcodeStyleFragment.tvBarcodeStyleFontLocation = null;
        attributeBarcodeStyleFragment.tvBarcodeStyleTextStyle = null;
        attributeBarcodeStyleFragment.llBarcodeStyleType = null;
        attributeBarcodeStyleFragment.llBarcodeStyleFont = null;
        attributeBarcodeStyleFragment.llBarcodeStyleFontLocation = null;
        attributeBarcodeStyleFragment.llBarcodeStyleTextStyle = null;
        attributeBarcodeStyleFragment.ivBarcodeStyleLocationTop = null;
        attributeBarcodeStyleFragment.ivBarcodeStyleLocationBottom = null;
        attributeBarcodeStyleFragment.ivBarcodeStyleLocationGone = null;
        attributeBarcodeStyleFragment.tvFormat = null;
        attributeBarcodeStyleFragment.ivMore = null;
        attributeBarcodeStyleFragment.llFormat = null;
        attributeBarcodeStyleFragment.lpwTextSize = null;
        attributeBarcodeStyleFragment.rvAttributeTextFont = null;
        attributeBarcodeStyleFragment.ivAttributeTextStyleBold = null;
        attributeBarcodeStyleFragment.ivAttributeTextStyleItalic = null;
        attributeBarcodeStyleFragment.ivAttributeTextStyleUnderline = null;
        attributeBarcodeStyleFragment.ivAttributeTextStyleStrikethrough = null;
        attributeBarcodeStyleFragment.ivAttributeTextStyleLeft = null;
        attributeBarcodeStyleFragment.ivAttributeTextStyleCenter = null;
        attributeBarcodeStyleFragment.ivAttributeTextStyleRight = null;
        attributeBarcodeStyleFragment.ivAttributeTextStyleStretch = null;
        this.view1799.setOnClickListener(null);
        this.view1799 = null;
        this.view1795.setOnClickListener(null);
        this.view1795 = null;
        this.view1796.setOnClickListener(null);
        this.view1796 = null;
        this.view1798.setOnClickListener(null);
        this.view1798 = null;
        this.view14e7.setOnClickListener(null);
        this.view14e7 = null;
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
        this.view14e8.setOnClickListener(null);
        this.view14e8 = null;
        this.view14ea.setOnClickListener(null);
        this.view14ea = null;
        this.view14e9.setOnClickListener(null);
        this.view14e9 = null;
    }
}
