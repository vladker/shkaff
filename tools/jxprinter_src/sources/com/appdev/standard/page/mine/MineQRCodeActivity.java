package com.appdev.standard.page.mine;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import cn.bertsir.zbar.utils.QRUtils;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.appdev.constant.DefaultRouteConstant;
import com.library.base.frame.MvpActivity;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = DefaultRouteConstant.ACTIVITY_MINEQRCODE)
public class MineQRCodeActivity extends MvpActivity implements R.a {

    @BindView(5259)
    ImageView mIvMineQrcode;

    @BindView(6274)
    TextView mTvTitle;
    private R.b mineQRCodeWorker = null;

    @Override // R.a
    public void getMineQRCodeSuccess(Bitmap bitmap) {
        this.mIvMineQrcode.setImageBitmap(bitmap);
    }

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initComponent() {
        super.initComponent();
        this.mTvTitle.setText(getString(p113u.g.text_96));
        Object obj = this.mineQRCodeWorker.b;
        if (obj != null) {
            ((R.a) obj).getMineQRCodeSuccess(QRUtils.getInstance().createQRCode(String.valueOf(p042h2.e.f4031a.e().c)));
        }
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initData() {
        super.initData();
        R.b bVar = new R.b(this);
        this.mineQRCodeWorker = bVar;
        addPresenter(bVar);
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public int layoutId() {
        return p113u.e.activity_mine_qrcode;
    }

    public void getMineQRCodeFailed(int i5, String str) {
    }
}
