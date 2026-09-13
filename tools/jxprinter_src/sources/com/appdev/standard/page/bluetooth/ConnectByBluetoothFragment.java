package com.appdev.standard.page.bluetooth;

import S4.k;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.dialog.PermissionTipDialog;
import com.library.base.widget.AutoNullDisplayView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Y;
import org.greenrobot.eventbus.ThreadMode;
import p050j.w;
import p134x2.E;
import p137y.i;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"MissingPermission"})
public class ConnectByBluetoothFragment extends com.library.base.frame.f {

    @BindView(4869)
    AutoNullDisplayView audvConnectPrintDevices;
    private BluetoothAdapter mBtAdapter;
    private com.library.base.util.recyclerview.f quickAdapter;

    @BindView(5818)
    RecyclerView rvConnectPrintDevices;

    @BindView(5924)
    SmartRefreshLayout srlConnectPrintDevices;
    protected final String TAG = getClass().getSimpleName();
    private boolean isHasPermission = false;
    private List<BluetoothDevice> latestDevices = new ArrayList();
    private boolean isCancelScan = false;
    private final BroadcastReceiver mReceiver = new BroadcastReceiver() { // from class: com.appdev.standard.page.bluetooth.ConnectByBluetoothFragment.4
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.bluetooth.device.action.FOUND".equals(action)) {
                BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                p051j0.a.d(ConnectByBluetoothFragment.this.TAG, "扫描到设备 " + bluetoothDevice.getName() + " " + bluetoothDevice.getAddress());
                BluetoothClass bluetoothClass = bluetoothDevice.getBluetoothClass();
                if (bluetoothClass == null || bluetoothClass.getMajorDeviceClass() != 1536) {
                    return;
                }
                ConnectByBluetoothFragment.this.addBluetooth(bluetoothDevice);
                return;
            }
            if ("android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(action)) {
                p051j0.a.d(ConnectByBluetoothFragment.this.TAG, "扫描结束");
                if (!ConnectByBluetoothFragment.this.isCancelScan) {
                    ConnectByBluetoothFragment.this.quickAdapter.clear();
                    if (!Y.f(p051j0.f.getPrintDeviceAddress())) {
                        try {
                            if (E.n()) {
                                ConnectByBluetoothFragment.this.quickAdapter.add(ConnectByBluetoothFragment.this.mBtAdapter.getRemoteDevice(p051j0.f.getPrintDeviceAddress()));
                            }
                        } catch (Exception unused) {
                            p051j0.a.d(ConnectByBluetoothFragment.this.TAG, "initComponent: errorPrintDeviceAddress   " + p051j0.f.getPrintDeviceAddress());
                        }
                    }
                    for (BluetoothDevice bluetoothDevice2 : ConnectByBluetoothFragment.this.latestDevices) {
                        if (!ConnectByBluetoothFragment.this.quickAdapter.getData().contains(bluetoothDevice2)) {
                            ConnectByBluetoothFragment.this.quickAdapter.add(bluetoothDevice2);
                        }
                    }
                    ConnectByBluetoothFragment.this.refreshBtDevices();
                }
                ConnectByBluetoothFragment.this.srlConnectPrintDevices.k();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void addBluetooth(BluetoothDevice bluetoothDevice) {
        try {
            this.srlConnectPrintDevices.k();
            if (!this.latestDevices.contains(bluetoothDevice)) {
                this.latestDevices.add(bluetoothDevice);
            }
            if (this.quickAdapter.getData().contains(bluetoothDevice)) {
                p051j0.a.d("addBluetooth", "当前设备已存在");
            } else {
                this.quickAdapter.add(bluetoothDevice);
            }
            refreshBtDevices();
        } catch (Throwable th) {
            throw th;
        }
    }

    private void clearOtherDevices() {
        ArrayList arrayList = new ArrayList();
        Iterator<Object> it = this.quickAdapter.getData().iterator();
        while (it.hasNext()) {
            BluetoothDevice bluetoothDevice = (BluetoothDevice) it.next();
            if (bluetoothDevice.getAddress().equals(p051j0.f.getPrintDeviceAddress())) {
                arrayList.add(bluetoothDevice);
            }
        }
        this.quickAdapter.replaceAll(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshBtDevices() {
        ArrayList arrayList = new ArrayList();
        Iterator<Object> it = this.quickAdapter.getData().iterator();
        while (it.hasNext()) {
            BluetoothDevice bluetoothDevice = (BluetoothDevice) it.next();
            if (bluetoothDevice.getAddress().equals(p051j0.f.getPrintDeviceAddress())) {
                arrayList.add(bluetoothDevice);
            }
        }
        Iterator<Object> it2 = this.quickAdapter.getData().iterator();
        while (it2.hasNext()) {
            BluetoothDevice bluetoothDevice2 = (BluetoothDevice) it2.next();
            if (!bluetoothDevice2.getAddress().equals(p051j0.f.getPrintDeviceAddress()) && bluetoothDevice2.getBondState() == 12) {
                arrayList.add(bluetoothDevice2);
            }
        }
        Iterator<Object> it3 = this.quickAdapter.getData().iterator();
        while (it3.hasNext()) {
            BluetoothDevice bluetoothDevice3 = (BluetoothDevice) it3.next();
            if (!bluetoothDevice3.getAddress().equals(p051j0.f.getPrintDeviceAddress()) && bluetoothDevice3.getBondState() != 12) {
                arrayList.add(bluetoothDevice3);
            }
        }
        this.quickAdapter.replaceAll(arrayList);
    }

    @Override // com.library.base.frame.e
    public void initComponent() {
        registerEventBus();
        SmartRefreshLayout smartRefreshLayout = this.srlConnectPrintDevices;
        smartRefreshLayout.f3760x0 = true;
        smartRefreshLayout.f3695D = false;
        this.mBtAdapter = BluetoothAdapter.getDefaultAdapter();
        this.quickAdapter = new com.library.base.util.recyclerview.f(getContext(), p113u.e.item_connect_print_devices_by_bluetooth) { // from class: com.appdev.standard.page.bluetooth.ConnectByBluetoothFragment.1
            @Override // com.library.base.util.recyclerview.b
            public void convert(com.library.base.util.recyclerview.a aVar, BluetoothDevice bluetoothDevice) {
                LinearLayout linearLayout = (LinearLayout) aVar.a(p113u.d.ll_item_connect_print_devices_by_bluetooth);
                ImageView imageView = (ImageView) aVar.a(p113u.d.iv_item_connect_print_devices_by_bluetooth_img);
                TextView textView = (TextView) aVar.a(p113u.d.tv_item_connect_print_devices_by_bluetooth_name);
                textView.setText(bluetoothDevice.getName());
                aVar.b(p113u.d.tv_item_connect_print_devices_by_bluetooth_address, bluetoothDevice.getAddress());
                TextView textView2 = (TextView) aVar.a(p113u.d.tv_item_connect_print_devices_by_bluetooth_connect_state);
                if (bluetoothDevice.getAddress().equals(p051j0.f.getPrintDeviceAddress()) && E.n()) {
                    textView2.setVisibility(0);
                    linearLayout.setBackgroundResource(p113u.c.bg_ffffff_rad_10_stroke_ffae00);
                    textView2.setText(ConnectByBluetoothFragment.this.getString(p113u.g.text_82));
                    Resources resources = ConnectByBluetoothFragment.this.getResources();
                    int i5 = p113u.a.color_FFAE00;
                    textView2.setTextColor(resources.getColor(i5));
                    textView.setTextColor(ConnectByBluetoothFragment.this.getResources().getColor(i5));
                    imageView.setImageResource(p113u.f.ic_connect_print_connect);
                    return;
                }
                if (bluetoothDevice.getBondState() != 12) {
                    textView2.setVisibility(8);
                    textView.setTextColor(ConnectByBluetoothFragment.this.getResources().getColor(p113u.a.color_555555));
                    linearLayout.setBackgroundResource(p113u.c.bg_ffffff_rad_10_stroke_eeeeee);
                    imageView.setImageResource(p113u.f.ic_connect_print_connect_not);
                    return;
                }
                textView2.setVisibility(0);
                linearLayout.setBackgroundResource(p113u.c.bg_ffffff_rad_10_stroke_eeeeee);
                textView2.setText(ConnectByBluetoothFragment.this.getResources().getString(p113u.g.text_194));
                textView2.setTextColor(ConnectByBluetoothFragment.this.getResources().getColor(p113u.a.color_999999));
                textView.setTextColor(ConnectByBluetoothFragment.this.getResources().getColor(p113u.a.color_555555));
                imageView.setImageResource(p113u.f.ic_connect_print_connect_not);
            }
        };
        this.rvConnectPrintDevices.setLayoutManager(new LinearLayoutManager(getContext()));
        this.rvConnectPrintDevices.setAdapter(this.quickAdapter);
        this.audvConnectPrintDevices.b(p113u.f.ic_print_no_data);
        this.audvConnectPrintDevices.setConnect(getString(p113u.g.text_283));
        this.audvConnectPrintDevices.setButtonWhetherVisible(false);
        this.srlConnectPrintDevices.f3691A0 = new L2.e() { // from class: com.appdev.standard.page.bluetooth.ConnectByBluetoothFragment.2
            @Override // L2.e
            public void onRefresh(@NonNull I2.f fVar) {
                ConnectByBluetoothFragment.this.getFrameActivity().needBlueToothPermission(new PermissionTipDialog(ConnectByBluetoothFragment.this.getFrameActivity(), ConnectByBluetoothFragment.this.getFrameActivity().getString(p113u.g.bluetooth_permission2)), new p026e2.a() { // from class: com.appdev.standard.page.bluetooth.ConnectByBluetoothFragment.2.1
                    @Override // p026e2.a
                    public void onRequestPermissionFail() {
                        ConnectByBluetoothFragment.this.isHasPermission = false;
                        p042h2.d.show(p113u.g.toast_3);
                    }

                    @Override // p026e2.a
                    public void onRequestPermissionSuccess() {
                        ConnectByBluetoothFragment.this.isHasPermission = true;
                        p051j0.a.d(ConnectByBluetoothFragment.this.TAG, "获取权限成功");
                        if (!ConnectByBluetoothFragment.this.mBtAdapter.isEnabled()) {
                            ConnectByBluetoothFragment.this.srlConnectPrintDevices.k();
                            ConnectByBluetoothFragment.this.quickAdapter.clear();
                            p042h2.d.show(p113u.g.toast_16);
                        } else {
                            if (ConnectByBluetoothFragment.this.mBtAdapter.isDiscovering()) {
                                ConnectByBluetoothFragment.this.mBtAdapter.cancelDiscovery();
                            } else {
                                ConnectByBluetoothFragment.this.latestDevices.clear();
                            }
                            ConnectByBluetoothFragment.this.isCancelScan = false;
                            ConnectByBluetoothFragment.this.mBtAdapter.startDiscovery();
                            p051j0.a.d(ConnectByBluetoothFragment.this.TAG, "开始扫描");
                        }
                    }
                });
            }
        };
        this.quickAdapter.setOnItemClickListener(new com.library.base.util.recyclerview.e() { // from class: com.appdev.standard.page.bluetooth.ConnectByBluetoothFragment.3
            @Override // com.library.base.util.recyclerview.e
            public void onItemClick(View view, int i5) {
                final BluetoothDevice bluetoothDevice = (BluetoothDevice) ConnectByBluetoothFragment.this.quickAdapter.getItem(i5);
                if (p051j0.f.getPrintDeviceAddress().equals(bluetoothDevice.getAddress()) && E.n()) {
                    androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_PRINT_DEVICE_INFO);
                    return;
                }
                if (!ConnectByBluetoothFragment.this.mBtAdapter.isEnabled()) {
                    ConnectByBluetoothFragment.this.srlConnectPrintDevices.k();
                    p042h2.d.show(p113u.g.toast_16);
                    return;
                }
                ConnectByBluetoothFragment.this.mBtAdapter.cancelDiscovery();
                ConnectByBluetoothFragment.this.isCancelScan = true;
                ConnectByBluetoothFragment.this.srlConnectPrintDevices.k();
                w.f(ConnectByBluetoothFragment.this.getString(p113u.g.text_264));
                new Thread() { // from class: com.appdev.standard.page.bluetooth.ConnectByBluetoothFragment.3.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        super.run();
                        p051j0.f.connectBluetoothDevice(bluetoothDevice.getAddress());
                    }
                }.start();
            }

            @Override // com.library.base.util.recyclerview.e
            public void onItemLongClick(View view, int i5) {
            }
        });
        if (!Y.f(p051j0.f.getPrintDeviceAddress())) {
            try {
                if (E.n()) {
                    addBluetooth(this.mBtAdapter.getRemoteDevice(p051j0.f.getPrintDeviceAddress()));
                }
            } catch (Exception unused) {
                p051j0.a.d(this.TAG, "initComponent: errorPrintDeviceAddress   " + p051j0.f.getPrintDeviceAddress());
            }
        }
        this.srlConnectPrintDevices.h();
    }

    @Override // com.library.base.frame.e
    public int layoutId() {
        return p113u.e.fragment_connect_by_bluetooth;
    }

    @k(threadMode = ThreadMode.MAIN)
    public void onDeviceEvent(i iVar) {
        p051j0.a.k(this.TAG, "isShow=" + iVar.b);
        refreshBtDevices();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        try {
            if (this.isHasPermission) {
                BluetoothAdapter bluetoothAdapter = this.mBtAdapter;
                if (bluetoothAdapter != null && bluetoothAdapter.isDiscovering()) {
                    this.mBtAdapter.cancelDiscovery();
                    this.isCancelScan = true;
                    p051j0.a.d(this.TAG, "蓝牙连接暂停扫描");
                }
                getContext().unregisterReceiver(this.mReceiver);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.device.action.FOUND");
        intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        getContext().registerReceiver(this.mReceiver, intentFilter);
        super.onResume();
        if (this.quickAdapter == null || Y.f(p051j0.f.getPrintDeviceAddress()) || this.quickAdapter.getItemCount() == 0) {
            return;
        }
        this.quickAdapter.notifyDataSetChanged();
    }

    @Override // com.library.base.frame.e
    public void refreshUI() {
    }
}
