package org.apache.xmlbeans.impl.store;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
abstract class NamedNodeXobj extends NodeXobj {
    boolean _canHavePrefixUri;

    public NamedNodeXobj(Locale locale, int i5, int i6) {
        super(locale, i5, i6);
        this._canHavePrefixUri = true;
    }

    @Override // org.apache.xmlbeans.impl.store.NodeXobj, org.apache.xmlbeans.impl.store.DomImpl.Dom
    public boolean nodeCanHavePrefixUri() {
        return this._canHavePrefixUri;
    }
}
