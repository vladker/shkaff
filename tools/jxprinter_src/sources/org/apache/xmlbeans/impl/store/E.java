package org.apache.xmlbeans.impl.store;

import java.util.function.Consumer;
import org.apache.xmlbeans.impl.soap.SOAPElement;
import org.apache.xmlbeans.impl.soap.SOAPPart;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class E implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7388a;
    public final /* synthetic */ Object b;

    public /* synthetic */ E(Object obj, int i5) {
        this.f7388a = i5;
        this.b = obj;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f7388a) {
            case 0:
                DomImpl.lambda$_soapPart_removeAllMimeHeaders$93((SOAPPart) this.b, (DomImpl.Dom) obj);
                break;
            case 1:
                DomImpl.impl_saajCallback_setSaajData((DomImpl.Dom) obj, this.b);
                break;
            default:
                DomImpl.lambda$_soapElement_removeContents$35((SOAPElement) this.b, (DomImpl.Dom) obj);
                break;
        }
    }
}
