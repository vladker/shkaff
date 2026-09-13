package com.appdev.standard.page.auth;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class RegisterActivity_ViewBinding implements Unbinder {
    private RegisterActivity target;

    @UiThread
    public RegisterActivity_ViewBinding(RegisterActivity registerActivity) {
        this(registerActivity, registerActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RegisterActivity registerActivity = this.target;
        if (registerActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        registerActivity.tvTitle = null;
        registerActivity.tvRegisterPhone = null;
        registerActivity.viewRegisterPhone = null;
        registerActivity.tvRegisterEmail = null;
        registerActivity.viewRegisterEmail = null;
        registerActivity.etRegisterPhone = null;
        registerActivity.btnSendPhoneCode = null;
        registerActivity.etRegisterPhoneCode = null;
        registerActivity.etRegisterEmail = null;
        registerActivity.btnSendEmailCode = null;
        registerActivity.etRegisterEmailCode = null;
        registerActivity.llRegisterViewPhone = null;
        registerActivity.llRegisterViewEmail = null;
        registerActivity.llRegisterPhone = null;
        registerActivity.llRegisterEmail = null;
        registerActivity.llRegisterType = null;
        registerActivity.ivLoginAgreement = null;
        registerActivity.tvRegisterAgreement = null;
    }

    @UiThread
    public RegisterActivity_ViewBinding(RegisterActivity registerActivity, View view) {
        this.target = registerActivity;
        registerActivity.tvTitle = (TextView) d.findRequiredViewAsType(view, p113u.d.tv_title, "field 'tvTitle'", TextView.class);
        registerActivity.tvRegisterPhone = (TextView) d.findRequiredViewAsType(view, p113u.d.tv_register_phone, "field 'tvRegisterPhone'", TextView.class);
        registerActivity.viewRegisterPhone = d.findRequiredView(view, p113u.d.view_register_phone, "field 'viewRegisterPhone'");
        registerActivity.tvRegisterEmail = (TextView) d.findRequiredViewAsType(view, p113u.d.tv_register_email, "field 'tvRegisterEmail'", TextView.class);
        registerActivity.viewRegisterEmail = d.findRequiredView(view, p113u.d.view_register_email, "field 'viewRegisterEmail'");
        registerActivity.etRegisterPhone = (EditText) d.findRequiredViewAsType(view, p113u.d.et_register_phone, "field 'etRegisterPhone'", EditText.class);
        registerActivity.btnSendPhoneCode = (Button) d.findRequiredViewAsType(view, p113u.d.btn_send_phone_code, "field 'btnSendPhoneCode'", Button.class);
        registerActivity.etRegisterPhoneCode = (EditText) d.findRequiredViewAsType(view, p113u.d.et_register_phone_code, "field 'etRegisterPhoneCode'", EditText.class);
        registerActivity.etRegisterEmail = (EditText) d.findRequiredViewAsType(view, p113u.d.et_register_email, "field 'etRegisterEmail'", EditText.class);
        registerActivity.btnSendEmailCode = (Button) d.findRequiredViewAsType(view, p113u.d.btn_send_email_code, "field 'btnSendEmailCode'", Button.class);
        registerActivity.etRegisterEmailCode = (EditText) d.findRequiredViewAsType(view, p113u.d.et_register_email_code, "field 'etRegisterEmailCode'", EditText.class);
        registerActivity.llRegisterViewPhone = (LinearLayout) d.findRequiredViewAsType(view, p113u.d.ll_register_view_phone, "field 'llRegisterViewPhone'", LinearLayout.class);
        registerActivity.llRegisterViewEmail = (LinearLayout) d.findRequiredViewAsType(view, p113u.d.ll_register_view_email, "field 'llRegisterViewEmail'", LinearLayout.class);
        registerActivity.llRegisterPhone = (LinearLayout) d.findRequiredViewAsType(view, p113u.d.ll_register_phone, "field 'llRegisterPhone'", LinearLayout.class);
        registerActivity.llRegisterEmail = (LinearLayout) d.findRequiredViewAsType(view, p113u.d.ll_register_email, "field 'llRegisterEmail'", LinearLayout.class);
        registerActivity.llRegisterType = (LinearLayout) d.findRequiredViewAsType(view, p113u.d.ll_register_type, "field 'llRegisterType'", LinearLayout.class);
        registerActivity.ivLoginAgreement = (ImageView) d.findRequiredViewAsType(view, p113u.d.iv_login_agreement, "field 'ivLoginAgreement'", ImageView.class);
        registerActivity.tvRegisterAgreement = (TextView) d.findRequiredViewAsType(view, p113u.d.tv_register_agreement, "field 'tvRegisterAgreement'", TextView.class);
    }
}
