package p076n2;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f6225a = new RectF();
    public final Paint b;
    public final Paint c;
    public final f d;
    public float e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f6226f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f6227g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f6228h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f6229i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f6230j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f6231k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f6232l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f6233m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f6234n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f6235o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Path f6236p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f6237q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public double f6238r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f6239s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f6240t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f6241u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Paint f6242v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f6243w;

    public h(f fVar) {
        Paint paint = new Paint();
        this.b = paint;
        Paint paint2 = new Paint();
        this.c = paint2;
        this.e = 0.0f;
        this.f6226f = 0.0f;
        this.f6227g = 0.0f;
        this.f6228h = 5.0f;
        this.f6229i = 2.5f;
        this.f6242v = new Paint();
        this.d = fVar;
        paint.setStrokeCap(Paint.Cap.SQUARE);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setAntiAlias(true);
    }

    public final void a() {
        this.d.invalidateDrawable(null);
    }

    public void setColors(@NonNull int[] iArr) {
        this.f6230j = iArr;
        this.f6231k = 0;
    }
}
