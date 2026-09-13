package com.appdev.standard.page.mine;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ModifyNicknameActivity_ViewBinding implements Unbinder {
    private ModifyNicknameActivity target;

    @UiThread
    public ModifyNicknameActivity_ViewBinding(ModifyNicknameActivity modifyNicknameActivity) {
        this(modifyNicknameActivity, modifyNicknameActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ModifyNicknameActivity modifyNicknameActivity = this.target;
        if (modifyNicknameActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        modifyNicknameActivity.mTvTitle = null;
        modifyNicknameActivity.mEtNickname = null;
    }

    @UiThread
    public ModifyNicknameActivity_ViewBinding(ModifyNicknameActivity modifyNicknameActivity, View view) {
        this.target = modifyNicknameActivity;
        modifyNicknameActivity.mTvTitle = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_title, "field 'mTvTitle'", TextView.class);
        modifyNicknameActivity.mEtNickname = (EditText) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.et_nickname, "field 'mEtNickname'", EditText.class);
    }
}
