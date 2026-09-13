package cn.sharesdk.onekeyshare.themes.classic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class XView extends View {
    private float ratio;

    public XView(Context context) {
        super(context);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(-6250336);
        float f6 = width;
        canvas.drawRect(f6, 0.0f, getWidth(), height, paint);
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setStrokeWidth(this.ratio * 3.0f);
        paint2.setColor(-1);
        float f7 = this.ratio * 8.0f;
        float f8 = f6 + f7;
        float f9 = f6 - f7;
        canvas.drawLine(f8, f7, getWidth() - f7, f9, paint2);
        canvas.drawLine(f8, f9, getWidth() - f7, f7, paint2);
    }

    public void setRatio(float f6) {
        this.ratio = f6;
    }
}
