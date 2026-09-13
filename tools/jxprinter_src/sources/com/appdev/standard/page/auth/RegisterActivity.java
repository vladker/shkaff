package com.appdev.standard.page.auth;

import A.b;
import A.d;
import A.e;
import A.f;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.dialog.SummaryTipDialog;
import com.library.base.frame.MvpActivity;
import com.orhanobut.hawk.Hawk;
import kotlin.jvm.internal.Y;
import p050j.w;
import p056k0.o;
import p113u.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = DefaultRouteConstant.ACTIVITY_REGISTER)
public class RegisterActivity extends MvpActivity implements A.a, e {

    @BindView(4934)
    Button btnSendEmailCode;

    @BindView(4935)
    Button btnSendPhoneCode;

    @BindView(5070)
    EditText etRegisterEmail;

    @BindView(5071)
    EditText etRegisterEmailCode;

    @BindView(5072)
    EditText etRegisterPhone;

    @BindView(5073)
    EditText etRegisterPhoneCode;

    @BindView(5257)
    ImageView ivLoginAgreement;

    @BindView(5485)
    LinearLayout llRegisterEmail;

    @BindView(5486)
    LinearLayout llRegisterPhone;

    @BindView(5487)
    LinearLayout llRegisterType;

    @BindView(5488)
    LinearLayout llRegisterViewEmail;

    @BindView(5489)
    LinearLayout llRegisterViewPhone;

    @BindView(6253)
    TextView tvRegisterAgreement;

    @BindView(6254)
    TextView tvRegisterEmail;

    @BindView(6255)
    TextView tvRegisterPhone;

    @BindView(6274)
    TextView tvTitle;

    @BindView(6301)
    View viewRegisterEmail;

