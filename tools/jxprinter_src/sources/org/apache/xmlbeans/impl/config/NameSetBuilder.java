package org.apache.xmlbeans.impl.config;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class NameSetBuilder {
    private boolean _isFinite = true;
    private final Set<String> _finiteSet = new HashSet();

    public void add(String str) {
        if (this._isFinite) {
            this._finiteSet.add(str);
        } else {
            this._finiteSet.remove(str);
        }
    }

    public void invert() {
        this._isFinite = !this._isFinite;
    }

    public NameSet toNameSet() {
        if (this._finiteSet.size() == 0) {
            return this._isFinite ? NameSet.EMPTY : NameSet.EVERYTHING;
        }
        return NameSet.newInstance(this._isFinite, this._finiteSet);
    }
}
