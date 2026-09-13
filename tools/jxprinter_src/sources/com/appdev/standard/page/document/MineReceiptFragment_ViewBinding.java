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
public class MineReceiptFragment_ViewBinding implements Unbinder {
    private MineReceiptFragment target;

    @UiThread
    public MineReceiptFragment_ViewBinding(MineReceiptFragment mineReceiptFragment, View view) {
        this.target = mineReceiptFragment;
        mineReceiptFragment.rvFragmentMineReceipt = (RecyclerView) d.findRequiredViewAsType(view, p113u.d.rv_fragment_mine_receipt, "field 'rvFragmentMineReceipt'", RecyclerView.class);
        mineReceiptFragment.audvFragmentMineReceipt = (AutoNullDisplayView) d.findRequiredViewAsType(view, p113u.d.audv_fragment_mine_receipt, "field 'audvFragmentMineReceipt'", AutoNullDisplayView.class);
        mineReceiptFragment.srlFragmentMineReceipt = (SmartRefreshLayout) d.findRequiredViewAsType(view, p113u.d.srl_fragment_mine_receipt, "field 'srlFragmentMineReceipt'", SmartRefreshLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MineReceiptFragment mineReceiptFragment = this.target;
        if (mineReceiptFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        mineReceiptFragment.rvFragmentMineReceipt = null;
        mineReceiptFragment.audvFragmentMineReceipt = null;
        mineReceiptFragment.srlFragmentMineReceipt = null;
    }
}
