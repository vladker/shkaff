package p042h2;

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;
import androidx.annotation.StringRes;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Toast f4030a;
    public static Context b;

    public static void a(String str) {
        if (b == null) {
            return;
        }
        Toast toast = f4030a;
        if (toast != null) {
            toast.cancel();
        }
        try {
            Toast toastMakeText = Toast.makeText(b, (CharSequence) null, 0);
            f4030a = toastMakeText;
            toastMakeText.setText(str);
            f4030a.show();
        } catch (Exception unused) {
            Looper.prepare();
            Toast.makeText(b, str, 0).show();
            Looper.loop();
        }
    }

    public static void show(@StringRes int i5) {
        if (b == null) {
            return;
        }
        Toast toast = f4030a;
        if (toast != null) {
            toast.cancel();
        }
        Toast toastMakeText = Toast.makeText(b, (CharSequence) null, 0);
        f4030a = toastMakeText;
        toastMakeText.setText(i5);
        f4030a.show();
    }
}
