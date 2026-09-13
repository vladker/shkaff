package androidx.window.embedding;

import O3.p;
import android.app.Activity;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.F;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class EmbeddingAdapter$VendorApiLevel1Impl$translateActivityPairPredicates$1 extends F implements p {
    final /* synthetic */ Set<SplitPairFilter> $splitPairFilters;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmbeddingAdapter$VendorApiLevel1Impl$translateActivityPairPredicates$1(Set<SplitPairFilter> set) {
        super(2);
        this.$splitPairFilters = set;
    }

    @Override // O3.p
    public final Boolean invoke(Activity first, Activity second) {
        E.f(first, "first");
        E.f(second, "second");
        Set<SplitPairFilter> set = this.$splitPairFilters;
        boolean z6 = false;
        if (set == null || !set.isEmpty()) {
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                if (((SplitPairFilter) it.next()).matchesActivityPair(first, second)) {
                    z6 = true;
                    break;
                }
            }
        }
        return Boolean.valueOf(z6);
    }
}
