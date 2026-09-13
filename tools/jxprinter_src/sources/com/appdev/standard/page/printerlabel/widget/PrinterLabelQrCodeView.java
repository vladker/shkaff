package com.appdev.standard.page.printerlabel.widget;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.appdev.standard.page.printerlabel.util.QRCodeUtil;
import com.bumptech.glide.h;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Date;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.json.JSONException;
import org.json.JSONObject;
import p056k0.g;
import p113u.d;
import p113u.e;
import p134x2.K;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class PrinterLabelQrCodeView extends IDTControlView {
    private static final int COLOR_BLACK = 0;
    private static final int COLOR_RED = 1;
    private static final String KEY_COLOR_TYPE = "colorType";
    protected final String KEY_CODE_TYPE;
    protected final String KEY_CONTENT;
    protected final String KEY_EXCELFILEURL;
    protected final String KEY_EXCELHEADERCOLUMN;
    protected final String KEY_EXCELNAME;
    protected final String KEY_INPUTDATATYPE;
    protected final String KEY_INTERVAL;
    protected final String KEY_ISSHOWEXCELHEADER;
    protected final String KEY_PREFIX;
    protected final String KEY_SUFFIX;
    protected final String KEY_TIME_FORMAT;
    protected final String KEY_TIME_OFFSET_DAY;
    protected final String KEY_TIME_OFFSET_HOUR;
    protected final String KEY_TIME_OFFSET_MINUTE;
    protected final String KEY_TIME_OFFSET_MONTH;
    protected final String KEY_TIME_OFFSET_SECOND;
    protected final String KEY_TIME_OFFSET_YEAR;
    protected final String KEY_TIME_TYPE;
    private int colorType;
    private int columnIndex;
    public PrinterLabelBarCodeView.DynamicTimeUpdateListener dynamicTimeUpdateListener;
    private String encodeRef;
    private String excelName;
    private String excelUrl;
    private Handler handler;
    private ImageView iv;
    private Runnable runnable;
    private String showContent;
    private boolean showTableHeader;
    private int whiteMargin;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface DynamicTimeUpdateListener {
        void updateDateValue(String str);
    }

    public PrinterLabelQrCodeView(TemplatePageView templatePageView) {
        super(templatePageView);
        this.iv = null;
        this.showContent = "";
        this.whiteMargin = 0;
        this.encodeRef = "QR_CODE";
        this.KEY_INPUTDATATYPE = "inputDataType";
        this.KEY_CONTENT = FirebaseAnalytics.Param.CONTENT;
        this.KEY_CODE_TYPE = "encodeRef";
        this.KEY_PREFIX = "prefix";
        this.KEY_SUFFIX = "suffix";
        this.KEY_INTERVAL = "interval";
        this.KEY_TIME_TYPE = "timeType";
        this.KEY_TIME_FORMAT = "timeFormat";
        this.KEY_TIME_OFFSET_YEAR = "timeOffsetYear";
        this.KEY_TIME_OFFSET_MONTH = "timeOffsetMonth";
        this.KEY_TIME_OFFSET_DAY = "timeOffsetDay";
        this.KEY_TIME_OFFSET_HOUR = "timeOffsetHour";
        this.KEY_TIME_OFFSET_MINUTE = "timeOffsetMinute";
        this.KEY_TIME_OFFSET_SECOND = "timeOffsetSecond";
        this.KEY_EXCELFILEURL = "excelFileUrl";
        this.KEY_EXCELNAME = "excelName";
        this.KEY_EXCELHEADERCOLUMN = "excelHeaderColumn";
        this.KEY_ISSHOWEXCELHEADER = "isShowExcelHeader";
        this.colorType = 0;
        this.handler = new Handler();
        this.runnable = new Runnable() { // from class: com.appdev.standard.page.printerlabel.widget.PrinterLabelQrCodeView.1
            @Override // java.lang.Runnable
            public void run() {
                PrinterLabelQrCodeView.this.updateTimeContent();
                PrinterLabelQrCodeView.this.handler.postDelayed(PrinterLabelQrCodeView.this.runnable, 1000L);
            }
        };
        this.iv = (ImageView) findViewById(d.iv_qr_code);
        this.content = "12345678";
        int i5 = this.inputDataType;
        if (i5 == 0) {
            this.showContent = "12345678";
        } else if (i5 == 1) {
            this.showContent = this.prefix + this.content + this.suffix;
        } else if (i5 == 2 && this.timeType == 1) {
            Date date = new Date(System.currentTimeMillis());
            date.setYear(date.getYear() + this.timeOffsetYear);
            date.setMonth(date.getMonth() + this.timeOffsetMonth);
            date.setDate(date.getDate() + this.timeOffsetDay);
            date.setHours(date.getHours() + this.timeOffsetHour);
            date.setMinutes(date.getMinutes() + this.timeOffsetMinute);
            date.setSeconds(date.getSeconds() + this.timeOffsetSecond);
            this.showContent = h.a(date.getTime(), this.timeFormat.replace(" am/pm", ""));
        } else {
            this.showContent = "12345678";
        }
        updateView();
    }

    private String convertErrorCorrectionLevel(int i5) {
        if (i5 == 1) {
            return "L";
        }
        if (i5 != 2) {
            return i5 != 3 ? "H" : "Q";
        }
        return "M";
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
        this.content = strA;
        updateView();
        PrinterLabelBarCodeView.DynamicTimeUpdateListener dynamicTimeUpdateListener = this.dynamicTimeUpdateListener;
        if (dynamicTimeUpdateListener != null) {
            dynamicTimeUpdateListener.updateDateValue(strA);
        }
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int defaultHeight() {
        return 200;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int defaultWidth() {
        return 200;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int elementType() {
        return 8;
    }

    public int getColumnIndex() {
        return this.columnIndex;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.IDTControlView
    public String getControlViewContent() {
        return this.showContent;
    }

    public String getExcelName() {
        return this.excelName;
    }

    public String getExcelUrl() {
        return this.excelUrl;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public JSONObject getJson() {
        super.getJson();
        try {
            this.saveObject.put("inputDataType", this.inputDataType);
            this.saveObject.put(FirebaseAnalytics.Param.CONTENT, this.content);
            this.saveObject.put("encodeRef", this.encodeRef);
            this.saveObject.put("interval", this.interval);
            this.saveObject.put("prefix", this.prefix);
            this.saveObject.put("suffix", this.suffix);
            this.saveObject.put("timeType", this.timeType);
            this.saveObject.put("timeFormat", this.timeFormat);
            this.saveObject.put("timeOffsetYear", this.timeOffsetYear);
            this.saveObject.put("timeOffsetMonth", this.timeOffsetMonth);
            this.saveObject.put("timeOffsetDay", this.timeOffsetDay);
            this.saveObject.put("timeOffsetHour", this.timeOffsetHour);
            this.saveObject.put("timeOffsetMinute", this.timeOffsetMinute);
            this.saveObject.put("timeOffsetSecond", this.timeOffsetSecond);
            this.saveObject.put("excelFileUrl", this.excelUrl);
            this.saveObject.put("excelName", this.excelName);
            this.saveObject.put("excelHeaderColumn", this.columnIndex);
            this.saveObject.put("isShowExcelHeader", this.showTableHeader);
            this.saveObject.put(KEY_COLOR_TYPE, this.colorType);
        } catch (JSONException e) {
            p051j0.a.d(this.TAG, e.toString());
        }
        return this.saveObject;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.IDTControlView
    public void intervalContentInMainThread(int i5) {
        String str;
        if (getInputDataType() != 3) {
            super.intervalContentInMainThread(i5);
            return;
        }
        if (i5 == 0 || (str = this.excelUrl) == null || str.isEmpty()) {
            return;
        }
        K cellInfo = g.readCellInfo(this.excelUrl, i5 + 1, this.columnIndex);
        if (cellInfo.a()) {
            p051j0.a.k("PrinterLabelTextView", "intervalContentInMainThread: " + cellInfo.exceptionOrNull());
            return;
        }
        p056k0.c cVar = (p056k0.c) cellInfo.getOrNull();
        if (cVar == null) {
            return;
        }
        if (this.showTableHeader) {
            setControlViewContent(cVar.getName() + ParameterizedMessage.ERROR_MSG_SEPARATOR + cVar.getValue());
        } else {
            setControlViewContent(cVar.getValue());
        }
        int left = this.mRoot.getLeft();
        int top = this.mRoot.getTop();
        this.mRoot.measure(View.MeasureSpec.makeMeasureSpec(this.templatePage.getBgWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(this.templatePage.getBgHeight(), Integer.MIN_VALUE));
        RelativeLayout relativeLayout = this.mRoot;
        relativeLayout.layout(left, top, relativeLayout.getMeasuredWidth() + left, this.mRoot.getMeasuredHeight() + top);
    }

    public boolean isShowTableHeader() {
        return this.showTableHeader;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int layoutId() {
        return e.printer_label_qrcode_view;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int minHeight() {
        return 100;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int minWidth() {
        return 100;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public void onSizeChanged(int i5, int i6) {
        super.onSizeChanged(i5, i6);
        updateView();
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public void recoverFromJson(JSONObject jSONObject) {
        super.recoverFromJson(jSONObject);
        try {
            this.inputDataType = getObjectInt(jSONObject, "inputDataType", 0);
            this.content = getObjectString(jSONObject, FirebaseAnalytics.Param.CONTENT, "");
            this.interval = getObjectInt(jSONObject, "interval", 1);
            this.prefix = getObjectString(jSONObject, "prefix", "");
            this.suffix = getObjectString(jSONObject, "suffix", "");
            this.timeType = getObjectInt(jSONObject, "timeType", 0);
            this.timeFormat = getObjectString(jSONObject, "timeFormat", "yyyy/MM/dd");
            this.timeOffsetYear = getObjectInt(jSONObject, "timeOffsetYear", 0);
            this.timeOffsetMonth = getObjectInt(jSONObject, "timeOffsetMonth", 0);
            this.timeOffsetDay = getObjectInt(jSONObject, "timeOffsetDay", 0);
            this.timeOffsetHour = getObjectInt(jSONObject, "timeOffsetHour", 0);
            this.timeOffsetMinute = getObjectInt(jSONObject, "timeOffsetMinute", 0);
            this.timeOffsetSecond = getObjectInt(jSONObject, "timeOffsetSecond", 0);
            this.excelUrl = getObjectString(jSONObject, "excelFileUrl", "");
            this.excelName = getObjectString(jSONObject, "excelName", "");
            this.columnIndex = getObjectInt(jSONObject, "excelHeaderColumn", 0);
            this.showTableHeader = getObjectBoolean(jSONObject, "isShowExcelHeader");
            this.colorType = getObjectInt(jSONObject, KEY_COLOR_TYPE, 0);
            int i5 = this.inputDataType;
            if (i5 == 0) {
                this.handler.removeCallbacks(this.runnable);
                this.showContent = this.content;
            } else if (i5 == 1) {
                this.handler.removeCallbacks(this.runnable);
                this.showContent = this.prefix + this.content + this.suffix;
            } else if (i5 != 2) {
                if (i5 != 3) {
                    this.handler.removeCallbacks(this.runnable);
                    this.showContent = this.content;
                } else {
                    this.handler.removeCallbacks(this.runnable);
                    this.showContent = this.content;
                }
            } else if (this.timeType == 1) {
                Date date = new Date(System.currentTimeMillis());
                date.setYear(date.getYear() + this.timeOffsetYear);
                date.setMonth(date.getMonth() + this.timeOffsetMonth);
                date.setDate(date.getDate() + this.timeOffsetDay);
                date.setHours(date.getHours() + this.timeOffsetHour);
                date.setMinutes(date.getMinutes() + this.timeOffsetMinute);
                date.setSeconds(date.getSeconds() + this.timeOffsetSecond);
                this.showContent = h.a(date.getTime(), this.timeFormat.replace(" am/pm", ""));
                this.handler.post(this.runnable);
            } else {
                this.handler.removeCallbacks(this.runnable);
                this.showContent = this.content;
            }
            if (jSONObject.has("encodeRef")) {
                this.encodeRef = getObjectString(jSONObject, "encodeRef", "QR_CODE");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        updateView();
    }

    public void setColumnIndex(int i5) {
        this.columnIndex = i5;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.IDTControlView
    public void setControlViewContent(String str) {
        this.showContent = str;
        updateView();
    }

    public void setDynamicTimeUpdateListener(PrinterLabelBarCodeView.DynamicTimeUpdateListener dynamicTimeUpdateListener) {
        this.dynamicTimeUpdateListener = dynamicTimeUpdateListener;
    }

    public void setExcelName(String str) {
        this.excelName = str;
    }

    public void setExcelUrl(String str) {
        this.excelUrl = str;
    }

    public void setShowTableHeader(boolean z6) {
        this.showTableHeader = z6;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public void updateView() {
        int dimensionPixelOffset;
        int i5 = this.colorType == 1 ? SupportMenu.CATEGORY_MASK : ViewCompat.MEASURED_STATE_MASK;
        ViewGroup.LayoutParams layoutParams = this.mRoot.getLayoutParams();
        String str = this.encodeRef;
        String str2 = this.showContent;
        int zoomScale = layoutParams.width;
        if (zoomScale == 0) {
            zoomScale = (int) (this.templatePage.getZoomScale() * defaultWidth());
        }
        int zoomScale2 = layoutParams.height;
        if (zoomScale2 == 0) {
            zoomScale2 = (int) (this.templatePage.getZoomScale() * defaultHeight());
        }
        this.iv.setImageBitmap(QRCodeUtil.createQRCodeBitmap(str, str2, zoomScale, zoomScale2, "UTF-8", null, "0", i5, 0));
        int i6 = this.whiteMargin;
        if (i6 == 2) {
            dimensionPixelOffset = getResources().getDimensionPixelOffset(p113u.b.px8dp);
        } else {
            dimensionPixelOffset = i6 == 4 ? getResources().getDimensionPixelOffset(p113u.b.px16dp) : 0;
        }
        this.iv.setPadding(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
        setControlType(2);
        this.isRenderingCompleted = true;
        super.updateView();
    }

    public PrinterLabelQrCodeView(TemplatePageView templatePageView, String str, String str2, String str3, String str4, int i5, boolean z6) {
        this(templatePageView);
        this.content = str;
        this.inputDataType = 3;
        this.encodeRef = str2;
        this.excelUrl = str3;
        this.excelName = str4;
        this.showTableHeader = z6;
        this.columnIndex = i5;
    }
}
