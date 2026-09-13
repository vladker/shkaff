package com.appdev.standard.page.printerlabel.widget;

import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;
import com.bumptech.glide.h;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Date;
import org.json.JSONObject;
import org.opencv.videoio.Videoio;
import p113u.d;
import p113u.e;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class PrinterLabelTimeView extends IDTControlView {
    private static final String KEY_COLOR_TYPE = "colorType";
    protected final String KEY_BOLD;
    protected final String KEY_CONTENT;
    protected final String KEY_FONTTYPE;
    protected final String KEY_ITALIC;
    protected final String KEY_STRIKETHROUGH;
    protected final String KEY_TEXTSIZE;
    protected final String KEY_TIME_FORMAT;
    protected final String KEY_TIME_OFFSET_DAY;
    protected final String KEY_TIME_OFFSET_HOUR;
    protected final String KEY_TIME_OFFSET_MINUTE;
    protected final String KEY_TIME_OFFSET_MONTH;
    protected final String KEY_TIME_OFFSET_SECOND;
    protected final String KEY_TIME_OFFSET_YEAR;
    protected final String KEY_TIME_TYPE;
    protected final String KEY_UNDERLINE;
    private boolean automaticHeightCalculation;
    private BaseTextView btv;
    public PrinterLabelBarCodeView.DynamicTimeUpdateListener dynamicTimeUpdateListener;
    private Handler handler;
    private float lineSpaceMM;
    private Runnable runnable;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface DynamicTimeUpdateListener {
        void updateDateValue(String str);
    }

    public PrinterLabelTimeView(TemplatePageView templatePageView) {
        this(templatePageView, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTimeContent() {
        Date date = new Date(System.currentTimeMillis());
        date.setYear(date.getYear() + this.timeOffsetYear);
        date.setMonth(date.getMonth() + this.timeOffsetMonth);
        date.setDate(date.getDate() + this.timeOffsetDay);
        date.setHours(date.getHours() + this.timeOffsetHour);
        date.setMinutes(date.getMinutes() + this.timeOffsetMinute);
        date.setSeconds(date.getSeconds() + this.timeOffsetSecond);
        String strA = h.a(date.getTime(), this.timeFormat.replace(" am/pm", ""));
        if (this.timeFormat.contains(" am/pm")) {
            StringBuilder sbR = androidx.collection.a.r(strA);
            sbR.append(date.getHours() > 12 ? " pm" : " am");
            strA = sbR.toString();
        }
        this.btv.setContent(strA);
        updateView();
        PrinterLabelBarCodeView.DynamicTimeUpdateListener dynamicTimeUpdateListener = this.dynamicTimeUpdateListener;
        if (dynamicTimeUpdateListener != null) {
            dynamicTimeUpdateListener.updateDateValue(strA);
        }
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int defaultHeight() {
        return 100;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int defaultWidth() {
        return Videoio.CAP_QT;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int elementType() {
        return 10;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.IDTControlView
    public String getControlViewContent() {
        return this.btv.getContent();
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public JSONObject getJson() {
        super.getJson();
        try {
            this.saveObject.put(FirebaseAnalytics.Param.CONTENT, this.btv.getSaveContent());
            this.saveObject.put("fontSize", this.btv.getTextSize());
            this.saveObject.put("timeType", this.timeType);
            this.saveObject.put("timeFormat", this.timeFormat);
            this.saveObject.put("timeOffsetYear", this.timeOffsetYear);
            this.saveObject.put("timeOffsetMonth", this.timeOffsetMonth);
            this.saveObject.put("timeOffsetDay", this.timeOffsetDay);
            this.saveObject.put("timeOffsetHour", this.timeOffsetHour);
            this.saveObject.put("timeOffsetMinute", this.timeOffsetMinute);
            this.saveObject.put("timeOffsetSecond", this.timeOffsetSecond);
            this.saveObject.put("fontId", this.btv.getFontType());
            this.saveObject.put("isBold", this.btv.isBold());
            this.saveObject.put("isItalic", this.btv.isItalic());
            this.saveObject.put("isUnderLine", this.btv.isUnderline());
            this.saveObject.put("isDeleteLine", this.btv.isStrikethrough());
            this.saveObject.put(KEY_COLOR_TYPE, this.btv.getColorType());
        } catch (Exception e) {
            p051j0.a.d(this.TAG, e.toString());
        }
        return this.saveObject;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int layoutId() {
        return e.printer_label_time_view;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int minHeight() {
        return 0;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int minWidth() {
        return 30;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public void onSizeChanged(int i5, int i6) {
        int i7;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mRoot.getLayoutParams();
        if ((this.btv.getCurDataType() == 0 || this.btv.getCurDataType() == 2) && this.automaticHeightCalculation && layoutParams.width >= 0) {
            this.btv.setNeedRefresh();
            int i8 = 0;
            this.btv.measure(View.MeasureSpec.makeMeasureSpec((layoutParams.width - this.mRoot.getPaddingLeft()) - this.mRoot.getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            int paddingRight = this.mRoot.getPaddingRight() + this.mRoot.getPaddingLeft() + this.btv.getMeasuredWidth();
            this.btv.getMeasuredHeight();
            this.mRoot.getPaddingTop();
            this.mRoot.getPaddingBottom();
            if (paddingRight != i5) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) getLayoutParams();
                if (getRotationAngle() == 90) {
                    int i9 = paddingRight - i5;
                    int i10 = 0 / 2;
                    i8 = ((-i9) / 2) - i10;
                    i7 = (i9 / 2) - i10;
                } else if (getRotationAngle() == 270) {
                    int i11 = (-(paddingRight - i5)) / 2;
                    int i12 = 0 / 2;
                    int i13 = i11 + i12;
                    i7 = i11 - i12;
                    i8 = i13;
                } else if (getRotationAngle() == 180) {
                    i8 = -(paddingRight - i5);
                    i7 = -0;
                } else {
                    i7 = 0;
                }
                layoutParams2.leftMargin += i8;
                layoutParams2.topMargin += i7;
                setLayoutParams(layoutParams2);
                layoutParams.width = paddingRight;
                this.mRoot.setLayoutParams(layoutParams);
                i5 = paddingRight;
            }
        }
        super.onSizeChanged(i5, i6);
        updateRealSize();
        this.btv.setRealWidth(this.realWidth);
        this.btv.setRealHeight(this.realHeight);
        this.btv.setNeedRefresh();
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public void recoverFromJson(JSONObject jSONObject) {
        String strA;
        super.recoverFromJson(jSONObject);
        try {
            String objectString = getObjectString(jSONObject, FirebaseAnalytics.Param.CONTENT, "");
            this.content = objectString;
            this.btv.setContent(objectString);
            BaseTextView baseTextView = this.btv;
            baseTextView.setTextSize(getObjectFloat(jSONObject, "fontSize", baseTextView.getTextSize()));
            this.timeType = getObjectInt(jSONObject, "timeType", 0);
            this.timeFormat = getObjectString(jSONObject, "timeFormat", "yyyy/MM/dd");
            this.timeOffsetYear = getObjectInt(jSONObject, "timeOffsetYear", 0);
            this.timeOffsetMonth = getObjectInt(jSONObject, "timeOffsetMonth", 0);
            this.timeOffsetDay = getObjectInt(jSONObject, "timeOffsetDay", 0);
            this.timeOffsetHour = getObjectInt(jSONObject, "timeOffsetHour", 0);
            this.timeOffsetMinute = getObjectInt(jSONObject, "timeOffsetMinute", 0);
            this.timeOffsetSecond = getObjectInt(jSONObject, "timeOffsetSecond", 0);
            this.btv.setFontType(getObjectString(jSONObject, "fontId", "0"));
            this.btv.setColorType(getObjectInt(jSONObject, KEY_COLOR_TYPE, 0));
            if (this.timeType == 1) {
                Date date = new Date(System.currentTimeMillis());
                date.setYear(date.getYear() + this.timeOffsetYear);
                date.setMonth(date.getMonth() + this.timeOffsetMonth);
                date.setDate(date.getDate() + this.timeOffsetDay);
                date.setHours(date.getHours() + this.timeOffsetHour);
                date.setMinutes(date.getMinutes() + this.timeOffsetMinute);
                date.setSeconds(date.getSeconds() + this.timeOffsetSecond);
                strA = h.a(date.getTime(), this.timeFormat.replace(" am/pm", ""));
                this.handler.post(this.runnable);
            } else {
                this.handler.removeCallbacks(this.runnable);
                strA = this.content;
            }
            this.btv.setContent(strA);
            this.btv.setBold(getObjectBoolean(jSONObject, "isBold"));
            this.btv.setItalic(getObjectBoolean(jSONObject, "isItalic"));
            this.btv.setUnderline(getObjectBoolean(jSONObject, "isUnderLine"));
            this.btv.setStrikethrough(getObjectBoolean(jSONObject, "isDeleteLine"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        updateView();
    }

    @Override // com.appdev.standard.page.printerlabel.widget.IDTControlView
    public void setControlViewContent(String str) {
        this.content = str;
        this.btv.setContent(str);
    }

    public void setDynamicTimeUpdateListener(PrinterLabelBarCodeView.DynamicTimeUpdateListener dynamicTimeUpdateListener) {
        this.dynamicTimeUpdateListener = dynamicTimeUpdateListener;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public void updateView() {
        int i5;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.btv.getLayoutParams();
        if (this.automaticHeightCalculation) {
            layoutParams.height = -2;
            i5 = 3;
        } else {
            layoutParams.height = -1;
            i5 = 2;
        }
        this.btv.setLayoutParams(layoutParams);
        setControlType(i5);
        this.isRenderingCompleted = true;
        super.updateView();
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public void updateZoomedSize() {
        super.updateZoomedSize();
        this.btv.setRealWidth(this.realWidth);
        this.btv.setRealHeight(this.realHeight);
        updateView();
        this.btv.scale(this.templatePage.getScaleConvert().a(this.realWidth), this.templatePage.getScaleConvert().a(this.realHeight));
        if (this.templatePage.isLoadCompelete()) {
            return;
        }
        this.btv.setNeedRefresh();
    }

    public PrinterLabelTimeView(TemplatePageView templatePageView, String str) {
        super(templatePageView);
        this.btv = null;
        this.lineSpaceMM = -1.0f;
        this.automaticHeightCalculation = true;
        this.KEY_CONTENT = FirebaseAnalytics.Param.CONTENT;
        this.KEY_TEXTSIZE = "fontSize";
        this.KEY_TIME_TYPE = "timeType";
        this.KEY_TIME_FORMAT = "timeFormat";
        this.KEY_TIME_OFFSET_YEAR = "timeOffsetYear";
        this.KEY_TIME_OFFSET_MONTH = "timeOffsetMonth";
        this.KEY_TIME_OFFSET_DAY = "timeOffsetDay";
        this.KEY_TIME_OFFSET_HOUR = "timeOffsetHour";
        this.KEY_TIME_OFFSET_MINUTE = "timeOffsetMinute";
        this.KEY_TIME_OFFSET_SECOND = "timeOffsetSecond";
        this.KEY_FONTTYPE = "fontId";
        this.KEY_BOLD = "isBold";
        this.KEY_ITALIC = "isItalic";
        this.KEY_UNDERLINE = "isUnderLine";
        this.KEY_STRIKETHROUGH = "isDeleteLine";
        this.handler = new Handler();
        this.runnable = new Runnable() { // from class: com.appdev.standard.page.printerlabel.widget.PrinterLabelTimeView.1
            @Override // java.lang.Runnable
            public void run() {
                PrinterLabelTimeView.this.updateTimeContent();
                PrinterLabelTimeView.this.handler.postDelayed(PrinterLabelTimeView.this.runnable, 1000L);
            }
        };
        String strA = h.a(System.currentTimeMillis(), "yyyy-MM-dd");
        BaseTextView baseTextView = (BaseTextView) findViewById(d.btv_content);
        this.btv = baseTextView;
        baseTextView.setContent(strA);
        this.btv.setTextSize(18.0f);
        this.btv.sethAlignment(1);
        updateView();
        this.btv.setRealHeight(this.realHeight);
        this.btv.setRealWidth(this.realWidth);
    }
}
