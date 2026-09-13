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
import com.appdev.standard.dialog.T;
import com.appdev.standard.dialog.TimeOffsetDialog;
import com.appdev.standard.model.ReceiptDateDataModel;
import com.appdev.standard.model.ReceiptElementModel;
import com.library.base.util.recyclerview.f;
import java.util.Date;
import kotlin.jvm.internal.Y;
import p051j0.i;
import p052j2.c;
import p113u.d;
import p113u.e;
import p113u.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ReceiptDateOperate extends ReceiptBaseOperate {
    private Date fixedDate;
    private ImageView ivDateAligmentCenter;
    private ImageView ivDateAligmentLeft;
    private ImageView ivDateAligmentRight;
    private ImageView ivDateStyleBold;
    private ImageView ivDateStyleItalic;
    private ImageView ivDateStyleStrikethrough;
    private ImageView ivDateStyleUnderline;
    private LinearLayout llDateData;
    private LinearLayout llDateStyle;
    private RadioButton rbDateFontSize1;
    private RadioButton rbDateFontSize2;
    private RadioButton rbDateFontSize3;
    private ReceiptDateDataModel receiptDateDataModel;
    private TextView tvDateDate;
    private TextView tvDateDynamicTime;
    private TextView tvDateFixedTime;
    private TextView tvDatePrefix;
    private TextView tvDateSettingTimeOffset;
    private TextView tvDateSuffix;
    private TextView tvDateTime;
    private TextView tvDateTitleContent;
    private TextView tvDateTitleStyle;

    public ReceiptDateOperate(Context context, f fVar) {
        super(context, fVar);
        this.fixedDate = new Date();
    }

    private void initTextTitle() {
        this.tvDateTitleContent = (TextView) this.contentView.findViewById(d.tv_pop_receipt_edit_date_title_1);
        this.tvDateTitleStyle = (TextView) this.contentView.findViewById(d.tv_pop_receipt_edit_date_title_2);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptDateOperate.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ReceiptDateOperate.this.selectType(view.getId());
            }
        };
        this.tvDateTitleContent.setOnClickListener(onClickListener);
        this.tvDateTitleStyle.setOnClickListener(onClickListener);
    }

    private void initTextTitle1() {
        this.llDateData = (LinearLayout) this.contentView.findViewById(d.ll_pop_receipt_edit_date_data);
        this.tvDatePrefix = (TextView) this.contentView.findViewById(d.tv_pop_receipt_edit_date_prefix);
        this.tvDateSuffix = (TextView) this.contentView.findViewById(d.tv_pop_receipt_edit_date_suffix);
        this.tvDateDate = (TextView) this.contentView.findViewById(d.tv_pop_receipt_edit_date_date);
        this.tvDateTime = (TextView) this.contentView.findViewById(d.tv_pop_receipt_edit_date_time);
        this.tvDateDynamicTime = (TextView) this.contentView.findViewById(d.tv_date_dynamic_time);
        this.tvDateFixedTime = (TextView) this.contentView.findViewById(d.tv_date_fixed_time);
        this.tvDateSettingTimeOffset = (TextView) this.contentView.findViewById(d.tv_date_setting_time_offset);
        this.tvDatePrefix.setText(this.receiptDateDataModel.getPrefix());
        this.tvDateSuffix.setText(this.receiptDateDataModel.getSuffix());
        this.tvDateDate.setText(Y.f(this.receiptDateDataModel.getDateFormat()) ? i.f5400a : this.receiptDateDataModel.getDateFormat());
        this.tvDateTime.setText(Y.f(this.receiptDateDataModel.getTimeFormat()) ? i.f5400a : this.receiptDateDataModel.getTimeFormat());
        setTimeType(this.receiptDateDataModel.getTimeType());
        this.tvDateDynamicTime.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptDateOperate.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ReceiptDateOperate.this.setTimeType(1);
            }
        });
        this.tvDateFixedTime.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptDateOperate.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ReceiptDateOperate.this.setTimeType(0);
            }
        });
        this.tvDateSettingTimeOffset.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptDateOperate.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TimeOffsetDialog timeOffsetDialog = new TimeOffsetDialog(ReceiptDateOperate.this.context);
                timeOffsetDialog.a(ReceiptDateOperate.this.receiptDateDataModel.getTimeOffsetYear(), ReceiptDateOperate.this.receiptDateDataModel.getTimeOffsetMonth(), ReceiptDateOperate.this.receiptDateDataModel.getTimeOffsetDay(), ReceiptDateOperate.this.receiptDateDataModel.getTimeOffsetHour(), ReceiptDateOperate.this.receiptDateDataModel.getTimeOffsetMinute(), ReceiptDateOperate.this.receiptDateDataModel.getTimeOffsetSecond());
                timeOffsetDialog.f2634g = new T() { // from class: com.appdev.standard.page.receipt.operate.ReceiptDateOperate.3.1
                    @Override // com.appdev.standard.dialog.T
                    public void updateDateValue(int i5, int i6, int i7, int i8, int i9, int i10) {
                        ReceiptDateOperate.this.receiptDateDataModel.setTimeOffsetYear(i5);
                        ReceiptDateOperate.this.receiptDateDataModel.setTimeOffsetMonth(i6);
                        ReceiptDateOperate.this.receiptDateDataModel.setTimeOffsetDay(i7);
                        ReceiptDateOperate.this.receiptDateDataModel.setTimeOffsetHour(i8);
                        ReceiptDateOperate.this.receiptDateDataModel.setTimeOffsetMinute(i9);
                        ReceiptDateOperate.this.receiptDateDataModel.setTimeOffsetSecond(i10);
                        ReceiptDateOperate receiptDateOperate = ReceiptDateOperate.this;
                        receiptDateOperate.item.setData(c.e(receiptDateOperate.receiptDateDataModel));
                        ReceiptDateOperate.this.quickAdapter.notifyItemChanged(ReceiptDateOperate.this.quickAdapter.getData().indexOf(ReceiptDateOperate.this.item));
                    }
                };
                timeOffsetDialog.show();
            }
        });
        this.tvDatePrefix.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptDateOperate.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ContentEditDialog contentEditDialog = new ContentEditDialog(ReceiptDateOperate.this.context);
                contentEditDialog.a(ReceiptDateOperate.this.receiptDateDataModel.getPrefix());
                contentEditDialog.show();
                contentEditDialog.b = new InterfaceC0453f() { // from class: com.appdev.standard.page.receipt.operate.ReceiptDateOperate.4.1
                    @Override // com.appdev.standard.dialog.InterfaceC0453f
                    public void setNewContent(String str) {
                        ReceiptDateOperate.this.receiptDateDataModel.setPrefix(str);
                        ReceiptDateOperate.this.tvDatePrefix.setText(str);
                        ReceiptDateOperate receiptDateOperate = ReceiptDateOperate.this;
                        receiptDateOperate.item.setData(c.e(receiptDateOperate.receiptDateDataModel));
                        ReceiptDateOperate.this.quickAdapter.notifyItemChanged(ReceiptDateOperate.this.quickAdapter.getData().indexOf(ReceiptDateOperate.this.item));
                    }
                };
            }
        });
        this.tvDateSuffix.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptDateOperate.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ContentEditDialog contentEditDialog = new ContentEditDialog(ReceiptDateOperate.this.context);
                contentEditDialog.a(ReceiptDateOperate.this.receiptDateDataModel.getSuffix());
                contentEditDialog.show();
                contentEditDialog.b = new InterfaceC0453f() { // from class: com.appdev.standard.page.receipt.operate.ReceiptDateOperate.5.1
                    @Override // com.appdev.standard.dialog.InterfaceC0453f
                    public void setNewContent(String str) {
                        ReceiptDateOperate.this.receiptDateDataModel.setSuffix(str);
                        ReceiptDateOperate.this.tvDateSuffix.setText(str);
                        ReceiptDateOperate receiptDateOperate = ReceiptDateOperate.this;
                        receiptDateOperate.item.setData(c.e(receiptDateOperate.receiptDateDataModel));
                        ReceiptDateOperate.this.quickAdapter.notifyItemChanged(ReceiptDateOperate.this.quickAdapter.getData().indexOf(ReceiptDateOperate.this.item));
                    }
                };
            }
        });
        this.tvDateDate.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptDateOperate.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                p097r0.a aVar = new p097r0.a(ReceiptDateOperate.this.context, new p109t0.a() { // from class: com.appdev.standard.page.receipt.operate.ReceiptDateOperate.6.1
                    @Override // p109t0.a
                    public void onOptionsSelect(int i5, int i6, int i7, View view2) {
                        ReceiptDateOperate.this.tvDateDate.setText((CharSequence) i.f().get(i5));
                        ReceiptDateOperate.this.receiptDateDataModel.setDateFormat(i.f5400a.equals(i.g().get(i5)) ? "" : (String) i.g().get(i5));
                        ReceiptDateOperate receiptDateOperate = ReceiptDateOperate.this;
                        receiptDateOperate.item.setData(c.e(receiptDateOperate.receiptDateDataModel));
                        ReceiptDateOperate.this.quickAdapter.notifyItemChanged(ReceiptDateOperate.this.quickAdapter.getData().indexOf(ReceiptDateOperate.this.item));
                        ReceiptDateOperate.this.show();
                    }
                });
                aVar.f7931a.f8190k = ReceiptDateOperate.this.context.getString(g.text_286);
                aVar.f7931a.f8188i = ReceiptDateOperate.this.getResources().getString(g.confirm);
                String string = ReceiptDateOperate.this.getResources().getString(g.cancel);
                p103s0.a aVar2 = aVar.f7931a;
                aVar2.f8189j = string;
                aVar2.f8192m = 14;
                aVar2.f8191l = 14;
                p114u0.d dVarA = aVar.a();
                dVarA.f(i.f());
                dVarA.g(1);
                ReceiptDateOperate.this.hide();
                dVarA.h();
            }
        });
        this.tvDateTime.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptDateOperate.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                p097r0.a aVar = new p097r0.a(ReceiptDateOperate.this.context, new p109t0.a() { // from class: com.appdev.standard.page.receipt.operate.ReceiptDateOperate.7.1
                    @Override // p109t0.a
                    public void onOptionsSelect(int i5, int i6, int i7, View view2) {
                        ReceiptDateOperate.this.tvDateTime.setText((CharSequence) i.e().get(i5));
                        ReceiptDateOperate.this.receiptDateDataModel.setTimeFormat(i.f5400a.equals(i.d().get(i5)) ? "" : (String) i.d().get(i5));
                        ReceiptDateOperate receiptDateOperate = ReceiptDateOperate.this;
                        receiptDateOperate.item.setData(c.e(receiptDateOperate.receiptDateDataModel));
                        ReceiptDateOperate.this.quickAdapter.notifyItemChanged(ReceiptDateOperate.this.quickAdapter.getData().indexOf(ReceiptDateOperate.this.item));
                        ReceiptDateOperate.this.show();
                    }
                });
                aVar.f7931a.f8190k = ReceiptDateOperate.this.context.getString(g.text_286);
                aVar.f7931a.f8188i = ReceiptDateOperate.this.getResources().getString(g.confirm);
                String string = ReceiptDateOperate.this.getResources().getString(g.cancel);
                p103s0.a aVar2 = aVar.f7931a;
                aVar2.f8189j = string;
                aVar2.f8192m = 14;
                aVar2.f8191l = 14;
                p114u0.d dVarA = aVar.a();
                dVarA.f(i.e());
                dVarA.g(0);
                ReceiptDateOperate.this.hide();
                dVarA.h();
            }
        });
    }

    private void initTextTitle2() {
        this.llDateStyle = (LinearLayout) this.contentView.findViewById(d.ll_pop_receipt_edit_date_style);
        this.rbDateFontSize1 = (RadioButton) this.contentView.findViewById(d.rb_pop_receipt_edit_date_fontSize_1);
        this.rbDateFontSize2 = (RadioButton) this.contentView.findViewById(d.rb_pop_receipt_edit_date_fontSize_2);
        this.rbDateFontSize3 = (RadioButton) this.contentView.findViewById(d.rb_pop_receipt_edit_date_fontSize_3);
        this.ivDateStyleBold = (ImageView) this.contentView.findViewById(d.iv_pop_receipt_edit_date_style_bold);
        this.ivDateStyleItalic = (ImageView) this.contentView.findViewById(d.iv_pop_receipt_edit_date_style_italic);
        this.ivDateStyleUnderline = (ImageView) this.contentView.findViewById(d.iv_pop_receipt_edit_date_style_underline);
        this.ivDateStyleStrikethrough = (ImageView) this.contentView.findViewById(d.iv_pop_receipt_edit_date_style_strikethrough);
        this.ivDateAligmentLeft = (ImageView) this.contentView.findViewById(d.iv_pop_receipt_edit_date_aligment_left);
        this.ivDateAligmentCenter = (ImageView) this.contentView.findViewById(d.iv_pop_receipt_edit_date_aligment_center);
        this.ivDateAligmentRight = (ImageView) this.contentView.findViewById(d.iv_pop_receipt_edit_date_aligment_right);
        int fontSize = this.receiptDateDataModel.getFontSize();
        if (fontSize == 30) {
            this.rbDateFontSize1.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
            RadioButton radioButton = this.rbDateFontSize2;
            int i5 = p113u.c.bg_f8f8f8_rad_6;
            radioButton.setBackgroundResource(i5);
            this.rbDateFontSize3.setBackgroundResource(i5);
        } else if (fontSize == 50) {
            RadioButton radioButton2 = this.rbDateFontSize1;
            int i6 = p113u.c.bg_f8f8f8_rad_6;
            radioButton2.setBackgroundResource(i6);
            this.rbDateFontSize2.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
            this.rbDateFontSize3.setBackgroundResource(i6);
        } else if (fontSize == 70) {
            RadioButton radioButton3 = this.rbDateFontSize1;
            int i7 = p113u.c.bg_f8f8f8_rad_6;
            radioButton3.setBackgroundResource(i7);
            this.rbDateFontSize2.setBackgroundResource(i7);
            this.rbDateFontSize3.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
        }
        if (this.receiptDateDataModel.isBold()) {
            this.ivDateStyleBold.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
        } else {
            this.ivDateStyleBold.setBackgroundResource(p113u.c.bg_f8f8f8_rad_6);
        }
        if (this.receiptDateDataModel.isItalic()) {
            this.ivDateStyleItalic.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
        } else {
            this.ivDateStyleItalic.setBackgroundResource(p113u.c.bg_f8f8f8_rad_6);
        }
        if (this.receiptDateDataModel.isUnderLine()) {
            this.ivDateStyleUnderline.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
        } else {
            this.ivDateStyleUnderline.setBackgroundResource(p113u.c.bg_f8f8f8_rad_6);
        }
        if (this.receiptDateDataModel.isDeleteLine()) {
            this.ivDateStyleStrikethrough.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
        } else {
            this.ivDateStyleStrikethrough.setBackgroundResource(p113u.c.bg_f8f8f8_rad_6);
        }
        int aligment = this.receiptDateDataModel.getAligment();
        if (aligment == 0) {
            this.ivDateAligmentLeft.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
            ImageView imageView = this.ivDateAligmentCenter;
            int i8 = p113u.c.bg_f8f8f8_rad_6;
            imageView.setBackgroundResource(i8);
            this.ivDateAligmentRight.setBackgroundResource(i8);
        } else if (aligment == 1) {
            ImageView imageView2 = this.ivDateAligmentLeft;
            int i9 = p113u.c.bg_f8f8f8_rad_6;
            imageView2.setBackgroundResource(i9);
            this.ivDateAligmentCenter.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
            this.ivDateAligmentRight.setBackgroundResource(i9);
        } else if (aligment == 2) {
            ImageView imageView3 = this.ivDateAligmentLeft;
            int i10 = p113u.c.bg_f8f8f8_rad_6;
            imageView3.setBackgroundResource(i10);
            this.ivDateAligmentCenter.setBackgroundResource(i10);
            this.ivDateAligmentRight.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
        }
        this.rbDateFontSize1.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptDateOperate.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ReceiptDateOperate.this.rbDateFontSize1.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
                RadioButton radioButton4 = ReceiptDateOperate.this.rbDateFontSize2;
                int i11 = p113u.c.bg_f8f8f8_rad_6;
                radioButton4.setBackgroundResource(i11);
                ReceiptDateOperate.this.rbDateFontSize3.setBackgroundResource(i11);
                ReceiptDateOperate.this.receiptDateDataModel.setFontSize(30);
                ReceiptDateOperate receiptDateOperate = ReceiptDateOperate.this;
                receiptDateOperate.item.setData(c.e(receiptDateOperate.receiptDateDataModel));
                ReceiptDateOperate.this.quickAdapter.notifyItemChanged(ReceiptDateOperate.this.quickAdapter.getData().indexOf(ReceiptDateOperate.this.item));
            }
        });
        this.rbDateFontSize2.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptDateOperate.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RadioButton radioButton4 = ReceiptDateOperate.this.rbDateFontSize1;
                int i11 = p113u.c.bg_f8f8f8_rad_6;
                radioButton4.setBackgroundResource(i11);
                ReceiptDateOperate.this.rbDateFontSize2.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
                ReceiptDateOperate.this.rbDateFontSize3.setBackgroundResource(i11);
                ReceiptDateOperate.this.receiptDateDataModel.setFontSize(50);
                ReceiptDateOperate receiptDateOperate = ReceiptDateOperate.this;
                receiptDateOperate.item.setData(c.e(receiptDateOperate.receiptDateDataModel));
                ReceiptDateOperate.this.quickAdapter.notifyItemChanged(ReceiptDateOperate.this.quickAdapter.getData().indexOf(ReceiptDateOperate.this.item));
            }
        });
        this.rbDateFontSize3.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptDateOperate.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RadioButton radioButton4 = ReceiptDateOperate.this.rbDateFontSize1;
                int i11 = p113u.c.bg_f8f8f8_rad_6;
                radioButton4.setBackgroundResource(i11);
                ReceiptDateOperate.this.rbDateFontSize2.setBackgroundResource(i11);
                ReceiptDateOperate.this.rbDateFontSize3.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
                ReceiptDateOperate.this.receiptDateDataModel.setFontSize(70);
                ReceiptDateOperate receiptDateOperate = ReceiptDateOperate.this;
                receiptDateOperate.item.setData(c.e(receiptDateOperate.receiptDateDataModel));
                ReceiptDateOperate.this.quickAdapter.notifyItemChanged(ReceiptDateOperate.this.quickAdapter.getData().indexOf(ReceiptDateOperate.this.item));
            }
        });
        this.ivDateStyleBold.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptDateOperate.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ReceiptDateOperate.this.receiptDateDataModel.setBold(!ReceiptDateOperate.this.receiptDateDataModel.isBold());
                if (ReceiptDateOperate.this.receiptDateDataModel.isBold()) {
                    ReceiptDateOperate.this.ivDateStyleBold.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
                } else {
                    ReceiptDateOperate.this.ivDateStyleBold.setBackgroundResource(p113u.c.bg_f8f8f8_rad_6);
                }
                ReceiptDateOperate receiptDateOperate = ReceiptDateOperate.this;
                receiptDateOperate.item.setData(c.e(receiptDateOperate.receiptDateDataModel));
                ReceiptDateOperate.this.quickAdapter.notifyItemChanged(ReceiptDateOperate.this.quickAdapter.getData().indexOf(ReceiptDateOperate.this.item));
            }
        });
        this.ivDateStyleItalic.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptDateOperate.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ReceiptDateOperate.this.receiptDateDataModel.setItalic(!ReceiptDateOperate.this.receiptDateDataModel.isItalic());
                if (ReceiptDateOperate.this.receiptDateDataModel.isItalic()) {
                    ReceiptDateOperate.this.ivDateStyleItalic.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
                } else {
                    ReceiptDateOperate.this.ivDateStyleItalic.setBackgroundResource(p113u.c.bg_f8f8f8_rad_6);
                }
                ReceiptDateOperate receiptDateOperate = ReceiptDateOperate.this;
                receiptDateOperate.item.setData(c.e(receiptDateOperate.receiptDateDataModel));
                ReceiptDateOperate.this.quickAdapter.notifyItemChanged(ReceiptDateOperate.this.quickAdapter.getData().indexOf(ReceiptDateOperate.this.item));
            }
        });
        this.ivDateStyleUnderline.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptDateOperate.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ReceiptDateOperate.this.receiptDateDataModel.setUnderLine(!ReceiptDateOperate.this.receiptDateDataModel.isUnderLine());
                if (ReceiptDateOperate.this.receiptDateDataModel.isUnderLine()) {
                    ReceiptDateOperate.this.ivDateStyleUnderline.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
                } else {
                    ReceiptDateOperate.this.ivDateStyleUnderline.setBackgroundResource(p113u.c.bg_f8f8f8_rad_6);
                }
                ReceiptDateOperate receiptDateOperate = ReceiptDateOperate.this;
                receiptDateOperate.item.setData(c.e(receiptDateOperate.receiptDateDataModel));
                ReceiptDateOperate.this.quickAdapter.notifyItemChanged(ReceiptDateOperate.this.quickAdapter.getData().indexOf(ReceiptDateOperate.this.item));
            }
        });
        this.ivDateStyleStrikethrough.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptDateOperate.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ReceiptDateOperate.this.receiptDateDataModel.setDeleteLine(!ReceiptDateOperate.this.receiptDateDataModel.isDeleteLine());
                if (ReceiptDateOperate.this.receiptDateDataModel.isDeleteLine()) {
                    ReceiptDateOperate.this.ivDateStyleStrikethrough.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
                } else {
                    ReceiptDateOperate.this.ivDateStyleStrikethrough.setBackgroundResource(p113u.c.bg_f8f8f8_rad_6);
                }
                ReceiptDateOperate receiptDateOperate = ReceiptDateOperate.this;
                receiptDateOperate.item.setData(c.e(receiptDateOperate.receiptDateDataModel));
                ReceiptDateOperate.this.quickAdapter.notifyItemChanged(ReceiptDateOperate.this.quickAdapter.getData().indexOf(ReceiptDateOperate.this.item));
            }
        });
        this.ivDateAligmentLeft.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptDateOperate.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ReceiptDateOperate.this.receiptDateDataModel.setAligment(0);
                int aligment2 = ReceiptDateOperate.this.receiptDateDataModel.getAligment();
                if (aligment2 == 0) {
                    ReceiptDateOperate.this.ivDateAligmentLeft.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
                    ImageView imageView4 = ReceiptDateOperate.this.ivDateAligmentCenter;
                    int i11 = p113u.c.bg_f8f8f8_rad_6;
                    imageView4.setBackgroundResource(i11);
                    ReceiptDateOperate.this.ivDateAligmentRight.setBackgroundResource(i11);
                } else if (aligment2 == 1) {
                    ImageView imageView5 = ReceiptDateOperate.this.ivDateAligmentLeft;
                    int i12 = p113u.c.bg_f8f8f8_rad_6;
                    imageView5.setBackgroundResource(i12);
                    ReceiptDateOperate.this.ivDateAligmentCenter.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
                    ReceiptDateOperate.this.ivDateAligmentRight.setBackgroundResource(i12);
                } else if (aligment2 == 2) {
                    ImageView imageView6 = ReceiptDateOperate.this.ivDateAligmentLeft;
                    int i13 = p113u.c.bg_f8f8f8_rad_6;
                    imageView6.setBackgroundResource(i13);
                    ReceiptDateOperate.this.ivDateAligmentCenter.setBackgroundResource(i13);
                    ReceiptDateOperate.this.ivDateAligmentRight.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
                }
                ReceiptDateOperate receiptDateOperate = ReceiptDateOperate.this;
                receiptDateOperate.item.setData(c.e(receiptDateOperate.receiptDateDataModel));
                ReceiptDateOperate.this.quickAdapter.notifyItemChanged(ReceiptDateOperate.this.quickAdapter.getData().indexOf(ReceiptDateOperate.this.item));
            }
        });
        this.ivDateAligmentCenter.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptDateOperate.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ReceiptDateOperate.this.receiptDateDataModel.setAligment(1);
                int aligment2 = ReceiptDateOperate.this.receiptDateDataModel.getAligment();
                if (aligment2 == 0) {
                    ReceiptDateOperate.this.ivDateAligmentLeft.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
                    ImageView imageView4 = ReceiptDateOperate.this.ivDateAligmentCenter;
                    int i11 = p113u.c.bg_f8f8f8_rad_6;
                    imageView4.setBackgroundResource(i11);
                    ReceiptDateOperate.this.ivDateAligmentRight.setBackgroundResource(i11);
                } else if (aligment2 == 1) {
                    ImageView imageView5 = ReceiptDateOperate.this.ivDateAligmentLeft;
                    int i12 = p113u.c.bg_f8f8f8_rad_6;
                    imageView5.setBackgroundResource(i12);
                    ReceiptDateOperate.this.ivDateAligmentCenter.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
                    ReceiptDateOperate.this.ivDateAligmentRight.setBackgroundResource(i12);
                } else if (aligment2 == 2) {
                    ImageView imageView6 = ReceiptDateOperate.this.ivDateAligmentLeft;
                    int i13 = p113u.c.bg_f8f8f8_rad_6;
                    imageView6.setBackgroundResource(i13);
                    ReceiptDateOperate.this.ivDateAligmentCenter.setBackgroundResource(i13);
                    ReceiptDateOperate.this.ivDateAligmentRight.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
                }
                ReceiptDateOperate receiptDateOperate = ReceiptDateOperate.this;
                receiptDateOperate.item.setData(c.e(receiptDateOperate.receiptDateDataModel));
                ReceiptDateOperate.this.quickAdapter.notifyItemChanged(ReceiptDateOperate.this.quickAdapter.getData().indexOf(ReceiptDateOperate.this.item));
            }
        });
        this.ivDateAligmentRight.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptDateOperate.17
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ReceiptDateOperate.this.receiptDateDataModel.setAligment(2);
                int aligment2 = ReceiptDateOperate.this.receiptDateDataModel.getAligment();
                if (aligment2 == 0) {
                    ReceiptDateOperate.this.ivDateAligmentLeft.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
                    ImageView imageView4 = ReceiptDateOperate.this.ivDateAligmentCenter;
                    int i11 = p113u.c.bg_f8f8f8_rad_6;
                    imageView4.setBackgroundResource(i11);
                    ReceiptDateOperate.this.ivDateAligmentRight.setBackgroundResource(i11);
                } else if (aligment2 == 1) {
                    ImageView imageView5 = ReceiptDateOperate.this.ivDateAligmentLeft;
                    int i12 = p113u.c.bg_f8f8f8_rad_6;
                    imageView5.setBackgroundResource(i12);
                    ReceiptDateOperate.this.ivDateAligmentCenter.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
                    ReceiptDateOperate.this.ivDateAligmentRight.setBackgroundResource(i12);
                } else if (aligment2 == 2) {
                    ImageView imageView6 = ReceiptDateOperate.this.ivDateAligmentLeft;
                    int i13 = p113u.c.bg_f8f8f8_rad_6;
                    imageView6.setBackgroundResource(i13);
                    ReceiptDateOperate.this.ivDateAligmentCenter.setBackgroundResource(i13);
                    ReceiptDateOperate.this.ivDateAligmentRight.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
                }
                ReceiptDateOperate receiptDateOperate = ReceiptDateOperate.this;
                receiptDateOperate.item.setData(c.e(receiptDateOperate.receiptDateDataModel));
                ReceiptDateOperate.this.quickAdapter.notifyItemChanged(ReceiptDateOperate.this.quickAdapter.getData().indexOf(ReceiptDateOperate.this.item));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectType(int i5) {
        TextView textView = this.tvDateTitleContent;
        Resources resources = this.context.getResources();
        int i6 = p113u.a.color_333333;
        textView.setTextColor(resources.getColor(i6));
        this.tvDateTitleStyle.setTextColor(this.context.getResources().getColor(i6));
        this.llDateData.setVisibility(8);
        this.llDateStyle.setVisibility(8);
        if (i5 == d.tv_pop_receipt_edit_date_title_1) {
            this.tvDateTitleContent.setTextColor(this.context.getResources().getColor(p113u.a.color_FFAE00));
            this.llDateData.setVisibility(0);
        } else if (i5 == d.tv_pop_receipt_edit_date_title_2) {
            this.tvDateTitleStyle.setTextColor(this.context.getResources().getColor(p113u.a.color_FFAE00));
            this.llDateStyle.setVisibility(0);
        } else {
            this.tvDateTitleContent.setTextColor(this.context.getResources().getColor(p113u.a.color_FFAE00));
            this.llDateData.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTimeType(int i5) {
        if (i5 == 1) {
            this.tvDateDynamicTime.setBackgroundResource(p113u.c.bg_ffae00_rad_15);
            this.tvDateFixedTime.setBackground(null);
            this.tvDateSettingTimeOffset.setVisibility(0);
        } else {
            this.tvDateDynamicTime.setBackground(null);
            this.tvDateFixedTime.setBackgroundResource(p113u.c.bg_ffae00_rad_15);
            this.tvDateSettingTimeOffset.setVisibility(8);
        }
        this.receiptDateDataModel.setTimeType(i5);
        this.item.setData(c.e(this.receiptDateDataModel));
        this.quickAdapter.notifyItemChanged(this.quickAdapter.getData().indexOf(this.item));
    }

    @Override // com.appdev.standard.page.receipt.operate.ReceiptBaseOperate
    public int getLayoutId() {
        return e.pop_receipt_edit_date;
    }

    @Override // com.appdev.standard.page.receipt.operate.ReceiptBaseOperate
    public void initContent(ReceiptElementModel receiptElementModel) {
        this.receiptDateDataModel = (ReceiptDateDataModel) c.d(receiptElementModel.getData(), ReceiptDateDataModel.class);
        initTextTitle1();
        initTextTitle2();
        initTextTitle();
        selectType(d.tv_pop_receipt_edit_text_title_1);
    }
}
