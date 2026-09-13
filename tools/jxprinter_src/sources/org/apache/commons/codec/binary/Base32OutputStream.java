package org.apache.commons.codec.binary;

import java.io.OutputStream;
import org.apache.commons.codec.CodecPolicy;
import org.apache.poi.ss.formula.ptg.DeletedArea3DPtg;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Base32OutputStream extends BaseNCodecOutputStream {
    public Base32OutputStream(OutputStream outputStream) {
        this(outputStream, true);
    }

    public Base32OutputStream(OutputStream outputStream, boolean z6) {
        super(outputStream, new Base32(false), z6);
    }

    public Base32OutputStream(OutputStream outputStream, boolean z6, int i5, byte[] bArr) {
        super(outputStream, new Base32(i5, bArr), z6);
    }

    public Base32OutputStream(OutputStream outputStream, boolean z6, int i5, byte[] bArr, CodecPolicy codecPolicy) {
        super(outputStream, new Base32(i5, bArr, false, DeletedArea3DPtg.sid, codecPolicy), z6);
    }
}
