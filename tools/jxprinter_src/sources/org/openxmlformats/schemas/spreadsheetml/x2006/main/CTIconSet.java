package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTIconSet extends XmlObject {
    public static final DocumentFactory<CTIconSet> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTIconSet> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "cticonset2648type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTCfvo addNewCfvo();

    CTCfvo getCfvoArray(int i5);

    CTCfvo[] getCfvoArray();

    List<CTCfvo> getCfvoList();

    STIconSetType.Enum getIconSet();

    boolean getPercent();

    boolean getReverse();

    boolean getShowValue();

    CTCfvo insertNewCfvo(int i5);

    boolean isSetIconSet();

    boolean isSetPercent();

    boolean isSetReverse();

    boolean isSetShowValue();

    void removeCfvo(int i5);

    void setCfvoArray(int i5, CTCfvo cTCfvo);

    void setCfvoArray(CTCfvo[] cTCfvoArr);

    void setIconSet(STIconSetType.Enum r6);

    void setPercent(boolean z6);

    void setReverse(boolean z6);

    void setShowValue(boolean z6);

    int sizeOfCfvoArray();

    void unsetIconSet();

    void unsetPercent();

    void unsetReverse();

    void unsetShowValue();

    STIconSetType xgetIconSet();

    XmlBoolean xgetPercent();

    XmlBoolean xgetReverse();

    XmlBoolean xgetShowValue();

    void xsetIconSet(STIconSetType sTIconSetType);

    void xsetPercent(XmlBoolean xmlBoolean);

    void xsetReverse(XmlBoolean xmlBoolean);

    void xsetShowValue(XmlBoolean xmlBoolean);
}
