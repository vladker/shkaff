package com.appdev.standard.api.pto;

import com.google.gson.GsonBuilder;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class TemplatePto {
    private TemplateModulePto module;
    private TemplatePaperPto paper;
    private List<Object> views;

    public TemplateModulePto getModule() {
        return this.module;
    }

    public TemplatePaperPto getPaper() {
        return this.paper;
    }

    public List<Object> getViews() {
        return this.views;
    }

    public void setModule(TemplateModulePto templateModulePto) {
        this.module = templateModulePto;
    }

    public void setPaper(TemplatePaperPto templatePaperPto) {
        this.paper = templatePaperPto;
    }

    public void setViews(List<Object> list) {
        this.views = list;
    }

    public String toJson() {
        String json = new GsonBuilder().disableHtmlEscaping().create().toJson(this);
        System.out.println(json);
        return json;
    }
}
