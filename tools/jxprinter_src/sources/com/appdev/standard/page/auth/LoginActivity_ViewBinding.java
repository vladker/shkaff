package com.appdev.standard.page.auth;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class LoginActivity_ViewBinding implements Unbinder {
    private LoginActivity target;

    @UiThread
    public LoginActivity_ViewBinding(LoginActivity loginActivity) {
        this(loginActivity, loginActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        LoginActivity loginActivity = this.target;
        if (loginActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        loginActivity.llLoginIndex = null;
        loginActivity.etLoginUsername = null;
        loginActivity.etLoginPassword = null;
        loginActivity.ivLoginAgreement = null;
        loginActivity.tvLoginAgreement = null;
        loginActivity.ivLoginLanguage = null;
        loginActivity.llDomestic = null;
        loginActivity.llAbroad = null;
        loginActivity.btnShowPassword = null;
    }

    @UiThread
    public LoginActivity_ViewBinding(LoginActivity loginActivity, View view) {
        this.target = loginActivity;
        loginActivity.llLoginIndex = (LinearLayout) d.findRequiredViewAsType(view, p113u.d.ll_login_index, "field 'llLoginIndex'", LinearLayout.class);
        loginActivity.etLoginUsername = (EditText) d.findRequiredViewAsType(view, p113u.d.et_login_username, "field 'etLoginUsername'", EditText.class);
        loginActivity.etLoginPassword = (EditText) d.findRequiredViewAsType(view, p113u.d.et_login_password, "field 'etLoginPassword'", EditText.class);
        loginActivity.ivLoginAgreement = (ImageView) d.findRequiredViewAsType(view, p113u.d.iv_login_agreement, "field 'ivLoginAgreement'", ImageView.class);
        loginActivity.tvLoginAgreement = (TextView) d.findRequiredViewAsType(view, p113u.d.tv_login_agreement, "field 'tvLoginAgreement'", TextView.class);
        loginActivity.ivLoginLanguage = (ImageView) d.findRequiredViewAsType(view, p113u.d.iv_login_language, "field 'ivLoginLanguage'", ImageView.class);
        loginActivity.llDomestic = (LinearLayout) d.findRequiredViewAsType(view, p113u.d.ll_domestic, "field 'llDomestic'", LinearLayout.class);
        loginActivity.llAbroad = (LinearLayout) d.findRequiredViewAsType(view, p113u.d.ll_abroad, "field 'llAbroad'", LinearLayout.class);
        loginActivity.btnShowPassword = (ImageButton) d.findRequiredViewAsType(view, p113u.d.show_password_btn, "field 'btnShowPassword'", ImageButton.class);
    }
}
