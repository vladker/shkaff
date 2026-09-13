package com.appdev.standard.api.pto;

import com.google.gson.GsonBuilder;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class TemplateElementPto implements Serializable {
    private String content;
    private String coverUrl;
    private String description;
    private int height;
    private String templateId;
    private String templateIndustry;
    private String templateType;
    private String title;
    private int width;

    public String getContent() {
        return this.content;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public String getDescription() {
        return this.description;
    }

    public int getHeight() {
        return this.height;
    }

    public String getTemplateId() {
        return this.templateId;
    }

    public String getTemplateIndustry() {
        return this.templateIndustry;
    }

    public String getTemplateType() {
        return this.templateType;
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

    public void setDescription(String str) {
        this.description = str;
    }

    public void setHeight(int i5) {
        this.height = i5;
    }

    public void setTemplateId(String str) {
        this.templateId = str;
    }

    public void setTemplateIndustry(String str) {
        this.templateIndustry = str;
    }

    public void setTemplateType(String str) {
        this.templateType = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setWidth(int i5) {
        this.width = i5;
    }

    public String toJson() {
        String json = new GsonBuilder().disableHtmlEscaping().create().toJson(this);
        System.out.println(json);
        return json;
    }
}
