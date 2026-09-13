package cn.sharesdk.framework.utils;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.view.accessibility.AccessibilityEventCompat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static PendingIntent a(Context context, int i5, Intent intent, int i6) {
        return PendingIntent.getBroadcast(context, i5, intent, AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
    }
}
