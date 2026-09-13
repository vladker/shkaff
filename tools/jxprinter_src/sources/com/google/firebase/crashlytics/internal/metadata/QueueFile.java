package com.google.firebase.crashlytics.internal.metadata;

import A3.AbstractC0157z;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.common.primitives.UnsignedBytes;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
class QueueFile implements Closeable {
    static final int HEADER_LENGTH = 16;
    private static final int INITIAL_LENGTH = 4096;
    private static final Logger LOGGER = Logger.getLogger(QueueFile.class.getName());
    private final byte[] buffer;
    private int elementCount;
    int fileLength;
    private Element first;
    private Element last;
    private final RandomAccessFile raf;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Element {
        static final int HEADER_LENGTH = 4;
        static final Element NULL = new Element(0, 0);
        final int length;
        final int position;

        public Element(int i5, int i6) {
            this.position = i5;
            this.length = i6;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getSimpleName());
            sb.append("[position = ");
            sb.append(this.position);
            sb.append(", length = ");
            return AbstractC0157z.l("]", this.length, sb);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public final class ElementInputStream extends InputStream {
        private int position;
        private int remaining;

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i5, int i6) throws IOException {
            QueueFile.nonNull(bArr, "buffer");
            if ((i5 | i6) < 0 || i6 > bArr.length - i5) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i7 = this.remaining;
            if (i7 <= 0) {
                return -1;
            }
            if (i6 > i7) {
                i6 = i7;
            }
            QueueFile.this.ringRead(this.position, bArr, i5, i6);
            this.position = QueueFile.this.wrapPosition(this.position + i6);
            this.remaining -= i6;
            return i6;
        }

        private ElementInputStream(Element element) {
            this.position = QueueFile.this.wrapPosition(element.position + 4);
            this.remaining = element.length;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.remaining == 0) {
                return -1;
            }
            QueueFile.this.raf.seek(this.position);
            int i5 = QueueFile.this.raf.read();
            this.position = QueueFile.this.wrapPosition(this.position + 1);
            this.remaining--;
            return i5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface ElementReader {
        void read(InputStream inputStream, int i5);
    }

    public QueueFile(File file) throws IOException {
        this.buffer = new byte[16];
        if (!file.exists()) {
            initialize(file);
        }
        this.raf = open(file);
        readHeader();
    }

    private void expandIfNecessary(int i5) throws IOException {
        int i6 = i5 + 4;
        int iRemainingBytes = remainingBytes();
        if (iRemainingBytes >= i6) {
            return;
        }
        int i7 = this.fileLength;
        do {
            iRemainingBytes += i7;
            i7 <<= 1;
        } while (iRemainingBytes < i6);
        setLength(i7);
        Element element = this.last;
        int iWrapPosition = wrapPosition(element.position + 4 + element.length);
        if (iWrapPosition < this.first.position) {
            FileChannel channel = this.raf.getChannel();
            channel.position(this.fileLength);
            long j6 = iWrapPosition - 4;
            if (channel.transferTo(16L, j6, channel) != j6) {
                throw new AssertionError("Copied insufficient number of bytes!");
            }
        }
        int i8 = this.last.position;
        int i9 = this.first.position;
        if (i8 < i9) {
            int i10 = (this.fileLength + i8) - 16;
            writeHeader(i7, this.elementCount, i9, i10);
            this.last = new Element(i10, this.last.length);
        } else {
            writeHeader(i7, this.elementCount, i9, i8);
        }
        this.fileLength = i7;
    }

    private static void initialize(File file) throws IOException {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile randomAccessFileOpen = open(file2);
        try {
            randomAccessFileOpen.setLength(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
            randomAccessFileOpen.seek(0L);
            byte[] bArr = new byte[16];
            writeInts(bArr, 4096, 0, 0, 0);
            randomAccessFileOpen.write(bArr);
            randomAccessFileOpen.close();
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } catch (Throwable th) {
            randomAccessFileOpen.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T nonNull(T t6, String str) {
        if (t6 != null) {
            return t6;
        }
        throw new NullPointerException(str);
    }

    private static RandomAccessFile open(File file) {
        return new RandomAccessFile(file, "rwd");
    }

    private Element readElement(int i5) throws IOException {
        if (i5 == 0) {
            return Element.NULL;
        }
        this.raf.seek(i5);
        return new Element(i5, this.raf.readInt());
    }

    private void readHeader() throws IOException {
        this.raf.seek(0L);
        this.raf.readFully(this.buffer);
        int i5 = readInt(this.buffer, 0);
        this.fileLength = i5;
        if (i5 > this.raf.length()) {
            throw new IOException("File is truncated. Expected length: " + this.fileLength + ", Actual length: " + this.raf.length());
        }
        this.elementCount = readInt(this.buffer, 4);
        int i6 = readInt(this.buffer, 8);
        int i7 = readInt(this.buffer, 12);
        this.first = readElement(i6);
        this.last = readElement(i7);
    }

    private static int readInt(byte[] bArr, int i5) {
        return ((bArr[i5] & UnsignedBytes.MAX_VALUE) << 24) + ((bArr[i5 + 1] & UnsignedBytes.MAX_VALUE) << 16) + ((bArr[i5 + 2] & UnsignedBytes.MAX_VALUE) << 8) + (bArr[i5 + 3] & UnsignedBytes.MAX_VALUE);
    }

    private int remainingBytes() {
        return this.fileLength - usedBytes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ringRead(int i5, byte[] bArr, int i6, int i7) throws IOException {
        int iWrapPosition = wrapPosition(i5);
        int i8 = iWrapPosition + i7;
        int i9 = this.fileLength;
        if (i8 <= i9) {
            this.raf.seek(iWrapPosition);
            this.raf.readFully(bArr, i6, i7);
            return;
        }
        int i10 = i9 - iWrapPosition;
        this.raf.seek(iWrapPosition);
        this.raf.readFully(bArr, i6, i10);
        this.raf.seek(16L);
        this.raf.readFully(bArr, i6 + i10, i7 - i10);
    }

    private void ringWrite(int i5, byte[] bArr, int i6, int i7) throws IOException {
        int iWrapPosition = wrapPosition(i5);
        int i8 = iWrapPosition + i7;
        int i9 = this.fileLength;
        if (i8 <= i9) {
            this.raf.seek(iWrapPosition);
            this.raf.write(bArr, i6, i7);
            return;
        }
        int i10 = i9 - iWrapPosition;
        this.raf.seek(iWrapPosition);
        this.raf.write(bArr, i6, i10);
        this.raf.seek(16L);
        this.raf.write(bArr, i6 + i10, i7 - i10);
    }

    private void setLength(int i5) throws IOException {
        this.raf.setLength(i5);
        this.raf.getChannel().force(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int wrapPosition(int i5) {
        int i6 = this.fileLength;
        return i5 < i6 ? i5 : (i5 + 16) - i6;
    }

    private void writeHeader(int i5, int i6, int i7, int i8) throws IOException {
        writeInts(this.buffer, i5, i6, i7, i8);
        this.raf.seek(0L);
        this.raf.write(this.buffer);
    }

    private static void writeInt(byte[] bArr, int i5, int i6) {
        bArr[i5] = (byte) (i6 >> 24);
        bArr[i5 + 1] = (byte) (i6 >> 16);
        bArr[i5 + 2] = (byte) (i6 >> 8);
        bArr[i5 + 3] = (byte) i6;
    }

    private static void writeInts(byte[] bArr, int... iArr) {
        int i5 = 0;
        for (int i6 : iArr) {
            writeInt(bArr, i5, i6);
            i5 += 4;
        }
    }

    public void add(byte[] bArr) {
        add(bArr, 0, bArr.length);
    }

    public synchronized void clear() {
        try {
            writeHeader(4096, 0, 0, 0);
            this.elementCount = 0;
            Element element = Element.NULL;
            this.first = element;
            this.last = element;
            if (this.fileLength > 4096) {
                setLength(4096);
            }
            this.fileLength = 4096;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.raf.close();
    }

    public synchronized void forEach(ElementReader elementReader) {
        int iWrapPosition = this.first.position;
        for (int i5 = 0; i5 < this.elementCount; i5++) {
            Element element = readElement(iWrapPosition);
            elementReader.read(new ElementInputStream(element), element.length);
            iWrapPosition = wrapPosition(element.position + 4 + element.length);
        }
    }

    public boolean hasSpaceFor(int i5, int i6) {
        return (usedBytes() + 4) + i5 <= i6;
    }

    public synchronized boolean isEmpty() {
        return this.elementCount == 0;
    }

    public synchronized byte[] peek() {
        if (isEmpty()) {
            return null;
        }
        Element element = this.first;
        int i5 = element.length;
        byte[] bArr = new byte[i5];
        ringRead(element.position + 4, bArr, 0, i5);
        return bArr;
    }

    public synchronized void remove() {
        try {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }
            if (this.elementCount == 1) {
                clear();
            } else {
                Element element = this.first;
                int iWrapPosition = wrapPosition(element.position + 4 + element.length);
                ringRead(iWrapPosition, this.buffer, 0, 4);
                int i5 = readInt(this.buffer, 0);
                writeHeader(this.fileLength, this.elementCount - 1, iWrapPosition, this.last.position);
                this.elementCount--;
                this.first = new Element(iWrapPosition, i5);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized int size() {
        return this.elementCount;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[fileLength=");
        sb.append(this.fileLength);
        sb.append(", size=");
        sb.append(this.elementCount);
        sb.append(", first=");
        sb.append(this.first);
        sb.append(", last=");
        sb.append(this.last);
        sb.append(", element lengths=[");
        try {
            forEach(new ElementReader() { // from class: com.google.firebase.crashlytics.internal.metadata.QueueFile.1
                boolean first = true;

                @Override // com.google.firebase.crashlytics.internal.metadata.QueueFile.ElementReader
                public void read(InputStream inputStream, int i5) {
                    if (this.first) {
                        this.first = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(i5);
                }
            });
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "read error", (Throwable) e);
        }
        sb.append("]]");
        return sb.toString();
    }

    public int usedBytes() {
        if (this.elementCount == 0) {
            return 16;
        }
        Element element = this.last;
        int i5 = element.position;
        int i6 = this.first.position;
        return i5 >= i6 ? (i5 - i6) + 4 + element.length + 16 : (((i5 + 4) + element.length) + this.fileLength) - i6;
    }

    public synchronized void add(byte[] bArr, int i5, int i6) {
        int iWrapPosition;
        try {
            nonNull(bArr, "buffer");
            if ((i5 | i6) < 0 || i6 > bArr.length - i5) {
                throw new IndexOutOfBoundsException();
            }
            expandIfNecessary(i6);
            boolean zIsEmpty = isEmpty();
            if (zIsEmpty) {
                iWrapPosition = 16;
            } else {
                Element element = this.last;
                iWrapPosition = wrapPosition(element.position + 4 + element.length);
            }
            Element element2 = new Element(iWrapPosition, i6);
            writeInt(this.buffer, 0, i6);
            ringWrite(element2.position, this.buffer, 0, 4);
            ringWrite(element2.position + 4, bArr, i5, i6);
            writeHeader(this.fileLength, this.elementCount + 1, zIsEmpty ? element2.position : this.first.position, element2.position);
            this.last = element2;
            this.elementCount++;
            if (zIsEmpty) {
                this.first = element2;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public QueueFile(RandomAccessFile randomAccessFile) throws IOException {
        this.buffer = new byte[16];
        this.raf = randomAccessFile;
        readHeader();
    }

    public synchronized void peek(ElementReader elementReader) {
        if (this.elementCount > 0) {
            elementReader.read(new ElementInputStream(this.first), this.first.length);
        }
    }
}
