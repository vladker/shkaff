package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STXstring;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTSortCondition extends XmlObject {
    public static final DocumentFactory<CTSortCondition> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTSortCondition> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctsortconditionc4fctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    String getCustomList();

    boolean getDescending();

    long getDxfId();

    long getIconId();

    STIconSetType.Enum getIconSet();

    String getRef();

    STSortBy$Enum getSortBy();

    boolean isSetCustomList();

    boolean isSetDescending();

    boolean isSetDxfId();

    boolean isSetIconId();

    boolean isSetIconSet();

    boolean isSetSortBy();

    void setCustomList(String str);

    void setDescending(boolean z6);

    void setDxfId(long j6);

    void setIconId(long j6);

    void setIconSet(STIconSetType.Enum r6);

    void setRef(String str);

    void setSortBy(STSortBy$Enum sTSortBy$Enum);

    void unsetCustomList();

    void unsetDescending();

    void unsetDxfId();

    void unsetIconId();

    void unsetIconSet();

    void unsetSortBy();

    STXstring xgetCustomList();

    XmlBoolean xgetDescending();

    STDxfId xgetDxfId();

    XmlUnsignedInt xgetIconId();

    STIconSetType xgetIconSet();

    STRef xgetRef();

    STSortBy xgetSortBy();

    void xsetCustomList(STXstring sTXstring);

    void xsetDescending(XmlBoolean xmlBoolean);

    void xsetDxfId(STDxfId sTDxfId);

    void xsetIconId(XmlUnsignedInt xmlUnsignedInt);

    void xsetIconSet(STIconSetType sTIconSetType);

    void xsetRef(STRef sTRef);

    void xsetSortBy(STSortBy sTSortBy);
}
