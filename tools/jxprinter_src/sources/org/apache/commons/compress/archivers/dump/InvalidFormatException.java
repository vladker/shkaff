package org.apache.commons.compress.archivers.dump;

import androidx.exifinterface.media.a;
import com.alibaba.android.arouter.utils.Consts;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class InvalidFormatException extends DumpArchiveException {
    private static final long serialVersionUID = 1;
    protected long offset;

    public InvalidFormatException() {
        super("there was an error decoding a tape segment");
    }

    public long getOffset() {
        return this.offset;
    }

    public InvalidFormatException(long j6) {
        super(a.k("there was an error decoding a tape segment header at offset ", j6, Consts.DOT));
        this.offset = j6;
    }
}
