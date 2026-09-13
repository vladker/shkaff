package com.appdev.standard.page.bluetooth;

import S4.k;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.BindView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.api.dto.VersionDataDto;
import com.appdev.standard.dialog.DefaultTipDialog;
import com.appdev.standard.dialog.V;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.FlutterBoostRouteOptions;
import com.library.base.frame.MvpActivity;
import com.orhanobut.hawk.Hawk;
import java.util.HashMap;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.greenrobot.eventbus.ThreadMode;
import p050j.w;
import p134x2.K;
import p134x2.K0;
import p134x2.P0;
import p137y.j;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = DefaultRouteConstant.ACTIVITY_PRINT_DEVICE_INFO)
public class PrintDeviceInfoActivity extends MvpActivity {
    private Context context;

    @BindView(5291)
    ImageView ivPrintDeviceInfoSetting;

    @BindView(5468)
    LinearLayout llPrintDeviceInfo;

    @BindView(5469)
    LinearLayout llPrintDeviceInfoError;

    @BindView(5470)
    LinearLayout llPrintDeviceInfoErrorCuttingKnife;

    @BindView(5471)
    LinearLayout llPrintDeviceInfoErrorLack;

    @BindView(5472)
    LinearLayout llPrintDeviceInfoErrorOpen;

    @BindView(5473)
    LinearLayout llPrintDeviceInfoErrorTemperature;

    @BindView(5513)
    LinearLayout llZip;
    private PrintSetting mCustomPopWindow;
    private P0 printerInfo;

    @BindView(5779)
    RadioButton rbZipNo;

    @BindView(5780)
    RadioButton rbZipYes;

    @BindView(5797)
    RadioGroup rgZipGroup;

    @BindView(6228)
    TextView tvPrintDeviceCmdMode;

    @BindView(6229)
    TextView tvPrintDeviceCodeType;

    @BindView(6230)
    TextView tvPrintDeviceCodepage;

    @BindView(6227)
    TextView tvPrintDeviceDPIType;

    @BindView(6231)
    TextView tvPrintDeviceDepthLev;

    @BindView(6232)
    TextView tvPrintDeviceFactoryName;

    @BindView(6233)
    TextView tvPrintDeviceInfoAddress;

    @BindView(6234)
    TextView tvPrintDeviceInfoName;

    @BindView(6235)
    TextView tvPrintDeviceMaxDotLine;

    @BindView(6236)
    TextView tvPrintDeviceNfcEnable;

    @BindView(6237)
    TextView tvPrintDevicePaperType;

    @BindView(6238)
    TextView tvPrintDevicePowerLev;

    @BindView(6239)
    TextView tvPrintDevicePtStatus;

    @BindView(6244)
    TextView tvPrintDeviceSpeedLev;

    @BindView(6245)
    TextView tvPrintDeviceVersion;

