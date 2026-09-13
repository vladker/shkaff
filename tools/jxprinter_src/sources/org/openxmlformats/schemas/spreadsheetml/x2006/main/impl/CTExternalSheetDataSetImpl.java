package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.List;
import java.util.function.Function;
import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetData;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetDataSet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTExternalSheetDataSetImpl;
import r5.B;
import r5.C1566i;
import r5.C1568j;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class CTExternalSheetDataSetImpl extends XmlComplexContentImpl implements CTExternalSheetDataSet {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_SPREADSHEETML, "sheetData")};
    private static final long serialVersionUID = 1;

    public CTExternalSheetDataSetImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetDataSet
    public CTExternalSheetData addNewSheetData() {
        CTExternalSheetData cTExternalSheetData;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalSheetData = (CTExternalSheetData) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTExternalSheetData;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetDataSet
    public CTExternalSheetData[] getSheetDataArray() {
        return (CTExternalSheetData[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTExternalSheetData[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetDataSet
    public List<CTExternalSheetData> getSheetDataList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            final int i5 = 0;
            final int i6 = 1;
            javaListXmlObject = new JavaListXmlObject(new Function(this) { // from class: r5.O
                public final /* synthetic */ CTExternalSheetDataSetImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i5;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getSheetDataArray(iIntValue);
                        default:
                            return this.b.insertNewSheetData(iIntValue);
                    }
                }
            }, new B(this, 13), new Function(this) { // from class: r5.O
                public final /* synthetic */ CTExternalSheetDataSetImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i6;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getSheetDataArray(iIntValue);
                        default:
                            return this.b.insertNewSheetData(iIntValue);
                    }
                }
            }, new C1566i(this, 25), new C1568j(this, 25));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetDataSet
    public CTExternalSheetData insertNewSheetData(int i5) {
        CTExternalSheetData cTExternalSheetData;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalSheetData = (CTExternalSheetData) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return cTExternalSheetData;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetDataSet
    public void removeSheetData(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetDataSet
    public void setSheetDataArray(CTExternalSheetData[] cTExternalSheetDataArr) {
        check_orphaned();
        arraySetterHelper(cTExternalSheetDataArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetDataSet
    public int sizeOfSheetDataArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetDataSet
    public CTExternalSheetData getSheetDataArray(int i5) {
        CTExternalSheetData cTExternalSheetData;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTExternalSheetData = (CTExternalSheetData) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (cTExternalSheetData == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTExternalSheetData;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetDataSet
    public void setSheetDataArray(int i5, CTExternalSheetData cTExternalSheetData) {
        generatedSetterHelperImpl(cTExternalSheetData, PROPERTY_QNAME[0], i5, (short) 2);
    }
}
