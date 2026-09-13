package U4;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class g extends IOException {
    public g(int i5, String str) {
        super("HTTP error fetching URL. Status=" + i5 + ", URL=[" + str + "]");
    }
}
