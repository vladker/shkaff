package org.openxmlformats.schemas.xpackage.x2006.digitalSignature;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface SignatureTimeDocument extends XmlObject {
    public static final DocumentFactory<SignatureTimeDocument> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<SignatureTimeDocument> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "signaturetime9c91doctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTSignatureTime addNewSignatureTime();

    CTSignatureTime getSignatureTime();

    void setSignatureTime(CTSignatureTime cTSignatureTime);
}
