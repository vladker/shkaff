package C2;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends B2.a {
    public int b = 0;
    public int c = 0;
    public final Path d = new Path();

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        int iWidth = bounds.width();
        int iHeight = bounds.height();
        int i5 = this.b;
        Path path = this.d;
        if (i5 != iWidth || this.c != iHeight) {
            path.reset();
            float f6 = (iWidth * 30) / 225;
            float f7 = f6 * 0.70710677f;
            float f8 = f6 / 0.70710677f;
            float f9 = iWidth;
            float f10 = f9 / 2.0f;
            float f11 = iHeight;
            path.moveTo(f10, f11);
            float f12 = f11 / 2.0f;
            path.lineTo(0.0f, f12);
            float f13 = f12 - f7;
            path.lineTo(f7, f13);
            float f14 = f6 / 2.0f;
            float f15 = f10 - f14;
            float f16 = (f11 - f8) - f14;
            path.lineTo(f15, f16);
            path.lineTo(f15, 0.0f);
            float f17 = f10 + f14;
            path.lineTo(f17, 0.0f);
            path.lineTo(f17, f16);
            path.lineTo(f9 - f7, f13);
            path.lineTo(f9, f12);
            path.close();
            this.b = iWidth;
            this.c = iHeight;
        }
        canvas.drawPath(path, this.f88a);
    }
}
