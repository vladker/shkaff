package com.appdev.standard.page.auth;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ResetPasswordActivity_ViewBinding implements Unbinder {
    private ResetPasswordActivity target;

    @UiThread
    public ResetPasswordActivity_ViewBinding(ResetPasswordActivity resetPasswordActivity) {
        this(resetPasswordActivity, resetPasswordActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ResetPasswordActivity resetPasswordActivity = this.target;
        if (resetPasswordActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        resetPasswordActivity.tvTitle = null;
        resetPasswordActivity.tvResetPasswordPhone = null;
        resetPasswordActivity.viewResetPasswordPhone = null;
        resetPasswordActivity.tvResetPasswordEmail = null;
        resetPasswordActivity.viewResetPasswordEmail = null;
        resetPasswordActivity.etResetPasswordPhone = null;
        resetPasswordActivity.btnSendPhoneCode = null;
        resetPasswordActivity.etResetPasswordPhoneCode = null;
        resetPasswordActivity.llResetPasswordViewPhone = null;
        resetPasswordActivity.etResetPasswordEmail = null;
        resetPasswordActivity.btnSendEmailCode = null;
        resetPasswordActivity.etResetPasswordEmailCode = null;
        resetPasswordActivity.llResetPasswordViewEmail = null;
        resetPasswordActivity.llResetPasswordType = null;
    }

    @UiThread
    public ResetPasswordActivity_ViewBinding(ResetPasswordActivity resetPasswordActivity, View view) {
        this.target = resetPasswordActivity;
        resetPasswordActivity.tvTitle = (TextView) d.findRequiredViewAsType(view, p113u.d.tv_title, "field 'tvTitle'", TextView.class);
        resetPasswordActivity.tvResetPasswordPhone = (TextView) d.findRequiredViewAsType(view, p113u.d.tv_reset_password_phone, "field 'tvResetPasswordPhone'", TextView.class);
        resetPasswordActivity.viewResetPasswordPhone = d.findRequiredView(view, p113u.d.view_reset_password_phone, "field 'viewResetPasswordPhone'");
        resetPasswordActivity.tvResetPasswordEmail = (TextView) d.findRequiredViewAsType(view, p113u.d.tv_reset_password_email, "field 'tvResetPasswordEmail'", TextView.class);
        resetPasswordActivity.viewResetPasswordEmail = d.findRequiredView(view, p113u.d.view_reset_password_email, "field 'viewResetPasswordEmail'");
        resetPasswordActivity.etResetPasswordPhone = (EditText) d.findRequiredViewAsType(view, p113u.d.et_reset_password_phone, "field 'etResetPasswordPhone'", EditText.class);
        resetPasswordActivity.btnSendPhoneCode = (Button) d.findRequiredViewAsType(view, p113u.d.btn_send_phone_code, "field 'btnSendPhoneCode'", Button.class);
        resetPasswordActivity.etResetPasswordPhoneCode = (EditText) d.findRequiredViewAsType(view, p113u.d.et_reset_password_phone_code, "field 'etResetPasswordPhoneCode'", EditText.class);
        resetPasswordActivity.llResetPasswordViewPhone = (LinearLayout) d.findRequiredViewAsType(view, p113u.d.ll_reset_password_view_phone, "field 'llResetPasswordViewPhone'", LinearLayout.class);
        resetPasswordActivity.etResetPasswordEmail = (EditText) d.findRequiredViewAsType(view, p113u.d.et_reset_password_email, "field 'etResetPasswordEmail'", EditText.class);
        resetPasswordActivity.btnSendEmailCode = (Button) d.findRequiredViewAsType(view, p113u.d.btn_send_email_code, "field 'btnSendEmailCode'", Button.class);
        resetPasswordActivity.etResetPasswordEmailCode = (EditText) d.findRequiredViewAsType(view, p113u.d.et_reset_password_email_code, "field 'etResetPasswordEmailCode'", EditText.class);
        resetPasswordActivity.llResetPasswordViewEmail = (LinearLayout) d.findRequiredViewAsType(view, p113u.d.ll_reset_password_view_email, "field 'llResetPasswordViewEmail'", LinearLayout.class);
        resetPasswordActivity.llResetPasswordType = (LinearLayout) d.findRequiredViewAsType(view, p113u.d.ll_reset_password_type, "field 'llResetPasswordType'", LinearLayout.class);
    }
}
