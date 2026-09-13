package com.appdev.standard.page.bluetooth;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class PrintDeviceInfoActivity_ViewBinding implements Unbinder {
    private PrintDeviceInfoActivity target;

    @UiThread
    public PrintDeviceInfoActivity_ViewBinding(PrintDeviceInfoActivity printDeviceInfoActivity) {
        this(printDeviceInfoActivity, printDeviceInfoActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PrintDeviceInfoActivity printDeviceInfoActivity = this.target;
        if (printDeviceInfoActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        printDeviceInfoActivity.llPrintDeviceInfo = null;
        printDeviceInfoActivity.tvTitle = null;
        printDeviceInfoActivity.tvPrintDeviceInfoName = null;
        printDeviceInfoActivity.tvPrintDeviceInfoAddress = null;
        printDeviceInfoActivity.ivPrintDeviceInfoSetting = null;
        printDeviceInfoActivity.tvPrintDeviceFactoryName = null;
        printDeviceInfoActivity.tvPrintDeviceDPIType = null;
        printDeviceInfoActivity.tvPrintDevicePtStatus = null;
        printDeviceInfoActivity.tvPrintDeviceMaxDotLine = null;
        printDeviceInfoActivity.tvPrintDeviceCodepage = null;
        printDeviceInfoActivity.tvPrintDeviceCodeType = null;
        printDeviceInfoActivity.tvPrintDevicePowerLev = null;
        printDeviceInfoActivity.tvPrintDeviceDepthLev = null;
        printDeviceInfoActivity.tvPrintDeviceSpeedLev = null;
        printDeviceInfoActivity.tvPrintDeviceCmdMode = null;
        printDeviceInfoActivity.tvPrintDevicePaperType = null;
        printDeviceInfoActivity.tvPrintDeviceNfcEnable = null;
        printDeviceInfoActivity.tvPrintDeviceVersion = null;
        printDeviceInfoActivity.llPrintDeviceInfoErrorLack = null;
        printDeviceInfoActivity.llPrintDeviceInfoErrorOpen = null;
        printDeviceInfoActivity.llPrintDeviceInfoError = null;
        printDeviceInfoActivity.llPrintDeviceInfoErrorTemperature = null;
        printDeviceInfoActivity.llPrintDeviceInfoErrorCuttingKnife = null;
        printDeviceInfoActivity.rgZipGroup = null;
        printDeviceInfoActivity.rbZipYes = null;
        printDeviceInfoActivity.rbZipNo = null;
        printDeviceInfoActivity.llZip = null;
    }

    @UiThread
    public PrintDeviceInfoActivity_ViewBinding(PrintDeviceInfoActivity printDeviceInfoActivity, View view) {
        this.target = printDeviceInfoActivity;
        printDeviceInfoActivity.llPrintDeviceInfo = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_print_device_info, "field 'llPrintDeviceInfo'", LinearLayout.class);
        printDeviceInfoActivity.tvTitle = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_title, "field 'tvTitle'", TextView.class);
        printDeviceInfoActivity.tvPrintDeviceInfoName = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_print_device_info_name, "field 'tvPrintDeviceInfoName'", TextView.class);
        printDeviceInfoActivity.tvPrintDeviceInfoAddress = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_print_device_info_address, "field 'tvPrintDeviceInfoAddress'", TextView.class);
        printDeviceInfoActivity.ivPrintDeviceInfoSetting = (ImageView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.iv_print_device_info_setting, "field 'ivPrintDeviceInfoSetting'", ImageView.class);
        printDeviceInfoActivity.tvPrintDeviceFactoryName = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_print_device_factory_name, "field 'tvPrintDeviceFactoryName'", TextView.class);
        printDeviceInfoActivity.tvPrintDeviceDPIType = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_print_device_DPI_type, "field 'tvPrintDeviceDPIType'", TextView.class);
        printDeviceInfoActivity.tvPrintDevicePtStatus = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_print_device_pt_status, "field 'tvPrintDevicePtStatus'", TextView.class);
        printDeviceInfoActivity.tvPrintDeviceMaxDotLine = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_print_device_max_dot_line, "field 'tvPrintDeviceMaxDotLine'", TextView.class);
        printDeviceInfoActivity.tvPrintDeviceCodepage = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_print_device_codepage, "field 'tvPrintDeviceCodepage'", TextView.class);
        printDeviceInfoActivity.tvPrintDeviceCodeType = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_print_device_code_type, "field 'tvPrintDeviceCodeType'", TextView.class);
        printDeviceInfoActivity.tvPrintDevicePowerLev = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_print_device_power_lev, "field 'tvPrintDevicePowerLev'", TextView.class);
        printDeviceInfoActivity.tvPrintDeviceDepthLev = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_print_device_depth_lev, "field 'tvPrintDeviceDepthLev'", TextView.class);
        printDeviceInfoActivity.tvPrintDeviceSpeedLev = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_print_device_speed_lev, "field 'tvPrintDeviceSpeedLev'", TextView.class);
        printDeviceInfoActivity.tvPrintDeviceCmdMode = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_print_device_cmd_mode, "field 'tvPrintDeviceCmdMode'", TextView.class);
        printDeviceInfoActivity.tvPrintDevicePaperType = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_print_device_paper_type, "field 'tvPrintDevicePaperType'", TextView.class);
        printDeviceInfoActivity.tvPrintDeviceNfcEnable = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_print_device_nfc_enable, "field 'tvPrintDeviceNfcEnable'", TextView.class);
        printDeviceInfoActivity.tvPrintDeviceVersion = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_print_device_version, "field 'tvPrintDeviceVersion'", TextView.class);
        printDeviceInfoActivity.llPrintDeviceInfoErrorLack = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_print_device_info_error_lack, "field 'llPrintDeviceInfoErrorLack'", LinearLayout.class);
        printDeviceInfoActivity.llPrintDeviceInfoErrorOpen = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_print_device_info_error_open, "field 'llPrintDeviceInfoErrorOpen'", LinearLayout.class);
        printDeviceInfoActivity.llPrintDeviceInfoError = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_print_device_info_error, "field 'llPrintDeviceInfoError'", LinearLayout.class);
        printDeviceInfoActivity.llPrintDeviceInfoErrorTemperature = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_print_device_info_error_temperature, "field 'llPrintDeviceInfoErrorTemperature'", LinearLayout.class);
        printDeviceInfoActivity.llPrintDeviceInfoErrorCuttingKnife = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_print_device_info_error_cutting_knife, "field 'llPrintDeviceInfoErrorCuttingKnife'", LinearLayout.class);
        printDeviceInfoActivity.rgZipGroup = (RadioGroup) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rg_zip_group, "field 'rgZipGroup'", RadioGroup.class);
        printDeviceInfoActivity.rbZipYes = (RadioButton) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rb_print_device_setting_zip_yes, "field 'rbZipYes'", RadioButton.class);
        printDeviceInfoActivity.rbZipNo = (RadioButton) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rb_print_device_setting_zip_no, "field 'rbZipNo'", RadioButton.class);
        printDeviceInfoActivity.llZip = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_zip, "field 'llZip'", LinearLayout.class);
    }
}
