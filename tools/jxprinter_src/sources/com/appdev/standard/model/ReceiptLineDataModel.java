package com.appdev.standard.model;

import com.google.gson.GsonBuilder;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ReceiptLineDataModel {
    private float lineSize = 0.5f;
    private int lineStyleIndex = 1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f2667w;

    public JSONObject ObjectToJson() {
        try {
            return new JSONObject(toJson());
        } catch (JSONException e) {
            e.printStackTrace();
            return new JSONObject();
        }
    }

    public float getLineSize() {
        return this.lineSize;
    }

    public int getLineStyleIndex() {
        return this.lineStyleIndex;
    }

    public float getW() {
        return this.f2667w;
    }

    public void setLineSize(float f6) {
        this.lineSize = f6;
    }

    public void setLineStyleIndex(int i5) {
        this.lineStyleIndex = i5;
    }

    public void setW(float f6) {
        this.f2667w = f6;
    }

    public String toJson() {
        return new GsonBuilder().disableHtmlEscaping().create().toJson(this);
    }
}
