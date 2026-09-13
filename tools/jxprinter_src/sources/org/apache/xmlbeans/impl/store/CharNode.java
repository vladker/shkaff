package org.apache.xmlbeans.impl.store;

import java.io.PrintStream;
import javax.xml.namespace.QName;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.UserDataHandler;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
abstract class CharNode implements DomImpl.Dom, Node, CharacterData {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    int _cch;
    private Locale _locale;
    CharNode _next;
    int _off;
    CharNode _prev;
    private Object _src;

    public CharNode(Locale locale) {
        this._locale = locale;
    }

    public static CharNode appendNode(CharNode charNode, CharNode charNode2) {
        return insertNode(charNode, charNode2, null);
    }

    public static CharNode appendNodes(CharNode charNode, CharNode charNode2) {
        if (charNode == null) {
            return charNode2;
        }
        CharNode charNode3 = charNode;
        while (true) {
            CharNode charNode4 = charNode3._next;
            if (charNode4 == null) {
                charNode3._next = charNode2;
                charNode2._prev = charNode3;
                return charNode;
            }
            charNode3 = charNode4;
        }
    }

    public static CharNode copyNodes(CharNode charNode, Object obj) {
        TextNode textNode = null;
        TextNode textNode2 = null;
        while (charNode != null) {
            TextNode textNodeCreateTextNode = charNode instanceof TextNode ? charNode.locale().createTextNode() : charNode.locale().createCdataNode();
            textNodeCreateTextNode.setChars(obj, charNode._off, charNode._cch);
            if (textNode == null) {
                textNode = textNodeCreateTextNode;
            }
            if (textNode2 != null) {
                textNode2._next = textNodeCreateTextNode;
                textNodeCreateTextNode._prev = textNode2;
            }
            charNode = charNode._next;
            textNode2 = textNodeCreateTextNode;
        }
        return textNode;
    }

    public static CharNode insertNode(CharNode charNode, CharNode charNode2, CharNode charNode3) {
        CharNode charNode4;
        if (charNode == null) {
            return charNode2;
        }
        if (charNode == charNode3) {
            charNode._prev = charNode2;
            charNode2._next = charNode;
            return charNode2;
        }
        CharNode charNode5 = charNode;
        while (true) {
            charNode4 = charNode5._next;
            if (charNode4 == charNode3) {
                break;
            }
            charNode5 = charNode4;
        }
        charNode2._next = charNode4;
        if (charNode4 != null) {
            charNode5._next._prev = charNode2;
        }
        charNode2._prev = charNode5;
        charNode5._next = charNode2;
        return charNode;
    }

    public static boolean isOnList(CharNode charNode, CharNode charNode2) {
        while (charNode != null) {
            if (charNode == charNode2) {
                return true;
            }
            charNode = charNode._next;
        }
        return false;
    }

    private boolean isValid() {
        return (this._src instanceof DomImpl.Dom) == (this._locale == null);
    }

    public static CharNode remove(CharNode charNode, CharNode charNode2) {
        if (charNode == charNode2) {
            charNode = charNode2._next;
        } else {
            charNode2._prev._next = charNode2._next;
        }
        CharNode charNode3 = charNode2._next;
        if (charNode3 != null) {
            charNode3._prev = charNode2._prev;
        }
        charNode2._next = null;
        charNode2._prev = null;
        return charNode;
    }

    @Override // org.w3c.dom.Node
    public Node appendChild(Node node) {
        return DomImpl._node_appendChild(this, node);
    }

    @Override // org.w3c.dom.CharacterData
    public void appendData(String str) {
        DomImpl._characterData_appendData(this, str);
    }

    @Override // org.w3c.dom.Node
    public Node cloneNode(boolean z6) {
        return DomImpl._node_cloneNode(this, z6);
    }

    @Override // org.w3c.dom.Node
    public short compareDocumentPosition(Node node) {
        return DomImpl._node_compareDocumentPosition(this, node);
    }

    @Override // org.w3c.dom.CharacterData
    public void deleteData(int i5, int i6) {
        DomImpl._characterData_deleteData(this, i5, i6);
    }

    @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
    public void dump(PrintStream printStream, Object obj) {
        Object obj2 = this._src;
        if (obj2 instanceof DomImpl.Dom) {
            ((DomImpl.Dom) obj2).dump(printStream, obj);
            return;
        }
        printStream.println("Lonely CharNode: \"" + CharUtil.getString(this._src, this._off, this._cch) + "\"");
    }

