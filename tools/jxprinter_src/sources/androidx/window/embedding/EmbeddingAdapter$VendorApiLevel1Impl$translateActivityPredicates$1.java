package androidx.window.embedding;

import O3.l;
import android.app.Activity;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.F;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class EmbeddingAdapter$VendorApiLevel1Impl$translateActivityPredicates$1 extends F implements l {
    final /* synthetic */ Set<ActivityFilter> $activityFilters;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmbeddingAdapter$VendorApiLevel1Impl$translateActivityPredicates$1(Set<ActivityFilter> set) {
        super(1);
        this.$activityFilters = set;
    }

    @Override // O3.l
    public final Boolean invoke(Activity activity) {
        E.f(activity, "activity");
        Set<ActivityFilter> set = this.$activityFilters;
        boolean z6 = false;
        if (set == null || !set.isEmpty()) {
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                if (((ActivityFilter) it.next()).matchesActivity(activity)) {
                    z6 = true;
                    break;
                }
            }
        }
        return Boolean.valueOf(z6);
    }
}
