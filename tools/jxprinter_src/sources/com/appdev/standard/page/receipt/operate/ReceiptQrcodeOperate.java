package com.appdev.standard.page.receipt.operate;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.appdev.standard.dialog.C0451d;
import com.appdev.standard.dialog.ContentEditDialog;
import com.appdev.standard.dialog.InterfaceC0453f;
import com.appdev.standard.model.ReceiptElementModel;
import com.appdev.standard.model.ReceiptQrCodeDataModel;
import com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget;
import com.library.base.util.recyclerview.f;
import p113u.c;
import p113u.d;
import p113u.e;
import p113u.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ReceiptQrcodeOperate extends ReceiptBaseOperate {
    private ImageView ivMore;
    private LinearLayout llQrCodeData;
    private LinearLayout llQrCodeStyle;
    private LinearLayout llQrCodeTitleIncrementalContent;
    private QuantitySelectorWidget qswInterval;
    private RadioButton rbQrCodeSize1;
    private RadioButton rbQrCodeSize2;
    private RadioButton rbQrCodeSize3;
    private ReceiptQrCodeDataModel receiptQrCodeDataModel;
    private TextView tvIncrementalContent;
    private TextView tvPrefix;
    private TextView tvQrCodeContent;
    private TextView tvQrCodeEncodeRef;
    private TextView tvQrCodeTitleContent;
    private TextView tvQrCodeTitleData;
    private TextView tvQrCodeTitleIncrementalContent;
    private TextView tvQrCodeTitleStyle;
    private TextView tvSuffix;
    private View vLine;

    public ReceiptQrcodeOperate(Context context, f fVar) {
        super(context, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getSizeMultiplier(int i5) {
        if (i5 != 2) {
            return i5 != 3 ? 1.0f : 2.0f;
        }
        return 1.5f;
    }

    private void initTextTitle() {
        this.vLine = this.contentView.findViewById(d.v_line);
        this.tvQrCodeTitleContent = (TextView) this.contentView.findViewById(d.tv_pop_receipt_edit_qrcode_title_1);
        this.tvQrCodeTitleStyle = (TextView) this.contentView.findViewById(d.tv_pop_receipt_edi_qrcode_title_2);
        this.tvQrCodeTitleData = (TextView) this.contentView.findViewById(d.tv_pop_receipt_edi_qrcode_title_3);
        this.tvQrCodeTitleIncrementalContent = (TextView) this.contentView.findViewById(d.tv_pop_receipt_edi_qrcode_title_4);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptQrcodeOperate.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ReceiptQrcodeOperate.this.selectType(view.getId());
            }
        };
        this.tvQrCodeTitleContent.setOnClickListener(onClickListener);
        this.tvQrCodeTitleStyle.setOnClickListener(onClickListener);
        this.tvQrCodeTitleData.setOnClickListener(onClickListener);
        this.tvQrCodeTitleIncrementalContent.setOnClickListener(onClickListener);
    }

    private void initTextTitle1() {
        TextView textView = (TextView) this.contentView.findViewById(d.tv_pop_receipt_edi_qrcode_title_content);
        this.tvQrCodeContent = textView;
        textView.setText(this.receiptQrCodeDataModel.getContent());
        this.tvQrCodeContent.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptQrcodeOperate.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ReceiptQrcodeOperate.this.showEditContent();
            }
        });
    }

    private void initTextTitle2() {
        this.llQrCodeStyle = (LinearLayout) this.contentView.findViewById(d.ll_pop_receipt_edi_qrcode_style);
        this.rbQrCodeSize1 = (RadioButton) this.contentView.findViewById(d.rb_pop_receipt_edit_qrcode_size_1);
        this.rbQrCodeSize2 = (RadioButton) this.contentView.findViewById(d.rb_pop_receipt_edit_qrcode_size_2);
        this.rbQrCodeSize3 = (RadioButton) this.contentView.findViewById(d.rb_pop_receipt_edit_qrcode_size_3);
        RadioButton radioButton = this.rbQrCodeSize1;
        int i5 = c.bg_f8f8f8_rad_6;
        radioButton.setBackgroundResource(i5);
        this.rbQrCodeSize2.setBackgroundResource(i5);
        this.rbQrCodeSize3.setBackgroundResource(i5);
        int size = this.receiptQrCodeDataModel.getSize();
        if (size == 1) {
            this.rbQrCodeSize1.setBackgroundResource(c.bg_fff3da_rad_6_stroke_ffae00);
        } else if (size == 2) {
            this.rbQrCodeSize2.setBackgroundResource(c.bg_fff3da_rad_6_stroke_ffae00);
        } else if (size != 3) {
            this.rbQrCodeSize1.setBackgroundResource(c.bg_fff3da_rad_6_stroke_ffae00);
        } else {
            this.rbQrCodeSize3.setBackgroundResource(c.bg_fff3da_rad_6_stroke_ffae00);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptQrcodeOperate.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RadioButton radioButton2 = ReceiptQrcodeOperate.this.rbQrCodeSize1;
                int i6 = c.bg_f8f8f8_rad_6;
                radioButton2.setBackgroundResource(i6);
                ReceiptQrcodeOperate.this.rbQrCodeSize2.setBackgroundResource(i6);
                ReceiptQrcodeOperate.this.rbQrCodeSize3.setBackgroundResource(i6);
                float sizeMultiplier = ReceiptQrcodeOperate.this.getSizeMultiplier(ReceiptQrcodeOperate.this.receiptQrCodeDataModel.getSize());
                float f6 = 1.0f;
                int i7 = 1;
                if (view.getId() == d.rb_pop_receipt_edit_qrcode_size_1) {
                    ReceiptQrcodeOperate.this.rbQrCodeSize1.setBackgroundResource(c.bg_fff3da_rad_6_stroke_ffae00);
                } else if (view.getId() == d.rb_pop_receipt_edit_qrcode_size_2) {
                    ReceiptQrcodeOperate.this.rbQrCodeSize2.setBackgroundResource(c.bg_fff3da_rad_6_stroke_ffae00);
                    i7 = 2;
                    f6 = 1.5f;
                } else if (view.getId() == d.rb_pop_receipt_edit_qrcode_size_3) {
                    ReceiptQrcodeOperate.this.rbQrCodeSize3.setBackgroundResource(c.bg_fff3da_rad_6_stroke_ffae00);
                    i7 = 3;
                    f6 = 2.0f;
                } else {
                    ReceiptQrcodeOperate.this.rbQrCodeSize1.setBackgroundResource(c.bg_fff3da_rad_6_stroke_ffae00);
                }
                float w6 = ReceiptQrcodeOperate.this.receiptQrCodeDataModel.getW() / sizeMultiplier;
                float h6 = ReceiptQrcodeOperate.this.receiptQrCodeDataModel.getH() / sizeMultiplier;
                ReceiptQrcodeOperate.this.receiptQrCodeDataModel.setW(w6 * f6);
                ReceiptQrcodeOperate.this.receiptQrCodeDataModel.setH(h6 * f6);
                ReceiptQrcodeOperate.this.receiptQrCodeDataModel.setSize(i7);
                ReceiptQrcodeOperate receiptQrcodeOperate = ReceiptQrcodeOperate.this;
                receiptQrcodeOperate.item.setData(p052j2.c.e(receiptQrcodeOperate.receiptQrCodeDataModel));
                ReceiptQrcodeOperate.this.quickAdapter.notifyItemChanged(ReceiptQrcodeOperate.this.quickAdapter.getData().indexOf(ReceiptQrcodeOperate.this.item));
            }
        };
        this.rbQrCodeSize1.setOnClickListener(onClickListener);
        this.rbQrCodeSize2.setOnClickListener(onClickListener);
        this.rbQrCodeSize3.setOnClickListener(onClickListener);
    }

    private void initTextTitle3() {
        this.llQrCodeData = (LinearLayout) this.contentView.findViewById(d.ll_pop_receipt_edi_qrcode_data);
        TextView textView = (TextView) this.contentView.findViewById(d.tv_pop_receipt_edit_qrcode_encodeRef);
        this.tvQrCodeEncodeRef = textView;
        textView.setText(this.receiptQrCodeDataModel.getEncodeRef());
        this.tvQrCodeEncodeRef.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptQrcodeOperate.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                p097r0.a aVar = new p097r0.a(ReceiptQrcodeOperate.this.context, new p109t0.a() { // from class: com.appdev.standard.page.receipt.operate.ReceiptQrcodeOperate.3.1
                    @Override // p109t0.a
                    public void onOptionsSelect(int i5, int i6, int i7, View view2) {
                        ReceiptQrcodeOperate.this.tvQrCodeEncodeRef.setText((CharSequence) p051j0.a.i().get(i5));
                        ReceiptQrcodeOperate.this.receiptQrCodeDataModel.setEncodeRef((String) p051j0.a.i().get(i5));
                        ReceiptQrcodeOperate receiptQrcodeOperate = ReceiptQrcodeOperate.this;
                        receiptQrcodeOperate.item.setData(p052j2.c.e(receiptQrcodeOperate.receiptQrCodeDataModel));
                        ReceiptQrcodeOperate.this.quickAdapter.notifyItemChanged(ReceiptQrcodeOperate.this.quickAdapter.getData().indexOf(ReceiptQrcodeOperate.this.item));
                    }
                });
                aVar.f7931a.f8190k = ReceiptQrcodeOperate.this.context.getString(g.text_285);
                aVar.f7931a.f8188i = ReceiptQrcodeOperate.this.getResources().getString(g.confirm);
                String string = ReceiptQrcodeOperate.this.getResources().getString(g.cancel);
                p103s0.a aVar2 = aVar.f7931a;
                aVar2.f8189j = string;
                aVar2.f8192m = 14;
                aVar2.f8191l = 14;
                p114u0.d dVarA = aVar.a();
                dVarA.f(p051j0.a.i());
                dVarA.g(0);
                C0451d c0451d = ReceiptQrcodeOperate.this.customPopWindow;
                if (c0451d != null) {
                    c0451d.a();
                }
                dVarA.h();
            }
        });
        ImageView imageView = (ImageView) this.contentView.findViewById(d.tv_pop_receipt_edit_qrcode_more);
        this.ivMore = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptQrcodeOperate.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                p097r0.a aVar = new p097r0.a(ReceiptQrcodeOperate.this.context, new p109t0.a() { // from class: com.appdev.standard.page.receipt.operate.ReceiptQrcodeOperate.4.1
                    @Override // p109t0.a
                    public void onOptionsSelect(int i5, int i6, int i7, View view2) {
                        ReceiptQrcodeOperate.this.tvQrCodeEncodeRef.setText((CharSequence) p051j0.a.i().get(i5));
                        ReceiptQrcodeOperate.this.receiptQrCodeDataModel.setEncodeRef((String) p051j0.a.i().get(i5));
                        ReceiptQrcodeOperate receiptQrcodeOperate = ReceiptQrcodeOperate.this;
                        receiptQrcodeOperate.item.setData(p052j2.c.e(receiptQrcodeOperate.receiptQrCodeDataModel));
                        ReceiptQrcodeOperate.this.quickAdapter.notifyItemChanged(ReceiptQrcodeOperate.this.quickAdapter.getData().indexOf(ReceiptQrcodeOperate.this.item));
                    }
                });
                aVar.f7931a.f8190k = ReceiptQrcodeOperate.this.context.getString(g.text_285);
                aVar.f7931a.f8188i = ReceiptQrcodeOperate.this.getResources().getString(g.confirm);
                String string = ReceiptQrcodeOperate.this.getResources().getString(g.cancel);
                p103s0.a aVar2 = aVar.f7931a;
                aVar2.f8189j = string;
                aVar2.f8192m = 14;
                aVar2.f8191l = 14;
                p114u0.d dVarA = aVar.a();
                dVarA.f(p051j0.a.i());
                dVarA.g(0);
                C0451d c0451d = ReceiptQrcodeOperate.this.customPopWindow;
                if (c0451d != null) {
                    c0451d.a();
                }
                dVarA.h();
            }
        });
    }

    private void initTextTitle4() {
        this.llQrCodeTitleIncrementalContent = (LinearLayout) this.contentView.findViewById(d.ll_pop_receipt_edi_qrcode_incremental_content);
        this.tvIncrementalContent = (TextView) this.contentView.findViewById(d.tv_attribute_qrcode_incremental_content);
        this.tvPrefix = (TextView) this.contentView.findViewById(d.tv_attribute_qrcode_prefix);
        this.tvSuffix = (TextView) this.contentView.findViewById(d.tv_attribute_qrcode_suffix);
        this.qswInterval = (QuantitySelectorWidget) this.contentView.findViewById(d.qsw_attribute_qrcode_interval);
        this.tvIncrementalContent.setText(this.receiptQrCodeDataModel.getContent());
        this.tvPrefix.setText(this.receiptQrCodeDataModel.getPrefix());
        this.tvSuffix.setText(this.receiptQrCodeDataModel.getSuffix());
        this.qswInterval.setOffsetValue(this.receiptQrCodeDataModel.getInterval());
        this.tvIncrementalContent.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptQrcodeOperate.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ReceiptQrcodeOperate.this.showEditContent();
            }
        });
        this.tvPrefix.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptQrcodeOperate.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ContentEditDialog contentEditDialog = new ContentEditDialog(ReceiptQrcodeOperate.this.context);
                contentEditDialog.a(ReceiptQrcodeOperate.this.receiptQrCodeDataModel.getPrefix());
                contentEditDialog.show();
                contentEditDialog.b = new InterfaceC0453f() { // from class: com.appdev.standard.page.receipt.operate.ReceiptQrcodeOperate.6.1
                    @Override // com.appdev.standard.dialog.InterfaceC0453f
                    public void setNewContent(String str) {
                        ReceiptQrcodeOperate.this.receiptQrCodeDataModel.setPrefix(str);
                        ReceiptQrcodeOperate.this.tvPrefix.setText(str);
                        ReceiptQrcodeOperate receiptQrcodeOperate = ReceiptQrcodeOperate.this;
                        receiptQrcodeOperate.item.setData(p052j2.c.e(receiptQrcodeOperate.receiptQrCodeDataModel));
                        ReceiptQrcodeOperate.this.quickAdapter.notifyItemChanged(ReceiptQrcodeOperate.this.quickAdapter.getData().indexOf(ReceiptQrcodeOperate.this.item));
                    }
                };
            }
        });
        this.tvSuffix.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptQrcodeOperate.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ContentEditDialog contentEditDialog = new ContentEditDialog(ReceiptQrcodeOperate.this.context);
                contentEditDialog.a(ReceiptQrcodeOperate.this.receiptQrCodeDataModel.getSuffix());
                contentEditDialog.show();
                contentEditDialog.b = new InterfaceC0453f() { // from class: com.appdev.standard.page.receipt.operate.ReceiptQrcodeOperate.7.1
                    @Override // com.appdev.standard.dialog.InterfaceC0453f
                    public void setNewContent(String str) {
                        ReceiptQrcodeOperate.this.receiptQrCodeDataModel.setSuffix(str);
                        ReceiptQrcodeOperate.this.tvSuffix.setText(str);
                        ReceiptQrcodeOperate receiptQrcodeOperate = ReceiptQrcodeOperate.this;
                        receiptQrcodeOperate.item.setData(p052j2.c.e(receiptQrcodeOperate.receiptQrCodeDataModel));
                        ReceiptQrcodeOperate.this.quickAdapter.notifyItemChanged(ReceiptQrcodeOperate.this.quickAdapter.getData().indexOf(ReceiptQrcodeOperate.this.item));
                    }
                };
            }
        });
        this.qswInterval.setOnValueChangeListener(new QuantitySelectorWidget.OnValueChangeListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptQrcodeOperate.8
            @Override // com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget.OnValueChangeListener
            public void onValue(int i5) {
                ReceiptQrcodeOperate.this.receiptQrCodeDataModel.setInterval(i5);
                ReceiptQrcodeOperate receiptQrcodeOperate = ReceiptQrcodeOperate.this;
                receiptQrcodeOperate.item.setData(p052j2.c.e(receiptQrcodeOperate.receiptQrCodeDataModel));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectType(int i5) {
        TextView textView = this.tvQrCodeTitleContent;
        Resources resources = getResources();
        int i6 = p113u.a.color_333333;
        textView.setTextColor(resources.getColor(i6));
        this.tvQrCodeTitleStyle.setTextColor(getResources().getColor(i6));
        this.tvQrCodeTitleData.setTextColor(getResources().getColor(i6));
        this.tvQrCodeTitleIncrementalContent.setTextColor(getResources().getColor(i6));
        this.vLine.setVisibility(0);
        this.tvQrCodeContent.setVisibility(8);
        this.llQrCodeStyle.setVisibility(8);
        this.llQrCodeData.setVisibility(8);
        this.llQrCodeTitleIncrementalContent.setVisibility(8);
        if (i5 == d.tv_pop_receipt_edit_qrcode_title_1) {
            this.tvQrCodeTitleContent.setTextColor(getResources().getColor(p113u.a.color_FFAE00));
            this.tvQrCodeContent.setVisibility(0);
            this.vLine.setVisibility(8);
            this.receiptQrCodeDataModel.setInputDataType(0);
            this.item.setData(p052j2.c.e(this.receiptQrCodeDataModel));
            this.quickAdapter.notifyItemChanged(this.quickAdapter.getData().indexOf(this.item));
            return;
        }
        if (i5 == d.tv_pop_receipt_edi_qrcode_title_2) {
            this.tvQrCodeTitleStyle.setTextColor(getResources().getColor(p113u.a.color_FFAE00));
            this.llQrCodeStyle.setVisibility(0);
            return;
        }
        if (i5 == d.tv_pop_receipt_edi_qrcode_title_3) {
            this.tvQrCodeTitleData.setTextColor(getResources().getColor(p113u.a.color_FFAE00));
            this.llQrCodeData.setVisibility(0);
            return;
        }
        if (i5 != d.tv_pop_receipt_edi_qrcode_title_4) {
            this.tvQrCodeTitleContent.setTextColor(getResources().getColor(p113u.a.color_FFAE00));
            this.tvQrCodeContent.setVisibility(0);
            this.vLine.setVisibility(8);
        } else {
            this.tvQrCodeTitleIncrementalContent.setTextColor(getResources().getColor(p113u.a.color_FFAE00));
            this.llQrCodeTitleIncrementalContent.setVisibility(0);
            this.receiptQrCodeDataModel.setInputDataType(1);
            this.item.setData(p052j2.c.e(this.receiptQrCodeDataModel));
            this.quickAdapter.notifyItemChanged(this.quickAdapter.getData().indexOf(this.item));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showEditContent() {
        ContentEditDialog contentEditDialog = new ContentEditDialog(this.context);
        contentEditDialog.a(this.receiptQrCodeDataModel.getContent());
        contentEditDialog.show();
        contentEditDialog.b = new InterfaceC0453f() { // from class: com.appdev.standard.page.receipt.operate.ReceiptQrcodeOperate.9
            @Override // com.appdev.standard.dialog.InterfaceC0453f
            public void setNewContent(String str) {
                ReceiptQrcodeOperate.this.receiptQrCodeDataModel.setContent(str);
                ReceiptQrcodeOperate.this.tvQrCodeContent.setText(str);
                ReceiptQrcodeOperate.this.tvIncrementalContent.setText(str);
                ReceiptQrcodeOperate receiptQrcodeOperate = ReceiptQrcodeOperate.this;
                receiptQrcodeOperate.item.setData(p052j2.c.e(receiptQrcodeOperate.receiptQrCodeDataModel));
                ReceiptQrcodeOperate.this.quickAdapter.notifyItemChanged(ReceiptQrcodeOperate.this.quickAdapter.getData().indexOf(ReceiptQrcodeOperate.this.item));
            }
        };
    }

    @Override // com.appdev.standard.page.receipt.operate.ReceiptBaseOperate
    public int getLayoutId() {
        return e.pop_receipt_edit_qrcode;
    }

    @Override // com.appdev.standard.page.receipt.operate.ReceiptBaseOperate
    public void initContent(ReceiptElementModel receiptElementModel) {
        this.receiptQrCodeDataModel = (ReceiptQrCodeDataModel) p052j2.c.d(receiptElementModel.getData(), ReceiptQrCodeDataModel.class);
        initTextTitle1();
        initTextTitle2();
        initTextTitle3();
        initTextTitle4();
        initTextTitle();
        if (this.receiptQrCodeDataModel.getInputDataType() == 1) {
            selectType(d.tv_pop_receipt_edi_qrcode_title_4);
        } else {
            selectType(d.tv_pop_receipt_edit_qrcode_title_1);
        }
    }
}
