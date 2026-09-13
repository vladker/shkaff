package org.apache.xmlbeans.impl.store;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import org.apache.xmlbeans.impl.soap.SOAPBody;
import org.apache.xmlbeans.impl.soap.SOAPFault;

/* JADX INFO: renamed from: org.apache.xmlbeans.impl.store.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1454o implements Cursor.WrapIOEx, DomImpl.WrapSoapEx, Saver.SyncWrapFun {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7436a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ C1454o(Object obj, Object obj2, int i5) {
        this.f7436a = i5;
        this.b = obj;
        this.c = obj2;
    }

    @Override // org.apache.xmlbeans.impl.store.DomImpl.WrapSoapEx
    public Object get() {
        switch (this.f7436a) {
            case 3:
                return DomImpl.lambda$soapFault_addDetail$85((DomImpl.Dom) this.b, (SOAPFault) this.c);
            default:
                return DomImpl.lambda$soapBody_addFault$69((DomImpl.Dom) this.b, (SOAPBody) this.c);
        }
    }

    @Override // org.apache.xmlbeans.impl.store.Saver.SyncWrapFun
    public int process() {
        return ((Saver.TextReader) this.b).lambda$read$0((char[]) this.c);
    }

    @Override // org.apache.xmlbeans.impl.store.Cursor.WrapIOEx, org.apache.xmlbeans.impl.store.Cursor.WrapSAXEx
    public void run() throws IOException {
        switch (this.f7436a) {
            case 0:
                ((Cursor) this.b).lambda$save$10((Writer) this.c);
                break;
            case 1:
                ((Cursor) this.b).lambda$save$8((File) this.c);
                break;
            default:
                ((Cursor) this.b).lambda$save$9((OutputStream) this.c);
                break;
        }
    }
}
