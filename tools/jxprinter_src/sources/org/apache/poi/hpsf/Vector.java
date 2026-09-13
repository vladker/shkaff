package org.apache.poi.hpsf;

import androidx.collection.a;
import java.util.ArrayList;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndianByteArrayInputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public class Vector {
    private final short _type;
    private TypedPropertyValue[] _values;

    public Vector(short s6) {
        this._type = s6;
    }

    public TypedPropertyValue[] getValues() {
        return this._values;
    }

    public void read(LittleEndianByteArrayInputStream littleEndianByteArrayInputStream) {
        long uInt = littleEndianByteArrayInputStream.readUInt();
        if (uInt > 2147483647L) {
            throw new UnsupportedOperationException(a.j(uInt, "Vector is too long -- "));
        }
        int i5 = (int) uInt;
        ArrayList arrayList = new ArrayList();
        short s6 = this._type;
        if (s6 == 12) {
            s6 = 0;
        }
        for (int i6 = 0; i6 < i5; i6++) {
            TypedPropertyValue typedPropertyValue = new TypedPropertyValue(s6, null);
            if (s6 == 0) {
                typedPropertyValue.read(littleEndianByteArrayInputStream);
            } else {
                typedPropertyValue.readValue(littleEndianByteArrayInputStream);
            }
            arrayList.add(typedPropertyValue);
        }
        this._values = (TypedPropertyValue[]) arrayList.toArray(new TypedPropertyValue[0]);
    }
}
