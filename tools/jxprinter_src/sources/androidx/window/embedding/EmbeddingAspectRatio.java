package androidx.window.embedding;

import androidx.annotation.FloatRange;
import com.google.android.material.color.utilities.Contrast;
import kotlin.jvm.internal.AbstractC1107v;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class EmbeddingAspectRatio {
    private final String description;
    private final float value;
    public static final Companion Companion = new Companion(null);
    public static final EmbeddingAspectRatio ALWAYS_ALLOW = new EmbeddingAspectRatio("ALWAYS_ALLOW", 0.0f);
    public static final EmbeddingAspectRatio ALWAYS_DISALLOW = new EmbeddingAspectRatio("ALWAYS_DISALLOW", -1.0f);

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1107v abstractC1107v) {
            this();
        }

        public final EmbeddingAspectRatio buildAspectRatioFromValue$window_release(float f6) {
            EmbeddingAspectRatio embeddingAspectRatio = EmbeddingAspectRatio.ALWAYS_ALLOW;
            if (f6 == embeddingAspectRatio.getValue$window_release()) {
                return embeddingAspectRatio;
            }
            EmbeddingAspectRatio embeddingAspectRatio2 = EmbeddingAspectRatio.ALWAYS_DISALLOW;
            return f6 == embeddingAspectRatio2.getValue$window_release() ? embeddingAspectRatio2 : ratio(f6);
        }

        public final EmbeddingAspectRatio ratio(@FloatRange(from = Contrast.RATIO_MIN, fromInclusive = false) float f6) {
            if (f6 <= 1.0f) {
                throw new IllegalArgumentException("Ratio must be greater than 1.");
            }
            return new EmbeddingAspectRatio("ratio:" + f6, f6, null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ EmbeddingAspectRatio(String str, float f6, AbstractC1107v abstractC1107v) {
        this(str, f6);
    }

    public static final EmbeddingAspectRatio ratio(@FloatRange(from = Contrast.RATIO_MIN, fromInclusive = false) float f6) {
        return Companion.ratio(f6);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EmbeddingAspectRatio)) {
            return false;
        }
        EmbeddingAspectRatio embeddingAspectRatio = (EmbeddingAspectRatio) obj;
        return this.value == embeddingAspectRatio.value && E.a(this.description, embeddingAspectRatio.description);
    }

    public final String getDescription$window_release() {
        return this.description;
    }

    public final float getValue$window_release() {
        return this.value;
    }

    public int hashCode() {
        return (Float.hashCode(this.value) * 31) + this.description.hashCode();
    }

    public String toString() {
        return androidx.collection.a.f(')', this.description, new StringBuilder("EmbeddingAspectRatio("));
    }

    private EmbeddingAspectRatio(String str, float f6) {
        this.description = str;
        this.value = f6;
    }
}
