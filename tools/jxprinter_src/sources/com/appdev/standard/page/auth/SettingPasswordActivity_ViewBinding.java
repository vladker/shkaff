package com.appdev.standard.page.auth;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class SettingPasswordActivity_ViewBinding implements Unbinder {
    private SettingPasswordActivity target;

    @UiThread
    public SettingPasswordActivity_ViewBinding(SettingPasswordActivity settingPasswordActivity) {
        this(settingPasswordActivity, settingPasswordActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SettingPasswordActivity settingPasswordActivity = this.target;
        if (settingPasswordActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        settingPasswordActivity.tvTitle = null;
        settingPasswordActivity.etSettingPassword = null;
        settingPasswordActivity.etSettingAgain = null;
        settingPasswordActivity.btnShowPassword = null;
        settingPasswordActivity.btnShowConfirmPassword = null;
    }

    @UiThread
    public SettingPasswordActivity_ViewBinding(SettingPasswordActivity settingPasswordActivity, View view) {
        this.target = settingPasswordActivity;
        settingPasswordActivity.tvTitle = (TextView) d.findRequiredViewAsType(view, p113u.d.tv_title, "field 'tvTitle'", TextView.class);
        settingPasswordActivity.etSettingPassword = (EditText) d.findRequiredViewAsType(view, p113u.d.et_setting_password, "field 'etSettingPassword'", EditText.class);
        settingPasswordActivity.etSettingAgain = (EditText) d.findRequiredViewAsType(view, p113u.d.et_setting_again, "field 'etSettingAgain'", EditText.class);
        settingPasswordActivity.btnShowPassword = (ImageButton) d.findRequiredViewAsType(view, p113u.d.setting_show_password_btn, "field 'btnShowPassword'", ImageButton.class);
        settingPasswordActivity.btnShowConfirmPassword = (ImageButton) d.findRequiredViewAsType(view, p113u.d.show_confirm_password_btn, "field 'btnShowConfirmPassword'", ImageButton.class);
    }
}
