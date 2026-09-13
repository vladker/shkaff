package org.apache.xmlbeans.impl.xpath;

import javax.xml.namespace.QName;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
class XPathStep {
    final boolean _attr;
    XPathStep _backtrack;
    final boolean _deep;
    int _flags;
    boolean _hasBacktrack;
    final QName _name;
    XPathStep _next;
    XPathStep _prev;

    public XPathStep(boolean z6, boolean z7, QName qName) {
        this._name = qName;
        this._deep = z6;
        this._attr = z7;
        int i5 = (z6 || !z7) ? 2 : 0;
        this._flags = z7 ? i5 | 4 : i5;
    }

    public boolean isWild() {
        return this._name.getLocalPart().length() == 0;
    }

    public boolean match(QName qName) {
        String localPart = this._name.getLocalPart();
        String localPart2 = qName.getLocalPart();
        int length = localPart.length();
        if (length == 0) {
            String namespaceURI = this._name.getNamespaceURI();
            return namespaceURI.isEmpty() || namespaceURI.equals(qName.getNamespaceURI());
        }
        if (length != localPart2.length()) {
            return false;
        }
        String namespaceURI2 = this._name.getNamespaceURI();
        String namespaceURI3 = qName.getNamespaceURI();
        return namespaceURI2.length() == namespaceURI3.length() && localPart.equals(localPart2) && namespaceURI2.equals(namespaceURI3);
    }
}
