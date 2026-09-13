package com.appdev.standard.page.mine;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import com.library.base.widget.AutoNullDisplayView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class HelpCenterActivity_ViewBinding implements Unbinder {
    private HelpCenterActivity target;
    private View view1811;
    private View view1886;

    @UiThread
    public HelpCenterActivity_ViewBinding(HelpCenterActivity helpCenterActivity) {
        this(helpCenterActivity, helpCenterActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        HelpCenterActivity helpCenterActivity = this.target;
        if (helpCenterActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        helpCenterActivity.tvTitle = null;
        helpCenterActivity.etHelpCenterSearchContent = null;
        helpCenterActivity.rvHelpCenter = null;
        helpCenterActivity.audvHelpCenter = null;
        helpCenterActivity.srlHelpCenter = null;
        helpCenterActivity.mTvVideos = null;
        helpCenterActivity.mTvManual = null;
        helpCenterActivity.mVBottomLine = null;
        helpCenterActivity.mVManualLine = null;
        helpCenterActivity.mVVideosLine = null;
        this.view1886.setOnClickListener(null);
        this.view1886 = null;
        this.view1811.setOnClickListener(null);
        this.view1811 = null;
    }

    @UiThread
    public HelpCenterActivity_ViewBinding(final HelpCenterActivity helpCenterActivity, View view) {
        this.target = helpCenterActivity;
        helpCenterActivity.tvTitle = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_title, "field 'tvTitle'", TextView.class);
        helpCenterActivity.etHelpCenterSearchContent = (EditText) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.et_help_center_search_content, "field 'etHelpCenterSearchContent'", EditText.class);
        helpCenterActivity.rvHelpCenter = (RecyclerView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rv_help_center, "field 'rvHelpCenter'", RecyclerView.class);
        helpCenterActivity.audvHelpCenter = (AutoNullDisplayView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.audv_help_center, "field 'audvHelpCenter'", AutoNullDisplayView.class);
        helpCenterActivity.srlHelpCenter = (SmartRefreshLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.srl_help_center, "field 'srlHelpCenter'", SmartRefreshLayout.class);
        int i5 = p113u.d.tv_videos;
        View viewFindRequiredView = butterknife.internal.d.findRequiredView(view, i5, "field 'mTvVideos' and method 'onTabClick'");
        helpCenterActivity.mTvVideos = (TextView) butterknife.internal.d.castView(viewFindRequiredView, i5, "field 'mTvVideos'", TextView.class);
        this.view1886 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.mine.HelpCenterActivity_ViewBinding.1
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                helpCenterActivity.onTabClick(view2);
            }
        });
        int i6 = p113u.d.tv_manual;
        View viewFindRequiredView2 = butterknife.internal.d.findRequiredView(view, i6, "field 'mTvManual' and method 'onTabClick'");
        helpCenterActivity.mTvManual = (TextView) butterknife.internal.d.castView(viewFindRequiredView2, i6, "field 'mTvManual'", TextView.class);
        this.view1811 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.mine.HelpCenterActivity_ViewBinding.2
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                helpCenterActivity.onTabClick(view2);
            }
        });
        helpCenterActivity.mVBottomLine = butterknife.internal.d.findRequiredView(view, p113u.d.v_bottom_line, "field 'mVBottomLine'");
        helpCenterActivity.mVManualLine = butterknife.internal.d.findRequiredView(view, p113u.d.v_manual_line, "field 'mVManualLine'");
        helpCenterActivity.mVVideosLine = butterknife.internal.d.findRequiredView(view, p113u.d.v_videos_line, "field 'mVVideosLine'");
    }
}
