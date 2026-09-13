package com.appdev.standard.page.scene;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
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
public class CloudSpaceCloudLabelManageActivity_ViewBinding implements Unbinder {
    private CloudSpaceCloudLabelManageActivity target;

    @UiThread
    public CloudSpaceCloudLabelManageActivity_ViewBinding(CloudSpaceCloudLabelManageActivity cloudSpaceCloudLabelManageActivity) {
        this(cloudSpaceCloudLabelManageActivity, cloudSpaceCloudLabelManageActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CloudSpaceCloudLabelManageActivity cloudSpaceCloudLabelManageActivity = this.target;
        if (cloudSpaceCloudLabelManageActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        cloudSpaceCloudLabelManageActivity.llCloudSpaceCloudLabelManageRootView = null;
        cloudSpaceCloudLabelManageActivity.tvTitle = null;
        cloudSpaceCloudLabelManageActivity.ivCloudSpaceCloudLabelManageSelect = null;
        cloudSpaceCloudLabelManageActivity.tvCloudSpaceCloudLabelManageSelect = null;
        cloudSpaceCloudLabelManageActivity.tvCloudSpaceCloudLabelManageNumber = null;
        cloudSpaceCloudLabelManageActivity.tvCloudSpaceCloudLabelManageTeamNumber = null;
        cloudSpaceCloudLabelManageActivity.rvCloudSpaceCloudLabelManageCloudLabel = null;
        cloudSpaceCloudLabelManageActivity.audvCloudSpaceCloudLabelManageCloudLabel = null;
        cloudSpaceCloudLabelManageActivity.srlCloudSpaceCloudLabelManageCloudLabel = null;
        cloudSpaceCloudLabelManageActivity.flTemplatePageView = null;
        cloudSpaceCloudLabelManageActivity.llView = null;
        cloudSpaceCloudLabelManageActivity.llManageDelete = null;
    }

    @UiThread
    public CloudSpaceCloudLabelManageActivity_ViewBinding(CloudSpaceCloudLabelManageActivity cloudSpaceCloudLabelManageActivity, View view) {
        this.target = cloudSpaceCloudLabelManageActivity;
        cloudSpaceCloudLabelManageActivity.llCloudSpaceCloudLabelManageRootView = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_cloud_space_cloud_label_manage_root_view, "field 'llCloudSpaceCloudLabelManageRootView'", LinearLayout.class);
        cloudSpaceCloudLabelManageActivity.tvTitle = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_title, "field 'tvTitle'", TextView.class);
        cloudSpaceCloudLabelManageActivity.ivCloudSpaceCloudLabelManageSelect = (ImageView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.iv_cloud_space_cloud_label_manage_select, "field 'ivCloudSpaceCloudLabelManageSelect'", ImageView.class);
        cloudSpaceCloudLabelManageActivity.tvCloudSpaceCloudLabelManageSelect = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_cloud_space_cloud_label_manage_select, "field 'tvCloudSpaceCloudLabelManageSelect'", TextView.class);
        cloudSpaceCloudLabelManageActivity.tvCloudSpaceCloudLabelManageNumber = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_cloud_space_cloud_label_manage_number, "field 'tvCloudSpaceCloudLabelManageNumber'", TextView.class);
        cloudSpaceCloudLabelManageActivity.tvCloudSpaceCloudLabelManageTeamNumber = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_cloud_space_cloud_label_manage_team_number, "field 'tvCloudSpaceCloudLabelManageTeamNumber'", TextView.class);
        cloudSpaceCloudLabelManageActivity.rvCloudSpaceCloudLabelManageCloudLabel = (RecyclerView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rv_cloud_space_cloud_label_manage_cloud_label, "field 'rvCloudSpaceCloudLabelManageCloudLabel'", RecyclerView.class);
        cloudSpaceCloudLabelManageActivity.audvCloudSpaceCloudLabelManageCloudLabel = (AutoNullDisplayView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.audv_cloud_space_cloud_label_manage_cloud_label, "field 'audvCloudSpaceCloudLabelManageCloudLabel'", AutoNullDisplayView.class);
        cloudSpaceCloudLabelManageActivity.srlCloudSpaceCloudLabelManageCloudLabel = (SmartRefreshLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.srl_cloud_space_cloud_label_manage_cloud_label, "field 'srlCloudSpaceCloudLabelManageCloudLabel'", SmartRefreshLayout.class);
        cloudSpaceCloudLabelManageActivity.flTemplatePageView = (FrameLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.fl_template_page_view, "field 'flTemplatePageView'", FrameLayout.class);
        cloudSpaceCloudLabelManageActivity.llView = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_view, "field 'llView'", LinearLayout.class);
        cloudSpaceCloudLabelManageActivity.llManageDelete = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_manage_delete, "field 'llManageDelete'", LinearLayout.class);
    }
}
