package com.appdev.standard.page.printerlabel.widget;

import J0.d;
import android.annotation.SuppressLint;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.json.JSONException;
import org.json.JSONObject;
import p056k0.q;
import p113u.e;
import p113u.g;
import p134x2.C1849c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class PrinterLabelPictureView extends BaseControlView {
    protected final String KEY_BRIGHTNESS;
    protected final String KEY_CONTENT;
    protected final String KEY_CONTRAST;
    protected final String KEY_DEFINITION;
    protected final String KEY_IMAGE_DISPLAY_MODE;
    protected final String KEY_PIC_TYPE;
    protected final String KEY_SATURATION;
    protected final String KEY_TILE;
    private final String TAG;
    private int brightness;
    private String content;
    private int contrast;
    private Bitmap curBitmap;
    private String curBitmapUrl;
    private int definition;
    private long height;
    private int imageDisplayMode;
    private boolean isTile;
    private ImageView iv;
    private Runnable loadNetworkPicRunnable;
    private int oldBrightness;
    private String oldContent;
    private int oldContrast;
    private int oldDefinition;
    private long oldHeight;
    private int oldImageDisplayMode;
    private int oldSaturation;
    private long oldWidth;
    private int picType;
    private boolean pictureToastShown;
    private int realBrightness;
    private int realContrast;
    private int realSaturation;
    private int saturation;
    private long width;

    public PrinterLabelPictureView(TemplatePageView templatePageView) {
        super(templatePageView);
        this.TAG = "PrinterLabelPictureView";
        this.iv = null;
        this.oldContent = null;
        this.oldDefinition = 0;
        this.oldBrightness = 0;
        this.oldContrast = 50;
        this.oldSaturation = 50;
        this.oldImageDisplayMode = 1;
        this.oldWidth = 0L;
        this.oldHeight = 0L;
        this.content = null;
        this.definition = 128;
        this.brightness = 0;
        this.contrast = 50;
        this.saturation = 50;
        this.realBrightness = 0;
        this.realContrast = 50;
        this.realSaturation = 50;
        this.width = 0L;
        this.height = 0L;
        this.curBitmap = null;
        this.curBitmapUrl = null;
        this.pictureToastShown = false;
        this.isTile = false;
        this.picType = 1;
        this.imageDisplayMode = 0;
        this.loadNetworkPicRunnable = new Runnable() { // from class: com.appdev.standard.page.printerlabel.widget.PrinterLabelPictureView.1
            @Override // java.lang.Runnable
            public void run() {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) PrinterLabelPictureView.this.mRoot.getLayoutParams();
                PrinterLabelPictureView.this.width = layoutParams.width;
                PrinterLabelPictureView.this.height = layoutParams.height;
                if (PrinterLabelPictureView.this.width <= 0 || PrinterLabelPictureView.this.height <= 0) {
                    PrinterLabelPictureView printerLabelPictureView = PrinterLabelPictureView.this;
                    printerLabelPictureView.postDelayed(printerLabelPictureView.loadNetworkPicRunnable, 500L);
                } else {
                    if (PrinterLabelPictureView.this.curBitmapUrl != null && PrinterLabelPictureView.this.curBitmapUrl.equals(PrinterLabelPictureView.this.content)) {
                        PrinterLabelPictureView.this.updateImage();
                        return;
                    }
                    p051j0.a.d(PrinterLabelPictureView.this.TAG, "加载网络图片:" + PrinterLabelPictureView.this.content);
                    com.bumptech.glide.c.with(PrinterLabelPictureView.this.getContext()).asBitmap().load(PrinterLabelPictureView.this.content).into(new com.bumptech.glide.request.target.c() { // from class: com.appdev.standard.page.printerlabel.widget.PrinterLabelPictureView.1.1
                        @Override // com.bumptech.glide.request.target.c, com.bumptech.glide.request.target.k
                        @SuppressLint({"ClickableViewAccessibility"})
                        public void onResourceReady(@NonNull Bitmap bitmap, @Nullable d dVar) {
                            PrinterLabelPictureView.this.curBitmap = bitmap;
                            PrinterLabelPictureView printerLabelPictureView2 = PrinterLabelPictureView.this;
                            printerLabelPictureView2.curBitmapUrl = printerLabelPictureView2.content;
                            PrinterLabelPictureView.this.updateImage();
                            p051j0.a.d(PrinterLabelPictureView.this.TAG, "图片加载完毕");
                        }

                        @Override // com.bumptech.glide.request.target.c, com.bumptech.glide.request.target.k
                        public void onLoadCleared(@Nullable Drawable drawable) {
                        }
                    });
                }
            }
        };
        this.KEY_CONTENT = FirebaseAnalytics.Param.CONTENT;
        this.KEY_DEFINITION = "definition";
        this.KEY_BRIGHTNESS = "brightness";
        this.KEY_CONTRAST = "contrast";
        this.KEY_SATURATION = "saturation";
        this.KEY_TILE = "isTile";
        this.KEY_PIC_TYPE = "picType";
        this.KEY_IMAGE_DISPLAY_MODE = "imageDisplayMode";
        this.iv = (ImageView) findViewById(p113u.d.iv_picture);
        updateView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:48:0x017d A[Catch: Exception -> 0x01b0, TryCatch #0 {Exception -> 0x01b0, blocks: (B:26:0x0061, B:28:0x006b, B:30:0x00a8, B:32:0x00d0, B:34:0x00ed, B:35:0x0102, B:38:0x011c, B:52:0x0190, B:37:0x0106, B:40:0x0126, B:42:0x0143, B:43:0x0158, B:46:0x0172, B:48:0x017d, B:45:0x015c, B:51:0x0185), top: B:58:0x0061 }] */
    public void updateImage() {
        float fFloatValue;
        float fFloatValue2;
        String str;
        if (this.curBitmapUrl == null || this.curBitmap == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mRoot.getLayoutParams();
        this.width = layoutParams.width;
        this.height = layoutParams.height;
        if (this.definition == this.oldDefinition && this.brightness == this.oldBrightness && this.contrast == this.oldContrast && this.saturation == this.oldSaturation && this.imageDisplayMode == this.oldImageDisplayMode && (((str = this.content) == null || str.equals(this.oldContent)) && this.oldWidth == this.width && this.oldHeight == this.height)) {
            return;
        }
        this.oldWidth = layoutParams.width;
        this.oldHeight = layoutParams.height;
        try {
            if (this.curBitmapUrl.equals("default")) {
                this.iv.setImageBitmap(new q().scaleBitmapByEqualRatio(this.curBitmap, (int) (layoutParams.width / C1849c.getScale()), (int) (layoutParams.height / C1849c.getScale())));
                this.oldDefinition = this.definition;
                this.oldBrightness = this.brightness;
                this.oldContrast = this.contrast;
                this.oldSaturation = this.saturation;
                this.oldImageDisplayMode = this.imageDisplayMode;
                this.oldContent = this.content;
                this.isRenderingCompleted = true;
                return;
            }
            Bitmap bitmapScaleBitmapByEqualRatio = new q().scaleBitmapByEqualRatio(this.curBitmap, (int) (layoutParams.width / C1849c.getScale()), (int) (layoutParams.height / C1849c.getScale()));
            int i5 = this.imageDisplayMode;
            float f6 = 1.0f;
            if (i5 == 0) {
                BigDecimal bigDecimal = new BigDecimal(this.contrast - 50);
                BigDecimal bigDecimal2 = new BigDecimal(50);
                RoundingMode roundingMode = RoundingMode.UP;
                float fFloatValue3 = bigDecimal.divide(bigDecimal2, 3, roundingMode).floatValue() + 1.0f;
                int i6 = this.saturation - 50;
                if (i6 < 0) {
                    fFloatValue2 = new BigDecimal(this.saturation - 50).divide(new BigDecimal(50), 3, roundingMode).floatValue();
                } else {
                    if (i6 > 0) {
                        fFloatValue2 = new BigDecimal(this.saturation - 50).divide(new BigDecimal(25), 3, roundingMode).floatValue();
                    }
                    bitmapScaleBitmapByEqualRatio = q.a(bitmapScaleBitmapByEqualRatio, fFloatValue3, this.brightness, f6);
                }
                f6 = 1.0f + fFloatValue2;
                bitmapScaleBitmapByEqualRatio = q.a(bitmapScaleBitmapByEqualRatio, fFloatValue3, this.brightness, f6);
            } else if (i5 == 1) {
                BigDecimal bigDecimal3 = new BigDecimal(this.contrast - 50);
                BigDecimal bigDecimal4 = new BigDecimal(50);
                RoundingMode roundingMode2 = RoundingMode.UP;
                float fFloatValue4 = bigDecimal3.divide(bigDecimal4, 3, roundingMode2).floatValue() + 1.0f;
                int i7 = this.saturation - 50;
                if (i7 < 0) {
                    fFloatValue = new BigDecimal(this.saturation - 50).divide(new BigDecimal(50), 3, roundingMode2).floatValue();
                } else if (i7 > 0) {
                    fFloatValue = new BigDecimal(this.saturation - 50).divide(new BigDecimal(25), 3, roundingMode2).floatValue();
                } else {
                    bitmapScaleBitmapByEqualRatio = q.a(bitmapScaleBitmapByEqualRatio, fFloatValue4, this.brightness, f6);
                    if (this.picType != 0) {
                        bitmapScaleBitmapByEqualRatio = q.d(bitmapScaleBitmapByEqualRatio);
                    }
                }
                f6 = 1.0f + fFloatValue;
                bitmapScaleBitmapByEqualRatio = q.a(bitmapScaleBitmapByEqualRatio, fFloatValue4, this.brightness, f6);
                if (this.picType != 0) {
                    bitmapScaleBitmapByEqualRatio = q.d(bitmapScaleBitmapByEqualRatio);
                }
            } else if (i5 == 2) {
                bitmapScaleBitmapByEqualRatio = q.e(q.a(bitmapScaleBitmapByEqualRatio, 1.0f, this.brightness, 1.0f));
            }
            this.iv.setImageBitmap(bitmapScaleBitmapByEqualRatio);
            this.oldDefinition = this.definition;
            this.oldBrightness = this.brightness;
            this.oldContrast = this.contrast;
            this.oldSaturation = this.saturation;
            this.oldImageDisplayMode = this.imageDisplayMode;
            this.oldContent = this.content;
            this.isRenderingCompleted = true;
        } catch (Exception unused) {
            this.iv.setImageDrawable(null);
            if (this.pictureToastShown) {
                return;
            }
            this.pictureToastShown = true;
            p042h2.d.show(g.toast_label_picture_removed);
        }
    }

    public void copyFrom(PrinterLabelPictureView printerLabelPictureView) {
        this.curBitmapUrl = printerLabelPictureView.curBitmapUrl;
        this.curBitmap = printerLabelPictureView.curBitmap;
        this.brightness = printerLabelPictureView.brightness;
        this.contrast = printerLabelPictureView.contrast;
        this.saturation = printerLabelPictureView.saturation;
        this.definition = printerLabelPictureView.definition;
        this.picType = printerLabelPictureView.picType;
        int i5 = printerLabelPictureView.imageDisplayMode;
        if (i5 == 0) {
            this.imageDisplayMode = 1;
        } else {
            this.imageDisplayMode = i5;
        }
        updateImage();
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int defaultHeight() {
        return 200;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int defaultWidth() {
        return 200;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int elementType() {
        return 6;
    }

    public String getContent() {
        return this.content;
    }

    public String getFileName() {
        p051j0.a.d("t", this.content);
        String realFilePath = getRealFilePath(Uri.parse(this.content));
        return realFilePath.substring(realFilePath.lastIndexOf(PackagingURIHelper.FORWARD_SLASH_STRING) + 1);
    }

    public String getFilePath() {
        return getRealFilePath(Uri.parse(this.content));
    }

    public ImageView getIv() {
        return this.iv;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public JSONObject getJson() {
        super.getJson();
        try {
            this.saveObject.put(FirebaseAnalytics.Param.CONTENT, this.content);
            this.saveObject.put("definition", this.definition);
            this.saveObject.put("brightness", this.realBrightness);
            this.saveObject.put("contrast", this.realContrast);
            this.saveObject.put("saturation", this.realSaturation);
            this.saveObject.put("isTile", this.isTile);
            this.saveObject.put("picType", this.picType);
            this.saveObject.put("imageDisplayMode", this.imageDisplayMode);
        } catch (JSONException e) {
            p051j0.a.d(this.TAG, e.toString());
        }
        return this.saveObject;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0057  */
    /* JADX WARN: Code duplicated, block: B:26:0x0076  */
    /* JADX WARN: Code duplicated, block: B:28:0x007b  */
    /* JADX WARN: Code duplicated, block: B:30:0x008f A[RETURN] */
    public String getRealFilePath(Uri uri) {
        Uri uri2;
        int columnIndex;
        String string = null;
        if (uri == null) {
            return null;
        }
        String scheme = uri.getScheme();
        if (scheme != null && !Constants.FILE.equals(scheme)) {
            if (FirebaseAnalytics.Param.CONTENT.equals(scheme)) {
                uri2 = uri;
                Cursor cursorQuery = getContext().getContentResolver().query(uri2, new String[]{"_data"}, null, null, null);
                if (cursorQuery != null) {
                    if (cursorQuery.moveToFirst() && (columnIndex = cursorQuery.getColumnIndex("_data")) > -1) {
                        string = cursorQuery.getString(columnIndex);
                    }
                    cursorQuery.close();
                }
            }
            if (TextUtils.isEmpty(string)) {
                return string;
            }
            String string2 = uri2.toString();
            String strSubstring = string2.substring(string2.lastIndexOf(PackagingURIHelper.FORWARD_SLASH_STRING));
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), strSubstring);
            return file.exists() ? file.getAbsolutePath() : new File(getContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES), strSubstring).getAbsolutePath();
        }
        string = uri.getPath();
        uri2 = uri;
        if (TextUtils.isEmpty(string)) {
            return string;
        }
        String string3 = uri2.toString();
        String strSubstring2 = string3.substring(string3.lastIndexOf(PackagingURIHelper.FORWARD_SLASH_STRING));
        File file2 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), strSubstring2);
        if (file2.exists()) {
        }
    }

    public boolean isUploadFile() {
        return this.content.startsWith("content:") || this.content.startsWith("file:") || this.content.startsWith(PackagingURIHelper.FORWARD_SLASH_STRING);
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int layoutId() {
        return e.printer_label_picture_view;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int minHeight() {
        return 100;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public int minWidth() {
        return 100;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public void onSizeChanged(int i5, int i6) {
        super.onSizeChanged(i5, i6);
        updateView();
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public void recoverFromJson(JSONObject jSONObject) {
        super.recoverFromJson(jSONObject);
        try {
            this.content = getObjectString(jSONObject, FirebaseAnalytics.Param.CONTENT, "");
            this.definition = getObjectInt(jSONObject, "definition", 128);
            this.brightness = getObjectInt(jSONObject, "brightness", 0);
            this.contrast = getObjectInt(jSONObject, "contrast", 50);
            this.saturation = getObjectInt(jSONObject, "saturation", 50);
            this.isTile = getObjectBoolean(jSONObject, "isTile");
            this.picType = getObjectInt(jSONObject, "picType", 1);
            this.imageDisplayMode = getObjectInt(jSONObject, "imageDisplayMode", 0);
            this.realBrightness = this.brightness;
            this.realContrast = this.contrast;
            this.realSaturation = this.saturation;
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.pictureToastShown = false;
        this.isRenderingCompleted = false;
        updateView();
    }

    public void setPicType(int i5) {
        this.picType = i5;
    }

    public void setUploadContent(String str) {
        this.content = str;
        this.pictureToastShown = false;
        updateView();
    }

    public void updateBrightness(int i5) {
        this.brightness = i5;
        updateImage();
    }

    public void updateContentToUrl(String str) {
        this.content = str;
        this.curBitmapUrl = str;
        this.pictureToastShown = false;
    }

    public void updateContrast(int i5) {
        this.contrast = i5;
        updateImage();
    }

    public void updateSaturation(int i5) {
        this.saturation = i5;
        updateImage();
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView
    public void updateView() {
        setControlType(2);
        if (this.isTile) {
            this.iv.setScaleType(ImageView.ScaleType.FIT_XY);
        } else if (C1849c.getScale() == 1.0d) {
            this.iv.setScaleType(ImageView.ScaleType.CENTER);
        } else {
            this.iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        removeCallbacks(this.loadNetworkPicRunnable);
        post(this.loadNetworkPicRunnable);
        super.updateView();
    }

    public PrinterLabelPictureView(TemplatePageView templatePageView, boolean z6) {
        super(templatePageView);
        this.TAG = "PrinterLabelPictureView";
        this.iv = null;
        this.oldContent = null;
        this.oldDefinition = 0;
        this.oldBrightness = 0;
        this.oldContrast = 50;
        this.oldSaturation = 50;
        this.oldImageDisplayMode = 1;
        this.oldWidth = 0L;
        this.oldHeight = 0L;
        this.content = null;
        this.definition = 128;
        this.brightness = 0;
        this.contrast = 50;
        this.saturation = 50;
        this.realBrightness = 0;
        this.realContrast = 50;
        this.realSaturation = 50;
        this.width = 0L;
        this.height = 0L;
        this.curBitmap = null;
        this.curBitmapUrl = null;
        this.pictureToastShown = false;
        this.isTile = false;
        this.picType = 1;
        this.imageDisplayMode = 0;
        this.loadNetworkPicRunnable = new Runnable() { // from class: com.appdev.standard.page.printerlabel.widget.PrinterLabelPictureView.1
            @Override // java.lang.Runnable
            public void run() {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) PrinterLabelPictureView.this.mRoot.getLayoutParams();
                PrinterLabelPictureView.this.width = layoutParams.width;
                PrinterLabelPictureView.this.height = layoutParams.height;
                if (PrinterLabelPictureView.this.width <= 0 || PrinterLabelPictureView.this.height <= 0) {
                    PrinterLabelPictureView printerLabelPictureView = PrinterLabelPictureView.this;
                    printerLabelPictureView.postDelayed(printerLabelPictureView.loadNetworkPicRunnable, 500L);
                } else {
                    if (PrinterLabelPictureView.this.curBitmapUrl != null && PrinterLabelPictureView.this.curBitmapUrl.equals(PrinterLabelPictureView.this.content)) {
                        PrinterLabelPictureView.this.updateImage();
                        return;
                    }
                    p051j0.a.d(PrinterLabelPictureView.this.TAG, "加载网络图片:" + PrinterLabelPictureView.this.content);
                    com.bumptech.glide.c.with(PrinterLabelPictureView.this.getContext()).asBitmap().load(PrinterLabelPictureView.this.content).into(new com.bumptech.glide.request.target.c() { // from class: com.appdev.standard.page.printerlabel.widget.PrinterLabelPictureView.1.1
                        @Override // com.bumptech.glide.request.target.c, com.bumptech.glide.request.target.k
                        @SuppressLint({"ClickableViewAccessibility"})
                        public void onResourceReady(@NonNull Bitmap bitmap, @Nullable d dVar) {
                            PrinterLabelPictureView.this.curBitmap = bitmap;
                            PrinterLabelPictureView printerLabelPictureView2 = PrinterLabelPictureView.this;
                            printerLabelPictureView2.curBitmapUrl = printerLabelPictureView2.content;
                            PrinterLabelPictureView.this.updateImage();
                            p051j0.a.d(PrinterLabelPictureView.this.TAG, "图片加载完毕");
                        }

                        @Override // com.bumptech.glide.request.target.c, com.bumptech.glide.request.target.k
                        public void onLoadCleared(@Nullable Drawable drawable) {
                        }
                    });
                }
            }
        };
        this.KEY_CONTENT = FirebaseAnalytics.Param.CONTENT;
        this.KEY_DEFINITION = "definition";
        this.KEY_BRIGHTNESS = "brightness";
        this.KEY_CONTRAST = "contrast";
        this.KEY_SATURATION = "saturation";
        this.KEY_TILE = "isTile";
        this.KEY_PIC_TYPE = "picType";
        this.KEY_IMAGE_DISPLAY_MODE = "imageDisplayMode";
        this.iv = (ImageView) findViewById(p113u.d.iv_picture);
        if (z6) {
            updateView();
        }
    }
}
