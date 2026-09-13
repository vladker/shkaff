package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.Calendar;
import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTSharedItems extends XmlObject {
    public static final DocumentFactory<CTSharedItems> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTSharedItems> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctshareditems677atype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTBoolean addNewB();

    CTDateTime addNewD();

    CTError addNewE();

    CTMissing addNewM();

    CTNumber addNewN();

    CTString addNewS();

    CTBoolean getBArray(int i5);

    CTBoolean[] getBArray();

    List<CTBoolean> getBList();

    boolean getContainsBlank();

    boolean getContainsDate();

    boolean getContainsInteger();

    boolean getContainsMixedTypes();

    boolean getContainsNonDate();

    boolean getContainsNumber();

    boolean getContainsSemiMixedTypes();

    boolean getContainsString();

    long getCount();

    CTDateTime getDArray(int i5);

    CTDateTime[] getDArray();

    List<CTDateTime> getDList();

    CTError getEArray(int i5);

    CTError[] getEArray();

    List<CTError> getEList();

    boolean getLongText();

    CTMissing getMArray(int i5);

    CTMissing[] getMArray();

    List<CTMissing> getMList();

    Calendar getMaxDate();

    double getMaxValue();

    Calendar getMinDate();

    double getMinValue();

    CTNumber getNArray(int i5);

    CTNumber[] getNArray();

    List<CTNumber> getNList();

    CTString getSArray(int i5);

    CTString[] getSArray();

    List<CTString> getSList();

    CTBoolean insertNewB(int i5);

    CTDateTime insertNewD(int i5);

    CTError insertNewE(int i5);

    CTMissing insertNewM(int i5);

    CTNumber insertNewN(int i5);

    CTString insertNewS(int i5);

    boolean isSetContainsBlank();

    boolean isSetContainsDate();

    boolean isSetContainsInteger();

    boolean isSetContainsMixedTypes();

    boolean isSetContainsNonDate();

    boolean isSetContainsNumber();

    boolean isSetContainsSemiMixedTypes();

    boolean isSetContainsString();

    boolean isSetCount();

    boolean isSetLongText();

    boolean isSetMaxDate();

    boolean isSetMaxValue();

    boolean isSetMinDate();

    boolean isSetMinValue();

    void removeB(int i5);

    void removeD(int i5);

    void removeE(int i5);

    void removeM(int i5);

    void removeN(int i5);

    void removeS(int i5);

    void setBArray(int i5, CTBoolean cTBoolean);

    void setBArray(CTBoolean[] cTBooleanArr);

    void setContainsBlank(boolean z6);

    void setContainsDate(boolean z6);

    void setContainsInteger(boolean z6);

    void setContainsMixedTypes(boolean z6);

    void setContainsNonDate(boolean z6);

    void setContainsNumber(boolean z6);

    void setContainsSemiMixedTypes(boolean z6);

    void setContainsString(boolean z6);

    void setCount(long j6);

    void setDArray(int i5, CTDateTime cTDateTime);

    void setDArray(CTDateTime[] cTDateTimeArr);

    void setEArray(int i5, CTError cTError);

    void setEArray(CTError[] cTErrorArr);

    void setLongText(boolean z6);

    void setMArray(int i5, CTMissing cTMissing);

    void setMArray(CTMissing[] cTMissingArr);

    void setMaxDate(Calendar calendar);

    void setMaxValue(double d);

    void setMinDate(Calendar calendar);

    void setMinValue(double d);

    void setNArray(int i5, CTNumber cTNumber);

    void setNArray(CTNumber[] cTNumberArr);

    void setSArray(int i5, CTString cTString);

    void setSArray(CTString[] cTStringArr);

    int sizeOfBArray();

    int sizeOfDArray();

    int sizeOfEArray();

    int sizeOfMArray();

    int sizeOfNArray();

    int sizeOfSArray();

    void unsetContainsBlank();

    void unsetContainsDate();

    void unsetContainsInteger();

    void unsetContainsMixedTypes();

    void unsetContainsNonDate();

    void unsetContainsNumber();

    void unsetContainsSemiMixedTypes();

    void unsetContainsString();

    void unsetCount();

    void unsetLongText();

    void unsetMaxDate();

    void unsetMaxValue();

    void unsetMinDate();

    void unsetMinValue();

    XmlBoolean xgetContainsBlank();

    XmlBoolean xgetContainsDate();

    XmlBoolean xgetContainsInteger();

    XmlBoolean xgetContainsMixedTypes();

    XmlBoolean xgetContainsNonDate();

    XmlBoolean xgetContainsNumber();

    XmlBoolean xgetContainsSemiMixedTypes();

    XmlBoolean xgetContainsString();

    XmlUnsignedInt xgetCount();

    XmlBoolean xgetLongText();

    XmlDateTime xgetMaxDate();

    XmlDouble xgetMaxValue();

    XmlDateTime xgetMinDate();

    XmlDouble xgetMinValue();

    void xsetContainsBlank(XmlBoolean xmlBoolean);

    void xsetContainsDate(XmlBoolean xmlBoolean);

    void xsetContainsInteger(XmlBoolean xmlBoolean);

    void xsetContainsMixedTypes(XmlBoolean xmlBoolean);

    void xsetContainsNonDate(XmlBoolean xmlBoolean);

    void xsetContainsNumber(XmlBoolean xmlBoolean);

    void xsetContainsSemiMixedTypes(XmlBoolean xmlBoolean);

    void xsetContainsString(XmlBoolean xmlBoolean);

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);

    void xsetLongText(XmlBoolean xmlBoolean);

    void xsetMaxDate(XmlDateTime xmlDateTime);

    void xsetMaxValue(XmlDouble xmlDouble);

    void xsetMinDate(XmlDateTime xmlDateTime);

    void xsetMinValue(XmlDouble xmlDouble);
}