    @Override // org.w3c.dom.Node
    public NamedNodeMap getAttributes() {
        return null;
    }

    @Override // org.w3c.dom.Node
    public String getBaseURI() {
        return DomImpl._node_getBaseURI(this);
    }

    @Override // org.w3c.dom.Node
    public NodeList getChildNodes() {
        return DomImpl._emptyNodeList;
    }

    @Override // org.w3c.dom.CharacterData
    public String getData() {
        return DomImpl._characterData_getData(this);
    }

    public DomImpl.Dom getDom() {
        Object obj = this._src;
        if (obj instanceof DomImpl.Dom) {
            return (DomImpl.Dom) obj;
        }
        return null;
    }

    @Override // org.w3c.dom.Node
    public Object getFeature(String str, String str2) {
        return DomImpl._node_getFeature(this, str, str2);
    }

    @Override // org.w3c.dom.Node
    public Node getFirstChild() {
        return null;
    }

    @Override // org.w3c.dom.Node
    public Node getLastChild() {
        return null;
    }

    @Override // org.w3c.dom.CharacterData
    public int getLength() {
        return DomImpl._characterData_getLength(this);
    }

    @Override // org.w3c.dom.Node
    public String getLocalName() {
        return DomImpl._node_getLocalName(this);
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

    public Object getObject() {
        return this._src;
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
        return null;
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
        return false;
    }

    @Override // org.w3c.dom.Node
    public boolean hasChildNodes() {
        return false;
    }

    @Override // org.w3c.dom.Node
    public Node insertBefore(Node node, Node node2) {
        return DomImpl._node_insertBefore(this, node, node2);
    }

    @Override // org.w3c.dom.CharacterData
    public void insertData(int i5, String str) {
        DomImpl._characterData_insertData(this, i5, str);
    }

    @Override // org.w3c.dom.Node
    public boolean isDefaultNamespace(String str) {
        return DomImpl._node_isDefaultNamespace(this, str);
    }

    @Override // org.w3c.dom.Node
    public boolean isEqualNode(Node node) {
        return DomImpl._node_isEqualNode(this, node);
    }

    public boolean isNodeAftertext() {
        Xobj xobj = (Xobj) this._src;
        if (xobj._charNodesValue == null) {
            return true;
        }
        CharNode charNode = xobj._charNodesAfter;
        if (charNode == null) {
            return false;
        }
        return isOnList(charNode, this);
    }

    @Override // org.w3c.dom.Node
    public boolean isSameNode(Node node) {
        return DomImpl._node_isSameNode(this, node);
    }

    @Override // org.w3c.dom.Node
    public boolean isSupported(String str, String str2) {
        return DomImpl._node_isSupported(this, str, str2);
    }

    @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
    public Locale locale() {
        Locale locale = this._locale;
        return locale == null ? ((DomImpl.Dom) this._src).locale() : locale;
    }

    @Override // org.w3c.dom.Node
    public String lookupNamespaceURI(String str) {
        return DomImpl._node_lookupNamespaceURI(this, str);
    }

    @Override // org.w3c.dom.Node
    public String lookupPrefix(String str) {
        return DomImpl._node_lookupPrefix(this, str);
    }

    @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
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

    @Override // org.w3c.dom.CharacterData
    public void replaceData(int i5, int i6, String str) {
        DomImpl._characterData_replaceData(this, i5, i6, str);
    }

    public void setChars(Object obj, int i5, int i6) {
        if (this._locale == null) {
            this._locale = ((DomImpl.Dom) this._src).locale();
        }
        this._src = obj;
        this._off = i5;
        this._cch = i6;
    }

    @Override // org.w3c.dom.CharacterData
    public void setData(String str) {
        DomImpl._characterData_setData(this, str);
    }

    public void setDom(DomImpl.Dom dom) {
        this._src = dom;
        this._locale = null;
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

    @Override // org.w3c.dom.CharacterData
    public String substringData(int i5, int i6) {
        return DomImpl._characterData_substringData(this, i5, i6);
    }

    @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
    public Cur tempCur() {
        if (!(this._src instanceof DomImpl.Dom)) {
            return null;
        }
        Cur curTempCur = locale().tempCur();
        curTempCur.moveToCharNode(this);
        return curTempCur;
    }

    @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
    public void dump(PrintStream printStream) {
        dump(printStream, this);
    }

    @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
    public void dump() {
        dump(System.out);
    }
}
