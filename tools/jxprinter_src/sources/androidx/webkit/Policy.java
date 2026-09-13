package androidx.webkit;

import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.chromium.support_lib_boundary.WebViewBuilderBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@WebViewBuilder.Experimental
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class Policy {
    private final List<ConfigRunnable> mBehaviors;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Builder {
        final List<ConfigRunnable> mBehaviors = new ArrayList();

        public Policy build() {
            return new Policy(this.mBehaviors);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface ConfigRunnable {
        void configure(WebViewBuilderBoundaryInterface.Config config);
    }

    public void configure(WebViewBuilderBoundaryInterface.Config config) {
        Iterator<ConfigRunnable> it = this.mBehaviors.iterator();
        while (it.hasNext()) {
            it.next().configure(config);
        }
    }

    private Policy(List<ConfigRunnable> list) {
        this.mBehaviors = list;
    }
}
