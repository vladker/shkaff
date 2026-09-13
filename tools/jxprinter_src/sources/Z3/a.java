package Z3;

import java.security.SecureRandom;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final a INSTANCE = new a();
    private static final SecureRandom instance = new SecureRandom();

    public final SecureRandom getInstance() {
        return instance;
    }
}
