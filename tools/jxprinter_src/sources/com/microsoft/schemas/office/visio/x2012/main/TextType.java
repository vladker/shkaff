package com.microsoft.schemas.office.visio.x2012.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface TextType extends XmlObject {
    public static final DocumentFactory<TextType> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<TextType> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "texttyped2ectype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CpType addNewCp();

    FldType addNewFld();

    PpType addNewPp();

    TpType addNewTp();

    CpType getCpArray(int i5);

    CpType[] getCpArray();

    List<CpType> getCpList();

    FldType getFldArray(int i5);

    FldType[] getFldArray();

    List<FldType> getFldList();

    PpType getPpArray(int i5);

    PpType[] getPpArray();

    List<PpType> getPpList();

    TpType getTpArray(int i5);

    TpType[] getTpArray();

    List<TpType> getTpList();

    CpType insertNewCp(int i5);

    FldType insertNewFld(int i5);

    PpType insertNewPp(int i5);

    TpType insertNewTp(int i5);

    void removeCp(int i5);

    void removeFld(int i5);

    void removePp(int i5);

    void removeTp(int i5);

    void setCpArray(int i5, CpType cpType);

    void setCpArray(CpType[] cpTypeArr);

    void setFldArray(int i5, FldType fldType);

    void setFldArray(FldType[] fldTypeArr);

    void setPpArray(int i5, PpType ppType);

    void setPpArray(PpType[] ppTypeArr);

    void setTpArray(int i5, TpType tpType);

    void setTpArray(TpType[] tpTypeArr);

    int sizeOfCpArray();

    int sizeOfFldArray();

    int sizeOfPpArray();

    int sizeOfTpArray();
}
