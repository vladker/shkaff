package com.appdev.standard.page.mine;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import com.library.base.widget.AutoNullDisplayView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class MemberCenterActivity_ViewBinding implements Unbinder {
    private MemberCenterActivity target;

    @UiThread
    public MemberCenterActivity_ViewBinding(MemberCenterActivity memberCenterActivity) {
        this(memberCenterActivity, memberCenterActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MemberCenterActivity memberCenterActivity = this.target;
        if (memberCenterActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        memberCenterActivity.llMemberCenterCurrent = null;
        memberCenterActivity.tvMemberCenterCurrentMemberName = null;
        memberCenterActivity.tvMemberCenterCurrentMemberTime = null;
        memberCenterActivity.tvMemberCenterSelectMemberName = null;
        memberCenterActivity.rvMemberCenterMemberData = null;
        memberCenterActivity.audvMemberCenter = null;
        memberCenterActivity.srlMemberCenter = null;
        memberCenterActivity.llMemberCenterBottom = null;
    }

    @UiThread
    public MemberCenterActivity_ViewBinding(MemberCenterActivity memberCenterActivity, View view) {
        this.target = memberCenterActivity;
        memberCenterActivity.llMemberCenterCurrent = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_member_center_current, "field 'llMemberCenterCurrent'", LinearLayout.class);
        memberCenterActivity.tvMemberCenterCurrentMemberName = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_member_center_current_member_name, "field 'tvMemberCenterCurrentMemberName'", TextView.class);
        memberCenterActivity.tvMemberCenterCurrentMemberTime = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_member_center_current_member_time, "field 'tvMemberCenterCurrentMemberTime'", TextView.class);
        memberCenterActivity.tvMemberCenterSelectMemberName = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_member_center_select_member_name, "field 'tvMemberCenterSelectMemberName'", TextView.class);
        memberCenterActivity.rvMemberCenterMemberData = (RecyclerView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rv_member_center_member_data, "field 'rvMemberCenterMemberData'", RecyclerView.class);
        memberCenterActivity.audvMemberCenter = (AutoNullDisplayView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.audv_member_center, "field 'audvMemberCenter'", AutoNullDisplayView.class);
        memberCenterActivity.srlMemberCenter = (SmartRefreshLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.srl_member_center, "field 'srlMemberCenter'", SmartRefreshLayout.class);
        memberCenterActivity.llMemberCenterBottom = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_member_center_bottom, "field 'llMemberCenterBottom'", LinearLayout.class);
    }
}
