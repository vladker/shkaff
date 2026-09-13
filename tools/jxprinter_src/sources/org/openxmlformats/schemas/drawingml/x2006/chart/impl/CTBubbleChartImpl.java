package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import java.util.List;
import javax.xml.namespace.QName;
import k5.A;
import k5.B;
import k5.C;
import k5.C1086z;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleScale;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSizeRepresents;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTBubbleChartImpl extends XmlComplexContentImpl implements CTBubbleChart {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_CHART, "varyColors"), new QName(XSSFRelation.NS_CHART, "ser"), new QName(XSSFRelation.NS_CHART, "dLbls"), new QName(XSSFRelation.NS_CHART, "bubble3D"), new QName(XSSFRelation.NS_CHART, "bubbleScale"), new QName(XSSFRelation.NS_CHART, "showNegBubbles"), new QName(XSSFRelation.NS_CHART, "sizeRepresents"), new QName(XSSFRelation.NS_CHART, "axId"), new QName(XSSFRelation.NS_CHART, "extLst")};
    private static final long serialVersionUID = 1;

    public CTBubbleChartImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public CTUnsignedInt addNewAxId() {
        CTUnsignedInt cTUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedInt = (CTUnsignedInt) get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public CTBoolean addNewBubble3D() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public CTBubbleScale addNewBubbleScale() {
        CTBubbleScale cTBubbleScaleAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBubbleScaleAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTBubbleScaleAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public CTDLbls addNewDLbls() {
        CTDLbls cTDLbls;
        synchronized (monitor()) {
            check_orphaned();
            cTDLbls = (CTDLbls) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTDLbls;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public CTBubbleSer addNewSer() {
        CTBubbleSer cTBubbleSer;
        synchronized (monitor()) {
            check_orphaned();
            cTBubbleSer = (CTBubbleSer) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTBubbleSer;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public CTBoolean addNewShowNegBubbles() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public CTSizeRepresents addNewSizeRepresents() {
        CTSizeRepresents cTSizeRepresentsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSizeRepresentsAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTSizeRepresentsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public CTBoolean addNewVaryColors() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public CTUnsignedInt[] getAxIdArray() {
        return (CTUnsignedInt[]) getXmlObjectArray(PROPERTY_QNAME[7], new CTUnsignedInt[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public List<CTUnsignedInt> getAxIdList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1086z(this, 0), new A(this, 0), new C1086z(this, 1), new B(this, 0), new C(this, 0));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public CTBoolean getBubble3D() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTBoolean == null) {
                cTBoolean = null;
            }
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public CTBubbleScale getBubbleScale() {
        CTBubbleScale cTBubbleScaleFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBubbleScaleFind_element_user = get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (cTBubbleScaleFind_element_user == null) {
                cTBubbleScaleFind_element_user = null;
            }
        }
        return cTBubbleScaleFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public CTDLbls getDLbls() {
        CTDLbls cTDLbls;
        synchronized (monitor()) {
            check_orphaned();
            cTDLbls = (CTDLbls) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTDLbls == null) {
                cTDLbls = null;
            }
        }
        return cTDLbls;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public CTExtensionList getExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().find_element_user(PROPERTY_QNAME[8], 0);
            if (cTExtensionList == null) {
                cTExtensionList = null;
            }
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public CTBubbleSer[] getSerArray() {
        return (CTBubbleSer[]) getXmlObjectArray(PROPERTY_QNAME[1], new CTBubbleSer[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public List<CTBubbleSer> getSerList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1086z(this, 2), new A(this, 1), new C1086z(this, 3), new B(this, 1), new C(this, 1));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public CTBoolean getShowNegBubbles() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().find_element_user(PROPERTY_QNAME[5], 0);
            if (cTBoolean == null) {
                cTBoolean = null;
            }
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public CTSizeRepresents getSizeRepresents() {
        CTSizeRepresents cTSizeRepresentsFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSizeRepresentsFind_element_user = get_store().find_element_user(PROPERTY_QNAME[6], 0);
            if (cTSizeRepresentsFind_element_user == null) {
                cTSizeRepresentsFind_element_user = null;
            }
        }
        return cTSizeRepresentsFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public CTBoolean getVaryColors() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTBoolean == null) {
                cTBoolean = null;
            }
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public CTUnsignedInt insertNewAxId(int i5) {
        CTUnsignedInt cTUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedInt = (CTUnsignedInt) get_store().insert_element_user(PROPERTY_QNAME[7], i5);
        }
        return cTUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public CTBubbleSer insertNewSer(int i5) {
        CTBubbleSer cTBubbleSer;
        synchronized (monitor()) {
            check_orphaned();
            cTBubbleSer = (CTBubbleSer) get_store().insert_element_user(PROPERTY_QNAME[1], i5);
        }
        return cTBubbleSer;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public boolean isSetBubble3D() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public boolean isSetBubbleScale() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public boolean isSetDLbls() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public boolean isSetExtLst() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[8]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public boolean isSetShowNegBubbles() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[5]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public boolean isSetSizeRepresents() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[6]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public boolean isSetVaryColors() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public void removeAxId(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public void removeSer(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public void setAxIdArray(CTUnsignedInt[] cTUnsignedIntArr) {
        check_orphaned();
        arraySetterHelper(cTUnsignedIntArr, PROPERTY_QNAME[7]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public void setBubble3D(CTBoolean cTBoolean) {
        generatedSetterHelperImpl(cTBoolean, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public void setBubbleScale(CTBubbleScale cTBubbleScale) {
        generatedSetterHelperImpl(cTBubbleScale, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public void setDLbls(CTDLbls cTDLbls) {
        generatedSetterHelperImpl(cTDLbls, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public void setExtLst(CTExtensionList cTExtensionList) {
        generatedSetterHelperImpl(cTExtensionList, PROPERTY_QNAME[8], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public void setSerArray(CTBubbleSer[] cTBubbleSerArr) {
        check_orphaned();
        arraySetterHelper(cTBubbleSerArr, PROPERTY_QNAME[1]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public void setShowNegBubbles(CTBoolean cTBoolean) {
        generatedSetterHelperImpl(cTBoolean, PROPERTY_QNAME[5], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public void setSizeRepresents(CTSizeRepresents cTSizeRepresents) {
        generatedSetterHelperImpl(cTSizeRepresents, PROPERTY_QNAME[6], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public void setVaryColors(CTBoolean cTBoolean) {
        generatedSetterHelperImpl(cTBoolean, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public int sizeOfAxIdArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[7]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public int sizeOfSerArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public void unsetBubble3D() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public void unsetBubbleScale() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public void unsetDLbls() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public void unsetShowNegBubbles() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public void unsetSizeRepresents() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public void unsetVaryColors() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public CTUnsignedInt getAxIdArray(int i5) {
        CTUnsignedInt cTUnsignedInt;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTUnsignedInt = (CTUnsignedInt) get_store().find_element_user(PROPERTY_QNAME[7], i5);
                if (cTUnsignedInt == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public CTBubbleSer getSerArray(int i5) {
        CTBubbleSer cTBubbleSer;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTBubbleSer = (CTBubbleSer) get_store().find_element_user(PROPERTY_QNAME[1], i5);
                if (cTBubbleSer == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTBubbleSer;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public void setAxIdArray(int i5, CTUnsignedInt cTUnsignedInt) {
        generatedSetterHelperImpl(cTUnsignedInt, PROPERTY_QNAME[7], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart
    public void setSerArray(int i5, CTBubbleSer cTBubbleSer) {
        generatedSetterHelperImpl(cTBubbleSer, PROPERTY_QNAME[1], i5, (short) 2);
    }
}
