package cn.sharesdk.framework.utils;

import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class m {
    public static ShapeDrawable a(float f6, int i5) {
        float[] fArr = new float[8];
        float[] fArr2 = new float[8];
        for (int i6 = 0; i6 < 8; i6++) {
            fArr[i6] = 0.0f + f6;
            fArr2[i6] = f6;
        }
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, new RectF(0.0f, 0.0f, 0.0f, 0.0f), fArr2));
        shapeDrawable.getPaint().setColor(i5);
        return shapeDrawable;
    }
}
