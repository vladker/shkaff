package org.apache.poi.poifs.crypt.dsig.facets;

import Q4.m;
import javax.xml.crypto.MarshalException;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.poifs.crypt.dsig.SignatureInfo;
import org.apache.xmlbeans.XmlException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Office2010SignatureFacet implements SignatureFacet {
    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.crypto.MarshalException */
    @Override // org.apache.poi.poifs.crypt.dsig.facets.SignatureFacet
    public void postSign(SignatureInfo signatureInfo, Document document) throws MarshalException {
        NodeList elementsByTagNameNS = document.getElementsByTagNameNS(SignatureFacet.XADES_132_NS, "QualifyingProperties");
        if (elementsByTagNameNS.getLength() != 1) {
            throw new MarshalException("no XAdES-BES extension present");
        }
        try {
            if (m.f580W.parse(elementsByTagNameNS.item(0), POIXMLTypeLoader.DEFAULT_XML_OPTIONS) == 0) {
                throw null;
            }
            throw new ClassCastException();
        } catch (XmlException e) {
            throw new MarshalException(e);
        }
    }
}
