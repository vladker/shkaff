package org.apache.xmlbeans.impl.store;

import org.w3c.dom.CDATASection;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
class CdataNode extends TextNode implements CDATASection {
    public CdataNode(Locale locale) {
        super(locale);
    }

    @Override // org.apache.xmlbeans.impl.store.TextNode
    public String name() {
        return "#cdata-section";
    }

    @Override // org.apache.xmlbeans.impl.store.TextNode, org.apache.xmlbeans.impl.store.DomImpl.Dom
    public int nodeType() {
        return 4;
    }
}
