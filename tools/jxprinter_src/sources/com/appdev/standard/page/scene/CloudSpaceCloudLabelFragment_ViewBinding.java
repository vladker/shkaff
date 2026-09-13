package com.appdev.standard.page.scene;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import com.library.base.widget.AutoNullDisplayView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class CloudSpaceCloudLabelFragment_ViewBinding implements Unbinder {
    private CloudSpaceCloudLabelFragment target;

    @UiThread
    public CloudSpaceCloudLabelFragment_ViewBinding(CloudSpaceCloudLabelFragment cloudSpaceCloudLabelFragment, View view) {
        this.target = cloudSpaceCloudLabelFragment;
        cloudSpaceCloudLabelFragment.rvFragmentCloudSpaceCloudLabel = (RecyclerView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rv_fragment_cloud_space_cloud_label, "field 'rvFragmentCloudSpaceCloudLabel'", RecyclerView.class);
        cloudSpaceCloudLabelFragment.audvFragmentCloudSpaceCloudLabel = (AutoNullDisplayView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.audv_fragment_cloud_space_cloud_label, "field 'audvFragmentCloudSpaceCloudLabel'", AutoNullDisplayView.class);
        cloudSpaceCloudLabelFragment.srlFragmentCloudSpaceCloudLabel = (SmartRefreshLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.srl_fragment_cloud_space_cloud_label, "field 'srlFragmentCloudSpaceCloudLabel'", SmartRefreshLayout.class);
        cloudSpaceCloudLabelFragment.flRoot = (FrameLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.fl_root, "field 'flRoot'", FrameLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CloudSpaceCloudLabelFragment cloudSpaceCloudLabelFragment = this.target;
        if (cloudSpaceCloudLabelFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        cloudSpaceCloudLabelFragment.rvFragmentCloudSpaceCloudLabel = null;
        cloudSpaceCloudLabelFragment.audvFragmentCloudSpaceCloudLabel = null;
        cloudSpaceCloudLabelFragment.srlFragmentCloudSpaceCloudLabel = null;
        cloudSpaceCloudLabelFragment.flRoot = null;
    }
}
