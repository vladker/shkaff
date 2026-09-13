package com.appdev.standard.model;

import com.google.gson.GsonBuilder;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ReceiptPictureDataModel {
    private String content = "";
    private int displayMode = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f2668h;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f2669w;

    public JSONObject ObjectToJson() {
        try {
            return new JSONObject(toJson());
        } catch (JSONException e) {
            e.printStackTrace();
            return new JSONObject();
        }
    }

    public String getContent() {
        return this.content;
    }

    public int getDisplayMode() {
        return this.displayMode;
    }

    public float getH() {
        return this.f2668h;
    }

    public float getW() {
        return this.f2669w;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setDisplayMode(int i5) {
        this.displayMode = i5;
    }

    public void setH(float f6) {
        this.f2668h = f6;
    }

    public void setW(float f6) {
        this.f2669w = f6;
    }

    public String toJson() {
        return new GsonBuilder().disableHtmlEscaping().create().toJson(this);
    }
}
