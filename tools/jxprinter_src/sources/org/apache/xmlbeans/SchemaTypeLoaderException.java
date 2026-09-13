package org.apache.xmlbeans;

import androidx.exifinterface.media.a;
import com.alibaba.android.arouter.utils.Consts;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class SchemaTypeLoaderException extends XmlRuntimeException {
    public static final int BAD_HANDLE = 13;
    public static final int BAD_PARTICLE_TYPE = 11;
    public static final int INT_TOO_LARGE = 10;
    public static final int IO_EXCEPTION = 9;
    public static final int MALFORMED_CONTENT_MODEL = 7;
    public static final int NESTED_EXCEPTION = 14;
    public static final int NOT_WRITEABLE = 12;
    public static final int NO_RESOURCE = 0;
    public static final int UNRECOGNIZED_INDEX_ENTRY = 5;
    public static final int WRONG_FILE_TYPE = 4;
    public static final int WRONG_MAGIC_COOKIE = 1;
    public static final int WRONG_MAJOR_VERSION = 2;
    public static final int WRONG_MINOR_VERSION = 3;
    public static final int WRONG_PROPERTY_TYPE = 6;
    public static final int WRONG_SIMPLE_VARIETY = 8;
    private int _code;

    public SchemaTypeLoaderException(String str, String str2, String str3, int i5) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" (");
        sb.append(str2);
        sb.append(Consts.DOT);
        sb.append(str3);
        super(a.q(sb, ") - code ", i5));
        this._code = i5;
    }

    public int getCode() {
        return this._code;
    }

    public SchemaTypeLoaderException(String str, String str2, String str3, int i5, Exception exc) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" (");
        sb.append(str2);
        sb.append(Consts.DOT);
        sb.append(str3);
        super(a.q(sb, ") - code ", i5));
        this._code = i5;
        initCause(exc);
    }
}
