package com.appdev.standard.api.pto;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class EditRecordNamePto {
    private String title;
    private String usageRecordId;

    public EditRecordNamePto(String str, String str2) {
        this.usageRecordId = str;
        this.title = str2;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUsageRecordId() {
        return this.usageRecordId;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUsageRecordId(String str) {
        this.usageRecordId = str;
    }
}
