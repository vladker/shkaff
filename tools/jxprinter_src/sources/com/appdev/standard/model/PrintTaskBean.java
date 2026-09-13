package com.appdev.standard.model;

import android.graphics.Bitmap;
import com.appdev.standard.api.pto.TemplatePto;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class PrintTaskBean {
    private int pageCount;
    private Bitmap printBitmap;
    private int taskType = 2;
    private TemplateConfigBean templateConfig;
    private TemplatePto templatePto;

    public PrintTaskBean(TemplatePto templatePto, TemplateConfigBean templateConfigBean, int i5) {
        this.templatePto = templatePto;
        this.templateConfig = templateConfigBean;
        this.pageCount = i5;
    }

    public int getPageCount() {
        return this.pageCount;
    }

    public Bitmap getPrintBitmap() {
        return this.printBitmap;
    }

    public int getTaskType() {
        return this.taskType;
    }

    public TemplateConfigBean getTemplateConfig() {
        return this.templateConfig;
    }

    public TemplatePto getTemplatePto() {
        return this.templatePto;
    }

    public void setPageCount(int i5) {
        this.pageCount = i5;
    }

    public void setTemplateConfig(TemplateConfigBean templateConfigBean) {
        this.templateConfig = templateConfigBean;
    }

    public void setTemplatePto(TemplatePto templatePto) {
        this.templatePto = templatePto;
    }

    public PrintTaskBean(Bitmap bitmap, int i5) {
        this.printBitmap = bitmap;
        this.pageCount = i5;
    }
}
