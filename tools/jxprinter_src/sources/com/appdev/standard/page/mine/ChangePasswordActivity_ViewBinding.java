package com.appdev.standard.page.mine;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ChangePasswordActivity_ViewBinding implements Unbinder {
    private ChangePasswordActivity target;

    @UiThread
    public ChangePasswordActivity_ViewBinding(ChangePasswordActivity changePasswordActivity) {
        this(changePasswordActivity, changePasswordActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ChangePasswordActivity changePasswordActivity = this.target;
        if (changePasswordActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        changePasswordActivity.mTvTitle = null;
        changePasswordActivity.mEtOldPassword = null;
        changePasswordActivity.mEtPassword = null;
        changePasswordActivity.mEtPasswordAgain = null;
        changePasswordActivity.btnShowPassword = null;
        changePasswordActivity.btnShowNewPassword = null;
        changePasswordActivity.btnShowConfirmPassword = null;
    }

    @UiThread
    public ChangePasswordActivity_ViewBinding(ChangePasswordActivity changePasswordActivity, View view) {
        this.target = changePasswordActivity;
        changePasswordActivity.mTvTitle = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_title, "field 'mTvTitle'", TextView.class);
        changePasswordActivity.mEtOldPassword = (EditText) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.et_old_password, "field 'mEtOldPassword'", EditText.class);
        changePasswordActivity.mEtPassword = (EditText) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.et_password, "field 'mEtPassword'", EditText.class);
        changePasswordActivity.mEtPasswordAgain = (EditText) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.et_password_again, "field 'mEtPasswordAgain'", EditText.class);
        changePasswordActivity.btnShowPassword = (ImageButton) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.show_password_btn, "field 'btnShowPassword'", ImageButton.class);
        changePasswordActivity.btnShowNewPassword = (ImageButton) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.show_new_password_btn, "field 'btnShowNewPassword'", ImageButton.class);
        changePasswordActivity.btnShowConfirmPassword = (ImageButton) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.show_confirm_password_btn, "field 'btnShowConfirmPassword'", ImageButton.class);
    }
}
