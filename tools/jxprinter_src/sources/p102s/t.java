package p102s;

import O3.l;
import android.graphics.Bitmap;
import androidx.activity.result.a;
import com.bumptech.glide.g;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.text.TextRecognition;
import com.google.mlkit.vision.text.TextRecognizer;
import com.google.mlkit.vision.text.chinese.ChineseTextRecognizerOptions;
import kotlin.jvm.internal.E;
import p108t.D;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class t implements D {
    @Override // p108t.D
    public void createLabelFromImage(String imagePath, long j6, long j7, l callback) {
        E.f(imagePath, "imagePath");
        E.f(callback, "callback");
        TextRecognizer client = TextRecognition.getClient(new ChineseTextRecognizerOptions.Builder().build());
        E.e(client, "getClient(...)");
        Bitmap bitmapF = g.f(imagePath);
        int width = bitmapF.getWidth();
        int height = bitmapF.getHeight();
        InputImage inputImageFromBitmap = InputImage.fromBitmap(bitmapF, 0);
        E.e(inputImageFromBitmap, "fromBitmap(...)");
        client.process(inputImageFromBitmap).addOnSuccessListener(new org.apache.poi.openxml4j.opc.g(new s(callback, width, height, j6, j7), 9)).addOnFailureListener(new a(5, callback));
    }
}
