package org.apache.logging.log4j.util;

import java.util.function.Predicate;
import org.apache.logging.log4j.spi.Provider;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class h implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6948a;

    public /* synthetic */ h(int i5) {
        this.f6948a = i5;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        Provider provider = (Provider) obj;
        switch (this.f6948a) {
            case 0:
                return ProviderUtil.lambda$loadProviders$1(provider);
            default:
                return ProviderUtil.lambda$new$0(provider);
        }
    }
}
