package org.apache.xmlbeans.impl.store;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.soap.Name;
import org.apache.xmlbeans.impl.soap.SOAPElement;
import org.apache.xmlbeans.impl.soap.SOAPFault;
import org.w3c.dom.Node;
import org.xml.sax.ContentHandler;
import org.xml.sax.ext.LexicalHandler;

/* JADX INFO: renamed from: org.apache.xmlbeans.impl.store.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1451l implements Cursor.WrapIOEx, Cursor.WrapSAXEx, DomImpl.WrapSoapEx, Locale.SyncWrapFun {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7431a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public /* synthetic */ C1451l(Object obj, int i5, Object obj2, Object obj3) {
        this.f7431a = i5;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
    }

    private final Object a(Locale locale) {
        return Locale.lambda$parseToXmlObject$2((XMLStreamReader) this.b, (XmlOptions) this.d, (SchemaType) this.c, locale);
    }

    @Override // org.apache.xmlbeans.impl.store.DomImpl.WrapSoapEx
    public Object get() {
        switch (this.f7431a) {
            case 4:
                return DomImpl.lambda$soapFault_setFaultCode$77((DomImpl.Dom) this.b, (SOAPFault) this.c, (Name) this.d);
            case 5:
                return DomImpl.lambda$_soapElement_addChildElement$44((DomImpl.Dom) this.b, (SOAPElement) this.c, (Name) this.d);
            case 6:
                return DomImpl.lambda$_soapElement_addChildElement$45((DomImpl.Dom) this.b, (SOAPElement) this.c, (String) this.d);
            case 7:
                return DomImpl.lambda$soapFault_setFaultCode$81((DomImpl.Dom) this.b, (SOAPFault) this.c, (String) this.d);
            default:
                return DomImpl.lambda$_soapElement_addChildElement$43((DomImpl.Dom) this.b, (SOAPElement) this.c, (SOAPElement) this.d);
        }
    }

    @Override // org.apache.xmlbeans.impl.store.Locale.SyncWrapFun
    public Object parse(Locale locale) {
        switch (this.f7431a) {
            case 9:
                return Locale.lambda$parseToXmlObject$4((XmlOptions) this.d, (Reader) this.b, (SchemaType) this.c, locale);
            case 10:
                return Locale.lambda$parseToXmlObject$5((XmlOptions) this.d, (Node) this.b, (SchemaType) this.c, locale);
            case 11:
                return a(locale);
            case 12:
                return Locale.lambda$parseToXmlObject$3((XmlOptions) this.d, (InputStream) this.b, (SchemaType) this.c, locale);
            default:
                return Locale.lambda$parseToXmlObject$1((String) this.b, (XmlOptions) this.d, (SchemaType) this.c, locale);
        }
    }

    @Override // org.apache.xmlbeans.impl.store.Cursor.WrapIOEx, org.apache.xmlbeans.impl.store.Cursor.WrapSAXEx
    public void run() throws IOException {
        switch (this.f7431a) {
            case 0:
                ((Cursor) this.b).lambda$save$17((OutputStream) this.c, (XmlOptions) this.d);
                break;
            case 1:
                ((Cursor) this.b).lambda$save$7((ContentHandler) this.c, (LexicalHandler) this.d);
                break;
            case 2:
                ((Cursor) this.b).lambda$save$18((Writer) this.c, (XmlOptions) this.d);
                break;
            default:
                ((Cursor) this.b).lambda$save$16((File) this.c, (XmlOptions) this.d);
                break;
        }
    }

    public /* synthetic */ C1451l(Object obj, XmlOptions xmlOptions, SchemaType schemaType, int i5) {
        this.f7431a = i5;
        this.b = obj;
        this.d = xmlOptions;
        this.c = schemaType;
    }

    public /* synthetic */ C1451l(XmlOptions xmlOptions, Object obj, SchemaType schemaType, int i5) {
        this.f7431a = i5;
        this.d = xmlOptions;
        this.b = obj;
        this.c = schemaType;
    }
}
