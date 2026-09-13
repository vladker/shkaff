package org.apache.poi.sl.draw.geom;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class PolarAdjustHandle implements AdjustHandle {
    private String gdRefAng;
    private String gdRefR;
    private String maxAng;
    private String maxR;
    private String minAng;
    private String minR;
    private AdjustPoint pos;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PolarAdjustHandle)) {
            return false;
        }
        PolarAdjustHandle polarAdjustHandle = (PolarAdjustHandle) obj;
        return Objects.equals(this.pos, polarAdjustHandle.pos) && Objects.equals(this.gdRefR, polarAdjustHandle.gdRefR) && Objects.equals(this.minR, polarAdjustHandle.minR) && Objects.equals(this.maxR, polarAdjustHandle.maxR) && Objects.equals(this.gdRefAng, polarAdjustHandle.gdRefAng) && Objects.equals(this.minAng, polarAdjustHandle.minAng) && Objects.equals(this.maxAng, polarAdjustHandle.maxAng);
    }

    public String getGdRefAng() {
        return this.gdRefAng;
    }

    public String getGdRefR() {
        return this.gdRefR;
    }

    public String getMaxAng() {
        return this.maxAng;
    }

    public String getMaxR() {
        return this.maxR;
    }

    public String getMinAng() {
        return this.minAng;
    }

    public String getMinR() {
        return this.minR;
    }

    public AdjustPoint getPos() {
        return this.pos;
    }

    public int hashCode() {
        return Objects.hash(this.pos, this.gdRefR, this.minR, this.maxR, this.gdRefAng, this.minAng, this.maxAng);
    }

    public boolean isSetGdRefAng() {
        return this.gdRefAng != null;
    }

    public boolean isSetGdRefR() {
        return this.gdRefR != null;
    }

    public boolean isSetMaxAng() {
        return this.maxAng != null;
    }

    public boolean isSetMaxR() {
        return this.maxR != null;
    }

    public boolean isSetMinAng() {
        return this.minAng != null;
    }

    public boolean isSetMinR() {
        return this.minR != null;
    }

    public boolean isSetPos() {
        return this.pos != null;
    }

    public void setGdRefAng(String str) {
        this.gdRefAng = str;
    }

    public void setGdRefR(String str) {
        this.gdRefR = str;
    }

    public void setMaxAng(String str) {
        this.maxAng = str;
    }

    public void setMaxR(String str) {
        this.maxR = str;
    }

    public void setMinAng(String str) {
        this.minAng = str;
    }

    public void setMinR(String str) {
        this.minR = str;
    }

    public void setPos(AdjustPoint adjustPoint) {
        this.pos = adjustPoint;
    }
}
