package com.appdev.standard.api.pto;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class TemplatePaperPto {
    private String background;
    private String borderUrl;
    private int columnMargin;
    private int columns;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f2601h;
    private int paperType;
    private float rotate;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f2602w;

    public TemplatePaperPto(int i5, int i6, String str, int i7, int i8, String str2, int i9) {
        this.f2602w = i5;
        this.f2601h = i6;
        this.background = str;
        this.columns = i7;
        this.columnMargin = i8;
        this.borderUrl = str2;
        this.paperType = i9;
    }

    public String getBackground() {
        return this.background;
    }

    public String getBorderUrl() {
        return this.borderUrl;
    }

    public int getColumnMargin() {
        return this.columnMargin;
    }

    public int getColumns() {
        return this.columns;
    }

    public int getH() {
        return this.f2601h;
    }

    public int getPaperType() {
        return this.paperType;
    }

    public int getRotate() {
        return (int) this.rotate;
    }

    public int getW() {
        return this.f2602w;
    }

    public void setBackground(String str) {
        this.background = str;
    }

    public void setBorderUrl(String str) {
        this.borderUrl = str;
    }

    public void setColumnMargin(int i5) {
        this.columnMargin = i5;
    }

    public void setColumns(int i5) {
        this.columns = i5;
    }

    public void setH(int i5) {
        this.f2601h = i5;
    }

    public void setPaperType(int i5) {
        this.paperType = i5;
    }

    public void setRotate(float f6) {
        this.rotate = f6;
    }

    public void setW(int i5) {
        this.f2602w = i5;
    }

    public void setRotate(int i5) {
        this.rotate = i5;
    }

    public TemplatePaperPto(int i5, int i6, String str, int i7, int i8, String str2, int i9, int i10) {
        this.f2602w = i5;
        this.f2601h = i6;
        this.background = str;
        this.columns = i7;
        this.columnMargin = i8;
        this.borderUrl = str2;
        this.paperType = i9;
        this.rotate = i10;
    }
}
