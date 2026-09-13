package androidx.core.net;

import A3.AbstractC0157z;
import android.net.Uri;
import androidx.webkit.ProxyConfig;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.xmlbeans.impl.common.NameUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class UriCompat {
    private UriCompat() {
    }

    public static String toSafeString(Uri uri) {
        String scheme = uri.getScheme();
        String schemeSpecificPart = uri.getSchemeSpecificPart();
        if (scheme != null) {
            if (scheme.equalsIgnoreCase("tel") || scheme.equalsIgnoreCase("sip") || scheme.equalsIgnoreCase("sms") || scheme.equalsIgnoreCase("smsto") || scheme.equalsIgnoreCase("mailto") || scheme.equalsIgnoreCase("nfc")) {
                StringBuilder sb = new StringBuilder(64);
                sb.append(scheme);
                sb.append(NameUtil.COLON);
                if (schemeSpecificPart != null) {
                    for (int i5 = 0; i5 < schemeSpecificPart.length(); i5++) {
                        char cCharAt = schemeSpecificPart.charAt(i5);
                        if (cCharAt == '-' || cCharAt == '@' || cCharAt == '.') {
                            sb.append(cCharAt);
                        } else {
                            sb.append('x');
                        }
                    }
                }
                return sb.toString();
            }
            if (scheme.equalsIgnoreCase(ProxyConfig.MATCH_HTTP) || scheme.equalsIgnoreCase(ProxyConfig.MATCH_HTTPS) || scheme.equalsIgnoreCase("ftp") || scheme.equalsIgnoreCase("rtsp")) {
                StringBuilder sb2 = new StringBuilder("//");
                sb2.append(uri.getHost() != null ? uri.getHost() : "");
                schemeSpecificPart = AbstractC0157z.s(sb2, uri.getPort() != -1 ? ParameterizedMessage.ERROR_MSG_SEPARATOR + uri.getPort() : "", "/...");
            }
        }
        StringBuilder sb3 = new StringBuilder(64);
        if (scheme != null) {
            sb3.append(scheme);
            sb3.append(NameUtil.COLON);
        }
        if (schemeSpecificPart != null) {
            sb3.append(schemeSpecificPart);
        }
        return sb3.toString();
    }
}
