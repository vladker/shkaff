package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.ShapeSheetType;
import com.microsoft.schemas.office.visio.x2012.main.ShapesType;
import com.microsoft.schemas.office.visio.x2012.main.impl.ShapesTypeImpl;
import java.util.List;
import java.util.function.Function;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import p105s2.i;
import p105s2.j;
import r5.B0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class ShapesTypeImpl extends XmlComplexContentImpl implements ShapesType {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.microsoft.com/office/visio/2012/main", "Shape")};
    private static final long serialVersionUID = 1;

    public ShapesTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ShapesType
    public ShapeSheetType addNewShape() {
        ShapeSheetType shapeSheetType;
        synchronized (monitor()) {
            check_orphaned();
            shapeSheetType = (ShapeSheetType) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return shapeSheetType;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ShapesType
    public ShapeSheetType[] getShapeArray() {
        return (ShapeSheetType[]) getXmlObjectArray(PROPERTY_QNAME[0], new ShapeSheetType[0]);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ShapesType
    public List<ShapeSheetType> getShapeList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            final int i5 = 0;
            final int i6 = 1;
            javaListXmlObject = new JavaListXmlObject(new Function(this) { // from class: s2.s
                public final /* synthetic */ ShapesTypeImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i5;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getShapeArray(iIntValue);
                        default:
                            return this.b.insertNewShape(iIntValue);
                    }
                }
            }, new B0(this, 17), new Function(this) { // from class: s2.s
                public final /* synthetic */ ShapesTypeImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i6;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getShapeArray(iIntValue);
                        default:
                            return this.b.insertNewShape(iIntValue);
                    }
                }
            }, new i(this, 1), new j(this, 1));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ShapesType
    public ShapeSheetType insertNewShape(int i5) {
        ShapeSheetType shapeSheetType;
        synchronized (monitor()) {
            check_orphaned();
            shapeSheetType = (ShapeSheetType) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return shapeSheetType;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ShapesType
    public void removeShape(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ShapesType
    public void setShapeArray(ShapeSheetType[] shapeSheetTypeArr) {
        check_orphaned();
        arraySetterHelper(shapeSheetTypeArr, PROPERTY_QNAME[0]);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ShapesType
    public int sizeOfShapeArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ShapesType
    public ShapeSheetType getShapeArray(int i5) {
        ShapeSheetType shapeSheetType;
        synchronized (monitor()) {
            try {
                check_orphaned();
                shapeSheetType = (ShapeSheetType) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (shapeSheetType == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return shapeSheetType;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ShapesType
    public void setShapeArray(int i5, ShapeSheetType shapeSheetType) {
        generatedSetterHelperImpl(shapeSheetType, PROPERTY_QNAME[0], i5, (short) 2);
    }
}
