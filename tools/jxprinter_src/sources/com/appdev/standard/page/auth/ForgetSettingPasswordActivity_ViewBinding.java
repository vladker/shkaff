package com.appdev.standard.page.auth;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ForgetSettingPasswordActivity_ViewBinding implements Unbinder {
    private ForgetSettingPasswordActivity target;

    @UiThread
    public ForgetSettingPasswordActivity_ViewBinding(ForgetSettingPasswordActivity forgetSettingPasswordActivity) {
        this(forgetSettingPasswordActivity, forgetSettingPasswordActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ForgetSettingPasswordActivity forgetSettingPasswordActivity = this.target;
        if (forgetSettingPasswordActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        forgetSettingPasswordActivity.tvTitle = null;
        forgetSettingPasswordActivity.etSettingPassword = null;
        forgetSettingPasswordActivity.etSettingAgain = null;
    }

    @UiThread
    public ForgetSettingPasswordActivity_ViewBinding(ForgetSettingPasswordActivity forgetSettingPasswordActivity, View view) {
        this.target = forgetSettingPasswordActivity;
        forgetSettingPasswordActivity.tvTitle = (TextView) d.findRequiredViewAsType(view, p113u.d.tv_title, "field 'tvTitle'", TextView.class);
        forgetSettingPasswordActivity.etSettingPassword = (EditText) d.findRequiredViewAsType(view, p113u.d.et_setting_password, "field 'etSettingPassword'", EditText.class);
        forgetSettingPasswordActivity.etSettingAgain = (EditText) d.findRequiredViewAsType(view, p113u.d.et_setting_again, "field 'etSettingAgain'", EditText.class);
    }
}
