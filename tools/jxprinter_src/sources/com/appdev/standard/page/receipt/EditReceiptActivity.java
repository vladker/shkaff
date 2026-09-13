package com.appdev.standard.page.receipt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.BindView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.appdev.constant.DefaultRouteConstant;
import com.library.base.frame.MvpActivity;
import p113u.d;
import p113u.e;
import p113u.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = DefaultRouteConstant.ACTIVITY_EDIT_RECEIPT)
public class EditReceiptActivity extends MvpActivity {
    private String receiptWidth = "48";

    @BindView(5796)
    RadioGroup rgWidth;

    @BindView(6274)
    TextView tvTitle;

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initComponent() {
        super.initComponent();
        this.tvTitle.setText(getString(g.text_241));
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initListener() {
        super.initListener();
        this.rgWidth.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.appdev.standard.page.receipt.EditReceiptActivity.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i5) {
                if (i5 == d.rb_create_receipt_width_58) {
                    EditReceiptActivity.this.receiptWidth = "58";
                    return;
                }
                if (i5 == d.rb_create_receipt_width_80) {
                    EditReceiptActivity.this.receiptWidth = "82";
                } else if (i5 == d.rb_create_receipt_width_110) {
                    EditReceiptActivity.this.receiptWidth = "110";
                } else if (i5 == d.rb_create_receipt_width_210) {
                    EditReceiptActivity.this.receiptWidth = "210";
                }
            }
        });
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public int layoutId() {
        return e.activity_edit_receipt;
    }

    public void onCreateReceiptNextClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("receiptWidth", this.receiptWidth);
        setResult(-1, intent);
        finish();
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void receiveDataFromPreActivity(Bundle bundle) {
        super.receiveDataFromPreActivity(bundle);
        String string = bundle.getString("receiptWidth", "58");
        this.receiptWidth = string;
        if (string.equals("58")) {
            this.rgWidth.check(d.rb_create_receipt_width_58);
            return;
        }
        if (this.receiptWidth.equals("82")) {
            this.rgWidth.check(d.rb_create_receipt_width_80);
        } else if (this.receiptWidth.equals("110")) {
            this.rgWidth.check(d.rb_create_receipt_width_110);
        } else if (this.receiptWidth.equals("210")) {
            this.rgWidth.check(d.rb_create_receipt_width_210);
        }
    }
}
