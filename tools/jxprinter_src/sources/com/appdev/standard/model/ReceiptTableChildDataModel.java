package com.appdev.standard.model;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ReceiptTableChildDataModel {
    private int aligment;
    private float columnsWidth;
    private String content;
    private float fontSize;
    private boolean isBold;
    private boolean isDeleteLine;
    private boolean isItalic;
    private boolean isUnderLine;
    private float rowsHeight;

    public ReceiptTableChildDataModel() {
        this.content = "";
        this.fontSize = 30.0f;
        this.rowsHeight = 3.0f;
        this.columnsWidth = 3.0f;
        this.isBold = false;
        this.isItalic = false;
        this.isUnderLine = false;
        this.isDeleteLine = false;
        this.aligment = 0;
    }

    public int getAligment() {
        return this.aligment;
    }

    public float getColumnsWidth() {
        return this.columnsWidth;
    }

    public String getContent() {
        return this.content;
    }

    public float getFontSize() {
        return this.fontSize;
    }

    public float getRowsHeight() {
        return this.rowsHeight;
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

    public void setColumnsWidth(float f6) {
        this.columnsWidth = f6;
    }

    public void setContent(String str) {
        this.content = str;
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

    public void setRowsHeight(float f6) {
        this.rowsHeight = f6;
    }

    public void setUnderLine(boolean z6) {
        this.isUnderLine = z6;
    }

    public void setFontSize(float f6) {
        this.fontSize = f6;
    }

    public ReceiptTableChildDataModel(float f6, float f7) {
        this.content = "";
        this.fontSize = 30.0f;
        this.isBold = false;
        this.isItalic = false;
        this.isUnderLine = false;
        this.isDeleteLine = false;
        this.aligment = 0;
        this.rowsHeight = f6;
        this.columnsWidth = f7;
    }
}
