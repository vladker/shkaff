package com.appdev.standard.page.bluetooth;

import S4.k;
import android.content.res.Resources;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.appdev.constant.DefaultRouteConstant;
import com.library.base.widget.AutoNullDisplayView;
import com.orhanobut.hawk.Hawk;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import p050j.w;
import p137y.i;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ConnectByUsbFragment extends com.library.base.frame.f {
    private static final String BLUETOOTH_CONTENT_ADDRESS_LIST = "BluetoothContentAddressList";

    @BindView(4869)
    AutoNullDisplayView audvConnectPrintDevices;
    private List<String> bluetoothContentAddressList;
    private com.library.base.util.recyclerview.f quickAdapter;

    @BindView(5818)
    RecyclerView rvConnectPrintDevices;

    @BindView(5924)
    SmartRefreshLayout srlConnectPrintDevices;

    private void clearOtherDevices() {
        ArrayList arrayList = new ArrayList();
        Iterator<Object> it = this.quickAdapter.getData().iterator();
        while (it.hasNext()) {
            UsbDevice usbDevice = (UsbDevice) it.next();
            if (p146z2.b.getUsbDeviceAddress(usbDevice).equals(p051j0.f.getPrintDeviceAddress())) {
                arrayList.add(usbDevice);
            }
        }
        this.quickAdapter.replaceAll(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initComponent$0(I2.f fVar) {
        refreshUI();
        ((SmartRefreshLayout) fVar).k();
    }

    private void refreshUsbDevices() {
        ArrayList arrayList = new ArrayList();
        Iterator<Object> it = this.quickAdapter.getData().iterator();
        while (it.hasNext()) {
            UsbDevice usbDevice = (UsbDevice) it.next();
            if (p146z2.b.getUsbDeviceAddress(usbDevice).equals(p051j0.f.getPrintDeviceAddress())) {
                arrayList.add(usbDevice);
            }
        }
        Iterator<Object> it2 = this.quickAdapter.getData().iterator();
        while (it2.hasNext()) {
            UsbDevice usbDevice2 = (UsbDevice) it2.next();
            if (!p146z2.b.getUsbDeviceAddress(usbDevice2).equals(p051j0.f.getPrintDeviceAddress())) {
                arrayList.add(usbDevice2);
            }
        }
        this.quickAdapter.replaceAll(arrayList);
    }

    @Override // com.library.base.frame.e
    public void initComponent() {
        registerEventBus();
        this.bluetoothContentAddressList = (List) Hawk.get(BLUETOOTH_CONTENT_ADDRESS_LIST, new ArrayList());
        SmartRefreshLayout smartRefreshLayout = this.srlConnectPrintDevices;
        smartRefreshLayout.f3760x0 = true;
        smartRefreshLayout.f3695D = false;
        this.quickAdapter = new com.library.base.util.recyclerview.f(getContext(), p113u.e.item_connect_print_devices_by_usb) { // from class: com.appdev.standard.page.bluetooth.ConnectByUsbFragment.1
            @Override // com.library.base.util.recyclerview.b
            public void convert(com.library.base.util.recyclerview.a aVar, UsbDevice usbDevice) {
                LinearLayout linearLayout = (LinearLayout) aVar.a(p113u.d.ll_item_connect_print_devices_by_usb);
                ImageView imageView = (ImageView) aVar.a(p113u.d.iv_item_connect_print_devices_by_usb_img);
                TextView textView = (TextView) aVar.a(p113u.d.tv_item_connect_print_devices_by_usb_name);
                textView.setText(usbDevice.getProductName());
                String usbDeviceAddress = p146z2.b.getUsbDeviceAddress(usbDevice);
                aVar.b(p113u.d.tv_item_connect_print_devices_by_usb_info, usbDeviceAddress);
                TextView textView2 = (TextView) aVar.a(p113u.d.tv_item_connect_print_devices_by_usb_connect_state);
                if (p051j0.f.getPrintDeviceAddress().equals(usbDeviceAddress)) {
                    textView2.setVisibility(0);
                    linearLayout.setBackgroundResource(p113u.c.bg_ffffff_rad_10_stroke_ffae00);
                    textView2.setText(ConnectByUsbFragment.this.getString(p113u.g.text_82));
                    Resources resources = ConnectByUsbFragment.this.getResources();
                    int i5 = p113u.a.color_FFAE00;
                    textView2.setTextColor(resources.getColor(i5));
                    textView.setTextColor(ConnectByUsbFragment.this.getResources().getColor(i5));
                    imageView.setImageResource(p113u.f.ic_connect_print_connect);
                    return;
                }
                if (!ConnectByUsbFragment.this.bluetoothContentAddressList.contains(usbDeviceAddress)) {
                    textView2.setVisibility(8);
                    textView.setTextColor(ConnectByUsbFragment.this.getResources().getColor(p113u.a.color_555555));
                    linearLayout.setBackgroundResource(p113u.c.bg_ffffff_rad_10_stroke_eeeeee);
                    imageView.setImageResource(p113u.f.ic_connect_print_connect_not);
                    return;
                }
                textView2.setVisibility(0);
                linearLayout.setBackgroundResource(p113u.c.bg_ffffff_rad_10_stroke_eeeeee);
                textView2.setText(ConnectByUsbFragment.this.getResources().getString(p113u.g.text_194));
                textView2.setTextColor(ConnectByUsbFragment.this.getResources().getColor(p113u.a.color_999999));
                textView.setTextColor(ConnectByUsbFragment.this.getResources().getColor(p113u.a.color_555555));
                imageView.setImageResource(p113u.f.ic_connect_print_connect_not);
            }
        };
        this.rvConnectPrintDevices.setLayoutManager(new LinearLayoutManager(getContext()));
        this.rvConnectPrintDevices.setAdapter(this.quickAdapter);
        this.audvConnectPrintDevices.b(p113u.f.ic_print_no_data);
        this.audvConnectPrintDevices.setConnect(getString(p113u.g.text_283));
        this.audvConnectPrintDevices.setButtonWhetherVisible(false);
        this.srlConnectPrintDevices.f3691A0 = new L2.e() { // from class: com.appdev.standard.page.bluetooth.a
            @Override // L2.e
            public final void onRefresh(I2.f fVar) {
                this.f2679a.lambda$initComponent$0(fVar);
            }
        };
        this.quickAdapter.setOnItemClickListener(new com.library.base.util.recyclerview.e() { // from class: com.appdev.standard.page.bluetooth.ConnectByUsbFragment.2
            @Override // com.library.base.util.recyclerview.e
            public void onItemClick(View view, int i5) {
                final UsbDevice usbDevice = (UsbDevice) ConnectByUsbFragment.this.quickAdapter.getItem(i5);
                String printDeviceAddress = p051j0.f.getPrintDeviceAddress();
                final String usbDeviceAddress = p146z2.b.getUsbDeviceAddress(usbDevice);
                if (printDeviceAddress.equals(usbDeviceAddress)) {
                    androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_PRINT_DEVICE_INFO);
                } else {
                    w.f(ConnectByUsbFragment.this.getString(p113u.g.text_264));
                    new Thread() { // from class: com.appdev.standard.page.bluetooth.ConnectByUsbFragment.2.1
                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            super.run();
                            p051j0.f.connectUsbDevice(usbDevice.getDeviceName(), usbDeviceAddress);
                        }
                    }.start();
                }
            }

            @Override // com.library.base.util.recyclerview.e
            public void onItemLongClick(View view, int i5) {
            }
        });
    }

    @Override // com.library.base.frame.e
    public int layoutId() {
        return p113u.e.fragment_connect_by_usb;
    }

    @k(threadMode = ThreadMode.MAIN)
    public void onDeviceEvent(i iVar) {
        refreshUsbDevices();
    }

    @Override // com.library.base.frame.e
    public void refreshUI() {
        clearOtherDevices();
        HashMap<String, UsbDevice> deviceList = ((UsbManager) getContext().getSystemService("usb")).getDeviceList();
        this.quickAdapter.clear();
        Iterator<UsbDevice> it = deviceList.values().iterator();
        while (it.hasNext()) {
            this.quickAdapter.add(it.next());
        }
        refreshUsbDevices();
    }
}
