package F2;

import C2.b;
import I2.d;
import I2.f;
import J2.c;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends b implements d {

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public static String f243H = null;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public static String f244I = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static String f245J = null;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public static String f246K = null;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public static String f247M = null;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public static String f248Q = null;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static String f249k0 = null;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static String f250n0 = null;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public final String f251A;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public final String f252C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public final String f253D;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public final String f254G;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f255q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Date f256r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final TextView f257s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final SharedPreferences f258t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final SimpleDateFormat f259u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f260v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f261w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f262x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f263y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f264z;

    public a(Context context) {
        FragmentManager supportFragmentManager;
        super(context);
        this.f255q = "LAST_UPDATE_TIME";
        this.f260v = true;
        View.inflate(context, G2.b.srl_classics_header, this);
        ImageView imageView = (ImageView) findViewById(G2.a.srl_classics_arrow);
        this.e = imageView;
        TextView textView = (TextView) findViewById(G2.a.srl_classics_update);
        this.f257s = textView;
        ImageView imageView2 = (ImageView) findViewById(G2.a.srl_classics_progress);
        this.f127f = imageView2;
        this.d = (TextView) findViewById(G2.a.srl_classics_title);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, G2.d.ClassicsHeader);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
        new LinearLayout.LayoutParams(-2, -2).topMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(G2.d.ClassicsHeader_srlTextTimeMarginTop, N2.b.a(0.0f));
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(G2.d.ClassicsHeader_srlDrawableMarginRight, N2.b.a(20.0f));
        layoutParams2.rightMargin = dimensionPixelSize;
        layoutParams.rightMargin = dimensionPixelSize;
        int i5 = G2.d.ClassicsHeader_srlDrawableArrowSize;
        layoutParams.width = typedArrayObtainStyledAttributes.getLayoutDimension(i5, layoutParams.width);
        layoutParams.height = typedArrayObtainStyledAttributes.getLayoutDimension(i5, layoutParams.height);
        int i6 = G2.d.ClassicsHeader_srlDrawableProgressSize;
        layoutParams2.width = typedArrayObtainStyledAttributes.getLayoutDimension(i6, layoutParams2.width);
        layoutParams2.height = typedArrayObtainStyledAttributes.getLayoutDimension(i6, layoutParams2.height);
        int i7 = G2.d.ClassicsHeader_srlDrawableSize;
        layoutParams.width = typedArrayObtainStyledAttributes.getLayoutDimension(i7, layoutParams.width);
        layoutParams.height = typedArrayObtainStyledAttributes.getLayoutDimension(i7, layoutParams.height);
        layoutParams2.width = typedArrayObtainStyledAttributes.getLayoutDimension(i7, layoutParams2.width);
        layoutParams2.height = typedArrayObtainStyledAttributes.getLayoutDimension(i7, layoutParams2.height);
        this.f134m = typedArrayObtainStyledAttributes.getInt(G2.d.ClassicsHeader_srlFinishDuration, this.f134m);
        boolean z6 = typedArrayObtainStyledAttributes.getBoolean(G2.d.ClassicsHeader_srlEnableLastTime, true);
        this.f260v = z6;
        this.b = c.f379h[typedArrayObtainStyledAttributes.getInt(G2.d.ClassicsHeader_srlClassicsSpinnerStyle, this.b.f380a)];
        int i8 = G2.d.ClassicsHeader_srlDrawableArrow;
        if (typedArrayObtainStyledAttributes.hasValue(i8)) {
            this.e.setImageDrawable(typedArrayObtainStyledAttributes.getDrawable(i8));
        } else if (this.e.getDrawable() == null) {
            C2.a aVar = new C2.a();
            this.f129h = aVar;
            aVar.a(-10066330);
            this.e.setImageDrawable(this.f129h);
        }
        int i9 = G2.d.ClassicsHeader_srlDrawableProgress;
        if (typedArrayObtainStyledAttributes.hasValue(i9)) {
            this.f127f.setImageDrawable(typedArrayObtainStyledAttributes.getDrawable(i9));
        } else if (this.f127f.getDrawable() == null) {
            B2.b bVar = new B2.b();
            this.f130i = bVar;
            bVar.a(-10066330);
            this.f127f.setImageDrawable(this.f130i);
        }
        int i10 = G2.d.ClassicsHeader_srlTextSizeTitle;
        if (typedArrayObtainStyledAttributes.hasValue(i10)) {
            this.d.setTextSize(0, typedArrayObtainStyledAttributes.getDimensionPixelSize(i10, N2.b.a(16.0f)));
        }
        int i11 = G2.d.ClassicsHeader_srlTextSizeTime;
        if (typedArrayObtainStyledAttributes.hasValue(i11)) {
            textView.setTextSize(0, typedArrayObtainStyledAttributes.getDimensionPixelSize(i11, N2.b.a(12.0f)));
        }
        int i12 = G2.d.ClassicsHeader_srlPrimaryColor;
        if (typedArrayObtainStyledAttributes.hasValue(i12)) {
            super.setPrimaryColor(typedArrayObtainStyledAttributes.getColor(i12, 0));
        }
        int i13 = G2.d.ClassicsHeader_srlAccentColor;
        if (typedArrayObtainStyledAttributes.hasValue(i13)) {
            setAccentColor(typedArrayObtainStyledAttributes.getColor(i13, 0));
        }
        int i14 = G2.d.ClassicsHeader_srlTextPulling;
        if (typedArrayObtainStyledAttributes.hasValue(i14)) {
            this.f261w = typedArrayObtainStyledAttributes.getString(i14);
        } else {
            String str = f243H;
            if (str != null) {
                this.f261w = str;
            } else {
                this.f261w = context.getString(G2.c.srl_header_pulling);
            }
        }
        int i15 = G2.d.ClassicsHeader_srlTextLoading;
        if (typedArrayObtainStyledAttributes.hasValue(i15)) {
            this.f263y = typedArrayObtainStyledAttributes.getString(i15);
        } else {
            String str2 = f245J;
            if (str2 != null) {
                this.f263y = str2;
            } else {
                this.f263y = context.getString(G2.c.srl_header_loading);
            }
        }
        int i16 = G2.d.ClassicsHeader_srlTextRelease;
        if (typedArrayObtainStyledAttributes.hasValue(i16)) {
            this.f264z = typedArrayObtainStyledAttributes.getString(i16);
        } else {
            String str3 = f246K;
            if (str3 != null) {
                this.f264z = str3;
            } else {
                this.f264z = context.getString(G2.c.srl_header_release);
            }
        }
        int i17 = G2.d.ClassicsHeader_srlTextFinish;
        if (typedArrayObtainStyledAttributes.hasValue(i17)) {
            this.f251A = typedArrayObtainStyledAttributes.getString(i17);
        } else {
            String str4 = f247M;
            if (str4 != null) {
                this.f251A = str4;
            } else {
                this.f251A = context.getString(G2.c.srl_header_finish);
            }
        }
        int i18 = G2.d.ClassicsHeader_srlTextFailed;
        if (typedArrayObtainStyledAttributes.hasValue(i18)) {
            this.f252C = typedArrayObtainStyledAttributes.getString(i18);
        } else {
            String str5 = f248Q;
            if (str5 != null) {
                this.f252C = str5;
            } else {
                this.f252C = context.getString(G2.c.srl_header_failed);
            }
        }
        int i19 = G2.d.ClassicsHeader_srlTextSecondary;
        if (typedArrayObtainStyledAttributes.hasValue(i19)) {
            this.f254G = typedArrayObtainStyledAttributes.getString(i19);
        } else {
            String str6 = f250n0;
            if (str6 != null) {
                this.f254G = str6;
            } else {
                this.f254G = context.getString(G2.c.srl_header_secondary);
            }
        }
        int i20 = G2.d.ClassicsHeader_srlTextRefreshing;
        if (typedArrayObtainStyledAttributes.hasValue(i20)) {
            this.f262x = typedArrayObtainStyledAttributes.getString(i20);
        } else {
            String str7 = f244I;
            if (str7 != null) {
                this.f262x = str7;
            } else {
                this.f262x = context.getString(G2.c.srl_header_refreshing);
            }
        }
        int i21 = G2.d.ClassicsHeader_srlTextUpdate;
        if (typedArrayObtainStyledAttributes.hasValue(i21)) {
            this.f253D = typedArrayObtainStyledAttributes.getString(i21);
        } else {
            String str8 = f249k0;
            if (str8 != null) {
                this.f253D = str8;
            } else {
                this.f253D = context.getString(G2.c.srl_header_update);
            }
        }
        this.f259u = new SimpleDateFormat(this.f253D, Locale.getDefault());
        typedArrayObtainStyledAttributes.recycle();
        imageView2.animate().setInterpolator(null);
        textView.setVisibility(z6 ? 0 : 8);
        this.d.setText(isInEditMode() ? this.f262x : this.f261w);
        if (isInEditMode()) {
            imageView.setVisibility(8);
        } else {
            imageView2.setVisibility(8);
        }
        try {
            if ((context instanceof FragmentActivity) && (supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager()) != null && supportFragmentManager.getFragments().size() > 0) {
                b(new Date());
                return;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        String str9 = this.f255q + context.getClass().getName();
        this.f255q = str9;
        SharedPreferences sharedPreferences = context.getSharedPreferences("ClassicsHeader", 0);
        this.f258t = sharedPreferences;
        b(new Date(sharedPreferences.getLong(str9, System.currentTimeMillis())));
    }

    public final void b(Date date) {
        this.f256r = date;
        this.f257s.setText(this.f259u.format(date));
        SharedPreferences sharedPreferences = this.f258t;
        if (sharedPreferences == null || isInEditMode()) {
            return;
        }
        sharedPreferences.edit().putLong(this.f255q, date.getTime()).apply();
    }

    @Override // C2.b, M2.b, I2.a
    public int onFinish(@NonNull f fVar, boolean z6) {
        if (z6) {
            this.d.setText(this.f251A);
            if (this.f256r != null) {
                b(new Date());
            }
        } else {
            this.d.setText(this.f252C);
        }
        return super.onFinish(fVar, z6);
    }

    @Override // M2.b, I2.a, L2.g, I2.c
    public void onStateChanged(@NonNull f fVar, @NonNull J2.b bVar, @NonNull J2.b bVar2) {
        ImageView imageView = this.e;
        int iOrdinal = bVar2.ordinal();
        boolean z6 = this.f260v;
        TextView textView = this.f257s;
        if (iOrdinal == 0) {
            textView.setVisibility(z6 ? 0 : 8);
        } else if (iOrdinal != 1) {
            if (iOrdinal == 5) {
                this.d.setText(this.f264z);
                imageView.animate().rotation(180.0f);
                return;
            }
            if (iOrdinal == 7) {
                this.d.setText(this.f254G);
                imageView.animate().rotation(0.0f);
                return;
            } else if (iOrdinal == 9 || iOrdinal == 11) {
                this.d.setText(this.f262x);
                imageView.setVisibility(8);
                return;
            } else {
                if (iOrdinal != 12) {
                    return;
                }
                imageView.setVisibility(8);
                textView.setVisibility(z6 ? 4 : 8);
                this.d.setText(this.f263y);
                return;
            }
        }
        this.d.setText(this.f261w);
        imageView.setVisibility(0);
        imageView.animate().rotation(0.0f);
    }

    @Override // C2.b
    public a setAccentColor(@ColorInt int i5) {
        this.f257s.setTextColor((16777215 & i5) | (-872415232));
        return (a) super.setAccentColor(i5);
    }
}
