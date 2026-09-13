package org.apache.xmlbeans.impl.store;

import A3.AbstractC0157z;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.xml.namespace.QName;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.logging.log4j.util.Chars;
import org.apache.xmlbeans.SystemProperties;
import org.apache.xmlbeans.XmlDocumentProperties;
import org.apache.xmlbeans.XmlOptionCharEscapeMap;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.EncodingMap;
import org.apache.xmlbeans.impl.common.NameUtil;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.Sax2Dom;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.AttributesImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
abstract class Saver {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int ATTR = 3;
    static final int COMMENT = 4;
    static final int ELEM = 2;
    static final int PROCINST = 5;
    static final int ROOT = 1;
    static final int TEXT = 0;
    static final String _newLine = SystemProperties.getProperty("line.separator", "\n");
    private List<String> _ancestorNamespaces;
    private SaveCur _cur;
    private int _currentMapping;
    private String _initialDefaultUri;
    private final Locale _locale;
    private Map<String, String> _preComputedNamespaces;
    protected XmlOptionCharEscapeMap _replaceChar;
    private final boolean _saveNamespacesFirst;
    private final Map<String, String> _suggestedPrefixes;
    private final boolean _useDefaultNamespace;
    private final long _version;
    private final ArrayList<QName> _attrNames = new ArrayList<>();
    private final ArrayList<String> _attrValues = new ArrayList<>();
    private final ArrayList<String> _namespaceStack = new ArrayList<>();
    private final HashMap<String, String> _uriMap = new HashMap<>();
    private final HashMap<String, String> _prefixMap = new HashMap<>();

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class DocSaveCur extends SaveCur {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private Cur _cur;

        public DocSaveCur(Cur cur) {
            this._cur = cur.weakCur(this);
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public List<String> getAncestorNamespaces() {
            return null;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public String getAttrValue() {
            return this._cur.getValueAsString();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public Object getChars() {
            Object chars = this._cur.getChars(-1);
            Cur cur = this._cur;
            this._offSrc = cur._offSrc;
            this._cchSrc = cur._cchSrc;
            return chars;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public XmlDocumentProperties getDocProps() {
            return Locale.getDocProps(this._cur, false);
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public QName getName() {
            return this._cur.getName();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public String getXmlnsPrefix() {
            return this._cur.getXmlnsPrefix();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public String getXmlnsUri() {
            return this._cur.getXmlnsUri();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean hasChildren() {
            return this._cur.hasChildren();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean hasText() {
            return this._cur.hasText();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean isTextCData() {
            return this._cur.isTextCData();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean isXmlns() {
            return this._cur.isXmlns();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public int kind() {
            return this._cur.kind();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean next() {
            return this._cur.next();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public void pop() {
            this._cur.pop();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public void push() {
            this._cur.push();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public void release() {
            this._cur.release();
            this._cur = null;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public void toEnd() {
            this._cur.toEnd();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean toFirstAttr() {
            return this._cur.toFirstAttr();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean toNextAttr() {
            return this._cur.toNextAttr();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class FilterPiSaveCur extends FilterSaveCur {
        private final String _piTarget;

        public FilterPiSaveCur(SaveCur saveCur, String str) {
            super(saveCur);
            this._piTarget = str;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.FilterSaveCur
        public boolean filter() {
            return kind() == 5 && getName().getLocalPart().equals(this._piTarget);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static abstract class FilterSaveCur extends SaveCur {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private SaveCur _cur;

        public FilterSaveCur(SaveCur saveCur) {
            this._cur = saveCur;
        }

        public abstract boolean filter();

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public List<String> getAncestorNamespaces() {
            return this._cur.getAncestorNamespaces();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public String getAttrValue() {
            return this._cur.getAttrValue();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public Object getChars() {
            Object chars = this._cur.getChars();
            SaveCur saveCur = this._cur;
            this._offSrc = saveCur._offSrc;
            this._cchSrc = saveCur._cchSrc;
            return chars;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public XmlDocumentProperties getDocProps() {
            return this._cur.getDocProps();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public QName getName() {
            return this._cur.getName();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public String getXmlnsPrefix() {
            return this._cur.getXmlnsPrefix();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public String getXmlnsUri() {
            return this._cur.getXmlnsUri();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean hasChildren() {
            return this._cur.hasChildren();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean hasText() {
            return this._cur.hasText();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean isTextCData() {
            return this._cur.isTextCData();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean isXmlns() {
            return this._cur.isXmlns();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public int kind() {
            return this._cur.kind();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean next() {
            if (!this._cur.next()) {
                return false;
            }
            if (!filter()) {
                return true;
            }
            toEnd();
            return next();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public void pop() {
            this._cur.pop();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public void push() {
            this._cur.push();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public void release() {
            this._cur.release();
            this._cur = null;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public void toEnd() {
            this._cur.toEnd();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean toFirstAttr() {
            return this._cur.toFirstAttr();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean toNextAttr() {
            return this._cur.toNextAttr();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class FragSaveCur extends SaveCur {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final int CUR = 5;
        private static final int ELEM_END = 4;
        private static final int ELEM_START = 2;
        private static final int ROOT_END = 3;
        private static final int ROOT_START = 1;
        private ArrayList<String> _ancestorNamespaces;
        private Cur _cur;
        private final QName _elem;
        private Cur _end;
        private final boolean _saveAttr;
        private int _state;
        private int[] _stateStack;
        private int _stateStackSize;

        public FragSaveCur(Cur cur, Cur cur2, QName qName) {
            this._saveAttr = cur.isAttr() && cur.isSamePos(cur2);
            this._cur = cur.weakCur(this);
            this._end = cur2.weakCur(this);
            this._elem = qName;
            this._state = 1;
            this._stateStack = new int[8];
            cur.push();
            computeAncestorNamespaces(cur);
            cur.pop();
        }

        private void computeAncestorNamespaces(Cur cur) {
            this._ancestorNamespaces = new ArrayList<>();
            while (cur.toParentRaw()) {
                if (cur.toFirstAttr()) {
                    do {
                        if (cur.isXmlns()) {
                            String xmlnsPrefix = cur.getXmlnsPrefix();
                            if (cur.getXmlnsUri().length() > 0 || xmlnsPrefix.length() == 0) {
                                this._ancestorNamespaces.add(cur.getXmlnsPrefix());
                                this._ancestorNamespaces.add(cur.getXmlnsUri());
                            }
                        }
                    } while (cur.toNextAttr());
                    cur.toParent();
                }
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public List<String> getAncestorNamespaces() {
            return this._ancestorNamespaces;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public String getAttrValue() {
            return this._cur.getValueAsString();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public Object getChars() {
            Object chars = this._cur.getChars(-1);
            Cur cur = this._cur;
            this._offSrc = cur._offSrc;
            this._cchSrc = cur._cchSrc;
            return chars;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public XmlDocumentProperties getDocProps() {
            return Locale.getDocProps(this._cur, false);
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public QName getName() {
            int i5 = this._state;
            if (i5 == 1) {
                return null;
            }
            if (i5 != 2) {
                if (i5 == 3) {
                    return null;
                }
                if (i5 != 4) {
                    return this._cur.getName();
                }
            }
            return this._elem;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public String getXmlnsPrefix() {
            return this._cur.getXmlnsPrefix();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public String getXmlnsUri() {
            return this._cur.getXmlnsUri();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean hasChildren() {
            boolean z6 = false;
            if (isContainer()) {
                push();
                next();
                if (!isText() && !isFinish()) {
                    z6 = true;
                }
                pop();
            }
            return z6;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean hasText() {
            if (!isContainer()) {
                return false;
            }
            push();
            next();
            boolean zIsText = isText();
            pop();
            return zIsText;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean isTextCData() {
            return this._cur.isTextCData();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean isXmlns() {
            return this._cur.isXmlns();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public int kind() {
            int i5 = this._state;
            int i6 = 1;
            if (i5 != 1) {
                i6 = 2;
                if (i5 != 2) {
                    if (i5 == 3) {
                        return -1;
                    }
                    if (i5 != 4) {
                        return this._cur.kind();
                    }
                    return -2;
                }
            }
            return i6;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean next() {
            int i5 = this._state;
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 == 3) {
                        return false;
                    }
                    if (i5 == 4) {
                        this._state = 3;
                    } else if (i5 == 5) {
                        this._cur.next();
                        if (this._cur.isSamePos(this._end)) {
                            this._state = this._elem == null ? 3 : 4;
                        }
                    }
                } else if (this._saveAttr) {
                    this._state = 4;
                } else {
                    if (this._cur.isAttr()) {
                        this._cur.toParent();
                        this._cur.next();
                    }
                    if (this._cur.isSamePos(this._end)) {
                        this._state = 4;
                    } else {
                        this._state = 5;
                    }
                }
            } else {
                this._state = this._elem == null ? 5 : 2;
            }
            return true;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public void pop() {
            this._cur.pop();
            int[] iArr = this._stateStack;
            int i5 = this._stateStackSize - 1;
            this._stateStackSize = i5;
            this._state = iArr[i5];
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public void push() {
            int i5 = this._stateStackSize;
            int[] iArr = this._stateStack;
            if (i5 == iArr.length) {
                int[] iArr2 = new int[i5 * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i5);
                this._stateStack = iArr2;
            }
            int[] iArr3 = this._stateStack;
            int i6 = this._stateStackSize;
            this._stateStackSize = i6 + 1;
            iArr3[i6] = this._state;
            this._cur.push();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public void release() {
            this._cur.release();
            this._cur = null;
            this._end.release();
            this._end = null;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public void toEnd() {
            int i5 = this._state;
            if (i5 == 1) {
                this._state = 3;
                return;
            }
            if (i5 == 2) {
                this._state = 4;
            } else {
                if (i5 == 3 || i5 == 4) {
                    return;
                }
                this._cur.toEnd();
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean toFirstAttr() {
            int i5 = this._state;
            if (i5 == 1 || i5 == 3 || i5 == 4) {
                return false;
            }
            if (i5 == 5) {
                return this._cur.toFirstAttr();
            }
            if (!this._cur.isAttr()) {
                return false;
            }
            this._state = 5;
            return true;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean toNextAttr() {
            return !this._saveAttr && this._cur.toNextAttr();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class PrettySaveCur extends SaveCur {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final SaveCur _cur;
        private int _depth;
        private int _prettyIndent;
        private int _prettyOffset;
        private String _txt;
        private final boolean _useCDataBookmarks;
        private boolean _isTextCData = false;
        private final StringBuffer _sb = new StringBuffer();
        private final ArrayList<Object> _stack = new ArrayList<>();

        public PrettySaveCur(SaveCur saveCur, XmlOptions xmlOptions) {
            this._cur = saveCur;
            this._prettyIndent = 2;
            if (xmlOptions.getSavePrettyPrintIndent() != null) {
                this._prettyIndent = xmlOptions.getSavePrettyPrintIndent().intValue();
            }
            if (xmlOptions.getSavePrettyPrintOffset() != null) {
                this._prettyOffset = xmlOptions.getSavePrettyPrintOffset().intValue();
            }
            this._useCDataBookmarks = xmlOptions.isUseCDataBookmarks();
        }

        public static void spaces(StringBuffer stringBuffer, int i5, int i6) {
            while (true) {
                int i7 = i6 - 1;
                if (i6 <= 0) {
                    return;
                }
                stringBuffer.insert(i5, Chars.SPACE);
                i6 = i7;
            }
        }

        public static void trim(StringBuffer stringBuffer) {
            int i5 = 0;
            while (i5 < stringBuffer.length() && CharUtil.isWhiteSpace(stringBuffer.charAt(i5))) {
                i5++;
            }
            stringBuffer.delete(0, i5);
            int length = stringBuffer.length();
            while (length > 0 && CharUtil.isWhiteSpace(stringBuffer.charAt(length - 1))) {
                length--;
            }
            stringBuffer.delete(length, stringBuffer.length());
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public List<String> getAncestorNamespaces() {
            return this._cur.getAncestorNamespaces();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public String getAttrValue() {
            return this._cur.getAttrValue();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public Object getChars() {
            String str = this._txt;
            if (str != null) {
                this._offSrc = 0;
                this._cchSrc = str.length();
                return this._txt;
            }
            Object chars = this._cur.getChars();
            SaveCur saveCur = this._cur;
            this._offSrc = saveCur._offSrc;
            this._cchSrc = saveCur._cchSrc;
            return chars;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public XmlDocumentProperties getDocProps() {
            return this._cur.getDocProps();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public QName getName() {
            return this._cur.getName();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public String getXmlnsPrefix() {
            return this._cur.getXmlnsPrefix();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public String getXmlnsUri() {
            return this._cur.getXmlnsUri();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean hasChildren() {
            return this._txt == null && this._cur.hasChildren();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean hasText() {
            return this._txt == null && this._cur.hasText();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean isTextCData() {
            if (this._txt == null) {
                return this._useCDataBookmarks && this._cur.isTextCData();
            }
            return this._isTextCData;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean isXmlns() {
            return this._txt == null && this._cur.isXmlns();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public int kind() {
            if (this._txt == null) {
                return this._cur.kind();
            }
            return 0;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean next() {
            int iKind = 0;
            if (this._txt != null) {
                this._txt = null;
                this._isTextCData = false;
                iKind = this._cur.kind();
            } else {
                int iKind2 = this._cur.kind();
                if (!this._cur.next()) {
                    return false;
                }
                StringBuffer stringBuffer = this._sb;
                stringBuffer.delete(0, stringBuffer.length());
                if (this._cur.isText()) {
                    this._isTextCData = this._useCDataBookmarks && this._cur.isTextCData();
                    StringBuffer stringBuffer2 = this._sb;
                    Object chars = this._cur.getChars();
                    SaveCur saveCur = this._cur;
                    CharUtil.getString(stringBuffer2, chars, saveCur._offSrc, saveCur._cchSrc);
                    this._cur.next();
                    int iKind3 = this._cur.kind();
                    if (iKind2 != 2 || iKind3 != -2) {
                        trim(this._sb);
                    }
                }
                int iKind4 = this._cur.kind();
                if (this._prettyIndent >= 0 && iKind2 != 4 && iKind2 != 5 && (iKind2 != 2 || iKind4 != -2)) {
                    if (this._sb.length() > 0) {
                        StringBuffer stringBuffer3 = this._sb;
                        String str = Saver._newLine;
                        stringBuffer3.insert(0, str);
                        spaces(this._sb, str.length(), (this._prettyIndent * this._depth) + this._prettyOffset);
                    }
                    if (iKind4 != -1) {
                        if (iKind2 != 1) {
                            this._sb.append(Saver._newLine);
                        }
                        int i5 = this._depth;
                        if (iKind4 < 0) {
                            i5--;
                        }
                        StringBuffer stringBuffer4 = this._sb;
                        spaces(stringBuffer4, stringBuffer4.length(), (this._prettyIndent * i5) + this._prettyOffset);
                    }
                }
                if (this._sb.length() > 0) {
                    this._txt = this._sb.toString();
                } else {
                    iKind = iKind4;
                }
            }
            if (iKind == 2) {
                this._depth++;
            } else if (iKind == -2) {
                this._depth--;
            }
            return true;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public void pop() {
            this._cur.pop();
            ArrayList<Object> arrayList = this._stack;
            this._depth = ((Integer) arrayList.remove(arrayList.size() - 1)).intValue();
            ArrayList<Object> arrayList2 = this._stack;
            this._txt = (String) arrayList2.remove(arrayList2.size() - 1);
            this._isTextCData = false;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public void push() {
            this._cur.push();
            this._stack.add(this._txt);
            this._stack.add(Integer.valueOf(this._depth));
            this._isTextCData = false;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public void release() {
            this._cur.release();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public void toEnd() {
            this._cur.toEnd();
            if (this._cur.kind() == -2) {
                this._depth--;
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean toFirstAttr() {
            return this._cur.toFirstAttr();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        public boolean toNextAttr() {
            return this._cur.toNextAttr();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static abstract class SaveCur {
        int _cchSrc;
        int _offSrc;

        public abstract List<String> getAncestorNamespaces();

        public abstract String getAttrValue();

        public abstract Object getChars();

        public abstract XmlDocumentProperties getDocProps();

        public abstract QName getName();

        public abstract String getXmlnsPrefix();

        public abstract String getXmlnsUri();

        public abstract boolean hasChildren();

        public abstract boolean hasText();

        public final boolean isAttr() {
            return kind() == 3;
        }

        public final boolean isComment() {
            return kind() == 4;
        }

        public final boolean isContainer() {
            return Cur.kindIsContainer(kind());
        }

        public final boolean isElem() {
            return kind() == 2;
        }

        public final boolean isFinish() {
            return Cur.kindIsFinish(kind());
        }

        public final boolean isNormalAttr() {
            return kind() == 3 && !isXmlns();
        }

        public final boolean isProcinst() {
            return kind() == 5;
        }

        public final boolean isRoot() {
            return kind() == 1;
        }

        public final boolean isText() {
            return kind() == 0;
        }

        public abstract boolean isTextCData();

        public abstract boolean isXmlns();

        public abstract int kind();

        public abstract boolean next();

        public abstract void pop();

        public abstract void push();

        public abstract void release();

        public final boolean skip() {
            toEnd();
            return next();
        }

        public abstract void toEnd();

        public abstract boolean toFirstAttr();

        public abstract boolean toNextAttr();
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface SyncWrapFun {
        int process();
    }

    public Saver(Cur cur, XmlOptions xmlOptions) {
        XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
        this._cur = createSaveCur(cur, xmlOptionsMaskNull);
        Locale locale = cur._locale;
        this._locale = locale;
        this._version = locale.version();
        addMapping("xml", "http://www.w3.org/XML/1998/namespace");
        Map<String, String> saveImplicitNamespaces = xmlOptionsMaskNull.getSaveImplicitNamespaces();
        if (saveImplicitNamespaces != null) {
            for (String str : saveImplicitNamespaces.keySet()) {
                addMapping(str, saveImplicitNamespaces.get(str));
            }
        }
        this._replaceChar = xmlOptionsMaskNull.getSaveSubstituteCharacters();
        if (getNamespaceForPrefix("") == null) {
            this._initialDefaultUri = "";
            addMapping("", "");
        }
        if (xmlOptionsMaskNull.isSaveAggressiveNamespaces() && !(this instanceof SynthNamespaceSaver)) {
            SynthNamespaceSaver synthNamespaceSaver = new SynthNamespaceSaver(cur, xmlOptionsMaskNull);
            while (synthNamespaceSaver.process()) {
            }
            if (!synthNamespaceSaver._synthNamespaces.isEmpty()) {
                this._preComputedNamespaces = synthNamespaceSaver._synthNamespaces;
            }
        }
        this._useDefaultNamespace = xmlOptionsMaskNull.isUseDefaultNamespace();
        this._saveNamespacesFirst = xmlOptionsMaskNull.isSaveNamespacesFirst();
        this._suggestedPrefixes = xmlOptionsMaskNull.getSaveSuggestedPrefixes();
        this._ancestorNamespaces = this._cur.getAncestorNamespaces();
    }

    private void addMapping(String str, String str2) {
        String str3;
        String str4 = this._prefixMap.get(str);
        if (str4 == null) {
            str3 = null;
        } else if (!str4.equals(str2)) {
            int size = this._namespaceStack.size();
            str3 = null;
            while (size > 0) {
                if (this._namespaceStack.get(size - 1) != null) {
                    if (this._namespaceStack.get(size - 7).equals(str4) && ((str3 = this._namespaceStack.get(size - 8)) == null || !str3.equals(str))) {
                        break;
                    } else {
                        size -= 8;
                    }
                } else {
                    size--;
                }
            }
        } else {
            str4 = null;
            str3 = null;
        }
        this._namespaceStack.add(this._uriMap.get(str2));
        this._namespaceStack.add(str2);
        if (str4 != null) {
            this._namespaceStack.add(this._uriMap.get(str4));
            this._namespaceStack.add(str4);
        } else {
            this._namespaceStack.add(null);
            this._namespaceStack.add(null);
        }
        this._namespaceStack.add(str);
        this._namespaceStack.add(this._prefixMap.get(str));
        this._namespaceStack.add(str);
        this._namespaceStack.add(str2);
        this._uriMap.put(str2, str);
        this._prefixMap.put(str, str2);
        if (str4 != null) {
            this._uriMap.put(str4, str3);
        }
    }

    private void addNewFrameMapping(String str, String str2, boolean z6) {
        if (str.length() == 0 || str2.length() > 0) {
            if (!z6 || str.length() > 0 || str2.length() == 0) {
                iterateMappings();
                while (hasMapping()) {
                    if (mappingPrefix().equals(str)) {
                        return;
                    } else {
                        nextMapping();
                    }
                }
                if (str2.equals(getNamespaceForPrefix(str))) {
                    return;
                }
                addMapping(str, str2);
            }
        }
    }

    private static SaveCur createSaveCur(Cur cur, XmlOptions xmlOptions) {
        QName qName;
        SaveCur fragSaveCur;
        QName saveSyntheticDocumentElement = xmlOptions.getSaveSyntheticDocumentElement();
        if (saveSyntheticDocumentElement == null) {
            qName = xmlOptions.isSaveUseOpenFrag() ? Locale._openuriFragment : Locale._xmlFragment;
        } else {
            qName = saveSyntheticDocumentElement;
        }
        boolean z6 = xmlOptions.isSaveInner() && !xmlOptions.isSaveOuter();
        Cur curTempCur = cur.tempCur();
        Cur curTempCur2 = cur.tempCur();
        int iKind = cur.kind();
        if (iKind != 1) {
            fragSaveCur = null;
            if (iKind == 2) {
                if (z6) {
                    positionToInner(cur, curTempCur, curTempCur2);
                    if (Locale.isFragment(curTempCur, curTempCur2)) {
                        saveSyntheticDocumentElement = qName;
                    }
                    fragSaveCur = new FragSaveCur(curTempCur, curTempCur2, saveSyntheticDocumentElement);
                } else if (saveSyntheticDocumentElement != null) {
                    positionToInner(cur, curTempCur, curTempCur2);
                    fragSaveCur = new FragSaveCur(curTempCur, curTempCur2, saveSyntheticDocumentElement);
                } else {
                    curTempCur.moveToCur(cur);
                    curTempCur2.moveToCur(cur);
                    curTempCur2.skip();
                    fragSaveCur = new FragSaveCur(curTempCur, curTempCur2, null);
                }
            }
        } else {
            positionToInner(cur, curTempCur, curTempCur2);
            if (Locale.isFragment(curTempCur, curTempCur2)) {
                fragSaveCur = new FragSaveCur(curTempCur, curTempCur2, qName);
            } else {
                fragSaveCur = saveSyntheticDocumentElement != null ? new FragSaveCur(curTempCur, curTempCur2, saveSyntheticDocumentElement) : new DocSaveCur(cur);
            }
        }
        if (fragSaveCur == null) {
            if (iKind < 0) {
                curTempCur.moveToCur(cur);
                curTempCur2.moveToCur(cur);
            } else if (iKind == 0) {
                curTempCur.moveToCur(cur);
                curTempCur2.moveToCur(cur);
                curTempCur2.next();
            } else if (z6) {
                curTempCur.moveToCur(cur);
                curTempCur.next();
                curTempCur2.moveToCur(cur);
                curTempCur2.toEnd();
            } else if (iKind == 3) {
                curTempCur.moveToCur(cur);
                curTempCur2.moveToCur(cur);
            } else {
                curTempCur.moveToCur(cur);
                curTempCur2.moveToCur(cur);
                curTempCur2.skip();
            }
            fragSaveCur = new FragSaveCur(curTempCur, curTempCur2, qName);
        }
        String saveFilterProcinst = xmlOptions.getSaveFilterProcinst();
        if (saveFilterProcinst != null) {
            fragSaveCur = new FilterPiSaveCur(fragSaveCur, saveFilterProcinst);
        }
        if (xmlOptions.isSavePrettyPrint()) {
            fragSaveCur = new PrettySaveCur(fragSaveCur, xmlOptions);
        }
        curTempCur.release();
        curTempCur2.release();
        return fragSaveCur;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0059  */
    /* JADX WARN: Code duplicated, block: B:34:0x0067 A[LOOP:0: B:31:0x0060->B:34:0x0067, LOOP_END] */
    /* JADX WARN: Instruction removed from duplicated block: B:34:0x0067, please report this as an issue */
    private void ensureMapping(String str, String str2, boolean z6, boolean z7) {
        String strSuggestPrefix;
        int i5;
        if (str.length() == 0) {
            return;
        }
        String str3 = this._uriMap.get(str);
        if (str3 == null || (str3.length() <= 0 && z7)) {
            if (str2 != null && str2.length() == 0) {
                str2 = null;
            }
            if (!tryPrefix(str2)) {
                Map<String, String> map = this._suggestedPrefixes;
                if (map != null && map.containsKey(str) && tryPrefix(this._suggestedPrefixes.get(str))) {
                    str2 = this._suggestedPrefixes.get(str);
                } else if (z6 && this._useDefaultNamespace) {
                    str2 = "";
                    if (!tryPrefix("")) {
                        strSuggestPrefix = QNameHelper.suggestPrefix(str);
                        str2 = strSuggestPrefix;
                        i5 = 1;
                        while (!tryPrefix(str2)) {
                            str2 = strSuggestPrefix + i5;
                            i5++;
                        }
                    }
                } else {
                    strSuggestPrefix = QNameHelper.suggestPrefix(str);
                    str2 = strSuggestPrefix;
                    i5 = 1;
                    while (!tryPrefix(str2)) {
                        str2 = strSuggestPrefix + i5;
                        i5++;
                    }
                }
            }
            syntheticNamespace(str2, str, z6);
            addMapping(str2, str);
        }
    }

    public static boolean isBadChar(char c) {
        if (Character.isHighSurrogate(c) || Character.isLowSurrogate(c)) {
            return false;
        }
        if (c < ' ' || c > 55295) {
            return ((c >= 57344 && c <= 65533) || c == '\t' || c == '\n' || c == '\r') ? false : true;
        }
        return false;
    }

    private void popMappings() {
        while (true) {
            int size = this._namespaceStack.size();
            if (size == 0) {
                return;
            }
            int i5 = size - 1;
            if (this._namespaceStack.get(i5) == null) {
                this._namespaceStack.remove(i5);
                return;
            }
            int i6 = size - 7;
            String str = this._namespaceStack.get(i6);
            int i7 = size - 8;
            String str2 = this._namespaceStack.get(i7);
            if (str2 == null) {
                this._uriMap.remove(str);
            } else {
                this._uriMap.put(str, str2);
            }
            int i8 = size - 4;
            String str3 = this._namespaceStack.get(i8);
            int i9 = size - 3;
            String str4 = this._namespaceStack.get(i9);
            if (str4 == null) {
                this._prefixMap.remove(str3);
            } else {
                this._prefixMap.put(str3, str4);
            }
            int i10 = size - 5;
            String str5 = this._namespaceStack.get(i10);
            if (str5 != null) {
                this._uriMap.put(str5, this._namespaceStack.get(size - 6));
            }
            this._namespaceStack.remove(i5);
            this._namespaceStack.remove(size - 2);
            this._namespaceStack.remove(i9);
            this._namespaceStack.remove(i8);
            this._namespaceStack.remove(i10);
            this._namespaceStack.remove(size - 6);
            this._namespaceStack.remove(i6);
            this._namespaceStack.remove(i7);
        }
    }

    private static void positionToInner(Cur cur, Cur cur2, Cur cur3) {
        cur2.moveToCur(cur);
        if (!cur2.toFirstAttr()) {
            cur2.next();
        }
        cur3.moveToCur(cur);
        cur3.toEnd();
    }

    private void processElement() {
        QName name = this._cur.getName();
        boolean z6 = name.getNamespaceURI().length() == 0;
        pushMappings(this._cur, z6);
        ensureMapping(name.getNamespaceURI(), name.getPrefix(), !z6, false);
        this._attrNames.clear();
        this._attrValues.clear();
        this._cur.push();
        boolean firstAttr = this._cur.toFirstAttr();
        while (firstAttr) {
            if (this._cur.isNormalAttr()) {
                QName name2 = this._cur.getName();
                this._attrNames.add(name2);
                int size = this._attrNames.size() - 2;
                while (true) {
                    if (size < 0) {
                        this._attrValues.add(this._cur.getAttrValue());
                        ensureMapping(name2.getNamespaceURI(), name2.getPrefix(), false, true);
                        break;
                    } else {
                        if (this._attrNames.get(size).equals(name2)) {
                            ArrayList<QName> arrayList = this._attrNames;
                            arrayList.remove(arrayList.size() - 1);
                            break;
                        }
                        size--;
                    }
                }
            }
            firstAttr = this._cur.toNextAttr();
        }
        this._cur.pop();
        Map<String, String> map = this._preComputedNamespaces;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                ensureMapping(key, value, value.length() == 0 && !z6, false);
            }
            this._preComputedNamespaces = null;
        }
        if (emitElement(this._cur, this._attrNames, this._attrValues)) {
            popMappings();
            this._cur.toEnd();
        }
    }

    private void processFinish() {
        emitFinish(this._cur);
        popMappings();
    }

    private void processRoot() {
        String doctypeSystemId;
        String localPart;
        XmlDocumentProperties docProps = this._cur.getDocProps();
        if (docProps != null) {
            doctypeSystemId = docProps.getDoctypeSystemId();
            localPart = docProps.getDoctypeName();
        } else {
            doctypeSystemId = null;
            localPart = null;
        }
        if (doctypeSystemId != null || localPart != null) {
            if (localPart == null) {
                this._cur.push();
                while (!this._cur.isElem() && this._cur.next()) {
                }
                if (this._cur.isElem()) {
                    localPart = this._cur.getName().getLocalPart();
                }
                this._cur.pop();
            }
            String doctypePublicId = docProps.getDoctypePublicId();
            if (localPart != null) {
                QName name = this._cur.getName();
                if (name == null) {
                    this._cur.push();
                    while (!this._cur.isFinish()) {
                        if (this._cur.isElem()) {
                            name = this._cur.getName();
                            break;
                        }
                        this._cur.next();
                    }
                    this._cur.pop();
                }
                if (name != null && localPart.equals(name.getLocalPart())) {
                    emitDocType(localPart, doctypePublicId, doctypeSystemId);
                    return;
                }
            }
        }
        emitStartDoc(this._cur);
    }

    private void pushMappings(SaveCur saveCur, boolean z6) {
        this._namespaceStack.add(null);
        saveCur.push();
        boolean firstAttr = saveCur.toFirstAttr();
        while (firstAttr) {
            if (saveCur.isXmlns()) {
                addNewFrameMapping(saveCur.getXmlnsPrefix(), saveCur.getXmlnsUri(), z6);
            }
            firstAttr = saveCur.toNextAttr();
        }
        saveCur.pop();
        if (this._ancestorNamespaces != null) {
            for (int i5 = 0; i5 < this._ancestorNamespaces.size(); i5 += 2) {
                addNewFrameMapping(this._ancestorNamespaces.get(i5), this._ancestorNamespaces.get(i5 + 1), z6);
            }
            this._ancestorNamespaces = null;
        }
        if (!z6 || this._prefixMap.get("").length() <= 0) {
            return;
        }
        addMapping("", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int syncWrap(Locale locale, SyncWrapFun syncWrapFun) {
        int iProcess;
        if (locale.noSync()) {
            locale.enter();
            try {
                return syncWrapFun.process();
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    iProcess = syncWrapFun.process();
                    locale.exit();
                } catch (Throwable th) {
                    locale.exit();
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return iProcess;
    }

    private boolean tryPrefix(String str) {
        if (str == null || Locale.beginsWithXml(str)) {
            return false;
        }
        String str2 = this._prefixMap.get(str);
        if (str2 != null) {
            return str.length() <= 0 && str2.equals(this._initialDefaultUri);
        }
        return true;
    }

    public abstract void emitComment(SaveCur saveCur);

    public abstract void emitDocType(String str, String str2, String str3);

    public abstract boolean emitElement(SaveCur saveCur, List<QName> list, List<String> list2);

    public abstract void emitEndDoc(SaveCur saveCur);

    public abstract void emitFinish(SaveCur saveCur);

    public abstract void emitProcinst(SaveCur saveCur);

    public abstract void emitStartDoc(SaveCur saveCur);

    public abstract void emitText(SaveCur saveCur);

    public final String getNamespaceForPrefix(String str) {
        return this._prefixMap.get(str);
    }

    public String getNonDefaultUriMapping(String str) {
        String str2 = this._uriMap.get(str);
        if (str2 != null && str2.length() > 0) {
            return str2;
        }
        for (String str3 : this._prefixMap.keySet()) {
            if (str3.length() > 0 && this._prefixMap.get(str3).equals(str)) {
                return str3;
            }
        }
        return null;
    }

    public final String getUriMapping(String str) {
        return this._uriMap.get(str);
    }

    public boolean hasMapping() {
        return this._currentMapping < this._namespaceStack.size();
    }

    public void iterateMappings() {
        this._currentMapping = this._namespaceStack.size();
        while (true) {
            int i5 = this._currentMapping;
            if (i5 <= 0 || this._namespaceStack.get(i5 - 1) == null) {
                return;
            } else {
                this._currentMapping -= 8;
            }
        }
    }

    public String mappingPrefix() {
        return this._namespaceStack.get(this._currentMapping + 6);
    }

    public String mappingUri() {
        return this._namespaceStack.get(this._currentMapping + 7);
    }

    public void nextMapping() {
        this._currentMapping += 8;
    }

    public final boolean process() {
        if (this._cur == null) {
            return false;
        }
        if (this._version != this._locale.version()) {
            throw new ConcurrentModificationException("Document changed during save");
        }
        int iKind = this._cur.kind();
        if (iKind == -2) {
            processFinish();
        } else {
            if (iKind == -1) {
                emitEndDoc(this._cur);
                this._cur.release();
                this._cur = null;
                return true;
            }
            if (iKind == 0) {
                emitText(this._cur);
            } else if (iKind == 1) {
                processRoot();
            } else if (iKind == 2) {
                processElement();
            } else if (iKind == 4) {
                emitComment(this._cur);
                this._cur.toEnd();
            } else {
                if (iKind != 5) {
                    throw new RuntimeException("Unexpected kind");
                }
                emitProcinst(this._cur);
                this._cur.toEnd();
            }
        }
        this._cur.next();
        return true;
    }

    public boolean saveNamespacesFirst() {
        return this._saveNamespacesFirst;
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class OptimizedForSpeedSaver extends Saver {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final char[] _buf;
        Writer _w;

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static class SaverIOException extends RuntimeException {
            public SaverIOException(IOException iOException) {
                super(iOException);
            }
        }

        public OptimizedForSpeedSaver(Cur cur, Writer writer) {
            super(cur, XmlOptions.maskNull(null));
            this._buf = new char[1024];
            this._w = writer;
        }

        private void emit(String str) {
            try {
                this._w.write(str);
            } catch (IOException e) {
                throw new SaverIOException(e);
            }
        }

        private void emitAttrHelper(QName qName, String str) {
            emit(Chars.SPACE);
            emitName(qName, true);
            emit(Chars.EQ, Chars.DQUOTE);
            emitAttrValue(str);
            emit(Chars.DQUOTE);
        }

        private void emitAttrValue(CharSequence charSequence) {
            int length = charSequence.length();
            for (int i5 = 0; i5 < length; i5++) {
                char cCharAt = charSequence.charAt(i5);
                if (cCharAt == '<') {
                    emit("&lt;");
                } else if (cCharAt == '&') {
                    emit("&amp;");
                } else if (cCharAt == '\"') {
                    emit("&quot;");
                } else {
                    emit(cCharAt);
                }
            }
        }

        private void emitLiteral(String str) {
            if (str.contains("\"")) {
                emit(Chars.QUOTE);
                emit(str);
                emit(Chars.QUOTE);
            } else {
                emit(Chars.DQUOTE);
                emit(str);
                emit(Chars.DQUOTE);
            }
        }

        private void emitName(QName qName, boolean z6) {
            String namespaceURI = qName.getNamespaceURI();
            if (namespaceURI.length() != 0) {
                String prefix = qName.getPrefix();
                String namespaceForPrefix = getNamespaceForPrefix(prefix);
                if (namespaceForPrefix == null || !namespaceForPrefix.equals(namespaceURI)) {
                    prefix = getUriMapping(namespaceURI);
                }
                if (z6 && prefix.length() == 0) {
                    prefix = getNonDefaultUriMapping(namespaceURI);
                }
                if (prefix.length() > 0) {
                    emit(prefix);
                    emit(NameUtil.COLON);
                }
            }
            emit(qName.getLocalPart());
        }

        private void emitNamespacesHelper() {
            iterateMappings();
            while (hasMapping()) {
                emit(Chars.SPACE);
                emitXmlns(mappingPrefix(), mappingUri());
                nextMapping();
            }
        }

        private void entitizeAndWriteCommentText(int i5) {
            int i6 = 0;
            boolean z6 = false;
            while (i6 < i5) {
                char c = this._buf[i6];
                if (Saver.isBadChar(c)) {
                    this._buf[i6] = '?';
                } else if (c != '-') {
                    z6 = false;
                } else if (z6) {
                    this._buf[i6] = Chars.SPACE;
                    z6 = false;
                } else {
                    z6 = true;
                }
                if (i6 == this._buf.length) {
                    i6 = 0;
                }
                i6++;
            }
            char[] cArr = this._buf;
            int i7 = i5 - 1;
            if (cArr[i7] == '-') {
                cArr[i7] = Chars.SPACE;
            }
            emit(cArr, 0, i5);
        }

        private void entitizeAndWritePIText(int i5) {
            boolean z6 = false;
            for (int i6 = 0; i6 < i5; i6++) {
                char c = this._buf[i6];
                if (Saver.isBadChar(c)) {
                    this._buf[i6] = '?';
                    c = '?';
                }
                if (c != '>') {
                    z6 = c == '?';
                } else if (z6) {
                    this._buf[i6] = Chars.SPACE;
                }
            }
            emit(this._buf, 0, i5);
        }

        private void entitizeAndWriteText(int i5) {
            int i6 = 0;
            for (int i7 = 0; i7 < i5; i7++) {
                char[] cArr = this._buf;
                char c = cArr[i7];
                if (c != '&') {
                    if (c == '<') {
                        emit(cArr, i6, i7 - i6);
                        emit("&lt;");
                    }
                } else {
                    emit(cArr, i6, i7 - i6);
                    emit("&amp;");
                }
                i6 = i7 + 1;
            }
            emit(this._buf, i6, i5 - i6);
        }

        public static void save(Cur cur, Writer writer) {
            try {
                do {
                } while (new OptimizedForSpeedSaver(cur, writer).process());
            } catch (SaverIOException e) {
                throw ((IOException) e.getCause());
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitComment(SaveCur saveCur) {
            emit("<!--");
            saveCur.push();
            saveCur.next();
            emitCommentText(saveCur);
            saveCur.pop();
            emit("-->");
        }

        public void emitCommentText(SaveCur saveCur) {
            Object chars = saveCur.getChars();
            int i5 = saveCur._cchSrc;
            int i6 = saveCur._offSrc;
            int i7 = 0;
            while (i7 < i5) {
                int i8 = i7 + 512 > i5 ? i5 : 512;
                CharUtil.getChars(this._buf, 0, chars, i6 + i7, i8);
                entitizeAndWriteCommentText(i8 - i7);
                i7 = i8;
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitDocType(String str, String str2, String str3) {
            emit("<!DOCTYPE ");
            emit(str);
            if (str2 == null && str3 != null) {
                emit(" SYSTEM ");
                emitLiteral(str3);
            } else if (str2 != null) {
                emit(" PUBLIC ");
                emitLiteral(str2);
                emit(Chars.SPACE);
                emitLiteral(str3);
            }
            emit('>');
            emit(Saver._newLine);
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public boolean emitElement(SaveCur saveCur, List<QName> list, List<String> list2) {
            emit('<');
            emitName(saveCur.getName(), false);
            for (int i5 = 0; i5 < list.size(); i5++) {
                emitAttrHelper(list.get(i5), list2.get(i5));
            }
            if (!saveNamespacesFirst()) {
                emitNamespacesHelper();
            }
            if (saveCur.hasChildren() || saveCur.hasText()) {
                emit('>');
                return false;
            }
            emit('/', '>');
            return true;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitFinish(SaveCur saveCur) {
            emit('<', '/');
            emitName(saveCur.getName(), false);
            emit('>');
        }

        public void emitPiText(SaveCur saveCur) {
            Object chars = saveCur.getChars();
            int i5 = saveCur._cchSrc;
            int i6 = saveCur._offSrc;
            int i7 = 0;
            while (i7 < i5) {
                int i8 = i7 + 512 > i5 ? i5 : 512;
                CharUtil.getChars(this._buf, 0, chars, i6 + i7, i8);
                entitizeAndWritePIText(i8 - i7);
                i7 = i8;
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitProcinst(SaveCur saveCur) {
            emit("<?");
            emit(saveCur.getName().getLocalPart());
            saveCur.push();
            saveCur.next();
            if (saveCur.isText()) {
                emit(Chars.SPACE);
                emitPiText(saveCur);
            }
            saveCur.pop();
            emit("?>");
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitText(SaveCur saveCur) {
            Object chars = saveCur.getChars();
            int i5 = saveCur._cchSrc;
            int i6 = saveCur._offSrc;
            int i7 = 0;
            while (i7 < i5) {
                int iMin = Math.min(i7 + 512, i5);
                int i8 = i6 + i7;
                int i9 = iMin - i7;
                CharUtil.getChars(this._buf, 0, chars, i8, i9);
                entitizeAndWriteText(i9);
                i7 = iMin;
            }
        }

        public void emitXmlns(String str, String str2) {
            emit(Sax2Dom.XMLNS_PREFIX);
            if (str.length() > 0) {
                emit(NameUtil.COLON);
                emit(str);
            }
            emit(Chars.EQ, Chars.DQUOTE);
            emitAttrValue(str2);
            emit(Chars.DQUOTE);
        }

        private void emit(char c) {
            try {
                char[] cArr = this._buf;
                cArr[0] = c;
                this._w.write(cArr, 0, 1);
            } catch (IOException e) {
                throw new SaverIOException(e);
            }
        }

        private void emit(char c, char c6) {
            try {
                char[] cArr = this._buf;
                cArr[0] = c;
                cArr[1] = c6;
                this._w.write(cArr, 0, 2);
            } catch (IOException e) {
                throw new SaverIOException(e);
            }
        }

        private void emit(char[] cArr, int i5, int i6) {
            try {
                this._w.write(cArr, i5, i6);
            } catch (IOException e) {
                throw new SaverIOException(e);
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitEndDoc(SaveCur saveCur) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitStartDoc(SaveCur saveCur) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class TextReader extends Reader {
        private boolean _closed = false;
        private final Locale _locale;
        private final TextSaver _textSaver;

        public TextReader(Cur cur, XmlOptions xmlOptions) {
            this._textSaver = new TextSaver(cur, xmlOptions, null);
            this._locale = cur._locale;
        }

        private void checkClosed() throws IOException {
            if (this._closed) {
                throw new IOException("Reader has been closed");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ int lambda$read$0(char[] cArr) {
            return this._textSaver.read(cArr, 0, cArr == null ? 0 : cArr.length);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ int lambda$read$1(char[] cArr, int i5, int i6) {
            return this._textSaver.read(cArr, i5, i6);
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this._closed = true;
        }

        @Override // java.io.Reader
        public int read() throws IOException {
            checkClosed();
            Locale locale = this._locale;
            TextSaver textSaver = this._textSaver;
            textSaver.getClass();
            return Saver.syncWrap(locale, new k0(textSaver, 1));
        }

        @Override // java.io.Reader
        public boolean ready() {
            return !this._closed;
        }

        @Override // java.io.Reader
        public int read(char[] cArr) throws IOException {
            checkClosed();
            return Saver.syncWrap(this._locale, new C1454o(this, cArr, 5));
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i5, int i6) throws IOException {
            checkClosed();
            return Saver.syncWrap(this._locale, new l0(this, cArr, i5, i6, 1));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class InputStreamSaver extends InputStream {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private boolean _closed = false;
        private final OutputStreamWriter _converter;
        private final Locale _locale;
        private final OutputStreamImpl _outStreamImpl;
        private final TextSaver _textSaver;

        /* JADX WARN: Multi-variable type inference failed */
        public InputStreamSaver(Cur cur, XmlOptions xmlOptions) {
            String java2IANAMapping;
            this._locale = cur._locale;
            XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
            OutputStreamImpl outputStreamImpl = new OutputStreamImpl();
            this._outStreamImpl = outputStreamImpl;
            XmlDocumentProperties docProps = Locale.getDocProps(cur, false);
            String iANA2JavaMapping = (docProps == null || docProps.getEncoding() == null) ? null : EncodingMap.getIANA2JavaMapping(docProps.getEncoding());
            String characterEncoding = xmlOptionsMaskNull.getCharacterEncoding();
            iANA2JavaMapping = characterEncoding != null ? characterEncoding : iANA2JavaMapping;
            if (iANA2JavaMapping != null && (java2IANAMapping = EncodingMap.getJava2IANAMapping(iANA2JavaMapping)) != null) {
                iANA2JavaMapping = java2IANAMapping;
            }
            iANA2JavaMapping = iANA2JavaMapping == null ? EncodingMap.getJava2IANAMapping("UTF8") : iANA2JavaMapping;
            String iANA2JavaMapping2 = iANA2JavaMapping != null ? EncodingMap.getIANA2JavaMapping(iANA2JavaMapping) : null;
            if (iANA2JavaMapping2 == null) {
                throw new IllegalStateException(AbstractC0157z.n("Unknown encoding: ", iANA2JavaMapping));
            }
            try {
                this._converter = new OutputStreamWriter(outputStreamImpl, iANA2JavaMapping2);
                this._textSaver = new TextSaver(cur, xmlOptionsMaskNull, iANA2JavaMapping);
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }

        private void checkClosed() throws IOException {
            if (this._closed) {
                throw new IOException("Stream closed");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int ensure(int i5) {
            if (i5 <= 0) {
                i5 = 1;
            }
            int available = this._outStreamImpl.getAvailable();
            while (available < i5 && this._textSaver.write(this._converter, 2048) >= 2048) {
                available = this._outStreamImpl.getAvailable();
            }
            return this._outStreamImpl.getAvailable();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ int lambda$available$1() {
            return ensure(1024);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ int lambda$read$0(byte[] bArr, int i5, int i6) {
            return this._outStreamImpl.read(bArr, i5, i6);
        }

        @Override // java.io.InputStream
        public int available() {
            try {
                return Saver.syncWrap(this._locale, new k0(this, 0));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this._closed = true;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            int i5;
            checkClosed();
            if (this._locale.noSync()) {
                this._locale.enter();
                try {
                    return this._outStreamImpl.read();
                } finally {
                    this._locale.exit();
                }
            }
            synchronized (this._locale) {
                try {
                    this._locale.enter();
                    try {
                        i5 = this._outStreamImpl.read();
                        this._locale.exit();
                    } catch (Throwable th) {
                        this._locale.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return i5;
        }

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public final class OutputStreamImpl extends OutputStream {
            static final /* synthetic */ boolean $assertionsDisabled = false;
            private static final int _initialBufSize = 4096;
            private byte[] _buf;
            private int _free;
            private int _in;
            private int _out;

            private OutputStreamImpl() {
            }

            public int getAvailable() {
                byte[] bArr = this._buf;
                if (bArr == null) {
                    return 0;
                }
                return bArr.length - this._free;
            }

            public int read() {
                if (InputStreamSaver.this.ensure(1) == 0) {
                    return -1;
                }
                byte[] bArr = this._buf;
                int i5 = this._out;
                byte b = bArr[i5];
                this._out = (i5 + 1) % bArr.length;
                this._free++;
                return b;
            }

            public void resize(int i5) {
                byte[] bArr = this._buf;
                int length = bArr == null ? 4096 : bArr.length * 2;
                int available = getAvailable();
                while (length - available < i5) {
                    length *= 2;
                }
                byte[] bArr2 = new byte[length];
                if (available > 0) {
                    int i6 = this._in;
                    int i7 = this._out;
                    if (i6 > i7) {
                        System.arraycopy(this._buf, i7, bArr2, 0, available);
                    } else {
                        System.arraycopy(this._buf, i7, bArr2, 0, available - i6);
                        byte[] bArr3 = this._buf;
                        int i8 = this._in;
                        System.arraycopy(bArr3, 0, bArr2, available - i8, i8);
                    }
                    this._out = 0;
                    this._in = available;
                    this._free = (length - this._buf.length) + this._free;
                } else {
                    this._free = length;
                }
                this._buf = bArr2;
            }

            @Override // java.io.OutputStream
            public void write(int i5) {
                if (this._free == 0) {
                    resize(1);
                }
                byte[] bArr = this._buf;
                int i6 = this._in;
                bArr[i6] = (byte) i5;
                this._in = (i6 + 1) % bArr.length;
                this._free--;
            }

            public int read(byte[] bArr, int i5, int i6) {
                int iEnsure = InputStreamSaver.this.ensure(i6);
                if (iEnsure == 0) {
                    return -1;
                }
                if (bArr == null || i6 <= 0) {
                    return 0;
                }
                if (iEnsure < i6) {
                    i6 = iEnsure;
                }
                int i7 = this._out;
                if (i7 < this._in) {
                    System.arraycopy(this._buf, i7, bArr, i5, i6);
                } else {
                    byte[] bArr2 = this._buf;
                    int length = bArr2.length - i7;
                    if (length >= i6) {
                        System.arraycopy(bArr2, i7, bArr, i5, i6);
                    } else {
                        System.arraycopy(bArr2, i7, bArr, i5, length);
                        System.arraycopy(this._buf, 0, bArr, i5 + length, i6 - length);
                    }
                }
                this._out = (this._out + i6) % this._buf.length;
                this._free += i6;
                return i6;
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i5, int i6) {
                if (i6 == 0) {
                    return;
                }
                if (this._free < i6) {
                    resize(i6);
                }
                if (this._in == this._out) {
                    this._out = 0;
                    this._in = 0;
                }
                byte[] bArr2 = this._buf;
                int length = bArr2.length;
                int i7 = this._in;
                int i8 = length - i7;
                if (i7 > this._out && i6 >= i8) {
                    System.arraycopy(bArr, i5, bArr2, i7, i8);
                    System.arraycopy(bArr, i5 + i8, this._buf, 0, i6 - i8);
                    this._in = (this._in + i6) % this._buf.length;
                } else {
                    System.arraycopy(bArr, i5, bArr2, i7, i6);
                    this._in += i6;
                }
                this._free -= i6;
            }
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i5, int i6) throws IOException {
            checkClosed();
            if (bArr != null) {
                if (i5 >= 0 && i5 <= bArr.length) {
                    return Saver.syncWrap(this._locale, new l0(this, bArr, i5, i6, 0));
                }
                throw new IndexOutOfBoundsException("Offset is not within buf");
            }
            throw new NullPointerException("buf to read into is null");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class TextSaver extends Saver {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final int _initialBufSize = 4096;
        private char[] _buf;
        private int _cdataEntityCountThreshold;
        private int _cdataLengthThreshold;
        private int _free;
        private int _in;
        private boolean _isPrettyPrint;
        private int _lastEmitCch;
        private int _lastEmitIn;
        private int _out;
        private boolean _useCDataBookmarks;

        public TextSaver(Cur cur, XmlOptions xmlOptions, String str) {
            super(cur, xmlOptions);
            this._cdataLengthThreshold = 32;
            this._cdataEntityCountThreshold = 5;
            this._useCDataBookmarks = false;
            this._isPrettyPrint = false;
            boolean z6 = xmlOptions != null && xmlOptions.isSaveNoXmlDecl();
            if (xmlOptions != null && xmlOptions.getSaveCDataLengthThreshold() != null) {
                this._cdataLengthThreshold = xmlOptions.getSaveCDataLengthThreshold().intValue();
            }
            if (xmlOptions != null && xmlOptions.getSaveCDataEntityCountThreshold() != null) {
                this._cdataEntityCountThreshold = xmlOptions.getSaveCDataEntityCountThreshold().intValue();
            }
            if (xmlOptions != null && xmlOptions.isUseCDataBookmarks()) {
                this._useCDataBookmarks = true;
            }
            if (xmlOptions != null && xmlOptions.isSavePrettyPrint()) {
                this._isPrettyPrint = true;
            }
            this._out = 0;
            this._in = 0;
            this._free = 0;
            if (str == null || z6) {
                return;
            }
            XmlDocumentProperties docProps = Locale.getDocProps(cur, false);
            Boolean boolValueOf = null;
            String version = docProps == null ? null : docProps.getVersion();
            version = version == null ? "1.0" : version;
            if (docProps != null && docProps.get(XmlDocumentProperties.STANDALONE) != null) {
                boolValueOf = Boolean.valueOf(docProps.getStandalone());
            }
            emit("<?xml version=\"");
            emit(version);
            emit(AbstractC0157z.o("\" encoding=\"", str, "\""));
            if (boolValueOf != null) {
                emit(AbstractC0157z.s(new StringBuilder(" standalone=\""), boolValueOf.booleanValue() ? "yes" : "no", "\""));
            }
            emit("?>" + Saver._newLine);
        }

        private void emit(char c) {
            preEmit(1);
            char[] cArr = this._buf;
            int i5 = this._in;
            cArr[i5] = c;
            this._in = (i5 + 1) % cArr.length;
        }

        private void emitAttrHelper(QName qName, String str) {
            emit(Chars.SPACE);
            emitName(qName, true);
            emit(Chars.EQ, Chars.DQUOTE);
            emit(str);
            entitizeAttrValue(true);
            emit(Chars.DQUOTE);
        }

        private void emitLiteral(String str) {
            if (str.contains("\"")) {
                emit(Chars.QUOTE);
                emit(str);
                emit(Chars.QUOTE);
            } else {
                emit(Chars.DQUOTE);
                emit(str);
                emit(Chars.DQUOTE);
            }
        }

        private void emitName(QName qName, boolean z6) {
            String namespaceURI = qName.getNamespaceURI();
            if (namespaceURI.length() != 0) {
                String prefix = qName.getPrefix();
                String namespaceForPrefix = getNamespaceForPrefix(prefix);
                if (namespaceForPrefix == null || !namespaceForPrefix.equals(namespaceURI)) {
                    prefix = getUriMapping(namespaceURI);
                }
                if (z6 && prefix.length() == 0) {
                    prefix = getNonDefaultUriMapping(namespaceURI);
                }
                if (prefix.length() > 0) {
                    emit(prefix);
                    emit(NameUtil.COLON);
                }
            }
            emit(qName.getLocalPart());
        }

        private void emitNamespacesHelper() {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            iterateMappings();
            while (hasMapping()) {
                String strMappingPrefix = mappingPrefix();
                String strMappingUri = mappingUri();
                if (!linkedHashMap.containsKey(strMappingPrefix)) {
                    linkedHashMap.put(strMappingPrefix, strMappingUri);
                } else if (strMappingPrefix.length() == 0 && ((String) linkedHashMap.get(strMappingPrefix)).length() == 0) {
                    linkedHashMap.put(strMappingPrefix, strMappingUri);
                }
                nextMapping();
            }
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                emit(Chars.SPACE);
                emitXmlns((String) entry.getKey(), (String) entry.getValue());
            }
        }

        private int ensure(int i5) {
            if (i5 <= 0) {
                i5 = 1;
            }
            int available = getAvailable();
            while (available < i5 && process()) {
                available = getAvailable();
            }
            return available;
        }

        private void entitizeAttrValue(boolean z6) {
            int i5 = this._lastEmitCch;
            if (i5 == 0) {
                return;
            }
            int iReplace = this._lastEmitIn;
            while (i5 > 0) {
                char c = this._buf[iReplace];
                if (c == '<') {
                    iReplace = replace(iReplace, "&lt;");
                } else if (c == '&') {
                    iReplace = replace(iReplace, "&amp;");
                } else if (c == '\"') {
                    iReplace = replace(iReplace, "&quot;");
                } else if (!isEscapedChar(c)) {
                    iReplace++;
                } else if (z6) {
                    iReplace = replace(iReplace, this._replaceChar.getEscapedString(c));
                }
                if (iReplace == this._buf.length) {
                    iReplace = 0;
                }
                i5--;
            }
        }

        private void entitizeComment() {
            int i5 = this._lastEmitCch;
            if (i5 == 0) {
                return;
            }
            int iReplace = this._lastEmitIn;
            boolean z6 = false;
            while (i5 > 0) {
                char c = this._buf[iReplace];
                if (Saver.isBadChar(c)) {
                    iReplace = replace(iReplace, "?");
                } else {
                    if (c != '-') {
                        iReplace++;
                    } else if (z6) {
                        iReplace = replace(iReplace, " ");
                    } else {
                        iReplace++;
                        z6 = true;
                    }
                    z6 = false;
                }
                if (iReplace == this._buf.length) {
                    iReplace = 0;
                }
                i5--;
            }
            int i6 = (this._lastEmitIn + this._lastEmitCch) - 1;
            char[] cArr = this._buf;
            int length = i6 % cArr.length;
            if (cArr[length] == '-') {
                replace(length, " ");
            }
        }

        private void entitizeContent(boolean z6) {
            int i5;
            int i6 = this._lastEmitCch;
            if (i6 == 0) {
                return;
            }
            int i7 = this._lastEmitIn;
            int length = this._buf.length;
            int i8 = 0;
            boolean z7 = false;
            char c = 0;
            char c6 = 0;
            while (i6 > 0) {
                char c7 = this._buf[i7];
                if (c7 == '<' || c7 == '&') {
                    i8++;
                } else if ((c == ']' && c6 == ']' && c7 == '>') || Saver.isBadChar(c7) || isEscapedChar(c7) || (!this._isPrettyPrint && c7 == '\r')) {
                    z7 = true;
                }
                i7++;
                if (i7 == length) {
                    i7 = 0;
                }
                i6--;
                c = c6;
                c6 = c7;
            }
            if (z6 || i8 != 0 || z7 || i8 >= this._cdataEntityCountThreshold) {
                int iReplace = this._lastEmitIn;
                if (!z6 && ((i5 = this._lastEmitCch) <= this._cdataLengthThreshold || i8 <= this._cdataEntityCountThreshold)) {
                    char c8 = 0;
                    char c9 = 0;
                    while (i5 > 0) {
                        char c10 = this._buf[iReplace];
                        if (c10 == '<') {
                            iReplace = replace(iReplace, "&lt;");
                        } else if (c10 == '&') {
                            iReplace = replace(iReplace, "&amp;");
                        } else if (c10 == '>' && c9 == ']' && c8 == ']') {
                            iReplace = replace(iReplace, "&gt;");
                        } else if (Saver.isBadChar(c10)) {
                            iReplace = replace(iReplace, "?");
                        } else if (this._isPrettyPrint || c10 != '\r') {
                            iReplace = isEscapedChar(c10) ? replace(iReplace, this._replaceChar.getEscapedString(c10)) : iReplace + 1;
                        } else {
                            iReplace = replace(iReplace, "&#13;");
                        }
                        if (iReplace == this._buf.length) {
                            iReplace = 0;
                        }
                        i5--;
                        c8 = c9;
                        c9 = c10;
                    }
                    return;
                }
                boolean z8 = this._buf[iReplace] == ']';
                int iReplace2 = replace(iReplace, "<![CDATA[" + this._buf[iReplace]);
                char[] cArr = this._buf;
                boolean z9 = cArr[iReplace2] == ']';
                int iReplace3 = iReplace2 + 1;
                if (iReplace3 == cArr.length) {
                    iReplace3 = 0;
                }
                int i9 = this._lastEmitCch - 2;
                while (i9 > 0) {
                    char c11 = this._buf[iReplace3];
                    if (c11 == '>' && z8 && z9) {
                        iReplace3 = replace(iReplace3, "]]>><![CDATA[");
                    } else {
                        iReplace3 = Saver.isBadChar(c11) ? replace(iReplace3, "?") : iReplace3 + 1;
                    }
                    boolean z10 = c11 == ']';
                    if (iReplace3 == this._buf.length) {
                        iReplace3 = 0;
                    }
                    i9--;
                    boolean z11 = z9;
                    z9 = z10;
                    z8 = z11;
                }
                emit("]]>");
            }
        }

        private void entitizeProcinst() {
            int i5 = this._lastEmitCch;
            if (i5 == 0) {
                return;
            }
            int iReplace = this._lastEmitIn;
            boolean z6 = false;
            while (i5 > 0) {
                char c = this._buf[iReplace];
                if (Saver.isBadChar(c)) {
                    iReplace = replace(iReplace, "?");
                }
                if (c == '>') {
                    iReplace = z6 ? replace(iReplace, " ") : iReplace + 1;
                    z6 = false;
                } else {
                    z6 = c == '?';
                    iReplace++;
                }
                if (iReplace == this._buf.length) {
                    iReplace = 0;
                }
                i5--;
            }
        }

        private boolean isEscapedChar(char c) {
            XmlOptionCharEscapeMap xmlOptionCharEscapeMap = this._replaceChar;
            return xmlOptionCharEscapeMap != null && xmlOptionCharEscapeMap.containsChar(c);
        }

        private boolean preEmit(int i5) {
            this._lastEmitCch = i5;
            if (i5 == 0) {
                return true;
            }
            if (this._free <= i5) {
                resize(i5, -1);
            }
            if (getAvailable() == 0) {
                this._out = 0;
                this._in = 0;
            }
            this._lastEmitIn = this._in;
            this._free -= i5;
            return false;
        }

        private int replace(int i5, String str) {
            int length = str.length();
            int i6 = length - 1;
            if (i6 == 0) {
                this._buf[i5] = str.charAt(0);
                return i5 + 1;
            }
            if (i6 > this._free) {
                i5 = resize(i6, i5);
            }
            int i7 = this._out;
            int i8 = this._in;
            if (i7 <= i8 || i5 < i7) {
                char[] cArr = this._buf;
                int length2 = cArr.length - i8;
                if (i6 <= length2) {
                    System.arraycopy(cArr, i5, cArr, i5 + i6, i8 - i5);
                    this._in = (this._in + i6) % this._buf.length;
                } else if (i6 <= ((length2 + i8) - i5) - 1) {
                    int i9 = i6 - length2;
                    System.arraycopy(cArr, i8 - i9, cArr, 0, i9);
                    char[] cArr2 = this._buf;
                    int i10 = i5 + 1;
                    System.arraycopy(cArr2, i10, cArr2, i10 + i6, ((this._in - i5) - 1) - i9);
                    this._in = i9;
                } else {
                    int i11 = (i8 - i5) - 1;
                    int i12 = (length2 + i8) - i5;
                    System.arraycopy(cArr, i8 - i11, cArr, (i6 - i12) + 1, i11);
                    str.getChars(i12, length, this._buf, 0);
                    this._in = ((i11 + i6) - i12) + 1;
                    length = i12;
                }
            } else {
                char[] cArr3 = this._buf;
                System.arraycopy(cArr3, i7, cArr3, i7 - i6, i5 - i7);
                this._out -= i6;
                i5 -= i6;
            }
            str.getChars(0, length, this._buf, i5);
            this._free -= i6;
            return ((i5 + i6) + 1) % this._buf.length;
        }

        private int resize(int i5, int i6) {
            char[] cArr = this._buf;
            int length = cArr == null ? 4096 : cArr.length * 2;
            int available = getAvailable();
            while (length - available < i5) {
                length *= 2;
            }
            char[] cArr2 = new char[length];
            if (available > 0) {
                int i7 = this._in;
                int i8 = this._out;
                if (i7 > i8) {
                    System.arraycopy(this._buf, i8, cArr2, 0, available);
                    i6 -= this._out;
                } else {
                    int i9 = available - i7;
                    System.arraycopy(this._buf, i8, cArr2, 0, i9);
                    System.arraycopy(this._buf, 0, cArr2, i9, this._in);
                    int i10 = this._out;
                    i6 = i6 >= i10 ? i6 - i10 : i6 + i9;
                }
                this._out = 0;
                this._in = available;
                this._free = (length - this._buf.length) + this._free;
            } else {
                this._free = length;
            }
            this._buf = cArr2;
            return i6;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitComment(SaveCur saveCur) {
            emit("<!--");
            saveCur.push();
            saveCur.next();
            emit(saveCur);
            saveCur.pop();
            entitizeComment();
            emit("-->");
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitDocType(String str, String str2, String str3) {
            emit("<!DOCTYPE ");
            emit(str);
            if (str2 == null && str3 != null) {
                emit(" SYSTEM ");
                emitLiteral(str3);
            } else if (str2 != null) {
                emit(" PUBLIC ");
                emitLiteral(str2);
                emit(" ");
                emitLiteral(str3);
            }
            emit(">");
            emit(Saver._newLine);
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public boolean emitElement(SaveCur saveCur, List<QName> list, List<String> list2) {
            emit('<');
            emitName(saveCur.getName(), false);
            if (saveNamespacesFirst()) {
                emitNamespacesHelper();
            }
            for (int i5 = 0; i5 < list.size(); i5++) {
                emitAttrHelper(list.get(i5), list2.get(i5));
            }
            if (!saveNamespacesFirst()) {
                emitNamespacesHelper();
            }
            if (saveCur.hasChildren() || saveCur.hasText()) {
                emit('>');
                return false;
            }
            emit('/', '>');
            return true;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitFinish(SaveCur saveCur) {
            emit('<', '/');
            emitName(saveCur.getName(), false);
            emit('>');
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitProcinst(SaveCur saveCur) {
            emit("<?");
            emit(saveCur.getName().getLocalPart());
            saveCur.push();
            saveCur.next();
            if (saveCur.isText()) {
                emit(" ");
                emit(saveCur);
                entitizeProcinst();
            }
            saveCur.pop();
            emit("?>");
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitText(SaveCur saveCur) {
            boolean z6 = this._useCDataBookmarks && saveCur.isTextCData();
            emit(saveCur);
            entitizeContent(z6);
        }

        public void emitXmlns(String str, String str2) {
            emit(Sax2Dom.XMLNS_PREFIX);
            if (str.length() > 0) {
                emit(NameUtil.COLON);
                emit(str);
            }
            emit(Chars.EQ, Chars.DQUOTE);
            emit(str2);
            entitizeAttrValue(false);
            emit(Chars.DQUOTE);
        }

        public int getAvailable() {
            char[] cArr = this._buf;
            if (cArr == null) {
                return 0;
            }
            return cArr.length - this._free;
        }

        public int read() {
            if (ensure(1) == 0) {
                return -1;
            }
            char[] cArr = this._buf;
            int i5 = this._out;
            char c = cArr[i5];
            this._out = (i5 + 1) % cArr.length;
            this._free++;
            return c;
        }

        public String saveToString() {
            while (process()) {
            }
            int available = getAvailable();
            return available == 0 ? "" : new String(this._buf, this._out, available);
        }

        public int write(Writer writer, int i5) {
            while (getAvailable() < i5 && process()) {
            }
            int available = getAvailable();
            if (available > 0) {
                char[] cArr = this._buf;
                if (cArr.length - this._in != this._free) {
                    this._in = cArr.length;
                }
                try {
                    writer.write(cArr, 0, available);
                    writer.flush();
                    this._free += available;
                    this._in = 0;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return available;
        }

        private void emit(char c, char c6) {
            if (preEmit(2)) {
                return;
            }
            char[] cArr = this._buf;
            int i5 = this._in;
            cArr[i5] = c;
            int length = (i5 + 1) % cArr.length;
            this._in = length;
            cArr[length] = c6;
            this._in = (length + 1) % cArr.length;
        }

        public int read(char[] cArr, int i5, int i6) {
            int iEnsure = ensure(i6);
            if (iEnsure == 0) {
                return -1;
            }
            if (cArr == null || i6 <= 0) {
                return 0;
            }
            if (iEnsure < i6) {
                i6 = iEnsure;
            }
            int i7 = this._out;
            if (i7 < this._in) {
                System.arraycopy(this._buf, i7, cArr, i5, i6);
            } else {
                char[] cArr2 = this._buf;
                int length = cArr2.length - i7;
                if (length >= i6) {
                    System.arraycopy(cArr2, i7, cArr, i5, i6);
                } else {
                    System.arraycopy(cArr2, i7, cArr, i5, length);
                    System.arraycopy(this._buf, 0, cArr, i5 + length, i6 - length);
                }
            }
            this._out = (this._out + i6) % this._buf.length;
            this._free += i6;
            return i6;
        }

        private void emit(String str) {
            int length = str == null ? 0 : str.length();
            if (preEmit(length) || str == null) {
                return;
            }
            int i5 = this._in;
            if (i5 > this._out) {
                char[] cArr = this._buf;
                int length2 = cArr.length - i5;
                if (length >= length2) {
                    str.getChars(0, length2, cArr, i5);
                    str.getChars(length2, length, this._buf, 0);
                    this._in = (this._in + length) % this._buf.length;
                    return;
                }
            }
            str.getChars(0, length, this._buf, i5);
            this._in += length;
        }

        private void emit(SaveCur saveCur) {
            if (saveCur.isText()) {
                Object chars = saveCur.getChars();
                int i5 = saveCur._cchSrc;
                if (preEmit(i5)) {
                    return;
                }
                int i6 = this._in;
                if (i6 > this._out) {
                    char[] cArr = this._buf;
                    int length = cArr.length - i6;
                    if (i5 >= length) {
                        CharUtil.getChars(cArr, i6, chars, saveCur._offSrc, length);
                        CharUtil.getChars(this._buf, 0, chars, saveCur._offSrc + length, i5 - length);
                        this._in = (this._in + i5) % this._buf.length;
                        return;
                    }
                }
                CharUtil.getChars(this._buf, i6, chars, saveCur._offSrc, i5);
                this._in += i5;
                return;
            }
            preEmit(0);
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitEndDoc(SaveCur saveCur) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitStartDoc(SaveCur saveCur) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class SaxSaver extends Saver {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AttributesImpl _attributes;
        private char[] _buf;
        private final ContentHandler _contentHandler;
        private final LexicalHandler _lexicalHandler;
        private final boolean _nsAsAttrs;

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static class SaverSAXException extends RuntimeException {
            SAXException _saxException;

            public SaverSAXException(SAXException sAXException) {
                this._saxException = sAXException;
            }
        }

        public SaxSaver(Cur cur, XmlOptions xmlOptions, ContentHandler contentHandler, LexicalHandler lexicalHandler) throws SAXException {
            super(cur, xmlOptions);
            this._contentHandler = contentHandler;
            this._lexicalHandler = lexicalHandler;
            this._attributes = new AttributesImpl();
            this._nsAsAttrs = !xmlOptions.isSaveSaxNoNSDeclsInAttributes();
            contentHandler.startDocument();
            do {
                try {
                } catch (SaverSAXException e) {
                    throw e._saxException;
                }
            } while (process());
            this._contentHandler.endDocument();
        }

        private void emitNamespacesHelper() {
            iterateMappings();
            while (hasMapping()) {
                String strMappingPrefix = mappingPrefix();
                String strMappingUri = mappingUri();
                try {
                    this._contentHandler.startPrefixMapping(strMappingPrefix, strMappingUri);
                    if (this._nsAsAttrs) {
                        if (strMappingPrefix == null || strMappingPrefix.length() == 0) {
                            this._attributes.addAttribute("http://www.w3.org/2000/xmlns/", Sax2Dom.XMLNS_PREFIX, Sax2Dom.XMLNS_PREFIX, "CDATA", strMappingUri);
                        } else {
                            this._attributes.addAttribute("http://www.w3.org/2000/xmlns/", strMappingPrefix, Sax2Dom.XMLNS_STRING.concat(strMappingPrefix), "CDATA", strMappingUri);
                        }
                    }
                    nextMapping();
                } catch (SAXException e) {
                    throw new SaverSAXException(e);
                }
            }
        }

        private String getPrefixedName(QName qName) {
            String namespaceURI = qName.getNamespaceURI();
            String localPart = qName.getLocalPart();
            if (namespaceURI.length() != 0) {
                String uriMapping = getUriMapping(namespaceURI);
                if (uriMapping.length() != 0) {
                    return androidx.collection.a.o(uriMapping, ParameterizedMessage.ERROR_MSG_SEPARATOR, localPart);
                }
            }
            return localPart;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitComment(SaveCur saveCur) {
            if (this._lexicalHandler != null) {
                saveCur.push();
                saveCur.next();
                try {
                    if (saveCur.isText()) {
                        Object chars = saveCur.getChars();
                        if (chars instanceof char[]) {
                            this._lexicalHandler.comment((char[]) chars, saveCur._offSrc, saveCur._cchSrc);
                        } else {
                            char[] cArr = this._buf;
                            if (cArr == null || cArr.length < saveCur._cchSrc) {
                                this._buf = new char[Math.max(1024, saveCur._cchSrc)];
                            }
                            CharUtil.getChars(this._buf, 0, chars, saveCur._offSrc, saveCur._cchSrc);
                            this._lexicalHandler.comment(this._buf, 0, saveCur._cchSrc);
                        }
                    } else {
                        this._lexicalHandler.comment(null, 0, 0);
                    }
                    saveCur.pop();
                } catch (SAXException e) {
                    throw new SaverSAXException(e);
                }
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitDocType(String str, String str2, String str3) {
            LexicalHandler lexicalHandler = this._lexicalHandler;
            if (lexicalHandler != null) {
                try {
                    lexicalHandler.startDTD(str, str2, str3);
                    this._lexicalHandler.endDTD();
                } catch (SAXException e) {
                    throw new SaverSAXException(e);
                }
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public boolean emitElement(SaveCur saveCur, List<QName> list, List<String> list2) {
            this._attributes.clear();
            if (saveNamespacesFirst()) {
                emitNamespacesHelper();
            }
            for (int i5 = 0; i5 < list.size(); i5++) {
                QName qName = list.get(i5);
                this._attributes.addAttribute(qName.getNamespaceURI(), qName.getLocalPart(), getPrefixedName(qName), "CDATA", list2.get(i5));
            }
            if (!saveNamespacesFirst()) {
                emitNamespacesHelper();
            }
            QName name = saveCur.getName();
            try {
                this._contentHandler.startElement(name.getNamespaceURI(), name.getLocalPart(), getPrefixedName(name), this._attributes);
                return false;
            } catch (SAXException e) {
                throw new SaverSAXException(e);
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitFinish(SaveCur saveCur) {
            QName name = saveCur.getName();
            try {
                this._contentHandler.endElement(name.getNamespaceURI(), name.getLocalPart(), getPrefixedName(name));
                iterateMappings();
                while (hasMapping()) {
                    this._contentHandler.endPrefixMapping(mappingPrefix());
                    nextMapping();
                }
            } catch (SAXException e) {
                throw new SaverSAXException(e);
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitProcinst(SaveCur saveCur) {
            saveCur.push();
            saveCur.next();
            String string = CharUtil.getString(saveCur.getChars(), saveCur._offSrc, saveCur._cchSrc);
            saveCur.pop();
            try {
                this._contentHandler.processingInstruction(saveCur.getName().getLocalPart(), string);
            } catch (SAXException e) {
                throw new SaverSAXException(e);
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitText(SaveCur saveCur) {
            Object chars = saveCur.getChars();
            try {
                if (chars instanceof char[]) {
                    this._contentHandler.characters((char[]) chars, saveCur._offSrc, saveCur._cchSrc);
                    return;
                }
                if (this._buf == null) {
                    this._buf = new char[1024];
                }
                while (true) {
                    int i5 = saveCur._cchSrc;
                    if (i5 <= 0) {
                        return;
                    }
                    int iMin = Math.min(this._buf.length, i5);
                    CharUtil.getChars(this._buf, 0, chars, saveCur._offSrc, iMin);
                    this._contentHandler.characters(this._buf, 0, iMin);
                    saveCur._offSrc += iMin;
                    saveCur._cchSrc -= iMin;
                }
            } catch (SAXException e) {
                throw new SaverSAXException(e);
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitEndDoc(SaveCur saveCur) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitStartDoc(SaveCur saveCur) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class SynthNamespaceSaver extends Saver {
        LinkedHashMap<String, String> _synthNamespaces;

        public SynthNamespaceSaver(Cur cur, XmlOptions xmlOptions) {
            super(cur, xmlOptions);
            this._synthNamespaces = new LinkedHashMap<>();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public boolean emitElement(SaveCur saveCur, List<QName> list, List<String> list2) {
            return false;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void syntheticNamespace(String str, String str2, boolean z6) {
            LinkedHashMap<String, String> linkedHashMap = this._synthNamespaces;
            if (z6) {
                str = "";
            }
            linkedHashMap.put(str2, str);
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitComment(SaveCur saveCur) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitEndDoc(SaveCur saveCur) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitFinish(SaveCur saveCur) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitProcinst(SaveCur saveCur) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitStartDoc(SaveCur saveCur) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitText(SaveCur saveCur) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        public void emitDocType(String str, String str2, String str3) {
        }
    }

    public void syntheticNamespace(String str, String str2, boolean z6) {
    }
}
