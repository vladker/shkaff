package org.apache.poi.poifs.crypt.dsig.facets;

import Q4.c;
import Q4.f;
import Q4.g;
import Q4.l;
import Q4.m;
import Q4.n;
import Q4.t;
import Q4.u;
import java.io.IOException;
import java.math.BigInteger;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.xml.crypto.MarshalException;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.poifs.crypt.dsig.SignatureConfig;
import org.apache.poi.poifs.crypt.dsig.SignatureInfo;
import org.apache.poi.poifs.crypt.dsig.services.RevocationData;
import org.apache.xml.security.c14n.Canonicalizer;
import org.apache.xmlbeans.XmlException;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.x509.Extension;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XAdESXLSignatureFacet implements SignatureFacet {
    private static final Logger LOG = LogManager.getLogger((Class<?>) XAdESXLSignatureFacet.class);
    private final CertificateFactory certificateFactory;

    public XAdESXLSignatureFacet() {
        try {
            this.certificateFactory = CertificateFactory.getInstance("X.509");
        } catch (CertificateException e) {
            throw new RuntimeException("X509 JCA error: " + e.getMessage(), e);
        }
    }

    private void addCertificateValues(t tVar, SignatureConfig signatureConfig) {
        List<X509Certificate> signingCertificateChain = signatureConfig.getSigningCertificateChain();
        if (signingCertificateChain.size() < 2) {
            return;
        }
        tVar.r();
        try {
            Iterator<X509Certificate> it = signingCertificateChain.subList(1, signingCertificateChain.size()).iterator();
            if (it.hasNext()) {
                it.next();
                throw null;
            }
        } catch (CertificateEncodingException e) {
            throw new RuntimeException("certificate encoding error: " + e.getMessage(), e);
        }
    }

    private void addRevocationCRL(g gVar, SignatureConfig signatureConfig, RevocationData revocationData) {
        if (revocationData.hasCRLs()) {
            gVar.o();
            gVar.q();
            Iterator<byte[]> it = revocationData.getCRLs().iterator();
            if (it.hasNext()) {
                it.next();
                throw null;
            }
        }
    }

    private void addRevocationOCSP(g gVar, SignatureConfig signatureConfig, RevocationData revocationData) {
        if (revocationData.hasOCSPs()) {
            gVar.e();
            Iterator<byte[]> it = revocationData.getOCSPs().iterator();
            if (it.hasNext()) {
                it.next();
                try {
                    throw null;
                } catch (Exception e) {
                    throw new RuntimeException("OCSP decoding error: " + e.getMessage(), e);
                }
            }
        }
    }

    private f completeCertificateRefs(t tVar, SignatureConfig signatureConfig) {
        tVar.a();
        throw null;
    }

    private void createRevocationValues(n nVar, RevocationData revocationData) {
        if (revocationData.hasCRLs()) {
            nVar.l();
            Iterator<byte[]> it = revocationData.getCRLs().iterator();
            if (it.hasNext()) {
                it.next();
                throw null;
            }
        }
        if (revocationData.hasOCSPs()) {
            nVar.d();
            Iterator<byte[]> it2 = revocationData.getOCSPs().iterator();
            if (it2.hasNext()) {
                it2.next();
                throw null;
            }
        }
    }

    private R4.a createValidationData(RevocationData revocationData) {
        R4.a.f612d0.newInstance().getClass();
        throw new ClassCastException();
    }

    private u createXAdESTimeStamp(SignatureInfo signatureInfo, RevocationData revocationData, Node... nodeArr) {
        SignatureConfig signatureConfig = signatureInfo.getSignatureConfig();
        try {
            signatureConfig.getTspService().timeStamp(signatureInfo, getC14nValue(Arrays.asList(nodeArr), signatureConfig.getXadesCanonicalizationMethod()), revocationData);
            u.f582b0.newInstance().getClass();
            throw new ClassCastException();
        } catch (Exception e) {
            throw new RuntimeException("error while creating a time-stamp: " + e.getMessage(), e);
        }
    }

    private static byte[] getC14nValue(List<Node> list, String str) {
        try {
            UnsynchronizedByteArrayOutputStream unsynchronizedByteArrayOutputStream = new UnsynchronizedByteArrayOutputStream();
            try {
                Iterator<Node> it = list.iterator();
                while (it.hasNext()) {
                    Canonicalizer.getInstance(str).canonicalizeSubtree(it.next(), unsynchronizedByteArrayOutputStream);
                }
                byte[] byteArray = unsynchronizedByteArrayOutputStream.toByteArray();
                unsynchronizedByteArrayOutputStream.close();
                return byteArray;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        unsynchronizedByteArrayOutputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e6) {
            throw new RuntimeException("c14n error: " + e6.getMessage(), e6);
        }
    }

    private BigInteger getCrlNumber(X509CRL x509crl) {
        byte[] extensionValue = x509crl.getExtensionValue(Extension.cRLNumber.getId());
        if (extensionValue == null) {
            return null;
        }
        try {
            ASN1InputStream aSN1InputStream = new ASN1InputStream(extensionValue);
            try {
                ASN1InputStream aSN1InputStream2 = new ASN1InputStream(aSN1InputStream.readObject().getOctets());
                try {
                    BigInteger positiveValue = aSN1InputStream2.readObject().getPositiveValue();
                    aSN1InputStream2.close();
                    aSN1InputStream.close();
                    return positiveValue;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            aSN1InputStream2.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                try {
                    throw th4;
                } catch (Throwable th5) {
                    try {
                        aSN1InputStream.close();
                    } catch (Throwable th6) {
                        th4.addSuppressed(th6);
                    }
                    throw th5;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("I/O error: " + e.getMessage(), e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.crypto.MarshalException */
    private m getQualProps(NodeList nodeList) throws MarshalException {
        if (nodeList.getLength() != 1) {
            throw new MarshalException("no XAdES-BES extension present");
        }
        try {
            if (l.f578U.parse(nodeList.item(0), POIXMLTypeLoader.DEFAULT_XML_OPTIONS) == 0) {
                throw null;
            }
            throw new ClassCastException();
        } catch (XmlException e) {
            throw new MarshalException(e);
        }
    }

    private static /* synthetic */ void lambda$completeCertificateRefs$0(c cVar, SignatureConfig signatureConfig, X509Certificate x509Certificate) {
        cVar.p();
        XAdESSignatureFacet.setCertID(null, signatureConfig, false, x509Certificate);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.crypto.MarshalException */
    @Override // org.apache.poi.poifs.crypt.dsig.facets.SignatureFacet
    public void postSign(SignatureInfo signatureInfo, Document document) throws MarshalException {
        LOG.atDebug().log("XAdES-X-L post sign phase");
        signatureInfo.getSignatureConfig();
        getQualProps(document.getElementsByTagNameNS(SignatureFacet.XADES_132_NS, "QualifyingProperties"));
        throw null;
    }
}
