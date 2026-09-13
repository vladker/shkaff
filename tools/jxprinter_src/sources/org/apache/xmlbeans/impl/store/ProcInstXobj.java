package org.apache.xmlbeans.impl.store;

import org.w3c.dom.Node;
import org.w3c.dom.ProcessingInstruction;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
class ProcInstXobj extends NodeXobj implements ProcessingInstruction {
    public ProcInstXobj(Locale locale, String str) {
        super(locale, 5, 7);
        this._name = this._locale.makeQName(null, str);
    }

    @Override // org.w3c.dom.ProcessingInstruction
    public String getData() {
        return DomImpl._processingInstruction_getData(this);
    }

    @Override // org.apache.xmlbeans.impl.store.NodeXobj, org.w3c.dom.Node
    public Node getFirstChild() {
        return null;
    }

    @Override // org.apache.xmlbeans.impl.store.NodeXobj, org.w3c.dom.NodeList, org.w3c.dom.CharacterData
    public int getLength() {
        return 0;
    }

    @Override // org.w3c.dom.ProcessingInstruction
    public String getTarget() {
        return DomImpl._processingInstruction_getTarget(this);
    }

    @Override // org.apache.xmlbeans.impl.store.Xobj
    public Xobj newNode(Locale locale) {
        return new ProcInstXobj(locale, this._name.getLocalPart());
    }

    @Override // org.w3c.dom.ProcessingInstruction
    public void setData(String str) {
        DomImpl._processingInstruction_setData(this, str);
    }
}
