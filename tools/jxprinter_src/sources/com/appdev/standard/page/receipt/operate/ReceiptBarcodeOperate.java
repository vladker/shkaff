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
import com.appdev.standard.model.ReceiptBarcodeDataModel;
import com.appdev.standard.model.ReceiptElementModel;
import com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget;
import com.library.base.util.recyclerview.f;
import p113u.c;
import p113u.d;
import p113u.e;
import p113u.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ReceiptBarcodeOperate extends ReceiptBaseOperate {
    private ImageView ivmore;
    private LinearLayout llBarcodeData;
    private LinearLayout llBarcodeStyle;
    private LinearLayout llBarcodeTitleIncrementalContent;
    private QuantitySelectorWidget qswInterval;
    private RadioButton rbBarcodeSize1;
    private RadioButton rbBarcodeSize2;
    private RadioButton rbBarcodeSize3;
    private ReceiptBarcodeDataModel receiptBarcodeDataModel;
    private TextView tvBarcodeContent;
    private TextView tvBarcodeEncodeRef;
    private TextView tvBarcodeTitleContent;
    private TextView tvBarcodeTitleData;
    private TextView tvBarcodeTitleIncrementalContent;
    private TextView tvBarcodeTitleStyle;
    private TextView tvIncrementalContent;
    private TextView tvPrefix;
    private TextView tvSuffix;
    private View vLine;

    public ReceiptBarcodeOperate(Context context, f fVar) {
        super(context, fVar);
        this.receiptBarcodeDataModel = null;
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
        this.tvBarcodeTitleContent = (TextView) this.contentView.findViewById(d.tv_pop_receipt_edit_barcode_title_1);
        this.tvBarcodeTitleStyle = (TextView) this.contentView.findViewById(d.tv_pop_receipt_edi_barcode_title_2);
        this.tvBarcodeTitleData = (TextView) this.contentView.findViewById(d.tv_pop_receipt_edi_barcode_title_3);
        this.tvBarcodeTitleIncrementalContent = (TextView) this.contentView.findViewById(d.tv_pop_receipt_edi_barcode_title_4);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptBarcodeOperate.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ReceiptBarcodeOperate.this.selectType(view.getId());
            }
        };
        this.tvBarcodeTitleContent.setOnClickListener(onClickListener);
        this.tvBarcodeTitleStyle.setOnClickListener(onClickListener);
        this.tvBarcodeTitleData.setOnClickListener(onClickListener);
        this.tvBarcodeTitleIncrementalContent.setOnClickListener(onClickListener);
    }

    private void initTextTitle1() {
        TextView textView = (TextView) this.contentView.findViewById(d.tv_pop_receipt_edi_barcode_title_content);
        this.tvBarcodeContent = textView;
        textView.setText(this.receiptBarcodeDataModel.getContent());
        this.tvBarcodeContent.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptBarcodeOperate.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ReceiptBarcodeOperate.this.showEditContent();
            }
        });
    }

    private void initTextTitle2() {
        this.llBarcodeStyle = (LinearLayout) this.contentView.findViewById(d.ll_pop_receipt_edi_barcode_style);
        this.rbBarcodeSize1 = (RadioButton) this.contentView.findViewById(d.rb_pop_receipt_edit_barcode_size_1);
        this.rbBarcodeSize2 = (RadioButton) this.contentView.findViewById(d.rb_pop_receipt_edit_barcode_size_2);
        this.rbBarcodeSize3 = (RadioButton) this.contentView.findViewById(d.rb_pop_receipt_edit_barcode_size_3);
        RadioButton radioButton = this.rbBarcodeSize1;
        int i5 = c.bg_f8f8f8_rad_6;
        radioButton.setBackgroundResource(i5);
        this.rbBarcodeSize2.setBackgroundResource(i5);
        this.rbBarcodeSize3.setBackgroundResource(i5);
        int size = this.receiptBarcodeDataModel.getSize();
        if (size == 1) {
            this.rbBarcodeSize1.setBackgroundResource(c.bg_fff3da_rad_6_stroke_ffae00);
        } else if (size == 2) {
            this.rbBarcodeSize2.setBackgroundResource(c.bg_fff3da_rad_6_stroke_ffae00);
        } else if (size != 3) {
            this.rbBarcodeSize1.setBackgroundResource(c.bg_fff3da_rad_6_stroke_ffae00);
        } else {
            this.rbBarcodeSize3.setBackgroundResource(c.bg_fff3da_rad_6_stroke_ffae00);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptBarcodeOperate.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RadioButton radioButton2 = ReceiptBarcodeOperate.this.rbBarcodeSize1;
                int i6 = c.bg_f8f8f8_rad_6;
                radioButton2.setBackgroundResource(i6);
                ReceiptBarcodeOperate.this.rbBarcodeSize2.setBackgroundResource(i6);
                ReceiptBarcodeOperate.this.rbBarcodeSize3.setBackgroundResource(i6);
                float sizeMultiplier = ReceiptBarcodeOperate.this.getSizeMultiplier(ReceiptBarcodeOperate.this.receiptBarcodeDataModel.getSize());
                float f6 = 1.0f;
                int i7 = 1;
                if (view.getId() == d.rb_pop_receipt_edit_barcode_size_1) {
                    ReceiptBarcodeOperate.this.rbBarcodeSize1.setBackgroundResource(c.bg_fff3da_rad_6_stroke_ffae00);
                } else if (view.getId() == d.rb_pop_receipt_edit_barcode_size_2) {
                    ReceiptBarcodeOperate.this.rbBarcodeSize2.setBackgroundResource(c.bg_fff3da_rad_6_stroke_ffae00);
                    i7 = 2;
                    f6 = 1.5f;
                } else if (view.getId() == d.rb_pop_receipt_edit_barcode_size_3) {
                    ReceiptBarcodeOperate.this.rbBarcodeSize3.setBackgroundResource(c.bg_fff3da_rad_6_stroke_ffae00);
                    i7 = 3;
                    f6 = 2.0f;
                } else {
                    ReceiptBarcodeOperate.this.rbBarcodeSize1.setBackgroundResource(c.bg_fff3da_rad_6_stroke_ffae00);
                }
                float w6 = ReceiptBarcodeOperate.this.receiptBarcodeDataModel.getW() / sizeMultiplier;
                float h6 = ReceiptBarcodeOperate.this.receiptBarcodeDataModel.getH() / sizeMultiplier;
                ReceiptBarcodeOperate.this.receiptBarcodeDataModel.setW(w6 * f6);
                ReceiptBarcodeOperate.this.receiptBarcodeDataModel.setH(h6 * f6);
                ReceiptBarcodeOperate.this.receiptBarcodeDataModel.setSize(i7);
                ReceiptBarcodeOperate receiptBarcodeOperate = ReceiptBarcodeOperate.this;
                receiptBarcodeOperate.item.setData(p052j2.c.e(receiptBarcodeOperate.receiptBarcodeDataModel));
                ReceiptBarcodeOperate.this.quickAdapter.notifyItemChanged(ReceiptBarcodeOperate.this.quickAdapter.getData().indexOf(ReceiptBarcodeOperate.this.item));
            }
        };
        this.rbBarcodeSize1.setOnClickListener(onClickListener);
        this.rbBarcodeSize2.setOnClickListener(onClickListener);
        this.rbBarcodeSize3.setOnClickListener(onClickListener);
    }

    private void initTextTitle3() {
        this.llBarcodeData = (LinearLayout) this.contentView.findViewById(d.ll_pop_receipt_edi_barcode_data);
        TextView textView = (TextView) this.contentView.findViewById(d.tv_pop_receipt_edit_barcode_encodeRef);
        this.tvBarcodeEncodeRef = textView;
        textView.setText(this.receiptBarcodeDataModel.getEncodeRef());
        this.tvBarcodeEncodeRef.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptBarcodeOperate.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                p097r0.a aVar = new p097r0.a(ReceiptBarcodeOperate.this.context, new p109t0.a() { // from class: com.appdev.standard.page.receipt.operate.ReceiptBarcodeOperate.3.1
                    @Override // p109t0.a
                    public void onOptionsSelect(int i5, int i6, int i7, View view2) {
                        ReceiptBarcodeOperate.this.tvBarcodeEncodeRef.setText((CharSequence) p051j0.a.j().get(i5));
                        ReceiptBarcodeOperate.this.receiptBarcodeDataModel.setEncodeRef((String) p051j0.a.j().get(i5));
                        ReceiptBarcodeOperate receiptBarcodeOperate = ReceiptBarcodeOperate.this;
                        receiptBarcodeOperate.item.setData(p052j2.c.e(receiptBarcodeOperate.receiptBarcodeDataModel));
                        ReceiptBarcodeOperate.this.quickAdapter.notifyItemChanged(ReceiptBarcodeOperate.this.quickAdapter.getData().indexOf(ReceiptBarcodeOperate.this.item));
                    }
                });
                String string = ReceiptBarcodeOperate.this.context.getString(g.text_285);
                p103s0.a aVar2 = aVar.f7931a;
                aVar2.f8190k = string;
                aVar2.f8192m = 14;
                aVar2.f8191l = 14;
                aVar.f7931a.f8188i = ReceiptBarcodeOperate.this.getResources().getString(g.confirm);
                aVar.f7931a.f8189j = ReceiptBarcodeOperate.this.getResources().getString(g.cancel);
                p114u0.d dVarA = aVar.a();
                dVarA.f(p051j0.a.j());
                dVarA.g(0);
                C0451d c0451d = ReceiptBarcodeOperate.this.customPopWindow;
                if (c0451d != null) {
                    c0451d.a();
                }
                dVarA.h();
            }
        });
        ImageView imageView = (ImageView) this.contentView.findViewById(d.tv_tv_pop_receipt_edit_barcode_more);
        this.ivmore = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptBarcodeOperate.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                p097r0.a aVar = new p097r0.a(ReceiptBarcodeOperate.this.context, new p109t0.a() { // from class: com.appdev.standard.page.receipt.operate.ReceiptBarcodeOperate.4.1
                    @Override // p109t0.a
                    public void onOptionsSelect(int i5, int i6, int i7, View view2) {
                        ReceiptBarcodeOperate.this.tvBarcodeEncodeRef.setText((CharSequence) p051j0.a.j().get(i5));
                        ReceiptBarcodeOperate.this.receiptBarcodeDataModel.setEncodeRef((String) p051j0.a.j().get(i5));
                        ReceiptBarcodeOperate receiptBarcodeOperate = ReceiptBarcodeOperate.this;
                        receiptBarcodeOperate.item.setData(p052j2.c.e(receiptBarcodeOperate.receiptBarcodeDataModel));
                        ReceiptBarcodeOperate.this.quickAdapter.notifyItemChanged(ReceiptBarcodeOperate.this.quickAdapter.getData().indexOf(ReceiptBarcodeOperate.this.item));
                    }
                });
                String string = ReceiptBarcodeOperate.this.context.getString(g.text_285);
                p103s0.a aVar2 = aVar.f7931a;
                aVar2.f8190k = string;
                aVar2.f8192m = 14;
                aVar2.f8191l = 14;
                aVar.f7931a.f8188i = ReceiptBarcodeOperate.this.getResources().getString(g.confirm);
                aVar.f7931a.f8189j = ReceiptBarcodeOperate.this.getResources().getString(g.cancel);
                p114u0.d dVarA = aVar.a();
                dVarA.f(p051j0.a.j());
                dVarA.g(0);
                C0451d c0451d = ReceiptBarcodeOperate.this.customPopWindow;
                if (c0451d != null) {
                    c0451d.a();
                }
                dVarA.h();
            }
        });
    }

    private void initTextTitle4() {
        this.llBarcodeTitleIncrementalContent = (LinearLayout) this.contentView.findViewById(d.ll_pop_receipt_edi_barcode_incremental_content);
        this.tvIncrementalContent = (TextView) this.contentView.findViewById(d.tv_attribute_barcode_incremental_content);
        this.tvPrefix = (TextView) this.contentView.findViewById(d.tv_attribute_barcode_prefix);
        this.tvSuffix = (TextView) this.contentView.findViewById(d.tv_attribute_barcode_suffix);
        this.qswInterval = (QuantitySelectorWidget) this.contentView.findViewById(d.qsw_attribute_barcode_interval);
        this.tvIncrementalContent.setText(this.receiptBarcodeDataModel.getContent());
        this.tvPrefix.setText(this.receiptBarcodeDataModel.getPrefix());
        this.tvSuffix.setText(this.receiptBarcodeDataModel.getSuffix());
        this.qswInterval.setOffsetValue(this.receiptBarcodeDataModel.getInterval());
        this.tvIncrementalContent.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptBarcodeOperate.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ReceiptBarcodeOperate.this.showEditContent();
            }
        });
        this.tvPrefix.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptBarcodeOperate.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ContentEditDialog contentEditDialog = new ContentEditDialog(ReceiptBarcodeOperate.this.context);
                contentEditDialog.a(ReceiptBarcodeOperate.this.receiptBarcodeDataModel.getPrefix());
                contentEditDialog.show();
                contentEditDialog.b = new InterfaceC0453f() { // from class: com.appdev.standard.page.receipt.operate.ReceiptBarcodeOperate.6.1
                    @Override // com.appdev.standard.dialog.InterfaceC0453f
                    public void setNewContent(String str) {
                        ReceiptBarcodeOperate.this.receiptBarcodeDataModel.setPrefix(str);
                        ReceiptBarcodeOperate.this.tvPrefix.setText(str);
                        ReceiptBarcodeOperate receiptBarcodeOperate = ReceiptBarcodeOperate.this;
                        receiptBarcodeOperate.item.setData(p052j2.c.e(receiptBarcodeOperate.receiptBarcodeDataModel));
                        ReceiptBarcodeOperate.this.quickAdapter.notifyItemChanged(ReceiptBarcodeOperate.this.quickAdapter.getData().indexOf(ReceiptBarcodeOperate.this.item));
                    }
                };
            }
        });
        this.tvSuffix.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptBarcodeOperate.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ContentEditDialog contentEditDialog = new ContentEditDialog(ReceiptBarcodeOperate.this.context);
                contentEditDialog.a(ReceiptBarcodeOperate.this.receiptBarcodeDataModel.getSuffix());
                contentEditDialog.show();
                contentEditDialog.b = new InterfaceC0453f() { // from class: com.appdev.standard.page.receipt.operate.ReceiptBarcodeOperate.7.1
                    @Override // com.appdev.standard.dialog.InterfaceC0453f
                    public void setNewContent(String str) {
                        ReceiptBarcodeOperate.this.receiptBarcodeDataModel.setSuffix(str);
                        ReceiptBarcodeOperate.this.tvSuffix.setText(str);
                        ReceiptBarcodeOperate receiptBarcodeOperate = ReceiptBarcodeOperate.this;
                        receiptBarcodeOperate.item.setData(p052j2.c.e(receiptBarcodeOperate.receiptBarcodeDataModel));
                        ReceiptBarcodeOperate.this.quickAdapter.notifyItemChanged(ReceiptBarcodeOperate.this.quickAdapter.getData().indexOf(ReceiptBarcodeOperate.this.item));
                    }
                };
            }
        });
        this.qswInterval.setOnValueChangeListener(new QuantitySelectorWidget.OnValueChangeListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptBarcodeOperate.8
            @Override // com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget.OnValueChangeListener
            public void onValue(int i5) {
                ReceiptBarcodeOperate.this.receiptBarcodeDataModel.setInterval(i5);
                ReceiptBarcodeOperate receiptBarcodeOperate = ReceiptBarcodeOperate.this;
                receiptBarcodeOperate.item.setData(p052j2.c.e(receiptBarcodeOperate.receiptBarcodeDataModel));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectType(int i5) {
        TextView textView = this.tvBarcodeTitleContent;
        Resources resources = getResources();
        int i6 = p113u.a.color_333333;
        textView.setTextColor(resources.getColor(i6));
        this.tvBarcodeTitleStyle.setTextColor(getResources().getColor(i6));
        this.tvBarcodeTitleData.setTextColor(getResources().getColor(i6));
        this.tvBarcodeTitleIncrementalContent.setTextColor(getResources().getColor(i6));
        this.vLine.setVisibility(0);
        this.tvBarcodeContent.setVisibility(8);
        this.llBarcodeStyle.setVisibility(8);
        this.llBarcodeData.setVisibility(8);
        this.llBarcodeTitleIncrementalContent.setVisibility(8);
        if (i5 == d.tv_pop_receipt_edit_barcode_title_1) {
            this.tvBarcodeTitleContent.setTextColor(getResources().getColor(p113u.a.color_FFAE00));
            this.tvBarcodeContent.setVisibility(0);
            this.vLine.setVisibility(8);
            this.receiptBarcodeDataModel.setInputDataType(0);
            this.item.setData(p052j2.c.e(this.receiptBarcodeDataModel));
            this.quickAdapter.notifyItemChanged(this.quickAdapter.getData().indexOf(this.item));
            return;
        }
        if (i5 == d.tv_pop_receipt_edi_barcode_title_2) {
            this.tvBarcodeTitleStyle.setTextColor(getResources().getColor(p113u.a.color_FFAE00));
            this.llBarcodeStyle.setVisibility(0);
            return;
        }
        if (i5 == d.tv_pop_receipt_edi_barcode_title_3) {
            this.tvBarcodeTitleData.setTextColor(getResources().getColor(p113u.a.color_FFAE00));
            this.llBarcodeData.setVisibility(0);
            return;
        }
        if (i5 != d.tv_pop_receipt_edi_barcode_title_4) {
            this.tvBarcodeTitleContent.setTextColor(getResources().getColor(p113u.a.color_FFAE00));
            this.tvBarcodeContent.setVisibility(0);
            this.vLine.setVisibility(8);
        } else {
            this.tvBarcodeTitleIncrementalContent.setTextColor(getResources().getColor(p113u.a.color_FFAE00));
            this.llBarcodeTitleIncrementalContent.setVisibility(0);
            this.receiptBarcodeDataModel.setInputDataType(1);
            this.item.setData(p052j2.c.e(this.receiptBarcodeDataModel));
            this.quickAdapter.notifyItemChanged(this.quickAdapter.getData().indexOf(this.item));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showEditContent() {
        ContentEditDialog contentEditDialog = new ContentEditDialog(this.context);
        contentEditDialog.a(this.receiptBarcodeDataModel.getContent());
        contentEditDialog.show();
        contentEditDialog.b = new InterfaceC0453f() { // from class: com.appdev.standard.page.receipt.operate.ReceiptBarcodeOperate.9
            @Override // com.appdev.standard.dialog.InterfaceC0453f
            public void setNewContent(String str) {
                ReceiptBarcodeOperate.this.receiptBarcodeDataModel.setContent(str);
                ReceiptBarcodeOperate.this.tvBarcodeContent.setText(str);
                ReceiptBarcodeOperate.this.tvIncrementalContent.setText(str);
                ReceiptBarcodeOperate receiptBarcodeOperate = ReceiptBarcodeOperate.this;
                receiptBarcodeOperate.item.setData(p052j2.c.e(receiptBarcodeOperate.receiptBarcodeDataModel));
                ReceiptBarcodeOperate.this.quickAdapter.notifyItemChanged(ReceiptBarcodeOperate.this.quickAdapter.getData().indexOf(ReceiptBarcodeOperate.this.item));
            }
        };
    }

    @Override // com.appdev.standard.page.receipt.operate.ReceiptBaseOperate
    public int getLayoutId() {
        return e.pop_receipt_edit_barcode;
    }

    @Override // com.appdev.standard.page.receipt.operate.ReceiptBaseOperate
    public void initContent(ReceiptElementModel receiptElementModel) {
        this.receiptBarcodeDataModel = (ReceiptBarcodeDataModel) p052j2.c.d(receiptElementModel.getData(), ReceiptBarcodeDataModel.class);
        initTextTitle1();
        initTextTitle2();
        initTextTitle3();
        initTextTitle4();
        initTextTitle();
        if (this.receiptBarcodeDataModel.getInputDataType() == 1) {
            selectType(d.tv_pop_receipt_edi_barcode_title_4);
        } else {
            selectType(d.tv_pop_receipt_edit_barcode_title_1);
        }
    }
}
