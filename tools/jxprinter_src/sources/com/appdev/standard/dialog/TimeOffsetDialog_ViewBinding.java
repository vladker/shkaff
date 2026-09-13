package com.appdev.standard.dialog;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class TimeOffsetDialog_ViewBinding implements Unbinder {
    public TimeOffsetDialog b;
    public View c;
    public View d;
    public View e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f2635f;

    @UiThread
    public TimeOffsetDialog_ViewBinding(TimeOffsetDialog timeOffsetDialog) {
        this(timeOffsetDialog, timeOffsetDialog.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        TimeOffsetDialog timeOffsetDialog = this.b;
        if (timeOffsetDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        timeOffsetDialog.qswDateSettingTimeOffsetYear = null;
        timeOffsetDialog.qswDateSettingTimeOffsetMonth = null;
        timeOffsetDialog.qswDateSettingTimeOffsetDay = null;
        timeOffsetDialog.llDialogTimeOffsetDay = null;
        timeOffsetDialog.qswDateSettingTimeOffsetHour = null;
        timeOffsetDialog.qswDateSettingTimeOffsetMinute = null;
        timeOffsetDialog.qswDateSettingTimeOffsetSecond = null;
        timeOffsetDialog.llDialogTimeOffsetTime = null;
        this.c.setOnClickListener(null);
        this.c = null;
        this.d.setOnClickListener(null);
        this.d = null;
        this.e.setOnClickListener(null);
        this.e = null;
        this.f2635f.setOnClickListener(null);
        this.f2635f = null;
    }

    @UiThread
    public TimeOffsetDialog_ViewBinding(TimeOffsetDialog timeOffsetDialog, View view) {
        this.b = timeOffsetDialog;
        timeOffsetDialog.qswDateSettingTimeOffsetYear = (QuantitySelectorWidget) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.qsw_date_setting_time_offset_year, "field 'qswDateSettingTimeOffsetYear'", QuantitySelectorWidget.class);
        timeOffsetDialog.qswDateSettingTimeOffsetMonth = (QuantitySelectorWidget) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.qsw_date_setting_time_offset_month, "field 'qswDateSettingTimeOffsetMonth'", QuantitySelectorWidget.class);
        timeOffsetDialog.qswDateSettingTimeOffsetDay = (QuantitySelectorWidget) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.qsw_date_setting_time_offset_day, "field 'qswDateSettingTimeOffsetDay'", QuantitySelectorWidget.class);
        timeOffsetDialog.llDialogTimeOffsetDay = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_dialog_time_offset_day, "field 'llDialogTimeOffsetDay'", LinearLayout.class);
        timeOffsetDialog.qswDateSettingTimeOffsetHour = (QuantitySelectorWidget) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.qsw_date_setting_time_offset_hour, "field 'qswDateSettingTimeOffsetHour'", QuantitySelectorWidget.class);
        timeOffsetDialog.qswDateSettingTimeOffsetMinute = (QuantitySelectorWidget) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.qsw_date_setting_time_offset_minute, "field 'qswDateSettingTimeOffsetMinute'", QuantitySelectorWidget.class);
        timeOffsetDialog.qswDateSettingTimeOffsetSecond = (QuantitySelectorWidget) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.qsw_date_setting_time_offset_second, "field 'qswDateSettingTimeOffsetSecond'", QuantitySelectorWidget.class);
        timeOffsetDialog.llDialogTimeOffsetTime = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_dialog_time_offset_time, "field 'llDialogTimeOffsetTime'", LinearLayout.class);
        View viewFindRequiredView = butterknife.internal.d.findRequiredView(view, p113u.d.tv_dialog_time_offset_type_day, "method 'onDialogTypeDayClick'");
        this.c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new U(timeOffsetDialog, 0));
        View viewFindRequiredView2 = butterknife.internal.d.findRequiredView(view, p113u.d.tv_dialog_time_offset_type_time, "method 'onDialogTypeTimeClick'");
        this.d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new U(timeOffsetDialog, 1));
        View viewFindRequiredView3 = butterknife.internal.d.findRequiredView(view, p113u.d.tv_dialog_time_offset_cancel, "method 'onDialogCancelClick'");
        this.e = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new U(timeOffsetDialog, 2));
        View viewFindRequiredView4 = butterknife.internal.d.findRequiredView(view, p113u.d.tv_dialog_time_offset_confirm, "method 'onDialogConfirmClick'");
        this.f2635f = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new U(timeOffsetDialog, 3));
    }
}
