package com.appdev.standard.page.document;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.d;
import com.library.base.widget.AutoNullDisplayView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class CollectLabelFragment_ViewBinding implements Unbinder {
    private CollectLabelFragment target;

    @UiThread
    public CollectLabelFragment_ViewBinding(CollectLabelFragment collectLabelFragment, View view) {
        this.target = collectLabelFragment;
        collectLabelFragment.rvFragmentCollectLabel = (RecyclerView) d.findRequiredViewAsType(view, p113u.d.rv_fragment_collect_label, "field 'rvFragmentCollectLabel'", RecyclerView.class);
        collectLabelFragment.audvFragmentCollectLabel = (AutoNullDisplayView) d.findRequiredViewAsType(view, p113u.d.audv_fragment_collect_label, "field 'audvFragmentCollectLabel'", AutoNullDisplayView.class);
        collectLabelFragment.srlFragmentCollectLabel = (SmartRefreshLayout) d.findRequiredViewAsType(view, p113u.d.srl_fragment_collect_label, "field 'srlFragmentCollectLabel'", SmartRefreshLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CollectLabelFragment collectLabelFragment = this.target;
        if (collectLabelFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        collectLabelFragment.rvFragmentCollectLabel = null;
        collectLabelFragment.audvFragmentCollectLabel = null;
        collectLabelFragment.srlFragmentCollectLabel = null;
    }
}
