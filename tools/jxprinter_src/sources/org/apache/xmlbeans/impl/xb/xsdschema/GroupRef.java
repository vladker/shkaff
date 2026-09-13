package org.apache.xmlbeans.impl.xb.xsdschema;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface GroupRef extends RealGroup {
    public static final DocumentFactory<GroupRef> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<GroupRef> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "groupref303ftype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    QName getRef();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    boolean isSetRef();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    void setRef(QName qName);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    void unsetRef();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    XmlQName xgetRef();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    void xsetRef(XmlQName xmlQName);
}
