package org.apache.xmlbeans.impl.config;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class NameSet {
    public static final NameSet EMPTY;
    public static final NameSet EVERYTHING;
    private Set<String> _finiteSet;
    private boolean _isFinite;

    static {
        Set set = Collections.EMPTY_SET;
        EMPTY = new NameSet(true, set);
        EVERYTHING = new NameSet(false, set);
    }

    private NameSet(boolean z6, Set<String> set) {
        this._isFinite = z6;
        this._finiteSet = set;
    }

    private static Set<String> intersectFiniteSets(Set<String> set, Set<String> set2) {
        HashSet hashSet = new HashSet();
        while (set.iterator().hasNext()) {
            String next = set.iterator().next();
            if (set2.contains(next)) {
                hashSet.add(next);
            }
        }
        return hashSet;
    }

    public static NameSet newInstance(boolean z6, Set<String> set) {
        if (set.size() == 0) {
            return z6 ? EMPTY : EVERYTHING;
        }
        HashSet hashSet = new HashSet();
        hashSet.addAll(set);
        return new NameSet(z6, hashSet);
    }

    public boolean contains(String str) {
        return this._isFinite ? this._finiteSet.contains(str) : !this._finiteSet.contains(str);
    }

    public NameSet intersect(NameSet nameSet) {
        if (this._isFinite) {
            if (nameSet._isFinite) {
                return newInstance(true, intersectFiniteSets(this._finiteSet, nameSet._finiteSet));
            }
            HashSet hashSet = new HashSet();
            hashSet.addAll(this._finiteSet);
            hashSet.removeAll(nameSet._finiteSet);
            return newInstance(false, hashSet);
        }
        if (nameSet._isFinite) {
            HashSet hashSet2 = new HashSet();
            hashSet2.addAll(nameSet._finiteSet);
            hashSet2.removeAll(this._finiteSet);
            return newInstance(true, hashSet2);
        }
        HashSet hashSet3 = new HashSet();
        hashSet3.addAll(this._finiteSet);
        hashSet3.addAll(nameSet._finiteSet);
        return newInstance(false, hashSet3);
    }

    public NameSet invert() {
        return newInstance(!this._isFinite, this._finiteSet);
    }

    public NameSet substract(NameSet nameSet) {
        if (this._isFinite) {
            if (!nameSet._isFinite) {
                return newInstance(true, intersectFiniteSets(this._finiteSet, nameSet._finiteSet));
            }
            HashSet hashSet = new HashSet();
            hashSet.addAll(this._finiteSet);
            hashSet.removeAll(nameSet._finiteSet);
            return newInstance(true, hashSet);
        }
        if (nameSet._isFinite) {
            HashSet hashSet2 = new HashSet();
            hashSet2.addAll(this._finiteSet);
            hashSet2.addAll(nameSet._finiteSet);
            return newInstance(false, hashSet2);
        }
        HashSet hashSet3 = new HashSet();
        hashSet3.addAll(nameSet._finiteSet);
        hashSet3.removeAll(this._finiteSet);
        return newInstance(true, hashSet3);
    }

    public NameSet substractFrom(NameSet nameSet) {
        return nameSet.substract(this);
    }

    public NameSet union(NameSet nameSet) {
        if (!this._isFinite) {
            if (!nameSet._isFinite) {
                return newInstance(false, intersectFiniteSets(this._finiteSet, nameSet._finiteSet));
            }
            HashSet hashSet = new HashSet();
            hashSet.addAll(this._finiteSet);
            hashSet.removeAll(nameSet._finiteSet);
            return newInstance(false, hashSet);
        }
        if (nameSet._isFinite) {
            HashSet hashSet2 = new HashSet();
            hashSet2.addAll(this._finiteSet);
            hashSet2.addAll(nameSet._finiteSet);
            return newInstance(true, hashSet2);
        }
        HashSet hashSet3 = new HashSet();
        hashSet3.addAll(nameSet._finiteSet);
        hashSet3.removeAll(this._finiteSet);
        return newInstance(false, hashSet3);
    }
}
