package org.apache.poi.hpsf;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Unbox;
import org.apache.poi.util.CodePageUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianByteArrayInputStream;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public class CodePageString {
    private static final int DEFAULT_MAX_RECORD_LENGTH = 100000;
    private static final Logger LOG = LogManager.getLogger((Class<?>) CodePageString.class);
    private static int MAX_RECORD_LENGTH = 100000;
    private byte[] _value;

    public static int getMaxRecordLength() {
        return MAX_RECORD_LENGTH;
    }

    public static void setMaxRecordLength(int i5) {
        MAX_RECORD_LENGTH = i5;
    }

    public String getJavaValue(int i5) {
        if (i5 == -1) {
            i5 = 1252;
        }
        String stringFromCodePage = CodePageUtil.getStringFromCodePage(this._value, i5);
        int iIndexOf = stringFromCodePage.indexOf(0);
        if (iIndexOf == -1) {
            LOG.atWarn().log("String terminator (\\0) for CodePageString property value not found. Continue without trimming and hope for the best.");
            return stringFromCodePage;
        }
        if (iIndexOf != stringFromCodePage.length() - 1) {
            LOG.atDebug().log("String terminator (\\0) for CodePageString property value occurred before the end of string. Trimming and hope for the best.");
        }
        return stringFromCodePage.substring(0, iIndexOf);
    }

    public int getSize() {
        return this._value.length + 4;
    }

    public void read(LittleEndianByteArrayInputStream littleEndianByteArrayInputStream) {
        int readIndex = littleEndianByteArrayInputStream.getReadIndex();
        int i5 = littleEndianByteArrayInputStream.readInt();
        byte[] bArrSafelyAllocate = IOUtils.safelyAllocate(i5, MAX_RECORD_LENGTH);
        this._value = bArrSafelyAllocate;
        if (i5 == 0) {
            return;
        }
        littleEndianByteArrayInputStream.readFully(bArrSafelyAllocate);
        if (this._value[i5 - 1] != 0) {
            LOG.atWarn().log("CodePageString started at offset #{} is not NULL-terminated", Unbox.box(readIndex));
        }
        TypedPropertyValue.skipPadding(littleEndianByteArrayInputStream);
    }

    public void setJavaValue(String str, int i5) {
        if (i5 == -1) {
            i5 = 1252;
        }
        this._value = CodePageUtil.getBytesInCodePage(str + WebViewProviderFactoryBoundaryInterface.MULTI_COOKIE_VALUE_SEPARATOR, i5);
    }

    public int write(OutputStream outputStream) throws IOException {
        LittleEndian.putUInt(this._value.length, outputStream);
        outputStream.write(this._value);
        return this._value.length + 4;
    }
}
