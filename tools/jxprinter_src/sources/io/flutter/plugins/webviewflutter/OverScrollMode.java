package io.flutter.plugins.webviewflutter;

import kotlin.jvm.internal.AbstractC1107v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public enum OverScrollMode {
    ALWAYS(0),
    IF_CONTENT_SCROLLS(1),
    NEVER(2),
    UNKNOWN(3);

    private final int raw;
    private static final /* synthetic */ H3.a $ENTRIES = H3.b.enumEntries(values());
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1107v abstractC1107v) {
            this();
        }

        public final OverScrollMode ofRaw(int i5) {
            for (OverScrollMode overScrollMode : OverScrollMode.values()) {
                if (overScrollMode.getRaw() == i5) {
                    return overScrollMode;
                }
            }
            return null;
        }

        private Companion() {
        }
    }

    OverScrollMode(int i5) {
        this.raw = i5;
    }

    public static H3.a getEntries() {
        return $ENTRIES;
    }

    public final int getRaw() {
        return this.raw;
    }
}
