package org.apache.commons.compress.harmony.unpack200;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SegmentConstantPoolArrayCache {
    protected IdentityHashMap knownArrays = new IdentityHashMap(1000);
    protected String[] lastArray;
    protected List lastIndexes;
    protected String lastKey;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class CachedArray {
        int lastKnownSize;
        String[] primaryArray;
        HashMap primaryTable;

        public CachedArray(String[] strArr) {
            this.primaryArray = strArr;
            this.lastKnownSize = strArr.length;
            this.primaryTable = new HashMap(this.lastKnownSize);
            cacheIndexes();
        }

        public void cacheIndexes() {
            int i5 = 0;
            while (true) {
                String[] strArr = this.primaryArray;
                if (i5 >= strArr.length) {
                    return;
                }
                String str = strArr[i5];
                if (!this.primaryTable.containsKey(str)) {
                    this.primaryTable.put(str, new ArrayList());
                }
                ((ArrayList) this.primaryTable.get(str)).add(Integer.valueOf(i5));
                i5++;
            }
        }

        public List indexesForKey(String str) {
            return !this.primaryTable.containsKey(str) ? Collections.EMPTY_LIST : (List) this.primaryTable.get(str);
        }

        public int lastKnownSize() {
            return this.lastKnownSize;
        }
    }

    public boolean arrayIsCached(String[] strArr) {
        return this.knownArrays.containsKey(strArr) && ((CachedArray) this.knownArrays.get(strArr)).lastKnownSize() == strArr.length;
    }

    public void cacheArray(String[] strArr) {
        if (arrayIsCached(strArr)) {
            throw new IllegalArgumentException("Trying to cache an array that already exists");
        }
        this.knownArrays.put(strArr, new CachedArray(strArr));
        this.lastArray = null;
    }

    public List indexesForArrayKey(String[] strArr, String str) {
        if (!arrayIsCached(strArr)) {
            cacheArray(strArr);
        }
        if (this.lastArray == strArr && this.lastKey == str) {
            return this.lastIndexes;
        }
        this.lastArray = strArr;
        this.lastKey = str;
        List listIndexesForKey = ((CachedArray) this.knownArrays.get(strArr)).indexesForKey(str);
        this.lastIndexes = listIndexesForKey;
        return listIndexesForKey;
    }
}
