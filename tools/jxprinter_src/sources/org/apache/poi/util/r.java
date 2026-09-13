package org.apache.poi.util;

import org.apache.xmlbeans.impl.common.SAXHelper;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class r implements EntityResolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7260a;

    public /* synthetic */ r(int i5) {
        this.f7260a = i5;
    }

    @Override // org.xml.sax.EntityResolver
    public final InputSource resolveEntity(String str, String str2) {
        switch (this.f7260a) {
            case 0:
                return XMLHelper.ignoreEntity(str, str2);
            default:
                return SAXHelper.lambda$static$0(str, str2);
        }
    }
}
