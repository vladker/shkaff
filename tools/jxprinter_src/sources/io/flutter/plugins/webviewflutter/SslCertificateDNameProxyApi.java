package io.flutter.plugins.webviewflutter;

import android.net.http.SslCertificate;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
class SslCertificateDNameProxyApi extends PigeonApiSslCertificateDName {
    public SslCertificateDNameProxyApi(@NonNull ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiSslCertificateDName
    @NonNull
    public String getCName(@NonNull SslCertificate.DName dName) {
        return dName.getCName();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiSslCertificateDName
    @NonNull
    public String getDName(@NonNull SslCertificate.DName dName) {
        return dName.getDName();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiSslCertificateDName
    @NonNull
    public String getOName(@NonNull SslCertificate.DName dName) {
        return dName.getOName();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiSslCertificateDName
    @NonNull
    public String getUName(@NonNull SslCertificate.DName dName) {
        return dName.getUName();
    }
}
