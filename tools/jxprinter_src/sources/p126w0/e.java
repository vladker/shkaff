package p126w0;

import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class e extends IOException {
    private static final long serialVersionUID = 1;

    @Deprecated
    public e(String str) {
        this(str, -1, null);
    }

    public e(String str, int i5, @Nullable Throwable th) {
        super(str + ", status code: " + i5, th);
    }
}
