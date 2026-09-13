package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.List;
import java.util.function.Function;
import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCells;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTSingleXmlCellsImpl;
import r5.B0;
import r5.C1551a0;
import r5.C1553b0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class CTSingleXmlCellsImpl extends XmlComplexContentImpl implements CTSingleXmlCells {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_SPREADSHEETML, "singleXmlCell")};
    private static final long serialVersionUID = 1;

    public CTSingleXmlCellsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCells
    public CTSingleXmlCell addNewSingleXmlCell() {
        CTSingleXmlCell cTSingleXmlCell;
        synchronized (monitor()) {
            check_orphaned();
            cTSingleXmlCell = (CTSingleXmlCell) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTSingleXmlCell;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCells
    public CTSingleXmlCell[] getSingleXmlCellArray() {
        return (CTSingleXmlCell[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTSingleXmlCell[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCells
    public List<CTSingleXmlCell> getSingleXmlCellList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            final int i5 = 0;
            final int i6 = 1;
            javaListXmlObject = new JavaListXmlObject(new Function(this) { // from class: r5.X0
                public final /* synthetic */ CTSingleXmlCellsImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i5;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getSingleXmlCellArray(iIntValue);
                        default:
                            return this.b.insertNewSingleXmlCell(iIntValue);
                    }
                }
            }, new B0(this, 6), new Function(this) { // from class: r5.X0
                public final /* synthetic */ CTSingleXmlCellsImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i6;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getSingleXmlCellArray(iIntValue);
                        default:
                            return this.b.insertNewSingleXmlCell(iIntValue);
                    }
                }
            }, new C1551a0(this, 20), new C1553b0(this, 20));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCells
    public CTSingleXmlCell insertNewSingleXmlCell(int i5) {
        CTSingleXmlCell cTSingleXmlCell;
        synchronized (monitor()) {
            check_orphaned();
            cTSingleXmlCell = (CTSingleXmlCell) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return cTSingleXmlCell;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCells
    public void removeSingleXmlCell(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCells
    public void setSingleXmlCellArray(CTSingleXmlCell[] cTSingleXmlCellArr) {
        check_orphaned();
        arraySetterHelper(cTSingleXmlCellArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCells
    public int sizeOfSingleXmlCellArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCells
    public CTSingleXmlCell getSingleXmlCellArray(int i5) {
        CTSingleXmlCell cTSingleXmlCell;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTSingleXmlCell = (CTSingleXmlCell) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (cTSingleXmlCell == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTSingleXmlCell;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCells
    public void setSingleXmlCellArray(int i5, CTSingleXmlCell cTSingleXmlCell) {
        generatedSetterHelperImpl(cTSingleXmlCell, PROPERTY_QNAME[0], i5, (short) 2);
    }
}
