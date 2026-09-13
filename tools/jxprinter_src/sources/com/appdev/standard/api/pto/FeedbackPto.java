package com.appdev.standard.api.pto;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class FeedbackPto {
    private String contactWay;
    private String feedbackContent;
    private String feedbackType;
    private String imgUrls;
    private String platform = "1";

    public FeedbackPto(String str, String str2, String str3, String str4) {
        this.contactWay = str;
        this.feedbackContent = str2;
        this.feedbackType = str3;
        this.imgUrls = str4;
    }

    public String getContactWay() {
        return this.contactWay;
    }

    public String getFeedbackContent() {
        return this.feedbackContent;
    }

    public String getFeedbackType() {
        return this.feedbackType;
    }

    public String getImgUrls() {
        return this.imgUrls;
    }

    public String getPlatform() {
        return this.platform;
    }

    public void setContactWay(String str) {
        this.contactWay = str;
    }

    public void setFeedbackContent(String str) {
        this.feedbackContent = str;
    }

    public void setFeedbackType(String str) {
        this.feedbackType = str;
    }

    public void setImgUrls(String str) {
        this.imgUrls = str;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }
}
