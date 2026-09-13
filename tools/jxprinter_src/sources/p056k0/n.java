package p056k0;

import android.content.Context;
import androidx.webkit.ProxyConfig;
import com.orhanobut.hawk.Hawk;
import io.reactivex.internal.operators.observable.C0953x2;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import p122v2.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class n {
    public static volatile boolean b = false;
    public static volatile int c = 0;
    public static volatile String d = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f5469a = new Object();
    public static final AtomicReference e = new AtomicReference(m.f5468a);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final CopyOnWriteArraySet f5470f = new CopyOnWriteArraySet();

    public static void a(Context context, boolean z6) {
        String strG;
        int iIndexOf;
        Context applicationContext = context.getApplicationContext();
        if (!z6 && c(applicationContext)) {
            c = 100;
            d = "";
            e.set(m.c);
            d();
            return;
        }
        String str = (String) Hawk.get("base_server_url", "");
        if (str == null || str.trim().length() <= 0) {
            try {
                Object obj = a.class.getField("SERVER_URL").get(null);
                str = obj instanceof String ? (String) obj : "";
            } catch (Exception e6) {
                p051j0.a.d("ModelFileDownloadUtil", "Unable to read host app BuildConfig.SERVER_URL: " + e6.getMessage());
            }
        }
        String str2 = (String) Hawk.get("appType", "");
        if (str2 == null || str2.trim().length() <= 0) {
            str2 = "sanduOverseas";
        }
        if (str2.trim().length() == 0 ? false : str2.trim().toLowerCase(Locale.US).contains("overseas")) {
            strG = str.trim();
            if (strG.length() != 0) {
                try {
                    URI uri = new URI(strG);
                    if (uri.getScheme() == null || uri.getRawAuthority() == null) {
                        int iIndexOf2 = strG.indexOf("://");
                        if (iIndexOf2 >= 0 && (iIndexOf = strG.indexOf(47, iIndexOf2 + 3)) > 0) {
                            strG = strG.substring(0, iIndexOf);
                        }
                    } else {
                        strG = uri.getScheme() + "://" + uri.getRawAuthority();
                    }
                } catch (URISyntaxException unused) {
                    p051j0.a.d("ModelFileDownloadUtil", "Invalid SERVER_URL: ".concat(strG));
                }
            }
        } else {
            strG = "https://www.eleph-label.com";
        }
        if (strG.endsWith(PackagingURIHelper.FORWARD_SLASH_STRING)) {
            strG = androidx.collection.a.g(1, 0, strG);
        }
        StringBuilder sbR = androidx.collection.a.r(strG);
        sbR.append(str2.trim().length() == 0 ? false : str2.trim().toLowerCase(Locale.US).contains("overseas") ? "/static/jx_url/doclayout_yolo_docstructbench_imgsz1024.onnx" : "/jx_url/doclayout_yolo_docstructbench_imgsz1024.onnx");
        String string = sbR.toString();
        if (string != null && string.trim().length() != 0) {
            try {
                URI uri2 = new URI(string.trim());
                String scheme = uri2.getScheme();
                if ((ProxyConfig.MATCH_HTTP.equalsIgnoreCase(scheme) || ProxyConfig.MATCH_HTTPS.equalsIgnoreCase(scheme)) && uri2.getRawAuthority() != null && uri2.getRawAuthority().trim().length() > 0) {
                    synchronized (f5469a) {
                        m mVar = m.b;
                        AtomicReference atomicReference = e;
                        if (mVar.equals(atomicReference.get())) {
                            d();
                            return;
                        }
                        c = 0;
                        d = "";
                        atomicReference.set(mVar);
                        d();
                        C0953x2 c0953x2 = new C0953x2(4);
                        File file = new File(applicationContext.getFilesDir(), "doclayout_yolo_docstructbench_imgsz1024.onnx");
                        File file2 = new File(applicationContext.getFilesDir(), "doclayout_yolo_docstructbench_imgsz1024.onnx.tmp");
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (z6 && file.exists() && !file.delete()) {
                            C0953x2.b("Failed to delete invalid model file");
                            return;
                        } else {
                            p051j0.a.c("ModelFileDownloadUtil", "Start downloading model: ".concat(string));
                            new Thread(new androidx.webkit.a(string, c0953x2, file2, file)).start();
                            return;
                        }
                    }
                }
            } catch (URISyntaxException unused2) {
            }
        }
        e("Invalid model URL");
    }

    public static boolean b(File file) {
        return file.exists() && file.isFile() && file.length() > 0;
    }

    public static boolean c(Context context) {
        return b(new File(context.getFilesDir(), "doclayout_yolo_docstructbench_imgsz1024.onnx"));
    }

    public static void d() {
        m mVar = (m) e.get();
        Iterator it = f5470f.iterator();
        while (it.hasNext()) {
            ((l) it.next()).onState(mVar, c, d);
        }
    }

    public static void e(String str) {
        if (str == null) {
            str = "";
        }
        d = str;
        e.set(m.d);
        d();
    }
}
