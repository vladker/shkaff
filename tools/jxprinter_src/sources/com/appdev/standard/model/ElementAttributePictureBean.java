package com.appdev.standard.model;

import com.google.gson.GsonBuilder;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ElementAttributePictureBean extends ElementAttributeBean {
    private String content = null;
    private int definition = 128;
    private int brightness = 0;
    private int contrast = 50;
    private int saturation = 50;
    private int imageDisplayMode = 1;
    private boolean isTile = false;
    private int picType = 1;

    public JSONObject ObjectToJson() {
        try {
            return new JSONObject(toJson());
        } catch (JSONException e) {
            e.printStackTrace();
            return new JSONObject();
        }
    }

    public int getBrightness() {
        return this.brightness;
    }

    public String getContent() {
        return this.content;
    }

    public int getContrast() {
        return this.contrast;
    }

    public int getDefinition() {
        return this.definition;
    }

    public int getImageDisplayMode() {
        return this.imageDisplayMode;
    }

    public int getPicType() {
        return this.picType;
    }

    public int getSaturation() {
        return this.saturation;
    }

    public boolean isTile() {
        return this.isTile;
    }

    public void setBrightness(int i5) {
        this.brightness = i5;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setContrast(int i5) {
        this.contrast = i5;
    }

    public void setDefinition(int i5) {
        this.definition = i5;
    }

    public void setImageDisplayMode(int i5) {
        this.imageDisplayMode = i5;
    }

    public void setPicType(int i5) {
        this.picType = i5;
    }

    public void setSaturation(int i5) {
        this.saturation = i5;
    }

    public void setTile(boolean z6) {
        this.isTile = z6;
    }

    public String toJson() {
        return new GsonBuilder().disableHtmlEscaping().create().toJson(this);
    }
}
