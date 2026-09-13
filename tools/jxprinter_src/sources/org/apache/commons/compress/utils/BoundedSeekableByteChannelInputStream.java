package org.apache.commons.compress.utils;

import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class BoundedSeekableByteChannelInputStream extends BoundedArchiveInputStream {
    private final SeekableByteChannel channel;

    public BoundedSeekableByteChannelInputStream(long j6, long j7, SeekableByteChannel seekableByteChannel) {
        super(j6, j7);
        this.channel = seekableByteChannel;
    }

    @Override // org.apache.commons.compress.utils.BoundedArchiveInputStream
    public int read(long j6, ByteBuffer byteBuffer) {
        int i5;
        synchronized (this.channel) {
            this.channel.position(j6);
            i5 = this.channel.read(byteBuffer);
        }
        byteBuffer.flip();
        return i5;
    }
}
