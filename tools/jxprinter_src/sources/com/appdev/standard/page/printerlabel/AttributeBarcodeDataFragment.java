package com.appdev.standard.page.printerlabel;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.OnClick;
import cn.bertsir.zbar.Qr.ScanResult;
import cn.bertsir.zbar.QrManager;
import com.appdev.standard.dialog.ContentEditDialog;
import com.appdev.standard.dialog.InterfaceC0453f;
import com.appdev.standard.dialog.PermissionTipDialog;
import com.appdev.standard.dialog.T;
import com.appdev.standard.dialog.TimeOffsetDialog;
import com.appdev.standard.model.ElementAttributeBarCodeBean;
import com.appdev.standard.page.LocalFlutterBoostActivity;
import com.appdev.standard.page.printerlabel.widget.BaseControlView;
import com.appdev.standard.page.printerlabel.widget.PrinterLabelBarCodeView;
import com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.text.Text;
import com.google.mlkit.vision.text.TextRecognition;
import com.google.mlkit.vision.text.chinese.ChineseTextRecognizerOptions;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.containers.FlutterActivityLaunchConfigs;
import com.idlefish.flutterboost.containers.FlutterBoostActivity;
import com.idlefish.flutterboost.containers.FlutterBoostFragment;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class AttributeBarcodeDataFragment extends com.library.base.frame.f {
    private ActivityResultLauncher<Intent> asrLauncher;
    private ElementAttributeBarCodeBean elementAttributeBarCodeBean;
    private FlutterBoostFragment excelFragment;
    private Date fixedDate = new Date();

    @BindView(5344)
    FrameLayout flExcelContent;

    @BindView(5343)
    LinearLayout llDateContent;

    @BindView(5346)
    LinearLayout llIncrementalContent;
    private ActivityResultLauncher<Intent> orcGetImageLauncher;
    private PrinterLabelBarCodeView printerLabelBarCodeView;

    @BindView(5716)
    QuantitySelectorWidget qswInterval;

    @BindView(5804)
    RelativeLayout rlFixedContent;

    @BindView(6054)
    TextView tvDateContent;

    @BindView(6055)
    TextView tvDateData;

    @BindView(6056)
    TextView tvDateDynamicTime;

    @BindView(6057)
    TextView tvDateFixedTime;

    @BindView(6058)
    TextView tvDateFormat;

    @BindView(6059)
    TextView tvDateSettingTimeOffset;

    @BindView(6084)
    TextView tvExcelData;

    @BindView(6024)
    TextView tvFixedContent;

    @BindView(6088)
    TextView tvFixedData;

    @BindView(6025)
    TextView tvIncrementalContent;

    @BindView(6110)
    TextView tvIncrementalData;

    @BindView(6026)
    TextView tvPrefix;

    @BindView(6027)
    TextView tvSuffix;

    public AttributeBarcodeDataFragment(BaseControlView baseControlView) {
        this.printerLabelBarCodeView = (PrinterLabelBarCodeView) baseControlView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$0(String str) {
        ElementAttributeBarCodeBean elementAttributeBarCodeBean = (ElementAttributeBarCodeBean) p052j2.c.c(ElementAttributeBarCodeBean.class, this.printerLabelBarCodeView.getJson().toString());
        this.elementAttributeBarCodeBean = elementAttributeBarCodeBean;
        elementAttributeBarCodeBean.setContent(str);
        this.printerLabelBarCodeView.recoverFromJson(this.elementAttributeBarCodeBean.ObjectToJson());
        this.tvFixedContent.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$1(Text text) {
        this.printerLabelBarCodeView.runWithTemplateEdit(new C0470b(this, text.getText(), 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onViewCreated$2(Exception exc) {
        p051j0.a.e("AttributeTextDataFragment", "Text recognition failed", exc);
        p042h2.d.show(p113u.g.text_485);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$3(ActivityResult activityResult) {
        String str;
        if (activityResult.getResultCode() != -1 || (str = (String) ((HashMap) activityResult.getData().getSerializableExtra(FlutterActivityLaunchConfigs.ACTIVITY_RESULT_KEY)).get("imagePath")) == null || str.isEmpty()) {
            return;
        }
        TextRecognition.getClient(new ChineseTextRecognizerOptions.Builder().build()).process(InputImage.fromBitmap(com.bumptech.glide.g.f(str), 0)).addOnSuccessListener(new C0469a(this, 0)).addOnFailureListener(new y(1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$4(String str) {
        ElementAttributeBarCodeBean elementAttributeBarCodeBean = (ElementAttributeBarCodeBean) p052j2.c.c(ElementAttributeBarCodeBean.class, this.printerLabelBarCodeView.getJson().toString());
        this.elementAttributeBarCodeBean = elementAttributeBarCodeBean;
        elementAttributeBarCodeBean.setContent(str);
        this.printerLabelBarCodeView.recoverFromJson(this.elementAttributeBarCodeBean.ObjectToJson());
        this.tvFixedContent.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$5(ActivityResult activityResult) {
        String str;
        if (activityResult.getResultCode() != -1 || (str = (String) ((HashMap) activityResult.getData().getSerializableExtra(FlutterActivityLaunchConfigs.ACTIVITY_RESULT_KEY)).get("text")) == null || str.isEmpty()) {
            return;
        }
        this.printerLabelBarCodeView.runWithTemplateEdit(new C0470b(this, str, 1));
    }

    private void setInputDataType(final int i5) {
        this.printerLabelBarCodeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeDataFragment.12
            @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
            public void run() {
                JSONObject json = AttributeBarcodeDataFragment.this.printerLabelBarCodeView.getJson();
                AttributeBarcodeDataFragment.this.elementAttributeBarCodeBean = (ElementAttributeBarCodeBean) p052j2.c.c(ElementAttributeBarCodeBean.class, json.toString());
                AttributeBarcodeDataFragment.this.elementAttributeBarCodeBean.setInputDataType(i5);
                AttributeBarcodeDataFragment.this.printerLabelBarCodeView.recoverFromJson(AttributeBarcodeDataFragment.this.elementAttributeBarCodeBean.ObjectToJson());
            }
        });
    }

    private void setTimeType(final int i5) {
        this.printerLabelBarCodeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeDataFragment.13
            @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
            public void run() {
                JSONObject json = AttributeBarcodeDataFragment.this.printerLabelBarCodeView.getJson();
                AttributeBarcodeDataFragment.this.elementAttributeBarCodeBean = (ElementAttributeBarCodeBean) p052j2.c.c(ElementAttributeBarCodeBean.class, json.toString());
                AttributeBarcodeDataFragment.this.elementAttributeBarCodeBean.setTimeType(i5);
                AttributeBarcodeDataFragment.this.printerLabelBarCodeView.recoverFromJson(AttributeBarcodeDataFragment.this.elementAttributeBarCodeBean.ObjectToJson());
            }
        });
    }

    @Override // com.library.base.frame.e
    public void initComponent() {
        HashMap map = new HashMap();
        map.put("fileName", this.printerLabelBarCodeView.getExcelName());
        map.put("fileUrl", this.printerLabelBarCodeView.getExcelUrl());
        map.put("showTableHeader", Boolean.valueOf(this.printerLabelBarCodeView.isShowTableHeader()));
        map.put("excelHeaderColumn", Integer.valueOf(this.printerLabelBarCodeView.getColumnIndex()));
        this.excelFragment = new FlutterBoostFragment.CachedEngineFragmentBuilder().shouldAttachEngineToActivity(false).url("label_excel_attribute").urlParams(map).uniqueId("label_excel_attribute_" + System.currentTimeMillis()).build();
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        int i5 = p113u.d.ll_attribute_barcode_excel_content;
        FlutterBoostFragment flutterBoostFragment = this.excelFragment;
        fragmentTransactionBeginTransaction.add(i5, flutterBoostFragment, flutterBoostFragment.getUniqueId()).show(this.excelFragment).commit();
        JSONObject json = this.printerLabelBarCodeView.getJson();
        System.out.println(json);
        ElementAttributeBarCodeBean elementAttributeBarCodeBean = (ElementAttributeBarCodeBean) p052j2.c.c(ElementAttributeBarCodeBean.class, json.toString());
        this.elementAttributeBarCodeBean = elementAttributeBarCodeBean;
        int inputDataType = elementAttributeBarCodeBean.getInputDataType();
        if (inputDataType == 0) {
            this.tvFixedContent.setText(this.elementAttributeBarCodeBean.getContent());
            this.rlFixedContent.setVisibility(0);
            this.llIncrementalContent.setVisibility(8);
            this.llDateContent.setVisibility(8);
            this.flExcelContent.setVisibility(8);
            this.tvFixedData.setTextColor(getResources().getColor(p113u.a.color_FFAE00));
            TextView textView = this.tvIncrementalData;
            Resources resources = getResources();
            int i6 = p113u.a.color_999999;
            textView.setTextColor(resources.getColor(i6));
            this.tvDateData.setTextColor(getResources().getColor(i6));
            this.tvExcelData.setTextColor(getResources().getColor(i6));
            return;
        }
        if (inputDataType == 1) {
            this.tvIncrementalContent.setText(this.elementAttributeBarCodeBean.getContent());
            this.tvPrefix.setText(this.elementAttributeBarCodeBean.getPrefix());
            this.tvSuffix.setText(this.elementAttributeBarCodeBean.getSuffix());
            this.qswInterval.setOffsetValue(this.elementAttributeBarCodeBean.getInterval());
            this.rlFixedContent.setVisibility(8);
            this.llIncrementalContent.setVisibility(0);
            this.llDateContent.setVisibility(8);
            this.flExcelContent.setVisibility(8);
            TextView textView2 = this.tvFixedData;
            Resources resources2 = getResources();
            int i7 = p113u.a.color_999999;
            textView2.setTextColor(resources2.getColor(i7));
            this.tvIncrementalData.setTextColor(getResources().getColor(p113u.a.color_FFAE00));
            this.tvDateData.setTextColor(getResources().getColor(i7));
            this.tvExcelData.setTextColor(getResources().getColor(i7));
            return;
        }
        if (inputDataType != 2) {
            if (inputDataType != 3) {
                return;
            }
            this.rlFixedContent.setVisibility(8);
            this.llIncrementalContent.setVisibility(8);
            this.llDateContent.setVisibility(8);
            this.flExcelContent.setVisibility(0);
            TextView textView3 = this.tvFixedData;
            Resources resources3 = getResources();
            int i8 = p113u.a.color_999999;
            textView3.setTextColor(resources3.getColor(i8));
            this.tvIncrementalData.setTextColor(getResources().getColor(i8));
            this.tvDateData.setTextColor(getResources().getColor(i8));
            this.tvExcelData.setTextColor(getResources().getColor(p113u.a.color_FFAE00));
            return;
        }
        this.tvDateFormat.setText(this.elementAttributeBarCodeBean.getTimeFormat());
        if (this.elementAttributeBarCodeBean.getTimeType() == 1) {
            this.printerLabelBarCodeView.setDynamicTimeUpdateListener(new PrinterLabelBarCodeView.DynamicTimeUpdateListener() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeDataFragment.1
                @Override // com.appdev.standard.page.printerlabel.widget.PrinterLabelBarCodeView.DynamicTimeUpdateListener
                public void updateDateValue(String str) {
                    AttributeBarcodeDataFragment.this.tvDateContent.setText(str);
                }
            });
            this.tvDateDynamicTime.setBackgroundResource(p113u.c.bg_ffae00_rad_15);
            this.tvDateFixedTime.setBackground(null);
            this.tvDateSettingTimeOffset.setVisibility(0);
        } else {
            String strA = com.bumptech.glide.h.a(this.fixedDate.getTime(), this.elementAttributeBarCodeBean.getTimeFormat().replace(" am/pm", ""));
            TextView textView4 = this.tvDateContent;
            if (this.elementAttributeBarCodeBean.getTimeFormat().contains(" am/pm")) {
                StringBuilder sbR = androidx.collection.a.r(strA);
                sbR.append(this.fixedDate.getHours() > 12 ? " pm" : " am");
                strA = sbR.toString();
            }
            textView4.setText(strA);
            this.tvDateDynamicTime.setBackground(null);
            this.tvDateFixedTime.setBackgroundResource(p113u.c.bg_ffae00_rad_15);
            this.tvDateSettingTimeOffset.setVisibility(8);
        }
        this.rlFixedContent.setVisibility(8);
        this.llIncrementalContent.setVisibility(8);
        this.llDateContent.setVisibility(0);
        this.flExcelContent.setVisibility(8);
        TextView textView5 = this.tvFixedData;
        Resources resources4 = getResources();
        int i9 = p113u.a.color_999999;
        textView5.setTextColor(resources4.getColor(i9));
        this.tvIncrementalData.setTextColor(getResources().getColor(i9));
        this.tvDateData.setTextColor(getResources().getColor(p113u.a.color_FFAE00));
        this.tvExcelData.setTextColor(getResources().getColor(i9));
    }

    @Override // com.library.base.frame.e
    public int layoutId() {
        return p113u.e.fragment_attribute_barcode_data;
    }

    @OnClick({5342})
    public void onASRClick(View view) {
        getFrameActivity().checkAndRequestPermissions(new String[]{"android.permission.RECORD_AUDIO"}, new PermissionTipDialog(getFrameActivity(), getString(p113u.g.text_487)), new p026e2.a() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeDataFragment.15
            @Override // p026e2.a
            public void onRequestPermissionFail() {
                p042h2.d.show(p113u.g.toast_3);
            }

            @Override // p026e2.a
            public void onRequestPermissionSuccess() {
                try {
                    AttributeBarcodeDataFragment.this.asrLauncher.launch(new FlutterBoostActivity.CachedEngineIntentBuilder(LocalFlutterBoostActivity.class).backgroundMode(io.flutter.embedding.android.FlutterActivityLaunchConfigs.BackgroundMode.transparent).destroyEngineWithActivity(false).url("acr_page").urlParams(new HashMap()).build(FlutterBoost.instance().currentActivity()));
                } catch (Exception e) {
                    p051j0.a.e("ElementAllFragment", "", e);
                }
            }
        });
    }

    @OnClick({6054})
    public void onDateContentClick() {
        if (this.elementAttributeBarCodeBean.getTimeType() == 0) {
            p097r0.b bVar = new p097r0.b(getContext(), new p109t0.b() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeDataFragment.8
                @Override // p109t0.b
                public void onTimeSelect(Date date, View view) {
                    AttributeBarcodeDataFragment.this.fixedDate = date;
                    String strA = com.bumptech.glide.h.a(date.getTime(), AttributeBarcodeDataFragment.this.elementAttributeBarCodeBean.getTimeFormat().replace(" am/pm", ""));
                    AttributeBarcodeDataFragment attributeBarcodeDataFragment = AttributeBarcodeDataFragment.this;
                    TextView textView = attributeBarcodeDataFragment.tvDateContent;
                    if (attributeBarcodeDataFragment.elementAttributeBarCodeBean.getTimeFormat().contains(" am/pm")) {
                        StringBuilder sbR = androidx.collection.a.r(strA);
                        sbR.append(date.getHours() > 12 ? " pm" : " am");
                        strA = sbR.toString();
                    }
                    textView.setText(strA);
                    AttributeBarcodeDataFragment.this.printerLabelBarCodeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeDataFragment.8.1
                        @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                        public void run() {
                            JSONObject json = AttributeBarcodeDataFragment.this.printerLabelBarCodeView.getJson();
                            AttributeBarcodeDataFragment.this.elementAttributeBarCodeBean = (ElementAttributeBarCodeBean) p052j2.c.c(ElementAttributeBarCodeBean.class, json.toString());
                            AttributeBarcodeDataFragment.this.elementAttributeBarCodeBean.setContent(AttributeBarcodeDataFragment.this.tvDateContent.getText().toString());
                            AttributeBarcodeDataFragment.this.printerLabelBarCodeView.recoverFromJson(AttributeBarcodeDataFragment.this.elementAttributeBarCodeBean.ObjectToJson());
                        }
                    });
                }
            });
            String string = getString(p113u.g.text_287);
            p103s0.a aVar = bVar.f7932a;
            aVar.f8190k = string;
            aVar.e = new boolean[]{true, true, true, true, true, true};
            bVar.a().h();
        }
    }

    @OnClick({6055})
    public void onDateDataClick() {
        this.rlFixedContent.setVisibility(8);
        this.llIncrementalContent.setVisibility(8);
        this.llDateContent.setVisibility(0);
        this.flExcelContent.setVisibility(8);
        setInputDataType(2);
        String strA = com.bumptech.glide.h.a(this.fixedDate.getTime(), this.elementAttributeBarCodeBean.getTimeFormat().replace(" am/pm", ""));
        TextView textView = this.tvDateContent;
        if (this.elementAttributeBarCodeBean.getTimeFormat().contains(" am/pm")) {
            StringBuilder sbR = androidx.collection.a.r(strA);
            sbR.append(this.fixedDate.getHours() > 12 ? " pm" : " am");
            strA = sbR.toString();
        }
        textView.setText(strA);
        this.tvDateFormat.setText(this.elementAttributeBarCodeBean.getTimeFormat());
        if (this.elementAttributeBarCodeBean.getTimeType() == 1) {
            this.tvDateDynamicTime.setBackgroundResource(p113u.c.bg_ffae00_rad_15);
            this.tvDateFixedTime.setBackground(null);
            this.tvDateSettingTimeOffset.setVisibility(0);
        } else {
            this.tvDateDynamicTime.setBackground(null);
            this.tvDateFixedTime.setBackgroundResource(p113u.c.bg_ffae00_rad_15);
            this.tvDateSettingTimeOffset.setVisibility(8);
        }
        TextView textView2 = this.tvFixedData;
        Resources resources = getResources();
        int i5 = p113u.a.color_999999;
        textView2.setTextColor(resources.getColor(i5));
        this.tvIncrementalData.setTextColor(getResources().getColor(i5));
        this.tvDateData.setTextColor(getResources().getColor(p113u.a.color_FFAE00));
        this.tvExcelData.setTextColor(getResources().getColor(i5));
    }

    @OnClick({6056})
    public void onDateDynamicTimeClick() {
        setTimeType(1);
        this.tvDateDynamicTime.setBackgroundResource(p113u.c.bg_ffae00_rad_15);
        this.tvDateFixedTime.setBackground(null);
        this.tvDateSettingTimeOffset.setVisibility(0);
        this.printerLabelBarCodeView.setDynamicTimeUpdateListener(new PrinterLabelBarCodeView.DynamicTimeUpdateListener() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeDataFragment.10
            @Override // com.appdev.standard.page.printerlabel.widget.PrinterLabelBarCodeView.DynamicTimeUpdateListener
            public void updateDateValue(String str) {
                AttributeBarcodeDataFragment.this.tvDateContent.setText(str);
            }
        });
    }

    @OnClick({6057})
    public void onDateFixedTimeClick() {
        setTimeType(0);
        this.tvDateSettingTimeOffset.setVisibility(8);
        this.tvDateDynamicTime.setBackground(null);
        this.tvDateFixedTime.setBackgroundResource(p113u.c.bg_ffae00_rad_15);
        this.tvDateSettingTimeOffset.setVisibility(8);
        ElementAttributeBarCodeBean elementAttributeBarCodeBean = (ElementAttributeBarCodeBean) p052j2.c.c(ElementAttributeBarCodeBean.class, this.printerLabelBarCodeView.getJson().toString());
        this.elementAttributeBarCodeBean = elementAttributeBarCodeBean;
        String strA = com.bumptech.glide.h.a(this.fixedDate.getTime(), elementAttributeBarCodeBean.getTimeFormat().replace(" am/pm", ""));
        TextView textView = this.tvDateContent;
        if (this.elementAttributeBarCodeBean.getTimeFormat().contains(" am/pm")) {
            StringBuilder sbR = androidx.collection.a.r(strA);
            sbR.append(this.fixedDate.getHours() > 12 ? " pm" : " am");
            strA = sbR.toString();
        }
        textView.setText(strA);
    }

    @OnClick({6058})
    public void onDateFormatClick() {
        p097r0.a aVar = new p097r0.a(getContext(), new p109t0.a() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeDataFragment.7
            @Override // p109t0.a
            public void onOptionsSelect(int i5, int i6, int i7, View view) {
                TextView textView = AttributeBarcodeDataFragment.this.tvDateFormat;
                StringBuilder sb = new StringBuilder();
                sb.append(p051j0.i.f5400a.equals(p051j0.i.g().get(i5)) ? "" : (String) p051j0.i.g().get(i5));
                sb.append(" ");
                sb.append(p051j0.i.f5400a.equals(p051j0.i.d().get(i6)) ? "" : (String) p051j0.i.d().get(i6));
                textView.setText(sb.toString());
                if (AttributeBarcodeDataFragment.this.elementAttributeBarCodeBean.getTimeType() == 0) {
                    String strA = com.bumptech.glide.h.a(AttributeBarcodeDataFragment.this.fixedDate.getTime(), AttributeBarcodeDataFragment.this.tvDateFormat.getText().toString().replace(" am/pm", ""));
                    AttributeBarcodeDataFragment attributeBarcodeDataFragment = AttributeBarcodeDataFragment.this;
                    TextView textView2 = attributeBarcodeDataFragment.tvDateContent;
                    if (attributeBarcodeDataFragment.tvDateFormat.getText().toString().contains(" am/pm")) {
                        StringBuilder sbR = androidx.collection.a.r(strA);
                        sbR.append(AttributeBarcodeDataFragment.this.fixedDate.getHours() > 12 ? " pm" : " am");
                        strA = sbR.toString();
                    }
                    textView2.setText(strA);
                }
                AttributeBarcodeDataFragment.this.printerLabelBarCodeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeDataFragment.7.1
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        JSONObject json = AttributeBarcodeDataFragment.this.printerLabelBarCodeView.getJson();
                        AttributeBarcodeDataFragment.this.elementAttributeBarCodeBean = (ElementAttributeBarCodeBean) p052j2.c.c(ElementAttributeBarCodeBean.class, json.toString());
                        AttributeBarcodeDataFragment.this.elementAttributeBarCodeBean.setTimeFormat(AttributeBarcodeDataFragment.this.tvDateFormat.getText().toString());
                        AttributeBarcodeDataFragment.this.elementAttributeBarCodeBean.setContent(AttributeBarcodeDataFragment.this.tvDateContent.getText().toString());
                        AttributeBarcodeDataFragment.this.printerLabelBarCodeView.recoverFromJson(AttributeBarcodeDataFragment.this.elementAttributeBarCodeBean.ObjectToJson());
                    }
                });
            }
        });
        aVar.f7931a.f8190k = getString(p113u.g.text_286);
        aVar.f7931a.f8188i = getString(p113u.g.confirm);
        String string = getResources().getString(p113u.g.cancel);
        p103s0.a aVar2 = aVar.f7931a;
        aVar2.f8189j = string;
        aVar2.f8192m = 14;
        aVar2.f8191l = 14;
        p114u0.d dVarA = aVar.a();
        dVarA.e(p051j0.i.g(), p051j0.i.d());
        p103s0.a aVar3 = dVarA.d;
        aVar3.c = 1;
        aVar3.d = 1;
        dVarA.d();
        dVarA.h();
    }

    @OnClick({6059})
    public void onDateSettingTimeOffsetClick() {
        this.elementAttributeBarCodeBean = (ElementAttributeBarCodeBean) p052j2.c.c(ElementAttributeBarCodeBean.class, this.printerLabelBarCodeView.getJson().toString());
        TimeOffsetDialog timeOffsetDialog = new TimeOffsetDialog(getContext());
        timeOffsetDialog.a(this.elementAttributeBarCodeBean.getTimeOffsetYear(), this.elementAttributeBarCodeBean.getTimeOffsetMonth(), this.elementAttributeBarCodeBean.getTimeOffsetDay(), this.elementAttributeBarCodeBean.getTimeOffsetHour(), this.elementAttributeBarCodeBean.getTimeOffsetMinute(), this.elementAttributeBarCodeBean.getTimeOffsetSecond());
        timeOffsetDialog.f2634g = new T() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeDataFragment.11
            @Override // com.appdev.standard.dialog.T
            public void updateDateValue(final int i5, final int i6, final int i7, final int i8, final int i9, final int i10) {
                AttributeBarcodeDataFragment.this.printerLabelBarCodeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeDataFragment.11.1
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        AttributeBarcodeDataFragment.this.elementAttributeBarCodeBean.setTimeOffsetYear(i5);
                        AttributeBarcodeDataFragment.this.elementAttributeBarCodeBean.setTimeOffsetMonth(i6);
                        AttributeBarcodeDataFragment.this.elementAttributeBarCodeBean.setTimeOffsetDay(i7);
                        AttributeBarcodeDataFragment.this.elementAttributeBarCodeBean.setTimeOffsetHour(i8);
                        AttributeBarcodeDataFragment.this.elementAttributeBarCodeBean.setTimeOffsetMinute(i9);
                        AttributeBarcodeDataFragment.this.elementAttributeBarCodeBean.setTimeOffsetSecond(i10);
                        AttributeBarcodeDataFragment.this.printerLabelBarCodeView.recoverFromJson(AttributeBarcodeDataFragment.this.elementAttributeBarCodeBean.ObjectToJson());
                    }
                });
            }
        };
        timeOffsetDialog.show();
    }

    @OnClick({6084})
    public void onExcelDataClick() {
        this.rlFixedContent.setVisibility(8);
        this.llIncrementalContent.setVisibility(8);
        this.llDateContent.setVisibility(8);
        this.flExcelContent.setVisibility(0);
        setInputDataType(3);
        TextView textView = this.tvFixedData;
        Resources resources = getResources();
        int i5 = p113u.a.color_999999;
        textView.setTextColor(resources.getColor(i5));
        this.tvIncrementalData.setTextColor(getResources().getColor(i5));
        this.tvDateData.setTextColor(getResources().getColor(i5));
        this.tvExcelData.setTextColor(getResources().getColor(p113u.a.color_FFAE00));
    }

    @OnClick({6024})
    public void onFixedContentClick() {
        ContentEditDialog contentEditDialog = new ContentEditDialog(getContext());
        contentEditDialog.a(this.elementAttributeBarCodeBean.getContent());
        contentEditDialog.show();
        contentEditDialog.b = new InterfaceC0453f() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeDataFragment.3
            @Override // com.appdev.standard.dialog.InterfaceC0453f
            public void setNewContent(final String str) {
                AttributeBarcodeDataFragment.this.printerLabelBarCodeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeDataFragment.3.1
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        JSONObject json = AttributeBarcodeDataFragment.this.printerLabelBarCodeView.getJson();
                        AttributeBarcodeDataFragment.this.elementAttributeBarCodeBean = (ElementAttributeBarCodeBean) p052j2.c.c(ElementAttributeBarCodeBean.class, json.toString());
                        AttributeBarcodeDataFragment.this.elementAttributeBarCodeBean.setContent(str);
                        AttributeBarcodeDataFragment.this.printerLabelBarCodeView.recoverFromJson(AttributeBarcodeDataFragment.this.elementAttributeBarCodeBean.ObjectToJson());
                        AttributeBarcodeDataFragment.this.tvFixedContent.setText(str);
                    }
                });
            }
        };
    }

    @OnClick({6088})
    public void onFixedDataClick() {
        this.rlFixedContent.setVisibility(0);
        this.llIncrementalContent.setVisibility(8);
        this.llDateContent.setVisibility(8);
        this.flExcelContent.setVisibility(8);
        setInputDataType(0);
        this.tvFixedContent.setText(this.elementAttributeBarCodeBean.getContent());
        TextView textView = this.tvFixedData;
        Resources resources = getResources();
        int i5 = p113u.a.color_FFAE00;
        textView.setTextColor(resources.getColor(i5));
        TextView textView2 = this.tvIncrementalData;
        Resources resources2 = getResources();
        int i6 = p113u.a.color_999999;
        textView2.setTextColor(resources2.getColor(i6));
        this.tvDateData.setTextColor(getResources().getColor(i6));
        this.tvExcelData.setTextColor(getResources().getColor(i5));
    }

    @OnClick({5345})
    public void onFixedScanClick() {
        QrManager.getInstance().init(p056k0.r.a(getContext())).startScan(getFrameActivity(), new QrManager.OnScanResultCallback() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeDataFragment.9
            @Override // cn.bertsir.zbar.QrManager.OnScanResultCallback
            public void onScanSuccess(final ScanResult scanResult) {
                p051j0.a.d("test", "onScanSuccess: " + scanResult.getContent());
                AttributeBarcodeDataFragment.this.printerLabelBarCodeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeDataFragment.9.1
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        JSONObject json = AttributeBarcodeDataFragment.this.printerLabelBarCodeView.getJson();
                        AttributeBarcodeDataFragment.this.elementAttributeBarCodeBean = (ElementAttributeBarCodeBean) p052j2.c.c(ElementAttributeBarCodeBean.class, json.toString());
                        AttributeBarcodeDataFragment.this.elementAttributeBarCodeBean.setContent(scanResult.getContent());
                        AttributeBarcodeDataFragment.this.printerLabelBarCodeView.recoverFromJson(AttributeBarcodeDataFragment.this.elementAttributeBarCodeBean.ObjectToJson());
                        AttributeBarcodeDataFragment.this.tvFixedContent.setText(scanResult.getContent());
                    }
                });
            }
        });
    }

    @OnClick({6025})
    public void onIncrementalContentClick() {
        ContentEditDialog contentEditDialog = new ContentEditDialog(getContext());
        contentEditDialog.a(this.elementAttributeBarCodeBean.getContent());
        contentEditDialog.show();
        contentEditDialog.b = new InterfaceC0453f() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeDataFragment.4
            @Override // com.appdev.standard.dialog.InterfaceC0453f
            public void setNewContent(final String str) {
                AttributeBarcodeDataFragment.this.printerLabelBarCodeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeDataFragment.4.1
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        JSONObject json = AttributeBarcodeDataFragment.this.printerLabelBarCodeView.getJson();
                        AttributeBarcodeDataFragment.this.elementAttributeBarCodeBean = (ElementAttributeBarCodeBean) p052j2.c.c(ElementAttributeBarCodeBean.class, json.toString());
                        AttributeBarcodeDataFragment.this.elementAttributeBarCodeBean.setContent(str);
                        AttributeBarcodeDataFragment.this.printerLabelBarCodeView.recoverFromJson(AttributeBarcodeDataFragment.this.elementAttributeBarCodeBean.ObjectToJson());
                        AttributeBarcodeDataFragment.this.tvIncrementalContent.setText(str);
                    }
                });
            }
        };
    }

    @OnClick({6110})
    public void onIncrementalDataClick() {
        this.rlFixedContent.setVisibility(8);
        this.llIncrementalContent.setVisibility(0);
        this.llDateContent.setVisibility(8);
        this.flExcelContent.setVisibility(8);
        setInputDataType(1);
        this.tvIncrementalContent.setText(this.elementAttributeBarCodeBean.getContent());
        this.tvPrefix.setText(this.elementAttributeBarCodeBean.getPrefix());
        this.tvSuffix.setText(this.elementAttributeBarCodeBean.getSuffix());
        this.qswInterval.setOffsetValue(this.elementAttributeBarCodeBean.getInterval());
        TextView textView = this.tvFixedData;
        Resources resources = getResources();
        int i5 = p113u.a.color_999999;
        textView.setTextColor(resources.getColor(i5));
        this.tvIncrementalData.setTextColor(getResources().getColor(p113u.a.color_FFAE00));
        this.tvDateData.setTextColor(getResources().getColor(i5));
        this.tvExcelData.setTextColor(getResources().getColor(i5));
    }

    @OnClick({5348})
    public void onOCRClick(View view) {
        getFrameActivity().checkAndRequestPermissions(new String[]{"android.permission.CAMERA"}, new PermissionTipDialog(getFrameActivity(), getString(p113u.g.text_486)), new p026e2.a() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeDataFragment.14
            @Override // p026e2.a
            public void onRequestPermissionFail() {
                p042h2.d.show(p113u.g.toast_3);
            }

            @Override // p026e2.a
            public void onRequestPermissionSuccess() {
                try {
                    AttributeBarcodeDataFragment.this.orcGetImageLauncher.launch(new FlutterBoostActivity.CachedEngineIntentBuilder(LocalFlutterBoostActivity.class).backgroundMode(io.flutter.embedding.android.FlutterActivityLaunchConfigs.BackgroundMode.transparent).destroyEngineWithActivity(false).url("ocr_get_image").urlParams(new HashMap()).build(FlutterBoost.instance().currentActivity()));
                } catch (Exception e) {
                    p051j0.a.e("ElementAllFragment", "", e);
                }
            }
        });
    }

    @OnClick({6026})
    public void onPrefixClick() {
        ContentEditDialog contentEditDialog = new ContentEditDialog(getContext());
        contentEditDialog.a(this.elementAttributeBarCodeBean.getPrefix());
        contentEditDialog.show();
        contentEditDialog.b = new InterfaceC0453f() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeDataFragment.5
            @Override // com.appdev.standard.dialog.InterfaceC0453f
            public void setNewContent(final String str) {
                AttributeBarcodeDataFragment.this.tvPrefix.setText(str);
                AttributeBarcodeDataFragment.this.printerLabelBarCodeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeDataFragment.5.1
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        JSONObject json = AttributeBarcodeDataFragment.this.printerLabelBarCodeView.getJson();
                        AttributeBarcodeDataFragment.this.elementAttributeBarCodeBean = (ElementAttributeBarCodeBean) p052j2.c.c(ElementAttributeBarCodeBean.class, json.toString());
                        AttributeBarcodeDataFragment.this.elementAttributeBarCodeBean.setPrefix(str);
                        AttributeBarcodeDataFragment.this.printerLabelBarCodeView.recoverFromJson(AttributeBarcodeDataFragment.this.elementAttributeBarCodeBean.ObjectToJson());
                    }
                });
            }
        };
    }

    @OnClick({6027})
    public void onSuffixClick() {
        ContentEditDialog contentEditDialog = new ContentEditDialog(getContext());
        contentEditDialog.a(this.elementAttributeBarCodeBean.getSuffix());
        contentEditDialog.show();
        contentEditDialog.b = new InterfaceC0453f() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeDataFragment.6
            @Override // com.appdev.standard.dialog.InterfaceC0453f
            public void setNewContent(final String str) {
                AttributeBarcodeDataFragment.this.tvSuffix.setText(str);
                AttributeBarcodeDataFragment.this.printerLabelBarCodeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeDataFragment.6.1
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        JSONObject json = AttributeBarcodeDataFragment.this.printerLabelBarCodeView.getJson();
                        AttributeBarcodeDataFragment.this.elementAttributeBarCodeBean = (ElementAttributeBarCodeBean) p052j2.c.c(ElementAttributeBarCodeBean.class, json.toString());
                        AttributeBarcodeDataFragment.this.elementAttributeBarCodeBean.setSuffix(str);
                        AttributeBarcodeDataFragment.this.printerLabelBarCodeView.recoverFromJson(AttributeBarcodeDataFragment.this.elementAttributeBarCodeBean.ObjectToJson());
                    }
                });
            }
        };
    }

    @Override // com.library.base.frame.f, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.orcGetImageLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C0469a(this, 1));
        this.asrLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C0469a(this, 2));
    }

    @Override // com.library.base.frame.e
    public void refreshUI() {
        this.qswInterval.setOnValueChangeListener(new QuantitySelectorWidget.OnValueChangeListener() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeDataFragment.2
            @Override // com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget.OnValueChangeListener
            public void onValue(final int i5) {
                AttributeBarcodeDataFragment.this.printerLabelBarCodeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeBarcodeDataFragment.2.1
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        JSONObject json = AttributeBarcodeDataFragment.this.printerLabelBarCodeView.getJson();
                        AttributeBarcodeDataFragment.this.elementAttributeBarCodeBean = (ElementAttributeBarCodeBean) p052j2.c.c(ElementAttributeBarCodeBean.class, json.toString());
                        AttributeBarcodeDataFragment.this.elementAttributeBarCodeBean.setInterval(i5);
                        AttributeBarcodeDataFragment.this.printerLabelBarCodeView.recoverFromJson(AttributeBarcodeDataFragment.this.elementAttributeBarCodeBean.ObjectToJson());
                    }
                });
            }
        });
    }
}
