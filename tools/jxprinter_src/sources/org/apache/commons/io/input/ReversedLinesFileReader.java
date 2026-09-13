package org.apache.commons.io.input;

import A3.AbstractC0157z;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.StandardLineSeparator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ReversedLinesFileReader implements Closeable {
    private static final int DEFAULT_BLOCK_SIZE = 8192;
    private static final String EMPTY_STRING = "";
    private final int avoidNewlineSplitBufferSize;
    private final int blockSize;
    private final int byteDecrement;
    private final SeekableByteChannel channel;
    private final Charset charset;
    private FilePart currentFilePart;
    private final byte[][] newLineSequences;
    private final long totalBlockCount;
    private final long totalByteLength;
    private boolean trailingNewlineOfFileSkipped;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class FilePart {
        private int currentLastBytePos;
        private final byte[] data;
        private byte[] leftOver;
        private final long no;

        private void createLeftOver() {
            int i5 = this.currentLastBytePos + 1;
            if (i5 > 0) {
                byte[] bArrByteArray = IOUtils.byteArray(i5);
                this.leftOver = bArrByteArray;
                System.arraycopy(this.data, 0, bArrByteArray, 0, i5);
            } else {
                this.leftOver = null;
            }
            this.currentLastBytePos = -1;
        }

        private int getNewLineMatchByteCount(byte[] bArr, int i5) {
            for (byte[] bArr2 : ReversedLinesFileReader.this.newLineSequences) {
                boolean z6 = true;
                for (int length = bArr2.length - 1; length >= 0; length--) {
                    int length2 = (i5 + length) - (bArr2.length - 1);
                    z6 &= length2 >= 0 && bArr[length2] == bArr2[length];
                }
                if (z6) {
                    return bArr2.length;
                }
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String readLine() {
            String str;
            byte[] bArr;
            boolean z6 = this.no == 1;
            int i5 = this.currentLastBytePos;
            while (true) {
                if (i5 > -1) {
                    if (z6 || i5 >= ReversedLinesFileReader.this.avoidNewlineSplitBufferSize) {
                        int newLineMatchByteCount = getNewLineMatchByteCount(this.data, i5);
                        if (newLineMatchByteCount > 0) {
                            int i6 = i5 + 1;
                            int i7 = (this.currentLastBytePos - i6) + 1;
                            if (i7 < 0) {
                                throw new IllegalStateException(AbstractC0157z.k(i7, "Unexpected negative line length="));
                            }
                            byte[] bArrByteArray = IOUtils.byteArray(i7);
                            System.arraycopy(this.data, i6, bArrByteArray, 0, i7);
                            str = new String(bArrByteArray, ReversedLinesFileReader.this.charset);
                            this.currentLastBytePos = i5 - newLineMatchByteCount;
                            break;
                        }
                        i5 -= ReversedLinesFileReader.this.byteDecrement;
                        if (i5 < 0) {
                            createLeftOver();
                        }
                    } else {
                        createLeftOver();
                    }
                }
                str = null;
                break;
            }
            if (!z6 || (bArr = this.leftOver) == null) {
                return str;
            }
            String str2 = new String(bArr, ReversedLinesFileReader.this.charset);
            this.leftOver = null;
            return str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public FilePart rollOver() {
            if (this.currentLastBytePos > -1) {
                throw new IllegalStateException("Current currentLastCharPos unexpectedly positive... last readLine() should have returned something! currentLastCharPos=" + this.currentLastBytePos);
            }
            long j6 = this.no;
            if (j6 > 1) {
                ReversedLinesFileReader reversedLinesFileReader = ReversedLinesFileReader.this;
                return reversedLinesFileReader.new FilePart(j6 - 1, reversedLinesFileReader.blockSize, this.leftOver);
            }
            if (this.leftOver == null) {
                return null;
            }
            throw new IllegalStateException("Unexpected leftover of the last block: leftOverOfThisFilePart=".concat(new String(this.leftOver, ReversedLinesFileReader.this.charset)));
        }

        private FilePart(long j6, int i5, byte[] bArr) throws IOException {
            this.no = j6;
            byte[] bArr2 = new byte[(bArr != null ? bArr.length : 0) + i5];
            this.data = bArr2;
            long j7 = (j6 - 1) * ((long) ReversedLinesFileReader.this.blockSize);
            if (j6 > 0) {
                ReversedLinesFileReader.this.channel.position(j7);
                if (ReversedLinesFileReader.this.channel.read(ByteBuffer.wrap(bArr2, 0, i5)) != i5) {
                    throw new IllegalStateException("Count of requested bytes and actually read bytes don't match");
                }
            }
            if (bArr != null) {
                System.arraycopy(bArr, 0, bArr2, i5, bArr.length);
            }
            this.currentLastBytePos = bArr2.length - 1;
            this.leftOver = null;
        }
    }

    @Deprecated
    public ReversedLinesFileReader(File file) {
        this(file, 8192, Charset.defaultCharset());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.channel.close();
    }

    public String readLine() {
        String line = this.currentFilePart.readLine();
        while (line == null) {
            FilePart filePartRollOver = this.currentFilePart.rollOver();
            this.currentFilePart = filePartRollOver;
            if (filePartRollOver == null) {
                break;
            }
            line = filePartRollOver.readLine();
        }
        if (!"".equals(line) || this.trailingNewlineOfFileSkipped) {
            return line;
        }
        this.trailingNewlineOfFileSkipped = true;
        return readLine();
    }

    public List<String> readLines(int i5) {
        if (i5 < 0) {
            throw new IllegalArgumentException("lineCount < 0");
        }
        ArrayList arrayList = new ArrayList(i5);
        for (int i6 = 0; i6 < i5; i6++) {
            String line = readLine();
            if (line == null) {
                break;
            }
            arrayList.add(line);
        }
        return arrayList;
    }

    public String toString(int i5) {
        List<String> lines = readLines(i5);
        Collections.reverse(lines);
        if (lines.isEmpty()) {
            return "";
        }
        return String.join(System.lineSeparator(), lines) + System.lineSeparator();
    }

    public ReversedLinesFileReader(File file, Charset charset) {
        this(file.toPath(), charset);
    }

    public ReversedLinesFileReader(File file, int i5, Charset charset) {
        this(file.toPath(), i5, charset);
    }

    public ReversedLinesFileReader(File file, int i5, String str) {
        this(file.toPath(), i5, str);
    }

    public ReversedLinesFileReader(Path path, Charset charset) {
        this(path, 8192, charset);
    }

    public ReversedLinesFileReader(Path path, int i5, Charset charset) throws IOException {
        int i6;
        this.blockSize = i5;
        Charset charset2 = Charsets.toCharset(charset);
        this.charset = charset2;
        if (charset2.newEncoder().maxBytesPerChar() != 1.0f && charset2 != StandardCharsets.UTF_8 && charset2 != Charset.forName("Shift_JIS") && charset2 != Charset.forName("windows-31j") && charset2 != Charset.forName("x-windows-949") && charset2 != Charset.forName("gbk") && charset2 != Charset.forName("x-windows-950")) {
            if (charset2 != StandardCharsets.UTF_16BE && charset2 != StandardCharsets.UTF_16LE) {
                if (charset2 == StandardCharsets.UTF_16) {
                    throw new UnsupportedEncodingException("For UTF-16, you need to specify the byte order (use UTF-16BE or UTF-16LE)");
                }
                throw new UnsupportedEncodingException("Encoding " + charset + " is not supported yet (feel free to submit a patch)");
            }
            this.byteDecrement = 2;
        } else {
            this.byteDecrement = 1;
        }
        byte[][] bArr = {StandardLineSeparator.CRLF.getBytes(charset2), StandardLineSeparator.LF.getBytes(charset2), StandardLineSeparator.CR.getBytes(charset2)};
        this.newLineSequences = bArr;
        this.avoidNewlineSplitBufferSize = bArr[0].length;
        SeekableByteChannel seekableByteChannelNewByteChannel = Files.newByteChannel(path, StandardOpenOption.READ);
        this.channel = seekableByteChannelNewByteChannel;
        long size = seekableByteChannelNewByteChannel.size();
        this.totalByteLength = size;
        long j6 = i5;
        int i7 = (int) (size % j6);
        if (i7 > 0) {
            this.totalBlockCount = (size / j6) + 1;
        } else {
            this.totalBlockCount = size / j6;
            i6 = size > 0 ? i5 : i6;
            this.currentFilePart = new FilePart(this.totalBlockCount, i6, null);
        }
        i6 = i7;
        this.currentFilePart = new FilePart(this.totalBlockCount, i6, null);
    }

    public ReversedLinesFileReader(Path path, int i5, String str) {
        this(path, i5, Charsets.toCharset(str));
    }
}
