package org.apache.commons.compress.harmony.unpack200;

import androidx.collection.a;
import java.io.InputStream;
import org.apache.commons.compress.harmony.pack200.BHSDCodec;
import org.apache.commons.compress.harmony.pack200.Codec;
import org.apache.commons.compress.harmony.pack200.Pack200Exception;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FileBands extends BandSet {
    private final String[] cpUTF8;
    private byte[][] fileBits;
    private int[] fileModtime;
    private String[] fileName;
    private int[] fileOptions;
    private long[] fileSize;
    private InputStream in;

    public FileBands(Segment segment) {
        super(segment);
        this.cpUTF8 = segment.getCpBands().getCpUTF8();
    }

    public byte[][] getFileBits() {
        return this.fileBits;
    }

    public int[] getFileModtime() {
        return this.fileModtime;
    }

    public String[] getFileName() {
        return this.fileName;
    }

    public int[] getFileOptions() {
        return this.fileOptions;
    }

    public long[] getFileSize() {
        return this.fileSize;
    }

    public void processFileBits() {
        int numberOfFiles = this.header.getNumberOfFiles();
        this.fileBits = new byte[numberOfFiles][];
        for (int i5 = 0; i5 < numberOfFiles; i5++) {
            int i6 = (int) this.fileSize[i5];
            byte[] bArr = new byte[i6];
            this.fileBits[i5] = bArr;
            int i7 = this.in.read(bArr);
            if (i6 != 0 && i7 < i6) {
                throw new Pack200Exception(a.h(i6, i7, "Expected to read ", " bytes but read "));
            }
        }
    }

    @Override // org.apache.commons.compress.harmony.unpack200.BandSet
    public void read(InputStream inputStream) {
        int numberOfFiles = this.header.getNumberOfFiles();
        SegmentOptions options = this.header.getOptions();
        BHSDCodec bHSDCodec = Codec.UNSIGNED5;
        this.fileName = parseReferences("file_name", inputStream, bHSDCodec, numberOfFiles, this.cpUTF8);
        this.fileSize = parseFlags("file_size", inputStream, numberOfFiles, bHSDCodec, options.hasFileSizeHi());
        if (options.hasFileModtime()) {
            this.fileModtime = decodeBandInt("file_modtime", inputStream, Codec.DELTA5, numberOfFiles);
        } else {
            this.fileModtime = new int[numberOfFiles];
        }
        if (options.hasFileOptions()) {
            this.fileOptions = decodeBandInt("file_options", inputStream, bHSDCodec, numberOfFiles);
        } else {
            this.fileOptions = new int[numberOfFiles];
        }
        this.in = inputStream;
    }

    @Override // org.apache.commons.compress.harmony.unpack200.BandSet
    public void unpack() {
    }
}
