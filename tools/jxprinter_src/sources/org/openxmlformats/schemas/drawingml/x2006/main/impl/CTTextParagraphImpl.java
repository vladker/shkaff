package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import java.util.List;
import javax.xml.namespace.QName;
import l5.h2;
import l5.i2;
import l5.j2;
import l5.k2;
import org.apache.commons.compress.compressors.CompressorStreamFactory;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextField;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextLineBreak;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTTextParagraphImpl extends XmlComplexContentImpl implements CTTextParagraph {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_DRAWINGML, "pPr"), new QName(XSSFRelation.NS_DRAWINGML, "r"), new QName(XSSFRelation.NS_DRAWINGML, CompressorStreamFactory.BROTLI), new QName(XSSFRelation.NS_DRAWINGML, "fld"), new QName(XSSFRelation.NS_DRAWINGML, "endParaRPr")};
    private static final long serialVersionUID = 1;

    public CTTextParagraphImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public CTTextLineBreak addNewBr() {
        CTTextLineBreak cTTextLineBreak;
        synchronized (monitor()) {
            check_orphaned();
            cTTextLineBreak = (CTTextLineBreak) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTTextLineBreak;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public CTTextCharacterProperties addNewEndParaRPr() {
        CTTextCharacterProperties cTTextCharacterProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTextCharacterProperties = (CTTextCharacterProperties) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTTextCharacterProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public CTTextField addNewFld() {
        CTTextField cTTextField;
        synchronized (monitor()) {
            check_orphaned();
            cTTextField = (CTTextField) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTTextField;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public CTTextParagraphProperties addNewPPr() {
        CTTextParagraphProperties cTTextParagraphProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTextParagraphProperties = (CTTextParagraphProperties) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTTextParagraphProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public CTRegularTextRun addNewR() {
        CTRegularTextRun cTRegularTextRun;
        synchronized (monitor()) {
            check_orphaned();
            cTRegularTextRun = (CTRegularTextRun) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTRegularTextRun;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public CTTextLineBreak[] getBrArray() {
        return (CTTextLineBreak[]) getXmlObjectArray(PROPERTY_QNAME[2], new CTTextLineBreak[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public List<CTTextLineBreak> getBrList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new h2(this, 4), new i2(this, 2), new h2(this, 5), new j2(this, 2), new k2(this, 2));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public CTTextCharacterProperties getEndParaRPr() {
        CTTextCharacterProperties cTTextCharacterProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTextCharacterProperties = (CTTextCharacterProperties) get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (cTTextCharacterProperties == null) {
                cTTextCharacterProperties = null;
            }
        }
        return cTTextCharacterProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public CTTextField[] getFldArray() {
        return (CTTextField[]) getXmlObjectArray(PROPERTY_QNAME[3], new CTTextField[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public List<CTTextField> getFldList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new h2(this, 0), new i2(this, 1), new h2(this, 3), new j2(this, 1), new k2(this, 1));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public CTTextParagraphProperties getPPr() {
        CTTextParagraphProperties cTTextParagraphProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTextParagraphProperties = (CTTextParagraphProperties) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTTextParagraphProperties == null) {
                cTTextParagraphProperties = null;
            }
        }
        return cTTextParagraphProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public CTRegularTextRun[] getRArray() {
        return (CTRegularTextRun[]) getXmlObjectArray(PROPERTY_QNAME[1], new CTRegularTextRun[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public List<CTRegularTextRun> getRList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new h2(this, 1), new i2(this, 0), new h2(this, 2), new j2(this, 0), new k2(this, 0));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public CTTextLineBreak insertNewBr(int i5) {
        CTTextLineBreak cTTextLineBreak;
        synchronized (monitor()) {
            check_orphaned();
            cTTextLineBreak = (CTTextLineBreak) get_store().insert_element_user(PROPERTY_QNAME[2], i5);
        }
        return cTTextLineBreak;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public CTTextField insertNewFld(int i5) {
        CTTextField cTTextField;
        synchronized (monitor()) {
            check_orphaned();
            cTTextField = (CTTextField) get_store().insert_element_user(PROPERTY_QNAME[3], i5);
        }
        return cTTextField;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public CTRegularTextRun insertNewR(int i5) {
        CTRegularTextRun cTRegularTextRun;
        synchronized (monitor()) {
            check_orphaned();
            cTRegularTextRun = (CTRegularTextRun) get_store().insert_element_user(PROPERTY_QNAME[1], i5);
        }
        return cTRegularTextRun;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public boolean isSetEndParaRPr() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public boolean isSetPPr() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public void removeBr(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public void removeFld(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public void removeR(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public void setBrArray(CTTextLineBreak[] cTTextLineBreakArr) {
        check_orphaned();
        arraySetterHelper(cTTextLineBreakArr, PROPERTY_QNAME[2]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public void setEndParaRPr(CTTextCharacterProperties cTTextCharacterProperties) {
        generatedSetterHelperImpl(cTTextCharacterProperties, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public void setFldArray(CTTextField[] cTTextFieldArr) {
        check_orphaned();
        arraySetterHelper(cTTextFieldArr, PROPERTY_QNAME[3]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public void setPPr(CTTextParagraphProperties cTTextParagraphProperties) {
        generatedSetterHelperImpl(cTTextParagraphProperties, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public void setRArray(CTRegularTextRun[] cTRegularTextRunArr) {
        check_orphaned();
        arraySetterHelper(cTRegularTextRunArr, PROPERTY_QNAME[1]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public int sizeOfBrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[2]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public int sizeOfFldArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[3]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public int sizeOfRArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public void unsetEndParaRPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public void unsetPPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public CTTextLineBreak getBrArray(int i5) {
        CTTextLineBreak cTTextLineBreak;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTextLineBreak = (CTTextLineBreak) get_store().find_element_user(PROPERTY_QNAME[2], i5);
                if (cTTextLineBreak == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTextLineBreak;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public CTTextField getFldArray(int i5) {
        CTTextField cTTextField;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTextField = (CTTextField) get_store().find_element_user(PROPERTY_QNAME[3], i5);
                if (cTTextField == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTextField;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public CTRegularTextRun getRArray(int i5) {
        CTRegularTextRun cTRegularTextRun;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTRegularTextRun = (CTRegularTextRun) get_store().find_element_user(PROPERTY_QNAME[1], i5);
                if (cTRegularTextRun == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTRegularTextRun;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public void setBrArray(int i5, CTTextLineBreak cTTextLineBreak) {
        generatedSetterHelperImpl(cTTextLineBreak, PROPERTY_QNAME[2], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public void setFldArray(int i5, CTTextField cTTextField) {
        generatedSetterHelperImpl(cTTextField, PROPERTY_QNAME[3], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public void setRArray(int i5, CTRegularTextRun cTRegularTextRun) {
        generatedSetterHelperImpl(cTRegularTextRun, PROPERTY_QNAME[1], i5, (short) 2);
    }
}
