package org.apache.xmlbeans.impl.store;

import java.util.function.Consumer;
import org.apache.xmlbeans.impl.soap.SOAPPart;

/* JADX INFO: renamed from: org.apache.xmlbeans.impl.store.y, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1463y implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7446a;
    public final /* synthetic */ SOAPPart b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public /* synthetic */ C1463y(SOAPPart sOAPPart, String str, String str2, int i5) {
        this.f7446a = i5;
        this.b = sOAPPart;
        this.c = str;
        this.d = str2;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f7446a) {
            case 0:
                DomImpl.lambda$_soapPart_setMimeHeader$101(this.b, this.c, this.d, (DomImpl.Dom) obj);
                break;
            default:
                DomImpl.lambda$_soapPart_addMimeHeader$100(this.b, this.c, this.d, (DomImpl.Dom) obj);
                break;
        }
    }
}
