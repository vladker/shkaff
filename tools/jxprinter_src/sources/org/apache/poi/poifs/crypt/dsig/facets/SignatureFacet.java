package org.apache.poi.poifs.crypt.dsig.facets;

import java.util.List;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.XMLObject;
import org.apache.poi.poifs.crypt.dsig.SignatureInfo;
import org.apache.poi.util.Internal;
import org.w3c.dom.Document;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public interface SignatureFacet {
    public static final String MS_DIGSIG_NS = "http://schemas.microsoft.com/office/2006/digsig";
    public static final String OO_DIGSIG_NS = "http://schemas.openxmlformats.org/package/2006/digital-signature";
    public static final String XADES_132_NS = "http://uri.etsi.org/01903/v1.3.2#";
    public static final String XADES_141_NS = "http://uri.etsi.org/01903/v1.4.1#";
    public static final String XML_DIGSIG_NS = "http://www.w3.org/2000/09/xmldsig#";
    public static final String XML_NS = "http://www.w3.org/2000/xmlns/";

    default void postSign(SignatureInfo signatureInfo, Document document) {
    }

    default void preSign(SignatureInfo signatureInfo, Document document, List<Reference> list, List<XMLObject> list2) {
    }
}
