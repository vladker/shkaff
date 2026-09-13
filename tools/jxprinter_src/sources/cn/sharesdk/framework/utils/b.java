package cn.sharesdk.framework.utils;

import android.util.Base64;
import androidx.browser.trusted.sharing.ShareTarget;
import com.google.common.net.HttpHeaders;
import com.mob.tools.network.KVPair;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private C0036b f2225a = new C0036b();
    private d b = new d("-._~", false);

    /* JADX INFO: renamed from: cn.sharesdk.framework.utils.b$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2226a;

        static {
            int[] iArr = new int[a.values().length];
            f2226a = iArr;
            try {
                iArr[a.HMAC_SHA1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2226a[a.PLAINTEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum a {
        HMAC_SHA1,
        PLAINTEXT
    }

    /* JADX INFO: renamed from: cn.sharesdk.framework.utils.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class C0036b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f2228a;
        public String b;
        public String c;
        public String d;
        public String e;
    }

    public void a(String str, String str2, String str3) {
        C0036b c0036b = this.f2225a;
        c0036b.f2228a = str;
        c0036b.b = str2;
        c0036b.e = str3;
    }

    public ArrayList<KVPair<String>> b(String str, ArrayList<KVPair<String>> arrayList) {
        return b(str, arrayList, a.HMAC_SHA1);
    }

    public ArrayList<KVPair<String>> c(String str, ArrayList<KVPair<String>> arrayList, a aVar) {
        return a(str, "PUT", arrayList, aVar);
    }

    public ArrayList<KVPair<String>> b(String str, ArrayList<KVPair<String>> arrayList, a aVar) {
        return a(str, ShareTarget.METHOD_GET, arrayList, aVar);
    }

    private String b(ArrayList<KVPair<String>> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            StringBuilder sb = new StringBuilder();
            int size = arrayList.size();
            int i5 = 0;
            int i6 = 0;
            while (i6 < size) {
                KVPair<String> kVPair = arrayList.get(i6);
                i6++;
                KVPair<String> kVPair2 = kVPair;
                if (i5 > 0) {
                    sb.append('&');
                }
                sb.append(kVPair2.name);
                sb.append(Chars.EQ);
                sb.append(kVPair2.value);
                i5++;
            }
            return sb.toString();
        }
        return "";
    }

    public C0036b a() {
        return this.f2225a;
    }

    public ArrayList<KVPair<String>> a(String str, ArrayList<KVPair<String>> arrayList) {
        return a(str, arrayList, a.HMAC_SHA1);
    }

    public ArrayList<KVPair<String>> a(String str, ArrayList<KVPair<String>> arrayList, a aVar) {
        return a(str, ShareTarget.METHOD_POST, arrayList, aVar);
    }

    public void a(String str, String str2) {
        C0036b c0036b = this.f2225a;
        c0036b.c = str;
        c0036b.d = str2;
    }

    private ArrayList<KVPair<String>> a(String str, String str2, ArrayList<KVPair<String>> arrayList, a aVar) throws NoSuchAlgorithmException, InvalidKeyException {
        String strTrim;
        String str3;
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i5 = AnonymousClass1.f2226a[aVar.ordinal()];
        if (i5 == 1) {
            SecretKeySpec secretKeySpec = new SecretKeySpec((a(this.f2225a.b) + '&' + a(this.f2225a.d)).getBytes("utf-8"), "HMAC-SHA1");
            Mac mac = Mac.getInstance("HMAC-SHA1");
            mac.init(secretKeySpec);
            strTrim = new String(Base64.encode(mac.doFinal((str2 + '&' + a(str) + '&' + a(b(a(jCurrentTimeMillis, arrayList, "HMAC-SHA1")))).getBytes("utf-8")), 0)).trim();
            str3 = "HMAC-SHA1";
        } else if (i5 != 2) {
            str3 = null;
            strTrim = null;
        } else {
            strTrim = a(this.f2225a.b) + '&' + a(this.f2225a.d);
            str3 = "PLAINTEXT";
        }
        ArrayList<KVPair<String>> arrayListA = a(jCurrentTimeMillis, str3);
        arrayListA.add(new KVPair<>("oauth_signature", strTrim));
        return arrayListA;
    }

    public String a(String str) {
        if (str == null) {
            return "";
        }
        return this.b.escape(str);
    }

    private ArrayList<KVPair<String>> a(long j6, ArrayList<KVPair<String>> arrayList, String str) {
        HashMap map = new HashMap();
        if (arrayList != null) {
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                KVPair<String> kVPair = arrayList.get(i5);
                i5++;
                KVPair<String> kVPair2 = kVPair;
                map.put(a(kVPair2.name), a(kVPair2.value));
            }
        }
        ArrayList<KVPair<String>> arrayListA = a(j6, str);
        if (arrayListA != null) {
            int size2 = arrayListA.size();
            int i6 = 0;
            while (i6 < size2) {
                KVPair<String> kVPair3 = arrayListA.get(i6);
                i6++;
                KVPair<String> kVPair4 = kVPair3;
                map.put(a(kVPair4.name), a(kVPair4.value));
            }
        }
        int size3 = map.size();
        String[] strArr = new String[size3];
        Iterator it = map.entrySet().iterator();
        int i7 = 0;
        while (it.hasNext()) {
            strArr[i7] = (String) ((Map.Entry) it.next()).getKey();
            i7++;
        }
        Arrays.sort(strArr);
        ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
        for (int i8 = 0; i8 < size3; i8++) {
            String str2 = strArr[i8];
            arrayList2.add(new KVPair<>(str2, map.get(str2)));
        }
        return arrayList2;
    }

    private ArrayList<KVPair<String>> a(long j6, String str) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("oauth_consumer_key", this.f2225a.f2228a));
        arrayList.add(new KVPair<>("oauth_signature_method", str));
        arrayList.add(new KVPair<>("oauth_timestamp", String.valueOf(j6 / 1000)));
        arrayList.add(new KVPair<>("oauth_nonce", String.valueOf(j6)));
        arrayList.add(new KVPair<>("oauth_version", "1.0"));
        String str2 = this.f2225a.c;
        if (str2 != null && str2.length() > 0) {
            arrayList.add(new KVPair<>("oauth_token", str2));
        }
        return arrayList;
    }

    public ArrayList<KVPair<String>> a(ArrayList<KVPair<String>> arrayList) {
        StringBuilder sb = new StringBuilder("OAuth ");
        int size = arrayList.size();
        int i5 = 0;
        int i6 = 0;
        while (i6 < size) {
            KVPair<String> kVPair = arrayList.get(i6);
            i6++;
            KVPair<String> kVPair2 = kVPair;
            if (i5 > 0) {
                sb.append(',');
            }
            String strA = a(kVPair2.value);
            sb.append(kVPair2.name);
            sb.append("=\"");
            sb.append(strA);
            sb.append("\"");
            i5++;
        }
        ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
        arrayList2.add(new KVPair<>(HttpHeaders.AUTHORIZATION, sb.toString()));
        arrayList2.add(new KVPair<>(HttpHeaders.CONTENT_TYPE, ShareTarget.ENCODING_TYPE_URL_ENCODED));
        return arrayList2;
    }
}
