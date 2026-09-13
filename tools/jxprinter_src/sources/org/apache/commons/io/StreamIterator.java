package org.apache.commons.io;

import java.io.Closeable;
import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Stream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class StreamIterator<E> implements Iterator<E>, Closeable {
    private final Iterator<E> iterator;
    private final Stream<E> stream;

    private StreamIterator(Stream<E> stream) {
        Objects.requireNonNull(stream, "stream");
        this.stream = stream;
        this.iterator = stream.iterator();
    }

    public static <T> Iterator<T> iterator(Stream<T> stream) {
        return new StreamIterator(stream).iterator;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.stream.close();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        boolean zHasNext = this.iterator.hasNext();
        if (!zHasNext) {
            close();
        }
        return zHasNext;
    }

    @Override // java.util.Iterator
    public E next() {
        E next = this.iterator.next();
        if (next == null) {
            close();
        }
        return next;
    }
}
