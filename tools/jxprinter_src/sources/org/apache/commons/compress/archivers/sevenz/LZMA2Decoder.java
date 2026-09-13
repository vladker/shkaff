package org.apache.commons.compress.archivers.sevenz;

import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.compress.MemoryLimitException;
import org.tukaani.xz.FinishableWrapperOutputStream;
import org.tukaani.xz.LZMA2InputStream;
import org.tukaani.xz.LZMA2Options;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class LZMA2Decoder extends CoderBase {
    public LZMA2Decoder() {
        super(LZMA2Options.class, Number.class);
    }

    private int getDictSize(Object obj) {
        return obj instanceof LZMA2Options ? ((LZMA2Options) obj).getDictSize() : numberOptionOrDefault(obj);
    }

    private int getDictionarySize(Coder coder) throws IOException {
        byte[] bArr = coder.properties;
        if (bArr == null) {
            throw new IOException("Missing LZMA2 properties");
        }
        if (bArr.length < 1) {
            throw new IOException("LZMA2 properties too short");
        }
        byte b = bArr[0];
        int i5 = b & UnsignedBytes.MAX_VALUE;
        if ((b & 192) != 0) {
            throw new IOException("Unsupported LZMA2 property bits");
        }
        if (i5 > 40) {
            throw new IOException("Dictionary larger than 4GiB maximum size");
        }
        if (i5 == 40) {
            return -1;
        }
        return ((b & 1) | 2) << ((i5 / 2) + 11);
    }

    private LZMA2Options getOptions(Object obj) {
        if (obj instanceof LZMA2Options) {
            return (LZMA2Options) obj;
        }
        LZMA2Options lZMA2Options = new LZMA2Options();
        lZMA2Options.setDictSize(numberOptionOrDefault(obj));
        return lZMA2Options;
    }

    private int numberOptionOrDefault(Object obj) {
        return CoderBase.numberOptionOrDefault(obj, 8388608);
    }

    @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
    public InputStream decode(String str, InputStream inputStream, long j6, Coder coder, byte[] bArr, int i5) throws IOException {
        try {
            int dictionarySize = getDictionarySize(coder);
            int memoryUsage = LZMA2InputStream.getMemoryUsage(dictionarySize);
            if (memoryUsage <= i5) {
                return new LZMA2InputStream(inputStream, dictionarySize);
            }
            throw new MemoryLimitException(memoryUsage, i5);
        } catch (IllegalArgumentException e) {
            throw new IOException(e.getMessage());
        }
    }

    @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
    public OutputStream encode(OutputStream outputStream, Object obj) {
        return getOptions(obj).getOutputStream(new FinishableWrapperOutputStream(outputStream));
    }

    @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
    public byte[] getOptionsAsProperties(Object obj) {
        int dictSize = getDictSize(obj);
        int iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(dictSize);
        return new byte[]{(byte) (((19 - iNumberOfLeadingZeros) * 2) + ((dictSize >>> (30 - iNumberOfLeadingZeros)) - 2))};
    }

    @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
    public Object getOptionsFromCoder(Coder coder, InputStream inputStream) {
        return Integer.valueOf(getDictionarySize(coder));
    }
}
