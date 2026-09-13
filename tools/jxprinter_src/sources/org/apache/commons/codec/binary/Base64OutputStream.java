package org.apache.commons.codec.binary;

import java.io.OutputStream;
import org.apache.commons.codec.CodecPolicy;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Base64OutputStream extends BaseNCodecOutputStream {
    public Base64OutputStream(OutputStream outputStream) {
        this(outputStream, true);
    }

    public Base64OutputStream(OutputStream outputStream, boolean z6) {
        super(outputStream, new Base64(false), z6);
    }

    public Base64OutputStream(OutputStream outputStream, boolean z6, int i5, byte[] bArr) {
        super(outputStream, new Base64(i5, bArr), z6);
    }

    public Base64OutputStream(OutputStream outputStream, boolean z6, int i5, byte[] bArr, CodecPolicy codecPolicy) {
        super(outputStream, new Base64(i5, bArr, false, codecPolicy), z6);
    }
}
