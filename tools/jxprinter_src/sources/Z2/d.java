package Z2;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import io.flutter.FlutterInjector;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.jvm.internal.E;
import org.apache.xmlbeans.XmlErrorCodes;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements MethodChannel.MethodCallHandler {
    private Context context;
    private Toast mToast;

    public d(Context context) {
        E.f(context, "context");
        this.context = context;
    }

    public static void a(d dVar) {
        Toast toast = dVar.mToast;
        if (toast != null) {
            toast.show();
        }
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall call, MethodChannel.Result result) {
        int i5;
        Toast toast;
        E.f(call, "call");
        E.f(result, "result");
        String str = call.method;
        if (!E.a(str, "showToast")) {
            if (!E.a(str, "cancel")) {
                result.notImplemented();
                return;
            }
            Toast toast2 = this.mToast;
            if (toast2 != null) {
                toast2.cancel();
                this.mToast = null;
            }
            result.success(Boolean.TRUE);
            return;
        }
        String strValueOf = String.valueOf(call.argument(NotificationCompat.CATEGORY_MESSAGE));
        String strValueOf2 = String.valueOf(call.argument("length"));
        String strValueOf3 = String.valueOf(call.argument("gravity"));
        Number number = (Number) call.argument("bgcolor");
        Number number2 = (Number) call.argument("textcolor");
        Number number3 = (Number) call.argument("fontSize");
        String str2 = (String) call.argument("fontAsset");
        if (strValueOf3.equals("top")) {
            i5 = 48;
        } else {
            i5 = strValueOf3.equals("center") ? 17 : 80;
        }
        boolean zEquals = strValueOf2.equals(XmlErrorCodes.LONG);
        if (number != null) {
            Object systemService = this.context.getSystemService("layout_inflater");
            E.d(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
            View viewInflate = ((LayoutInflater) systemService).inflate(g.toast_custom, (ViewGroup) null);
            TextView textView = (TextView) viewInflate.findViewById(f.text);
            textView.setText(strValueOf);
            Drawable drawable = this.context.getDrawable(e.corner);
            E.c(drawable);
            E.c(drawable);
            drawable.setColorFilter(number.intValue(), PorterDuff.Mode.SRC_IN);
            textView.setBackground(drawable);
            if (number3 != null) {
                textView.setTextSize(number3.floatValue());
            }
            if (number2 != null) {
                textView.setTextColor(number2.intValue());
            }
            Toast toast3 = new Toast(this.context);
            this.mToast = toast3;
            toast3.setDuration(zEquals ? 1 : 0);
            if (str2 != null) {
                AssetManager assets = this.context.getAssets();
                E.e(assets, "getAssets(...)");
                String lookupKeyForAsset = FlutterInjector.instance().flutterLoader().getLookupKeyForAsset(str2);
                E.e(lookupKeyForAsset, "getLookupKeyForAsset(...)");
                textView.setTypeface(Typeface.createFromAsset(assets, lookupKeyForAsset));
            }
            Toast toast4 = this.mToast;
            if (toast4 != null) {
                toast4.setView(viewInflate);
            }
        } else {
            Log.d("KARTHIK", "showToast: " + number + " " + number2 + " " + number3 + " " + str2);
            Toast toastMakeText = Toast.makeText(this.context, strValueOf, zEquals ? 1 : 0);
            this.mToast = toastMakeText;
            if (Build.VERSION.SDK_INT < 30) {
                View view = toastMakeText != null ? toastMakeText.getView() : null;
                E.c(view);
                View viewFindViewById = view.findViewById(R.id.message);
                E.e(viewFindViewById, "findViewById(...)");
                TextView textView2 = (TextView) viewFindViewById;
                if (number3 != null) {
                    textView2.setTextSize(number3.floatValue());
                }
                if (number2 != null) {
                    textView2.setTextColor(number2.intValue());
                }
                if (str2 != null) {
                    AssetManager assets2 = this.context.getAssets();
                    E.e(assets2, "getAssets(...)");
                    String lookupKeyForAsset2 = FlutterInjector.instance().flutterLoader().getLookupKeyForAsset(str2);
                    E.e(lookupKeyForAsset2, "getLookupKeyForAsset(...)");
                    textView2.setTypeface(Typeface.createFromAsset(assets2, lookupKeyForAsset2));
                }
            }
        }
        try {
            if (i5 == 17) {
                Toast toast5 = this.mToast;
                if (toast5 != null) {
                    toast5.setGravity(i5, 0, 0);
                }
            } else if (i5 != 48) {
                Toast toast6 = this.mToast;
                if (toast6 != null) {
                    toast6.setGravity(i5, 0, 100);
                }
            } else {
                Toast toast7 = this.mToast;
                if (toast7 != null) {
                    toast7.setGravity(i5, 0, 100);
                }
            }
        } catch (Exception unused) {
        }
        Context context = this.context;
        if (context instanceof Activity) {
            ((Activity) context).runOnUiThread(new W2.c(this, 1));
        } else {
            Toast toast8 = this.mToast;
            if (toast8 != null) {
                toast8.show();
            }
        }
        if (Build.VERSION.SDK_INT >= 30 && (toast = this.mToast) != null) {
            toast.addCallback(new c(this));
        }
        result.success(Boolean.TRUE);
    }
}
