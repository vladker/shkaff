package org.opencv.android;

import android.content.Context;
import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.opencv.core.CvException;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class Utils {
    public static void bitmapToMat(Bitmap bitmap, Mat mat, boolean z6) {
        if (bitmap == null) {
            throw new IllegalArgumentException("bmp == null");
        }
        if (mat == null) {
            throw new IllegalArgumentException("mat == null");
        }
        nBitmapToMat2(bitmap, mat.nativeObj, z6);
    }

    public static String exportResource(Context context, int i5) {
        return exportResource(context, i5, "OpenCV_data");
    }

    public static Mat loadResource(Context context, int i5) {
        return loadResource(context, i5, -1);
    }

    public static void matToBitmap(Mat mat, Bitmap bitmap, boolean z6) {
        if (mat == null) {
            throw new IllegalArgumentException("mat == null");
        }
        if (bitmap == null) {
            throw new IllegalArgumentException("bmp == null");
        }
        nMatToBitmap2(mat.nativeObj, bitmap, z6);
    }

    private static native void nBitmapToMat2(Bitmap bitmap, long j6, boolean z6);

    private static native void nMatToBitmap2(long j6, Bitmap bitmap, boolean z6);

    public static String exportResource(Context context, int i5, String str) {
        String string = context.getResources().getString(i5);
        String strSubstring = string.substring(string.lastIndexOf(PackagingURIHelper.FORWARD_SLASH_STRING) + 1);
        try {
            InputStream inputStreamOpenRawResource = context.getResources().openRawResource(i5);
            File file = new File(context.getDir(str, 0), strSubstring);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[4096];
            while (true) {
                int i6 = inputStreamOpenRawResource.read(bArr);
                if (i6 == -1) {
                    inputStreamOpenRawResource.close();
                    fileOutputStream.close();
                    return file.getAbsolutePath();
                }
                fileOutputStream.write(bArr, 0, i6);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new CvException("Failed to export resource " + strSubstring + ". Exception thrown: " + e);
        }
    }

    public static Mat loadResource(Context context, int i5, int i6) throws IOException {
        InputStream inputStreamOpenRawResource = context.getResources().openRawResource(i5);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(inputStreamOpenRawResource.available());
        byte[] bArr = new byte[4096];
        while (true) {
            int i7 = inputStreamOpenRawResource.read(bArr);
            if (i7 == -1) {
                inputStreamOpenRawResource.close();
                Mat mat = new Mat(1, byteArrayOutputStream.size(), 0);
                mat.put(0, 0, byteArrayOutputStream.toByteArray());
                byteArrayOutputStream.close();
                Mat matImdecode = Imgcodecs.imdecode(mat, i6);
                mat.release();
                return matImdecode;
            }
            byteArrayOutputStream.write(bArr, 0, i7);
        }
    }

    public static void bitmapToMat(Bitmap bitmap, Mat mat) {
        bitmapToMat(bitmap, mat, false);
    }

    public static void matToBitmap(Mat mat, Bitmap bitmap) {
        matToBitmap(mat, bitmap, false);
    }
}
