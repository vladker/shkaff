package com.appdev.standard.model;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class HelpCenterModel {
    public static final int TYPE_PDF = 2;
    public static final int TYPE_VIDEO = 1;
    public static final int TYPE_WEB = 3;
    private int articleType;
    private String content;
    private String pdfUrl;
    private String title;
    private int type;

    public HelpCenterModel(int i5, String str, String str2) {
        this.type = i5;
        this.title = str;
        this.content = str2;
    }

    public int getArticleType() {
        return this.articleType;
    }

    public String getContent() {
        return this.content;
    }

    public String getPdfUrl() {
        return this.pdfUrl;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public void setArticleType(int i5) {
        this.articleType = i5;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setPdfUrl(String str) {
        this.pdfUrl = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(int i5) {
        this.type = i5;
    }
}
