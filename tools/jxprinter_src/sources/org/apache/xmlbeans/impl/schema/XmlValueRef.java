package org.apache.xmlbeans.impl.schema;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class XmlValueRef {
    Object _initVal;
    XmlAnySimpleType _obj;
    SchemaType.Ref _typeref;

    public XmlValueRef(XmlAnySimpleType xmlAnySimpleType) {
        if (xmlAnySimpleType == null) {
            throw new IllegalArgumentException();
        }
        this._obj = xmlAnySimpleType;
    }

    public synchronized XmlAnySimpleType get() {
        try {
            if (this._obj == null) {
                SchemaType schemaType = this._typeref.get();
                if (schemaType.getSimpleVariety() != 3) {
                    this._obj = schemaType.newValue(this._initVal);
                } else {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = ((List) this._initVal).iterator();
                    while (it.hasNext()) {
                        arrayList.add(((XmlValueRef) it.next()).get());
                    }
                    this._obj = schemaType.newValue(arrayList);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this._obj;
    }

    public XmlValueRef(SchemaType.Ref ref, Object obj) {
        if (ref != null) {
            this._typeref = ref;
            this._initVal = obj;
            return;
        }
        throw new IllegalArgumentException();
    }
}
