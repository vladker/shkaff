package com.appdev.standard.page.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.dialog.PermissionTipDialog;
import com.library.base.frame.BaseActivity;
import com.library.base.frame.MvpActivity;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = DefaultRouteConstant.ACTIVITY_BLUETOOTH_DEVICE_LIST)
public class BluetoothDeviceListActivity extends MvpActivity {
    public static String EXTRA_DEVICE_ADDRESS = "device_address";
    public static String EXTRA_DEVICE_NAME = "device_name";
    private BluetoothAdapter mBtAdapter;

    @BindView(5675)
    RecyclerView mPairedDevices;
    private final int BLUETOOTH_PERMISSION_REQUEST_CODE = 1;
    private final int BLUETOOTH_DISCOVERY_PERMISSION_REQUEST_CODE = 2;
    private com.library.base.util.recyclerview.f devicesAdapter = null;
    private final BroadcastReceiver mReceiver = new BroadcastReceiver() { // from class: com.appdev.standard.page.bluetooth.BluetoothDeviceListActivity.4
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (!"android.bluetooth.device.action.FOUND".equals(action)) {
                if ("android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(action)) {
                    p051j0.a.d(((BaseActivity) BluetoothDeviceListActivity.this).TAG, "扫描结束");
                    return;
                }
                return;
            }
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            p051j0.a.d(((BaseActivity) BluetoothDeviceListActivity.this).TAG, "扫描到设备" + bluetoothDevice.getAddress());
            String deviceShowStr = BluetoothDeviceListActivity.this.getDeviceShowStr(bluetoothDevice);
            if (BluetoothDeviceListActivity.this.devicesAdapter.getData().contains(deviceShowStr)) {
                return;
            }
            BluetoothDeviceListActivity.this.devicesAdapter.add(deviceShowStr);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public String getDeviceShowStr(BluetoothDevice bluetoothDevice) {
        return bluetoothDevice.getName() + " (" + getString(bluetoothDevice.getBondState() == 12 ? p113u.g.text_271 : p113u.g.text_272) + ")\n" + bluetoothDevice.getAddress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void returnToPreviousActivity(String str, String str2) {
        if (this.mBtAdapter.isDiscovering()) {
            this.mBtAdapter.cancelDiscovery();
        }
        Intent intent = new Intent();
        intent.putExtra(EXTRA_DEVICE_ADDRESS, str);
        intent.putExtra(EXTRA_DEVICE_NAME, str2);
        setResult(-1, intent);
        finish();
    }

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initComponent() {
        super.initComponent();
        this.mPairedDevices.setLayoutManager(new LinearLayoutManager(this));
        this.mPairedDevices.setAdapter(this.devicesAdapter);
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initData() {
        super.initData();
        setResult(0);
        this.devicesAdapter = new com.library.base.util.recyclerview.f(this, p113u.e.item_paired_devices) { // from class: com.appdev.standard.page.bluetooth.BluetoothDeviceListActivity.1
            @Override // com.library.base.util.recyclerview.b
            public void convert(com.library.base.util.recyclerview.a aVar, String str) {
                aVar.b(p113u.d.name, str);
            }
        };
        needBlueToothPermission(new PermissionTipDialog(this, getString(p113u.g.bluetooth_permission2)), new p026e2.a() { // from class: com.appdev.standard.page.bluetooth.BluetoothDeviceListActivity.2
            @Override // p026e2.a
            public void onRequestPermissionFail() {
            }

            @Override // p026e2.a
            public void onRequestPermissionSuccess() {
            }
        });
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initListener() {
        super.initListener();
        this.devicesAdapter.setOnItemClickListener(new com.library.base.util.recyclerview.e() { // from class: com.appdev.standard.page.bluetooth.BluetoothDeviceListActivity.3
            @Override // com.library.base.util.recyclerview.e
            public void onItemClick(View view, int i5) {
                String[] strArrSplit = ((String) BluetoothDeviceListActivity.this.devicesAdapter.getItem(i5)).split("\n");
                String str = strArrSplit[0];
                BluetoothDeviceListActivity.this.returnToPreviousActivity(strArrSplit[1], str);
            }

            @Override // com.library.base.util.recyclerview.e
            public void onItemLongClick(View view, int i5) {
            }
        });
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public int layoutId() {
        return p113u.e.activity_bluetooth_device_list;
    }

    @Override // com.library.base.frame.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.device.action.FOUND");
        intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        registerReceiver(this.mReceiver, intentFilter);
        super.onResume();
    }

    @Override // com.library.base.frame.FrameActivity
    public void onReturnClick(View view) {
        finish();
    }

    public void onScanClick(View view) {
        needBlueToothPermission(new PermissionTipDialog(this, getString(p113u.g.bluetooth_permission2)), new p026e2.a() { // from class: com.appdev.standard.page.bluetooth.BluetoothDeviceListActivity.5
            @Override // p026e2.a
            public void onRequestPermissionFail() {
            }

            @Override // p026e2.a
            public void onRequestPermissionSuccess() {
            }
        });
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        BluetoothAdapter bluetoothAdapter = this.mBtAdapter;
        if (bluetoothAdapter != null && bluetoothAdapter.isDiscovering()) {
            this.mBtAdapter.cancelDiscovery();
        }
        unregisterReceiver(this.mReceiver);
        super.onStop();
    }

    @p005a2.a(requestCode = 2)
    public void requestBluetoothDiscoveryFailure() {
        p051j0.a.d(this.TAG, getResources().getString(p113u.g.toast_3));
    }

    @p005a2.b(requestCode = 2)
    public void requestBluetoothDiscoverySuccess() {
        p051j0.a.d(this.TAG, "获取权限成功");
        p051j0.a.d(this.TAG, "doDiscovery");
        if (this.mBtAdapter.isDiscovering()) {
            this.mBtAdapter.cancelDiscovery();
        }
        this.devicesAdapter.clear();
        this.mBtAdapter.startDiscovery();
        p051j0.a.d(this.TAG, getResources().getString(p113u.g.toast_3));
    }

    @p005a2.a(requestCode = 1)
    public void requestBluetoothFailure() {
        p051j0.a.d(this.TAG, getResources().getString(p113u.g.toast_3));
    }

    @p005a2.b(requestCode = 1)
    public void requestBluetoothSuccess() {
        p051j0.a.d(this.TAG, "获取权限成功");
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        this.mBtAdapter = defaultAdapter;
        Set<BluetoothDevice> bondedDevices = defaultAdapter.getBondedDevices();
        if (bondedDevices.size() > 0) {
            Iterator<BluetoothDevice> it = bondedDevices.iterator();
            while (it.hasNext()) {
                String deviceShowStr = getDeviceShowStr(it.next());
                if (!this.devicesAdapter.getData().contains(deviceShowStr)) {
                    this.devicesAdapter.add(deviceShowStr);
                }
            }
        }
    }
}
