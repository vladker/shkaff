package com.appdev.standard.page.receipt.operate;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.appdev.standard.model.ReceiptElementModel;
import com.appdev.standard.model.ReceiptLineDataModel;
import com.appdev.standard.page.printerlabel.widget.LineProgressWidget;
import com.library.base.util.recyclerview.f;
import p113u.c;
import p113u.d;
import p113u.e;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ReceiptLineOperate extends ReceiptBaseOperate {
    private LinearLayout llLineStyle;
    private LinearLayout llLineType;
    private ReceiptLineDataModel receiptLineDataModel;
    private TextView tvLineStyleTitle;
    private TextView tvLineTypeTitle;

    public ReceiptLineOperate(Context context, f fVar) {
        super(context, fVar);
        this.receiptLineDataModel = null;
    }

    private void initLineTitle() {
        this.tvLineTypeTitle = (TextView) this.contentView.findViewById(d.tv_pop_receipt_edit_line_type);
        this.tvLineStyleTitle = (TextView) this.contentView.findViewById(d.tv_pop_receipt_edit_line_style);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptLineOperate.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ReceiptLineOperate.this.selectType(view.getId());
            }
        };
        this.tvLineTypeTitle.setOnClickListener(onClickListener);
        this.tvLineStyleTitle.setOnClickListener(onClickListener);
    }

    private void initLineTitle1() {
        this.llLineType = (LinearLayout) this.contentView.findViewById(d.ll_pop_receipt_edit_line_type);
        final ImageView imageView = (ImageView) this.contentView.findViewById(d.iv_pop_receipt_edit_line_style_1);
        final ImageView imageView2 = (ImageView) this.contentView.findViewById(d.iv_pop_receipt_edit_line_style_2);
        final ImageView imageView3 = (ImageView) this.contentView.findViewById(d.iv_pop_receipt_edit_line_style_3);
        int i5 = c.bg_f8f8f8_rad_6;
        imageView.setBackgroundResource(i5);
        imageView2.setBackgroundResource(i5);
        imageView3.setBackgroundResource(i5);
        int lineStyleIndex = this.receiptLineDataModel.getLineStyleIndex();
        if (lineStyleIndex == 1) {
            imageView.setBackgroundResource(c.bg_fff3da_rad_6_stroke_ffae00);
        } else if (lineStyleIndex == 2) {
            imageView2.setBackgroundResource(c.bg_fff3da_rad_6_stroke_ffae00);
        } else if (lineStyleIndex == 4) {
            imageView3.setBackgroundResource(c.bg_fff3da_rad_6_stroke_ffae00);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptLineOperate.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ImageView imageView4 = imageView;
                int i6 = c.bg_f8f8f8_rad_6;
                imageView4.setBackgroundResource(i6);
                imageView2.setBackgroundResource(i6);
                imageView3.setBackgroundResource(i6);
                if (view.getId() == d.iv_pop_receipt_edit_line_style_1) {
                    imageView.setBackgroundResource(c.bg_fff3da_rad_6_stroke_ffae00);
                    ReceiptLineOperate.this.receiptLineDataModel.setLineStyleIndex(1);
                } else if (view.getId() == d.iv_pop_receipt_edit_line_style_2) {
                    imageView2.setBackgroundResource(c.bg_fff3da_rad_6_stroke_ffae00);
                    ReceiptLineOperate.this.receiptLineDataModel.setLineStyleIndex(2);
                } else if (view.getId() == d.iv_pop_receipt_edit_line_style_3) {
                    imageView3.setBackgroundResource(c.bg_fff3da_rad_6_stroke_ffae00);
                    ReceiptLineOperate.this.receiptLineDataModel.setLineStyleIndex(4);
                }
                ReceiptLineOperate receiptLineOperate = ReceiptLineOperate.this;
                receiptLineOperate.item.setData(p052j2.c.e(receiptLineOperate.receiptLineDataModel));
                ReceiptLineOperate.this.quickAdapter.notifyItemChanged(ReceiptLineOperate.this.quickAdapter.getData().indexOf(ReceiptLineOperate.this.item));
            }
        };
        imageView.setOnClickListener(onClickListener);
        imageView2.setOnClickListener(onClickListener);
        imageView3.setOnClickListener(onClickListener);
    }

    private void initLineTitle2() {
        this.llLineStyle = (LinearLayout) this.contentView.findViewById(d.ll_pop_receipt_edit_line_style);
        LineProgressWidget lineProgressWidget = (LineProgressWidget) this.contentView.findViewById(d.lpw_line_width);
        lineProgressWidget.setPosition(this.receiptLineDataModel.getLineSize());
        lineProgressWidget.setOnRangeUpListener(new LineProgressWidget.OnRangeUpListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptLineOperate.3
            @Override // com.appdev.standard.page.printerlabel.widget.LineProgressWidget.OnRangeUpListener
            public void onRangeUp(float f6) {
                ReceiptLineOperate.this.receiptLineDataModel.setLineSize(f6);
                ReceiptLineOperate receiptLineOperate = ReceiptLineOperate.this;
                receiptLineOperate.item.setData(p052j2.c.e(receiptLineOperate.receiptLineDataModel));
                ReceiptLineOperate.this.quickAdapter.notifyItemChanged(ReceiptLineOperate.this.quickAdapter.getData().indexOf(ReceiptLineOperate.this.item));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectType(int i5) {
        TextView textView = this.tvLineTypeTitle;
        Resources resources = this.context.getResources();
        int i6 = p113u.a.color_333333;
        textView.setTextColor(resources.getColor(i6));
        this.tvLineStyleTitle.setTextColor(this.context.getResources().getColor(i6));
        this.llLineType.setVisibility(8);
        this.llLineStyle.setVisibility(8);
        if (i5 == d.tv_pop_receipt_edit_line_type) {
            this.tvLineTypeTitle.setTextColor(this.context.getResources().getColor(p113u.a.color_FFAE00));
            this.llLineType.setVisibility(0);
        } else if (i5 == d.tv_pop_receipt_edit_line_style) {
            this.tvLineStyleTitle.setTextColor(this.context.getResources().getColor(p113u.a.color_FFAE00));
            this.llLineStyle.setVisibility(0);
        }
    }

    @Override // com.appdev.standard.page.receipt.operate.ReceiptBaseOperate
    public int getLayoutId() {
        return e.pop_receipt_edit_line;
    }

    @Override // com.appdev.standard.page.receipt.operate.ReceiptBaseOperate
    public void initContent(ReceiptElementModel receiptElementModel) {
        this.receiptLineDataModel = (ReceiptLineDataModel) p052j2.c.d(receiptElementModel.getData(), ReceiptLineDataModel.class);
        initLineTitle1();
        initLineTitle2();
        initLineTitle();
        selectType(d.tv_pop_receipt_edit_line_type);
    }
}
