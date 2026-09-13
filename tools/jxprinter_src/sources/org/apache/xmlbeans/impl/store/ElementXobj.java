package org.apache.xmlbeans.impl.store;

import javax.xml.namespace.QName;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.TypeInfo;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
class ElementXobj extends NamedNodeXobj implements Element {
    private ElementAttributes _attributes;

    public ElementXobj(Locale locale, QName qName) {
        super(locale, 2, 1);
        this._name = qName;
    }

    @Override // org.w3c.dom.Element
    public String getAttribute(String str) {
        return DomImpl._element_getAttribute(this, str);
    }

    @Override // org.w3c.dom.Element
    public String getAttributeNS(String str, String str2) {
        return DomImpl._element_getAttributeNS(this, str, str2);
    }

    @Override // org.w3c.dom.Element
    public Attr getAttributeNode(String str) {
        return DomImpl._element_getAttributeNode(this, str);
    }

    @Override // org.w3c.dom.Element
    public Attr getAttributeNodeNS(String str, String str2) {
        return DomImpl._element_getAttributeNodeNS(this, str, str2);
    }

    @Override // org.apache.xmlbeans.impl.store.NodeXobj, org.w3c.dom.Node
    public NamedNodeMap getAttributes() {
        if (this._attributes == null) {
            this._attributes = new ElementAttributes(this);
        }
        return this._attributes;
    }

    @Override // org.w3c.dom.Element
    public NodeList getElementsByTagName(String str) {
        return DomImpl._element_getElementsByTagName(this, str);
    }

    @Override // org.w3c.dom.Element
    public NodeList getElementsByTagNameNS(String str, String str2) {
        return DomImpl._element_getElementsByTagNameNS(this, str, str2);
    }

    @Override // org.w3c.dom.Element
    public TypeInfo getSchemaTypeInfo() {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Element
    public String getTagName() {
        return DomImpl._element_getTagName(this);
    }

    @Override // org.w3c.dom.Element
    public boolean hasAttribute(String str) {
        return DomImpl._element_hasAttribute(this, str);
    }

    @Override // org.w3c.dom.Element
    public boolean hasAttributeNS(String str, String str2) {
        return DomImpl._element_hasAttributeNS(this, str, str2);
    }

    @Override // org.apache.xmlbeans.impl.store.Xobj
    public Xobj newNode(Locale locale) {
        return new ElementXobj(locale, this._name);
    }

    @Override // org.w3c.dom.Element
    public void removeAttribute(String str) {
        DomImpl._element_removeAttribute(this, str);
    }

    @Override // org.w3c.dom.Element
    public void removeAttributeNS(String str, String str2) {
        DomImpl._element_removeAttributeNS(this, str, str2);
    }

    @Override // org.w3c.dom.Element
    public Attr removeAttributeNode(Attr attr) {
        return DomImpl._element_removeAttributeNode(this, attr);
    }

    @Override // org.w3c.dom.Element
    public void setAttribute(String str, String str2) {
        DomImpl._element_setAttribute(this, str, str2);
    }

    @Override // org.w3c.dom.Element
    public void setAttributeNS(String str, String str2, String str3) {
        DomImpl._element_setAttributeNS(this, str, str2, str3);
    }

    @Override // org.w3c.dom.Element
    public Attr setAttributeNode(Attr attr) {
        return DomImpl._element_setAttributeNode(this, attr);
    }

    @Override // org.w3c.dom.Element
    public Attr setAttributeNodeNS(Attr attr) {
        return DomImpl._element_setAttributeNodeNS(this, attr);
    }

    @Override // org.w3c.dom.Element
    public void setIdAttribute(String str, boolean z6) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Element
    public void setIdAttributeNS(String str, String str2, boolean z6) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Element
    public void setIdAttributeNode(Attr attr, boolean z6) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }
}
