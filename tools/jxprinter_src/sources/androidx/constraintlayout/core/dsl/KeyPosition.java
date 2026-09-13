package androidx.constraintlayout.core.dsl;

import androidx.collection.a;
import androidx.constraintlayout.core.motion.utils.TypedValues;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class KeyPosition extends Keys {
    private int mFrame;
    private String mTarget;
    private String mTransitionEasing = null;
    private float mPercentWidth = Float.NaN;
    private float mPercentHeight = Float.NaN;
    private float mPercentX = Float.NaN;
    private float mPercentY = Float.NaN;
    private Type mPositionType = Type.CARTESIAN;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum Type {
        CARTESIAN,
        SCREEN,
        PATH
    }

    public KeyPosition(String str, int i5) {
        this.mTarget = null;
        this.mFrame = 0;
        this.mTarget = str;
        this.mFrame = i5;
    }

    public int getFrames() {
        return this.mFrame;
    }

    public float getPercentHeight() {
        return this.mPercentHeight;
    }

    public float getPercentWidth() {
        return this.mPercentWidth;
    }

    public float getPercentX() {
        return this.mPercentX;
    }

    public float getPercentY() {
        return this.mPercentY;
    }

    public Type getPositionType() {
        return this.mPositionType;
    }

    public String getTarget() {
        return this.mTarget;
    }

    public String getTransitionEasing() {
        return this.mTransitionEasing;
    }

    public void setFrames(int i5) {
        this.mFrame = i5;
    }

    public void setPercentHeight(float f6) {
        this.mPercentHeight = f6;
    }

    public void setPercentWidth(float f6) {
        this.mPercentWidth = f6;
    }

    public void setPercentX(float f6) {
        this.mPercentX = f6;
    }

    public void setPercentY(float f6) {
        this.mPercentY = f6;
    }

    public void setPositionType(Type type) {
        this.mPositionType = type;
    }

    public void setTarget(String str) {
        this.mTarget = str;
    }

    public void setTransitionEasing(String str) {
        this.mTransitionEasing = str;
    }

    public String toString() {
        StringBuilder sbR = a.r("KeyPositions:{\n");
        append(sbR, TypedValues.AttributesType.S_TARGET, this.mTarget);
        sbR.append("frame:");
        sbR.append(this.mFrame);
        sbR.append(",\n");
        if (this.mPositionType != null) {
            sbR.append("type:'");
            sbR.append(this.mPositionType);
            sbR.append("',\n");
        }
        append(sbR, "easing", this.mTransitionEasing);
        append(sbR, "percentX", this.mPercentX);
        append(sbR, "percentY", this.mPercentY);
        append(sbR, "percentWidth", this.mPercentWidth);
        append(sbR, "percentHeight", this.mPercentHeight);
        sbR.append("},\n");
        return sbR.toString();
    }
}
