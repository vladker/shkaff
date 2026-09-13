package org.apache.xmlbeans.impl.store;

import java.io.Serializable;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.soap.Name;
import org.apache.xmlbeans.impl.soap.SOAPBody;
import org.apache.xmlbeans.impl.soap.SOAPElement;
import org.xml.sax.ContentHandler;
import org.xml.sax.ext.LexicalHandler;

/* JADX INFO: renamed from: org.apache.xmlbeans.impl.store.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1447h implements Cursor.WrapSAXEx, DomImpl.WrapSoapEx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7423a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Serializable e;

    public /* synthetic */ C1447h(Object obj, Object obj2, Object obj3, Serializable serializable, int i5) {
        this.f7423a = i5;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
        this.e = serializable;
    }

    @Override // org.apache.xmlbeans.impl.store.DomImpl.WrapSoapEx
    public Object get() {
        switch (this.f7423a) {
            case 1:
                return DomImpl.lambda$_soapElement_addAttribute$42((DomImpl.Dom) this.b, (SOAPElement) this.c, (Name) this.d, (String) this.e);
            case 2:
                return DomImpl.lambda$_soapElement_addChildElement$46((DomImpl.Dom) this.b, (SOAPElement) this.c, (String) this.d, (String) this.e);
            default:
                return DomImpl.lambda$soapBody_addFault$73((DomImpl.Dom) this.b, (SOAPBody) this.c, (Name) this.d, (String) this.e);
        }
    }

    @Override // org.apache.xmlbeans.impl.store.Cursor.WrapSAXEx
    public void run() {
        ((Cursor) this.b).lambda$save$15((ContentHandler) this.c, (LexicalHandler) this.d, (XmlOptions) this.e);
    }
}
