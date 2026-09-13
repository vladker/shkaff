package org.apache.xmlbeans;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class XmlLineNumber extends XmlCursor.XmlBookmark {
    private int _column;
    private int _line;
    private int _offset;

    public XmlLineNumber(int i5) {
        this(i5, -1, -1);
    }

    public int getColumn() {
        return this._column;
    }

    public int getLine() {
        return this._line;
    }

    public int getOffset() {
        return this._offset;
    }

    public XmlLineNumber(int i5, int i6) {
        this(i5, i6, -1);
    }

    public XmlLineNumber(int i5, int i6, int i7) {
        super(false);
        this._line = i5;
        this._column = i6;
        this._offset = i7;
    }
}
