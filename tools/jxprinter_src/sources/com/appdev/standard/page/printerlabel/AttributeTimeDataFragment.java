package com.appdev.standard.page.printerlabel;

import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.appdev.standard.dialog.T;
import com.appdev.standard.dialog.TimeOffsetDialog;
import com.appdev.standard.model.ElementAttributeTimeBean;
import com.appdev.standard.page.printerlabel.widget.BaseControlView;
import com.appdev.standard.page.printerlabel.widget.PrinterLabelBarCodeView;
import com.appdev.standard.page.printerlabel.widget.PrinterLabelTimeView;
import java.util.Date;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class AttributeTimeDataFragment extends com.library.base.frame.f {
    private ElementAttributeTimeBean elementAttributeTimeBean;
    private Date fixedDate = new Date();
    private PrinterLabelTimeView printerLabelTimeView;

    @BindView(6054)
    TextView tvDateContent;

    @BindView(6056)
    TextView tvDateDynamicTime;

    @BindView(6057)
    TextView tvDateFixedTime;

    @BindView(6058)
    TextView tvDateFormat;

    @BindView(6059)
    TextView tvDateSettingTimeOffset;

    public AttributeTimeDataFragment(BaseControlView baseControlView) {
        this.printerLabelTimeView = (PrinterLabelTimeView) baseControlView;
    }

    private void setTimeType(final int i5) {
        this.printerLabelTimeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeTimeDataFragment.4
            @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
            public void run() {
                JSONObject json = AttributeTimeDataFragment.this.printerLabelTimeView.getJson();
                AttributeTimeDataFragment.this.elementAttributeTimeBean = (ElementAttributeTimeBean) p052j2.c.c(ElementAttributeTimeBean.class, json.toString());
                AttributeTimeDataFragment.this.elementAttributeTimeBean.setTimeType(i5);
                AttributeTimeDataFragment.this.printerLabelTimeView.recoverFromJson(AttributeTimeDataFragment.this.elementAttributeTimeBean.ObjectToJson());
            }
        });
    }

    @Override // com.library.base.frame.e
    public void initComponent() {
        ElementAttributeTimeBean elementAttributeTimeBean = (ElementAttributeTimeBean) p052j2.c.c(ElementAttributeTimeBean.class, this.printerLabelTimeView.getJson().toString());
        this.elementAttributeTimeBean = elementAttributeTimeBean;
        this.tvDateFormat.setText(elementAttributeTimeBean.getTimeFormat());
        if (this.elementAttributeTimeBean.getTimeType() == 1) {
            this.printerLabelTimeView.setDynamicTimeUpdateListener(new PrinterLabelBarCodeView.DynamicTimeUpdateListener() { // from class: com.appdev.standard.page.printerlabel.AttributeTimeDataFragment.1
                @Override // com.appdev.standard.page.printerlabel.widget.PrinterLabelBarCodeView.DynamicTimeUpdateListener
                public void updateDateValue(String str) {
                    AttributeTimeDataFragment.this.tvDateContent.setText(str);
                }
            });
            this.tvDateDynamicTime.setBackgroundResource(p113u.c.bg_ffae00_rad_15);
            this.tvDateFixedTime.setBackground(null);
            this.tvDateSettingTimeOffset.setVisibility(0);
            return;
        }
        String strA = com.bumptech.glide.h.a(this.fixedDate.getTime(), this.elementAttributeTimeBean.getTimeFormat().replace(" am/pm", ""));
        TextView textView = this.tvDateContent;
        if (this.elementAttributeTimeBean.getTimeFormat().contains(" am/pm")) {
            StringBuilder sbR = androidx.collection.a.r(strA);
            sbR.append(this.fixedDate.getHours() > 12 ? " pm" : " am");
            strA = sbR.toString();
        }
        textView.setText(strA);
        this.tvDateDynamicTime.setBackground(null);
        this.tvDateFixedTime.setBackgroundResource(p113u.c.bg_ffae00_rad_15);
        this.tvDateSettingTimeOffset.setVisibility(8);
    }

    @Override // com.library.base.frame.e
    public int layoutId() {
        return p113u.e.fragment_attribute_time_data;
    }

    @OnClick({6054})
    public void onDateContentClick() {
        if (this.elementAttributeTimeBean.getTimeType() == 0) {
            p097r0.b bVar = new p097r0.b(getContext(), new p109t0.b() { // from class: com.appdev.standard.page.printerlabel.AttributeTimeDataFragment.6
                @Override // p109t0.b
                public void onTimeSelect(Date date, View view) {
                    AttributeTimeDataFragment.this.fixedDate = date;
                    String strA = com.bumptech.glide.h.a(date.getTime(), AttributeTimeDataFragment.this.elementAttributeTimeBean.getTimeFormat().replace(" am/pm", ""));
                    AttributeTimeDataFragment attributeTimeDataFragment = AttributeTimeDataFragment.this;
                    TextView textView = attributeTimeDataFragment.tvDateContent;
                    if (attributeTimeDataFragment.elementAttributeTimeBean.getTimeFormat().contains(" am/pm")) {
                        StringBuilder sbR = androidx.collection.a.r(strA);
                        sbR.append(date.getHours() > 12 ? " pm" : " am");
                        strA = sbR.toString();
                    }
                    textView.setText(strA);
                    AttributeTimeDataFragment.this.printerLabelTimeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeTimeDataFragment.6.1
                        @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                        public void run() {
                            JSONObject json = AttributeTimeDataFragment.this.printerLabelTimeView.getJson();
                            AttributeTimeDataFragment.this.elementAttributeTimeBean = (ElementAttributeTimeBean) p052j2.c.c(ElementAttributeTimeBean.class, json.toString());
                            AttributeTimeDataFragment.this.elementAttributeTimeBean.setContent(AttributeTimeDataFragment.this.tvDateContent.getText().toString());
                            AttributeTimeDataFragment.this.printerLabelTimeView.recoverFromJson(AttributeTimeDataFragment.this.elementAttributeTimeBean.ObjectToJson());
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

    @OnClick({6056})
    public void onDateDynamicTimeClick() {
        setTimeType(1);
        this.tvDateDynamicTime.setBackgroundResource(p113u.c.bg_ffae00_rad_15);
        this.tvDateFixedTime.setBackground(null);
        this.tvDateSettingTimeOffset.setVisibility(0);
        this.printerLabelTimeView.setDynamicTimeUpdateListener(new PrinterLabelBarCodeView.DynamicTimeUpdateListener() { // from class: com.appdev.standard.page.printerlabel.AttributeTimeDataFragment.2
            @Override // com.appdev.standard.page.printerlabel.widget.PrinterLabelBarCodeView.DynamicTimeUpdateListener
            public void updateDateValue(String str) {
                AttributeTimeDataFragment.this.tvDateContent.setText(str);
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
        ElementAttributeTimeBean elementAttributeTimeBean = (ElementAttributeTimeBean) p052j2.c.c(ElementAttributeTimeBean.class, this.printerLabelTimeView.getJson().toString());
        this.elementAttributeTimeBean = elementAttributeTimeBean;
        String strA = com.bumptech.glide.h.a(this.fixedDate.getTime(), elementAttributeTimeBean.getTimeFormat().replace(" am/pm", ""));
        TextView textView = this.tvDateContent;
        if (this.elementAttributeTimeBean.getTimeFormat().contains(" am/pm")) {
            StringBuilder sbR = androidx.collection.a.r(strA);
            sbR.append(this.fixedDate.getHours() > 12 ? " pm" : " am");
            strA = sbR.toString();
        }
        textView.setText(strA);
    }

    @OnClick({6058})
    public void onDateFormatClick() {
        p097r0.a aVar = new p097r0.a(getContext(), new p109t0.a() { // from class: com.appdev.standard.page.printerlabel.AttributeTimeDataFragment.5
            @Override // p109t0.a
            public void onOptionsSelect(int i5, int i6, int i7, View view) {
                TextView textView = AttributeTimeDataFragment.this.tvDateFormat;
                StringBuilder sb = new StringBuilder();
                sb.append(p051j0.i.f5400a.equals(p051j0.i.g().get(i5)) ? "" : (String) p051j0.i.g().get(i5));
                sb.append(" ");
                sb.append(p051j0.i.f5400a.equals(p051j0.i.d().get(i6)) ? "" : (String) p051j0.i.d().get(i6));
                textView.setText(sb.toString());
                if (AttributeTimeDataFragment.this.elementAttributeTimeBean.getTimeType() == 0) {
                    String strA = com.bumptech.glide.h.a(AttributeTimeDataFragment.this.fixedDate.getTime(), AttributeTimeDataFragment.this.tvDateFormat.getText().toString().replace(" am/pm", ""));
                    AttributeTimeDataFragment attributeTimeDataFragment = AttributeTimeDataFragment.this;
                    TextView textView2 = attributeTimeDataFragment.tvDateContent;
                    if (attributeTimeDataFragment.tvDateFormat.getText().toString().contains(" am/pm")) {
                        StringBuilder sbR = androidx.collection.a.r(strA);
                        sbR.append(AttributeTimeDataFragment.this.fixedDate.getHours() > 12 ? " pm" : " am");
                        strA = sbR.toString();
                    }
                    textView2.setText(strA);
                }
                AttributeTimeDataFragment.this.printerLabelTimeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeTimeDataFragment.5.1
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        JSONObject json = AttributeTimeDataFragment.this.printerLabelTimeView.getJson();
                        AttributeTimeDataFragment.this.elementAttributeTimeBean = (ElementAttributeTimeBean) p052j2.c.c(ElementAttributeTimeBean.class, json.toString());
                        AttributeTimeDataFragment.this.elementAttributeTimeBean.setTimeFormat(AttributeTimeDataFragment.this.tvDateFormat.getText().toString());
                        AttributeTimeDataFragment.this.elementAttributeTimeBean.setContent(AttributeTimeDataFragment.this.tvDateContent.getText().toString());
                        AttributeTimeDataFragment.this.printerLabelTimeView.recoverFromJson(AttributeTimeDataFragment.this.elementAttributeTimeBean.ObjectToJson());
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
        this.elementAttributeTimeBean = (ElementAttributeTimeBean) p052j2.c.c(ElementAttributeTimeBean.class, this.printerLabelTimeView.getJson().toString());
        TimeOffsetDialog timeOffsetDialog = new TimeOffsetDialog(getContext());
        timeOffsetDialog.a(this.elementAttributeTimeBean.getTimeOffsetYear(), this.elementAttributeTimeBean.getTimeOffsetMonth(), this.elementAttributeTimeBean.getTimeOffsetDay(), this.elementAttributeTimeBean.getTimeOffsetHour(), this.elementAttributeTimeBean.getTimeOffsetMinute(), this.elementAttributeTimeBean.getTimeOffsetSecond());
        timeOffsetDialog.f2634g = new T() { // from class: com.appdev.standard.page.printerlabel.AttributeTimeDataFragment.3
            @Override // com.appdev.standard.dialog.T
            public void updateDateValue(final int i5, final int i6, final int i7, final int i8, final int i9, final int i10) {
                AttributeTimeDataFragment.this.printerLabelTimeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.AttributeTimeDataFragment.3.1
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        AttributeTimeDataFragment.this.elementAttributeTimeBean.setTimeOffsetYear(i5);
                        AttributeTimeDataFragment.this.elementAttributeTimeBean.setTimeOffsetMonth(i6);
                        AttributeTimeDataFragment.this.elementAttributeTimeBean.setTimeOffsetDay(i7);
                        AttributeTimeDataFragment.this.elementAttributeTimeBean.setTimeOffsetHour(i8);
                        AttributeTimeDataFragment.this.elementAttributeTimeBean.setTimeOffsetMinute(i9);
                        AttributeTimeDataFragment.this.elementAttributeTimeBean.setTimeOffsetSecond(i10);
                        AttributeTimeDataFragment.this.printerLabelTimeView.recoverFromJson(AttributeTimeDataFragment.this.elementAttributeTimeBean.ObjectToJson());
                    }
                });
            }
        };
        timeOffsetDialog.show();
    }

    @Override // com.library.base.frame.e
    public void refreshUI() {
    }
}
