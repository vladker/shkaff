package org.apache.poi.hpsf;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Unbox;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianByteArrayInputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public class ClipboardData {
    private static final int DEFAULT_MAX_RECORD_LENGTH = 100000000;
    private static final Logger LOG = LogManager.getLogger((Class<?>) ClipboardData.class);
    private static int MAX_RECORD_LENGTH = 100000000;
    private int _format;
    private byte[] _value;

    public static int getMaxRecordLength() {
        return MAX_RECORD_LENGTH;
    }

    public static void setMaxRecordLength(int i5) {
        MAX_RECORD_LENGTH = i5;
    }

    public byte[] getValue() {
        return this._value;
    }

    public void read(LittleEndianByteArrayInputStream littleEndianByteArrayInputStream) {
        int readIndex = littleEndianByteArrayInputStream.getReadIndex();
        long j6 = littleEndianByteArrayInputStream.readInt();
        if (j6 < 4) {
            LOG.atWarn().log("ClipboardData at offset {} size less than 4 bytes (doesn't even have format field!). Setting to format == 0 and hope for the best", Unbox.box(readIndex));
            this._format = 0;
            this._value = new byte[0];
        } else {
            this._format = littleEndianByteArrayInputStream.readInt();
            byte[] bArrSafelyAllocate = IOUtils.safelyAllocate(j6 - 4, MAX_RECORD_LENGTH);
            this._value = bArrSafelyAllocate;
            littleEndianByteArrayInputStream.readFully(bArrSafelyAllocate);
        }
    }

    public void setValue(byte[] bArr) {
        this._value = (byte[]) bArr.clone();
    }

    public byte[] toByteArray() {
        byte[] bArr = this._value;
        byte[] bArr2 = new byte[bArr.length + 8];
        LittleEndian.putInt(bArr2, 0, bArr.length + 4);
        LittleEndian.putInt(bArr2, 4, this._format);
        byte[] bArr3 = this._value;
        System.arraycopy(bArr3, 0, bArr2, 8, bArr3.length);
        return bArr2;
    }
}
