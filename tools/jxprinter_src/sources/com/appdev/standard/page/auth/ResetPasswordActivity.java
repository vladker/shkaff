package com.appdev.standard.page.auth;

import A.d;
import A.e;
import A.f;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.appdev.constant.DefaultRouteConstant;
import com.library.base.frame.MvpActivity;
import com.orhanobut.hawk.Hawk;
import p050j.w;
import p113u.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = DefaultRouteConstant.ACTIVITY_RESETPASSWORD)
public class ResetPasswordActivity extends MvpActivity implements A.a, e {

    @BindView(4934)
    Button btnSendEmailCode;

    @BindView(4935)
    Button btnSendPhoneCode;

    @BindView(5074)
    EditText etResetPasswordEmail;

    @BindView(5075)
    EditText etResetPasswordEmailCode;

    @BindView(5076)
    EditText etResetPasswordPhone;

    @BindView(5077)
    EditText etResetPasswordPhoneCode;

    @BindView(5492)
    LinearLayout llResetPasswordType;

    @BindView(5493)
    LinearLayout llResetPasswordViewEmail;

    @BindView(5494)
    LinearLayout llResetPasswordViewPhone;

    @BindView(6256)
    TextView tvResetPasswordEmail;

    @BindView(6257)
    TextView tvResetPasswordPhone;

    @BindView(6274)
    TextView tvTitle;

    @BindView(6303)
    View viewResetPasswordEmail;

    @BindView(6304)
    View viewResetPasswordPhone;
    private d phoneCodeWorker = null;
    private d emailCodeWorker = null;
    private f checkAuthCodeWorker = null;
    private int registerType = 1;
    private String appType = null;

    @Override // A.e
    public void checkCodeFailed(int i5, String str) {
        w.c();
        p042h2.d.a(str);
    }

    @Override // A.e
    public void checkCodeSuccess() {
        w.c();
        Bundle bundle = new Bundle();
        bundle.putInt("accountType", this.registerType);
        int i5 = this.registerType;
        if (i5 == 1) {
            bundle.putString("username", this.etResetPasswordPhone.getText().toString().trim());
            bundle.putString("code", this.etResetPasswordPhoneCode.getText().toString().trim());
        } else if (i5 == 2) {
            bundle.putString("username", this.etResetPasswordEmail.getText().toString().trim());
            bundle.putString("code", this.etResetPasswordEmailCode.getText().toString().trim());
        }
        ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_FORGET_SETTING_PASSWORD).with(bundle).navigation();
    }

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initComponent() {
        super.initComponent();
        this.tvTitle.setText(getString(g.Forget_Password));
        String str = (String) Hawk.get("appType");
        this.appType = str;
        if (str.equals("sanduOverseas")) {
            this.registerType = 2;
            this.llResetPasswordType.setVisibility(8);
            this.llResetPasswordViewEmail.setVisibility(0);
            this.llResetPasswordViewPhone.setVisibility(8);
            return;
        }
        this.registerType = 1;
        this.llResetPasswordType.setVisibility(0);
        this.llResetPasswordViewEmail.setVisibility(8);
        this.llResetPasswordViewPhone.setVisibility(0);
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initData() {
        super.initData();
        d dVar = new d(this, this.btnSendPhoneCode);
        this.phoneCodeWorker = dVar;
        addPresenter(dVar);
        d dVar2 = new d(this, this.btnSendEmailCode);
        this.emailCodeWorker = dVar2;
        addPresenter(dVar2);
        f fVar = new f(this);
        this.checkAuthCodeWorker = fVar;
        addPresenter(fVar);
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public int layoutId() {
        return p113u.e.activity_reset_password;
    }

    public void onGoLoginClick(View view) {
        androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_LOGIN);
    }

    public void onNextClick(View view) {
        w.e();
        f fVar = this.checkAuthCodeWorker;
        int i5 = this.registerType;
        fVar.a(i5, 2, androidx.exifinterface.media.a.f(i5 == 1 ? this.etResetPasswordPhone : this.etResetPasswordEmail), androidx.exifinterface.media.a.f(this.registerType == 1 ? this.etResetPasswordPhoneCode : this.etResetPasswordEmailCode));
    }

    public void onResetPasswordEmailTypeClick(View view) {
        this.llResetPasswordViewPhone.setVisibility(8);
        this.llResetPasswordViewEmail.setVisibility(0);
        this.tvResetPasswordPhone.setTextColor(getResources().getColor(p113u.a.color_999999));
        this.viewResetPasswordPhone.setVisibility(8);
        this.tvResetPasswordEmail.setTextColor(getResources().getColor(p113u.a.color_FFAE00));
        this.viewResetPasswordEmail.setVisibility(0);
        this.registerType = 2;
    }

    public void onResetPasswordPhoneTypeClick(View view) {
        this.llResetPasswordViewPhone.setVisibility(0);
        this.llResetPasswordViewEmail.setVisibility(8);
        this.tvResetPasswordPhone.setTextColor(getResources().getColor(p113u.a.color_FFAE00));
        this.viewResetPasswordPhone.setVisibility(0);
        this.tvResetPasswordEmail.setTextColor(getResources().getColor(p113u.a.color_999999));
        this.viewResetPasswordEmail.setVisibility(8);
        this.registerType = 1;
    }

    public void onSendEmailCodeClick(View view) {
        w.e();
        this.emailCodeWorker.a(2, 2, this.etResetPasswordEmail.getText().toString().trim());
    }

    public void onSendPhoneCodeClick(View view) {
        w.e();
        this.phoneCodeWorker.a(1, 2, this.etResetPasswordPhone.getText().toString().trim());
    }

    public void resetPasswordFailed(int i5, String str) {
        w.c();
        p042h2.d.a(str);
    }

    public void resetPasswordSuccess() {
        w.c();
        finish();
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
