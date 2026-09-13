package org.apache.commons.compress.harmony.pack200;

import com.google.common.primitives.UnsignedBytes;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import kotlinx.serialization.json.internal.AbstractC1125a;
import org.objectweb.asm.ClassReader;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FileBands extends BandSet {
    private final CpBands cpBands;
    private final List fileList;
    private final CPUTF8[] fileName;
    private final byte[][] file_bits;
    private final int[] file_modtime;
    private int[] file_name;
    private final int[] file_options;
    private final long[] file_size;
    private final PackingOptions options;

    public FileBands(CpBands cpBands, SegmentHeader segmentHeader, PackingOptions packingOptions, Archive.SegmentUnit segmentUnit, int i5) {
        super(i5, segmentHeader);
        List fileList = segmentUnit.getFileList();
        this.fileList = fileList;
        this.options = packingOptions;
        this.cpBands = cpBands;
        int size = fileList.size();
        this.fileName = new CPUTF8[size];
        this.file_modtime = new int[size];
        this.file_size = new long[size];
        this.file_options = new int[size];
        this.file_bits = new byte[size][];
        int archive_modtime = segmentHeader.getArchive_modtime();
        HashSet hashSet = new HashSet();
        Iterator it = segmentUnit.getClassList().iterator();
        while (it.hasNext()) {
            hashSet.add(((ClassReader) it.next()).getClassName());
        }
        CPUTF8 cPUtf8 = cpBands.getCPUtf8("");
        boolean zEquals = "keep".equals(packingOptions.getModificationTime());
        int i6 = 0;
        int i7 = Integer.MIN_VALUE;
        int i8 = 0;
        while (i8 < size) {
            Archive.PackingFile packingFile = (Archive.PackingFile) this.fileList.get(i8);
            String name = packingFile.getName();
            if (!name.endsWith(".class") || packingOptions.isPassFile(name)) {
                this.fileName[i8] = cpBands.getCPUtf8(name);
            } else {
                int[] iArr = this.file_options;
                iArr[i8] = iArr[i8] | 2;
                if (hashSet.contains(name.substring(i6, name.length() - 6))) {
                    this.fileName[i8] = cPUtf8;
                } else {
                    this.fileName[i8] = cpBands.getCPUtf8(name);
                }
            }
            if (packingOptions.isKeepDeflateHint() && packingFile.isDefalteHint()) {
                int[] iArr2 = this.file_options;
                iArr2[i8] = iArr2[i8] | 1;
            }
            this.file_size[i8] = packingFile.getContents().length;
            int i9 = i7;
            int modtime = (int) (((packingFile.getModtime() + ((long) TimeZone.getDefault().getRawOffset())) / 1000) - ((long) archive_modtime));
            this.file_modtime[i8] = modtime;
            i7 = (zEquals || i9 >= modtime) ? i9 : modtime;
            this.file_bits[i8] = packingFile.getContents();
            i8++;
            i6 = 0;
        }
        int i10 = i7;
        if (zEquals) {
            return;
        }
        for (int i11 = 0; i11 < size; i11++) {
            this.file_modtime[i11] = i10;
        }
    }

    private int[] flatten(byte[][] bArr) {
        int length = 0;
        for (byte[] bArr2 : bArr) {
            length += bArr2.length;
        }
        int[] iArr = new int[length];
        int i5 = 0;
        for (byte[] bArr3 : bArr) {
            int i6 = 0;
            while (true) {
                if (i6 < bArr3.length) {
                    iArr[i5] = bArr3[i6] & UnsignedBytes.MAX_VALUE;
                    i6++;
                    i5++;
                }
            }
        }
        return iArr;
    }

    public void finaliseBands() {
        this.file_name = new int[this.fileName.length];
        for (int i5 = 0; i5 < this.file_name.length; i5++) {
            if (this.fileName[i5].equals(this.cpBands.getCPUtf8(""))) {
                String name = ((Archive.PackingFile) this.fileList.get(i5)).getName();
                if (this.options.isPassFile(name)) {
                    this.fileName[i5] = this.cpBands.getCPUtf8(name);
                    int[] iArr = this.file_options;
                    iArr[i5] = iArr[i5] & (-3);
                }
            }
            this.file_name[i5] = this.fileName[i5].getIndex();
        }
    }

    @Override // org.apache.commons.compress.harmony.pack200.BandSet
    public void pack(OutputStream outputStream) {
        PackingUtils.log("Writing file bands...");
        int[] iArr = this.file_name;
        BHSDCodec bHSDCodec = Codec.UNSIGNED5;
        byte[] bArrEncodeBandInt = encodeBandInt("file_name", iArr, bHSDCodec);
        StringBuilder sbI = AbstractC1125a.i(outputStream, bArrEncodeBandInt, "Wrote ");
        sbI.append(bArrEncodeBandInt.length);
        sbI.append(" bytes from file_name[");
        AbstractC1125a.m("]", this.file_name.length, sbI);
        byte[] bArrEncodeFlags = encodeFlags("file_size", this.file_size, bHSDCodec, bHSDCodec, this.segmentHeader.have_file_size_hi());
        StringBuilder sbI2 = AbstractC1125a.i(outputStream, bArrEncodeFlags, "Wrote ");
        sbI2.append(bArrEncodeFlags.length);
        sbI2.append(" bytes from file_size[");
        AbstractC1125a.m("]", this.file_size.length, sbI2);
        if (this.segmentHeader.have_file_modtime()) {
            byte[] bArrEncodeBandInt2 = encodeBandInt("file_modtime", this.file_modtime, Codec.DELTA5);
            StringBuilder sbI3 = AbstractC1125a.i(outputStream, bArrEncodeBandInt2, "Wrote ");
            sbI3.append(bArrEncodeBandInt2.length);
            sbI3.append(" bytes from file_modtime[");
            AbstractC1125a.m("]", this.file_modtime.length, sbI3);
        }
        if (this.segmentHeader.have_file_options()) {
            byte[] bArrEncodeBandInt3 = encodeBandInt("file_options", this.file_options, bHSDCodec);
            StringBuilder sbI4 = AbstractC1125a.i(outputStream, bArrEncodeBandInt3, "Wrote ");
            sbI4.append(bArrEncodeBandInt3.length);
            sbI4.append(" bytes from file_options[");
            AbstractC1125a.m("]", this.file_options.length, sbI4);
        }
        byte[] bArrEncodeBandInt4 = encodeBandInt("file_bits", flatten(this.file_bits), Codec.BYTE1);
        StringBuilder sbI5 = AbstractC1125a.i(outputStream, bArrEncodeBandInt4, "Wrote ");
        sbI5.append(bArrEncodeBandInt4.length);
        sbI5.append(" bytes from file_bits[");
        AbstractC1125a.m("]", this.file_bits.length, sbI5);
    }
}
