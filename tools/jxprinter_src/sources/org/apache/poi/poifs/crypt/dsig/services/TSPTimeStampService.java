package org.apache.poi.poifs.crypt.dsig.services;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.security.cert.CertificateFactory;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.security.auth.x500.X500Principal;
import l5.d2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Unbox;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.poifs.crypt.dsig.SignatureConfig;
import org.apache.poi.poifs.crypt.dsig.SignatureInfo;
import org.bouncycastle.asn1.ASN1IA5String;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cmp.PKIFailureInfo;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.CRLDistPoint;
import org.bouncycastle.asn1.x509.DistributionPointName;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509ExtensionUtils;
import org.bouncycastle.cms.DefaultCMSSignatureAlgorithmNameGenerator;
import org.bouncycastle.cms.SignerId;
import org.bouncycastle.cms.bc.BcRSASignerInfoVerifierBuilder;
import org.bouncycastle.operator.DefaultDigestAlgorithmIdentifierFinder;
import org.bouncycastle.operator.DefaultSignatureAlgorithmIdentifierFinder;
import org.bouncycastle.operator.bc.BcDigestCalculatorProvider;
import org.bouncycastle.tsp.TimeStampRequest;
import org.bouncycastle.tsp.TimeStampRequestGenerator;
import org.bouncycastle.tsp.TimeStampResponse;
import org.bouncycastle.tsp.TimeStampToken;
import org.bouncycastle.util.Selector;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class TSPTimeStampService implements TimeStampService {
    private static final Logger LOG = LogManager.getLogger((Class<?>) TSPTimeStampService.class);

    /* JADX INFO: renamed from: org.apache.poi.poifs.crypt.dsig.services.TSPTimeStampService$1, reason: invalid class name */
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
                $SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm[HashAlgorithm.sha256.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm[HashAlgorithm.sha384.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm[HashAlgorithm.sha512.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$retrieveCRL$3(DistributionPointName distributionPointName) {
        return distributionPointName.getType() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Stream lambda$retrieveCRL$4(DistributionPointName distributionPointName) {
        return Stream.of((Object[]) GeneralNames.getInstance(distributionPointName.getName()).getNames());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$retrieveCRL$5(GeneralName generalName) {
        return generalName.getTagNo() == 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$retrieveCRL$6(GeneralName generalName) {
        return ASN1IA5String.getInstance(generalName.getName()).getString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Stream lambda$retrieveCRL$9(List list, final X509Certificate x509Certificate, SignatureConfig signatureConfig, final String str) {
        SignatureConfig.CRLEntry cRLEntryDownloadCRL;
        final int i5 = 0;
        List list2 = (List) list.stream().filter(new Predicate(this) { // from class: org.apache.poi.poifs.crypt.dsig.services.a
            public final /* synthetic */ TSPTimeStampService b;

            {
                this.b = this;
            }

            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                switch (i5) {
                    case 0:
                        return this.b.lambda$null$7(x509Certificate, str, (SignatureConfig.CRLEntry) obj);
                    default:
                        return this.b.lambda$null$8(x509Certificate, str, (SignatureConfig.CRLEntry) obj);
                }
            }
        }).collect(Collectors.toList());
        final int i6 = 1;
        Stream streamFilter = list.stream().filter(new Predicate(this) { // from class: org.apache.poi.poifs.crypt.dsig.services.a
            public final /* synthetic */ TSPTimeStampService b;

            {
                this.b = this;
            }

            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                switch (i6) {
                    case 0:
                        return this.b.lambda$null$7(x509Certificate, str, (SignatureConfig.CRLEntry) obj);
                    default:
                        return this.b.lambda$null$8(x509Certificate, str, (SignatureConfig.CRLEntry) obj);
                }
            }
        });
        if (list2.isEmpty() && (cRLEntryDownloadCRL = downloadCRL(signatureConfig, str)) != null) {
            list2.add(cRLEntryDownloadCRL);
        }
        return Stream.concat(list2.stream(), streamFilter).map(new com.google.android.material.color.utilities.g(22));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$timeStamp$0(X509CertificateHolder x509CertificateHolder) {
        return x509CertificateHolder.getSubject().toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$timeStamp$1(X500Name x500Name, BigInteger bigInteger, X509CertificateHolder x509CertificateHolder) {
        return x500Name.equals(x509CertificateHolder.getIssuer()) && bigInteger.equals(x509CertificateHolder.getSerialNumber());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ RuntimeException lambda$timeStamp$2() {
        return new RuntimeException("TSP response token has no signer certificate");
    }

    public SignatureConfig.CRLEntry downloadCRL(SignatureConfig signatureConfig, String str) {
        if (!signatureConfig.isAllowCRLDownload()) {
            return null;
        }
        TimeStampHttpClient tspHttpClient = signatureConfig.getTspHttpClient();
        tspHttpClient.init(signatureConfig);
        tspHttpClient.setBasicAuthentication(null, null);
        try {
            TimeStampHttpClient.TimeStampHttpClientResponse timeStampHttpClientResponse = tspHttpClient.get(str);
            if (!timeStampHttpClientResponse.isOK()) {
                return null;
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                byte[] responseBytes = timeStampHttpClientResponse.getResponseBytes();
                return signatureConfig.addCRL(str, ((X509CRL) certificateFactory.generateCRL(new ByteArrayInputStream(responseBytes))).getIssuerX500Principal().getName(), responseBytes);
            } catch (GeneralSecurityException e) {
                LOG.atWarn().withThrowable(e).log("CRL download failed from {}", str);
                return null;
            }
        } catch (IOException unused) {
        }
    }

    public ASN1ObjectIdentifier mapDigestAlgoToOID(HashAlgorithm hashAlgorithm) {
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm[hashAlgorithm.ordinal()];
        if (i5 == 1) {
            return X509ObjectIdentifiers.id_SHA1;
        }
        if (i5 == 2) {
            return NISTObjectIdentifiers.id_sha256;
        }
        if (i5 == 3) {
            return NISTObjectIdentifiers.id_sha384;
        }
        if (i5 == 4) {
            return NISTObjectIdentifiers.id_sha512;
        }
        throw new IllegalArgumentException("unsupported digest algo: " + hashAlgorithm);
    }

    /* JADX INFO: renamed from: matchCRLbyCN, reason: merged with bridge method [inline-methods] */
    public boolean lambda$null$8(SignatureConfig.CRLEntry cRLEntry, X509Certificate x509Certificate, String str) {
        return x509Certificate.getSubjectX500Principal().getName().equals(cRLEntry.getCertCN());
    }

    /* JADX INFO: renamed from: matchCRLbyUrl, reason: merged with bridge method [inline-methods] */
    public boolean lambda$null$7(SignatureConfig.CRLEntry cRLEntry, X509Certificate x509Certificate, String str) {
        return str.equals(cRLEntry.getCrlURL());
    }

    public List<byte[]> retrieveCRL(final SignatureConfig signatureConfig, final X509Certificate x509Certificate) {
        final List<SignatureConfig.CRLEntry> crlEntries = signatureConfig.getCrlEntries();
        byte[] extensionValue = x509Certificate.getExtensionValue(Extension.cRLDistributionPoints.getId());
        return extensionValue == null ? Collections.EMPTY_LIST : (List) Stream.of((Object[]) CRLDistPoint.getInstance(JcaX509ExtensionUtils.parseExtensionValue(extensionValue)).getDistributionPoints()).map(new h()).filter(new i()).filter(new j()).flatMap(new b()).filter(new c()).map(new d()).flatMap(new Function() { // from class: org.apache.poi.poifs.crypt.dsig.services.e
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f7157a.lambda$retrieveCRL$9(crlEntries, x509Certificate, signatureConfig, (String) obj);
            }
        }).filter(new org.apache.commons.compress.archivers.tar.a(4)).collect(Collectors.toList());
    }

    @Override // org.apache.poi.poifs.crypt.dsig.services.TimeStampService
    public byte[] timeStamp(SignatureInfo signatureInfo, byte[] bArr, RevocationData revocationData) throws IOException {
        SignatureConfig signatureConfig = signatureInfo.getSignatureConfig();
        byte[] bArrDigest = CryptoFunctions.getMessageDigest(signatureConfig.getTspDigestAlgo()).digest(bArr);
        BigInteger bigInteger = new BigInteger(128, new SecureRandom());
        TimeStampRequestGenerator timeStampRequestGenerator = new TimeStampRequestGenerator();
        timeStampRequestGenerator.setCertReq(true);
        String tspRequestPolicy = signatureConfig.getTspRequestPolicy();
        if (tspRequestPolicy != null) {
            timeStampRequestGenerator.setReqPolicy(new ASN1ObjectIdentifier(tspRequestPolicy));
        }
        TimeStampRequest timeStampRequestGenerate = timeStampRequestGenerator.generate(mapDigestAlgoToOID(signatureConfig.getTspDigestAlgo()), bArrDigest, bigInteger);
        TimeStampHttpClient tspHttpClient = signatureConfig.getTspHttpClient();
        tspHttpClient.init(signatureConfig);
        tspHttpClient.setContentTypeIn(signatureConfig.isTspOldProtocol() ? "application/timestamp-request" : "application/timestamp-query");
        TimeStampHttpClient.TimeStampHttpClientResponse timeStampHttpClientResponsePost = tspHttpClient.post(signatureConfig.getTspUrl(), timeStampRequestGenerate.getEncoded());
        if (!timeStampHttpClientResponsePost.isOK()) {
            throw new IOException("Requesting timestamp data failed");
        }
        byte[] responseBytes = timeStampHttpClientResponsePost.getResponseBytes();
        if (responseBytes.length == 0) {
            throw new RuntimeException("Content-Length is zero");
        }
        TimeStampResponse timeStampResponse = new TimeStampResponse(responseBytes);
        timeStampResponse.validate(timeStampRequestGenerate);
        if (timeStampResponse.getStatus() != 0) {
            Logger logger = LOG;
            logger.atDebug().log("status: {}", Unbox.box(timeStampResponse.getStatus()));
            logger.atDebug().log("status string: {}", timeStampResponse.getStatusString());
            PKIFailureInfo failInfo = timeStampResponse.getFailInfo();
            if (failInfo != null) {
                logger.atDebug().log("fail info int value: {}", Unbox.box(failInfo.intValue()));
                if (256 == failInfo.intValue()) {
                    logger.atDebug().log("unaccepted policy");
                }
            }
            throw new RuntimeException("timestamp response status != 0: " + timeStampResponse.getStatus());
        }
        TimeStampToken timeStampToken = timeStampResponse.getTimeStampToken();
        SignerId sid = timeStampToken.getSID();
        final BigInteger serialNumber = sid.getSerialNumber();
        final X500Name issuer = sid.getIssuer();
        Logger logger2 = LOG;
        logger2.atDebug().log("signer cert serial number: {}", serialNumber);
        logger2.atDebug().log("signer cert issuer: {}", issuer);
        Map map = (Map) timeStampToken.getCertificates().getMatches((Selector) null).stream().collect(Collectors.toMap(new f(), Function.identity()));
        X509CertificateHolder x509CertificateHolder = (X509CertificateHolder) map.values().stream().filter(new Predicate() { // from class: org.apache.poi.poifs.crypt.dsig.services.g
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return TSPTimeStampService.lambda$timeStamp$1(issuer, serialNumber, (X509CertificateHolder) obj);
            }
        }).findFirst().orElseThrow(new org.apache.poi.poifs.crypt.dsig.b(4));
        JcaX509CertificateConverter jcaX509CertificateConverter = new JcaX509CertificateConverter();
        jcaX509CertificateConverter.setProvider("BC");
        X509Certificate certificate = jcaX509CertificateConverter.getCertificate(x509CertificateHolder);
        do {
            revocationData.addCertificate(certificate);
            X500Principal issuerX500Principal = certificate.getIssuerX500Principal();
            if (certificate.getSubjectX500Principal().equals(issuerX500Principal)) {
                break;
            }
            X509CertificateHolder x509CertificateHolder2 = (X509CertificateHolder) map.get(issuerX500Principal.getName());
            certificate = x509CertificateHolder2 != null ? jcaX509CertificateConverter.getCertificate(x509CertificateHolder2) : signatureConfig.getCachedCertificateByPrinicipal(issuerX500Principal.getName());
            if (certificate != null) {
                retrieveCRL(signatureConfig, certificate).forEach(new d2(revocationData, 7));
            }
        } while (certificate != null);
        timeStampToken.validate(new BcRSASignerInfoVerifierBuilder(new DefaultCMSSignatureAlgorithmNameGenerator(), new DefaultSignatureAlgorithmIdentifierFinder(), new DefaultDigestAlgorithmIdentifierFinder(), new BcDigestCalculatorProvider()).build(x509CertificateHolder));
        if (signatureConfig.getTspValidator() != null) {
            signatureConfig.getTspValidator().validate(revocationData.getX509chain(), revocationData);
        }
        LOG.atDebug().log("time-stamp token time: {}", timeStampToken.getTimeStampInfo().getGenTime());
        return timeStampToken.getEncoded();
    }
}
