package com.appdev.standard.page.auth;

import A.c;
import W.b;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.api.AuthorityApi;
import com.appdev.standard.api.pto.ResetPasswordPto;
import com.library.base.frame.MvpActivity;
import com.library.base.util.http.Http;
import kotlin.jvm.internal.Y;
import p042h2.d;
import p050j.w;
import p051j0.i;
import p113u.e;
import p113u.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = DefaultRouteConstant.ACTIVITY_FORGET_SETTING_PASSWORD)
public class ForgetSettingPasswordActivity extends MvpActivity implements W.a {
    private int accountType;
    private String code;

    @BindView(5080)
    EditText etSettingAgain;

    @BindView(5081)
    EditText etSettingPassword;
    private b resetPasswordWorker;

    @BindView(6274)
    TextView tvTitle;
    private String username;

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initComponent() {
        super.initComponent();
        this.tvTitle.setText(getString(g.setting_the_password));
        b bVar = new b(this);
        bVar.d = null;
        bVar.d = (AuthorityApi) Http.createApi(AuthorityApi.class);
        this.resetPasswordWorker = bVar;
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
        return e.activity_forget_setting_password;
    }

    public void onConfirmClick(View view) {
        w.e();
        b bVar = this.resetPasswordWorker;
        int i5 = this.accountType;
        String str = this.code;
        String strF = androidx.exifinterface.media.a.f(this.etSettingPassword);
        String strF2 = androidx.exifinterface.media.a.f(this.etSettingAgain);
        String str2 = this.username;
        if (Y.f(str2)) {
            Object obj = bVar.b;
            if (obj != null) {
                ((W.a) obj).resetPasswordFailed(1, bVar.getString(g.The_account_cannot_be_empty));
                return;
            }
            return;
        }
        if (Y.f(strF)) {
            Object obj2 = bVar.b;
            if (obj2 != null) {
                ((W.a) obj2).resetPasswordFailed(1, bVar.getString(g.The_password_cannot_be_empty));
                return;
            }
            return;
        }
        bVar.getClass();
        if (!strF.equals(strF2)) {
            Object obj3 = bVar.b;
            if (obj3 != null) {
                ((W.a) obj3).resetPasswordFailed(1, bVar.getString(g.Two_different_passwords));
                return;
            }
            return;
        }
        if (Y.f(str)) {
            Object obj4 = bVar.b;
            if (obj4 != null) {
                ((W.a) obj4).resetPasswordFailed(1, bVar.getString(g.The_verification_code_cannot_be_empty));
                return;
            }
            return;
        }
        boolean z6 = false;
        boolean z7 = false;
        for (int i6 = 0; i6 < strF.length(); i6++) {
            if (Character.isDigit(strF.charAt(i6))) {
                z6 = true;
            }
            if (Character.isLetter(strF.charAt(i6))) {
                z7 = true;
            }
        }
        if (z6 && z7 && strF.matches("^[a-zA-Z0-9]+$")) {
            bVar.d.resetPassword(new ResetPasswordPto(i5, str, i.b(strF), str2)).b(new c(bVar, 24));
            return;
        }
        Object obj5 = bVar.b;
        if (obj5 != null) {
            ((W.a) obj5).resetPasswordFailed(1, bVar.getString(g.The_password_must_contain_at_least_two_characters));
        }
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void receiveDataFromPreActivity(Bundle bundle) {
        super.receiveDataFromPreActivity(bundle);
        this.accountType = bundle.getInt("accountType");
        this.username = bundle.getString("username");
        this.code = bundle.getString("code");
    }

    @Override // W.a
    public void resetPasswordFailed(int i5, String str) {
        w.c();
        d.a(str);
    }

    @Override // W.a
    public void resetPasswordSuccess() {
        w.c();
        d.show(g.reset_password_success);
        ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_LOGIN).navigation();
    }
}
