package com.appdev.standard.model;

import com.bumptech.glide.h;
import com.google.gson.GsonBuilder;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
import p051j0.i;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ReceiptDateDataModel {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f2666w;
    private String content = "";
    private int aligment = 0;
    private boolean isBold = false;
    private boolean isItalic = false;
    private boolean isUnderLine = false;
    private boolean isDeleteLine = false;
    private int fontSize = 30;
    private String prefix = "";
    private String suffix = "";
    private int timeType = 0;
    private String dateFormat = "yyyy/MM/dd";
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

    public int getAligment() {
        return this.aligment;
    }

    public String getContent() {
        return this.content;
    }

    public String getDateFormat() {
        return this.dateFormat;
    }

    public int getFontSize() {
        return this.fontSize;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public String getShowContent(int i5) {
        String string;
        int i6 = this.timeType;
        String string2 = "";
        if (i6 == 0) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(this.prefix);
                if (this.dateFormat.equals(i.f5400a)) {
                    string = "";
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(this.dateFormat);
                    sb2.append(" ");
                    sb2.append(this.timeFormat.equals(i.f5400a) ? "" : this.timeFormat);
                    string = sb2.toString();
                }
                sb.append(h.a(Long.parseLong(this.content), string));
                sb.append(this.suffix);
                return sb.toString();
            } catch (Exception unused) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(this.prefix);
                if (!this.dateFormat.equals(i.f5400a)) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(this.dateFormat);
                    sb4.append(" ");
                    sb4.append(this.timeFormat.equals(i.f5400a) ? "" : this.timeFormat);
                    string2 = sb4.toString();
                }
                sb3.append(h.a(System.currentTimeMillis(), string2));
                sb3.append(this.suffix);
                return sb3.toString();
            }
        }
        if (i6 != 1) {
            return this.prefix + this.content + this.suffix;
        }
        Date date = new Date(System.currentTimeMillis());
        date.setYear(date.getYear() + this.timeOffsetYear);
        date.setMonth(date.getMonth() + this.timeOffsetMonth);
        date.setDate(date.getDate() + this.timeOffsetDay);
        date.setHours(date.getHours() + this.timeOffsetHour);
        date.setMinutes(date.getMinutes() + this.timeOffsetMinute);
        date.setSeconds(date.getSeconds() + this.timeOffsetSecond);
        if (!this.dateFormat.equals(i.f5400a)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.dateFormat);
            sb5.append(" ");
            sb5.append(this.timeFormat.equals(i.f5400a) ? "" : this.timeFormat);
            string2 = sb5.toString();
        }
        return this.prefix + h.a(date.getTime(), string2) + this.suffix;
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

    public float getW() {
        return this.f2666w;
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

    public boolean isUnderLine() {
        return this.isUnderLine;
    }

    public void setAligment(int i5) {
        this.aligment = i5;
    }

    public void setBold(boolean z6) {
        this.isBold = z6;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setDateFormat(String str) {
        this.dateFormat = str;
    }

    public void setDeleteLine(boolean z6) {
        this.isDeleteLine = z6;
    }

    public void setFontSize(int i5) {
        this.fontSize = i5;
    }

    public void setItalic(boolean z6) {
        this.isItalic = z6;
    }

    public void setPrefix(String str) {
        this.prefix = str;
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

    public void setUnderLine(boolean z6) {
        this.isUnderLine = z6;
    }

    public void setW(float f6) {
        this.f2666w = f6;
    }

    public String toJson() {
        return new GsonBuilder().disableHtmlEscaping().create().toJson(this);
    }
}
