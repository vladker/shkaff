package p056k0;

import android.content.Context;
import android.graphics.Bitmap;
import com.gzwx.image.GzwxImage;
import java.io.File;
import p050j.j;
import p051j0.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class k {
    public static j a(Context context, Bitmap bitmap) {
        j jVar;
        j jVar2;
        if (context == null) {
            return new j(false, (Bitmap) null, "Context is null", 6);
        }
        if (bitmap == null) {
            return new j(false, (Bitmap) null, "Bitmap is null", 6);
        }
        Object obj = n.f5469a;
        File file = new File(context.getFilesDir(), "doclayout_yolo_docstructbench_imgsz1024.onnx");
        if (!n.c(context)) {
            return new j(false, (Bitmap) null, "Model file is not ready", 6);
        }
        if (n.b(file)) {
            try {
                Bitmap bitmapLambda$process$0 = lambda$process$0(bitmap, file.getAbsolutePath(), 0.25f);
                if (bitmapLambda$process$0 == null) {
                    jVar2 = new j(false, (Bitmap) null, "gzwx-image returned null", 5);
                } else {
                    jVar = new j(true, bitmapLambda$process$0, "", 5);
                    jVar2 = jVar;
                }
            } catch (Throwable th) {
                String string = th.getMessage() == null ? th.toString() : th.getMessage();
                if (string != null) {
                    string.contains("Failed to load ONNX model");
                }
                jVar = new j(false, (Bitmap) null, string, 5);
            }
        } else {
            jVar2 = new j(false, (Bitmap) null, "Model file is not ready", 5);
        }
        if (jVar2.c) {
            return new j(true, (Bitmap) jVar2.d, "", 6);
        }
        String str = jVar2.b;
        if (str != null && str.contains("Failed to load ONNX model")) {
            String str2 = jVar2.b;
            Context applicationContext = context.getApplicationContext();
            if (str2 == null) {
                str2 = "Model file invalidated";
            }
            File file2 = new File(applicationContext.getFilesDir(), "doclayout_yolo_docstructbench_imgsz1024.onnx");
            File file3 = new File(applicationContext.getFilesDir(), "doclayout_yolo_docstructbench_imgsz1024.onnx.tmp");
            if (file3.exists() && !file3.delete()) {
                a.d("ModelFileDownloadUtil", "Failed to delete tmp model file: " + file3.getAbsolutePath());
            }
            if (file2.exists() && !file2.delete()) {
                a.d("ModelFileDownloadUtil", "Failed to delete model file: " + file2.getAbsolutePath());
            }
            if (m.b.equals(n.e.get())) {
                n.d = str2;
                n.d();
            } else {
                n.e(str2);
                n.a(applicationContext, true);
            }
        }
        return new j(false, (Bitmap) null, jVar2.b, 6);
    }

    private static /* synthetic */ Bitmap lambda$process$0(Bitmap bitmap, String str, float f6) {
        return GzwxImage.INSTANCE.asyncPhotoTextBackgroundBinarize(bitmap, str, f6);
    }
}
