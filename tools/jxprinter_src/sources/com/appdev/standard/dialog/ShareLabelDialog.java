package com.appdev.standard.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ShareLabelDialog extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public I f2630a;

    @BindView(4923)
    TextView btnEdit;

    @BindView(4924)
    TextView btnEditNo;

    @BindView(5211)
    ImageView ivDialogShareLabelImg;

    public ShareLabelDialog(@NonNull Context context) {
        super(context, p113u.h.Dialog);
        setContentView(p113u.e.dialog_share_label);
        ButterKnife.bind(this);
    }

    public final void a(String str) {
        p047i2.a.a(this.ivDialogShareLabelImg, str);
    }

    @OnClick({4923, 4924})
    public void onBtnClick(View view) {
        if (view.getId() != p113u.d.btn_edit) {
            if (view.getId() == p113u.d.btn_edit_no) {
                dismiss();
            }
        } else {
            I i5 = this.f2630a;
            if (i5 != null) {
                i5.onEdit();
            }
            dismiss();
        }
    }
}
