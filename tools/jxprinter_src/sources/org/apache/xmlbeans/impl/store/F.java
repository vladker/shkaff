package org.apache.xmlbeans.impl.store;

import java.util.function.Consumer;
import javax.xml.transform.Source;
import org.apache.xmlbeans.impl.soap.Node;
import org.apache.xmlbeans.impl.soap.SOAPElement;
import org.apache.xmlbeans.impl.soap.SOAPHeaderElement;
import org.apache.xmlbeans.impl.soap.SOAPPart;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class F implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7389a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ F(String str, String str2) {
        this.f7389a = 3;
        this.c = str;
        this.b = str2;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f7389a) {
            case 0:
                DomImpl.lambda$_soapNode_setValue$32((Node) this.b, (String) this.c, (DomImpl.Dom) obj);
                break;
            case 1:
                DomImpl.lambda$_soapNode_setParentElement$34((Node) this.b, (SOAPElement) this.c, (DomImpl.Dom) obj);
                break;
            case 2:
                DomImpl.lambda$_soapPart_removeMimeHeader$94((SOAPPart) this.b, (String) this.c, (DomImpl.Dom) obj);
                break;
            case 3:
                DomImpl.element_setAttribute((DomImpl.Dom) obj, (String) this.c, (String) this.b);
                break;
            case 4:
                DomImpl.lambda$_soapElement_setEncodingStyle$37((SOAPElement) this.b, (String) this.c, (DomImpl.Dom) obj);
                break;
            case 5:
                DomImpl.lambda$soapHeaderElement_setActor$89((SOAPHeaderElement) this.b, (String) this.c, (DomImpl.Dom) obj);
                break;
            default:
                DomImpl.lambda$_soapPart_setContent$98((SOAPPart) this.b, (Source) this.c, (DomImpl.Dom) obj);
                break;
        }
    }

    public /* synthetic */ F(org.w3c.dom.Node node, Object obj, int i5) {
        this.f7389a = i5;
        this.b = node;
        this.c = obj;
    }
}
