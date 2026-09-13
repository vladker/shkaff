package org.apache.xmlbeans.impl.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.namespace.QName;
import javax.xml.stream.Location;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlIDREF;
import org.apache.xmlbeans.XmlIDREFS;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.xpath.XPath;
import org.apache.xmlbeans.impl.xpath.XPathExecutionContext;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class IdentityConstraint {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private ConstraintState _constraintStack;
    private ElementState _elementStack;
    private final Collection<XmlError> _errorListener;
    private boolean _invalid;
    private final boolean _trackIdrefs;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public abstract class ConstraintState {
        ConstraintState _next;

        public ConstraintState() {
            IdentityConstraint.this.setSavePoint(IdentityConstraint.this._constraintStack);
            this._next = IdentityConstraint.this._constraintStack;
            IdentityConstraint.this._constraintStack = this;
        }

        public abstract void attr(ValidatorListener.Event event, QName qName, SchemaType schemaType, String str);

        public abstract void element(ValidatorListener.Event event, SchemaType schemaType);

        public abstract void endElement(ValidatorListener.Event event);

        public abstract void remove(ValidatorListener.Event event);

        public abstract void text(ValidatorListener.Event event, SchemaType schemaType, String str, boolean z6);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ElementState {
        boolean _hasConstraints;
        ElementState _next;
        ConstraintState _savePoint;

        private ElementState() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class FieldState extends ConstraintState {
        XPathExecutionContext[] _contexts;
        boolean[] _needsValue;
        SelectorState _selector;
        XmlObjectList _value;

        public FieldState(SelectorState selectorState, ValidatorListener.Event event, SchemaType schemaType) {
            super();
            this._selector = selectorState;
            SchemaIdentityConstraint schemaIdentityConstraint = selectorState._constraint;
            int length = schemaIdentityConstraint.getFields().length;
            this._contexts = new XPathExecutionContext[length];
            this._needsValue = new boolean[length];
            this._value = new XmlObjectList(length);
            for (int i5 = 0; i5 < length; i5++) {
                this._contexts[i5] = new XPathExecutionContext();
                this._contexts[i5].init((XPath) schemaIdentityConstraint.getFieldPath(i5));
                if ((this._contexts[i5].start() & 1) != 0) {
                    if (IdentityConstraint.hasSimpleContent(schemaType)) {
                        this._needsValue[i5] = true;
                    } else {
                        IdentityConstraint.this.emitError(event, "Identity constraint field must have simple content");
                    }
                }
            }
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        public void attr(ValidatorListener.Event event, QName qName, SchemaType schemaType, String str) {
            if (str == null) {
                return;
            }
            int i5 = 0;
            while (true) {
                XPathExecutionContext[] xPathExecutionContextArr = this._contexts;
                if (i5 >= xPathExecutionContextArr.length) {
                    return;
                }
                if (xPathExecutionContextArr[i5].attr(qName)) {
                    XmlObject xmlObjectNewValue = IdentityConstraint.newValue(schemaType, str);
                    if (xmlObjectNewValue == null) {
                        return;
                    }
                    if (!this._value.set(xmlObjectNewValue, i5)) {
                        IdentityConstraint.this.emitError(event, "Multiple instances of field with xpath: '" + this._selector._constraint.getFields()[i5] + "' for a selector");
                    }
                }
                i5++;
            }
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        public void element(ValidatorListener.Event event, SchemaType schemaType) {
            int i5 = 0;
            for (int i6 = 0; i6 < this._contexts.length; i6++) {
                if (this._needsValue[i6]) {
                    IdentityConstraint.this.emitError(event, "Identity constraint field must have simple content");
                    this._needsValue[i6] = false;
                }
            }
            while (true) {
                XPathExecutionContext[] xPathExecutionContextArr = this._contexts;
                if (i5 >= xPathExecutionContextArr.length) {
                    return;
                }
                if ((xPathExecutionContextArr[i5].element(event.getName()) & 1) != 0) {
                    if (IdentityConstraint.hasSimpleContent(schemaType)) {
                        this._needsValue[i5] = true;
                    } else {
                        IdentityConstraint.this.emitError(event, "Identity constraint field must have simple content");
                    }
                }
                i5++;
            }
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        public void endElement(ValidatorListener.Event event) {
            for (int i5 = 0; i5 < this._needsValue.length; i5++) {
                this._contexts[i5].end();
                this._needsValue[i5] = false;
            }
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        public void remove(ValidatorListener.Event event) {
            if (this._selector._constraint.getConstraintCategory() != 1 || this._value.unfilled() < 0) {
                this._selector.addFields(this._value, event);
                return;
            }
            IdentityConstraint.this.emitError(event, "Key " + QNameHelper.pretty(this._selector._constraint.getName()) + " is missing field with xpath: '" + this._selector._constraint.getFields()[this._value.unfilled()] + "'");
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        public void text(ValidatorListener.Event event, SchemaType schemaType, String str, boolean z6) {
            if (str != null || z6) {
                for (int i5 = 0; i5 < this._contexts.length; i5++) {
                    if (this._needsValue[i5]) {
                        if (z6 || !IdentityConstraint.hasSimpleContent(schemaType)) {
                            IdentityConstraint.this.emitError(event, "Identity constraint field must have simple content");
                            return;
                        }
                        XmlObject xmlObjectNewValue = IdentityConstraint.newValue(IdentityConstraint.getSimpleType(schemaType), str);
                        if (xmlObjectNewValue == null) {
                            return;
                        }
                        if (!this._value.set(xmlObjectNewValue, i5)) {
                            IdentityConstraint.this.emitError(event, "Multiple instances of field with xpath: '" + this._selector._constraint.getFields()[i5] + "' for a selector");
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class KeyrefState extends SelectorState {
        private final Object CHILD_ADDED;
        private final Object CHILD_REMOVED;
        private final Object SELF_ADDED;
        Map<XmlObjectList, Object> _keyValues;

        public KeyrefState(SchemaIdentityConstraint schemaIdentityConstraint, ValidatorListener.Event event, SchemaType schemaType) {
            super(schemaIdentityConstraint, event, schemaType);
            this._keyValues = new HashMap();
            this.CHILD_ADDED = new Object();
            this.CHILD_REMOVED = new Object();
            this.SELF_ADDED = new Object();
        }

        private boolean hasKeyValue(XmlObjectList xmlObjectList) {
            Object obj = this._keyValues.get(xmlObjectList);
            return (obj == null || obj == this.CHILD_REMOVED) ? false : true;
        }

        public void addKeyValues(Set<XmlObjectList> set, boolean z6) {
            for (XmlObjectList xmlObjectList : set) {
                Object obj = this._keyValues.get(xmlObjectList);
                if (obj == null) {
                    this._keyValues.put(xmlObjectList, z6 ? this.CHILD_ADDED : this.SELF_ADDED);
                } else if (obj == this.CHILD_ADDED) {
                    if (z6) {
                        this._keyValues.put(xmlObjectList, this.CHILD_REMOVED);
                    } else {
                        this._keyValues.put(xmlObjectList, this.SELF_ADDED);
                    }
                } else if (obj == this.CHILD_REMOVED && !z6) {
                    this._keyValues.put(xmlObjectList, this.SELF_ADDED);
                }
            }
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.SelectorState, org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        public void remove(ValidatorListener.Event event) {
            for (ConstraintState constraintState = this._next; constraintState != null && constraintState != IdentityConstraint.this._elementStack._savePoint; constraintState = constraintState._next) {
                if (constraintState instanceof SelectorState) {
                    SelectorState selectorState = (SelectorState) constraintState;
                    if (selectorState._constraint == this._constraint.getReferencedKey()) {
                        addKeyValues(selectorState._values, false);
                    }
                }
            }
            for (XmlObjectList xmlObjectList : this._values) {
                if (xmlObjectList.unfilled() < 0 && !hasKeyValue(xmlObjectList)) {
                    IdentityConstraint.this.emitError(event, XmlErrorCodes.IDENTITY_CONSTRAINT_VALID$KEYREF_KEY_NOT_FOUND, new Object[]{xmlObjectList, QNameHelper.pretty(this._constraint.getName())});
                    return;
                }
            }
        }
    }

    public IdentityConstraint(Collection<XmlError> collection, boolean z6) {
        this._errorListener = collection;
        this._trackIdrefs = z6;
    }

    private void buildIdStates() {
        IdState idState = new IdState();
        if (this._trackIdrefs) {
            new IdRefState(idState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emitError(ValidatorListener.Event event, String str, Object[] objArr) {
        this._invalid = true;
        Collection<XmlError> collection = this._errorListener;
        if (collection != null) {
            collection.add(errorForEvent(str, objArr, 0, event));
        }
    }

    public static XmlError errorForEvent(String str, Object[] objArr, int i5, ValidatorListener.Event event) {
        XmlCursor locationAsCursor = event.getLocationAsCursor();
        if (locationAsCursor != null) {
            return XmlError.forCursor(str, objArr, i5, locationAsCursor);
        }
        Location location = event.getLocation();
        return location != null ? XmlError.forLocation(str, objArr, i5, location.getSystemId(), location.getLineNumber(), location.getColumnNumber(), location.getCharacterOffset()) : XmlError.forMessage(str, objArr, i5);
    }

    public static SchemaType getSimpleType(SchemaType schemaType) {
        while (!schemaType.isSimpleType()) {
            schemaType = schemaType.getBaseType();
        }
        return schemaType;
    }

    public static boolean hasSimpleContent(SchemaType schemaType) {
        return schemaType.isSimpleType() || schemaType.getContentType() == 2;
    }

    private void newConstraintState(SchemaIdentityConstraint schemaIdentityConstraint, ValidatorListener.Event event, SchemaType schemaType) {
        if (schemaIdentityConstraint.getConstraintCategory() == 2) {
            new KeyrefState(schemaIdentityConstraint, event, schemaType);
        } else {
            new SelectorState(schemaIdentityConstraint, event, schemaType);
        }
    }

    private void newState() {
        boolean z6 = this._elementStack == null;
        ElementState elementState = new ElementState();
        elementState._next = this._elementStack;
        this._elementStack = elementState;
        if (z6) {
            buildIdStates();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static XmlObject newValue(SchemaType schemaType, String str) {
        try {
            return schemaType.newValue(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSavePoint(ConstraintState constraintState) {
        ElementState elementState = this._elementStack;
        if (!elementState._hasConstraints) {
            elementState._savePoint = constraintState;
        }
        elementState._hasConstraints = true;
    }

    public void attr(ValidatorListener.Event event, QName qName, SchemaType schemaType, String str) {
        for (ConstraintState constraintState = this._constraintStack; constraintState != null; constraintState = constraintState._next) {
            constraintState.attr(event, qName, schemaType, str);
        }
    }

    public void element(ValidatorListener.Event event, SchemaType schemaType, SchemaIdentityConstraint[] schemaIdentityConstraintArr) {
        newState();
        for (ConstraintState constraintState = this._constraintStack; constraintState != null; constraintState = constraintState._next) {
            constraintState.element(event, schemaType);
        }
        for (int i5 = 0; schemaIdentityConstraintArr != null && i5 < schemaIdentityConstraintArr.length; i5++) {
            newConstraintState(schemaIdentityConstraintArr[i5], event, schemaType);
        }
    }

    public void endElement(ValidatorListener.Event event) {
        if (this._elementStack._hasConstraints) {
            for (ConstraintState constraintState = this._constraintStack; constraintState != null && constraintState != this._elementStack._savePoint; constraintState = constraintState._next) {
                constraintState.remove(event);
            }
            this._constraintStack = this._elementStack._savePoint;
        }
        this._elementStack = this._elementStack._next;
        for (ConstraintState constraintState2 = this._constraintStack; constraintState2 != null; constraintState2 = constraintState2._next) {
            constraintState2.endElement(event);
        }
    }

    public boolean isValid() {
        return !this._invalid;
    }

    public void text(ValidatorListener.Event event, SchemaType schemaType, String str, boolean z6) {
        for (ConstraintState constraintState = this._constraintStack; constraintState != null; constraintState = constraintState._next) {
            constraintState.text(event, schemaType, str, z6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emitError(ValidatorListener.Event event, String str) {
        this._invalid = true;
        Collection<XmlError> collection = this._errorListener;
        if (collection != null) {
            collection.add(errorForEvent(str, 0, event));
        }
    }

    public static XmlError errorForEvent(String str, int i5, ValidatorListener.Event event) {
        XmlCursor locationAsCursor = event.getLocationAsCursor();
        if (locationAsCursor != null) {
            return XmlError.forCursor(str, i5, locationAsCursor);
        }
        Location location = event.getLocation();
        if (location != null) {
            return XmlError.forLocation(str, i5, location.getSystemId(), location.getLineNumber(), location.getColumnNumber(), location.getCharacterOffset());
        }
        return XmlError.forMessage(str, i5);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class IdRefState extends ConstraintState {
        IdState _ids;
        List<XmlObjectList> _values;

        public IdRefState(IdState idState) {
            super();
            this._ids = idState;
            this._values = new ArrayList();
        }

        private void handleValue(ValidatorListener.Event event, SchemaType schemaType, String str) {
            if (str == null || schemaType == null || schemaType.isNoType()) {
                return;
            }
            SchemaType schemaType2 = XmlIDREFS.type;
            if (!schemaType2.isAssignableFrom(schemaType)) {
                if (XmlIDREF.type.isAssignableFrom(schemaType)) {
                    XmlObjectList xmlObjectList = new XmlObjectList(1);
                    XmlIDREF xmlIDREF = (XmlIDREF) schemaType.newValue(str);
                    if (xmlIDREF == null) {
                        return;
                    }
                    xmlObjectList.set(xmlIDREF, 0);
                    this._values.add(xmlObjectList);
                    return;
                }
                return;
            }
            XmlIDREFS xmlIDREFS = (XmlIDREFS) IdentityConstraint.newValue(schemaType2, str);
            if (xmlIDREFS == null) {
                return;
            }
            for (XmlAnySimpleType xmlAnySimpleType : xmlIDREFS.xgetListValue()) {
                XmlObjectList xmlObjectList2 = new XmlObjectList(1);
                xmlObjectList2.set(xmlAnySimpleType, 0);
                this._values.add(xmlObjectList2);
            }
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        public void attr(ValidatorListener.Event event, QName qName, SchemaType schemaType, String str) {
            handleValue(event, schemaType, str);
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        public void remove(ValidatorListener.Event event) {
            for (XmlObjectList xmlObjectList : this._values) {
                if (!this._ids._values.contains(xmlObjectList)) {
                    IdentityConstraint.this.emitError(event, "ID not found for IDRef value '" + xmlObjectList + "'");
                }
            }
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        public void text(ValidatorListener.Event event, SchemaType schemaType, String str, boolean z6) {
            if (z6) {
                return;
            }
            handleValue(event, schemaType, str);
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        public void endElement(ValidatorListener.Event event) {
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        public void element(ValidatorListener.Event event, SchemaType schemaType) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class IdState extends ConstraintState {
        Set<XmlObjectList> _values;

        public IdState() {
            super();
            this._values = new LinkedHashSet();
        }

        private void handleValue(ValidatorListener.Event event, SchemaType schemaType, String str) {
            if (str == null || schemaType == null || schemaType.isNoType()) {
                return;
            }
            SchemaType schemaType2 = XmlID.type;
            if (schemaType2.isAssignableFrom(schemaType)) {
                XmlObjectList xmlObjectList = new XmlObjectList(1);
                XmlObject xmlObjectNewValue = IdentityConstraint.newValue(schemaType2, str);
                if (xmlObjectNewValue == null) {
                    return;
                }
                xmlObjectList.set(xmlObjectNewValue, 0);
                if (this._values.contains(xmlObjectList)) {
                    IdentityConstraint.this.emitError(event, XmlErrorCodes.ID_VALID$DUPLICATE, new Object[]{str});
                } else {
                    this._values.add(xmlObjectList);
                }
            }
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        public void attr(ValidatorListener.Event event, QName qName, SchemaType schemaType, String str) {
            handleValue(event, schemaType, str);
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        public void text(ValidatorListener.Event event, SchemaType schemaType, String str, boolean z6) {
            if (z6) {
                return;
            }
            handleValue(event, schemaType, str);
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        public void endElement(ValidatorListener.Event event) {
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        public void remove(ValidatorListener.Event event) {
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        public void element(ValidatorListener.Event event, SchemaType schemaType) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class SelectorState extends ConstraintState {
        SchemaIdentityConstraint _constraint;
        XPathExecutionContext _context;
        Set<XmlObjectList> _values;

        public SelectorState(SchemaIdentityConstraint schemaIdentityConstraint, ValidatorListener.Event event, SchemaType schemaType) {
            super();
            this._values = new LinkedHashSet();
            this._constraint = schemaIdentityConstraint;
            XPathExecutionContext xPathExecutionContext = new XPathExecutionContext();
            this._context = xPathExecutionContext;
            xPathExecutionContext.init((XPath) this._constraint.getSelectorPath());
            if ((this._context.start() & 1) != 0) {
                createFieldState(event, schemaType);
            }
        }

        public void addFields(XmlObjectList xmlObjectList, ValidatorListener.Event event) {
            if (this._constraint.getConstraintCategory() == 2) {
                this._values.add(xmlObjectList);
                return;
            }
            if (!this._values.contains(xmlObjectList)) {
                this._values.add(xmlObjectList);
            } else if (this._constraint.getConstraintCategory() == 3) {
                IdentityConstraint.this.emitError(event, XmlErrorCodes.IDENTITY_CONSTRAINT_VALID$DUPLICATE_UNIQUE, new Object[]{xmlObjectList, QNameHelper.pretty(this._constraint.getName())});
            } else {
                IdentityConstraint.this.emitError(event, XmlErrorCodes.IDENTITY_CONSTRAINT_VALID$DUPLICATE_KEY, new Object[]{xmlObjectList, QNameHelper.pretty(this._constraint.getName())});
            }
        }

        public void createFieldState(ValidatorListener.Event event, SchemaType schemaType) {
            IdentityConstraint.this.new FieldState(this, event, schemaType);
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        public void element(ValidatorListener.Event event, SchemaType schemaType) {
            if ((this._context.element(event.getName()) & 1) != 0) {
                createFieldState(event, schemaType);
            }
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        public void endElement(ValidatorListener.Event event) {
            this._context.end();
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        public void remove(ValidatorListener.Event event) {
            for (ConstraintState constraintState = this._next; constraintState != null; constraintState = constraintState._next) {
                if (constraintState instanceof KeyrefState) {
                    KeyrefState keyrefState = (KeyrefState) constraintState;
                    if (keyrefState._constraint.getReferencedKey() == this._constraint) {
                        keyrefState.addKeyValues(this._values, true);
                    }
                }
            }
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        public void attr(ValidatorListener.Event event, QName qName, SchemaType schemaType, String str) {
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        public void text(ValidatorListener.Event event, SchemaType schemaType, String str, boolean z6) {
        }
    }
}
