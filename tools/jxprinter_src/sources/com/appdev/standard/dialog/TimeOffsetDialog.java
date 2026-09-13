package com.appdev.standard.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class TimeOffsetDialog extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2632a;
    public int b;
    public int c;
    public int d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2633f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public T f2634g;

    @BindView(5367)
    LinearLayout llDialogTimeOffsetDay;

    @BindView(5368)
    LinearLayout llDialogTimeOffsetTime;

    @BindView(5718)
    QuantitySelectorWidget qswDateSettingTimeOffsetDay;

    @BindView(5719)
    QuantitySelectorWidget qswDateSettingTimeOffsetHour;

    @BindView(5720)
    QuantitySelectorWidget qswDateSettingTimeOffsetMinute;

    @BindView(5721)
    QuantitySelectorWidget qswDateSettingTimeOffsetMonth;

    @BindView(5722)
    QuantitySelectorWidget qswDateSettingTimeOffsetSecond;

    @BindView(5723)
    QuantitySelectorWidget qswDateSettingTimeOffsetYear;

    public TimeOffsetDialog(@NonNull Context context) {
        super(context, p113u.h.Dialog);
        setContentView(p113u.e.dialog_time_offset);
        ButterKnife.bind(this);
        this.qswDateSettingTimeOffsetYear.setOnValueChangeListener(new M(this));
        this.qswDateSettingTimeOffsetMonth.setOnValueChangeListener(new N(this));
        this.qswDateSettingTimeOffsetDay.setOnValueChangeListener(new O(this));
        this.qswDateSettingTimeOffsetHour.setOnValueChangeListener(new P(this));
        this.qswDateSettingTimeOffsetMinute.setOnValueChangeListener(new Q(this));
        this.qswDateSettingTimeOffsetSecond.setOnValueChangeListener(new S(this));
    }

    public final void a(int i5, int i6, int i7, int i8, int i9, int i10) {
        this.f2632a = i5;
        this.b = i6;
        this.c = i7;
        this.d = i8;
        this.e = i9;
        this.f2633f = i10;
        this.qswDateSettingTimeOffsetYear.setOffsetValue(i5);
        this.qswDateSettingTimeOffsetMonth.setOffsetValue(i6);
        this.qswDateSettingTimeOffsetDay.setOffsetValue(i7);
        this.qswDateSettingTimeOffsetHour.setOffsetValue(i8);
        this.qswDateSettingTimeOffsetMinute.setOffsetValue(i9);
        this.qswDateSettingTimeOffsetSecond.setOffsetValue(i10);
    }

    @OnClick({6063})
    public void onDialogCancelClick(View view) {
        dismiss();
    }

    @OnClick({6064})
    public void onDialogConfirmClick(View view) {
        T t6 = this.f2634g;
        if (t6 != null) {
            t6.updateDateValue(this.f2632a, this.b, this.c, this.d, this.e, this.f2633f);
        }
        dismiss();
    }

    @OnClick({6065})
    public void onDialogTypeDayClick(View view) {
        this.llDialogTimeOffsetDay.setVisibility(0);
        this.llDialogTimeOffsetTime.setVisibility(8);
    }

    @OnClick({6066})
    public void onDialogTypeTimeClick(View view) {
        this.llDialogTimeOffsetDay.setVisibility(8);
        this.llDialogTimeOffsetTime.setVisibility(0);
    }
}
