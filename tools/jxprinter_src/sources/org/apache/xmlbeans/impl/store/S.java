package org.apache.xmlbeans.impl.store;

import java.io.Serializable;
import java.util.function.Consumer;
import org.apache.xmlbeans.impl.soap.SOAPFault;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class S implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7400a = 1;
    public final /* synthetic */ String b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Serializable d;

    public /* synthetic */ S(String str, String str2, String str3) {
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f7400a) {
            case 0:
                DomImpl.lambda$soapFault_setFaultString$76((SOAPFault) this.c, this.b, (java.util.Locale) this.d, (DomImpl.Dom) obj);
                break;
            default:
                DomImpl.element_setAttributeNS((DomImpl.Dom) obj, this.b, (String) this.c, (String) this.d);
                break;
        }
    }

    public /* synthetic */ S(SOAPFault sOAPFault, String str, java.util.Locale locale) {
        this.c = sOAPFault;
        this.b = str;
        this.d = locale;
    }
}
