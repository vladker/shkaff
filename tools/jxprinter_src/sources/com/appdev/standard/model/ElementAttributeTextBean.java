package com.appdev.standard.model;

import com.google.gson.GsonBuilder;
import org.json.JSONException;
import org.json.JSONObject;
import p051j0.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ElementAttributeTextBean extends ElementAttributeBean {
    private String fontPath;
    private int colorType = 0;
    private int direction = 0;
    private int inputDataType = 0;
    private String content = "";
    private float wordSpace = 0.0f;
    private float linesSpace = 0.0f;
    private boolean lineWrap = true;
    private boolean automaticHeightCalculation = true;
    private String fontId = "0";
    private int aligment = 0;
    private boolean isBold = false;
    private boolean isItalic = false;
    private boolean isUnderLine = false;
    private boolean isDeleteLine = false;
    private float fontSize = 40.0f;
    private String prefix = "";
    private String suffix = "";
    private int interval = 1;
    private String excelFileUrl = "";
    private String excelName = "";
    private int excelHeaderColumn = 0;
    private boolean isShowExcelHeader = true;
    private boolean isDarkMode = false;

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

    public int getDirection() {
        return this.direction;
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

    public String getFontPath() {
        return this.fontPath;
    }

    public String getFontType() {
        return this.fontId;
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

    public String getSuffix() {
        return this.suffix;
    }

    public float getTextSize() {
        return this.fontSize;
    }

    public float getWordSpace() {
        return this.wordSpace;
    }

    public int gethAlignment() {
        return this.aligment;
    }

    public boolean isAutomaticHeightCalculation() {
        return this.automaticHeightCalculation;
    }

    public boolean isBold() {
        return this.isBold;
    }

    public boolean isDarkMode() {
        return this.isDarkMode;
    }

    public boolean isItalic() {
        return this.isItalic;
    }

    public boolean isLineWrap() {
        return this.lineWrap;
    }

    public boolean isShowExcelHeader() {
        return this.isShowExcelHeader;
    }

    public boolean isStrikethrough() {
        return this.isDeleteLine;
    }

    public boolean isUnderline() {
        return this.isUnderLine;
    }

    public void setAutomaticHeightCalculation(boolean z6) {
        this.automaticHeightCalculation = z6;
    }

    public void setBold(boolean z6) {
        this.isBold = z6;
    }

    public void setColorType(int i5) {
        this.colorType = i5;
    }

    public void setContent(String str) {
        a.k("TAG", "---content=" + str);
        this.content = str;
    }

    public void setDarkMode(boolean z6) {
        this.isDarkMode = z6;
    }

    public void setDirection(int i5) {
        this.direction = i5;
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

    public void setFontPath(String str) {
        this.fontPath = str;
    }

    public void setFontType(String str) {
        this.fontId = str;
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

    public void setLineWrap(boolean z6) {
        this.lineWrap = z6;
    }

    public void setLinesSpace(float f6) {
        this.linesSpace = f6;
    }

    public void setPrefix(String str) {
        this.prefix = str;
    }

    public void setShowExcelHeader(boolean z6) {
        this.isShowExcelHeader = z6;
    }

    public void setStrikethrough(boolean z6) {
        this.isDeleteLine = z6;
    }

    public void setSuffix(String str) {
        this.suffix = str;
    }

    public void setTextSize(float f6) {
        this.fontSize = f6;
    }

    public void setUnderline(boolean z6) {
        this.isUnderLine = z6;
    }

    public void setWordSpace(float f6) {
        this.wordSpace = f6;
    }

    public void sethAlignment(int i5) {
        this.aligment = i5;
    }

    public String toJson() {
        return new GsonBuilder().disableHtmlEscaping().create().toJson(this);
    }
}
