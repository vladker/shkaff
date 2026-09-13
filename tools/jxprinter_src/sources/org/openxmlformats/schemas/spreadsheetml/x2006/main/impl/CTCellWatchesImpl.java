package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.List;
import java.util.function.Function;
import javax.xml.namespace.QName;
import l5.g2;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellWatch;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellWatches;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTCellWatchesImpl;
import r5.C1566i;
import r5.C1568j;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class CTCellWatchesImpl extends XmlComplexContentImpl implements CTCellWatches {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_SPREADSHEETML, "cellWatch")};
    private static final long serialVersionUID = 1;

    public CTCellWatchesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellWatches
    public CTCellWatch addNewCellWatch() {
        CTCellWatch cTCellWatch;
        synchronized (monitor()) {
            check_orphaned();
            cTCellWatch = (CTCellWatch) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTCellWatch;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellWatches
    public CTCellWatch[] getCellWatchArray() {
        return (CTCellWatch[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTCellWatch[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellWatches
    public List<CTCellWatch> getCellWatchList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            final int i5 = 0;
            final int i6 = 1;
            javaListXmlObject = new JavaListXmlObject(new Function(this) { // from class: r5.n
                public final /* synthetic */ CTCellWatchesImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i5;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getCellWatchArray(iIntValue);
                        default:
                            return this.b.insertNewCellWatch(iIntValue);
                    }
                }
            }, new g2(this, 23), new Function(this) { // from class: r5.n
                public final /* synthetic */ CTCellWatchesImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i6;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getCellWatchArray(iIntValue);
                        default:
                            return this.b.insertNewCellWatch(iIntValue);
                    }
                }
            }, new C1566i(this, 4), new C1568j(this, 4));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellWatches
    public CTCellWatch insertNewCellWatch(int i5) {
        CTCellWatch cTCellWatch;
        synchronized (monitor()) {
            check_orphaned();
            cTCellWatch = (CTCellWatch) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return cTCellWatch;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellWatches
    public void removeCellWatch(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellWatches
    public void setCellWatchArray(CTCellWatch[] cTCellWatchArr) {
        check_orphaned();
        arraySetterHelper(cTCellWatchArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellWatches
    public int sizeOfCellWatchArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellWatches
    public CTCellWatch getCellWatchArray(int i5) {
        CTCellWatch cTCellWatch;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTCellWatch = (CTCellWatch) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (cTCellWatch == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTCellWatch;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellWatches
    public void setCellWatchArray(int i5, CTCellWatch cTCellWatch) {
        generatedSetterHelperImpl(cTCellWatch, PROPERTY_QNAME[0], i5, (short) 2);
    }
}
