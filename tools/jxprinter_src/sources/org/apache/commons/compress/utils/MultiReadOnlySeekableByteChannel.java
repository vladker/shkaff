package org.apache.commons.compress.utils;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NonWritableChannelException;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class MultiReadOnlySeekableByteChannel implements SeekableByteChannel {
    private final List<SeekableByteChannel> channels;
    private int currentChannelIdx;
    private long globalPosition;

    public MultiReadOnlySeekableByteChannel(List<SeekableByteChannel> list) {
        Objects.requireNonNull(list, "channels must not be null");
        this.channels = Collections.unmodifiableList(new ArrayList(list));
    }

    public static SeekableByteChannel forFiles(File... fileArr) {
        ArrayList arrayList = new ArrayList();
        Objects.requireNonNull(fileArr, "files must not be null");
        for (File file : fileArr) {
            arrayList.add(Files.newByteChannel(file.toPath(), StandardOpenOption.READ));
        }
        return arrayList.size() == 1 ? (SeekableByteChannel) arrayList.get(0) : new MultiReadOnlySeekableByteChannel(arrayList);
    }

    public static SeekableByteChannel forSeekableByteChannels(SeekableByteChannel... seekableByteChannelArr) {
        Objects.requireNonNull(seekableByteChannelArr, "channels must not be null");
        return seekableByteChannelArr.length == 1 ? seekableByteChannelArr[0] : new MultiReadOnlySeekableByteChannel(Arrays.asList(seekableByteChannelArr));
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Iterator<SeekableByteChannel> it = this.channels.iterator();
        IOException iOException = null;
        while (it.hasNext()) {
            try {
                it.next().close();
            } catch (IOException e) {
                if (iOException == null) {
                    iOException = e;
                }
            }
        }
        if (iOException != null) {
            throw new IOException("failed to close wrapped channel", iOException);
        }
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        Iterator<SeekableByteChannel> it = this.channels.iterator();
        while (it.hasNext()) {
            if (!it.next().isOpen()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.nio.channels.SeekableByteChannel
    public long position() {
        return this.globalPosition;
    }

    @Override // java.nio.channels.SeekableByteChannel, java.nio.channels.ReadableByteChannel
    public synchronized int read(ByteBuffer byteBuffer) {
        try {
            if (!isOpen()) {
                throw new ClosedChannelException();
            }
            int i5 = 0;
            if (!byteBuffer.hasRemaining()) {
                return 0;
            }
            while (byteBuffer.hasRemaining() && this.currentChannelIdx < this.channels.size()) {
                SeekableByteChannel seekableByteChannel = this.channels.get(this.currentChannelIdx);
                int i6 = seekableByteChannel.read(byteBuffer);
                if (i6 == -1) {
                    this.currentChannelIdx++;
                } else {
                    if (seekableByteChannel.position() >= seekableByteChannel.size()) {
                        this.currentChannelIdx++;
                    }
                    i5 += i6;
                }
            }
            if (i5 <= 0) {
                return -1;
            }
            this.globalPosition += (long) i5;
            return i5;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.nio.channels.SeekableByteChannel
    public long size() throws ClosedChannelException {
        if (!isOpen()) {
            throw new ClosedChannelException();
        }
        Iterator<SeekableByteChannel> it = this.channels.iterator();
        long size = 0;
        while (it.hasNext()) {
            size += it.next().size();
        }
        return size;
    }

    @Override // java.nio.channels.SeekableByteChannel
    public SeekableByteChannel truncate(long j6) {
        throw new NonWritableChannelException();
    }

    @Override // java.nio.channels.SeekableByteChannel, java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        throw new NonWritableChannelException();
    }

    public synchronized SeekableByteChannel position(long j6, long j7) {
        try {
            if (!isOpen()) {
                throw new ClosedChannelException();
            }
            for (int i5 = 0; i5 < j6; i5++) {
                j7 += this.channels.get(i5).size();
            }
        } catch (Throwable th) {
            throw th;
        }
        return position(j7);
    }

    @Override // java.nio.channels.SeekableByteChannel
    public synchronized SeekableByteChannel position(long j6) {
        try {
            if (j6 >= 0) {
                if (isOpen()) {
                    this.globalPosition = j6;
                    int i5 = 0;
                    while (i5 < this.channels.size()) {
                        SeekableByteChannel seekableByteChannel = this.channels.get(i5);
                        long size = seekableByteChannel.size();
                        long j7 = -1;
                        if (j6 == -1) {
                            j7 = j6;
                            j6 = 0;
                        } else if (j6 <= size) {
                            this.currentChannelIdx = i5;
                        } else {
                            j7 = j6 - size;
                            j6 = size;
                        }
                        seekableByteChannel.position(j6);
                        i5++;
                        j6 = j7;
                    }
                } else {
                    throw new ClosedChannelException();
                }
            } else {
                throw new IOException("Negative position: " + j6);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }
}
