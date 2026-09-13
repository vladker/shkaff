package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class P implements Q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f3096a;
    public final /* synthetic */ float b;
    public final /* synthetic */ float c;
    public final /* synthetic */ float d;

    public P(float f6, float f7, float f8, float f9) {
        this.f3096a = f6;
        this.b = f7;
        this.c = f8;
        this.d = f9;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.Q
    public final void a(Canvas canvas, Paint paint, RectF rectF) {
        Path path = new Path();
        float f6 = this.f3096a;
        float f7 = this.b;
        float f8 = this.c;
        float f9 = this.d;
        path.addRoundRect(rectF, new float[]{f6, f6, f7, f7, f8, f8, f9, f9}, Path.Direction.CW);
        canvas.drawPath(path, paint);
    }
}
