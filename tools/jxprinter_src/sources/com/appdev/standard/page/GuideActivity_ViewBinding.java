package com.appdev.standard.page;

import android.view.View;
import android.widget.Button;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import com.library.base.widget.EllipseGuideLayout;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class GuideActivity_ViewBinding implements Unbinder {
    private GuideActivity target;

    @UiThread
    public GuideActivity_ViewBinding(GuideActivity guideActivity) {
        this(guideActivity, guideActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        GuideActivity guideActivity = this.target;
        if (guideActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        guideActivity.mGuideViewPager = null;
        guideActivity.mBtnStart = null;
        guideActivity.mEglGuide = null;
    }

    @UiThread
    public GuideActivity_ViewBinding(GuideActivity guideActivity, View view) {
        this.target = guideActivity;
        guideActivity.mGuideViewPager = (ViewPager) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.guide_view_pager, "field 'mGuideViewPager'", ViewPager.class);
        guideActivity.mBtnStart = (Button) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.btn_start, "field 'mBtnStart'", Button.class);
        guideActivity.mEglGuide = (EllipseGuideLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.egl_guide, "field 'mEglGuide'", EllipseGuideLayout.class);
    }
}
