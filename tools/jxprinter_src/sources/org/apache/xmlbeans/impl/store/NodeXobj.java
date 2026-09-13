package org.apache.xmlbeans.impl.store;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.UserDataHandler;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
abstract class NodeXobj extends Xobj implements DomImpl.Dom, Node, NodeList {
    public NodeXobj(Locale locale, int i5, int i6) {
        super(locale, i5, i6);
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

    public NamedNodeMap getAttributes() {
        return null;
    }

    @Override // org.w3c.dom.Node
    public String getBaseURI() {
        return DomImpl._node_getBaseURI(this);
    }

    @Override // org.w3c.dom.Node
    public Object getFeature(String str, String str2) {
        return DomImpl._node_getFeature(this, str, str2);
    }

    public Node getFirstChild() {
        return DomImpl._node_getFirstChild(this);
    }

    @Override // org.w3c.dom.Node
    public Node getLastChild() {
        return DomImpl._node_getLastChild(this);
    }

    public int getLength() {
        return DomImpl._childNodes_getLength(this);
    }

    @Override // org.w3c.dom.Node
    public String getLocalName() {
        return DomImpl._node_getLocalName(this);
    }

    @Override // org.w3c.dom.Node
    public String getNamespaceURI() {
        return DomImpl._node_getNamespaceURI(this);
    }

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

    @Override // org.w3c.dom.Node
    public String getTextContent() {
        return DomImpl._node_getTextContent(this);
    }

    @Override // org.w3c.dom.Node
    public Object getUserData(String str) {
        return DomImpl._node_getUserData(this, str);
    }

    @Override // org.w3c.dom.Node
    public boolean hasAttributes() {
        return DomImpl._node_hasAttributes(this);
    }

    @Override // org.w3c.dom.Node
    public boolean hasChildNodes() {
        return DomImpl._node_hasChildNodes(this);
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

    @Override // org.w3c.dom.Node
    public String lookupNamespaceURI(String str) {
        return DomImpl._node_lookupNamespaceURI(this, str);
    }

    @Override // org.w3c.dom.Node
    public String lookupPrefix(String str) {
        return DomImpl._node_lookupPrefix(this, str);
    }

    public boolean nodeCanHavePrefixUri() {
        return false;
    }

    @Override // org.w3c.dom.Node
    public void normalize() {
        DomImpl._node_normalize(this);
    }

    @Override // org.w3c.dom.Node
    public Node removeChild(Node node) {
        return DomImpl._node_removeChild(this, node);
    }

    @Override // org.w3c.dom.Node
    public Node replaceChild(Node node, Node node2) {
        return DomImpl._node_replaceChild(this, node, node2);
    }

    @Override // org.w3c.dom.Node
    public void setNodeValue(String str) {
        DomImpl._node_setNodeValue(this, str);
    }

    @Override // org.w3c.dom.Node
    public void setPrefix(String str) {
        DomImpl._node_setPrefix(this, str);
    }

    @Override // org.w3c.dom.Node
    public void setTextContent(String str) {
        DomImpl._node_setTextContent(this, str);
    }

    @Override // org.w3c.dom.Node
    public Object setUserData(String str, Object obj, UserDataHandler userDataHandler) {
        return DomImpl._node_setUserData(this, str, obj, userDataHandler);
    }

    public NodeList getChildNodes() {
        return this;
    }

    @Override // org.apache.xmlbeans.impl.store.Xobj
    public DomImpl.Dom getDom() {
        return this;
    }
}
