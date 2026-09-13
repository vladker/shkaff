package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.math.BigInteger;
import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTNum extends XmlObject {
    public static final DocumentFactory<CTNum> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTNum> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctnume94ctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTDecimalNumber addNewAbstractNumId();

    CTNumLvl addNewLvlOverride();

    CTDecimalNumber getAbstractNumId();

    CTNumLvl getLvlOverrideArray(int i5);

    CTNumLvl[] getLvlOverrideArray();

    List<CTNumLvl> getLvlOverrideList();

    BigInteger getNumId();

    CTNumLvl insertNewLvlOverride(int i5);

    void removeLvlOverride(int i5);

    void setAbstractNumId(CTDecimalNumber cTDecimalNumber);

    void setLvlOverrideArray(int i5, CTNumLvl cTNumLvl);

    void setLvlOverrideArray(CTNumLvl[] cTNumLvlArr);

    void setNumId(BigInteger bigInteger);

    int sizeOfLvlOverrideArray();

    STDecimalNumber xgetNumId();

    void xsetNumId(STDecimalNumber sTDecimalNumber);
}
