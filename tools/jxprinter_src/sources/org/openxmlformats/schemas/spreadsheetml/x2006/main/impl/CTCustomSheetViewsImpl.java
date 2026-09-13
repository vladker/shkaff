package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.List;
import java.util.function.Function;
import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomSheetView;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomSheetViews;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTCustomSheetViewsImpl;
import r5.B;
import r5.C1566i;
import r5.C1568j;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class CTCustomSheetViewsImpl extends XmlComplexContentImpl implements CTCustomSheetViews {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_SPREADSHEETML, "customSheetView")};
    private static final long serialVersionUID = 1;

    public CTCustomSheetViewsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomSheetViews
    public CTCustomSheetView addNewCustomSheetView() {
        CTCustomSheetView cTCustomSheetView;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomSheetView = (CTCustomSheetView) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTCustomSheetView;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomSheetViews
    public CTCustomSheetView[] getCustomSheetViewArray() {
        return (CTCustomSheetView[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTCustomSheetView[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomSheetViews
    public List<CTCustomSheetView> getCustomSheetViewList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            final int i5 = 0;
            final int i6 = 1;
            javaListXmlObject = new JavaListXmlObject(new Function(this) { // from class: r5.C
                public final /* synthetic */ CTCustomSheetViewsImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i5;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getCustomSheetViewArray(iIntValue);
                        default:
                            return this.b.insertNewCustomSheetView(iIntValue);
                    }
                }
            }, new B(this, 1), new Function(this) { // from class: r5.C
                public final /* synthetic */ CTCustomSheetViewsImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i6;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getCustomSheetViewArray(iIntValue);
                        default:
                            return this.b.insertNewCustomSheetView(iIntValue);
                    }
                }
            }, new C1566i(this, 13), new C1568j(this, 13));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomSheetViews
    public CTCustomSheetView insertNewCustomSheetView(int i5) {
        CTCustomSheetView cTCustomSheetView;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomSheetView = (CTCustomSheetView) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return cTCustomSheetView;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomSheetViews
    public void removeCustomSheetView(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomSheetViews
    public void setCustomSheetViewArray(CTCustomSheetView[] cTCustomSheetViewArr) {
        check_orphaned();
        arraySetterHelper(cTCustomSheetViewArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomSheetViews
    public int sizeOfCustomSheetViewArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomSheetViews
    public CTCustomSheetView getCustomSheetViewArray(int i5) {
        CTCustomSheetView cTCustomSheetView;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTCustomSheetView = (CTCustomSheetView) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (cTCustomSheetView == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTCustomSheetView;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomSheetViews
    public void setCustomSheetViewArray(int i5, CTCustomSheetView cTCustomSheetView) {
        generatedSetterHelperImpl(cTCustomSheetView, PROPERTY_QNAME[0], i5, (short) 2);
    }
}
