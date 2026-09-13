package org.apache.xmlbeans.impl.store;

import java.util.function.Function;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.impl.soap.Detail;
import org.apache.xmlbeans.impl.soap.Name;
import org.apache.xmlbeans.impl.soap.SOAPBody;
import org.apache.xmlbeans.impl.soap.SOAPEnvelope;
import org.apache.xmlbeans.impl.soap.SOAPHeader;
import org.apache.xmlbeans.impl.soap.SOAPPart;
import org.w3c.dom.Document;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class A implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7384a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ A(Object obj, Object obj2, int i5) {
        this.f7384a = i5;
        this.b = obj;
        this.c = obj2;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f7384a) {
            case 0:
                return DomImpl.lambda$saajCallback_createSoapElement$105((QName) this.b, (QName) this.c, (DomImpl.Dom) obj);
            case 1:
                return DomImpl.lambda$detail_addDetailEntry$91((Detail) this.b, (Name) this.c, (DomImpl.Dom) obj);
            case 2:
                return DomImpl.lambda$soapBody_addBodyElement$71((SOAPBody) this.b, (Name) this.c, (DomImpl.Dom) obj);
            case 3:
                return DomImpl.lambda$_soapEnvelope_createName$60((SOAPEnvelope) this.b, (String) this.c, (DomImpl.Dom) obj);
            case 4:
                return DomImpl.lambda$soapHeader_addHeaderElement$67((SOAPHeader) this.b, (Name) this.c, (DomImpl.Dom) obj);
            case 5:
                return DomImpl.lambda$soapBody_addDocument$72((SOAPBody) this.b, (Document) this.c, (DomImpl.Dom) obj);
            case 6:
                return DomImpl.lambda$_soapPart_getMimeHeader$99((SOAPPart) this.b, (String) this.c, (DomImpl.Dom) obj);
            default:
                return DomImpl.lambda$_attributes_getNamedItem$22((DomImpl.Dom) this.b, (String) this.c, (DomImpl.Dom) obj);
        }
    }
}
