package com.appdev.standard.page.mine;

import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.appdev.constant.DefaultRouteConstant;
import com.library.base.frame.MvpActivity;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = DefaultRouteConstant.ACTIVITY_SERVER_AGREEMENT)
public class ServerAgreementActivity extends MvpActivity {

    @BindView(6274)
    TextView tvTitle;

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initComponent() {
        super.initComponent();
        this.tvTitle.setText(getString(p113u.g.text_235));
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public int layoutId() {
        return p113u.e.activity_server_agreement;
    }

    public void onPrivacyAgreementClick(View view) {
        ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_AGREEMENT).withInt("type", 2).navigation();
    }

    public void onUserAgreementClick(View view) {
        ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_AGREEMENT).withInt("type", 1).navigation();
    }
}
