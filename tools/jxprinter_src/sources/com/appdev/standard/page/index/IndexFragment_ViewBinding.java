package com.appdev.standard.page.index;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import com.appdev.standard.widget.MallBannerView;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class IndexFragment_ViewBinding implements Unbinder {
    private IndexFragment target;
    private View view1468;
    private View view146a;
    private View view16ae;

    @UiThread
    public IndexFragment_ViewBinding(final IndexFragment indexFragment, View view) {
        this.target = indexFragment;
        indexFragment.ivHomeLogo = (ImageView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.iv_home_logo, "field 'ivHomeLogo'", ImageView.class);
        indexFragment.bvFragmentIndexBanner = (MallBannerView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.bv_fragment_index_banner, "field 'bvFragmentIndexBanner'", MallBannerView.class);
        indexFragment.rvFragmentIndexPrintHistory = (RecyclerView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rv_fragment_index_print_history, "field 'rvFragmentIndexPrintHistory'", RecyclerView.class);
        indexFragment.llFragmentIndex = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_fragment_index, "field 'llFragmentIndex'", LinearLayout.class);
        int i5 = p113u.d.iv_fragment_vip;
        View viewFindRequiredView = butterknife.internal.d.findRequiredView(view, i5, "field 'ivVip' and method 'onVipClick'");
        indexFragment.ivVip = (ImageView) butterknife.internal.d.castView(viewFindRequiredView, i5, "field 'ivVip'", ImageView.class);
        this.view146a = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.index.IndexFragment_ViewBinding.1
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                indexFragment.onVipClick(view2);
            }
        });
        View viewFindRequiredView2 = butterknife.internal.d.findRequiredView(view, p113u.d.iv_fragment_index_scan, "method 'onScanClick'");
        this.view1468 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.index.IndexFragment_ViewBinding.2
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                indexFragment.onScanClick(view2);
            }
        });
        View viewFindRequiredView3 = butterknife.internal.d.findRequiredView(view, p113u.d.rl_fragment_index_printer, "method 'onPrinterClick'");
        this.view16ae = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.index.IndexFragment_ViewBinding.3
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                indexFragment.onPrinterClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        IndexFragment indexFragment = this.target;
        if (indexFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        indexFragment.ivHomeLogo = null;
        indexFragment.bvFragmentIndexBanner = null;
        indexFragment.rvFragmentIndexPrintHistory = null;
        indexFragment.llFragmentIndex = null;
        indexFragment.ivVip = null;
        this.view146a.setOnClickListener(null);
        this.view146a = null;
        this.view1468.setOnClickListener(null);
        this.view1468 = null;
        this.view16ae.setOnClickListener(null);
        this.view16ae = null;
    }
}
