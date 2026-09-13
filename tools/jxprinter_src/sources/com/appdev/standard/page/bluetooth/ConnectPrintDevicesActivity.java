package com.appdev.standard.page.bluetooth;

import S4.k;
import android.bluetooth.BluetoothAdapter;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.dialog.OpenBluetoothDialog;
import com.appdev.standard.dialog.OpenBluetoothFailedDialog;
import com.appdev.standard.dialog.PermissionTipDialog;
import com.appdev.standard.dialog.z;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.containers.FlutterBoostFragment;
import com.library.base.frame.MvpActivity;
import java.util.HashMap;
import org.greenrobot.eventbus.ThreadMode;
import p050j.w;
import p134x2.K0;
import p134x2.L0;
import p134x2.M0;
import p137y.i;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = DefaultRouteConstant.ACTIVITY_CONNECT_PRINT_DEVICES)
public class ConnectPrintDevicesActivity extends MvpActivity {
    private Fragment[] fragments = null;
    boolean isDeviceLogin;

    @BindView(5425)
    LinearLayout llNetworkGuide;

    @BindView(6048)
    TextView tvConnectByBluetooth;

    @BindView(6049)
    TextView tvConnectByUsb;

    @BindView(6050)
    TextView tvConnectByWifi;

    @BindView(6274)
    TextView tvTitle;

