package com.appdev.standard.page.mine;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.appdev.constant.DefaultRouteConstant;
import com.library.base.frame.MvpActivity;
import com.orhanobut.hawk.Hawk;
import p050j.w;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = DefaultRouteConstant.ACTIVITY_CHANGE_USERNAME_PHONE)
public class ChangeUserNamePhoneActivity extends MvpActivity implements A.a, p025e0.g {

    @BindView(4935)
    Button btnSendPhoneCode;

    @BindView(5044)
    EditText etChangeUserNamePassword;

    @BindView(5067)
    EditText etPhoneCode;

    @BindView(5082)
    EditText etUsername;

    @BindView(5358)
    LinearLayout llChangeUserNamePassword;

    @BindView(5359)
    LinearLayout llChangeUserNameUsername;

    @BindView(6043)
    TextView tvChangeUserNameNext;

    @BindView(6274)
    TextView tvTitle;
    private String username;
    private A.d authCodeWorker = null;
    private p025e0.h editUserNameWorker = null;

    @Override // p025e0.g
    public void editUserNameFailed(int i5, String str) {
        w.c();
        p042h2.d.a(str);
    }

    @Override // p025e0.g
    public void editUserNameSuccess() {
        w.c();
        S4.h hVar = p042h2.e.f4031a;
        String str = this.username;
        p032f2.a aVar = (p032f2.a) Hawk.get("user_util_user_data", null);
        hVar.b = aVar;
        if (aVar != null) {
            aVar.d = str;
            Hawk.put("user_util_user_data", aVar);
        }
        finish();
    }

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initComponent() {
        super.initComponent();
        this.tvTitle.setText(getString(p113u.g.text_230));
        A.d dVar = new A.d(this, this.btnSendPhoneCode);
        this.authCodeWorker = dVar;
        addPresenter(dVar);
        p025e0.h hVar = new p025e0.h(this);
        this.editUserNameWorker = hVar;
        addPresenter(hVar);
        this.llChangeUserNamePassword.setVisibility(8);
        this.llChangeUserNameUsername.setVisibility(0);
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initData() {
        super.initData();
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public int layoutId() {
        return p113u.e.activity_change_user_name_phone;
    }

    public void onConfirmClick(View view) {
        w.e();
        this.editUserNameWorker.a(1, androidx.exifinterface.media.a.f(this.etPhoneCode), "", this.username);
    }

    public void onSendPhoneCodeClick(View view) {
        w.e();
        String strF = androidx.exifinterface.media.a.f(this.etUsername);
        this.username = strF;
        this.authCodeWorker.a(1, 3, strF);
    }

    @Override // A.a
    public void sendCodeFailed(int i5, String str) {
        w.c();
        p042h2.d.a(str);
    }

    @Override // A.a
    public void sendCodeSuccess(String str) {
        w.c();
        p042h2.d.a(str);
    }
}
