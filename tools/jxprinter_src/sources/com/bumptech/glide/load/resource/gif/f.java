package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import p126w0.z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class f extends Drawable implements k, Animatable, Animatable2Compat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f3137a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3138f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f3139g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f3140h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Paint f3141i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Rect f3142j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList f3143k;

    @Deprecated
    public f(Context context, com.bumptech.glide.gifdecoder.b bVar, com.bumptech.glide.load.engine.bitmap_recycle.c cVar, z zVar, int i5, int i6, Bitmap bitmap) {
        this(context, bVar, zVar, i5, i6, bitmap);
    }

    public final ByteBuffer a() {
        return this.f3137a.frameLoader.f3146a.getData().asReadOnlyBuffer();
    }

    public final Bitmap b() {
        return this.f3137a.frameLoader.f3153l;
    }

    public final void c() {
        L0.q.checkArgument(!this.d, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        n nVar = this.f3137a.frameLoader;
        if (((com.bumptech.glide.gifdecoder.f) nVar.f3146a).f2890j.b == 1) {
            invalidateSelf();
            return;
        }
        if (this.b) {
            return;
        }
        this.b = true;
        ArrayList arrayList = nVar.c;
        if (nVar.f3151j) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        if (arrayList.contains(this)) {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        boolean zIsEmpty = arrayList.isEmpty();
        arrayList.add(this);
        if (zIsEmpty && !nVar.f3147f) {
            nVar.f3147f = true;
            nVar.f3151j = false;
            nVar.a();
        }
        invalidateSelf();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public final void clearAnimationCallbacks() {
        ArrayList arrayList = this.f3143k;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.d) {
            return;
        }
        if (this.f3140h) {
            int intrinsicWidth = getIntrinsicWidth();
            int intrinsicHeight = getIntrinsicHeight();
            Rect bounds = getBounds();
            if (this.f3142j == null) {
                this.f3142j = new Rect();
            }
            Gravity.apply(119, intrinsicWidth, intrinsicHeight, bounds, this.f3142j);
            this.f3140h = false;
        }
        n nVar = this.f3137a.frameLoader;
        j jVar = nVar.f3150i;
        Bitmap bitmap = jVar != null ? jVar.d : nVar.f3153l;
        if (this.f3142j == null) {
            this.f3142j = new Rect();
        }
        Rect rect = this.f3142j;
        if (this.f3141i == null) {
            this.f3141i = new Paint(2);
        }
        canvas.drawBitmap(bitmap, (Rect) null, rect, this.f3141i);
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f3137a;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f3137a.frameLoader.f3157p;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f3137a.frameLoader.f3156o;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.b;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f3140h = true;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        if (animationCallback == null) {
            return;
        }
        if (this.f3143k == null) {
            this.f3143k = new ArrayList();
        }
        this.f3143k.add(animationCallback);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i5) {
        if (this.f3141i == null) {
            this.f3141i = new Paint(2);
        }
        this.f3141i.setAlpha(i5);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.f3141i == null) {
            this.f3141i = new Paint(2);
        }
        this.f3141i.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z6, boolean z7) {
        L0.q.checkArgument(!this.d, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.e = z6;
        if (!z6) {
            this.b = false;
            n nVar = this.f3137a.frameLoader;
            ArrayList arrayList = nVar.c;
            arrayList.remove(this);
            if (arrayList.isEmpty()) {
                nVar.f3147f = false;
            }
        } else if (this.c) {
            c();
        }
        return super.setVisible(z6, z7);
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        this.c = true;
        this.f3138f = 0;
        if (this.e) {
            c();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.c = false;
        this.b = false;
        n nVar = this.f3137a.frameLoader;
        ArrayList arrayList = nVar.c;
        arrayList.remove(this);
        if (arrayList.isEmpty()) {
            nVar.f3147f = false;
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        ArrayList arrayList = this.f3143k;
        if (arrayList == null || animationCallback == null) {
            return false;
        }
        return arrayList.remove(animationCallback);
    }

    public f(Context context, com.bumptech.glide.gifdecoder.b bVar, z zVar, int i5, int i6, Bitmap bitmap) {
        this(new e(new n(com.bumptech.glide.c.get(context), bVar, i5, i6, zVar, bitmap)));
    }

    public f(e eVar) {
        this.e = true;
        this.f3139g = -1;
        this.f3137a = (e) L0.q.checkNotNull(eVar);
    }

    @VisibleForTesting
    public f(n nVar, Paint paint) {
        this(new e(nVar));
        this.f3141i = paint;
    }
}
