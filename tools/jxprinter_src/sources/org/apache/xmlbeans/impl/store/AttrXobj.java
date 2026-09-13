package org.apache.xmlbeans.impl.store;

import javax.xml.namespace.QName;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.TypeInfo;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
class AttrXobj extends NamedNodeXobj implements Attr {
    public AttrXobj(Locale locale, QName qName) {
        super(locale, 3, 2);
        this._name = qName;
    }

    @Override // org.w3c.dom.Attr
    public String getName() {
        return DomImpl._node_getNodeName(this);
    }

    @Override // org.apache.xmlbeans.impl.store.NodeXobj, org.w3c.dom.Node
    public Node getNextSibling() {
        return null;
    }

    @Override // org.w3c.dom.Attr
    public Element getOwnerElement() {
        return DomImpl._attr_getOwnerElement(this);
    }

    @Override // org.w3c.dom.Attr
    public TypeInfo getSchemaTypeInfo() {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Attr
    public boolean getSpecified() {
        return DomImpl._attr_getSpecified(this);
    }

    @Override // org.w3c.dom.Attr
    public String getValue() {
        return DomImpl._node_getNodeValue(this);
    }

    public boolean isId() {
        return false;
    }

    @Override // org.apache.xmlbeans.impl.store.Xobj
    public Xobj newNode(Locale locale) {
        return new AttrXobj(locale, this._name);
    }

    @Override // org.w3c.dom.Attr
    public void setValue(String str) {
        DomImpl._node_setNodeValue(this, str);
    }
}
