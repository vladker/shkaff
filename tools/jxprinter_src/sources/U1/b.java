package U1;

import androidx.webkit.ProxyConfig;
import org.apache.logging.log4j.util.ProcessIdUtil;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f707a = null;

    public static void c(b bVar, p067m.k kVar) {
        if (bVar instanceof a) {
            a aVar = (a) bVar;
            c(aVar.b, kVar);
            c(aVar.c, kVar);
            return;
        }
        if (bVar instanceof k) {
            k kVar2 = (k) bVar;
            String str = kVar2.b;
            int i5 = -1;
            if (kVar.f6115a > 0) {
                if (str == null) {
                    for (int i6 = 0; i6 < kVar.f6115a; i6++) {
                        if (((Object[]) kVar.b)[i6] == null) {
                            i5 = i6;
                            break;
                        }
                    }
                } else {
                    for (int i7 = 0; i7 < kVar.f6115a; i7++) {
                        if (str.equals(((Object[]) kVar.b)[i7])) {
                            i5 = i7;
                            break;
                        }
                    }
                }
            }
            if (i5 >= 0) {
                return;
            }
            kVar.d(kVar.f6115a, kVar2.b);
            return;
        }
        if (!(bVar instanceof e)) {
            return;
        }
        e eVar = (e) bVar;
        int i8 = 0;
        while (true) {
            p067m.k kVar3 = eVar.d;
            if (i8 >= kVar3.f6115a) {
                return;
            }
            c((b) kVar3.c(i8), kVar);
            i8++;
        }
    }

    public static void d(b bVar, StringBuffer stringBuffer) {
        String str;
        if (bVar instanceof a) {
            a aVar = (a) bVar;
            stringBuffer.append("(");
            d(aVar.b, stringBuffer);
            switch (aVar.d) {
                case 0:
                    str = "+";
                    break;
                case 1:
                    str = PackagingURIHelper.FORWARD_SLASH_STRING;
                    break;
                case 2:
                    str = ProxyConfig.MATCH_ALL_SCHEMES;
                    break;
                case 3:
                    str = "^";
                    break;
                default:
                    str = ProcessIdUtil.DEFAULT_PROCESSID;
                    break;
            }
            stringBuffer.append(str);
            d(aVar.c, stringBuffer);
            stringBuffer.append(")");
            return;
        }
        if (!(bVar instanceof h)) {
            if (bVar instanceof i) {
                stringBuffer.append(((i) bVar).b);
                return;
            }
            return;
        }
        h hVar = (h) bVar;
        if (hVar.c) {
            stringBuffer.append("(");
            stringBuffer.append(ProcessIdUtil.DEFAULT_PROCESSID);
        }
        stringBuffer.append(hVar.b);
        if (hVar instanceof e) {
            p067m.k kVar = ((e) hVar).d;
            stringBuffer.append("(");
            if (kVar.f6115a > 0) {
                d((b) kVar.c(0), stringBuffer);
            }
            for (int i5 = 1; i5 < kVar.f6115a; i5++) {
                stringBuffer.append(", ");
                d((b) kVar.c(i5), stringBuffer);
            }
            stringBuffer.append(")");
        }
        if (hVar.c) {
            stringBuffer.append(")");
        }
    }

    public final void a(b bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("expression cannot be null");
        }
        if (bVar.f707a != null) {
            throw new IllegalArgumentException("expression must be removed parent");
        }
        for (b bVar2 = this; bVar2 != null; bVar2 = bVar2.f707a) {
            if (bVar2 == bVar) {
                throw new IllegalArgumentException("cyclic reference");
            }
        }
    }

    public abstract double b(j jVar, d dVar);

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        d(this, stringBuffer);
        return stringBuffer.toString();
    }
}
