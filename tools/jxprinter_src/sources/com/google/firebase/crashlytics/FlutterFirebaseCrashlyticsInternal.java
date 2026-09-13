package com.google.firebase.crashlytics;

import android.annotation.SuppressLint;
import com.google.firebase.crashlytics.internal.Logger;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class FlutterFirebaseCrashlyticsInternal {
    private static final String FLUTTER_BUILD_ID_DEFAULT_KEY = "com.crashlytics.flutter.build-id.0";
    private static final String LOADING_UNIT_KEY = "com.crashlytics.flutter.build-id.";

    private FlutterFirebaseCrashlyticsInternal() {
    }

    @SuppressLint({"VisibleForTests"})
    public static void recordFatalException(Throwable th) {
        if (th == null) {
            Logger.getLogger().w("A null value was passed to recordFatalException. Ignoring.");
        } else {
            FirebaseCrashlytics.getInstance().core.logFatalException(th);
        }
    }

    @SuppressLint({"VisibleForTests"})
    public static void setFlutterBuildId(String str) {
        FirebaseCrashlytics.getInstance().core.setInternalKey(FLUTTER_BUILD_ID_DEFAULT_KEY, str);
    }

    @SuppressLint({"VisibleForTests"})
    public static void setLoadingUnits(List<String> list) {
        int i5 = 0;
        for (String str : list) {
            i5++;
            FirebaseCrashlytics.getInstance().core.setInternalKey(LOADING_UNIT_KEY + i5, str);
        }
    }
}
