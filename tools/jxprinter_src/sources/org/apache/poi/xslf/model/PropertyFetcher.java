package org.apache.poi.xslf.model;

import org.apache.poi.util.Internal;
import org.apache.poi.xslf.usermodel.XSLFShape;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public abstract class PropertyFetcher<T> {
    private T _value;
    private boolean isSet = false;

    public abstract boolean fetch(XSLFShape xSLFShape);

    public T getValue() {
        return this._value;
    }

    public boolean isSet() {
        return this.isSet;
    }

    public void setValue(T t6) {
        this._value = t6;
        this.isSet = true;
    }
}
