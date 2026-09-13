package com.appdev.standard.page.bluetooth;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class BluetoothDeviceListActivity_ViewBinding implements Unbinder {
    private BluetoothDeviceListActivity target;

    @UiThread
    public BluetoothDeviceListActivity_ViewBinding(BluetoothDeviceListActivity bluetoothDeviceListActivity) {
        this(bluetoothDeviceListActivity, bluetoothDeviceListActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        BluetoothDeviceListActivity bluetoothDeviceListActivity = this.target;
        if (bluetoothDeviceListActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        bluetoothDeviceListActivity.mPairedDevices = null;
    }

    @UiThread
    public BluetoothDeviceListActivity_ViewBinding(BluetoothDeviceListActivity bluetoothDeviceListActivity, View view) {
        this.target = bluetoothDeviceListActivity;
        bluetoothDeviceListActivity.mPairedDevices = (RecyclerView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.paired_devices, "field 'mPairedDevices'", RecyclerView.class);
    }
}
