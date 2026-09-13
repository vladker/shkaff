package org.apache.commons.compress.archivers.dump;

import A3.AbstractC0157z;
import com.alibaba.android.arouter.utils.Consts;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class UnsupportedCompressionAlgorithmException extends DumpArchiveException {
    private static final long serialVersionUID = 1;

    public UnsupportedCompressionAlgorithmException() {
        super("this file uses an unsupported compression algorithm.");
    }

    public UnsupportedCompressionAlgorithmException(String str) {
        super(AbstractC0157z.o("this file uses an unsupported compression algorithm: ", str, Consts.DOT));
    }
}
