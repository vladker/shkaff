package com.appdev.standard.page.mine;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class LanguageManagementActivity_ViewBinding implements Unbinder {
    private LanguageManagementActivity target;

    @UiThread
    public LanguageManagementActivity_ViewBinding(LanguageManagementActivity languageManagementActivity) {
        this(languageManagementActivity, languageManagementActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        LanguageManagementActivity languageManagementActivity = this.target;
        if (languageManagementActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        languageManagementActivity.mTvTitle = null;
        languageManagementActivity.mRvLanguageManagement = null;
    }

    @UiThread
    public LanguageManagementActivity_ViewBinding(LanguageManagementActivity languageManagementActivity, View view) {
        this.target = languageManagementActivity;
        languageManagementActivity.mTvTitle = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_title, "field 'mTvTitle'", TextView.class);
        languageManagementActivity.mRvLanguageManagement = (RecyclerView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rv_language_management, "field 'mRvLanguageManagement'", RecyclerView.class);
    }
}
