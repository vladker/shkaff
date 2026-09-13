package androidx.window.embedding;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.os.IBinder;
import androidx.window.RequiresWindowSdkExtension;
import androidx.window.core.ExperimentalWindowApi;
import kotlin.jvm.internal.AbstractC1107v;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityEmbeddingController {
    public static final Companion Companion = new Companion(null);
    private final EmbeddingBackend backend;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1107v abstractC1107v) {
            this();
        }

        public final ActivityEmbeddingController getInstance(Context context) {
            E.f(context, "context");
            return new ActivityEmbeddingController(EmbeddingBackend.Companion.getInstance(context));
        }

        private Companion() {
        }
    }

    public ActivityEmbeddingController(EmbeddingBackend backend) {
        E.f(backend, "backend");
        this.backend = backend;
    }

    public static final ActivityEmbeddingController getInstance(Context context) {
        return Companion.getInstance(context);
    }

    @ExperimentalWindowApi
    public final ActivityStack getActivityStack(Activity activity) {
        E.f(activity, "activity");
        return this.backend.getActivityStack(activity);
    }

    public final boolean isActivityEmbedded(Activity activity) {
        E.f(activity, "activity");
        return this.backend.isActivityEmbedded(activity);
    }

    @RequiresWindowSdkExtension(version = 3)
    public final ActivityOptions setLaunchingActivityStack$window_release(ActivityOptions options, IBinder token) {
        E.f(options, "options");
        E.f(token, "token");
        return this.backend.setLaunchingActivityStack(options, token);
    }
}
