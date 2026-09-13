package com.appdev.standard.page.bluetooth;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import com.library.base.widget.AutoNullDisplayView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ConnectByUsbFragment_ViewBinding implements Unbinder {
    private ConnectByUsbFragment target;

    @UiThread
    public ConnectByUsbFragment_ViewBinding(ConnectByUsbFragment connectByUsbFragment, View view) {
        this.target = connectByUsbFragment;
        connectByUsbFragment.rvConnectPrintDevices = (RecyclerView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rv_connect_print_devices, "field 'rvConnectPrintDevices'", RecyclerView.class);
        connectByUsbFragment.audvConnectPrintDevices = (AutoNullDisplayView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.audv_connect_print_devices, "field 'audvConnectPrintDevices'", AutoNullDisplayView.class);
        connectByUsbFragment.srlConnectPrintDevices = (SmartRefreshLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.srl_connect_print_devices, "field 'srlConnectPrintDevices'", SmartRefreshLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ConnectByUsbFragment connectByUsbFragment = this.target;
        if (connectByUsbFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        connectByUsbFragment.rvConnectPrintDevices = null;
        connectByUsbFragment.audvConnectPrintDevices = null;
        connectByUsbFragment.srlConnectPrintDevices = null;
    }
}
