package com.appdev.standard.model;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ReceiptModel implements Serializable {
    private String content;
    private String coverUrl;
    private String receiptId;
    private String title;
    private int width;

    public String getContent() {
        return this.content;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public String getReceiptId() {
        return this.receiptId;
    }

    public String getTitle() {
        return this.title;
    }

    public int getWidth() {
        return this.width;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setCoverUrl(String str) {
        this.coverUrl = str;
    }

    public void setReceiptId(String str) {
        this.receiptId = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setWidth(int i5) {
        this.width = i5;
    }
}
