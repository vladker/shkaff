package org.apache.poi.poifs.crypt.dsig.services;

import java.security.cert.CRLException;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class RevocationData {
    private final List<byte[]> crls = new ArrayList();
    private final List<byte[]> ocsps = new ArrayList();
    private final List<X509Certificate> x509chain = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$addCRL$0(byte[] bArr, byte[] bArr2) {
        return Arrays.equals(bArr2, bArr);
    }

    public void addCRL(byte[] bArr) {
        if (this.crls.stream().noneMatch(new E4.a(bArr, 5))) {
            this.crls.add(bArr);
        }
    }

    public void addCertificate(X509Certificate x509Certificate) {
        this.x509chain.add(x509Certificate);
    }

    public void addOCSP(byte[] bArr) {
        this.ocsps.add(bArr);
    }

    public List<byte[]> getCRLs() {
        return this.crls;
    }

    public List<byte[]> getOCSPs() {
        return this.ocsps;
    }

    public List<X509Certificate> getX509chain() {
        return this.x509chain;
    }

    public boolean hasCRLs() {
        return !this.crls.isEmpty();
    }

    public boolean hasOCSPs() {
        return !this.ocsps.isEmpty();
    }

    public boolean hasRevocationDataEntries() {
        return hasOCSPs() || hasCRLs();
    }

    public void addCRL(X509CRL x509crl) {
        try {
            addCRL(x509crl.getEncoded());
        } catch (CRLException e) {
            throw new IllegalArgumentException("CRL coding error: " + e.getMessage(), e);
        }
    }
}
