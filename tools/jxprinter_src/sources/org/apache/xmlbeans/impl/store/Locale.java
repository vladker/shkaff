package org.apache.xmlbeans.impl.store;

import A3.AbstractC0157z;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import javax.xml.namespace.QName;
import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.logging.log4j.util.Chars;
import org.apache.xmlbeans.CDataBookmark;
import org.apache.xmlbeans.QNameCache;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlDocumentProperties;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlLineNumber;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlRuntimeException;
import org.apache.xmlbeans.XmlSaxHandler;
import org.apache.xmlbeans.XmlTokenSource;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ResolverUtil;
import org.apache.xmlbeans.impl.common.SAXHelper;
import org.apache.xmlbeans.impl.common.Sax2Dom;
import org.apache.xmlbeans.impl.common.XmlLocale;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.DeclHandler;
import org.xml.sax.ext.LexicalHandler;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class Locale implements DOMImplementation, Saaj.SaajCallback, XmlLocale {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int ATTR = 3;
    static final int COMMENT = 4;
    static final int ELEM = 2;
    static final int PROCINST = 5;
    static final int ROOT = 1;
    static final int TEXT = 0;
    static final String _xml1998Uri = "http://www.w3.org/XML/1998/namespace";
    static final String _xmlnsUri = "http://www.w3.org/2000/xmlns/";
    int _cchSrc;
    ChangeListener _changeListeners;
    private CharUtil _charUtil;
    Cur _curPool;
    int _curPoolCount;
    private int _entryCount;
    Cur.Locations _locations;
    boolean _noSync;
    int _numTempFramesLeft;
    int _offSrc;
    DomImpl.Dom _ownerDoc;
    int _posTemp;
    QNameFactory _qnameFactory;
    private ReferenceQueue<Ref> _refQueue;
    Cur _registered;
    Saaj _saaj;
    SchemaTypeLoader _schemaTypeLoader;
    Cur[] _tempFrames;
    boolean _validateOnSet;
    long _versionAll;
    long _versionSansText;
    private static final Logger LOG = LogManager.getLogger((Class<?>) Locale.class);
    static final String _xsi = "http://www.w3.org/2001/XMLSchema-instance";
    static final QName _xsiNil = new QName(_xsi, "nil", "xsi");
    static final QName _xsiType = new QName(_xsi, "type", "xsi");
    static final QName _xsiLoc = new QName(_xsi, "schemaLocation", "xsi");
    static final QName _xsiNoLoc = new QName(_xsi, "noNamespaceSchemaLocation", "xsi");
    static final String _openFragUri = "http://www.openuri.org/fragment";
    static final QName _openuriFragment = new QName(_openFragUri, "fragment", "frag");
    static final QName _xmlFragment = new QName("xml-fragment");
    private static final ThreadLocal<SoftReference<ScrubBuffer>> tl_scrubBuffer = ThreadLocal.withInitial(new C1440a(1));
    nthCache _nthCache_A = new nthCache();
    nthCache _nthCache_B = new nthCache();
    domNthCache _domNthCache_A = new domNthCache();
    domNthCache _domNthCache_B = new domNthCache();

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface ChangeListener {
        ChangeListener getNextChangeListener();

        void notifyChange();

        void setNextChangeListener(ChangeListener changeListener);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class DefaultEntityResolver implements EntityResolver {
        private DefaultEntityResolver() {
        }

        @Override // org.xml.sax.EntityResolver
        public InputSource resolveEntity(String str, String str2) {
            return new InputSource(new StringReader(""));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class DefaultQNameFactory implements QNameFactory {
        private final QNameCache _cache;

        private DefaultQNameFactory() {
            this._cache = XmlBeans.getQNameCache();
        }

        @Override // org.apache.xmlbeans.impl.store.QNameFactory
        public QName getQName(String str, String str2) {
            return this._cache.getName(str, str2, "");
        }

        @Override // org.apache.xmlbeans.impl.store.QNameFactory
        public QName getQName(String str, String str2, String str3) {
            return this._cache.getName(str, str2, str3);
        }

        @Override // org.apache.xmlbeans.impl.store.QNameFactory
        public QName getQName(char[] cArr, int i5, int i6, char[] cArr2, int i7, int i8) {
            return this._cache.getName(new String(cArr, i5, i6), new String(cArr2, i7, i8), "");
        }

        @Override // org.apache.xmlbeans.impl.store.QNameFactory
        public QName getQName(char[] cArr, int i5, int i6, char[] cArr2, int i7, int i8, char[] cArr3, int i9, int i10) {
            return this._cache.getName(new String(cArr, i5, i6), new String(cArr2, i7, i8), new String(cArr3, i9, i10));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class DocProps extends XmlDocumentProperties {
        private final HashMap<Object, Object> _map;

        private DocProps() {
            this._map = new HashMap<>();
        }

        @Override // org.apache.xmlbeans.XmlDocumentProperties
        public Object get(Object obj) {
            return this._map.get(obj);
        }

        @Override // org.apache.xmlbeans.XmlDocumentProperties
        public Object put(Object obj, Object obj2) {
            return this._map.put(obj, obj2);
        }

        @Override // org.apache.xmlbeans.XmlDocumentProperties
        public Object remove(Object obj) {
            return this._map.remove(obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static abstract class LoadContext {
        private Hashtable<String, String> _idAttrs;

        public abstract void abort();

        public void addIdAttr(String str, String str2) {
            if (this._idAttrs == null) {
                this._idAttrs = new Hashtable<>();
            }
            this._idAttrs.put(str2, str);
        }

        public abstract void attr(String str, String str2, String str3, String str4);

        public abstract void attr(QName qName, String str);

        public abstract void bookmark(XmlCursor.XmlBookmark xmlBookmark);

        public abstract void bookmarkLastAttr(QName qName, XmlCursor.XmlBookmark xmlBookmark);

        public abstract void bookmarkLastNonAttr(XmlCursor.XmlBookmark xmlBookmark);

        public abstract void comment(String str);

        public abstract void comment(char[] cArr, int i5, int i6);

        public abstract void endDTD();

        public abstract void endElement();

        public abstract Cur finish();

        public boolean isAttrOfTypeId(QName qName, QName qName2) {
            if (this._idAttrs == null) {
                return "id".equalsIgnoreCase(qName.getLocalPart());
            }
            String prefix = qName.getPrefix();
            String localPart = qName.getLocalPart();
            if (!"".equals(prefix)) {
                localPart = androidx.collection.a.o(prefix, ParameterizedMessage.ERROR_MSG_SEPARATOR, localPart);
            }
            String str = this._idAttrs.get(localPart);
            if (str == null) {
                return false;
            }
            String prefix2 = qName2.getPrefix();
            String localPart2 = qName2.getLocalPart();
            if (!"".equals(prefix2)) {
                localPart2 = androidx.collection.a.o(prefix2, ParameterizedMessage.ERROR_MSG_SEPARATOR, localPart2);
            }
            return str.equals(localPart2);
        }

        public abstract void lineNumber(int i5, int i6, int i7);

        public abstract void procInst(String str, String str2);

        public abstract void startDTD(String str, String str2, String str3);

        public abstract void startElement(QName qName);

        public abstract void text(String str);

        public abstract void text(char[] cArr, int i5, int i6);

        public abstract void xmlns(String str, String str2);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Ref extends PhantomReference {
        Cur _cur;

        public Ref(Cur cur, Object obj) {
            super(obj, cur._locale.refQueue());
            this._cur = cur;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class ScrubBuffer {
        private static final int NOSPACE_STATE = 2;
        private static final int SPACE_SEEN_STATE = 1;
        private static final int START_STATE = 0;
        private int _state;
        private int _wsr;
        private char[] _srcBuf = new char[1024];
        private final StringBuffer _sb = new StringBuffer();

        public String getResultAsString() {
            return this._sb.toString();
        }

        public void init(int i5) {
            StringBuffer stringBuffer = this._sb;
            stringBuffer.delete(0, stringBuffer.length());
            this._wsr = i5;
            this._state = 0;
        }

        public void scrub(Object obj, int i5, int i6) {
            char[] cArr;
            if (i6 == 0) {
                return;
            }
            if (this._wsr == 1) {
                CharUtil.getString(this._sb, obj, i5, i6);
                return;
            }
            if (obj instanceof char[]) {
                cArr = (char[]) obj;
            } else {
                char[] cArr2 = this._srcBuf;
                if (i6 > cArr2.length) {
                    if (i6 <= 16384) {
                        cArr2 = new char[16384];
                        this._srcBuf = cArr2;
                    } else {
                        cArr2 = new char[i6];
                    }
                }
                CharUtil.getChars(cArr2, 0, obj, i5, i6);
                cArr = cArr2;
                i5 = 0;
            }
            int i7 = 0;
            for (int i8 = 0; i8 < i6; i8++) {
                char c = cArr[i5 + i8];
                if (c == ' ' || c == '\n' || c == '\r' || c == '\t') {
                    this._sb.append(cArr, i5 + i7, i8 - i7);
                    i7 = i8 + 1;
                    if (this._wsr == 2) {
                        this._sb.append(Chars.SPACE);
                    } else if (this._state == 2) {
                        this._state = 1;
                    }
                } else {
                    if (this._state == 1) {
                        this._sb.append(Chars.SPACE);
                    }
                    this._state = 2;
                }
            }
            this._sb.append(cArr, i5 + i7, i6 - i7);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface SyncWrapFun<T> {
        T parse(Locale locale);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class XmlReaderSaxLoader extends SaxLoader {
        public XmlReaderSaxLoader(XMLReader xMLReader) {
            super(xMLReader, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class XmlSaxHandlerImpl extends SaxHandler implements XmlSaxHandler {
        private final XmlOptions _options;
        private final SchemaType _type;

        public XmlSaxHandlerImpl(Locale locale, SchemaType schemaType, XmlOptions xmlOptions) {
            super(null);
            this._options = xmlOptions;
            this._type = schemaType;
            XmlOptions xmlOptions2 = new XmlOptions(xmlOptions);
            xmlOptions2.setLoadUseLocaleCharUtil(true);
            initSaxHandler(locale, xmlOptions2);
        }

        @Override // org.apache.xmlbeans.XmlSaxHandler
        public void bookmarkLastAttr(QName qName, XmlCursor.XmlBookmark xmlBookmark) {
            this._context.bookmarkLastAttr(qName, xmlBookmark);
        }

        @Override // org.apache.xmlbeans.XmlSaxHandler
        public void bookmarkLastEvent(XmlCursor.XmlBookmark xmlBookmark) {
            this._context.bookmarkLastNonAttr(xmlBookmark);
        }

        @Override // org.apache.xmlbeans.XmlSaxHandler
        public ContentHandler getContentHandler() {
            if (this._context == null) {
                return null;
            }
            return this;
        }

        @Override // org.apache.xmlbeans.XmlSaxHandler
        public LexicalHandler getLexicalHandler() {
            if (this._context == null) {
                return null;
            }
            return this;
        }

        @Override // org.apache.xmlbeans.XmlSaxHandler
        public XmlObject getObject() {
            if (this._context == null) {
                return null;
            }
            this._locale.enter();
            try {
                Cur curFinish = this._context.finish();
                Locale.autoTypeDocument(curFinish, this._type, this._options);
                XmlObject xmlObject = (XmlObject) curFinish.getUser();
                curFinish.release();
                this._context = null;
                return xmlObject;
            } finally {
                this._locale.exit();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class domNthCache {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        public static final int BLITZ_BOUNDARY = 40;
        private DomImpl.Dom _child;
        private int _len;
        private int _n;
        private DomImpl.Dom _parent;
        private long _version;

        public domNthCache() {
        }

        public int distance(DomImpl.Dom dom, int i5) {
            if (this._version != Locale.this.version()) {
                return 2147483646;
            }
            if (dom != this._parent) {
                return Integer.MAX_VALUE;
            }
            int i6 = this._n;
            return i5 > i6 ? i5 - i6 : i6 - i5;
        }

        public DomImpl.Dom fetch(DomImpl.Dom dom, int i5) {
            if (this._version != Locale.this.version() || this._parent != dom) {
                this._parent = dom;
                this._version = Locale.this.version();
                this._child = null;
                this._n = -1;
                this._len = -1;
                Node nodeFirstChild = DomImpl.firstChild(this._parent);
                while (true) {
                    DomImpl.Dom dom2 = (DomImpl.Dom) nodeFirstChild;
                    if (dom2 == null) {
                        break;
                    }
                    int i6 = this._n + 1;
                    this._n = i6;
                    if (this._child == null && i5 == i6) {
                        this._child = dom2;
                        break;
                    }
                    nodeFirstChild = DomImpl.nextSibling(dom2);
                }
                return this._child;
            }
            int i7 = this._n;
            if (i7 < 0) {
                return null;
            }
            if (i5 > i7) {
                while (i5 > this._n) {
                    DomImpl.Dom dom3 = (DomImpl.Dom) DomImpl.nextSibling(this._child);
                    if (dom3 == null) {
                        return null;
                    }
                    this._child = dom3;
                    this._n++;
                }
            } else if (i5 < i7) {
                while (i5 < this._n) {
                    DomImpl.Dom dom4 = (DomImpl.Dom) DomImpl.prevSibling(this._child);
                    if (dom4 == null) {
                        return null;
                    }
                    this._child = dom4;
                    this._n--;
                }
            }
            return this._child;
        }

        public int length(DomImpl.Dom dom) {
            int i5;
            if (this._version != Locale.this.version() || this._parent != dom) {
                this._parent = dom;
                this._version = Locale.this.version();
                this._child = null;
                this._n = -1;
                this._len = -1;
            }
            if (this._len == -1) {
                DomImpl.Dom dom2 = this._child;
                if (dom2 == null || (i5 = this._n) == -1) {
                    dom2 = (DomImpl.Dom) DomImpl.firstChild(this._parent);
                    this._len = 0;
                    this._child = dom2;
                    this._n = 0;
                } else {
                    this._len = i5;
                }
                while (dom2 != null) {
                    this._len++;
                    dom2 = (DomImpl.Dom) DomImpl.nextSibling(dom2);
                }
            }
            return this._len;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class nthCache {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private Xobj _child;
        private int _n;
        private QName _name;
        private Xobj _parent;
        private QNameSet _set;
        private long _version;

        public nthCache() {
        }

        private boolean cacheSame(QName qName, QNameSet qNameSet) {
            return qNameSet == null ? namesSame(qName, this._name) : setsSame(qNameSet, this._set);
        }

        private boolean nameHit(QName qName, QNameSet qNameSet, QName qName2) {
            return qNameSet == null ? namesSame(qName, qName2) : qNameSet.contains(qName2);
        }

        private boolean namesSame(QName qName, QName qName2) {
            return qName == null || qName.equals(qName2);
        }

        private boolean setsSame(QNameSet qNameSet, QNameSet qNameSet2) {
            return qNameSet != null && qNameSet == qNameSet2;
        }

        public int distance(Xobj xobj, QName qName, QNameSet qNameSet, int i5) {
            if (this._version != Locale.this.version()) {
                return 2147483646;
            }
            if (xobj != this._parent || !cacheSame(qName, qNameSet)) {
                return Integer.MAX_VALUE;
            }
            int i6 = this._n;
            return i5 > i6 ? i5 - i6 : i6 - i5;
        }

        public Xobj fetch(Xobj xobj, QName qName, QNameSet qNameSet, int i5) {
            if (this._version != Locale.this.version() || this._parent != xobj || !cacheSame(qName, qNameSet) || i5 == 0) {
                this._version = Locale.this.version();
                this._parent = xobj;
                this._name = qName;
                this._child = null;
                this._n = -1;
                for (Xobj xobj2 = xobj._firstChild; xobj2 != null; xobj2 = xobj2._nextSibling) {
                    if (xobj2.isElem() && nameHit(qName, qNameSet, xobj2._name)) {
                        this._child = xobj2;
                        this._n = 0;
                        break;
                    }
                }
            }
            int i6 = this._n;
            if (i6 < 0) {
                return null;
            }
            if (i5 > i6) {
                while (i5 > this._n) {
                    Xobj xobj3 = this._child;
                    while (true) {
                        xobj3 = xobj3._nextSibling;
                        if (xobj3 == null) {
                            return null;
                        }
                        if (!xobj3.isElem() || !nameHit(qName, qNameSet, xobj3._name)) {
                        }
                    }
                    this._child = xobj3;
                    this._n++;
                }
            } else if (i5 < i6) {
                while (i5 < this._n) {
                    Xobj xobj4 = this._child;
                    while (true) {
                        xobj4 = xobj4._prevSibling;
                        if (xobj4 == null) {
                            return null;
                        }
                        if (!xobj4.isElem() || !nameHit(qName, qNameSet, xobj4._name)) {
                        }
                    }
                    this._child = xobj4;
                    this._n--;
                }
            }
            return this._child;
        }
    }

    private Locale(SchemaTypeLoader schemaTypeLoader, XmlOptions xmlOptions) {
        XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
        this._noSync = xmlOptionsMaskNull.isUnsynchronized();
        this._numTempFramesLeft = 8;
        this._tempFrames = new Cur[8];
        this._qnameFactory = new DefaultQNameFactory();
        this._locations = new Cur.Locations(this);
        this._schemaTypeLoader = schemaTypeLoader;
        this._validateOnSet = xmlOptionsMaskNull.isValidateOnSet();
        Saaj saaj = xmlOptionsMaskNull.getSaaj();
        this._saaj = saaj;
        if (saaj != null) {
            saaj.setCallback(this);
        }
    }

    private static void addNamespace(StringBuilder sb, QName qName) {
        if (qName.getNamespaceURI() == null) {
            sb.append("<no namespace>");
            return;
        }
        sb.append("\"");
        sb.append(qName.getNamespaceURI());
        sb.append("\"");
    }

    public static void applyNamespaces(Cur cur, Map<String, String> map) {
        for (String str : map.keySet()) {
            if (!str.toLowerCase(java.util.Locale.ROOT).startsWith("xml") && cur.namespaceForPrefix(str, false) == null) {
                cur.push();
                cur.next();
                cur.createAttr(cur._locale.createXmlns(str));
                cur.next();
                cur.insertString(map.get(str));
                cur.pop();
            }
        }
    }

    public static String applyWhiteSpaceRule(String str, int i5) {
        boolean z6 = false;
        int length = str == null ? 0 : str.length();
        if (length == 0) {
            return str;
        }
        int i6 = 1;
        if (i5 == 1) {
            return str;
        }
        if (i5 == 2) {
            for (int i7 = 0; i7 < length; i7++) {
                char cCharAt = str.charAt(i7);
                if (cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t') {
                    return processWhiteSpaceRule(str, i5);
                }
            }
            return str;
        }
        if (i5 != 3) {
            return str;
        }
        if (CharUtil.isWhiteSpace(str.charAt(0)) || CharUtil.isWhiteSpace(str.charAt(length - 1))) {
            return processWhiteSpaceRule(str, i5);
        }
        while (i6 < length) {
            boolean zIsWhiteSpace = CharUtil.isWhiteSpace(str.charAt(i6));
            if (zIsWhiteSpace && z6) {
                return processWhiteSpaceRule(str, i5);
            }
            i6++;
            z6 = zIsWhiteSpace;
        }
        return str;
    }

    public static void associateSourceName(Cur cur, XmlOptions xmlOptions) {
        String documentSourceName = xmlOptions == null ? null : xmlOptions.getDocumentSourceName();
        if (documentSourceName != null) {
            getDocProps(cur, true).setSourceName(documentSourceName);
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0030  */
    public static void autoTypeDocument(Cur cur, SchemaType schemaType, XmlOptions xmlOptions) {
        SchemaType schemaTypeFindType;
        SchemaType documentType = XmlOptions.maskNull(xmlOptions).getDocumentType();
        if (documentType != null) {
            cur.setType(documentType);
            return;
        }
        SchemaType schemaTypeFindAttributeType = null;
        if (schemaType == null || schemaType.getName() != null) {
            QName xsiTypeName = cur.getXsiTypeName();
            schemaTypeFindType = xsiTypeName == null ? null : cur._locale._schemaTypeLoader.findType(xsiTypeName);
            if (schemaType != null && !schemaType.isAssignableFrom(schemaTypeFindType)) {
                schemaTypeFindType = null;
            }
        } else {
            schemaTypeFindType = null;
        }
        if (schemaTypeFindType == null && (schemaType == null || schemaType.isDocumentType())) {
            cur.push();
            QName name = (cur.hasAttrs() || !toFirstChildElement(cur) || toNextSiblingElement(cur)) ? null : cur.getName();
            cur.pop();
            if (name != null && (schemaTypeFindType = cur._locale._schemaTypeLoader.findDocumentType(name)) != null && schemaType != null) {
                QName documentElementName = schemaType.getDocumentElementName();
                if (!documentElementName.equals(name) && !schemaType.isValidSubstitution(name)) {
                    throw new XmlException("Element " + QNameHelper.pretty(name) + " is not a valid " + QNameHelper.pretty(documentElementName) + " document or a valid substitution.");
                }
            }
        }
        if (schemaTypeFindType == null && schemaType == null) {
            cur.push();
            if (toFirstNormalAttr(cur) && !toNextNormalAttr(cur)) {
                schemaTypeFindAttributeType = cur._locale._schemaTypeLoader.findAttributeType(cur.getName());
            }
            cur.pop();
            schemaTypeFindType = schemaTypeFindAttributeType;
        }
        if (schemaTypeFindType == null) {
            schemaTypeFindType = schemaType;
        }
        if (schemaTypeFindType == null) {
            schemaTypeFindType = XmlBeans.NO_TYPE;
        }
        cur.setType(schemaTypeFindType);
        if (schemaType != null) {
            if (schemaTypeFindType.isDocumentType()) {
                verifyDocumentType(cur, schemaTypeFindType.getDocumentElementName());
            } else if (schemaTypeFindType.isAttributeType()) {
                verifyAttributeType(cur, schemaTypeFindType.getAttributeTypeAttributeName());
            }
        }
    }

    public static boolean beginsWithXml(String str) {
        char cCharAt;
        char cCharAt2;
        char cCharAt3;
        return str.length() >= 3 && ((cCharAt = str.charAt(0)) == 'x' || cCharAt == 'X') && (((cCharAt2 = str.charAt(1)) == 'm' || cCharAt2 == 'M') && ((cCharAt3 = str.charAt(2)) == 'l' || cCharAt3 == 'L'));
    }

    private static DomImpl.Dom checkNode(Node node) {
        if (node == null) {
            throw new IllegalArgumentException("Node is null");
        }
        if (node instanceof DomImpl.Dom) {
            return (DomImpl.Dom) node;
        }
        throw new IllegalArgumentException("Node is not an XmlBeans node");
    }

    public static void clearThreadLocals() {
        tl_scrubBuffer.remove();
    }

    private void doAttributes(XMLStreamReader xMLStreamReader, LoadContext loadContext) {
        int attributeCount = xMLStreamReader.getAttributeCount();
        for (int i5 = 0; i5 < attributeCount; i5++) {
            loadContext.attr(xMLStreamReader.getAttributeLocalName(i5), xMLStreamReader.getAttributeNamespace(i5), xMLStreamReader.getAttributePrefix(i5), xMLStreamReader.getAttributeValue(i5));
        }
    }

    private void doNamespaces(XMLStreamReader xMLStreamReader, LoadContext loadContext) {
        int namespaceCount = xMLStreamReader.getNamespaceCount();
        for (int i5 = 0; i5 < namespaceCount; i5++) {
            String namespacePrefix = xMLStreamReader.getNamespacePrefix(i5);
            if (namespacePrefix == null || namespacePrefix.length() == 0) {
                loadContext.attr(Sax2Dom.XMLNS_PREFIX, "http://www.w3.org/2000/xmlns/", null, xMLStreamReader.getNamespaceURI(i5));
            } else {
                loadContext.attr(namespacePrefix, "http://www.w3.org/2000/xmlns/", Sax2Dom.XMLNS_PREFIX, xMLStreamReader.getNamespaceURI(i5));
            }
        }
    }

    public static Map<String, String> getAllNamespaces(Cur cur, Map<String, String> map) {
        cur.push();
        if (!cur.isContainer()) {
            cur.toParent();
        }
        while (true) {
            if (!cur.toNextAttr()) {
                if (!cur.isContainer()) {
                    cur.toParentRaw();
                }
                if (!cur.toParentRaw()) {
                    cur.pop();
                    return map;
                }
            } else if (cur.isXmlns()) {
                String xmlnsPrefix = cur.getXmlnsPrefix();
                String xmlnsUri = cur.getXmlnsUri();
                if (map == null) {
                    map = new HashMap<>();
                }
                if (!map.containsKey(xmlnsPrefix)) {
                    map.put(xmlnsPrefix, xmlnsUri);
                }
            }
        }
    }

    public static XmlDocumentProperties getDocProps(Cur cur, boolean z6) {
        cur.push();
        while (cur.toParent()) {
        }
        DocProps docProps = (DocProps) cur.getBookmark(DocProps.class);
        if (docProps == null && z6) {
            docProps = new DocProps();
            cur.setBookmark(DocProps.class, docProps);
        }
        cur.pop();
        return docProps;
    }

    public static Locale getLocale(SchemaTypeLoader schemaTypeLoader, XmlOptions xmlOptions) {
        Locale locale;
        if (schemaTypeLoader == null) {
            schemaTypeLoader = XmlBeans.getContextTypeLoader();
        }
        XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
        Object useSameLocale = xmlOptionsMaskNull.getUseSameLocale();
        if (useSameLocale == null) {
            return new Locale(schemaTypeLoader, xmlOptionsMaskNull);
        }
        if (useSameLocale instanceof Locale) {
            locale = (Locale) useSameLocale;
        } else {
            if (!(useSameLocale instanceof XmlTokenSource)) {
                throw new IllegalArgumentException(androidx.collection.a.l(useSameLocale, "Source locale not understood: "));
            }
            locale = (Locale) ((XmlTokenSource) useSameLocale).monitor();
        }
        if (locale._schemaTypeLoader != schemaTypeLoader) {
            throw new IllegalArgumentException("Source locale does not support same schema type loader");
        }
        Saaj saaj = locale._saaj;
        if (saaj != null && saaj != xmlOptionsMaskNull.getSaaj()) {
            throw new IllegalArgumentException("Source locale does not support same saaj");
        }
        if (!locale._validateOnSet || xmlOptionsMaskNull.isValidateOnSet()) {
            return locale;
        }
        throw new IllegalArgumentException("Source locale does not support same validate on set");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static SaxLoader getSaxLoader(XmlOptions xmlOptions) throws XmlException {
        XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
        EntityResolver entityResolver = null;
        Object[] objArr = 0;
        if (!xmlOptionsMaskNull.isLoadUseDefaultResolver()) {
            EntityResolver entityResolver2 = xmlOptionsMaskNull.getEntityResolver();
            if (entityResolver2 == null) {
                entityResolver2 = ResolverUtil.getGlobalEntityResolver();
            }
            if (entityResolver2 == null) {
                entityResolver2 = new DefaultEntityResolver();
            }
            entityResolver = entityResolver2;
        }
        XMLReader loadUseXMLReader = xmlOptionsMaskNull.getLoadUseXMLReader();
        if (loadUseXMLReader == null) {
            try {
                loadUseXMLReader = SAXHelper.newXMLReader(new XmlOptions(xmlOptionsMaskNull));
            } catch (Exception e) {
                throw new XmlException("Problem creating XMLReader", e);
            }
        }
        XmlReaderSaxLoader xmlReaderSaxLoader = new XmlReaderSaxLoader(loadUseXMLReader);
        if (entityResolver != null) {
            loadUseXMLReader.setEntityResolver(entityResolver);
        }
        return xmlReaderSaxLoader;
    }

    public static ScrubBuffer getScrubBuffer(int i5) {
        ThreadLocal<SoftReference<ScrubBuffer>> threadLocal = tl_scrubBuffer;
        ScrubBuffer scrubBuffer = threadLocal.get().get();
        if (scrubBuffer == null) {
            scrubBuffer = new ScrubBuffer();
            threadLocal.set(new SoftReference<>(scrubBuffer));
        }
        scrubBuffer.init(i5);
        return scrubBuffer;
    }

    public static String getTextValue(Cur cur) {
        if (!cur.hasChildren()) {
            return cur.getValueAsString();
        }
        StringBuffer stringBuffer = new StringBuffer();
        cur.push();
        while (true) {
            cur.next();
            if (cur.isAtEndOfLastPush()) {
                cur.pop();
                return stringBuffer.toString();
            }
            if (cur.isText() && ((!cur._xobj.isComment() && !cur._xobj.isProcinst()) || cur._pos >= cur._xobj._cchValue)) {
                CharUtil.getString(stringBuffer, cur.getChars(-1), cur._offSrc, cur._cchSrc);
            }
        }
    }

    public static boolean isFragment(Cur cur, Cur cur2) {
        boolean z6;
        int iKind;
        cur.push();
        cur2.push();
        int i5 = 0;
        while (true) {
            if (cur.isSamePos(cur2) || (iKind = cur.kind()) == 3) {
                z6 = false;
            } else if ((iKind != 0 || isWhiteSpace(cur.getCharsAsString())) && (iKind != 2 || (i5 = i5 + 1) <= 1)) {
                if (iKind != 0) {
                    cur.toEnd();
                }
                cur.next();
            } else {
                z6 = true;
            }
            cur.pop();
            cur2.pop();
            return z6 || i5 != 1;
        }
    }

    public static boolean isFragmentQName(QName qName) {
        return qName.equals(_openuriFragment) || qName.equals(_xmlFragment);
    }

    public static boolean isWhiteSpace(String str) {
        int length = str.length();
        while (true) {
            int i5 = length - 1;
            if (length <= 0) {
                return true;
            }
            if (!CharUtil.isWhiteSpace(str.charAt(i5))) {
                return false;
            }
            length = i5;
        }
    }

    public static boolean isXmlns(QName qName) {
        String prefix = qName.getPrefix();
        if (prefix.equals(Sax2Dom.XMLNS_PREFIX)) {
            return true;
        }
        return prefix.length() == 0 && qName.getLocalPart().equals(Sax2Dom.XMLNS_PREFIX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XmlObject lambda$newInstance$0(XmlOptions xmlOptions, SchemaType schemaType, Locale locale) {
        Cur curTempCur = locale.tempCur();
        SchemaType documentType = XmlOptions.maskNull(xmlOptions).getDocumentType();
        if (documentType == null) {
            if (schemaType == null) {
                schemaType = XmlObject.type;
            }
            documentType = schemaType;
        }
        if (documentType.isDocumentType()) {
            curTempCur.createDomDocumentRoot();
        } else {
            curTempCur.createRoot();
        }
        curTempCur.setType(documentType);
        XmlObject xmlObject = (XmlObject) curTempCur.getUser();
        curTempCur.release();
        return xmlObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XmlSaxHandlerImpl lambda$newSaxHandler$6(SchemaType schemaType, XmlOptions xmlOptions, Locale locale) {
        return new XmlSaxHandlerImpl(locale, schemaType, xmlOptions);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XmlObject lambda$parseToXmlObject$1(String str, XmlOptions xmlOptions, SchemaType schemaType, Locale locale) throws IOException {
        StringReader stringReader = new StringReader(str);
        try {
            Cur curLoad = getSaxLoader(xmlOptions).load(locale, new InputSource(stringReader), xmlOptions);
            autoTypeDocument(curLoad, schemaType, xmlOptions);
            XmlObject xmlObject = (XmlObject) curLoad.getUser();
            curLoad.release();
            stringReader.close();
            return xmlObject;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    stringReader.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XmlObject lambda$parseToXmlObject$2(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions, SchemaType schemaType, Locale locale) throws XmlException {
        try {
            Cur curLoadXMLStreamReader = locale.loadXMLStreamReader(xMLStreamReader, xmlOptions);
            autoTypeDocument(curLoadXMLStreamReader, schemaType, xmlOptions);
            XmlObject xmlObject = (XmlObject) curLoadXMLStreamReader.getUser();
            curLoadXMLStreamReader.release();
            return xmlObject;
        } catch (XMLStreamException e) {
            throw new XmlException(e.getMessage(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XmlObject lambda$parseToXmlObject$3(XmlOptions xmlOptions, InputStream inputStream, SchemaType schemaType, Locale locale) throws XmlException, IOException {
        Cur curLoad = getSaxLoader(xmlOptions).load(locale, new InputSource(inputStream), xmlOptions);
        autoTypeDocument(curLoad, schemaType, xmlOptions);
        XmlObject xmlObject = (XmlObject) curLoad.getUser();
        curLoad.release();
        return xmlObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XmlObject lambda$parseToXmlObject$4(XmlOptions xmlOptions, Reader reader, SchemaType schemaType, Locale locale) throws XmlException, IOException {
        Cur curLoad = getSaxLoader(xmlOptions).load(locale, new InputSource(reader), xmlOptions);
        autoTypeDocument(curLoad, schemaType, xmlOptions);
        XmlObject xmlObject = (XmlObject) curLoad.getUser();
        curLoad.release();
        return xmlObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XmlObject lambda$parseToXmlObject$5(XmlOptions xmlOptions, Node node, SchemaType schemaType, Locale locale) {
        Cur.CurLoadContext curLoadContext = new Cur.CurLoadContext(locale, xmlOptions);
        locale.loadNode(node, curLoadContext);
        Cur curFinish = curLoadContext.finish();
        associateSourceName(curFinish, xmlOptions);
        autoTypeDocument(curFinish, schemaType, xmlOptions);
        XmlObject xmlObject = (XmlObject) curFinish.getUser();
        curFinish.release();
        return xmlObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SoftReference lambda$static$7() {
        return new SoftReference(new ScrubBuffer());
    }

    private static void lineNumber(XMLStreamReader xMLStreamReader, LoadContext loadContext) {
        Location location = xMLStreamReader.getLocation();
        if (location != null) {
            loadContext.lineNumber(location.getLineNumber(), location.getColumnNumber(), location.getCharacterOffset());
        }
    }

    private DomImpl.Dom load(InputSource inputSource, XmlOptions xmlOptions) {
        return getSaxLoader(xmlOptions).load(this, inputSource, xmlOptions).getDom();
    }

    private void loadNodeChildren(Node node, LoadContext loadContext) {
        for (Node firstChild = node.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            loadNode(firstChild, loadContext);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:33:0x00ae A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:40:0x00b7 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    private Cur loadXMLStreamReader(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
        XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
        boolean zIsLoadLineNumbers = xmlOptionsMaskNull.isLoadLineNumbers();
        Cur.CurLoadContext curLoadContext = new Cur.CurLoadContext(this, xmlOptionsMaskNull);
        int eventType = xMLStreamReader.getEventType();
        String str = null;
        int i5 = 0;
        boolean z6 = false;
        String str2 = null;
        while (true) {
            switch (eventType) {
                case 1:
                    i5++;
                    curLoadContext.startElement(xMLStreamReader.getName());
                    if (zIsLoadLineNumbers) {
                        lineNumber(xMLStreamReader, curLoadContext);
                    }
                    doAttributes(xMLStreamReader, curLoadContext);
                    doNamespaces(xMLStreamReader, curLoadContext);
                    if (xMLStreamReader.hasNext() || i5 <= 0) {
                        Cur curFinish = curLoadContext.finish();
                        associateSourceName(curFinish, xmlOptionsMaskNull);
                        XmlDocumentProperties docProps = getDocProps(curFinish, true);
                        docProps.setEncoding(str);
                        docProps.setVersion(str2);
                        docProps.setStandalone(z6);
                        return curFinish;
                    }
                    eventType = xMLStreamReader.next();
                    break;
                case 2:
                    i5--;
                    curLoadContext.endElement();
                    if (zIsLoadLineNumbers) {
                        lineNumber(xMLStreamReader, curLoadContext);
                    }
                    if (xMLStreamReader.hasNext()) {
                    }
                    Cur curFinish2 = curLoadContext.finish();
                    associateSourceName(curFinish2, xmlOptionsMaskNull);
                    XmlDocumentProperties docProps2 = getDocProps(curFinish2, true);
                    docProps2.setEncoding(str);
                    docProps2.setVersion(str2);
                    docProps2.setStandalone(z6);
                    return curFinish2;
                case 3:
                    curLoadContext.procInst(xMLStreamReader.getPITarget(), xMLStreamReader.getPIData());
                    if (zIsLoadLineNumbers) {
                        lineNumber(xMLStreamReader, curLoadContext);
                    }
                    if (xMLStreamReader.hasNext()) {
                    }
                    Cur curFinish3 = curLoadContext.finish();
                    associateSourceName(curFinish3, xmlOptionsMaskNull);
                    XmlDocumentProperties docProps3 = getDocProps(curFinish3, true);
                    docProps3.setEncoding(str);
                    docProps3.setVersion(str2);
                    docProps3.setStandalone(z6);
                    return curFinish3;
                case 4:
                case 12:
                    curLoadContext.text(xMLStreamReader.getTextCharacters(), xMLStreamReader.getTextStart(), xMLStreamReader.getTextLength());
                    if (zIsLoadLineNumbers) {
                        lineNumber(xMLStreamReader, curLoadContext);
                    }
                    if (xMLStreamReader.hasNext()) {
                    }
                    Cur curFinish4 = curLoadContext.finish();
                    associateSourceName(curFinish4, xmlOptionsMaskNull);
                    XmlDocumentProperties docProps4 = getDocProps(curFinish4, true);
                    docProps4.setEncoding(str);
                    docProps4.setVersion(str2);
                    docProps4.setStandalone(z6);
                    return curFinish4;
                case 5:
                    curLoadContext.comment(xMLStreamReader.getText());
                    if (zIsLoadLineNumbers) {
                        lineNumber(xMLStreamReader, curLoadContext);
                    }
                    if (xMLStreamReader.hasNext()) {
                    }
                    Cur curFinish5 = curLoadContext.finish();
                    associateSourceName(curFinish5, xmlOptionsMaskNull);
                    XmlDocumentProperties docProps5 = getDocProps(curFinish5, true);
                    docProps5.setEncoding(str);
                    docProps5.setVersion(str2);
                    docProps5.setStandalone(z6);
                    return curFinish5;
                case 6:
                case 11:
                    if (xMLStreamReader.hasNext()) {
                    }
                    Cur curFinish6 = curLoadContext.finish();
                    associateSourceName(curFinish6, xmlOptionsMaskNull);
                    XmlDocumentProperties docProps6 = getDocProps(curFinish6, true);
                    docProps6.setEncoding(str);
                    docProps6.setVersion(str2);
                    docProps6.setStandalone(z6);
                    return curFinish6;
                case 7:
                    i5++;
                    String characterEncodingScheme = xMLStreamReader.getCharacterEncodingScheme();
                    String version = xMLStreamReader.getVersion();
                    boolean zIsStandalone = xMLStreamReader.isStandalone();
                    if (zIsLoadLineNumbers) {
                        lineNumber(xMLStreamReader, curLoadContext);
                    }
                    z6 = zIsStandalone;
                    str2 = version;
                    str = characterEncodingScheme;
                    if (xMLStreamReader.hasNext()) {
                    }
                    Cur curFinish7 = curLoadContext.finish();
                    associateSourceName(curFinish7, xmlOptionsMaskNull);
                    XmlDocumentProperties docProps7 = getDocProps(curFinish7, true);
                    docProps7.setEncoding(str);
                    docProps7.setVersion(str2);
                    docProps7.setStandalone(z6);
                    return curFinish7;
                case 8:
                    if (zIsLoadLineNumbers) {
                        lineNumber(xMLStreamReader, curLoadContext);
                    }
                    Cur curFinish8 = curLoadContext.finish();
                    associateSourceName(curFinish8, xmlOptionsMaskNull);
                    XmlDocumentProperties docProps8 = getDocProps(curFinish8, true);
                    docProps8.setEncoding(str);
                    docProps8.setVersion(str2);
                    docProps8.setStandalone(z6);
                    return curFinish8;
                case 9:
                    curLoadContext.text(xMLStreamReader.getText());
                    if (xMLStreamReader.hasNext()) {
                    }
                    Cur curFinish9 = curLoadContext.finish();
                    associateSourceName(curFinish9, xmlOptionsMaskNull);
                    XmlDocumentProperties docProps9 = getDocProps(curFinish9, true);
                    docProps9.setEncoding(str);
                    docProps9.setVersion(str2);
                    docProps9.setStandalone(z6);
                    return curFinish9;
                case 10:
                    doAttributes(xMLStreamReader, curLoadContext);
                    if (xMLStreamReader.hasNext()) {
                    }
                    Cur curFinish10 = curLoadContext.finish();
                    associateSourceName(curFinish10, xmlOptionsMaskNull);
                    XmlDocumentProperties docProps10 = getDocProps(curFinish10, true);
                    docProps10.setEncoding(str);
                    docProps10.setVersion(str2);
                    docProps10.setStandalone(z6);
                    return curFinish10;
                case 13:
                    doNamespaces(xMLStreamReader, curLoadContext);
                    if (xMLStreamReader.hasNext()) {
                    }
                    Cur curFinish11 = curLoadContext.finish();
                    associateSourceName(curFinish11, xmlOptionsMaskNull);
                    XmlDocumentProperties docProps11 = getDocProps(curFinish11, true);
                    docProps11.setEncoding(str);
                    docProps11.setVersion(str2);
                    docProps11.setStandalone(z6);
                    return curFinish11;
                default:
                    throw new RuntimeException(AbstractC0157z.k(eventType, "Unhandled xml event type: "));
            }
        }
    }

    private static boolean namespacesSame(QName qName, QName qName2) {
        if (qName == qName2) {
            return true;
        }
        if (qName == null || qName2 == null) {
            return false;
        }
        return Objects.equals(qName.getNamespaceURI(), qName2.getNamespaceURI());
    }

    public static DOMImplementation newDomImplementation(SchemaTypeLoader schemaTypeLoader, XmlOptions xmlOptions) {
        return getLocale(schemaTypeLoader, xmlOptions);
    }

    public static XmlObject newInstance(SchemaTypeLoader schemaTypeLoader, SchemaType schemaType, XmlOptions xmlOptions) {
        try {
            return (XmlObject) syncWrap(schemaTypeLoader, xmlOptions, new j0(xmlOptions, schemaType));
        } catch (IOException | XmlException e) {
            throw new RuntimeException(e);
        }
    }

    public static XmlSaxHandler newSaxHandler(SchemaTypeLoader schemaTypeLoader, SchemaType schemaType, XmlOptions xmlOptions) {
        try {
            return (XmlSaxHandler) syncWrap(schemaTypeLoader, xmlOptions, new j0(schemaType, xmlOptions));
        } catch (IOException | XmlException e) {
            throw new RuntimeException(e);
        }
    }

    public static XmlCursor nodeToCursor(Node node) {
        return DomImpl._getXmlCursor(checkNode(node));
    }

    public static XmlObject nodeToXmlObject(Node node) {
        return DomImpl._getXmlObject(checkNode(node));
    }

    public static XMLStreamReader nodeToXmlStream(Node node) {
        return DomImpl._getXmlStreamReader(checkNode(node));
    }

    public static XmlObject parseToXmlObject(SchemaTypeLoader schemaTypeLoader, String str, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException {
        try {
            return (XmlObject) syncWrap(schemaTypeLoader, xmlOptions, new C1451l(str, xmlOptions, schemaType, 13));
        } catch (IOException e) {
            throw new XmlException(e.getMessage(), e);
        }
    }

    private void pollQueue() {
        if (this._refQueue == null) {
            return;
        }
        while (true) {
            Ref ref = (Ref) this._refQueue.poll();
            if (ref == null) {
                return;
            }
            Cur cur = ref._cur;
            if (cur != null) {
                cur.release();
            }
        }
    }

    public static String processWhiteSpaceRule(String str, int i5) {
        ScrubBuffer scrubBuffer = getScrubBuffer(i5);
        scrubBuffer.scrub(str, 0, str.length());
        return scrubBuffer.getResultAsString();
    }

    public static boolean pushToContainer(Cur cur) {
        cur.push();
        while (true) {
            int iKind = cur.kind();
            if (iKind == -2 || iKind == -1) {
                break;
            }
            if (iKind == 1 || iKind == 2) {
                return true;
            }
            if (iKind == 4 || iKind == 5) {
                cur.skip();
            } else {
                cur.nextWithAttrs();
            }
        }
        cur.pop();
        return false;
    }

    public static Node streamToNode(XMLStreamReader xMLStreamReader) {
        return Jsr173.nodeFromStream(xMLStreamReader);
    }

    private static <T> T syncWrap(SchemaTypeLoader schemaTypeLoader, XmlOptions xmlOptions, SyncWrapFun<T> syncWrapFun) {
        T t6;
        Locale locale = getLocale(schemaTypeLoader, xmlOptions);
        if (locale.noSync()) {
            locale.enter();
            try {
                return syncWrapFun.parse(locale);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    t6 = syncWrapFun.parse(locale);
                    locale.exit();
                } catch (Throwable th) {
                    locale.exit();
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return t6;
    }

    public static boolean toChild(Cur cur, QName qName, int i5) {
        if (i5 < 0 || !pushToContainer(cur)) {
            return false;
        }
        Xobj xobjFindNthChildElem = cur._locale.findNthChildElem(cur._xobj, qName, null, i5);
        cur.pop();
        if (xobjFindNthChildElem == null) {
            return false;
        }
        cur.moveTo(xobjFindNthChildElem);
        return true;
    }

    public static boolean toFirstChildElement(Cur cur) {
        Xobj xobj = cur._xobj;
        int i5 = cur._pos;
        while (true) {
            int iKind = cur.kind();
            if (iKind == -2 || iKind == -1) {
                break;
            }
            if (iKind == 1 || iKind == 2) {
                if (cur.toFirstChild() && (cur.isElem() || toNextSiblingElement(cur))) {
                    return true;
                }
                cur.moveTo(xobj, i5);
                return false;
            }
            if (iKind == 4 || iKind == 5) {
                cur.skip();
            } else {
                cur.nextWithAttrs();
            }
        }
        cur.moveTo(xobj, i5);
        return false;
    }

    public static boolean toFirstNormalAttr(Cur cur) {
        cur.push();
        if (cur.toFirstAttr()) {
            while (cur.isXmlns()) {
                if (!cur.toNextAttr()) {
                }
            }
            cur.popButStay();
            return true;
        }
        cur.pop();
        return false;
    }

    public static boolean toLastChildElement(Cur cur) {
        if (!pushToContainer(cur)) {
            return false;
        }
        if (cur.toLastChild() && (cur.isElem() || toPrevSiblingElement(cur))) {
            cur.popButStay();
            return true;
        }
        cur.pop();
        return false;
    }

    public static boolean toNextNormalAttr(Cur cur) {
        cur.push();
        while (cur.toNextAttr()) {
            if (!cur.isXmlns()) {
                cur.popButStay();
                return true;
            }
        }
        cur.pop();
        return false;
    }

    public static boolean toNextSiblingElement(Cur cur) {
        if (!cur.hasParent()) {
            return false;
        }
        cur.push();
        int iKind = cur.kind();
        if (iKind == 3) {
            cur.toParent();
            cur.next();
        } else if (iKind == 2) {
            cur.skip();
        }
        while (true) {
            int iKind2 = cur.kind();
            if (iKind2 < 0) {
                cur.pop();
                return false;
            }
            if (iKind2 == 2) {
                cur.popButStay();
                return true;
            }
            if (iKind2 > 0) {
                cur.toEnd();
            }
            cur.next();
        }
    }

    public static boolean toPrevNormalAttr(Cur cur) {
        if (!cur.isAttr()) {
            return false;
        }
        cur.push();
        while (cur.prev()) {
            cur.prev();
            if (!cur.isAttr()) {
                cur.prev();
            }
            if (cur.isNormalAttr()) {
                cur.popButStay();
                return true;
            }
        }
        cur.pop();
        return false;
    }

    public static boolean toPrevSiblingElement(Cur cur) {
        int iKind;
        boolean z6 = false;
        if (!cur.hasParent()) {
            return false;
        }
        Cur curTempCur = cur.tempCur();
        if (curTempCur.kind() != 3) {
            while (curTempCur.prev() && (iKind = curTempCur.kind()) != 1 && iKind != 2) {
                if (curTempCur.kind() == -2) {
                    curTempCur.toParent();
                    cur.moveToCur(curTempCur);
                    z6 = true;
                    break;
                }
            }
        }
        curTempCur.release();
        return z6;
    }

    private static void verifyAttributeType(Cur cur, QName qName) {
        StringBuilder sb;
        cur.push();
        try {
            if (!toFirstNormalAttr(cur) || toNextNormalAttr(cur)) {
                sb = new StringBuilder();
                sb.append("The document is not a ");
                sb.append(QNameHelper.pretty(qName));
                sb.append(cur.isRoot() ? ": no attributes" : ": multiple attributes");
            } else {
                QName name = cur.getName();
                if (name.equals(qName)) {
                    sb = null;
                } else {
                    sb = new StringBuilder();
                    sb.append("The document is not a ");
                    sb.append(QNameHelper.pretty(qName));
                    if (qName.getLocalPart().equals(name.getLocalPart())) {
                        sb.append(": attribute namespace mismatch ");
                        sb.append("expected ");
                        addNamespace(sb, qName);
                        sb.append(" got ");
                        addNamespace(sb, name);
                    } else if (namespacesSame(qName, name)) {
                        sb.append(": attribute local name mismatch ");
                        sb.append("expected ");
                        sb.append(qName.getLocalPart());
                        sb.append(" got ");
                        sb.append(name.getLocalPart());
                    } else {
                        sb.append(": attribute element mismatch ");
                        sb.append("got ");
                        sb.append(QNameHelper.pretty(name));
                    }
                }
            }
            if (sb == null) {
                cur.pop();
            } else {
                XmlError xmlErrorForCursor = XmlError.forCursor(sb.toString(), new Cursor(cur));
                throw new XmlException(xmlErrorForCursor.toString(), (Throwable) null, xmlErrorForCursor);
            }
        } catch (Throwable th) {
            cur.pop();
            throw th;
        }
    }

    private static void verifyDocumentType(Cur cur, QName qName) {
        StringBuilder sb;
        cur.push();
        try {
            if (!toFirstChildElement(cur) || toNextSiblingElement(cur)) {
                sb = new StringBuilder();
                sb.append("The document is not a ");
                sb.append(QNameHelper.pretty(qName));
                sb.append(cur.isRoot() ? ": no document element" : ": multiple document elements");
            } else {
                QName name = cur.getName();
                if (name.equals(qName)) {
                    sb = null;
                } else {
                    sb = new StringBuilder();
                    sb.append("The document is not a ");
                    sb.append(QNameHelper.pretty(qName));
                    if (qName.getLocalPart().equals(name.getLocalPart())) {
                        sb.append(": document element namespace mismatch ");
                        sb.append("expected ");
                        addNamespace(sb, qName);
                        sb.append(" got ");
                        addNamespace(sb, name);
                    } else if (namespacesSame(qName, name)) {
                        sb.append(": document element local name mismatch expected ");
                        sb.append(qName.getLocalPart());
                        sb.append(" got ");
                        sb.append(name.getLocalPart());
                    } else {
                        sb.append(": document element mismatch got ");
                        sb.append(QNameHelper.pretty(name));
                    }
                }
            }
            if (sb == null) {
                cur.pop();
            } else {
                XmlError xmlErrorForCursor = XmlError.forCursor(sb.toString(), new Cursor(cur));
                throw new XmlException(xmlErrorForCursor.toString(), (Throwable) null, xmlErrorForCursor);
            }
        } catch (Throwable th) {
            cur.pop();
            throw th;
        }
    }

    public static String xmlnsPrefix(QName qName) {
        return qName.getPrefix().equals(Sax2Dom.XMLNS_PREFIX) ? qName.getLocalPart() : "";
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0017  */
    public int count(Xobj xobj, QName qName, QNameSet qNameSet) {
        int i5 = 0;
        for (Xobj xobjFindNthChildElem = findNthChildElem(xobj, qName, qNameSet, 0); xobjFindNthChildElem != null; xobjFindNthChildElem = xobjFindNthChildElem._nextSibling) {
            if (xobjFindNthChildElem.isElem()) {
                if (qNameSet == null) {
                    if (xobjFindNthChildElem._name.equals(qName)) {
                        i5++;
                    }
                } else if (qNameSet.contains(xobjFindNthChildElem._name)) {
                    i5++;
                }
            }
        }
        return i5;
    }

    public CdataNode createCdataNode() {
        return this._saaj == null ? new CdataNode(this) : new SaajCdataNode(this);
    }

    @Override // org.w3c.dom.DOMImplementation
    public Document createDocument(String str, String str2, DocumentType documentType) {
        return DomImpl._domImplementation_createDocument(this, str, str2, documentType);
    }

    @Override // org.w3c.dom.DOMImplementation
    public DocumentType createDocumentType(String str, String str2, String str3) {
        throw new RuntimeException("Not implemented");
    }

    @Override // org.apache.xmlbeans.impl.store.Saaj.SaajCallback
    public Element createSoapElement(QName qName, QName qName2) {
        return DomImpl.saajCallback_createSoapElement(this._ownerDoc, qName, qName2);
    }

    public TextNode createTextNode() {
        return this._saaj == null ? new TextNode(this) : new SaajTextNode(this);
    }

    public QName createXmlns(String str) {
        if (str == null) {
            str = "";
        }
        return str.length() == 0 ? makeQName("http://www.w3.org/2000/xmlns/", Sax2Dom.XMLNS_PREFIX, "") : makeQName("http://www.w3.org/2000/xmlns/", str, Sax2Dom.XMLNS_PREFIX);
    }

    public int domLength(DomImpl.Dom dom) {
        if (dom == null) {
            return 0;
        }
        int iDistance = this._domNthCache_A.distance(dom, 0);
        int iDistance2 = this._domNthCache_B.distance(dom, 0);
        int length = iDistance <= iDistance2 ? this._domNthCache_A.length(dom) : this._domNthCache_B.length(dom);
        if (iDistance == iDistance2) {
            domNthCache domnthcache = this._domNthCache_A;
            this._domNthCache_A = this._domNthCache_B;
            this._domNthCache_B = domnthcache;
        }
        return length;
    }

    public void embedCurs() {
        while (true) {
            Cur cur = this._registered;
            if (cur == null) {
                return;
            }
            this._registered = cur.listRemove(cur);
            Xobj xobj = cur._xobj;
            xobj._embedded = cur.listInsert(xobj._embedded);
            cur._state = 2;
        }
    }

    public void enter(Locale locale) {
        enter();
        if (locale != this) {
            locale.enter();
        }
    }

    public boolean entered() {
        return this._tempFrames.length - this._numTempFramesLeft > 0;
    }

    public void exit(Locale locale) {
        exit();
        if (locale != this) {
            locale.exit();
        }
    }

    public DomImpl.Dom findDomNthChild(DomImpl.Dom dom, int i5) {
        DomImpl.Dom domFetch;
        if (dom == null) {
            return null;
        }
        int iDistance = this._domNthCache_A.distance(dom, i5);
        int iDistance2 = this._domNthCache_B.distance(dom, i5);
        boolean z6 = false;
        boolean z7 = iDistance2 - (this._domNthCache_B._len / 2) > 0 && (iDistance2 - (this._domNthCache_B._len / 2)) + (-40) > 0;
        if (iDistance - (this._domNthCache_A._len / 2) > 0 && (iDistance - (this._domNthCache_A._len / 2)) - 40 > 0) {
            z6 = true;
        }
        if (iDistance <= iDistance2) {
            if (z6) {
                this._domNthCache_B._version = -1L;
                domFetch = this._domNthCache_B.fetch(dom, i5);
            } else {
                domFetch = this._domNthCache_A.fetch(dom, i5);
            }
        } else if (z7) {
            this._domNthCache_A._version = -1L;
            domFetch = this._domNthCache_A.fetch(dom, i5);
        } else {
            domFetch = this._domNthCache_B.fetch(dom, i5);
        }
        if (iDistance == iDistance2) {
            domNthCache domnthcache = this._domNthCache_A;
            this._domNthCache_A = this._domNthCache_B;
            this._domNthCache_B = domnthcache;
        }
        return domFetch;
    }

    public Xobj findNthChildElem(Xobj xobj, QName qName, QNameSet qNameSet, int i5) {
        if (xobj == null) {
            return null;
        }
        int iDistance = this._nthCache_A.distance(xobj, qName, qNameSet, i5);
        int iDistance2 = this._nthCache_B.distance(xobj, qName, qNameSet, i5);
        Xobj xobjFetch = iDistance <= iDistance2 ? this._nthCache_A.fetch(xobj, qName, qNameSet, i5) : this._nthCache_B.fetch(xobj, qName, qNameSet, i5);
        if (iDistance == iDistance2) {
            nthCache nthcache = this._nthCache_A;
            this._nthCache_A = this._nthCache_B;
            this._nthCache_B = nthcache;
        }
        return xobjFetch;
    }

    public CharUtil getCharUtil() {
        if (this._charUtil == null) {
            this._charUtil = new CharUtil(1024);
        }
        return this._charUtil;
    }

    public Cur getCur() {
        Cur cur = this._curPool;
        if (cur == null) {
            cur = new Cur(this);
        } else {
            this._curPool = cur.listRemove(cur);
            this._curPoolCount--;
        }
        this._registered = cur.listInsert(this._registered);
        cur._state = 1;
        return cur;
    }

    @Override // org.w3c.dom.DOMImplementation
    public Object getFeature(String str, String str2) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.apache.xmlbeans.impl.store.Saaj.SaajCallback
    public Object getSaajData(Node node) {
        return DomImpl.saajCallback_getSaajData((DomImpl.Dom) node);
    }

    public SchemaTypeLoader getSchemaTypeLoader() {
        return this._schemaTypeLoader;
    }

    @Override // org.w3c.dom.DOMImplementation
    public boolean hasFeature(String str, String str2) {
        return DomImpl._domImplementation_hasFeature(this, str, str2);
    }

    @Override // org.apache.xmlbeans.impl.store.Saaj.SaajCallback
    public Element importSoapElement(Document document, Element element, boolean z6, QName qName) {
        return DomImpl.saajCallback_importSoapElement((DomImpl.Dom) document, element, z6, qName);
    }

    public void invalidateDomCaches(DomImpl.Dom dom) {
        if (this._domNthCache_A._parent == dom) {
            this._domNthCache_A._version = -1L;
        }
        if (this._domNthCache_B._parent == dom) {
            this._domNthCache_B._version = -1L;
        }
    }

    public void loadNode(Node node, LoadContext loadContext) {
        switch (node.getNodeType()) {
            case 1:
                loadContext.startElement(makeQualifiedQName(node.getNamespaceURI(), node.getNodeName()));
                NamedNodeMap attributes = node.getAttributes();
                for (int i5 = 0; i5 < attributes.getLength(); i5++) {
                    Node nodeItem = attributes.item(i5);
                    String nodeName = nodeItem.getNodeName();
                    String nodeValue = nodeItem.getNodeValue();
                    if (!nodeName.toLowerCase(java.util.Locale.ROOT).startsWith(Sax2Dom.XMLNS_PREFIX)) {
                        loadContext.attr(makeQualifiedQName(nodeItem.getNamespaceURI(), nodeName), nodeValue);
                    } else if (nodeName.length() == 5) {
                        loadContext.xmlns(null, nodeValue);
                    } else {
                        loadContext.xmlns(nodeName.substring(6), nodeValue);
                    }
                }
                loadNodeChildren(node, loadContext);
                loadContext.endElement();
                return;
            case 2:
                throw new RuntimeException("Unexpected node");
            case 3:
            case 4:
                loadContext.text(node.getNodeValue());
                return;
            case 5:
            case 9:
            case 11:
                loadNodeChildren(node, loadContext);
                return;
            case 6:
            case 10:
            case 12:
                Node nextSibling = node.getNextSibling();
                if (nextSibling != null) {
                    loadNode(nextSibling, loadContext);
                    return;
                }
                return;
            case 7:
                loadContext.procInst(node.getNodeName(), node.getNodeValue());
                return;
            case 8:
                loadContext.comment(node.getNodeValue());
                return;
            default:
                return;
        }
    }

    public QName makeQName(String str, String str2) {
        return this._qnameFactory.getQName(str, str2);
    }

    public QName makeQNameNoCheck(String str, String str2) {
        return this._qnameFactory.getQName(str, str2);
    }

    public QName makeQualifiedQName(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        int iIndexOf = str2.indexOf(58);
        return iIndexOf < 0 ? this._qnameFactory.getQName(str, str2) : this._qnameFactory.getQName(str, str2.substring(iIndexOf + 1), str2.substring(0, iIndexOf));
    }

    @Override // org.apache.xmlbeans.impl.common.XmlLocale
    public boolean noSync() {
        return this._noSync;
    }

    public void notifyChange() {
        while (true) {
            ChangeListener changeListener = this._changeListeners;
            if (changeListener == null) {
                this._locations.notifyChange();
                return;
            }
            changeListener.notifyChange();
            ChangeListener nextChangeListener = this._changeListeners.getNextChangeListener();
            ChangeListener changeListener2 = this._changeListeners;
            if (nextChangeListener == changeListener2) {
                changeListener2.setNextChangeListener(null);
            }
            ChangeListener nextChangeListener2 = this._changeListeners.getNextChangeListener();
            this._changeListeners.setNextChangeListener(null);
            this._changeListeners = nextChangeListener2;
        }
    }

    public final ReferenceQueue<Ref> refQueue() {
        if (this._refQueue == null) {
            this._refQueue = new ReferenceQueue<>();
        }
        return this._refQueue;
    }

    public void registerForChange(ChangeListener changeListener) {
        if (changeListener.getNextChangeListener() == null) {
            ChangeListener changeListener2 = this._changeListeners;
            if (changeListener2 == null) {
                changeListener.setNextChangeListener(changeListener);
            } else {
                changeListener.setNextChangeListener(changeListener2);
            }
            this._changeListeners = changeListener;
        }
    }

    @Override // org.apache.xmlbeans.impl.store.Saaj.SaajCallback
    public void setSaajData(Node node, Object obj) {
        DomImpl.saajCallback_setSaajData((DomImpl.Dom) node, obj);
    }

    @Override // org.apache.xmlbeans.impl.common.XmlLocale
    public boolean sync() {
        return !this._noSync;
    }

    public Cur tempCur() {
        return tempCur(null);
    }

    public long version() {
        return this._versionAll;
    }

    public Cur weakCur(Object obj) {
        Cur cur = getCur();
        cur._ref = new Ref(cur, obj);
        return cur;
    }

    public DomImpl.Dom load(Reader reader) {
        return load(reader, (XmlOptions) null);
    }

    public QName makeQName(String str, String str2, String str3) {
        QNameFactory qNameFactory = this._qnameFactory;
        if (str3 == null) {
            str3 = "";
        }
        return qNameFactory.getQName(str, str2, str3);
    }

    public Cur tempCur(String str) {
        Cur cur = getCur();
        Cur[] curArr = this._tempFrames;
        int length = (curArr.length - this._numTempFramesLeft) - 1;
        Cur cur2 = curArr[length];
        cur._nextTemp = cur2;
        if (cur2 != null) {
            cur2._prevTemp = cur;
        }
        curArr[length] = cur;
        cur._tempFrame = length;
        cur._id = str;
        return cur;
    }

    public static XmlObject parseToXmlObject(SchemaTypeLoader schemaTypeLoader, XMLStreamReader xMLStreamReader, SchemaType schemaType, XmlOptions xmlOptions) {
        try {
            return (XmlObject) syncWrap(schemaTypeLoader, xmlOptions, new C1451l(xMLStreamReader, xmlOptions, schemaType, 11));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // org.apache.xmlbeans.impl.common.XmlLocale
    public void enter() {
        int i5 = this._numTempFramesLeft - 1;
        this._numTempFramesLeft = i5;
        if (i5 <= 0) {
            Cur[] curArr = this._tempFrames;
            Cur[] curArr2 = new Cur[curArr.length * 2];
            this._numTempFramesLeft = curArr.length;
            System.arraycopy(curArr, 0, curArr2, 0, curArr.length);
            this._tempFrames = curArr2;
        }
        int i6 = this._entryCount + 1;
        this._entryCount = i6;
        if (i6 > 1000) {
            pollQueue();
            this._entryCount = 0;
        }
    }

    @Override // org.apache.xmlbeans.impl.common.XmlLocale
    public void exit() {
        int length = this._tempFrames.length;
        int i5 = this._numTempFramesLeft + 1;
        this._numTempFramesLeft = i5;
        int i6 = length - i5;
        while (true) {
            Cur cur = this._tempFrames[i6];
            if (cur == null) {
                return;
            } else {
                cur.release();
            }
        }
    }

    public DomImpl.Dom load(Reader reader, XmlOptions xmlOptions) {
        return load(new InputSource(reader), xmlOptions);
    }

    public DomImpl.Dom load(InputStream inputStream) {
        return load(inputStream, (XmlOptions) null);
    }

    public static XmlObject parseToXmlObject(SchemaTypeLoader schemaTypeLoader, InputStream inputStream, SchemaType schemaType, XmlOptions xmlOptions) {
        return (XmlObject) syncWrap(schemaTypeLoader, xmlOptions, new C1451l(xmlOptions, inputStream, schemaType, 12));
    }

    public DomImpl.Dom load(InputStream inputStream, XmlOptions xmlOptions) {
        return load(new InputSource(inputStream), xmlOptions);
    }

    public static XmlObject parseToXmlObject(SchemaTypeLoader schemaTypeLoader, Reader reader, SchemaType schemaType, XmlOptions xmlOptions) {
        return (XmlObject) syncWrap(schemaTypeLoader, xmlOptions, new C1451l(xmlOptions, reader, schemaType, 9));
    }

    public DomImpl.Dom load(String str) {
        return load(str, (XmlOptions) null);
    }

    public static XmlObject parseToXmlObject(SchemaTypeLoader schemaTypeLoader, Node node, SchemaType schemaType, XmlOptions xmlOptions) {
        try {
            return (XmlObject) syncWrap(schemaTypeLoader, xmlOptions, new C1451l(xmlOptions, node, schemaType, 10));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public DomImpl.Dom load(String str, XmlOptions xmlOptions) throws XmlException {
        try {
            StringReader stringReader = new StringReader(str);
            try {
                DomImpl.Dom domLoad = load(stringReader, xmlOptions);
                stringReader.close();
                return domLoad;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        stringReader.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (IOException e) {
            throw new XmlException(e.getMessage(), e);
        }
    }

    public static int getTextValue(Cur cur, char[] cArr, int i5, int i6) {
        String valueAsString = cur._xobj.getValueAsString(1);
        int length = valueAsString.length();
        if (length <= i6) {
            i6 = length;
        }
        if (i6 <= 0) {
            return 0;
        }
        valueAsString.getChars(0, i6, cArr, i5);
        return i6;
    }

    public static boolean toNextSiblingElement(Cur cur, Xobj xobj) {
        Xobj xobj2 = cur._xobj;
        int i5 = cur._pos;
        int iKind = cur.kind();
        if (iKind == 3) {
            cur.moveTo(xobj);
            cur.next();
        } else if (iKind == 2) {
            cur.skip();
        }
        while (true) {
            int iKind2 = cur.kind();
            if (iKind2 < 0) {
                cur.moveTo(xobj2, i5);
                return false;
            }
            if (iKind2 == 2) {
                return true;
            }
            if (iKind2 > 0) {
                cur.toEnd();
            }
            cur.next();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static abstract class SaxHandler implements ContentHandler, LexicalHandler, DeclHandler, DTDHandler {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        protected LoadContext _context;
        protected Locale _locale;
        private Locator _startLocator;
        private boolean _wantCdataBookmarks;
        private boolean _wantLineNumbers;
        private boolean _wantLineNumbersAtEndElt;
        private boolean _insideCDATA = false;
        private int _entityBytesLimit = TarConstants.DEFAULT_BLKSIZE;
        private int _entityBytes = 0;
        private int _insideEntity = 0;
        private Map<String, String> delayedPrefixMappings = new LinkedHashMap();

        public SaxHandler(Locator locator) {
            this._startLocator = locator;
        }

        @Override // org.xml.sax.ext.DeclHandler
        public void attributeDecl(String str, String str2, String str3, String str4, String str5) {
            if (str3.equals("ID")) {
                this._context.addIdAttr(str, str2);
            }
        }

        @Override // org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i5, int i6) throws SAXException {
            this._context.text(cArr, i5, i6);
            if (this._wantCdataBookmarks && this._insideCDATA && this._startLocator != null) {
                this._context.bookmarkLastNonAttr(CDataBookmark.CDATA_BOOKMARK);
            }
            if (this._insideEntity != 0) {
                int i7 = this._entityBytes + i6;
                this._entityBytes = i7;
                int i8 = this._entityBytesLimit;
                if (i7 > i8) {
                    throw new SAXException(XmlError.forMessage(XmlErrorCodes.EXCEPTION_EXCEEDED_ENTITY_BYTES, new Integer[]{Integer.valueOf(i8)}).getMessage());
                }
            }
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void comment(char[] cArr, int i5, int i6) {
            this._context.comment(cArr, i5, i6);
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void endCDATA() {
            this._insideCDATA = false;
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void endDTD() {
            this._context.endDTD();
        }

        @Override // org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) {
            Locator locator;
            this._context.endElement();
            if (!this._wantLineNumbersAtEndElt || (locator = this._startLocator) == null) {
                return;
            }
            this._context.bookmark(new XmlLineNumber(locator.getLineNumber(), this._startLocator.getColumnNumber() - 1, -1));
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void endEntity(String str) {
            int i5 = this._insideEntity - 1;
            this._insideEntity = i5;
            if (i5 == 0) {
                this._entityBytes = 0;
            }
        }

        public void initSaxHandler(Locale locale, XmlOptions xmlOptions) {
            this._locale = locale;
            XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
            this._context = new Cur.CurLoadContext(this._locale, xmlOptionsMaskNull);
            this._wantLineNumbers = xmlOptionsMaskNull.isLoadLineNumbers();
            this._wantLineNumbersAtEndElt = xmlOptionsMaskNull.isLoadLineNumbersEndElement();
            this._wantCdataBookmarks = xmlOptionsMaskNull.isUseCDataBookmarks();
            Integer loadEntityBytesLimit = xmlOptionsMaskNull.getLoadEntityBytesLimit();
            if (loadEntityBytesLimit != null) {
                this._entityBytesLimit = loadEntityBytesLimit.intValue();
            }
        }

        @Override // org.xml.sax.ContentHandler
        public void processingInstruction(String str, String str2) {
            this._context.procInst(str, str2);
        }

        @Override // org.xml.sax.ContentHandler
        public void setDocumentLocator(Locator locator) {
            if (this._startLocator == null) {
                this._startLocator = locator;
            }
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void startCDATA() {
            this._insideCDATA = true;
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void startDTD(String str, String str2, String str3) {
            this._context.startDTD(str, str2, str3);
        }

        @Override // org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) {
            Locator locator;
            if (str3.indexOf(58) >= 0 && str.length() == 0) {
                XmlError xmlErrorForMessage = XmlError.forMessage("Use of undefined namespace prefix: " + str3.substring(0, str3.indexOf(58)));
                throw new XmlRuntimeException(xmlErrorForMessage.toString(), (Throwable) null, xmlErrorForMessage);
            }
            this._context.startElement(this._locale.makeQualifiedQName(str, str3));
            if (this._wantLineNumbers && (locator = this._startLocator) != null) {
                this._context.bookmark(new XmlLineNumber(locator.getLineNumber(), this._startLocator.getColumnNumber() - 1, -1));
            }
            for (Map.Entry<String, String> entry : this.delayedPrefixMappings.entrySet()) {
                this._context.xmlns(entry.getKey(), entry.getValue());
            }
            this.delayedPrefixMappings.clear();
            int length = attributes.getLength();
            for (int i5 = 0; i5 < length; i5++) {
                String qName = attributes.getQName(i5);
                int iIndexOf = qName.indexOf(58);
                if (iIndexOf < 0) {
                    this._context.attr(qName, attributes.getURI(i5), null, attributes.getValue(i5));
                } else {
                    this._context.attr(qName.substring(iIndexOf + 1), attributes.getURI(i5), qName.substring(0, iIndexOf), attributes.getValue(i5));
                }
            }
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void startEntity(String str) {
            this._insideEntity++;
        }

        @Override // org.xml.sax.ContentHandler
        public void startPrefixMapping(String str, String str2) {
            if (!Locale.beginsWithXml(str) || ("xml".equals(str) && Locale._xml1998Uri.equals(str2))) {
                this.delayedPrefixMappings.put(str, str2);
                return;
            }
            XmlError xmlErrorForMessage = XmlError.forMessage("Prefix can't begin with XML: " + str, 0);
            throw new XmlRuntimeException(xmlErrorForMessage.toString(), (Throwable) null, xmlErrorForMessage);
        }

        @Override // org.xml.sax.ContentHandler
        public void endDocument() {
        }

        @Override // org.xml.sax.ContentHandler
        public void startDocument() {
        }

        @Override // org.xml.sax.ContentHandler
        public void endPrefixMapping(String str) {
        }

        @Override // org.xml.sax.ContentHandler
        public void skippedEntity(String str) {
        }

        @Override // org.xml.sax.ext.DeclHandler
        public void elementDecl(String str, String str2) {
        }

        @Override // org.xml.sax.ext.DeclHandler
        public void internalEntityDecl(String str, String str2) {
        }

        @Override // org.xml.sax.ext.DeclHandler
        public void externalEntityDecl(String str, String str2, String str3) {
        }

        @Override // org.xml.sax.ContentHandler
        public void ignorableWhitespace(char[] cArr, int i5, int i6) {
        }

        @Override // org.xml.sax.DTDHandler
        public void notationDecl(String str, String str2, String str3) {
        }

        @Override // org.xml.sax.DTDHandler
        public void unparsedEntityDecl(String str, String str2, String str3, String str4) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static abstract class SaxLoader extends SaxHandler implements ErrorHandler {
        private final XMLReader _xr;

        public SaxLoader(XMLReader xMLReader, Locator locator) {
            super(locator);
            this._xr = xMLReader;
            try {
                xMLReader.setFeature("http://xml.org/sax/features/namespaces", true);
                xMLReader.setFeature("http://xml.org/sax/features/validation", false);
                xMLReader.setProperty("http://xml.org/sax/properties/lexical-handler", this);
                xMLReader.setContentHandler(this);
                xMLReader.setDTDHandler(this);
                xMLReader.setErrorHandler(this);
                try {
                    xMLReader.setFeature("http://javax.xml.XMLConstants/feature/secure-processing", true);
                } catch (Throwable th) {
                    Locale.LOG.atWarn().withThrowable(th).log("Secure Processing Feature is not supported");
                }
                try {
                    this._xr.setProperty("http://xml.org/sax/properties/declaration-handler", this);
                } catch (Throwable th2) {
                    Locale.LOG.atWarn().withThrowable(th2).log("SAX Declaration Handler is not supported");
                }
            } catch (Throwable th3) {
                throw new RuntimeException(th3.getMessage(), th3);
            }
        }

        public Cur load(Locale locale, InputSource inputSource, XmlOptions xmlOptions) throws XmlException, IOException {
            inputSource.setSystemId("file://");
            initSaxHandler(locale, xmlOptions);
            try {
                this._xr.parse(inputSource);
                Cur curFinish = this._context.finish();
                Locale.associateSourceName(curFinish, xmlOptions);
                postLoad(curFinish);
                return curFinish;
            } catch (XmlRuntimeException e) {
                this._context.abort();
                throw new XmlException(e);
            } catch (RuntimeException e6) {
                this._context.abort();
                throw e6;
            } catch (SAXParseException e7) {
                this._context.abort();
                XmlError xmlErrorForLocation = XmlError.forLocation(e7.getMessage(), xmlOptions == null ? null : xmlOptions.getDocumentSourceName(), e7.getLineNumber(), e7.getColumnNumber(), -1);
                throw new XmlException(xmlErrorForLocation.toString(), e7, xmlErrorForLocation);
            } catch (SAXException e8) {
                this._context.abort();
                XmlError xmlErrorForMessage = XmlError.forMessage(e8.getMessage());
                throw new XmlException(xmlErrorForMessage.toString(), e8, xmlErrorForMessage);
            }
        }

        public void postLoad(Cur cur) {
            this._locale = null;
            this._context = null;
        }

        @Override // org.xml.sax.ErrorHandler
        public void error(SAXParseException sAXParseException) throws SAXParseException {
            throw sAXParseException;
        }

        @Override // org.xml.sax.ErrorHandler
        public void fatalError(SAXParseException sAXParseException) throws SAXParseException {
            throw sAXParseException;
        }

        @Override // org.xml.sax.ErrorHandler
        public void warning(SAXParseException sAXParseException) throws SAXParseException {
            throw sAXParseException;
        }
    }
}
