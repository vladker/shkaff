package com.appdev.standard.model;

import com.google.gson.GsonBuilder;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ElementAttributeLineBean extends ElementAttributeBean {
    private int colorType = 0;
    private int lineStyleIndex = 1;
    private float lineSize = 0.5f;

    public JSONObject ObjectToJson() {
        try {
            return new JSONObject(toJson());
        } catch (JSONException e) {
            e.printStackTrace();
            return new JSONObject();
        }
    }

    public int getColorType() {
        return this.colorType;
    }

    public float getLineSize() {
        return this.lineSize;
    }

    public int getLineStyleIndex() {
        return this.lineStyleIndex;
    }

    public void setColorType(int i5) {
        this.colorType = i5;
    }

    public void setLineSize(float f6) {
        this.lineSize = f6;
    }

    public void setLineStyleIndex(int i5) {
        this.lineStyleIndex = i5;
    }

    public String toJson() {
        return new GsonBuilder().disableHtmlEscaping().create().toJson(this);
    }
}
