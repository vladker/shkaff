package com.appdev.standard.model;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ElementAttributeType {
    private String content;
    private boolean isSelect;

    public ElementAttributeType(String str, boolean z6) {
        this.content = str;
        this.isSelect = z6;
    }

    public String getContent() {
        return this.content;
    }

    public boolean isSelect() {
        return this.isSelect;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setSelect(boolean z6) {
        this.isSelect = z6;
    }
}
