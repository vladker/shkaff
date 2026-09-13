package com.appdev.standard.api.pto;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class CollectUpdatePto {
    private String biaoqianTemplateId;
    private String collect;

    public CollectUpdatePto(String str, String str2) {
        this.biaoqianTemplateId = str;
        this.collect = str2;
    }

    public String getBiaoqianTemplateId() {
        return this.biaoqianTemplateId;
    }

    public String getCollect() {
        return this.collect;
    }

    public void setBiaoqianTemplateId(String str) {
        this.biaoqianTemplateId = str;
    }

    public void setCollect(String str) {
        this.collect = str;
    }
}
