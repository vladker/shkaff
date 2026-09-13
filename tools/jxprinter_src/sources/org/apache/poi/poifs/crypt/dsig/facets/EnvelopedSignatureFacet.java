package org.apache.poi.poifs.crypt.dsig.facets;

import java.util.ArrayList;
import java.util.List;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.XMLObject;
import org.apache.poi.poifs.crypt.dsig.SignatureInfo;
import org.w3c.dom.Document;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class EnvelopedSignatureFacet implements SignatureFacet {
    @Override // org.apache.poi.poifs.crypt.dsig.facets.SignatureFacet
    public void preSign(SignatureInfo signatureInfo, Document document, List<Reference> list, List<XMLObject> list2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(SignatureFacetHelper.newTransform(signatureInfo, "http://www.w3.org/2000/09/xmldsig#enveloped-signature"));
        arrayList.add(SignatureFacetHelper.newTransform(signatureInfo, "http://www.w3.org/2001/10/xml-exc-c14n#"));
        list.add(SignatureFacetHelper.newReference(signatureInfo, "", arrayList, null));
    }
}
