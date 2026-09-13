package org.apache.commons.compress.archivers.examples;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface CloseableConsumer {
    public static final CloseableConsumer CLOSING_CONSUMER;
    public static final CloseableConsumer NULL_CONSUMER;

    static {
        final int i5 = 0;
        CLOSING_CONSUMER = new CloseableConsumer() { // from class: org.apache.commons.compress.archivers.examples.a
            @Override // org.apache.commons.compress.archivers.examples.CloseableConsumer
            public final void accept(Closeable closeable) throws IOException {
                switch (i5) {
                    case 0:
                        closeable.close();
                        break;
                    default:
                        CloseableConsumer.lambda$static$0(closeable);
                        break;
                }
            }
        };
        final int i6 = 1;
        NULL_CONSUMER = new CloseableConsumer() { // from class: org.apache.commons.compress.archivers.examples.a
            @Override // org.apache.commons.compress.archivers.examples.CloseableConsumer
            public final void accept(Closeable closeable) throws IOException {
                switch (i6) {
                    case 0:
                        closeable.close();
                        break;
                    default:
                        CloseableConsumer.lambda$static$0(closeable);
                        break;
                }
            }
        };
    }

    void accept(Closeable closeable);

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ void lambda$static$0(Closeable closeable) {
    }
}
