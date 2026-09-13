package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTIgnoredError extends XmlObject {
    public static final DocumentFactory<CTIgnoredError> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTIgnoredError> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctignorederrorc51ftype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    boolean getCalculatedColumn();

    boolean getEmptyCellReference();

    boolean getEvalError();

    boolean getFormula();

    boolean getFormulaRange();

    boolean getListDataValidation();

    boolean getNumberStoredAsText();

    List getSqref();

    boolean getTwoDigitTextYear();

    boolean getUnlockedFormula();

    boolean isSetCalculatedColumn();

    boolean isSetEmptyCellReference();

    boolean isSetEvalError();

    boolean isSetFormula();

    boolean isSetFormulaRange();

    boolean isSetListDataValidation();

    boolean isSetNumberStoredAsText();

    boolean isSetTwoDigitTextYear();

    boolean isSetUnlockedFormula();

    void setCalculatedColumn(boolean z6);

    void setEmptyCellReference(boolean z6);

    void setEvalError(boolean z6);

    void setFormula(boolean z6);

    void setFormulaRange(boolean z6);

    void setListDataValidation(boolean z6);

    void setNumberStoredAsText(boolean z6);

    void setSqref(List list);

    void setTwoDigitTextYear(boolean z6);

    void setUnlockedFormula(boolean z6);

    void unsetCalculatedColumn();

    void unsetEmptyCellReference();

    void unsetEvalError();

    void unsetFormula();

    void unsetFormulaRange();

    void unsetListDataValidation();

    void unsetNumberStoredAsText();

    void unsetTwoDigitTextYear();

    void unsetUnlockedFormula();

    XmlBoolean xgetCalculatedColumn();

    XmlBoolean xgetEmptyCellReference();

    XmlBoolean xgetEvalError();

    XmlBoolean xgetFormula();

    XmlBoolean xgetFormulaRange();

    XmlBoolean xgetListDataValidation();

    XmlBoolean xgetNumberStoredAsText();

    STSqref xgetSqref();

    XmlBoolean xgetTwoDigitTextYear();

    XmlBoolean xgetUnlockedFormula();

    void xsetCalculatedColumn(XmlBoolean xmlBoolean);

    void xsetEmptyCellReference(XmlBoolean xmlBoolean);

    void xsetEvalError(XmlBoolean xmlBoolean);

    void xsetFormula(XmlBoolean xmlBoolean);

    void xsetFormulaRange(XmlBoolean xmlBoolean);

    void xsetListDataValidation(XmlBoolean xmlBoolean);

    void xsetNumberStoredAsText(XmlBoolean xmlBoolean);

    void xsetSqref(STSqref sTSqref);

    void xsetTwoDigitTextYear(XmlBoolean xmlBoolean);

    void xsetUnlockedFormula(XmlBoolean xmlBoolean);
}
