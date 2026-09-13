package cn.bertsir.zbar.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import cn.bertsir.zbar.R;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class LineView extends View {
    private Canvas canvas;
    private int line_color;
    private Shader mShader;
    private Paint paint;

    public LineView(Context context) {
        super(context);
        this.line_color = getResources().getColor(R.color.common_color);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        String strValueOf = String.valueOf(Integer.toHexString(this.line_color));
        String strSubstring = strValueOf.substring(strValueOf.length() - 6, strValueOf.length());
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{Color.parseColor("#00" + strSubstring), this.line_color, Color.parseColor("#00" + strSubstring)}, (float[]) null, Shader.TileMode.CLAMP);
        this.mShader = linearGradient;
        this.paint.setShader(linearGradient);
        canvas.drawLine(0.0f, 0.0f, 1.6843096E7f, 0.0f, this.paint);
    }

    public void setLinecolor(int i5) {
        this.line_color = i5;
        invalidate();
    }

    public LineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.line_color = getResources().getColor(R.color.common_color);
        this.paint = new Paint();
        this.canvas = new Canvas();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setStrokeWidth(10.0f);
        this.paint.setAntiAlias(true);
    }
}
