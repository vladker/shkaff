package com.appdev.standard.model;

import androidx.exifinterface.media.a;
import com.google.gson.GsonBuilder;
import kotlin.jvm.internal.Y;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ReceiptQrCodeDataModel {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f2670h;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f2671w;
    private int inputDataType = 0;
    private String content = "";
    private String encodeRef = "QR_CODE";
    private String prefix = "";
    private String suffix = "";
    private int interval = 1;
    private int size = 1;

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

    public String getEncodeRef() {
        return this.encodeRef;
    }

    public float getH() {
        return this.f2670h;
    }

    public int getInputDataType() {
        return this.inputDataType;
    }

    public int getInterval() {
        return this.interval;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public String getShowContent(int i5) {
        int i6;
        String strJ;
        long jI;
        if (Y.f(this.content)) {
            return "12345678";
        }
        if (this.inputDataType != 1) {
            return this.content;
        }
        int length = this.content.length() - 1;
        int i7 = -1;
        while (true) {
            if (length < 0) {
                i6 = -1;
                break;
            }
            if (Character.isDigit(this.content.charAt(length))) {
                if (i7 == -1) {
                    i7 = length + 1;
                }
            } else if (i7 != -1) {
                i6 = length + 1;
                break;
            }
            length--;
        }
        if (i7 != -1 && i6 == -1) {
            i6 = 0;
        }
        int i8 = i7 - i6;
        if (i7 == -1 && i6 == -1) {
            jI = -1;
            strJ = "";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(this.content.substring(0, i6));
            sb.append("%0");
            sb.append(i8);
            sb.append("d");
            strJ = a.j(this.content, i7, sb);
            jI = Y.i(this.content.substring(i6, i7));
        }
        if (Y.f(strJ)) {
            return this.prefix + this.content + this.suffix;
        }
        return this.prefix + String.format(strJ, Long.valueOf(jI + ((long) (i5 * this.interval)))) + this.suffix;
    }

    public int getSize() {
        return this.size;
    }

    public String getSuffix() {
        return this.suffix;
    }

    public float getW() {
        return this.f2671w;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setEncodeRef(String str) {
        this.encodeRef = str;
    }

    public void setH(float f6) {
        this.f2670h = f6;
    }

    public void setInputDataType(int i5) {
        this.inputDataType = i5;
    }

    public void setInterval(int i5) {
        this.interval = i5;
    }

    public void setPrefix(String str) {
        this.prefix = str;
    }

    public void setSize(int i5) {
        this.size = i5;
    }

    public void setSuffix(String str) {
        this.suffix = str;
    }

    public void setW(float f6) {
        this.f2671w = f6;
    }

    public String toJson() {
        return new GsonBuilder().disableHtmlEscaping().create().toJson(this);
    }
}
