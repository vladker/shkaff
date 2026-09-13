package com.appdev.standard.page.receipt.operate;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.appdev.standard.model.ReceiptElementModel;
import com.appdev.standard.model.ReceiptPictureDataModel;
import com.appdev.standard.page.printerlabel.widget.LineProgressWidget;
import com.library.base.util.recyclerview.f;
import p052j2.c;
import p113u.d;
import p113u.e;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ReceiptPictureOperate extends ReceiptBaseOperate {
    private LinearLayout llDisplayMode;
    private LinearLayout llDisplayModeProportional;
    private LinearLayout llDisplayModeTile;
    private LinearLayout llSize;
    private LineProgressWidget lpwHeight;
    private LineProgressWidget lpwWidth;
    private ReceiptPictureDataModel receiptPictureDataModel;
    private TextView tvDisplayModeTitle;
    private TextView tvSizeTitle;

    public ReceiptPictureOperate(Context context, f fVar) {
        super(context, fVar);
        this.receiptPictureDataModel = null;
    }

    private void initPictureTitle() {
        this.tvSizeTitle = (TextView) this.contentView.findViewById(d.tv_pop_receipt_edit_picture_size);
        this.tvDisplayModeTitle = (TextView) this.contentView.findViewById(d.tv_pop_receipt_edit_picture_display_mode);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptPictureOperate.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ReceiptPictureOperate.this.selectType(view.getId());
            }
        };
        this.tvSizeTitle.setOnClickListener(onClickListener);
        this.tvDisplayModeTitle.setOnClickListener(onClickListener);
    }

    private void initPictureTitle1() {
        this.llSize = (LinearLayout) this.contentView.findViewById(d.ll_pop_receipt_edit_picture_size);
        this.lpwWidth = (LineProgressWidget) this.contentView.findViewById(d.lpw_picture_width);
        this.lpwHeight = (LineProgressWidget) this.contentView.findViewById(d.lpw_picture_height);
        this.lpwWidth.setPosition(this.receiptPictureDataModel.getW());
        this.lpwHeight.setPosition(this.receiptPictureDataModel.getH());
        this.lpwWidth.setOnRangeUpListener(new LineProgressWidget.OnRangeUpListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptPictureOperate.2
            @Override // com.appdev.standard.page.printerlabel.widget.LineProgressWidget.OnRangeUpListener
            public void onRangeUp(float f6) {
                ReceiptPictureOperate.this.receiptPictureDataModel.setW(f6);
                ReceiptPictureOperate receiptPictureOperate = ReceiptPictureOperate.this;
                receiptPictureOperate.item.setData(c.e(receiptPictureOperate.receiptPictureDataModel));
                ReceiptPictureOperate.this.quickAdapter.notifyItemChanged(ReceiptPictureOperate.this.quickAdapter.getData().indexOf(ReceiptPictureOperate.this.item));
            }
        });
        this.lpwHeight.setOnRangeUpListener(new LineProgressWidget.OnRangeUpListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptPictureOperate.3
            @Override // com.appdev.standard.page.printerlabel.widget.LineProgressWidget.OnRangeUpListener
            public void onRangeUp(float f6) {
                ReceiptPictureOperate.this.receiptPictureDataModel.setH(f6);
                ReceiptPictureOperate receiptPictureOperate = ReceiptPictureOperate.this;
                receiptPictureOperate.item.setData(c.e(receiptPictureOperate.receiptPictureDataModel));
                ReceiptPictureOperate.this.quickAdapter.notifyItemChanged(ReceiptPictureOperate.this.quickAdapter.getData().indexOf(ReceiptPictureOperate.this.item));
            }
        });
    }

    private void initPictureTitle2() {
        this.llDisplayMode = (LinearLayout) this.contentView.findViewById(d.ll_pop_receipt_edit_picture_display_mode);
        this.llDisplayModeProportional = (LinearLayout) this.contentView.findViewById(d.iv_pop_receipt_edit_picture_proportional);
        this.llDisplayModeTile = (LinearLayout) this.contentView.findViewById(d.iv_pop_receipt_edit_picture_tile);
        updateDisplayModeUI();
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.appdev.standard.page.receipt.operate.ReceiptPictureOperate.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == d.iv_pop_receipt_edit_picture_proportional) {
                    ReceiptPictureOperate.this.receiptPictureDataModel.setDisplayMode(0);
                } else if (view.getId() == d.iv_pop_receipt_edit_picture_tile) {
                    ReceiptPictureOperate.this.receiptPictureDataModel.setDisplayMode(1);
                }
                ReceiptPictureOperate.this.updateDisplayModeUI();
                ReceiptPictureOperate receiptPictureOperate = ReceiptPictureOperate.this;
                receiptPictureOperate.item.setData(c.e(receiptPictureOperate.receiptPictureDataModel));
                ReceiptPictureOperate.this.quickAdapter.notifyItemChanged(ReceiptPictureOperate.this.quickAdapter.getData().indexOf(ReceiptPictureOperate.this.item));
            }
        };
        this.llDisplayModeProportional.setOnClickListener(onClickListener);
        this.llDisplayModeTile.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectType(int i5) {
        TextView textView = this.tvSizeTitle;
        Resources resources = this.context.getResources();
        int i6 = p113u.a.color_333333;
        textView.setTextColor(resources.getColor(i6));
        this.tvDisplayModeTitle.setTextColor(this.context.getResources().getColor(i6));
        this.llSize.setVisibility(8);
        this.llDisplayMode.setVisibility(8);
        if (i5 == d.tv_pop_receipt_edit_picture_size) {
            this.tvSizeTitle.setTextColor(this.context.getResources().getColor(p113u.a.color_FFAE00));
            this.llSize.setVisibility(0);
        } else if (i5 == d.tv_pop_receipt_edit_picture_display_mode) {
            this.tvDisplayModeTitle.setTextColor(this.context.getResources().getColor(p113u.a.color_FFAE00));
            this.llDisplayMode.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDisplayModeUI() {
        LinearLayout linearLayout = this.llDisplayModeProportional;
        int i5 = p113u.c.bg_f8f8f8_rad_6;
        linearLayout.setBackgroundResource(i5);
        this.llDisplayModeTile.setBackgroundResource(i5);
        if (this.receiptPictureDataModel.getDisplayMode() == 0) {
            this.llDisplayModeProportional.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
        } else {
            this.llDisplayModeTile.setBackgroundResource(p113u.c.bg_fff3da_rad_6_stroke_ffae00);
        }
    }

    @Override // com.appdev.standard.page.receipt.operate.ReceiptBaseOperate
    public int getLayoutId() {
        return e.pop_receipt_edit_picture;
    }

    @Override // com.appdev.standard.page.receipt.operate.ReceiptBaseOperate
    public void initContent(ReceiptElementModel receiptElementModel) {
        this.receiptPictureDataModel = (ReceiptPictureDataModel) c.d(receiptElementModel.getData(), ReceiptPictureDataModel.class);
        initPictureTitle();
        initPictureTitle1();
        initPictureTitle2();
        selectType(d.tv_pop_receipt_edit_picture_size);
    }
}
