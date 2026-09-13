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
import com.appdev.standard.model.ElementAttributeQrCodeBean;
import com.appdev.standard.page.LocalFlutterBoostActivity;
import com.appdev.standard.page.printerlabel.widget.BaseControlView;
import com.appdev.standard.page.printerlabel.widget.PrinterLabelBarCodeView;
import com.appdev.standard.page.printerlabel.widget.PrinterLabelQrCodeView;
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
public class AttributeQrcodeDataFragment extends com.library.base.frame.f {
    private ActivityResultLauncher<Intent> asrLauncher;
    private ElementAttributeQrCodeBean elementAttributeQrCodeBean;
    private FlutterBoostFragment excelFragment;
    private Date fixedDate = new Date();

    @BindView(5347)
    FrameLayout flExcelContent;

    @BindView(5343)
    LinearLayout llDateContent;

    @BindView(5346)
    LinearLayout llIncrementalContent;
    private ActivityResultLauncher<Intent> orcGetImageLauncher;
    private PrinterLabelQrCodeView printerLabelQrCodeView;

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

    public AttributeQrcodeDataFragment(BaseControlView baseControlView) {
        this.printerLabelQrCodeView = (PrinterLabelQrCodeView) baseControlView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$0(String str) {
        ElementAttributeQrCodeBean elementAttributeQrCodeBean = (ElementAttributeQrCodeBean) p052j2.c.c(ElementAttributeQrCodeBean.class, this.printerLabelQrCodeView.getJson().toString());
        this.elementAttributeQrCodeBean = elementAttributeQrCodeBean;
        elementAttributeQrCodeBean.setContent(str);
        this.printerLabelQrCodeView.recoverFromJson(this.elementAttributeQrCodeBean.ObjectToJson());
        this.tvFixedContent.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$1(Text text) {
        this.printerLabelQrCodeView.runWithTemplateEdit(new C0473e(this, text.getText(), 0));
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
        TextRecognition.getClient(new ChineseTextRecognizerOptions.Builder().build()).process(InputImage.fromBitmap(com.bumptech.glide.g.f(str), 0)).addOnSuccessListener(new C0472d(this, 0)).addOnFailureListener(new y(2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$4(String str) {
        ElementAttributeQrCodeBean elementAttributeQrCodeBean = (ElementAttributeQrCodeBean) p052j2.c.c(ElementAttributeQrCodeBean.class, this.printerLabelQrCodeView.getJson().toString());
        this.elementAttributeQrCodeBean = elementAttributeQrCodeBean;
        elementAttributeQrCodeBean.setContent(str);
        this.printerLabelQrCodeView.recoverFromJson(this.elementAttributeQrCodeBean.ObjectToJson());
        this.tvFixedContent.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$5(ActivityResult activityResult) {
        String str;
        if (activityResult.getResultCode() != -1 || (str = (String) ((HashMap) activityResult.getData().getSerializableExtra(FlutterActivityLaunchConfigs.ACTIVITY_RESULT_KEY)).get("text")) == null || str.isEmpty()) {
            return;
        }
        this.printerLabelQrCodeView.runWithTemplateEdit(new C0473e(this, str, 1));
    }

    private void setInputDataType(final int i5) {
        this.printerLabelQrCodeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeQrcodeDataFragment.12
            @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
            public void run() {
                JSONObject json = AttributeQrcodeDataFragment.this.printerLabelQrCodeView.getJson();
                AttributeQrcodeDataFragment.this.elementAttributeQrCodeBean = (ElementAttributeQrCodeBean) p052j2.c.c(ElementAttributeQrCodeBean.class, json.toString());
                AttributeQrcodeDataFragment.this.elementAttributeQrCodeBean.setInputDataType(i5);
                AttributeQrcodeDataFragment.this.printerLabelQrCodeView.recoverFromJson(AttributeQrcodeDataFragment.this.elementAttributeQrCodeBean.ObjectToJson());
            }
        });
    }

    private void setTimeType(final int i5) {
        this.printerLabelQrCodeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeQrcodeDataFragment.13
            @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
            public void run() {
                JSONObject json = AttributeQrcodeDataFragment.this.printerLabelQrCodeView.getJson();
                AttributeQrcodeDataFragment.this.elementAttributeQrCodeBean = (ElementAttributeQrCodeBean) p052j2.c.c(ElementAttributeQrCodeBean.class, json.toString());
                AttributeQrcodeDataFragment.this.elementAttributeQrCodeBean.setTimeType(i5);
                AttributeQrcodeDataFragment.this.printerLabelQrCodeView.recoverFromJson(AttributeQrcodeDataFragment.this.elementAttributeQrCodeBean.ObjectToJson());
            }
        });
    }

    @Override // com.library.base.frame.e
    public void initComponent() {
        JSONObject json = this.printerLabelQrCodeView.getJson();
        System.out.println(json);
        ElementAttributeQrCodeBean elementAttributeQrCodeBean = (ElementAttributeQrCodeBean) p052j2.c.c(ElementAttributeQrCodeBean.class, json.toString());
        this.elementAttributeQrCodeBean = elementAttributeQrCodeBean;
        int inputDataType = elementAttributeQrCodeBean.getInputDataType();
        if (inputDataType == 0) {
            this.tvFixedContent.setText(this.elementAttributeQrCodeBean.getContent());
            this.rlFixedContent.setVisibility(0);
            this.llIncrementalContent.setVisibility(8);
            this.llDateContent.setVisibility(8);
            this.flExcelContent.setVisibility(8);
            this.tvFixedData.setTextColor(getResources().getColor(p113u.a.color_FFAE00));
            TextView textView = this.tvIncrementalData;
            Resources resources = getResources();
            int i5 = p113u.a.color_999999;
            textView.setTextColor(resources.getColor(i5));
            this.tvDateData.setTextColor(getResources().getColor(i5));
            this.tvExcelData.setTextColor(getResources().getColor(i5));
            return;
        }
        if (inputDataType == 1) {
            this.tvIncrementalContent.setText(this.elementAttributeQrCodeBean.getContent());
            this.tvPrefix.setText(this.elementAttributeQrCodeBean.getPrefix());
            this.tvSuffix.setText(this.elementAttributeQrCodeBean.getSuffix());
            this.qswInterval.setOffsetValue(this.elementAttributeQrCodeBean.getInterval());
            this.rlFixedContent.setVisibility(8);
            this.llIncrementalContent.setVisibility(0);
            this.llDateContent.setVisibility(8);
            this.flExcelContent.setVisibility(8);
            TextView textView2 = this.tvFixedData;
            Resources resources2 = getResources();
            int i6 = p113u.a.color_999999;
            textView2.setTextColor(resources2.getColor(i6));
            this.tvIncrementalData.setTextColor(getResources().getColor(p113u.a.color_FFAE00));
            this.tvDateData.setTextColor(getResources().getColor(i6));
            this.tvExcelData.setTextColor(getResources().getColor(i6));
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
            getChildFragmentManager().beginTransaction().show(this.excelFragment).commit();
            TextView textView3 = this.tvFixedData;
            Resources resources3 = getResources();
            int i7 = p113u.a.color_999999;
            textView3.setTextColor(resources3.getColor(i7));
            this.tvIncrementalData.setTextColor(getResources().getColor(i7));
            this.tvDateData.setTextColor(getResources().getColor(i7));
            this.tvExcelData.setTextColor(getResources().getColor(p113u.a.color_FFAE00));
            return;
        }
        this.tvDateFormat.setText(this.elementAttributeQrCodeBean.getTimeFormat());
        if (this.elementAttributeQrCodeBean.getTimeType() == 1) {
            this.printerLabelQrCodeView.setDynamicTimeUpdateListener(new PrinterLabelBarCodeView.DynamicTimeUpdateListener() { // from class: com.appdev.standard.page.printerlabel.AttributeQrcodeDataFragment.1
                @Override // com.appdev.standard.page.printerlabel.widget.PrinterLabelBarCodeView.DynamicTimeUpdateListener
                public void updateDateValue(String str) {
                    AttributeQrcodeDataFragment.this.tvDateContent.setText(str);
                }
            });
            this.tvDateDynamicTime.setBackgroundResource(p113u.c.bg_ffae00_rad_15);
            this.tvDateFixedTime.setBackground(null);
            this.tvDateSettingTimeOffset.setVisibility(0);
        } else {
            String strA = com.bumptech.glide.h.a(this.fixedDate.getTime(), this.elementAttributeQrCodeBean.getTimeFormat().replace(" am/pm", ""));
            TextView textView4 = this.tvDateContent;
            if (this.elementAttributeQrCodeBean.getTimeFormat().contains(" am/pm")) {
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
        int i8 = p113u.a.color_999999;
        textView5.setTextColor(resources4.getColor(i8));
        this.tvIncrementalData.setTextColor(getResources().getColor(i8));
        this.tvDateData.setTextColor(getResources().getColor(p113u.a.color_FFAE00));
        this.tvExcelData.setTextColor(getResources().getColor(i8));
    }

    @Override // com.library.base.frame.e
    public int layoutId() {
        return p113u.e.fragment_attribute_qrcode_data;
    }

    @OnClick({5342})
    public void onASRClick(View view) {
        getFrameActivity().checkAndRequestPermissions(new String[]{"android.permission.RECORD_AUDIO"}, new PermissionTipDialog(getFrameActivity(), getString(p113u.g.text_487)), new p026e2.a() { // from class: com.appdev.standard.page.printerlabel.AttributeQrcodeDataFragment.15
            @Override // p026e2.a
            public void onRequestPermissionFail() {
                p042h2.d.show(p113u.g.toast_3);
            }

            @Override // p026e2.a
            public void onRequestPermissionSuccess() {
                try {
                    AttributeQrcodeDataFragment.this.asrLauncher.launch(new FlutterBoostActivity.CachedEngineIntentBuilder(LocalFlutterBoostActivity.class).backgroundMode(io.flutter.embedding.android.FlutterActivityLaunchConfigs.BackgroundMode.transparent).destroyEngineWithActivity(false).url("acr_page").urlParams(new HashMap()).build(FlutterBoost.instance().currentActivity()));
                } catch (Exception e) {
                    p051j0.a.e("ElementAllFragment", "", e);
                }
            }
        });
    }

    @OnClick({6054})
    public void onDateContentClick() {
        if (this.elementAttributeQrCodeBean.getTimeType() == 0) {
            p097r0.b bVar = new p097r0.b(getContext(), new p109t0.b() { // from class: com.appdev.standard.page.printerlabel.AttributeQrcodeDataFragment.8
                @Override // p109t0.b
                public void onTimeSelect(Date date, View view) {
                    AttributeQrcodeDataFragment.this.fixedDate = date;
                    String strA = com.bumptech.glide.h.a(date.getTime(), AttributeQrcodeDataFragment.this.elementAttributeQrCodeBean.getTimeFormat().replace(" am/pm", ""));
                    AttributeQrcodeDataFragment attributeQrcodeDataFragment = AttributeQrcodeDataFragment.this;
                    TextView textView = attributeQrcodeDataFragment.tvDateContent;
                    if (attributeQrcodeDataFragment.elementAttributeQrCodeBean.getTimeFormat().contains(" am/pm")) {
                        StringBuilder sbR = androidx.collection.a.r(strA);
                        sbR.append(date.getHours() > 12 ? " pm" : " am");
                        strA = sbR.toString();
                    }
                    textView.setText(strA);
                    AttributeQrcodeDataFragment.this.printerLabelQrCodeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeQrcodeDataFragment.8.1
                        @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                        public void run() {
                            JSONObject json = AttributeQrcodeDataFragment.this.printerLabelQrCodeView.getJson();
                            AttributeQrcodeDataFragment.this.elementAttributeQrCodeBean = (ElementAttributeQrCodeBean) p052j2.c.c(ElementAttributeQrCodeBean.class, json.toString());
                            AttributeQrcodeDataFragment.this.elementAttributeQrCodeBean.setContent(AttributeQrcodeDataFragment.this.tvDateContent.getText().toString());
                            AttributeQrcodeDataFragment.this.printerLabelQrCodeView.recoverFromJson(AttributeQrcodeDataFragment.this.elementAttributeQrCodeBean.ObjectToJson());
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
        String strA = com.bumptech.glide.h.a(this.fixedDate.getTime(), this.elementAttributeQrCodeBean.getTimeFormat().replace(" am/pm", ""));
        TextView textView = this.tvDateContent;
        if (this.elementAttributeQrCodeBean.getTimeFormat().contains(" am/pm")) {
            StringBuilder sbR = androidx.collection.a.r(strA);
            sbR.append(this.fixedDate.getHours() > 12 ? " pm" : " am");
            strA = sbR.toString();
        }
        textView.setText(strA);
        this.tvDateFormat.setText(this.elementAttributeQrCodeBean.getTimeFormat());
        if (this.elementAttributeQrCodeBean.getTimeType() == 1) {
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
        this.printerLabelQrCodeView.setDynamicTimeUpdateListener(new PrinterLabelBarCodeView.DynamicTimeUpdateListener() { // from class: com.appdev.standard.page.printerlabel.AttributeQrcodeDataFragment.10
            @Override // com.appdev.standard.page.printerlabel.widget.PrinterLabelBarCodeView.DynamicTimeUpdateListener
            public void updateDateValue(String str) {
                AttributeQrcodeDataFragment.this.tvDateContent.setText(str);
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
        String strA = com.bumptech.glide.h.a(this.fixedDate.getTime(), this.elementAttributeQrCodeBean.getTimeFormat().replace(" am/pm", ""));
        TextView textView = this.tvDateContent;
        if (this.elementAttributeQrCodeBean.getTimeFormat().contains(" am/pm")) {
            StringBuilder sbR = androidx.collection.a.r(strA);
            sbR.append(this.fixedDate.getHours() > 12 ? " pm" : " am");
            strA = sbR.toString();
        }
        textView.setText(strA);
    }

    @OnClick({6058})
    public void onDateFormatClick() {
        p097r0.a aVar = new p097r0.a(getContext(), new p109t0.a() { // from class: com.appdev.standard.page.printerlabel.AttributeQrcodeDataFragment.7
            @Override // p109t0.a
            public void onOptionsSelect(int i5, int i6, int i7, View view) {
                TextView textView = AttributeQrcodeDataFragment.this.tvDateFormat;
                StringBuilder sb = new StringBuilder();
                sb.append(p051j0.i.f5400a.equals(p051j0.i.g().get(i5)) ? "" : (String) p051j0.i.g().get(i5));
                sb.append(" ");
                sb.append(p051j0.i.f5400a.equals(p051j0.i.d().get(i6)) ? "" : (String) p051j0.i.d().get(i6));
                textView.setText(sb.toString());
                if (AttributeQrcodeDataFragment.this.elementAttributeQrCodeBean.getTimeType() == 0) {
                    String strA = com.bumptech.glide.h.a(AttributeQrcodeDataFragment.this.fixedDate.getTime(), AttributeQrcodeDataFragment.this.tvDateFormat.getText().toString().replace(" am/pm", ""));
                    AttributeQrcodeDataFragment attributeQrcodeDataFragment = AttributeQrcodeDataFragment.this;
                    TextView textView2 = attributeQrcodeDataFragment.tvDateContent;
                    if (attributeQrcodeDataFragment.tvDateFormat.getText().toString().contains(" am/pm")) {
                        StringBuilder sbR = androidx.collection.a.r(strA);
                        sbR.append(AttributeQrcodeDataFragment.this.fixedDate.getHours() > 12 ? " pm" : " am");
                        strA = sbR.toString();
                    }
                    textView2.setText(strA);
                }
                AttributeQrcodeDataFragment.this.printerLabelQrCodeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeQrcodeDataFragment.7.1
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        JSONObject json = AttributeQrcodeDataFragment.this.printerLabelQrCodeView.getJson();
                        AttributeQrcodeDataFragment.this.elementAttributeQrCodeBean = (ElementAttributeQrCodeBean) p052j2.c.c(ElementAttributeQrCodeBean.class, json.toString());
                        AttributeQrcodeDataFragment.this.elementAttributeQrCodeBean.setTimeFormat(AttributeQrcodeDataFragment.this.tvDateFormat.getText().toString());
                        AttributeQrcodeDataFragment.this.elementAttributeQrCodeBean.setContent(AttributeQrcodeDataFragment.this.tvDateContent.getText().toString());
                        AttributeQrcodeDataFragment.this.printerLabelQrCodeView.recoverFromJson(AttributeQrcodeDataFragment.this.elementAttributeQrCodeBean.ObjectToJson());
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
        this.elementAttributeQrCodeBean = (ElementAttributeQrCodeBean) p052j2.c.c(ElementAttributeQrCodeBean.class, this.printerLabelQrCodeView.getJson().toString());
        TimeOffsetDialog timeOffsetDialog = new TimeOffsetDialog(getContext());
        timeOffsetDialog.a(this.elementAttributeQrCodeBean.getTimeOffsetYear(), this.elementAttributeQrCodeBean.getTimeOffsetMonth(), this.elementAttributeQrCodeBean.getTimeOffsetDay(), this.elementAttributeQrCodeBean.getTimeOffsetHour(), this.elementAttributeQrCodeBean.getTimeOffsetMinute(), this.elementAttributeQrCodeBean.getTimeOffsetSecond());
        timeOffsetDialog.f2634g = new T() { // from class: com.appdev.standard.page.printerlabel.AttributeQrcodeDataFragment.11
            @Override // com.appdev.standard.dialog.T
            public void updateDateValue(final int i5, final int i6, final int i7, final int i8, final int i9, final int i10) {
                AttributeQrcodeDataFragment.this.printerLabelQrCodeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeQrcodeDataFragment.11.1
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        AttributeQrcodeDataFragment.this.elementAttributeQrCodeBean.setTimeOffsetYear(i5);
                        AttributeQrcodeDataFragment.this.elementAttributeQrCodeBean.setTimeOffsetMonth(i6);
                        AttributeQrcodeDataFragment.this.elementAttributeQrCodeBean.setTimeOffsetDay(i7);
                        AttributeQrcodeDataFragment.this.elementAttributeQrCodeBean.setTimeOffsetHour(i8);
                        AttributeQrcodeDataFragment.this.elementAttributeQrCodeBean.setTimeOffsetMinute(i9);
                        AttributeQrcodeDataFragment.this.elementAttributeQrCodeBean.setTimeOffsetSecond(i10);
                        AttributeQrcodeDataFragment.this.printerLabelQrCodeView.recoverFromJson(AttributeQrcodeDataFragment.this.elementAttributeQrCodeBean.ObjectToJson());
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
        contentEditDialog.a(this.elementAttributeQrCodeBean.getContent());
        contentEditDialog.show();
        contentEditDialog.b = new InterfaceC0453f() { // from class: com.appdev.standard.page.printerlabel.AttributeQrcodeDataFragment.3
            @Override // com.appdev.standard.dialog.InterfaceC0453f
            public void setNewContent(final String str) {
                AttributeQrcodeDataFragment.this.printerLabelQrCodeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeQrcodeDataFragment.3.1
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        JSONObject json = AttributeQrcodeDataFragment.this.printerLabelQrCodeView.getJson();
                        AttributeQrcodeDataFragment.this.elementAttributeQrCodeBean = (ElementAttributeQrCodeBean) p052j2.c.c(ElementAttributeQrCodeBean.class, json.toString());
                        AttributeQrcodeDataFragment.this.elementAttributeQrCodeBean.setContent(str);
                        AttributeQrcodeDataFragment.this.printerLabelQrCodeView.recoverFromJson(AttributeQrcodeDataFragment.this.elementAttributeQrCodeBean.ObjectToJson());
                        AttributeQrcodeDataFragment.this.tvFixedContent.setText(str);
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
        this.tvFixedContent.setText(this.elementAttributeQrCodeBean.getContent());
        this.tvFixedData.setTextColor(getResources().getColor(p113u.a.color_FFAE00));
        TextView textView = this.tvIncrementalData;
        Resources resources = getResources();
        int i5 = p113u.a.color_999999;
        textView.setTextColor(resources.getColor(i5));
        this.tvDateData.setTextColor(getResources().getColor(i5));
        this.tvExcelData.setTextColor(getResources().getColor(i5));
    }

    @OnClick({5345})
    public void onFixedScanClick() {
        QrManager.getInstance().init(p056k0.r.a(getContext())).startScan(getFrameActivity(), new QrManager.OnScanResultCallback() { // from class: com.appdev.standard.page.printerlabel.AttributeQrcodeDataFragment.9
            @Override // cn.bertsir.zbar.QrManager.OnScanResultCallback
            public void onScanSuccess(final ScanResult scanResult) {
                p051j0.a.d("test", "onScanSuccess: " + scanResult.getContent());
                AttributeQrcodeDataFragment.this.printerLabelQrCodeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeQrcodeDataFragment.9.1
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        JSONObject json = AttributeQrcodeDataFragment.this.printerLabelQrCodeView.getJson();
                        AttributeQrcodeDataFragment.this.elementAttributeQrCodeBean = (ElementAttributeQrCodeBean) p052j2.c.c(ElementAttributeQrCodeBean.class, json.toString());
                        AttributeQrcodeDataFragment.this.elementAttributeQrCodeBean.setContent(scanResult.getContent());
                        AttributeQrcodeDataFragment.this.printerLabelQrCodeView.recoverFromJson(AttributeQrcodeDataFragment.this.elementAttributeQrCodeBean.ObjectToJson());
                        AttributeQrcodeDataFragment.this.tvFixedContent.setText(scanResult.getContent());
                    }
                });
            }
        });
    }

    @OnClick({6025})
    public void onIncrementalContentClick() {
        ContentEditDialog contentEditDialog = new ContentEditDialog(getContext());
        contentEditDialog.a(this.elementAttributeQrCodeBean.getContent());
        contentEditDialog.show();
        contentEditDialog.b = new InterfaceC0453f() { // from class: com.appdev.standard.page.printerlabel.AttributeQrcodeDataFragment.4
            @Override // com.appdev.standard.dialog.InterfaceC0453f
            public void setNewContent(final String str) {
                AttributeQrcodeDataFragment.this.printerLabelQrCodeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeQrcodeDataFragment.4.1
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        JSONObject json = AttributeQrcodeDataFragment.this.printerLabelQrCodeView.getJson();
                        AttributeQrcodeDataFragment.this.elementAttributeQrCodeBean = (ElementAttributeQrCodeBean) p052j2.c.c(ElementAttributeQrCodeBean.class, json.toString());
                        AttributeQrcodeDataFragment.this.elementAttributeQrCodeBean.setContent(str);
                        AttributeQrcodeDataFragment.this.printerLabelQrCodeView.recoverFromJson(AttributeQrcodeDataFragment.this.elementAttributeQrCodeBean.ObjectToJson());
                        AttributeQrcodeDataFragment.this.tvIncrementalContent.setText(str);
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
        this.tvIncrementalContent.setText(this.elementAttributeQrCodeBean.getContent());
        this.tvPrefix.setText(this.elementAttributeQrCodeBean.getPrefix());
        this.tvSuffix.setText(this.elementAttributeQrCodeBean.getSuffix());
        this.qswInterval.setOffsetValue(this.elementAttributeQrCodeBean.getInterval());
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
        getFrameActivity().checkAndRequestPermissions(new String[]{"android.permission.CAMERA"}, new PermissionTipDialog(getFrameActivity(), getString(p113u.g.text_486)), new p026e2.a() { // from class: com.appdev.standard.page.printerlabel.AttributeQrcodeDataFragment.14
            @Override // p026e2.a
            public void onRequestPermissionFail() {
                p042h2.d.show(p113u.g.toast_3);
            }

            @Override // p026e2.a
            public void onRequestPermissionSuccess() {
                try {
                    AttributeQrcodeDataFragment.this.orcGetImageLauncher.launch(new FlutterBoostActivity.CachedEngineIntentBuilder(LocalFlutterBoostActivity.class).backgroundMode(io.flutter.embedding.android.FlutterActivityLaunchConfigs.BackgroundMode.transparent).destroyEngineWithActivity(false).url("ocr_get_image").urlParams(new HashMap()).build(FlutterBoost.instance().currentActivity()));
                } catch (Exception e) {
                    p051j0.a.e("ElementAllFragment", "", e);
                }
            }
        });
    }

    @OnClick({6026})
    public void onPrefixClick() {
        ContentEditDialog contentEditDialog = new ContentEditDialog(getContext());
        contentEditDialog.a(this.elementAttributeQrCodeBean.getPrefix());
        contentEditDialog.show();
        contentEditDialog.b = new InterfaceC0453f() { // from class: com.appdev.standard.page.printerlabel.AttributeQrcodeDataFragment.5
            @Override // com.appdev.standard.dialog.InterfaceC0453f
            public void setNewContent(final String str) {
                AttributeQrcodeDataFragment.this.tvPrefix.setText(str);
                AttributeQrcodeDataFragment.this.printerLabelQrCodeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeQrcodeDataFragment.5.1
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        JSONObject json = AttributeQrcodeDataFragment.this.printerLabelQrCodeView.getJson();
                        AttributeQrcodeDataFragment.this.elementAttributeQrCodeBean = (ElementAttributeQrCodeBean) p052j2.c.c(ElementAttributeQrCodeBean.class, json.toString());
                        AttributeQrcodeDataFragment.this.elementAttributeQrCodeBean.setPrefix(str);
                        AttributeQrcodeDataFragment.this.printerLabelQrCodeView.recoverFromJson(AttributeQrcodeDataFragment.this.elementAttributeQrCodeBean.ObjectToJson());
                    }
                });
            }
        };
    }

    @OnClick({6027})
    public void onSuffixClick() {
        ContentEditDialog contentEditDialog = new ContentEditDialog(getContext());
        contentEditDialog.a(this.elementAttributeQrCodeBean.getSuffix());
        contentEditDialog.show();
        contentEditDialog.b = new InterfaceC0453f() { // from class: com.appdev.standard.page.printerlabel.AttributeQrcodeDataFragment.6
            @Override // com.appdev.standard.dialog.InterfaceC0453f
            public void setNewContent(final String str) {
                AttributeQrcodeDataFragment.this.tvSuffix.setText(str);
                AttributeQrcodeDataFragment.this.printerLabelQrCodeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeQrcodeDataFragment.6.1
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        JSONObject json = AttributeQrcodeDataFragment.this.printerLabelQrCodeView.getJson();
                        AttributeQrcodeDataFragment.this.elementAttributeQrCodeBean = (ElementAttributeQrCodeBean) p052j2.c.c(ElementAttributeQrCodeBean.class, json.toString());
                        AttributeQrcodeDataFragment.this.elementAttributeQrCodeBean.setSuffix(str);
                        AttributeQrcodeDataFragment.this.printerLabelQrCodeView.recoverFromJson(AttributeQrcodeDataFragment.this.elementAttributeQrCodeBean.ObjectToJson());
                    }
                });
            }
        };
    }

    @Override // com.library.base.frame.f, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.orcGetImageLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C0472d(this, 1));
        this.asrLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C0472d(this, 2));
        HashMap map = new HashMap();
        map.put("fileName", this.printerLabelQrCodeView.getExcelName());
        map.put("fileUrl", this.printerLabelQrCodeView.getExcelUrl());
        map.put("showTableHeader", Boolean.valueOf(this.printerLabelQrCodeView.isShowTableHeader()));
        map.put("excelHeaderColumn", Integer.valueOf(this.printerLabelQrCodeView.getColumnIndex()));
        this.excelFragment = new FlutterBoostFragment.CachedEngineFragmentBuilder().shouldAttachEngineToActivity(false).url("label_excel_attribute").urlParams(map).uniqueId("label_excel_attribute_" + System.currentTimeMillis()).build();
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        int i5 = p113u.d.ll_attribute_qrcode_excel_content;
        FlutterBoostFragment flutterBoostFragment = this.excelFragment;
        fragmentTransactionBeginTransaction.add(i5, flutterBoostFragment, flutterBoostFragment.getUniqueId()).show(this.excelFragment).commit();
    }

    @Override // com.library.base.frame.e
    public void refreshUI() {
        this.qswInterval.setOnValueChangeListener(new QuantitySelectorWidget.OnValueChangeListener() { // from class: com.appdev.standard.page.printerlabel.AttributeQrcodeDataFragment.2
            @Override // com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget.OnValueChangeListener
            public void onValue(final int i5) {
                AttributeQrcodeDataFragment.this.printerLabelQrCodeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeQrcodeDataFragment.2.1
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        JSONObject json = AttributeQrcodeDataFragment.this.printerLabelQrCodeView.getJson();
                        AttributeQrcodeDataFragment.this.elementAttributeQrCodeBean = (ElementAttributeQrCodeBean) p052j2.c.c(ElementAttributeQrCodeBean.class, json.toString());
                        AttributeQrcodeDataFragment.this.elementAttributeQrCodeBean.setInterval(i5);
                        AttributeQrcodeDataFragment.this.printerLabelQrCodeView.recoverFromJson(AttributeQrcodeDataFragment.this.elementAttributeQrCodeBean.ObjectToJson());
                    }
                });
            }
        });
    }
}
