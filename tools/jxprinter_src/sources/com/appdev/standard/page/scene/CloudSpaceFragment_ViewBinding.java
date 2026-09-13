package com.appdev.standard.page.scene;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class CloudSpaceFragment_ViewBinding implements Unbinder {
    private CloudSpaceFragment target;
    private View view1339;
    private View view1343;
    private View view150a;
    private View view150b;

    @UiThread
    public CloudSpaceFragment_ViewBinding(final CloudSpaceFragment cloudSpaceFragment, View view) {
        this.target = cloudSpaceFragment;
        cloudSpaceFragment.tvFragmentCloudSpaceCloudLabelNumber = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_fragment_cloud_space_cloud_label_number, "field 'tvFragmentCloudSpaceCloudLabelNumber'", TextView.class);
        cloudSpaceFragment.tvFragmentCloudSpaceCloudLabelContent = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_fragment_cloud_space_cloud_label_content, "field 'tvFragmentCloudSpaceCloudLabelContent'", TextView.class);
        int i5 = p113u.d.ll_fragment_cloud_space_cloud_label;
        View viewFindRequiredView = butterknife.internal.d.findRequiredView(view, i5, "field 'llFragmentCloudSpaceCloudLabel' and method 'onCloudSpaceCloudLabelClick'");
        cloudSpaceFragment.llFragmentCloudSpaceCloudLabel = (LinearLayout) butterknife.internal.d.castView(viewFindRequiredView, i5, "field 'llFragmentCloudSpaceCloudLabel'", LinearLayout.class);
        this.view150a = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.scene.CloudSpaceFragment_ViewBinding.1
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                cloudSpaceFragment.onCloudSpaceCloudLabelClick();
            }
        });
        cloudSpaceFragment.tvFragmentCloudSpaceTeamNumber = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_fragment_cloud_space_team_number, "field 'tvFragmentCloudSpaceTeamNumber'", TextView.class);
        cloudSpaceFragment.tvFragmentCloudSpaceTeamContent = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_fragment_cloud_space_team_content, "field 'tvFragmentCloudSpaceTeamContent'", TextView.class);
        int i6 = p113u.d.ll_fragment_cloud_space_team;
        View viewFindRequiredView2 = butterknife.internal.d.findRequiredView(view, i6, "field 'llFragmentCloudSpaceTeam' and method 'onCloudSpaceTeamClick'");
        cloudSpaceFragment.llFragmentCloudSpaceTeam = (LinearLayout) butterknife.internal.d.castView(viewFindRequiredView2, i6, "field 'llFragmentCloudSpaceTeam'", LinearLayout.class);
        this.view150b = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.scene.CloudSpaceFragment_ViewBinding.2
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                cloudSpaceFragment.onCloudSpaceTeamClick();
            }
        });
        cloudSpaceFragment.llFragmentLayoutBottomActionBar = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_fragment_layout_bottom_action_bar, "field 'llFragmentLayoutBottomActionBar'", LinearLayout.class);
        cloudSpaceFragment.ivCloudSpaceCloudLabelManageSelect = (ImageView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.iv_cloud_space_cloud_label_manage_select, "field 'ivCloudSpaceCloudLabelManageSelect'", ImageView.class);
        cloudSpaceFragment.flTemplatePageView = (FrameLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.fl_template_page_view, "field 'flTemplatePageView'", FrameLayout.class);
        View viewFindRequiredView3 = butterknife.internal.d.findRequiredView(view, p113u.d.btn_delete, "method 'onCloudLabelManageDeleteClick'");
        this.view1339 = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.scene.CloudSpaceFragment_ViewBinding.3
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                cloudSpaceFragment.onCloudLabelManageDeleteClick();
            }
        });
        View viewFindRequiredView4 = butterknife.internal.d.findRequiredView(view, p113u.d.btn_print, "method 'onCloudLabelManagePrinterClick'");
        this.view1343 = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.scene.CloudSpaceFragment_ViewBinding.4
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                cloudSpaceFragment.onCloudLabelManagePrinterClick();
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CloudSpaceFragment cloudSpaceFragment = this.target;
        if (cloudSpaceFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        cloudSpaceFragment.tvFragmentCloudSpaceCloudLabelNumber = null;
        cloudSpaceFragment.tvFragmentCloudSpaceCloudLabelContent = null;
        cloudSpaceFragment.llFragmentCloudSpaceCloudLabel = null;
        cloudSpaceFragment.tvFragmentCloudSpaceTeamNumber = null;
        cloudSpaceFragment.tvFragmentCloudSpaceTeamContent = null;
        cloudSpaceFragment.llFragmentCloudSpaceTeam = null;
        cloudSpaceFragment.llFragmentLayoutBottomActionBar = null;
        cloudSpaceFragment.ivCloudSpaceCloudLabelManageSelect = null;
        cloudSpaceFragment.flTemplatePageView = null;
        this.view150a.setOnClickListener(null);
        this.view150a = null;
        this.view150b.setOnClickListener(null);
        this.view150b = null;
        this.view1339.setOnClickListener(null);
        this.view1339 = null;
        this.view1343.setOnClickListener(null);
        this.view1343 = null;
    }
}
