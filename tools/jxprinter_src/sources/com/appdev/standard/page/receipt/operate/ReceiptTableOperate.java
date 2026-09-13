package com.appdev.standard.page.receipt.operate;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.appdev.standard.dialog.ContentEditDialog;
import com.appdev.standard.dialog.InterfaceC0453f;
import com.appdev.standard.model.ElementAttributeTableChildBean;
import com.appdev.standard.model.ReceiptElementModel;
import com.appdev.standard.model.ReceiptTableChildDataModel;
import com.appdev.standard.model.ReceiptTableDataModel;
import com.appdev.standard.page.printerlabel.widget.LineProgressWidget;
import com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget;
import com.library.base.util.recyclerview.f;
import java.util.ArrayList;
import java.util.List;
import p052j2.c;
import p113u.d;
import p113u.e;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ReceiptTableOperate extends ReceiptBaseOperate {
    private Integer col;
    private ImageView ivAligmentCenter;
    private ImageView ivAligmentLeft;
    private ImageView ivAligmentRight;
    private ImageView ivStyleBold;
    private ImageView ivStyleItalic;
    private ImageView ivStyleStrikethrough;
    private ImageView ivStyleUnderline;
    private LinearLayout llLineStyle;
    private LinearLayout llStyle;
    private LinearLayout llTableStyle;
    private QuantitySelectorWidget qswColNum;
    private QuantitySelectorWidget qswRowNum;
    private RadioButton rbFontSize1;
    private RadioButton rbFontSize2;
    private RadioButton rbFontSize3;
    private ReceiptTableChildDataModel receiptTableChildDataModel;
    private List<ReceiptTableChildDataModel> receiptTableChildDataModels;
    private ReceiptTableDataModel receiptTableDataModel;
    private int receiptWidth;
    private Integer row;
    private List<List> tableLists;
    private TextView tvLineStyle;
    private TextView tvTableContent;
    private TextView tvTableTitleContent;
    private TextView tvTableTitleStyle;
    private TextView tvTitleStyle;

    public ReceiptTableOperate(Context context, f fVar) {
        super(context, fVar);
        this.receiptTableDataModel = null;
        this.receiptTableChildDataModel = null;
        this.row = 0;
        this.col = 0;
        this.receiptWidth = 58;
    }

    private void initTableTitle() {
        this.tvTableTitleContent = (TextView) this.contentView.findViewById(d.tv_pop_receipt_edit_table_title_1);
        this.tvTableTitleStyle = (TextView) this.contentView.findViewById(d.tv_pop_receipt_edit_table_title_2);
        this.tvTitleStyle = (TextView) this.contentView.findViewById(d.tv_pop_receipt_edit_table_title_3);
        this.tvLineStyle = (TextView) this.contentView.findViewById(d.tv_pop_receipt_edit_table_title_4);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptTableOperate.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TextView textView = ReceiptTableOperate.this.tvTableTitleContent;
                Resources resources = ReceiptTableOperate.this.getResources();
                int i5 = p113u.a.color_333333;
                textView.setTextColor(resources.getColor(i5));
                ReceiptTableOperate.this.tvTableTitleStyle.setTextColor(ReceiptTableOperate.this.getResources().getColor(i5));
                ReceiptTableOperate.this.tvTitleStyle.setTextColor(ReceiptTableOperate.this.getResources().getColor(i5));
                ReceiptTableOperate.this.tvTableContent.setVisibility(8);
                ReceiptTableOperate.this.llTableStyle.setVisibility(8);
                ReceiptTableOperate.this.llStyle.setVisibility(8);
                ReceiptTableOperate.this.llLineStyle.setVisibility(8);
                if (view.getId() == d.tv_pop_receipt_edit_table_title_1) {
                    ReceiptTableOperate.this.tvTableTitleContent.setTextColor(ReceiptTableOperate.this.getResources().getColor(p113u.a.color_FFAE00));
                    ReceiptTableOperate.this.tvTableContent.setVisibility(0);
                    return;
                }
                if (view.getId() == d.tv_pop_receipt_edit_table_title_2) {
                    ReceiptTableOperate.this.tvTableTitleStyle.setTextColor(ReceiptTableOperate.this.getResources().getColor(p113u.a.color_FFAE00));
                    ReceiptTableOperate.this.llTableStyle.setVisibility(0);
                } else if (view.getId() == d.tv_pop_receipt_edit_table_title_3) {
                    ReceiptTableOperate.this.tvTitleStyle.setTextColor(ReceiptTableOperate.this.getResources().getColor(p113u.a.color_FFAE00));
                    ReceiptTableOperate.this.llStyle.setVisibility(0);
                } else if (view.getId() == d.tv_pop_receipt_edit_table_title_4) {
                    ReceiptTableOperate.this.tvLineStyle.setTextColor(ReceiptTableOperate.this.getResources().getColor(p113u.a.color_FFAE00));
                    ReceiptTableOperate.this.llLineStyle.setVisibility(0);
                }
            }
        };
        this.tvTableTitleContent.setOnClickListener(onClickListener);
        this.tvTableTitleStyle.setOnClickListener(onClickListener);
        this.tvTitleStyle.setOnClickListener(onClickListener);
        this.tvLineStyle.setOnClickListener(onClickListener);
    }

    private void initTableTitle1() {
        TextView textView = (TextView) this.contentView.findViewById(d.tv_pop_receipt_edit_table_title_content);
        this.tvTableContent = textView;
        textView.setText(this.receiptTableChildDataModel.getContent());
        this.tvTableContent.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptTableOperate.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ContentEditDialog contentEditDialog = new ContentEditDialog(ReceiptTableOperate.this.context);
                contentEditDialog.a(ReceiptTableOperate.this.receiptTableChildDataModel.getContent());
                contentEditDialog.show();
                contentEditDialog.b = new InterfaceC0453f() { // from class: com.appdev.standard.page.receipt.operate.ReceiptTableOperate.2.1
                    @Override // com.appdev.standard.dialog.InterfaceC0453f
                    public void setNewContent(String str) {
                        ReceiptTableOperate.this.receiptTableChildDataModel.setContent(str);
                        ReceiptTableOperate.this.tvTableContent.setText(str);
                        ReceiptTableOperate.this.updateReceiptTableChildData();
                    }
                };
            }
        });
    }

    private void initTableTitle2() {
        this.llTableStyle = (LinearLayout) this.contentView.findViewById(d.ll_pop_receipt_edit_table_style);
        this.qswRowNum = (QuantitySelectorWidget) this.contentView.findViewById(d.qsw_pop_receipt_edit_table_row_num);
        this.qswColNum = (QuantitySelectorWidget) this.contentView.findViewById(d.qsw_pop_receipt_edit_table_col_num);
        this.qswRowNum.setOffsetValue(this.tableLists.size());
        this.qswColNum.setOffsetValue(this.tableLists.get(0).size());
        this.qswRowNum.setOnValueChangeListener(new QuantitySelectorWidget.OnValueChangeListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptTableOperate.3
            @Override // com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget.OnValueChangeListener
            public void onValue(int i5) {
                int size = ReceiptTableOperate.this.tableLists.size() - i5;
                if (size > 0) {
                    while (size > 0) {
                        ReceiptTableOperate.this.tableLists.remove(ReceiptTableOperate.this.tableLists.size() - 1);
                        if (ReceiptTableOperate.this.row.intValue() > ReceiptTableOperate.this.tableLists.size() - 1) {
                            ReceiptTableOperate receiptTableOperate = ReceiptTableOperate.this;
                            receiptTableOperate.row = Integer.valueOf(receiptTableOperate.tableLists.size() - 1);
                        }
                        size--;
                    }
                } else {
                    if (size >= 0) {
                        return;
                    }
                    List<ElementAttributeTableChildBean> listB = c.b(ReceiptTableOperate.this.tableLists.get(ReceiptTableOperate.this.tableLists.size() - 1), ElementAttributeTableChildBean.class);
                    while (size < 0) {
                        ArrayList arrayList = new ArrayList();
                        for (ElementAttributeTableChildBean elementAttributeTableChildBean : listB) {
                            arrayList.add(new ElementAttributeTableChildBean(elementAttributeTableChildBean.getRowsHeight(), elementAttributeTableChildBean.getColumnsWidth()));
                        }
                        ReceiptTableOperate.this.tableLists.add(arrayList);
                        size++;
                    }
                }
                ReceiptTableOperate receiptTableOperate2 = ReceiptTableOperate.this;
                receiptTableOperate2.receiptTableChildDataModels = c.b(receiptTableOperate2.tableLists.get(ReceiptTableOperate.this.row.intValue()), ReceiptTableChildDataModel.class);
                ReceiptTableOperate receiptTableOperate3 = ReceiptTableOperate.this;
                receiptTableOperate3.receiptTableChildDataModel = (ReceiptTableChildDataModel) receiptTableOperate3.receiptTableChildDataModels.get(ReceiptTableOperate.this.col.intValue());
                ReceiptTableOperate.this.receiptTableDataModel.setTableData(ReceiptTableOperate.this.tableLists);
                ReceiptTableOperate receiptTableOperate4 = ReceiptTableOperate.this;
                receiptTableOperate4.item.setData(c.e(receiptTableOperate4.receiptTableDataModel));
                ReceiptTableOperate.this.quickAdapter.notifyItemChanged(ReceiptTableOperate.this.quickAdapter.getData().indexOf(ReceiptTableOperate.this.item));
            }
        });
        this.qswColNum.setOnValueChangeListener(new QuantitySelectorWidget.OnValueChangeListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptTableOperate.4
            @Override // com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget.OnValueChangeListener
            public void onValue(int i5) {
                for (List list : ReceiptTableOperate.this.tableLists) {
                    int size = list.size() - i5;
                    if (size > 0) {
                        while (size > 0) {
                            androidx.exifinterface.media.a.w(1, list);
                            if (ReceiptTableOperate.this.col.intValue() > list.size() - 1) {
                                ReceiptTableOperate.this.col = Integer.valueOf(list.size() - 1);
                            }
                            size--;
                        }
                    } else if (size < 0) {
                        ElementAttributeTableChildBean elementAttributeTableChildBean = (ElementAttributeTableChildBean) c.d(list.get(list.size() - 1), ElementAttributeTableChildBean.class);
                        while (size < 0) {
                            list.add(new ElementAttributeTableChildBean(elementAttributeTableChildBean.getRowsHeight(), elementAttributeTableChildBean.getColumnsWidth()));
                            size++;
                        }
                    }
                }
                for (int i6 = 0; i6 < ReceiptTableOperate.this.tableLists.size(); i6++) {
                    List listB = c.b(ReceiptTableOperate.this.tableLists.get(i6), ElementAttributeTableChildBean.class);
                    for (int i7 = 0; i7 < listB.size(); i7++) {
                        ((ElementAttributeTableChildBean) listB.get(i7)).setColumnsWidth((ReceiptTableOperate.this.receiptWidth - 10) / i5);
                    }
                    ReceiptTableOperate.this.tableLists.set(i6, listB);
                }
                ReceiptTableOperate receiptTableOperate = ReceiptTableOperate.this;
                receiptTableOperate.receiptTableChildDataModels = c.b(receiptTableOperate.tableLists.get(ReceiptTableOperate.this.row.intValue()), ReceiptTableChildDataModel.class);
                ReceiptTableOperate receiptTableOperate2 = ReceiptTableOperate.this;
                receiptTableOperate2.receiptTableChildDataModel = (ReceiptTableChildDataModel) receiptTableOperate2.receiptTableChildDataModels.get(ReceiptTableOperate.this.col.intValue());
                ReceiptTableOperate.this.receiptTableDataModel.setTableData(ReceiptTableOperate.this.tableLists);
                ReceiptTableOperate receiptTableOperate3 = ReceiptTableOperate.this;
                receiptTableOperate3.item.setData(c.e(receiptTableOperate3.receiptTableDataModel));
                ReceiptTableOperate.this.quickAdapter.notifyItemChanged(ReceiptTableOperate.this.quickAdapter.getData().indexOf(ReceiptTableOperate.this.item));
            }
        });
    }

    private void initTableTitle3() {
        this.tvTitleStyle = (TextView) this.contentView.findViewById(d.tv_pop_receipt_edit_text_title_3);
        this.llStyle = (LinearLayout) this.contentView.findViewById(d.ll_pop_receipt_edit_text_title_style);
        this.rbFontSize1 = (RadioButton) this.contentView.findViewById(d.rb_pop_receipt_edit_text_fontSize_1);
        this.rbFontSize2 = (RadioButton) this.contentView.findViewById(d.rb_pop_receipt_edit_text_fontSize_2);
        this.rbFontSize3 = (RadioButton) this.contentView.findViewById(d.rb_pop_receipt_edit_text_fontSize_3);
        this.ivStyleBold = (ImageView) this.contentView.findViewById(d.iv_pop_receipt_edit_text_style_bold);
        this.ivStyleItalic = (ImageView) this.contentView.findViewById(d.iv_pop_receipt_edit_text_style_italic);
        this.ivStyleUnderline = (ImageView) this.contentView.findViewById(d.iv_pop_receipt_edit_text_style_underline);
        this.ivStyleStrikethrough = (ImageView) this.contentView.findViewById(d.iv_pop_receipt_edit_text_style_strikethrough);
        this.ivAligmentLeft = (ImageView) this.contentView.findViewById(d.iv_pop_receipt_edit_text_aligment_left);
        this.ivAligmentCenter = (ImageView) this.contentView.findViewById(d.iv_pop_receipt_edit_text_aligment_center);
        this.ivAligmentRight = (ImageView) this.contentView.findViewById(d.iv_pop_receipt_edit_text_aligment_right);
        RadioButton radioButton = this.rbFontSize1;
        int i5 = p113u.c.bg_f8f8f8_rad_6;
        radioButton.setBackgroundResource(i5);
        this.rbFontSize2.setBackgroundResource(i5);
        this.rbFontSize3.setBackgroundResource(i5);
        int fontSize = (int) this.receiptTableChildDataModel.getFontSize();
        if (fontSize == 30) {
            this.rbFontSize1.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
        } else if (fontSize == 50) {
            this.rbFontSize2.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
        } else if (fontSize == 70) {
            this.rbFontSize3.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
        }
        if (this.receiptTableChildDataModel.isBold()) {
            this.ivStyleBold.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
        } else {
            this.ivStyleBold.setBackgroundResource(i5);
        }
        if (this.receiptTableChildDataModel.isItalic()) {
            this.ivStyleItalic.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
        } else {
            this.ivStyleItalic.setBackgroundResource(i5);
        }
        if (this.receiptTableChildDataModel.isUnderLine()) {
            this.ivStyleUnderline.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
        } else {
            this.ivStyleUnderline.setBackgroundResource(i5);
        }
        if (this.receiptTableChildDataModel.isDeleteLine()) {
            this.ivStyleStrikethrough.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
        } else {
            this.ivStyleStrikethrough.setBackgroundResource(i5);
        }
        this.ivAligmentLeft.setBackgroundResource(i5);
        this.ivAligmentCenter.setBackgroundResource(i5);
        this.ivAligmentRight.setBackgroundResource(i5);
        int aligment = this.receiptTableChildDataModel.getAligment();
        if (aligment == 0) {
            this.ivAligmentLeft.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
        } else if (aligment == 1) {
            this.ivAligmentCenter.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
        } else if (aligment == 2) {
            this.ivAligmentRight.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptTableOperate.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RadioButton radioButton2 = ReceiptTableOperate.this.rbFontSize1;
                int i6 = p113u.c.bg_f8f8f8_rad_6;
                radioButton2.setBackgroundResource(i6);
                ReceiptTableOperate.this.rbFontSize2.setBackgroundResource(i6);
                ReceiptTableOperate.this.rbFontSize3.setBackgroundResource(i6);
                if (view.getId() == d.rb_pop_receipt_edit_text_fontSize_1) {
                    ReceiptTableOperate.this.receiptTableChildDataModel.setFontSize(30);
                    ReceiptTableOperate.this.rbFontSize1.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
                } else if (view.getId() == d.rb_pop_receipt_edit_text_fontSize_2) {
                    ReceiptTableOperate.this.receiptTableChildDataModel.setFontSize(50);
                    ReceiptTableOperate.this.rbFontSize2.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
                } else if (view.getId() == d.rb_pop_receipt_edit_text_fontSize_3) {
                    ReceiptTableOperate.this.receiptTableChildDataModel.setFontSize(70);
                    ReceiptTableOperate.this.rbFontSize3.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
                } else {
                    ReceiptTableOperate.this.receiptTableChildDataModel.setFontSize(30);
                    ReceiptTableOperate.this.rbFontSize1.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
                }
                ReceiptTableOperate.this.updateReceiptTableChildData();
            }
        };
        this.rbFontSize1.setOnClickListener(onClickListener);
        this.rbFontSize2.setOnClickListener(onClickListener);
        this.rbFontSize3.setOnClickListener(onClickListener);
        this.ivStyleBold.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptTableOperate.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ReceiptTableOperate.this.receiptTableChildDataModel.setBold(!ReceiptTableOperate.this.receiptTableChildDataModel.isBold());
                if (ReceiptTableOperate.this.receiptTableChildDataModel.isBold()) {
                    ReceiptTableOperate.this.ivStyleBold.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
                } else {
                    ReceiptTableOperate.this.ivStyleBold.setBackgroundResource(p113u.c.bg_f8f8f8_rad_6);
                }
                ReceiptTableOperate.this.updateReceiptTableChildData();
            }
        });
        this.ivStyleItalic.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptTableOperate.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ReceiptTableOperate.this.receiptTableChildDataModel.setItalic(!ReceiptTableOperate.this.receiptTableChildDataModel.isItalic());
                if (ReceiptTableOperate.this.receiptTableChildDataModel.isItalic()) {
                    ReceiptTableOperate.this.ivStyleItalic.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
                } else {
                    ReceiptTableOperate.this.ivStyleItalic.setBackgroundResource(p113u.c.bg_f8f8f8_rad_6);
                }
                ReceiptTableOperate.this.updateReceiptTableChildData();
            }
        });
        this.ivStyleUnderline.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptTableOperate.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ReceiptTableOperate.this.receiptTableChildDataModel.setUnderLine(!ReceiptTableOperate.this.receiptTableChildDataModel.isUnderLine());
                if (ReceiptTableOperate.this.receiptTableChildDataModel.isUnderLine()) {
                    ReceiptTableOperate.this.ivStyleUnderline.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
                } else {
                    ReceiptTableOperate.this.ivStyleUnderline.setBackgroundResource(p113u.c.bg_f8f8f8_rad_6);
                }
                ReceiptTableOperate.this.updateReceiptTableChildData();
            }
        });
        this.ivStyleStrikethrough.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptTableOperate.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ReceiptTableOperate.this.receiptTableChildDataModel.setDeleteLine(!ReceiptTableOperate.this.receiptTableChildDataModel.isDeleteLine());
                if (ReceiptTableOperate.this.receiptTableChildDataModel.isDeleteLine()) {
                    ReceiptTableOperate.this.ivStyleStrikethrough.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
                } else {
                    ReceiptTableOperate.this.ivStyleStrikethrough.setBackgroundResource(p113u.c.bg_f8f8f8_rad_6);
                }
                ReceiptTableOperate.this.updateReceiptTableChildData();
            }
        });
        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptTableOperate.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.iv_pop_receipt_edit_text_aligment_left) {
                    ReceiptTableOperate.this.receiptTableChildDataModel.setAligment(0);
                } else if (view.getId() == d.iv_pop_receipt_edit_text_aligment_center) {
                    ReceiptTableOperate.this.receiptTableChildDataModel.setAligment(1);
                } else if (view.getId() == d.iv_pop_receipt_edit_text_aligment_right) {
                    ReceiptTableOperate.this.receiptTableChildDataModel.setAligment(2);
                } else {
                    ReceiptTableOperate.this.receiptTableChildDataModel.setAligment(0);
                }
                ImageView imageView = ReceiptTableOperate.this.ivAligmentLeft;
                int i6 = p113u.c.bg_f8f8f8_rad_6;
                imageView.setBackgroundResource(i6);
                ReceiptTableOperate.this.ivAligmentCenter.setBackgroundResource(i6);
                ReceiptTableOperate.this.ivAligmentRight.setBackgroundResource(i6);
                int aligment2 = ReceiptTableOperate.this.receiptTableChildDataModel.getAligment();
                if (aligment2 == 0) {
                    ReceiptTableOperate.this.ivAligmentLeft.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
                } else if (aligment2 == 1) {
                    ReceiptTableOperate.this.ivAligmentCenter.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
                } else if (aligment2 == 2) {
                    ReceiptTableOperate.this.ivAligmentRight.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
                }
                ReceiptTableOperate.this.updateReceiptTableChildData();
            }
        };
        this.ivAligmentLeft.setOnClickListener(onClickListener2);
        this.ivAligmentCenter.setOnClickListener(onClickListener2);
        this.ivAligmentRight.setOnClickListener(onClickListener2);
    }

    private void initTableTitle4() {
        this.llLineStyle = (LinearLayout) this.contentView.findViewById(d.ll_pop_receipt_edit_line_style);
        LineProgressWidget lineProgressWidget = (LineProgressWidget) this.contentView.findViewById(d.lpw_line_width);
        lineProgressWidget.setPosition(this.receiptTableDataModel.getLineSize());
        lineProgressWidget.setOnRangeUpListener(new LineProgressWidget.OnRangeUpListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptTableOperate.11
            @Override // com.appdev.standard.page.printerlabel.widget.LineProgressWidget.OnRangeUpListener
            public void onRangeUp(float f6) {
                ReceiptTableOperate.this.receiptTableDataModel.setLineSize(f6);
                ReceiptTableOperate receiptTableOperate = ReceiptTableOperate.this;
                receiptTableOperate.item.setData(c.e(receiptTableOperate.receiptTableDataModel));
                ReceiptTableOperate.this.quickAdapter.notifyItemChanged(ReceiptTableOperate.this.quickAdapter.getData().indexOf(ReceiptTableOperate.this.item));
            }
        });
        final ImageView imageView = (ImageView) this.contentView.findViewById(d.iv_open_frame);
        imageView.setImageResource(this.receiptTableDataModel.getOpenFrame() == 1 ? p113u.f.icon_choice_on : p113u.f.icon_choice_off);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptTableOperate.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ReceiptTableOperate.this.receiptTableDataModel.getOpenFrame() == 1) {
                    ReceiptTableOperate.this.receiptTableDataModel.setOpenFrame(0);
                } else {
                    ReceiptTableOperate.this.receiptTableDataModel.setOpenFrame(1);
                }
                imageView.setImageResource(ReceiptTableOperate.this.receiptTableDataModel.getOpenFrame() == 1 ? p113u.f.icon_choice_on : p113u.f.icon_choice_off);
                ReceiptTableOperate receiptTableOperate = ReceiptTableOperate.this;
                receiptTableOperate.item.setData(c.e(receiptTableOperate.receiptTableDataModel));
                ReceiptTableOperate.this.quickAdapter.notifyItemChanged(ReceiptTableOperate.this.quickAdapter.getData().indexOf(ReceiptTableOperate.this.item));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateReceiptTableChildData() {
        this.receiptTableChildDataModels.set(this.col.intValue(), this.receiptTableChildDataModel);
        this.tableLists.set(this.row.intValue(), this.receiptTableChildDataModels);
        this.receiptTableDataModel.setTableData(this.tableLists);
        this.item.setData(c.e(this.receiptTableDataModel));
        this.quickAdapter.notifyItemChanged(this.quickAdapter.getData().indexOf(this.item));
    }

    @Override // com.appdev.standard.page.receipt.operate.ReceiptBaseOperate
    public int getLayoutId() {
        return e.pop_receipt_edit_table;
    }

    @Override // com.appdev.standard.page.receipt.operate.ReceiptBaseOperate
    public void initContent(ReceiptElementModel receiptElementModel) {
        ReceiptTableDataModel receiptTableDataModel = (ReceiptTableDataModel) c.d(receiptElementModel.getData(), ReceiptTableDataModel.class);
        this.receiptTableDataModel = receiptTableDataModel;
        List<List> listB = c.b(receiptTableDataModel.getTableData(), List.class);
        this.tableLists = listB;
        List<ReceiptTableChildDataModel> listB2 = c.b(listB.get(this.row.intValue()), ReceiptTableChildDataModel.class);
        this.receiptTableChildDataModels = listB2;
        this.receiptTableChildDataModel = listB2.get(this.col.intValue());
        initTableTitle1();
        initTableTitle2();
        initTableTitle3();
        initTableTitle4();
        initTableTitle();
    }

    public void show(ReceiptElementModel receiptElementModel, View view, Integer num, Integer num2, int i5) {
        this.row = num;
        this.col = num2;
        this.receiptWidth = i5;
        super.show(receiptElementModel, view);
    }
}
