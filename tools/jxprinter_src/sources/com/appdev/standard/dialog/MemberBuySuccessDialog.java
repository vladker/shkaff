package com.appdev.standard.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class MemberBuySuccessDialog extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public x f2619a;

    @BindView(4925)
    TextView btnFinish;

    public MemberBuySuccessDialog(@NonNull Context context) {
        super(context, p113u.h.Dialog);
        setContentView(p113u.e.dialog_member_buy_success);
        ButterKnife.bind(this);
    }

    @OnClick({4925})
    public void onBtnClick(View view) {
        if (view.getId() == p113u.d.btn_finish) {
            x xVar = this.f2619a;
            if (xVar != null) {
                xVar.onFinish();
            }
            dismiss();
        }
    }
}
