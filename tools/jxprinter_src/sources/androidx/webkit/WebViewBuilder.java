package androidx.webkit;

import android.content.Context;
import android.webkit.WebView;
import androidx.annotation.RequiresOptIn;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.webkit.internal.WebViewFeatureInternal;
import androidx.webkit.internal.WebViewGlueCommunicator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.chromium.support_lib_boundary.WebViewBuilderBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class WebViewBuilder {
    WebViewBuilderBoundaryInterface mBuilderStateBoundary;
    private Policy mPolicy;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @Target({ElementType.METHOD, ElementType.TYPE, ElementType.FIELD})
    @RequiresOptIn(level = RequiresOptIn.Level.ERROR)
    @Retention(RetentionPolicy.CLASS)
    public @interface Experimental {
    }

    @Experimental
    @UiThread
    public WebView build(Context context) {
        if (!WebViewFeatureInternal.WEBVIEW_BUILDER.isSupportedByWebView()) {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
        if (this.mBuilderStateBoundary == null) {
            this.mBuilderStateBoundary = WebViewGlueCommunicator.getFactory().getWebViewBuilder();
        }
        WebViewBuilderBoundaryInterface.Config config = new WebViewBuilderBoundaryInterface.Config();
        this.mPolicy.configure(config);
        return this.mBuilderStateBoundary.build(context, config);
    }

    @Experimental
    public WebViewBuilder setPolicy(Policy policy) {
        this.mPolicy = policy;
        return this;
    }
}
