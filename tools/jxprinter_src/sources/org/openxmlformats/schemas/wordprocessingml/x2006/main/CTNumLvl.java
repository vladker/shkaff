package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.math.BigInteger;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTNumLvl extends XmlObject {
    public static final DocumentFactory<CTNumLvl> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTNumLvl> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctnumlvl416ctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTLvl addNewLvl();

    CTDecimalNumber addNewStartOverride();

    BigInteger getIlvl();

    CTLvl getLvl();

    CTDecimalNumber getStartOverride();

    boolean isSetLvl();

    boolean isSetStartOverride();

    void setIlvl(BigInteger bigInteger);

    void setLvl(CTLvl cTLvl);

    void setStartOverride(CTDecimalNumber cTDecimalNumber);

    void unsetLvl();

    void unsetStartOverride();

    STDecimalNumber xgetIlvl();

    void xsetIlvl(STDecimalNumber sTDecimalNumber);
}
