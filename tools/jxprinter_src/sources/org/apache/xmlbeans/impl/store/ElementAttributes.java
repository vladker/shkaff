package org.apache.xmlbeans.impl.store;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
final class ElementAttributes implements NamedNodeMap {
    private ElementXobj _elementXobj;

    public ElementAttributes(ElementXobj elementXobj) {
        this._elementXobj = elementXobj;
    }

    @Override // org.w3c.dom.NamedNodeMap
    public int getLength() {
        return DomImpl._attributes_getLength(this._elementXobj);
    }

    @Override // org.w3c.dom.NamedNodeMap
    public Node getNamedItem(String str) {
        return DomImpl._attributes_getNamedItem(this._elementXobj, str);
    }

    @Override // org.w3c.dom.NamedNodeMap
    public Node getNamedItemNS(String str, String str2) {
        return DomImpl._attributes_getNamedItemNS(this._elementXobj, str, str2);
    }

    @Override // org.w3c.dom.NamedNodeMap
    public Node item(int i5) {
        return DomImpl._attributes_item(this._elementXobj, i5);
    }

    @Override // org.w3c.dom.NamedNodeMap
    public Node removeNamedItem(String str) {
        return DomImpl._attributes_removeNamedItem(this._elementXobj, str);
    }

    @Override // org.w3c.dom.NamedNodeMap
    public Node removeNamedItemNS(String str, String str2) {
        return DomImpl._attributes_removeNamedItemNS(this._elementXobj, str, str2);
    }

    @Override // org.w3c.dom.NamedNodeMap
    public Node setNamedItem(Node node) {
        return DomImpl._attributes_setNamedItem(this._elementXobj, node);
    }

    @Override // org.w3c.dom.NamedNodeMap
    public Node setNamedItemNS(Node node) {
        return DomImpl._attributes_setNamedItemNS(this._elementXobj, node);
    }
}
