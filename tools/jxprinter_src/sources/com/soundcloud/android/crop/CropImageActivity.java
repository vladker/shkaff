package com.soundcloud.android.crop;

import P2.a;
import R2.b;
import R2.c;
import R2.d;
import R2.e;
import R2.h;
import R2.i;
import R2.k;
import R2.l;
import R2.m;
import R2.o;
import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.net.Uri;
import android.opengl.GLES10;
import android.os.Bundle;
import android.os.Handler;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.bumptech.glide.f;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class CropImageActivity extends i {
    private static final int SIZE_DEFAULT = 2048;
    private static final int SIZE_LIMIT = 4096;
    private int aspectX;
    private int aspectY;
    private e cropView;
    private int exifRotation;
    private final Handler handler = new Handler();
    private CropImageView imageView;
    private boolean isSaving;
    private int maxX;
    private int maxY;
    private o rotateBitmap;
    private int sampleSize;
    private Uri saveUri;
    private Uri sourceUri;

    private int calculateBitmapSampleSize(Uri uri) throws Throwable {
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i5 = 1;
        options.inJustDecodeBounds = true;
        InputStream inputStream = null;
        try {
            InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(uri);
            try {
                BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
                d.closeSilently(inputStreamOpenInputStream);
                int maxImageSize = getMaxImageSize();
                while (true) {
                    if (options.outHeight / i5 <= maxImageSize && options.outWidth / i5 <= maxImageSize) {
                        return i5;
                    }
                    i5 <<= 1;
                }
            } catch (Throwable th) {
                th = th;
                inputStream = inputStreamOpenInputStream;
                d.closeSilently(inputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void clearImageView() {
        Bitmap bitmap;
        CropImageView cropImageView = this.imageView;
        cropImageView.getClass();
        cropImageView.e(new o(null, 0));
        o oVar = this.rotateBitmap;
        if (oVar != null && (bitmap = oVar.f611a) != null) {
            bitmap.recycle();
            oVar.f611a = null;
        }
        System.gc();
    }

    private Bitmap decodeRegionCrop(Rect rect, int i5, int i6) throws Throwable {
        InputStream inputStream;
        Bitmap bitmap;
        Rect rect2;
        Bitmap bitmap2;
        clearImageView();
        try {
            try {
                InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(this.sourceUri);
                try {
                    try {
                        BitmapRegionDecoder bitmapRegionDecoderNewInstance = BitmapRegionDecoder.newInstance(inputStreamOpenInputStream, false);
                        int width = bitmapRegionDecoderNewInstance.getWidth();
                        int height = bitmapRegionDecoderNewInstance.getHeight();
                        if (this.exifRotation != 0) {
                            Matrix matrix = new Matrix();
                            matrix.setRotate(-this.exifRotation);
                            RectF rectF = new RectF();
                            matrix.mapRect(rectF, new RectF(rect));
                            rectF.offset(rectF.left < 0.0f ? width : 0.0f, rectF.top < 0.0f ? height : 0.0f);
                            rect2 = new Rect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                        } else {
                            rect2 = rect;
                        }
                        try {
                            Bitmap bitmapDecodeRegion = bitmapRegionDecoderNewInstance.decodeRegion(rect2, new BitmapFactory.Options());
                            try {
                                if (rect2.width() > i5 || rect2.height() > i6) {
                                    Matrix matrix2 = new Matrix();
                                    matrix2.postScale(i5 / rect2.width(), i6 / rect2.height());
                                    bitmapDecodeRegion = Bitmap.createBitmap(bitmapDecodeRegion, 0, 0, bitmapDecodeRegion.getWidth(), bitmapDecodeRegion.getHeight(), matrix2, true);
                                }
                                d.closeSilently(inputStreamOpenInputStream);
                                return bitmapDecodeRegion;
                            } catch (IOException e) {
                                e = e;
                                inputStream = inputStreamOpenInputStream;
                                bitmap = bitmapDecodeRegion;
                                f.e("Error cropping image: " + e.getMessage(), e);
                                setResultException(e);
                                d.closeSilently(inputStream);
                                return bitmap;
                            } catch (IllegalArgumentException e6) {
                                e = e6;
                                bitmap2 = bitmapDecodeRegion;
                                try {
                                    throw new IllegalArgumentException("Rectangle " + rect2 + " is outside of the image (" + width + "," + height + "," + this.exifRotation + ")", e);
                                } catch (IOException e7) {
                                    e = e7;
                                    bitmap = bitmap2;
                                    inputStream = inputStreamOpenInputStream;
                                    f.e("Error cropping image: " + e.getMessage(), e);
                                    setResultException(e);
                                    d.closeSilently(inputStream);
                                    return bitmap;
                                } catch (OutOfMemoryError e8) {
                                    e = e8;
                                    bitmap = bitmap2;
                                    inputStream = inputStreamOpenInputStream;
                                    f.e("OOM cropping image: " + e.getMessage(), e);
                                    setResultException(e);
                                    d.closeSilently(inputStream);
                                    return bitmap;
                                }
                            } catch (OutOfMemoryError e9) {
                                e = e9;
                                inputStream = inputStreamOpenInputStream;
                                bitmap = bitmapDecodeRegion;
                                f.e("OOM cropping image: " + e.getMessage(), e);
                                setResultException(e);
                                d.closeSilently(inputStream);
                                return bitmap;
                            }
                        } catch (IllegalArgumentException e10) {
                            e = e10;
                            bitmap2 = null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStreamOpenInputStream;
                        d.closeSilently(inputStream);
                        throw th;
                    }
                } catch (IOException e11) {
                    e = e11;
                    inputStream = inputStreamOpenInputStream;
                    bitmap = null;
                    f.e("Error cropping image: " + e.getMessage(), e);
                    setResultException(e);
                    d.closeSilently(inputStream);
                    return bitmap;
                } catch (OutOfMemoryError e12) {
                    e = e12;
                    inputStream = inputStreamOpenInputStream;
                    bitmap = null;
                    f.e("OOM cropping image: " + e.getMessage(), e);
                    setResultException(e);
                    d.closeSilently(inputStream);
                    return bitmap;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e13) {
            e = e13;
            inputStream = null;
        } catch (OutOfMemoryError e14) {
            e = e14;
            inputStream = null;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
        }
    }

    private int getMaxImageSize() {
        int maxTextureSize = getMaxTextureSize();
        if (maxTextureSize == 0) {
            return 2048;
        }
        return Math.min(maxTextureSize, 4096);
    }

    private int getMaxTextureSize() {
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        return iArr[0];
    }

    private void loadInput() throws Throwable {
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            this.aspectX = extras.getInt("aspect_x");
            this.aspectY = extras.getInt("aspect_y");
            this.maxX = extras.getInt("max_x");
            this.maxY = extras.getInt("max_y");
            this.saveUri = (Uri) extras.getParcelable("output");
        }
        Uri data = intent.getData();
        this.sourceUri = data;
        if (data == null) {
            return;
        }
        File fromMediaUri = d.getFromMediaUri(this, getContentResolver(), this.sourceUri);
        int i5 = 0;
        if (fromMediaUri != null) {
            try {
                int attributeInt = new ExifInterface(fromMediaUri.getAbsolutePath()).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 0);
                if (attributeInt == 3) {
                    i5 = 180;
                } else if (attributeInt == 6) {
                    i5 = 90;
                } else if (attributeInt == 8) {
                    i5 = 270;
                }
            } catch (IOException e) {
                f.e("Error getting Exif data", e);
            }
        }
        this.exifRotation = i5;
        InputStream inputStream = null;
        try {
            try {
                this.sampleSize = calculateBitmapSampleSize(this.sourceUri);
                InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(this.sourceUri);
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = this.sampleSize;
                    this.rotateBitmap = new o(BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options), this.exifRotation);
                    d.closeSilently(inputStreamOpenInputStream);
                } catch (IOException e6) {
                    e = e6;
                    inputStream = inputStreamOpenInputStream;
                    f.e("Error reading image: " + e.getMessage(), e);
                    setResultException(e);
                    d.closeSilently(inputStream);
                } catch (OutOfMemoryError e7) {
                    e = e7;
                    inputStream = inputStreamOpenInputStream;
                    f.e("OOM reading image: " + e.getMessage(), e);
                    setResultException(e);
                    d.closeSilently(inputStream);
                } catch (Throwable th) {
                    th = th;
                    inputStream = inputStreamOpenInputStream;
                    d.closeSilently(inputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e8) {
            e = e8;
        } catch (OutOfMemoryError e9) {
            e = e9;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSaveClicked() throws Throwable {
        int i5;
        e eVar = this.cropView;
        if (eVar == null || this.isSaving) {
            return;
        }
        this.isSaving = true;
        float f6 = this.sampleSize;
        RectF rectF = eVar.f590a;
        Rect rect = new Rect((int) (rectF.left * f6), (int) (rectF.top * f6), (int) (rectF.right * f6), (int) (rectF.bottom * f6));
        int iWidth = rect.width();
        int iHeight = rect.height();
        int i6 = this.maxX;
        if (i6 > 0 && (i5 = this.maxY) > 0 && (iWidth > i6 || iHeight > i5)) {
            float f7 = iWidth / iHeight;
            float f8 = i6;
            float f9 = i5;
            if (f8 / f9 > f7) {
                iWidth = (int) ((f9 * f7) + 0.5f);
                iHeight = i5;
            } else {
                iHeight = (int) ((f8 / f7) + 0.5f);
                iWidth = i6;
            }
        }
        try {
            Bitmap bitmapDecodeRegionCrop = decodeRegionCrop(rect, iWidth, iHeight);
            if (bitmapDecodeRegionCrop != null) {
                this.imageView.e(new o(bitmapDecodeRegionCrop, this.exifRotation));
                this.imageView.a();
                this.imageView.f3767l.clear();
            }
            saveImage(bitmapDecodeRegionCrop);
        } catch (IllegalArgumentException e) {
            setResultException(e);
            finish();
        }
    }

    private void saveImage(Bitmap bitmap) {
        if (bitmap == null) {
            finish();
            return;
        }
        String string = getResources().getString(m.crop__saving);
        new Thread(new c(this, new b(this, bitmap, 0), ProgressDialog.show(this, null, string, true, false), this.handler)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveOutput(Bitmap bitmap) {
        if (this.saveUri != null) {
            OutputStream outputStreamOpenOutputStream = null;
            try {
                try {
                    outputStreamOpenOutputStream = getContentResolver().openOutputStream(this.saveUri);
                    if (outputStreamOpenOutputStream != null) {
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 90, outputStreamOpenOutputStream);
                    }
                } catch (IOException e) {
                    setResultException(e);
                    f.e("Cannot open file: " + this.saveUri, e);
                }
                d.closeSilently(outputStreamOpenOutputStream);
                File fromMediaUri = d.getFromMediaUri(this, getContentResolver(), this.sourceUri);
                File fromMediaUri2 = d.getFromMediaUri(this, getContentResolver(), this.saveUri);
                if (fromMediaUri != null && fromMediaUri2 != null) {
                    try {
                        ExifInterface exifInterface = new ExifInterface(fromMediaUri.getAbsolutePath());
                        ExifInterface exifInterface2 = new ExifInterface(fromMediaUri2.getAbsolutePath());
                        exifInterface2.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, exifInterface.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION));
                        exifInterface2.saveAttributes();
                    } catch (IOException e6) {
                        f.e("Error copying Exif data", e6);
                    }
                }
                setResultUri(this.saveUri);
            } catch (Throwable th) {
                d.closeSilently(outputStreamOpenOutputStream);
                throw th;
            }
        }
        this.handler.post(new b(this, bitmap, 1));
        finish();
    }

    private void setResultException(Throwable th) {
        setResult(Videoio.CAP_PROP_XI_TRG_SOURCE, new Intent().putExtra("error", th));
    }

    private void setResultUri(Uri uri) {
        setResult(-1, new Intent().putExtra("output", uri));
    }

    private void setupViews() {
        setContentView(l.crop__activity_crop);
        CropImageView cropImageView = (CropImageView) findViewById(k.crop_image);
        this.imageView = cropImageView;
        cropImageView.f3769n = this;
        cropImageView.setRecycler(new a(1));
        findViewById(k.btn_cancel).setOnClickListener(new R2.a(this, 0));
        findViewById(k.btn_done).setOnClickListener(new R2.a(this, 1));
    }

    @TargetApi(19)
    private void setupWindowFlags() {
        requestWindowFeature(1);
        getWindow().clearFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
    }

    private void startCrop() {
        if (isFinishing()) {
            return;
        }
        this.imageView.e(this.rotateBitmap);
        String string = getResources().getString(m.crop__wait);
        new Thread(new c(this, new H2.c(this, 1), ProgressDialog.show(this, null, string, true, false), this.handler)).start();
    }

    @Override // R2.i
    public /* bridge */ /* synthetic */ void addLifeCycleListener(h hVar) {
        super.addLifeCycleListener(hVar);
    }

    public boolean isSaving() {
        return this.isSaving;
    }

    @Override // R2.i, android.app.Activity
    public void onCreate(Bundle bundle) throws Throwable {
        super.onCreate(bundle);
        setupWindowFlags();
        setupViews();
        loadInput();
        if (this.rotateBitmap == null) {
            finish();
        } else {
            startCrop();
        }
    }

    @Override // R2.i, android.app.Activity
    public void onDestroy() {
        Bitmap bitmap;
        super.onDestroy();
        o oVar = this.rotateBitmap;
        if (oVar == null || (bitmap = oVar.f611a) == null) {
            return;
        }
        bitmap.recycle();
        oVar.f611a = null;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        return false;
    }

    @Override // R2.i
    public /* bridge */ /* synthetic */ void removeLifeCycleListener(h hVar) {
        super.removeLifeCycleListener(hVar);
    }
}
