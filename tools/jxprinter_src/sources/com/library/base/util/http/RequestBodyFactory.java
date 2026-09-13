package com.library.base.util.http;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import androidx.core.app.NotificationCompat;
import androidx.webkit.internal.AssetHelper;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import okhttp3.B;
import okhttp3.Q;
import p051j0.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class RequestBodyFactory {
    /* JADX WARN: Code duplicated, block: B:15:0x002f  */
    /* JADX WARN: Code duplicated, block: B:18:0x0053  */
    private byte[] compress(String str) {
        int i5;
        float f6;
        Bitmap bitmapDecodeFile;
        int bitmapDegree;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inJustDecodeBounds = false;
        int i6 = options.outWidth;
        int i7 = options.outHeight;
        if (i6 <= i7 || i6 <= 480.0f) {
            if (i6 >= i7 || i7 <= 800.0f) {
                i5 = 1;
            } else {
                f6 = i7 / 800.0f;
            }
            options.inSampleSize = i5 > 0 ? i5 : 1;
            bitmapDecodeFile = BitmapFactory.decodeFile(str, options);
            bitmapDegree = getBitmapDegree(str);
            a.d(NotificationCompat.CATEGORY_MESSAGE, "照片角度=" + getBitmapDegree(str));
            if (bitmapDegree > 0) {
                bitmapDecodeFile = rotateBitmapByDegree(bitmapDecodeFile, bitmapDegree);
            }
            return compressImage(bitmapDecodeFile);
        }
        f6 = i6 / 480.0f;
        i5 = (int) f6;
        options.inSampleSize = i5 > 0 ? i5 : 1;
        bitmapDecodeFile = BitmapFactory.decodeFile(str, options);
        bitmapDegree = getBitmapDegree(str);
        a.d(NotificationCompat.CATEGORY_MESSAGE, "照片角度=" + getBitmapDegree(str));
        if (bitmapDegree > 0) {
            bitmapDecodeFile = rotateBitmapByDegree(bitmapDecodeFile, bitmapDegree);
        }
        return compressImage(bitmapDecodeFile);
    }

    private byte[] compressImage(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        int i5 = 100;
        while (byteArrayOutputStream.toByteArray().length / 1024 > 100 && i5 > 0) {
            byteArrayOutputStream.reset();
            bitmap.compress(Bitmap.CompressFormat.PNG, i5, byteArrayOutputStream);
            if (i5 > 10) {
                i5 -= 10;
            } else if (i5 > 0 && i5 <= 10) {
                i5 -= 2;
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    private int getBitmapDegree(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt != 6) {
                return attributeInt != 8 ? 0 : 270;
            }
            return 90;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private Bitmap rotateBitmapByDegree(Bitmap bitmap, int i5) {
        Bitmap bitmap2;
        Bitmap bitmapCreateBitmap;
        Matrix matrix = new Matrix();
        matrix.postRotate(i5);
        try {
            bitmap2 = bitmap;
            try {
                bitmapCreateBitmap = Bitmap.createBitmap(bitmap2, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            } catch (OutOfMemoryError e) {
                e = e;
                e.printStackTrace();
                bitmapCreateBitmap = null;
            }
        } catch (OutOfMemoryError e6) {
            e = e6;
            bitmap2 = bitmap;
        }
        if (bitmapCreateBitmap == null) {
            bitmapCreateBitmap = bitmap2;
        }
        if (bitmap2 != bitmapCreateBitmap) {
            bitmap2.recycle();
        }
        return bitmapCreateBitmap;
    }

    public Q create(int i5) {
        return Q.create(B.parse(AssetHelper.DEFAULT_MIME_TYPE), String.valueOf(i5));
    }

    public Q createPicture(String str) {
        return Q.create(B.parse("image/*"), compress(str));
    }

    public Q create(long j6) {
        return Q.create(B.parse(AssetHelper.DEFAULT_MIME_TYPE), String.valueOf(j6));
    }

    public Q createPicture(byte[] bArr) {
        return Q.create(B.parse("image/*"), bArr);
    }

    public Q create(String str) {
        return Q.create(B.parse(AssetHelper.DEFAULT_MIME_TYPE), str);
    }

    public Q create(File file) {
        return Q.create(B.parse("image/*"), file);
    }
}
