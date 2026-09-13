package org.apache.poi.poifs.crypt.dsig;

import A3.AbstractC0157z;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.xml.crypto.URIDereferencer;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hpsf.ClassID;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.poifs.crypt.dsig.facets.SignatureFacet;
import org.apache.poi.poifs.crypt.dsig.services.RevocationDataService;
import org.apache.poi.poifs.crypt.dsig.services.SignaturePolicyService;
import org.apache.poi.poifs.crypt.dsig.services.TSPTimeStampService;
import org.apache.poi.poifs.crypt.dsig.services.TimeStampHttpClient;
import org.apache.poi.poifs.crypt.dsig.services.TimeStampService;
import org.apache.poi.poifs.crypt.dsig.services.TimeStampServiceValidator;
import org.apache.poi.poifs.crypt.dsig.services.TimeStampSimpleHttpClient;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LocaleUtil;
import org.apache.poi.util.Removal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SignatureConfig {
    private static final String DigestMethod_SHA224 = "http://www.w3.org/2001/04/xmldsig-more#sha224";
    private static final String DigestMethod_SHA384 = "http://www.w3.org/2001/04/xmldsig-more#sha384";
    public static final String SIGNATURE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    private static final String XMLSEC_JDK = "org.jcp.xml.dsig.internal.dom.XMLDSigRI";
    private static final String XMLSEC_SANTUARIO = "org.apache.jcp.xml.dsig.internal.dom.XMLDSigRI";
    private boolean allowCRLDownload;
    private boolean allowMultipleSignatures;
    private String commitmentType;
    private final List<CRLEntry> crlEntries;
    private boolean includeIssuerSerial;
    private boolean includeKeyValue;
    private PrivateKey key;
    private final KeyStore keyStore;
    private final Map<String, String> namespacePrefixes;
    private String proxyUrl;
    private RevocationDataService revocationDataService;
    private boolean secureValidation;
    private byte[] signatureImage;
    private byte[] signatureImageInvalid;
    private ClassID signatureImageSetupId;
    private byte[] signatureImageValid;
    private SignaturePolicyService signaturePolicyService;
    private List<X509Certificate> signingCertificateChain;
    private HashAlgorithm tspDigestAlgo;
    private boolean tspOldProtocol;
    private String tspPass;
    private String tspUrl;
    private String tspUser;
    private TimeStampServiceValidator tspValidator;
    private boolean updateConfigOnValidate;
    private HashAlgorithm xadesDigestAlgo;
    private String xadesRole;
    private static final Logger LOG = LogManager.getLogger((Class<?>) SignatureConfig.class);
    private static final List<Supplier<SignatureFacet>> DEFAULT_FACETS = Arrays.asList(new b(0), new b(1), new b(2), new b(3));
    private final ThreadLocal<OPCPackage> opcPackage = new ThreadLocal<>();
    private final ThreadLocal<XMLSignatureFactory> signatureFactory = new ThreadLocal<>();
    private final ThreadLocal<KeyInfoFactory> keyInfoFactory = new ThreadLocal<>();
    private final ThreadLocal<Provider> provider = new ThreadLocal<>();
    private List<SignatureFacet> signatureFacets = new ArrayList();
    private HashAlgorithm digestAlgo = HashAlgorithm.sha256;
    private Date executionTime = new Date();
    private URIDereferencer uriDereferencer = new OOXMLURIDereferencer();
    private String canonicalizationMethod = "http://www.w3.org/TR/2001/REC-xml-c14n-20010315";
    private boolean includeEntireCertificateChain = true;
    private TimeStampService tspService = new TSPTimeStampService();
    private TimeStampHttpClient tspHttpClient = new TimeStampSimpleHttpClient();
    private String tspRequestPolicy = "1.3.6.1.4.1.13762.3";
    private String userAgent = "POI XmlSign Service TSP Client";
    private String xadesSignatureId = "idSignedProperties";
    private boolean xadesSignaturePolicyImplied = true;
    private String xadesCanonicalizationMethod = "http://www.w3.org/2001/10/xml-exc-c14n#";
    private boolean xadesIssuerNameNoReverseOrder = true;
    private String packageSignatureId = "idPackageSignature";
    private String signatureDescription = "Office OpenXML Document";
    private SignatureMarshalListener signatureMarshalListener = new SignatureMarshalDefaultListener();

    /* JADX INFO: renamed from: org.apache.poi.poifs.crypt.dsig.SignatureConfig$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm;

        static {
            int[] iArr = new int[HashAlgorithm.values().length];
            $SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm = iArr;
            try {
                iArr[HashAlgorithm.sha1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm[HashAlgorithm.sha224.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm[HashAlgorithm.sha256.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm[HashAlgorithm.sha384.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm[HashAlgorithm.sha512.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm[HashAlgorithm.ripemd160.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class CRLEntry {
        private final String certCN;
        private final byte[] crlBytes;
        private final String crlURL;

        public CRLEntry(String str, String str2, byte[] bArr) {
            this.crlURL = str;
            this.certCN = str2;
            this.crlBytes = bArr;
        }

        public String getCertCN() {
            return this.certCN;
        }

        public byte[] getCrlBytes() {
            return this.crlBytes;
        }

        public String getCrlURL() {
            return this.crlURL;
        }
    }

    public SignatureConfig() {
        HashMap map = new HashMap();
        this.namespacePrefixes = map;
        this.updateConfigOnValidate = false;
        this.allowMultipleSignatures = false;
        this.secureValidation = true;
        this.commitmentType = "Created and approved this document";
        this.allowCRLDownload = false;
        this.crlEntries = new ArrayList();
        this.keyStore = emptyKeyStore();
        map.put("http://schemas.openxmlformats.org/package/2006/digital-signature", "mdssi");
        map.put(SignatureFacet.XADES_132_NS, "xd");
    }

    private static KeyStore emptyKeyStore() {
        try {
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            keyStore.load(null, null);
            return keyStore;
        } catch (IOException | GeneralSecurityException e) {
            LOG.atError().withThrowable(e).log("unable to create PKCS #12 keystore - XAdES certificate chain lookups disabled");
            return null;
        }
    }

    private static HashAlgorithm getDigestMethodAlgo(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        switch (str) {
            case "http://www.w3.org/2001/04/xmlenc#sha256":
                return HashAlgorithm.sha256;
            case "http://www.w3.org/2001/04/xmlenc#sha512":
                return HashAlgorithm.sha512;
            case "http://www.w3.org/2000/09/xmldsig#sha1":
                return HashAlgorithm.sha1;
            case "http://www.w3.org/2001/04/xmlenc#ripemd160":
                return HashAlgorithm.ripemd160;
            case "http://www.w3.org/2001/04/xmldsig-more#sha224":
                return HashAlgorithm.sha224;
            case "http://www.w3.org/2001/04/xmldsig-more#sha384":
                return HashAlgorithm.sha384;
            default:
                throw new EncryptedDocumentException(AbstractC0157z.o("Hash algorithm ", str, " not supported for signing."));
        }
    }

    public static String[] getProviderNames() {
        String property = System.getProperty("jsr105Provider");
        return (property == null || "".equals(property)) ? new String[]{XMLSEC_SANTUARIO, XMLSEC_JDK} : new String[]{property, XMLSEC_SANTUARIO, XMLSEC_JDK};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getCachedCertificateByPrinicipal$0(String str, X509Certificate x509Certificate) {
        return str.equalsIgnoreCase(x509Certificate.getSubjectX500Principal().getName());
    }

    private static <T> T nvl(T t6, T t7) {
        return t6 == null ? t7 : t6;
    }

    private static String verifyCanonicalizationMethod(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return str2;
        }
        switch (str) {
            case "http://www.w3.org/TR/2001/REC-xml-c14n-20010315":
            case "http://www.w3.org/2000/09/xmldsig#enveloped-signature":
            case "http://www.w3.org/2001/10/xml-exc-c14n#":
            case "http://www.w3.org/TR/2001/REC-xml-c14n-20010315#WithComments":
            case "http://www.w3.org/2001/10/xml-exc-c14n#WithComments":
                return str;
            default:
                throw new EncryptedDocumentException("Unknown CanonicalizationMethod: ".concat(str));
        }
    }

    public CRLEntry addCRL(String str, String str2, byte[] bArr) {
        CRLEntry cRLEntry = new CRLEntry(str, str2, bArr);
        this.crlEntries.add(cRLEntry);
        return cRLEntry;
    }

    public void addCachedCertificate(String str, X509Certificate x509Certificate) {
        if (str == null) {
            str = x509Certificate.getSubjectX500Principal().getName();
        }
        KeyStore keyStore = this.keyStore;
        if (keyStore != null) {
            synchronized (keyStore) {
                this.keyStore.setCertificateEntry(str, x509Certificate);
            }
        }
    }

    public void addSignatureFacet(SignatureFacet signatureFacet) {
        this.signatureFacets.add(signatureFacet);
    }

    public String formatExecutionTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SIGNATURE_TIME_FORMAT, Locale.ROOT);
        simpleDateFormat.setTimeZone(LocaleUtil.TIMEZONE_UTC);
        return simpleDateFormat.format(getExecutionTime());
    }

    public X509Certificate getCachedCertificateByPrinicipal(final String str) {
        KeyStore keyStore = this.keyStore;
        if (keyStore == null) {
            return null;
        }
        try {
            ArrayList list = Collections.list(keyStore.aliases());
            int size = list.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj = list.get(i5);
                i5++;
                String str2 = (String) obj;
                Certificate[] certificateChain = this.keyStore.getCertificateChain(str2);
                if (certificateChain == null) {
                    Certificate certificate = this.keyStore.getCertificate(str2);
                    if (certificate != null) {
                        certificateChain = new Certificate[]{certificate};
                    }
                }
                Optional optionalFindFirst = Stream.of((Object[]) certificateChain).map(new com.google.android.material.color.utilities.g(20)).filter(new Predicate() { // from class: org.apache.poi.poifs.crypt.dsig.a
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj2) {
                        return SignatureConfig.lambda$getCachedCertificateByPrinicipal$0(str, (X509Certificate) obj2);
                    }
                }).findFirst();
                if (optionalFindFirst.isPresent()) {
                    return (X509Certificate) optionalFindFirst.get();
                }
            }
            return null;
        } catch (KeyStoreException unused) {
            return null;
        }
    }

    public String getCanonicalizationMethod() {
        return this.canonicalizationMethod;
    }

    public String getCommitmentType() {
        return this.commitmentType;
    }

    public List<CRLEntry> getCrlEntries() {
        return this.crlEntries;
    }

    public HashAlgorithm getDigestAlgo() {
        return this.digestAlgo;
    }

    public String getDigestMethodUri() {
        return getDigestMethodUri(getDigestAlgo());
    }

    public Date getExecutionTime() {
        return this.executionTime;
    }

    public PrivateKey getKey() {
        return this.key;
    }

    @Removal(version = "5.0.0")
    @Deprecated
    public KeyInfoFactory getKeyInfoFactory() {
        return this.keyInfoFactory.get();
    }

    public KeyStore getKeyStore() {
        return this.keyStore;
    }

    public Map<String, String> getNamespacePrefixes() {
        return this.namespacePrefixes;
    }

    @Removal(version = "5.0.0")
    @Deprecated
    public OPCPackage getOpcPackage() {
        return this.opcPackage.get();
    }

    public String getPackageSignatureId() {
        return this.packageSignatureId;
    }

    @Removal(version = "5.0.0")
    @Deprecated
    public Provider getProvider() {
        return this.provider.get();
    }

    public String getProxyUrl() {
        return this.proxyUrl;
    }

    public RevocationDataService getRevocationDataService() {
        return this.revocationDataService;
    }

    public String getSignatureDescription() {
        return this.signatureDescription;
    }

    public List<SignatureFacet> getSignatureFacets() {
        return this.signatureFacets.isEmpty() ? (List) DEFAULT_FACETS.stream().map(new com.google.android.material.color.utilities.g(21)).collect(Collectors.toList()) : this.signatureFacets;
    }

    @Removal(version = "5.0.0")
    @Deprecated
    public XMLSignatureFactory getSignatureFactory() {
        return this.signatureFactory.get();
    }

    public byte[] getSignatureImage() {
        return this.signatureImage;
    }

    public byte[] getSignatureImageInvalid() {
        return this.signatureImageInvalid;
    }

    public ClassID getSignatureImageSetupId() {
        return this.signatureImageSetupId;
    }

    public byte[] getSignatureImageValid() {
        return this.signatureImageValid;
    }

    public SignatureMarshalListener getSignatureMarshalListener() {
        return this.signatureMarshalListener;
    }

    public String getSignatureMethodUri() {
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm[getDigestAlgo().ordinal()]) {
            case 1:
                return "http://www.w3.org/2000/09/xmldsig#rsa-sha1";
            case 2:
                return "http://www.w3.org/2001/04/xmldsig-more#rsa-sha224";
            case 3:
                return "http://www.w3.org/2001/04/xmldsig-more#rsa-sha256";
            case 4:
                return "http://www.w3.org/2001/04/xmldsig-more#rsa-sha384";
            case 5:
                return "http://www.w3.org/2001/04/xmldsig-more#rsa-sha512";
            case 6:
                return "http://www.w3.org/2001/04/xmldsig-more#rsa-ripemd160";
            default:
                throw new EncryptedDocumentException("Hash algorithm " + getDigestAlgo() + " not supported for signing.");
        }
    }

    public SignaturePolicyService getSignaturePolicyService() {
        return this.signaturePolicyService;
    }

    public List<X509Certificate> getSigningCertificateChain() {
        return this.signingCertificateChain;
    }

    public HashAlgorithm getTspDigestAlgo() {
        return (HashAlgorithm) nvl(this.tspDigestAlgo, this.digestAlgo);
    }

    public TimeStampHttpClient getTspHttpClient() {
        return this.tspHttpClient;
    }

    public String getTspPass() {
        return this.tspPass;
    }

    public String getTspRequestPolicy() {
        return this.tspRequestPolicy;
    }

    public TimeStampService getTspService() {
        return this.tspService;
    }

    public String getTspUrl() {
        return this.tspUrl;
    }

    public String getTspUser() {
        return this.tspUser;
    }

    public TimeStampServiceValidator getTspValidator() {
        return this.tspValidator;
    }

    @Removal(version = "5.0.0")
    @Deprecated
    public URIDereferencer getUriDereferencer() {
        return this.uriDereferencer;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public String getXadesCanonicalizationMethod() {
        return this.xadesCanonicalizationMethod;
    }

    public HashAlgorithm getXadesDigestAlgo() {
        return (HashAlgorithm) nvl(this.xadesDigestAlgo, this.digestAlgo);
    }

    public String getXadesRole() {
        return this.xadesRole;
    }

    public String getXadesSignatureId() {
        return (String) nvl(this.xadesSignatureId, "idSignedProperties");
    }

    public boolean isAllowCRLDownload() {
        return this.allowCRLDownload;
    }

    public boolean isAllowMultipleSignatures() {
        return this.allowMultipleSignatures;
    }

    public boolean isIncludeEntireCertificateChain() {
        return this.includeEntireCertificateChain;
    }

    public boolean isIncludeIssuerSerial() {
        return this.includeIssuerSerial;
    }

    public boolean isIncludeKeyValue() {
        return this.includeKeyValue;
    }

    public boolean isSecureValidation() {
        return this.secureValidation;
    }

    public boolean isTspOldProtocol() {
        return this.tspOldProtocol;
    }

    public boolean isUpdateConfigOnValidate() {
        return this.updateConfigOnValidate;
    }

    public boolean isXadesIssuerNameNoReverseOrder() {
        return this.xadesIssuerNameNoReverseOrder;
    }

    public boolean isXadesSignaturePolicyImplied() {
        return this.xadesSignaturePolicyImplied;
    }

    public void setAllowCRLDownload(boolean z6) {
        this.allowCRLDownload = z6;
    }

    public void setAllowMultipleSignatures(boolean z6) {
        this.allowMultipleSignatures = z6;
    }

    public void setCanonicalizationMethod(String str) {
        this.canonicalizationMethod = verifyCanonicalizationMethod(str, "http://www.w3.org/TR/2001/REC-xml-c14n-20010315");
    }

    public void setCommitmentType(String str) {
        this.commitmentType = str;
    }

    public void setDigestAlgo(HashAlgorithm hashAlgorithm) {
        this.digestAlgo = hashAlgorithm;
    }

    public void setExecutionTime(Date date) {
        this.executionTime = date;
    }

    public void setIncludeEntireCertificateChain(boolean z6) {
        this.includeEntireCertificateChain = z6;
    }

    public void setIncludeIssuerSerial(boolean z6) {
        this.includeIssuerSerial = z6;
    }

    public void setIncludeKeyValue(boolean z6) {
        this.includeKeyValue = z6;
    }

    public void setKey(PrivateKey privateKey) {
        this.key = privateKey;
    }

    @Removal(version = "5.0.0")
    @Deprecated
    public void setKeyInfoFactory(KeyInfoFactory keyInfoFactory) {
        this.keyInfoFactory.set(keyInfoFactory);
    }

    public void setNamespacePrefixes(Map<String, String> map) {
        this.namespacePrefixes.clear();
        this.namespacePrefixes.putAll(map);
    }

    @Removal(version = "5.0.0")
    @Deprecated
    public void setOpcPackage(OPCPackage oPCPackage) {
        this.opcPackage.set(oPCPackage);
    }

    public void setPackageSignatureId(String str) {
        this.packageSignatureId = (String) nvl(str, "xmldsig-" + UUID.randomUUID());
    }

    @Removal(version = "5.0.0")
    @Internal
    @Deprecated
    public void setProvider(Provider provider) {
        this.provider.set(provider);
    }

    public void setProxyUrl(String str) {
        this.proxyUrl = str;
    }

    public void setRevocationDataService(RevocationDataService revocationDataService) {
        this.revocationDataService = revocationDataService;
    }

    public void setSecureValidation(boolean z6) {
        this.secureValidation = z6;
    }

    public void setSignatureDescription(String str) {
        this.signatureDescription = str;
    }

    public void setSignatureFacets(List<SignatureFacet> list) {
        this.signatureFacets = list;
    }

    @Removal(version = "5.0.0")
    @Deprecated
    public void setSignatureFactory(XMLSignatureFactory xMLSignatureFactory) {
        this.signatureFactory.set(xMLSignatureFactory);
    }

    public void setSignatureImage(byte[] bArr) {
        this.signatureImage = bArr == null ? null : (byte[]) bArr.clone();
    }

    public void setSignatureImageInvalid(byte[] bArr) {
        this.signatureImageInvalid = bArr == null ? null : (byte[]) bArr.clone();
    }

    public void setSignatureImageSetupId(ClassID classID) {
        this.signatureImageSetupId = classID;
    }

    public void setSignatureImageValid(byte[] bArr) {
        this.signatureImageValid = bArr == null ? null : (byte[]) bArr.clone();
    }

    public void setSignatureMarshalListener(SignatureMarshalListener signatureMarshalListener) {
        this.signatureMarshalListener = signatureMarshalListener;
    }

    public void setSignatureMethodFromUri(String str) {
        str.getClass();
        switch (str) {
            case "http://www.w3.org/2001/04/xmldsig-more#rsa-ripemd160":
                setDigestAlgo(HashAlgorithm.ripemd160);
                return;
            case "http://www.w3.org/2001/04/xmldsig-more#rsa-sha224":
                setDigestAlgo(HashAlgorithm.sha224);
                return;
            case "http://www.w3.org/2001/04/xmldsig-more#rsa-sha256":
                setDigestAlgo(HashAlgorithm.sha256);
                return;
            case "http://www.w3.org/2001/04/xmldsig-more#rsa-sha384":
                setDigestAlgo(HashAlgorithm.sha384);
                return;
            case "http://www.w3.org/2001/04/xmldsig-more#rsa-sha512":
                setDigestAlgo(HashAlgorithm.sha512);
                return;
            case "http://www.w3.org/2000/09/xmldsig#rsa-sha1":
                setDigestAlgo(HashAlgorithm.sha1);
                return;
            default:
                throw new EncryptedDocumentException(AbstractC0157z.o("Hash algorithm ", str, " not supported."));
        }
    }

    public void setSignaturePolicyService(SignaturePolicyService signaturePolicyService) {
        this.signaturePolicyService = signaturePolicyService;
    }

    public void setSigningCertificateChain(List<X509Certificate> list) {
        this.signingCertificateChain = list;
    }

    public void setTspDigestAlgo(HashAlgorithm hashAlgorithm) {
        this.tspDigestAlgo = hashAlgorithm;
    }

    public void setTspHttpClient(TimeStampHttpClient timeStampHttpClient) {
        this.tspHttpClient = timeStampHttpClient;
    }

    public void setTspOldProtocol(boolean z6) {
        this.tspOldProtocol = z6;
    }

    public void setTspPass(String str) {
        this.tspPass = str;
    }

    public void setTspRequestPolicy(String str) {
        this.tspRequestPolicy = str;
    }

    public void setTspService(TimeStampService timeStampService) {
        this.tspService = timeStampService;
    }

    public void setTspUrl(String str) {
        this.tspUrl = str;
    }

    public void setTspUser(String str) {
        this.tspUser = str;
    }

    public void setTspValidator(TimeStampServiceValidator timeStampServiceValidator) {
        this.tspValidator = timeStampServiceValidator;
    }

    public void setUpdateConfigOnValidate(boolean z6) {
        this.updateConfigOnValidate = z6;
    }

    @Removal(version = "5.0.0")
    @Deprecated
    public void setUriDereferencer(URIDereferencer uRIDereferencer) {
        this.uriDereferencer = uRIDereferencer;
    }

    public void setUserAgent(String str) {
        this.userAgent = str;
    }

    public void setXadesCanonicalizationMethod(String str) {
        this.xadesCanonicalizationMethod = verifyCanonicalizationMethod(str, "http://www.w3.org/2001/10/xml-exc-c14n#");
    }

    public void setXadesDigestAlgo(HashAlgorithm hashAlgorithm) {
        this.xadesDigestAlgo = hashAlgorithm;
    }

    public void setXadesIssuerNameNoReverseOrder(boolean z6) {
        this.xadesIssuerNameNoReverseOrder = z6;
    }

    public void setXadesRole(String str) {
        this.xadesRole = str;
    }

    public void setXadesSignatureId(String str) {
        this.xadesSignatureId = str;
    }

    public void setXadesSignaturePolicyImplied(boolean z6) {
        this.xadesSignaturePolicyImplied = z6;
    }

    public static String getDigestMethodUri(HashAlgorithm hashAlgorithm) {
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm[hashAlgorithm.ordinal()]) {
            case 1:
                return "http://www.w3.org/2000/09/xmldsig#sha1";
            case 2:
                return DigestMethod_SHA224;
            case 3:
                return "http://www.w3.org/2001/04/xmlenc#sha256";
            case 4:
                return DigestMethod_SHA384;
            case 5:
                return "http://www.w3.org/2001/04/xmlenc#sha512";
            case 6:
                return "http://www.w3.org/2001/04/xmlenc#ripemd160";
            default:
                throw new EncryptedDocumentException("Hash algorithm " + hashAlgorithm + " not supported for signing.");
        }
    }

    public void setExecutionTime(String str) {
        if (str == null || "".equals(str)) {
            return;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SIGNATURE_TIME_FORMAT, Locale.ROOT);
        simpleDateFormat.setTimeZone(LocaleUtil.TIMEZONE_UTC);
        try {
            this.executionTime = simpleDateFormat.parse(str);
        } catch (ParseException unused) {
            LOG.atWarn().log("Illegal execution time: {}. Must be formatted as yyyy-MM-dd'T'HH:mm:ss'Z'", str);
        }
    }

    public void setXadesDigestAlgo(String str) {
        this.xadesDigestAlgo = getDigestMethodAlgo(str);
    }

    public void addCachedCertificate(String str, byte[] bArr) {
        addCachedCertificate((String) null, (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr)));
    }
}
