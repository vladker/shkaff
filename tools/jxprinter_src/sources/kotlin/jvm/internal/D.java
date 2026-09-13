package kotlin.jvm.internal;

import android.net.ConnectivityManager;
import android.net.Uri;
import com.google.firebase.analytics.FirebaseAnalytics;
import p018c4.EnumC0368b;
import p023d4.InterfaceC0612o;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ConnectivityManager f5685a;

    public static /* synthetic */ InterfaceC0612o a(kotlinx.coroutines.flow.internal.B b, E3.q qVar, int i5, EnumC0368b enumC0368b, int i6) {
        if ((i6 & 1) != 0) {
            qVar = E3.r.INSTANCE;
        }
        if ((i6 & 2) != 0) {
            i5 = -3;
        }
        if ((i6 & 4) != 0) {
            enumC0368b = EnumC0368b.f1135a;
        }
        return b.fuse(qVar, i5, enumC0368b);
    }

    public static boolean b(Uri uri) {
        return uri != null && FirebaseAnalytics.Param.CONTENT.equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    public static void c(Y4.q qVar, org.jsoup.nodes.s sVar) {
        V4.h.notNull(qVar);
        V4.h.notNull(sVar);
        org.jsoup.nodes.s sVarNextSibling = sVar;
        int i5 = 0;
        while (sVarNextSibling != null) {
            org.jsoup.nodes.s sVarParentNode = sVarNextSibling.parentNode();
            qVar.e(sVarNextSibling, i5);
            if (sVarParentNode != null && !sVarNextSibling.q()) {
                sVarNextSibling = (org.jsoup.nodes.s) sVarParentNode.n().get(sVarNextSibling.f7484a);
            }
            if (sVarNextSibling.j() > 0) {
                sVarNextSibling = (org.jsoup.nodes.s) sVarNextSibling.n().get(0);
                i5++;
            } else {
                while (sVarNextSibling.nextSibling() == null && i5 > 0) {
                    qVar.b(sVarNextSibling, i5);
                    sVarNextSibling = sVarNextSibling.parentNode();
                    i5--;
                }
                qVar.b(sVarNextSibling, i5);
                if (sVarNextSibling == sVar) {
                    return;
                } else {
                    sVarNextSibling = sVarNextSibling.nextSibling();
                }
            }
        }
    }
}
