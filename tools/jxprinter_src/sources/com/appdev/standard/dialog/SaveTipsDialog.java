package com.appdev.standard.dialog;

import android.app.Dialog;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.library.base.frame.MvpActivity;
import kotlin.jvm.internal.Y;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class SaveTipsDialog extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C f2627a;

    @BindView(6061)
    TextView mTvDialogContent;

    public SaveTipsDialog(MvpActivity mvpActivity) {
        super(mvpActivity, p113u.h.Dialog);
        this.f2627a = null;
        setContentView(p113u.e.dialog_save_tips);
        ButterKnife.bind(this);
    }

    public final void a(String str) {
        if (Y.f(str)) {
            return;
        }
        this.mTvDialogContent.setText(str);
    }

    @OnClick({4919, 4920, 5210})
    public void onBtnClick(View view) {
        if (view.getId() == p113u.d.btn_cancel) {
            C c = this.f2627a;
            if (c != null) {
                c.onExit();
            }
            dismiss();
            return;
        }
        if (view.getId() != p113u.d.btn_confirm) {
            if (view.getId() == p113u.d.iv_dialog_close) {
                dismiss();
            }
        } else {
            C c6 = this.f2627a;
            if (c6 != null) {
                c6.onSave();
            }
            dismiss();
        }
    }
}
