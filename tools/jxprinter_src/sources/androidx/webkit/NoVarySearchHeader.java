package androidx.webkit;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@Profile.ExperimentalUrlPrefetch
public class NoVarySearchHeader {
    public final List<String> consideredQueryParameters;
    public final boolean ignoreDifferencesInParameters;
    public final List<String> ignoredQueryParameters;
    public final boolean varyOnKeyOrder;

    private NoVarySearchHeader(boolean z6, boolean z7, List<String> list, List<String> list2) {
        this.varyOnKeyOrder = z6;
        this.ignoreDifferencesInParameters = z7;
        this.ignoredQueryParameters = list;
        this.consideredQueryParameters = list2;
    }

    @Profile.ExperimentalUrlPrefetch
    public static NoVarySearchHeader alwaysVaryHeader() {
        return new NoVarySearchHeader(true, false, new ArrayList(), new ArrayList());
    }

    @Profile.ExperimentalUrlPrefetch
    public static NoVarySearchHeader neverVaryExcept(boolean z6, List<String> list) {
        return new NoVarySearchHeader(z6, true, new ArrayList(), list);
    }

    @Profile.ExperimentalUrlPrefetch
    public static NoVarySearchHeader neverVaryHeader() {
        return new NoVarySearchHeader(false, true, new ArrayList(), new ArrayList());
    }

    @Profile.ExperimentalUrlPrefetch
    public static NoVarySearchHeader varyExcept(boolean z6, List<String> list) {
        return new NoVarySearchHeader(z6, false, list, new ArrayList());
    }
}
