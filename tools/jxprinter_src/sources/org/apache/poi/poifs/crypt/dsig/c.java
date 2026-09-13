package org.apache.poi.poifs.crypt.dsig;

import java.util.HashMap;
import java.util.function.BiConsumer;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import org.w3c.dom.Element;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class c implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7148a;
    public final /* synthetic */ Object b;

    public /* synthetic */ c(Object obj, int i5) {
        this.f7148a = i5;
        this.b = obj;
    }

    private final void a(Object obj, Object obj2) {
        ((DOMSignContext) this.b).putNamespacePrefix((String) obj, (String) obj2);
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        switch (this.f7148a) {
            case 0:
                a(obj, obj2);
                break;
            case 1:
                ((SignaturePart.XPathNSContext) this.b).lambda$new$0((String) obj, (String) obj2);
                break;
            case 2:
                SignatureInfo.lambda$writeDocument$2((HashMap) this.b, (String) obj, (String) obj2);
                break;
            default:
                SignatureMarshalDefaultListener.setXmlns((Element) this.b, (String) obj2, (String) obj);
                break;
        }
    }
}
