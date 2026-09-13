package org.apache.poi.hpsf;

import androidx.collection.a;
import java.io.OutputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.util.CodePageUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianByteArrayInputStream;
import org.apache.poi.util.StringUtil;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public class UnicodeString {
    private static final Logger LOG = LogManager.getLogger((Class<?>) UnicodeString.class);
    private byte[] _value;

    public byte[] getValue() {
        return this._value;
    }

    public void read(LittleEndianByteArrayInputStream littleEndianByteArrayInputStream) {
        int i5 = littleEndianByteArrayInputStream.readInt();
        int i6 = i5 * 2;
        this._value = IOUtils.safelyAllocate(i6, CodePageString.getMaxRecordLength());
        if (i5 == 0) {
            return;
        }
        int readIndex = littleEndianByteArrayInputStream.getReadIndex();
        littleEndianByteArrayInputStream.readFully(this._value);
        byte[] bArr = this._value;
        if (bArr[i6 - 2] != 0 || bArr[i6 - 1] != 0) {
            throw new IllegalPropertySetDataException(a.i(readIndex, "UnicodeString started at offset #", " is not NULL-terminated"));
        }
        TypedPropertyValue.skipPadding(littleEndianByteArrayInputStream);
    }

    public void setJavaValue(String str) {
        this._value = CodePageUtil.getBytesInCodePage(str + WebViewProviderFactoryBoundaryInterface.MULTI_COOKIE_VALUE_SEPARATOR, 1200);
    }

    public String toJavaString() {
        byte[] bArr = this._value;
        if (bArr.length == 0) {
            return null;
        }
        String fromUnicodeLE = StringUtil.getFromUnicodeLE(bArr, 0, bArr.length >> 1);
        int iIndexOf = fromUnicodeLE.indexOf(0);
        if (iIndexOf == -1) {
            LOG.atWarn().log("String terminator (\\0) for UnicodeString property value not found. Continue without trimming and hope for the best.");
            return fromUnicodeLE;
        }
        if (iIndexOf != fromUnicodeLE.length() - 1) {
            LOG.atWarn().log("String terminator (\\0) for UnicodeString property value occured before the end of string. Trimming and hope for the best.");
        }
        return fromUnicodeLE.substring(0, iIndexOf);
    }

    public int write(OutputStream outputStream) {
        LittleEndian.putUInt(this._value.length / 2, outputStream);
        outputStream.write(this._value);
        return this._value.length + 4;
    }
}
