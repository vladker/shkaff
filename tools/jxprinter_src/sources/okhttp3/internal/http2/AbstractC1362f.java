package okhttp3.internal.http2;

import A4.C0173p;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.webkit.ProxyConfig;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.xmlbeans.XmlErrorCodes;

/* JADX INFO: renamed from: okhttp3.internal.http2.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractC1362f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1359c[] f6613a;
    public static final Map b;

    static {
        C1359c c1359c = new C1359c("", C1359c.f6603i);
        C0173p c0173p = C1359c.f6600f;
        C1359c c1359c2 = new C1359c(ShareTarget.METHOD_GET, c0173p);
        C1359c c1359c3 = new C1359c(ShareTarget.METHOD_POST, c0173p);
        C0173p c0173p2 = C1359c.f6601g;
        C1359c c1359c4 = new C1359c(PackagingURIHelper.FORWARD_SLASH_STRING, c0173p2);
        C1359c c1359c5 = new C1359c("/index.html", c0173p2);
        C0173p c0173p3 = C1359c.f6602h;
        C1359c c1359c6 = new C1359c(ProxyConfig.MATCH_HTTP, c0173p3);
        C1359c c1359c7 = new C1359c(ProxyConfig.MATCH_HTTPS, c0173p3);
        C0173p c0173p4 = C1359c.e;
        C1359c[] c1359cArr = {c1359c, c1359c2, c1359c3, c1359c4, c1359c5, c1359c6, c1359c7, new C1359c("200", c0173p4), new C1359c("204", c0173p4), new C1359c("206", c0173p4), new C1359c("304", c0173p4), new C1359c("400", c0173p4), new C1359c("404", c0173p4), new C1359c("500", c0173p4), new C1359c("accept-charset", ""), new C1359c("accept-encoding", "gzip, deflate"), new C1359c("accept-language", ""), new C1359c("accept-ranges", ""), new C1359c("accept", ""), new C1359c("access-control-allow-origin", ""), new C1359c("age", ""), new C1359c("allow", ""), new C1359c("authorization", ""), new C1359c("cache-control", ""), new C1359c("content-disposition", ""), new C1359c("content-encoding", ""), new C1359c("content-language", ""), new C1359c("content-length", ""), new C1359c("content-location", ""), new C1359c("content-range", ""), new C1359c("content-type", ""), new C1359c("cookie", ""), new C1359c(XmlErrorCodes.DATE, ""), new C1359c("etag", ""), new C1359c("expect", ""), new C1359c("expires", ""), new C1359c(TypedValues.TransitionType.S_FROM, ""), new C1359c("host", ""), new C1359c("if-match", ""), new C1359c("if-modified-since", ""), new C1359c("if-none-match", ""), new C1359c("if-range", ""), new C1359c("if-unmodified-since", ""), new C1359c("last-modified", ""), new C1359c("link", ""), new C1359c(FirebaseAnalytics.Param.LOCATION, ""), new C1359c("max-forwards", ""), new C1359c("proxy-authenticate", ""), new C1359c("proxy-authorization", ""), new C1359c("range", ""), new C1359c("referer", ""), new C1359c("refresh", ""), new C1359c("retry-after", ""), new C1359c("server", ""), new C1359c("set-cookie", ""), new C1359c("strict-transport-security", ""), new C1359c("transfer-encoding", ""), new C1359c("user-agent", ""), new C1359c("vary", ""), new C1359c("via", ""), new C1359c("www-authenticate", "")};
        f6613a = c1359cArr;
        LinkedHashMap linkedHashMap = new LinkedHashMap(c1359cArr.length);
        for (int i5 = 0; i5 < c1359cArr.length; i5++) {
            if (!linkedHashMap.containsKey(c1359cArr[i5].f6604a)) {
                linkedHashMap.put(c1359cArr[i5].f6604a, Integer.valueOf(i5));
            }
        }
        b = Collections.unmodifiableMap(linkedHashMap);
    }

    public static C0173p checkLowercase(C0173p c0173p) throws IOException {
        int size = c0173p.size();
        for (int i5 = 0; i5 < size; i5++) {
            byte b6 = c0173p.getByte(i5);
            if (b6 >= 65 && b6 <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + c0173p.utf8());
            }
        }
        return c0173p;
    }
}
