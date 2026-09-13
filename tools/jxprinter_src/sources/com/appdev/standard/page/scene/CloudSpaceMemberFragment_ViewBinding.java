package com.appdev.standard.page.scene;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class CloudSpaceMemberFragment_ViewBinding implements Unbinder {
    private CloudSpaceMemberFragment target;

    @UiThread
    public CloudSpaceMemberFragment_ViewBinding(CloudSpaceMemberFragment cloudSpaceMemberFragment, View view) {
        this.target = cloudSpaceMemberFragment;
        cloudSpaceMemberFragment.rvFragmentCloudSpaceTeam = (RecyclerView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rv_fragment_cloud_space_member, "field 'rvFragmentCloudSpaceTeam'", RecyclerView.class);
        cloudSpaceMemberFragment.srlFragmentCloudSpaceTeam = (SmartRefreshLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.srl_fragment_cloud_space_member, "field 'srlFragmentCloudSpaceTeam'", SmartRefreshLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CloudSpaceMemberFragment cloudSpaceMemberFragment = this.target;
        if (cloudSpaceMemberFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        cloudSpaceMemberFragment.rvFragmentCloudSpaceTeam = null;
        cloudSpaceMemberFragment.srlFragmentCloudSpaceTeam = null;
    }
}
