package com.appdev.standard.page.document;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class PersonalSpaceFragment_ViewBinding implements Unbinder {
    private PersonalSpaceFragment target;

    @UiThread
    public PersonalSpaceFragment_ViewBinding(PersonalSpaceFragment personalSpaceFragment, View view) {
        this.target = personalSpaceFragment;
        personalSpaceFragment.rvFileType = (RecyclerView) d.findRequiredViewAsType(view, p113u.d.rv_personal_space_file_type, "field 'rvFileType'", RecyclerView.class);
        personalSpaceFragment.flView = (FrameLayout) d.findRequiredViewAsType(view, p113u.d.fl_personal_space_view, "field 'flView'", FrameLayout.class);
        personalSpaceFragment.tvManage = (TextView) d.findRequiredViewAsType(view, p113u.d.tv_personal_space_manage, "field 'tvManage'", TextView.class);
        personalSpaceFragment.llBottomActionBar = (LinearLayout) d.findRequiredViewAsType(view, p113u.d.ll_personal_space_bottom_action_bar, "field 'llBottomActionBar'", LinearLayout.class);
        personalSpaceFragment.ivManageSelect = (ImageView) d.findRequiredViewAsType(view, p113u.d.iv_personal_space_manage_select, "field 'ivManageSelect'", ImageView.class);
        personalSpaceFragment.btnDelete = (TextView) d.findRequiredViewAsType(view, p113u.d.btn_personal_space_delete, "field 'btnDelete'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PersonalSpaceFragment personalSpaceFragment = this.target;
        if (personalSpaceFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        personalSpaceFragment.rvFileType = null;
        personalSpaceFragment.flView = null;
        personalSpaceFragment.tvManage = null;
        personalSpaceFragment.llBottomActionBar = null;
        personalSpaceFragment.ivManageSelect = null;
        personalSpaceFragment.btnDelete = null;
    }
}
