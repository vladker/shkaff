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
public class PublishLabelFragment_ViewBinding implements Unbinder {
    private PublishLabelFragment target;

    @UiThread
    public PublishLabelFragment_ViewBinding(PublishLabelFragment publishLabelFragment, View view) {
        this.target = publishLabelFragment;
        publishLabelFragment.rvFragmentCollectLabel = (RecyclerView) d.findRequiredViewAsType(view, p113u.d.rv_fragment_collect_label, "field 'rvFragmentCollectLabel'", RecyclerView.class);
        publishLabelFragment.audvFragmentCollectLabel = (AutoNullDisplayView) d.findRequiredViewAsType(view, p113u.d.audv_fragment_collect_label, "field 'audvFragmentCollectLabel'", AutoNullDisplayView.class);
        publishLabelFragment.srlFragmentCollectLabel = (SmartRefreshLayout) d.findRequiredViewAsType(view, p113u.d.srl_fragment_collect_label, "field 'srlFragmentCollectLabel'", SmartRefreshLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PublishLabelFragment publishLabelFragment = this.target;
        if (publishLabelFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        publishLabelFragment.rvFragmentCollectLabel = null;
        publishLabelFragment.audvFragmentCollectLabel = null;
        publishLabelFragment.srlFragmentCollectLabel = null;
    }
}
