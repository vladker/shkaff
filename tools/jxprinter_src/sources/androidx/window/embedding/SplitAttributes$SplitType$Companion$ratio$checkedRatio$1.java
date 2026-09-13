package androidx.window.embedding;

import A3.C;
import O3.l;
import kotlin.jvm.internal.F;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class SplitAttributes$SplitType$Companion$ratio$checkedRatio$1 extends F implements l {
    final /* synthetic */ float $ratio;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplitAttributes$SplitType$Companion$ratio$checkedRatio$1(float f6) {
        super(1);
        this.$ratio = f6;
    }

    @Override // O3.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).floatValue());
    }

    public final Boolean invoke(float f6) {
        double d = this.$ratio;
        return Boolean.valueOf(0.0d <= d && d <= 1.0d && !C.contains(new Float[]{Float.valueOf(0.0f), Float.valueOf(1.0f)}, Float.valueOf(this.$ratio)));
    }
}