    /* JADX INFO: renamed from: com.appdev.standard.page.bluetooth.ConnectPrintDevicesActivity$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass1 implements p026e2.a {
        public AnonymousClass1() {
        }

        @Override // p026e2.a
        public void onRequestPermissionFail() {
            p051j0.a.l();
        }

        @Override // p026e2.a
        public void onRequestPermissionSuccess() {
            p051j0.a.m();
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter == null) {
                p042h2.d.show(p113u.g.toast_33);
            } else {
                if (defaultAdapter.isEnabled()) {
                    ConnectPrintDevicesActivity.this.initFragment();
                    return;
                }
                OpenBluetoothDialog openBluetoothDialog = new OpenBluetoothDialog(ConnectPrintDevicesActivity.this);
                openBluetoothDialog.f2622a = new z() { // from class: com.appdev.standard.page.bluetooth.ConnectPrintDevicesActivity.1.1
                    @Override // com.appdev.standard.dialog.z
                    public void onCancel() {
                        new OpenBluetoothFailedDialog(ConnectPrintDevicesActivity.this).show();
                    }

                    @Override // com.appdev.standard.dialog.z
                    public void onConfirm() {
                        ConnectPrintDevicesActivity.this.openBluetooth(new com.library.base.frame.b() { // from class: com.appdev.standard.page.bluetooth.ConnectPrintDevicesActivity.1.1.1
                            @Override // com.library.base.frame.b
                            public void openBluetoothSuccess() {
                                ConnectPrintDevicesActivity.this.initFragment();
                            }
                        });
                    }
                };
                openBluetoothDialog.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initFragment() {
        this.fragments = new Fragment[]{new ConnectByBluetoothFragment(), new ConnectByUsbFragment(), new FlutterBoostFragment.CachedEngineFragmentBuilder().shouldAttachEngineToActivity(false).url("wifi_device_list").uniqueId("wifi_device_list").build()};
        K0 printer = p051j0.f.getPrinter();
        if (printer == null) {
            switchFragment(0);
            return;
        }
        M0 printerDevice = printer.getPrinterDevice();
        if (printerDevice == null) {
            switchFragment(0);
            return;
        }
        if (printerDevice.getPrinterType() == L0.f8859a) {
            switchFragment(0);
        } else if (printerDevice.getPrinterType() == L0.b) {
            switchFragment(1);
        } else {
            switchFragment(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initComponent$0(View view) {
        showNetworkGuide();
    }

    private void showFragment(Fragment fragment) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (this.currentFragment != fragment) {
            FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
            Fragment fragment2 = this.currentFragment;
            if (fragment2 != null) {
                fragmentTransactionBeginTransaction.hide(fragment2);
            }
            this.currentFragment = fragment;
            if (fragment.isAdded()) {
                fragmentTransactionBeginTransaction.show(fragment).commitAllowingStateLoss();
            } else if (fragment instanceof FlutterBoostFragment) {
                fragmentTransactionBeginTransaction.add(p113u.d.fl_connect_print_devices, fragment, ((FlutterBoostFragment) fragment).getUniqueId()).show(fragment).commitAllowingStateLoss();
            } else {
                fragmentTransactionBeginTransaction.add(p113u.d.fl_connect_print_devices, fragment).show(fragment).commitAllowingStateLoss();
            }
        }
    }

    private void showNetworkGuide() {
        ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_AGREEMENT).withInt("agreement_type", 4).navigation();
    }

    private void switchFragment(int i5) {
        if (this.fragments == null) {
            return;
        }
        this.tvConnectByBluetooth.setBackgroundDrawable(null);
        TextView textView = this.tvConnectByBluetooth;
        Resources resources = getResources();
        int i6 = p113u.a.color_999999;
        textView.setTextColor(resources.getColor(i6));
        this.tvConnectByUsb.setBackgroundDrawable(null);
        this.tvConnectByUsb.setTextColor(getResources().getColor(i6));
        this.tvConnectByWifi.setBackgroundDrawable(null);
        this.tvConnectByWifi.setTextColor(getResources().getColor(i6));
        if (i5 == 2) {
            this.llNetworkGuide.setVisibility(0);
        } else {
            this.llNetworkGuide.setVisibility(8);
        }
        if (i5 == 0) {
            this.tvConnectByBluetooth.setBackground(getResources().getDrawable(p113u.c.layer_underline_ffae00));
            this.tvConnectByBluetooth.setTextColor(getResources().getColor(p113u.a.color_FFAE00));
        } else if (i5 == 1) {
            this.tvConnectByUsb.setBackground(getResources().getDrawable(p113u.c.layer_underline_ffae00));
            this.tvConnectByUsb.setTextColor(getResources().getColor(p113u.a.color_FFAE00));
        } else if (i5 == 2) {
            this.tvConnectByWifi.setBackground(getResources().getDrawable(p113u.c.layer_underline_ffae00));
            this.tvConnectByWifi.setTextColor(getResources().getColor(p113u.a.color_FFAE00));
        }
        try {
            showFragment(this.fragments[i5]);
        } catch (ArrayIndexOutOfBoundsException unused) {
            p051j0.a.d(this.TAG, "数据越界");
        }
    }

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initComponent() {
        registerEventBus();
        super.initComponent();
        this.tvTitle.setText(getString(p113u.g.text_223));
        if (this.isDeviceLogin || p042h2.e.f4031a.g()) {
            needBlueToothPermission(new PermissionTipDialog(this, getString(p113u.g.text_258)), new AnonymousClass1());
        } else {
            ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_LOGIN).navigation();
            finishActivity();
        }
        if (Build.VERSION.SDK_INT >= 30) {
            WindowInsetsController insetsController = getWindow().getInsetsController();
            if (insetsController != null) {
                insetsController.show(WindowInsets.Type.statusBars());
                insetsController.setSystemBarsAppearance(8, 8);
            }
        } else {
            getWindow().getDecorView().setSystemUiVisibility(9472);
        }
        this.llNetworkGuide.setOnClickListener(new b(this, 0));
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public int layoutId() {
        return p113u.e.activity_connect_print_devices;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
    }

    public void onConnectByBluetoothClick(View view) {
        switchFragment(0);
    }

    public void onConnectByUSBClick(View view) {
        switchFragment(1);
    }

    public void onConnectByWifiClick(View view) {
        switchFragment(2);
    }

    @Override // com.library.base.frame.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(null);
    }

    @k(threadMode = ThreadMode.MAIN)
    public void onDeviceEvent(i iVar) {
        w.c();
        FlutterBoost.instance().sendEventToFlutter("refresh_wifi_list", new HashMap());
        if (iVar.b) {
            int i5 = iVar.f9014a;
            if (i5 == 1) {
                p042h2.d.show(p113u.g.toast_17);
                return;
            }
            if (i5 == 2) {
                p042h2.d.show(p113u.g.toast_18);
                return;
            }
            if (i5 != 3) {
                if (i5 != 4) {
                    if (i5 != 5) {
                        return;
                    }
                    p042h2.d.show(p113u.g.toast_20);
                    return;
                }
                p042h2.d.show(p113u.g.toast_18);
            }
            p042h2.d.show(p113u.g.toast_19);
        }
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void receiveDataFromPreActivity(Bundle bundle) {
        this.isDeviceLogin = bundle.getBoolean("isDeviceLogin", false);
    }
}
