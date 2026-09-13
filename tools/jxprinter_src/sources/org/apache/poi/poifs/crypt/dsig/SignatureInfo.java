package org.apache.poi.poifs.crypt.dsig;

import A3.AbstractC0157z;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.security.Provider;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;
import javax.xml.crypto.MarshalException;
import javax.xml.crypto.URIDereferencer;
import javax.xml.crypto.dsig.Manifest;
import javax.xml.crypto.dsig.TransformException;
import javax.xml.crypto.dsig.XMLObject;
import javax.xml.crypto.dsig.XMLSignatureException;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.SignatureMethodParameterSpec;
import org.apache.jcp.xml.dsig.internal.dom.DOMReference;
import org.apache.jcp.xml.dsig.internal.dom.DOMSignedInfo;
import org.apache.jcp.xml.dsig.internal.dom.DOMSubTreeData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.ooxml.util.DocumentHelper;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
import org.apache.poi.openxml4j.opc.PackageRelationshipTypes;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.poifs.crypt.dsig.facets.SignatureFacet;
import org.apache.poi.poifs.crypt.dsig.services.RelationshipTransformService;
import org.apache.xml.security.Init;
import org.apache.xml.security.utils.XMLUtils;
import org.apache.xmlbeans.XmlOptions;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventListener;
import org.w3c.dom.events.EventTarget;
import org.w3c.dom.events.MutationEvent;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SignatureInfo {
    private static final Logger LOG = LogManager.getLogger((Class<?>) SignatureInfo.class);
    private KeyInfoFactory keyInfoFactory;
    private OPCPackage opcPackage;
    private Provider provider;
    private SignatureConfig signatureConfig;
    private XMLSignatureFactory signatureFactory;
    private URIDereferencer uriDereferencer;

    /* JADX INFO: renamed from: org.apache.poi.poifs.crypt.dsig.SignatureInfo$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm;

        static {
            int[] iArr = new int[HashAlgorithm.values().length];
            $SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm = iArr;
            try {
                iArr[HashAlgorithm.md2.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm[HashAlgorithm.md5.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm[HashAlgorithm.sha1.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm[HashAlgorithm.sha256.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm[HashAlgorithm.sha384.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm[HashAlgorithm.sha512.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public final class SignaturePartIterator implements Iterator<SignaturePart> {
        Iterator<PackageRelationship> sigOrigRels;
        private PackagePart sigPart;
        private Iterator<PackageRelationship> sigRels;

        public /* synthetic */ SignaturePartIterator(SignatureInfo signatureInfo, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (true) {
                Iterator<PackageRelationship> it = this.sigRels;
                if (it != null && it.hasNext()) {
                    return true;
                }
                if (!this.sigOrigRels.hasNext()) {
                    return false;
                }
                this.sigPart = SignatureInfo.this.opcPackage.getPart(this.sigOrigRels.next());
                SignatureInfo.LOG.atDebug().log("Digital Signature Origin part: {}", this.sigPart);
                try {
                    this.sigRels = this.sigPart.getRelationshipsByType(PackageRelationshipTypes.DIGITAL_SIGNATURE).iterator();
                } catch (InvalidFormatException e) {
                    SignatureInfo.LOG.atWarn().withThrowable(e).log("Reference to signature is invalid.");
                }
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private SignaturePartIterator() {
            this.sigOrigRels = SignatureInfo.this.opcPackage.getRelationshipsByType(PackageRelationshipTypes.DIGITAL_SIGNATURE_ORIGIN).iterator();
        }

        @Override // java.util.Iterator
        public SignaturePart next() {
            PackagePart relatedPart = null;
            do {
                try {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    relatedPart = this.sigPart.getRelatedPart(this.sigRels.next());
                    SignatureInfo.LOG.atDebug().log("XML Signature part: {}", relatedPart);
                } catch (InvalidFormatException e) {
                    SignatureInfo.LOG.atWarn().withThrowable(e).log("Reference to signature is invalid.");
                }
            } while (relatedPart == null);
            return new SignaturePart(relatedPart, SignatureInfo.this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class XmlProviderInitSingleton {

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static class SingletonHelper {
            private static final XmlProviderInitSingleton INSTANCE = new XmlProviderInitSingleton(null);

            private SingletonHelper() {
            }
        }

        public /* synthetic */ XmlProviderInitSingleton(AnonymousClass1 anonymousClass1) {
            this();
        }

        public static XmlProviderInitSingleton getInstance() {
            return SingletonHelper.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Provider getProvider(String str) {
            try {
                return (Provider) Class.forName(str).getDeclaredConstructor(null).newInstance(null);
            } catch (Exception unused) {
                SignatureInfo.LOG.atDebug().log("XMLDsig-Provider '{}' can't be found - trying next.", str);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public RuntimeException providerNotFound() {
            return new RuntimeException("JRE doesn't support default xml signature provider - set jsr105Provider system property!");
        }

        public Provider findProvider() {
            return (Provider) Stream.of((Object[]) SignatureConfig.getProviderNames()).map(new Function() { // from class: org.apache.poi.poifs.crypt.dsig.f
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.f7151a.getProvider((String) obj);
                }
            }).filter(new org.apache.commons.compress.archivers.tar.a(3)).findFirst().orElseThrow(new Supplier() { // from class: org.apache.poi.poifs.crypt.dsig.g
                @Override // java.util.function.Supplier
                public final Object get() {
                    return this.f7153a.providerNotFound();
                }
            });
        }

        private XmlProviderInitSingleton() {
            try {
                Init.init();
                RelationshipTransformService.registerDsigProvider();
                CryptoFunctions.registerBouncyCastle();
            } catch (Exception e) {
                throw new RuntimeException("Xml & BouncyCastle-Provider initialization failed", e);
            }
        }
    }

    private static DigestOutputStream getDigestStream(HashAlgorithm hashAlgorithm, PrivateKey privateKey) {
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm[hashAlgorithm.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return new SignatureOutputStream(hashAlgorithm, privateKey);
            default:
                return new DigestOutputStream(hashAlgorithm, privateKey);
        }
    }

    private Element getDsigElement(Document document, String str) {
        NodeList elementsByTagNameNS = document.getElementsByTagNameNS(SignatureFacet.XML_DIGSIG_NS, str);
        if (elementsByTagNameNS.getLength() == 1) {
            return (Element) elementsByTagNameNS.item(0);
        }
        LOG.atWarn().log("Signature element '{}' was {}", str, elementsByTagNameNS.getLength() == 0 ? "not found" : "multiple times");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Iterator lambda$getSignatureParts$0() {
        return new SignaturePartIterator(this, null);
    }

    private /* synthetic */ void lambda$registerEventListener$1(EventTarget eventTarget, EventListener[] eventListenerArr, SignatureMarshalListener signatureMarshalListener, Document document, Event event) {
        if ((event instanceof MutationEvent) && (event.getTarget() instanceof Document)) {
            eventTarget.removeEventListener("DOMSubtreeModified", eventListenerArr[0], false);
            signatureMarshalListener.handleElement(this, document, eventTarget, eventListenerArr[0]);
            eventTarget.addEventListener("DOMSubtreeModified", eventListenerArr[0], false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$writeDocument$2(Map map, String str, String str2) {
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.crypto.MarshalException */
    public void confirmSignature() throws MarshalException {
        initXmlProvider();
        DOMSignContext dOMSignContextCreateXMLSignContext = createXMLSignContext(DocumentHelper.createDocument());
        postSign(dOMSignContextCreateXMLSignContext, signDigest(dOMSignContextCreateXMLSignContext, preSign(dOMSignContextCreateXMLSignContext)));
    }

    public DOMSignContext createXMLSignContext(Document document) {
        initXmlProvider();
        return new DOMSignContext(this.signatureConfig.getKey(), document);
    }

    public KeyInfoFactory getKeyInfoFactory() {
        return this.keyInfoFactory;
    }

    public OPCPackage getOpcPackage() {
        return this.opcPackage;
    }

    public SignatureConfig getSignatureConfig() {
        return this.signatureConfig;
    }

    public XMLSignatureFactory getSignatureFactory() {
        return this.signatureFactory;
    }

    public Iterable<SignaturePart> getSignatureParts() {
        initXmlProvider();
        return new Iterable() { // from class: org.apache.poi.poifs.crypt.dsig.e
            @Override // java.lang.Iterable
            public final Iterator iterator() {
                return this.f7150a.lambda$getSignatureParts$0();
            }
        };
    }

    public URIDereferencer getUriDereferencer() {
        return this.uriDereferencer;
    }

    public void initXmlProvider() {
        if (this.opcPackage == null) {
            this.opcPackage = this.signatureConfig.getOpcPackage();
        }
        if (this.provider == null) {
            Provider provider = this.signatureConfig.getProvider();
            this.provider = provider;
            if (provider == null) {
                this.provider = XmlProviderInitSingleton.getInstance().findProvider();
            }
        }
        if (this.signatureFactory == null) {
            XMLSignatureFactory signatureFactory = this.signatureConfig.getSignatureFactory();
            this.signatureFactory = signatureFactory;
            if (signatureFactory == null) {
                this.signatureFactory = XMLSignatureFactory.getInstance("DOM", this.provider);
            }
        }
        if (this.keyInfoFactory == null) {
            KeyInfoFactory keyInfoFactory = this.signatureConfig.getKeyInfoFactory();
            this.keyInfoFactory = keyInfoFactory;
            if (keyInfoFactory == null) {
                this.keyInfoFactory = KeyInfoFactory.getInstance("DOM", this.provider);
            }
        }
        if (this.uriDereferencer == null) {
            URIDereferencer uriDereferencer = this.signatureConfig.getUriDereferencer();
            this.uriDereferencer = uriDereferencer;
            if (uriDereferencer == null) {
                this.uriDereferencer = new OOXMLURIDereferencer();
            }
        }
        URIDereferencer uRIDereferencer = this.uriDereferencer;
        if (uRIDereferencer instanceof OOXMLURIDereferencer) {
            ((OOXMLURIDereferencer) uRIDereferencer).setSignatureInfo(this);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.crypto.MarshalException */
    public void postSign(DOMSignContext dOMSignContext, String str) throws MarshalException {
        LOG.atDebug().log("postSign");
        Document document = (Document) dOMSignContext.getParent();
        String packageSignatureId = this.signatureConfig.getPackageSignatureId();
        if (!packageSignatureId.equals(document.getDocumentElement().getAttribute(PackageRelationship.ID_ATTRIBUTE_NAME))) {
            throw new RuntimeException("ds:Signature not found for @Id: ".concat(packageSignatureId));
        }
        Element dsigElement = getDsigElement(document, "SignatureValue");
        if (dsigElement == null) {
            throw new RuntimeException("preSign has to be called before postSign");
        }
        dsigElement.setTextContent(str);
        Iterator<SignatureFacet> it = this.signatureConfig.getSignatureFacets().iterator();
        while (it.hasNext()) {
            it.next().postSign(this, document);
        }
        writeDocument(document);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.crypto.dsig.XMLSignatureException */
    public DOMSignedInfo preSign(DOMSignContext dOMSignContext) throws XMLSignatureException {
        Document document = (Document) dOMSignContext.getParent();
        registerEventListener(document);
        URIDereferencer uRIDereferencer = this.uriDereferencer;
        if (uRIDereferencer != null) {
            dOMSignContext.setURIDereferencer(uRIDereferencer);
        }
        this.signatureConfig.getNamespacePrefixes().forEach(new c(dOMSignContext, 0));
        dOMSignContext.setDefaultNamespacePrefix("");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (SignatureFacet signatureFacet : this.signatureConfig.getSignatureFacets()) {
            LOG.atDebug().log("invoking signature facet: {}", signatureFacet.getClass().getSimpleName());
            signatureFacet.preSign(this, document, arrayList, arrayList2);
        }
        try {
            DOMSignedInfo dOMSignedInfoNewSignedInfo = this.signatureFactory.newSignedInfo(this.signatureFactory.newCanonicalizationMethod(this.signatureConfig.getCanonicalizationMethod(), (C14NMethodParameterSpec) null), this.signatureFactory.newSignatureMethod(this.signatureConfig.getSignatureMethodUri(), (SignatureMethodParameterSpec) null), arrayList);
            this.signatureFactory.newXMLSignature(dOMSignedInfoNewSignedInfo, (KeyInfo) null, arrayList2, this.signatureConfig.getPackageSignatureId(), this.signatureConfig.getPackageSignatureId() + "-signature-value").sign(dOMSignContext);
            int size = arrayList2.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj = arrayList2.get(i5);
                i5++;
                XMLObject xMLObject = (XMLObject) obj;
                LOG.atDebug().log("object java type: {}", xMLObject.getClass().getName());
                for (Manifest manifest : xMLObject.getContent()) {
                    LOG.atDebug().log("object content java type: {}", manifest.getClass().getName());
                    if (manifest instanceof Manifest) {
                        for (DOMReference dOMReference : manifest.getReferences()) {
                            if (dOMReference.getDigestValue() == null) {
                                dOMReference.digest(dOMSignContext);
                            }
                        }
                    }
                }
            }
            for (DOMReference dOMReference2 : dOMSignedInfoNewSignedInfo.getReferences()) {
                if (dOMReference2.getDigestValue() == null) {
                    dOMReference2.digest(dOMSignContext);
                }
            }
            return dOMSignedInfoNewSignedInfo;
        } catch (GeneralSecurityException e) {
            throw new XMLSignatureException(e);
        }
    }

    public void registerEventListener(Document document) {
        final SignatureMarshalListener signatureMarshalListener = this.signatureConfig.getSignatureMarshalListener();
        if (signatureMarshalListener == null) {
            return;
        }
        EventListener[] eventListenerArr = {null};
        eventListenerArr[0] = new EventListener() { // from class: org.apache.poi.poifs.crypt.dsig.d
        };
        ((EventTarget) document).addEventListener("DOMSubtreeModified", eventListenerArr[0], false);
    }

    public void setKeyInfoFactory(KeyInfoFactory keyInfoFactory) {
        this.keyInfoFactory = keyInfoFactory;
    }

    public void setOpcPackage(OPCPackage oPCPackage) {
        this.opcPackage = oPCPackage;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public void setSignatureConfig(SignatureConfig signatureConfig) {
        this.signatureConfig = signatureConfig;
    }

    public void setSignatureFactory(XMLSignatureFactory xMLSignatureFactory) {
        this.signatureFactory = xMLSignatureFactory;
    }

    public void setUriDereferencer(URIDereferencer uRIDereferencer) {
        this.uriDereferencer = uRIDereferencer;
    }

    public String signDigest(DOMSignContext dOMSignContext, DOMSignedInfo dOMSignedInfo) {
        initXmlProvider();
        PrivateKey key = this.signatureConfig.getKey();
        HashAlgorithm digestAlgo = this.signatureConfig.getDigestAlgo();
        if ((digestAlgo.hashSize * 4) / 3 > 76 && !XMLUtils.ignoreLineBreaks()) {
            StringBuilder sb = new StringBuilder("The hash size of the chosen hash algorithm (");
            sb.append(digestAlgo);
            sb.append(" = ");
            throw new EncryptedDocumentException(AbstractC0157z.l(" bytes), will motivate XmlSec to add linebreaks to the generated digest, which results in an invalid signature (... at least for Office) - please persuade it otherwise by adding '-Dorg.apache.xml.security.ignoreLineBreaks=true' to the JVM system properties.", digestAlgo.hashSize, sb));
        }
        try {
            DigestOutputStream digestStream = getDigestStream(digestAlgo, key);
            try {
                digestStream.init();
                dOMSignedInfo.getCanonicalizationMethod().transform(new DOMSubTreeData(getDsigElement((Document) dOMSignContext.getParent(), "SignedInfo"), true), dOMSignContext, digestStream);
                String strEncodeToString = Base64.getEncoder().encodeToString(digestStream.sign());
                digestStream.close();
                return strEncodeToString;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (digestStream != null) {
                        try {
                            digestStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        } catch (IOException | GeneralSecurityException | TransformException e) {
            throw new EncryptedDocumentException(e);
        }
    }

    public boolean verifySignature() {
        initXmlProvider();
        Iterator<SignaturePart> it = getSignatureParts().iterator();
        return it.hasNext() && it.next().validate();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.crypto.MarshalException */
    public void writeDocument(Document document) throws MarshalException {
        XmlOptions xmlOptions = new XmlOptions();
        HashMap map = new HashMap();
        this.signatureConfig.getNamespacePrefixes().forEach(new c(map, 2));
        xmlOptions.setSaveSuggestedPrefixes(map);
        xmlOptions.setUseDefaultNamespace();
        LOG.atDebug().log("output signed Office OpenXML document");
        try {
            DSigRelation dSigRelation = DSigRelation.ORIGIN_SIGS;
            PackagePartName packagePartNameCreatePartName = PackagingURIHelper.createPartName(dSigRelation.getFileName(0));
            PackagePart part = this.opcPackage.getPart(packagePartNameCreatePartName);
            if (part == null) {
                part = this.opcPackage.createPart(packagePartNameCreatePartName, dSigRelation.getContentType());
                this.opcPackage.addRelationship(packagePartNameCreatePartName, TargetMode.INTERNAL, dSigRelation.getRelation());
            }
            DSigRelation dSigRelation2 = DSigRelation.SIG;
            int unusedPartIndex = this.opcPackage.getUnusedPartIndex(dSigRelation2.getDefaultFileName());
            if (!this.signatureConfig.isAllowMultipleSignatures()) {
                PackageRelationshipCollection relationshipsByType = part.getRelationshipsByType(dSigRelation2.getRelation());
                for (int i5 = 2; i5 < unusedPartIndex; i5++) {
                    PackagePartName packagePartNameCreatePartName2 = PackagingURIHelper.createPartName(dSigRelation2.getFileName(i5));
                    for (PackageRelationship packageRelationship : relationshipsByType) {
                        if (part.getRelatedPart(packageRelationship).getPartName().equals(packagePartNameCreatePartName2)) {
                            part.removeRelationship(packageRelationship.getId());
                            relationshipsByType.removeRelationship(packageRelationship.getId());
                            break;
                        }
                    }
                    OPCPackage oPCPackage = this.opcPackage;
                    oPCPackage.removePart(oPCPackage.getPart(packagePartNameCreatePartName2));
                }
                unusedPartIndex = 1;
            }
            PackagePartName packagePartNameCreatePartName3 = PackagingURIHelper.createPartName(dSigRelation2.getFileName(unusedPartIndex));
            PackagePart part2 = this.opcPackage.getPart(packagePartNameCreatePartName3);
            if (part2 == null) {
                part2 = this.opcPackage.createPart(packagePartNameCreatePartName3, dSigRelation2.getContentType());
                part.addRelationship(packagePartNameCreatePartName3, TargetMode.INTERNAL, dSigRelation2.getRelation());
            } else {
                part2.clear();
            }
            OutputStream outputStream = part2.getOutputStream();
            try {
                if (u5.b.f8745h0.parse(document, POIXMLTypeLoader.DEFAULT_XML_OPTIONS) != 0) {
                    throw new ClassCastException();
                }
                throw null;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        } catch (Exception e) {
            throw new MarshalException("Unable to write signature document", e);
        }
    }
}
