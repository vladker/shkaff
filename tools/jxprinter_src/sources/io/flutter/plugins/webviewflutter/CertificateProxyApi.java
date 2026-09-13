package io.flutter.plugins.webviewflutter;

import androidx.annotation.NonNull;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
class CertificateProxyApi extends PigeonApiCertificate {
    public CertificateProxyApi(@NonNull ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiCertificate
    @NonNull
    public byte[] getEncoded(@NonNull Certificate certificate) {
        try {
            return certificate.getEncoded();
        } catch (CertificateEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
