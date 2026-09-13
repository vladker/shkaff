package com.appdev.standard.model;

import com.google.gson.JsonObject;
import p052j2.c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ReceiptElementModel {
    private JsonObject data;
    private int itemType;
    private boolean selectState = false;

    public ReceiptElementModel(int i5, String str) {
        this.itemType = i5;
        this.data = (JsonObject) c.c(JsonObject.class, str);
    }

    public JsonObject getData() {
        return this.data;
    }

    public int getItemType() {
        return this.itemType;
    }

    public boolean isSelectState() {
        return this.selectState;
    }

    public void setData(String str) {
        this.data = (JsonObject) c.c(JsonObject.class, str);
    }

    public void setItemType(int i5) {
        this.itemType = i5;
    }

    public void setSelectState(boolean z6) {
        this.selectState = z6;
    }
}
