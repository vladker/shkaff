package org.apache.commons.compress.archivers.dump;

import androidx.collection.a;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import org.apache.commons.compress.utils.IOUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class TapeInputStream extends FilterInputStream {
    private static final int RECORD_SIZE = 1024;
    private byte[] blockBuffer;
    private int blockSize;
    private long bytesRead;
    private int currBlkIdx;
    private boolean isCompressed;
    private int readOffset;

    /* JADX INFO: renamed from: org.apache.commons.compress.archivers.dump.TapeInputStream$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$compress$archivers$dump$DumpArchiveConstants$COMPRESSION_TYPE;

        static {
            int[] iArr = new int[DumpArchiveConstants.COMPRESSION_TYPE.values().length];
            $SwitchMap$org$apache$commons$compress$archivers$dump$DumpArchiveConstants$COMPRESSION_TYPE = iArr;
            try {
                iArr[DumpArchiveConstants.COMPRESSION_TYPE.ZLIB.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$commons$compress$archivers$dump$DumpArchiveConstants$COMPRESSION_TYPE[DumpArchiveConstants.COMPRESSION_TYPE.BZLIB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$commons$compress$archivers$dump$DumpArchiveConstants$COMPRESSION_TYPE[DumpArchiveConstants.COMPRESSION_TYPE.LZO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public TapeInputStream(InputStream inputStream) {
        super(inputStream);
        this.blockBuffer = new byte[1024];
        this.currBlkIdx = -1;
        this.blockSize = 1024;
        this.readOffset = 1024;
    }

    private void readBlock(boolean z6) throws IOException {
        if (((FilterInputStream) this).in == null) {
            throw new IOException("Input buffer is closed");
        }
        if (!this.isCompressed || this.currBlkIdx == -1) {
            readFully(this.blockBuffer, 0, this.blockSize);
            this.bytesRead += (long) this.blockSize;
        } else {
            readFully(this.blockBuffer, 0, 4);
            this.bytesRead += 4;
            int iConvert32 = DumpArchiveUtil.convert32(this.blockBuffer, 0);
            if ((iConvert32 & 1) == 1) {
                int i5 = iConvert32 >> 1;
                int i6 = (iConvert32 >> 4) & 268435455;
                byte[] range = readRange(i6);
                this.bytesRead += (long) i6;
                if (z6) {
                    int i7 = AnonymousClass1.$SwitchMap$org$apache$commons$compress$archivers$dump$DumpArchiveConstants$COMPRESSION_TYPE[DumpArchiveConstants.COMPRESSION_TYPE.find(i5 & 3).ordinal()];
                    if (i7 != 1) {
                        if (i7 == 2) {
                            throw new UnsupportedCompressionAlgorithmException("BZLIB2");
                        }
                        if (i7 == 3) {
                            throw new UnsupportedCompressionAlgorithmException("LZO");
                        }
                        throw new UnsupportedCompressionAlgorithmException();
                    }
                    Inflater inflater = new Inflater();
                    try {
                        try {
                            inflater.setInput(range, 0, range.length);
                            if (inflater.inflate(this.blockBuffer) != this.blockSize) {
                                throw new ShortFileException();
                            }
                            inflater.end();
                        } catch (DataFormatException e) {
                            throw new DumpArchiveException("Bad data", e);
                        }
                    } catch (Throwable th) {
                        inflater.end();
                        throw th;
                    }
                    inflater.end();
                    throw th;
                }
                Arrays.fill(this.blockBuffer, (byte) 0);
            } else {
                readFully(this.blockBuffer, 0, this.blockSize);
                this.bytesRead += (long) this.blockSize;
            }
        }
        this.currBlkIdx++;
        this.readOffset = 0;
    }

    private void readFully(byte[] bArr, int i5, int i6) throws ShortFileException {
        if (IOUtils.readFully(((FilterInputStream) this).in, bArr, i5, i6) < i6) {
            throw new ShortFileException();
        }
    }

    private byte[] readRange(int i5) throws ShortFileException {
        byte[] range = IOUtils.readRange(((FilterInputStream) this).in, i5);
        if (range.length >= i5) {
            return range;
        }
        throw new ShortFileException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        int i5 = this.readOffset;
        int i6 = this.blockSize;
        return i5 < i6 ? i6 - i5 : ((FilterInputStream) this).in.available();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (((FilterInputStream) this).in == null || ((FilterInputStream) this).in == System.in) {
            return;
        }
        ((FilterInputStream) this).in.close();
    }

    public long getBytesRead() {
        return this.bytesRead;
    }

    public byte[] peek() {
        if (this.readOffset == this.blockSize) {
            try {
                readBlock(true);
            } catch (ShortFileException unused) {
                return null;
            }
        }
        byte[] bArr = new byte[1024];
        System.arraycopy(this.blockBuffer, this.readOffset, bArr, 0, 1024);
        return bArr;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        throw new IllegalArgumentException("All reads must be multiple of record size (1024 bytes.");
    }

    public byte[] readRecord() {
        byte[] bArr = new byte[1024];
        if (-1 != read(bArr, 0, 1024)) {
            return bArr;
        }
        throw new ShortFileException();
    }

    public void resetBlockSize(int i5, boolean z6) {
        this.isCompressed = z6;
        if (i5 < 1) {
            throw new IOException(a.i(i5, "Block with ", " records found, must be at least 1"));
        }
        int i6 = i5 * 1024;
        this.blockSize = i6;
        byte[] bArr = this.blockBuffer;
        byte[] bArr2 = new byte[i6];
        this.blockBuffer = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, 1024);
        readFully(this.blockBuffer, 1024, this.blockSize - 1024);
        this.currBlkIdx = 0;
        this.readOffset = 1024;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j6) throws IOException {
        long j7 = 0;
        if (j6 % 1024 != 0) {
            throw new IllegalArgumentException("All reads must be multiple of record size (1024 bytes.");
        }
        while (j7 < j6) {
            int i5 = this.readOffset;
            int i6 = this.blockSize;
            if (i5 == i6) {
                try {
                    readBlock(j6 - j7 < ((long) i6));
                } catch (ShortFileException unused) {
                    return -1L;
                }
            }
            int i7 = this.readOffset;
            long j8 = j6 - j7;
            long j9 = ((long) i7) + j8;
            int i8 = this.blockSize;
            if (j9 > i8) {
                j8 = ((long) i8) - ((long) i7);
            }
            this.readOffset = (int) (((long) i7) + j8);
            j7 += j8;
        }
        return j7;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) throws IOException {
        int i7 = 0;
        if (i6 == 0) {
            return 0;
        }
        if (i6 % 1024 != 0) {
            throw new IllegalArgumentException("All reads must be multiple of record size (1024 bytes.");
        }
        while (i7 < i6) {
            if (this.readOffset == this.blockSize) {
                try {
                    readBlock(true);
                } catch (ShortFileException unused) {
                    return -1;
                }
            }
            int i8 = this.readOffset;
            int i9 = i6 - i7;
            int i10 = i8 + i9;
            int i11 = this.blockSize;
            if (i10 > i11) {
                i9 = i11 - i8;
            }
            System.arraycopy(this.blockBuffer, i8, bArr, i5, i9);
            this.readOffset += i9;
            i7 += i9;
            i5 += i9;
        }
        return i7;
    }
}