    @BindView(6274)
    TextView tvTitle;
    TextView tvUpdateVersion;
    private V updateDeviceDialog;
    private p031f0.a versionDataWorker;
    private VersionDataDto versionData = null;
    private boolean isUpdatingZipSetting = false;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface OnSettingListener {
        void onSetting(P0 p1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onPrintCheckClick$4() {
        w.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPrintCheckClick$5() {
        K0 printer = p051j0.f.getPrinter();
        if (printer == null) {
            return;
        }
        if (printer.selfCheckSync().b()) {
            runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.bluetooth.PrintDeviceInfoActivity.5
                @Override // java.lang.Runnable
                public void run() {
                    w.c();
                }
            });
        } else {
            runOnUiThread(new f(3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$updatePrintInfoUi$3(RadioGroup radioGroup, int i5) {
        if (this.isUpdatingZipSetting) {
            return;
        }
        boolean z6 = i5 == p113u.d.rb_print_device_setting_zip_yes;
        if (!z6 || p042h2.e.f4031a.h()) {
            updateZipSetting(z6);
            return;
        }
        this.isUpdatingZipSetting = true;
        try {
            showVipTipDialog();
            this.rbZipNo.setChecked(true);
        } finally {
            this.isUpdatingZipSetting = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateZipSetting$0(boolean z6) {
        p042h2.d.show(p113u.g.text_524);
        this.printerInfo.setZipEnable(z6 ? TarConstants.VERSION_POSIX : "01");
        p051j0.a.n(this.printerInfo);
        updateUI();
        this.isUpdatingZipSetting = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateZipSetting$1(K k6, boolean z6) {
        if (k6.b()) {
            p042h2.d.show(p113u.g.text_523);
        } else {
            p042h2.d.show(p113u.g.text_524);
            this.printerInfo.setZipEnable(z6 ? TarConstants.VERSION_POSIX : "01");
            p051j0.a.n(this.printerInfo);
        }
        updateUI();
        this.isUpdatingZipSetting = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateZipSetting$2(boolean z6) {
        p051j0.a.n(this.printerInfo);
        Hawk.put("isUseZip", Boolean.valueOf(z6));
        K0 printer = p051j0.f.getPrinter();
        if (printer == null) {
            runOnUiThread(new c(this, z6, 1));
        } else {
            runOnUiThread(new d(this, printer.updateSettingSync(this.printerInfo), z6));
        }
    }

    private void refreshDeviceStateEvent(j jVar) {
        boolean z6 = jVar.b;
        boolean z7 = jVar.c;
        boolean z8 = jVar.d;
        boolean z9 = jVar.f9015a;
        if (!z6 && !z9 && !z8 && !z7) {
            this.llPrintDeviceInfoError.setVisibility(8);
            this.tvPrintDevicePtStatus.setText(getString(p113u.g.text_63) + getString(p113u.g.text_268));
            return;
        }
        this.llPrintDeviceInfoError.setVisibility(0);
        if (jVar.b) {
            this.llPrintDeviceInfoErrorLack.setVisibility(0);
        } else {
            this.llPrintDeviceInfoErrorLack.setVisibility(8);
        }
        if (z9) {
            this.llPrintDeviceInfoErrorOpen.setVisibility(0);
        } else {
            this.llPrintDeviceInfoErrorOpen.setVisibility(8);
        }
        if (z8) {
            this.llPrintDeviceInfoErrorTemperature.setVisibility(0);
        } else {
            this.llPrintDeviceInfoErrorTemperature.setVisibility(8);
        }
        if (z7) {
            this.llPrintDeviceInfoErrorCuttingKnife.setVisibility(0);
        } else {
            this.llPrintDeviceInfoErrorCuttingKnife.setVisibility(8);
        }
        this.tvPrintDevicePtStatus.setText(getString(p113u.g.text_63) + getString(p113u.g.text_269));
    }

    private void showVipTipDialog() {
        DefaultTipDialog defaultTipDialog = new DefaultTipDialog(this);
        defaultTipDialog.e("");
        defaultTipDialog.c(getString(p113u.g.text_246));
        defaultTipDialog.a(getString(p113u.g.text_254));
        defaultTipDialog.b(getString(p113u.g.text_255));
        defaultTipDialog.f2608a = new com.bumptech.glide.f() { // from class: com.appdev.standard.page.bluetooth.PrintDeviceInfoActivity.2
            @Override // com.library.base.frame.d
            public void onConfirm() {
                androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_MEMBER_CENTER);
            }

            @Override // com.library.base.frame.d
            public void onCancel() {
            }
        };
        defaultTipDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePrintInfoUi(P0 p1) {
        this.tvPrintDeviceInfoName.setText(p1.getDeviceName());
        this.tvPrintDeviceInfoAddress.setText(p1.getDeviceAddress());
        this.tvPrintDeviceFactoryName.setText(getString(p113u.g.text_61) + p1.getFactoryName());
        TextView textView = this.tvPrintDeviceDPIType;
        StringBuilder sb = new StringBuilder();
        sb.append(getString(p113u.g.text_62));
        sb.append(TarConstants.VERSION_POSIX.equals(p1.getDpiType()) ? "203DPI" : "300DPI");
        textView.setText(sb.toString());
        TextView textView2 = this.tvPrintDevicePtStatus;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getString(p113u.g.text_63));
        sb2.append(getString(TarConstants.VERSION_POSIX.equals(p1.getPtStatus()) ? p113u.g.text_268 : p113u.g.text_269));
        textView2.setText(sb2.toString());
        this.tvPrintDeviceMaxDotLine.setText(getString(p113u.g.text_64) + p1.d);
        TextView textView3 = this.tvPrintDeviceCodepage;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(getString(p113u.g.text_65));
        String strValueOf = String.valueOf(Integer.parseInt(p1.getCodepage(), 16));
        p046i0.a[] aVarArr = p046i0.a.c;
        String string = getString(p113u.g.text_344);
        if (strValueOf != null) {
            for (p046i0.a aVar : p046i0.a.values()) {
                if (strValueOf.equals(aVar.f4043a)) {
                    string = getString(aVar.b);
                    break;
                }
            }
        }
        sb3.append(string);
        textView3.setText(sb3.toString());
        TextView textView4 = this.tvPrintDeviceCodeType;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(getString(p113u.g.text_66));
        String codeType = p1.getCodeType();
        String string2 = getString(p113u.g.text_395);
        if (codeType != null) {
            if (codeType.equals("C1")) {
                string2 = "UNICODE";
            } else if (codeType.equals("C2")) {
                string2 = "UTF8";
            } else if (codeType.equals("C3")) {
                string2 = "CODEPAGE";
            }
        }
        sb4.append(string2);
        textView4.setText(sb4.toString());
        TextView textView5 = this.tvPrintDevicePowerLev;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(getString(p113u.g.text_67));
        sb5.append("FF".equals(p1.getPowerLev()) ? getString(p113u.g.text_270) : String.valueOf(Integer.valueOf(p1.getPowerLev(), 16)).concat("%"));
        textView5.setText(sb5.toString());
        this.tvPrintDeviceDepthLev.setText(getString(p113u.g.text_68) + p1.e);
        TextView textView6 = this.tvPrintDeviceSpeedLev;
        StringBuilder sb6 = new StringBuilder();
        sb6.append(getString(p113u.g.text_69));
        String devType = p1.getDevType();
        String speedLev = p1.getSpeedLev();
        int i5 = p113u.g.text_396;
        String string3 = getString(i5);
        if ("03".equals(devType) || "04".equals(devType)) {
            speedLev.getClass();
            switch (speedLev) {
                case "00":
                case "01":
                case "02":
                    string3 = "50";
                    break;
                case "03":
                    string3 = "80";
                    break;
                case "04":
                    string3 = "100";
                    break;
                case "05":
                    string3 = "125";
                    break;
                case "06":
                    string3 = "150";
                    break;
                case "07":
                    string3 = "180";
                    break;
                case "08":
                    string3 = "200";
                    break;
                case "09":
                    string3 = "220";
                    break;
                case "10":
                    string3 = "240";
                    break;
                default:
                    string3 = getString(i5);
                    break;
            }
        } else if ("02".equals(speedLev)) {
            string3 = getString(p113u.g.text_435);
        } else if ("01".equals(speedLev)) {
            string3 = getString(p113u.g.text_436);
        } else if (TarConstants.VERSION_POSIX.equals(speedLev)) {
            string3 = getString(p113u.g.text_437);
        }
        sb6.append(string3);
        textView6.setText(sb6.toString());
        TextView textView7 = this.tvPrintDeviceCmdMode;
        StringBuilder sb7 = new StringBuilder();
        sb7.append(getString(p113u.g.text_70));
        sb7.append("01".equals(p1.getCmdMode()) ? "ESC" : "TSC");
        textView7.setText(sb7.toString());
        TextView textView8 = this.tvPrintDevicePaperType;
        StringBuilder sb8 = new StringBuilder();
        sb8.append(getString(p113u.g.text_71));
        String paperType = p1.getPaperType();
        p046i0.b[] bVarArr = p046i0.b.c;
        String string4 = getString(p113u.g.text_343);
        if (paperType != null) {
            for (p046i0.b bVar : p046i0.b.values()) {
                if (paperType.equals(bVar.f4044a)) {
                    string4 = getString(bVar.b);
                }
            }
        }
        sb8.append(string4);
        textView8.setText(sb8.toString());
        TextView textView9 = this.tvPrintDeviceNfcEnable;
        StringBuilder sb9 = new StringBuilder();
        sb9.append(getString(p113u.g.text_72));
        sb9.append(getString(TarConstants.VERSION_POSIX.equals(p1.getNfcEnable()) ? p113u.g.text_214 : p113u.g.text_213));
        textView9.setText(sb9.toString());
        this.tvPrintDeviceVersion.setText(getString(p113u.g.text_73) + p1.c);
        this.llZip.setVisibility(0);
        if (!p042h2.e.f4031a.h()) {
            p1.setZipEnable(TarConstants.VERSION_POSIX);
            p051j0.a.n(p1);
            Hawk.put("isUseZip", Boolean.FALSE);
        }
        String zipEnable = p1.getZipEnable();
        this.rbZipYes.setChecked("01".equals(zipEnable));
        this.rbZipNo.setChecked(TarConstants.VERSION_POSIX.equals(zipEnable));
        this.rgZipGroup.setOnCheckedChangeListener(null);
        this.rgZipGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.appdev.standard.page.bluetooth.e
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i6) {
                this.f2683a.lambda$updatePrintInfoUi$3(radioGroup, i6);
            }
        });
        j jVar = (j) Hawk.get("LastDeviceState", null);
        if (jVar != null) {
            refreshDeviceStateEvent(jVar);
        }
    }

    private void updateUI() {
        String zipEnable = this.printerInfo.getZipEnable();
        this.rbZipYes.setChecked("01".equals(zipEnable));
        this.rbZipNo.setChecked(TarConstants.VERSION_POSIX.equals(zipEnable));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0024 A[Catch: all -> 0x0022, TRY_ENTER, TryCatch #0 {all -> 0x0022, blocks: (B:7:0x000b, B:9:0x0013, B:16:0x0024, B:20:0x002d), top: B:30:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:18:0x0028  */
    /* JADX WARN: Code duplicated, block: B:19:0x002b  */
    /* JADX WARN: Code duplicated, block: B:23:0x0042 A[DONT_GENERATE] */
    private void updateZipSetting(boolean z6) {
        String str;
        if (this.isUpdatingZipSetting) {
            return;
        }
        this.isUpdatingZipSetting = true;
        if (z6) {
            try {
                if (p042h2.e.f4031a.h()) {
                    P0 p1 = this.printerInfo;
                    if (z6) {
                        str = "01";
                    } else {
                        str = TarConstants.VERSION_POSIX;
                    }
                    p1.setZipEnable(str);
                    new Thread(new c(this, z6, 0)).start();
                } else {
                    showVipTipDialog();
                    this.rbZipNo.setChecked(true);
                }
            } finally {
                if (!this.isUpdatingZipSetting) {
                    this.isUpdatingZipSetting = false;
                }
            }
        } else {
            P0 p6 = this.printerInfo;
            if (z6) {
                str = "01";
            } else {
                str = TarConstants.VERSION_POSIX;
            }
            p6.setZipEnable(str);
            new Thread(new c(this, z6, 0)).start();
        }
    }

    public void getVersionDataFailed(int i5, String str) {
        this.tvUpdateVersion.setVisibility(8);
    }

    public void getVersionDataSuccess(VersionDataDto versionDataDto) {
        if (this.printerInfo.c < Integer.valueOf(versionDataDto.getData().getVersion()).intValue()) {
            this.tvUpdateVersion.setVisibility(8);
        } else {
            this.tvUpdateVersion.setVisibility(0);
            this.versionData = versionDataDto;
        }
    }

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initComponent() {
        registerEventBus();
        super.initComponent();
        this.tvTitle.setText(getString(p113u.g.text_228));
        this.context = this;
        V v6 = new V(this, p113u.h.Dialog);
        v6.setContentView(p113u.e.dialog_update_device);
        v6.setCanceledOnTouchOutside(false);
        this.updateDeviceDialog = v6;
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initData() {
        super.initData();
        P0 p0H = p051j0.a.h();
        this.printerInfo = p0H;
        if (p0H != null) {
            updatePrintInfoUi(p0H);
        } else {
            w.f(getResources().getString(p113u.g.toast_44));
            runOnNewThread(new Runnable() { // from class: com.appdev.standard.page.bluetooth.PrintDeviceInfoActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    PrintDeviceInfoActivity.this.printerInfo = p051j0.f.read_print_info();
                    PrintDeviceInfoActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.bluetooth.PrintDeviceInfoActivity.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (PrintDeviceInfoActivity.this.printerInfo != null) {
                                    p051j0.a.n(PrintDeviceInfoActivity.this.printerInfo);
                                    PrintDeviceInfoActivity printDeviceInfoActivity = PrintDeviceInfoActivity.this;
                                    printDeviceInfoActivity.updatePrintInfoUi(printDeviceInfoActivity.printerInfo);
                                }
                                w.c();
                            } catch (NumberFormatException e) {
                                w.c();
                                p042h2.d.show(p113u.g.toast_1);
                                throw new RuntimeException(e);
                            }
                        }
                    });
                }
            });
        }
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public int layoutId() {
        return p113u.e.activity_print_device_info;
    }

    public void onDeviceInfoSettingClick(View view) {
        if (this.printerInfo == null) {
            return;
        }
        PrintSetting printSetting = new PrintSetting(new PrintSetting.OnSettingListener() { // from class: com.appdev.standard.page.bluetooth.PrintDeviceInfoActivity.3
            @Override // com.appdev.standard.page.bluetooth.PrintSetting.OnSettingListener
            public void onSetting(P0 p1) {
                PrintDeviceInfoActivity.this.updatePrintInfoUi(p1);
            }
        });
        this.mCustomPopWindow = printSetting;
        printSetting.showSetting(this, this.llPrintDeviceInfo);
    }

    @k(threadMode = ThreadMode.MAIN)
    public void onDeviceStateEvent(j jVar) {
        refreshDeviceStateEvent(jVar);
    }

    public void onPrintCheckClick(View view) {
        w.e();
        runOnNewThread(new g(this, 2));
    }

    public void onPrintDisConnectClick(View view) {
        p051j0.f.disconnectDevice();
        finish();
    }

    public void onPrintResetClick(View view) {
        DefaultTipDialog defaultTipDialog = new DefaultTipDialog(this);
        defaultTipDialog.e("");
        defaultTipDialog.c(getString(p113u.g.text_318));
        defaultTipDialog.a(getString(p113u.g.cancel));
        defaultTipDialog.b(getString(p113u.g.Confirm));
        defaultTipDialog.f2608a = new AnonymousClass4();
        defaultTipDialog.show();
    }

    public void onPrintToolbox(View view) {
        FlutterBoost.instance().open(new FlutterBoostRouteOptions.Builder().pageName("tool_box").arguments(new HashMap()).requestCode(0).build());
    }

    /* JADX INFO: renamed from: com.appdev.standard.page.bluetooth.PrintDeviceInfoActivity$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass4 extends com.bumptech.glide.f {
        public AnonymousClass4() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onConfirm$0() {
            w.c();
            p042h2.d.show(p113u.g.toast_27);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onConfirm$1() {
            K0 printer = p051j0.f.getPrinter();
            if (printer == null) {
                return;
            }
            if (!printer.resetPrinterSync().b()) {
                PrintDeviceInfoActivity.this.runOnUiThread(new f(0));
                return;
            }
            PrintDeviceInfoActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.bluetooth.PrintDeviceInfoActivity.4.1
                @Override // java.lang.Runnable
                public void run() {
                    w.c();
                    p042h2.d.show(p113u.g.toast_25);
                    V1.b.h().getClass();
                    Activity activity = (Activity) V1.b.b.lastElement();
                    if (activity != null) {
                        V1.b.b.remove(activity);
                        activity.finish();
                    }
                }
            });
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.library.base.frame.d
        public void onConfirm() {
            w.e();
            PrintDeviceInfoActivity.this.runOnNewThread(new g(this, 0));
        }

        @Override // com.library.base.frame.d
        public void onCancel() {
        }
    }
}
