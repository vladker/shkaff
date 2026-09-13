package com.microsoft.schemas.vml;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface CTFormulas extends XmlObject {
    public static final DocumentFactory<CTFormulas> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTFormulas> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctformulas808btype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTF addNewF();

    CTF getFArray(int i5);

    CTF[] getFArray();

    List<CTF> getFList();

    CTF insertNewF(int i5);

    void removeF(int i5);

    void setFArray(int i5, CTF ctf);

    void setFArray(CTF[] ctfArr);

    int sizeOfFArray();
}
