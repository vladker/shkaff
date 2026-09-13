package org.apache.xmlbeans.impl.store;

import org.w3c.dom.Text;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
class TextNode extends CharNode implements Text {
    public TextNode(Locale locale) {
        super(locale);
    }

    @Override // org.w3c.dom.Text
    public String getWholeText() {
        return DomImpl._text_getWholeText(this);
    }

    @Override // org.w3c.dom.Text
    public boolean isElementContentWhitespace() {
        return DomImpl._text_isElementContentWhitespace(this);
    }

    public String name() {
        return "#text";
    }

    @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
    public int nodeType() {
        return 3;
    }

    @Override // org.w3c.dom.Text
    public Text replaceWholeText(String str) {
        return DomImpl._text_replaceWholeText(this, str);
    }

    @Override // org.w3c.dom.Text
    public Text splitText(int i5) {
        return DomImpl._text_splitText(this, i5);
    }
}
