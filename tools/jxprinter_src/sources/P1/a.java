package P1;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.vision.text.Text;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.firebase.crashlytics.FlutterFirebaseCrashlyticsPlugin;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements OnFailureListener, OnSuccessListener, OnCompleteListener, p080o0.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f560a;
    public final /* synthetic */ MethodChannel.Result b;

    public /* synthetic */ a(R1.b bVar, MethodChannel.Result result) {
        this.f560a = 1;
        this.b = result;
    }

    public void a(String str, String str2) {
        switch (this.f560a) {
            case 5:
                this.b.error(str, str2, null);
                break;
            default:
                this.b.error(str, str2, null);
                break;
        }
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task) {
        FlutterFirebaseCrashlyticsPlugin.lambda$onMethodCall$11(this.b, task);
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        switch (this.f560a) {
            case 0:
                this.b.error("BarcodeDetectorError", exc.toString(), null);
                break;
            default:
                this.b.error("TextRecognizerError", exc.toString(), null);
                break;
        }
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        Text text = (Text) obj;
        HashMap map = new HashMap();
        map.put("text", text.getText());
        ArrayList arrayList = new ArrayList();
        for (Text.TextBlock textBlock : text.getTextBlocks()) {
            HashMap map2 = new HashMap();
            R1.b.a(map2, textBlock.getText(), textBlock.getBoundingBox(), textBlock.getCornerPoints(), textBlock.getRecognizedLanguage(), null, null);
            ArrayList arrayList2 = new ArrayList();
            for (Text.Line line : textBlock.getLines()) {
                HashMap map3 = new HashMap();
                R1.b.a(map3, line.getText(), line.getBoundingBox(), line.getCornerPoints(), line.getRecognizedLanguage(), Float.valueOf(line.getConfidence()), Float.valueOf(line.getAngle()));
                ArrayList arrayList3 = new ArrayList();
                for (Text.Element element : line.getElements()) {
                    HashMap map4 = new HashMap();
                    R1.b.a(map4, element.getText(), element.getBoundingBox(), element.getCornerPoints(), element.getRecognizedLanguage(), Float.valueOf(element.getConfidence()), Float.valueOf(element.getAngle()));
                    ArrayList arrayList4 = new ArrayList();
                    for (Text.Symbol symbol : element.getSymbols()) {
                        HashMap map5 = new HashMap();
                        R1.b.a(map5, symbol.getText(), symbol.getBoundingBox(), symbol.getCornerPoints(), symbol.getRecognizedLanguage(), Float.valueOf(symbol.getConfidence()), Float.valueOf(symbol.getAngle()));
                        arrayList4.add(map5);
                    }
                    map4.put("symbols", arrayList4);
                    arrayList3.add(map4);
                }
                map3.put("elements", arrayList3);
                arrayList2.add(map3);
            }
            map2.put("lines", arrayList2);
            arrayList.add(map2);
        }
        map.put("blocks", arrayList);
        this.b.success(map);
    }

    public /* synthetic */ a(MethodChannel.Result result, int i5) {
        this.f560a = i5;
        this.b = result;
    }
}
