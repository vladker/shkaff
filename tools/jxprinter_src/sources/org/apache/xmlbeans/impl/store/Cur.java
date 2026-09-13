package org.apache.xmlbeans.impl.store;

import androidx.webkit.ProxyConfig;
import java.io.PrintStream;
import java.util.Map;
import javax.xml.namespace.QName;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.xmlbeans.CDataBookmark;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlDocumentProperties;
import org.apache.xmlbeans.XmlLineNumber;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.soap.Detail;
import org.apache.xmlbeans.impl.soap.DetailEntry;
import org.apache.xmlbeans.impl.soap.SOAPBody;
import org.apache.xmlbeans.impl.soap.SOAPBodyElement;
import org.apache.xmlbeans.impl.soap.SOAPElement;
import org.apache.xmlbeans.impl.soap.SOAPEnvelope;
import org.apache.xmlbeans.impl.soap.SOAPFault;
import org.apache.xmlbeans.impl.soap.SOAPFaultElement;
import org.apache.xmlbeans.impl.soap.SOAPHeader;
import org.apache.xmlbeans.impl.soap.SOAPHeaderElement;
import org.apache.xmlbeans.impl.values.TypeStoreUser;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class Cur {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int ATTR = 3;
    static final int COMMENT = 4;
    static final int DISPOSED = 3;
    static final int ELEM = 2;
    static final int EMBEDDED = 2;
    static final int END_POS = -1;
    static final int NO_POS = -2;
    static final int POOLED = 0;
    static final int PROCINST = 5;
    static final int REGISTERED = 1;
    static final int ROOT = 1;
    static final int TEXT = 0;
    int _cchSrc;
    String _id;
    Locale _locale;
    Cur _next;
    Cur _nextTemp;
    int _offSrc;
    private int _posTemp;
    Cur _prev;
    Cur _prevTemp;
    Locale.Ref _ref;
    Xobj _xobj;
    int _pos = -2;
    int _tempFrame = -1;
    int _state = 0;
    int _stackTop = -1;
    int _selectionFirst = -1;
    int _selectionN = -1;
    int _selectionLoc = -1;
    int _selectionCount = 0;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Locations {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final int NULL = -1;
        private static final int _initialSize = 32;
        private int _free;
        private final Locale _locale;
        private int _naked;
        private Xobj[] _xobjs = new Xobj[32];
        private int[] _poses = new int[32];
        private Cur[] _curs = new Cur[32];
        private int[] _next = new int[32];
        private int[] _prev = new int[32];
        private int[] _nextN = new int[32];
        private int[] _prevN = new int[32];

        public Locations(Locale locale) {
            this._locale = locale;
            for (int i5 = 31; i5 >= 0; i5--) {
                this._poses[i5] = -2;
                this._next[i5] = i5 + 1;
                this._prev[i5] = -1;
                this._nextN[i5] = -1;
                this._prevN[i5] = -1;
            }
            this._next[31] = -1;
            this._free = 0;
            this._naked = -1;
        }

        private void makeRoom() {
            Xobj[] xobjArr = this._xobjs;
            int length = xobjArr.length;
            int[] iArr = this._poses;
            Cur[] curArr = this._curs;
            int[] iArr2 = this._next;
            int[] iArr3 = this._prev;
            int[] iArr4 = this._nextN;
            int[] iArr5 = this._prevN;
            int i5 = length * 2;
            Xobj[] xobjArr2 = new Xobj[i5];
            this._xobjs = xobjArr2;
            this._poses = new int[i5];
            this._curs = new Cur[i5];
            this._next = new int[i5];
            this._prev = new int[i5];
            this._nextN = new int[i5];
            this._prevN = new int[i5];
            System.arraycopy(xobjArr, 0, xobjArr2, 0, length);
            System.arraycopy(iArr, 0, this._poses, 0, length);
            System.arraycopy(curArr, 0, this._curs, 0, length);
            System.arraycopy(iArr2, 0, this._next, 0, length);
            System.arraycopy(iArr3, 0, this._prev, 0, length);
            System.arraycopy(iArr4, 0, this._nextN, 0, length);
            System.arraycopy(iArr5, 0, this._prevN, 0, length);
            int i6 = i5 - 1;
            for (int i7 = i6; i7 >= length; i7--) {
                this._next[i7] = i7 + 1;
                this._prev[i7] = -1;
                this._nextN[i7] = -1;
                this._prevN[i7] = -1;
                this._poses[i7] = -2;
            }
            this._next[i6] = -1;
            this._free = length;
        }

        public int allocate(Cur cur) {
            if (this._free == -1) {
                makeRoom();
            }
            int i5 = this._free;
            int[] iArr = this._next;
            this._free = iArr[i5];
            iArr[i5] = -1;
            this._xobjs[i5] = cur._xobj;
            this._poses[i5] = cur._pos;
            this._naked = insert(this._naked, -1, i5, this._nextN, this._prevN);
            return i5;
        }

        public int insert(int i5, int i6, int i7) {
            return insert(i5, i6, i7, this._next, this._prev);
        }

        public boolean isAtEndOf(int i5, Cur cur) {
            Cur cur2 = this._curs[i5];
            if (cur2 == null) {
                return cur._xobj == this._xobjs[i5] && cur._pos == -1;
            }
            return cur.isAtEndOf(cur2);
        }

        public boolean isSamePos(int i5, Cur cur) {
            Cur cur2 = this._curs[i5];
            if (cur2 == null) {
                return cur._xobj == this._xobjs[i5] && cur._pos == this._poses[i5];
            }
            return cur.isSamePos(cur2);
        }

        public void moveTo(int i5, Cur cur) {
            Cur cur2 = this._curs[i5];
            if (cur2 == null) {
                cur.moveTo(this._xobjs[i5], this._poses[i5]);
            } else {
                cur.moveToCur(cur2);
            }
        }

        public int next(int i5) {
            return this._next[i5];
        }

        public void notifyChange() {
            while (true) {
                int i5 = this._naked;
                if (i5 == -1) {
                    return;
                }
                this._naked = remove(i5, i5, this._nextN, this._prevN);
                this._curs[i5] = this._locale.getCur();
                this._curs[i5].moveTo(this._xobjs[i5], this._poses[i5]);
                this._xobjs[i5] = null;
                this._poses[i5] = -2;
            }
        }

        public int prev(int i5) {
            return this._prev[i5];
        }

        public int remove(int i5, int i6) {
            Cur cur = this._curs[i6];
            if (cur != null) {
                cur.release();
                this._curs[i6] = null;
            } else {
                this._xobjs[i6] = null;
                this._poses[i6] = -2;
                this._naked = remove(this._naked, i6, this._nextN, this._prevN);
            }
            int iRemove = remove(i5, i6, this._next, this._prev);
            this._next[i6] = this._free;
            this._free = i6;
            return iRemove;
        }

        private static int insert(int i5, int i6, int i7, int[] iArr, int[] iArr2) {
            if (i5 == -1) {
                iArr2[i7] = i7;
                return i7;
            }
            if (i6 != -1) {
                iArr2[i7] = iArr2[i6];
                iArr[i7] = i6;
                iArr2[i6] = i7;
                return i5 == i6 ? i7 : i5;
            }
            iArr2[i7] = iArr2[i5];
            iArr[iArr2[i5]] = i7;
            iArr2[i5] = i7;
            return i5;
        }

        private static int remove(int i5, int i6, int[] iArr, int[] iArr2) {
            int i7 = iArr2[i6];
            if (i7 == i6) {
                i5 = -1;
            } else {
                if (i5 == i6) {
                    i5 = iArr[i6];
                } else {
                    iArr[i7] = iArr[i6];
                }
                int i8 = iArr[i6];
                if (i8 == -1) {
                    iArr2[i5] = iArr2[i6];
                } else {
                    iArr2[i8] = iArr2[i6];
                    iArr[i6] = -1;
                }
            }
            iArr2[i6] = -1;
            return i5;
        }
    }

    public Cur(Locale locale) {
        this._locale = locale;
    }

    public static Xobj createDomDocumentRootXobj(Locale locale) {
        return createDomDocumentRootXobj(locale, false);
    }

    public static Xobj createElementXobj(Locale locale, QName qName, QName qName2) {
        Saaj saaj = locale._saaj;
        if (saaj == null) {
            return new ElementXobj(locale, qName);
        }
        Class clsIdentifyElement = saaj.identifyElement(qName, qName2);
        if (clsIdentifyElement == SOAPElement.class) {
            return new SoapElementXobj(locale, qName);
        }
        if (clsIdentifyElement == SOAPBody.class) {
            return new SoapBodyXobj(locale, qName);
        }
        if (clsIdentifyElement == SOAPBodyElement.class) {
            return new SoapBodyElementXobj(locale, qName);
        }
        if (clsIdentifyElement == SOAPEnvelope.class) {
            return new SoapEnvelopeXobj(locale, qName);
        }
        if (clsIdentifyElement == SOAPHeader.class) {
            return new SoapHeaderXobj(locale, qName);
        }
        if (clsIdentifyElement == SOAPHeaderElement.class) {
            return new SoapHeaderElementXobj(locale, qName);
        }
        if (clsIdentifyElement == SOAPFaultElement.class) {
            return new SoapFaultElementXobj(locale, qName);
        }
        if (clsIdentifyElement == Detail.class) {
            return new DetailXobj(locale, qName);
        }
        if (clsIdentifyElement == DetailEntry.class) {
            return new DetailEntryXobj(locale, qName);
        }
        if (clsIdentifyElement == SOAPFault.class) {
            return new SoapFaultXobj(locale, qName);
        }
        throw new IllegalStateException("Unknown SAAJ element class: " + clsIdentifyElement);
    }

    private void createHelper(Xobj xobj) {
        if (isPositioned()) {
            Cur curTempCur = tempCur(xobj, 0);
            curTempCur.moveNode(this);
            curTempCur.release();
        }
        moveTo(xobj);
    }

    private static void dumpBookmarks(PrintStream printStream, Xobj xobj, Object obj) {
        for (Bookmark bookmark = xobj._bookmarks; bookmark != null; bookmark = bookmark._next) {
            printStream.print(" ");
            if (obj == bookmark) {
                printStream.print("*:");
            }
            Object obj2 = bookmark._value;
            if (obj2 instanceof XmlLineNumber) {
                printStream.print("<line:" + ((XmlLineNumber) obj2).getLine() + ">[" + bookmark._pos + "]");
            } else {
                printStream.print("<mark>[" + bookmark._pos + "]");
            }
        }
    }

    private static void dumpCharNodes(PrintStream printStream, CharNode charNode, Object obj) {
        while (charNode != null) {
            printStream.print(" ");
            if (charNode == obj) {
                printStream.print(ProxyConfig.MATCH_ALL_SCHEMES);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(charNode instanceof TextNode ? "TEXT" : "CDATA");
            sb.append("[");
            sb.append(charNode._cch);
            sb.append("]");
            printStream.print(sb.toString());
            charNode = charNode._next;
        }
    }

    private static void dumpChars(PrintStream printStream, Object obj, int i5, int i6) {
        printStream.print("\"");
        String string = CharUtil.getString(obj, i5, i6);
        int iCharCount = 0;
        while (iCharCount < string.length()) {
            if (iCharCount == 36) {
                printStream.print("...");
                break;
            }
            int iCodePointAt = string.codePointAt(iCharCount);
            char[] chars = Character.toChars(iCodePointAt);
            if (chars.length == 1) {
                char c = chars[0];
                if (c >= ' ' && c < 127 && c != '\"') {
                    printStream.print(c);
                } else if (c == '\n') {
                    printStream.print("\\n");
                } else if (c == '\r') {
                    printStream.print("\\r");
                } else if (c == '\t') {
                    printStream.print("\\t");
                } else if (c == '\"') {
                    printStream.print("\\\"");
                } else {
                    printStream.print("<#" + ((int) c) + ">");
                }
            } else {
                printStream.print("<#" + iCodePointAt + ">");
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        printStream.print("\"");
    }

    private static void dumpCur(PrintStream printStream, String str, Cur cur, Object obj) {
        printStream.print(" ");
        if (obj == cur) {
            printStream.print("*:");
        }
        StringBuilder sbR = androidx.collection.a.r(str);
        String str2 = cur._id;
        if (str2 == null) {
            str2 = "<cur>";
        }
        sbR.append(str2);
        sbR.append("[");
        sbR.append(cur._pos);
        sbR.append("]");
        printStream.print(sbR.toString());
    }

    private static void dumpCurs(PrintStream printStream, Xobj xobj, Object obj) {
        for (Cur cur = xobj._embedded; cur != null; cur = cur._next) {
            dumpCur(printStream, "E:", cur, obj);
        }
        for (Cur cur2 = xobj._locale._registered; cur2 != null; cur2 = cur2._next) {
            if (cur2._xobj == xobj) {
                dumpCur(printStream, "R:", cur2, obj);
            }
        }
    }

    private static void dumpXobj(PrintStream printStream, Xobj xobj, int i5, Object obj) {
        int iLastIndexOf;
        if (xobj == null) {
            return;
        }
        if (xobj == obj) {
            printStream.print("* ");
        } else {
            printStream.print("  ");
        }
        for (int i6 = 0; i6 < i5; i6++) {
            printStream.print("  ");
        }
        printStream.print(kindName(xobj.kind()));
        if (xobj._name != null) {
            printStream.print(" ");
            if (xobj._name.getPrefix().length() > 0) {
                printStream.print(xobj._name.getPrefix() + ParameterizedMessage.ERROR_MSG_SEPARATOR);
            }
            printStream.print(xobj._name.getLocalPart());
            if (xobj._name.getNamespaceURI().length() > 0) {
                printStream.print("@" + xobj._name.getNamespaceURI());
            }
        }
        if (xobj._srcValue != null || xobj._charNodesValue != null) {
            printStream.print(" Value( ");
            dumpChars(printStream, xobj._srcValue, xobj._offValue, xobj._cchValue);
            dumpCharNodes(printStream, xobj._charNodesValue, obj);
            printStream.print(" )");
        }
        if (xobj._user != null) {
            printStream.print(" (USER)");
        }
        if (xobj.isVacant()) {
            printStream.print(" (VACANT)");
        }
        if (xobj._srcAfter != null || xobj._charNodesAfter != null) {
            printStream.print(" After( ");
            dumpChars(printStream, xobj._srcAfter, xobj._offAfter, xobj._cchAfter);
            dumpCharNodes(printStream, xobj._charNodesAfter, obj);
            printStream.print(" )");
        }
        dumpCurs(printStream, xobj, obj);
        dumpBookmarks(printStream, xobj, obj);
        String name = xobj.getClass().getName();
        int iLastIndexOf2 = name.lastIndexOf(46);
        if (iLastIndexOf2 > 0 && (iLastIndexOf = (name = name.substring(iLastIndexOf2 + 1)).lastIndexOf(36)) > 0) {
            name = name.substring(iLastIndexOf + 1);
        }
        printStream.print(" (");
        printStream.print(name);
        printStream.print(")");
        printStream.println();
        for (Xobj xobj2 = xobj._firstChild; xobj2 != null; xobj2 = xobj2._nextSibling) {
            dumpXobj(printStream, xobj2, i5 + 1, obj);
        }
    }

    private Xobj getDenormal() {
        return getDenormal(this._xobj, this._pos);
    }

    private Xobj getNormal(Xobj xobj, int i5) {
        Xobj normal = xobj.getNormal(i5);
        this._posTemp = xobj._locale._posTemp;
        return normal;
    }

    public static boolean kindIsContainer(int i5) {
        return i5 == 2 || i5 == 1;
    }

    public static boolean kindIsFinish(int i5) {
        return i5 == -2 || i5 == -1;
    }

    public static String kindName(int i5) {
        if (i5 == 0) {
            return "TEXT";
        }
        if (i5 == 1) {
            return "ROOT";
        }
        if (i5 == 2) {
            return "ELEM";
        }
        if (i5 == 3) {
            return "ATTR";
        }
        if (i5 != 4) {
            return i5 != 5 ? androidx.collection.a.i(i5, "<< Unknown Kind (", ") >>") : "PROCINST";
        }
        return "COMMENT";
    }

    private int selectionIndex(int i5) {
        if (this._selectionN == -1) {
            this._selectionN = 0;
            this._selectionLoc = this._selectionFirst;
        }
        while (this._selectionN < i5) {
            this._selectionLoc = this._locale._locations.next(this._selectionLoc);
            this._selectionN++;
        }
        while (this._selectionN > i5) {
            this._selectionLoc = this._locale._locations.prev(this._selectionLoc);
            this._selectionN--;
        }
        return this._selectionLoc;
    }

    private static void transferChars(Xobj xobj, int i5, Xobj xobj2, int i6, int i7) {
        Object charsHelper = xobj.getCharsHelper(i5, i7);
        Locale locale = xobj._locale;
        xobj2.insertCharsHelper(i6, charsHelper, locale._offSrc, locale._cchSrc, false);
        xobj.removeCharsHelper(i5, i7, xobj2, i6, true, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static CharNode updateCharNodes(Locale locale, Xobj xobj, CharNode charNode, int i5) {
        CharNode charNode2 = charNode;
        int i6 = 0;
        while (charNode2 != null && i5 > 0) {
            if (charNode2._cch > i5) {
                charNode2._cch = i5;
            }
            charNode2._off = i6;
            int i7 = charNode2._cch;
            i6 += i7;
            i5 -= i7;
            charNode2 = charNode2._next;
        }
        if (i5 > 0) {
            TextNode textNodeCreateTextNode = locale.createTextNode();
            textNodeCreateTextNode.setDom((DomImpl.Dom) xobj);
            textNodeCreateTextNode._cch = i5;
            textNodeCreateTextNode._off = i6;
            return CharNode.appendNode(charNode, textNodeCreateTextNode);
        }
        while (charNode2 != null) {
            if (charNode2._cch != 0) {
                charNode2._cch = 0;
            }
            charNode2._off = i6;
            charNode2 = charNode2._next;
        }
        return charNode;
    }

    public void addToSelection(Cur cur) {
        this._selectionFirst = this._locale._locations.insert(this._selectionFirst, -1, this._locale._locations.allocate(cur));
        this._selectionCount++;
    }

    public int cchLeft() {
        return this._xobj.cchLeft(this._pos);
    }

    public int cchRight() {
        return this._xobj.cchRight(this._pos);
    }

    public void clearSelection() {
        while (this._selectionCount > 0) {
            removeFirstSelection();
        }
    }

    public int comparePosition(Cur cur) {
        if (this._locale != cur._locale) {
            return 2;
        }
        Xobj xobj = this._xobj;
        int iPosAfter = this._pos;
        if (iPosAfter == -1) {
            iPosAfter = xobj.posAfter() - 1;
        }
        Xobj xobj2 = cur._xobj;
        int iPosAfter2 = cur._pos;
        if (iPosAfter2 == -1) {
            iPosAfter2 = xobj2.posAfter() - 1;
        }
        if (xobj == xobj2) {
            return Integer.compare(iPosAfter, iPosAfter2);
        }
        int i5 = 0;
        int i6 = 0;
        for (Xobj xobj3 = xobj._parent; xobj3 != null; xobj3 = xobj3._parent) {
            i6++;
            if (xobj3 == xobj2) {
                return iPosAfter2 < xobj2.posAfter() - 1 ? 1 : -1;
            }
        }
        for (Xobj xobj4 = xobj2._parent; xobj4 != null; xobj4 = xobj4._parent) {
            i5++;
            if (xobj4 == xobj) {
                return iPosAfter < xobj.posAfter() - 1 ? -1 : 1;
            }
        }
        while (i6 > i5) {
            i6--;
            xobj = xobj._parent;
        }
        while (i5 > i6) {
            i5--;
            xobj2 = xobj2._parent;
        }
        if (i5 == 0) {
            return 2;
        }
        while (true) {
            Xobj xobj5 = xobj._parent;
            Xobj xobj6 = xobj2._parent;
            if (xobj5 == xobj6) {
                if (xobj._prevSibling == null || xobj2._nextSibling == null) {
                    return -1;
                }
                if (xobj._nextSibling == null || xobj2._prevSibling == null) {
                    return 1;
                }
                while (xobj != null) {
                    xobj = xobj._prevSibling;
                    if (xobj == xobj2) {
                        return 1;
                    }
                }
                return -1;
            }
            if (xobj5 == null) {
                return 2;
            }
            xobj = xobj5;
            xobj2 = xobj6;
        }
    }

    public boolean contains(Cur cur) {
        return this._xobj.contains(cur);
    }

    public void copyNode(Cur cur) {
        Xobj xobjCopyNode = this._xobj.copyNode(cur._locale);
        if (cur.isPositioned()) {
            moveNode(xobjCopyNode, cur);
        } else {
            cur.moveTo(xobjCopyNode);
        }
    }

    public void createAttr(QName qName) {
        createHelper(new AttrXobj(this._locale, qName));
    }

    public void createComment() {
        createHelper(new CommentXobj(this._locale));
    }

    public void createDomDocFragRoot() {
        moveTo(new DocumentFragXobj(this._locale));
    }

    public void createDomDocumentRoot() {
        moveTo(createDomDocumentRootXobj(this._locale));
    }

    public void createElement(QName qName) {
        createElement(qName, null);
    }

    public void createProcinst(String str) {
        createHelper(new ProcInstXobj(this._locale, str));
    }

    public void createRoot() {
        createDomDocFragRoot();
    }

    public void dump() {
        dump(System.out, this._xobj, this);
    }

    public int firstBookmarkInChars(Object obj, int i5) {
        if (!isText()) {
            return -1;
        }
        int i6 = -1;
        for (Bookmark bookmark = this._xobj._bookmarks; bookmark != null; bookmark = bookmark._next) {
            if (bookmark._key == obj && inChars(bookmark, i5, false) && (i6 == -1 || bookmark._pos - this._pos < i6)) {
                i6 = bookmark._pos - this._pos;
            }
        }
        return i6;
    }

    public int firstBookmarkInCharsLeft(Object obj, int i5) {
        int i6;
        if (cchLeft() <= 0) {
            return -1;
        }
        Xobj denormal = getDenormal();
        int i7 = this._posTemp - i5;
        Bookmark bookmark = denormal._bookmarks;
        int i8 = -1;
        while (bookmark != null) {
            if (bookmark._key == obj) {
                i6 = i5;
                if (denormal.inChars(i7, bookmark._xobj, bookmark._pos, i6, false) && (i8 == -1 || bookmark._pos - i7 < i8)) {
                    i8 = bookmark._pos - i7;
                }
            } else {
                i6 = i5;
            }
            bookmark = bookmark._next;
            i5 = i6;
        }
        return i8;
    }

    public String getAttrValue(QName qName) {
        push();
        String valueAsString = toAttr(qName) ? getValueAsString() : null;
        pop();
        return valueAsString;
    }

    public Object getBookmark(Object obj) {
        for (Bookmark bookmark = this._xobj._bookmarks; bookmark != null; bookmark = bookmark._next) {
            if (bookmark._pos == this._pos && bookmark._key == obj) {
                return bookmark._value;
            }
        }
        return null;
    }

    public CharNode getCharNodes() {
        Xobj denormal = getDenormal();
        if (this._posTemp >= denormal.posAfter()) {
            CharNode charNodeUpdateCharNodes = updateCharNodes(this._locale, denormal, denormal._charNodesAfter, denormal._cchAfter);
            denormal._charNodesAfter = charNodeUpdateCharNodes;
            return charNodeUpdateCharNodes;
        }
        denormal.ensureOccupancy();
        CharNode charNodeUpdateCharNodes2 = updateCharNodes(this._locale, denormal, denormal._charNodesValue, denormal._cchValue);
        denormal._charNodesValue = charNodeUpdateCharNodes2;
        return charNodeUpdateCharNodes2;
    }

    public Object getChars(int i5) {
        return this._xobj.getChars(this._pos, i5, this);
    }

    public String getCharsAsString() {
        return getCharsAsString(1);
    }

    public DomImpl.Dom getDom() {
        if (!isText()) {
            return this._xobj.getDom();
        }
        int iCchLeft = cchLeft();
        CharNode charNodes = getCharNodes();
        while (true) {
            iCchLeft -= charNodes._cch;
            if (iCchLeft < 0) {
                return charNodes;
            }
            charNodes = charNodes._next;
        }
    }

    public Object getFirstChars() {
        Object firstChars = this._xobj.getFirstChars();
        Locale locale = this._locale;
        this._offSrc = locale._offSrc;
        this._cchSrc = locale._cchSrc;
        return firstChars;
    }

    public String getLocal() {
        return getName().getLocalPart();
    }

    public Locale getLocale() {
        return this._locale;
    }

    public QName getName() {
        return this._xobj._name;
    }

    public XmlObject getObject() {
        if (isUserNode()) {
            return (XmlObject) getUser();
        }
        return null;
    }

    public Xobj getParent() {
        return getParent(false);
    }

    public Xobj getParentNoRoot() {
        int i5 = this._pos;
        if (i5 == -1 || (i5 >= 1 && i5 < this._xobj.posAfter())) {
            return this._xobj;
        }
        Xobj xobj = this._xobj._parent;
        if (xobj != null) {
            return xobj;
        }
        return null;
    }

    public Xobj getParentRaw() {
        return getParent(true);
    }

    public String getUri() {
        return getName().getNamespaceURI();
    }

    public TypeStoreUser getUser() {
        return this._xobj.getUser();
    }

    public String getValueAsString(int i5) {
        return this._xobj.getValueAsString(i5);
    }

    public String getXmlnsPrefix() {
        return this._xobj.getXmlnsPrefix();
    }

    public String getXmlnsUri() {
        return this._xobj.getXmlnsUri();
    }

    public final QName getXsiTypeName() {
        return this._xobj.getXsiTypeName();
    }

    public boolean hasAttrs() {
        return this._xobj.hasAttrs();
    }

    public boolean hasChildren() {
        return this._xobj.hasChildren();
    }

    public boolean hasParent() {
        int i5 = this._pos;
        return i5 == -1 || (i5 >= 1 && i5 < this._xobj.posAfter()) || this._xobj._parent != null;
    }

    public boolean hasText() {
        return this._xobj.hasTextEnsureOccupancy();
    }

    public boolean inChars(Cur cur, int i5, boolean z6) {
        return this._xobj.inChars(this._pos, cur._xobj, cur._pos, i5, z6);
    }

    public void insertChars(Object obj, int i5, int i6) {
        if (i6 <= 0) {
            return;
        }
        this._locale.notifyChange();
        if (this._pos == -1) {
            this._xobj.ensureOccupancy();
        }
        Xobj denormal = getDenormal();
        int i7 = this._posTemp;
        denormal.insertCharsHelper(i7, obj, i5, i6, true);
        moveTo(denormal, i7);
        this._locale._versionAll++;
    }

    public void insertString(String str) {
        if (str != null) {
            insertChars(str, 0, str.length());
        }
    }

    public boolean isAtEndOf(Cur cur) {
        return this._xobj == cur._xobj && this._pos == -1;
    }

    public boolean isAtEndOfLastPush() {
        return this._locale._locations.isAtEndOf(this._stackTop, this);
    }

    public boolean isAtLastPush() {
        return this._locale._locations.isSamePos(this._stackTop, this);
    }

    public boolean isAttr() {
        return this._pos == 0 && this._xobj.kind() == 3;
    }

    public boolean isComment() {
        return this._pos == 0 && this._xobj.kind() == 4;
    }

    public boolean isContainer() {
        return this._pos == 0 && kindIsContainer(this._xobj.kind());
    }

    public boolean isContainerOrFinish() {
        int i5 = this._pos;
        if (i5 != 0 && i5 != -1) {
            return false;
        }
        int iKind = this._xobj.kind();
        return iKind == 2 || iKind == -2 || iKind == 1 || iKind == -1;
    }

    public boolean isDomDocRoot() {
        return isRoot() && (this._xobj.getDom() instanceof Document);
    }

    public boolean isDomFragRoot() {
        return isRoot() && (this._xobj.getDom() instanceof DocumentFragment);
    }

    public boolean isElem() {
        return this._pos == 0 && this._xobj.kind() == 2;
    }

    public boolean isEnd() {
        return this._pos == -1 && this._xobj.kind() == 2;
    }

    public boolean isEndRoot() {
        return this._pos == -1 && this._xobj.kind() == 1;
    }

    public boolean isFinish() {
        return this._pos == -1 && kindIsContainer(this._xobj.kind());
    }

    public boolean isInSameTree(Cur cur) {
        return this._xobj.isInSameTree(cur._xobj);
    }

    public boolean isJustAfterEnd(Cur cur) {
        return cur._xobj.isJustAfterEnd(this._xobj, this._pos);
    }

    public boolean isNode() {
        return this._pos == 0;
    }

    public boolean isNormal() {
        int i5 = this._state;
        if (i5 == 0 || i5 == 3) {
            return false;
        }
        Xobj xobj = this._xobj;
        if (xobj == null) {
            return this._pos == -2;
        }
        if (xobj.isNormal(this._pos)) {
            return this._state == 2 ? isOnList(this._xobj._embedded) : isOnList(this._locale._registered);
        }
        return false;
    }

    public boolean isNormalAttr() {
        return isNode() && this._xobj.isNormalAttr();
    }

    public boolean isOnList(Cur cur) {
        while (cur != null) {
            if (cur == this) {
                return true;
            }
            cur = cur._next;
        }
        return false;
    }

    public boolean isPositioned() {
        return this._xobj != null;
    }

    public boolean isProcinst() {
        return this._pos == 0 && this._xobj.kind() == 5;
    }

    public boolean isRoot() {
        return this._pos == 0 && this._xobj.kind() == 1;
    }

    public boolean isSamePos(Cur cur) {
        return this._xobj == cur._xobj && this._pos == cur._pos;
    }

    public boolean isText() {
        return this._pos > 0;
    }

    public boolean isTextCData() {
        return this._xobj.hasBookmark(CDataBookmark.class, this._pos);
    }

    public boolean isUserNode() {
        int iKind = kind();
        return iKind == 2 || iKind == 1 || (iKind == 3 && !isXmlns());
    }

    public boolean isXmlns() {
        return isNode() && this._xobj.isXmlns();
    }

    public int kind() {
        int iKind = this._xobj.kind();
        int i5 = this._pos;
        if (i5 == 0) {
            return iKind;
        }
        if (i5 == -1) {
            return -iKind;
        }
        return 0;
    }

    public Cur listInsert(Cur cur) {
        if (cur == null) {
            this._prev = this;
            return this;
        }
        this._prev = cur._prev;
        cur._prev._next = this;
        cur._prev = this;
        return cur;
    }

    public Cur listRemove(Cur cur) {
        Cur cur2 = this._prev;
        if (cur2 == this) {
            cur = null;
        } else {
            if (cur == this) {
                cur = this._next;
            } else {
                cur2._next = this._next;
            }
            Cur cur3 = this._next;
            if (cur3 != null) {
                cur3._prev = cur2;
                this._next = null;
            } else if (cur != null) {
                cur._prev = cur2;
            }
        }
        this._prev = null;
        return cur;
    }

    public Object moveChars(Cur cur, int i5) {
        if (i5 < 0) {
            i5 = cchRight();
        }
        int i6 = i5;
        if (i6 == 0) {
            this._offSrc = 0;
            this._cchSrc = 0;
            return null;
        }
        Object chars = getChars(i6);
        int i7 = this._offSrc;
        if (cur == null) {
            for (Bookmark bookmark = this._xobj._bookmarks; bookmark != null; bookmark = bookmark._next) {
                if (inChars(bookmark, i6, false)) {
                    Cur curTempCur = this._locale.tempCur();
                    curTempCur.createRoot();
                    curTempCur.next();
                    Object objMoveChars = moveChars(curTempCur, i6);
                    curTempCur.release();
                    return objMoveChars;
                }
            }
        } else {
            if (inChars(cur, i6, true)) {
                cur.moveToCur(this);
                nextChars(i6);
                this._offSrc = i7;
                this._cchSrc = i6;
                return chars;
            }
            cur.insertChars(chars, i7, i6);
        }
        this._locale.notifyChange();
        if (cur == null) {
            this._xobj.removeCharsHelper(this._pos, i6, null, -2, false, true);
        } else {
            this._xobj.removeCharsHelper(this._pos, i6, cur._xobj, cur._pos, false, true);
        }
        this._locale._versionAll++;
        this._offSrc = i7;
        this._cchSrc = i6;
        return chars;
    }

    public void moveNode(Cur cur) {
        Xobj xobj = this._xobj;
        skip();
        moveNode(xobj, cur);
    }

    public void moveNodeContents(Cur cur, boolean z6) {
        moveNodeContents(this._xobj, cur, z6);
    }

    public void moveTo(Xobj xobj) {
        moveTo(xobj, 0);
    }

    public void moveToCharNode(CharNode charNode) {
        moveToDom(charNode.getDom());
        this._xobj.ensureOccupancy();
        Xobj xobj = this._xobj;
        CharNode charNodeUpdateCharNodes = updateCharNodes(this._locale, xobj, xobj._charNodesValue, xobj._cchValue);
        xobj._charNodesValue = charNodeUpdateCharNodes;
        while (charNodeUpdateCharNodes != null) {
            if (charNode == charNodeUpdateCharNodes) {
                moveTo(getNormal(this._xobj, charNodeUpdateCharNodes._off + 1), this._posTemp);
                return;
            }
            charNodeUpdateCharNodes = charNodeUpdateCharNodes._next;
        }
        Xobj xobj2 = this._xobj;
        CharNode charNodeUpdateCharNodes2 = updateCharNodes(this._locale, xobj2, xobj2._charNodesAfter, xobj2._cchAfter);
        xobj2._charNodesAfter = charNodeUpdateCharNodes2;
        while (charNodeUpdateCharNodes2 != null) {
            if (charNode == charNodeUpdateCharNodes2) {
                Xobj xobj3 = this._xobj;
                moveTo(getNormal(xobj3, charNodeUpdateCharNodes2._off + xobj3._cchValue + 2), this._posTemp);
                return;
            }
            charNodeUpdateCharNodes2 = charNodeUpdateCharNodes2._next;
        }
    }

    public void moveToCur(Cur cur) {
        if (cur == null) {
            moveTo(null, -2);
        } else {
            moveTo(cur._xobj, cur._pos);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void moveToDom(DomImpl.Dom dom) {
        moveTo(dom instanceof Xobj ? (Xobj) dom : ((SoapPartDom) dom)._docXobj);
    }

    public void moveToNoCheck(Xobj xobj, int i5) {
        Xobj xobj2;
        if (this._state == 2 && xobj != (xobj2 = this._xobj)) {
            xobj2._embedded = listRemove(xobj2._embedded);
            Locale locale = this._locale;
            locale._registered = listInsert(locale._registered);
            this._state = 1;
        }
        this._xobj = xobj;
        this._pos = i5;
    }

    public void moveToSelection(int i5) {
        this._locale._locations.moveTo(selectionIndex(i5), this);
    }

    public final String namespaceForPrefix(String str, boolean z6) {
        return this._xobj.namespaceForPrefix(str, z6);
    }

    public boolean next(boolean z6) {
        return z6 ? nextWithAttrs() : next();
    }

    public int nextChars(int i5) {
        int iCchRight = cchRight();
        if (iCchRight == 0) {
            return 0;
        }
        if (i5 < 0 || i5 >= iCchRight) {
            next();
            return iCchRight;
        }
        moveTo(getNormal(this._xobj, this._pos + i5), this._posTemp);
        return i5;
    }

    public boolean nextWithAttrs() {
        int iKind = kind();
        if (kindIsContainer(iKind)) {
            if (toFirstAttr()) {
                return true;
            }
        } else if (iKind == -3) {
            if (next()) {
                return true;
            }
            toParent();
            if (!toParentRaw()) {
                return false;
            }
        }
        return next();
    }

    public TypeStoreUser peekUser() {
        return this._xobj._user;
    }

    public boolean pop() {
        int i5 = this._stackTop;
        if (i5 == -1) {
            return false;
        }
        this._locale._locations.moveTo(i5, this);
        Locations locations = this._locale._locations;
        int i6 = this._stackTop;
        this._stackTop = locations.remove(i6, i6);
        return true;
    }

    public void popButStay() {
        int i5 = this._stackTop;
        if (i5 != -1) {
            this._stackTop = this._locale._locations.remove(i5, i5);
        }
    }

    public final String prefixForNamespace(String str, String str2, boolean z6) {
        return (isContainer() ? this._xobj : getParent()).prefixForNamespace(str, str2, z6);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x005b  */
    public boolean prev() {
        Xobj xobj;
        int i5 = 0;
        if (this._xobj.isRoot() && this._pos == 0) {
            return false;
        }
        if (this._xobj.isAttr() && this._pos == 0 && this._xobj._prevSibling == null) {
            return false;
        }
        Xobj denormal = getDenormal();
        int i6 = this._posTemp;
        int iPosAfter = denormal.posAfter();
        if (i6 > iPosAfter) {
            i5 = iPosAfter;
        } else if (i6 == iPosAfter) {
            if (!denormal.isAttr() || (denormal._cchAfter <= 0 && (xobj = denormal._nextSibling) != null && xobj.isAttr())) {
                i5 = -1;
            } else {
                denormal = denormal.ensureParent();
            }
        } else if (i6 == iPosAfter - 1) {
            denormal.ensureOccupancy();
            if (denormal._cchValue > 0) {
                i5 = 1;
            }
        } else if (i6 > 1) {
            i5 = 1;
        }
        moveTo(getNormal(denormal, i5), this._posTemp);
        return true;
    }

    public int prevChars(int i5) {
        int iCchLeft = cchLeft();
        if (i5 < 0 || i5 > iCchLeft) {
            i5 = iCchLeft;
        }
        if (i5 != 0) {
            moveTo(getNormal(getDenormal(), this._posTemp - i5), this._posTemp);
        }
        return i5;
    }

    public boolean prevWithAttrs() {
        if (prev()) {
            return true;
        }
        if (!isAttr()) {
            return false;
        }
        toParent();
        return true;
    }

    public void push() {
        int iAllocate = this._locale._locations.allocate(this);
        Locations locations = this._locale._locations;
        int i5 = this._stackTop;
        this._stackTop = locations.insert(i5, i5, iAllocate);
    }

    public void release() {
        int i5 = this._tempFrame;
        if (i5 >= 0) {
            Cur cur = this._nextTemp;
            if (cur != null) {
                cur._prevTemp = this._prevTemp;
            }
            Cur cur2 = this._prevTemp;
            if (cur2 == null) {
                this._locale._tempFrames[i5] = cur;
            } else {
                cur2._nextTemp = cur;
            }
            this._nextTemp = null;
            this._prevTemp = null;
            this._tempFrame = -1;
        }
        int i6 = this._state;
        if (i6 == 0 || i6 == 3) {
            return;
        }
        while (this._stackTop != -1) {
            popButStay();
        }
        clearSelection();
        this._id = null;
        moveToCur(null);
        Locale.Ref ref = this._ref;
        if (ref != null) {
            ref.clear();
            this._ref._cur = null;
        }
        this._ref = null;
        Locale locale = this._locale;
        locale._registered = listRemove(locale._registered);
        Locale locale2 = this._locale;
        if (locale2._curPoolCount >= 16) {
            this._locale = null;
            this._state = 3;
        } else {
            locale2._curPool = listInsert(locale2._curPool);
            this._state = 0;
            this._locale._curPoolCount++;
        }
    }

    public boolean removeAttr(QName qName) {
        return this._xobj.removeAttr(qName);
    }

    public void removeFirstSelection() {
        int iSelectionIndex = selectionIndex(0);
        int i5 = this._selectionN;
        if (i5 > 0) {
            this._selectionN = i5 - 1;
        } else if (i5 == 0) {
            this._selectionN = i5 - 1;
            this._selectionLoc = -1;
        }
        this._selectionFirst = this._locale._locations.remove(this._selectionFirst, iSelectionIndex);
        this._selectionCount--;
    }

    public void removeFollowingAttrs() {
        QName name = getName();
        push();
        if (toNextAttr()) {
            while (isAttr()) {
                if (getName().equals(name)) {
                    moveNode(null);
                } else if (!toNextAttr()) {
                    break;
                }
            }
        }
        pop();
    }

    public int selectionCount() {
        return this._selectionCount;
    }

    public void setAttrValue(QName qName, String str) {
        this._xobj.setAttr(qName, str);
    }

    public void setAttrValueAsQName(QName qName) {
        QName qName2 = Locale._xsiType;
        if (qName == null) {
            this._xobj.removeAttr(qName2);
            return;
        }
        if (toAttr(qName2)) {
            removeFollowingAttrs();
        } else {
            next();
            createAttr(qName2);
        }
        setValueAsQName(qName);
        toParent();
    }

    public final Bookmark setBookmark(Object obj, Object obj2) {
        return this._xobj.setBookmark(this._pos, obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setCharNodes(CharNode charNode) {
        Xobj denormal = getDenormal();
        if (this._posTemp >= denormal.posAfter()) {
            denormal._charNodesAfter = charNode;
        } else {
            denormal._charNodesValue = charNode;
        }
        while (charNode != null) {
            charNode.setDom((DomImpl.Dom) denormal);
            charNode = charNode._next;
        }
    }

    public void setId(String str) {
        this._id = str;
    }

    public void setName(QName qName) {
        this._xobj.setName(qName);
    }

    public void setSubstitution(QName qName, SchemaType schemaType) {
        TypeStoreUser typeStoreUserPeekUser = peekUser();
        if ((typeStoreUserPeekUser != null && typeStoreUserPeekUser.get_schema_type() == schemaType && qName.equals(getName())) || isRoot()) {
            return;
        }
        TypeStoreUser user = this._xobj.ensureParent().getUser();
        if (isAttr()) {
            return;
        }
        if (user.get_element_type(qName, null) == schemaType) {
            setName(qName);
            removeAttr(Locale._xsiType);
            return;
        }
        QName name = schemaType.getName();
        if (name != null && user.get_element_type(qName, name) == schemaType) {
            setName(qName);
            setAttrValueAsQName(name);
        }
    }

    public void setType(SchemaType schemaType) {
        setType(schemaType, true);
    }

    public void setValue(String str) {
        moveNodeContents(null, false);
        next();
        insertString(str);
        toParent();
    }

    public void setValueAsQName(QName qName) {
        String localPart = qName.getLocalPart();
        String strPrefixForNamespace = prefixForNamespace(qName.getNamespaceURI(), qName.getPrefix().length() > 0 ? qName.getPrefix() : null, true);
        if (strPrefixForNamespace.length() > 0) {
            localPart = androidx.collection.a.o(strPrefixForNamespace, ParameterizedMessage.ERROR_MSG_SEPARATOR, localPart);
        }
        setValue(localPart);
    }

    public final void setXsiType(QName qName) {
        setAttrValueAsQName(qName);
    }

    public boolean skip() {
        if (this._xobj.isRoot()) {
            return false;
        }
        if (!this._xobj.isAttr()) {
            Xobj xobj = this._xobj;
            moveTo(getNormal(xobj, xobj.posAfter()), this._posTemp);
            return true;
        }
        Xobj xobj2 = this._xobj._nextSibling;
        if (xobj2 == null || !xobj2.isAttr()) {
            return false;
        }
        moveTo(this._xobj._nextSibling, 0);
        return true;
    }

    public boolean skipWithAttrs() {
        if (skip()) {
            return true;
        }
        if (this._xobj.isRoot()) {
            return false;
        }
        toParent();
        next();
        return true;
    }

    public Cur tempCur() {
        Cur curTempCur = this._locale.tempCur(null);
        curTempCur.moveToCur(this);
        return curTempCur;
    }

    public boolean toAttr(QName qName) {
        Xobj attr = this._xobj.getAttr(qName);
        if (attr == null) {
            return false;
        }
        moveTo(attr);
        return true;
    }

    public void toEnd() {
        moveTo(this._xobj, -1);
    }

    public boolean toFirstAttr() {
        Xobj xobjFirstAttr = this._xobj.firstAttr();
        if (xobjFirstAttr == null) {
            return false;
        }
        moveTo(xobjFirstAttr);
        return true;
    }

    public boolean toFirstChild() {
        if (!this._xobj.hasChildren()) {
            return false;
        }
        Xobj xobj = this._xobj._firstChild;
        while (xobj.isAttr()) {
            xobj = xobj._nextSibling;
        }
        moveTo(xobj);
        return true;
    }

    public boolean toLastAttr() {
        if (!toFirstAttr()) {
            return false;
        }
        while (toNextAttr()) {
        }
        return true;
    }

    public boolean toLastChild() {
        if (!this._xobj.hasChildren()) {
            return false;
        }
        moveTo(this._xobj._lastChild);
        return true;
    }

    public boolean toNextAttr() {
        Xobj xobjNextAttr = this._xobj.nextAttr();
        if (xobjNextAttr == null) {
            return false;
        }
        moveTo(xobjNextAttr);
        return true;
    }

    public boolean toNextSibling() {
        if (!this._xobj.isAttr()) {
            Xobj xobj = this._xobj._nextSibling;
            if (xobj == null) {
                return false;
            }
            moveTo(xobj);
            return true;
        }
        Xobj xobj2 = this._xobj._nextSibling;
        if (xobj2 == null || !xobj2.isAttr()) {
            return false;
        }
        moveTo(this._xobj._nextSibling);
        return true;
    }

    public boolean toParent() {
        return toParent(false);
    }

    public boolean toParentRaw() {
        return toParent(true);
    }

    public boolean toPrevAttr() {
        if (!isAttr()) {
            prev();
            if (isContainer()) {
                return toLastAttr();
            }
            next();
            return false;
        }
        Xobj xobj = this._xobj;
        Xobj xobj2 = xobj._prevSibling;
        if (xobj2 == null) {
            moveTo(xobj.ensureParent());
            return true;
        }
        moveTo(xobj2);
        return true;
    }

    public void toRoot() {
        Xobj xobj = this._xobj;
        while (!xobj.isRoot()) {
            xobj = xobj._parent;
            if (xobj == null) {
                Cur curTempCur = this._locale.tempCur();
                curTempCur.createRoot();
                Xobj xobj2 = curTempCur._xobj;
                curTempCur.next();
                moveNode(curTempCur);
                curTempCur.release();
                xobj = xobj2;
                break;
            }
        }
        moveTo(xobj);
    }

    public Cur weakCur(Object obj) {
        Cur curWeakCur = this._locale.weakCur(obj);
        curWeakCur.moveToCur(this);
        return curWeakCur;
    }

    public static Xobj createDomDocumentRootXobj(Locale locale, boolean z6) {
        Xobj soapPartDocXobj;
        if (locale._saaj == null) {
            soapPartDocXobj = z6 ? new DocumentFragXobj(locale) : new DocumentXobj(locale);
        } else {
            soapPartDocXobj = new SoapPartDocXobj(locale);
        }
        if (locale._ownerDoc == null) {
            locale._ownerDoc = soapPartDocXobj.getDom();
        }
        return soapPartDocXobj;
    }

    private Xobj getDenormal(Xobj xobj, int i5) {
        Xobj denormal = xobj.getDenormal(i5);
        this._posTemp = xobj._locale._posTemp;
        return denormal;
    }

    /* JADX WARN: Code duplicated, block: B:123:0x00c7 A[EDGE_INSN: B:123:0x00c7->B:59:0x00c7 BREAK  A[LOOP:1: B:56:0x00bf->B:58:0x00c3], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x0097  */
    /* JADX WARN: Code duplicated, block: B:58:0x00c3 A[LOOP:1: B:56:0x00bf->B:58:0x00c3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:61:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:67:0x00d9  */
    public static void moveNodeContents(Xobj xobj, Cur cur, boolean z6) {
        int i5;
        Cur cur2;
        boolean zIsAtLastPush;
        boolean zHasAttrs = xobj.hasAttrs();
        Cur cur3 = null;
        if (!xobj.hasChildren() && (!z6 || !zHasAttrs)) {
            if (xobj.isVacant() && cur == null) {
                xobj.clearBit(256);
                xobj.invalidateUser();
                xobj.invalidateSpecialAttr(null);
                xobj._locale._versionAll++;
                return;
            }
            if (xobj.hasTextEnsureOccupancy()) {
                Cur curTempCur = xobj.tempCur();
                curTempCur.next();
                curTempCur.moveChars(cur, -1);
                curTempCur.release();
                return;
            }
            return;
        }
        boolean z7 = false;
        int iPosAfter = 1;
        if (cur != null) {
            if (xobj == cur._xobj && cur._pos == -1) {
                cur.moveTo(xobj);
                if (z6 && zHasAttrs) {
                    z7 = true;
                }
                cur.next(z7);
                return;
            }
            if (cur._locale == xobj._locale) {
                cur.push();
                cur.moveTo(xobj);
                cur.next(z6 && zHasAttrs);
                zIsAtLastPush = cur.isAtLastPush();
                cur.pop();
            } else {
                zIsAtLastPush = false;
            }
            if (zIsAtLastPush) {
                return;
            }
        }
        if (xobj.hasTextNoEnsureOccupancy()) {
            Cur curTempCur2 = xobj.tempCur();
            curTempCur2.next();
            curTempCur2.moveChars(cur, -1);
            curTempCur2.release();
            if (cur != null) {
                i5 = curTempCur2._cchSrc;
                cur.nextChars(i5);
            } else {
                i5 = 0;
            }
        } else {
            i5 = 0;
        }
        xobj._locale.embedCurs();
        Xobj xobjWalk = xobj.walk(xobj, true);
        boolean z8 = false;
        Xobj xobj2 = xobjWalk;
        while (xobjWalk != null) {
            if (xobjWalk._parent != xobj || !xobjWalk.isAttr()) {
                while (true) {
                    cur2 = xobjWalk._embedded;
                    if (cur2 != null) {
                        break;
                    } else {
                        cur2.moveTo(xobj, -1);
                    }
                }
                xobjWalk.disconnectUser();
                if (cur != null) {
                    xobjWalk._locale = cur._locale;
                }
                if (z8 && xobjWalk._bookmarks == null) {
                    z8 = false;
                } else {
                    z8 = true;
                }
            } else if (z6) {
                xobjWalk.invalidateSpecialAttr(cur == null ? null : cur.getParent());
                while (true) {
                    cur2 = xobjWalk._embedded;
                    if (cur2 != null) {
                        break;
                        break;
                    }
                    cur2.moveTo(xobj, -1);
                }
                xobjWalk.disconnectUser();
                if (cur != null) {
                    xobjWalk._locale = cur._locale;
                }
                if (z8) {
                    z8 = true;
                } else {
                    z8 = true;
                }
            } else {
                xobj2 = xobjWalk._nextSibling;
            }
            xobjWalk = xobjWalk.walk(xobj, true);
        }
        Xobj xobj3 = xobj._lastChild;
        if (z8 && cur == null) {
            cur = xobj._locale.tempCur();
            cur.createRoot();
            cur.next();
            cur3 = cur;
        }
        if (!xobj3.isAttr()) {
            xobj.invalidateUser();
        }
        Locale locale = xobj._locale;
        locale._versionAll++;
        locale._versionSansText++;
        if (cur != null && i5 == 0) {
            cur.getParent().invalidateUser();
            Locale locale2 = cur._locale;
            locale2._versionAll++;
            locale2._versionSansText++;
        }
        xobj.removeXobjs(xobj2, xobj3);
        if (cur != null) {
            Xobj xobj4 = cur._xobj;
            boolean z9 = cur._pos != 0;
            int iCchRight = cur.cchRight();
            if (iCchRight > 0) {
                cur.push();
                cur.next();
                xobj4 = cur._xobj;
                z7 = cur._pos != 0;
                cur.pop();
                z9 = z7;
            }
            if (xobj2.isAttr()) {
                Xobj xobj5 = xobj2;
                while (true) {
                    Xobj xobj6 = xobj5._nextSibling;
                    if (xobj6 == null || !xobj6.isAttr()) {
                        break;
                    } else {
                        xobj5 = xobj5._nextSibling;
                    }
                }
                Xobj parent = cur.getParent();
                if (iCchRight > 0) {
                    transferChars(cur._xobj, cur._pos, xobj5, xobj5.posMax(), iCchRight);
                }
                if (parent.hasTextNoEnsureOccupancy()) {
                    int i6 = parent._cchValue;
                    if (i6 <= 0) {
                        parent = parent.lastAttr();
                        iPosAfter = parent.posAfter();
                        i6 = parent._cchAfter;
                    }
                    transferChars(parent, iPosAfter, xobj5, xobj5.posAfter(), i6);
                }
            } else if (iCchRight > 0) {
                transferChars(cur._xobj, cur._pos, xobj3, xobj3.posMax(), iCchRight);
            }
            if (z9) {
                xobj4.appendXobjs(xobj2, xobj3);
            } else {
                xobj4.insertXobjs(xobj2, xobj3);
            }
            cur.moveTo(xobj2);
            cur.prevChars(i5);
        }
        if (cur3 != null) {
            cur3.release();
        }
    }

    public void createElement(QName qName, QName qName2) {
        createHelper(createElementXobj(this._locale, qName, qName2));
    }

    public void dump(PrintStream printStream) {
        Xobj xobj = this._xobj;
        if (xobj == null) {
            printStream.println("Unpositioned xptr");
        } else {
            dump(printStream, xobj, this);
        }
    }

    public String getCharsAsString(int i5) {
        return this._xobj.getCharsAsString(this._pos, -1, i5);
    }

    public Xobj getParent(boolean z6) {
        int i5 = this._pos;
        if (i5 == -1 || (i5 >= 1 && i5 < this._xobj.posAfter())) {
            return this._xobj;
        }
        Xobj xobj = this._xobj;
        Xobj xobj2 = xobj._parent;
        if (xobj2 != null) {
            return xobj2;
        }
        if (z6 || xobj.isRoot()) {
            return null;
        }
        Cur curTempCur = this._locale.tempCur();
        curTempCur.createRoot();
        Xobj xobj3 = curTempCur._xobj;
        curTempCur.next();
        moveNode(curTempCur);
        curTempCur.release();
        return xobj3;
    }

    public String getValueAsString() {
        return this._xobj.getValueAsString();
    }

    public boolean inChars(Bookmark bookmark, int i5, boolean z6) {
        return this._xobj.inChars(this._pos, bookmark._xobj, bookmark._pos, i5, z6);
    }

    public boolean isJustAfterEnd(Xobj xobj) {
        return xobj.isJustAfterEnd(this._xobj, this._pos);
    }

    public void moveTo(Xobj xobj, int i5) {
        moveToNoCheck(xobj, i5);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0034 A[PHI: r1
  0x0034: PHI (r1v8 org.apache.xmlbeans.impl.store.Xobj) = (r1v6 org.apache.xmlbeans.impl.store.Xobj), (r1v9 org.apache.xmlbeans.impl.store.Xobj) binds: [B:38:0x0066, B:18:0x0032] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:41:0x006c  */
    public boolean next() {
        Xobj xobj;
        Xobj xobj2;
        Xobj xobj3;
        Xobj xobj4 = this._xobj;
        int i5 = this._pos;
        int iPosAfter = xobj4.posAfter();
        if (i5 >= iPosAfter) {
            iPosAfter = this._xobj.posMax();
        } else if (i5 == -1) {
            if (xobj4.isRoot() || (xobj4.isAttr() && ((xobj3 = xobj4._nextSibling) == null || !xobj3.isAttr()))) {
                return false;
            }
        } else if (i5 > 0) {
            xobj2 = xobj4._firstChild;
            if (xobj2 != null) {
                xobj4 = xobj2;
                iPosAfter = 0;
            } else {
                iPosAfter = -1;
            }
        } else {
            xobj4.ensureOccupancy();
            if (xobj4._cchValue != 0 || (xobj = xobj4._firstChild) == null) {
                iPosAfter = 1;
            } else if (xobj.isAttr()) {
                Xobj xobj5 = xobj4._firstChild;
                while (true) {
                    Xobj xobj6 = xobj5._nextSibling;
                    if (xobj6 == null || !xobj6.isAttr()) {
                        break;
                    }
                    xobj5 = xobj5._nextSibling;
                }
                if (xobj5._cchAfter > 0) {
                    iPosAfter = xobj5.posAfter();
                    xobj4 = xobj5;
                } else {
                    xobj2 = xobj5._nextSibling;
                    if (xobj2 != null) {
                        xobj4 = xobj2;
                        iPosAfter = 0;
                    } else {
                        iPosAfter = 1;
                    }
                }
            } else {
                xobj4 = xobj4._firstChild;
                iPosAfter = 0;
            }
        }
        moveTo(getNormal(xobj4, iPosAfter), this._posTemp);
        return true;
    }

    public void setType(SchemaType schemaType, boolean z6) {
        TypeStoreUser typeStoreUserPeekUser = peekUser();
        if (typeStoreUserPeekUser == null || typeStoreUserPeekUser.get_schema_type() != schemaType) {
            if (isRoot()) {
                this._xobj.setStableType(schemaType);
                return;
            }
            TypeStoreUser user = this._xobj.ensureParent().getUser();
            if (isAttr()) {
                if (!z6 || user.get_attribute_type(getName()) == schemaType) {
                    return;
                }
                throw new IllegalArgumentException("Can't set type of attribute to " + schemaType.toString());
            }
            if (user.get_element_type(getName(), null) == schemaType) {
                removeAttr(Locale._xsiType);
                return;
            }
            QName name = schemaType.getName();
            if (name == null) {
                if (z6) {
                    throw new IllegalArgumentException("Can't set type of element, type is un-named");
                }
            } else if (user.get_element_type(getName(), name) == schemaType) {
                setAttrValueAsQName(name);
            } else if (z6) {
                throw new IllegalArgumentException("Can't set type of element, invalid type");
            }
        }
    }

    public boolean toParent(boolean z6) {
        Xobj parent = getParent(z6);
        if (parent == null) {
            return false;
        }
        moveTo(parent);
        return true;
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class CurLoadContext extends Locale.LoadContext {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final Map<String, String> _additionalNamespaces;
        private boolean _after;
        private final CharUtil _charUtil;
        private final boolean _discardDocElem;
        private String _doctypeName;
        private String _doctypePublicId;
        private String _doctypeSystemId;
        private Xobj _frontier;
        private int _lastPos;
        private Xobj _lastXobj;
        private final Locale _locale;
        private final QName _replaceDocElem;
        private final boolean _stripComments;
        private boolean _stripLeft = true;
        private final boolean _stripProcinsts;
        private final boolean _stripWhitespace;
        private final Map<String, String> _substituteNamespaces;

        public CurLoadContext(Locale locale, XmlOptions xmlOptions) {
            XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
            this._locale = locale;
            this._charUtil = xmlOptionsMaskNull.isLoadUseLocaleCharUtil() ? locale.getCharUtil() : CharUtil.getThreadLocalCharUtil();
            Xobj xobjCreateDomDocumentRootXobj = Cur.createDomDocumentRootXobj(locale);
            this._frontier = xobjCreateDomDocumentRootXobj;
            this._after = false;
            this._lastXobj = xobjCreateDomDocumentRootXobj;
            this._lastPos = 0;
            this._replaceDocElem = xmlOptionsMaskNull.getLoadReplaceDocumentElement();
            this._discardDocElem = xmlOptionsMaskNull.hasOption(XmlOptions.XmlOptionsKeys.LOAD_REPLACE_DOCUMENT_ELEMENT);
            this._stripWhitespace = xmlOptionsMaskNull.isSetLoadStripWhitespace();
            this._stripComments = xmlOptionsMaskNull.isLoadStripComments();
            this._stripProcinsts = xmlOptionsMaskNull.isLoadStripProcinsts();
            this._substituteNamespaces = xmlOptionsMaskNull.getLoadSubstituteNamespaces();
            this._additionalNamespaces = xmlOptionsMaskNull.getLoadAdditionalNamespaces();
            locale._versionAll++;
            locale._versionSansText++;
        }

        private QName checkName(QName qName, boolean z6) {
            String str;
            if (this._substituteNamespaces != null) {
                return ((!z6 || qName.getNamespaceURI().length() > 0) && (str = this._substituteNamespaces.get(qName.getNamespaceURI())) != null) ? this._locale.makeQName(str, qName.getLocalPart(), qName.getPrefix()) : qName;
            }
            return qName;
        }

        private void end() {
            flushText();
            if (this._after) {
                this._frontier = this._frontier._parent;
            } else {
                this._after = true;
            }
            this._lastXobj = this._frontier;
            this._lastPos = -1;
        }

        private void flushText() {
            if (this._stripWhitespace) {
                if (this._after) {
                    Xobj xobj = this._frontier;
                    xobj._srcAfter = this._charUtil.stripRight(xobj._srcAfter, xobj._offAfter, xobj._cchAfter);
                    Xobj xobj2 = this._frontier;
                    CharUtil charUtil = this._charUtil;
                    xobj2._offAfter = charUtil._offSrc;
                    xobj2._cchAfter = charUtil._cchSrc;
                    return;
                }
                Xobj xobj3 = this._frontier;
                xobj3._srcValue = this._charUtil.stripRight(xobj3._srcValue, xobj3._offValue, xobj3._cchValue);
                Xobj xobj4 = this._frontier;
                CharUtil charUtil2 = this._charUtil;
                xobj4._offValue = charUtil2._offSrc;
                xobj4._cchValue = charUtil2._cchSrc;
            }
        }

        private Xobj parent() {
            return this._after ? this._frontier._parent : this._frontier;
        }

        private void start(Xobj xobj) {
            flushText();
            if (this._after) {
                this._frontier = this._frontier._parent;
                this._after = false;
            }
            this._frontier.appendXobj(xobj);
            this._frontier = xobj;
            this._lastXobj = xobj;
            this._lastPos = 0;
        }

        private void stripText(Object obj, int i5, int i6) {
            if (this._stripWhitespace && this._stripLeft) {
                obj = this._charUtil.stripLeft(obj, i5, i6);
                this._stripLeft = false;
                CharUtil charUtil = this._charUtil;
                int i7 = charUtil._offSrc;
                i6 = charUtil._cchSrc;
                i5 = i7;
            }
            text(obj, i5, i6);
        }

        private void text(Object obj, int i5, int i6) {
            if (i6 <= 0) {
                return;
            }
            Xobj xobj = this._frontier;
            this._lastXobj = xobj;
            int i7 = xobj._cchValue;
            int i8 = i7 + 1;
            this._lastPos = i8;
            if (!this._after) {
                xobj._srcValue = this._charUtil.saveChars(obj, i5, i6, xobj._srcValue, xobj._offValue, i7);
                Xobj xobj2 = this._frontier;
                CharUtil charUtil = this._charUtil;
                xobj2._offValue = charUtil._offSrc;
                xobj2._cchValue = charUtil._cchSrc;
                return;
            }
            int i9 = xobj._cchAfter;
            this._lastPos = i9 + 1 + i8;
            xobj._srcAfter = this._charUtil.saveChars(obj, i5, i6, xobj._srcAfter, xobj._offAfter, i9);
            Xobj xobj3 = this._frontier;
            CharUtil charUtil2 = this._charUtil;
            xobj3._offAfter = charUtil2._offSrc;
            xobj3._cchAfter = charUtil2._cchSrc;
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void abort() {
            this._stripLeft = true;
            while (!parent().isRoot()) {
                end();
            }
            finish().release();
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void attr(QName qName, String str) {
            boolean zIsAttrOfTypeId = isAttrOfTypeId(qName, (this._after ? this._lastXobj._parent : this._lastXobj).getQName());
            Xobj attrIdXobj = zIsAttrOfTypeId ? new AttrIdXobj(this._locale, checkName(qName, true)) : new AttrXobj(this._locale, checkName(qName, true));
            start(attrIdXobj);
            text(str, 0, str.length());
            end();
            if (zIsAttrOfTypeId) {
                Cur curTempCur = attrIdXobj.tempCur();
                curTempCur.toRoot();
                Xobj xobj = curTempCur._xobj;
                curTempCur.release();
                if (xobj instanceof DocumentXobj) {
                    ((DocumentXobj) xobj).addIdElement(str, attrIdXobj._parent.getDom());
                }
            }
            this._lastXobj = attrIdXobj;
            this._lastPos = 0;
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void bookmark(XmlCursor.XmlBookmark xmlBookmark) {
            this._lastXobj.setBookmark(this._lastPos, xmlBookmark.getKey(), xmlBookmark);
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void bookmarkLastAttr(QName qName, XmlCursor.XmlBookmark xmlBookmark) {
            Xobj attr;
            if (this._lastPos == 0 && this._lastXobj.isAttr() && (attr = this._lastXobj._parent.getAttr(qName)) != null) {
                attr.setBookmark(0, xmlBookmark.getKey(), xmlBookmark);
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void bookmarkLastNonAttr(XmlCursor.XmlBookmark xmlBookmark) {
            if (this._lastPos > 0 || !this._lastXobj.isAttr()) {
                this._lastXobj.setBookmark(this._lastPos, xmlBookmark.getKey(), xmlBookmark);
            } else {
                this._lastXobj._parent.setBookmark(0, xmlBookmark.getKey(), xmlBookmark);
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void comment(String str) {
            if (!this._stripComments) {
                comment(str, 0, str.length());
            }
            this._stripLeft = true;
        }

        public void dump() {
            this._frontier.dump();
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void endElement() {
            end();
            this._stripLeft = true;
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public Cur finish() {
            flushText();
            if (this._after) {
                this._frontier = this._frontier._parent;
            }
            Cur curTempCur = this._frontier.tempCur();
            if (!Locale.toFirstChildElement(curTempCur)) {
                return curTempCur;
            }
            boolean zIsFragmentQName = Locale.isFragmentQName(curTempCur.getName());
            if (this._discardDocElem || zIsFragmentQName) {
                QName qName = this._replaceDocElem;
                if (qName != null) {
                    curTempCur.setName(qName);
                } else {
                    while (curTempCur.toParent()) {
                    }
                    curTempCur.next();
                    while (!curTempCur.isElem()) {
                        if (curTempCur.isText()) {
                            curTempCur.moveChars(null, -1);
                        } else {
                            curTempCur.moveNode(null);
                        }
                    }
                    curTempCur.skip();
                    while (!curTempCur.isFinish()) {
                        if (curTempCur.isText()) {
                            curTempCur.moveChars(null, -1);
                        } else {
                            curTempCur.moveNode(null);
                        }
                    }
                    curTempCur.toParent();
                    curTempCur.next();
                    Cur curTempCur2 = curTempCur.tempCur();
                    curTempCur.moveNodeContents(curTempCur, true);
                    curTempCur.moveToCur(curTempCur2);
                    curTempCur2.release();
                    curTempCur.moveNode(null);
                }
                if (zIsFragmentQName) {
                    curTempCur.moveTo(this._frontier);
                    if (curTempCur.toFirstAttr()) {
                        while (true) {
                            if (curTempCur.isXmlns() && curTempCur.getXmlnsUri().equals("http://www.openuri.org/fragment")) {
                                curTempCur.moveNode(null);
                                if (!curTempCur.isAttr()) {
                                    break;
                                }
                            } else if (!curTempCur.toNextAttr()) {
                                break;
                            }
                        }
                    }
                    curTempCur.moveTo(this._frontier);
                    Xobj xobjCreateDomDocumentRootXobj = Cur.createDomDocumentRootXobj(this._locale, true);
                    this._frontier = xobjCreateDomDocumentRootXobj;
                    Cur curTempCur3 = xobjCreateDomDocumentRootXobj.tempCur();
                    curTempCur3.next();
                    curTempCur.moveNodeContents(curTempCur3, true);
                    curTempCur.moveTo(this._frontier);
                    curTempCur3.release();
                }
            }
            if (this._additionalNamespaces != null) {
                curTempCur.moveTo(this._frontier);
                Locale.toFirstChildElement(curTempCur);
                Locale.applyNamespaces(curTempCur, this._additionalNamespaces);
            }
            if (this._doctypeName != null && (this._doctypePublicId != null || this._doctypeSystemId != null)) {
                XmlDocumentProperties docProps = Locale.getDocProps(curTempCur, true);
                docProps.setDoctypeName(this._doctypeName);
                String str = this._doctypePublicId;
                if (str != null) {
                    docProps.setDoctypePublicId(str);
                }
                String str2 = this._doctypeSystemId;
                if (str2 != null) {
                    docProps.setDoctypeSystemId(str2);
                }
            }
            curTempCur.moveTo(this._frontier);
            return curTempCur;
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void lineNumber(int i5, int i6, int i7) {
            this._lastXobj.setBookmark(this._lastPos, XmlLineNumber.class, new XmlLineNumber(i5, i6, i7));
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void procInst(String str, String str2) {
            if (!this._stripProcinsts) {
                ProcInstXobj procInstXobj = new ProcInstXobj(this._locale, str);
                start(procInstXobj);
                text(str2, 0, str2.length());
                end();
                this._lastXobj = procInstXobj;
                this._lastPos = 0;
            }
            this._stripLeft = true;
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void startDTD(String str, String str2, String str3) {
            this._doctypeName = str;
            this._doctypePublicId = str2;
            this._doctypeSystemId = str3;
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void startElement(QName qName) {
            start(Cur.createElementXobj(this._locale, checkName(qName, false), parent()._name));
            this._stripLeft = true;
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void xmlns(String str, String str2) {
            String str3;
            Map<String, String> map = this._substituteNamespaces;
            if (map != null && (str3 = map.get(str2)) != null) {
                str2 = str3;
            }
            Locale locale = this._locale;
            AttrXobj attrXobj = new AttrXobj(locale, locale.createXmlns(str));
            start(attrXobj);
            text(str2, 0, str2.length());
            end();
            this._lastXobj = attrXobj;
            this._lastPos = 0;
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void comment(char[] cArr, int i5, int i6) {
            if (!this._stripComments) {
                Object objSaveChars = this._charUtil.saveChars(cArr, i5, i6);
                CharUtil charUtil = this._charUtil;
                comment(objSaveChars, charUtil._offSrc, charUtil._cchSrc);
            }
            this._stripLeft = true;
        }

        private void comment(Object obj, int i5, int i6) {
            CommentXobj commentXobj = new CommentXobj(this._locale);
            start(commentXobj);
            text(obj, i5, i6);
            end();
            this._lastXobj = commentXobj;
            this._lastPos = 0;
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void text(String str) {
            if (str == null) {
                return;
            }
            stripText(str, 0, str.length());
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void text(char[] cArr, int i5, int i6) {
            stripText(cArr, i5, i6);
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void attr(String str, String str2, String str3, String str4) {
            attr(this._locale.makeQName(str2, str, str3), str4);
        }

        @Override // org.apache.xmlbeans.impl.store.Locale.LoadContext
        public void endDTD() {
        }
    }

    private Cur tempCur(Xobj xobj, int i5) {
        Cur curTempCur = this._locale.tempCur();
        if (xobj != null) {
            curTempCur.moveTo(getNormal(xobj, i5), this._posTemp);
        }
        return curTempCur;
    }

    public static void moveNode(Xobj xobj, Cur cur) {
        Locale locale;
        if (cur != null) {
            if (cur._pos == -1) {
                cur._xobj.ensureOccupancy();
            }
            if ((cur._pos == 0 && cur._xobj == xobj) || cur.isJustAfterEnd(xobj)) {
                cur.moveTo(xobj);
                return;
            }
        }
        xobj._locale.notifyChange();
        Locale locale2 = xobj._locale;
        locale2._versionAll++;
        locale2._versionSansText++;
        if (cur != null && (locale = cur._locale) != locale2) {
            locale.notifyChange();
            Locale locale3 = cur._locale;
            locale3._versionAll++;
            locale3._versionSansText++;
        }
        if (xobj.isAttr()) {
            xobj.invalidateSpecialAttr(cur == null ? null : cur.getParentRaw());
        } else {
            Xobj xobj2 = xobj._parent;
            if (xobj2 != null) {
                xobj2.invalidateUser();
            }
            if (cur != null && cur.hasParent()) {
                cur.getParent().invalidateUser();
            }
        }
        if (xobj._cchAfter > 0) {
            transferChars(xobj, xobj.posAfter(), xobj.getDenormal(0), xobj.posTemp(), xobj._cchAfter);
        }
        xobj._locale.embedCurs();
        Xobj xobjWalk = xobj;
        while (xobjWalk != null) {
            while (true) {
                Cur cur2 = xobjWalk._embedded;
                if (cur2 == null) {
                    break;
                } else {
                    cur2.moveTo(xobj.getNormal(xobj.posAfter()));
                }
            }
            xobjWalk.disconnectUser();
            if (cur != null) {
                xobjWalk._locale = cur._locale;
            }
            xobjWalk = xobjWalk.walk(xobj, true);
        }
        xobj.removeXobj();
        if (cur != null) {
            Xobj xobj3 = cur._xobj;
            boolean z6 = cur._pos != 0;
            int iCchRight = cur.cchRight();
            if (iCchRight > 0) {
                cur.push();
                cur.next();
                xobj3 = cur._xobj;
                boolean z7 = cur._pos != 0;
                cur.pop();
                z6 = z7;
            }
            if (z6) {
                xobj3.appendXobj(xobj);
            } else {
                xobj3.insertXobj(xobj);
            }
            if (iCchRight > 0) {
                transferChars(cur._xobj, cur._pos, xobj, xobj.posAfter(), iCchRight);
            }
            cur.moveTo(xobj);
        }
    }

    public void addToSelection() {
        this._selectionFirst = this._locale._locations.insert(this._selectionFirst, -1, this._locale._locations.allocate(this));
        this._selectionCount++;
    }

    public static void dump(PrintStream printStream, Xobj xobj, Object obj) {
        if (obj == null) {
            obj = xobj;
        }
        while (true) {
            Xobj xobj2 = xobj._parent;
            if (xobj2 == null) {
                dumpXobj(printStream, xobj, 0, obj);
                printStream.println();
                return;
            }
            xobj = xobj2;
        }
    }
}
