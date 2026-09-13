package org.apache.xmlbeans;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Map;
import javax.xml.namespace.QName;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface XmlCursor extends XmlTokenSource, AutoCloseable {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface ChangeStamp {
        boolean hasChanged();
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class TokenType {
        public static final int INT_ATTR = 6;
        public static final int INT_COMMENT = 8;
        public static final int INT_END = 4;
        public static final int INT_ENDDOC = 2;
        public static final int INT_NAMESPACE = 7;
        public static final int INT_NONE = 0;
        public static final int INT_PROCINST = 9;
        public static final int INT_START = 3;
        public static final int INT_STARTDOC = 1;
        public static final int INT_TEXT = 5;
        private String _name;
        private int _value;
        public static final TokenType NONE = new TokenType("NONE", 0);
        public static final TokenType STARTDOC = new TokenType("STARTDOC", 1);
        public static final TokenType ENDDOC = new TokenType("ENDDOC", 2);
        public static final TokenType START = new TokenType("START", 3);
        public static final TokenType END = new TokenType("END", 4);
        public static final TokenType TEXT = new TokenType("TEXT", 5);
        public static final TokenType ATTR = new TokenType("ATTR", 6);
        public static final TokenType NAMESPACE = new TokenType("NAMESPACE", 7);
        public static final TokenType COMMENT = new TokenType("COMMENT", 8);
        public static final TokenType PROCINST = new TokenType("PROCINST", 9);

        private TokenType(String str, int i5) {
            this._name = str;
            this._value = i5;
        }

        public int intValue() {
            return this._value;
        }

        public boolean isAnyAttr() {
            return this == NAMESPACE || this == ATTR;
        }

        public boolean isAttr() {
            return this == ATTR;
        }

        public boolean isComment() {
            return this == COMMENT;
        }

        public boolean isContainer() {
            return this == STARTDOC || this == START;
        }

        public boolean isEnd() {
            return this == END;
        }

        public boolean isEnddoc() {
            return this == ENDDOC;
        }

        public boolean isFinish() {
            return this == ENDDOC || this == END;
        }

        public boolean isNamespace() {
            return this == NAMESPACE;
        }

        public boolean isNone() {
            return this == NONE;
        }

        public boolean isProcinst() {
            return this == PROCINST;
        }

        public boolean isStart() {
            return this == START;
        }

        public boolean isStartdoc() {
            return this == STARTDOC;
        }

        public boolean isText() {
            return this == TEXT;
        }

        public String toString() {
            return this._name;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static abstract class XmlBookmark {
        public XmlMark _currentMark;
        public final Reference _ref;

        public XmlBookmark() {
            this(false);
        }

        public final XmlCursor createCursor() {
            XmlMark xmlMark = this._currentMark;
            if (xmlMark == null) {
                return null;
            }
            return xmlMark.createCursor();
        }

        public Object getKey() {
            return getClass();
        }

        public final XmlCursor toBookmark(XmlCursor xmlCursor) {
            return (xmlCursor == null || !xmlCursor.toBookmark(this)) ? createCursor() : xmlCursor;
        }

        public XmlBookmark(boolean z6) {
            this._ref = z6 ? new WeakReference(this) : null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface XmlMark {
        XmlCursor createCursor();
    }

    void addToSelection();

    void beginElement(String str);

    void beginElement(String str, String str2);

    void beginElement(QName qName);

    void clearBookmark(Object obj);

    void clearSelections();

    @Override // java.lang.AutoCloseable
    default void close() {
        dispose();
    }

    int comparePosition(XmlCursor xmlCursor);

    int copyChars(int i5, XmlCursor xmlCursor);

    boolean copyXml(XmlCursor xmlCursor);

    boolean copyXmlContents(XmlCursor xmlCursor);

    TokenType currentTokenType();

    @Deprecated
    void dispose();

    XmlCursor execQuery(String str);

    XmlCursor execQuery(String str, XmlOptions xmlOptions);

    void getAllBookmarkRefs(Collection<Object> collection);

    void getAllNamespaces(Map<String, String> map);

    String getAttributeText(QName qName);

    XmlBookmark getBookmark(Object obj);

    int getChars(char[] cArr, int i5, int i6);

    String getChars();

    ChangeStamp getDocChangeStamp();

    QName getName();

    XmlObject getObject();

    int getSelectionCount();

    int getTextValue(char[] cArr, int i5, int i6);

    String getTextValue();

    boolean hasNextSelection();

    boolean hasNextToken();

    boolean hasPrevToken();

    void insertAttribute(String str);

    void insertAttribute(String str, String str2);

    void insertAttribute(QName qName);

    void insertAttributeWithValue(String str, String str2);

    void insertAttributeWithValue(String str, String str2, String str3);

    void insertAttributeWithValue(QName qName, String str);

    void insertChars(String str);

    void insertComment(String str);

    void insertElement(String str);

    void insertElement(String str, String str2);

    void insertElement(QName qName);

    void insertElementWithText(String str, String str2);

    void insertElementWithText(String str, String str2, String str3);

    void insertElementWithText(QName qName, String str);

    void insertNamespace(String str, String str2);

    void insertProcInst(String str, String str2);

    boolean isAnyAttr();

    boolean isAtSamePositionAs(XmlCursor xmlCursor);

    boolean isAttr();

    boolean isComment();

    boolean isContainer();

    boolean isEnd();

    boolean isEnddoc();

    boolean isFinish();

    boolean isInSameDocument(XmlCursor xmlCursor);

    boolean isLeftOf(XmlCursor xmlCursor);

    boolean isNamespace();

    boolean isProcinst();

    boolean isRightOf(XmlCursor xmlCursor);

    boolean isStart();

    boolean isStartdoc();

    boolean isText();

    int moveChars(int i5, XmlCursor xmlCursor);

    boolean moveXml(XmlCursor xmlCursor);

    boolean moveXmlContents(XmlCursor xmlCursor);

    String namespaceForPrefix(String str);

    boolean pop();

    String prefixForNamespace(String str);

    TokenType prevTokenType();

    void push();

    boolean removeAttribute(QName qName);

    int removeChars(int i5);

    boolean removeXml();

    boolean removeXmlContents();

    void selectPath(String str);

    void selectPath(String str, XmlOptions xmlOptions);

    boolean setAttributeText(QName qName, String str);

    void setBookmark(XmlBookmark xmlBookmark);

    void setName(QName qName);

    void setTextValue(String str);

    void setTextValue(char[] cArr, int i5, int i6);

    boolean toBookmark(XmlBookmark xmlBookmark);

    boolean toChild(int i5);

    boolean toChild(String str);

    boolean toChild(String str, String str2);

    boolean toChild(QName qName);

    boolean toChild(QName qName, int i5);

    boolean toCursor(XmlCursor xmlCursor);

    void toEndDoc();

    TokenType toEndToken();

    boolean toFirstAttribute();

    boolean toFirstChild();

    TokenType toFirstContentToken();

    boolean toLastAttribute();

    boolean toLastChild();

    boolean toNextAttribute();

    XmlBookmark toNextBookmark(Object obj);

    int toNextChar(int i5);

    boolean toNextSelection();

    boolean toNextSibling();

    boolean toNextSibling(String str);

    boolean toNextSibling(String str, String str2);

    boolean toNextSibling(QName qName);

    TokenType toNextToken();

    boolean toParent();

    boolean toPrevAttribute();

    XmlBookmark toPrevBookmark(Object obj);

    int toPrevChar(int i5);

    boolean toPrevSibling();

    TokenType toPrevToken();

    boolean toSelection(int i5);

    void toStartDoc();
}
