package cn.sharesdk.onekeyshare.themes.classic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class IndicatorView extends View {
    private static final int DESIGN_BOTTOM_HEIGHT = 52;
    private static final int DESIGN_INDICATOR_DISTANCE = 14;
    private static final int DESIGN_INDICATOR_RADIUS = 6;
    private int count;
    private int current;

    public IndicatorView(Context context) {
        super(context);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.count <= 1) {
            setVisibility(8);
            return;
        }
        float height = getHeight();
        float f6 = (6.0f * height) / 52.0f;
        float f7 = (14.0f * height) / 52.0f;
        float f8 = f6 * 2.0f;
        int i5 = this.count;
        float width = (getWidth() - (((i5 - 1) * f7) + (i5 * f8))) / 2.0f;
        float f9 = height / 2.0f;
        canvas.drawColor(-1);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        for (int i6 = 0; i6 < this.count; i6++) {
            if (i6 == this.current) {
                paint.setColor(-10653280);
            } else {
                paint.setColor(-5262921);
            }
            canvas.drawCircle(((f8 + f7) * i6) + width, f9, f6, paint);
        }
    }

    public void onScreenChange(int i5, int i6) {
        if (i5 != this.current) {
            this.current = i5;
            postInvalidate();
        }
    }

    public void setScreenCount(int i5) {
        this.count = i5;
    }
}
