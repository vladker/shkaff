package com.appdev.standard.page.mine;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ChangeUserNamePhoneActivity_ViewBinding implements Unbinder {
    private ChangeUserNamePhoneActivity target;

    @UiThread
    public ChangeUserNamePhoneActivity_ViewBinding(ChangeUserNamePhoneActivity changeUserNamePhoneActivity) {
        this(changeUserNamePhoneActivity, changeUserNamePhoneActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ChangeUserNamePhoneActivity changeUserNamePhoneActivity = this.target;
        if (changeUserNamePhoneActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        changeUserNamePhoneActivity.tvTitle = null;
        changeUserNamePhoneActivity.llChangeUserNamePassword = null;
        changeUserNamePhoneActivity.llChangeUserNameUsername = null;
        changeUserNamePhoneActivity.etChangeUserNamePassword = null;
        changeUserNamePhoneActivity.tvChangeUserNameNext = null;
        changeUserNamePhoneActivity.etUsername = null;
        changeUserNamePhoneActivity.btnSendPhoneCode = null;
        changeUserNamePhoneActivity.etPhoneCode = null;
    }

    @UiThread
    public ChangeUserNamePhoneActivity_ViewBinding(ChangeUserNamePhoneActivity changeUserNamePhoneActivity, View view) {
        this.target = changeUserNamePhoneActivity;
        changeUserNamePhoneActivity.tvTitle = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_title, "field 'tvTitle'", TextView.class);
        changeUserNamePhoneActivity.llChangeUserNamePassword = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_change_user_name_password, "field 'llChangeUserNamePassword'", LinearLayout.class);
        changeUserNamePhoneActivity.llChangeUserNameUsername = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_change_user_name_username, "field 'llChangeUserNameUsername'", LinearLayout.class);
        changeUserNamePhoneActivity.etChangeUserNamePassword = (EditText) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.et_change_user_name_password, "field 'etChangeUserNamePassword'", EditText.class);
        changeUserNamePhoneActivity.tvChangeUserNameNext = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_change_user_name_next, "field 'tvChangeUserNameNext'", TextView.class);
        changeUserNamePhoneActivity.etUsername = (EditText) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.et_username, "field 'etUsername'", EditText.class);
        changeUserNamePhoneActivity.btnSendPhoneCode = (Button) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.btn_send_phone_code, "field 'btnSendPhoneCode'", Button.class);
        changeUserNamePhoneActivity.etPhoneCode = (EditText) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.et_phone_code, "field 'etPhoneCode'", EditText.class);
    }
}
