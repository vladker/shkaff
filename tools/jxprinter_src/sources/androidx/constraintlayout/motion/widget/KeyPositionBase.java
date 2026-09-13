package androidx.constraintlayout.motion.widget;

import android.graphics.RectF;
import android.view.View;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
abstract class KeyPositionBase extends Key {
    protected static final float SELECTION_SLOPE = 20.0f;
    int mCurveFit = Key.UNSET;

    public abstract void calcPosition(int i5, int i6, float f6, float f7, float f8, float f9);

    public abstract float getPositionX();

    public abstract float getPositionY();

    public abstract boolean intersects(int i5, int i6, RectF rectF, RectF rectF2, float f6, float f7);

    public abstract void positionAttributes(View view, RectF rectF, RectF rectF2, float f6, float f7, String[] strArr, float[] fArr);

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> hashSet) {
    }
}
