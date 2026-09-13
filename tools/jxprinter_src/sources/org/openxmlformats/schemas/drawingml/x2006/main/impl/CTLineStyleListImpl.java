package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import H4.d;
import J4.b;
import J4.c;
import java.util.List;
import java.util.function.Function;
import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineStyleList;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTLineStyleListImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTLineStyleListImpl extends XmlComplexContentImpl implements CTLineStyleList {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_DRAWINGML, "ln")};
    private static final long serialVersionUID = 1;

    public CTLineStyleListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineStyleList
    public CTLineProperties addNewLn() {
        CTLineProperties cTLineProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTLineProperties = (CTLineProperties) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTLineProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineStyleList
    public CTLineProperties[] getLnArray() {
        return (CTLineProperties[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTLineProperties[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineStyleList
    public List<CTLineProperties> getLnList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            final int i5 = 0;
            final int i6 = 1;
            javaListXmlObject = new JavaListXmlObject(new Function(this) { // from class: l5.J0
                public final /* synthetic */ CTLineStyleListImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i5;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getLnArray(iIntValue);
                        default:
                            return this.b.insertNewLn(iIntValue);
                    }
                }
            }, new b(this, 22), new Function(this) { // from class: l5.J0
                public final /* synthetic */ CTLineStyleListImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i6;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getLnArray(iIntValue);
                        default:
                            return this.b.insertNewLn(iIntValue);
                    }
                }
            }, new c(this, 24), new d(this, 25));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineStyleList
    public CTLineProperties insertNewLn(int i5) {
        CTLineProperties cTLineProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTLineProperties = (CTLineProperties) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return cTLineProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineStyleList
    public void removeLn(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineStyleList
    public void setLnArray(CTLineProperties[] cTLinePropertiesArr) {
        check_orphaned();
        arraySetterHelper(cTLinePropertiesArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineStyleList
    public int sizeOfLnArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineStyleList
    public CTLineProperties getLnArray(int i5) {
        CTLineProperties cTLineProperties;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTLineProperties = (CTLineProperties) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (cTLineProperties == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTLineProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineStyleList
    public void setLnArray(int i5, CTLineProperties cTLineProperties) {
        generatedSetterHelperImpl(cTLineProperties, PROPERTY_QNAME[0], i5, (short) 2);
    }
}
