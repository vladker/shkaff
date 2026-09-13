package org.apache.xmlbeans.impl.inst2xsd.util;

import javax.xml.namespace.QName;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class Attribute {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private QName _name;
    private Type _type;
    private Attribute _ref = null;
    private boolean _isGlobal = false;
    private boolean _isOptional = false;

    public QName getName() {
        return this._name;
    }

    public Attribute getRef() {
        return this._ref;
    }

    public Type getType() {
        return isRef() ? getRef().getType() : this._type;
    }

    public boolean isGlobal() {
        return this._isGlobal;
    }

    public boolean isOptional() {
        return this._isOptional;
    }

    public boolean isRef() {
        return this._ref != null;
    }

    public void setGlobal(boolean z6) {
        this._isGlobal = z6;
    }

    public void setName(QName qName) {
        this._name = qName;
    }

    public void setOptional(boolean z6) {
        this._isOptional = z6;
    }

    public void setRef(Attribute attribute) {
        this._ref = attribute;
        this._type = null;
    }

    public void setType(Type type) {
        this._type = type;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("\n    Attribute{_name=");
        sb.append(this._name);
        sb.append(", _type=");
        sb.append(this._type);
        sb.append(", _ref=");
        sb.append(this._ref != null);
        sb.append(", _isGlobal=");
        sb.append(this._isGlobal);
        sb.append(", _isOptional=");
        sb.append(this._isOptional);
        sb.append(VectorFormat.DEFAULT_SUFFIX);
        return sb.toString();
    }
}
