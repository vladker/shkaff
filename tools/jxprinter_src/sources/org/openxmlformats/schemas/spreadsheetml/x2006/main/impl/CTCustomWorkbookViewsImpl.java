package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.List;
import java.util.function.Function;
import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomWorkbookView;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomWorkbookViews;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTCustomWorkbookViewsImpl;
import r5.B;
import r5.C1566i;
import r5.C1568j;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class CTCustomWorkbookViewsImpl extends XmlComplexContentImpl implements CTCustomWorkbookViews {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_SPREADSHEETML, "customWorkbookView")};
    private static final long serialVersionUID = 1;

    public CTCustomWorkbookViewsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomWorkbookViews
    public CTCustomWorkbookView addNewCustomWorkbookView() {
        CTCustomWorkbookView cTCustomWorkbookView;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomWorkbookView = (CTCustomWorkbookView) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTCustomWorkbookView;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomWorkbookViews
    public CTCustomWorkbookView[] getCustomWorkbookViewArray() {
        return (CTCustomWorkbookView[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTCustomWorkbookView[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomWorkbookViews
    public List<CTCustomWorkbookView> getCustomWorkbookViewList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            final int i5 = 0;
            final int i6 = 1;
            javaListXmlObject = new JavaListXmlObject(new Function(this) { // from class: r5.D
                public final /* synthetic */ CTCustomWorkbookViewsImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i5;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getCustomWorkbookViewArray(iIntValue);
                        default:
                            return this.b.insertNewCustomWorkbookView(iIntValue);
                    }
                }
            }, new B(this, 2), new Function(this) { // from class: r5.D
                public final /* synthetic */ CTCustomWorkbookViewsImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i6;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getCustomWorkbookViewArray(iIntValue);
                        default:
                            return this.b.insertNewCustomWorkbookView(iIntValue);
                    }
                }
            }, new C1566i(this, 14), new C1568j(this, 14));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomWorkbookViews
    public CTCustomWorkbookView insertNewCustomWorkbookView(int i5) {
        CTCustomWorkbookView cTCustomWorkbookView;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomWorkbookView = (CTCustomWorkbookView) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return cTCustomWorkbookView;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomWorkbookViews
    public void removeCustomWorkbookView(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomWorkbookViews
    public void setCustomWorkbookViewArray(CTCustomWorkbookView[] cTCustomWorkbookViewArr) {
        check_orphaned();
        arraySetterHelper(cTCustomWorkbookViewArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomWorkbookViews
    public int sizeOfCustomWorkbookViewArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomWorkbookViews
    public CTCustomWorkbookView getCustomWorkbookViewArray(int i5) {
        CTCustomWorkbookView cTCustomWorkbookView;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTCustomWorkbookView = (CTCustomWorkbookView) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (cTCustomWorkbookView == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTCustomWorkbookView;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomWorkbookViews
    public void setCustomWorkbookViewArray(int i5, CTCustomWorkbookView cTCustomWorkbookView) {
        generatedSetterHelperImpl(cTCustomWorkbookView, PROPERTY_QNAME[0], i5, (short) 2);
    }
}
