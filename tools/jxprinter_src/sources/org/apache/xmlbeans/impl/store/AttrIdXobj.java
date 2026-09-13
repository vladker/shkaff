package org.apache.xmlbeans.impl.store;

import javax.xml.namespace.QName;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
class AttrIdXobj extends AttrXobj {
    public AttrIdXobj(Locale locale, QName qName) {
        super(locale, qName);
    }

    @Override // org.apache.xmlbeans.impl.store.AttrXobj, org.w3c.dom.Attr
    public boolean isId() {
        return true;
    }
}
