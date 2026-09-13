package androidx.webkit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@WebViewCompat.ExperimentalUrlPrerender
public class PrerenderException extends Exception {
    public PrerenderException(@NonNull String str, @Nullable Throwable th) {
        super(str, th);
    }
}
