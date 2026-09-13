package com.appdev.standard.page.mine;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class PersonalInfomationActivity_ViewBinding implements Unbinder {
    private PersonalInfomationActivity target;

    @UiThread
    public PersonalInfomationActivity_ViewBinding(PersonalInfomationActivity personalInfomationActivity) {
        this(personalInfomationActivity, personalInfomationActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PersonalInfomationActivity personalInfomationActivity = this.target;
        if (personalInfomationActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        personalInfomationActivity.mTvTitle = null;
        personalInfomationActivity.mIvAvatar = null;
        personalInfomationActivity.mTvNickname = null;
        personalInfomationActivity.mTvPhoneNumber = null;
        personalInfomationActivity.mTtvEmailAddress = null;
        personalInfomationActivity.llPersonalInformationPhone = null;
        personalInfomationActivity.llPersonalInformationEmail = null;
        personalInfomationActivity.tvVersion = null;
        personalInfomationActivity.tvCacheSize = null;
    }

    @UiThread
    public PersonalInfomationActivity_ViewBinding(PersonalInfomationActivity personalInfomationActivity, View view) {
        this.target = personalInfomationActivity;
        personalInfomationActivity.mTvTitle = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_title, "field 'mTvTitle'", TextView.class);
        personalInfomationActivity.mIvAvatar = (ImageView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.iv_avatar, "field 'mIvAvatar'", ImageView.class);
        personalInfomationActivity.mTvNickname = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_nickname, "field 'mTvNickname'", TextView.class);
        personalInfomationActivity.mTvPhoneNumber = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_phone_number, "field 'mTvPhoneNumber'", TextView.class);
        personalInfomationActivity.mTtvEmailAddress = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_email_address, "field 'mTtvEmailAddress'", TextView.class);
        personalInfomationActivity.llPersonalInformationPhone = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_personal_information_phone, "field 'llPersonalInformationPhone'", LinearLayout.class);
        personalInfomationActivity.llPersonalInformationEmail = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_personal_information_email, "field 'llPersonalInformationEmail'", LinearLayout.class);
        personalInfomationActivity.tvVersion = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_version, "field 'tvVersion'", TextView.class);
        personalInfomationActivity.tvCacheSize = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_cache_size, "field 'tvCacheSize'", TextView.class);
    }
}
