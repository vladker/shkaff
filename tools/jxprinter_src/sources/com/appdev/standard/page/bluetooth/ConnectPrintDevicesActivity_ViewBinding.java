package com.appdev.standard.page.bluetooth;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ConnectPrintDevicesActivity_ViewBinding implements Unbinder {
    private ConnectPrintDevicesActivity target;

    @UiThread
    public ConnectPrintDevicesActivity_ViewBinding(ConnectPrintDevicesActivity connectPrintDevicesActivity) {
        this(connectPrintDevicesActivity, connectPrintDevicesActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ConnectPrintDevicesActivity connectPrintDevicesActivity = this.target;
        if (connectPrintDevicesActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        connectPrintDevicesActivity.tvTitle = null;
        connectPrintDevicesActivity.tvConnectByBluetooth = null;
        connectPrintDevicesActivity.tvConnectByUsb = null;
        connectPrintDevicesActivity.tvConnectByWifi = null;
        connectPrintDevicesActivity.llNetworkGuide = null;
    }

    @UiThread
    public ConnectPrintDevicesActivity_ViewBinding(ConnectPrintDevicesActivity connectPrintDevicesActivity, View view) {
        this.target = connectPrintDevicesActivity;
        connectPrintDevicesActivity.tvTitle = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_title, "field 'tvTitle'", TextView.class);
        connectPrintDevicesActivity.tvConnectByBluetooth = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_connect_by_bluetooth, "field 'tvConnectByBluetooth'", TextView.class);
        connectPrintDevicesActivity.tvConnectByUsb = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_connect_by_usb, "field 'tvConnectByUsb'", TextView.class);
        connectPrintDevicesActivity.tvConnectByWifi = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_connect_by_wifi, "field 'tvConnectByWifi'", TextView.class);
        connectPrintDevicesActivity.llNetworkGuide = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_network_guide, "field 'llNetworkGuide'", LinearLayout.class);
    }
}
