package org.apache.xmlbeans.impl.store;

import A3.AbstractC0157z;
import androidx.webkit.ProxyConfig;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Source;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlRuntimeException;
import org.apache.xmlbeans.impl.common.Sax2Dom;
import org.apache.xmlbeans.impl.common.XMLChar;
import org.apache.xmlbeans.impl.soap.Detail;
import org.apache.xmlbeans.impl.soap.DetailEntry;
import org.apache.xmlbeans.impl.soap.MimeHeader;
import org.apache.xmlbeans.impl.soap.Name;
import org.apache.xmlbeans.impl.soap.SOAPBody;
import org.apache.xmlbeans.impl.soap.SOAPBodyElement;
import org.apache.xmlbeans.impl.soap.SOAPElement;
import org.apache.xmlbeans.impl.soap.SOAPEnvelope;
import org.apache.xmlbeans.impl.soap.SOAPFault;
import org.apache.xmlbeans.impl.soap.SOAPHeader;
import org.apache.xmlbeans.impl.soap.SOAPHeaderElement;
import org.apache.xmlbeans.impl.soap.SOAPPart;
import org.apache.xmlbeans.impl.values.NamespaceManager;
import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.EntityReference;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;
import org.w3c.dom.UserDataHandler;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class DomImpl {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int ATTR = 2;
    static final int CDATA = 4;
    static final int COMMENT = 8;
    static final int DOCFRAG = 11;
    static final int DOCTYPE = 10;
    static final int DOCUMENT = 9;
    static final int ELEMENT = 1;
    static final int ENTITY = 6;
    static final int ENTITYREF = 5;
    static final int NOTATION = 12;
    static final int PROCINST = 7;
    static final int TEXT = 3;
    public static final NodeList _emptyNodeList = new EmptyNodeList();

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface Dom {
        void dump();

        void dump(PrintStream printStream);

        void dump(PrintStream printStream, Object obj);

        QName getQName();

        Locale locale();

        boolean nodeCanHavePrefixUri();

        int nodeType();

        Cur tempCur();
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class DomLevel3NotImplemented extends RuntimeException {
        public DomLevel3NotImplemented() {
            super("DOM Level 3 Not implemented");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ElementsByTagNameNSNodeList extends ElementsNodeList {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final String _local;
        private final String _uri;

        public ElementsByTagNameNSNodeList(Dom dom, String str, String str2) {
            super(dom);
            this._uri = str == null ? "" : str;
            this._local = str2;
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.ElementsNodeList
        public boolean match(Dom dom) {
            if (this._uri.equals(ProxyConfig.MATCH_ALL_SCHEMES) || this._uri.equals(DomImpl._node_getNamespaceURI(dom))) {
                return this._local.equals(ProxyConfig.MATCH_ALL_SCHEMES) || this._local.equals(DomImpl._node_getLocalName(dom));
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ElementsByTagNameNodeList extends ElementsNodeList {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final String _name;

        public ElementsByTagNameNodeList(Dom dom, String str) {
            super(dom);
            this._name = str;
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.ElementsNodeList
        public boolean match(Dom dom) {
            return this._name.equals(ProxyConfig.MATCH_ALL_SCHEMES) || this._name.equals(DomImpl._node_getNodeName(dom));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static abstract class ElementsNodeList implements NodeList {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private ArrayList<Dom> _elements;
        private final Locale _locale;
        private final Dom _root;
        private long _version = 0;

        public ElementsNodeList(Dom dom) {
            this._root = dom;
            this._locale = dom.locale();
        }

        private void addElements(Dom dom) {
            Node nodeFirstChild = DomImpl.firstChild(dom);
            while (nodeFirstChild != null) {
                Dom dom2 = (Dom) nodeFirstChild;
                if (dom2.nodeType() == 1) {
                    if (match(dom2)) {
                        this._elements.add(dom2);
                    }
                    addElements(dom2);
                }
                nodeFirstChild = DomImpl.nextSibling(dom2);
            }
        }

        private void ensureElements() {
            if (this._version == this._locale.version()) {
                return;
            }
            this._version = this._locale.version();
            this._elements = new ArrayList<>();
            DomImpl.syncWrapHelper(this._locale, true, new C1461w(this, 19));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object lambda$ensureElements$0() {
            addElements(this._root);
            return null;
        }

        @Override // org.w3c.dom.NodeList
        public int getLength() {
            ensureElements();
            return this._elements.size();
        }

        @Override // org.w3c.dom.NodeList
        public Node item(int i5) {
            ensureElements();
            if (i5 < 0 || i5 >= this._elements.size()) {
                return null;
            }
            return (Node) this._elements.get(i5);
        }

        public abstract boolean match(Dom dom);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class EmptyNodeList implements NodeList {
        private EmptyNodeList() {
        }

        @Override // org.w3c.dom.NodeList
        public int getLength() {
            return 0;
        }

        @Override // org.w3c.dom.NodeList
        public Node item(int i5) {
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class HierarchyRequestErr extends DOMException {
        public HierarchyRequestErr(String str) {
            super((short) 3, str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class IndexSizeError extends DOMException {
        public IndexSizeError() {
            this("Index Size Error");
        }

        public IndexSizeError(String str) {
            super((short) 1, str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class InuseAttributeError extends DOMException {
        public InuseAttributeError() {
            this("Attribute currently in use error");
        }

        public InuseAttributeError(String str) {
            super((short) 10, str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class InvalidCharacterError extends DOMException {
        public InvalidCharacterError() {
            this("The name contains an invalid character");
        }

        public InvalidCharacterError(String str) {
            super((short) 5, str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class NamespaceErr extends DOMException {
        public NamespaceErr(String str) {
            super((short) 14, str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class NoModificationAllowedErr extends DOMException {
        public NoModificationAllowedErr(String str) {
            super((short) 7, str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class NotFoundErr extends DOMException {
        public NotFoundErr(String str) {
            super((short) 8, str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class NotSupportedError extends DOMException {
        public NotSupportedError(String str) {
            super((short) 9, str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class SaajData {
        Object _obj;

        private SaajData() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface WrapSoapEx<T> {
        T get();
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class WrongDocumentErr extends DOMException {
        public WrongDocumentErr(String str) {
            super((short) 4, str);
        }
    }

    public static Element _attr_getOwnerElement(Dom dom) {
        return (Element) syncWrap(dom, new m0(17));
    }

    public static boolean _attr_getSpecified(Dom dom) {
        return true;
    }

    public static int _attributes_getLength(Dom dom) {
        return ((Integer) syncWrap(dom, new m0(2))).intValue();
    }

    public static Node _attributes_getNamedItem(Dom dom, String str) {
        return (Node) syncWrap(dom, new A(dom, str, 7));
    }

    public static Node _attributes_getNamedItemNS(Dom dom, String str, String str2) {
        return (Node) syncWrap(dom, new C1464z(str, str2, 5));
    }

    public static Node _attributes_item(Dom dom, int i5) {
        return (Node) syncWrap(dom, new C(i5, 0));
    }

    public static Node _attributes_removeNamedItem(Dom dom, String str) {
        return (Node) syncWrap(dom, new B(str, 0));
    }

    public static Node _attributes_removeNamedItemNS(Dom dom, String str, String str2) {
        return (Node) syncWrap(dom, new C1464z(str, str2, 3));
    }

    public static Node _attributes_setNamedItem(Dom dom, Node node) {
        Locale locale = dom.locale();
        if (node == null) {
            throw new IllegalArgumentException("Attr to set is null");
        }
        if (node instanceof Dom) {
            Dom dom2 = (Dom) node;
            if (dom2.locale() == locale) {
                return (Node) syncWrap(dom, new G(1, dom2));
            }
        }
        throw new WrongDocumentErr("Attr to set is from another document");
    }

    public static Node _attributes_setNamedItemNS(Dom dom, Node node) {
        Locale locale = dom.locale();
        if (node == null) {
            throw new IllegalArgumentException("Attr to set is null");
        }
        if (node instanceof Dom) {
            Dom dom2 = (Dom) node;
            if (dom2.locale() == locale) {
                return (Node) syncWrap(dom, new G(2, dom2));
            }
        }
        throw new WrongDocumentErr("Attr to set is from another document");
    }

    public static void _characterData_appendData(Dom dom, String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        _node_setNodeValue(dom, _node_getNodeValue(dom) + str);
    }

    public static void _characterData_deleteData(Dom dom, int i5, int i6) {
        String str_characterData_getData = _characterData_getData(dom);
        if (i5 < 0 || i5 > str_characterData_getData.length() || i6 < 0) {
            throw new IndexSizeError();
        }
        if (i5 + i6 > str_characterData_getData.length()) {
            i6 = str_characterData_getData.length() - i5;
        }
        if (i6 > 0) {
            _characterData_setData(dom, str_characterData_getData.substring(0, i5) + str_characterData_getData.substring(i5 + i6));
        }
    }

    public static String _characterData_getData(Dom dom) {
        return _node_getNodeValue(dom);
    }

    public static int _characterData_getLength(Dom dom) {
        return _characterData_getData(dom).length();
    }

    public static void _characterData_insertData(Dom dom, int i5, String str) {
        String str_characterData_getData = _characterData_getData(dom);
        if (i5 < 0 || i5 > str_characterData_getData.length()) {
            throw new IndexSizeError();
        }
        if (str == null || str.length() <= 0) {
            return;
        }
        _characterData_setData(dom, str_characterData_getData.substring(0, i5) + str + str_characterData_getData.substring(i5));
    }

    public static void _characterData_replaceData(Dom dom, int i5, int i6, String str) {
        String str_characterData_getData = _characterData_getData(dom);
        if (i5 < 0 || i5 > str_characterData_getData.length() || i6 < 0) {
            throw new IndexSizeError();
        }
        if (i5 + i6 > str_characterData_getData.length()) {
            i6 = str_characterData_getData.length() - i5;
        }
        if (i6 > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(str_characterData_getData.substring(0, i5));
            if (str == null) {
                str = "";
            }
            sb.append(str);
            sb.append(str_characterData_getData.substring(i5 + i6));
            _characterData_setData(dom, sb.toString());
        }
    }

    public static void _characterData_setData(Dom dom, String str) {
        _node_setNodeValue(dom, str);
    }

    public static String _characterData_substringData(Dom dom, int i5, int i6) {
        String str_characterData_getData = _characterData_getData(dom);
        if (i5 < 0 || i5 > str_characterData_getData.length() || i6 < 0) {
            throw new IndexSizeError();
        }
        if (i5 + i6 > str_characterData_getData.length()) {
            i6 = str_characterData_getData.length() - i5;
        }
        return str_characterData_getData.substring(i5, i6 + i5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int _childNodes_getLength(Dom dom) {
        int domZeroOneChildren;
        Xobj xobj = (Xobj) dom;
        return (xobj.isVacant() || (domZeroOneChildren = xobj.getDomZeroOneChildren()) >= 2) ? ((Integer) syncWrapNoEnter(dom, new m0(15))).intValue() : domZeroOneChildren;
    }

    public static Node _childNodes_item(Dom dom, int i5) {
        return i5 == 0 ? _node_getFirstChild(dom) : (Node) syncWrapNoEnter(dom, new C(i5, 1));
    }

    public static Attr _document_createAttribute(Dom dom, String str) {
        return (Attr) syncWrap(dom, new B(str, 5));
    }

    public static Attr _document_createAttributeNS(Dom dom, String str, String str2) {
        return (Attr) syncWrap(dom, new C1464z(str, str2, 2));
    }

    public static CDATASection _document_createCDATASection(Dom dom, String str) {
        return document_createCDATASection(dom, str);
    }

    public static Comment _document_createComment(Dom dom, String str) {
        return (Comment) syncWrap(dom, new B(str, 2));
    }

    public static DocumentFragment _document_createDocumentFragment(Dom dom) {
        return (DocumentFragment) syncWrap(dom, new m0(6));
    }

    public static Element _document_createElement(Dom dom, String str) {
        return (Element) syncWrap(dom, new B(str, 4));
    }

    public static Element _document_createElementNS(Dom dom, String str, String str2) {
        return (Element) syncWrap(dom, new C1464z(str, str2, 4));
    }

    public static EntityReference _document_createEntityReference(Dom dom, String str) {
        throw new RuntimeException("Not implemented");
    }

    public static ProcessingInstruction _document_createProcessingInstruction(Dom dom, String str, String str2) {
        return (ProcessingInstruction) syncWrap(dom, new C1464z(str, str2, 6));
    }

    public static Text _document_createTextNode(Dom dom, String str) {
        return document_createTextNode(dom, str);
    }

    public static DocumentType _document_getDoctype(Dom dom) {
        return (DocumentType) syncWrap(dom, new m0(11));
    }

    public static Element _document_getDocumentElement(Dom dom) {
        return (Element) syncWrap(dom, new m0(3));
    }

    public static Element _document_getElementById(Dom dom, String str) {
        throw new RuntimeException("Not implemented");
    }

    public static NodeList _document_getElementsByTagName(Dom dom, String str) {
        return (NodeList) syncWrap(dom, new B(str, 3));
    }

    public static NodeList _document_getElementsByTagNameNS(Dom dom, String str, String str2) {
        return (NodeList) syncWrap(dom, new C1464z(str, str2, 1));
    }

    public static DOMImplementation _document_getImplementation(Dom dom) {
        return dom.locale();
    }

    public static Node _document_importNode(Dom dom, final Node node, final boolean z6) {
        return (Node) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.g0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DomImpl.lambda$_document_importNode$9(node, z6, (DomImpl.Dom) obj);
            }
        });
    }

    public static Document _domImplementation_createDocument(final Locale locale, final String str, final String str2, final DocumentType documentType) {
        return (Document) syncWrapHelper(locale, true, new Supplier() { // from class: org.apache.xmlbeans.impl.store.i0
            @Override // java.util.function.Supplier
            public final Object get() {
                return DomImpl.domImplementation_createDocument(locale, str, str2, documentType);
            }
        });
    }

    public static boolean _domImplementation_hasFeature(Locale locale, String str, String str2) {
        if (str == null) {
            return false;
        }
        if (str2 != null && str2.length() > 0 && !str2.equals("1.0") && !str2.equals("2.0")) {
            return false;
        }
        if (str.equalsIgnoreCase("core")) {
            return true;
        }
        return str.equalsIgnoreCase("xml");
    }

    public static String _element_getAttribute(Dom dom, String str) {
        Node node_attributes_getNamedItem = _attributes_getNamedItem(dom, str);
        return node_attributes_getNamedItem == null ? "" : node_attributes_getNamedItem.getNodeValue();
    }

    public static String _element_getAttributeNS(Dom dom, String str, String str2) {
        Node node_attributes_getNamedItemNS = _attributes_getNamedItemNS(dom, str, str2);
        return node_attributes_getNamedItemNS == null ? "" : node_attributes_getNamedItemNS.getNodeValue();
    }

    public static Attr _element_getAttributeNode(Dom dom, String str) {
        return (Attr) _attributes_getNamedItem(dom, str);
    }

    public static Attr _element_getAttributeNodeNS(Dom dom, String str, String str2) {
        return (Attr) _attributes_getNamedItemNS(dom, str, str2);
    }

    public static NodeList _element_getElementsByTagName(Dom dom, String str) {
        return (NodeList) syncWrap(dom, new B(str, 1));
    }

    public static NodeList _element_getElementsByTagNameNS(Dom dom, String str, String str2) {
        return (NodeList) syncWrap(dom, new C1464z(str, str2, 0));
    }

    public static String _element_getTagName(Dom dom) {
        return _node_getNodeName(dom);
    }

    public static boolean _element_hasAttribute(Dom dom, String str) {
        return _attributes_getNamedItem(dom, str) != null;
    }

    public static boolean _element_hasAttributeNS(Dom dom, String str, String str2) {
        return _attributes_getNamedItemNS(dom, str, str2) != null;
    }

    public static void _element_removeAttribute(Dom dom, String str) {
        try {
            _attributes_removeNamedItem(dom, str);
        } catch (NotFoundErr unused) {
        }
    }

    public static void _element_removeAttributeNS(Dom dom, String str, String str2) {
        try {
            _attributes_removeNamedItemNS(dom, str, str2);
        } catch (NotFoundErr unused) {
        }
    }

    public static Attr _element_removeAttributeNode(Dom dom, Attr attr) {
        if (attr == null) {
            throw new NotFoundErr("Attribute to remove is null");
        }
        if (attr.getOwnerElement() == dom) {
            return (Attr) _attributes_removeNamedItem(dom, attr.getNodeName());
        }
        throw new NotFoundErr("Attribute to remove does not belong to this element");
    }

    public static void _element_setAttribute(Dom dom, String str, String str2) {
        syncWrapVoid(dom, new F(str, str2));
    }

    public static void _element_setAttributeNS(Dom dom, String str, String str2, String str3) {
        syncWrapVoid(dom, new S(str, str2, str3));
    }

    public static Attr _element_setAttributeNode(Dom dom, Attr attr) {
        return (Attr) _attributes_setNamedItem(dom, attr);
    }

    public static Attr _element_setAttributeNodeNS(Dom dom, Attr attr) {
        return (Attr) _attributes_setNamedItemNS(dom, attr);
    }

    public static XmlCursor _getXmlCursor(Dom dom) {
        return (XmlCursor) syncWrap(dom, new m0(16));
    }

    public static XmlObject _getXmlObject(Dom dom) {
        return (XmlObject) syncWrap(dom, new m0(19));
    }

    public static XMLStreamReader _getXmlStreamReader(Dom dom) {
        return (XMLStreamReader) syncWrap(dom, new m0(10));
    }

    public static Node _node_appendChild(Dom dom, Node node) {
        return _node_insertBefore(dom, node, null);
    }

    public static Node _node_cloneNode(Dom dom, final boolean z6) {
        return (Node) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.W
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DomImpl.lambda$_node_cloneNode$13(z6, (DomImpl.Dom) obj);
            }
        });
    }

    public static short _node_compareDocumentPosition(Dom dom, Node node) {
        if (!(dom instanceof Node)) {
            return (short) 32;
        }
        Iterator<Node> it = ancestorAndSelf((Node) dom).iterator();
        Iterator<Node> it2 = ancestorAndSelf(node).iterator();
        boolean z6 = true;
        while (true) {
            Node next = it.next();
            Node next2 = it2.next();
            boolean zEquals = Objects.equals(next, next2);
            if (z6 && !zEquals) {
                return (short) 1;
            }
            if (!zEquals || !it.hasNext() || !it2.hasNext()) {
                if (zEquals) {
                    if (it.hasNext()) {
                        return (short) 10;
                    }
                    return it2.hasNext() ? (short) 20 : (short) 32;
                }
                do {
                    next = next.getPreviousSibling();
                    if (next == null) {
                        return (short) 4;
                    }
                } while (!next.equals(next2));
                return (short) 2;
            }
            z6 = false;
        }
    }

    public static String _node_getBaseURI(Dom dom) {
        throw new DomLevel3NotImplemented();
    }

    public static Object _node_getFeature(Dom dom, String str, String str2) {
        throw new DomLevel3NotImplemented();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Node _node_getFirstChild(Dom dom) {
        Xobj xobj = (Xobj) dom;
        if (!xobj.isVacant()) {
            if (xobj.isFirstChildPtrDomUsable()) {
                return (Node) xobj._firstChild;
            }
            Xobj xobjLastAttr = xobj.lastAttr();
            if (xobjLastAttr != null && xobjLastAttr.isNextSiblingPtrDomUsable()) {
                return (NodeXobj) xobjLastAttr._nextSibling;
            }
            if (xobj.isExistingCharNodesValueUsable()) {
                return xobj._charNodesValue;
            }
        }
        return (Node) syncWrapNoEnter(dom, new m0(9));
    }

    public static Node _node_getLastChild(Dom dom) {
        return (Node) syncWrap(dom, new m0(18));
    }

    public static String _node_getLocalName(Dom dom) {
        if (!dom.nodeCanHavePrefixUri()) {
            return null;
        }
        QName qName = dom.getQName();
        return qName == null ? "" : qName.getLocalPart();
    }

    public static String _node_getNamespaceURI(Dom dom) {
        if (!dom.nodeCanHavePrefixUri()) {
            return null;
        }
        QName qName = dom.getQName();
        return qName == null ? "" : qName.getNamespaceURI();
    }

    public static Node _node_getNextSibling(Dom dom) {
        return (Node) syncWrapNoEnter(dom, new m0(14));
    }

    public static String _node_getNodeName(Dom dom) {
        switch (dom.nodeType()) {
            case 1:
            case 2:
                QName qName = dom.getQName();
                String prefix = qName.getPrefix();
                if (prefix.length() == 0) {
                    return qName.getLocalPart();
                }
                StringBuilder sbX = AbstractC0157z.x(prefix, ParameterizedMessage.ERROR_MSG_SEPARATOR);
                sbX.append(qName.getLocalPart());
                return sbX.toString();
            case 3:
                return "#text";
            case 4:
                return "#cdata-section";
            case 5:
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not impl");
            case 7:
                return dom.getQName().getLocalPart();
            case 8:
                return "#comment";
            case 9:
                return "#document";
            case 11:
                return "#document-fragment";
            default:
                throw new RuntimeException("Unknown node type");
        }
    }

    public static short _node_getNodeType(Dom dom) {
        return (short) dom.nodeType();
    }

    public static String _node_getNodeValue(Dom dom) {
        return (String) syncWrapNoEnter(dom, new m0(20));
    }

    public static Document _node_getOwnerDocument(Dom dom) {
        return (Document) syncWrap(dom, new m0(7));
    }

    public static Node _node_getParentNode(Dom dom) {
        return (Node) syncWrap(dom, new m0(5));
    }

    public static String _node_getPrefix(Dom dom) {
        if (!dom.nodeCanHavePrefixUri()) {
            return null;
        }
        QName qName = dom.getQName();
        return qName == null ? "" : qName.getPrefix();
    }

    public static Node _node_getPreviousSibling(Dom dom) {
        return (Node) syncWrapNoEnter(dom, new m0(8));
    }

    public static String _node_getTextContent(Dom dom) {
        throw new DomLevel3NotImplemented();
    }

    public static Object _node_getUserData(Dom dom, String str) {
        throw new DomLevel3NotImplemented();
    }

    public static boolean _node_hasAttributes(Dom dom) {
        return ((Boolean) syncWrap(dom, new m0(12))).booleanValue();
    }

    public static boolean _node_hasChildNodes(Dom dom) {
        return (dom instanceof Xobj) && _node_getFirstChild(dom) != null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001e, code lost:
    
        if (r4.locale() == r0) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.w3c.dom.Node _node_insertBefore(org.apache.xmlbeans.impl.store.DomImpl.Dom r2, org.w3c.dom.Node r3, org.w3c.dom.Node r4) {
        /*
            org.apache.xmlbeans.impl.store.Locale r0 = r2.locale()
            if (r3 == 0) goto L3f
            boolean r1 = r3 instanceof org.apache.xmlbeans.impl.store.DomImpl.Dom
            if (r1 == 0) goto L37
            org.apache.xmlbeans.impl.store.DomImpl$Dom r3 = (org.apache.xmlbeans.impl.store.DomImpl.Dom) r3
            org.apache.xmlbeans.impl.store.Locale r1 = r3.locale()
            if (r1 != r0) goto L37
            if (r4 == 0) goto L29
            boolean r1 = r4 instanceof org.apache.xmlbeans.impl.store.DomImpl.Dom
            if (r1 == 0) goto L21
            org.apache.xmlbeans.impl.store.DomImpl$Dom r4 = (org.apache.xmlbeans.impl.store.DomImpl.Dom) r4
            org.apache.xmlbeans.impl.store.Locale r1 = r4.locale()
            if (r1 != r0) goto L21
            goto L2a
        L21:
            org.apache.xmlbeans.impl.store.DomImpl$WrongDocumentErr r2 = new org.apache.xmlbeans.impl.store.DomImpl$WrongDocumentErr
            java.lang.String r3 = "Reference child is from another document"
            r2.<init>(r3)
            throw r2
        L29:
            r4 = 0
        L2a:
            org.apache.xmlbeans.impl.store.Q r0 = new org.apache.xmlbeans.impl.store.Q
            r1 = 0
            r0.<init>(r3, r4, r1)
            java.lang.Object r2 = syncWrap(r2, r0)
            org.w3c.dom.Node r2 = (org.w3c.dom.Node) r2
            return r2
        L37:
            org.apache.xmlbeans.impl.store.DomImpl$WrongDocumentErr r2 = new org.apache.xmlbeans.impl.store.DomImpl$WrongDocumentErr
            java.lang.String r3 = "Child to add is from another document"
            r2.<init>(r3)
            throw r2
        L3f:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Child to add is null"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.store.DomImpl._node_insertBefore(org.apache.xmlbeans.impl.store.DomImpl$Dom, org.w3c.dom.Node, org.w3c.dom.Node):org.w3c.dom.Node");
    }

    public static boolean _node_isDefaultNamespace(Dom dom, String str) {
        throw new DomLevel3NotImplemented();
    }

    public static boolean _node_isEqualNode(Dom dom, Node node) {
        throw new DomLevel3NotImplemented();
    }

    public static boolean _node_isSameNode(Dom dom, Node node) {
        if (dom instanceof CharNode) {
            return dom.equals(node);
        }
        if (dom instanceof NodeXobj) {
            return ((NodeXobj) dom).getDom().equals(node);
        }
        throw new DomLevel3NotImplemented();
    }

    public static boolean _node_isSupported(Dom dom, String str, String str2) {
        return _domImplementation_hasFeature(dom.locale(), str, str2);
    }

    public static String _node_lookupNamespaceURI(Dom dom, String str) {
        throw new DomLevel3NotImplemented();
    }

    public static String _node_lookupPrefix(Dom dom, String str) {
        throw new DomLevel3NotImplemented();
    }

    public static void _node_normalize(Dom dom) {
        syncWrapVoid(dom, new O());
    }

    public static Node _node_removeChild(Dom dom, Node node) {
        Locale locale = dom.locale();
        if (node == null) {
            throw new NotFoundErr("Child to remove is null");
        }
        if (node instanceof Dom) {
            Dom dom2 = (Dom) node;
            if (dom2.locale() == locale) {
                return (Node) syncWrap(dom, new G(0, dom2));
            }
        }
        throw new WrongDocumentErr("Child to remove is from another document");
    }

    public static Node _node_replaceChild(Dom dom, Node node, Node node2) {
        Locale locale = dom.locale();
        if (node == null) {
            throw new IllegalArgumentException("Child to add is null");
        }
        if (node2 == null) {
            throw new NotFoundErr("Child to replace is null");
        }
        if (node instanceof Dom) {
            Dom dom2 = (Dom) node;
            if (dom2.locale() == locale) {
                if (node2 instanceof Dom) {
                    Dom dom3 = (Dom) node2;
                    if (dom3.locale() == locale) {
                        return (Node) syncWrap(dom, new Q(dom2, dom3, 1));
                    }
                }
                throw new WrongDocumentErr("Child to replace is from another document");
            }
        }
        throw new WrongDocumentErr("Child to add is from another document");
    }

    public static void _node_setNodeValue(Dom dom, String str) {
        syncWrapVoid(dom, new Z(str, 1));
    }

    public static void _node_setPrefix(Dom dom, String str) {
        syncWrapVoid(dom, new Z(str, 0));
    }

    public static void _node_setTextContent(Dom dom, String str) {
        throw new DomLevel3NotImplemented();
    }

    public static Object _node_setUserData(Dom dom, String str, Object obj, UserDataHandler userDataHandler) {
        throw new DomLevel3NotImplemented();
    }

    public static String _processingInstruction_getData(Dom dom) {
        return _node_getNodeValue(dom);
    }

    public static String _processingInstruction_getTarget(Dom dom) {
        return _node_getNodeName(dom);
    }

    public static void _processingInstruction_setData(Dom dom, String str) {
        _node_setNodeValue(dom, str);
    }

    public static SOAPElement _soapElement_addAttribute(Dom dom, Name name, String str) {
        return (SOAPElement) syncWrapEx(dom, new C1447h(dom, (SOAPElement) dom, name, str, 1));
    }

    public static SOAPElement _soapElement_addChildElement(Dom dom, SOAPElement sOAPElement) {
        return (SOAPElement) syncWrapEx(dom, new C1451l(dom, 8, (SOAPElement) dom, sOAPElement));
    }

    public static SOAPElement _soapElement_addNamespaceDeclaration(Dom dom, final String str, final String str2) {
        final SOAPElement sOAPElement = (SOAPElement) dom;
        return (SOAPElement) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.h0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DomImpl.lambda$_soapElement_addNamespaceDeclaration$48(sOAPElement, str, str2, (DomImpl.Dom) obj);
            }
        });
    }

    public static SOAPElement _soapElement_addTextNode(Dom dom, String str) {
        return (SOAPElement) syncWrap(dom, new N((SOAPElement) dom, str, 2));
    }

    public static Iterator<Name> _soapElement_getAllAttributes(Dom dom) {
        return (Iterator) syncWrap(dom, new L((SOAPElement) dom, 0));
    }

    public static String _soapElement_getAttributeValue(Dom dom, Name name) {
        return (String) syncWrap(dom, new P((SOAPElement) dom, name, 1));
    }

    public static Iterator<SOAPElement> _soapElement_getChildElements(Dom dom) {
        return (Iterator) syncWrap(dom, new L((SOAPElement) dom, 4));
    }

    public static Name _soapElement_getElementName(Dom dom) {
        return (Name) syncWrap(dom, new L((SOAPElement) dom, 2));
    }

    public static String _soapElement_getEncodingStyle(Dom dom) {
        return (String) syncWrap(dom, new L((SOAPElement) dom, 5));
    }

    public static Iterator<String> _soapElement_getNamespacePrefixes(Dom dom) {
        return (Iterator) syncWrap(dom, new L((SOAPElement) dom, 1));
    }

    public static String _soapElement_getNamespaceURI(Dom dom, String str) {
        return (String) syncWrap(dom, new N((SOAPElement) dom, str, 1));
    }

    public static Iterator<String> _soapElement_getVisibleNamespacePrefixes(Dom dom) {
        return (Iterator) syncWrap(dom, new L((SOAPElement) dom, 3));
    }

    public static boolean _soapElement_removeAttribute(Dom dom, Name name) {
        return ((Boolean) syncWrap(dom, new P((SOAPElement) dom, name, 2))).booleanValue();
    }

    public static void _soapElement_removeContents(Dom dom) {
        syncWrapVoid(dom, new E((SOAPElement) dom, 2));
    }

    public static boolean _soapElement_removeNamespaceDeclaration(Dom dom, String str) {
        return ((Boolean) syncWrap(dom, new N((SOAPElement) dom, str, 0))).booleanValue();
    }

    public static void _soapElement_setEncodingStyle(Dom dom, String str) {
        syncWrapVoid(dom, new F((SOAPElement) dom, str, 4));
    }

    public static SOAPBody _soapEnvelope_addBody(Dom dom) {
        return (SOAPBody) syncWrapEx(dom, new H(dom, (SOAPEnvelope) dom, 3));
    }

    public static SOAPHeader _soapEnvelope_addHeader(Dom dom) {
        return (SOAPHeader) syncWrapEx(dom, new H(dom, (SOAPEnvelope) dom, 2));
    }

    public static Name _soapEnvelope_createName(Dom dom, String str) {
        return (Name) syncWrap(dom, new A((SOAPEnvelope) dom, str, 3));
    }

    public static SOAPBody _soapEnvelope_getBody(Dom dom) {
        return (SOAPBody) syncWrapEx(dom, new H(dom, (SOAPEnvelope) dom, 0));
    }

    public static SOAPHeader _soapEnvelope_getHeader(Dom dom) {
        return (SOAPHeader) syncWrapEx(dom, new H(dom, (SOAPEnvelope) dom, 1));
    }

    public static void _soapNode_detachNode(Dom dom) {
        syncWrapVoid(dom, new U((org.apache.xmlbeans.impl.soap.Node) dom, 1));
    }

    public static SOAPElement _soapNode_getParentElement(Dom dom) {
        return (SOAPElement) syncWrap(dom, new M((org.apache.xmlbeans.impl.soap.Node) dom, 0));
    }

    public static String _soapNode_getValue(Dom dom) {
        return (String) syncWrap(dom, new M((org.apache.xmlbeans.impl.soap.Node) dom, 1));
    }

    public static void _soapNode_recycleNode(Dom dom) {
        syncWrapVoid(dom, new U((org.apache.xmlbeans.impl.soap.Node) dom, 0));
    }

    public static void _soapNode_setParentElement(Dom dom, SOAPElement sOAPElement) {
        syncWrapVoid(dom, new F((org.apache.xmlbeans.impl.soap.Node) dom, sOAPElement, 1));
    }

    public static void _soapNode_setValue(Dom dom, String str) {
        syncWrapVoid(dom, new F((org.apache.xmlbeans.impl.soap.Node) dom, str, 0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void _soapPart_addMimeHeader(Dom dom, String str, String str2) {
        syncWrapVoid(dom, new C1463y((SOAPPart) dom, str, str2, 1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Iterator<MimeHeader> _soapPart_getAllMimeHeaders(Dom dom) {
        return (Iterator) syncWrap(dom, new D((SOAPPart) dom, 2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Source _soapPart_getContent(Dom dom) {
        return (Source) syncWrap(dom, new D((SOAPPart) dom, 0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static SOAPEnvelope _soapPart_getEnvelope(Dom dom) {
        return (SOAPEnvelope) syncWrap(dom, new D((SOAPPart) dom, 1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Iterator<MimeHeader> _soapPart_getMatchingMimeHeaders(Dom dom, String[] strArr) {
        return (Iterator) syncWrap(dom, new c0((SOAPPart) dom, strArr, 1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String[] _soapPart_getMimeHeader(Dom dom, String str) {
        return (String[]) syncWrap(dom, new A((SOAPPart) dom, str, 6));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Iterator<MimeHeader> _soapPart_getNonMatchingMimeHeaders(Dom dom, String[] strArr) {
        return (Iterator) syncWrap(dom, new c0((SOAPPart) dom, strArr, 0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void _soapPart_removeAllMimeHeaders(Dom dom) {
        syncWrapVoid(dom, new E((SOAPPart) dom, 0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void _soapPart_removeMimeHeader(Dom dom, String str) {
        syncWrapVoid(dom, new F((SOAPPart) dom, str, 2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void _soapPart_setContent(Dom dom, Source source) {
        syncWrapVoid(dom, new F((SOAPPart) dom, source, 6));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void _soapPart_setMimeHeader(Dom dom, String str, String str2) {
        syncWrapVoid(dom, new C1463y((SOAPPart) dom, str, str2, 0));
    }

    public static boolean _soapText_isComment(Dom dom) {
        return ((Boolean) syncWrap(dom, new d0((org.apache.xmlbeans.impl.soap.Text) dom, 1))).booleanValue();
    }

    public static String _text_getWholeText(Dom dom) {
        throw new DomLevel3NotImplemented();
    }

    public static boolean _text_isElementContentWhitespace(Dom dom) {
        throw new DomLevel3NotImplemented();
    }

    public static Text _text_replaceWholeText(Dom dom, String str) {
        throw new DomLevel3NotImplemented();
    }

    public static Text _text_splitText(Dom dom, int i5) {
        String str_characterData_getData = _characterData_getData(dom);
        if (i5 < 0 || i5 > str_characterData_getData.length()) {
            throw new IndexSizeError();
        }
        _characterData_deleteData(dom, i5, str_characterData_getData.length() - i5);
        Dom dom2 = (Dom) _document_createTextNode(dom, str_characterData_getData.substring(i5));
        Dom dom3 = (Dom) _node_getParentNode(dom);
        if (dom3 != null) {
            _node_insertBefore(dom3, (Text) dom2, _node_getNextSibling(dom));
            dom.locale().invalidateDomCaches(dom3);
        }
        return (Text) dom2;
    }

    private static List<Node> ancestorAndSelf(Node node) {
        LinkedList linkedList = new LinkedList();
        do {
            linkedList.addFirst(node);
            node = node.getParentNode();
        } while (node != null);
        return linkedList;
    }

    public static Node append(Dom dom, Dom dom2) {
        return node_insertBefore(dom2, dom, null);
    }

    public static Element attr_getOwnerElement(Dom dom) {
        Cur curTempCur = dom.tempCur();
        if (!curTempCur.toParentRaw()) {
            curTempCur.release();
            return null;
        }
        Dom dom2 = curTempCur.getDom();
        curTempCur.release();
        return (Element) dom2;
    }

    public static int attributes_getLength(Dom dom) {
        Cur curTempCur = dom.tempCur();
        int i5 = 0;
        while (curTempCur.toNextAttr()) {
            i5++;
        }
        curTempCur.release();
        return i5;
    }

    public static Node attributes_getNamedItem(Dom dom, String str) {
        Dom dom2;
        Cur curTempCur = dom.tempCur();
        while (curTempCur.toNextAttr()) {
            dom2 = curTempCur.getDom();
            if (_node_getNodeName(dom2).equals(str)) {
                curTempCur.release();
                return (Node) dom2;
            }
        }
        dom2 = null;
        curTempCur.release();
        return (Node) dom2;
    }

    public static Node attributes_getNamedItemNS(Dom dom, String str, String str2) {
        Dom dom2;
        if (str == null) {
            str = "";
        }
        Cur curTempCur = dom.tempCur();
        while (curTempCur.toNextAttr()) {
            dom2 = curTempCur.getDom();
            QName qName = dom2.getQName();
            if (qName.getNamespaceURI().equals(str) && qName.getLocalPart().equals(str2)) {
                curTempCur.release();
                return (Node) dom2;
            }
        }
        dom2 = null;
        curTempCur.release();
        return (Node) dom2;
    }

    public static Node attributes_item(Dom dom, int i5) {
        Dom dom2 = null;
        if (i5 < 0) {
            return null;
        }
        Cur curTempCur = dom.tempCur();
        while (curTempCur.toNextAttr()) {
            int i6 = i5 - 1;
            if (i5 == 0) {
                dom2 = curTempCur.getDom();
                break;
            }
            i5 = i6;
        }
        curTempCur.release();
        return (Node) dom2;
    }

    public static Node attributes_removeNamedItem(Dom dom, String str) {
        Cur curTempCur = dom.tempCur();
        Dom dom2 = null;
        while (curTempCur.toNextAttr()) {
            Dom dom3 = curTempCur.getDom();
            if (_node_getNodeName(dom3).equals(str)) {
                if (dom2 == null) {
                    dom2 = dom3;
                }
                if (((AttrXobj) dom3).isId()) {
                    Document documentNode_getOwnerDocument = node_getOwnerDocument(dom3);
                    String strNode_getNodeValue = node_getNodeValue(dom3);
                    if (documentNode_getOwnerDocument instanceof DocumentXobj) {
                        ((DocumentXobj) documentNode_getOwnerDocument).removeIdElement(strNode_getNodeValue);
                    }
                }
                removeNode(dom3);
                curTempCur.toPrevAttr();
            }
        }
        curTempCur.release();
        if (dom2 != null) {
            return (Node) dom2;
        }
        throw new NotFoundErr(AbstractC0157z.n("Named item not found: ", str));
    }

    public static Node attributes_removeNamedItemNS(Dom dom, String str, String str2) {
        if (str == null) {
            str = "";
        }
        Cur curTempCur = dom.tempCur();
        Dom dom2 = null;
        while (curTempCur.toNextAttr()) {
            Dom dom3 = curTempCur.getDom();
            QName qName = dom3.getQName();
            if (qName.getNamespaceURI().equals(str) && qName.getLocalPart().equals(str2)) {
                if (dom2 == null) {
                    dom2 = dom3;
                }
                if (((AttrXobj) dom3).isId()) {
                    Document documentNode_getOwnerDocument = node_getOwnerDocument(dom3);
                    String strNode_getNodeValue = node_getNodeValue(dom3);
                    if (documentNode_getOwnerDocument instanceof DocumentXobj) {
                        ((DocumentXobj) documentNode_getOwnerDocument).removeIdElement(strNode_getNodeValue);
                    }
                }
                removeNode(dom3);
                curTempCur.toPrevAttr();
            }
        }
        curTempCur.release();
        if (dom2 != null) {
            return (Node) dom2;
        }
        throw new NotFoundErr(androidx.exifinterface.media.a.m("Named item not found: uri=", str, ", local=", str2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Node attributes_setNamedItem(Dom dom, Dom dom2) {
        if (attr_getOwnerElement(dom2) != null) {
            throw new InuseAttributeError();
        }
        if (dom2.nodeType() != 2) {
            throw new HierarchyRequestErr("Node is not an attribute");
        }
        String str_node_getNodeName = _node_getNodeName(dom2);
        Cur curTempCur = dom.tempCur();
        Dom dom3 = null;
        while (curTempCur.toNextAttr()) {
            Dom dom4 = curTempCur.getDom();
            if (_node_getNodeName(dom4).equals(str_node_getNodeName)) {
                if (dom3 == null) {
                    dom3 = dom4;
                } else {
                    removeNode(dom4);
                    curTempCur.toPrevAttr();
                }
            }
        }
        if (dom3 == null) {
            curTempCur.moveToDom(dom);
            curTempCur.next();
            Cur.moveNode((Xobj) dom2, curTempCur);
        } else {
            curTempCur.moveToDom(dom3);
            Cur.moveNode((Xobj) dom2, curTempCur);
            removeNode(dom3);
        }
        curTempCur.release();
        return (Node) dom3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Node attributes_setNamedItemNS(Dom dom, Dom dom2) {
        Element elementAttr_getOwnerElement = attr_getOwnerElement(dom2);
        if (elementAttr_getOwnerElement == dom) {
            return (Node) dom2;
        }
        if (elementAttr_getOwnerElement != null) {
            throw new InuseAttributeError();
        }
        if (dom2.nodeType() != 2) {
            throw new HierarchyRequestErr("Node is not an attribute");
        }
        QName qName = dom2.getQName();
        Cur curTempCur = dom.tempCur();
        Dom dom3 = null;
        while (curTempCur.toNextAttr()) {
            Dom dom4 = curTempCur.getDom();
            if (dom4.getQName().equals(qName)) {
                if (dom3 == null) {
                    dom3 = dom4;
                } else {
                    removeNode(dom4);
                    curTempCur.toPrevAttr();
                }
            }
        }
        if (dom3 == null) {
            curTempCur.moveToDom(dom);
            curTempCur.next();
            Cur.moveNode((Xobj) dom2, curTempCur);
        } else {
            curTempCur.moveToDom(dom3);
            Cur.moveNode((Xobj) dom2, curTempCur);
            removeNode(dom3);
        }
        curTempCur.release();
        return (Node) dom3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int childNodes_getLength(Dom dom) {
        switch (dom.nodeType()) {
            case 3:
            case 4:
            case 7:
            case 8:
                return 0;
            case 5:
                throw new RuntimeException("Not impl");
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not impl");
            case 9:
            case 11:
            default:
                Xobj xobj = (Xobj) dom;
                xobj.ensureOccupancy();
                int domZeroOneChildren = xobj.getDomZeroOneChildren();
                return domZeroOneChildren < 2 ? domZeroOneChildren : dom.locale().domLength(dom);
        }
    }

    public static Node childNodes_item(Dom dom, int i5) {
        if (i5 < 0) {
            return null;
        }
        switch (dom.nodeType()) {
            case 3:
            case 4:
            case 7:
            case 8:
                return null;
            case 5:
                throw new RuntimeException("Not impl");
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not impl");
            case 9:
            case 11:
            default:
                return i5 == 0 ? node_getFirstChild(dom) : (Node) dom.locale().findDomNthChild(dom, i5);
        }
    }

    public static DetailEntry detail_addDetailEntry(Dom dom, Name name) {
        return (DetailEntry) syncWrap(dom, new A((Detail) dom, name, 1));
    }

    public static Iterator<DetailEntry> detail_getDetailEntries(Dom dom) {
        return (Iterator) syncWrap(dom, new d0((Detail) dom, 0));
    }

    public static Attr document_createAttribute(Dom dom, String str) {
        validateName(str);
        Locale locale = dom.locale();
        Cur curTempCur = locale.tempCur();
        curTempCur.createAttr(locale.makeQualifiedQName("", str));
        AttrXobj attrXobj = (AttrXobj) curTempCur.getDom();
        curTempCur.release();
        attrXobj._canHavePrefixUri = false;
        return attrXobj;
    }

    public static Attr document_createAttributeNS(Dom dom, String str, String str2) {
        validateQualifiedName(str2, str, true);
        Locale locale = dom.locale();
        Cur curTempCur = locale.tempCur();
        curTempCur.createAttr(locale.makeQualifiedQName(str, str2));
        Dom dom2 = curTempCur.getDom();
        curTempCur.release();
        return (Attr) dom2;
    }

    public static CDATASection document_createCDATASection(Dom dom, String str) {
        CdataNode cdataNodeCreateCdataNode = dom.locale().createCdataNode();
        if (str == null) {
            str = "";
        }
        cdataNodeCreateCdataNode.setChars(str, 0, str.length());
        return cdataNodeCreateCdataNode;
    }

    public static Comment document_createComment(Dom dom, String str) {
        Cur curTempCur = dom.locale().tempCur();
        curTempCur.createComment();
        Dom dom2 = curTempCur.getDom();
        if (str != null) {
            curTempCur.next();
            curTempCur.insertString(str);
        }
        curTempCur.release();
        return (Comment) dom2;
    }

    public static DocumentFragment document_createDocumentFragment(Dom dom) {
        Cur curTempCur = dom.locale().tempCur();
        curTempCur.createDomDocFragRoot();
        Dom dom2 = curTempCur.getDom();
        curTempCur.release();
        return (DocumentFragment) dom2;
    }

    public static Element document_createElement(Dom dom, String str) {
        validateName(str);
        Locale locale = dom.locale();
        Cur curTempCur = locale.tempCur();
        curTempCur.createElement(locale.makeQualifiedQName("", str));
        ElementXobj elementXobj = (ElementXobj) curTempCur.getDom();
        curTempCur.release();
        elementXobj._canHavePrefixUri = false;
        return elementXobj;
    }

    public static Element document_createElementNS(Dom dom, String str, String str2) {
        validateQualifiedName(str2, str, false);
        Locale locale = dom.locale();
        Cur curTempCur = locale.tempCur();
        curTempCur.createElement(locale.makeQualifiedQName(str, str2));
        Dom dom2 = curTempCur.getDom();
        curTempCur.release();
        return (Element) dom2;
    }

    public static ProcessingInstruction document_createProcessingInstruction(Dom dom, String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Target is null");
        }
        if (str.length() == 0) {
            throw new IllegalArgumentException("Target is empty");
        }
        if (!XMLChar.isValidName(str)) {
            throw new InvalidCharacterError("Target has an invalid character");
        }
        if (Locale.beginsWithXml(str) && str.length() == 3) {
            throw new InvalidCharacterError("Invalid target - is 'xml'");
        }
        Cur curTempCur = dom.locale().tempCur();
        curTempCur.createProcinst(str);
        Dom dom2 = curTempCur.getDom();
        if (str2 != null) {
            curTempCur.next();
            curTempCur.insertString(str2);
        }
        curTempCur.release();
        return (ProcessingInstruction) dom2;
    }

    public static Text document_createTextNode(Dom dom, String str) {
        TextNode textNodeCreateTextNode = dom.locale().createTextNode();
        if (str == null) {
            str = "";
        }
        textNodeCreateTextNode.setChars(str, 0, str.length());
        return textNodeCreateTextNode;
    }

    public static DocumentType document_getDoctype(Dom dom) {
        return null;
    }

    public static Element document_getDocumentElement(Dom dom) {
        Node nodeFirstChild = firstChild(dom);
        while (nodeFirstChild != null) {
            Dom dom2 = (Dom) nodeFirstChild;
            if (dom2.nodeType() == 1) {
                return (Element) nodeFirstChild;
            }
            nodeFirstChild = nextSibling(dom2);
        }
        return null;
    }

    public static NodeList document_getElementsByTagName(Dom dom, String str) {
        return new ElementsByTagNameNodeList(dom, str);
    }

    public static NodeList document_getElementsByTagNameNS(Dom dom, String str, String str2) {
        return new ElementsByTagNameNSNodeList(dom, str, str2);
    }

    /* JADX WARN: Code duplicated, block: B:66:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:69:0x0107 A[LOOP:0: B:67:0x0101->B:69:0x0107, LOOP_END] */
    public static Node document_importNode(Dom dom, Node node, boolean z6) {
        Node nodeDocument_createElement;
        Attr attrDocument_createAttribute;
        NodeList childNodes;
        if (node == null) {
            return null;
        }
        switch (node.getNodeType()) {
            case 1:
                String localName = node.getLocalName();
                if (localName == null || localName.length() == 0) {
                    nodeDocument_createElement = document_createElement(dom, node.getNodeName());
                } else {
                    String prefix = node.getPrefix();
                    if (prefix != null && prefix.length() != 0) {
                        localName = androidx.collection.a.o(prefix, ParameterizedMessage.ERROR_MSG_SEPARATOR, localName);
                    }
                    String namespaceURI = node.getNamespaceURI();
                    nodeDocument_createElement = (namespaceURI == null || namespaceURI.length() == 0) ? document_createElement(dom, localName) : document_createElementNS(dom, namespaceURI, localName);
                }
                NamedNodeMap attributes = node.getAttributes();
                for (int i5 = 0; i5 < attributes.getLength(); i5++) {
                    attributes_setNamedItem((Dom) nodeDocument_createElement, (Dom) document_importNode(dom, attributes.item(i5), true));
                }
                if (z6) {
                    childNodes = node.getChildNodes();
                    for (int i6 = 0; i6 < childNodes.getLength(); i6++) {
                        node_insertBefore((Dom) nodeDocument_createElement, (Dom) document_importNode(dom, childNodes.item(i6), true), null);
                    }
                }
                return nodeDocument_createElement;
            case 2:
                String localName2 = node.getLocalName();
                if (localName2 == null || localName2.length() == 0) {
                    attrDocument_createAttribute = document_createAttribute(dom, node.getNodeName());
                } else {
                    String prefix2 = node.getPrefix();
                    if (prefix2 != null && prefix2.length() != 0) {
                        localName2 = androidx.collection.a.o(prefix2, ParameterizedMessage.ERROR_MSG_SEPARATOR, localName2);
                    }
                    String namespaceURI2 = node.getNamespaceURI();
                    attrDocument_createAttribute = (namespaceURI2 == null || namespaceURI2.length() == 0) ? document_createAttribute(dom, localName2) : document_createAttributeNS(dom, namespaceURI2, localName2);
                }
                nodeDocument_createElement = attrDocument_createAttribute;
                z6 = true;
                if (z6) {
                    childNodes = node.getChildNodes();
                    while (i6 < childNodes.getLength()) {
                        node_insertBefore((Dom) nodeDocument_createElement, (Dom) document_importNode(dom, childNodes.item(i6), true), null);
                    }
                }
                return nodeDocument_createElement;
            case 3:
                nodeDocument_createElement = document_createTextNode(dom, node.getNodeValue());
                z6 = false;
                if (z6) {
                    childNodes = node.getChildNodes();
                    while (i6 < childNodes.getLength()) {
                        node_insertBefore((Dom) nodeDocument_createElement, (Dom) document_importNode(dom, childNodes.item(i6), true), null);
                    }
                }
                return nodeDocument_createElement;
            case 4:
                nodeDocument_createElement = document_createCDATASection(dom, node.getNodeValue());
                z6 = false;
                if (z6) {
                    childNodes = node.getChildNodes();
                    while (i6 < childNodes.getLength()) {
                        node_insertBefore((Dom) nodeDocument_createElement, (Dom) document_importNode(dom, childNodes.item(i6), true), null);
                    }
                }
                return nodeDocument_createElement;
            case 5:
            case 6:
            case 12:
                throw new RuntimeException("Not impl");
            case 7:
                nodeDocument_createElement = document_createProcessingInstruction(dom, node.getNodeName(), node.getNodeValue());
                z6 = false;
                if (z6) {
                    childNodes = node.getChildNodes();
                    while (i6 < childNodes.getLength()) {
                        node_insertBefore((Dom) nodeDocument_createElement, (Dom) document_importNode(dom, childNodes.item(i6), true), null);
                    }
                }
                return nodeDocument_createElement;
            case 8:
                nodeDocument_createElement = document_createComment(dom, node.getNodeValue());
                z6 = false;
                if (z6) {
                    childNodes = node.getChildNodes();
                    while (i6 < childNodes.getLength()) {
                        node_insertBefore((Dom) nodeDocument_createElement, (Dom) document_importNode(dom, childNodes.item(i6), true), null);
                    }
                }
                return nodeDocument_createElement;
            case 9:
                throw new NotSupportedError("Document nodes may not be imported");
            case 10:
                throw new NotSupportedError("Document type nodes may not be imported");
            case 11:
                nodeDocument_createElement = document_createDocumentFragment(dom);
                if (z6) {
                    childNodes = node.getChildNodes();
                    while (i6 < childNodes.getLength()) {
                        node_insertBefore((Dom) nodeDocument_createElement, (Dom) document_importNode(dom, childNodes.item(i6), true), null);
                    }
                }
                return nodeDocument_createElement;
            default:
                throw new RuntimeException("Unknown kind");
        }
    }

    public static Document domImplementation_createDocument(Locale locale, String str, String str2, DocumentType documentType) {
        validateQualifiedName(str2, str, false);
        Cur curTempCur = locale.tempCur();
        curTempCur.createDomDocumentRoot();
        Document document = (Document) curTempCur.getDom();
        curTempCur.next();
        curTempCur.createElement(locale.makeQualifiedQName(str, str2));
        if (documentType != null) {
            throw new RuntimeException("Not impl");
        }
        curTempCur.toParent();
        try {
            Locale.autoTypeDocument(curTempCur, null, null);
            curTempCur.release();
            return document;
        } catch (XmlException e) {
            throw new XmlRuntimeException(e);
        }
    }

    public static NodeList element_getElementsByTagName(Dom dom, String str) {
        return new ElementsByTagNameNodeList(dom, str);
    }

    public static NodeList element_getElementsByTagNameNS(Dom dom, String str, String str2) {
        return new ElementsByTagNameNSNodeList(dom, str, str2);
    }

    public static void element_setAttribute(Dom dom, String str, String str2) {
        Object objAttributes_getNamedItem = attributes_getNamedItem(dom, str);
        if (objAttributes_getNamedItem == null) {
            Dom dom2 = (Dom) node_getOwnerDocument(dom);
            if (dom2 == null) {
                throw new NotFoundErr("Document element can't be determined.");
            }
            objAttributes_getNamedItem = document_createAttribute(dom2, str);
            attributes_setNamedItem(dom, (Dom) objAttributes_getNamedItem);
        }
        node_setNodeValue((Dom) objAttributes_getNamedItem, str2);
    }

    public static void element_setAttributeNS(Dom dom, String str, String str2, String str3) {
        validateQualifiedName(str2, str, true);
        QName qNameMakeQualifiedQName = dom.locale().makeQualifiedQName(str, str2);
        String localPart = qNameMakeQualifiedQName.getLocalPart();
        String strValidatePrefix = validatePrefix(qNameMakeQualifiedQName.getPrefix(), str, localPart, true);
        Object objAttributes_getNamedItemNS = attributes_getNamedItemNS(dom, str, localPart);
        if (objAttributes_getNamedItemNS == null) {
            objAttributes_getNamedItemNS = document_createAttributeNS((Dom) node_getOwnerDocument(dom), str, localPart);
            attributes_setNamedItemNS(dom, (Dom) objAttributes_getNamedItemNS);
        }
        Dom dom2 = (Dom) objAttributes_getNamedItemNS;
        node_setPrefix(dom2, strValidatePrefix);
        node_setNodeValue(dom2, str3);
    }

    public static Node firstChild(Dom dom) {
        return node_getFirstChild(dom);
    }

    public static XmlCursor getXmlCursor(Dom dom) {
        Cur curTempCur = dom.tempCur();
        Cursor cursor = new Cursor(curTempCur);
        curTempCur.release();
        return cursor;
    }

    public static XmlObject getXmlObject(Dom dom) {
        Cur curTempCur = dom.tempCur();
        XmlObject object = curTempCur.getObject();
        curTempCur.release();
        return object;
    }

    public static XMLStreamReader getXmlStreamReader(Dom dom) {
        XMLStreamReader xMLStreamReaderNewXmlStreamReader;
        switch (dom.nodeType()) {
            case 1:
            case 2:
            case 7:
            case 8:
            case 9:
            case 11:
                Cur curTempCur = dom.tempCur();
                XMLStreamReader xMLStreamReaderNewXmlStreamReader2 = Jsr173.newXmlStreamReader(curTempCur, null);
                curTempCur.release();
                return xMLStreamReaderNewXmlStreamReader2;
            case 3:
            case 4:
                CharNode charNode = (CharNode) dom;
                Cur curTempCur2 = charNode.tempCur();
                if (curTempCur2 == null) {
                    curTempCur2 = dom.locale().tempCur();
                    xMLStreamReaderNewXmlStreamReader = Jsr173.newXmlStreamReader(curTempCur2, charNode.getObject(), charNode._off, charNode._cch);
                } else {
                    xMLStreamReaderNewXmlStreamReader = Jsr173.newXmlStreamReader(curTempCur2, curTempCur2.getChars(charNode._cch), curTempCur2._offSrc, curTempCur2._cchSrc);
                }
                curTempCur2.release();
                return xMLStreamReaderNewXmlStreamReader;
            case 5:
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not impl");
            default:
                throw new RuntimeException("Unknown kind");
        }
    }

    public static Element impl_saajCallback_createSoapElement(Dom dom, QName qName, QName qName2) {
        Cur curTempCur = dom.locale().tempCur();
        curTempCur.createElement(qName, qName2);
        Dom dom2 = curTempCur.getDom();
        curTempCur.release();
        return (Element) dom2;
    }

    public static Text impl_saajCallback_ensureSoapTextNode(Dom dom) {
        return null;
    }

    public static Object impl_saajCallback_getSaajData(Dom dom) {
        Cur curTempCur = dom.locale().tempCur();
        curTempCur.moveToDom(dom);
        SaajData saajData = (SaajData) curTempCur.getBookmark(SaajData.class);
        Object obj = saajData == null ? null : saajData._obj;
        curTempCur.release();
        return obj;
    }

    public static Element impl_saajCallback_importSoapElement(Dom dom, Element element, boolean z6, QName qName) {
        throw new RuntimeException("Not impl");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void impl_saajCallback_setSaajData(Dom dom, Object obj) {
        Cur curTempCur = dom.locale().tempCur();
        curTempCur.moveToDom(dom);
        SaajData saajData = null;
        Object[] objArr = 0;
        if (obj != null) {
            SaajData saajData2 = (SaajData) curTempCur.getBookmark(SaajData.class);
            if (saajData2 == null) {
                saajData2 = new SaajData();
            }
            saajData = saajData2;
            saajData._obj = obj;
        }
        curTempCur.setBookmark(SaajData.class, saajData);
        curTempCur.release();
    }

    public static Node insert(Dom dom, Dom dom2) {
        return node_insertBefore((Dom) parent(dom2), dom, dom2);
    }

    private static String isValidChild(Dom dom, Dom dom2) {
        int iNodeType = dom.nodeType();
        int iNodeType2 = dom2.nodeType();
        switch (iNodeType) {
            case 1:
            case 5:
            case 6:
            case 11:
                if (iNodeType2 == 1 || iNodeType2 == 3 || iNodeType2 == 4 || iNodeType2 == 5 || iNodeType2 == 7 || iNodeType2 == 8) {
                    return null;
                }
                break;
            case 2:
                if (iNodeType2 == 3 || iNodeType2 == 5) {
                    return null;
                }
                break;
            case 3:
            case 4:
            case 7:
            case 8:
            case 10:
            case 12:
                return nodeKindName(iNodeType) + " nodes may not have any children";
            case 9:
                if (iNodeType2 == 1) {
                    if (document_getDocumentElement(dom) != null) {
                        return "Documents may only have a maximum of one document element";
                    }
                    return null;
                }
                if (iNodeType2 == 10) {
                    if (document_getDoctype(dom) != null) {
                        return "Documents may only have a maximum of one document type node";
                    }
                    return null;
                }
                if (iNodeType2 == 7 || iNodeType2 == 8) {
                    return null;
                }
                break;
        }
        return nodeKindName(iNodeType) + " nodes may not have " + nodeKindName(iNodeType2) + " nodes as children";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Node lambda$_attributes_getNamedItem$22(Dom dom, String str, Dom dom2) {
        return attributes_getNamedItem(dom, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Node lambda$_attributes_getNamedItemNS$23(String str, String str2, Dom dom) {
        return attributes_getNamedItemNS(dom, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Node lambda$_attributes_item$27(int i5, Dom dom) {
        return attributes_item(dom, i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Node lambda$_attributes_removeNamedItem$24(String str, Dom dom) {
        return attributes_removeNamedItem(dom, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Node lambda$_attributes_removeNamedItemNS$25(String str, String str2, Dom dom) {
        return attributes_removeNamedItemNS(dom, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Node lambda$_attributes_setNamedItem$21(Dom dom, Dom dom2) {
        return attributes_setNamedItem(dom2, dom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Node lambda$_attributes_setNamedItemNS$26(Dom dom, Dom dom2) {
        return attributes_setNamedItemNS(dom2, dom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Node lambda$_childNodes_item$16(int i5, Dom dom) {
        return childNodes_item(dom, i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Attr lambda$_document_createAttribute$3(String str, Dom dom) {
        return document_createAttribute(dom, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Attr lambda$_document_createAttributeNS$4(String str, String str2, Dom dom) {
        return document_createAttributeNS(dom, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Comment lambda$_document_createComment$5(String str, Dom dom) {
        return document_createComment(dom, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Element lambda$_document_createElement$1(String str, Dom dom) {
        return document_createElement(dom, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Element lambda$_document_createElementNS$2(String str, String str2, Dom dom) {
        return document_createElementNS(dom, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ProcessingInstruction lambda$_document_createProcessingInstruction$6(String str, String str2, Dom dom) {
        return document_createProcessingInstruction(dom, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ NodeList lambda$_document_getElementsByTagName$7(String str, Dom dom) {
        return document_getElementsByTagName(dom, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ NodeList lambda$_document_getElementsByTagNameNS$8(String str, String str2, Dom dom) {
        return document_getElementsByTagNameNS(dom, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Node lambda$_document_importNode$9(Node node, boolean z6, Dom dom) {
        return document_importNode(dom, node, z6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ NodeList lambda$_element_getElementsByTagName$19(String str, Dom dom) {
        return element_getElementsByTagName(dom, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ NodeList lambda$_element_getElementsByTagNameNS$20(String str, String str2, Dom dom) {
        return element_getElementsByTagNameNS(dom, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Node lambda$_node_cloneNode$13(boolean z6, Dom dom) {
        return node_cloneNode(dom, z6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Node lambda$_node_insertBefore$11(Dom dom, Dom dom2, Dom dom3) {
        return node_insertBefore(dom3, dom, dom2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Node lambda$_node_removeChild$12(Dom dom, Dom dom2) {
        return node_removeChild(dom2, dom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Node lambda$_node_replaceChild$10(Dom dom, Dom dom2, Dom dom3) {
        return node_replaceChild(dom3, dom, dom2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$_node_setNodeValue$15(String str, Dom dom) {
        node_setNodeValue(dom, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$_node_setPrefix$14(String str, Dom dom) {
        node_setPrefix(dom, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SOAPElement lambda$_soapElement_addAttribute$42(Dom dom, SOAPElement sOAPElement, Name name, String str) {
        return dom.locale()._saaj.soapElement_addAttribute(sOAPElement, name, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SOAPElement lambda$_soapElement_addChildElement$43(Dom dom, SOAPElement sOAPElement, SOAPElement sOAPElement2) {
        return dom.locale()._saaj.soapElement_addChildElement(sOAPElement, sOAPElement2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SOAPElement lambda$_soapElement_addChildElement$44(Dom dom, SOAPElement sOAPElement, Name name) {
        return dom.locale()._saaj.soapElement_addChildElement(sOAPElement, name);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SOAPElement lambda$_soapElement_addChildElement$45(Dom dom, SOAPElement sOAPElement, String str) {
        return dom.locale()._saaj.soapElement_addChildElement(sOAPElement, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SOAPElement lambda$_soapElement_addChildElement$46(Dom dom, SOAPElement sOAPElement, String str, String str2) {
        return dom.locale()._saaj.soapElement_addChildElement(sOAPElement, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SOAPElement lambda$_soapElement_addChildElement$47(Dom dom, SOAPElement sOAPElement, String str, String str2, String str3) {
        return dom.locale()._saaj.soapElement_addChildElement(sOAPElement, str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SOAPElement lambda$_soapElement_addNamespaceDeclaration$48(SOAPElement sOAPElement, String str, String str2, Dom dom) {
        return dom.locale()._saaj.soapElement_addNamespaceDeclaration(sOAPElement, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SOAPElement lambda$_soapElement_addTextNode$49(SOAPElement sOAPElement, String str, Dom dom) {
        return dom.locale()._saaj.soapElement_addTextNode(sOAPElement, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Iterator lambda$_soapElement_getAllAttributes$39(SOAPElement sOAPElement, Dom dom) {
        return dom.locale()._saaj.soapElement_getAllAttributes(sOAPElement);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$_soapElement_getAttributeValue$50(SOAPElement sOAPElement, Name name, Dom dom) {
        return dom.locale()._saaj.soapElement_getAttributeValue(sOAPElement, name);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Iterator lambda$_soapElement_getChildElements$40(SOAPElement sOAPElement, Dom dom) {
        return dom.locale()._saaj.soapElement_getChildElements(sOAPElement);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Iterator lambda$_soapElement_getChildElements$51(SOAPElement sOAPElement, Name name, Dom dom) {
        return dom.locale()._saaj.soapElement_getChildElements(sOAPElement, name);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Name lambda$_soapElement_getElementName$52(SOAPElement sOAPElement, Dom dom) {
        return dom.locale()._saaj.soapElement_getElementName(sOAPElement);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$_soapElement_getEncodingStyle$36(SOAPElement sOAPElement, Dom dom) {
        return dom.locale()._saaj.soapElement_getEncodingStyle(sOAPElement);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Iterator lambda$_soapElement_getNamespacePrefixes$41(SOAPElement sOAPElement, Dom dom) {
        return dom.locale()._saaj.soapElement_getNamespacePrefixes(sOAPElement);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$_soapElement_getNamespaceURI$53(SOAPElement sOAPElement, String str, Dom dom) {
        return dom.locale()._saaj.soapElement_getNamespaceURI(sOAPElement, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Iterator lambda$_soapElement_getVisibleNamespacePrefixes$54(SOAPElement sOAPElement, Dom dom) {
        return dom.locale()._saaj.soapElement_getVisibleNamespacePrefixes(sOAPElement);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$_soapElement_removeAttribute$55(SOAPElement sOAPElement, Name name, Dom dom) {
        return Boolean.valueOf(dom.locale()._saaj.soapElement_removeAttribute(sOAPElement, name));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$_soapElement_removeContents$35(SOAPElement sOAPElement, Dom dom) {
        dom.locale()._saaj.soapElement_removeContents(sOAPElement);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$_soapElement_removeNamespaceDeclaration$38(SOAPElement sOAPElement, String str, Dom dom) {
        return Boolean.valueOf(dom.locale()._saaj.soapElement_removeNamespaceDeclaration(sOAPElement, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$_soapElement_setEncodingStyle$37(SOAPElement sOAPElement, String str, Dom dom) {
        dom.locale()._saaj.soapElement_setEncodingStyle(sOAPElement, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SOAPBody lambda$_soapEnvelope_addBody$56(Dom dom, SOAPEnvelope sOAPEnvelope) {
        return dom.locale()._saaj.soapEnvelope_addBody(sOAPEnvelope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SOAPHeader lambda$_soapEnvelope_addHeader$59(Dom dom, SOAPEnvelope sOAPEnvelope) {
        return dom.locale()._saaj.soapEnvelope_addHeader(sOAPEnvelope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Name lambda$_soapEnvelope_createName$60(SOAPEnvelope sOAPEnvelope, String str, Dom dom) {
        return dom.locale()._saaj.soapEnvelope_createName(sOAPEnvelope, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Name lambda$_soapEnvelope_createName$61(SOAPEnvelope sOAPEnvelope, String str, String str2, String str3, Dom dom) {
        return dom.locale()._saaj.soapEnvelope_createName(sOAPEnvelope, str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SOAPBody lambda$_soapEnvelope_getBody$57(Dom dom, SOAPEnvelope sOAPEnvelope) {
        return dom.locale()._saaj.soapEnvelope_getBody(sOAPEnvelope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SOAPHeader lambda$_soapEnvelope_getHeader$58(Dom dom, SOAPEnvelope sOAPEnvelope) {
        return dom.locale()._saaj.soapEnvelope_getHeader(sOAPEnvelope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$_soapNode_detachNode$29(org.apache.xmlbeans.impl.soap.Node node, Dom dom) {
        dom.locale()._saaj.soapNode_detachNode(node);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SOAPElement lambda$_soapNode_getParentElement$33(org.apache.xmlbeans.impl.soap.Node node, Dom dom) {
        return dom.locale()._saaj.soapNode_getParentElement(node);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$_soapNode_getValue$31(org.apache.xmlbeans.impl.soap.Node node, Dom dom) {
        return dom.locale()._saaj.soapNode_getValue(node);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$_soapNode_recycleNode$30(org.apache.xmlbeans.impl.soap.Node node, Dom dom) {
        dom.locale()._saaj.soapNode_recycleNode(node);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$_soapNode_setParentElement$34(org.apache.xmlbeans.impl.soap.Node node, SOAPElement sOAPElement, Dom dom) {
        dom.locale()._saaj.soapNode_setParentElement(node, sOAPElement);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$_soapNode_setValue$32(org.apache.xmlbeans.impl.soap.Node node, String str, Dom dom) {
        dom.locale()._saaj.soapNode_setValue(node, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$_soapPart_addMimeHeader$100(SOAPPart sOAPPart, String str, String str2, Dom dom) {
        dom.locale()._saaj.soapPart_addMimeHeader(sOAPPart, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Iterator lambda$_soapPart_getAllMimeHeaders$95(SOAPPart sOAPPart, Dom dom) {
        return dom.locale()._saaj.soapPart_getAllMimeHeaders(sOAPPart);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Source lambda$_soapPart_getContent$97(SOAPPart sOAPPart, Dom dom) {
        return dom.locale()._saaj.soapPart_getContent(sOAPPart);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SOAPEnvelope lambda$_soapPart_getEnvelope$96(SOAPPart sOAPPart, Dom dom) {
        return dom.locale()._saaj.soapPart_getEnvelope(sOAPPart);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Iterator lambda$_soapPart_getMatchingMimeHeaders$102(SOAPPart sOAPPart, String[] strArr, Dom dom) {
        return dom.locale()._saaj.soapPart_getMatchingMimeHeaders(sOAPPart, strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String[] lambda$_soapPart_getMimeHeader$99(SOAPPart sOAPPart, String str, Dom dom) {
        return dom.locale()._saaj.soapPart_getMimeHeader(sOAPPart, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Iterator lambda$_soapPart_getNonMatchingMimeHeaders$103(SOAPPart sOAPPart, String[] strArr, Dom dom) {
        return dom.locale()._saaj.soapPart_getNonMatchingMimeHeaders(sOAPPart, strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$_soapPart_removeAllMimeHeaders$93(SOAPPart sOAPPart, Dom dom) {
        dom.locale()._saaj.soapPart_removeAllMimeHeaders(sOAPPart);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$_soapPart_removeMimeHeader$94(SOAPPart sOAPPart, String str, Dom dom) {
        dom.locale()._saaj.soapPart_removeMimeHeader(sOAPPart, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$_soapPart_setContent$98(SOAPPart sOAPPart, Source source, Dom dom) {
        dom.locale()._saaj.soapPart_setContent(sOAPPart, source);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$_soapPart_setMimeHeader$101(SOAPPart sOAPPart, String str, String str2, Dom dom) {
        dom.locale()._saaj.soapPart_setMimeHeader(sOAPPart, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$_soapText_isComment$28(org.apache.xmlbeans.impl.soap.Text text, Dom dom) {
        return Boolean.valueOf(dom.locale()._saaj.soapText_isComment(text));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DetailEntry lambda$detail_addDetailEntry$91(Detail detail, Name name, Dom dom) {
        return dom.locale()._saaj.detail_addDetailEntry(detail, name);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Iterator lambda$detail_getDetailEntries$92(Detail detail, Dom dom) {
        return dom.locale()._saaj.detail_getDetailEntries(detail);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Element lambda$saajCallback_createSoapElement$105(QName qName, QName qName2, Dom dom) {
        return impl_saajCallback_createSoapElement(dom, qName, qName2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Element lambda$saajCallback_importSoapElement$106(Element element, boolean z6, QName qName, Dom dom) {
        return impl_saajCallback_importSoapElement(dom, element, z6, qName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SOAPBodyElement lambda$soapBody_addBodyElement$71(SOAPBody sOAPBody, Name name, Dom dom) {
        return dom.locale()._saaj.soapBody_addBodyElement(sOAPBody, name);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SOAPBodyElement lambda$soapBody_addDocument$72(SOAPBody sOAPBody, Document document, Dom dom) {
        return dom.locale()._saaj.soapBody_addDocument(sOAPBody, document);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SOAPFault lambda$soapBody_addFault$69(Dom dom, SOAPBody sOAPBody) {
        return dom.locale()._saaj.soapBody_addFault(sOAPBody);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SOAPFault lambda$soapBody_addFault$73(Dom dom, SOAPBody sOAPBody, Name name, String str) {
        return dom.locale()._saaj.soapBody_addFault(sOAPBody, name, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SOAPFault lambda$soapBody_addFault$74(Dom dom, SOAPBody sOAPBody, Name name, String str, java.util.Locale locale) {
        return dom.locale()._saaj.soapBody_addFault(sOAPBody, name, str, locale);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SOAPFault lambda$soapBody_getFault$70(SOAPBody sOAPBody, Dom dom) {
        return dom.locale()._saaj.soapBody_getFault(sOAPBody);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$soapBody_hasFault$68(SOAPBody sOAPBody, Dom dom) {
        return Boolean.valueOf(dom.locale()._saaj.soapBody_hasFault(sOAPBody));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Detail lambda$soapFault_addDetail$85(Dom dom, SOAPFault sOAPFault) {
        return dom.locale()._saaj.soapFault_addDetail(sOAPFault);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Detail lambda$soapFault_getDetail$86(SOAPFault sOAPFault, Dom dom) {
        return dom.locale()._saaj.soapFault_getDetail(sOAPFault);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$soapFault_getFaultActor$79(SOAPFault sOAPFault, Dom dom) {
        return dom.locale()._saaj.soapFault_getFaultActor(sOAPFault);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$soapFault_getFaultCode$80(SOAPFault sOAPFault, Dom dom) {
        return dom.locale()._saaj.soapFault_getFaultCode(sOAPFault);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Name lambda$soapFault_getFaultCodeAsName$83(SOAPFault sOAPFault, Dom dom) {
        return dom.locale()._saaj.soapFault_getFaultCodeAsName(sOAPFault);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$soapFault_getFaultString$84(SOAPFault sOAPFault, Dom dom) {
        return dom.locale()._saaj.soapFault_getFaultString(sOAPFault);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ java.util.Locale lambda$soapFault_getFaultStringLocale$82(SOAPFault sOAPFault, Dom dom) {
        return dom.locale()._saaj.soapFault_getFaultStringLocale(sOAPFault);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$soapFault_setFaultActor$78(SOAPFault sOAPFault, String str, Dom dom) {
        dom.locale()._saaj.soapFault_setFaultActor(sOAPFault, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$soapFault_setFaultCode$77(Dom dom, SOAPFault sOAPFault, Name name) {
        dom.locale()._saaj.soapFault_setFaultCode(sOAPFault, name);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$soapFault_setFaultCode$81(Dom dom, SOAPFault sOAPFault, String str) {
        dom.locale()._saaj.soapFault_setFaultCode(sOAPFault, str);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$soapFault_setFaultString$75(SOAPFault sOAPFault, String str, Dom dom) {
        dom.locale()._saaj.soapFault_setFaultString(sOAPFault, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$soapFault_setFaultString$76(SOAPFault sOAPFault, String str, java.util.Locale locale, Dom dom) {
        dom.locale()._saaj.soapFault_setFaultString(sOAPFault, str, locale);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$soapHeaderElement_getActor$90(SOAPHeaderElement sOAPHeaderElement, Dom dom) {
        return dom.locale()._saaj.soapHeaderElement_getActor(sOAPHeaderElement);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$soapHeaderElement_getMustUnderstand$88(SOAPHeaderElement sOAPHeaderElement, Dom dom) {
        return Boolean.valueOf(dom.locale()._saaj.soapHeaderElement_getMustUnderstand(sOAPHeaderElement));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$soapHeaderElement_setActor$89(SOAPHeaderElement sOAPHeaderElement, String str, Dom dom) {
        dom.locale()._saaj.soapHeaderElement_setActor(sOAPHeaderElement, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$soapHeaderElement_setMustUnderstand$87(SOAPHeaderElement sOAPHeaderElement, boolean z6, Dom dom) {
        dom.locale()._saaj.soapHeaderElement_setMustUnderstand(sOAPHeaderElement, z6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SOAPHeaderElement lambda$soapHeader_addHeaderElement$67(SOAPHeader sOAPHeader, Name name, Dom dom) {
        return dom.locale()._saaj.soapHeader_addHeaderElement(sOAPHeader, name);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Iterator lambda$soapHeader_examineAllHeaderElements$62(SOAPHeader sOAPHeader, Dom dom) {
        return dom.locale()._saaj.soapHeader_examineAllHeaderElements(sOAPHeader);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Iterator lambda$soapHeader_examineHeaderElements$64(SOAPHeader sOAPHeader, String str, Dom dom) {
        return dom.locale()._saaj.soapHeader_examineHeaderElements(sOAPHeader, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Iterator lambda$soapHeader_examineMustUnderstandHeaderElements$65(SOAPHeader sOAPHeader, String str, Dom dom) {
        return dom.locale()._saaj.soapHeader_examineMustUnderstandHeaderElements(sOAPHeader, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Iterator lambda$soapHeader_extractAllHeaderElements$63(SOAPHeader sOAPHeader, Dom dom) {
        return dom.locale()._saaj.soapHeader_extractAllHeaderElements(sOAPHeader);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Iterator lambda$soapHeader_extractHeaderElements$66(SOAPHeader sOAPHeader, String str, Dom dom) {
        return dom.locale()._saaj.soapHeader_extractHeaderElements(sOAPHeader, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$syncWrap$107(Function function, Dom dom) {
        return function.apply(dom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$syncWrapNoEnter$108(Function function, Dom dom) {
        return function.apply(dom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$syncWrapVoid$109(Consumer consumer, Dom dom) {
        consumer.accept(dom);
        return null;
    }

    public static Node nextSibling(Dom dom) {
        return node_getNextSibling(dom);
    }

    public static String nodeKindName(int i5) {
        switch (i5) {
            case 1:
                return "element";
            case 2:
                return "attribute";
            case 3:
                return "text";
            case 4:
                return "cdata section";
            case 5:
                return "entity reference";
            case 6:
                return "entity";
            case 7:
                return "processing instruction";
            case 8:
                return "comment";
            case 9:
                return "document";
            case 10:
                return "document type";
            case 11:
                return "document fragment";
            case 12:
                return "notation";
            default:
                throw new RuntimeException("Unknown node type");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4, types: [org.apache.xmlbeans.impl.store.DomImpl$Dom] */
    /* JADX WARN: Type inference failed for: r1v6, types: [org.apache.xmlbeans.impl.store.CharNode] */
    /* JADX WARN: Type inference failed for: r1v7, types: [org.apache.xmlbeans.impl.store.DomImpl$Dom] */
    /* JADX WARN: Type inference failed for: r1v8 */
    public static Node node_cloneNode(Dom dom, boolean z6) {
        Cur curTempCur;
        Locale locale = dom.locale();
        ?? dom2 = 0;
        dom2 = 0;
        if (!z6) {
            int iNodeType = dom.nodeType();
            if (iNodeType == 1) {
                curTempCur = locale.tempCur();
                curTempCur.createElement(dom.getQName());
                Element element = (Element) curTempCur.getDom();
                NamedNodeMap attributes = ((Element) dom).getAttributes();
                for (int i5 = 0; i5 < attributes.getLength(); i5++) {
                    element.setAttributeNodeNS((Attr) attributes.item(i5).cloneNode(true));
                }
            } else if (iNodeType == 2) {
                curTempCur = locale.tempCur();
                curTempCur.createAttr(dom.getQName());
            } else if (iNodeType == 9) {
                curTempCur = locale.tempCur();
                curTempCur.createDomDocumentRoot();
            } else if (iNodeType != 11) {
                curTempCur = null;
            } else {
                curTempCur = locale.tempCur();
                curTempCur.createDomDocFragRoot();
            }
            if (curTempCur != null) {
                dom2 = curTempCur.getDom();
                curTempCur.release();
            }
        }
        if (dom2 == 0) {
            switch (dom.nodeType()) {
                case 1:
                case 2:
                case 7:
                case 8:
                case 9:
                case 11:
                    Cur curTempCur2 = locale.tempCur();
                    Cur curTempCur3 = dom.tempCur();
                    curTempCur3.copyNode(curTempCur2);
                    dom2 = curTempCur2.getDom();
                    curTempCur2.release();
                    curTempCur3.release();
                    break;
                case 3:
                case 4:
                    Cur curTempCur4 = dom.tempCur();
                    dom2 = dom.nodeType() == 3 ? locale.createTextNode() : locale.createCdataNode();
                    dom2.setChars(curTempCur4.getChars(((CharNode) dom)._cch), curTempCur4._offSrc, curTempCur4._cchSrc);
                    curTempCur4.release();
                    break;
                case 5:
                case 6:
                case 10:
                case 12:
                    throw new RuntimeException("Not impl");
                default:
                    throw new RuntimeException("Unknown kind");
            }
        }
        return (Node) dom2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Node node_getFirstChild(Dom dom) {
        int iNodeType = dom.nodeType();
        if (iNodeType != 1 && iNodeType != 2) {
            if (iNodeType == 5) {
                throw new RuntimeException("Not impl");
            }
            if (iNodeType != 6) {
                switch (iNodeType) {
                    case 9:
                    case 11:
                        break;
                    case 10:
                    case 12:
                        break;
                    default:
                        return null;
                }
            }
            throw new RuntimeException("Not impl");
        }
        Xobj xobj = (Xobj) dom;
        xobj.ensureOccupancy();
        if (xobj.isFirstChildPtrDomUsable()) {
            return (NodeXobj) xobj._firstChild;
        }
        Xobj xobjLastAttr = xobj.lastAttr();
        if (xobjLastAttr != null) {
            if (xobjLastAttr.isNextSiblingPtrDomUsable()) {
                return (NodeXobj) xobjLastAttr._nextSibling;
            }
            if (xobjLastAttr.isCharNodesAfterUsable()) {
                return xobjLastAttr._charNodesAfter;
            }
        }
        if (xobj.isCharNodesValueUsable()) {
            return xobj._charNodesValue;
        }
        return null;
    }

    public static Node node_getLastChild(Dom dom) {
        CharNode charNodes;
        Dom dom2 = null;
        switch (dom.nodeType()) {
            case 3:
            case 4:
            case 7:
            case 8:
                return null;
            case 5:
                throw new RuntimeException("Not impl");
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not impl");
            case 9:
            case 11:
            default:
                Cur curTempCur = dom.tempCur();
                if (curTempCur.toLastChild()) {
                    Dom dom3 = curTempCur.getDom();
                    curTempCur.skip();
                    charNodes = curTempCur.getCharNodes();
                    if (charNodes == null) {
                        dom2 = dom3;
                    }
                } else {
                    curTempCur.next();
                    charNodes = curTempCur.getCharNodes();
                }
                if (dom2 == null && charNodes != null) {
                    while (true) {
                        CharNode charNode = charNodes._next;
                        if (charNode != null) {
                            charNodes = charNode;
                        } else {
                            dom2 = charNodes;
                        }
                    }
                }
                curTempCur.release();
                return (Node) dom2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Node node_getNextSibling(Dom dom) {
        Node node = null;
        switch (dom.nodeType()) {
            case 1:
            case 7:
            case 8:
                Xobj xobj = (Xobj) dom;
                xobj.ensureOccupancy();
                if (xobj.isNextSiblingPtrDomUsable()) {
                    return (NodeXobj) xobj._nextSibling;
                }
                if (xobj.isCharNodesAfterUsable()) {
                    return xobj._charNodesAfter;
                }
                break;
            case 3:
            case 4:
                CharNode charNode = (CharNode) dom;
                if (!(charNode.getObject() instanceof Xobj)) {
                    return null;
                }
                Xobj xobj2 = (Xobj) charNode.getObject();
                xobj2._charNodesAfter = Cur.updateCharNodes(xobj2._locale, xobj2, xobj2._charNodesAfter, xobj2._cchAfter);
                xobj2._charNodesValue = Cur.updateCharNodes(xobj2._locale, xobj2, xobj2._charNodesValue, xobj2._cchValue);
                node = charNode._next;
                if (node == null) {
                    node = !charNode.isNodeAftertext() ? (NodeXobj) xobj2._firstChild : (NodeXobj) xobj2._nextSibling;
                }
                break;
                break;
            case 5:
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not implemented");
        }
        return node;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String node_getNodeValue(Dom dom) {
        int iNodeType = dom.nodeType();
        if (iNodeType != 2) {
            if (iNodeType == 3 || iNodeType == 4) {
                CharNode charNode = (CharNode) dom;
                if (!(charNode.getObject() instanceof Xobj)) {
                    return CharUtil.getString(charNode.getObject(), charNode._off, charNode._cch);
                }
                Xobj xobj = (Xobj) charNode.getObject();
                xobj.ensureOccupancy();
                if (charNode.isNodeAftertext()) {
                    xobj._charNodesAfter = Cur.updateCharNodes(xobj._locale, xobj, xobj._charNodesAfter, xobj._cchAfter);
                    return xobj.getCharsAfterAsString(charNode._off, charNode._cch);
                }
                xobj._charNodesValue = Cur.updateCharNodes(xobj._locale, xobj, xobj._charNodesValue, xobj._cchValue);
                return xobj.getCharsValueAsString(charNode._off, charNode._cch);
            }
            if (iNodeType != 7 && iNodeType != 8) {
                return null;
            }
        }
        return ((Xobj) dom).getValueAsString();
    }

    public static Document node_getOwnerDocument(Dom dom) {
        if (dom.nodeType() == 9) {
            return null;
        }
        Locale locale = dom.locale();
        if (locale._ownerDoc == null) {
            Cur curTempCur = locale.tempCur();
            curTempCur.createDomDocumentRoot();
            locale._ownerDoc = curTempCur.getDom();
            curTempCur.release();
        }
        return (Document) locale._ownerDoc;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:19:0x003b  */
    public static Node node_getParentNode(Dom dom) {
        Cur curTempCur;
        switch (dom.nodeType()) {
            case 1:
            case 7:
            case 8:
                curTempCur = dom.tempCur();
                if (!curTempCur.toParentRaw()) {
                    curTempCur.release();
                    break;
                }
                if (curTempCur == null) {
                    return null;
                }
                Dom dom2 = curTempCur.getDom();
                curTempCur.release();
                return (Node) dom2;
            case 2:
            case 9:
            case 11:
                curTempCur = null;
                if (curTempCur == null) {
                    return null;
                }
                Dom dom3 = curTempCur.getDom();
                curTempCur.release();
                return (Node) dom3;
            case 3:
            case 4:
                curTempCur = dom.tempCur();
                if (curTempCur != null) {
                    curTempCur.toParent();
                }
                if (curTempCur == null) {
                    return null;
                }
                Dom dom4 = curTempCur.getDom();
                curTempCur.release();
                return (Node) dom4;
            case 5:
                throw new RuntimeException("Not impl");
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not impl");
            default:
                throw new RuntimeException("Unknown kind");
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0055 -> B:24:0x004a). Please report as a decompilation issue!!! */
    public static Node node_getPreviousSibling(Dom dom) {
        NodeXobj nodeXobj;
        Node nodeNode_getNextSibling;
        Node nodeNode_getFirstChild;
        NodeXobj nodeXobj2;
        int iNodeType = dom.nodeType();
        if (iNodeType == 3 || iNodeType == 4) {
            CharNode charNode = (CharNode) dom;
            if (!(charNode.getObject() instanceof Xobj)) {
                return null;
            }
            nodeXobj = (NodeXobj) charNode.getObject();
            nodeXobj.ensureOccupancy();
            boolean zIsNodeAftertext = charNode.isNodeAftertext();
            nodeNode_getNextSibling = charNode._prev;
            if (nodeNode_getNextSibling != null) {
                nodeNode_getFirstChild = nodeXobj;
                nodeNode_getFirstChild = nodeNode_getNextSibling;
            } else {
                if (!zIsNodeAftertext) {
                    nodeNode_getNextSibling = nodeXobj._charNodesValue;
                }
                nodeNode_getFirstChild = nodeXobj;
                nodeNode_getFirstChild = nodeNode_getNextSibling;
            }
        } else {
            NodeXobj nodeXobj3 = (NodeXobj) dom;
            nodeXobj2 = (NodeXobj) nodeXobj3._prevSibling;
            if (nodeXobj2 == null || (!(nodeXobj3 instanceof AttrXobj) && (nodeXobj2 instanceof AttrXobj))) {
                nodeNode_getFirstChild = nodeXobj2;
                nodeNode_getFirstChild = nodeXobj2;
                NamespaceManager namespaceManager = nodeXobj3._parent;
                nodeNode_getFirstChild = nodeXobj2;
                if (namespaceManager != null) {
                    nodeNode_getFirstChild = node_getFirstChild((Dom) namespaceManager);
                }
            }
        }
        if (nodeNode_getFirstChild != null || (nodeNode_getNextSibling = node_getNextSibling((Dom) nodeNode_getFirstChild)) == dom) {
            return nodeNode_getFirstChild;
        }
        nodeNode_getFirstChild = nodeXobj;
        nodeNode_getFirstChild = nodeNode_getNextSibling;
        if (nodeNode_getFirstChild != null) {
        }
        return nodeNode_getFirstChild;
    }

    public static boolean node_hasAttributes(Dom dom) {
        if (dom.nodeType() != 1) {
            return false;
        }
        Cur curTempCur = dom.tempCur();
        boolean zHasAttrs = curTempCur.hasAttrs();
        curTempCur.release();
        return zHasAttrs;
    }

    /* JADX WARN: Code duplicated, block: B:58:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:59:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:67:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:69:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:75:0x011b  */
    /* JADX WARN: Code duplicated, block: B:76:0x011f  */
    /* JADX WARN: Code duplicated, block: B:79:0x012f  */
    /* JADX WARN: Code duplicated, block: B:93:0x013d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:95:0x0139 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    public static Node node_insertBefore(Dom dom, Dom dom2, Dom dom3) {
        int iNodeType;
        ArrayList arrayList;
        Dom dom4;
        int size;
        int i5;
        Dom dom5;
        CharNode charNode;
        if (dom2 == dom3) {
            return (Node) dom2;
        }
        if (dom3 != null && parent(dom3) != dom) {
            throw new NotFoundErr("RefChild is not a child of this node");
        }
        int iNodeType2 = dom2.nodeType();
        if (iNodeType2 == 11) {
            Node nodeFirstChild = firstChild(dom2);
            while (nodeFirstChild != null) {
                Dom dom6 = (Dom) nodeFirstChild;
                validateNewChild(dom, dom6);
                nodeFirstChild = nextSibling(dom6);
            }
            Node nodeFirstChild2 = firstChild(dom2);
            while (nodeFirstChild2 != null) {
                Dom dom7 = (Dom) nodeFirstChild2;
                Node nodeNextSibling = nextSibling(dom7);
                if (dom3 == null) {
                    append(dom7, dom);
                } else {
                    insert(dom7, dom3);
                }
                nodeFirstChild2 = nodeNextSibling;
            }
            return (Node) dom2;
        }
        validateNewChild(dom, dom2);
        remove(dom2);
        dom.nodeType();
        if (iNodeType2 == 1) {
            if (dom3 == null) {
                Cur curTempCur = dom.tempCur();
                curTempCur.toEnd();
                Cur.moveNode((Xobj) dom2, curTempCur);
                curTempCur.release();
            } else {
                iNodeType = dom3.nodeType();
                if (iNodeType != 3 || iNodeType == 4) {
                    arrayList = new ArrayList();
                    while (dom3 != null && (dom3.nodeType() == 3 || dom3.nodeType() == 4)) {
                        Node nodeNextSibling2 = nextSibling(dom3);
                        arrayList.add((Dom) remove(dom3));
                        dom3 = (Dom) nodeNextSibling2;
                    }
                    if (dom3 == null) {
                        append(dom2, dom);
                    } else {
                        insert(dom2, dom3);
                    }
                    dom4 = (Dom) nextSibling(dom2);
                    size = arrayList.size();
                    i5 = 0;
                    while (i5 < size) {
                        Object obj = arrayList.get(i5);
                        i5++;
                        dom5 = (Dom) obj;
                        if (dom4 == null) {
                            append(dom5, dom);
                        } else {
                            insert(dom5, dom4);
                        }
                    }
                } else {
                    if (iNodeType == 5) {
                        throw new RuntimeException("Not implemented");
                    }
                    Cur curTempCur2 = dom3.tempCur();
                    Cur.moveNode((Xobj) dom2, curTempCur2);
                    curTempCur2.release();
                }
            }
        } else {
            if (iNodeType2 == 10) {
                throw new RuntimeException("Not implemented");
            }
            if (iNodeType2 == 3 || iNodeType2 == 4) {
                CharNode charNode2 = (CharNode) dom2;
                Cur curTempCur3 = dom.tempCur();
                if (dom3 == null) {
                    curTempCur3.toEnd();
                } else {
                    int iNodeType3 = dom3.nodeType();
                    if (iNodeType3 == 3 || iNodeType3 == 4) {
                        charNode = (CharNode) dom3;
                        curTempCur3.moveToCharNode(charNode);
                    } else {
                        if (iNodeType3 == 5) {
                            throw new RuntimeException("Not implemented");
                        }
                        curTempCur3.moveToDom(dom3);
                    }
                    CharNode charNodeInsertNode = CharNode.insertNode(curTempCur3.getCharNodes(), charNode2, charNode);
                    curTempCur3.insertChars(charNode2.getObject(), charNode2._off, charNode2._cch);
                    curTempCur3.setCharNodes(charNodeInsertNode);
                    curTempCur3.release();
                }
                charNode = null;
                CharNode charNodeInsertNode2 = CharNode.insertNode(curTempCur3.getCharNodes(), charNode2, charNode);
                curTempCur3.insertChars(charNode2.getObject(), charNode2._off, charNode2._cch);
                curTempCur3.setCharNodes(charNodeInsertNode2);
                curTempCur3.release();
            } else {
                if (iNodeType2 == 5) {
                    throw new RuntimeException("Not implemented");
                }
                if (iNodeType2 != 7 && iNodeType2 != 8) {
                    throw new RuntimeException("Unexpected child node type");
                }
                if (dom3 == null) {
                    Cur curTempCur4 = dom.tempCur();
                    curTempCur4.toEnd();
                    Cur.moveNode((Xobj) dom2, curTempCur4);
                    curTempCur4.release();
                } else {
                    iNodeType = dom3.nodeType();
                    if (iNodeType != 3) {
                        arrayList = new ArrayList();
                        while (dom3 != null) {
                            Node nodeNextSibling3 = nextSibling(dom3);
                            arrayList.add((Dom) remove(dom3));
                            dom3 = (Dom) nodeNextSibling3;
                        }
                        if (dom3 == null) {
                            append(dom2, dom);
                        } else {
                            insert(dom2, dom3);
                        }
                        dom4 = (Dom) nextSibling(dom2);
                        size = arrayList.size();
                        i5 = 0;
                        while (i5 < size) {
                            Object obj2 = arrayList.get(i5);
                            i5++;
                            dom5 = (Dom) obj2;
                            if (dom4 == null) {
                                append(dom5, dom);
                            } else {
                                insert(dom5, dom4);
                            }
                        }
                    } else {
                        arrayList = new ArrayList();
                        while (dom3 != null) {
                            Node nodeNextSibling4 = nextSibling(dom3);
                            arrayList.add((Dom) remove(dom3));
                            dom3 = (Dom) nodeNextSibling4;
                        }
                        if (dom3 == null) {
                            append(dom2, dom);
                        } else {
                            insert(dom2, dom3);
                        }
                        dom4 = (Dom) nextSibling(dom2);
                        size = arrayList.size();
                        i5 = 0;
                        while (i5 < size) {
                            Object obj3 = arrayList.get(i5);
                            i5++;
                            dom5 = (Dom) obj3;
                            if (dom4 == null) {
                                append(dom5, dom);
                            } else {
                                insert(dom5, dom4);
                            }
                        }
                    }
                }
            }
        }
        return (Node) dom2;
    }

    public static void node_normalize(Dom dom) {
        switch (dom.nodeType()) {
            case 3:
            case 4:
            case 7:
            case 8:
                return;
            case 5:
                throw new RuntimeException("Not impl");
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not impl");
            case 9:
            case 11:
            default:
                Cur curTempCur = dom.tempCur();
                curTempCur.push();
                do {
                    curTempCur.nextWithAttrs();
                    CharNode charNodes = curTempCur.getCharNodes();
                    if (charNodes != null) {
                        if (!curTempCur.isText()) {
                            while (charNodes != null) {
                                charNodes.setChars(null, 0, 0);
                                charNodes = CharNode.remove(charNodes, charNodes);
                            }
                        } else if (charNodes._next != null) {
                            while (charNodes._next != null) {
                                charNodes.setChars(null, 0, 0);
                                charNodes = CharNode.remove(charNodes, charNodes._next);
                            }
                            charNodes._cch = Integer.MAX_VALUE;
                        }
                        curTempCur.setCharNodes(charNodes);
                    }
                } while (!curTempCur.isAtEndOfLastPush());
                curTempCur.release();
                dom.locale().invalidateDomCaches(dom);
                return;
        }
    }

    public static Node node_removeChild(Dom dom, Dom dom2) {
        if (parent(dom2) != dom) {
            throw new NotFoundErr("Child to remove is not a child of given parent");
        }
        switch (dom2.nodeType()) {
            case 1:
            case 7:
            case 8:
                removeNode(dom2);
                break;
            case 2:
            case 9:
            case 11:
                throw new IllegalStateException();
            case 3:
            case 4:
                Cur curTempCur = dom2.tempCur();
                CharNode charNodes = curTempCur.getCharNodes();
                CharNode charNode = (CharNode) dom2;
                charNode.setChars(curTempCur.moveChars(null, charNode._cch), curTempCur._offSrc, curTempCur._cchSrc);
                curTempCur.setCharNodes(CharNode.remove(charNodes, charNode));
                curTempCur.release();
                break;
            case 5:
                throw new RuntimeException("Not impl");
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not impl");
            default:
                throw new RuntimeException("Unknown kind");
        }
        return (Node) dom2;
    }

    public static Node node_replaceChild(Dom dom, Dom dom2, Dom dom3) {
        Node nodeNode_getNextSibling = node_getNextSibling(dom3);
        node_removeChild(dom, dom3);
        try {
            node_insertBefore(dom, dom2, (Dom) nodeNode_getNextSibling);
            return (Node) dom3;
        } catch (DOMException e) {
            node_insertBefore(dom, dom3, (Dom) nodeNode_getNextSibling);
            throw e;
        }
    }

    public static void node_setNodeValue(Dom dom, String str) {
        if (str == null) {
            str = "";
        }
        int iNodeType = dom.nodeType();
        if (iNodeType == 2) {
            NodeList childNodes = ((Node) dom).getChildNodes();
            while (childNodes.getLength() > 1) {
                node_removeChild(dom, (Dom) childNodes.item(1));
            }
            if (childNodes.getLength() == 0) {
                TextNode textNodeCreateTextNode = dom.locale().createTextNode();
                textNodeCreateTextNode.setChars(str, 0, str.length());
                node_insertBefore(dom, textNodeCreateTextNode, null);
            } else {
                childNodes.item(0).setNodeValue(str);
            }
            if (((AttrXobj) dom).isId()) {
                Document documentNode_getOwnerDocument = node_getOwnerDocument(dom);
                String strNode_getNodeValue = node_getNodeValue(dom);
                if (documentNode_getOwnerDocument instanceof DocumentXobj) {
                    DocumentXobj documentXobj = (DocumentXobj) documentNode_getOwnerDocument;
                    documentXobj.removeIdElement(strNode_getNodeValue);
                    documentXobj.addIdElement(str, (Dom) attr_getOwnerElement(dom));
                    return;
                }
                return;
            }
            return;
        }
        if (iNodeType == 3 || iNodeType == 4) {
            CharNode charNode = (CharNode) dom;
            Cur curTempCur = charNode.tempCur();
            if (curTempCur == null) {
                charNode.setChars(str, 0, str.length());
                return;
            }
            curTempCur.moveChars(null, charNode._cch);
            charNode._cch = str.length();
            curTempCur.insertString(str);
            curTempCur.release();
            return;
        }
        if (iNodeType == 7 || iNodeType == 8) {
            Cur curTempCur2 = dom.tempCur();
            curTempCur2.next();
            curTempCur2.getChars(-1);
            curTempCur2.moveChars(null, curTempCur2._cchSrc);
            curTempCur2.insertString(str);
            curTempCur2.release();
        }
    }

    public static void node_setPrefix(Dom dom, String str) {
        if (dom.nodeType() != 1 && dom.nodeType() != 2) {
            validatePrefix(str, "", "", false);
            return;
        }
        Cur curTempCur = dom.tempCur();
        QName name = curTempCur.getName();
        String namespaceURI = name.getNamespaceURI();
        String localPart = name.getLocalPart();
        curTempCur.setName(dom.locale().makeQName(namespaceURI, localPart, validatePrefix(str, namespaceURI, localPart, dom.nodeType() == 2)));
        curTempCur.release();
    }

    public static Node parent(Dom dom) {
        return node_getParentNode(dom);
    }

    public static Node prevSibling(Dom dom) {
        return node_getPreviousSibling(dom);
    }

    public static Node remove(Dom dom) {
        Node nodeParent = parent(dom);
        if (nodeParent != null) {
            node_removeChild((Dom) nodeParent, dom);
        }
        return (Node) dom;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void removeNode(Dom dom) {
        CharNode charNodes;
        Cur curTempCur = dom.tempCur();
        curTempCur.toEnd();
        if (curTempCur.next() && (charNodes = curTempCur.getCharNodes()) != null) {
            curTempCur.setCharNodes(null);
            Cur curTempCur2 = dom.tempCur();
            curTempCur2.setCharNodes(CharNode.appendNodes(curTempCur2.getCharNodes(), charNodes));
            curTempCur2.release();
        }
        curTempCur.release();
        Cur.moveNode((Xobj) dom, null);
    }

    public static Element saajCallback_createSoapElement(Dom dom, QName qName, QName qName2) {
        return (Element) syncWrap(dom, new A(qName, qName2, 0));
    }

    public static Text saajCallback_ensureSoapTextNode(Dom dom) {
        return (Text) syncWrap(dom, new m0(4));
    }

    public static Object saajCallback_getSaajData(Dom dom) {
        return syncWrap(dom, new m0(13));
    }

    public static Element saajCallback_importSoapElement(Dom dom, final Element element, final boolean z6, final QName qName) {
        return (Element) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.f0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DomImpl.lambda$saajCallback_importSoapElement$106(element, z6, qName, (DomImpl.Dom) obj);
            }
        });
    }

    public static void saajCallback_setSaajData(Dom dom, Object obj) {
        syncWrapVoid(dom, new E(obj, 1));
    }

    public static SOAPBodyElement soapBody_addBodyElement(Dom dom, Name name) {
        return (SOAPBodyElement) syncWrap(dom, new A((SOAPBody) dom, name, 2));
    }

    public static SOAPBodyElement soapBody_addDocument(Dom dom, Document document) {
        return (SOAPBodyElement) syncWrap(dom, new A((SOAPBody) dom, document, 5));
    }

    public static SOAPFault soapBody_addFault(Dom dom) {
        return (SOAPFault) syncWrapEx(dom, new C1454o(dom, (SOAPBody) dom, 4));
    }

    public static SOAPFault soapBody_getFault(Dom dom) {
        return (SOAPFault) syncWrap(dom, new a0((SOAPBody) dom, 1));
    }

    public static boolean soapBody_hasFault(Dom dom) {
        return ((Boolean) syncWrap(dom, new a0((SOAPBody) dom, 0))).booleanValue();
    }

    public static Detail soapFault_addDetail(Dom dom) {
        return (Detail) syncWrapEx(dom, new C1454o(dom, (SOAPFault) dom, 3));
    }

    public static Detail soapFault_getDetail(Dom dom) {
        return (Detail) syncWrap(dom, new Y((SOAPFault) dom, 2));
    }

    public static String soapFault_getFaultActor(Dom dom) {
        return (String) syncWrap(dom, new Y((SOAPFault) dom, 5));
    }

    public static String soapFault_getFaultCode(Dom dom) {
        return (String) syncWrap(dom, new Y((SOAPFault) dom, 0));
    }

    public static Name soapFault_getFaultCodeAsName(Dom dom) {
        return (Name) syncWrap(dom, new Y((SOAPFault) dom, 3));
    }

    public static String soapFault_getFaultString(Dom dom) {
        return (String) syncWrap(dom, new Y((SOAPFault) dom, 4));
    }

    public static java.util.Locale soapFault_getFaultStringLocale(Dom dom) {
        return (java.util.Locale) syncWrap(dom, new Y((SOAPFault) dom, 1));
    }

    public static void soapFault_setFaultActor(Dom dom, String str) {
        syncWrapVoid(dom, new J((SOAPFault) dom, str, 1));
    }

    public static void soapFault_setFaultCode(Dom dom, Name name) {
        syncWrapEx(dom, new C1451l(dom, 4, (SOAPFault) dom, name));
    }

    public static void soapFault_setFaultString(Dom dom, String str) {
        syncWrapVoid(dom, new J((SOAPFault) dom, str, 0));
    }

    public static String soapHeaderElement_getActor(Dom dom) {
        return (String) syncWrap(dom, new K((SOAPHeaderElement) dom, 1));
    }

    public static boolean soapHeaderElement_getMustUnderstand(Dom dom) {
        return ((Boolean) syncWrap(dom, new K((SOAPHeaderElement) dom, 0))).booleanValue();
    }

    public static void soapHeaderElement_setActor(Dom dom, String str) {
        syncWrapVoid(dom, new F((SOAPHeaderElement) dom, str, 5));
    }

    public static void soapHeaderElement_setMustUnderstand(Dom dom, final boolean z6) {
        final SOAPHeaderElement sOAPHeaderElement = (SOAPHeaderElement) dom;
        syncWrapVoid(dom, new Consumer() { // from class: org.apache.xmlbeans.impl.store.e0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                DomImpl.lambda$soapHeaderElement_setMustUnderstand$87(sOAPHeaderElement, z6, (DomImpl.Dom) obj);
            }
        });
    }

    public static SOAPHeaderElement soapHeader_addHeaderElement(Dom dom, Name name) {
        return (SOAPHeaderElement) syncWrap(dom, new A((SOAPHeader) dom, name, 4));
    }

    public static Iterator<SOAPHeaderElement> soapHeader_examineAllHeaderElements(Dom dom) {
        return (Iterator) syncWrap(dom, new X((SOAPHeader) dom, 1));
    }

    public static Iterator<SOAPHeaderElement> soapHeader_examineHeaderElements(Dom dom, String str) {
        return (Iterator) syncWrap(dom, new I((SOAPHeader) dom, str, 1));
    }

    public static Iterator<SOAPHeaderElement> soapHeader_examineMustUnderstandHeaderElements(Dom dom, String str) {
        return (Iterator) syncWrap(dom, new I((SOAPHeader) dom, str, 2));
    }

    public static Iterator<SOAPHeaderElement> soapHeader_extractAllHeaderElements(Dom dom) {
        return (Iterator) syncWrap(dom, new X((SOAPHeader) dom, 0));
    }

    public static Iterator<SOAPHeaderElement> soapHeader_extractHeaderElements(Dom dom, String str) {
        return (Iterator) syncWrap(dom, new I((SOAPHeader) dom, str, 0));
    }

    private static <T> T syncWrap(Dom dom, Function<Dom, T> function) {
        return (T) syncWrapHelper(dom.locale(), true, new V(function, dom, 0));
    }

    private static <T> T syncWrapEx(Dom dom, WrapSoapEx<T> wrapSoapEx) {
        return (T) syncWrapHelperEx(dom.locale(), true, wrapSoapEx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T syncWrapHelper(Locale locale, boolean z6, Supplier<T> supplier) {
        T t6;
        if (locale.noSync()) {
            return (T) syncWrapHelper2(locale, z6, supplier);
        }
        synchronized (locale) {
            t6 = (T) syncWrapHelper2(locale, z6, supplier);
        }
        return t6;
    }

    private static <T> T syncWrapHelper2(Locale locale, boolean z6, Supplier<T> supplier) {
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

    private static <T> T syncWrapHelperEx(Locale locale, boolean z6, WrapSoapEx<T> wrapSoapEx) {
        T t6;
        if (locale.noSync()) {
            return (T) syncWrapHelperEx2(locale, z6, wrapSoapEx);
        }
        synchronized (locale) {
            t6 = (T) syncWrapHelperEx2(locale, z6, wrapSoapEx);
        }
        return t6;
    }

    private static <T> T syncWrapHelperEx2(Locale locale, boolean z6, WrapSoapEx<T> wrapSoapEx) {
        if (z6) {
            locale.enter();
        }
        try {
            return wrapSoapEx.get();
        } finally {
            if (z6) {
                locale.exit();
            }
        }
    }

    private static <T> T syncWrapNoEnter(Dom dom, Function<Dom, T> function) {
        return (T) syncWrapHelper(dom.locale(), false, new V(function, dom, 1));
    }

    private static void syncWrapVoid(Dom dom, Consumer<Dom> consumer) {
        syncWrapHelper(dom.locale(), true, new C1459u(consumer, dom, 1));
    }

    private static void validateName(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Name is null");
        }
        if (str.length() == 0) {
            throw new IllegalArgumentException("Name is empty");
        }
        if (!XMLChar.isValidName(str)) {
            throw new InvalidCharacterError("Name has an invalid character");
        }
    }

    private static void validateNcName(String str) {
        if (str != null && str.length() > 0 && !XMLChar.isValidNCName(str)) {
            throw new InvalidCharacterError();
        }
    }

    private static void validateNewChild(Dom dom, Dom dom2) {
        String strIsValidChild = isValidChild(dom, dom2);
        if (strIsValidChild != null) {
            throw new HierarchyRequestErr(strIsValidChild);
        }
        if (dom == dom2) {
            throw new HierarchyRequestErr("New child and parent are the same node");
        }
        Node nodeParent = (Node) dom;
        do {
            nodeParent = parent((Dom) nodeParent);
            if (nodeParent == null) {
                return;
            }
            if (dom2.nodeType() == 5) {
                throw new NoModificationAllowedErr("Entity reference trees may not be modified");
            }
        } while (dom2 != nodeParent);
        throw new HierarchyRequestErr("New child is an ancestor node of the parent node");
    }

    private static String validatePrefix(String str, String str2, String str3, boolean z6) {
        if (str != null && str.contains(ParameterizedMessage.ERROR_MSG_SEPARATOR)) {
            throw new NamespaceErr("Invalid prefix - contains ':' character");
        }
        validateNcName(str);
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        if (str.length() > 0 && str2.length() == 0) {
            throw new NamespaceErr("Attempt to give a prefix for no namespace");
        }
        if (str.equals("xml") && !str2.equals("http://www.w3.org/XML/1998/namespace")) {
            throw new NamespaceErr("Invalid prefix - begins with 'xml'");
        }
        if (z6) {
            if (str.length() > 0) {
                if (str3.equals(Sax2Dom.XMLNS_PREFIX)) {
                    throw new NamespaceErr("Invalid namespace - attr is default namespace already");
                }
                if (Locale.beginsWithXml(str3)) {
                    throw new NamespaceErr("Invalid namespace - attr prefix begins with 'xml'");
                }
                if (str.equals(Sax2Dom.XMLNS_PREFIX) && !str2.equals("http://www.w3.org/2000/xmlns/")) {
                    throw new NamespaceErr("Invalid namespace - uri is not 'http://www.w3.org/2000/xmlns/;");
                }
            } else if (str3.equals(Sax2Dom.XMLNS_PREFIX) && !str2.equals("http://www.w3.org/2000/xmlns/")) {
                throw new NamespaceErr("Invalid namespace - uri is not 'http://www.w3.org/2000/xmlns/;");
            }
        } else if (Locale.beginsWithXml(str)) {
            throw new NamespaceErr("Invalid prefix - begins with 'xml'");
        }
        return str;
    }

    private static void validateQualifiedName(String str, String str2, boolean z6) {
        if (str2 == null) {
            str2 = "";
        }
        int iIndexOf = str.indexOf(58);
        if (iIndexOf < 0) {
            validateNcName(str);
            if (z6 && str.equals(Sax2Dom.XMLNS_PREFIX) && !str2.equals("http://www.w3.org/2000/xmlns/")) {
                throw new NamespaceErr("Default xmlns attribute does not have namespace: http://www.w3.org/2000/xmlns/");
            }
        } else {
            if (iIndexOf == 0) {
                throw new NamespaceErr("Invalid qualified name, no prefix specified");
            }
            String strSubstring = str.substring(0, iIndexOf);
            validateNcName(strSubstring);
            if (str2.length() == 0) {
                throw new NamespaceErr("Attempt to give a prefix for no namespace");
            }
            str = str.substring(iIndexOf + 1);
            if (str.indexOf(58) >= 0) {
                throw new NamespaceErr("Invalid qualified name, more than one colon");
            }
            validateNcName(str);
            if (strSubstring.equals("xml") && !str2.equals("http://www.w3.org/XML/1998/namespace")) {
                throw new NamespaceErr("Invalid prefix - begins with 'xml'");
            }
        }
        if (str.length() == 0) {
            throw new NamespaceErr("Invalid qualified name, no local part specified");
        }
    }

    public static SOAPElement _soapElement_addChildElement(Dom dom, Name name) {
        return (SOAPElement) syncWrapEx(dom, new C1451l(dom, 5, (SOAPElement) dom, name));
    }

    public static Iterator<SOAPElement> _soapElement_getChildElements(Dom dom, Name name) {
        return (Iterator) syncWrap(dom, new P((SOAPElement) dom, name, 0));
    }

    public static Name _soapEnvelope_createName(Dom dom, final String str, final String str2, final String str3) {
        final SOAPEnvelope sOAPEnvelope = (SOAPEnvelope) dom;
        return (Name) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.T
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DomImpl.lambda$_soapEnvelope_createName$61(sOAPEnvelope, str, str2, str3, (DomImpl.Dom) obj);
            }
        });
    }

    public static SOAPFault soapBody_addFault(Dom dom, Name name, String str) {
        return (SOAPFault) syncWrapEx(dom, new C1447h(dom, (SOAPBody) dom, name, str, 3));
    }

    public static void soapFault_setFaultCode(Dom dom, String str) {
        syncWrapEx(dom, new C1451l(dom, 7, (SOAPFault) dom, str));
    }

    public static void soapFault_setFaultString(Dom dom, String str, java.util.Locale locale) {
        syncWrapVoid(dom, new S((SOAPFault) dom, str, locale));
    }

    public static SOAPElement _soapElement_addChildElement(Dom dom, String str) {
        return (SOAPElement) syncWrapEx(dom, new C1451l(dom, 6, (SOAPElement) dom, str));
    }

    public static SOAPFault soapBody_addFault(Dom dom, Name name, String str, java.util.Locale locale) {
        return (SOAPFault) syncWrapEx(dom, new b0(dom, (SOAPBody) dom, name, str, locale));
    }

    public static SOAPElement _soapElement_addChildElement(Dom dom, String str, String str2) {
        return (SOAPElement) syncWrapEx(dom, new C1447h(dom, (SOAPElement) dom, str, str2, 2));
    }

    public static SOAPElement _soapElement_addChildElement(Dom dom, String str, String str2, String str3) {
        return (SOAPElement) syncWrapEx(dom, new b0(dom, (SOAPElement) dom, str, str2, str3));
    }
}
