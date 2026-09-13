package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;

/* JADX INFO: renamed from: com.bumptech.glide.load.resource.bitmap.t, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C0524t {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final p126w0.u f3121h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final p126w0.u f3122i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final V1.b f3123j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Queue f3124k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.c f3125a;
    public final DisplayMetrics b;
    public final com.bumptech.glide.load.engine.bitmap_recycle.a c;
    public final List d;
    public final C0530z e = C0530z.a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final p126w0.u f3119f = p126w0.u.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", p126w0.b.c);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final p126w0.u f3120g = p126w0.u.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace");

    @Deprecated
    public static final p126w0.u DOWNSAMPLE_STRATEGY = r.f3117f;

    static {
        Boolean bool = Boolean.FALSE;
        f3121h = p126w0.u.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        f3122i = p126w0.u.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
        Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
        f3123j = new V1.b(13);
        Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser$ImageType.JPEG, ImageHeaderParser$ImageType.PNG_A, ImageHeaderParser$ImageType.PNG));
        f3124k = L0.s.createQueue(0);
    }

    public C0524t(List list, DisplayMetrics displayMetrics, com.bumptech.glide.load.engine.bitmap_recycle.c cVar, com.bumptech.glide.load.engine.bitmap_recycle.a aVar) {
        this.d = list;
        this.b = (DisplayMetrics) L0.q.checkNotNull(displayMetrics);
        this.f3125a = (com.bumptech.glide.load.engine.bitmap_recycle.c) L0.q.checkNotNull(cVar);
        this.c = (com.bumptech.glide.load.engine.bitmap_recycle.a) L0.q.checkNotNull(aVar);
    }

    public static void a(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.inPreferredColorSpace = null;
        options.outColorSpace = null;
        options.outConfig = null;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    private static void calculateScaling(ImageHeaderParser$ImageType imageHeaderParser$ImageType, F f6, InterfaceC0523s interfaceC0523s, com.bumptech.glide.load.engine.bitmap_recycle.c cVar, r rVar, int i5, int i6, int i7, int i8, int i9, BitmapFactory.Options options) {
        int i10;
        int i11;
        float f7;
        int i12;
        int iFloor;
        int iFloor2;
        if (i6 <= 0 || i7 <= 0) {
            if (Log.isLoggable("Downsampler", 3)) {
                Log.d("Downsampler", "Unable to determine dimensions for: " + imageHeaderParser$ImageType + " with target [" + i8 + "x" + i9 + "]");
                return;
            }
            return;
        }
        if (i5 == 90 || i5 == 270) {
            i10 = i6;
            i11 = i7;
        } else {
            i11 = i6;
            i10 = i7;
        }
        float fB = rVar.b(i11, i10, i8, i9);
        if (fB <= 0.0f) {
            StringBuilder sb = new StringBuilder("Cannot scale with factor: ");
            sb.append(fB);
            sb.append(" from: ");
            sb.append(rVar);
            sb.append(", source: [");
            androidx.exifinterface.media.a.y(sb, i6, "x", i7, "], target: [");
            sb.append(i8);
            sb.append("x");
            sb.append(i9);
            sb.append("]");
            throw new IllegalArgumentException(sb.toString());
        }
        int iA = rVar.a(i11, i10, i8, i9);
        if (iA == 0) {
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        float f8 = i11;
        float f9 = i10;
        int i13 = i11;
        int i14 = i10;
        int i15 = i13 / ((int) (((double) (fB * f8)) + 0.5d));
        int i16 = i14 / ((int) (((double) (fB * f9)) + 0.5d));
        int iMax = Math.max(1, Integer.highestOneBit(iA == 1 ? Math.max(i15, i16) : Math.min(i15, i16)));
        if (iA == 1 && iMax < 1.0f / fB) {
            iMax <<= 1;
        }
        options.inSampleSize = iMax;
        if (imageHeaderParser$ImageType == ImageHeaderParser$ImageType.JPEG) {
            float fMin = Math.min(iMax, 8);
            f7 = fB;
            i12 = 0;
            iFloor = (int) Math.ceil(f8 / fMin);
            iFloor2 = (int) Math.ceil(f9 / fMin);
            int i17 = iMax / 8;
            if (i17 > 0) {
                iFloor /= i17;
                iFloor2 /= i17;
            }
        } else {
            f7 = fB;
            i12 = 0;
            if (imageHeaderParser$ImageType == ImageHeaderParser$ImageType.PNG || imageHeaderParser$ImageType == ImageHeaderParser$ImageType.PNG_A) {
                float f10 = iMax;
                iFloor = (int) Math.floor(f8 / f10);
                iFloor2 = (int) Math.floor(f9 / f10);
            } else if (imageHeaderParser$ImageType.isWebp()) {
                float f11 = iMax;
                iFloor = Math.round(f8 / f11);
                iFloor2 = Math.round(f9 / f11);
            } else if (i13 % iMax == 0 && i14 % iMax == 0) {
                iFloor = i13 / iMax;
                iFloor2 = i14 / iMax;
            } else {
                int[] dimensions = getDimensions(f6, options, interfaceC0523s, cVar);
                iFloor = dimensions[0];
                iFloor2 = dimensions[1];
            }
        }
        double dB = rVar.b(iFloor, iFloor2, i8, i9);
        int iRound = (int) Math.round((dB <= 1.0d ? dB : 1.0d / dB) * 2.147483647E9d);
        int i18 = (int) ((((double) iRound) * dB) + 0.5d);
        options.inTargetDensity = (int) (((dB / ((double) (i18 / iRound))) * ((double) i18)) + 0.5d);
        int iRound2 = (int) Math.round((dB <= 1.0d ? dB : 1.0d / dB) * 2.147483647E9d);
        options.inDensity = iRound2;
        int i19 = options.inTargetDensity;
        if (i19 <= 0 || iRound2 <= 0 || i19 == iRound2) {
            int i20 = i12;
            options.inTargetDensity = i20;
            options.inDensity = i20;
        } else {
            options.inScaled = true;
        }
        if (Log.isLoggable("Downsampler", 2)) {
            StringBuilder sbS = androidx.collection.a.s("Calculate scaling, source: [", i6, i7, "x", "], degreesToRotate: ");
            androidx.exifinterface.media.a.y(sbS, i5, ", target: [", i8, "x");
            androidx.exifinterface.media.a.y(sbS, i9, "], power of two scaled: [", iFloor, "x");
            sbS.append(iFloor2);
            sbS.append("], exact scale factor: ");
            sbS.append(f7);
            sbS.append(", power of 2 sample size: ");
            sbS.append(iMax);
            sbS.append(", adjusted scale factor: ");
            sbS.append(dB);
            sbS.append(", target density: ");
            sbS.append(options.inTargetDensity);
            sbS.append(", density: ");
            sbS.append(options.inDensity);
            Log.v("Downsampler", sbS.toString());
        }
    }

    private Bitmap decodeFromWrappedStreams(F f6, BitmapFactory.Options options, r rVar, p126w0.b bVar, p126w0.w wVar, boolean z6, int i5, int i6, boolean z7, InterfaceC0523s interfaceC0523s) {
        int i7;
        boolean z8;
        int i8;
        int i9;
        int i10;
        int iRound;
        int iRound2;
        int i11;
        com.bumptech.glide.load.engine.bitmap_recycle.c cVar;
        ColorSpace colorSpace;
        boolean zHasAlpha;
        long logTime = L0.l.getLogTime();
        com.bumptech.glide.load.engine.bitmap_recycle.c cVar2 = this.f3125a;
        int[] dimensions = getDimensions(f6, options, interfaceC0523s, cVar2);
        boolean z9 = false;
        int i12 = dimensions[0];
        int i13 = dimensions[1];
        String str = options.outMimeType;
        boolean z10 = (i12 == -1 || i13 == -1) ? false : z6;
        int imageOrientation = f6.getImageOrientation();
        Paint paint = T.f3097a;
        switch (imageOrientation) {
            case 3:
            case 4:
                i7 = 180;
                break;
            case 5:
            case 6:
                i7 = 90;
                break;
            case 7:
            case 8:
                i7 = 270;
                break;
            default:
                i7 = 0;
                break;
        }
        switch (imageOrientation) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                z8 = true;
                break;
            default:
                z8 = false;
                break;
        }
        boolean z11 = z10;
        if (i5 == Integer.MIN_VALUE) {
            if (i7 != 90) {
                i8 = 270;
                if (i7 != 270) {
                    i9 = i12;
                }
            } else {
                i8 = 270;
            }
            i9 = i13;
        } else {
            i8 = 270;
            i9 = i5;
        }
        if (i6 == Integer.MIN_VALUE) {
            i10 = (i7 == 90 || i7 == i8) ? i12 : i13;
        } else {
            i10 = i6;
        }
        calculateScaling(f6.getImageType(), f6, interfaceC0523s, this.f3125a, rVar, i7, i12, i13, i9, i10, options);
        int i14 = i9;
        int i15 = i10;
        if (!this.e.setHardwareConfigIfAllowed(i14, i15, options, z11, z8)) {
            if (bVar != p126w0.b.f8803a) {
                try {
                    zHasAlpha = f6.getImageType().hasAlpha();
                } catch (IOException e) {
                    if (Log.isLoggable("Downsampler", 3)) {
                        Log.d("Downsampler", "Cannot determine whether the image has alpha or not from header, format " + bVar, e);
                    }
                    zHasAlpha = false;
                }
                Bitmap.Config config = zHasAlpha ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
                options.inPreferredConfig = config;
                if (config == Bitmap.Config.RGB_565) {
                    options.inDither = true;
                }
            } else {
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            }
        }
        int i16 = Build.VERSION.SDK_INT;
        if (i12 < 0 || i13 < 0 || !z7) {
            int i17 = options.inTargetDensity;
            float f7 = i17 > 0 && (i11 = options.inDensity) > 0 && i17 != i11 ? i17 / options.inDensity : 1.0f;
            int i18 = options.inSampleSize;
            float f8 = i18;
            int iCeil = (int) Math.ceil(i12 / f8);
            int iCeil2 = (int) Math.ceil(i13 / f8);
            iRound = Math.round(iCeil * f7);
            iRound2 = Math.round(iCeil2 * f7);
            if (Log.isLoggable("Downsampler", 2)) {
                StringBuilder sbS = androidx.collection.a.s("Calculated target [", iRound, iRound2, "x", "] for source [");
                androidx.exifinterface.media.a.y(sbS, i12, "x", i13, "], sampleSize: ");
                sbS.append(i18);
                sbS.append(", targetDensity: ");
                sbS.append(options.inTargetDensity);
                sbS.append(", density: ");
                sbS.append(options.inDensity);
                sbS.append(", density multiplier: ");
                sbS.append(f7);
                Log.v("Downsampler", sbS.toString());
            }
        } else {
            iRound = i14;
            iRound2 = i15;
        }
        if (iRound <= 0 || iRound2 <= 0) {
            cVar = cVar2;
        } else {
            cVar = cVar2;
            setInBitmap(options, cVar, iRound, iRound2);
        }
        if (wVar != null) {
            if (i16 >= 28) {
                if (wVar == p126w0.w.f8814a && (colorSpace = options.outColorSpace) != null && colorSpace.isWideGamut()) {
                    z9 = true;
                }
                options.inPreferredColorSpace = ColorSpace.get(z9 ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB);
            } else {
                options.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
            }
        }
        Bitmap bitmapDecodeStream = decodeStream(f6, options, interfaceC0523s, cVar);
        interfaceC0523s.onDecodeComplete(cVar, bitmapDecodeStream);
        if (Log.isLoggable("Downsampler", 2)) {
            StringBuilder sb = new StringBuilder("Decoded ");
            sb.append(getBitmapString(bitmapDecodeStream));
            sb.append(" from [");
            sb.append(i12);
            sb.append("x");
            androidx.exifinterface.media.a.z(sb, i13, "] ", str, " with inBitmap ");
            sb.append(getBitmapString(options.inBitmap));
            sb.append(" for [");
            sb.append(i5);
            sb.append("x");
            sb.append(i6);
            sb.append("], sample size: ");
            sb.append(options.inSampleSize);
            sb.append(", density: ");
            sb.append(options.inDensity);
            sb.append(", target density: ");
            sb.append(options.inTargetDensity);
            sb.append(", thread: ");
            sb.append(Thread.currentThread().getName());
            sb.append(", duration: ");
            sb.append(L0.l.a(logTime));
            Log.v("Downsampler", sb.toString());
        }
        if (bitmapDecodeStream == null) {
            return null;
        }
        bitmapDecodeStream.setDensity(this.b.densityDpi);
        Bitmap bitmapRotateImageExif = T.rotateImageExif(cVar, bitmapDecodeStream, imageOrientation);
        if (bitmapDecodeStream.equals(bitmapRotateImageExif)) {
            return bitmapRotateImageExif;
        }
        cVar.b(bitmapDecodeStream);
        return bitmapRotateImageExif;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:?, code lost:
    
        throw r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.graphics.Bitmap decodeStream(com.bumptech.glide.load.resource.bitmap.F r9, android.graphics.BitmapFactory.Options r10, com.bumptech.glide.load.resource.bitmap.InterfaceC0523s r11, com.bumptech.glide.load.engine.bitmap_recycle.c r12) {
        /*
            java.lang.String r0 = "Downsampler"
            boolean r1 = r10.inJustDecodeBounds
            if (r1 != 0) goto Lc
            r11.b()
            r9.a()
        Lc:
            int r1 = r10.outWidth
            int r2 = r10.outHeight
            java.lang.String r3 = r10.outMimeType
            java.util.concurrent.locks.Lock r4 = com.bumptech.glide.load.resource.bitmap.T.d
            r4.lock()
            android.graphics.Bitmap r9 = r9.decodeBitmap(r10)     // Catch: java.lang.IllegalArgumentException -> L1f java.lang.Throwable -> L66
            r4.unlock()
            return r9
        L1f:
            r4 = move-exception
            java.io.IOException r5 = new java.io.IOException     // Catch: java.lang.Throwable -> L66
            java.lang.String r6 = "Exception decoding bitmap, outWidth: "
            java.lang.String r7 = ", outHeight: "
            java.lang.String r8 = ", outMimeType: "
            java.lang.StringBuilder r1 = androidx.collection.a.s(r6, r1, r2, r7, r8)     // Catch: java.lang.Throwable -> L66
            r1.append(r3)     // Catch: java.lang.Throwable -> L66
            java.lang.String r2 = ", inBitmap: "
            r1.append(r2)     // Catch: java.lang.Throwable -> L66
            android.graphics.Bitmap r2 = r10.inBitmap     // Catch: java.lang.Throwable -> L66
            java.lang.String r2 = getBitmapString(r2)     // Catch: java.lang.Throwable -> L66
            r1.append(r2)     // Catch: java.lang.Throwable -> L66
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L66
            r5.<init>(r1, r4)     // Catch: java.lang.Throwable -> L66
            r1 = 3
            boolean r1 = android.util.Log.isLoggable(r0, r1)     // Catch: java.lang.Throwable -> L66
            if (r1 == 0) goto L50
            java.lang.String r1 = "Failed to decode with inBitmap, trying again without Bitmap re-use"
            android.util.Log.d(r0, r1, r5)     // Catch: java.lang.Throwable -> L66
        L50:
            android.graphics.Bitmap r0 = r10.inBitmap     // Catch: java.lang.Throwable -> L66
            if (r0 == 0) goto L65
            r12.b(r0)     // Catch: java.io.IOException -> L64 java.lang.Throwable -> L66
            r0 = 0
            r10.inBitmap = r0     // Catch: java.io.IOException -> L64 java.lang.Throwable -> L66
            android.graphics.Bitmap r9 = decodeStream(r9, r10, r11, r12)     // Catch: java.io.IOException -> L64 java.lang.Throwable -> L66
            java.util.concurrent.locks.Lock r10 = com.bumptech.glide.load.resource.bitmap.T.d
            r10.unlock()
            return r9
        L64:
            throw r5     // Catch: java.lang.Throwable -> L66
        L65:
            throw r5     // Catch: java.lang.Throwable -> L66
        L66:
            r9 = move-exception
            java.util.concurrent.locks.Lock r10 = com.bumptech.glide.load.resource.bitmap.T.d
            r10.unlock()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.C0524t.decodeStream(com.bumptech.glide.load.resource.bitmap.F, android.graphics.BitmapFactory$Options, com.bumptech.glide.load.resource.bitmap.s, com.bumptech.glide.load.engine.bitmap_recycle.c):android.graphics.Bitmap");
    }

    @Nullable
    @TargetApi(19)
    private static String getBitmapString(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + ")");
    }

    private static int[] getDimensions(F f6, BitmapFactory.Options options, InterfaceC0523s interfaceC0523s, com.bumptech.glide.load.engine.bitmap_recycle.c cVar) {
        options.inJustDecodeBounds = true;
        decodeStream(f6, options, interfaceC0523s, cVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    @TargetApi(26)
    private static void setInBitmap(BitmapFactory.Options options, com.bumptech.glide.load.engine.bitmap_recycle.c cVar, int i5, int i6) {
        Bitmap.Config config = options.inPreferredConfig;
        if (config == Bitmap.Config.HARDWARE) {
            return;
        }
        Bitmap.Config config2 = options.outConfig;
        if (config2 != null) {
            config = config2;
        }
        options.inBitmap = cVar.getDirty(i5, i6, config);
    }

    public com.bumptech.glide.load.engine.O decode(InputStream inputStream, int i5, int i6, p126w0.v vVar) {
        return decode(inputStream, i5, i6, vVar, f3123j);
    }

    public com.bumptech.glide.load.engine.O decode(ByteBuffer byteBuffer, int i5, int i6, p126w0.v vVar) {
        return decode(new B(this.d, byteBuffer, this.c), i5, i6, vVar, f3123j);
    }

    public com.bumptech.glide.load.engine.O decode(InputStream inputStream, int i5, int i6, p126w0.v vVar, InterfaceC0523s interfaceC0523s) {
        return decode(new D(this.d, inputStream, this.c), i5, i6, vVar, interfaceC0523s);
    }

    @VisibleForTesting
    public void decode(byte[] bArr, int i5, int i6, p126w0.v vVar) {
        decode(new A(bArr, this.d, this.c), i5, i6, vVar, f3123j);
    }

    @VisibleForTesting
    public void decode(File file, int i5, int i6, p126w0.v vVar) {
        decode(new C(file, this.d, this.c), i5, i6, vVar, f3123j);
    }

    @RequiresApi(21)
    public com.bumptech.glide.load.engine.O decode(ParcelFileDescriptor parcelFileDescriptor, int i5, int i6, p126w0.v vVar) {
        return decode(new E(parcelFileDescriptor, this.d, this.c), i5, i6, vVar, f3123j);
    }

    private com.bumptech.glide.load.engine.O decode(F f6, int i5, int i6, p126w0.v vVar, InterfaceC0523s interfaceC0523s) {
        Queue queue;
        BitmapFactory.Options options;
        byte[] bArr = (byte[]) ((com.bumptech.glide.load.engine.bitmap_recycle.j) this.c).c(65536, byte[].class);
        synchronized (C0524t.class) {
            queue = f3124k;
            synchronized (queue) {
                options = (BitmapFactory.Options) queue.poll();
            }
            if (options == null) {
                options = new BitmapFactory.Options();
                a(options);
            }
        }
        options.inTempStorage = bArr;
        p126w0.b bVar = (p126w0.b) vVar.get(f3119f);
        p126w0.w wVar = (p126w0.w) vVar.get(f3120g);
        r rVar = (r) vVar.get(r.f3117f);
        boolean zBooleanValue = ((Boolean) vVar.get(f3121h)).booleanValue();
        p126w0.u uVar = f3122i;
        try {
            C0510e c0510eObtain = C0510e.obtain(decodeFromWrappedStreams(f6, options, rVar, bVar, wVar, vVar.get(uVar) != null && ((Boolean) vVar.get(uVar)).booleanValue(), i5, i6, zBooleanValue, interfaceC0523s), this.f3125a);
            a(options);
            synchronized (queue) {
                queue.offer(options);
            }
            return c0510eObtain;
        } finally {
            a(options);
            Queue queue2 = f3124k;
            synchronized (queue2) {
                queue2.offer(options);
                ((com.bumptech.glide.load.engine.bitmap_recycle.j) this.c).g(bArr);
            }
        }
    }
}
