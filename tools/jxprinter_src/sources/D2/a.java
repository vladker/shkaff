package D2;

import C2.b;
import E2.d;
import I2.c;
import I2.f;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends b implements c {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static String f203A;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public static String f204C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public static String f205D;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public static String f206G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public static String f207H;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static String f208y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static String f209z;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f210q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f211r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f212s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f213t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f214u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f215v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f216w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f217x;

    public a(Context context) {
        super(context);
        this.f217x = false;
        View.inflate(context, E2.b.srl_classics_footer, this);
        ImageView imageView = (ImageView) findViewById(E2.a.srl_classics_arrow);
        this.e = imageView;
        ImageView imageView2 = (ImageView) findViewById(E2.a.srl_classics_progress);
        this.f127f = imageView2;
        this.d = (TextView) findViewById(E2.a.srl_classics_title);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, d.ClassicsFooter);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(d.ClassicsFooter_srlDrawableMarginRight, N2.b.a(20.0f));
        layoutParams2.rightMargin = dimensionPixelSize;
        layoutParams.rightMargin = dimensionPixelSize;
        int i5 = d.ClassicsFooter_srlDrawableArrowSize;
        layoutParams.width = typedArrayObtainStyledAttributes.getLayoutDimension(i5, layoutParams.width);
        layoutParams.height = typedArrayObtainStyledAttributes.getLayoutDimension(i5, layoutParams.height);
        int i6 = d.ClassicsFooter_srlDrawableProgressSize;
        layoutParams2.width = typedArrayObtainStyledAttributes.getLayoutDimension(i6, layoutParams2.width);
        layoutParams2.height = typedArrayObtainStyledAttributes.getLayoutDimension(i6, layoutParams2.height);
        int i7 = d.ClassicsFooter_srlDrawableSize;
        layoutParams.width = typedArrayObtainStyledAttributes.getLayoutDimension(i7, layoutParams.width);
        layoutParams.height = typedArrayObtainStyledAttributes.getLayoutDimension(i7, layoutParams.height);
        layoutParams2.width = typedArrayObtainStyledAttributes.getLayoutDimension(i7, layoutParams2.width);
        layoutParams2.height = typedArrayObtainStyledAttributes.getLayoutDimension(i7, layoutParams2.height);
        this.f134m = typedArrayObtainStyledAttributes.getInt(d.ClassicsFooter_srlFinishDuration, this.f134m);
        this.b = J2.c.f379h[typedArrayObtainStyledAttributes.getInt(d.ClassicsFooter_srlClassicsSpinnerStyle, this.b.f380a)];
        int i8 = d.ClassicsFooter_srlDrawableArrow;
        if (typedArrayObtainStyledAttributes.hasValue(i8)) {
            this.e.setImageDrawable(typedArrayObtainStyledAttributes.getDrawable(i8));
        } else if (this.e.getDrawable() == null) {
            C2.a aVar = new C2.a();
            this.f129h = aVar;
            aVar.a(-10066330);
            this.e.setImageDrawable(this.f129h);
        }
        int i9 = d.ClassicsFooter_srlDrawableProgress;
        if (typedArrayObtainStyledAttributes.hasValue(i9)) {
            this.f127f.setImageDrawable(typedArrayObtainStyledAttributes.getDrawable(i9));
        } else if (this.f127f.getDrawable() == null) {
            B2.b bVar = new B2.b();
            this.f130i = bVar;
            bVar.a(-10066330);
            this.f127f.setImageDrawable(this.f130i);
        }
        int i10 = d.ClassicsFooter_srlTextSizeTitle;
        if (typedArrayObtainStyledAttributes.hasValue(i10)) {
            this.d.setTextSize(0, typedArrayObtainStyledAttributes.getDimensionPixelSize(i10, N2.b.a(16.0f)));
        }
        int i11 = d.ClassicsFooter_srlPrimaryColor;
        if (typedArrayObtainStyledAttributes.hasValue(i11)) {
            super.setPrimaryColor(typedArrayObtainStyledAttributes.getColor(i11, 0));
        }
        int i12 = d.ClassicsFooter_srlAccentColor;
        if (typedArrayObtainStyledAttributes.hasValue(i12)) {
            super.setAccentColor(typedArrayObtainStyledAttributes.getColor(i12, 0));
        }
        int i13 = d.ClassicsFooter_srlTextPulling;
        if (typedArrayObtainStyledAttributes.hasValue(i13)) {
            this.f210q = typedArrayObtainStyledAttributes.getString(i13);
        } else {
            String str = f208y;
            if (str != null) {
                this.f210q = str;
            } else {
                this.f210q = context.getString(E2.c.srl_footer_pulling);
            }
        }
        int i14 = d.ClassicsFooter_srlTextRelease;
        if (typedArrayObtainStyledAttributes.hasValue(i14)) {
            this.f211r = typedArrayObtainStyledAttributes.getString(i14);
        } else {
            String str2 = f209z;
            if (str2 != null) {
                this.f211r = str2;
            } else {
                this.f211r = context.getString(E2.c.srl_footer_release);
            }
        }
        int i15 = d.ClassicsFooter_srlTextLoading;
        if (typedArrayObtainStyledAttributes.hasValue(i15)) {
            this.f212s = typedArrayObtainStyledAttributes.getString(i15);
        } else {
            String str3 = f203A;
            if (str3 != null) {
                this.f212s = str3;
            } else {
                this.f212s = context.getString(E2.c.srl_footer_loading);
            }
        }
        int i16 = d.ClassicsFooter_srlTextRefreshing;
        if (typedArrayObtainStyledAttributes.hasValue(i16)) {
            this.f213t = typedArrayObtainStyledAttributes.getString(i16);
        } else {
            String str4 = f204C;
            if (str4 != null) {
                this.f213t = str4;
            } else {
                this.f213t = context.getString(E2.c.srl_footer_refreshing);
            }
        }
        int i17 = d.ClassicsFooter_srlTextFinish;
        if (typedArrayObtainStyledAttributes.hasValue(i17)) {
            this.f214u = typedArrayObtainStyledAttributes.getString(i17);
        } else {
            String str5 = f205D;
            if (str5 != null) {
                this.f214u = str5;
            } else {
                this.f214u = context.getString(E2.c.srl_footer_finish);
            }
        }
        int i18 = d.ClassicsFooter_srlTextFailed;
        if (typedArrayObtainStyledAttributes.hasValue(i18)) {
            this.f215v = typedArrayObtainStyledAttributes.getString(i18);
        } else {
            String str6 = f206G;
            if (str6 != null) {
                this.f215v = str6;
            } else {
                this.f215v = context.getString(E2.c.srl_footer_failed);
            }
        }
        int i19 = d.ClassicsFooter_srlTextNothing;
        if (typedArrayObtainStyledAttributes.hasValue(i19)) {
            this.f216w = typedArrayObtainStyledAttributes.getString(i19);
        } else {
            String str7 = f207H;
            if (str7 != null) {
                this.f216w = str7;
            } else {
                this.f216w = context.getString(E2.c.srl_footer_nothing);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        imageView2.animate().setInterpolator(null);
        this.d.setText(isInEditMode() ? this.f212s : this.f210q);
        if (isInEditMode()) {
            imageView.setVisibility(8);
        } else {
            imageView2.setVisibility(8);
        }
    }

    @Override // C2.b, M2.b, I2.a
    public int onFinish(@NonNull f fVar, boolean z6) {
        super.onFinish(fVar, z6);
        if (this.f217x) {
            return 0;
        }
        this.d.setText(z6 ? this.f214u : this.f215v);
        return this.f134m;
    }

    @Override // M2.b, I2.a, L2.g, I2.c
    public void onStateChanged(@NonNull f fVar, @NonNull J2.b bVar, @NonNull J2.b bVar2) {
        ImageView imageView = this.e;
        if (this.f217x) {
            return;
        }
        int iOrdinal = bVar2.ordinal();
        if (iOrdinal == 0) {
            imageView.setVisibility(0);
        } else if (iOrdinal != 2) {
            if (iOrdinal == 6) {
                this.d.setText(this.f211r);
                imageView.animate().rotation(0.0f);
                return;
            }
            switch (iOrdinal) {
                case 10:
                case 12:
                    imageView.setVisibility(8);
                    this.d.setText(this.f212s);
                    break;
                case 11:
                    this.d.setText(this.f213t);
                    imageView.setVisibility(8);
                    break;
            }
            return;
        }
        this.d.setText(this.f210q);
        imageView.animate().rotation(180.0f);
    }

    @Override // M2.b, I2.c
    public final boolean setNoMoreData(boolean z6) {
        if (this.f217x == z6) {
            return true;
        }
        this.f217x = z6;
        ImageView imageView = this.e;
        if (z6) {
            this.d.setText(this.f216w);
            imageView.setVisibility(8);
            return true;
        }
        this.d.setText(this.f210q);
        imageView.setVisibility(0);
        return true;
    }

    @Override // C2.b, M2.b, I2.a
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (this.b == J2.c.e) {
            super.setPrimaryColors(iArr);
        }
    }
}
