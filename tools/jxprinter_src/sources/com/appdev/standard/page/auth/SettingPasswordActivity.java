package com.appdev.standard.page.auth;

import A.c;
import V.b;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import butterknife.BindView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.api.AuthorityApi;
import com.appdev.standard.api.pto.RegisterPto;
import com.library.base.frame.MvpActivity;
import com.library.base.util.http.Http;
import kotlin.jvm.internal.Y;
import p042h2.d;
import p050j.w;
import p051j0.i;
import p113u.e;
import p113u.f;
import p113u.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = DefaultRouteConstant.ACTIVITY_SETTING_PASSWORD)
public class SettingPasswordActivity extends MvpActivity implements V.a {
    private int accountType;

    @BindView(5892)
    ImageButton btnShowConfirmPassword;

    @BindView(5885)
    ImageButton btnShowPassword;
    private String code;

    @BindView(5080)
    EditText etSettingAgain;

    @BindView(5081)
    EditText etSettingPassword;
    private b registerWorker;

    @BindView(6274)
    TextView tvTitle;
    private String username;
    private boolean showPassword = false;
    private boolean showConfirmPassword = false;

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initComponent() {
        super.initComponent();
        this.tvTitle.setText(getString(g.setting_the_password));
        b bVar = new b(this);
        bVar.d = null;
        bVar.d = (AuthorityApi) Http.createApi(AuthorityApi.class);
        this.registerWorker = bVar;
        addPresenter(bVar);
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initData() {
        super.initData();
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initListener() {
        super.initListener();
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public int layoutId() {
        return e.activity_setting_password;
    }

    public void onConfirmClick(View view) {
        w.e();
        b bVar = this.registerWorker;
        int i5 = this.accountType;
        String str = this.code;
        String strF = androidx.exifinterface.media.a.f(this.etSettingPassword);
        String strF2 = androidx.exifinterface.media.a.f(this.etSettingAgain);
        String str2 = this.username;
        if (Y.f(str2)) {
            Object obj = bVar.b;
            if (obj != null) {
                ((V.a) obj).registerFailed(1, bVar.getString(g.The_account_cannot_be_empty));
                return;
            }
            return;
        }
        if (Y.f(strF)) {
            Object obj2 = bVar.b;
            if (obj2 != null) {
                ((V.a) obj2).registerFailed(1, bVar.getString(g.The_password_cannot_be_empty));
                return;
            }
            return;
        }
        bVar.getClass();
        if (!strF.equals(strF2)) {
            Object obj3 = bVar.b;
            if (obj3 != null) {
                ((V.a) obj3).registerFailed(1, bVar.getString(g.Two_different_passwords));
                return;
            }
            return;
        }
        if (!Y.f(str)) {
            bVar.d.register(new RegisterPto(i5, str, i.b(strF), str2)).b(new c(bVar, 23));
            return;
        }
        Object obj4 = bVar.b;
        if (obj4 != null) {
            ((V.a) obj4).registerFailed(1, bVar.getString(g.The_verification_code_cannot_be_empty));
        }
    }

    public void onShowConfirmPasswordClick(View view) {
        if (this.showConfirmPassword) {
            this.etSettingAgain.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.btnShowConfirmPassword.setImageResource(f.ic_show_passwd);
        } else {
            this.etSettingAgain.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            this.btnShowConfirmPassword.setImageResource(f.ic_hide_passwd);
        }
        this.showConfirmPassword = !this.showConfirmPassword;
        EditText editText = this.etSettingAgain;
        editText.setSelection(editText.getText().length());
    }

    public void onShowPasswordClick(View view) {
        if (this.showPassword) {
            this.etSettingPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.btnShowPassword.setImageResource(f.ic_show_passwd);
        } else {
            this.etSettingPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            this.btnShowPassword.setImageResource(f.ic_hide_passwd);
        }
        this.showPassword = !this.showPassword;
        EditText editText = this.etSettingPassword;
        editText.setSelection(editText.getText().length());
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void receiveDataFromPreActivity(Bundle bundle) {
        super.receiveDataFromPreActivity(bundle);
        this.accountType = bundle.getInt("accountType");
        this.username = bundle.getString("username");
        this.code = bundle.getString("code");
    }

    @Override // V.a
    public void registerFailed(int i5, String str) {
        w.c();
        d.a(str);
    }

    @Override // V.a
    public void registerSuccess() {
        w.c();
        d.show(g.register_success);
        ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_LOGIN).navigation();
    }
}
