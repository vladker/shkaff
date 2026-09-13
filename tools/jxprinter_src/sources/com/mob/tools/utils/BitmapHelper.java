package com.mob.tools.utils;

import A3.AbstractC0157z;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.opengl.GLES10;
import android.text.TextUtils;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import cn.fly.tools.network.HttpConnection;
import cn.fly.tools.network.HttpResponseCallback;
import cn.fly.tools.network.NetworkHelper;
import com.alibaba.android.arouter.utils.Consts;
import com.google.common.net.HttpHeaders;
import com.mob.tools.MobLog;
import com.mob.tools.proguard.PublicMemberKeeper;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.opc.ContentTypes;
import org.apache.poi.ss.formula.ptg.RefErrorPtg;

/* JADX INFO: loaded from: classes3.dex */
public class BitmapHelper implements PublicMemberKeeper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f3666a;
    private static int b;

    static {
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        int iMax = Math.max(iArr[0], 2048);
        f3666a = iMax;
        b = iMax;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(HttpConnection httpConnection, String str) {
        String strG;
        List<String> list;
        int iLastIndexOf;
        List<String> list2;
        Map<String, List<String>> headerFields = httpConnection.getHeaderFields();
        if (headerFields == null || (list2 = headerFields.get(HttpHeaders.CONTENT_DISPOSITION)) == null || list2.size() <= 0) {
            strG = null;
        } else {
            strG = null;
            for (String str2 : list2.get(0).split(";")) {
                if (str2.trim().startsWith("filename")) {
                    String[] strArrSplit = str2.split("=");
                    if (strArrSplit.length >= 2) {
                        strG = strArrSplit[1];
                        if (!TextUtils.isEmpty(strG) && strG.startsWith("\"") && strG.endsWith("\"")) {
                            strG = androidx.collection.a.g(1, 1, strG);
                        }
                    }
                }
            }
        }
        if (strG != null) {
            return strG;
        }
        String strMD5 = Data.MD5(str);
        if (headerFields != null && (list = headerFields.get(HttpHeaders.CONTENT_TYPE)) != null && list.size() > 0) {
            String str3 = list.get(0);
            String strTrim = str3 == null ? "" : str3.trim();
            if (strTrim.startsWith("image/")) {
                String strSubstring = strTrim.substring(6);
                StringBuilder sbX = AbstractC0157z.x(strMD5, Consts.DOT);
                if (ContentTypes.EXTENSION_JPG_2.equals(strSubstring)) {
                    strSubstring = ContentTypes.EXTENSION_JPG_1;
                }
                sbX.append(strSubstring);
                return sbX.toString();
            }
            int iLastIndexOf2 = str.lastIndexOf(47);
            String strSubstring2 = iLastIndexOf2 > 0 ? str.substring(iLastIndexOf2 + 1) : null;
            if (strSubstring2 != null && strSubstring2.length() > 0 && (iLastIndexOf = strSubstring2.lastIndexOf(46)) > 0 && strSubstring2.length() - iLastIndexOf < 10) {
                return androidx.exifinterface.media.a.j(strSubstring2, iLastIndexOf, androidx.collection.a.r(strMD5));
            }
        }
        return strMD5;
    }

    public static Bitmap blur(Bitmap bitmap, int i5, int i6) {
        float f6 = i6;
        int i7 = (int) ((i5 / f6) + 0.5f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) ((bitmap.getWidth() / f6) + 0.5f), (int) ((bitmap.getHeight() / f6) + 0.5f), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        float f7 = 1.0f / f6;
        canvas.scale(f7, f7);
        Paint paint = new Paint();
        paint.setFlags(2);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        a(bitmapCreateBitmap, i7, true);
        return bitmapCreateBitmap;
    }

    public static Bitmap captureView(View view, int i5, int i6) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i5, i6, Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(bitmapCreateBitmap));
        return bitmapCreateBitmap;
    }

    public static Bitmap compressByQuality(Bitmap bitmap, int i5) {
        return compressByQuality(bitmap, i5, false);
    }

    public static Bitmap cropBitmap(Bitmap bitmap, int i5, int i6, int i7, int i8) {
        int width = (bitmap.getWidth() - i5) - i7;
        int height = (bitmap.getHeight() - i6) - i8;
        if (width == bitmap.getWidth() && height == bitmap.getHeight()) {
            return bitmap;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        new Canvas(bitmapCreateBitmap).drawBitmap(bitmap, -i5, -i6, new Paint());
        return bitmapCreateBitmap;
    }

    public static String downloadBitmap(Context context, final String str) {
        final String cachePath = cn.fly.tools.utils.ResHelper.getCachePath(context, "images");
        File file = new File(cachePath, Data.MD5(str));
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        final HashMap map = new HashMap();
        new NetworkHelper().rawGet(str, new HttpResponseCallback() { // from class: com.mob.tools.utils.BitmapHelper.1
            @Override // cn.fly.tools.network.HttpResponseCallback
            public void onResponse(HttpConnection httpConnection) throws Throwable {
                InputStreamReader inputStreamReader;
                int responseCode = httpConnection.getResponseCode();
                Closeable closeable = null;
                if (responseCode == 200) {
                    String strB = BitmapHelper.b(httpConnection, str);
                    File file2 = new File(cachePath, strB);
                    if (!file2.getParentFile().exists()) {
                        file2.getParentFile().mkdirs();
                    }
                    if (file2.exists()) {
                        file2.delete();
                    }
                    try {
                        FilterInputStream filterInputStream = new FilterInputStream(httpConnection.getInputStream()) { // from class: com.mob.tools.utils.BitmapHelper.1.1
                            @Override // java.io.FilterInputStream, java.io.InputStream
                            public long skip(long j6) throws IOException {
                                long j7 = 0;
                                while (j7 < j6) {
                                    long jSkip = ((FilterInputStream) this).in.skip(j6 - j7);
                                    if (jSkip == 0) {
                                        break;
                                    }
                                    j7 += jSkip;
                                }
                                return j7;
                            }
                        };
                        try {
                            Bitmap bitmap = BitmapHelper.getBitmap(filterInputStream, 1);
                            if (bitmap == null || bitmap.isRecycled()) {
                                return;
                            }
                            try {
                                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                                try {
                                    if (strB.toLowerCase().endsWith(".gif") || strB.toLowerCase().endsWith(".png")) {
                                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                                    } else {
                                        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
                                    }
                                    fileOutputStream.flush();
                                    map.put("bitmap", file2.getAbsolutePath());
                                    com.mob.commons.a.a(fileOutputStream);
                                } catch (Throwable th) {
                                    th = th;
                                    closeable = fileOutputStream;
                                    com.mob.commons.a.a(closeable);
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            closeable = filterInputStream;
                            com.mob.commons.a.a(closeable);
                            if (file2.exists()) {
                                file2.delete();
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } else {
                    try {
                        StringBuilder sb = new StringBuilder();
                        inputStreamReader = new InputStreamReader(httpConnection.getErrorStream(), Charset.forName("utf-8"));
                        try {
                            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                            try {
                                for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                                    if (sb.length() > 0) {
                                        sb.append('\n');
                                    }
                                    sb.append(line);
                                }
                                HashMap map2 = new HashMap();
                                map2.put("error", sb.toString());
                                map2.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(responseCode));
                                throw new Throwable(HashonHelper.fromHashMap(map2));
                            } catch (Throwable th5) {
                                th = th5;
                                closeable = bufferedReader;
                                com.mob.commons.a.a(closeable, inputStreamReader);
                                throw th;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        inputStreamReader = null;
                    }
                }
            }
        }, (NetworkHelper.NetworkTimeOut) null);
        return (String) map.get("bitmap");
    }

    public static int[] fixRect(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[2];
        int i5 = iArr[0];
        int i6 = iArr[1];
        float f6 = i5 / i6;
        int i7 = iArr2[0];
        int i8 = iArr2[1];
        if (f6 > i7 / i8) {
            iArr3[0] = i7;
            iArr3[1] = (int) (((i6 * iArr2[0]) / iArr[0]) + 0.5f);
            return iArr3;
        }
        iArr3[1] = i8;
        iArr3[0] = (int) (((i5 * iArr2[1]) / iArr[1]) + 0.5f);
        return iArr3;
    }

    public static int[] fixRect_2(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[2];
        int i5 = iArr[0];
        int i6 = iArr[1];
        float f6 = i5 / i6;
        int i7 = iArr2[0];
        int i8 = iArr2[1];
        if (f6 > i7 / i8) {
            iArr3[1] = i8;
            iArr3[0] = (int) (((i5 * iArr2[1]) / iArr[1]) + 0.5f);
            return iArr3;
        }
        iArr3[0] = i7;
        iArr3[1] = (int) (((i6 * iArr2[0]) / iArr[0]) + 0.5f);
        return iArr3;
    }

    public static Bitmap getBitmap(String str, int i5) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return getBitmap(new File(str), i5);
    }

    public static Bitmap getBitmapByCompressQuality(String str, int i5, int i6, int i7, long j6) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            Bitmap bitmapByCompressSize = getBitmapByCompressSize(str, i5, i6);
            if (i7 < 10 || i7 > 100) {
                i7 = 100;
            }
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                Bitmap.CompressFormat bmpFormat = getBmpFormat(str);
                bitmapByCompressSize.compress(bmpFormat, i7, byteArrayOutputStream2);
                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                if (j6 < 10240) {
                    Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                    com.mob.commons.a.a(byteArrayOutputStream2);
                    return bitmapDecodeByteArray;
                }
                while (byteArray.length > j6 && i7 >= 11) {
                    byteArrayOutputStream2.reset();
                    i7 -= 6;
                    bitmapByCompressSize.compress(bmpFormat, i7, byteArrayOutputStream2);
                    byteArray = byteArrayOutputStream2.toByteArray();
                }
                if (i7 != 100) {
                    bitmapByCompressSize = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                }
                com.mob.commons.a.a(byteArrayOutputStream2);
                return bitmapByCompressSize;
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = byteArrayOutputStream2;
                com.mob.commons.a.a(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static Bitmap getBitmapByCompressSize(String str, int i5, int i6) {
        int i7;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i8 = options.outWidth;
        int i9 = options.outHeight;
        if (i5 <= 1 || i6 <= 1) {
            i7 = 1;
        } else {
            float f6 = 1.0f;
            float fMin = (Math.min(i8, i9) * 1.0f) / Math.min(i5, i6);
            float fMax = (Math.max(i8, i9) * 1.0f) / Math.max(i5, i6);
            float f7 = i8 / i9;
            if (f7 <= 2.0f && f7 >= 0.5d) {
                float fMin2 = Math.min(fMin, fMax);
                while (true) {
                    float f8 = f6 * 2.0f;
                    if (f8 > fMin2) {
                        break;
                    }
                    f6 = f8;
                }
            } else {
                while (true) {
                    float f9 = f6 * 2.0f;
                    if (f9 > fMin) {
                        break;
                    }
                    f6 = f9;
                }
            }
            i7 = (int) f6;
        }
        int i10 = i7 >= 1 ? i7 : 1;
        while (true) {
            if (i8 / i10 <= f3666a && i9 / i10 <= b) {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inPreferredConfig = Bitmap.Config.RGB_565;
                options2.inSampleSize = i10;
                return BitmapFactory.decodeFile(str, options2);
            }
            i10++;
        }
    }

    public static Bitmap.CompressFormat getBmpFormat(byte[] bArr) {
        String strA = a(bArr);
        return (strA == null || !(strA.endsWith(ContentTypes.EXTENSION_PNG) || strA.endsWith(ContentTypes.EXTENSION_GIF))) ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG;
    }

    public static String getMime(String str) throws Throwable {
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    byte[] bArr = new byte[8];
                    fileInputStream2.read(bArr);
                    String strA = a(bArr);
                    com.mob.commons.a.a(fileInputStream2);
                    return strA;
                } catch (Exception e) {
                    e = e;
                    fileInputStream = fileInputStream2;
                    MobLog.getInstance().w(e);
                    com.mob.commons.a.a(fileInputStream);
                    return "";
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    com.mob.commons.a.a(fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e6) {
            e = e6;
        }
    }

    public static boolean isBlackBitmap(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return true;
        }
        int height = bitmap.getHeight() * bitmap.getWidth();
        int[] iArr = new int[height];
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        boolean z6 = false;
        for (int i5 = 0; i5 < height; i5++) {
            if ((iArr[i5] & 16777215) != 0) {
                z6 = true;
                break;
            }
        }
        return !z6;
    }

    public static int mixAlpha(int i5, int i6) {
        int i7 = i5 >>> 24;
        int i8 = 255 - i7;
        return ((((((16711680 & i6) >>> 16) * i8) + (((i5 & 16711680) >>> 16) * i7)) / 255) << 16) | ViewCompat.MEASURED_STATE_MASK | ((((((65280 & i6) >>> 8) * i8) + (((i5 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >>> 8) * i7)) / 255) << 8) | (((i8 * (i6 & 255)) + (i7 * (i5 & 255))) / 255);
    }

    public static Bitmap roundBitmap(Bitmap bitmap, int i5, int i6, float f6, float f7, float f8, float f9) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Rect rect = new Rect(0, 0, width, height);
        Bitmap bitmapCreateBitmap = (width == i5 && height == i6) ? Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888) : Bitmap.createBitmap(i5, i6, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        Rect rect2 = new Rect(0, 0, i5, i6);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        float[] fArr = {f6, f6, f7, f7, f8, f8, f9, f9};
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, new RectF(0.0f, 0.0f, 0.0f, 0.0f), fArr));
        shapeDrawable.setBounds(rect2);
        shapeDrawable.draw(canvas);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect2, paint);
        return bitmapCreateBitmap;
    }

    public static boolean save(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat) {
        return save(bitmap, cn.fly.tools.utils.FileUtils.getFileByPath(str), compressFormat, false);
    }

    public static String saveBitmap(Context context, Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i5) throws Throwable {
        File file = new File(cn.fly.tools.utils.ResHelper.getCachePath(context, "images"), String.valueOf(System.currentTimeMillis()) + (compressFormat == Bitmap.CompressFormat.PNG ? ".png" : ".jpg"));
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                bitmap.compress(compressFormat, i5, fileOutputStream2);
                fileOutputStream2.flush();
                com.mob.commons.a.a(fileOutputStream2);
                return file.getAbsolutePath();
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                com.mob.commons.a.a(fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0008 A[PHI: r7
  0x0008: PHI (r7v5 int) = (r7v1 int), (r7v2 int) binds: [B:3:0x0006, B:6:0x000c] A[DONT_GENERATE, DONT_INLINE]] */
    public static String saveBitmapByCompress(String str, int i5, int i6, int i7) throws Throwable {
        Bitmap bitmapByCompressSize = getBitmapByCompressSize(str, i5, i6);
        int i8 = 100;
        if (i7 > 100) {
            i7 = i8;
        } else {
            i8 = 10;
            if (i7 < 10) {
                i7 = i8;
            }
        }
        Bitmap.CompressFormat bmpFormat = getBmpFormat(str);
        String str2 = bmpFormat == Bitmap.CompressFormat.PNG ? ".png" : ".jpg";
        File file = new File(new File(str).getParent(), String.valueOf(System.currentTimeMillis()) + str2);
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                bitmapByCompressSize.compress(bmpFormat, i7, fileOutputStream2);
                fileOutputStream2.flush();
                com.mob.commons.a.a(fileOutputStream2);
                return file.getAbsolutePath();
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                com.mob.commons.a.a(fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String saveViewToImage(View view) {
        if (view == null) {
            return null;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        if (width <= 0 || height <= 0) {
            return null;
        }
        return saveViewToImage(view, width, height);
    }

    public static Bitmap scaleBitmapByHeight(Context context, int i5, int i6) {
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), i5);
        boolean z6 = i6 != bitmapDecodeResource.getHeight();
        Bitmap bitmapScaleBitmapByHeight = scaleBitmapByHeight(bitmapDecodeResource, i6);
        if (z6) {
            bitmapDecodeResource.recycle();
        }
        return bitmapScaleBitmapByHeight;
    }

    private static Bitmap a(Bitmap bitmap, int i5, boolean z6) {
        int i6;
        int i7 = i5;
        Bitmap bitmapCopy = z6 ? bitmap : bitmap.copy(bitmap.getConfig(), true);
        if (i7 < 1) {
            return null;
        }
        int width = bitmapCopy.getWidth();
        int height = bitmapCopy.getHeight();
        int i8 = width * height;
        int[] iArr = new int[i8];
        bitmapCopy.getPixels(iArr, 0, width, 0, 0, width, height);
        int i9 = width - 1;
        int i10 = height - 1;
        int i11 = i7 + i7;
        int i12 = i11 + 1;
        int[] iArr2 = new int[i8];
        int[] iArr3 = new int[i8];
        int[] iArr4 = new int[i8];
        int[] iArr5 = new int[Math.max(width, height)];
        int i13 = (i11 + 2) >> 1;
        int i14 = i13 * i13;
        int i15 = i14 * 256;
        int[] iArr6 = new int[i15];
        int i16 = 0;
        for (int i17 = 0; i17 < i15; i17++) {
            iArr6[i17] = i17 / i14;
        }
        int[][] iArr7 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i12, 3);
        int i18 = i7 + 1;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        while (i19 < height) {
            int[] iArr8 = iArr6;
            int i22 = -i7;
            int i23 = i16;
            int i24 = i23;
            int i25 = i24;
            int i26 = i25;
            int i27 = i26;
            int i28 = i27;
            int i29 = i28;
            int i30 = i29;
            int i31 = i30;
            while (i22 <= i7) {
                int[] iArr9 = iArr4;
                Bitmap bitmap2 = bitmapCopy;
                int i32 = i16;
                int i33 = iArr[Math.min(i9, Math.max(i22, i32)) + i20];
                int[] iArr10 = iArr7[i22 + i7];
                iArr10[i32] = (i33 & 16711680) >> 16;
                iArr10[1] = (i33 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr10[2] = i33 & 255;
                int iAbs = i18 - Math.abs(i22);
                int i34 = iArr10[i32];
                i31 = (i34 * iAbs) + i31;
                int i35 = iArr10[1];
                i23 = (i35 * iAbs) + i23;
                int i36 = iArr10[2];
                i24 = (iAbs * i36) + i24;
                if (i22 > 0) {
                    i28 += i34;
                    i29 += i35;
                    i30 += i36;
                } else {
                    i25 += i34;
                    i26 += i35;
                    i27 += i36;
                }
                i22++;
                iArr4 = iArr9;
                bitmapCopy = bitmap2;
                i16 = 0;
            }
            int[] iArr11 = iArr4;
            Bitmap bitmap3 = bitmapCopy;
            int i37 = i7;
            int i38 = 0;
            while (i38 < width) {
                iArr2[i20] = iArr8[i31];
                iArr3[i20] = iArr8[i23];
                iArr11[i20] = iArr8[i24];
                int i39 = i31 - i25;
                int i40 = i23 - i26;
                int i41 = i24 - i27;
                int[] iArr12 = iArr7[((i37 - i7) + i12) % i12];
                int i42 = i25 - iArr12[0];
                int i43 = i26 - iArr12[1];
                int i44 = i27 - iArr12[2];
                if (i19 == 0) {
                    i6 = i38;
                    iArr5[i6] = Math.min(i38 + i7 + 1, i9);
                } else {
                    i6 = i38;
                }
                int i45 = iArr[i21 + iArr5[i6]];
                int i46 = (i45 & 16711680) >> 16;
                iArr12[0] = i46;
                int i47 = (i45 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr12[1] = i47;
                int i48 = i45 & 255;
                iArr12[2] = i48;
                int i49 = i28 + i46;
                int i50 = i29 + i47;
                int i51 = i30 + i48;
                i31 = i39 + i49;
                i23 = i40 + i50;
                i24 = i41 + i51;
                i37 = (i37 + 1) % i12;
                int[] iArr13 = iArr7[i37 % i12];
                int i52 = iArr13[0];
                i25 = i42 + i52;
                int i53 = iArr13[1];
                i26 = i43 + i53;
                int i54 = iArr13[2];
                i27 = i44 + i54;
                i28 = i49 - i52;
                i29 = i50 - i53;
                i30 = i51 - i54;
                i20++;
                i38 = i6 + 1;
            }
            i21 += width;
            i19++;
            iArr6 = iArr8;
            iArr4 = iArr11;
            bitmapCopy = bitmap3;
            i16 = 0;
        }
        int[] iArr14 = iArr6;
        int[] iArr15 = iArr4;
        Bitmap bitmap4 = bitmapCopy;
        int i55 = 0;
        while (i55 < width) {
            int i56 = -i7;
            int i57 = i55;
            int i58 = i56 * width;
            int i59 = 0;
            int i60 = 0;
            int i61 = 0;
            int i62 = 0;
            int i63 = 0;
            int i64 = 0;
            int i65 = 0;
            int i66 = 0;
            int i67 = 0;
            while (i56 <= i7) {
                int iMax = Math.max(0, i58) + i57;
                int[] iArr16 = iArr7[i56 + i5];
                iArr16[0] = iArr2[iMax];
                iArr16[1] = iArr3[iMax];
                iArr16[2] = iArr15[iMax];
                int iAbs2 = i18 - Math.abs(i56);
                i67 = (iArr2[iMax] * iAbs2) + i67;
                i59 = (iArr3[iMax] * iAbs2) + i59;
                i60 = (iArr15[iMax] * iAbs2) + i60;
                if (i56 > 0) {
                    i64 += iArr16[0];
                    i65 += iArr16[1];
                    i66 += iArr16[2];
                } else {
                    i61 += iArr16[0];
                    i62 += iArr16[1];
                    i63 += iArr16[2];
                }
                if (i56 < i10) {
                    i58 += width;
                }
                i56++;
                i7 = i5;
            }
            int i68 = i67;
            int i69 = i57;
            int i70 = i5;
            for (int i71 = 0; i71 < height; i71++) {
                iArr[i69] = (iArr[i69] & ViewCompat.MEASURED_STATE_MASK) | (iArr14[i68] << 16) | (iArr14[i59] << 8) | iArr14[i60];
                int i72 = i68 - i61;
                int i73 = i59 - i62;
                int i74 = i60 - i63;
                int[] iArr17 = iArr7[((i70 - i5) + i12) % i12];
                int i75 = i61 - iArr17[0];
                int i76 = i62 - iArr17[1];
                int i77 = i63 - iArr17[2];
                int i78 = i69;
                if (i57 == 0) {
                    iArr5[i71] = Math.min(i71 + i18, i10) * width;
                }
                int i79 = i57 + iArr5[i71];
                int i80 = iArr2[i79];
                iArr17[0] = i80;
                int i81 = iArr3[i79];
                iArr17[1] = i81;
                int i82 = iArr15[i79];
                iArr17[2] = i82;
                int i83 = i64 + i80;
                int i84 = i65 + i81;
                int i85 = i66 + i82;
                i68 = i72 + i83;
                i59 = i73 + i84;
                i60 = i74 + i85;
                i70 = (i70 + 1) % i12;
                int[] iArr18 = iArr7[i70];
                int i86 = iArr18[0];
                i61 = i75 + i86;
                int i87 = iArr18[1];
                i62 = i76 + i87;
                int i88 = iArr18[2];
                i63 = i77 + i88;
                i64 = i83 - i86;
                i65 = i84 - i87;
                i66 = i85 - i88;
                i69 = i78 + width;
            }
            i55 = i57 + 1;
            i7 = i5;
        }
        bitmap4.setPixels(iArr, 0, width, 0, 0, width, height);
        return bitmap4;
    }

    public static Bitmap compressByQuality(Bitmap bitmap, int i5, boolean z6) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = null;
        if (a(bitmap)) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, i5, byteArrayOutputStream2);
                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                if (z6 && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                com.mob.commons.a.a(byteArrayOutputStream2);
                return bitmapDecodeByteArray;
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = byteArrayOutputStream2;
                com.mob.commons.a.a(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean save(Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat, boolean z6) {
        boolean zCompress;
        if (a(bitmap) || !cn.fly.tools.utils.FileUtils.createFileByDeleteOldFile(file)) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
            try {
                zCompress = bitmap.compress(compressFormat, 100, bufferedOutputStream2);
                if (z6) {
                    try {
                        if (!bitmap.isRecycled()) {
                            bitmap.recycle();
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream = bufferedOutputStream2;
                        try {
                            MobLog.getInstance().d(th);
                            com.mob.commons.a.a(bufferedOutputStream);
                            return zCompress;
                        } catch (Throwable th2) {
                            com.mob.commons.a.a(bufferedOutputStream);
                            throw th2;
                        }
                    }
                }
                com.mob.commons.a.a(bufferedOutputStream2);
                return zCompress;
            } catch (Throwable th3) {
                th = th3;
                zCompress = false;
            }
        } catch (Throwable th4) {
            th = th4;
            zCompress = false;
        }
    }

    public static Bitmap getBitmap(File file, int i5) throws Throwable {
        FileInputStream fileInputStream = null;
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                Bitmap bitmap = getBitmap(fileInputStream2, i5);
                com.mob.commons.a.a(fileInputStream2);
                return bitmap;
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                com.mob.commons.a.a(fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String saveViewToImage(View view, int i5, int i6) throws Throwable {
        Bitmap bitmapCaptureView = captureView(view, i5, i6);
        FileOutputStream fileOutputStream = null;
        if (bitmapCaptureView == null || bitmapCaptureView.isRecycled()) {
            return null;
        }
        File file = new File(cn.fly.tools.utils.ResHelper.getCachePath(view.getContext(), "screenshot"), String.valueOf(System.currentTimeMillis()) + ".jpg");
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                bitmapCaptureView.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream2);
                fileOutputStream2.flush();
                com.mob.commons.a.a(fileOutputStream2);
                return file.getAbsolutePath();
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                com.mob.commons.a.a(fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static Bitmap.CompressFormat getBmpFormat(String str) throws Throwable {
        String lowerCase = str.toLowerCase();
        if (!lowerCase.endsWith(ContentTypes.EXTENSION_PNG) && !lowerCase.endsWith(ContentTypes.EXTENSION_GIF)) {
            if (!lowerCase.endsWith(ContentTypes.EXTENSION_JPG_1) && !lowerCase.endsWith(ContentTypes.EXTENSION_JPG_2) && !lowerCase.endsWith("bmp") && !lowerCase.endsWith("tif")) {
                String mime = getMime(str);
                if (!mime.endsWith(ContentTypes.EXTENSION_PNG) && !mime.endsWith(ContentTypes.EXTENSION_GIF)) {
                    return Bitmap.CompressFormat.JPEG;
                }
                return Bitmap.CompressFormat.PNG;
            }
            return Bitmap.CompressFormat.JPEG;
        }
        return Bitmap.CompressFormat.PNG;
    }

    public static Bitmap scaleBitmapByHeight(Bitmap bitmap, int i5) {
        return Bitmap.createScaledBitmap(bitmap, (bitmap.getWidth() * i5) / bitmap.getHeight(), i5, true);
    }

    public static Bitmap getBitmap(InputStream inputStream, int i5) {
        if (inputStream == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inSampleSize = i5;
        return BitmapFactory.decodeStream(inputStream, null, options);
    }

    public static Bitmap compressByQuality(Bitmap bitmap, long j6) {
        return compressByQuality(bitmap, j6, false);
    }

    public static Bitmap compressByQuality(Bitmap bitmap, long j6, boolean z6) throws Throwable {
        byte[] byteArray;
        ByteArrayOutputStream byteArrayOutputStream = null;
        if (a(bitmap) || j6 <= 0) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
                int i5 = 100;
                bitmap.compress(compressFormat, 100, byteArrayOutputStream2);
                if (byteArrayOutputStream2.size() <= j6) {
                    byteArray = byteArrayOutputStream2.toByteArray();
                } else {
                    byteArrayOutputStream2.reset();
                    bitmap.compress(compressFormat, 0, byteArrayOutputStream2);
                    if (byteArrayOutputStream2.size() >= j6) {
                        byteArray = byteArrayOutputStream2.toByteArray();
                    } else {
                        int i6 = 0;
                        int i7 = 0;
                        while (i6 < i5) {
                            i7 = (i6 + i5) / 2;
                            byteArrayOutputStream2.reset();
                            bitmap.compress(Bitmap.CompressFormat.JPEG, i7, byteArrayOutputStream2);
                            long size = byteArrayOutputStream2.size();
                            if (size == j6) {
                                break;
                            }
                            if (size > j6) {
                                i5 = i7 - 1;
                            } else {
                                i6 = i7 + 1;
                            }
                        }
                        if (i5 == i7 - 1) {
                            byteArrayOutputStream2.reset();
                            bitmap.compress(Bitmap.CompressFormat.JPEG, i6, byteArrayOutputStream2);
                        }
                        byteArray = byteArrayOutputStream2.toByteArray();
                    }
                }
                if (z6 && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                com.mob.commons.a.a(byteArrayOutputStream2);
                return bitmapDecodeByteArray;
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = byteArrayOutputStream2;
                com.mob.commons.a.a(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String saveBitmap(Context context, Bitmap bitmap) {
        return saveBitmap(context, bitmap, Bitmap.CompressFormat.JPEG, 80);
    }

    public static Bitmap getBitmap(String str) {
        return getBitmap(str, 1);
    }

    public static Bitmap getBitmap(Context context, String str) {
        return getBitmap(downloadBitmap(context, str));
    }

    private static String a(byte[] bArr) {
        byte[] bArr2 = {-1, -40, -1, -31};
        if (!a(bArr, new byte[]{-1, -40, -1, -32}) && !a(bArr, bArr2)) {
            if (a(bArr, new byte[]{-119, 80, 78, 71})) {
                return ContentTypes.EXTENSION_PNG;
            }
            if (a(bArr, "GIF".getBytes())) {
                return ContentTypes.EXTENSION_GIF;
            }
            if (a(bArr, "BM".getBytes())) {
                return "bmp";
            }
            byte[] bArr3 = {73, 73, RefErrorPtg.sid};
            byte[] bArr4 = {77, 77, RefErrorPtg.sid};
            if (!a(bArr, bArr3) && !a(bArr, bArr4)) {
                return "";
            }
            return "tif";
        }
        return ContentTypes.EXTENSION_JPG_1;
    }

    private static boolean a(byte[] bArr, byte[] bArr2) {
        if (bArr == bArr2) {
            return true;
        }
        if (bArr == null || bArr2 == null || bArr.length < bArr2.length) {
            return false;
        }
        for (int i5 = 0; i5 < bArr2.length; i5++) {
            if (bArr[i5] != bArr2[i5]) {
                return false;
            }
        }
        return true;
    }

    private static boolean a(Bitmap bitmap) {
        return bitmap == null || bitmap.getWidth() == 0 || bitmap.getHeight() == 0;
    }
}
