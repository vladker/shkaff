package org.apache.commons.collections4.properties;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import org.apache.commons.collections4.iterators.IteratorEnumeration;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SortedProperties extends Properties {
    private static final long serialVersionUID = 1;

    @Override // java.util.Hashtable, java.util.Dictionary
    public synchronized Enumeration<Object> keys() {
        ArrayList arrayList;
        try {
            Set<Object> setKeySet = keySet();
            arrayList = new ArrayList(setKeySet.size());
            Iterator<Object> it = setKeySet.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toString());
            }
            Collections.sort(arrayList);
        } catch (Throwable th) {
            throw th;
        }
        return new IteratorEnumeration(arrayList.iterator());
    }
}
