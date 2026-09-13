package p056k0;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.gzwx.image.GzwxImage;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.opencv.android.Utils;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import p051j0.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class q {
    public static Bitmap a(Bitmap bitmap, float f6, float f7, float f8) {
        Mat mat = new Mat();
        Utils.bitmapToMat(bitmap, mat);
        Mat mat2 = new Mat(mat.size(), mat.type());
        mat.convertTo(mat2, -1, f6, f7);
        ArrayList arrayList = new ArrayList();
        Core.split(mat2, arrayList);
        Mat mat3 = (Mat) arrayList.get(1);
        Core.multiply(mat3, new Scalar(f8), mat3);
        Core.merge(arrayList, mat2);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(mat2.cols(), mat2.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(mat2, bitmapCreateBitmap);
        return bitmapCreateBitmap;
    }

    public static Bitmap b(Bitmap bitmap) {
        try {
            Bitmap bitmapImageBinarize = GzwxImage.INSTANCE.imageBinarize(bitmap);
            return bitmapImageBinarize != null ? bitmapImageBinarize : bitmap;
        } catch (Exception e) {
            a.e("PictureUtil", "binarizeImage: " + e.getMessage(), e);
            return bitmap;
        }
    }

    public static Bitmap c(Bitmap bitmap) {
        Mat mat = new Mat();
        Utils.bitmapToMat(bitmap, mat);
        Mat mat2 = new Mat(mat.size(), CvType.CV_8UC1);
        Mat mat3 = new Mat();
        Imgproc.cvtColor(mat, mat3, 6);
        new Mat(mat3.size(), CvType.CV_32FC1);
        mat3.rows();
        CountDownLatch countDownLatch = new CountDownLatch(mat3.rows());
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(8, 200, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(mat3.rows()));
        for (int i5 = 0; i5 < mat3.rows(); i5++) {
            p pVar = new p();
            pVar.d = countDownLatch;
            pVar.f5471a = i5;
            pVar.b = mat3;
            pVar.c = mat2;
            threadPoolExecutor.submit(pVar);
        }
        threadPoolExecutor.shutdown();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(mat2.cols(), mat2.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(mat2, bitmapCreateBitmap);
        return bitmapCreateBitmap;
    }

    public static Bitmap d(Bitmap bitmap) {
        try {
            Bitmap bitmapJarvisDithering = GzwxImage.INSTANCE.jarvisDithering(bitmap);
            return bitmapJarvisDithering != null ? bitmapJarvisDithering : bitmap;
        } catch (Exception e) {
            a.e("PictureUtil", "jarvisDithering: " + e.getMessage(), e);
            return bitmap;
        }
    }

    public static Bitmap e(Bitmap bitmap) {
        Mat mat = new Mat();
        Utils.bitmapToMat(bitmap, mat);
        Imgproc.cvtColor(mat, mat, 6);
        Mat mat2 = new Mat();
        Imgproc.threshold(mat, mat2, 1.0d, 255.0d, 0);
        mat.convertTo(mat, CvType.CV_32FC1, 0.00392156862745098d);
        Mat mat3 = new Mat();
        Mat mat4 = new Mat();
        Mat mat5 = new Mat();
        Imgproc.blur(mat, mat3, new Size(101.0d, 101.0d));
        Core.divide(mat, mat3, mat4);
        Mat mat6 = new Mat();
        Mat mat7 = new Mat();
        Imgproc.GaussianBlur(mat4, mat7, new Size(7.0d, 7.0d), 3.0d, 3.0d, 4);
        Mat mat8 = new Mat();
        Core.subtract(mat4, mat7, mat8);
        Core.addWeighted(mat4, 1.0d, mat8, 101 / 100.0f, 0.0d, mat6);
        mat6.convertTo(mat5, CvType.CV_8UC1, 255.0d);
        Imgproc.GaussianBlur(mat5, mat5, new Size(1.0d, 1.0d), 0.0d, 0.0d, 4);
        Imgproc.adaptiveThreshold(mat5, mat5, 255.0d, 0, 0, 31, 30.0d);
        Mat mat9 = new Mat();
        Core.bitwise_and(mat5, mat5, mat9, mat2);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(mat9.cols(), mat9.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(mat9, bitmapCreateBitmap);
        return bitmapCreateBitmap;
    }

    public Bitmap scaleBitmapByEqualRatio(Bitmap bitmap, int i5) throws Exception {
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            float f6 = i5 / width;
            Matrix matrix = new Matrix();
            matrix.postScale(f6, f6);
            return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        } catch (OutOfMemoryError e) {
            throw new Exception("scaleBitmapByEqualRatio oom", e);
        }
    }

    public Bitmap scaleBitmapByTile(Bitmap bitmap, int i5, int i6) {
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Matrix matrix = new Matrix();
            matrix.postScale(i5 / width, i6 / height);
            return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        } catch (OutOfMemoryError e) {
            throw new Exception("scaleBitmapByTile oom", e);
        }
    }

    public Bitmap scaleBitmapByEqualRatio(Bitmap bitmap, int i5, int i6) {
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            float fMin = Math.min(i5 / width, i6 / height);
            Matrix matrix = new Matrix();
            matrix.postScale(fMin, fMin);
            return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        } catch (OutOfMemoryError e) {
            throw new Exception("scaleBitmapByEqualRatio oom", e);
        }
    }
}
