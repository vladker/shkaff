package org.apache.xmlbeans.impl.store;

import java.io.PrintStream;
import java.util.Iterator;
import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import org.apache.xmlbeans.impl.soap.MimeHeader;
import org.apache.xmlbeans.impl.soap.SOAPEnvelope;
import org.apache.xmlbeans.impl.soap.SOAPPart;
import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMConfiguration;
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
class SoapPartDom extends SOAPPart implements DomImpl.Dom, Document, NodeList {
    SoapPartDocXobj _docXobj;

    public SoapPartDom(SoapPartDocXobj soapPartDocXobj) {
        this._docXobj = soapPartDocXobj;
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPPart
    public void addMimeHeader(String str, String str2) {
        DomImpl._soapPart_addMimeHeader(this, str, str2);
    }

    @Override // org.w3c.dom.Document
    public Node adoptNode(Node node) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Node
    public Node appendChild(Node node) {
        return DomImpl._node_appendChild(this, node);
    }

    @Override // org.w3c.dom.Node
    public Node cloneNode(boolean z6) {
        return DomImpl._node_cloneNode(this, z6);
    }

    @Override // org.w3c.dom.Node
    public short compareDocumentPosition(Node node) {
        return DomImpl._node_compareDocumentPosition(this, node);
    }

    @Override // org.w3c.dom.Document
    public Attr createAttribute(String str) {
        return DomImpl._document_createAttribute(this, str);
    }

    @Override // org.w3c.dom.Document
    public Attr createAttributeNS(String str, String str2) {
        return DomImpl._document_createAttributeNS(this, str, str2);
    }

    @Override // org.w3c.dom.Document
    public CDATASection createCDATASection(String str) {
        return DomImpl._document_createCDATASection(this, str);
    }

    @Override // org.w3c.dom.Document
    public Comment createComment(String str) {
        return DomImpl._document_createComment(this, str);
    }

    @Override // org.w3c.dom.Document
    public DocumentFragment createDocumentFragment() {
        return DomImpl._document_createDocumentFragment(this);
    }

    @Override // org.w3c.dom.Document
    public Element createElement(String str) {
        return DomImpl._document_createElement(this, str);
    }

    @Override // org.w3c.dom.Document
    public Element createElementNS(String str, String str2) {
        return DomImpl._document_createElementNS(this, str, str2);
    }

    @Override // org.w3c.dom.Document
    public EntityReference createEntityReference(String str) {
        return DomImpl._document_createEntityReference(this, str);
    }

    @Override // org.w3c.dom.Document
    public ProcessingInstruction createProcessingInstruction(String str, String str2) {
        return DomImpl._document_createProcessingInstruction(this, str, str2);
    }

    @Override // org.w3c.dom.Document
    public Text createTextNode(String str) {
        return DomImpl._document_createTextNode(this, str);
    }

    @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
    public void dump() {
        dump(System.out);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPPart
    public Iterator<MimeHeader> getAllMimeHeaders() {
        return DomImpl._soapPart_getAllMimeHeaders(this);
    }

    @Override // org.w3c.dom.Node
    public NamedNodeMap getAttributes() {
        return null;
    }

    @Override // org.w3c.dom.Node
    public String getBaseURI() {
        return DomImpl._node_getBaseURI(this);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPPart
    public Source getContent() {
        return DomImpl._soapPart_getContent(this);
    }

    @Override // org.w3c.dom.Document
    public DocumentType getDoctype() {
        return DomImpl._document_getDoctype(this);
    }

    @Override // org.w3c.dom.Document
    public Element getDocumentElement() {
        return DomImpl._document_getDocumentElement(this);
    }

    @Override // org.w3c.dom.Document
    public String getDocumentURI() {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Document
    public DOMConfiguration getDomConfig() {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Document
    public Element getElementById(String str) {
        return DomImpl._document_getElementById(this, str);
    }

    @Override // org.w3c.dom.Document
    public NodeList getElementsByTagName(String str) {
        return DomImpl._document_getElementsByTagName(this, str);
    }

    @Override // org.w3c.dom.Document
    public NodeList getElementsByTagNameNS(String str, String str2) {
        return DomImpl._document_getElementsByTagNameNS(this, str, str2);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPPart
    public SOAPEnvelope getEnvelope() {
        return DomImpl._soapPart_getEnvelope(this);
    }

    @Override // org.w3c.dom.Node
    public Object getFeature(String str, String str2) {
        return DomImpl._node_getFeature(this, str, str2);
    }

    @Override // org.w3c.dom.Node
    public Node getFirstChild() {
        return DomImpl._node_getFirstChild(this);
    }

    @Override // org.w3c.dom.Document
    public DOMImplementation getImplementation() {
        return DomImpl._document_getImplementation(this);
    }

    @Override // org.w3c.dom.Document
    public String getInputEncoding() {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Node
    public Node getLastChild() {
        return DomImpl._node_getLastChild(this);
    }

    @Override // org.w3c.dom.NodeList
    public int getLength() {
        return DomImpl._childNodes_getLength(this);
    }

    @Override // org.w3c.dom.Node
    public String getLocalName() {
        return DomImpl._node_getLocalName(this);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPPart
    public Iterator<MimeHeader> getMatchingMimeHeaders(String[] strArr) {
        return DomImpl._soapPart_getMatchingMimeHeaders(this, strArr);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPPart
    public String[] getMimeHeader(String str) {
        return DomImpl._soapPart_getMimeHeader(this, str);
    }

    @Override // org.w3c.dom.Node
    public String getNamespaceURI() {
        return DomImpl._node_getNamespaceURI(this);
    }

    @Override // org.w3c.dom.Node
    public Node getNextSibling() {
        return DomImpl._node_getNextSibling(this);
    }

    @Override // org.w3c.dom.Node
    public String getNodeName() {
        return DomImpl._node_getNodeName(this);
    }

    @Override // org.w3c.dom.Node
    public short getNodeType() {
        return DomImpl._node_getNodeType(this);
    }

    @Override // org.w3c.dom.Node
    public String getNodeValue() {
        return DomImpl._node_getNodeValue(this);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPPart
    public Iterator<MimeHeader> getNonMatchingMimeHeaders(String[] strArr) {
        return DomImpl._soapPart_getNonMatchingMimeHeaders(this, strArr);
    }

    @Override // org.w3c.dom.Node
    public Document getOwnerDocument() {
        return DomImpl._node_getOwnerDocument(this);
    }

    @Override // org.w3c.dom.Node
    public Node getParentNode() {
        return DomImpl._node_getParentNode(this);
    }

    @Override // org.w3c.dom.Node
    public String getPrefix() {
        return DomImpl._node_getPrefix(this);
    }

    @Override // org.w3c.dom.Node
    public Node getPreviousSibling() {
        return DomImpl._node_getPreviousSibling(this);
    }

    @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
    public QName getQName() {
        return this._docXobj._name;
    }

    @Override // org.w3c.dom.Document
    public boolean getStrictErrorChecking() {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Node
    public String getTextContent() {
        return DomImpl._node_getTextContent(this);
    }

    @Override // org.w3c.dom.Node
    public Object getUserData(String str) {
        return DomImpl._node_getUserData(this, str);
    }

    @Override // org.w3c.dom.Document
    public String getXmlEncoding() {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Document
    public boolean getXmlStandalone() {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Document
    public String getXmlVersion() {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Node
    public boolean hasAttributes() {
        return DomImpl._node_hasAttributes(this);
    }

    @Override // org.w3c.dom.Node
    public boolean hasChildNodes() {
        return DomImpl._node_hasChildNodes(this);
    }

    @Override // org.w3c.dom.Document
    public Node importNode(Node node, boolean z6) {
        return DomImpl._document_importNode(this, node, z6);
    }

    @Override // org.w3c.dom.Node
    public Node insertBefore(Node node, Node node2) {
        return DomImpl._node_insertBefore(this, node, node2);
    }

    @Override // org.w3c.dom.Node
    public boolean isDefaultNamespace(String str) {
        return DomImpl._node_isDefaultNamespace(this, str);
    }

    @Override // org.w3c.dom.Node
    public boolean isEqualNode(Node node) {
        return DomImpl._node_isEqualNode(this, node);
    }

    @Override // org.w3c.dom.Node
    public boolean isSameNode(Node node) {
        return DomImpl._node_isSameNode(this, node);
    }

    @Override // org.w3c.dom.Node
    public boolean isSupported(String str, String str2) {
        return DomImpl._node_isSupported(this, str, str2);
    }

    @Override // org.w3c.dom.NodeList
    public Node item(int i5) {
        return DomImpl._childNodes_item(this, i5);
    }

    @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
    public Locale locale() {
        return this._docXobj._locale;
    }

    @Override // org.w3c.dom.Node
    public String lookupNamespaceURI(String str) {
        return DomImpl._node_lookupNamespaceURI(this, str);
    }

    @Override // org.w3c.dom.Node
    public String lookupPrefix(String str) {
        return DomImpl._node_lookupPrefix(this, str);
    }

    public String name() {
        return "#document";
    }

    @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
    public boolean nodeCanHavePrefixUri() {
        return true;
    }

    @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
    public int nodeType() {
        return 9;
    }

    @Override // org.w3c.dom.Node
    public void normalize() {
        DomImpl._node_normalize(this);
    }

    @Override // org.w3c.dom.Document
    public void normalizeDocument() {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPPart
    public void removeAllMimeHeaders() {
        DomImpl._soapPart_removeAllMimeHeaders(this);
    }

    @Override // org.w3c.dom.Node
    public Node removeChild(Node node) {
        return DomImpl._node_removeChild(this, node);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPPart
    public void removeMimeHeader(String str) {
        DomImpl._soapPart_removeMimeHeader(this, str);
    }

    @Override // org.w3c.dom.Document
    public Node renameNode(Node node, String str, String str2) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Node
    public Node replaceChild(Node node, Node node2) {
        return DomImpl._node_replaceChild(this, node, node2);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPPart
    public void setContent(Source source) {
        DomImpl._soapPart_setContent(this, source);
    }

    @Override // org.w3c.dom.Document
    public void setDocumentURI(String str) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPPart
    public void setMimeHeader(String str, String str2) {
        DomImpl._soapPart_setMimeHeader(this, str, str2);
    }

    @Override // org.w3c.dom.Node
    public void setNodeValue(String str) {
        DomImpl._node_setNodeValue(this, str);
    }

    @Override // org.w3c.dom.Node
    public void setPrefix(String str) {
        DomImpl._node_setPrefix(this, str);
    }

    @Override // org.w3c.dom.Document
    public void setStrictErrorChecking(boolean z6) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Node
    public void setTextContent(String str) {
        DomImpl._node_setTextContent(this, str);
    }

    @Override // org.w3c.dom.Node
    public Object setUserData(String str, Object obj, UserDataHandler userDataHandler) {
        return DomImpl._node_setUserData(this, str, obj, userDataHandler);
    }

    @Override // org.w3c.dom.Document
    public void setXmlStandalone(boolean z6) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Document
    public void setXmlVersion(String str) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
    public Cur tempCur() {
        return this._docXobj.tempCur();
    }

    @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
    public void dump(PrintStream printStream) {
        this._docXobj.dump(printStream);
    }

    @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
    public void dump(PrintStream printStream, Object obj) {
        this._docXobj.dump(printStream, obj);
    }

    @Override // org.w3c.dom.Node
    public NodeList getChildNodes() {
        return this;
    }
}
