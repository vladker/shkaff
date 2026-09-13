package com.appdev.standard.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class SummaryTipDialog extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p041h0.a f2631a;

    @BindView(6062)
    TextView mTvDialogContent2;

    public SummaryTipDialog(@NonNull Context context) {
        super(context, p113u.h.Dialog);
        this.f2631a = null;
        setContentView(p113u.e.dialog_summary_tips);
        ButterKnife.bind(this);
        String string = getContext().getString(p113u.g.summary_content_2_1);
        String string2 = getContext().getString(p113u.g.summary_content_2_2);
        String string3 = getContext().getString(p113u.g.summary_content_2_3);
        String string4 = getContext().getString(p113u.g.summary_content_2_4);
        String str = string + string2 + string3 + string4 + getContext().getString(p113u.g.summary_content_2_5);
        SpannableString spannableString = new SpannableString(str);
        K k6 = new K(0);
        K k7 = new K(1);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor("#FF9B7C"));
        int iIndexOf = str.indexOf(string2);
        int length = string2.length() + iIndexOf;
        int iIndexOf2 = str.indexOf(string4);
        int length2 = string4.length() + iIndexOf2;
        spannableString.setSpan(k6, iIndexOf, length, 33);
        spannableString.setSpan(foregroundColorSpan, iIndexOf, length, 33);
        spannableString.setSpan(k7, iIndexOf2, length2, 33);
        spannableString.setSpan(foregroundColorSpan, iIndexOf2, length2, 33);
        this.mTvDialogContent2.setText(spannableString);
        this.mTvDialogContent2.setMovementMethod(LinkMovementMethod.getInstance());
        this.mTvDialogContent2.setHighlightColor(0);
    }

    @OnClick({4919, 4920})
    public void onBtnClick(View view) {
        if (view.getId() == p113u.d.btn_cancel) {
            p041h0.a aVar = this.f2631a;
            if (aVar != null) {
                aVar.onCancel();
            }
            dismiss();
            return;
        }
        if (view.getId() == p113u.d.btn_confirm) {
            p041h0.a aVar2 = this.f2631a;
            if (aVar2 != null) {
                aVar2.onConfirm();
            }
            dismiss();
        }
    }
}
