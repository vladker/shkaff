package p115u1;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public static void a(boolean z6, String str) {
        if (!z6) {
            throw new IllegalStateException(str);
        }
    }

    public static void checkArgumentForIO(boolean z6, String str) throws IOException {
        if (!z6) {
            throw new IOException(str);
        }
    }
}
