package androidx.window.embedding;

import O3.l;
import android.content.Context;
import android.view.WindowMetrics;
import androidx.core.view.p;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.F;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class EmbeddingAdapter$VendorApiLevel1Impl$translateParentMetricsPredicate$1 extends F implements l {
    final /* synthetic */ Context $context;
    final /* synthetic */ SplitRule $splitRule;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmbeddingAdapter$VendorApiLevel1Impl$translateParentMetricsPredicate$1(SplitRule splitRule, Context context) {
        super(1);
        this.$splitRule = splitRule;
        this.$context = context;
    }

    @Override // O3.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(p.j(obj));
    }

    public final Boolean invoke(WindowMetrics windowMetrics) {
        E.f(windowMetrics, "windowMetrics");
        return Boolean.valueOf(this.$splitRule.checkParentMetrics$window_release(this.$context, windowMetrics));
    }
}
