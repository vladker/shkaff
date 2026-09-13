package com.appdev.standard.page.mine;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class MineQRCodeActivity_ViewBinding implements Unbinder {
    private MineQRCodeActivity target;

    @UiThread
    public MineQRCodeActivity_ViewBinding(MineQRCodeActivity mineQRCodeActivity) {
        this(mineQRCodeActivity, mineQRCodeActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MineQRCodeActivity mineQRCodeActivity = this.target;
        if (mineQRCodeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        mineQRCodeActivity.mTvTitle = null;
        mineQRCodeActivity.mIvMineQrcode = null;
    }

    @UiThread
    public MineQRCodeActivity_ViewBinding(MineQRCodeActivity mineQRCodeActivity, View view) {
        this.target = mineQRCodeActivity;
        mineQRCodeActivity.mTvTitle = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_title, "field 'mTvTitle'", TextView.class);
        mineQRCodeActivity.mIvMineQrcode = (ImageView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.iv_mine_qrcode, "field 'mIvMineQrcode'", ImageView.class);
    }
}
