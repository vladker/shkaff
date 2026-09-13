package com.appdev.standard.page.quickprinting;

import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.d;
import com.library.base.widget.AutoNullDisplayView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class QuickPrintingActivity_ViewBinding implements Unbinder {
    private QuickPrintingActivity target;

    @UiThread
    public QuickPrintingActivity_ViewBinding(QuickPrintingActivity quickPrintingActivity) {
        this(quickPrintingActivity, quickPrintingActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        QuickPrintingActivity quickPrintingActivity = this.target;
        if (quickPrintingActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        quickPrintingActivity.tvTitle = null;
        quickPrintingActivity.srlMineLabel = null;
        quickPrintingActivity.audvMineLabel = null;
        quickPrintingActivity.rvMineLabel = null;
        quickPrintingActivity.srlMyDoc = null;
        quickPrintingActivity.audvMyDoc = null;
        quickPrintingActivity.rvMyDoc = null;
        quickPrintingActivity.rvSelectLabel = null;
        quickPrintingActivity.llHasSelectLabel = null;
        quickPrintingActivity.tvSelectLabelNum = null;
        quickPrintingActivity.tvShowMore = null;
        quickPrintingActivity.ivShowMore = null;
        quickPrintingActivity.llSelectLabelNum = null;
        quickPrintingActivity.llDetails = null;
        quickPrintingActivity.flTemplatePageView = null;
        quickPrintingActivity.llWarn = null;
        quickPrintingActivity.tvPrintPagePrint = null;
        quickPrintingActivity.etSearch = null;
        quickPrintingActivity.tvSearch = null;
    }

    @UiThread
    public QuickPrintingActivity_ViewBinding(QuickPrintingActivity quickPrintingActivity, View view) {
        this.target = quickPrintingActivity;
        quickPrintingActivity.tvTitle = (TextView) d.findRequiredViewAsType(view, p113u.d.tv_title, "field 'tvTitle'", TextView.class);
        quickPrintingActivity.srlMineLabel = (SmartRefreshLayout) d.findRequiredViewAsType(view, p113u.d.srl_mine_label, "field 'srlMineLabel'", SmartRefreshLayout.class);
        quickPrintingActivity.audvMineLabel = (AutoNullDisplayView) d.findRequiredViewAsType(view, p113u.d.audv_mine_label, "field 'audvMineLabel'", AutoNullDisplayView.class);
        quickPrintingActivity.rvMineLabel = (RecyclerView) d.findRequiredViewAsType(view, p113u.d.rv_mine_label, "field 'rvMineLabel'", RecyclerView.class);
        quickPrintingActivity.srlMyDoc = (SmartRefreshLayout) d.findRequiredViewAsType(view, p113u.d.srl_my_doc, "field 'srlMyDoc'", SmartRefreshLayout.class);
        quickPrintingActivity.audvMyDoc = (AutoNullDisplayView) d.findRequiredViewAsType(view, p113u.d.audv_my_doc, "field 'audvMyDoc'", AutoNullDisplayView.class);
        quickPrintingActivity.rvMyDoc = (RecyclerView) d.findRequiredViewAsType(view, p113u.d.rv_my_doc, "field 'rvMyDoc'", RecyclerView.class);
        quickPrintingActivity.rvSelectLabel = (RecyclerView) d.findRequiredViewAsType(view, p113u.d.rv_select_label, "field 'rvSelectLabel'", RecyclerView.class);
        quickPrintingActivity.llHasSelectLabel = (LinearLayout) d.findRequiredViewAsType(view, p113u.d.ll_has_select_label, "field 'llHasSelectLabel'", LinearLayout.class);
        quickPrintingActivity.tvSelectLabelNum = (TextView) d.findRequiredViewAsType(view, p113u.d.tv_select_label_num, "field 'tvSelectLabelNum'", TextView.class);
        quickPrintingActivity.tvShowMore = (TextView) d.findRequiredViewAsType(view, p113u.d.tv_show_more, "field 'tvShowMore'", TextView.class);
        quickPrintingActivity.ivShowMore = (ImageView) d.findRequiredViewAsType(view, p113u.d.iv_show_more, "field 'ivShowMore'", ImageView.class);
        quickPrintingActivity.llSelectLabelNum = (LinearLayout) d.findRequiredViewAsType(view, p113u.d.ll_select_label_num, "field 'llSelectLabelNum'", LinearLayout.class);
        quickPrintingActivity.llDetails = (LinearLayout) d.findRequiredViewAsType(view, p113u.d.ll_details, "field 'llDetails'", LinearLayout.class);
        quickPrintingActivity.flTemplatePageView = (FrameLayout) d.findRequiredViewAsType(view, p113u.d.fl_template_page_view, "field 'flTemplatePageView'", FrameLayout.class);
        quickPrintingActivity.llWarn = (LinearLayout) d.findRequiredViewAsType(view, p113u.d.ll_warn, "field 'llWarn'", LinearLayout.class);
        quickPrintingActivity.tvPrintPagePrint = (TextView) d.findRequiredViewAsType(view, p113u.d.tv_print_page_print, "field 'tvPrintPagePrint'", TextView.class);
        quickPrintingActivity.etSearch = (EditText) d.findRequiredViewAsType(view, p113u.d.et_fragment_mine_label_search, "field 'etSearch'", EditText.class);
        quickPrintingActivity.tvSearch = (TextView) d.findRequiredViewAsType(view, p113u.d.tv_fragment_mine_label_search, "field 'tvSearch'", TextView.class);
    }
}
