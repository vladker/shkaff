package org.apache.xmlbeans.impl.store;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.XmlDocumentProperties;
import org.apache.xmlbeans.XmlLineNumber;
import org.apache.xmlbeans.XmlOptions;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class Jsr173 {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static abstract class Jsr173GateWay {
        Locale _l;
        XMLStreamReaderBase _xs;

        public Jsr173GateWay(Locale locale, XMLStreamReaderBase xMLStreamReaderBase) {
            this._l = locale;
            this._xs = xMLStreamReaderBase;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static abstract class XMLStreamReaderBase implements XMLStreamReader, NamespaceContext, Location {
        private Locale _locale;
        String _uri;
        private long _version;
        int _line = -1;
        int _column = -1;
        int _offset = -1;

        public XMLStreamReaderBase(Cur cur) {
            Locale locale = cur._locale;
            this._locale = locale;
            this._version = locale.version();
        }

        public final void checkChanged() {
            if (this._version != this._locale.version()) {
                throw new ConcurrentModificationException("Document changed while streaming");
            }
        }

        public void close() {
            checkChanged();
        }

        public String getCharacterEncodingScheme() {
            checkChanged();
            XmlDocumentProperties docProps = Locale.getDocProps(getStreamCur(), false);
            if (docProps == null) {
                return null;
            }
            return docProps.getEncoding();
        }

        public int getCharacterOffset() {
            return this._offset;
        }

        public int getColumnNumber() {
            return this._column;
        }

        public String getEncoding() {
            return null;
        }

        public int getLineNumber() {
            return this._line;
        }

        public Location getLocation() {
            checkChanged();
            XmlLineNumber xmlLineNumber = (XmlLineNumber) getStreamCur().getBookmark(XmlLineNumber.class);
            this._uri = null;
            if (xmlLineNumber != null) {
                this._line = xmlLineNumber.getLine();
                this._column = xmlLineNumber.getColumn();
                this._offset = xmlLineNumber.getOffset();
                return this;
            }
            this._line = -1;
            this._column = -1;
            this._offset = -1;
            return this;
        }

        public String getLocationURI() {
            return this._uri;
        }

        public NamespaceContext getNamespaceContext() {
            throw new RuntimeException("This version of getNamespaceContext should not be called");
        }

        @Override // javax.xml.namespace.NamespaceContext
        public String getNamespaceURI(String str) {
            checkChanged();
            Cur streamCur = getStreamCur();
            streamCur.push();
            if (!streamCur.isContainer()) {
                streamCur.toParent();
            }
            String strNamespaceForPrefix = streamCur.namespaceForPrefix(str, true);
            streamCur.pop();
            return strNamespaceForPrefix;
        }

        @Override // javax.xml.namespace.NamespaceContext
        public String getPrefix(String str) {
            checkChanged();
            Cur streamCur = getStreamCur();
            streamCur.push();
            if (!streamCur.isContainer()) {
                streamCur.toParent();
            }
            String strPrefixForNamespace = streamCur.prefixForNamespace(str, null, false);
            streamCur.pop();
            return strPrefixForNamespace;
        }

        @Override // javax.xml.namespace.NamespaceContext
        public Iterator<String> getPrefixes(String str) {
            checkChanged();
            HashMap map = new HashMap();
            map.put(str, getPrefix(str));
            return map.values().iterator();
        }

        public Object getProperty(String str) {
            checkChanged();
            if (str != null) {
                return null;
            }
            throw new IllegalArgumentException("Property name is null");
        }

        public String getPublicId() {
            return null;
        }

        public abstract Cur getStreamCur();

        public String getSystemId() {
            return null;
        }

        public String getVersion() {
            checkChanged();
            XmlDocumentProperties docProps = Locale.getDocProps(getStreamCur(), false);
            if (docProps == null) {
                return null;
            }
            return docProps.getVersion();
        }

        public boolean isStandalone() {
            checkChanged();
            XmlDocumentProperties docProps = Locale.getDocProps(getStreamCur(), false);
            if (docProps == null) {
                return false;
            }
            return docProps.getStandalone();
        }

        public boolean isWhiteSpace() {
            checkChanged();
            String text = getText();
            return this._locale.getCharUtil().isWhiteSpace(text, 0, text.length());
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
        public void require(int i5, String str, String str2) throws XMLStreamException {
            checkChanged();
            if (i5 != getEventType()) {
                throw new XMLStreamException();
            }
            if (str != null && !getNamespaceURI().equals(str)) {
                throw new XMLStreamException();
            }
            if (str2 != null && !getLocalName().equals(str2)) {
                throw new XMLStreamException();
            }
        }

        public boolean standaloneSet() {
            checkChanged();
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class XMLStreamReaderForString extends XMLStreamReaderBase {
        private int _cch;
        private Cur _cur;
        private int _off;
        private Object _src;

        public XMLStreamReaderForString(Cur cur, Object obj, int i5, int i6) {
            super(cur);
            this._src = obj;
            this._off = i5;
            this._cch = i6;
            this._cur = cur;
        }

        public int getAttributeCount() {
            throw new IllegalStateException();
        }

        public String getAttributeLocalName(int i5) {
            throw new IllegalStateException();
        }

        public QName getAttributeName(int i5) {
            throw new IllegalStateException();
        }

        public String getAttributeNamespace(int i5) {
            throw new IllegalStateException();
        }

        public String getAttributePrefix(int i5) {
            throw new IllegalStateException();
        }

        public String getAttributeType(int i5) {
            throw new IllegalStateException();
        }

        public String getAttributeValue(int i5) {
            throw new IllegalStateException();
        }

        public String getElementText() {
            throw new IllegalStateException();
        }

        public int getEventType() {
            checkChanged();
            return 4;
        }

        public String getLocalName() {
            throw new IllegalStateException();
        }

        public QName getName() {
            throw new IllegalStateException();
        }

        public int getNamespaceCount() {
            throw new IllegalStateException();
        }

        public String getNamespacePrefix(int i5) {
            throw new IllegalStateException();
        }

        public String getNamespaceURI(int i5) {
            throw new IllegalStateException();
        }

        public String getPIData() {
            throw new IllegalStateException();
        }

        public String getPITarget() {
            throw new IllegalStateException();
        }

        public String getPrefix() {
            throw new IllegalStateException();
        }

        @Override // org.apache.xmlbeans.impl.store.Jsr173.XMLStreamReaderBase
        public String getPublicId() {
            throw new IllegalStateException();
        }

        @Override // org.apache.xmlbeans.impl.store.Jsr173.XMLStreamReaderBase
        public Cur getStreamCur() {
            return this._cur;
        }

        @Override // org.apache.xmlbeans.impl.store.Jsr173.XMLStreamReaderBase
        public String getSystemId() {
            throw new IllegalStateException();
        }

        public String getText() {
            checkChanged();
            return CharUtil.getString(this._src, this._off, this._cch);
        }

        public char[] getTextCharacters() {
            checkChanged();
            int i5 = this._cch;
            char[] cArr = new char[i5];
            CharUtil.getChars(cArr, 0, this._src, this._off, i5);
            return cArr;
        }

        public int getTextLength() {
            checkChanged();
            return this._cch;
        }

        public int getTextStart() {
            checkChanged();
            return this._off;
        }

        public boolean hasName() {
            checkChanged();
            return false;
        }

        public boolean hasNext() {
            checkChanged();
            return false;
        }

        public boolean hasText() {
            checkChanged();
            return true;
        }

        public boolean isAttributeSpecified(int i5) {
            throw new IllegalStateException();
        }

        public boolean isCharacters() {
            checkChanged();
            return true;
        }

        public boolean isEndElement() {
            checkChanged();
            return false;
        }

        public boolean isStartElement() {
            checkChanged();
            return false;
        }

        public int next() {
            throw new IllegalStateException();
        }

        public int nextTag() {
            throw new IllegalStateException();
        }

        public String getAttributeValue(String str, String str2) {
            throw new IllegalStateException();
        }

        public String getNamespaceURI() {
            throw new IllegalStateException();
        }

        public int getTextCharacters(int i5, char[] cArr, int i6, int i7) {
            checkChanged();
            if (i7 >= 0) {
                int i8 = this._cch;
                if (i5 <= i8) {
                    if (i5 + i7 > i8) {
                        i7 = i8 - i5;
                    }
                    CharUtil.getChars(cArr, i6, this._src, this._off + i5, i7);
                    return i7;
                }
                throw new IndexOutOfBoundsException();
            }
            throw new IndexOutOfBoundsException();
        }
    }

    public static XMLStreamReader newXmlStreamReader(Cur cur, Object obj, int i5, int i6) {
        XMLStreamReaderForString xMLStreamReaderForString = new XMLStreamReaderForString(cur, obj, i5, i6);
        return cur._locale.noSync() ? new UnsyncedJsr173(cur._locale, xMLStreamReaderForString) : new SyncedJsr173(cur._locale, xMLStreamReaderForString);
    }

    public static Node nodeFromStream(XMLStreamReader xMLStreamReader) {
        Node nodeNodeFromStreamImpl;
        if (!(xMLStreamReader instanceof Jsr173GateWay)) {
            return null;
        }
        Jsr173GateWay jsr173GateWay = (Jsr173GateWay) xMLStreamReader;
        Locale locale = jsr173GateWay._l;
        if (locale.noSync()) {
            locale.enter();
            try {
                return nodeFromStreamImpl(jsr173GateWay);
            } finally {
                locale.exit();
            }
        }
        synchronized (locale) {
            try {
                locale.enter();
                try {
                    nodeNodeFromStreamImpl = nodeFromStreamImpl(jsr173GateWay);
                    locale.exit();
                } catch (Throwable th) {
                    locale.exit();
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return nodeNodeFromStreamImpl;
    }

    public static Node nodeFromStreamImpl(Jsr173GateWay jsr173GateWay) {
        Cur streamCur = jsr173GateWay._xs.getStreamCur();
        if (streamCur.isNode()) {
            return (Node) streamCur.getDom();
        }
        return null;
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class XMLStreamReaderForNode extends XMLStreamReaderBase {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private int _cchChars;
        private int _cchSrc;
        private char[] _chars;
        private Cur _cur;
        private boolean _done;
        private Cur _end;
        private int _offChars;
        private int _offSrc;
        private Object _src;
        private boolean _srcFetched;
        private boolean _textFetched;
        private boolean _wholeDoc;

        public XMLStreamReaderForNode(Cur cur, boolean z6) {
            super(cur);
            if (z6) {
                Cur curWeakCur = cur.weakCur(this);
                this._cur = curWeakCur;
                if (!curWeakCur.toFirstAttr()) {
                    this._cur.next();
                }
                Cur curWeakCur2 = cur.weakCur(this);
                this._end = curWeakCur2;
                curWeakCur2.toEnd();
            } else {
                this._cur = cur.weakCur(this);
                if (cur.isRoot()) {
                    this._wholeDoc = true;
                } else {
                    this._end = cur.weakCur(this);
                    if (!cur.isAttr()) {
                        this._end.skip();
                    } else if (!this._end.toNextAttr()) {
                        this._end.toParent();
                        this._end.next();
                    }
                }
            }
            if (this._wholeDoc) {
                return;
            }
            this._cur.push();
            try {
                next();
                this._cur.pop();
            } catch (XMLStreamException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }

        private void ensureCharBufLen(int i5) {
            char[] cArr = this._chars;
            if (cArr == null || cArr.length < i5) {
                int i6 = 256;
                while (i6 < i5) {
                    i6 *= 2;
                }
                this._chars = new char[i6];
            }
        }

        private void fetchChars() {
            Cur curTempCur;
            if (this._textFetched) {
                return;
            }
            int iKind = this._cur.kind();
            if (iKind == 4) {
                curTempCur = this._cur.tempCur();
                curTempCur.next();
            } else {
                if (iKind != 0) {
                    throw new IllegalStateException();
                }
                curTempCur = this._cur;
            }
            Object chars = curTempCur.getChars(-1);
            ensureCharBufLen(curTempCur._cchSrc);
            char[] cArr = this._chars;
            this._offChars = 0;
            int i5 = curTempCur._offSrc;
            int i6 = curTempCur._cchSrc;
            this._cchChars = i6;
            CharUtil.getChars(cArr, 0, chars, i5, i6);
            if (curTempCur != this._cur) {
                curTempCur.release();
            }
            this._textFetched = true;
        }

        private static boolean matchAttr(Cur cur, String str, String str2) {
            QName name = cur.getName();
            if (name.getLocalPart().equals(str2)) {
                return str == null || name.getNamespaceURI().equals(str);
            }
            return false;
        }

        private static Cur toAttr(Cur cur, String str, String str2) {
            boolean zMatchAttr;
            if (str == null || str2 == null || str2.length() == 0) {
                throw new IllegalArgumentException();
            }
            Cur curTempCur = cur.tempCur();
            if (cur.isElem()) {
                if (!curTempCur.toFirstAttr()) {
                    zMatchAttr = false;
                    break;
                }
                while (true) {
                    if (curTempCur.isNormalAttr() && matchAttr(curTempCur, str, str2)) {
                        zMatchAttr = true;
                        break;
                    }
                    if (!curTempCur.toNextSibling()) {
                        zMatchAttr = false;
                        break;
                    }
                }
            } else {
                if (!cur.isNormalAttr()) {
                    throw new IllegalStateException();
                }
                zMatchAttr = matchAttr(cur, str, str2);
            }
            if (zMatchAttr) {
                return curTempCur;
            }
            curTempCur.release();
            return null;
        }

        private static Cur toXmlns(Cur cur, int i5) {
            if (i5 < 0) {
                throw new IndexOutOfBoundsException("Namespace index is negative");
            }
            Cur curTempCur = cur.tempCur();
            if (cur.isElem() || cur.kind() == -2) {
                if (cur.kind() == -2) {
                    curTempCur.toParent();
                }
                if (curTempCur.toFirstAttr()) {
                    do {
                        if (curTempCur.isXmlns()) {
                            int i6 = i5 - 1;
                            if (i5 == 0) {
                                return curTempCur;
                            }
                            i5 = i6;
                        }
                    } while (curTempCur.toNextSibling());
                }
            } else {
                if (!cur.isXmlns()) {
                    throw new IllegalStateException();
                }
                if (i5 == 0) {
                    return curTempCur;
                }
            }
            curTempCur.release();
            throw new IndexOutOfBoundsException("Namespace index is too large");
        }

        public int getAttributeCount() {
            if (!this._cur.isElem()) {
                if (this._cur.isNormalAttr()) {
                    return 1;
                }
                throw new IllegalStateException();
            }
            Cur curTempCur = this._cur.tempCur();
            int i5 = 0;
            if (curTempCur.toFirstAttr()) {
                do {
                    if (curTempCur.isNormalAttr()) {
                        i5++;
                    }
                } while (curTempCur.toNextSibling());
            }
            curTempCur.release();
            return i5;
        }

        public String getAttributeLocalName(int i5) {
            return getAttributeName(i5).getLocalPart();
        }

        public QName getAttributeName(int i5) {
            Cur attr = toAttr(this._cur, i5);
            QName name = attr.getName();
            attr.release();
            return name;
        }

        public String getAttributeNamespace(int i5) {
            return getAttributeName(i5).getNamespaceURI();
        }

        public String getAttributePrefix(int i5) {
            return getAttributeName(i5).getPrefix();
        }

        public String getAttributeType(int i5) {
            toAttr(this._cur, i5).release();
            return "CDATA";
        }

        public String getAttributeValue(String str, String str2) {
            Cur attr = toAttr(this._cur, str, str2);
            if (attr == null) {
                return null;
            }
            String valueAsString = attr.getValueAsString();
            attr.release();
            return valueAsString;
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
        public String getElementText() throws XMLStreamException {
            checkChanged();
            if (!isStartElement()) {
                throw new IllegalStateException();
            }
            StringBuilder sb = new StringBuilder();
            while (hasNext()) {
                int next = next();
                if (next == 2) {
                    return sb.toString();
                }
                if (next == 1) {
                    throw new XMLStreamException();
                }
                if (next != 5 && next != 3) {
                    sb.append(getText());
                }
            }
            throw new XMLStreamException();
        }

        public int getEventType() {
            switch (this._cur.kind()) {
                case -2:
                    return 2;
                case -1:
                    return 8;
                case 0:
                    return 4;
                case 1:
                    return 7;
                case 2:
                    return 1;
                case 3:
                    return this._cur.isXmlns() ? 13 : 10;
                case 4:
                    return 5;
                case 5:
                    return 3;
                default:
                    throw new IllegalStateException();
            }
        }

        public String getLocalName() {
            return getName().getLocalPart();
        }

        public QName getName() {
            if (hasName()) {
                return this._cur.getName();
            }
            throw new IllegalStateException();
        }

        public int getNamespaceCount() {
            if (!this._cur.isElem() && this._cur.kind() != -2) {
                if (this._cur.isXmlns()) {
                    return 1;
                }
                throw new IllegalStateException();
            }
            Cur curTempCur = this._cur.tempCur();
            if (this._cur.kind() == -2) {
                curTempCur.toParent();
            }
            int i5 = 0;
            if (curTempCur.toFirstAttr()) {
                do {
                    if (curTempCur.isXmlns()) {
                        i5++;
                    }
                } while (curTempCur.toNextSibling());
            }
            curTempCur.release();
            return i5;
        }

        public String getNamespacePrefix(int i5) {
            Cur xmlns = toXmlns(this._cur, i5);
            String xmlnsPrefix = xmlns.getXmlnsPrefix();
            xmlns.release();
            return xmlnsPrefix;
        }

        public String getNamespaceURI(int i5) {
            Cur xmlns = toXmlns(this._cur, i5);
            String xmlnsUri = xmlns.getXmlnsUri();
            xmlns.release();
            return xmlnsUri;
        }

        public String getPIData() {
            if (this._cur.kind() == 5) {
                return this._cur.getValueAsString();
            }
            return null;
        }

        public String getPITarget() {
            if (this._cur.kind() == 5) {
                return this._cur.getName().getLocalPart();
            }
            return null;
        }

        public String getPrefix() {
            return getName().getPrefix();
        }

        @Override // org.apache.xmlbeans.impl.store.Jsr173.XMLStreamReaderBase
        public Cur getStreamCur() {
            return this._cur;
        }

        public String getText() {
            checkChanged();
            int iKind = this._cur.kind();
            if (iKind == 4) {
                return this._cur.getValueAsString();
            }
            if (iKind == 0) {
                return this._cur.getCharsAsString();
            }
            throw new IllegalStateException();
        }

        public char[] getTextCharacters() {
            checkChanged();
            fetchChars();
            return this._chars;
        }

        public int getTextLength() {
            checkChanged();
            fetchChars();
            return this._cchChars;
        }

        public int getTextStart() {
            checkChanged();
            fetchChars();
            return this._offChars;
        }

        public boolean hasName() {
            int iKind = this._cur.kind();
            return iKind == 2 || iKind == -2;
        }

        public boolean hasNext() {
            checkChanged();
            return !this._done;
        }

        public boolean hasText() {
            int iKind = this._cur.kind();
            return iKind == 4 || iKind == 0;
        }

        public boolean isAttributeSpecified(int i5) {
            toAttr(this._cur, i5).release();
            return false;
        }

        public boolean isCharacters() {
            return getEventType() == 4;
        }

        public boolean isEndElement() {
            return getEventType() == 2;
        }

        public boolean isStartElement() {
            return getEventType() == 1;
        }

        public int next() {
            checkChanged();
            if (!hasNext()) {
                throw new IllegalStateException("No next event in stream");
            }
            int iKind = this._cur.kind();
            boolean zIsSamePos = true;
            if (iKind == -1) {
                this._done = true;
            } else {
                if (iKind == 3) {
                    if (!this._cur.toNextAttr()) {
                        this._cur.toParent();
                        this._cur.next();
                    }
                } else if (iKind == 4 || iKind == 5) {
                    this._cur.skip();
                } else if (iKind != 1 || !this._cur.toFirstAttr()) {
                    this._cur.next();
                }
                if (!this._wholeDoc) {
                    zIsSamePos = this._cur.isSamePos(this._end);
                } else if (this._cur.kind() != -1) {
                    zIsSamePos = false;
                }
                this._done = zIsSamePos;
            }
            this._textFetched = false;
            this._srcFetched = false;
            return getEventType();
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
        public int nextTag() throws XMLStreamException {
            checkChanged();
            while (!isStartElement() && !isEndElement()) {
                if (!isWhiteSpace()) {
                    throw new XMLStreamException();
                }
                if (!hasNext()) {
                    throw new XMLStreamException();
                }
                next();
            }
            return getEventType();
        }

        public String getAttributeValue(int i5) {
            Cur attr = toAttr(this._cur, i5);
            if (attr == null) {
                return null;
            }
            String valueAsString = attr.getValueAsString();
            attr.release();
            return valueAsString;
        }

        public String getNamespaceURI() {
            return getName().getNamespaceURI();
        }

        public int getTextCharacters(int i5, char[] cArr, int i6, int i7) {
            Cur curTempCur;
            if (i7 >= 0) {
                if (i6 >= 0 && i6 < cArr.length) {
                    if (i6 + i7 <= cArr.length) {
                        if (!this._srcFetched) {
                            int iKind = this._cur.kind();
                            if (iKind == 4) {
                                curTempCur = this._cur.tempCur();
                                curTempCur.next();
                            } else if (iKind == 0) {
                                curTempCur = this._cur;
                            } else {
                                throw new IllegalStateException();
                            }
                            this._src = curTempCur.getChars(-1);
                            this._offSrc = curTempCur._offSrc;
                            this._cchSrc = curTempCur._cchSrc;
                            if (curTempCur != this._cur) {
                                curTempCur.release();
                            }
                            this._srcFetched = true;
                        }
                        int i8 = this._cchSrc;
                        if (i5 <= i8) {
                            if (i5 + i7 > i8) {
                                i7 = i8 - i5;
                            }
                            CharUtil.getChars(cArr, i6, this._src, this._offSrc, i7);
                            return i7;
                        }
                        throw new IndexOutOfBoundsException();
                    }
                    throw new IndexOutOfBoundsException();
                }
                throw new IndexOutOfBoundsException();
            }
            throw new IndexOutOfBoundsException();
        }

        private static Cur toAttr(Cur cur, int i5) {
            if (i5 >= 0) {
                Cur curTempCur = cur.tempCur();
                if (cur.isElem()) {
                    if (curTempCur.toFirstAttr()) {
                        do {
                            if (curTempCur.isNormalAttr()) {
                                int i6 = i5 - 1;
                                if (i5 == 0) {
                                    return curTempCur;
                                }
                                i5 = i6;
                            }
                        } while (curTempCur.toNextSibling());
                    }
                } else {
                    if (!cur.isNormalAttr()) {
                        throw new IllegalStateException();
                    }
                    if (i5 == 0) {
                        return curTempCur;
                    }
                }
                curTempCur.release();
                throw new IndexOutOfBoundsException("Attribute index is too large");
            }
            throw new IndexOutOfBoundsException("Attribute index is negative");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class UnsyncedJsr173 extends Jsr173GateWay implements XMLStreamReader, Location, NamespaceContext {
        public UnsyncedJsr173(Locale locale, XMLStreamReaderBase xMLStreamReaderBase) {
            super(locale, xMLStreamReaderBase);
        }

        public void close() {
            try {
                this._l.enter();
                this._xs.close();
            } finally {
                this._l.exit();
            }
        }

        public int getAttributeCount() {
            try {
                this._l.enter();
                return this._xs.getAttributeCount();
            } finally {
                this._l.exit();
            }
        }

        public String getAttributeLocalName(int i5) {
            try {
                this._l.enter();
                return this._xs.getAttributeLocalName(i5);
            } finally {
                this._l.exit();
            }
        }

        public QName getAttributeName(int i5) {
            try {
                this._l.enter();
                return this._xs.getAttributeName(i5);
            } finally {
                this._l.exit();
            }
        }

        public String getAttributeNamespace(int i5) {
            try {
                this._l.enter();
                return this._xs.getAttributeNamespace(i5);
            } finally {
                this._l.exit();
            }
        }

        public String getAttributePrefix(int i5) {
            try {
                this._l.enter();
                return this._xs.getAttributePrefix(i5);
            } finally {
                this._l.exit();
            }
        }

        public String getAttributeType(int i5) {
            try {
                this._l.enter();
                return this._xs.getAttributeType(i5);
            } finally {
                this._l.exit();
            }
        }

        public String getAttributeValue(String str, String str2) {
            try {
                this._l.enter();
                return this._xs.getAttributeValue(str, str2);
            } finally {
                this._l.exit();
            }
        }

        public String getCharacterEncodingScheme() {
            try {
                this._l.enter();
                return this._xs.getCharacterEncodingScheme();
            } finally {
                this._l.exit();
            }
        }

        public int getCharacterOffset() {
            try {
                this._l.enter();
                return this._xs.getCharacterOffset();
            } finally {
                this._l.exit();
            }
        }

        public int getColumnNumber() {
            try {
                this._l.enter();
                return this._xs.getColumnNumber();
            } finally {
                this._l.exit();
            }
        }

        public String getElementText() {
            try {
                this._l.enter();
                return this._xs.getElementText();
            } finally {
                this._l.exit();
            }
        }

        public String getEncoding() {
            try {
                this._l.enter();
                return this._xs.getEncoding();
            } finally {
                this._l.exit();
            }
        }

        public int getEventType() {
            try {
                this._l.enter();
                return this._xs.getEventType();
            } finally {
                this._l.exit();
            }
        }

        public int getLineNumber() {
            int lineNumber;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        lineNumber = this._xs.getLineNumber();
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return lineNumber;
        }

        public String getLocalName() {
            try {
                this._l.enter();
                return this._xs.getLocalName();
            } finally {
                this._l.exit();
            }
        }

        public Location getLocation() {
            try {
                this._l.enter();
                return this._xs.getLocation();
            } finally {
                this._l.exit();
            }
        }

        public String getLocationURI() {
            String locationURI;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        locationURI = this._xs.getLocationURI();
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return locationURI;
        }

        public QName getName() {
            try {
                this._l.enter();
                return this._xs.getName();
            } finally {
                this._l.exit();
            }
        }

        public int getNamespaceCount() {
            try {
                this._l.enter();
                return this._xs.getNamespaceCount();
            } finally {
                this._l.exit();
            }
        }

        public String getNamespacePrefix(int i5) {
            try {
                this._l.enter();
                return this._xs.getNamespacePrefix(i5);
            } finally {
                this._l.exit();
            }
        }

        @Override // javax.xml.namespace.NamespaceContext
        public String getNamespaceURI(String str) {
            try {
                this._l.enter();
                return this._xs.getNamespaceURI(str);
            } finally {
                this._l.exit();
            }
        }

        public String getPIData() {
            try {
                this._l.enter();
                return this._xs.getPIData();
            } finally {
                this._l.exit();
            }
        }

        public String getPITarget() {
            try {
                this._l.enter();
                return this._xs.getPITarget();
            } finally {
                this._l.exit();
            }
        }

        public String getPrefix() {
            try {
                this._l.enter();
                return this._xs.getPrefix();
            } finally {
                this._l.exit();
            }
        }

        @Override // javax.xml.namespace.NamespaceContext
        public Iterator<String> getPrefixes(String str) {
            try {
                this._l.enter();
                return this._xs.getPrefixes(str);
            } finally {
                this._l.exit();
            }
        }

        public Object getProperty(String str) {
            try {
                this._l.enter();
                return this._xs.getProperty(str);
            } finally {
                this._l.exit();
            }
        }

        public String getPublicId() {
            String publicId;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        publicId = this._xs.getPublicId();
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return publicId;
        }

        public String getSystemId() {
            String systemId;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        systemId = this._xs.getSystemId();
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return systemId;
        }

        public String getText() {
            try {
                this._l.enter();
                return this._xs.getText();
            } finally {
                this._l.exit();
            }
        }

        public char[] getTextCharacters() {
            try {
                this._l.enter();
                return this._xs.getTextCharacters();
            } finally {
                this._l.exit();
            }
        }

        public int getTextLength() {
            try {
                this._l.enter();
                return this._xs.getTextLength();
            } finally {
                this._l.exit();
            }
        }

        public int getTextStart() {
            try {
                this._l.enter();
                return this._xs.getTextStart();
            } finally {
                this._l.exit();
            }
        }

        public String getVersion() {
            try {
                this._l.enter();
                return this._xs.getVersion();
            } finally {
                this._l.exit();
            }
        }

        public boolean hasName() {
            try {
                this._l.enter();
                return this._xs.hasName();
            } finally {
                this._l.exit();
            }
        }

        public boolean hasNext() {
            try {
                this._l.enter();
                return this._xs.hasNext();
            } finally {
                this._l.exit();
            }
        }

        public boolean hasText() {
            try {
                this._l.enter();
                return this._xs.hasText();
            } finally {
                this._l.exit();
            }
        }

        public boolean isAttributeSpecified(int i5) {
            try {
                this._l.enter();
                return this._xs.isAttributeSpecified(i5);
            } finally {
                this._l.exit();
            }
        }

        public boolean isCharacters() {
            try {
                this._l.enter();
                return this._xs.isCharacters();
            } finally {
                this._l.exit();
            }
        }

        public boolean isEndElement() {
            try {
                this._l.enter();
                return this._xs.isEndElement();
            } finally {
                this._l.exit();
            }
        }

        public boolean isStandalone() {
            try {
                this._l.enter();
                return this._xs.isStandalone();
            } finally {
                this._l.exit();
            }
        }

        public boolean isStartElement() {
            try {
                this._l.enter();
                return this._xs.isStartElement();
            } finally {
                this._l.exit();
            }
        }

        public boolean isWhiteSpace() {
            try {
                this._l.enter();
                return this._xs.isWhiteSpace();
            } finally {
                this._l.exit();
            }
        }

        public int next() {
            try {
                this._l.enter();
                return this._xs.next();
            } finally {
                this._l.exit();
            }
        }

        public int nextTag() {
            try {
                this._l.enter();
                return this._xs.nextTag();
            } finally {
                this._l.exit();
            }
        }

        public void require(int i5, String str, String str2) {
            try {
                this._l.enter();
                this._xs.require(i5, str, str2);
            } finally {
                this._l.exit();
            }
        }

        public boolean standaloneSet() {
            try {
                this._l.enter();
                return this._xs.standaloneSet();
            } finally {
                this._l.exit();
            }
        }

        public String getAttributeValue(int i5) {
            try {
                this._l.enter();
                return this._xs.getAttributeValue(i5);
            } finally {
                this._l.exit();
            }
        }

        public String getNamespaceURI(int i5) {
            try {
                this._l.enter();
                return this._xs.getNamespaceURI(i5);
            } finally {
                this._l.exit();
            }
        }

        @Override // javax.xml.namespace.NamespaceContext
        public String getPrefix(String str) {
            try {
                this._l.enter();
                return this._xs.getPrefix(str);
            } finally {
                this._l.exit();
            }
        }

        public int getTextCharacters(int i5, char[] cArr, int i6, int i7) {
            try {
                this._l.enter();
                return this._xs.getTextCharacters(i5, cArr, i6, i7);
            } finally {
                this._l.exit();
            }
        }

        public String getNamespaceURI() {
            try {
                this._l.enter();
                return this._xs.getNamespaceURI();
            } finally {
                this._l.exit();
            }
        }

        public NamespaceContext getNamespaceContext() {
            return this;
        }
    }

    public static XMLStreamReader newXmlStreamReader(Cur cur, XmlOptions xmlOptions) {
        XMLStreamReaderBase xMLStreamReaderForString;
        XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
        boolean z6 = xmlOptionsMaskNull.isSaveInner() && !xmlOptionsMaskNull.isSaveOuter();
        int iKind = cur.kind();
        if (iKind == 0 || iKind < 0) {
            xMLStreamReaderForString = new XMLStreamReaderForString(cur, cur.getChars(-1), cur._offSrc, cur._cchSrc);
        } else if (z6) {
            if (!cur.hasAttrs() && !cur.hasChildren()) {
                xMLStreamReaderForString = new XMLStreamReaderForString(cur, cur.getFirstChars(), cur._offSrc, cur._cchSrc);
            } else {
                xMLStreamReaderForString = new XMLStreamReaderForNode(cur, true);
            }
        } else {
            xMLStreamReaderForString = new XMLStreamReaderForNode(cur, false);
        }
        if (cur._locale.noSync()) {
            return new UnsyncedJsr173(cur._locale, xMLStreamReaderForString);
        }
        return new SyncedJsr173(cur._locale, xMLStreamReaderForString);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class SyncedJsr173 extends Jsr173GateWay implements XMLStreamReader, Location, NamespaceContext {
        public SyncedJsr173(Locale locale, XMLStreamReaderBase xMLStreamReaderBase) {
            super(locale, xMLStreamReaderBase);
        }

        public void close() {
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        this._xs.close();
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public int getAttributeCount() {
            int attributeCount;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        attributeCount = this._xs.getAttributeCount();
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return attributeCount;
        }

        public String getAttributeLocalName(int i5) {
            String attributeLocalName;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        attributeLocalName = this._xs.getAttributeLocalName(i5);
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return attributeLocalName;
        }

        public QName getAttributeName(int i5) {
            QName attributeName;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        attributeName = this._xs.getAttributeName(i5);
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return attributeName;
        }

        public String getAttributeNamespace(int i5) {
            String attributeNamespace;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        attributeNamespace = this._xs.getAttributeNamespace(i5);
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return attributeNamespace;
        }

        public String getAttributePrefix(int i5) {
            String attributePrefix;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        attributePrefix = this._xs.getAttributePrefix(i5);
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return attributePrefix;
        }

        public String getAttributeType(int i5) {
            String attributeType;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        attributeType = this._xs.getAttributeType(i5);
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return attributeType;
        }

        public String getAttributeValue(String str, String str2) {
            String attributeValue;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        attributeValue = this._xs.getAttributeValue(str, str2);
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return attributeValue;
        }

        public String getCharacterEncodingScheme() {
            String characterEncodingScheme;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        characterEncodingScheme = this._xs.getCharacterEncodingScheme();
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return characterEncodingScheme;
        }

        public int getCharacterOffset() {
            int characterOffset;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        characterOffset = this._xs.getCharacterOffset();
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return characterOffset;
        }

        public int getColumnNumber() {
            int columnNumber;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        columnNumber = this._xs.getColumnNumber();
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return columnNumber;
        }

        public String getElementText() {
            String elementText;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        elementText = this._xs.getElementText();
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return elementText;
        }

        public String getEncoding() {
            String encoding;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        encoding = this._xs.getEncoding();
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return encoding;
        }

        public int getEventType() {
            int eventType;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        eventType = this._xs.getEventType();
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return eventType;
        }

        public int getLineNumber() {
            int lineNumber;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        lineNumber = this._xs.getLineNumber();
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return lineNumber;
        }

        public String getLocalName() {
            String localName;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        localName = this._xs.getLocalName();
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return localName;
        }

        public Location getLocation() {
            Location location;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        location = this._xs.getLocation();
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return location;
        }

        public String getLocationURI() {
            String locationURI;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        locationURI = this._xs.getLocationURI();
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return locationURI;
        }

        public QName getName() {
            QName name;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        name = this._xs.getName();
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return name;
        }

        public int getNamespaceCount() {
            int namespaceCount;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        namespaceCount = this._xs.getNamespaceCount();
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return namespaceCount;
        }

        public String getNamespacePrefix(int i5) {
            String namespacePrefix;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        namespacePrefix = this._xs.getNamespacePrefix(i5);
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return namespacePrefix;
        }

        @Override // javax.xml.namespace.NamespaceContext
        public String getNamespaceURI(String str) {
            String namespaceURI;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        namespaceURI = this._xs.getNamespaceURI(str);
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return namespaceURI;
        }

        public String getPIData() {
            String pIData;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        pIData = this._xs.getPIData();
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return pIData;
        }

        public String getPITarget() {
            String pITarget;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        pITarget = this._xs.getPITarget();
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return pITarget;
        }

        public String getPrefix() {
            String prefix;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        prefix = this._xs.getPrefix();
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return prefix;
        }

        @Override // javax.xml.namespace.NamespaceContext
        public Iterator<String> getPrefixes(String str) {
            Iterator<String> prefixes;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        prefixes = this._xs.getPrefixes(str);
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return prefixes;
        }

        public Object getProperty(String str) {
            Object property;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        property = this._xs.getProperty(str);
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return property;
        }

        public String getPublicId() {
            String publicId;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        publicId = this._xs.getPublicId();
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return publicId;
        }

        public String getSystemId() {
            String systemId;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        systemId = this._xs.getSystemId();
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return systemId;
        }

        public String getText() {
            String text;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        text = this._xs.getText();
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return text;
        }

        public char[] getTextCharacters() {
            char[] textCharacters;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        textCharacters = this._xs.getTextCharacters();
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return textCharacters;
        }

        public int getTextLength() {
            int textLength;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        textLength = this._xs.getTextLength();
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return textLength;
        }

        public int getTextStart() {
            int textStart;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        textStart = this._xs.getTextStart();
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return textStart;
        }

        public String getVersion() {
            String version;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        version = this._xs.getVersion();
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return version;
        }

        public boolean hasName() {
            boolean zHasName;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        zHasName = this._xs.hasName();
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return zHasName;
        }

        public boolean hasNext() {
            boolean zHasNext;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        zHasNext = this._xs.hasNext();
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return zHasNext;
        }

        public boolean hasText() {
            boolean zHasText;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        zHasText = this._xs.hasText();
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return zHasText;
        }

        public boolean isAttributeSpecified(int i5) {
            boolean zIsAttributeSpecified;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        zIsAttributeSpecified = this._xs.isAttributeSpecified(i5);
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return zIsAttributeSpecified;
        }

        public boolean isCharacters() {
            boolean zIsCharacters;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        zIsCharacters = this._xs.isCharacters();
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return zIsCharacters;
        }

        public boolean isEndElement() {
            boolean zIsEndElement;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        zIsEndElement = this._xs.isEndElement();
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return zIsEndElement;
        }

        public boolean isStandalone() {
            boolean zIsStandalone;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        zIsStandalone = this._xs.isStandalone();
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return zIsStandalone;
        }

        public boolean isStartElement() {
            boolean zIsStartElement;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        zIsStartElement = this._xs.isStartElement();
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return zIsStartElement;
        }

        public boolean isWhiteSpace() {
            boolean zIsWhiteSpace;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        zIsWhiteSpace = this._xs.isWhiteSpace();
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return zIsWhiteSpace;
        }

        public int next() {
            int next;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        next = this._xs.next();
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return next;
        }

        public int nextTag() {
            int iNextTag;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        iNextTag = this._xs.nextTag();
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return iNextTag;
        }

        public void require(int i5, String str, String str2) {
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        this._xs.require(i5, str, str2);
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public boolean standaloneSet() {
            boolean zStandaloneSet;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        zStandaloneSet = this._xs.standaloneSet();
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return zStandaloneSet;
        }

        public String getAttributeValue(int i5) {
            String attributeValue;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        attributeValue = this._xs.getAttributeValue(i5);
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return attributeValue;
        }

        public String getNamespaceURI(int i5) {
            String namespaceURI;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        namespaceURI = this._xs.getNamespaceURI(i5);
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return namespaceURI;
        }

        @Override // javax.xml.namespace.NamespaceContext
        public String getPrefix(String str) {
            String prefix;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        prefix = this._xs.getPrefix(str);
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return prefix;
        }

        public int getTextCharacters(int i5, char[] cArr, int i6, int i7) {
            int textCharacters;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        textCharacters = this._xs.getTextCharacters(i5, cArr, i6, i7);
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return textCharacters;
        }

        public String getNamespaceURI() {
            String namespaceURI;
            synchronized (this._l) {
                try {
                    this._l.enter();
                    try {
                        namespaceURI = this._xs.getNamespaceURI();
                        this._l.exit();
                    } catch (Throwable th) {
                        this._l.exit();
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return namespaceURI;
        }

        public NamespaceContext getNamespaceContext() {
            return this;
        }
    }
}
