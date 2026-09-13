package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTTabStop extends XmlObject {
    public static final DocumentFactory<CTTabStop> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTTabStop> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "cttabstop5ebbtype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    STTabTlc.Enum getLeader();

    Object getPos();

    STTabJc.Enum getVal();

    boolean isSetLeader();

    void setLeader(STTabTlc.Enum r6);

    void setPos(Object obj);

    void setVal(STTabJc.Enum r6);

    void unsetLeader();

    STTabTlc xgetLeader();

    STSignedTwipsMeasure xgetPos();

    STTabJc xgetVal();

    void xsetLeader(STTabTlc sTTabTlc);

    void xsetPos(STSignedTwipsMeasure sTSignedTwipsMeasure);

    void xsetVal(STTabJc sTTabJc);
}
