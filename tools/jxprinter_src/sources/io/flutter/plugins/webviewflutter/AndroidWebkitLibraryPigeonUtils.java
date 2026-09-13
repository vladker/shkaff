package io.flutter.plugins.webviewflutter;

import A3.AbstractC0157z;
import A3.I;
import android.util.Log;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
final class AndroidWebkitLibraryPigeonUtils {
    public static final AndroidWebkitLibraryPigeonUtils INSTANCE = new AndroidWebkitLibraryPigeonUtils();

    private AndroidWebkitLibraryPigeonUtils() {
    }

    public final AndroidWebKitError createConnectionError(String channelName) {
        kotlin.jvm.internal.E.f(channelName, "channelName");
        return new AndroidWebKitError("channel-error", AbstractC0157z.o("Unable to establish connection on channel: '", channelName, "'."), "");
    }

    public final List<Object> wrapError(Throwable exception) {
        kotlin.jvm.internal.E.f(exception, "exception");
        if (exception instanceof AndroidWebKitError) {
            AndroidWebKitError androidWebKitError = (AndroidWebKitError) exception;
            return I.listOf(androidWebKitError.getCode(), androidWebKitError.getMessage(), androidWebKitError.getDetails());
        }
        return I.listOf((Object[]) new String[]{exception.getClass().getSimpleName(), exception.toString(), "Cause: " + exception.getCause() + ", Stacktrace: " + Log.getStackTraceString(exception)});
    }

    public final List<Object> wrapResult(Object obj) {
        return A3.G.listOf(obj);
    }
}
