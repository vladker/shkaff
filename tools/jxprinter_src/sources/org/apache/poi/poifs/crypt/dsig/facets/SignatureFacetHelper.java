package org.apache.poi.poifs.crypt.dsig.facets;

import A3.AbstractC0157z;
import java.security.GeneralSecurityException;
import java.util.List;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.XMLSignatureException;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.spec.DigestMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import org.apache.poi.poifs.crypt.dsig.SignatureInfo;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
final class SignatureFacetHelper {
    private SignatureFacetHelper() {
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.crypto.dsig.XMLSignatureException */
    public static Reference newReference(SignatureInfo signatureInfo, String str, List<Transform> list, String str2) throws XMLSignatureException {
        String digestMethodUri = signatureInfo.getSignatureConfig().getDigestMethodUri();
        XMLSignatureFactory signatureFactory = signatureInfo.getSignatureFactory();
        try {
            return signatureFactory.newReference(str, signatureFactory.newDigestMethod(digestMethodUri, (DigestMethodParameterSpec) null), list, str2, (String) null);
        } catch (GeneralSecurityException e) {
            throw new XMLSignatureException(AbstractC0157z.n("unknown digest method uri: ", digestMethodUri), e);
        }
    }

    public static Transform newTransform(SignatureInfo signatureInfo, String str) {
        return newTransform(signatureInfo, str, null);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.crypto.dsig.XMLSignatureException */
    public static Transform newTransform(SignatureInfo signatureInfo, String str, TransformParameterSpec transformParameterSpec) throws XMLSignatureException {
        try {
            return signatureInfo.getSignatureFactory().newTransform(str, transformParameterSpec);
        } catch (GeneralSecurityException e) {
            throw new XMLSignatureException(AbstractC0157z.n("unknown canonicalization method: ", str), e);
        }
    }
}
