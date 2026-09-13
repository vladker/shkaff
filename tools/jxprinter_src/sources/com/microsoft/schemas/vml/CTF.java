package com.microsoft.schemas.vml;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface CTF extends XmlObject {
    public static final DocumentFactory<CTF> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTF> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctfbc3atype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    String getEqn();

    boolean isSetEqn();

    void setEqn(String str);

    void unsetEqn();

    XmlString xgetEqn();

    void xsetEqn(XmlString xmlString);
}
