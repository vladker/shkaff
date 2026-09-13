package com.appdev.standard.model;

import androidx.collection.a;
import com.google.gson.GsonBuilder;
import kotlin.jvm.internal.Y;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ReceiptTextDataModel {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f2672w;
    private int inputDataType = 0;
    private String content = "";
    private int aligment = 0;
    private boolean isBold = false;
    private boolean isItalic = false;
    private boolean isUnderLine = false;
    private boolean isDeleteLine = false;
    private int fontSize = 30;
    private float wordSpace = 0.0f;
    private float linesSpace = 0.0f;
    private String fontId = "0";
    private String prefix = "";
    private String suffix = "";
    private int interval = 1;

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

    public String getFontId() {
        return this.fontId;
    }

    public int getFontSize() {
        return this.fontSize;
    }

    public int getInputDataType() {
        return this.inputDataType;
    }

    public int getInterval() {
        return this.interval;
    }

    public float getLinesSpace() {
        return this.linesSpace;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public String getShowContent(int i5) {
        int i6;
        if (Y.f(this.content)) {
            return "";
        }
        if (this.inputDataType != 1) {
            return this.content;
        }
        int length = this.content.length() - 1;
        int i7 = -1;
        while (true) {
            if (length < 0) {
                i6 = -1;
                break;
            }
            if (Character.isDigit(this.content.charAt(length))) {
                if (i7 == -1) {
                    i7 = length + 1;
                }
            } else if (i7 != -1) {
                i6 = length + 1;
                break;
            }
            length--;
        }
        if (i7 != -1 && i6 == -1) {
            i6 = 0;
        }
        if (i7 == -1 && i6 == -1) {
            return this.prefix + this.content + this.suffix;
        }
        String str = String.format(a.i(i7 - i6, "%0", "d"), Long.valueOf(Y.i(this.content.substring(i6, i7)) + ((long) (i5 * this.interval))));
        StringBuilder sb = new StringBuilder();
        sb.append(this.content.substring(0, i6));
        sb.append(str);
        return this.prefix + androidx.exifinterface.media.a.j(this.content, i7, sb) + this.suffix;
    }

    public String getSuffix() {
        return this.suffix;
    }

    public float getW() {
        return this.f2672w;
    }

    public float getWordSpace() {
        return this.wordSpace;
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

    public void setDeleteLine(boolean z6) {
        this.isDeleteLine = z6;
    }

    public void setFontId(String str) {
        this.fontId = str;
    }

    public void setFontSize(int i5) {
        this.fontSize = i5;
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

    public void setLinesSpace(float f6) {
        this.linesSpace = f6;
    }

    public void setPrefix(String str) {
        this.prefix = str;
    }

    public void setSuffix(String str) {
        this.suffix = str;
    }

    public void setUnderLine(boolean z6) {
        this.isUnderLine = z6;
    }

    public void setW(float f6) {
        this.f2672w = f6;
    }

    public void setWordSpace(float f6) {
        this.wordSpace = f6;
    }

    public String toJson() {
        return new GsonBuilder().disableHtmlEscaping().create().toJson(this);
    }
}
