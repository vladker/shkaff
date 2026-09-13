package androidx.webkit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@Profile.ExperimentalUrlPrefetch
public class PrefetchNetworkException extends PrefetchException {
    public static final int NO_HTTP_RESPONSE_STATUS_CODE = 0;
    public final int httpResponseStatusCode;

    public PrefetchNetworkException(String str) {
        this(str, 0);
    }

    public PrefetchNetworkException(String str, int i5) {
        super(str);
        this.httpResponseStatusCode = i5;
    }

    public PrefetchNetworkException(int i5) {
        this.httpResponseStatusCode = i5;
    }

    public PrefetchNetworkException() {
        this(0);
    }
}
