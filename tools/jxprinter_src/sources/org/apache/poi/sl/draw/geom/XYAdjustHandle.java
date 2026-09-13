package org.apache.poi.sl.draw.geom;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class XYAdjustHandle implements AdjustHandle {
    private String gdRefX;
    private String gdRefY;
    private String maxX;
    private String maxY;
    private String minX;
    private String minY;
    private AdjustPoint pos;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof XYAdjustHandle)) {
            return false;
        }
        XYAdjustHandle xYAdjustHandle = (XYAdjustHandle) obj;
        return Objects.equals(this.pos, xYAdjustHandle.pos) && Objects.equals(this.gdRefX, xYAdjustHandle.gdRefX) && Objects.equals(this.minX, xYAdjustHandle.minX) && Objects.equals(this.maxX, xYAdjustHandle.maxX) && Objects.equals(this.gdRefY, xYAdjustHandle.gdRefY) && Objects.equals(this.minY, xYAdjustHandle.minY) && Objects.equals(this.maxY, xYAdjustHandle.maxY);
    }

    public String getGdRefX() {
        return this.gdRefX;
    }

    public String getGdRefY() {
        return this.gdRefY;
    }

    public String getMaxX() {
        return this.maxX;
    }

    public String getMaxY() {
        return this.maxY;
    }

    public String getMinX() {
        return this.minX;
    }

    public String getMinY() {
        return this.minY;
    }

    public AdjustPoint getPos() {
        return this.pos;
    }

    public int hashCode() {
        return Objects.hash(this.pos, this.gdRefX, this.minX, this.maxX, this.gdRefY, this.minY, this.maxY);
    }

    public boolean isSetGdRefX() {
        return this.gdRefX != null;
    }

    public boolean isSetGdRefY() {
        return this.gdRefY != null;
    }

    public boolean isSetMaxX() {
        return this.maxX != null;
    }

    public boolean isSetMaxY() {
        return this.maxY != null;
    }

    public boolean isSetMinX() {
        return this.minX != null;
    }

    public boolean isSetMinY() {
        return this.minY != null;
    }

    public boolean isSetPos() {
        return this.pos != null;
    }

    public void setGdRefX(String str) {
        this.gdRefX = str;
    }

    public void setGdRefY(String str) {
        this.gdRefY = str;
    }

    public void setMaxX(String str) {
        this.maxX = str;
    }

    public void setMaxY(String str) {
        this.maxY = str;
    }

    public void setMinX(String str) {
        this.minX = str;
    }

    public void setMinY(String str) {
        this.minY = str;
    }

    public void setPos(AdjustPoint adjustPoint) {
        this.pos = adjustPoint;
    }
}