    @BindView(6302)
    View viewRegisterPhone;
    private d phoneCodeWorker = null;
    private d emailCodeWorker = null;
    private f checkAuthCodeWorker = null;
    private int registerType = 1;
    private boolean isAgreement = false;
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
            bundle.putString("username", this.etRegisterPhone.getText().toString().trim());
            bundle.putString("code", this.etRegisterPhoneCode.getText().toString().trim());
        } else if (i5 == 2) {
            bundle.putString("username", this.etRegisterEmail.getText().toString().trim());
            bundle.putString("code", this.etRegisterEmailCode.getText().toString().trim());
        }
        ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_SETTING_PASSWORD).with(bundle).navigation();
    }

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initComponent() {
        super.initComponent();
        this.tvTitle.setText(getString(g.register));
        Bundle extras = getIntent().getExtras();
        String string = extras != null ? extras.getString("account") : null;
        this.appType = (String) Hawk.get("appType");
        boolean z6 = !Y.f(string) && string.contains("@");
        if (this.appType.equals("sanduOverseas")) {
            this.registerType = 2;
            this.llRegisterType.setVisibility(8);
            this.llRegisterViewPhone.setVisibility(8);
            this.llRegisterViewEmail.setVisibility(0);
            if (!Y.f(string)) {
                this.etRegisterEmail.setText(string);
            }
        } else {
            if (z6) {
                this.registerType = 2;
            } else {
                this.registerType = 1;
            }
            this.llRegisterType.setVisibility(0);
            if (z6) {
                this.llRegisterViewPhone.setVisibility(8);
                this.llRegisterViewEmail.setVisibility(0);
                this.etRegisterEmail.setText(string);
                this.tvRegisterPhone.setTextColor(getResources().getColor(p113u.a.color_999999));
                this.viewRegisterPhone.setVisibility(8);
                this.tvRegisterEmail.setTextColor(getResources().getColor(p113u.a.color_FFAE00));
                this.viewRegisterEmail.setVisibility(0);
            } else {
                this.llRegisterViewPhone.setVisibility(0);
                this.llRegisterViewEmail.setVisibility(8);
                this.etRegisterPhone.setText(string);
            }
        }
        o oVar = new o() { // from class: com.appdev.standard.page.auth.RegisterActivity.1
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                RegisterActivity.this.onAgreementClick(null);
            }
        };
        o oVar2 = new o() { // from class: com.appdev.standard.page.auth.RegisterActivity.2
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_AGREEMENT).withInt("type", 1).navigation();
            }
        };
        o oVar3 = new o() { // from class: com.appdev.standard.page.auth.RegisterActivity.3
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_AGREEMENT).withInt("type", 2).navigation();
            }
        };
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor("#FF9B7C"));
        String string2 = getString(g.text_30);
        String string3 = getString(g.summary_content_2_2);
        String string4 = getString(g.summary_content_2_3);
        String string5 = getString(g.summary_content_2_4);
        String string6 = getString(g.text_32);
        String str = string2 + string3 + string4 + string5 + string6;
        SpannableString spannableString = new SpannableString(str);
        int iIndexOf = str.indexOf(string2);
        int length = string2.length() + iIndexOf;
        int iIndexOf2 = str.indexOf(string4);
        int length2 = string4.length() + iIndexOf2;
        int iIndexOf3 = str.indexOf(string6);
        int length3 = string6.length() + iIndexOf3;
        int iIndexOf4 = str.indexOf(string3);
        int length4 = string3.length() + iIndexOf4;
        int iIndexOf5 = str.indexOf(string5);
        int length5 = string5.length() + iIndexOf5;
        spannableString.setSpan(oVar, iIndexOf, length, 33);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#999999")), iIndexOf, length, 33);
        spannableString.setSpan(oVar2, iIndexOf4, length4, 33);
        spannableString.setSpan(foregroundColorSpan, iIndexOf4, length4, 33);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#999999")), iIndexOf2, length2, 33);
        spannableString.setSpan(oVar3, iIndexOf5, length5, 33);
        spannableString.setSpan(foregroundColorSpan, iIndexOf5, length5, 33);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#999999")), iIndexOf3, length3, 33);
        this.tvRegisterAgreement.setText(spannableString);
        this.tvRegisterAgreement.setMovementMethod(LinkMovementMethod.getInstance());
        this.tvRegisterAgreement.setHighlightColor(0);
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
        return p113u.e.activity_register;
    }

    public void onAgreementClick(View view) {
        boolean z6 = this.isAgreement;
        this.isAgreement = !z6;
        if (z6) {
            this.ivLoginAgreement.setImageResource(p113u.f.standard_ic_common_radio_select_not);
        } else {
            this.ivLoginAgreement.setImageResource(p113u.f.standard_ic_common_radio_select);
        }
    }

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        b bVar = this.phoneCodeWorker.e;
        if (bVar != null) {
            bVar.cancel();
            bVar.onFinish();
        }
        b bVar2 = this.emailCodeWorker.e;
        if (bVar2 != null) {
            bVar2.cancel();
            bVar2.onFinish();
        }
        super.onDestroy();
    }

    public void onGoLoginClick(View view) {
        androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_LOGIN);
    }

    public void onNextClick(View view) {
        if (!this.isAgreement) {
            SummaryTipDialog summaryTipDialog = new SummaryTipDialog(this);
            summaryTipDialog.f2631a = new p041h0.a() { // from class: com.appdev.standard.page.auth.RegisterActivity.4
                @Override // p041h0.a
                public void onConfirm() {
                    RegisterActivity.this.onAgreementClick(null);
                }

                @Override // p041h0.a
                public void onCancel() {
                }
            };
            summaryTipDialog.show();
        } else {
            w.e();
            f fVar = this.checkAuthCodeWorker;
            int i5 = this.registerType;
            fVar.a(i5, 1, androidx.exifinterface.media.a.f(i5 == 1 ? this.etRegisterPhone : this.etRegisterEmail), androidx.exifinterface.media.a.f(this.registerType == 1 ? this.etRegisterPhoneCode : this.etRegisterEmailCode));
        }
    }

    public void onRegisterEmailTypeClick(View view) {
        this.llRegisterViewPhone.setVisibility(8);
        this.llRegisterViewEmail.setVisibility(0);
        this.tvRegisterPhone.setTextColor(getResources().getColor(p113u.a.color_999999));
        this.viewRegisterPhone.setVisibility(8);
        this.tvRegisterEmail.setTextColor(getResources().getColor(p113u.a.color_FFAE00));
        this.viewRegisterEmail.setVisibility(0);
        this.registerType = 2;
    }

    public void onRegisterPhoneTypeClick(View view) {
        this.llRegisterViewPhone.setVisibility(0);
        this.llRegisterViewEmail.setVisibility(8);
        this.tvRegisterPhone.setTextColor(getResources().getColor(p113u.a.color_FFAE00));
        this.viewRegisterPhone.setVisibility(0);
        this.tvRegisterEmail.setTextColor(getResources().getColor(p113u.a.color_999999));
        this.viewRegisterEmail.setVisibility(8);
        this.registerType = 1;
    }

    public void onSendEmailCodeClick(View view) {
        w.e();
        this.phoneCodeWorker.a(2, 1, this.etRegisterEmail.getText().toString().trim());
    }

    public void onSendPhoneCodeClick(View view) {
        w.e();
        this.phoneCodeWorker.a(1, 1, this.etRegisterPhone.getText().toString().trim());
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
