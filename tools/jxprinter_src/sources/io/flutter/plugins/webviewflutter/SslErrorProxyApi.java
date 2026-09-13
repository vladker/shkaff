package io.flutter.plugins.webviewflutter;

import android.net.http.SslCertificate;
import android.net.http.SslError;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
class SslErrorProxyApi extends PigeonApiSslError {

    /* JADX INFO: renamed from: io.flutter.plugins.webviewflutter.SslErrorProxyApi$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$plugins$webviewflutter$SslErrorType;

        static {
            int[] iArr = new int[SslErrorType.values().length];
            $SwitchMap$io$flutter$plugins$webviewflutter$SslErrorType = iArr;
            try {
                iArr[SslErrorType.DATE_INVALID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$flutter$plugins$webviewflutter$SslErrorType[SslErrorType.EXPIRED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$flutter$plugins$webviewflutter$SslErrorType[SslErrorType.ID_MISMATCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$flutter$plugins$webviewflutter$SslErrorType[SslErrorType.INVALID.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$flutter$plugins$webviewflutter$SslErrorType[SslErrorType.NOT_YET_VALID.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$flutter$plugins$webviewflutter$SslErrorType[SslErrorType.UNTRUSTED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$flutter$plugins$webviewflutter$SslErrorType[SslErrorType.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public SslErrorProxyApi(@NonNull ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiSslError
    @NonNull
    public SslCertificate certificate(@NonNull SslError sslError) {
        return sslError.getCertificate();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiSslError
    @NonNull
    public SslErrorType getPrimaryError(@NonNull SslError sslError) {
        int primaryError = sslError.getPrimaryError();
        if (primaryError == 0) {
            return SslErrorType.NOT_YET_VALID;
        }
        if (primaryError == 1) {
            return SslErrorType.EXPIRED;
        }
        if (primaryError == 2) {
            return SslErrorType.ID_MISMATCH;
        }
        if (primaryError == 3) {
            return SslErrorType.UNTRUSTED;
        }
        if (primaryError != 4) {
            return primaryError != 5 ? SslErrorType.UNKNOWN : SslErrorType.INVALID;
        }
        return SslErrorType.DATE_INVALID;
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiSslError
    public boolean hasError(@NonNull SslError sslError, @NonNull SslErrorType sslErrorType) {
        int i5;
        switch (AnonymousClass1.$SwitchMap$io$flutter$plugins$webviewflutter$SslErrorType[sslErrorType.ordinal()]) {
            case 1:
                i5 = 4;
                break;
            case 2:
                i5 = 1;
                break;
            case 3:
                i5 = 2;
                break;
            case 4:
                i5 = 5;
                break;
            case 5:
                i5 = 0;
                break;
            case 6:
                i5 = 3;
                break;
            case 7:
                throw getPigeonRegistrar().createUnknownEnumException(sslErrorType);
            default:
                i5 = -1;
                break;
        }
        return sslError.hasError(i5);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiSslError
    @NonNull
    public String url(@NonNull SslError sslError) {
        return sslError.getUrl();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiSslError
    @NonNull
    public ProxyApiRegistrar getPigeonRegistrar() {
        return (ProxyApiRegistrar) super.getPigeonRegistrar();
    }
}
