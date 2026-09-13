package org.apache.commons.codec.binary;

import java.io.InputStream;
import org.apache.commons.codec.CodecPolicy;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Base64InputStream extends BaseNCodecInputStream {
    public Base64InputStream(InputStream inputStream) {
        this(inputStream, false);
    }

    public Base64InputStream(InputStream inputStream, boolean z6) {
        super(inputStream, new Base64(false), z6);
    }

    public Base64InputStream(InputStream inputStream, boolean z6, int i5, byte[] bArr) {
        super(inputStream, new Base64(i5, bArr), z6);
    }

    public Base64InputStream(InputStream inputStream, boolean z6, int i5, byte[] bArr, CodecPolicy codecPolicy) {
        super(inputStream, new Base64(i5, bArr, false, codecPolicy), z6);
    }
}
