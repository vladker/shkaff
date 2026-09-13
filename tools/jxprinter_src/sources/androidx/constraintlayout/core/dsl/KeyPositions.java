package androidx.constraintlayout.core.dsl;

import androidx.collection.a;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class KeyPositions extends Keys {
    private int[] mFrames;
    private String[] mTarget;
    private String mTransitionEasing = null;
    private Type mPositionType = null;
    private float[] mPercentWidth = null;
    private float[] mPercentHeight = null;
    private float[] mPercentX = null;
    private float[] mPercentY = null;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum Type {
        CARTESIAN,
        SCREEN,
        PATH
    }

    public KeyPositions(int i5, String... strArr) {
        this.mFrames = null;
        this.mTarget = strArr;
        int[] iArr = new int[i5];
        this.mFrames = iArr;
        float length = 100.0f / (iArr.length + 1);
        int i6 = 0;
        while (true) {
            int[] iArr2 = this.mFrames;
            if (i6 >= iArr2.length) {
                return;
            }
            iArr2[i6] = (int) ((i6 * length) + length);
            i6++;
        }
    }

    public int[] getFrames() {
        return this.mFrames;
    }

    public float[] getPercentHeight() {
        return this.mPercentHeight;
    }

    public float[] getPercentWidth() {
        return this.mPercentWidth;
    }

    public float[] getPercentX() {
        return this.mPercentX;
    }

    public float[] getPercentY() {
        return this.mPercentY;
    }

    public Type getPositionType() {
        return this.mPositionType;
    }

    public String[] getTarget() {
        return this.mTarget;
    }

    public String getTransitionEasing() {
        return this.mTransitionEasing;
    }

    public void setFrames(int... iArr) {
        this.mFrames = iArr;
    }

    public void setPercentHeight(float... fArr) {
        this.mPercentHeight = fArr;
    }

    public void setPercentWidth(float... fArr) {
        this.mPercentWidth = fArr;
    }

    public void setPercentX(float... fArr) {
        this.mPercentX = fArr;
    }

    public void setPercentY(float... fArr) {
        this.mPercentY = fArr;
    }

    public void setPositionType(Type type) {
        this.mPositionType = type;
    }

    public void setTransitionEasing(String str) {
        this.mTransitionEasing = str;
    }

    public String toString() {
        StringBuilder sbR = a.r("KeyPositions:{\n");
        append(sbR, TypedValues.AttributesType.S_TARGET, this.mTarget);
        sbR.append("frame:");
        sbR.append(Arrays.toString(this.mFrames));
        sbR.append(",\n");
        if (this.mPositionType != null) {
            sbR.append("type:'");
            sbR.append(this.mPositionType);
            sbR.append("',\n");
        }
        append(sbR, "easing", this.mTransitionEasing);
        append(sbR, "percentX", this.mPercentX);
        append(sbR, "percentX", this.mPercentY);
        append(sbR, "percentWidth", this.mPercentWidth);
        append(sbR, "percentHeight", this.mPercentHeight);
        sbR.append("},\n");
        return sbR.toString();
    }
}
