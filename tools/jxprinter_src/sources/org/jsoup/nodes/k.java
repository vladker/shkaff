package org.jsoup.nodes;

import java.util.List;
import org.apache.commons.compress.compressors.CompressorStreamFactory;
import org.apache.logging.log4j.util.Chars;
import org.jsoup.parser.F;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class k implements Y4.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StringBuilder f7474a;

    public k(StringBuilder sb) {
        this.f7474a = sb;
    }

    @Override // Y4.q
    public final void b(s sVar, int i5) {
        if ((sVar instanceof m) && ((m) sVar).c.c && (sVar.nextSibling() instanceof u)) {
            StringBuilder sb = this.f7474a;
            if (u.C(sb)) {
                return;
            }
            sb.append(Chars.SPACE);
        }
    }

    @Override // Y4.q
    public final void e(s sVar, int i5) {
        boolean z6 = sVar instanceof u;
        StringBuilder sb = this.f7474a;
        if (z6) {
            u uVar = (u) sVar;
            List list = m.e;
            String strZ = uVar.z();
            if (m.preserveWhitespace(uVar.parentNode) || (uVar instanceof d)) {
                sb.append(strZ);
                return;
            } else {
                W4.b.a(sb, strZ, u.C(sb));
                return;
            }
        }
        if (sVar instanceof m) {
            m mVar = (m) sVar;
            if (sb.length() > 0) {
                F f6 = mVar.c;
                if ((f6.c || f6.b.equals(CompressorStreamFactory.BROTLI)) && !u.C(sb)) {
                    sb.append(Chars.SPACE);
                }
            }
        }
    }
}
