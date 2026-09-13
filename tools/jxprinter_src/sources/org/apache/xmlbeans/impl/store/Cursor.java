package org.apache.xmlbeans.impl.store;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Collection;
import java.util.Map;
import java.util.function.Supplier;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlDocumentProperties;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.GlobalLock;
import org.apache.xmlbeans.impl.common.XMLChar;
import org.apache.xmlbeans.impl.xpath.XPathEngine;
import org.apache.xmlbeans.impl.xpath.XPathFactory;
import org.w3c.dom.Node;
import org.xml.sax.ContentHandler;
import org.xml.sax.ext.LexicalHandler;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class Cursor implements XmlCursor, Locale.ChangeListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int ATTR = 3;
    static final int COMMENT = 4;
    private static final int COPY_CHARS = 5;
    private static final int COPY_XML = 1;
    private static final int COPY_XML_CONTENTS = 3;
    static final int ELEM = 2;
    private static final int MOVE_CHARS = 4;
    private static final int MOVE_XML = 0;
    private static final int MOVE_XML_CONTENTS = 2;
    static final int PROCINST = 5;
    static final int ROOT = 1;
    static final int TEXT = 0;
    private Cur _cur;
    private int _currentSelection;
    private Locale.ChangeListener _nextChangeListener;
    private XPathEngine _pathEngine;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class ChangeStampImpl implements XmlCursor.ChangeStamp {
        private final Locale _locale;
        private final long _versionStamp;

        public ChangeStampImpl(Locale locale) {
            this._locale = locale;
            this._versionStamp = locale.version();
        }

        @Override // org.apache.xmlbeans.XmlCursor.ChangeStamp
        public boolean hasChanged() {
            return this._versionStamp != this._locale.version();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface WrapIOEx {
        void run();
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface WrapSAXEx {
        void run();
    }

    public Cursor(Xobj xobj, int i5) {
        Cur curWeakCur = xobj._locale.weakCur(this);
        this._cur = curWeakCur;
        curWeakCur.moveTo(xobj, i5);
        this._currentSelection = -1;
    }

    private boolean checkContentInsertionValidity(Cursor cursor) {
        this._cur.push();
        this._cur.next();
        if (this._cur.isFinish()) {
            this._cur.pop();
            return false;
        }
        try {
            cursor.checkInsertionValidity(this._cur);
            this._cur.pop();
            return true;
        } catch (IllegalArgumentException e) {
            this._cur.pop();
            throw e;
        }
    }

    private Cursor checkCursors(XmlCursor xmlCursor) {
        checkThisCursor();
        if (xmlCursor == null) {
            throw new IllegalArgumentException("Other cursor is <null>");
        }
        if (!(xmlCursor instanceof Cursor)) {
            throw new IllegalArgumentException("Incompatible cursors: " + xmlCursor);
        }
        Cursor cursor = (Cursor) xmlCursor;
        if (cursor._cur != null) {
            return cursor;
        }
        throw new IllegalStateException("Other cursor has been disposed");
    }

    private void checkInsertionValidity(Cur cur) {
        int iKind = cur.kind();
        if (iKind < 0) {
            complain("Can't move/copy/insert an end token.");
        }
        if (iKind == 1) {
            complain("Can't move/copy/insert a whole document.");
        }
        int iKind2 = this._cur.kind();
        if (iKind2 == 1) {
            complain("Can't insert before the start of the document.");
        }
        if (iKind == 3) {
            this._cur.push();
            this._cur.prevWithAttrs();
            int iKind3 = this._cur.kind();
            this._cur.pop();
            if (iKind3 != 2 && iKind3 != 1 && iKind3 != -3) {
                complain("Can only insert attributes before other attributes or after containers.");
            }
        }
        if (iKind2 != 3 || iKind == 3) {
            return;
        }
        complain("Can only insert attributes before other attributes or after containers.");
    }

    private void checkThisCursor() {
        if (this._cur == null) {
            throw new IllegalStateException("This cursor has been disposed");
        }
    }

    private static void complain(String str) {
        throw new IllegalArgumentException(str);
    }

    public static XmlCursor.XmlBookmark getBookmark(Object obj, Cur cur) {
        if (obj == null) {
            return null;
        }
        Object bookmark = cur.getBookmark(obj);
        if (bookmark instanceof XmlCursor.XmlBookmark) {
            return (XmlCursor.XmlBookmark) bookmark;
        }
        return null;
    }

    private void insertNode(Cur cur, String str) {
        if (str != null && str.length() > 0) {
            cur.next();
            cur.insertString(str);
            cur.toParent();
        }
        checkInsertionValidity(cur);
        cur.moveNode(this._cur);
        this._cur.toEnd();
        this._cur.nextWithAttrs();
    }

    private boolean isDomFragment() {
        if (!isStartdoc()) {
            return true;
        }
        XmlCursor xmlCursorNewCursor = newCursor();
        try {
            int iIntValue = xmlCursorNewCursor.toNextToken().intValue();
            boolean z6 = false;
            while (true) {
                switch (iIntValue) {
                    case 0:
                    case 1:
                    case 2:
                        xmlCursorNewCursor.close();
                        return !z6;
                    case 3:
                        if (z6) {
                            xmlCursorNewCursor.close();
                            return true;
                        }
                        iIntValue = xmlCursorNewCursor.toEndToken().intValue();
                        z6 = true;
                        continue;
                        break;
                    case 4:
                    case 8:
                    case 9:
                        iIntValue = xmlCursorNewCursor.toNextToken().intValue();
                        continue;
                    case 5:
                        if (!Locale.isWhiteSpace(xmlCursorNewCursor.getChars())) {
                            xmlCursorNewCursor.close();
                            return true;
                        }
                        iIntValue = xmlCursorNewCursor.toNextToken().intValue();
                        continue;
                        break;
                    case 6:
                    case 7:
                        xmlCursorNewCursor.close();
                        return true;
                    default:
                        continue;
                }
                try {
                    throw th;
                } catch (Throwable th) {
                    if (xmlCursorNewCursor != null) {
                        try {
                            xmlCursorNewCursor.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th3) {
            throw th3;
        }
    }

    private static boolean isValid(Cur cur) {
        int iKind;
        if (cur.kind() > 0) {
            return true;
        }
        cur.push();
        if (cur.toParentRaw() && ((iKind = cur.kind()) == 4 || iKind == 5 || iKind == 3)) {
            return false;
        }
        cur.pop();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer lambda$comparePosition$2(Cursor cursor) {
        return Integer.valueOf(_comparePosition(cursor));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer lambda$getChars$45(char[] cArr, int i5, int i6) {
        return Integer.valueOf(_getChars(cArr, i5, i6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer lambda$getTextValue$42(char[] cArr, int i5, int i6) {
        return Integer.valueOf(_getTextValue(cArr, i5, i6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$isAtSamePositionAs$4(Cursor cursor) {
        return Boolean.valueOf(_isAtSamePositionAs(cursor));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$isLeftOf$3(Cursor cursor) {
        return Boolean.valueOf(_isLeftOf(cursor));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$isRightOf$5(Cursor cursor) {
        return Boolean.valueOf(_isRightOf(cursor));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$removeAttribute$41(QName qName) {
        return Boolean.valueOf(_removeAttribute(qName));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer lambda$removeChars$52(int i5) {
        return Integer.valueOf(_removeChars(i5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$setAttributeText$40(QName qName, String str) {
        return Boolean.valueOf(_setAttributeText(qName, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$toBookmark$22(XmlCursor.XmlBookmark xmlBookmark) {
        return Boolean.valueOf(_toBookmark(xmlBookmark));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$toChild$31(String str) {
        return Boolean.valueOf(_toChild(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$toChild$32(String str, String str2) {
        return Boolean.valueOf(_toChild(str, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$toChild$33(QName qName) {
        return Boolean.valueOf(_toChild(qName));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$toChild$34(int i5) {
        return Boolean.valueOf(_toChild(i5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$toChild$35(QName qName, int i5) {
        return Boolean.valueOf(_toChild(qName, i5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$toCursor$1(Cursor cursor) {
        return Boolean.valueOf(_toCursor(cursor));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer lambda$toNextChar$29(int i5) {
        return Integer.valueOf(_toNextChar(i5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$toNextSibling$36(String str) {
        return Boolean.valueOf(_toNextSibling(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$toNextSibling$37(String str, String str2) {
        return Boolean.valueOf(_toNextSibling(str, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$toNextSibling$38(QName qName) {
        return Boolean.valueOf(_toNextSibling(qName));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer lambda$toPrevChar$30(int i5) {
        return Integer.valueOf(_toPrevChar(i5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$toSelection$21(int i5) {
        return Boolean.valueOf(_toSelection(i5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer lambda$twoLocaleOp$0(Cursor cursor, int i5, int i6) {
        return Integer.valueOf(twoLocaleOp(cursor, i5, i6));
    }

    public static XmlCursor newCursor(Xobj xobj, int i5) {
        Cursor cursor;
        Locale locale = xobj._locale;
        if (locale.noSync()) {
            locale.enter();
            try {
                return new Cursor(xobj, i5);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    cursor = new Cursor(xobj, i5);
                    locale.exit();
                } catch (Throwable th) {
                    locale.exit();
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return cursor;
    }

    private Cursor preCheck(XmlCursor xmlCursor) {
        Cursor cursorCheckCursors = checkCursors(xmlCursor);
        if (this._cur._locale == cursorCheckCursors._cur._locale) {
            return cursorCheckCursors;
        }
        throw new IllegalArgumentException("Cursors not in same document");
    }

    private void setTextValue(Object obj, int i5, int i6) {
        if (!this._cur.isNode()) {
            throw new IllegalStateException("Can't set text value, current token can have no text value");
        }
        this._cur.moveNodeContents(null, false);
        this._cur.next();
        this._cur.insertChars(obj, i5, i6);
        this._cur.toParent();
    }

    private void syncWrap(Runnable runnable) {
        if (preCheck()) {
            syncWrapHelper(runnable, true);
            return;
        }
        synchronized (this._cur._locale) {
            syncWrapHelper(runnable, true);
        }
    }

    private void syncWrapHelper(Runnable runnable, boolean z6) {
        Locale locale = this._cur._locale;
        if (z6) {
            locale.enter();
        }
        try {
            runnable.run();
        } finally {
            if (z6) {
                locale.exit();
            }
        }
    }

    private void syncWrapIOEx(WrapIOEx wrapIOEx) {
        if (preCheck()) {
            syncWrapHelper(wrapIOEx);
            return;
        }
        synchronized (this._cur._locale) {
            syncWrapHelper(wrapIOEx);
        }
    }

    private <T> T syncWrapNoEnter(Supplier<T> supplier) {
        T t6;
        if (preCheck()) {
            return (T) syncWrapHelper((Supplier) supplier, false);
        }
        synchronized (this._cur._locale) {
            t6 = (T) syncWrapHelper((Supplier) supplier, false);
        }
        return t6;
    }

    private void syncWrapSAXEx(WrapSAXEx wrapSAXEx) {
        if (preCheck()) {
            syncWrapHelper(wrapSAXEx);
            return;
        }
        synchronized (this._cur._locale) {
            syncWrapHelper(wrapSAXEx);
        }
    }

    private int twoLocaleOp(XmlCursor xmlCursor, int i5, int i6) throws Throwable {
        InterruptedException interruptedException;
        Throwable th;
        int iTwoLocaleOp;
        int iTwoLocaleOp2;
        Cursor cursorCheckCursors = checkCursors(xmlCursor);
        Locale locale = this._cur._locale;
        Locale locale2 = cursorCheckCursors._cur._locale;
        if (locale == locale2) {
            return ((Integer) syncWrapNoEnter(new C1444e(this, cursorCheckCursors, i5, i6, 2))).intValue();
        }
        if (locale.noSync()) {
            if (locale2.noSync()) {
                return twoLocaleOp(cursorCheckCursors, i5, i6);
            }
            synchronized (locale2) {
                iTwoLocaleOp2 = twoLocaleOp(cursorCheckCursors, i5, i6);
            }
            return iTwoLocaleOp2;
        }
        if (locale2.noSync()) {
            synchronized (locale) {
                iTwoLocaleOp = twoLocaleOp(cursorCheckCursors, i5, i6);
            }
            return iTwoLocaleOp;
        }
        boolean z6 = false;
        try {
            try {
                GlobalLock.acquire();
                try {
                    try {
                        synchronized (locale) {
                            try {
                                try {
                                    synchronized (locale2) {
                                        try {
                                            GlobalLock.release();
                                            return twoLocaleOp(cursorCheckCursors, i5, i6);
                                        } catch (Throwable th2) {
                                            th = th2;
                                            throw th;
                                        }
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } catch (InterruptedException e) {
                    interruptedException = e;
                    throw new RuntimeException(interruptedException.getMessage(), interruptedException);
                } catch (Throwable th6) {
                    th = th6;
                    z6 = true;
                    if (!z6) {
                        throw th;
                    }
                    GlobalLock.release();
                    throw th;
                }
                throw th;
            } catch (Throwable th7) {
                th = th7;
            }
        } catch (InterruptedException e6) {
            interruptedException = e6;
        }
    }

    public static void validateLocalName(QName qName) {
        if (qName == null) {
            throw new IllegalArgumentException("QName is null");
        }
        validateLocalName(qName.getLocalPart());
    }

    public static void validatePrefix(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Prefix is null");
        }
        if (str.length() == 0) {
            throw new IllegalArgumentException("Prefix is empty");
        }
        if (Locale.beginsWithXml(str)) {
            throw new IllegalArgumentException("Prefix begins with 'xml'");
        }
        if (!XMLChar.isValidNCName(str)) {
            throw new IllegalArgumentException("Prefix is not valid");
        }
    }

    public boolean ___toNextSibling() {
        if (!this._cur.hasParent()) {
            return false;
        }
        Xobj parentNoRoot = this._cur.getParentNoRoot();
        if (parentNoRoot == null) {
            this._cur._locale.enter();
            try {
                parentNoRoot = this._cur.getParent();
            } finally {
                this._cur._locale.exit();
            }
        }
        return Locale.toNextSiblingElement(this._cur, parentNoRoot);
    }

    public void _addToSelection() {
        _toSelection(Integer.MAX_VALUE);
        this._cur.addToSelection();
    }

    /* JADX INFO: renamed from: _beginElement, reason: merged with bridge method [inline-methods] */
    public void lambda$beginElement$58(String str) {
        lambda$insertElementWithText$62(str, null, null);
        _toPrevToken();
    }

    /* JADX INFO: renamed from: _clearBookmark, reason: merged with bridge method [inline-methods] */
    public void lambda$clearBookmark$50(Object obj) {
        if (obj != null) {
            this._cur.setBookmark(obj, null);
        }
    }

    public void _clearSelections() {
        XPathEngine xPathEngine = this._pathEngine;
        if (xPathEngine != null) {
            xPathEngine.release();
            this._pathEngine = null;
        }
        this._cur.clearSelection();
        this._currentSelection = -1;
    }

    public int _comparePosition(Cursor cursor) {
        int iComparePosition = this._cur.comparePosition(cursor._cur);
        if (iComparePosition != 2) {
            return iComparePosition;
        }
        throw new IllegalArgumentException("Cursors not in same document");
    }

    public int _copyChars(int i5, Cursor cursor) {
        int iCchRight = this._cur.cchRight();
        if (iCchRight <= 0 || i5 == 0) {
            return 0;
        }
        if (i5 < 0 || i5 > iCchRight) {
            i5 = iCchRight;
        }
        cursor.checkInsertionValidity(this._cur);
        Cur cur = cursor._cur;
        Object chars = this._cur.getChars(i5);
        Cur cur2 = this._cur;
        cur.insertChars(chars, cur2._offSrc, cur2._cchSrc);
        cursor._cur.nextChars(this._cur._cchSrc);
        return this._cur._cchSrc;
    }

    public boolean _copyXml(Cursor cursor) {
        cursor.checkInsertionValidity(this._cur);
        Cur curTempCur = cursor.tempCur();
        if (this._cur.isText()) {
            Cur cur = cursor._cur;
            Object chars = this._cur.getChars(-1);
            Cur cur2 = this._cur;
            cur.insertChars(chars, cur2._offSrc, cur2._cchSrc);
        } else {
            this._cur.copyNode(cursor._cur);
        }
        cursor._cur.moveToCur(curTempCur);
        curTempCur.release();
        return true;
    }

    public boolean _copyXmlContents(Cursor cursor) {
        if (!this._cur.isContainer() || this._cur.contains(cursor._cur) || !checkContentInsertionValidity(cursor)) {
            return false;
        }
        Cur curTempCur = this._cur._locale.tempCur();
        this._cur.copyNode(curTempCur);
        Cur curTempCur2 = cursor._cur.tempCur();
        curTempCur.moveNodeContents(cursor._cur, false);
        curTempCur.release();
        cursor._cur.moveToCur(curTempCur2);
        curTempCur2.release();
        return true;
    }

    public XmlCursor.TokenType _currentTokenType() {
        switch (this._cur.kind()) {
            case -2:
                return XmlCursor.TokenType.END;
            case -1:
                return XmlCursor.TokenType.ENDDOC;
            case 0:
                return XmlCursor.TokenType.TEXT;
            case 1:
                return XmlCursor.TokenType.STARTDOC;
            case 2:
                return XmlCursor.TokenType.START;
            case 3:
                return this._cur.isXmlns() ? XmlCursor.TokenType.NAMESPACE : XmlCursor.TokenType.ATTR;
            case 4:
                return XmlCursor.TokenType.COMMENT;
            case 5:
                return XmlCursor.TokenType.PROCINST;
            default:
                throw new IllegalStateException();
        }
    }

    public void _dispose() {
        this._cur.release();
        this._cur = null;
    }

    public XmlDocumentProperties _documentProperties() {
        return Locale.getDocProps(this._cur, true);
    }

    public void _dump() {
        this._cur.dump();
    }

    /* JADX INFO: renamed from: _execQuery, reason: merged with bridge method [inline-methods] */
    public XmlCursor lambda$execQuery$46(String str) {
        return lambda$execQuery$47(str, null);
    }

    /* JADX INFO: renamed from: _getAllBookmarkRefs, reason: merged with bridge method [inline-methods] */
    public void lambda$getAllBookmarkRefs$51(Collection<Object> collection) {
        if (collection != null) {
            for (Bookmark bookmark = this._cur._xobj._bookmarks; bookmark != null; bookmark = bookmark._next) {
                Object obj = bookmark._value;
                if (obj instanceof XmlCursor.XmlBookmark) {
                    collection.add(obj);
                }
            }
        }
    }

    /* JADX INFO: renamed from: _getAllNamespaces, reason: merged with bridge method [inline-methods] */
    public void lambda$getAllNamespaces$28(Map<String, String> map) {
        if (!this._cur.isContainer()) {
            throw new IllegalStateException("Not on a container");
        }
        if (map != null) {
            Locale.getAllNamespaces(this._cur, map);
        }
    }

    /* JADX INFO: renamed from: _getAttributeText, reason: merged with bridge method [inline-methods] */
    public String lambda$getAttributeText$39(QName qName) {
        if (qName == null) {
            throw new IllegalArgumentException("Attr name is null");
        }
        if (this._cur.isContainer()) {
            return this._cur.getAttrValue(qName);
        }
        return null;
    }

    /* JADX INFO: renamed from: _getBookmark, reason: merged with bridge method [inline-methods] */
    public XmlCursor.XmlBookmark lambda$getBookmark$49(Object obj) {
        if (obj == null) {
            return null;
        }
        return getBookmark(obj, this._cur);
    }

    public String _getChars() {
        return this._cur.getCharsAsString();
    }

    public XmlCursor.ChangeStamp _getDocChangeStamp() {
        return new ChangeStampImpl(this._cur._locale);
    }

    public Node _getDomNode() {
        return (Node) this._cur.getDom();
    }

    public QName _getName() {
        int iKind = this._cur.kind();
        if (iKind != 2) {
            if (iKind != 3) {
                if (iKind != 5) {
                    return null;
                }
            } else if (this._cur.isXmlns()) {
                Cur cur = this._cur;
                return cur._locale.makeQNameNoCheck(cur.getXmlnsUri(), this._cur.getXmlnsPrefix());
            }
        }
        return this._cur.getName();
    }

    public XmlObject _getObject() {
        return this._cur.getObject();
    }

    public int _getSelectionCount() {
        _toSelection(Integer.MAX_VALUE);
        return this._cur.selectionCount();
    }

    public String _getTextValue() {
        if (this._cur.isText()) {
            return _getChars();
        }
        if (this._cur.isNode()) {
            return this._cur.hasChildren() ? Locale.getTextValue(this._cur) : this._cur.getValueAsString();
        }
        throw new IllegalStateException("Can't get text value, current token can have no text value");
    }

    public boolean _hasNextSelection() {
        int i5 = this._currentSelection;
        push();
        try {
            return _toNextSelection();
        } finally {
            this._currentSelection = i5;
            pop();
        }
    }

    public boolean _hasNextToken() {
        Cur cur = this._cur;
        return (cur._pos == -1 && cur._xobj.kind() == 1) ? false : true;
    }

    public boolean _hasPrevToken() {
        return this._cur.kind() != 1;
    }

    /* JADX INFO: renamed from: _insertAttribute, reason: merged with bridge method [inline-methods] */
    public void lambda$insertAttribute$63(String str) {
        lambda$insertAttributeWithValue$66(str, (String) null);
    }

    /* JADX INFO: renamed from: _insertAttributeWithValue, reason: merged with bridge method [inline-methods] */
    public void lambda$insertAttributeWithValue$66(String str, String str2) {
        lambda$insertAttributeWithValue$67(str, null, str2);
    }

    /* JADX INFO: renamed from: _insertChars, reason: merged with bridge method [inline-methods] */
    public void lambda$insertChars$53(String str) {
        int length = str == null ? 0 : str.length();
        if (length > 0) {
            if (this._cur.isRoot() || this._cur.isAttr()) {
                throw new IllegalStateException("Can't insert before the document or an attribute.");
            }
            this._cur.insertChars(str, 0, length);
            this._cur.nextChars(length);
        }
    }

    /* JADX INFO: renamed from: _insertComment, reason: merged with bridge method [inline-methods] */
    public void lambda$insertComment$70(String str) {
        Cur curTempCur = this._cur._locale.tempCur();
        curTempCur.createComment();
        insertNode(curTempCur, str);
        curTempCur.release();
    }

    /* JADX INFO: renamed from: _insertElement, reason: merged with bridge method [inline-methods] */
    public void lambda$insertElement$55(String str) {
        lambda$insertElementWithText$62(str, null, null);
    }

    /* JADX INFO: renamed from: _insertElementWithText, reason: merged with bridge method [inline-methods] */
    public void lambda$insertElementWithText$61(String str, String str2) {
        lambda$insertElementWithText$62(str, null, str2);
    }

    /* JADX INFO: renamed from: _insertNamespace, reason: merged with bridge method [inline-methods] */
    public void lambda$insertNamespace$69(String str, String str2) {
        lambda$insertAttributeWithValue$68(this._cur._locale.createXmlns(str), str2);
    }

    /* JADX INFO: renamed from: _insertProcInst, reason: merged with bridge method [inline-methods] */
    public void lambda$insertProcInst$71(String str, String str2) {
        validateLocalName(str);
        if (Locale.beginsWithXml(str) && str.length() == 3) {
            throw new IllegalArgumentException("Target is 'xml'");
        }
        Cur curTempCur = this._cur._locale.tempCur();
        curTempCur.createProcinst(str);
        insertNode(curTempCur, str2);
        curTempCur.release();
    }

    public boolean _isAnyAttr() {
        return this._cur.isAttr();
    }

    public boolean _isAtSamePositionAs(Cursor cursor) {
        return this._cur.isSamePos(cursor._cur);
    }

    public boolean _isAttr() {
        return this._cur.isNormalAttr();
    }

    public boolean _isComment() {
        return this._cur.isComment();
    }

    public boolean _isContainer() {
        return this._cur.isContainer();
    }

    public boolean _isEnd() {
        return this._cur.isEnd();
    }

    public boolean _isEnddoc() {
        return this._cur.isEndRoot();
    }

    public boolean _isFinish() {
        return this._cur.isFinish();
    }

    public boolean _isLeftOf(Cursor cursor) {
        return _comparePosition(cursor) < 0;
    }

    public boolean _isNamespace() {
        return this._cur.isXmlns();
    }

    public boolean _isProcinst() {
        return this._cur.isProcinst();
    }

    public boolean _isRightOf(Cursor cursor) {
        return _comparePosition(cursor) > 0;
    }

    public boolean _isStart() {
        return this._cur.isElem();
    }

    public boolean _isStartdoc() {
        return this._cur.isRoot();
    }

    public boolean _isText() {
        return this._cur.isText();
    }

    public Object _monitor() {
        return this._cur._locale;
    }

    public int _moveChars(int i5, Cursor cursor) {
        int iCchRight = this._cur.cchRight();
        if (iCchRight <= 0 || i5 == 0) {
            return 0;
        }
        if (i5 < 0 || i5 > iCchRight) {
            i5 = iCchRight;
        }
        cursor.checkInsertionValidity(this._cur);
        this._cur.moveChars(cursor._cur, i5);
        cursor._cur.nextChars(this._cur._cchSrc);
        return this._cur._cchSrc;
    }

    public boolean _moveXml(Cursor cursor) {
        cursor.checkInsertionValidity(this._cur);
        if (this._cur.isText()) {
            int iCchRight = this._cur.cchRight();
            if (this._cur.inChars(cursor._cur, iCchRight, true)) {
                return false;
            }
            this._cur.moveChars(cursor._cur, iCchRight);
            cursor._cur.nextChars(iCchRight);
            return true;
        }
        if (this._cur.contains(cursor._cur)) {
            return false;
        }
        Cur curTempCur = cursor.tempCur();
        this._cur.moveNode(cursor._cur);
        cursor._cur.moveToCur(curTempCur);
        curTempCur.release();
        return true;
    }

    public boolean _moveXmlContents(Cursor cursor) {
        if (!this._cur.isContainer() || this._cur.contains(cursor._cur) || !checkContentInsertionValidity(cursor)) {
            return false;
        }
        Cur curTempCur = cursor.tempCur();
        this._cur.moveNodeContents(cursor._cur, false);
        cursor._cur.moveToCur(curTempCur);
        curTempCur.release();
        return true;
    }

    /* JADX INFO: renamed from: _namespaceForPrefix, reason: merged with bridge method [inline-methods] */
    public String lambda$namespaceForPrefix$26(String str) {
        if (this._cur.isContainer()) {
            return this._cur.namespaceForPrefix(str, true);
        }
        throw new IllegalStateException("Not on a container");
    }

    public XmlCursor _newCursor() {
        return new Cursor(this._cur);
    }

    public Node _newDomNode() {
        return lambda$newDomNode$14(null);
    }

    public InputStream _newInputStream() {
        return lambda$newInputStream$12(null);
    }

    public Reader _newReader() {
        return lambda$newReader$13(null);
    }

    public XMLStreamReader _newXMLStreamReader() {
        return lambda$newXMLStreamReader$6(null);
    }

    public boolean _pop() {
        return this._cur.pop();
    }

    /* JADX INFO: renamed from: _prefixForNamespace, reason: merged with bridge method [inline-methods] */
    public String lambda$prefixForNamespace$27(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Must specify a namespace");
        }
        return this._cur.prefixForNamespace(str, null, true);
    }

    public XmlCursor.TokenType _prevTokenType() {
        this._cur.push();
        XmlCursor.TokenType tokenType_toPrevToken = _toPrevToken();
        this._cur.pop();
        return tokenType_toPrevToken;
    }

    public void _push() {
        this._cur.push();
    }

    public boolean _removeAttribute(QName qName) {
        if (qName == null) {
            throw new IllegalArgumentException("Attr name is null");
        }
        if (this._cur.isContainer()) {
            return this._cur.removeAttr(qName);
        }
        return false;
    }

    public int _removeChars(int i5) {
        int iCchRight = this._cur.cchRight();
        if (iCchRight == 0 || i5 == 0) {
            return 0;
        }
        if (i5 < 0 || i5 > iCchRight) {
            i5 = iCchRight;
        }
        this._cur.moveChars(null, i5);
        return this._cur._cchSrc;
    }

    public boolean _removeXml() {
        if (this._cur.isRoot()) {
            throw new IllegalStateException("Can't remove a whole document.");
        }
        if (this._cur.isFinish()) {
            return false;
        }
        if (this._cur.isText()) {
            this._cur.moveChars(null, -1);
            return true;
        }
        this._cur.moveNode(null);
        return true;
    }

    public boolean _removeXmlContents() {
        if (!this._cur.isContainer()) {
            return false;
        }
        this._cur.moveNodeContents(null, false);
        return true;
    }

    /* JADX INFO: renamed from: _save, reason: merged with bridge method [inline-methods] */
    public void lambda$save$8(File file) throws IOException {
        lambda$save$16(file, (XmlOptions) null);
    }

    /* JADX INFO: renamed from: _selectPath, reason: merged with bridge method [inline-methods] */
    public void lambda$selectPath$19(String str) {
        lambda$selectPath$20(str, null);
    }

    public boolean _setAttributeText(QName qName, String str) {
        if (qName == null) {
            throw new IllegalArgumentException("Attr name is null");
        }
        validateLocalName(qName.getLocalPart());
        if (!this._cur.isContainer()) {
            return false;
        }
        this._cur.setAttrValue(qName, str);
        return true;
    }

    /* JADX INFO: renamed from: _setBookmark, reason: merged with bridge method [inline-methods] */
    public void lambda$setBookmark$48(XmlCursor.XmlBookmark xmlBookmark) {
        if (xmlBookmark != null) {
            if (xmlBookmark.getKey() == null) {
                throw new IllegalArgumentException("Annotation key is null");
            }
            xmlBookmark._currentMark = this._cur.setBookmark(xmlBookmark.getKey(), xmlBookmark);
        }
    }

    /* JADX INFO: renamed from: _setName, reason: merged with bridge method [inline-methods] */
    public void lambda$setName$25(QName qName) {
        if (qName == null) {
            throw new IllegalArgumentException("Name is null");
        }
        int iKind = this._cur.kind();
        if (iKind == 2 || iKind == 3) {
            validateLocalName(qName.getLocalPart());
        } else {
            if (iKind != 5) {
                throw new IllegalStateException("Can set name on element, atrtribute and procinst only");
            }
            validatePrefix(qName.getLocalPart());
            if (qName.getNamespaceURI().length() > 0) {
                throw new IllegalArgumentException("Procinst name must have no URI");
            }
            if (qName.getPrefix().length() > 0) {
                throw new IllegalArgumentException("Procinst name must have no prefix");
            }
        }
        this._cur.setName(qName);
    }

    /* JADX INFO: renamed from: _setTextValue, reason: merged with bridge method [inline-methods] */
    public void lambda$setTextValue$43(String str) {
        if (str == null) {
            str = "";
        }
        setTextValue(str, 0, str.length());
    }

    public boolean _toBookmark(XmlCursor.XmlBookmark xmlBookmark) {
        Bookmark bookmark;
        Xobj xobj;
        if (xmlBookmark != null) {
            XmlCursor.XmlMark xmlMark = xmlBookmark._currentMark;
            if ((xmlMark instanceof Bookmark) && (xobj = (bookmark = (Bookmark) xmlMark)._xobj) != null) {
                Locale locale = xobj._locale;
                Cur cur = this._cur;
                if (locale == cur._locale) {
                    cur.moveTo(xobj, bookmark._pos);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean _toChild(String str) {
        return _toChild((String) null, str);
    }

    public boolean _toCursor(Cursor cursor) {
        this._cur.moveToCur(cursor._cur);
        return true;
    }

    public void _toEndDoc() {
        _toStartDoc();
        this._cur.toEnd();
    }

    public XmlCursor.TokenType _toEndToken() {
        if (!this._cur.isContainer()) {
            return XmlCursor.TokenType.NONE;
        }
        this._cur.toEnd();
        return currentTokenType();
    }

    public boolean _toFirstAttribute() {
        return this._cur.isContainer() && Locale.toFirstNormalAttr(this._cur);
    }

    public boolean _toFirstChild() {
        return Locale.toFirstChildElement(this._cur);
    }

    public XmlCursor.TokenType _toFirstContentToken() {
        if (!this._cur.isContainer()) {
            return XmlCursor.TokenType.NONE;
        }
        this._cur.next();
        return currentTokenType();
    }

    public boolean _toLastAttribute() {
        if (this._cur.isContainer()) {
            this._cur.push();
            this._cur.push();
            boolean z6 = false;
            while (this._cur.toNextAttr()) {
                if (this._cur.isNormalAttr()) {
                    this._cur.popButStay();
                    this._cur.push();
                    z6 = true;
                }
            }
            this._cur.pop();
            if (z6) {
                this._cur.popButStay();
                return true;
            }
            this._cur.pop();
        }
        return false;
    }

    public boolean _toLastChild() {
        return Locale.toLastChildElement(this._cur);
    }

    public boolean _toNextAttribute() {
        return this._cur.isAttr() && Locale.toNextNormalAttr(this._cur);
    }

    /* JADX INFO: renamed from: _toNextBookmark, reason: merged with bridge method [inline-methods] */
    public XmlCursor.XmlBookmark lambda$toNextBookmark$23(Object obj) {
        if (obj == null) {
            return null;
        }
        this._cur.push();
        do {
            int iCchRight = this._cur.cchRight();
            if (iCchRight > 1) {
                this._cur.nextChars(1);
                Cur cur = this._cur;
                int iFirstBookmarkInChars = cur.firstBookmarkInChars(obj, iCchRight - 1);
                if (iFirstBookmarkInChars < 0) {
                    iFirstBookmarkInChars = -1;
                }
                cur.nextChars(iFirstBookmarkInChars);
            } else if (_toNextToken().isNone()) {
                this._cur.pop();
                return null;
            }
            XmlCursor.XmlBookmark bookmark = getBookmark(obj, this._cur);
            if (bookmark != null) {
                this._cur.popButStay();
                return bookmark;
            }
        } while (this._cur.kind() != -1);
        this._cur.pop();
        return null;
    }

    public int _toNextChar(int i5) {
        return this._cur.nextChars(i5);
    }

    public boolean _toNextSelection() {
        return _toSelection(this._currentSelection + 1);
    }

    public boolean _toNextSibling(String str) {
        return _toNextSibling(new QName(str));
    }

    public XmlCursor.TokenType _toNextToken() {
        int iKind = this._cur.kind();
        if (iKind == 1 || iKind == 2) {
            if (!this._cur.toFirstAttr()) {
                this._cur.next();
            }
        } else if (iKind != 3) {
            if (iKind == 4 || iKind == 5) {
                this._cur.skip();
            } else if (!this._cur.next()) {
                return XmlCursor.TokenType.NONE;
            }
        } else if (!this._cur.toNextSibling()) {
            this._cur.toParent();
            this._cur.next();
        }
        return _currentTokenType();
    }

    public boolean _toParent() {
        Cur curTempCur = this._cur.tempCur();
        if (!curTempCur.toParent()) {
            return false;
        }
        this._cur.moveToCur(curTempCur);
        curTempCur.release();
        return true;
    }

    public boolean _toPrevAttribute() {
        return this._cur.isAttr() && Locale.toPrevNormalAttr(this._cur);
    }

    /* JADX INFO: renamed from: _toPrevBookmark, reason: merged with bridge method [inline-methods] */
    public XmlCursor.XmlBookmark lambda$toPrevBookmark$24(Object obj) {
        if (obj == null) {
            return null;
        }
        this._cur.push();
        do {
            int iCchLeft = this._cur.cchLeft();
            if (iCchLeft > 1) {
                this._cur.prevChars(1);
                Cur cur = this._cur;
                int iFirstBookmarkInCharsLeft = cur.firstBookmarkInCharsLeft(obj, iCchLeft - 1);
                if (iFirstBookmarkInCharsLeft < 0) {
                    iFirstBookmarkInCharsLeft = -1;
                }
                cur.prevChars(iFirstBookmarkInCharsLeft);
            } else if (iCchLeft == 1) {
                this._cur.prevChars(1);
            } else if (_toPrevToken().isNone()) {
                this._cur.pop();
                return null;
            }
            XmlCursor.XmlBookmark bookmark = getBookmark(obj, this._cur);
            if (bookmark != null) {
                this._cur.popButStay();
                return bookmark;
            }
        } while (this._cur.kind() != 1);
        this._cur.pop();
        return null;
    }

    public int _toPrevChar(int i5) {
        return this._cur.prevChars(i5);
    }

    public boolean _toPrevSibling() {
        return Locale.toPrevSiblingElement(this._cur);
    }

    public XmlCursor.TokenType _toPrevToken() {
        boolean zIsText = this._cur.isText();
        if (this._cur.prev()) {
            int iKind = this._cur.kind();
            if (iKind == -4 || iKind == -5 || iKind == -3) {
                this._cur.toParent();
            } else if (this._cur.isContainer()) {
                this._cur.toLastAttr();
            } else if (zIsText && this._cur.isText()) {
                return _toPrevToken();
            }
        } else {
            if (this._cur.isRoot()) {
                return XmlCursor.TokenType.NONE;
            }
            this._cur.toParent();
        }
        return _currentTokenType();
    }

    public boolean _toSelection(int i5) {
        if (i5 < 0) {
            return false;
        }
        while (i5 >= this._cur.selectionCount()) {
            XPathEngine xPathEngine = this._pathEngine;
            if (xPathEngine == null) {
                return false;
            }
            if (!xPathEngine.next(this._cur)) {
                this._pathEngine.release();
                this._pathEngine = null;
                return false;
            }
        }
        Cur cur = this._cur;
        this._currentSelection = i5;
        cur.moveToSelection(i5);
        return true;
    }

    public void _toStartDoc() {
        this._cur.toRoot();
    }

    public String _xmlText() {
        return lambda$xmlText$11(null);
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void addToSelection() {
        syncWrap(new RunnableC1453n(4, this));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void beginElement(QName qName) {
        syncWrap(new RunnableC1452m(this, qName, 3));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void clearBookmark(Object obj) {
        syncWrap(new r(this, obj, 0));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void clearSelections() {
        syncWrap(new RunnableC1453n(0, this));
    }

    @Override // org.apache.xmlbeans.XmlCursor, java.lang.AutoCloseable
    public void close() {
        if (this._cur != null) {
            syncWrap(new RunnableC1453n(6, this));
        }
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public int comparePosition(XmlCursor xmlCursor) {
        return ((Integer) syncWrap(new C1449j(this, preCheck(xmlCursor), 4))).intValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public int copyChars(int i5, XmlCursor xmlCursor) {
        return twoLocaleOp(xmlCursor, 5, i5);
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean copyXml(XmlCursor xmlCursor) {
        return twoLocaleOp(xmlCursor, 1, 0) == 1;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean copyXmlContents(XmlCursor xmlCursor) {
        return twoLocaleOp(xmlCursor, 3, 0) == 1;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public XmlCursor.TokenType currentTokenType() {
        return (XmlCursor.TokenType) syncWrapNoEnter(new C1461w(this, 0));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    @Deprecated
    public void dispose() {
        close();
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public XmlDocumentProperties documentProperties() {
        return (XmlDocumentProperties) syncWrap(new C1441b(12, this));
    }

    public void dump(PrintStream printStream) {
        this._cur.dump(printStream);
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public XmlCursor execQuery(String str) {
        return (XmlCursor) syncWrap(new C1446g(this, str, 0));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void getAllBookmarkRefs(Collection<Object> collection) {
        syncWrap(new r(this, collection, 3));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void getAllNamespaces(Map<String, String> map) {
        syncWrap(new r(this, map, 2));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public String getAttributeText(QName qName) {
        return (String) syncWrap(new C1460v(this, qName, 2));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public String getChars() {
        return (String) syncWrap(new C1441b(17, this));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public XmlCursor.ChangeStamp getDocChangeStamp() {
        return (XmlCursor.ChangeStamp) syncWrap(new C1441b(23, this));
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Node getDomNode() {
        return (Node) syncWrap(new C1441b(25, this));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public QName getName() {
        return (QName) syncWrap(new C1461w(this, 16));
    }

    @Override // org.apache.xmlbeans.impl.store.Locale.ChangeListener
    public Locale.ChangeListener getNextChangeListener() {
        return this._nextChangeListener;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public XmlObject getObject() {
        return (XmlObject) syncWrap(new C1441b(8, this));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public int getSelectionCount() {
        return ((Integer) syncWrap(new C1441b(29, this))).intValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public String getTextValue() {
        return (String) syncWrap(new C1441b(13, this));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean hasNextSelection() {
        return ((Boolean) syncWrap(new C1441b(19, this))).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean hasNextToken() {
        return ((Boolean) syncWrapNoEnter(new C1461w(this, 8))).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean hasPrevToken() {
        return ((Boolean) syncWrap(new C1441b(22, this))).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertAttribute(String str) {
        syncWrap(new RunnableC1443d(this, str, 6));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertAttributeWithValue(String str, String str2) {
        syncWrap(new RunnableC1445f(this, str, str2, 0));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertChars(String str) {
        syncWrap(new RunnableC1443d(this, str, 1));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertComment(String str) {
        syncWrap(new RunnableC1443d(this, str, 2));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertElement(QName qName) {
        syncWrap(new RunnableC1452m(this, qName, 2));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertElementWithText(QName qName, String str) {
        syncWrap(new RunnableC1455p(this, qName, str, 0));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertNamespace(String str, String str2) {
        syncWrap(new RunnableC1445f(this, str, str2, 1));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertProcInst(String str, String str2) {
        syncWrap(new RunnableC1445f(this, str, str2, 5));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isAnyAttr() {
        return ((Boolean) syncWrapNoEnter(new C1461w(this, 9))).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isAtSamePositionAs(XmlCursor xmlCursor) {
        return ((Boolean) syncWrap(new C1449j(this, preCheck(xmlCursor), 3))).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isAttr() {
        return ((Boolean) syncWrapNoEnter(new C1441b(28, this))).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isComment() {
        return ((Boolean) syncWrapNoEnter(new C1441b(26, this))).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isContainer() {
        return ((Boolean) syncWrapNoEnter(new C1441b(11, this))).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isEnd() {
        return ((Boolean) syncWrapNoEnter(new C1441b(9, this))).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isEnddoc() {
        return ((Boolean) syncWrapNoEnter(new C1441b(7, this))).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isFinish() {
        return ((Boolean) syncWrapNoEnter(new C1461w(this, 14))).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isInSameDocument(XmlCursor xmlCursor) {
        return xmlCursor != null && this._cur.isInSameTree(checkCursors(xmlCursor)._cur);
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isLeftOf(XmlCursor xmlCursor) {
        return ((Boolean) syncWrap(new C1449j(this, preCheck(xmlCursor), 1))).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isNamespace() {
        return ((Boolean) syncWrapNoEnter(new C1461w(this, 7))).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isProcinst() {
        return ((Boolean) syncWrapNoEnter(new C1441b(15, this))).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isRightOf(XmlCursor xmlCursor) {
        return ((Boolean) syncWrap(new C1449j(this, preCheck(xmlCursor), 2))).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isStart() {
        return ((Boolean) syncWrapNoEnter(new C1461w(this, 18))).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isStartdoc() {
        return ((Boolean) syncWrapNoEnter(new C1461w(this, 11))).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isText() {
        return ((Boolean) syncWrapNoEnter(new C1441b(10, this))).booleanValue();
    }

    public Locale locale() {
        return this._cur._locale;
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Object monitor() {
        return syncWrap(new C1461w(this, 3));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public int moveChars(int i5, XmlCursor xmlCursor) {
        return twoLocaleOp(xmlCursor, 4, i5);
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean moveXml(XmlCursor xmlCursor) {
        return twoLocaleOp(xmlCursor, 0, 0) == 1;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean moveXmlContents(XmlCursor xmlCursor) {
        return twoLocaleOp(xmlCursor, 2, 0) == 1;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public String namespaceForPrefix(String str) {
        return (String) syncWrap(new C1446g(this, str, 1));
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Node newDomNode() {
        return (Node) syncWrap(new C1441b(18, this));
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public InputStream newInputStream() {
        return (InputStream) syncWrap(new C1441b(3, this));
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Reader newReader() {
        return (Reader) syncWrap(new C1461w(this, 5));
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public XMLStreamReader newXMLStreamReader() {
        return (XMLStreamReader) syncWrap(new C1461w(this, 17));
    }

    @Override // org.apache.xmlbeans.impl.store.Locale.ChangeListener
    public void notifyChange() {
        if (this._cur != null) {
            _getSelectionCount();
        }
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean pop() {
        return ((Boolean) syncWrap(new C1441b(1, this))).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public String prefixForNamespace(String str) {
        return (String) syncWrap(new C1446g(this, str, 4));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public XmlCursor.TokenType prevTokenType() {
        return (XmlCursor.TokenType) syncWrap(new C1441b(5, this));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void push() {
        syncWrap(new RunnableC1453n(3, this));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean removeAttribute(QName qName) {
        return ((Boolean) syncWrap(new C1460v(this, qName, 3))).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public int removeChars(int i5) {
        return ((Integer) syncWrap(new C1457s(this, i5, 3))).intValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean removeXml() {
        return ((Boolean) syncWrap(new C1441b(21, this))).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean removeXmlContents() {
        return ((Boolean) syncWrap(new C1441b(24, this))).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(ContentHandler contentHandler, LexicalHandler lexicalHandler) {
        syncWrapSAXEx(new C1451l(this, 1, contentHandler, lexicalHandler));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void selectPath(String str) {
        syncWrap(new RunnableC1443d(this, str, 3));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean setAttributeText(QName qName, String str) {
        return ((Boolean) syncWrap(new C1456q(this, qName, str))).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void setBookmark(XmlCursor.XmlBookmark xmlBookmark) {
        syncWrap(new r(this, xmlBookmark, 1));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void setName(QName qName) {
        syncWrap(new RunnableC1452m(this, qName, 1));
    }

    @Override // org.apache.xmlbeans.impl.store.Locale.ChangeListener
    public void setNextChangeListener(Locale.ChangeListener changeListener) {
        this._nextChangeListener = changeListener;
    }

    public Cur tempCur() {
        return this._cur.tempCur();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toBookmark(XmlCursor.XmlBookmark xmlBookmark) {
        return ((Boolean) syncWrap(new C1459u(this, xmlBookmark, 0))).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toChild(String str) {
        return ((Boolean) syncWrap(new C1446g(this, str, 2))).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toCursor(XmlCursor xmlCursor) {
        Cursor cursorCheckCursors = checkCursors(xmlCursor);
        return this._cur._locale == cursorCheckCursors._cur._locale && ((Boolean) syncWrap(new C1449j(this, cursorCheckCursors, 0))).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void toEndDoc() {
        syncWrapNoEnter(new RunnableC1453n(2, this));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public XmlCursor.TokenType toEndToken() {
        return (XmlCursor.TokenType) syncWrap(new C1441b(14, this));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toFirstAttribute() {
        return ((Boolean) syncWrapNoEnter(new C1441b(27, this))).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toFirstChild() {
        return ((Boolean) syncWrapNoEnter(new C1461w(this, 2))).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public XmlCursor.TokenType toFirstContentToken() {
        return (XmlCursor.TokenType) syncWrap(new C1441b(2, this));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toLastAttribute() {
        return ((Boolean) syncWrap(new C1461w(this, 4))).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toLastChild() {
        return ((Boolean) syncWrap(new C1461w(this, 1))).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toNextAttribute() {
        return ((Boolean) syncWrap(new C1461w(this, 15))).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public XmlCursor.XmlBookmark toNextBookmark(Object obj) {
        return (XmlCursor.XmlBookmark) syncWrap(new C1442c(this, obj, 1));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public int toNextChar(int i5) {
        return ((Integer) syncWrap(new C1457s(this, i5, 2))).intValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toNextSelection() {
        return ((Boolean) syncWrap(new C1441b(4, this))).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toNextSibling() {
        return ((Boolean) syncWrapNoEnter(new C1441b(20, this))).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public XmlCursor.TokenType toNextToken() {
        return (XmlCursor.TokenType) syncWrap(new C1461w(this, 12));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toParent() {
        return ((Boolean) syncWrap(new C1461w(this, 10))).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toPrevAttribute() {
        return ((Boolean) syncWrap(new C1441b(0, this))).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public XmlCursor.XmlBookmark toPrevBookmark(Object obj) {
        return (XmlCursor.XmlBookmark) syncWrap(new C1442c(this, obj, 2));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public int toPrevChar(int i5) {
        return ((Integer) syncWrap(new C1457s(this, i5, 4))).intValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toPrevSibling() {
        return ((Boolean) syncWrap(new C1441b(16, this))).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public XmlCursor.TokenType toPrevToken() {
        return (XmlCursor.TokenType) syncWrap(new C1461w(this, 6));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toSelection(int i5) {
        return ((Boolean) syncWrap(new C1457s(this, i5, 0))).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void toStartDoc() {
        syncWrapNoEnter(new RunnableC1453n(1, this));
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public String xmlText() {
        return (String) syncWrap(new C1441b(6, this));
    }

    /* JADX INFO: renamed from: _execQuery, reason: merged with bridge method [inline-methods] */
    public XmlCursor lambda$execQuery$47(String str, XmlOptions xmlOptions) {
        checkThisCursor();
        return XPathFactory.cursorExecQuery(this._cur, str, xmlOptions);
    }

    public int _getChars(char[] cArr, int i5, int i6) {
        int iCchRight = this._cur.cchRight();
        if (i6 < 0 || i6 > iCchRight) {
            i6 = iCchRight;
        }
        if (cArr == null || i5 >= cArr.length) {
            return 0;
        }
        if (cArr.length - i5 < i6) {
            i6 = cArr.length - i5;
        }
        Object chars = this._cur.getChars(i6);
        Cur cur = this._cur;
        CharUtil.getChars(cArr, i5, chars, cur._offSrc, cur._cchSrc);
        return this._cur._cchSrc;
    }

    /* JADX INFO: renamed from: _insertAttribute, reason: merged with bridge method [inline-methods] */
    public void lambda$insertAttribute$64(String str, String str2) {
        lambda$insertAttributeWithValue$67(str, str2, null);
    }

    /* JADX INFO: renamed from: _insertAttributeWithValue, reason: merged with bridge method [inline-methods] */
    public void lambda$insertAttributeWithValue$67(String str, String str2, String str3) {
        validateLocalName(str);
        lambda$insertAttributeWithValue$68(this._cur._locale.makeQName(str2, str), str3);
    }

    /* JADX INFO: renamed from: _insertElement, reason: merged with bridge method [inline-methods] */
    public void lambda$insertElement$56(String str, String str2) {
        lambda$insertElementWithText$62(str, str2, null);
    }

    /* JADX INFO: renamed from: _insertElementWithText, reason: merged with bridge method [inline-methods] */
    public void lambda$insertElementWithText$62(String str, String str2, String str3) {
        validateLocalName(str);
        lambda$insertElementWithText$60(this._cur._locale.makeQName(str2, str), str3);
    }

    /* JADX INFO: renamed from: _newDomNode, reason: merged with bridge method [inline-methods] */
    public Node lambda$newDomNode$14(XmlOptions xmlOptions) {
        if (xmlOptions != null && xmlOptions.isSaveInner()) {
            XmlOptions xmlOptions2 = new XmlOptions(xmlOptions);
            xmlOptions2.setSaveInner(false);
            xmlOptions = xmlOptions2;
        }
        return new DomSaver(this._cur, isDomFragment(), xmlOptions).saveDom();
    }

    /* JADX INFO: renamed from: _newInputStream, reason: merged with bridge method [inline-methods] */
    public InputStream lambda$newInputStream$12(XmlOptions xmlOptions) {
        return new Saver.InputStreamSaver(this._cur, xmlOptions);
    }

    /* JADX INFO: renamed from: _newReader, reason: merged with bridge method [inline-methods] */
    public Reader lambda$newReader$13(XmlOptions xmlOptions) {
        return new Saver.TextReader(this._cur, xmlOptions);
    }

    /* JADX INFO: renamed from: _newXMLStreamReader, reason: merged with bridge method [inline-methods] */
    public XMLStreamReader lambda$newXMLStreamReader$6(XmlOptions xmlOptions) {
        return Jsr173.newXmlStreamReader(this._cur, xmlOptions);
    }

    /* JADX INFO: renamed from: _save, reason: merged with bridge method [inline-methods] */
    public void lambda$save$9(OutputStream outputStream) throws IOException {
        lambda$save$17(outputStream, (XmlOptions) null);
    }

    /* JADX INFO: renamed from: _selectPath, reason: merged with bridge method [inline-methods] */
    public void lambda$selectPath$20(String str, XmlOptions xmlOptions) {
        _clearSelections();
        this._pathEngine = XPathFactory.getCompiledPath(str, xmlOptions).execute(this._cur, xmlOptions);
        this._cur._locale.registerForChange(this);
    }

    public boolean _toChild(QName qName) {
        return _toChild(qName, 0);
    }

    public boolean _toNextSibling(String str, String str2) {
        validateLocalName(str2);
        return _toNextSibling(this._cur._locale._qnameFactory.getQName(str, str2));
    }

    /* JADX INFO: renamed from: _xmlText, reason: merged with bridge method [inline-methods] */
    public String lambda$xmlText$11(XmlOptions xmlOptions) {
        return new Saver.TextSaver(this._cur, xmlOptions, null).saveToString();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void beginElement(String str) {
        syncWrap(new RunnableC1443d(this, str, 0));
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void dump() {
        syncWrap(new RunnableC1453n(5, this));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public XmlCursor execQuery(String str, XmlOptions xmlOptions) {
        return (XmlCursor) syncWrap(new C1456q(this, str, xmlOptions));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public int getChars(char[] cArr, int i5, int i6) {
        return ((Integer) syncWrap(new C1444e(this, cArr, i5, i6, 1))).intValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public int getTextValue(char[] cArr, int i5, int i6) {
        return ((Integer) syncWrap(new C1444e(this, cArr, i5, i6, 0))).intValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertAttribute(String str, String str2) {
        syncWrap(new RunnableC1445f(this, str, str2, 6));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertAttributeWithValue(String str, String str2, String str3) {
        syncWrap(new RunnableC1448i(this, str, str2, str3, 1));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertElement(String str) {
        syncWrap(new RunnableC1443d(this, str, 5));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertElementWithText(String str, String str2) {
        syncWrap(new RunnableC1445f(this, str, str2, 3));
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Node newDomNode(XmlOptions xmlOptions) {
        return (Node) syncWrap(new C1458t(this, xmlOptions, 1));
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public InputStream newInputStream(XmlOptions xmlOptions) {
        return (InputStream) syncWrap(new C1458t(this, xmlOptions, 2));
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Reader newReader(XmlOptions xmlOptions) {
        return (Reader) syncWrap(new C1458t(this, xmlOptions, 0));
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public XMLStreamReader newXMLStreamReader(XmlOptions xmlOptions) {
        return (XMLStreamReader) syncWrap(new C1458t(this, xmlOptions, 4));
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(File file) {
        syncWrapIOEx(new C1454o(this, file, 1));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void selectPath(String str, XmlOptions xmlOptions) {
        syncWrap(new RunnableC1455p(this, str, xmlOptions));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toChild(String str, String str2) {
        return ((Boolean) syncWrap(new C1450k(this, str, str2, 0))).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toNextSibling(String str) {
        return ((Boolean) syncWrap(new C1446g(this, str, 3))).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public String xmlText(XmlOptions xmlOptions) {
        return (String) syncWrap(new C1458t(this, xmlOptions, 3));
    }

    public static void validateLocalName(String str) {
        if (str != null) {
            if (str.length() != 0) {
                if (!XMLChar.isValidNCName(str)) {
                    throw new IllegalArgumentException("Name is not valid");
                }
                return;
            }
            throw new IllegalArgumentException("Name is empty");
        }
        throw new IllegalArgumentException("Name is null");
    }

    /* JADX INFO: renamed from: _beginElement, reason: merged with bridge method [inline-methods] */
    public void lambda$beginElement$59(String str, String str2) {
        lambda$insertElementWithText$62(str, str2, null);
        _toPrevToken();
    }

    /* JADX INFO: renamed from: _insertAttribute, reason: merged with bridge method [inline-methods] */
    public void lambda$insertAttribute$65(QName qName) {
        lambda$insertAttributeWithValue$68(qName, (String) null);
    }

    /* JADX INFO: renamed from: _insertElement, reason: merged with bridge method [inline-methods] */
    public void lambda$insertElement$54(QName qName) {
        lambda$insertElementWithText$60(qName, (String) null);
    }

    /* JADX INFO: renamed from: _save, reason: merged with bridge method [inline-methods] */
    public void lambda$save$10(Writer writer) throws IOException {
        lambda$save$18(writer, (XmlOptions) null);
    }

    /* JADX INFO: renamed from: _setTextValue, reason: merged with bridge method [inline-methods] */
    public void lambda$setTextValue$44(char[] cArr, int i5, int i6) {
        if (i6 < 0) {
            throw new IndexOutOfBoundsException("setTextValue: length < 0");
        }
        if (cArr == null) {
            if (i6 <= 0) {
                setTextValue((char[]) null, 0, 0);
                return;
            }
            throw new IllegalArgumentException("setTextValue: sourceChars == null");
        }
        if (i5 >= 0 && i5 < cArr.length) {
            if (i5 + i6 > cArr.length) {
                i6 = cArr.length - i5;
            }
            CharUtil charUtil = this._cur._locale.getCharUtil();
            setTextValue(charUtil.saveChars(cArr, i5, i6), charUtil._offSrc, charUtil._cchSrc);
            return;
        }
        throw new IndexOutOfBoundsException("setTextValue: offset out of bounds");
    }

    public boolean _toChild(int i5) {
        return _toChild((QName) null, i5);
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void beginElement(String str, String str2) {
        syncWrap(new RunnableC1445f(this, str, str2, 2));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public XmlCursor.XmlBookmark getBookmark(Object obj) {
        return (XmlCursor.XmlBookmark) syncWrap(new C1442c(this, obj, 0));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertAttribute(QName qName) {
        syncWrap(new RunnableC1452m(this, qName, 0));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertAttributeWithValue(QName qName, String str) {
        syncWrap(new RunnableC1455p(this, qName, str, 1));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertElement(String str, String str2) {
        syncWrap(new RunnableC1445f(this, str, str2, 4));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertElementWithText(String str, String str2, String str3) {
        syncWrap(new RunnableC1448i(this, str, str2, str3, 0));
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(OutputStream outputStream) {
        syncWrapIOEx(new C1454o(this, outputStream, 2));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toChild(QName qName) {
        return ((Boolean) syncWrap(new C1460v(this, qName, 1))).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toNextSibling(String str, String str2) {
        return ((Boolean) syncWrap(new C1450k(this, str, str2, 1))).booleanValue();
    }

    private boolean preCheck() {
        checkThisCursor();
        return this._cur._locale.noSync();
    }

    /* JADX INFO: renamed from: _insertAttributeWithValue, reason: merged with bridge method [inline-methods] */
    public void lambda$insertAttributeWithValue$68(QName qName, String str) {
        if (qName != null) {
            validateLocalName(qName.getLocalPart());
            Cur curTempCur = this._cur._locale.tempCur();
            curTempCur.createAttr(qName);
            insertNode(curTempCur, str);
            curTempCur.release();
            return;
        }
        throw new IllegalArgumentException("QName must not be null");
    }

    /* JADX INFO: renamed from: _insertElementWithText, reason: merged with bridge method [inline-methods] */
    public void lambda$insertElementWithText$60(QName qName, String str) {
        validateLocalName(qName.getLocalPart());
        Cur curTempCur = this._cur._locale.tempCur();
        curTempCur.createElement(qName);
        insertNode(curTempCur, str);
        curTempCur.release();
    }

    /* JADX INFO: renamed from: _save, reason: merged with bridge method [inline-methods] */
    public void lambda$save$7(ContentHandler contentHandler, LexicalHandler lexicalHandler) {
        lambda$save$15(contentHandler, lexicalHandler, null);
    }

    public boolean _toChild(String str, String str2) {
        validateLocalName(str2);
        return _toChild(this._cur._locale.makeQName(str, str2), 0);
    }

    public boolean _toNextSibling(QName qName) {
        this._cur.push();
        while (___toNextSibling()) {
            if (this._cur.getName().equals(qName)) {
                this._cur.popButStay();
                return true;
            }
        }
        this._cur.pop();
        return false;
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(Writer writer) {
        syncWrapIOEx(new C1454o(this, writer, 0));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toChild(int i5) {
        return ((Boolean) syncWrap(new C1457s(this, i5, 1))).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toNextSibling(QName qName) {
        return ((Boolean) syncWrap(new C1460v(this, qName, 0))).booleanValue();
    }

    public Cursor(Cur cur) {
        this(cur._xobj, cur._pos);
    }

    /* JADX INFO: renamed from: _beginElement, reason: merged with bridge method [inline-methods] */
    public void lambda$beginElement$57(QName qName) {
        lambda$insertElementWithText$60(qName, (String) null);
        _toPrevToken();
    }

    /* JADX INFO: renamed from: _save, reason: merged with bridge method [inline-methods] */
    public void lambda$save$15(ContentHandler contentHandler, LexicalHandler lexicalHandler, XmlOptions xmlOptions) {
        new Saver.SaxSaver(this._cur, xmlOptions, contentHandler, lexicalHandler);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(ContentHandler contentHandler, LexicalHandler lexicalHandler, XmlOptions xmlOptions) {
        syncWrapSAXEx(new C1447h(this, contentHandler, lexicalHandler, xmlOptions, 0));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toChild(QName qName, int i5) {
        return ((Boolean) syncWrap(new org.apache.poi.util.e(this, qName, i5))).booleanValue();
    }

    private boolean isValid() {
        return isValid(this._cur);
    }

    private <T> T syncWrap(Supplier<T> supplier) {
        T t6;
        if (preCheck()) {
            return (T) syncWrapHelper((Supplier) supplier, true);
        }
        synchronized (this._cur._locale) {
            t6 = (T) syncWrapHelper((Supplier) supplier, true);
        }
        return t6;
    }

    private <T> T syncWrapHelper(Supplier<T> supplier, boolean z6) {
        Locale locale = this._cur._locale;
        if (z6) {
            locale.enter();
        }
        try {
            return supplier.get();
        } finally {
            if (z6) {
                locale.exit();
            }
        }
    }

    private void syncWrapNoEnter(Runnable runnable) {
        if (preCheck()) {
            syncWrapHelper(runnable, false);
            return;
        }
        synchronized (this._cur._locale) {
            syncWrapHelper(runnable, false);
        }
    }

    public int _getTextValue(char[] cArr, int i5, int i6) {
        if (this._cur.isText()) {
            return _getChars(cArr, i5, i6);
        }
        if (cArr == null) {
            throw new IllegalArgumentException("char buffer is null");
        }
        if (i5 >= 0) {
            if (i5 < cArr.length) {
                if (i6 < 0) {
                    i6 = Integer.MAX_VALUE;
                }
                if (i5 + i6 > cArr.length) {
                    i6 = cArr.length - i5;
                }
                if (this._cur.isNode()) {
                    if (this._cur.hasChildren()) {
                        return Locale.getTextValue(this._cur, cArr, i5, i6);
                    }
                    Object firstChars = this._cur.getFirstChars();
                    Cur cur = this._cur;
                    if (cur._cchSrc > i6) {
                        cur._cchSrc = i6;
                    }
                    int i7 = cur._cchSrc;
                    if (i7 <= 0) {
                        return 0;
                    }
                    CharUtil.getChars(cArr, i5, firstChars, cur._offSrc, i7);
                    return this._cur._cchSrc;
                }
                throw new IllegalStateException("Can't get text value, current token can have no text value");
            }
            throw new IllegalArgumentException("offset off end");
        }
        throw new IllegalArgumentException("offset < 0");
    }

    /* JADX INFO: renamed from: _save, reason: merged with bridge method [inline-methods] */
    public void lambda$save$16(File file, XmlOptions xmlOptions) throws IOException {
        if (file != null) {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                lambda$save$17(fileOutputStream, xmlOptions);
                fileOutputStream.close();
                return;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        }
        throw new IllegalArgumentException("Null file specified");
    }

    public boolean _toChild(QName qName, int i5) {
        return Locale.toChild(this._cur, qName, i5);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(File file, XmlOptions xmlOptions) {
        syncWrapIOEx(new C1451l(this, 3, file, xmlOptions));
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(OutputStream outputStream, XmlOptions xmlOptions) {
        syncWrapIOEx(new C1451l(this, 0, outputStream, xmlOptions));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void setTextValue(String str) {
        syncWrap(new RunnableC1443d(this, str, 4));
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(Writer writer, XmlOptions xmlOptions) {
        syncWrapIOEx(new C1451l(this, 2, writer, xmlOptions));
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void setTextValue(final char[] cArr, final int i5, final int i6) {
        syncWrap(new Runnable() { // from class: org.apache.xmlbeans.impl.store.x
            @Override // java.lang.Runnable
            public final void run() {
                this.f7445a.lambda$setTextValue$44(cArr, i5, i6);
            }
        });
    }

    private void syncWrapHelper(WrapSAXEx wrapSAXEx) {
        Locale locale = this._cur._locale;
        locale.enter();
        try {
            wrapSAXEx.run();
        } finally {
            locale.exit();
        }
    }

    /* JADX INFO: renamed from: _save, reason: merged with bridge method [inline-methods] */
    public void lambda$save$17(OutputStream outputStream, XmlOptions xmlOptions) throws IOException {
        if (outputStream != null) {
            InputStream inputStreamLambda$newInputStream$12 = lambda$newInputStream$12(xmlOptions);
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int i5 = inputStreamLambda$newInputStream$12.read(bArr);
                    if (i5 < 0) {
                        inputStreamLambda$newInputStream$12.close();
                        return;
                    }
                    outputStream.write(bArr, 0, i5);
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (inputStreamLambda$newInputStream$12 != null) {
                        try {
                            inputStreamLambda$newInputStream$12.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        } else {
            throw new IllegalArgumentException("Null OutputStream specified");
        }
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public XmlCursor newCursor() {
        return (XmlCursor) syncWrap(new C1461w(this, 13));
    }

    private void syncWrapHelper(WrapIOEx wrapIOEx) {
        Locale locale = this._cur._locale;
        locale.enter();
        try {
            wrapIOEx.run();
        } finally {
            locale.exit();
        }
    }

    /* JADX INFO: renamed from: _save, reason: merged with bridge method [inline-methods] */
    public void lambda$save$18(Writer writer, XmlOptions xmlOptions) throws IOException {
        if (writer != null) {
            if (xmlOptions != null && xmlOptions.isSaveOptimizeForSpeed()) {
                Saver.OptimizedForSpeedSaver.save(this._cur, writer);
                return;
            }
            Reader readerLambda$newReader$13 = lambda$newReader$13(xmlOptions);
            try {
                char[] cArr = new char[8192];
                while (true) {
                    int i5 = readerLambda$newReader$13.read(cArr);
                    if (i5 < 0) {
                        readerLambda$newReader$13.close();
                        return;
                    }
                    writer.write(cArr, 0, i5);
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (readerLambda$newReader$13 != null) {
                        try {
                            readerLambda$newReader$13.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        } else {
            throw new IllegalArgumentException("Null Writer specified");
        }
    }

    private int twoLocaleOp(Cursor cursor, int i5, int i6) {
        Locale locale = this._cur._locale;
        Locale locale2 = cursor._cur._locale;
        locale.enter(locale2);
        try {
            if (i5 == 0) {
                boolean z_moveXml = _moveXml(cursor);
                locale.exit(locale2);
                return z_moveXml ? 1 : 0;
            }
            if (i5 == 1) {
                boolean z_copyXml = _copyXml(cursor);
                locale.exit(locale2);
                return z_copyXml ? 1 : 0;
            }
            if (i5 == 2) {
                boolean z_moveXmlContents = _moveXmlContents(cursor);
                locale.exit(locale2);
                return z_moveXmlContents ? 1 : 0;
            }
            if (i5 == 3) {
                boolean z_copyXmlContents = _copyXmlContents(cursor);
                locale.exit(locale2);
                return z_copyXmlContents ? 1 : 0;
            }
            if (i5 == 4) {
                int i_moveChars = _moveChars(i6, cursor);
                locale.exit(locale2);
                return i_moveChars;
            }
            if (i5 != 5) {
                throw new RuntimeException("Unknown operation: " + i5);
            }
            int i_copyChars = _copyChars(i6, cursor);
            locale.exit(locale2);
            return i_copyChars;
        } catch (Throwable th) {
            locale.exit(locale2);
            throw th;
        }
    }
}
