package S3;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements Serializable {
    public static final d INSTANCE = new d();
    private static final long serialVersionUID = 0;

    private final Object readResolve() {
        return f.Default;
    }
}
