package io.flutter.plugins.webviewflutter;

import kotlin.jvm.internal.AbstractC1107v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public enum ConsoleMessageLevel {
    DEBUG(0),
    ERROR(1),
    LOG(2),
    TIP(3),
    WARNING(4),
    UNKNOWN(5);

    private final int raw;
    private static final /* synthetic */ H3.a $ENTRIES = H3.b.enumEntries(values());
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1107v abstractC1107v) {
            this();
        }

        public final ConsoleMessageLevel ofRaw(int i5) {
            for (ConsoleMessageLevel consoleMessageLevel : ConsoleMessageLevel.values()) {
                if (consoleMessageLevel.getRaw() == i5) {
                    return consoleMessageLevel;
                }
            }
            return null;
        }

        private Companion() {
        }
    }

    ConsoleMessageLevel(int i5) {
        this.raw = i5;
    }

    public static H3.a getEntries() {
        return $ENTRIES;
    }

    public final int getRaw() {
        return this.raw;
    }
}
