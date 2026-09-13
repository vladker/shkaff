package org.apache.xmlbeans.impl.store;

import org.w3c.dom.DocumentFragment;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
class DocumentFragXobj extends NodeXobj implements DocumentFragment {
    public DocumentFragXobj(Locale locale) {
        super(locale, 1, 11);
    }

    @Override // org.apache.xmlbeans.impl.store.Xobj
    public Xobj newNode(Locale locale) {
        return new DocumentFragXobj(locale);
    }
}
