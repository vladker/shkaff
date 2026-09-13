package p102s;

import W2.b;
import android.app.Activity;
import com.idlefish.flutterboost.FlutterBoost;
import kotlin.jvm.internal.E;
import p108t.F;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class u implements F {
    @Override // p108t.F
    public void showTipText(String text) {
        E.f(text, "text");
        Activity activityCurrentActivity = FlutterBoost.instance().currentActivity();
        activityCurrentActivity.runOnUiThread(new b(text, activityCurrentActivity, 28));
    }
}
