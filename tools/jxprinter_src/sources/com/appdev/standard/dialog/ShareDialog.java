package com.appdev.standard.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.common.net.HttpHeaders;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ShareDialog extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public G f2629a;

    @BindView(5365)
    LinearLayout llDialogShareLink;

    @BindView(5366)
    LinearLayout llDialogShareWechat;

    @BindView(4919)
    TextView mBtnCancel;

    @BindView(6067)
    TextView mTvDialogTitle;

    public ShareDialog(@NonNull Context context) {
        super(context, p113u.h.Dialog);
        setContentView(p113u.e.dialog_default_share);
        ButterKnife.bind(this);
    }

    @OnClick({4919, 5366, 5365})
    public void onBtnClick(View view) {
        if (view.getId() == p113u.d.btn_cancel) {
            G g6 = this.f2629a;
            if (g6 != null) {
                g6.onCancel();
            }
            dismiss();
            return;
        }
        if (view.getId() == p113u.d.ll_dialog_share_wechat) {
            G g7 = this.f2629a;
            if (g7 != null) {
                g7.onSelect("WeChat");
            }
            dismiss();
            return;
        }
        if (view.getId() == p113u.d.ll_dialog_share_link) {
            G g8 = this.f2629a;
            if (g8 != null) {
                g8.onSelect(HttpHeaders.LINK);
            }
            dismiss();
        }
    }
}
