package org.apache.xmlbeans.impl.soap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface Node extends org.w3c.dom.Node {
    void detachNode();

    SOAPElement getParentElement();

    String getValue();

    void recycleNode();

    void setParentElement(SOAPElement sOAPElement);

    void setValue(String str);
}
