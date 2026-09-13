package p145z1;

import java.util.Arrays;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements k {
    public static final c Companion = new c();
    private static final d src = new d(new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
    private final float[] matrix;

    public d(float[] matrix) {
        E.f(matrix, "matrix");
        this.matrix = matrix;
    }

    public final float[] component1() {
        return this.matrix;
    }

    public final d copy(float[] matrix) {
        E.f(matrix, "matrix");
        return new d(matrix);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!d.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        E.d(obj, "null cannot be cast to non-null type com.fluttercandies.image_editor.option.ColorOption");
        return Arrays.equals(this.matrix, ((d) obj).matrix);
    }

    public final float[] getMatrix() {
        return this.matrix;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.matrix);
    }

    public String toString() {
        return "ColorOption(matrix=" + Arrays.toString(this.matrix) + ')';
    }
}
