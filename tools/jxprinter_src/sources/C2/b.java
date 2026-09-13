package C2;

import H2.k;
import I2.e;
import I2.f;
import J2.c;
import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b extends M2.b {
    public TextView d;
    public ImageView e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f127f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public e f128g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f129h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public B2.b f130i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f131j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f132k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f133l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f134m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f135n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f136o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f137p;

    public b(Context context) {
        super(context, null, 0);
        this.f134m = Videoio.CAP_QT;
        this.f135n = 20;
        this.f136o = 20;
        this.f137p = 0;
        this.b = c.d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ImageView imageView = this.e;
        ImageView imageView2 = this.f127f;
        imageView.animate().cancel();
        imageView2.animate().cancel();
        Object drawable = this.f127f.getDrawable();
        if (drawable instanceof Animatable) {
            Animatable animatable = (Animatable) drawable;
            if (animatable.isRunning()) {
                animatable.stop();
            }
        }
    }

    @Override // M2.b, I2.a
    public int onFinish(@NonNull f fVar, boolean z6) {
        ImageView imageView = this.f127f;
        Object drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            Animatable animatable = (Animatable) drawable;
            if (animatable.isRunning()) {
                animatable.stop();
            }
        } else {
            imageView.animate().rotation(0.0f).setDuration(0L);
        }
        imageView.setVisibility(8);
        return this.f134m;
    }

    @Override // M2.b, I2.a
    public void onInitialized(@NonNull e eVar, int i5, int i6) {
        this.f128g = eVar;
        ((k) eVar).requestDrawBackgroundFor(this, this.f133l);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int i5, int i6) {
        if (this.f137p == 0) {
            this.f135n = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            this.f136o = paddingBottom;
            if (this.f135n == 0 || paddingBottom == 0) {
                int paddingLeft = getPaddingLeft();
                int paddingRight = getPaddingRight();
                int iA = this.f135n;
                if (iA == 0) {
                    iA = N2.b.a(20.0f);
                }
                this.f135n = iA;
                int iA2 = this.f136o;
                if (iA2 == 0) {
                    iA2 = N2.b.a(20.0f);
                }
                this.f136o = iA2;
                setPadding(paddingLeft, this.f135n, paddingRight, iA2);
            }
            setClipToPadding(false);
        }
        if (View.MeasureSpec.getMode(i6) == 1073741824) {
            int size = View.MeasureSpec.getSize(i6);
            int i7 = this.f137p;
            if (size < i7) {
                int i8 = (size - i7) / 2;
                setPadding(getPaddingLeft(), i8, getPaddingRight(), i8);
            } else {
                setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
            }
        } else {
            setPadding(getPaddingLeft(), this.f135n, getPaddingRight(), this.f136o);
        }
        super.onMeasure(i5, i6);
        if (this.f137p == 0) {
            for (int i9 = 0; i9 < getChildCount(); i9++) {
                int measuredHeight = getChildAt(i9).getMeasuredHeight();
                if (this.f137p < measuredHeight) {
                    this.f137p = measuredHeight;
                }
            }
        }
    }

    @Override // M2.b, I2.a
    public void onReleased(@NonNull f fVar, int i5, int i6) {
        onStartAnimator(fVar, i5, i6);
    }

    @Override // M2.b, I2.a
    public void onStartAnimator(@NonNull f fVar, int i5, int i6) {
        ImageView imageView = this.f127f;
        if (imageView.getVisibility() != 0) {
            imageView.setVisibility(0);
            Object drawable = this.f127f.getDrawable();
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).start();
            } else {
                imageView.animate().rotation(36000.0f).setDuration(100000L);
            }
        }
    }

    public b setAccentColor(@ColorInt int i5) {
        this.f131j = true;
        this.d.setTextColor(i5);
        a aVar = this.f129h;
        if (aVar != null) {
            aVar.a(i5);
            this.e.invalidateDrawable(this.f129h);
        }
        B2.b bVar = this.f130i;
        if (bVar != null) {
            bVar.a(i5);
            this.f127f.invalidateDrawable(this.f130i);
        }
        return this;
    }

    public b setAccentColorId(@ColorRes int i5) {
        setAccentColor(ContextCompat.getColor(getContext(), i5));
        return this;
    }

    public b setArrowResource(@DrawableRes int i5) {
        this.f129h = null;
        this.e.setImageResource(i5);
        return this;
    }

    public b setPrimaryColor(@ColorInt int i5) {
        this.f132k = true;
        this.f133l = i5;
        e eVar = this.f128g;
        if (eVar != null) {
            ((k) eVar).requestDrawBackgroundFor(this, i5);
        }
        return this;
    }

    public b setPrimaryColorId(@ColorRes int i5) {
        setPrimaryColor(ContextCompat.getColor(getContext(), i5));
        return this;
    }

    @Override // M2.b, I2.a
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 0) {
            if (!(getBackground() instanceof BitmapDrawable) && !this.f132k) {
                setPrimaryColor(iArr[0]);
                this.f132k = false;
            }
            if (this.f131j) {
                return;
            }
            if (iArr.length > 1) {
                setAccentColor(iArr[1]);
            }
            this.f131j = false;
        }
    }

    public b setProgressResource(@DrawableRes int i5) {
        this.f130i = null;
        this.f127f.setImageResource(i5);
        return this;
    }
}
