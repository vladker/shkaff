package androidx.window.embedding;

import android.content.Context;
import android.view.WindowMetrics;
import androidx.window.extensions.core.util.function.Predicate;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1078a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ SplitRule c;

    public /* synthetic */ b(SplitRule splitRule, Context context, int i5) {
        this.f1078a = i5;
        this.c = splitRule;
        this.b = context;
    }

    @Override // androidx.window.extensions.core.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f1078a) {
            case 0:
                return EmbeddingAdapter.translateSplitPlaceholderRule$lambda$11((SplitPlaceholderRule) this.c, this.b, (WindowMetrics) obj);
            default:
                return EmbeddingAdapter.translateSplitPairRule$lambda$6((SplitPairRule) this.c, this.b, (WindowMetrics) obj);
        }
    }
}
