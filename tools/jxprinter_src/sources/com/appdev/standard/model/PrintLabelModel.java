package com.appdev.standard.model;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class PrintLabelModel {
    private String biaoqianCloudId;
    private String content;
    private String coverUrl;
    private int height;
    private int numberOfPrint = 1;
    private String title;
    private int width;

    public PrintLabelModel(String str, int i5, int i6, String str2, String str3) {
        this.title = str;
        this.width = i5;
        this.height = i6;
        this.coverUrl = str2;
        this.content = str3;
    }

    public String getBiaoqianCloudId() {
        return this.biaoqianCloudId;
    }

    public String getContent() {
        return this.content;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public int getHeight() {
        return this.height;
    }

    public int getNumberOfPrint() {
        return this.numberOfPrint;
    }

    public String getTitle() {
        return this.title;
    }

    public int getWidth() {
        return this.width;
    }

    public void setBiaoqianCloudId(String str) {
        this.biaoqianCloudId = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setCoverUrl(String str) {
        this.coverUrl = str;
    }

    public void setHeight(int i5) {
        this.height = i5;
    }

    public void setNumberOfPrint(int i5) {
        this.numberOfPrint = i5;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setWidth(int i5) {
        this.width = i5;
    }
}
