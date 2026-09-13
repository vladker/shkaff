package org.apache.xmlbeans.impl.inst2xsd.util;

import A3.AbstractC0157z;
import javax.xml.namespace.QName;
import kotlinx.serialization.json.internal.AbstractC1127c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class Element {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int UNBOUNDED = -1;
    private QName _name = null;
    private Element _ref = null;
    private boolean _isGlobal = false;
    private int _minOccurs = 1;
    private int _maxOccurs = 1;
    private boolean _isNillable = false;
    private Type _type = null;
    private String _comment = null;

    public String getComment() {
        return this._comment;
    }

    public int getMaxOccurs() {
        return this._maxOccurs;
    }

    public int getMinOccurs() {
        return this._minOccurs;
    }

    public QName getName() {
        return this._name;
    }

    public Element getRef() {
        return this._ref;
    }

    public Type getType() {
        return isRef() ? getRef().getType() : this._type;
    }

    public boolean isGlobal() {
        return this._isGlobal;
    }

    public boolean isNillable() {
        return this._isNillable;
    }

    public boolean isRef() {
        return this._ref != null;
    }

    public void setComment(String str) {
        this._comment = str;
    }

    public void setGlobal(boolean z6) {
        this._isGlobal = z6;
        this._minOccurs = 1;
        this._maxOccurs = 1;
    }

    public void setMaxOccurs(int i5) {
        this._maxOccurs = i5;
    }

    public void setMinOccurs(int i5) {
        this._minOccurs = i5;
    }

    public void setName(QName qName) {
        this._name = qName;
    }

    public void setNillable(boolean z6) {
        this._isNillable = z6;
    }

    public void setRef(Element element) {
        this._ref = element;
        this._type = null;
    }

    public void setType(Type type) {
        this._type = type;
    }

    public String toString() {
        String string;
        StringBuilder sb = new StringBuilder("\n  Element{ _name = ");
        sb.append(this._name);
        sb.append(", _ref = ");
        sb.append(this._ref != null);
        sb.append(", _isGlobal = ");
        sb.append(this._isGlobal);
        sb.append(", _minOccurs = ");
        sb.append(this._minOccurs);
        sb.append(", _maxOccurs = ");
        sb.append(this._maxOccurs);
        sb.append(", _isNillable = ");
        sb.append(this._isNillable);
        sb.append(", _comment = ");
        sb.append(this._comment);
        sb.append(",\n    _type = ");
        Type type = this._type;
        if (type == null) {
            string = AbstractC1127c.NULL;
        } else {
            string = type.isGlobal() ? this._type.getName().toString() : this._type.toString();
        }
        return AbstractC0157z.s(sb, string, "\n  }");
    }
}
