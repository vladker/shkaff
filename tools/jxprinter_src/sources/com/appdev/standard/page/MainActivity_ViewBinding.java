package com.appdev.standard.page;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.appdev.standard.widget.BottomTabWidget;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class MainActivity_ViewBinding implements Unbinder {
    private MainActivity target;

    @UiThread
    public MainActivity_ViewBinding(MainActivity mainActivity) {
        this(mainActivity, mainActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MainActivity mainActivity = this.target;
        if (mainActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        mainActivity.mFlIndex = null;
        mainActivity.mBtwIndex = null;
        mainActivity.flTemplatePageView = null;
    }

    @UiThread
    public MainActivity_ViewBinding(MainActivity mainActivity, View view) {
        this.target = mainActivity;
        mainActivity.mFlIndex = (FrameLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.fl_index, "field 'mFlIndex'", FrameLayout.class);
        mainActivity.mBtwIndex = (BottomTabWidget) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.btw_index, "field 'mBtwIndex'", BottomTabWidget.class);
        mainActivity.flTemplatePageView = (FrameLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.fl_template_page_view, "field 'flTemplatePageView'", FrameLayout.class);
    }
}
