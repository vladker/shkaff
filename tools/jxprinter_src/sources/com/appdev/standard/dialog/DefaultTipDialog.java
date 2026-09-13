package com.appdev.standard.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kotlin.jvm.internal.Y;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class DefaultTipDialog extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bumptech.glide.f f2608a;

    @BindView(4919)
    TextView mBtnCancel;

    @BindView(4920)
    TextView mBtnConfirm;

    @BindView(6061)
    TextView mTvDialogContent;

    @BindView(6067)
    TextView mTvDialogTitle;

    public DefaultTipDialog(@NonNull Context context) {
        super(context, p113u.h.Dialog);
        this.f2608a = null;
        setContentView(p113u.e.dialog_default_tips);
        ButterKnife.bind(this);
    }

    public final void a(String str) {
        this.mBtnCancel.setText(str);
    }

    public final void b(String str) {
        this.mBtnConfirm.setText(str);
    }

    public final void c(String str) {
        this.mTvDialogContent.setText(str);
        this.mTvDialogContent.setGravity(17);
    }

    public final void d(String str) {
        this.mTvDialogContent.setText(str);
        this.mTvDialogContent.setGravity(3);
    }

    public final void e(String str) {
        if (Y.f(str)) {
            this.mTvDialogTitle.setVisibility(8);
        } else {
            this.mTvDialogTitle.setText(str);
            this.mTvDialogTitle.setVisibility(0);
        }
    }

    @OnClick({4919, 4920})
    public void onBtnClick(View view) {
        if (view.getId() == p113u.d.btn_cancel) {
            com.bumptech.glide.f fVar = this.f2608a;
            if (fVar != null) {
                fVar.onCancel();
            }
            dismiss();
            return;
        }
        if (view.getId() == p113u.d.btn_confirm) {
            com.bumptech.glide.f fVar2 = this.f2608a;
            if (fVar2 != null) {
                fVar2.onConfirm();
            }
            dismiss();
        }
    }
}
