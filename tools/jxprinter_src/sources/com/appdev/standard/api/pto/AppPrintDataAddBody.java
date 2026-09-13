package com.appdev.standard.api.pto;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class AppPrintDataAddBody {
    private String coverUrl;
    private int dataSource;
    private int height;
    private int paperType;
    private int printCount;
    private String shareLink;
    private String title;
    private int width;

    public AppPrintDataAddBody(String str, int i5, int i6, int i7, int i8, String str2, String str3, int i9) {
        this.coverUrl = str;
        this.dataSource = i5;
        this.height = i6;
        this.paperType = i7;
        this.printCount = i8;
        this.shareLink = str2;
        this.title = str3;
        this.width = i9;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public int getDataSource() {
        return this.dataSource;
    }

    public int getHeight() {
        return this.height;
    }

    public int getPaperType() {
        return this.paperType;
    }

    public int getPrintCount() {
        return this.printCount;
    }

    public String getShareLink() {
        return this.shareLink;
    }

    public String getTitle() {
        return this.title;
    }

    public int getWidth() {
        return this.width;
    }

    public void setCoverUrl(String str) {
        this.coverUrl = str;
    }

    public void setDataSource(int i5) {
        this.dataSource = i5;
    }

    public void setHeight(int i5) {
        this.height = i5;
    }

    public void setPaperType(int i5) {
        this.paperType = i5;
    }

    public void setPrintCount(int i5) {
        this.printCount = i5;
    }

    public void setShareLink(String str) {
        this.shareLink = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setWidth(int i5) {
        this.width = i5;
    }
}
