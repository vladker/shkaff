package com.appdev.standard.model;

import com.google.gson.GsonBuilder;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ElementAttributeQrCodeBean extends ElementAttributeBean {
    private int colorType = 0;
    private int inputDataType = 0;
    private String content = "";
    private String encodeRef = "QR_CODE";
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

    public int getColorType() {
        return this.colorType;
    }

    public String getContent() {
        return this.content;
    }

    public String getEncodeRef() {
        return this.encodeRef;
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

    public int getInputDataType() {
        return this.inputDataType;
    }

    public int getInterval() {
        return this.interval;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public String getSuffix() {
        return this.suffix;
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

    public boolean isShowExcelHeader() {
        return this.isShowExcelHeader;
    }

    public void setColorType(int i5) {
        this.colorType = i5;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setEncodeRef(String str) {
        this.encodeRef = str;
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

    public void setInputDataType(int i5) {
        this.inputDataType = i5;
    }

    public void setInterval(int i5) {
        this.interval = i5;
    }

    public void setPrefix(String str) {
        this.prefix = str;
    }

    public void setShowExcelHeader(boolean z6) {
        this.isShowExcelHeader = z6;
    }

    public void setSuffix(String str) {
        this.suffix = str;
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

    public String toJson() {
        return new GsonBuilder().disableHtmlEscaping().create().toJson(this);
    }
}
