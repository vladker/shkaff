package com.appdev.standard.page.receipt;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.BindView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.appdev.constant.DefaultRouteConstant;
import com.library.base.frame.MvpActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.opencv.videoio.Videoio;
import p051j0.a;
import p113u.c;
import p113u.d;
import p113u.e;
import p113u.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = DefaultRouteConstant.ACTIVITY_CREATE_RECEIPT)
public class CreateReceiptActivity extends MvpActivity {

    @BindView(5738)
    RadioButton rb110;

    @BindView(5739)
    RadioButton rb210;

    @BindView(5740)
    RadioButton rb58;

    @BindView(5741)
    RadioButton rb80;

    @BindView(5796)
    RadioGroup rgWidth;

    @BindView(6274)
    TextView tvTitle;
    private String receiptWidth = "58";
    private List<RadioButton> rbList = new ArrayList();

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initComponent() {
        super.initComponent();
        this.tvTitle.setText(getString(g.text_241));
        this.rb58.setChecked(true);
        this.rbList.add(this.rb58);
        this.rbList.add(this.rb80);
        this.rbList.add(this.rb110);
        this.rbList.add(this.rb210);
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initListener() {
        super.initListener();
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public int layoutId() {
        return e.activity_create_receipt;
    }

    public void onClickRadio(View view) {
        int id = view.getId();
        selectRadio(id);
        if (id == d.rb_create_receipt_width_58) {
            this.receiptWidth = "58";
            return;
        }
        if (id == d.rb_create_receipt_width_80) {
            this.receiptWidth = "80";
        } else if (id == d.rb_create_receipt_width_110) {
            this.receiptWidth = "100";
        } else if (id == d.rb_create_receipt_width_210) {
            this.receiptWidth = "210";
        }
    }

    public void onCreateReceiptNextClick(View view) {
        a.k(this.TAG, "receiptWidth=" + this.receiptWidth);
        Bundle bundle = new Bundle();
        bundle.putString("receiptWidth", this.receiptWidth);
        bundle.putString("receiptId", String.valueOf(new Random().nextInt(Videoio.CAP_PVAPI) + 100) + System.currentTimeMillis() + String.valueOf(new Random().nextInt(Videoio.CAP_PVAPI) + 100));
        ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_RECEIPT_EDIT).with(bundle).navigation();
        finish();
    }

    public void selectRadio(int i5) {
        for (RadioButton radioButton : this.rbList) {
            if (radioButton.getId() == i5) {
                radioButton.setChecked(true);
                radioButton.setBackgroundResource(c.bg_ffae00_rad_10);
                radioButton.setTextColor(getResources().getColor(p113u.a.color_FFFFFF));
            } else {
                radioButton.setChecked(false);
                radioButton.setBackgroundResource(c.bg_ffffff_rad_10_stroke_999999);
                radioButton.setTextColor(getResources().getColor(p113u.a.color_999999));
            }
        }
    }
}
