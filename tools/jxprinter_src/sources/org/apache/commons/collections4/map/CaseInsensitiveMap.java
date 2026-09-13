package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CaseInsensitiveMap<K, V> extends AbstractHashedMap<K, V> implements Serializable, Cloneable {
    private static final long serialVersionUID = -7074655917369299456L;

    public CaseInsensitiveMap() {
        super(16, 0.75f, 12);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        doReadObject(objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        doWriteObject(objectOutputStream);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public Object convertKey(Object obj) {
        if (obj == null) {
            return AbstractHashedMap.NULL;
        }
        char[] charArray = obj.toString().toCharArray();
        for (int length = charArray.length - 1; length >= 0; length--) {
            charArray[length] = Character.toLowerCase(Character.toUpperCase(charArray[length]));
        }
        return new String(charArray);
    }

    public CaseInsensitiveMap(int i5) {
        super(i5);
    }

    public CaseInsensitiveMap(int i5, float f6) {
        super(i5, f6);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap
    public CaseInsensitiveMap<K, V> clone() {
        return (CaseInsensitiveMap) super.clone();
    }

    public CaseInsensitiveMap(Map<? extends K, ? extends V> map) {
        super(map);
    }
}
