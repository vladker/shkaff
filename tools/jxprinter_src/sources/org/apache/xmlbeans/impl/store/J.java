package org.apache.xmlbeans.impl.store;

import java.util.function.Consumer;
import org.apache.xmlbeans.impl.soap.SOAPFault;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class J implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7393a;
    public final /* synthetic */ SOAPFault b;
    public final /* synthetic */ String c;

    public /* synthetic */ J(SOAPFault sOAPFault, String str, int i5) {
        this.f7393a = i5;
        this.b = sOAPFault;
        this.c = str;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f7393a) {
            case 0:
                DomImpl.lambda$soapFault_setFaultString$75(this.b, this.c, (DomImpl.Dom) obj);
                break;
            default:
                DomImpl.lambda$soapFault_setFaultActor$78(this.b, this.c, (DomImpl.Dom) obj);
                break;
        }
    }
}
