package com.appdev.standard.model;

import com.google.gson.GsonBuilder;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ElementAttributeBarCodeBean extends ElementAttributeBean {
    private int colorType = 0;
    private int inputDataType = 0;
    protected int transmutationValue = 0;
    private String content = "";
    private String fontType = "0";
    private float fontSize = 14.0f;
    private int textPosition = 2;
    private String encodeRef = "CODE_128";
    private int aligment = 1;
    private boolean isBold = false;
    private boolean isItalic = false;
    private boolean isUnderLine = false;
    private boolean isDeleteLine = false;
    private String prefix = "";
    private String suffix = "";
    private int interval = 0;
    private int timeType = 0;
    private String timeFormat = "yyyy/MM/dd";
    private int timeOffsetYear = 0;
    private int timeOffsetMonth = 0;
    private int timeOffsetDay = 0;
    private int timeOffsetHour = 0;
    private int timeOffsetMinute = 0;
    private int timeOffsetSecond = 0;
    private String excelFileUrl = "";
    private String excelName = "";
    private int excelHeaderColumn = 0;
    private boolean isShowExcelHeader = true;

    public JSONObject ObjectToJson() {
        try {
            return new JSONObject(toJson());
        } catch (JSONException e) {
            e.printStackTrace();
            return new JSONObject();
        }
    }

    public int getAligment() {
        return this.aligment;
    }

    public String getBarcodeType() {
        return this.encodeRef;
    }

    public int getColorType() {
        return this.colorType;
    }

    public String getContent() {
        return this.content;
    }

    public String getExcelFileUrl() {
        return this.excelFileUrl;
    }

    public int getExcelHeaderColumn() {
        return this.excelHeaderColumn;
    }

    public String getExcelName() {
        return this.excelName;
    }

    public String getFontType() {
        return this.fontType;
    }

    public int getInputDataType() {
        return this.inputDataType;
    }

    public int getInterval() {
        return this.interval;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public int getShowText() {
        return this.textPosition;
    }

    public String getSuffix() {
        return this.suffix;
    }

    public float getTextSize() {
        return this.fontSize;
    }

    public String getTimeFormat() {
        return this.timeFormat;
    }

    public int getTimeOffsetDay() {
        return this.timeOffsetDay;
    }

    public int getTimeOffsetHour() {
        return this.timeOffsetHour;
    }

    public int getTimeOffsetMinute() {
        return this.timeOffsetMinute;
    }

    public int getTimeOffsetMonth() {
        return this.timeOffsetMonth;
    }

    public int getTimeOffsetSecond() {
        return this.timeOffsetSecond;
    }

    public int getTimeOffsetYear() {
        return this.timeOffsetYear;
    }

    public int getTimeType() {
        return this.timeType;
    }

    public int getTransmutationValue() {
        return this.transmutationValue;
    }

    public boolean isBold() {
        return this.isBold;
    }

    public boolean isDeleteLine() {
        return this.isDeleteLine;
    }

    public boolean isItalic() {
        return this.isItalic;
    }

    public boolean isShowExcelHeader() {
        return this.isShowExcelHeader;
    }

    public boolean isUnderLine() {
        return this.isUnderLine;
    }

    public void setAligment(int i5) {
        this.aligment = i5;
    }

    public void setBarcodeType(String str) {
        this.encodeRef = str;
    }

    public void setBold(boolean z6) {
        this.isBold = z6;
    }

    public void setColorType(int i5) {
        this.colorType = i5;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setDeleteLine(boolean z6) {
        this.isDeleteLine = z6;
    }

    public void setExcelFileUrl(String str) {
        this.excelFileUrl = str;
    }

    public void setExcelHeaderColumn(int i5) {
        this.excelHeaderColumn = i5;
    }

    public void setExcelName(String str) {
        this.excelName = str;
    }

    public void setFontType(String str) {
        this.fontType = str;
    }

    public void setInputDataType(int i5) {
        this.inputDataType = i5;
    }

    public void setInterval(int i5) {
        this.interval = i5;
    }

    public void setItalic(boolean z6) {
        this.isItalic = z6;
    }

    public void setPrefix(String str) {
        this.prefix = str;
    }

    public void setShowExcelHeader(boolean z6) {
        this.isShowExcelHeader = z6;
    }

    public void setShowText(int i5) {
        this.textPosition = i5;
    }

    public void setSuffix(String str) {
        this.suffix = str;
    }

    public void setTextSize(float f6) {
        this.fontSize = f6;
    }

    public void setTimeFormat(String str) {
        this.timeFormat = str;
    }

    public void setTimeOffsetDay(int i5) {
        this.timeOffsetDay = i5;
    }

    public void setTimeOffsetHour(int i5) {
        this.timeOffsetHour = i5;
    }

    public void setTimeOffsetMinute(int i5) {
        this.timeOffsetMinute = i5;
    }

    public void setTimeOffsetMonth(int i5) {
        this.timeOffsetMonth = i5;
    }

    public void setTimeOffsetSecond(int i5) {
        this.timeOffsetSecond = i5;
    }

    public void setTimeOffsetYear(int i5) {
        this.timeOffsetYear = i5;
    }

    public void setTimeType(int i5) {
        this.timeType = i5;
    }

    public void setTransmutationValue(int i5) {
        this.transmutationValue = i5;
    }

    public void setUnderLine(boolean z6) {
        this.isUnderLine = z6;
    }

    public String toJson() {
        return new GsonBuilder().disableHtmlEscaping().create().toJson(this);
    }
}
