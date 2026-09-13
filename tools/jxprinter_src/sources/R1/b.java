package R1;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.text.TextRecognition;
import com.google.mlkit.vision.text.TextRecognizer;
import com.google.mlkit.vision.text.chinese.ChineseTextRecognizerOptions;
import com.google.mlkit.vision.text.devanagari.DevanagariTextRecognizerOptions;
import com.google.mlkit.vision.text.japanese.JapaneseTextRecognizerOptions;
import com.google.mlkit.vision.text.korean.KoreanTextRecognizerOptions;
import com.google.mlkit.vision.text.latin.TextRecognizerOptions;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements MethodChannel.MethodCallHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f586a;
    public final HashMap b = new HashMap();

    public b(Context context) {
        this.f586a = context;
    }

    public static void a(HashMap map, String str, Rect rect, Point[] pointArr, String str2, Float f6, Float f7) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        ArrayList arrayList2 = new ArrayList();
        for (Point point : pointArr) {
            HashMap map2 = new HashMap();
            map2.put("x", Integer.valueOf(point.x));
            map2.put("y", Integer.valueOf(point.y));
            arrayList2.add(map2);
        }
        map.put("points", arrayList2);
        HashMap map3 = new HashMap();
        map3.put("left", Integer.valueOf(rect.left));
        map3.put("right", Integer.valueOf(rect.right));
        map3.put("top", Integer.valueOf(rect.top));
        map3.put("bottom", Integer.valueOf(rect.bottom));
        map.put("rect", map3);
        map.put("recognizedLanguages", arrayList);
        map.put("text", str);
        map.put("confidence", f6);
        map.put("angle", f7);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0064  */
    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
        InputImage inputImageA;
        TextRecognizer client;
        String str = methodCall.method;
        str.getClass();
        boolean zEquals = str.equals("vision#startTextRecognizer");
        HashMap map = this.b;
        if (!zEquals) {
            if (!str.equals("vision#closeTextRecognizer")) {
                result.notImplemented();
                return;
            }
            String str2 = (String) methodCall.argument("id");
            TextRecognizer textRecognizer = (TextRecognizer) map.get(str2);
            if (textRecognizer != null) {
                textRecognizer.close();
                map.remove(str2);
            }
            result.success(null);
            return;
        }
        Map map2 = (Map) methodCall.argument("imageData");
        if (map2 == null || (inputImageA = Q1.b.a(map2, this.f586a, result)) == null) {
            return;
        }
        String str3 = (String) methodCall.argument("id");
        TextRecognizer textRecognizer2 = (TextRecognizer) map.get(str3);
        if (textRecognizer2 == null) {
            Integer num = (Integer) methodCall.argument("script");
            if (num != null) {
                int iIntValue = num.intValue();
                if (iIntValue == 0) {
                    client = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS);
                } else if (iIntValue == 1) {
                    client = TextRecognition.getClient(new ChineseTextRecognizerOptions.Builder().build());
                } else if (iIntValue == 2) {
                    client = TextRecognition.getClient(new DevanagariTextRecognizerOptions.Builder().build());
                } else if (iIntValue == 3) {
                    client = TextRecognition.getClient(new JapaneseTextRecognizerOptions.Builder().build());
                } else if (iIntValue != 4) {
                    textRecognizer2 = null;
                } else {
                    client = TextRecognition.getClient(new KoreanTextRecognizerOptions.Builder().build());
                }
                textRecognizer2 = client;
            } else {
                textRecognizer2 = null;
            }
            map.put(str3, textRecognizer2);
        }
        if (textRecognizer2 == null) {
            result.error("TextRecognizerError", "TextRecognizer is not initialized", null);
        } else {
            textRecognizer2.process(inputImageA).addOnSuccessListener(new P1.a(this, result)).addOnFailureListener(new P1.a(result, 2));
        }
    }
}
