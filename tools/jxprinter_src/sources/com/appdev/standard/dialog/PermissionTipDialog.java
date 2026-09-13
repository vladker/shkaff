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
public class PermissionTipDialog extends Dialog implements com.library.base.frame.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.library.base.frame.d f2624a;

    @BindView(4919)
    TextView mBtnCancel;

    @BindView(4920)
    TextView mBtnConfirm;

    @BindView(6061)
    TextView mTvDialogContent;

    @BindView(6067)
    TextView mTvDialogTitle;

    public PermissionTipDialog(@NonNull Context context) {
        super(context, p113u.h.Dialog);
        this.f2624a = null;
        setContentView(p113u.e.dialog_permission_tips);
        ButterKnife.bind(this);
    }

    @OnClick({4919, 4920})
    public void onBtnClick(View view) {
        if (view.getId() == p113u.d.btn_cancel) {
            com.library.base.frame.d dVar = this.f2624a;
            if (dVar != null) {
                dVar.onCancel();
            }
            dismiss();
            return;
        }
        if (view.getId() == p113u.d.btn_confirm) {
            com.library.base.frame.d dVar2 = this.f2624a;
            if (dVar2 != null) {
                dVar2.onConfirm();
            }
            dismiss();
        }
    }

    public PermissionTipDialog(@NonNull Context context, String str) {
        super(context, p113u.h.Dialog);
        this.f2624a = null;
        setContentView(p113u.e.dialog_permission_tips);
        ButterKnife.bind(this);
        this.mTvDialogContent.setText(str);
    }

    public PermissionTipDialog(@NonNull Context context, String str, String str2) {
        super(context, p113u.h.Dialog);
        this.f2624a = null;
        setContentView(p113u.e.dialog_permission_tips);
        ButterKnife.bind(this);
        if (Y.f(str)) {
            this.mTvDialogTitle.setVisibility(8);
        } else {
            this.mTvDialogTitle.setText(str);
            this.mTvDialogTitle.setVisibility(0);
        }
        this.mTvDialogContent.setText(str2);
    }
}
