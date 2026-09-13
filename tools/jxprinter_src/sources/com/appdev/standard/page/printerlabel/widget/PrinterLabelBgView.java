package com.appdev.standard.page.printerlabel.widget;

import I0.i;
import I0.j;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.AbstractC0501q;
import com.bumptech.glide.load.engine.J;
import com.bumptech.glide.request.target.k;
import kotlin.jvm.internal.Y;
import org.json.JSONException;
import org.json.JSONObject;
import p056k0.q;
import p113u.d;
import p113u.e;
import p113u.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class PrinterLabelBgView extends BaseControlView {
    protected final String KEY_TEMPLATE_BG;
    private String background;
    private Bitmap backgroundBitmap;
    private ImageView bg;
    private String border;
    private Bitmap borderBitmap;
    private int borderStyle;
    private boolean borderToastShown;
    private j requestOptions;

    /* JADX INFO: renamed from: com.appdev.standard.page.printerlabel.widget.PrinterLabelBgView$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass2 implements i {
        final /* synthetic */ Drawable[] val$backgroundDrawable;
        final /* synthetic */ Drawable[] val$borderDrawable;
        final /* synthetic */ String val$borderUrl;
        final /* synthetic */ boolean[] val$isBackgroundFinish;
        final /* synthetic */ boolean[] val$isBoarderFinish;
        final /* synthetic */ BgImageLoadListener val$listener;
        final /* synthetic */ int val$maxRetry;
        final /* synthetic */ int[] val$retryCount;

        public AnonymousClass2(int[] iArr, int i5, String str, Drawable[] drawableArr, boolean[] zArr, boolean[] zArr2, Drawable[] drawableArr2, BgImageLoadListener bgImageLoadListener) {
            this.val$retryCount = iArr;
            this.val$maxRetry = i5;
            this.val$borderUrl = str;
            this.val$borderDrawable = drawableArr;
            this.val$isBoarderFinish = zArr;
            this.val$isBackgroundFinish = zArr2;
            this.val$backgroundDrawable = drawableArr2;
            this.val$listener = bgImageLoadListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onLoadFailed$0(String str, Drawable[] drawableArr, boolean[] zArr, boolean[] zArr2, Drawable[] drawableArr2, BgImageLoadListener bgImageLoadListener, int[] iArr, int i5) {
            PrinterLabelBgView.this.loadBorderImage(str, drawableArr, zArr, zArr2, drawableArr2, bgImageLoadListener, iArr, i5);
        }

        @Override // I0.i
        public boolean onLoadFailed(@Nullable J j6, Object obj, k kVar, boolean z6) {
            int[] iArr = this.val$retryCount;
            int i5 = iArr[0];
            if (i5 >= this.val$maxRetry) {
                p051j0.a.d(PrinterLabelBgView.this.TAG, "边框图片加载失败，已达到最大重试次数");
                this.val$isBoarderFinish[0] = true;
                if (this.val$isBackgroundFinish[0]) {
                    this.val$listener.onBgImageLoad(this.val$backgroundDrawable[0], this.val$borderDrawable[0]);
                }
                return false;
            }
            iArr[0] = i5 + 1;
            String str = PrinterLabelBgView.this.TAG;
            StringBuilder sb = new StringBuilder("边框图片加载失败，尝试重新加载，重试次数: ");
            sb.append(this.val$retryCount[0]);
            sb.append(", 错误: ");
            sb.append(j6 != null ? j6.getMessage() : "未知错误");
            p051j0.a.d(str, sb.toString());
            PrinterLabelBgView.this.postDelayed(new b(this, this.val$borderUrl, this.val$borderDrawable, this.val$isBoarderFinish, this.val$isBackgroundFinish, this.val$backgroundDrawable, this.val$listener, this.val$retryCount, this.val$maxRetry, 0), 500L);
            return false;
        }

        @Override // I0.i
        public boolean onResourceReady(Drawable drawable, Object obj, k kVar, p126w0.a aVar, boolean z6) {
            return false;
        }
    }

    /* JADX INFO: renamed from: com.appdev.standard.page.printerlabel.widget.PrinterLabelBgView$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass4 implements i {
        final /* synthetic */ Drawable[] val$backgroundDrawable;
        final /* synthetic */ String val$backgroundUrl;
        final /* synthetic */ Drawable[] val$borderDrawable;
        final /* synthetic */ boolean[] val$isBackgroundFinish;
        final /* synthetic */ boolean[] val$isBoarderFinish;
        final /* synthetic */ BgImageLoadListener val$listener;
        final /* synthetic */ int val$maxRetry;
        final /* synthetic */ int[] val$retryCount;

        public AnonymousClass4(int[] iArr, int i5, String str, Drawable[] drawableArr, boolean[] zArr, boolean[] zArr2, Drawable[] drawableArr2, BgImageLoadListener bgImageLoadListener) {
            this.val$retryCount = iArr;
            this.val$maxRetry = i5;
            this.val$backgroundUrl = str;
            this.val$backgroundDrawable = drawableArr;
            this.val$isBackgroundFinish = zArr;
            this.val$isBoarderFinish = zArr2;
            this.val$borderDrawable = drawableArr2;
            this.val$listener = bgImageLoadListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onLoadFailed$0(String str, Drawable[] drawableArr, boolean[] zArr, boolean[] zArr2, Drawable[] drawableArr2, BgImageLoadListener bgImageLoadListener, int[] iArr, int i5) {
            PrinterLabelBgView.this.loadBackgroundImage(str, drawableArr, zArr, zArr2, drawableArr2, bgImageLoadListener, iArr, i5);
        }

        @Override // I0.i
        public boolean onLoadFailed(@Nullable J j6, Object obj, k kVar, boolean z6) {
            int[] iArr = this.val$retryCount;
            int i5 = iArr[0];
            if (i5 >= this.val$maxRetry) {
                p051j0.a.d(PrinterLabelBgView.this.TAG, "背景图片加载失败，已达到最大重试次数");
                this.val$isBackgroundFinish[0] = true;
                if (this.val$isBoarderFinish[0]) {
                    this.val$listener.onBgImageLoad(this.val$backgroundDrawable[0], this.val$borderDrawable[0]);
                }
                return false;
            }
            iArr[0] = i5 + 1;
            String str = PrinterLabelBgView.this.TAG;
            StringBuilder sb = new StringBuilder("背景图片加载失败，尝试重新加载，重试次数: ");
            sb.append(this.val$retryCount[0]);
            sb.append(", 错误: ");
            sb.append(j6 != null ? j6.getMessage() : "未知错误");
            p051j0.a.d(str, sb.toString());
            PrinterLabelBgView.this.postDelayed(new b(this, this.val$backgroundUrl, this.val$backgroundDrawable, this.val$isBackgroundFinish, this.val$isBoarderFinish, this.val$borderDrawable, this.val$listener, this.val$retryCount, this.val$maxRetry, 1), 500L);
            return false;
        }

        @Override // I0.i
        public boolean onResourceReady(Drawable drawable, Object obj, k kVar, p126w0.a aVar, boolean z6) {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface BgImageLoadListener {
        void onBgImageLoad(Drawable drawable, Drawable drawable2);
    }

    public PrinterLabelBgView(TemplatePageView templatePageView) {
        super(templatePageView);
        this.bg = null;
        this.background = null;
        this.border = null;
        this.borderStyle = 0;
        this.requestOptions = null;
        this.borderBitmap = null;
        this.backgroundBitmap = null;
        this.borderToastShown = false;
        this.KEY_TEMPLATE_BG = "templateBg";
        this.bg = (ImageView) findViewById(d.bg_content);
        this.requestOptions = (j) ((j) ((j) new j().dontAnimate()).diskCacheStrategy(AbstractC0501q.f3068a)).skipMemoryCache(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$loadBg$0(Drawable drawable, Drawable drawable2) {
        Bitmap bitmap;
        ViewGroup.LayoutParams layoutParams = this.mRoot.getLayoutParams();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(layoutParams.width, layoutParams.height, Bitmap.Config.ARGB_8888);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmapCreateBitmap, tileMode, tileMode));
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawRGB(255, 255, 255);
        RectF rectF = new RectF(0.0f, 0.0f, layoutParams.width, layoutParams.height);
        this.backgroundBitmap = null;
        if ((drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            this.backgroundBitmap = bitmap;
            drawable.setBounds(new Rect(0, 0, layoutParams.width, layoutParams.height));
            drawable.draw(canvas);
        }
        this.borderBitmap = null;
        if (drawable2 != null && (drawable2 instanceof BitmapDrawable)) {
            Bitmap bitmap2 = ((BitmapDrawable) drawable2).getBitmap();
            this.borderBitmap = bitmap2;
            try {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(getContext().getResources(), ninePatchStrech(new q().scaleBitmapByEqualRatio(bitmap2, layoutParams.width, layoutParams.height), layoutParams.width, layoutParams.height));
                bitmapDrawable.setBounds(new Rect(0, 0, layoutParams.width, layoutParams.height));
                bitmapDrawable.draw(canvas);
            } catch (Exception unused) {
                if (!this.borderToastShown) {
                    this.borderToastShown = true;
                    p042h2.d.show(g.toast_label_border_removed);
                }
            }
        }
        int i5 = this.borderStyle;
        if (i5 == 1) {
            float f6 = getContext().getResources().getDisplayMetrics().density * 6.0f;
            Path path = new Path();
            path.addRoundRect(rectF, f6, f6, Path.Direction.CW);
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(layoutParams.width, layoutParams.height, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
            canvas2.clipPath(path);
            canvas2.drawBitmap(bitmapCreateBitmap, 0.0f, 0.0f, (Paint) null);
            this.bg.setImageBitmap(bitmapCreateBitmap2);
            return;
        }
        if (i5 != 2) {
            this.bg.setImageBitmap(bitmapCreateBitmap);
            return;
        }
        Path path2 = new Path();
        path2.addOval(rectF, Path.Direction.CW);
        Bitmap bitmapCreateBitmap3 = Bitmap.createBitmap(layoutParams.width, layoutParams.height, Bitmap.Config.ARGB_8888);
        Canvas canvas3 = new Canvas(bitmapCreateBitmap3);
        canvas3.clipPath(path2);
        canvas3.drawBitmap(bitmapCreateBitmap, 0.0f, 0.0f, (Paint) null);
        this.bg.setImageBitmap(bitmapCreateBitmap3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadBackgroundImage(String str, final Drawable[] drawableArr, final boolean[] zArr, final boolean[] zArr2, final Drawable[] drawableArr2, final BgImageLoadListener bgImageLoadListener, int[] iArr, int i5) {
        com.bumptech.glide.c.with(getContext()).load(str).apply((I0.a) this.requestOptions).listener(new AnonymousClass4(iArr, i5, str, drawableArr, zArr, zArr2, drawableArr2, bgImageLoadListener)).into(new com.bumptech.glide.request.target.c() { // from class: com.appdev.standard.page.printerlabel.widget.PrinterLabelBgView.3
            @Override // com.bumptech.glide.request.target.c, com.bumptech.glide.request.target.k
            public void onResourceReady(@NonNull Drawable drawable, @Nullable J0.d dVar) {
                drawableArr[0] = drawable;
                zArr[0] = true;
                if (zArr2[0]) {
                    bgImageLoadListener.onBgImageLoad(drawable, drawableArr2[0]);
                }
            }

            @Override // com.bumptech.glide.request.target.c, com.bumptech.glide.request.target.k
            public void onLoadCleared(@Nullable Drawable drawable) {
            }
        });
    }

    private void loadBg() {
        int i5;
        ViewGroup.LayoutParams layoutParams = this.mRoot.getLayoutParams();
        int i6 = layoutParams.width;
        if (i6 == 0 || (i5 = layoutParams.height) == 0) {
            return;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i6, i5, Bitmap.Config.ARGB_8888);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmapCreateBitmap, tileMode, tileMode));
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawRGB(255, 255, 255);
        RectF rectF = new RectF(0.0f, 0.0f, layoutParams.width, layoutParams.height);
        int i7 = this.borderStyle;
        if (i7 == 1) {
            float f6 = getContext().getResources().getDisplayMetrics().density * 6.0f;
            canvas.drawRoundRect(rectF, f6, f6, paint);
            this.bg.setImageBitmap(bitmapCreateBitmap);
        } else if (i7 == 2) {
            canvas.drawOval(rectF, paint);
            this.bg.setImageBitmap(bitmapCreateBitmap);
        } else {
            this.bg.setImageBitmap(bitmapCreateBitmap);
        }
        loadBgImage(new a(this, 3));
    }

    private void loadBgImage(BgImageLoadListener bgImageLoadListener) {
        PrinterLabelBgView printerLabelBgView;
        BgImageLoadListener bgImageLoadListener2;
        if (Y.f(this.background) && Y.f(this.border)) {
            bgImageLoadListener.onBgImageLoad(null, null);
            return;
        }
        boolean[] zArr = {true};
        Drawable[] drawableArr = {null};
        boolean[] zArr2 = {true};
        Drawable[] drawableArr2 = {null};
        int[] iArr = {0};
        int[] iArr2 = {0};
        if (Y.f(this.border)) {
            printerLabelBgView = this;
            bgImageLoadListener2 = bgImageLoadListener;
        } else {
            zArr[0] = false;
            printerLabelBgView = this;
            bgImageLoadListener2 = bgImageLoadListener;
            printerLabelBgView.loadBorderImage(this.border, drawableArr, zArr, zArr2, drawableArr2, bgImageLoadListener2, iArr, 2);
        }
        if (Y.f(printerLabelBgView.background)) {
            return;
        }
        zArr2[0] = false;
        printerLabelBgView.loadBackgroundImage(printerLabelBgView.background, drawableArr2, zArr2, zArr, drawableArr, bgImageLoadListener2, iArr2, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadBorderImage(String str, final Drawable[] drawableArr, final boolean[] zArr, final boolean[] zArr2, final Drawable[] drawableArr2, final BgImageLoadListener bgImageLoadListener, int[] iArr, int i5) {
        com.bumptech.glide.c.with(getContext()).load(str).apply((I0.a) this.requestOptions).listener(new AnonymousClass2(iArr, i5, str, drawableArr, zArr, zArr2, drawableArr2, bgImageLoadListener)).into(new com.bumptech.glide.request.target.c() { // from class: com.appdev.standard.page.printerlabel.widget.PrinterLabelBgView.1
            @Override // com.bumptech.glide.request.target.c, com.bumptech.glide.request.target.k
            public void onResourceReady(@NonNull Drawable drawable, @Nullable J0.d dVar) {
                drawableArr[0] = drawable;
                zArr[0] = true;
                if (zArr2[0]) {
                    bgImageLoadListener.onBgImageLoad(drawableArr2[0], drawable);
                }
            }

            @Override // com.bumptech.glide.request.target.c, com.bumptech.glide.request.target.k
            public void onLoadCleared(@Nullable Drawable drawable) {
            }
        });
    }

    private Bitmap ninePatchStrech(Bitmap bitmap, int i5, int i6) {
        Paint paint;
        int i7;
        if (i5 == bitmap.getWidth() && i6 == bitmap.getHeight()) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i8 = width / 2;
        int i9 = width % 2 == 1 ? i8 + 1 : i8;
        int i10 = height / 2;
        int i11 = bitmap.getHeight() % 2 == 1 ? i10 + 1 : i10;
        if (i5 < width) {
            i9 = i5 / 2;
            if (i5 % 2 == 1) {
                i9++;
            }
        }
        if (i6 < height) {
            i11 = i6 / 2;
            if (i6 % 2 == 1) {
                i11++;
            }
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i5, i6, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawBitmap(bitmap, new Rect(0, 0, i9, i11), new Rect(0, 0, i9, i11), (Paint) null);
        int i12 = height - i11;
        int i13 = i6 - i11;
        canvas.drawBitmap(bitmap, new Rect(0, i12, i9, height), new Rect(0, i13, i9, i6), (Paint) null);
        int i14 = width - i9;
        int i15 = i5 - i9;
        canvas.drawBitmap(bitmap, new Rect(i14, 0, width, i11), new Rect(i15, 0, i5, i11), (Paint) null);
        canvas.drawBitmap(bitmap, new Rect(i14, i12, width, height), new Rect(i15, i13, i5, i6), (Paint) null);
        if (i5 > i9 * 2) {
            int i16 = i8 - 2;
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmap, i16, 0, 4, i11);
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            BitmapShader bitmapShader = new BitmapShader(bitmapCreateBitmap2, tileMode, tileMode);
            Paint paint2 = new Paint();
            paint2.setShader(bitmapShader);
            i7 = i14;
            canvas = canvas;
            paint = null;
            canvas.drawRect(i9, 0.0f, i15, i11, paint2);
            canvas.drawBitmap(bitmap, new Rect(i16, i12, i8 + 2, height), new Rect(i9, i13, i15, i6), (Paint) null);
        } else {
            paint = null;
            i7 = i14;
        }
        if (i6 > i11 * 2) {
            int i17 = i10 - 2;
            BitmapShader bitmapShader2 = new BitmapShader(Bitmap.createBitmap(bitmap, 0, i17, i9, 4), Shader.TileMode.CLAMP, Shader.TileMode.REPEAT);
            Paint paint3 = new Paint();
            paint3.setShader(bitmapShader2);
            canvas.drawRect(0.0f, i11, i9, i13, paint3);
            canvas.drawBitmap(bitmap, new Rect(i7, i17, width, i10 + 2), new Rect(i15, i11, i5, i13), paint);
        }
        return bitmapCreateBitmap;
    }

    public void changeBgView(int i5, int i6, int i7, int i8) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.mRoot.getLayoutParams();
        boolean z6 = (layoutParams2.width == i7 && layoutParams2.height == i8) ? false : true;
        layoutParams.leftMargin = i5;
        layoutParams.topMargin = i6;
        layoutParams2.width = i7;
        layoutParams2.height = i8;
        this.mRoot.setLayoutParams(layoutParams2);
        setLayoutParams(layoutParams);
        this.isFixed = true;
        this.takePrint = false;
        if (z6) {
            scaleBg();
        }
    }

    public void copyFrom(PrinterLabelBgView printerLabelBgView) {
        Bitmap bitmap = printerLabelBgView.borderBitmap;
        if (bitmap != null) {
            this.borderBitmap = bitmap;
            ViewGroup.LayoutParams layoutParams = this.mRoot.getLayoutParams();
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(layoutParams.width, layoutParams.height, Bitmap.Config.ARGB_8888);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            paint.setShader(new BitmapShader(bitmapCreateBitmap, tileMode, tileMode));
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            canvas.drawRGB(255, 255, 255);
            try {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(getContext().getResources(), ninePatchStrech(new q().scaleBitmapByEqualRatio(this.borderBitmap, layoutParams.width, layoutParams.height), layoutParams.width, layoutParams.height));
                bitmapDrawable.setBounds(new Rect(0, 0, layoutParams.width, layoutParams.height));
                bitmapDrawable.draw(canvas);
            } catch (Exception unused) {
                if (!this.borderToastShown) {
                    this.borderToastShown = true;
                    p042h2.d.show(g.toast_label_border_removed);
                }
            }
            RectF rectF = new RectF(0.0f, 0.0f, layoutParams.width, layoutParams.height);
            int i5 = this.borderStyle;
            if (i5 == 1) {
                float f6 = getContext().getResources().getDisplayMetrics().density * 6.0f;
                Path path = new Path();
                path.addRoundRect(rectF, f6, f6, Path.Direction.CW);
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(layoutParams.width, layoutParams.height, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
                canvas2.clipPath(path);
                canvas2.drawBitmap(bitmapCreateBitmap, 0.0f, 0.0f, (Paint) null);
                this.bg.setImageBitmap(bitmapCreateBitmap2);
                return;
            }
            if (i5 != 2) {
                this.bg.setImageBitmap(bitmapCreateBitmap);
                return;
            }
            Path path2 = new Path();
            path2.addOval(rectF, Path.Direction.CW);
            Bitmap bitmapCreateBitmap3 = Bitmap.createBitmap(layoutParams.width, layoutParams.height, Bitmap.Config.ARGB_8888);
            Canvas canvas3 = new Canvas(bitmapCreateBitmap3);
            canvas3.clipPath(path2);
            canvas3.drawBitmap(bitmapCreateBitmap, 0.0f, 0.0f, (Paint) null);
            this.bg.setImageBitmap(bitmapCreateBitmap3);
        }
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int defaultHeight() {
        return 0;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int defaultWidth() {
        return 0;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int elementType() {
        return 0;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public JSONObject getJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            this.saveObject = jSONObject;
            jSONObject.put("templateBg", this.background);
            this.saveObject.put("itemType", String.valueOf(elementType()));
        } catch (JSONException e) {
            p051j0.a.d(this.TAG, e.toString());
        }
        return this.saveObject;
    }

    public void initBgView(int i5, int i6) {
        ViewGroup.LayoutParams layoutParams = this.mRoot.getLayoutParams();
        layoutParams.width = i5;
        layoutParams.height = i6;
        this.mRoot.setLayoutParams(layoutParams);
        this.isFixed = true;
        this.takePrint = false;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public boolean isHitElement(int i5, int i6, int i7) {
        return false;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int layoutId() {
        return e.printer_labell_bg_view;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int minHeight() {
        return 0;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int minWidth() {
        return 0;
    }

    public void scaleBg() {
        ViewGroup.LayoutParams layoutParams = this.mRoot.getLayoutParams();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(layoutParams.width, layoutParams.height, Bitmap.Config.ARGB_8888);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmapCreateBitmap, tileMode, tileMode));
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawRGB(255, 255, 255);
        if (this.backgroundBitmap != null) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getContext().getResources(), this.backgroundBitmap);
            bitmapDrawable.setBounds(new Rect(0, 0, layoutParams.width, layoutParams.height));
            bitmapDrawable.draw(canvas);
        }
        Bitmap bitmap = this.borderBitmap;
        if (bitmap != null) {
            try {
                BitmapDrawable bitmapDrawable2 = new BitmapDrawable(getContext().getResources(), ninePatchStrech(new q().scaleBitmapByEqualRatio(bitmap, layoutParams.width, layoutParams.height), layoutParams.width, layoutParams.height));
                bitmapDrawable2.setBounds(new Rect(0, 0, layoutParams.width, layoutParams.height));
                bitmapDrawable2.draw(canvas);
            } catch (Exception unused) {
                if (!this.borderToastShown) {
                    this.borderToastShown = true;
                    p042h2.d.show(g.toast_label_border_removed);
                }
            }
        }
        RectF rectF = new RectF(0.0f, 0.0f, layoutParams.width, layoutParams.height);
        int i5 = this.borderStyle;
        if (i5 == 1) {
            float f6 = getContext().getResources().getDisplayMetrics().density * 6.0f;
            Path path = new Path();
            path.addRoundRect(rectF, f6, f6, Path.Direction.CW);
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(layoutParams.width, layoutParams.height, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
            canvas2.clipPath(path);
            canvas2.drawBitmap(bitmapCreateBitmap, 0.0f, 0.0f, (Paint) null);
            this.bg.setImageBitmap(bitmapCreateBitmap2);
            return;
        }
        if (i5 != 2) {
            this.bg.setImageBitmap(bitmapCreateBitmap);
            return;
        }
        Path path2 = new Path();
        path2.addOval(rectF, Path.Direction.CW);
        Bitmap bitmapCreateBitmap3 = Bitmap.createBitmap(layoutParams.width, layoutParams.height, Bitmap.Config.ARGB_8888);
        Canvas canvas3 = new Canvas(bitmapCreateBitmap3);
        canvas3.clipPath(path2);
        canvas3.drawBitmap(bitmapCreateBitmap, 0.0f, 0.0f, (Paint) null);
        this.bg.setImageBitmap(bitmapCreateBitmap3);
    }

    public void setBackground(String str, String str2, int i5) {
        if (this.templatePage.isWillPrintView()) {
            return;
        }
        this.background = str;
        this.borderStyle = i5;
        this.border = str2;
        loadBg();
    }

    public void setViewByJson(JSONObject jSONObject) {
        try {
            if (jSONObject.has("templateBg")) {
                this.background = jSONObject.getString("templateBg");
            }
            loadBg();
        } catch (JSONException e) {
            p051j0.a.d(this.TAG, e.toString());
        }
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public void updateView() {
        setControlType(1);
        this.isRenderingCompleted = true;
        super.updateView();
    }
}
