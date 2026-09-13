package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTNumbering extends XmlObject {
    public static final DocumentFactory<CTNumbering> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTNumbering> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctnumberingfdf9type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTAbstractNum addNewAbstractNum();

    CTNum addNewNum();

    CTDecimalNumber addNewNumIdMacAtCleanup();

    CTNumPicBullet addNewNumPicBullet();

    CTAbstractNum getAbstractNumArray(int i5);

    CTAbstractNum[] getAbstractNumArray();

    List<CTAbstractNum> getAbstractNumList();

    CTNum getNumArray(int i5);

    CTNum[] getNumArray();

    CTDecimalNumber getNumIdMacAtCleanup();

    List<CTNum> getNumList();

    CTNumPicBullet getNumPicBulletArray(int i5);

    CTNumPicBullet[] getNumPicBulletArray();

    List<CTNumPicBullet> getNumPicBulletList();

    CTAbstractNum insertNewAbstractNum(int i5);

    CTNum insertNewNum(int i5);

    CTNumPicBullet insertNewNumPicBullet(int i5);

    boolean isSetNumIdMacAtCleanup();

    void removeAbstractNum(int i5);

    void removeNum(int i5);

    void removeNumPicBullet(int i5);

    void setAbstractNumArray(int i5, CTAbstractNum cTAbstractNum);

    void setAbstractNumArray(CTAbstractNum[] cTAbstractNumArr);

    void setNumArray(int i5, CTNum cTNum);

    void setNumArray(CTNum[] cTNumArr);

    void setNumIdMacAtCleanup(CTDecimalNumber cTDecimalNumber);

    void setNumPicBulletArray(int i5, CTNumPicBullet cTNumPicBullet);

    void setNumPicBulletArray(CTNumPicBullet[] cTNumPicBulletArr);

    int sizeOfAbstractNumArray();

    int sizeOfNumArray();

    int sizeOfNumPicBulletArray();

    void unsetNumIdMacAtCleanup();
}
