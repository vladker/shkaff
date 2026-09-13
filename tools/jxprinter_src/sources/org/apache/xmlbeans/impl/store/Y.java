package org.apache.xmlbeans.impl.store;

import java.util.function.Function;
import org.apache.xmlbeans.impl.soap.SOAPFault;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class Y implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7406a;
    public final /* synthetic */ SOAPFault b;

    public /* synthetic */ Y(SOAPFault sOAPFault, int i5) {
        this.f7406a = i5;
        this.b = sOAPFault;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f7406a) {
            case 0:
                return DomImpl.lambda$soapFault_getFaultCode$80(this.b, (DomImpl.Dom) obj);
            case 1:
                return DomImpl.lambda$soapFault_getFaultStringLocale$82(this.b, (DomImpl.Dom) obj);
            case 2:
                return DomImpl.lambda$soapFault_getDetail$86(this.b, (DomImpl.Dom) obj);
            case 3:
                return DomImpl.lambda$soapFault_getFaultCodeAsName$83(this.b, (DomImpl.Dom) obj);
            case 4:
                return DomImpl.lambda$soapFault_getFaultString$84(this.b, (DomImpl.Dom) obj);
            default:
                return DomImpl.lambda$soapFault_getFaultActor$79(this.b, (DomImpl.Dom) obj);
        }
    }
}
