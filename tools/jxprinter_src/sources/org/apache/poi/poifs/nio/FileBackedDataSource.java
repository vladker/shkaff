package org.apache.poi.poifs.nio;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.IdentityHashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.util.IOUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FileBackedDataSource extends DataSource implements Closeable {
    private static final Logger LOG = LogManager.getLogger((Class<?>) FileBackedDataSource.class);
    private final IdentityHashMap<ByteBuffer, ByteBuffer> buffersToClean;
    private final FileChannel channel;
    private Long channelSize;
    private final boolean closeChannelOnClose;
    private final RandomAccessFile srcFile;
    private final boolean writable;

    public FileBackedDataSource(File file) {
        this(newSrcFile(file, "r"), true);
    }

    private static RandomAccessFile newSrcFile(File file, String str) throws FileNotFoundException {
        if (file.exists()) {
            return new RandomAccessFile(file, str);
        }
        throw new FileNotFoundException(file.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void unmap(ByteBuffer byteBuffer) {
        if (byteBuffer.getClass().getName().endsWith("HeapByteBuffer")) {
            return;
        }
        if (!CleanerUtil.UNMAP_SUPPORTED) {
            LOG.atDebug().log(CleanerUtil.UNMAP_NOT_SUPPORTED_REASON);
            return;
        }
        try {
            CleanerUtil.getCleaner().freeBuffer(byteBuffer);
        } catch (IOException e) {
            LOG.atWarn().withThrowable(e).log("Failed to unmap the buffer");
        }
    }

    @Override // org.apache.poi.poifs.nio.DataSource
    public void close() throws IOException {
        this.buffersToClean.forEach(new b(0));
        this.buffersToClean.clear();
        RandomAccessFile randomAccessFile = this.srcFile;
        if (randomAccessFile != null) {
            randomAccessFile.close();
        } else if (this.closeChannelOnClose) {
            this.channel.close();
        }
    }

    @Override // org.apache.poi.poifs.nio.DataSource
    public void copyTo(OutputStream outputStream) throws IOException {
        WritableByteChannel writableByteChannelNewChannel = Channels.newChannel(outputStream);
        try {
            FileChannel fileChannel = this.channel;
            fileChannel.transferTo(0L, fileChannel.size(), writableByteChannelNewChannel);
            if (writableByteChannelNewChannel != null) {
                writableByteChannelNewChannel.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (writableByteChannelNewChannel == null) {
                    throw th2;
                }
                try {
                    writableByteChannelNewChannel.close();
                    throw th2;
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                    throw th2;
                }
            }
        }
    }

    public FileChannel getChannel() {
        return this.channel;
    }

    public boolean isWriteable() {
        return this.writable;
    }

    @Override // org.apache.poi.poifs.nio.DataSource
    public ByteBuffer read(int i5, long j6) throws IOException {
        ByteBuffer byteBufferAllocate;
        if (j6 >= size()) {
            throw new IndexOutOfBoundsException(androidx.exifinterface.media.a.k("Position ", j6, " past the end of the file"));
        }
        if (this.writable) {
            byteBufferAllocate = this.channel.map(FileChannel.MapMode.READ_WRITE, j6, i5);
            this.buffersToClean.put(byteBufferAllocate, byteBufferAllocate);
        } else {
            this.channel.position(j6);
            byteBufferAllocate = ByteBuffer.allocate(i5);
            if (IOUtils.readFully(this.channel, byteBufferAllocate) == -1) {
                throw new IndexOutOfBoundsException(androidx.exifinterface.media.a.k("Position ", j6, " past the end of the file"));
            }
        }
        byteBufferAllocate.position(0);
        return byteBufferAllocate;
    }

    public void releaseBuffer(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferRemove = this.buffersToClean.remove(byteBuffer);
        if (byteBufferRemove != null) {
            unmap(byteBufferRemove);
        }
    }

    @Override // org.apache.poi.poifs.nio.DataSource
    public long size() {
        if (this.channelSize == null) {
            this.channelSize = Long.valueOf(this.channel.size());
        }
        return this.channelSize.longValue();
    }

    @Override // org.apache.poi.poifs.nio.DataSource
    public void write(ByteBuffer byteBuffer, long j6) throws IOException {
        this.channel.write(byteBuffer, j6);
        Long l6 = this.channelSize;
        if (l6 == null || j6 < l6.longValue()) {
            return;
        }
        this.channelSize = null;
    }

    public FileBackedDataSource(File file, boolean z6) {
        this(newSrcFile(file, z6 ? "r" : "rw"), z6);
    }

    public FileBackedDataSource(RandomAccessFile randomAccessFile, boolean z6) {
        this(randomAccessFile, randomAccessFile.getChannel(), z6, false);
    }

    public FileBackedDataSource(FileChannel fileChannel, boolean z6) {
        this(fileChannel, z6, true);
    }

    public FileBackedDataSource(FileChannel fileChannel, boolean z6, boolean z7) {
        this(null, fileChannel, z6, z7);
    }

    private FileBackedDataSource(RandomAccessFile randomAccessFile, FileChannel fileChannel, boolean z6, boolean z7) {
        this.buffersToClean = new IdentityHashMap<>();
        this.srcFile = randomAccessFile;
        this.channel = fileChannel;
        this.writable = !z6;
        this.closeChannelOnClose = z7;
    }
}
