package org.apache.commons.compress.archivers.examples;

import java.io.Closeable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
final class CloseableConsumerAdapter implements Closeable {
    private Closeable closeable;
    private final CloseableConsumer consumer;

    public CloseableConsumerAdapter(CloseableConsumer closeableConsumer) {
        Objects.requireNonNull(closeableConsumer, "consumer");
        this.consumer = closeableConsumer;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Closeable closeable = this.closeable;
        if (closeable != null) {
            this.consumer.accept(closeable);
        }
    }

    public <C extends Closeable> C track(C c) {
        this.closeable = c;
        return c;
    }
}
