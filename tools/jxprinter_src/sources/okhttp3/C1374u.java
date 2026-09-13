package okhttp3;

import java.io.IOException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* JADX INFO: renamed from: okhttp3.u, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class C1374u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Y f6675a;
    public final C1356i b;
    public final List c;
    public final List d;

    public C1374u(Y y6, C1356i c1356i, List list, List list2) {
        this.f6675a = y6;
        this.b = c1356i;
        this.c = list;
        this.d = list2;
    }

    public static ArrayList a(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Certificate certificate = (Certificate) it.next();
            if (certificate instanceof X509Certificate) {
                arrayList.add(String.valueOf(((X509Certificate) certificate).getSubjectDN()));
            } else {
                arrayList.add(certificate.getType());
            }
        }
        return arrayList;
    }

    public static C1374u get(SSLSession sSLSession) throws IOException {
        Certificate[] peerCertificates;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        if ("SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
            throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
        C1356i c1356iA = C1356i.a(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        if ("NONE".equals(protocol)) {
            throw new IOException("tlsVersion == NONE");
        }
        Y yA = Y.a(protocol);
        try {
            peerCertificates = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused) {
            peerCertificates = null;
        }
        List listImmutableList = peerCertificates != null ? p107s4.d.immutableList(peerCertificates) : Collections.EMPTY_LIST;
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        return new C1374u(yA, c1356iA, listImmutableList, localCertificates != null ? p107s4.d.immutableList(localCertificates) : Collections.EMPTY_LIST);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1374u)) {
            return false;
        }
        C1374u c1374u = (C1374u) obj;
        return this.f6675a.equals(c1374u.f6675a) && this.b.equals(c1374u.b) && this.c.equals(c1374u.c) && this.d.equals(c1374u.d);
    }

    public final int hashCode() {
        return this.d.hashCode() + ((this.c.hashCode() + ((this.b.hashCode() + ((this.f6675a.hashCode() + 527) * 31)) * 31)) * 31);
    }

    public Principal localPrincipal() {
        List list = this.d;
        if (list.isEmpty()) {
            return null;
        }
        return ((X509Certificate) list.get(0)).getSubjectX500Principal();
    }

    public Principal peerPrincipal() {
        List list = this.c;
        if (list.isEmpty()) {
            return null;
        }
        return ((X509Certificate) list.get(0)).getSubjectX500Principal();
    }

    public final String toString() {
        return "Handshake{tlsVersion=" + this.f6675a + " cipherSuite=" + this.b + " peerCertificates=" + a(this.c) + " localCertificates=" + a(this.d) + '}';
    }
}
