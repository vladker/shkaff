package com.appdev.standard.page.bluetooth;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.appdev.standard.dialog.C0450c;
import com.appdev.standard.dialog.C0451d;
import com.appdev.standard.dialog.DefaultTipDialog;
import com.appdev.standard.page.printerlabel.widget.LineProgressWidget;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.apache.poi.hssf.record.BOFRecord;
import p050j.w;
import p134x2.K0;
import p134x2.P0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class PrintSetting {
    private Activity activity;
    private String cmdMode;
    private int depthLev;
    private boolean isUseZip;
    private C0451d mCustomPopWindow;
    private OnSettingListener onSettingListener;
    private String paperType;
    private P0 printerInfo = p051j0.a.h();
    private int pt2tearLen;
    private boolean saveIsUseZip;
    private String speedLev;

    /* JADX INFO: renamed from: com.appdev.standard.page.bluetooth.PrintSetting$10, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass10 implements Runnable {
        public AnonymousClass10() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$run$0() {
            w.c();
            p042h2.d.show(p113u.g.toast_24);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$1() {
            p051j0.a.n(PrintSetting.this.printerInfo);
            PrintSetting.this.onSettingListener.onSetting(PrintSetting.this.printerInfo);
            w.c();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$run$2() {
            w.c();
            p042h2.d.show(p113u.g.toast_24);
        }

        @Override // java.lang.Runnable
        public void run() {
            PrintSetting.this.printerInfo.e = PrintSetting.this.depthLev;
            PrintSetting.this.printerInfo.setSpeedLev(PrintSetting.this.speedLev);
            PrintSetting.this.printerInfo.setCmdMode(PrintSetting.this.cmdMode);
            PrintSetting.this.printerInfo.setPaperType(PrintSetting.this.paperType);
            if ("01".equals(PrintSetting.this.printerInfo.getPaperType())) {
                PrintSetting.this.printerInfo.f8870m = PrintSetting.this.pt2tearLen;
            }
            K0 printer = p051j0.f.getPrinter();
            if (printer == null) {
                PrintSetting.this.activity.runOnUiThread(new f(1));
                return;
            }
            if (!printer.updateSettingSync(PrintSetting.this.printerInfo).b()) {
                PrintSetting.this.activity.runOnUiThread(new f(2));
                return;
            }
            PrintSetting.this.activity.runOnUiThread(new g(this, 1));
            try {
                Thread.sleep(500L);
                PrintSetting.this.printerInfo = p051j0.f.update_print_info();
                PrintSetting.this.activity.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.bluetooth.PrintSetting.10.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (PrintSetting.this.printerInfo != null) {
                                PrintSetting.this.onSettingListener.onSetting(PrintSetting.this.printerInfo);
                            }
                        } catch (NumberFormatException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface OnSettingListener {
        void onSetting(P0 p1);
    }

    public PrintSetting(OnSettingListener onSettingListener) {
        this.onSettingListener = onSettingListener;
    }

    /* JADX WARN: Code duplicated, block: B:72:0x034d A[PHI: r5
  0x034d: PHI (r5v20 java.lang.Object) = (r5v18 java.lang.Object), (r5v19 java.lang.Object), (r5v21 java.lang.Object) binds: [B:71:0x034b, B:67:0x033d, B:63:0x0331] A[DONT_GENERATE, DONT_INLINE]] */
    private void handleLogic(View view) {
        Object obj;
        Object obj2;
        Object obj3;
        RadioButton radioButton;
        RadioButton radioButton2;
        RadioButton radioButton3;
        RadioButton radioButton4;
        LinearLayout linearLayout;
        byte b;
        boolean z6;
        P0 p1 = this.printerInfo;
        this.depthLev = p1.e;
        this.speedLev = p1.getSpeedLev();
        this.cmdMode = this.printerInfo.getCmdMode();
        this.paperType = this.printerInfo.getPaperType();
        ImageView imageView = (ImageView) view.findViewById(p113u.d.iv_expand);
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(p113u.d.expandable_content);
        LineProgressWidget lineProgressWidget = (LineProgressWidget) view.findViewById(p113u.d.lpw_print_device_setting_depth_lev);
        final RadioButton radioButton5 = (RadioButton) view.findViewById(p113u.d.rb_print_device_setting_speed_lev_low);
        final RadioButton radioButton6 = (RadioButton) view.findViewById(p113u.d.rb_print_device_setting_speed_lev_middle);
        final RadioButton radioButton7 = (RadioButton) view.findViewById(p113u.d.rb_print_device_setting_speed_lev_high);
        final RadioButton radioButton8 = (RadioButton) view.findViewById(p113u.d.rb_print_device_setting_speed_lev_50);
        final RadioButton radioButton9 = (RadioButton) view.findViewById(p113u.d.rb_print_device_setting_speed_lev_80);
        final RadioButton radioButton10 = (RadioButton) view.findViewById(p113u.d.rb_print_device_setting_speed_lev_100);
        final RadioButton radioButton11 = (RadioButton) view.findViewById(p113u.d.rb_print_device_setting_speed_lev_125);
        RadioButton radioButton12 = (RadioButton) view.findViewById(p113u.d.rb_print_device_setting_speed_lev_150);
        RadioButton radioButton13 = (RadioButton) view.findViewById(p113u.d.rb_print_device_setting_speed_lev_180);
        RadioButton radioButton14 = (RadioButton) view.findViewById(p113u.d.rb_print_device_setting_speed_lev_200);
        RadioButton radioButton15 = (RadioButton) view.findViewById(p113u.d.rb_print_device_setting_speed_lev_220);
        RadioButton radioButton16 = (RadioButton) view.findViewById(p113u.d.rb_print_device_setting_speed_lev_240);
        RadioButton radioButton17 = (RadioButton) view.findViewById(p113u.d.rb_print_device_setting_paper_type_lian_xu);
        RadioButton radioButton18 = (RadioButton) view.findViewById(p113u.d.rb_print_device_setting_paper_type_biao_qian);
        RadioButton radioButton19 = (RadioButton) view.findViewById(p113u.d.rb_print_device_setting_paper_type_tattoo);
        RadioButton radioButton20 = (RadioButton) view.findViewById(p113u.d.rb_print_device_setting_paper_type_hei_biao);
        TextView textView = (TextView) view.findViewById(p113u.d.tv_print_device_setting_cancel);
        TextView textView2 = (TextView) view.findViewById(p113u.d.tv_print_device_setting_save);
        LinearLayout linearLayout3 = (LinearLayout) view.findViewById(p113u.d.ll_cut);
        LineProgressWidget lineProgressWidget2 = (LineProgressWidget) view.findViewById(p113u.d.lpw_print_device_setting_cut_dist);
        final TextView textView3 = (TextView) view.findViewById(p113u.d.tv_current_value);
        final TextView textView4 = (TextView) view.findViewById(p113u.d.tv_change_value);
        final TextView textView5 = (TextView) view.findViewById(p113u.d.tv_final_value);
        RadioButton radioButton21 = radioButton12;
        imageView.setOnClickListener(new h(linearLayout2, imageView, 0));
        final int i5 = this.printerInfo.e;
        lineProgressWidget.setSmallValue(0.0f);
        lineProgressWidget.setBigValue(15.0f);
        lineProgressWidget.setPosition(i5);
        RadioButton radioButton22 = radioButton14;
        RadioButton radioButton23 = radioButton15;
        RadioButton radioButton24 = radioButton13;
        RadioButton radioButton25 = radioButton16;
        final TextView textView6 = textView2;
        lineProgressWidget.setOnRangeUpListener(new LineProgressWidget.OnRangeUpListener() { // from class: com.appdev.standard.page.bluetooth.PrintSetting.1
            @Override // com.appdev.standard.page.printerlabel.widget.LineProgressWidget.OnRangeUpListener
            public void onRangeUp(float f6) {
                PrintSetting.this.depthLev = (int) f6;
                textView3.setText(String.valueOf(PrintSetting.this.depthLev));
                textView4.setText(String.valueOf(i5 - PrintSetting.this.printerInfo.e));
                textView5.setText(String.valueOf(i5));
                if (PrintSetting.this.haveChange()) {
                    textView6.setBackgroundResource(p113u.c.bg_ffae00_rad_10);
                } else {
                    textView6.setBackgroundResource(p113u.c.bg_999999_rad_10);
                }
            }
        });
        textView3.setText(String.valueOf(this.printerInfo.e));
        textView4.setText(String.valueOf(i5 - this.printerInfo.e));
        textView5.setText(String.valueOf(i5));
        int i6 = this.printerInfo.f8870m;
        this.pt2tearLen = i6;
        lineProgressWidget2.setSmallValue(i6 - 8);
        lineProgressWidget2.setBigValue(this.pt2tearLen + 8);
        lineProgressWidget2.setPosition(this.pt2tearLen);
        lineProgressWidget2.setOnRangeUpListener(new LineProgressWidget.OnRangeUpListener() { // from class: com.appdev.standard.page.bluetooth.PrintSetting.2
            @Override // com.appdev.standard.page.printerlabel.widget.LineProgressWidget.OnRangeUpListener
            public void onRangeUp(float f6) {
                PrintSetting.this.pt2tearLen = (int) f6;
                textView3.setText(String.valueOf(PrintSetting.this.printerInfo.f8870m));
                textView4.setText(String.valueOf(PrintSetting.this.pt2tearLen - PrintSetting.this.printerInfo.f8870m));
                textView5.setText(String.valueOf(PrintSetting.this.pt2tearLen));
                if (PrintSetting.this.haveChange()) {
                    textView6.setBackgroundResource(p113u.c.bg_ffae00_rad_10);
                } else {
                    textView6.setBackgroundResource(p113u.c.bg_999999_rad_10);
                }
            }
        });
        textView3.setText(String.valueOf(this.printerInfo.f8870m));
        textView4.setText(String.valueOf(this.pt2tearLen - this.printerInfo.f8870m));
        textView5.setText(String.valueOf(this.pt2tearLen));
        byte b6 = 3;
        if (!"03".equals(this.printerInfo.getDevType()) && !"04".equals(this.printerInfo.getDevType())) {
            radioButton5.setVisibility(0);
            radioButton6.setVisibility(0);
            radioButton7.setVisibility(0);
            radioButton8.setVisibility(8);
            radioButton9.setVisibility(8);
            radioButton10.setVisibility(8);
            radioButton11.setVisibility(8);
            radioButton21.setVisibility(8);
            radioButton24 = radioButton24;
            radioButton24.setVisibility(8);
            textView6 = textView6;
            radioButton22 = radioButton22;
            radioButton22.setVisibility(8);
            radioButton23 = radioButton23;
            radioButton23.setVisibility(8);
            radioButton25 = radioButton25;
            radioButton25.setVisibility(8);
            String speedLev = this.printerInfo.getSpeedLev();
            speedLev.getClass();
            switch (speedLev) {
                case "00":
                    z6 = true;
                    radioButton5.setChecked(true);
                    obj = "01";
                    obj3 = TarConstants.VERSION_POSIX;
                    obj2 = "03";
                    break;
                case "01":
                    z6 = true;
                    radioButton6.setChecked(true);
                    obj = "01";
                    obj3 = TarConstants.VERSION_POSIX;
                    obj2 = "03";
                    break;
                case "02":
                    z6 = true;
                    radioButton7.setChecked(true);
                    obj = "01";
                    obj3 = TarConstants.VERSION_POSIX;
                    obj2 = "03";
                    break;
                default:
                    obj = "01";
                    obj3 = TarConstants.VERSION_POSIX;
                    obj2 = "03";
                    break;
            }
        } else {
            int i7 = 8;
            radioButton5.setVisibility(i7);
            radioButton6.setVisibility(i7);
            radioButton7.setVisibility(i7);
            radioButton8.setVisibility(0);
            radioButton9.setVisibility(0);
            radioButton10.setVisibility(0);
            radioButton11.setVisibility(0);
            radioButton21.setVisibility(0);
            radioButton24.setVisibility(0);
            radioButton22.setVisibility(0);
            radioButton23.setVisibility(0);
            radioButton25.setVisibility(0);
            String speedLev2 = this.printerInfo.getSpeedLev();
            speedLev2.getClass();
            switch (speedLev2.hashCode()) {
                case BOFRecord.VERSION /* 1536 */:
                    obj2 = r15;
                    obj3 = r5;
                    b = !speedLev2.equals(obj3) ? (byte) -1 : (byte) 0;
                    break;
                case 1537:
                    obj2 = r15;
                    if (!speedLev2.equals("01")) {
                        b = -1;
                        obj3 = TarConstants.VERSION_POSIX;
                    } else {
                        obj3 = r5;
                        b = 1;
                    }
                    break;
                case 1538:
                    obj2 = r15;
                    if (speedLev2.equals("02")) {
                        b = 2;
                    } else {
                        b = -1;
                    }
                    obj3 = TarConstants.VERSION_POSIX;
                    break;
                case 1539:
                    obj2 = r15;
                    if (speedLev2.equals(obj2)) {
                        b = 3;
                    } else {
                        b = -1;
                    }
                    obj3 = TarConstants.VERSION_POSIX;
                    break;
                case 1540:
                    b = !speedLev2.equals("04") ? (byte) -1 : (byte) 4;
                    obj2 = "03";
                    obj3 = TarConstants.VERSION_POSIX;
                    break;
                case 1541:
                    b = !speedLev2.equals("05") ? (byte) -1 : (byte) 5;
                    obj2 = "03";
                    obj3 = TarConstants.VERSION_POSIX;
                    break;
                case 1542:
                    b = !speedLev2.equals("06") ? (byte) -1 : (byte) 6;
                    obj2 = "03";
                    obj3 = TarConstants.VERSION_POSIX;
                    break;
                case 1543:
                    b = !speedLev2.equals("07") ? (byte) -1 : (byte) 7;
                    obj2 = "03";
                    obj3 = TarConstants.VERSION_POSIX;
                    break;
                case 1544:
                    if (!speedLev2.equals("08")) {
                        b = -1;
                        obj2 = "03";
                        obj3 = TarConstants.VERSION_POSIX;
                    } else {
                        obj2 = r15;
                        obj3 = r5;
                        b = 8;
                    }
                    break;
                case 1545:
                    b = !speedLev2.equals("09") ? (byte) -1 : (byte) 9;
                    obj2 = "03";
                    obj3 = TarConstants.VERSION_POSIX;
                    break;
                case 1567:
                    b = !speedLev2.equals("10") ? (byte) -1 : (byte) 10;
                    obj2 = "03";
                    obj3 = TarConstants.VERSION_POSIX;
                    break;
                default:
                    b = -1;
                    obj2 = "03";
                    obj3 = TarConstants.VERSION_POSIX;
                    break;
            }
            switch (b) {
                case 0:
                case 1:
                case 2:
                    radioButton8.setChecked(true);
                    break;
                case 3:
                    radioButton9.setChecked(true);
                    break;
                case 4:
                    radioButton10.setChecked(true);
                    break;
                case 5:
                    radioButton11.setChecked(true);
                    break;
                case 6:
                    radioButton21.setChecked(true);
                    break;
                case 7:
                    radioButton24.setChecked(true);
                    break;
                case 8:
                    radioButton22.setChecked(true);
                    break;
                case 9:
                    radioButton23.setChecked(true);
                    break;
                case 10:
                    radioButton25.setChecked(true);
                    break;
            }
            radioButton21 = radioButton21;
        }
        final RadioButton radioButton26 = radioButton23;
        Object obj4 = obj2;
        final RadioButton radioButton27 = radioButton22;
        Object obj5 = obj3;
        Object obj6 = obj;
        final RadioButton radioButton28 = radioButton21;
        final RadioButton radioButton29 = radioButton24;
        final RadioButton radioButton30 = radioButton25;
        final TextView textView7 = textView6;
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.appdev.standard.page.bluetooth.PrintSetting.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                radioButton5.setChecked(false);
                radioButton6.setChecked(false);
                radioButton7.setChecked(false);
                radioButton8.setChecked(false);
                radioButton9.setChecked(false);
                radioButton10.setChecked(false);
                radioButton11.setChecked(false);
                radioButton28.setChecked(false);
                radioButton29.setChecked(false);
                radioButton27.setChecked(false);
                radioButton26.setChecked(false);
                radioButton30.setChecked(false);
                RadioButton radioButton31 = (RadioButton) view2;
                radioButton31.setChecked(true);
                PrintSetting.this.speedLev = (String) radioButton31.getTag();
                if (PrintSetting.this.haveChange()) {
                    textView7.setBackgroundResource(p113u.c.bg_ffae00_rad_10);
                } else {
                    textView7.setBackgroundResource(p113u.c.bg_999999_rad_10);
                }
            }
        };
        radioButton5.setOnClickListener(onClickListener);
        radioButton6.setOnClickListener(onClickListener);
        radioButton7.setOnClickListener(onClickListener);
        radioButton8.setOnClickListener(onClickListener);
        radioButton9.setOnClickListener(onClickListener);
        radioButton10.setOnClickListener(onClickListener);
        radioButton11.setOnClickListener(onClickListener);
        radioButton28.setOnClickListener(onClickListener);
        radioButton29.setOnClickListener(onClickListener);
        radioButton27.setOnClickListener(onClickListener);
        radioButton26.setOnClickListener(onClickListener);
        radioButton30.setOnClickListener(onClickListener);
        String paperType = this.printerInfo.getPaperType();
        paperType.getClass();
        switch (paperType.hashCode()) {
            case BOFRecord.VERSION /* 1536 */:
                b6 = !paperType.equals(obj5) ? (byte) -1 : (byte) 0;
                break;
            case 1537:
                b6 = !paperType.equals(obj6) ? (byte) -1 : (byte) 1;
                break;
            case 1538:
                b6 = !paperType.equals("02") ? (byte) -1 : (byte) 2;
                break;
            case 1539:
                if (!paperType.equals(obj4)) {
                    b6 = -1;
                }
                break;
            default:
                b6 = -1;
                break;
        }
        switch (b6) {
            case 0:
                radioButton = radioButton17;
                radioButton2 = radioButton18;
                radioButton3 = radioButton19;
                radioButton4 = radioButton20;
                linearLayout = linearLayout3;
                radioButton.setChecked(true);
                radioButton2.setChecked(false);
                radioButton4.setChecked(false);
                radioButton3.setChecked(false);
                linearLayout.setVisibility(8);
                break;
            case 1:
                radioButton = radioButton17;
                radioButton2 = radioButton18;
                radioButton3 = radioButton19;
                radioButton4 = radioButton20;
                linearLayout = linearLayout3;
                radioButton.setChecked(false);
                radioButton2.setChecked(true);
                radioButton4.setChecked(false);
                radioButton3.setChecked(false);
                linearLayout.setVisibility(0);
                break;
            case 2:
                radioButton = radioButton17;
                radioButton2 = radioButton18;
                radioButton3 = radioButton19;
                radioButton4 = radioButton20;
                linearLayout = linearLayout3;
                radioButton.setChecked(false);
                radioButton2.setChecked(false);
                radioButton4.setChecked(true);
                radioButton3.setChecked(false);
                linearLayout.setVisibility(8);
                break;
            case 3:
                radioButton = radioButton17;
                radioButton.setChecked(false);
                radioButton2 = radioButton18;
                radioButton2.setChecked(false);
                radioButton4 = radioButton20;
                radioButton4.setChecked(false);
                radioButton3 = radioButton19;
                radioButton3.setChecked(true);
                linearLayout = linearLayout3;
                linearLayout.setVisibility(8);
                break;
            default:
                radioButton = radioButton17;
                radioButton2 = radioButton18;
                radioButton3 = radioButton19;
                radioButton4 = radioButton20;
                linearLayout = linearLayout3;
                break;
        }
        final RadioButton radioButton31 = radioButton4;
        final RadioButton radioButton32 = radioButton3;
        final RadioButton radioButton33 = radioButton2;
        final LinearLayout linearLayout4 = linearLayout;
        radioButton.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.bluetooth.PrintSetting.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PrintSetting.this.paperType = TarConstants.VERSION_POSIX;
                radioButton33.setChecked(false);
                radioButton31.setChecked(false);
                radioButton32.setChecked(false);
                linearLayout4.setVisibility(8);
                if (PrintSetting.this.haveChange()) {
                    textView7.setBackgroundResource(p113u.c.bg_ffae00_rad_10);
                } else {
                    textView7.setBackgroundResource(p113u.c.bg_999999_rad_10);
                }
            }
        });
        final RadioButton radioButton34 = radioButton;
        radioButton33.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.bluetooth.PrintSetting.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PrintSetting.this.paperType = "01";
                radioButton34.setChecked(false);
                radioButton31.setChecked(false);
                radioButton32.setChecked(false);
                linearLayout4.setVisibility(0);
                if (PrintSetting.this.haveChange()) {
                    textView7.setBackgroundResource(p113u.c.bg_ffae00_rad_10);
                } else {
                    textView7.setBackgroundResource(p113u.c.bg_999999_rad_10);
                }
            }
        });
        radioButton31.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.bluetooth.PrintSetting.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PrintSetting.this.paperType = "02";
                radioButton34.setChecked(false);
                radioButton33.setChecked(false);
                radioButton32.setChecked(false);
                linearLayout4.setVisibility(8);
                if (PrintSetting.this.haveChange()) {
                    textView7.setBackgroundResource(p113u.c.bg_ffae00_rad_10);
                } else {
                    textView7.setBackgroundResource(p113u.c.bg_999999_rad_10);
                }
            }
        });
        radioButton32.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.bluetooth.PrintSetting.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PrintSetting.this.paperType = "03";
                radioButton34.setChecked(false);
                radioButton33.setChecked(false);
                radioButton31.setChecked(false);
                linearLayout4.setVisibility(8);
                if (PrintSetting.this.haveChange()) {
                    textView7.setBackgroundResource(p113u.c.bg_ffae00_rad_10);
                } else {
                    textView7.setBackgroundResource(p113u.c.bg_999999_rad_10);
                }
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.bluetooth.PrintSetting.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (PrintSetting.this.mCustomPopWindow != null) {
                    PrintSetting.this.mCustomPopWindow.a();
                    PrintSetting.this.mCustomPopWindow = null;
                }
            }
        });
        textView7.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.bluetooth.PrintSetting.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (PrintSetting.this.haveChange()) {
                    if (PrintSetting.this.pt2tearLen == PrintSetting.this.printerInfo.f8870m) {
                        PrintSetting.this.saveSetting();
                        return;
                    }
                    DefaultTipDialog defaultTipDialog = new DefaultTipDialog(PrintSetting.this.activity);
                    defaultTipDialog.e("");
                    defaultTipDialog.c(PrintSetting.this.activity.getString(p113u.g.text_476));
                    defaultTipDialog.a(PrintSetting.this.activity.getString(p113u.g.cancel));
                    defaultTipDialog.b(PrintSetting.this.activity.getString(p113u.g.confirm));
                    defaultTipDialog.f2608a = new com.bumptech.glide.f() { // from class: com.appdev.standard.page.bluetooth.PrintSetting.9.1
                        @Override // com.library.base.frame.d
                        public void onConfirm() {
                            PrintSetting.this.saveSetting();
                        }

                        @Override // com.library.base.frame.d
                        public void onCancel() {
                        }
                    };
                    defaultTipDialog.show();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean haveChange() {
        P0 p1 = this.printerInfo;
        if (p1 == null) {
            return false;
        }
        if (this.depthLev == p1.e && this.speedLev.equals(p1.getSpeedLev()) && this.cmdMode.equals(this.printerInfo.getCmdMode()) && this.paperType.equals(this.printerInfo.getPaperType())) {
            return this.paperType.equals("01") && this.pt2tearLen != this.printerInfo.f8870m;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$handleLogic$0(LinearLayout linearLayout, ImageView imageView, View view) {
        if (linearLayout.getVisibility() == 0) {
            linearLayout.setVisibility(8);
            imageView.setImageResource(p113u.c.ic_expand_more);
        } else {
            linearLayout.setVisibility(0);
            imageView.setImageResource(p113u.c.ic_expand_less);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveSetting() {
        w.e();
        C0451d c0451d = this.mCustomPopWindow;
        if (c0451d != null) {
            c0451d.a();
            this.mCustomPopWindow = null;
        }
        new Thread(new AnonymousClass10()).start();
    }

    public void dissmiss() {
        C0451d c0451d = this.mCustomPopWindow;
        if (c0451d != null) {
            c0451d.a();
            this.mCustomPopWindow = null;
        }
    }

    public void showSetting(Activity activity, View view) {
        if (this.printerInfo == null) {
            return;
        }
        this.activity = activity;
        View viewInflate = LayoutInflater.from(activity).inflate(p113u.e.pop_print_device_setting, (ViewGroup) null);
        handleLogic(viewInflate);
        DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        float f6 = displayMetrics.heightPixels - (displayMetrics.density * 100.0f);
        int i5 = f6 > 0.0f ? (int) f6 : -1;
        C0450c c0450c = new C0450c(activity);
        c0450c.f2639a.e = viewInflate;
        c0450c.b(i5);
        C0451d c0451d = c0450c.f2639a;
        c0451d.d = true;
        c0451d.f2643h = true;
        C0451d c0451dA = c0450c.a();
        c0451dA.b(view);
        this.mCustomPopWindow = c0451dA;
    }
}
