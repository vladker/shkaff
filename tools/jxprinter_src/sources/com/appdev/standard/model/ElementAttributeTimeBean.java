package com.appdev.standard.model;

import com.google.gson.GsonBuilder;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ElementAttributeTimeBean extends ElementAttributeBean {
    private int colorType = 0;
    private String content = "";
    private float fontSize = 14.0f;
    private float wordSpace = 0.0f;
    private String fontId = "0";
    private boolean isBold = false;
    private boolean isItalic = false;
    private boolean isUnderLine = false;
    private boolean isDeleteLine = false;
    private int timeType = 0;
    private String timeFormat = "yyyy/MM/dd";
    private int timeOffsetYear = 0;
    private int timeOffsetMonth = 0;
    private int timeOffsetDay = 0;
    private int timeOffsetHour = 0;
    private int timeOffsetMinute = 0;
    private int timeOffsetSecond = 0;

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

    public String getFontId() {
        return this.fontId;
    }

    public float getFontSize() {
        return this.fontSize;
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

    public float getWordSpace() {
        return this.wordSpace;
    }

    public boolean isBold() {
        return this.isBold;
    }

    public boolean isItalic() {
        return this.isItalic;
    }

    public boolean isStrikethrough() {
        return this.isDeleteLine;
    }

    public boolean isUnderline() {
        return this.isUnderLine;
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

    public void setFontId(String str) {
        this.fontId = str;
    }

    public void setFontSize(float f6) {
        this.fontSize = f6;
    }

    public void setItalic(boolean z6) {
        this.isItalic = z6;
    }

    public void setStrikethrough(boolean z6) {
        this.isDeleteLine = z6;
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

    public void setUnderline(boolean z6) {
        this.isUnderLine = z6;
    }

    public void setWordSpace(float f6) {
        this.wordSpace = f6;
    }

    public String toJson() {
        return new GsonBuilder().disableHtmlEscaping().create().toJson(this);
    }
}
