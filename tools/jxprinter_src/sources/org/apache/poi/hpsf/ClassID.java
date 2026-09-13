package org.apache.poi.hpsf;

import A3.AbstractC0157z;
import com.alibaba.android.arouter.utils.Consts;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.function.Supplier;
import l5.b2;
import org.apache.commons.math3.geometry.VectorFormat;
import org.apache.poi.common.Duplicatable;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ClassID implements Duplicatable, GenericRecord {
    public static final int LENGTH = 16;
    private final byte[] bytes;

    public ClassID(byte[] bArr, int i5) {
        this.bytes = new byte[16];
        read(bArr, i5);
    }

    public boolean equals(Object obj) {
        return (obj instanceof ClassID) && Arrays.equals(this.bytes, ((ClassID) obj).bytes);
    }

    public boolean equalsInverted(ClassID classID) {
        byte[] bArr = classID.bytes;
        byte b = bArr[0];
        byte[] bArr2 = this.bytes;
        return b == bArr2[3] && bArr[1] == bArr2[2] && bArr[2] == bArr2[1] && bArr[3] == bArr2[0] && bArr[4] == bArr2[5] && bArr[5] == bArr2[4] && bArr[6] == bArr2[7] && bArr[7] == bArr2[6] && bArr[8] == bArr2[8] && bArr[9] == bArr2[9] && bArr[10] == bArr2[10] && bArr[11] == bArr2[11] && bArr[12] == bArr2[12] && bArr[13] == bArr2[13] && bArr[14] == bArr2[14] && bArr[15] == bArr2[15];
    }

    public byte[] getBytes() {
        return this.bytes;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("uuid", new b2(this, 6));
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public int length() {
        return 16;
    }

    public byte[] read(byte[] bArr, int i5) {
        byte[] bArr2 = this.bytes;
        bArr2[0] = bArr[i5 + 3];
        bArr2[1] = bArr[i5 + 2];
        bArr2[2] = bArr[i5 + 1];
        bArr2[3] = bArr[i5];
        bArr2[4] = bArr[i5 + 5];
        bArr2[5] = bArr[i5 + 4];
        bArr2[6] = bArr[i5 + 7];
        bArr2[7] = bArr[i5 + 6];
        System.arraycopy(bArr, i5 + 8, bArr2, 8, 8);
        return this.bytes;
    }

    public void setBytes(byte[] bArr) {
        System.arraycopy(bArr, 0, this.bytes, 0, 16);
    }

    public String toString() {
        return VectorFormat.DEFAULT_PREFIX + toUUIDString() + VectorFormat.DEFAULT_SUFFIX;
    }

    public UUID toUUID() {
        return new UUID(ByteBuffer.wrap(this.bytes, 0, 8).getLong(), ByteBuffer.wrap(this.bytes, 8, 8).getLong());
    }

    public String toUUIDString() {
        return toUUID().toString().toUpperCase(Locale.ROOT);
    }

    public void write(byte[] bArr, int i5) {
        if (bArr.length < 16) {
            throw new ArrayStoreException(AbstractC0157z.l(Consts.DOT, bArr.length, new StringBuilder("Destination byte[] must have room for at least 16 bytes, but has a length of only ")));
        }
        byte[] bArr2 = this.bytes;
        bArr[i5] = bArr2[3];
        bArr[i5 + 1] = bArr2[2];
        bArr[i5 + 2] = bArr2[1];
        bArr[i5 + 3] = bArr2[0];
        bArr[i5 + 4] = bArr2[5];
        bArr[i5 + 5] = bArr2[4];
        bArr[i5 + 6] = bArr2[7];
        bArr[i5 + 7] = bArr2[6];
        System.arraycopy(bArr2, 8, bArr, i5 + 8, 8);
    }

    @Override // org.apache.poi.common.Duplicatable
    public ClassID copy() {
        return new ClassID(this);
    }

    public ClassID() {
        byte[] bArr = new byte[16];
        this.bytes = bArr;
        Arrays.fill(bArr, (byte) 0);
    }

    public ClassID(ClassID classID) {
        byte[] bArr = new byte[16];
        this.bytes = bArr;
        System.arraycopy(classID.bytes, 0, bArr, 0, bArr.length);
    }

    public ClassID(String str) {
        this.bytes = new byte[16];
        String strReplaceAll = str.replaceAll("[{}-]", "");
        int i5 = 0;
        while (i5 < strReplaceAll.length()) {
            int i6 = i5 + 2;
            this.bytes[i5 / 2] = (byte) Integer.parseInt(strReplaceAll.substring(i5, i6), 16);
            i5 = i6;
        }
    }

    public ClassID(LittleEndianInput littleEndianInput) {
        byte[] bArr = new byte[16];
        this.bytes = bArr;
        byte[] bArr2 = (byte[]) bArr.clone();
        littleEndianInput.readFully(bArr2);
        read(bArr2, 0);
    }

    public void write(LittleEndianOutput littleEndianOutput) {
        byte[] bArr = (byte[]) this.bytes.clone();
        write(bArr, 0);
        littleEndianOutput.write(bArr);
    }
}
