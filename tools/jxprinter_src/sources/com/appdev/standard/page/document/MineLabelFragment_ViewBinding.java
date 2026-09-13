package com.appdev.standard.page.document;

import android.view.View;
import android.widget.EditText;
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
public class MineLabelFragment_ViewBinding implements Unbinder {
    private MineLabelFragment target;

    @UiThread
    public MineLabelFragment_ViewBinding(MineLabelFragment mineLabelFragment, View view) {
        this.target = mineLabelFragment;
        mineLabelFragment.srlFragmentMineLabel = (SmartRefreshLayout) d.findRequiredViewAsType(view, p113u.d.srl_fragment_mine_label, "field 'srlFragmentMineLabel'", SmartRefreshLayout.class);
        mineLabelFragment.audvFragmentMineLabel = (AutoNullDisplayView) d.findRequiredViewAsType(view, p113u.d.audv_fragment_mine_label, "field 'audvFragmentMineLabel'", AutoNullDisplayView.class);
        mineLabelFragment.rvFragmentMineLabel = (RecyclerView) d.findRequiredViewAsType(view, p113u.d.rv_fragment_mine_label, "field 'rvFragmentMineLabel'", RecyclerView.class);
        mineLabelFragment.etSearch = (EditText) d.findRequiredViewAsType(view, p113u.d.et_fragment_mine_label_search, "field 'etSearch'", EditText.class);
        mineLabelFragment.tvSearch = (TextView) d.findRequiredViewAsType(view, p113u.d.tv_fragment_mine_label_search, "field 'tvSearch'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MineLabelFragment mineLabelFragment = this.target;
        if (mineLabelFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        mineLabelFragment.srlFragmentMineLabel = null;
        mineLabelFragment.audvFragmentMineLabel = null;
        mineLabelFragment.rvFragmentMineLabel = null;
        mineLabelFragment.etSearch = null;
        mineLabelFragment.tvSearch = null;
    }
}
