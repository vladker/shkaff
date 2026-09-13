package org.apache.poi.hpsf;

import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public class Blob {
    private static final int DEFAULT_MAX_RECORD_LENGTH = 10000000;
    private static int MAX_RECORD_LENGTH = 10000000;
    private byte[] _value;

    public static int getMaxRecordLength() {
        return MAX_RECORD_LENGTH;
    }

    public static void setMaxRecordLength(int i5) {
        MAX_RECORD_LENGTH = i5;
    }

    public void read(LittleEndianInput littleEndianInput) {
        int i5 = littleEndianInput.readInt();
        byte[] bArrSafelyAllocate = IOUtils.safelyAllocate(i5, MAX_RECORD_LENGTH);
        this._value = bArrSafelyAllocate;
        if (i5 > 0) {
            littleEndianInput.readFully(bArrSafelyAllocate);
        }
    }
}
