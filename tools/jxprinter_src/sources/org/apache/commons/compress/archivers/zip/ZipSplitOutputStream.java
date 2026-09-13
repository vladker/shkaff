package org.apache.commons.compress.archivers.zip;

import A3.AbstractC0157z;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import org.apache.commons.compress.utils.FileNameUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class ZipSplitOutputStream extends OutputStream {
    private static final long ZIP_SEGMENT_MAX_SIZE = 4294967295L;
    private static final long ZIP_SEGMENT_MIN_SIZE = 65536;
    private long currentSplitSegmentBytesWritten;
    private int currentSplitSegmentIndex;
    private boolean finished;
    private OutputStream outputStream;
    private final byte[] singleByte = new byte[1];
    private final long splitSize;
    private File zipFile;

    public ZipSplitOutputStream(File file, long j6) throws IOException {
        if (j6 < 65536 || j6 > 4294967295L) {
            throw new IllegalArgumentException("zip split segment size should between 64K and 4,294,967,295");
        }
        this.zipFile = file;
        this.splitSize = j6;
        this.outputStream = Files.newOutputStream(file.toPath(), new OpenOption[0]);
        writeZipSplitSignature();
    }

    private File createNewSplitSegmentFile(Integer num) throws IOException {
        int iIntValue = num == null ? this.currentSplitSegmentIndex + 2 : num.intValue();
        String baseName = FileNameUtils.getBaseName(this.zipFile.getName());
        String strK = iIntValue <= 9 ? AbstractC0157z.k(iIntValue, ".z0") : AbstractC0157z.k(iIntValue, ".z");
        File file = new File(this.zipFile.getParent(), androidx.collection.a.n(baseName, strK));
        if (file.exists()) {
            throw new IOException(androidx.exifinterface.media.a.m("split zip segment ", baseName, strK, " already exists"));
        }
        return file;
    }

    private void finish() throws IOException {
        if (this.finished) {
            throw new IOException("This archive has already been finished");
        }
        File file = new File(this.zipFile.getParentFile(), androidx.collection.a.n(FileNameUtils.getBaseName(this.zipFile.getName()), ".zip"));
        this.outputStream.close();
        if (this.zipFile.renameTo(file)) {
            this.finished = true;
            return;
        }
        throw new IOException("Failed to rename " + this.zipFile + " to " + file);
    }

    private void openNewSplitSegment() throws IOException {
        if (this.currentSplitSegmentIndex == 0) {
            this.outputStream.close();
            File fileCreateNewSplitSegmentFile = createNewSplitSegmentFile(1);
            if (!this.zipFile.renameTo(fileCreateNewSplitSegmentFile)) {
                throw new IOException("Failed to rename " + this.zipFile + " to " + fileCreateNewSplitSegmentFile);
            }
        }
        File fileCreateNewSplitSegmentFile2 = createNewSplitSegmentFile(null);
        this.outputStream.close();
        this.outputStream = Files.newOutputStream(fileCreateNewSplitSegmentFile2.toPath(), new OpenOption[0]);
        this.currentSplitSegmentBytesWritten = 0L;
        this.zipFile = fileCreateNewSplitSegmentFile2;
        this.currentSplitSegmentIndex++;
    }

    private void writeZipSplitSignature() throws IOException {
        OutputStream outputStream = this.outputStream;
        byte[] bArr = ZipArchiveOutputStream.DD_SIG;
        outputStream.write(bArr);
        this.currentSplitSegmentBytesWritten += (long) bArr.length;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.finished) {
            return;
        }
        finish();
    }

    public long getCurrentSplitSegmentBytesWritten() {
        return this.currentSplitSegmentBytesWritten;
    }

    public int getCurrentSplitSegmentIndex() {
        return this.currentSplitSegmentIndex;
    }

    public void prepareToWriteUnsplittableContent(long j6) {
        long j7 = this.splitSize;
        if (j6 > j7) {
            throw new IllegalArgumentException("The unsplittable content size is bigger than the split segment size");
        }
        if (j7 - this.currentSplitSegmentBytesWritten < j6) {
            openNewSplitSegment();
        }
    }

    @Override // java.io.OutputStream
    public void write(int i5) throws IOException {
        byte[] bArr = this.singleByte;
        bArr[0] = (byte) (i5 & 255);
        write(bArr);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i5, int i6) throws IOException {
        if (i6 <= 0) {
            return;
        }
        long j6 = this.currentSplitSegmentBytesWritten;
        long j7 = this.splitSize;
        if (j6 >= j7) {
            openNewSplitSegment();
            write(bArr, i5, i6);
            return;
        }
        long j8 = i6;
        if (j6 + j8 > j7) {
            int i7 = ((int) j7) - ((int) j6);
            write(bArr, i5, i7);
            openNewSplitSegment();
            write(bArr, i5 + i7, i6 - i7);
            return;
        }
        this.outputStream.write(bArr, i5, i6);
        this.currentSplitSegmentBytesWritten += j8;
    }
}
