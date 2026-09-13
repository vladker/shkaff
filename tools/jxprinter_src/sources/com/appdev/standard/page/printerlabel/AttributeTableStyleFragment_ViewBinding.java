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
public class AttributeTableStyleFragment_ViewBinding implements Unbinder {
    private AttributeTableStyleFragment target;
    private View view1445;
    private View view1446;
    private View view1447;
    private View view1448;
    private View view1449;
    private View view144b;
    private View view144c;
    private View view187b;
    private View view187c;
    private View view187d;
    private View view187e;
    private View view187f;

    @UiThread
    public AttributeTableStyleFragment_ViewBinding(final AttributeTableStyleFragment attributeTableStyleFragment, View view) {
        this.target = attributeTableStyleFragment;
        int i5 = p113u.d.tv_table_style_row_col;
        View viewFindRequiredView = butterknife.internal.d.findRequiredView(view, i5, "field 'tvTableStyleRowCol' and method 'onClick'");
        attributeTableStyleFragment.tvTableStyleRowCol = (TextView) butterknife.internal.d.castView(viewFindRequiredView, i5, "field 'tvTableStyleRowCol'", TextView.class);
        this.view187d = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeTableStyleFragment_ViewBinding.1
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeTableStyleFragment.onClick(view2);
            }
        });
        int i6 = p113u.d.tv_table_style_row_height_col_width;
        View viewFindRequiredView2 = butterknife.internal.d.findRequiredView(view, i6, "field 'tvTableStyleRowHeightColWidth' and method 'onClick'");
        attributeTableStyleFragment.tvTableStyleRowHeightColWidth = (TextView) butterknife.internal.d.castView(viewFindRequiredView2, i6, "field 'tvTableStyleRowHeightColWidth'", TextView.class);
        this.view187e = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeTableStyleFragment_ViewBinding.2
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeTableStyleFragment.onClick(view2);
            }
        });
        int i7 = p113u.d.tv_table_style_font;
        View viewFindRequiredView3 = butterknife.internal.d.findRequiredView(view, i7, "field 'tvTableStyleFont' and method 'onClick'");
        attributeTableStyleFragment.tvTableStyleFont = (TextView) butterknife.internal.d.castView(viewFindRequiredView3, i7, "field 'tvTableStyleFont'", TextView.class);
        this.view187b = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeTableStyleFragment_ViewBinding.3
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeTableStyleFragment.onClick(view2);
            }
        });
        int i8 = p113u.d.tv_table_style_font_type;
        View viewFindRequiredView4 = butterknife.internal.d.findRequiredView(view, i8, "field 'tvTableStyleFontType' and method 'onClick'");
        attributeTableStyleFragment.tvTableStyleFontType = (TextView) butterknife.internal.d.castView(viewFindRequiredView4, i8, "field 'tvTableStyleFontType'", TextView.class);
        this.view187c = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeTableStyleFragment_ViewBinding.4
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeTableStyleFragment.onClick(view2);
            }
        });
        int i9 = p113u.d.tv_table_style_style;
        View viewFindRequiredView5 = butterknife.internal.d.findRequiredView(view, i9, "field 'tvTableStyleStyle' and method 'onClick'");
        attributeTableStyleFragment.tvTableStyleStyle = (TextView) butterknife.internal.d.castView(viewFindRequiredView5, i9, "field 'tvTableStyleStyle'", TextView.class);
        this.view187f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeTableStyleFragment_ViewBinding.5
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeTableStyleFragment.onClick(view2);
            }
        });
        attributeTableStyleFragment.lpwTableRowCount = (LineProgressWidget) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.lpw_table_row_count, "field 'lpwTableRowCount'", LineProgressWidget.class);
        attributeTableStyleFragment.lpwTableColCount = (LineProgressWidget) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.lpw_table_col_count, "field 'lpwTableColCount'", LineProgressWidget.class);
        attributeTableStyleFragment.llTableRowCol = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_table_row_col, "field 'llTableRowCol'", LinearLayout.class);
        attributeTableStyleFragment.lpwTableLineSize = (LineProgressWidget) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.lpw_table_line_size, "field 'lpwTableLineSize'", LineProgressWidget.class);
        attributeTableStyleFragment.lpwTableRowHeight = (LineProgressWidget) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.lpw_table_row_height, "field 'lpwTableRowHeight'", LineProgressWidget.class);
        attributeTableStyleFragment.lpwTableColWidth = (LineProgressWidget) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.lpw_table_col_width, "field 'lpwTableColWidth'", LineProgressWidget.class);
        attributeTableStyleFragment.llTableRowHeightColWidth = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_table_row_height_col_width, "field 'llTableRowHeightColWidth'", LinearLayout.class);
        attributeTableStyleFragment.lpwTableFontSize = (LineProgressWidget) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.lpw_table_font_size, "field 'lpwTableFontSize'", LineProgressWidget.class);
        attributeTableStyleFragment.lpwTableWordSpace = (LineProgressWidget) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.lpw_table_word_space, "field 'lpwTableWordSpace'", LineProgressWidget.class);
        attributeTableStyleFragment.lpwTableLinesSpace = (LineProgressWidget) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.lpw_table_lines_space, "field 'lpwTableLinesSpace'", LineProgressWidget.class);
        attributeTableStyleFragment.llTableFontSize = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_table_font_size, "field 'llTableFontSize'", LinearLayout.class);
        attributeTableStyleFragment.rvTableFontType = (RecyclerView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rv_table_font_type, "field 'rvTableFontType'", RecyclerView.class);
        attributeTableStyleFragment.tvTableImportFont = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_table_import_font, "field 'tvTableImportFont'", TextView.class);
        attributeTableStyleFragment.clTableFontTypeContainer = butterknife.internal.d.findRequiredView(view, p113u.d.cl_table_font_type_container, "field 'clTableFontTypeContainer'");
        int i10 = p113u.d.iv_attribute_text_style_bold;
        View viewFindRequiredView6 = butterknife.internal.d.findRequiredView(view, i10, "field 'ivAttributeTextStyleBold' and method 'onBoldClick'");
        attributeTableStyleFragment.ivAttributeTextStyleBold = (ImageView) butterknife.internal.d.castView(viewFindRequiredView6, i10, "field 'ivAttributeTextStyleBold'", ImageView.class);
        this.view1445 = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeTableStyleFragment_ViewBinding.6
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeTableStyleFragment.onBoldClick(view2);
            }
        });
        int i11 = p113u.d.iv_attribute_text_style_italic;
        View viewFindRequiredView7 = butterknife.internal.d.findRequiredView(view, i11, "field 'ivAttributeTextStyleItalic' and method 'onItalicClick'");
        attributeTableStyleFragment.ivAttributeTextStyleItalic = (ImageView) butterknife.internal.d.castView(viewFindRequiredView7, i11, "field 'ivAttributeTextStyleItalic'", ImageView.class);
        this.view1447 = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeTableStyleFragment_ViewBinding.7
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeTableStyleFragment.onItalicClick(view2);
            }
        });
        int i12 = p113u.d.iv_attribute_text_style_underline;
        View viewFindRequiredView8 = butterknife.internal.d.findRequiredView(view, i12, "field 'ivAttributeTextStyleUnderline' and method 'onUnderlineClick'");
        attributeTableStyleFragment.ivAttributeTextStyleUnderline = (ImageView) butterknife.internal.d.castView(viewFindRequiredView8, i12, "field 'ivAttributeTextStyleUnderline'", ImageView.class);
        this.view144c = viewFindRequiredView8;
        viewFindRequiredView8.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeTableStyleFragment_ViewBinding.8
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeTableStyleFragment.onUnderlineClick(view2);
            }
        });
        int i13 = p113u.d.iv_attribute_text_style_strikethrough;
        View viewFindRequiredView9 = butterknife.internal.d.findRequiredView(view, i13, "field 'ivAttributeTextStyleStrikethrough' and method 'onStrikethroughClick'");
        attributeTableStyleFragment.ivAttributeTextStyleStrikethrough = (ImageView) butterknife.internal.d.castView(viewFindRequiredView9, i13, "field 'ivAttributeTextStyleStrikethrough'", ImageView.class);
        this.view144b = viewFindRequiredView9;
        viewFindRequiredView9.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeTableStyleFragment_ViewBinding.9
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeTableStyleFragment.onStrikethroughClick(view2);
            }
        });
        int i14 = p113u.d.iv_attribute_text_style_left;
        View viewFindRequiredView10 = butterknife.internal.d.findRequiredView(view, i14, "field 'ivAttributeTextStyleLeft' and method 'onLeftClick'");
        attributeTableStyleFragment.ivAttributeTextStyleLeft = (ImageView) butterknife.internal.d.castView(viewFindRequiredView10, i14, "field 'ivAttributeTextStyleLeft'", ImageView.class);
        this.view1448 = viewFindRequiredView10;
        viewFindRequiredView10.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeTableStyleFragment_ViewBinding.10
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeTableStyleFragment.onLeftClick(view2);
            }
        });
        int i15 = p113u.d.iv_attribute_text_style_center;
        View viewFindRequiredView11 = butterknife.internal.d.findRequiredView(view, i15, "field 'ivAttributeTextStyleCenter' and method 'onCenterClick'");
        attributeTableStyleFragment.ivAttributeTextStyleCenter = (ImageView) butterknife.internal.d.castView(viewFindRequiredView11, i15, "field 'ivAttributeTextStyleCenter'", ImageView.class);
        this.view1446 = viewFindRequiredView11;
        viewFindRequiredView11.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeTableStyleFragment_ViewBinding.11
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeTableStyleFragment.onCenterClick(view2);
            }
        });
        int i16 = p113u.d.iv_attribute_text_style_right;
        View viewFindRequiredView12 = butterknife.internal.d.findRequiredView(view, i16, "field 'ivAttributeTextStyleRight' and method 'onRightClick'");
        attributeTableStyleFragment.ivAttributeTextStyleRight = (ImageView) butterknife.internal.d.castView(viewFindRequiredView12, i16, "field 'ivAttributeTextStyleRight'", ImageView.class);
        this.view1449 = viewFindRequiredView12;
        viewFindRequiredView12.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeTableStyleFragment_ViewBinding.12
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeTableStyleFragment.onRightClick(view2);
            }
        });
        attributeTableStyleFragment.llTableFontStyle = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_table_font_style, "field 'llTableFontStyle'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AttributeTableStyleFragment attributeTableStyleFragment = this.target;
        if (attributeTableStyleFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        attributeTableStyleFragment.tvTableStyleRowCol = null;
        attributeTableStyleFragment.tvTableStyleRowHeightColWidth = null;
        attributeTableStyleFragment.tvTableStyleFont = null;
        attributeTableStyleFragment.tvTableStyleFontType = null;
        attributeTableStyleFragment.tvTableStyleStyle = null;
        attributeTableStyleFragment.lpwTableRowCount = null;
        attributeTableStyleFragment.lpwTableColCount = null;
        attributeTableStyleFragment.llTableRowCol = null;
        attributeTableStyleFragment.lpwTableLineSize = null;
        attributeTableStyleFragment.lpwTableRowHeight = null;
        attributeTableStyleFragment.lpwTableColWidth = null;
        attributeTableStyleFragment.llTableRowHeightColWidth = null;
        attributeTableStyleFragment.lpwTableFontSize = null;
        attributeTableStyleFragment.lpwTableWordSpace = null;
        attributeTableStyleFragment.lpwTableLinesSpace = null;
        attributeTableStyleFragment.llTableFontSize = null;
        attributeTableStyleFragment.rvTableFontType = null;
        attributeTableStyleFragment.tvTableImportFont = null;
        attributeTableStyleFragment.clTableFontTypeContainer = null;
        attributeTableStyleFragment.ivAttributeTextStyleBold = null;
        attributeTableStyleFragment.ivAttributeTextStyleItalic = null;
        attributeTableStyleFragment.ivAttributeTextStyleUnderline = null;
        attributeTableStyleFragment.ivAttributeTextStyleStrikethrough = null;
        attributeTableStyleFragment.ivAttributeTextStyleLeft = null;
        attributeTableStyleFragment.ivAttributeTextStyleCenter = null;
        attributeTableStyleFragment.ivAttributeTextStyleRight = null;
        attributeTableStyleFragment.llTableFontStyle = null;
        this.view187d.setOnClickListener(null);
        this.view187d = null;
        this.view187e.setOnClickListener(null);
        this.view187e = null;
        this.view187b.setOnClickListener(null);
        this.view187b = null;
        this.view187c.setOnClickListener(null);
        this.view187c = null;
        this.view187f.setOnClickListener(null);
        this.view187f = null;
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
    }
}
