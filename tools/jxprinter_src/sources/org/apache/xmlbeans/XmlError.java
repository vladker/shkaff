package org.apache.xmlbeans;

import io.flutter.plugins.firebase.crashlytics.Constants;
import java.io.File;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javax.xml.stream.Location;
import org.apache.xmlbeans.impl.common.NameUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class XmlError implements Serializable {
    public static final int SEVERITY_ERROR = 0;
    public static final int SEVERITY_INFO = 2;
    public static final int SEVERITY_WARNING = 1;
    private static final ResourceBundle _bundle = ResourceBundle.getBundle("org.apache.xmlbeans.message", Locale.ROOT);
    private static final long serialVersionUID = 1;
    private final String _code;
    private final int _column;
    private transient XmlCursor _cursor;
    private final int _line;
    private final String _message;
    private int _offset;
    private final int _severity;
    private final String _source;

    public XmlError(XmlError xmlError) {
        this._offset = -1;
        this._message = xmlError.getMessage();
        this._code = xmlError.getErrorCode();
        this._severity = xmlError.getSeverity();
        this._source = xmlError.getSourceName();
        this._line = xmlError.getLine();
        this._column = xmlError.getColumn();
        this._offset = xmlError.getOffset();
        this._cursor = xmlError.getCursorLocation();
    }

    public static XmlError forCursor(String str, XmlCursor xmlCursor) {
        return forCursor(str, 0, xmlCursor);
    }

    public static XmlError forLocation(String str, String str2, Location location) {
        return new XmlError(str, (String) null, 0, str2, location.getLineNumber(), location.getColumnNumber(), -1, (XmlCursor) null);
    }

    public static XmlError forLocationAndCursor(String str, int i5, String str2, int i6, int i7, int i8, XmlCursor xmlCursor) {
        return new XmlError(str, (String) null, i5, str2, i6, i7, i8, xmlCursor);
    }

    public static XmlError forMessage(String str) {
        return forMessage(str, 0);
    }

    public static XmlError forObject(String str, XmlObject xmlObject) {
        return forObject(str, 0, xmlObject);
    }

    public static XmlError forSource(String str, String str2) {
        return forLocation(str, 0, str2, -1, -1, -1);
    }

    public static String formattedFileName(String str, URI uri) {
        URI uriRelativize = null;
        if (str == null) {
            return null;
        }
        try {
            URI uri2 = new URI(str);
            if (uri2.isAbsolute()) {
                uriRelativize = uri2;
            }
        } catch (URISyntaxException unused) {
        }
        if (uriRelativize == null) {
            uriRelativize = new File(str).toURI();
        }
        if (uri != null) {
            uriRelativize = uri.relativize(uriRelativize);
        }
        if (!uriRelativize.isAbsolute() ? !(uri == null || !uri.isAbsolute() || uri.getScheme().compareToIgnoreCase(Constants.FILE) != 0) : uriRelativize.getScheme().compareToIgnoreCase(Constants.FILE) == 0) {
            try {
                return new File(uriRelativize).toString();
            } catch (Exception unused2) {
            }
        }
        return uriRelativize.toString();
    }

    public static String formattedMessage(String str, Object[] objArr) {
        if (str == null) {
            return null;
        }
        try {
            return new MessageFormat(_bundle.getString(str), Locale.ROOT).format(objArr);
        } catch (IllegalArgumentException | MissingResourceException e) {
            return new MessageFormat(_bundle.getString(e instanceof MissingResourceException ? "message.missing.resource" : "message.pattern.invalid"), Locale.ROOT).format(e.getMessage());
        }
    }

    public static String severityAsString(int i5) {
        if (i5 == 0) {
            return "error";
        }
        if (i5 == 1) {
            return "warning";
        }
        if (i5 == 2) {
            return "info";
        }
        throw new IllegalArgumentException("unknown severity");
    }

    public int getColumn() {
        return this._column;
    }

    public XmlCursor getCursorLocation() {
        return (XmlCursor) getLocation(XmlCursor.class);
    }

    public String getErrorCode() {
        return this._code;
    }

    public int getLine() {
        return this._line;
    }

    public Object getLocation(Object obj) {
        XmlCursor xmlCursor;
        if (obj == XmlCursor.class) {
            return this._cursor;
        }
        if (obj != XmlObject.class || (xmlCursor = this._cursor) == null) {
            return null;
        }
        return xmlCursor.getObject();
    }

    public String getMessage() {
        return this._message;
    }

    public XmlObject getObjectLocation() {
        return (XmlObject) getLocation(XmlObject.class);
    }

    public int getOffset() {
        return this._offset;
    }

    public int getSeverity() {
        return this._severity;
    }

    public String getSourceName() {
        return this._source;
    }

    public String toString() {
        return toString(null);
    }

    public static XmlError forCursor(String str, Object[] objArr, XmlCursor xmlCursor) {
        return forCursor(str, objArr, 0, xmlCursor);
    }

    public static XmlError forMessage(String str, int i5) {
        return forSource(str, i5, null);
    }

    public static XmlError forObject(String str, Object[] objArr, XmlObject xmlObject) {
        return forObject(str, objArr, 0, xmlObject);
    }

    public static XmlError forSource(String str, int i5, String str2) {
        return forLocation(str, i5, str2, -1, -1, -1);
    }

    public String toString(URI uri) {
        StringBuilder sb = new StringBuilder();
        String str = formattedFileName(getSourceName(), uri);
        if (str != null) {
            sb.append(str);
            int line = getLine();
            if (line < 0) {
                line = 0;
            }
            sb.append(NameUtil.COLON);
            sb.append(line);
            sb.append(NameUtil.COLON);
            if (getColumn() > 0) {
                sb.append(getColumn());
                sb.append(NameUtil.COLON);
            }
            sb.append(" ");
        }
        int severity = getSeverity();
        if (severity == 0) {
            sb.append("error: ");
        } else if (severity == 1) {
            sb.append("warning: ");
        }
        if (getErrorCode() != null) {
            sb.append(getErrorCode());
            sb.append(": ");
        }
        String message = getMessage();
        if (message == null) {
            message = "<Unspecified message>";
        }
        sb.append(message);
        return sb.toString();
    }

    public static XmlError forCursor(String str, int i5, XmlCursor xmlCursor) {
        return new XmlError(str, (String) null, i5, xmlCursor);
    }

    public static XmlError forLocation(String str, String str2, int i5, int i6, int i7) {
        return new XmlError(str, (String) null, 0, str2, i5, i6, i7, (XmlCursor) null);
    }

    public static XmlError forMessage(String str, Object[] objArr) {
        return forSource(str, objArr, 0, null);
    }

    public static XmlError forObject(String str, int i5, XmlObject xmlObject) {
        if (xmlObject == null) {
            return forMessage(str, i5);
        }
        return forCursor(str, i5, xmlObject.newCursor());
    }

    public static XmlError forSource(String str, Object[] objArr, int i5, String str2) {
        return forLocation(str, objArr, i5, str2, -1, -1, -1);
    }

    public static XmlError forCursor(String str, Object[] objArr, int i5, XmlCursor xmlCursor) {
        return new XmlError(str, objArr, i5, xmlCursor);
    }

    public static XmlError forLocation(String str, Object[] objArr, int i5, String str2, int i6, int i7, int i8) {
        return new XmlError(str, objArr, i5, str2, i6, i7, i8, (XmlCursor) null);
    }

    public static XmlError forMessage(String str, Object[] objArr, int i5) {
        return forSource(str, objArr, i5, null);
    }

    public static XmlError forLocation(String str, int i5, String str2, int i6, int i7, int i8) {
        return new XmlError(str, (String) null, i5, str2, i6, i7, i8, (XmlCursor) null);
    }

    public static XmlError forObject(String str, Object[] objArr, int i5, XmlObject xmlObject) {
        if (xmlObject == null) {
            return forMessage(str, objArr, i5);
        }
        return forCursor(str, objArr, i5, xmlObject.newCursor());
    }

    private XmlError(String str, String str2, int i5, String str3, int i6, int i7, int i8, XmlCursor xmlCursor) {
        this._message = str;
        this._code = str2;
        this._severity = i5;
        this._source = str3;
        this._line = i6;
        this._column = i7;
        this._offset = i8;
        this._cursor = xmlCursor;
    }

    private XmlError(String str, Object[] objArr, int i5, String str2, int i6, int i7, int i8, XmlCursor xmlCursor) {
        this(formattedMessage(str, objArr), str, i5, str2, i6, i7, i8, xmlCursor);
    }

    public XmlError(String str, String str2, int i5, XmlCursor xmlCursor) {
        String sourceName;
        int column;
        int offset;
        int line = -1;
        this._offset = -1;
        if (xmlCursor != null) {
            sourceName = xmlCursor.documentProperties().getSourceName();
            XmlCursor xmlCursorNewCursor = xmlCursor.newCursor();
            try {
                XmlLineNumber xmlLineNumber = (XmlLineNumber) xmlCursorNewCursor.getBookmark(XmlLineNumber.class);
                xmlLineNumber = xmlLineNumber == null ? (XmlLineNumber) xmlCursorNewCursor.toPrevBookmark(XmlLineNumber.class) : xmlLineNumber;
                if (xmlLineNumber != null) {
                    line = xmlLineNumber.getLine();
                    column = xmlLineNumber.getColumn();
                    offset = xmlLineNumber.getOffset();
                } else {
                    column = -1;
                    offset = -1;
                }
                xmlCursorNewCursor.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (xmlCursorNewCursor != null) {
                        try {
                            xmlCursorNewCursor.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        } else {
            sourceName = null;
            column = -1;
            offset = -1;
        }
        this._message = str;
        this._code = str2;
        this._severity = i5;
        this._source = sourceName;
        this._line = line;
        this._column = column;
        this._offset = offset;
        this._cursor = xmlCursor;
    }

    public XmlError(String str, Object[] objArr, int i5, XmlCursor xmlCursor) {
        this(formattedMessage(str, objArr), str, i5, xmlCursor);
    }

    public XmlError(String str, String str2, int i5, Location location) {
        String publicId;
        int columnNumber;
        int lineNumber = -1;
        this._offset = -1;
        if (location != null) {
            lineNumber = location.getLineNumber();
            columnNumber = location.getColumnNumber();
            publicId = location.getPublicId();
            if (publicId == null) {
                publicId = location.getSystemId();
            }
        } else {
            publicId = null;
            columnNumber = -1;
        }
        this._message = str;
        this._code = str2;
        this._severity = i5;
        this._source = publicId;
        this._line = lineNumber;
        this._column = columnNumber;
    }

    public XmlError(String str, Object[] objArr, int i5, Location location) {
        this(formattedMessage(str, objArr), str, i5, location);
    }
}
