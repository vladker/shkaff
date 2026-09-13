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
public class ChangeUserNameEmailActivity_ViewBinding implements Unbinder {
    private ChangeUserNameEmailActivity target;

    @UiThread
    public ChangeUserNameEmailActivity_ViewBinding(ChangeUserNameEmailActivity changeUserNameEmailActivity) {
        this(changeUserNameEmailActivity, changeUserNameEmailActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ChangeUserNameEmailActivity changeUserNameEmailActivity = this.target;
        if (changeUserNameEmailActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        changeUserNameEmailActivity.tvTitle = null;
        changeUserNameEmailActivity.llChangeUserNamePassword = null;
        changeUserNameEmailActivity.llChangeUserNameUsername = null;
        changeUserNameEmailActivity.etChangeUserNamePassword = null;
        changeUserNameEmailActivity.tvChangeUserNameNext = null;
        changeUserNameEmailActivity.etUsername = null;
        changeUserNameEmailActivity.btnSendEmailCode = null;
        changeUserNameEmailActivity.etEmailCode = null;
    }

    @UiThread
    public ChangeUserNameEmailActivity_ViewBinding(ChangeUserNameEmailActivity changeUserNameEmailActivity, View view) {
        this.target = changeUserNameEmailActivity;
        changeUserNameEmailActivity.tvTitle = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_title, "field 'tvTitle'", TextView.class);
        changeUserNameEmailActivity.llChangeUserNamePassword = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_change_user_name_password, "field 'llChangeUserNamePassword'", LinearLayout.class);
        changeUserNameEmailActivity.llChangeUserNameUsername = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_change_user_name_username, "field 'llChangeUserNameUsername'", LinearLayout.class);
        changeUserNameEmailActivity.etChangeUserNamePassword = (EditText) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.et_change_user_name_password, "field 'etChangeUserNamePassword'", EditText.class);
        changeUserNameEmailActivity.tvChangeUserNameNext = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_change_user_name_next, "field 'tvChangeUserNameNext'", TextView.class);
        changeUserNameEmailActivity.etUsername = (EditText) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.et_username, "field 'etUsername'", EditText.class);
        changeUserNameEmailActivity.btnSendEmailCode = (Button) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.btn_send_email_code, "field 'btnSendEmailCode'", Button.class);
        changeUserNameEmailActivity.etEmailCode = (EditText) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.et_email_code, "field 'etEmailCode'", EditText.class);
    }
}
