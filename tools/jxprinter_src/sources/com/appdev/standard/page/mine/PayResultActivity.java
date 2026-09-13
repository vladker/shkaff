package com.appdev.standard.page.mine;

import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.appdev.constant.DefaultRouteConstant;
import com.library.base.frame.FrameApplication;
import com.library.base.frame.MvpActivity;
import com.orhanobut.hawk.Hawk;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = DefaultRouteConstant.ACTIVITY_PAY_RESULT)
public class PayResultActivity extends MvpActivity {

    @BindView(5264)
    ImageView ivPayStatus;

    @Autowired(name = "payStatus")
    int payStatus;

    @BindView(6274)
    TextView tvTitle;

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initComponent() {
        super.initComponent();
        if (this.payStatus != 2) {
            this.tvTitle.setText(getString(p113u.g.text_234));
            return;
        }
        this.tvTitle.setText(getString(p113u.g.text_233));
        if (((String) Hawk.get("current_language", FrameApplication.defaultLang)).equals("zh")) {
            this.ivPayStatus.setImageResource(p113u.f.icon_pay_fail);
        } else {
            this.ivPayStatus.setImageResource(p113u.f.icon_pay_fail_en);
        }
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public int layoutId() {
        return p113u.e.activity_pay_result;
    }
}
