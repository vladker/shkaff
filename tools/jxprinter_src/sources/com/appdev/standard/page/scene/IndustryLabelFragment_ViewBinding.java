package com.appdev.standard.page.scene;

import android.view.View;
import android.widget.EditText;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import com.library.base.widget.AutoNullDisplayView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class IndustryLabelFragment_ViewBinding implements Unbinder {
    private IndustryLabelFragment target;
    private View view17cd;

    @UiThread
    public IndustryLabelFragment_ViewBinding(final IndustryLabelFragment industryLabelFragment, View view) {
        this.target = industryLabelFragment;
        industryLabelFragment.etFragmentIndustryLabelSearch = (EditText) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.et_fragment_industry_label_search, "field 'etFragmentIndustryLabelSearch'", EditText.class);
        industryLabelFragment.rvFragmentIndustryLabelSpecifications = (RecyclerView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rv_fragment_industry_label_specifications, "field 'rvFragmentIndustryLabelSpecifications'", RecyclerView.class);
        industryLabelFragment.rvFragmentIndustryLabelType = (RecyclerView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rv_fragment_industry_label_type, "field 'rvFragmentIndustryLabelType'", RecyclerView.class);
        industryLabelFragment.srlFragmentIndustryLabel = (SmartRefreshLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.srl_fragment_industry_label, "field 'srlFragmentIndustryLabel'", SmartRefreshLayout.class);
        industryLabelFragment.audvFragmentIndustryLabel = (AutoNullDisplayView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.audv_fragment_industry_label, "field 'audvFragmentIndustryLabel'", AutoNullDisplayView.class);
        industryLabelFragment.rvFragmentIndustryLabel = (RecyclerView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rv_fragment_industry_label, "field 'rvFragmentIndustryLabel'", RecyclerView.class);
        View viewFindRequiredView = butterknife.internal.d.findRequiredView(view, p113u.d.tv_fragment_industry_label_search, "method 'onIndustryLabelSearchClick'");
        this.view17cd = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.scene.IndustryLabelFragment_ViewBinding.1
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                industryLabelFragment.onIndustryLabelSearchClick();
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        IndustryLabelFragment industryLabelFragment = this.target;
        if (industryLabelFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        industryLabelFragment.etFragmentIndustryLabelSearch = null;
        industryLabelFragment.rvFragmentIndustryLabelSpecifications = null;
        industryLabelFragment.rvFragmentIndustryLabelType = null;
        industryLabelFragment.srlFragmentIndustryLabel = null;
        industryLabelFragment.audvFragmentIndustryLabel = null;
        industryLabelFragment.rvFragmentIndustryLabel = null;
        this.view17cd.setOnClickListener(null);
        this.view17cd = null;
    }
}
