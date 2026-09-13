package com.appdev.standard.model;

import com.google.gson.GsonBuilder;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ElementAttributeShapeBean extends ElementAttributeBean {
    private int colorType = 0;
    private int itemSubType = 5;
    private boolean isFill = false;
    private int lineStyleIndex = 1;
    private float lineSize = 0.5f;
    private int rectCorner = 0;

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

    public int getItemSubType() {
        return this.itemSubType;
    }

    public float getLineBoldSize() {
        return this.lineSize;
    }

    public int getLineStyleIndex() {
        return this.lineStyleIndex;
    }

    public int getRectCorner() {
        return this.rectCorner;
    }

    public boolean isFill() {
        return this.isFill;
    }

    public void setColorType(int i5) {
        this.colorType = i5;
    }

    public void setFill(boolean z6) {
        this.isFill = z6;
    }

    public void setItemSubType(int i5) {
        this.itemSubType = i5;
    }

    public void setLineBoldSize(float f6) {
        this.lineSize = f6;
    }

    public void setLineStyleIndex(int i5) {
        this.lineStyleIndex = i5;
    }

    public void setRectCorner(int i5) {
        this.rectCorner = i5;
    }

    public String toJson() {
        return new GsonBuilder().disableHtmlEscaping().create().toJson(this);
    }
}
