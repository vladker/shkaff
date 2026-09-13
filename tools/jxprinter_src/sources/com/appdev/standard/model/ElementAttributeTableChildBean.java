package com.appdev.standard.model;

import com.google.gson.GsonBuilder;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ElementAttributeTableChildBean {
    private int aligment;
    private int baseOffsetX;
    private int baseOffsetY;
    private float columnsWidth;
    private String content;
    private int direction;
    private String fontId;
    private float fontSize;
    private boolean isBold;
    private boolean isDeleteLine;
    private boolean isItalic;
    private boolean isSelect;
    private boolean isShowCell;
    private boolean isUnderLine;
    private float linesSpace;
    private int mergeHeight;
    private int mergeWidth;
    private float rowsHeight;
    private float wordSpace;

    public ElementAttributeTableChildBean() {
        this.content = "";
        this.fontSize = 35.0f;
        this.linesSpace = 0.0f;
        this.wordSpace = 0.0f;
        this.fontId = "0";
        this.isUnderLine = false;
        this.isDeleteLine = false;
        this.isBold = false;
        this.isItalic = false;
        this.aligment = 1;
        this.direction = 0;
        this.rowsHeight = 3.0f;
        this.columnsWidth = 3.0f;
        this.mergeWidth = 1;
        this.mergeHeight = 1;
        this.baseOffsetX = 0;
        this.baseOffsetY = 0;
        this.isShowCell = true;
        this.isSelect = false;
    }

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

    public int getBaseOffsetX() {
        return this.baseOffsetX;
    }

    public int getBaseOffsetY() {
        return this.baseOffsetY;
    }

    public float getColumnsWidth() {
        return this.columnsWidth;
    }

    public String getContent() {
        return this.content;
    }

    public int getDirection() {
        return this.direction;
    }

    public String getFontId() {
        return this.fontId;
    }

    public float getFontSize() {
        return this.fontSize;
    }

    public float getLinesSpace() {
        return this.linesSpace;
    }

    public int getMergeHeight() {
        return this.mergeHeight;
    }

    public int getMergeWidth() {
        return this.mergeWidth;
    }

    public float getRowsHeight() {
        return this.rowsHeight;
    }

    public float getWordSpace() {
        return this.wordSpace;
    }

    public boolean isIsBold() {
        return this.isBold;
    }

    public boolean isIsDeleteLine() {
        return this.isDeleteLine;
    }

    public boolean isIsItalic() {
        return this.isItalic;
    }

    public boolean isIsUnderLine() {
        return this.isUnderLine;
    }

    public boolean isMergeCell() {
        return this.mergeWidth > 1 || this.mergeHeight > 1;
    }

    public boolean isSelect() {
        return this.isSelect;
    }

    public boolean isShowCell() {
        return this.isShowCell;
    }

    public void setAligment(int i5) {
        this.aligment = i5;
    }

    public void setBaseOffsetX(int i5) {
        this.baseOffsetX = i5;
    }

    public void setBaseOffsetY(int i5) {
        this.baseOffsetY = i5;
    }

    public void setColumnsWidth(float f6) {
        this.columnsWidth = f6;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setDirection(int i5) {
        this.direction = i5;
    }

    public void setFontId(String str) {
        this.fontId = str;
    }

    public void setFontSize(int i5) {
        this.fontSize = i5;
    }

    public void setIsBold(boolean z6) {
        this.isBold = z6;
    }

    public void setIsDeleteLine(boolean z6) {
        this.isDeleteLine = z6;
    }

    public void setIsItalic(boolean z6) {
        this.isItalic = z6;
    }

    public void setIsUnderLine(boolean z6) {
        this.isUnderLine = z6;
    }

    public void setLinesSpace(float f6) {
        this.linesSpace = f6;
    }

    public void setMergeHeight(int i5) {
        this.mergeHeight = i5;
    }

    public void setMergeWidth(int i5) {
        this.mergeWidth = i5;
    }

    public void setRowsHeight(float f6) {
        this.rowsHeight = f6;
    }

    public void setSelect(boolean z6) {
        this.isSelect = z6;
    }

    public void setShowCell(boolean z6) {
        this.isShowCell = z6;
    }

    public void setWordSpace(float f6) {
        this.wordSpace = f6;
    }

    public String toJson() {
        return new GsonBuilder().disableHtmlEscaping().create().toJson(this);
    }

    public ElementAttributeTableChildBean(float f6, float f7) {
        this.content = "";
        this.fontSize = 35.0f;
        this.linesSpace = 0.0f;
        this.wordSpace = 0.0f;
        this.fontId = "0";
        this.isUnderLine = false;
        this.isDeleteLine = false;
        this.isBold = false;
        this.isItalic = false;
        this.aligment = 1;
        this.direction = 0;
        this.mergeWidth = 1;
        this.mergeHeight = 1;
        this.baseOffsetX = 0;
        this.baseOffsetY = 0;
        this.isShowCell = true;
        this.isSelect = false;
        this.rowsHeight = f6;
        this.columnsWidth = f7;
    }
}
