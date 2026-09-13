package org.apache.xmlbeans.impl.inst2xsd.util;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.commons.math3.geometry.VectorFormat;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.impl.inst2xsd.a;
import org.apache.xmlbeans.impl.values.JavaQNameHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class Type {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int COMPLEX_TYPE_COMPLEX_CONTENT = 3;
    public static final int COMPLEX_TYPE_EMPTY_CONTENT = 5;
    public static final int COMPLEX_TYPE_MIXED_CONTENT = 4;
    public static final int COMPLEX_TYPE_SIMPLE_CONTENT = 2;
    public static final int PARTICLE_CHOICE_UNBOUNDED = 2;
    public static final int PARTICLE_SEQUENCE = 1;
    public static final int SIMPLE_TYPE_SIMPLE_CONTENT = 1;
    private List<Attribute> _attributes;
    private List<Element> _elements;
    private List<QName> _enumerationQNames;
    private List<String> _enumerationValues;
    private Type _extensionType;
    private QName _name;
    private int _kind = 1;
    private int _topParticleForComplexOrMixedContent = 1;
    private boolean _isGlobal = false;
    private boolean _acceptsEnumerationValue = true;

    public static Type createNamedType(QName qName, int i5) {
        Type type = new Type();
        type.setName(qName);
        type.setContentType(i5);
        return type;
    }

    public static Type createUnnamedType(int i5) {
        Type type = new Type();
        type.setContentType(i5);
        return type;
    }

    private void ensureAttributes() {
        if (this._attributes == null) {
            this._attributes = new ArrayList();
        }
    }

    private void ensureElements() {
        if (this._elements == null) {
            this._elements = new ArrayList();
        }
    }

    private void ensureEnumerationValues() {
        if (this._enumerationValues == null) {
            this._enumerationValues = new ArrayList();
            this._enumerationQNames = new ArrayList();
        }
    }

    public void addAllEnumerationsFrom(Type type) {
        ensureEnumerationValues();
        QName qName = this._name;
        SchemaType schemaType = XmlQName.type;
        int i5 = 0;
        if (!qName.equals(schemaType.getName()) || !type._name.equals(schemaType.getName())) {
            while (i5 < type.getEnumerationValues().size()) {
                String str = type.getEnumerationValues().get(i5);
                if (this._acceptsEnumerationValue && !this._enumerationValues.contains(str)) {
                    this._enumerationValues.add(str);
                }
                i5++;
            }
            return;
        }
        while (i5 < type.getEnumerationValues().size()) {
            String str2 = type.getEnumerationValues().get(i5);
            QName qName2 = type.getEnumerationQNames().get(i5);
            if (this._acceptsEnumerationValue && !this._enumerationQNames.contains(qName2)) {
                this._enumerationValues.add(str2);
                this._enumerationQNames.add(qName2);
            }
            i5++;
        }
    }

    public void addAttribute(Attribute attribute) {
        ensureAttributes();
        this._attributes.add(attribute);
    }

    public void addElement(Element element) {
        ensureElements();
        this._elements.add(element);
    }

    public void addEnumerationValue(String str, XmlCursor xmlCursor) {
        ensureEnumerationValues();
        if (!this._acceptsEnumerationValue || this._enumerationValues.contains(str)) {
            return;
        }
        this._enumerationValues.add(str);
        if (this._name.equals(XmlQName.type.getName())) {
            xmlCursor.getClass();
            this._enumerationQNames.add(JavaQNameHolder.validateLexical(str, null, new a(xmlCursor)));
        }
    }

    public void closeEnumeration() {
        this._acceptsEnumerationValue = false;
    }

    public Attribute getAttribute(QName qName) {
        for (Attribute attribute : this._attributes) {
            if (attribute.getName().equals(qName)) {
                return attribute;
            }
        }
        return null;
    }

    public List<Attribute> getAttributes() {
        ensureAttributes();
        return this._attributes;
    }

    public int getContentType() {
        return this._kind;
    }

    public List<Element> getElements() {
        ensureElements();
        return this._elements;
    }

    public List<QName> getEnumerationQNames() {
        ensureEnumerationValues();
        return this._enumerationQNames;
    }

    public List<String> getEnumerationValues() {
        ensureEnumerationValues();
        return this._enumerationValues;
    }

    public Type getExtensionType() {
        return this._extensionType;
    }

    public QName getName() {
        return this._name;
    }

    public int getTopParticleForComplexOrMixedContent() {
        return this._topParticleForComplexOrMixedContent;
    }

    public boolean hasSimpleContent() {
        int i5 = this._kind;
        return i5 == 1 || i5 == 2;
    }

    public boolean isComplexType() {
        int i5 = this._kind;
        return i5 == 3 || i5 == 4 || i5 == 2;
    }

    public boolean isEnumeration() {
        List<String> list;
        return this._acceptsEnumerationValue && (list = this._enumerationValues) != null && list.size() > 1;
    }

    public boolean isGlobal() {
        return this._isGlobal;
    }

    public boolean isQNameEnumeration() {
        List<QName> list;
        return isEnumeration() && this._name.equals(XmlQName.type.getName()) && (list = this._enumerationQNames) != null && list.size() > 1;
    }

    public void setContentType(int i5) {
        this._kind = i5;
    }

    public void setElements(List<Element> list) {
        ensureElements();
        this._elements.clear();
        this._elements.addAll(list);
    }

    public void setExtensionType(Type type) {
        this._extensionType = type;
    }

    public void setGlobal(boolean z6) {
        this._isGlobal = z6;
    }

    public void setName(QName qName) {
        this._name = qName;
    }

    public void setTopParticleForComplexOrMixedContent(int i5) {
        this._topParticleForComplexOrMixedContent = i5;
    }

    public String toString() {
        return "Type{_name = " + this._name + ", _extensionType = " + this._extensionType + ", _kind = " + this._kind + ", _elements = " + this._elements + ", _attributes = " + this._attributes + VectorFormat.DEFAULT_SUFFIX;
    }
}
