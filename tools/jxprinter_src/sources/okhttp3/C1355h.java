package okhttp3;

import A4.C0173p;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlinx.serialization.json.internal.AbstractC1125a;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: renamed from: okhttp3.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class C1355h {
    public static final C1355h b = new C1355h(new LinkedHashSet(new ArrayList()), null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f6566a;
    private final p142y4.c certificateChainCleaner;

    public C1355h(Set<Object> set, p142y4.c cVar) {
        this.f6566a = set;
        this.certificateChainCleaner = cVar;
    }

    public static String a(X509Certificate x509Certificate) {
        if (x509Certificate == null) {
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }
        return "sha256/" + C0173p.of(x509Certificate.getPublicKey().getEncoded()).sha256().base64();
    }

    public void check(String str, Certificate... certificateArr) throws SSLPeerUnverifiedException {
        check(str, Arrays.asList(certificateArr));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1355h)) {
            return false;
        }
        C1355h c1355h = (C1355h) obj;
        return Objects.equals(this.certificateChainCleaner, c1355h.certificateChainCleaner) && this.f6566a.equals(c1355h.f6566a);
    }

    public final int hashCode() {
        return this.f6566a.hashCode() + (Objects.hashCode(this.certificateChainCleaner) * 31);
    }

    public C1355h withCertificateChainCleaner(p142y4.c cVar) {
        return Objects.equals(this.certificateChainCleaner, cVar) ? this : new C1355h(this.f6566a, cVar);
    }

    public void check(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List list2 = Collections.EMPTY_LIST;
        Iterator it = this.f6566a.iterator();
        if (it.hasNext()) {
            throw AbstractC1125a.g(it);
        }
        if (list2.isEmpty()) {
            return;
        }
        p142y4.c cVar = this.certificateChainCleaner;
        if (cVar != null) {
            list = cVar.clean(list, str);
        }
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (list2.size() > 0) {
                list2.get(0).getClass();
                throw new ClassCastException();
            }
        }
        StringBuilder sb = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
        int size2 = list.size();
        for (int i6 = 0; i6 < size2; i6++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i6);
            sb.append("\n    ");
            sb.append(a(x509Certificate));
            sb.append(": ");
            sb.append(x509Certificate.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        int size3 = list2.size();
        for (int i7 = 0; i7 < size3; i7++) {
            if (list2.get(i7) != null) {
                throw new ClassCastException();
            }
            sb.append("\n    null");
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }
}
