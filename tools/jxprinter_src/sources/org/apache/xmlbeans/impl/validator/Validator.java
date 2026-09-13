package org.apache.xmlbeans.impl.validator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import javax.xml.namespace.QName;
import org.apache.poi.xwpf.usermodel.c;
import org.apache.xmlbeans.GDate;
import org.apache.xmlbeans.GDuration;
import org.apache.xmlbeans.SchemaAttributeModel;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaLocalAttribute;
import org.apache.xmlbeans.SchemaLocalElement;
import org.apache.xmlbeans.SchemaParticle;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlValidationError;
import org.apache.xmlbeans.impl.common.IdentityConstraint;
import org.apache.xmlbeans.impl.common.InvalidLexicalValueException;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.common.ValidatorListener;
import org.apache.xmlbeans.impl.common.XmlWhitespace;
import org.apache.xmlbeans.impl.schema.SchemaTypeImpl;
import org.apache.xmlbeans.impl.schema.SchemaTypeVisitorImpl;
import org.apache.xmlbeans.impl.util.XsTypeConverter;
import org.apache.xmlbeans.impl.values.JavaBase64Holder;
import org.apache.xmlbeans.impl.values.JavaBase64HolderEx;
import org.apache.xmlbeans.impl.values.JavaBooleanHolder;
import org.apache.xmlbeans.impl.values.JavaBooleanHolderEx;
import org.apache.xmlbeans.impl.values.JavaDecimalHolderEx;
import org.apache.xmlbeans.impl.values.JavaDoubleHolderEx;
import org.apache.xmlbeans.impl.values.JavaFloatHolderEx;
import org.apache.xmlbeans.impl.values.JavaGDateHolderEx;
import org.apache.xmlbeans.impl.values.JavaGDurationHolderEx;
import org.apache.xmlbeans.impl.values.JavaHexBinaryHolder;
import org.apache.xmlbeans.impl.values.JavaHexBinaryHolderEx;
import org.apache.xmlbeans.impl.values.JavaNotationHolderEx;
import org.apache.xmlbeans.impl.values.JavaQNameHolder;
import org.apache.xmlbeans.impl.values.JavaQNameHolderEx;
import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;
import org.apache.xmlbeans.impl.values.JavaUriHolderEx;
import org.apache.xmlbeans.impl.values.NamespaceContext;
import org.apache.xmlbeans.impl.values.TypeStoreVisitor;
import org.apache.xmlbeans.impl.values.XmlListImpl;
import org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class Validator implements ValidatorListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private boolean _booleanValue;
    private byte[] _byteArrayValue;
    private final IdentityConstraint _constraintEngine;
    private BigDecimal _decimalValue;
    private double _doubleValue;
    private int _eatContent;
    private Collection<XmlError> _errorListener;
    private int _errorState;
    private float _floatValue;
    private GDate _gdateValue;
    private GDuration _gdurationValue;
    private final SchemaTypeLoader _globalTypes;
    private boolean _invalid;
    private List<SchemaType> _listTypes;
    private List<Object> _listValue;
    private SchemaLocalAttribute _localAttribute;
    private SchemaLocalElement _localElement;
    private QName _qnameValue;
    private final SchemaField _rootField;
    private final SchemaType _rootType;
    private State _stateStack;
    private final boolean _strict;
    private String _stringValue;
    private int _suspendErrors;
    private final boolean _treatLaxAsSkip;
    private SchemaType _unionType;
    private final ValidatorVC _vc;
    private final LinkedList<TypeStoreVisitor> _visitorPool = new LinkedList<>();
    private SchemaAttributeModel _wildcardAttribute;
    private SchemaParticle _wildcardElement;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class State {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        SchemaAttributeModel _attrModel;
        HashSet<QName> _attrs;
        boolean _canHaveAttrs;
        boolean _canHaveElements;
        boolean _canHaveMixedContent;
        SchemaField _field;
        boolean _hasSimpleContent;
        boolean _isEmpty;
        boolean _isNil;
        State _next;
        boolean _sawText;
        SchemaType _type;
        SchemaTypeVisitorImpl _visitor;

        private State() {
        }

        public SchemaParticle currentParticle() {
            return this._visitor.currentParticle();
        }

        public boolean end() {
            return !this._canHaveElements || this._visitor.visit(null);
        }

        public boolean test(QName qName) {
            return this._canHaveElements && this._visitor.testValid(qName);
        }

        public boolean visit(QName qName) {
            return this._canHaveElements && this._visitor.visit(qName);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class ValidatorVC implements ValidationContext {
        ValidatorListener.Event _event;

        private ValidatorVC() {
        }

        @Override // org.apache.xmlbeans.impl.common.ValidationContext
        public void invalid(String str) {
            Validator.this.emitError(this._event, str, null, null, 1001);
        }

        @Override // org.apache.xmlbeans.impl.common.ValidationContext
        public void invalid(String str, Object[] objArr) {
            Validator.this.emitError(this._event, str, objArr, null, null, 1001, null);
        }
    }

    public Validator(SchemaType schemaType, SchemaField schemaField, SchemaTypeLoader schemaTypeLoader, XmlOptions xmlOptions, Collection<XmlError> collection) {
        XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
        this._errorListener = xmlOptionsMaskNull.getErrorListener();
        this._treatLaxAsSkip = xmlOptionsMaskNull.isValidateTreatLaxAsSkip();
        this._strict = xmlOptionsMaskNull.isValidateStrict();
        if (this._errorListener == null) {
            this._errorListener = collection;
        }
        this._constraintEngine = new IdentityConstraint(this._errorListener, schemaType.isDocumentType());
        this._globalTypes = schemaTypeLoader;
        this._rootType = schemaType;
        this._rootField = schemaField;
        this._vc = new ValidatorVC();
    }

    private void addToList(SchemaType schemaType) {
        if (schemaType.getSimpleVariety() == 1 || schemaType.getSimpleVariety() == 2) {
            if (schemaType.getUnionMemberTypes().length > 0 && getUnionType() != null) {
                schemaType = getUnionType();
                this._unionType = null;
            }
            this._listTypes.add(schemaType);
            if (schemaType.getPrimitiveType() == null) {
                this._listValue.add(null);
                return;
            }
            switch (schemaType.getPrimitiveType().getBuiltinTypeCode()) {
                case 2:
                case 6:
                    this._listValue.add(this._stringValue);
                    return;
                case 3:
                    this._listValue.add(this._booleanValue ? Boolean.TRUE : Boolean.FALSE);
                    this._booleanValue = false;
                    return;
                case 4:
                case 5:
                    this._listValue.add(this._byteArrayValue);
                    this._byteArrayValue = null;
                    return;
                case 7:
                case 8:
                    this._listValue.add(this._qnameValue);
                    this._qnameValue = null;
                    return;
                case 9:
                    this._listValue.add(Float.valueOf(this._floatValue));
                    this._floatValue = 0.0f;
                    return;
                case 10:
                    this._listValue.add(Double.valueOf(this._doubleValue));
                    this._doubleValue = 0.0d;
                    return;
                case 11:
                    this._listValue.add(this._decimalValue);
                    this._decimalValue = null;
                    return;
                case 12:
                    this._listValue.add(this._stringValue);
                    this._stringValue = null;
                    return;
                case 13:
                    this._listValue.add(this._gdurationValue);
                    this._gdurationValue = null;
                    return;
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                    this._listValue.add(this._gdateValue);
                    this._gdateValue = null;
                    return;
                default:
                    throw new RuntimeException("Unexpected primitive type code");
            }
        }
    }

    private void attrEvent(ValidatorListener.Event event) {
        QName name = event.getName();
        State state = topState();
        if (state._attrs == null) {
            state._attrs = new HashSet<>();
        }
        if (state._attrs.contains(name)) {
            emitFieldError(event, XmlErrorCodes.XML_DUPLICATE_ATTRIBUTE, new Object[]{QNameHelper.pretty(name)}, name, null, null, 1000, state._type);
            return;
        }
        state._attrs.add(name);
        if (!state._canHaveAttrs) {
            emitFieldError(event, XmlErrorCodes.ELEM_COMPLEX_TYPE_LOCALLY_VALID$NO_WILDCARD, new Object[]{QNameHelper.pretty(name)}, name, null, null, 1000, state._type);
            return;
        }
        SchemaAttributeModel schemaAttributeModel = state._attrModel;
        SchemaLocalAttribute attribute = schemaAttributeModel == null ? null : schemaAttributeModel.getAttribute(name);
        if (attribute != null) {
            this._localAttribute = attribute;
            if (attribute.getUse() == 1) {
                emitFieldError(event, XmlErrorCodes.ELEM_COMPLEX_TYPE_LOCALLY_VALID$PROHIBITED_ATTRIBUTE, new Object[]{QNameHelper.pretty(name)}, name, null, null, 1000, state._type);
                return;
            } else {
                this._constraintEngine.attr(event, name, attribute.getType(), validateSimpleType(attribute.getType(), attribute, event, false, false));
                return;
            }
        }
        int wildcardProcess = state._attrModel.getWildcardProcess();
        SchemaAttributeModel schemaAttributeModel2 = state._attrModel;
        this._wildcardAttribute = schemaAttributeModel2;
        if (wildcardProcess == 0) {
            emitFieldError(event, XmlErrorCodes.ELEM_COMPLEX_TYPE_LOCALLY_VALID$NO_WILDCARD, new Object[]{QNameHelper.pretty(name)}, name, null, null, 1000, state._type);
            return;
        }
        if (!schemaAttributeModel2.getWildcardSet().contains(name)) {
            emitFieldError(event, XmlErrorCodes.ELEM_COMPLEX_TYPE_LOCALLY_VALID$NOT_WILDCARD_VALID, new Object[]{QNameHelper.pretty(name)}, name, null, null, 1000, state._type);
            return;
        }
        if (wildcardProcess != 3) {
            if (wildcardProcess == 2 && this._treatLaxAsSkip) {
                return;
            }
            SchemaGlobalAttribute schemaGlobalAttributeFindAttribute = this._globalTypes.findAttribute(name);
            this._localAttribute = schemaGlobalAttributeFindAttribute;
            if (schemaGlobalAttributeFindAttribute != null) {
                this._constraintEngine.attr(event, name, schemaGlobalAttributeFindAttribute.getType(), validateSimpleType(schemaGlobalAttributeFindAttribute.getType(), schemaGlobalAttributeFindAttribute, event, false, false));
            } else {
                if (wildcardProcess == 2) {
                    return;
                }
                emitFieldError(event, XmlErrorCodes.ASSESS_ATTR_SCHEMA_VALID$NOT_RESOLVED, new Object[]{QNameHelper.pretty(name)}, name, null, null, 1000, state._type);
            }
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void beginEvent(ValidatorListener.Event event) {
        ValidatorListener.Event event2;
        SchemaField schemaField;
        SchemaType type;
        SchemaField schemaField2;
        ValidatorListener.Event event3;
        SchemaType schemaType;
        boolean zValidateLexical;
        ValidatorListener.Event event4;
        this._localElement = null;
        this._wildcardElement = null;
        State state = topState();
        boolean z6 = false;
        if (state == null) {
            type = this._rootType;
            schemaField2 = this._rootField;
        } else {
            QName name = event.getName();
            state._isEmpty = false;
            if (state._isNil) {
                QName name2 = state._field.getName();
                SchemaType schemaType2 = state._type;
                emitFieldError(event, XmlErrorCodes.ELEM_LOCALLY_VALID$NIL_WITH_CONTENT, null, name2, schemaType2, null, 4, schemaType2);
                this._eatContent = 1;
                return;
            }
            SchemaField schemaField3 = state._field;
            if (schemaField3 == null || !schemaField3.isFixed()) {
                event2 = event;
            } else {
                Object[] objArr = {QNameHelper.pretty(state._field.getName())};
                QName name3 = state._field.getName();
                SchemaType schemaType3 = state._type;
                event2 = event;
                emitFieldError(event2, XmlErrorCodes.ELEM_LOCALLY_VALID$FIXED_WITH_CONTENT, objArr, name3, schemaType3, null, 2, schemaType3);
            }
            if (!state.visit(name)) {
                findDetailedErrorBegin(event2, state, name);
                this._eatContent = 1;
                return;
            }
            SchemaParticle schemaParticleCurrentParticle = state.currentParticle();
            this._wildcardElement = schemaParticleCurrentParticle;
            if (schemaParticleCurrentParticle.getParticleType() == 5) {
                if (!schemaParticleCurrentParticle.getWildcardSet().contains(name)) {
                    emitFieldError(event2, XmlErrorCodes.PARTICLE_VALID$NOT_WILDCARD_VALID, new Object[]{QNameHelper.pretty(name)}, name, null, null, 2, state._type);
                    this._eatContent = 1;
                    return;
                }
                int wildcardProcess = schemaParticleCurrentParticle.getWildcardProcess();
                if (wildcardProcess == 3 || (wildcardProcess == 2 && this._treatLaxAsSkip)) {
                    this._eatContent = 1;
                    return;
                }
                SchemaGlobalElement schemaGlobalElementFindElement = this._globalTypes.findElement(name);
                this._localElement = schemaGlobalElementFindElement;
                schemaField = schemaGlobalElementFindElement;
                if (schemaGlobalElementFindElement == null) {
                    if (wildcardProcess == 1) {
                        Object[] objArr2 = {QNameHelper.pretty(name)};
                        SchemaType schemaType4 = state._type;
                        emitFieldError(event, XmlErrorCodes.ASSESS_ELEM_SCHEMA_VALID$NOT_RESOLVED, objArr2, name, schemaType4, null, 2, schemaType4);
                    }
                    this._eatContent = 1;
                    return;
                }
            } else if (schemaParticleCurrentParticle.getName().equals(name)) {
                schemaField = (SchemaField) schemaParticleCurrentParticle;
            } else {
                if (((SchemaLocalElement) schemaParticleCurrentParticle).blockSubstitution()) {
                    Object[] objArr3 = {QNameHelper.pretty(name)};
                    SchemaType schemaType5 = state._type;
                    emitFieldError(event, XmlErrorCodes.PARTICLE_VALID$BLOCK_SUBSTITUTION, objArr3, name, schemaType5, null, 2, schemaType5);
                    this._eatContent = 1;
                    return;
                }
                SchemaGlobalElement schemaGlobalElementFindElement2 = this._globalTypes.findElement(name);
                this._localElement = schemaGlobalElementFindElement2;
                schemaField = schemaGlobalElementFindElement2;
            }
            type = schemaField.getType();
            schemaField2 = schemaField;
        }
        SchemaType schemaType6 = type;
        SchemaField schemaField4 = schemaField2;
        if (schemaType6.isNoType()) {
            event3 = event;
            emitFieldError(event3, XmlErrorCodes.ELEM_LOCALLY_VALID$NO_TYPE, null, event.getName(), null, null, 3, null);
            this._eatContent = 1;
        } else {
            event3 = event;
        }
        String xsiType = event3.getXsiType();
        if (xsiType != null) {
            int i5 = this._errorState;
            this._suspendErrors++;
            try {
                try {
                    ValidatorVC validatorVC = this._vc;
                    validatorVC._event = null;
                    SchemaType schemaTypeFindType = this._globalTypes.findType(JavaQNameHolder.validateLexical(xsiType, validatorVC, event3));
                    this._suspendErrors--;
                    schemaType = schemaTypeFindType;
                } catch (Throwable th) {
                    this._suspendErrors--;
                    throw th;
                }
            } catch (Throwable unused) {
                this._errorState++;
                this._suspendErrors--;
                schemaType = null;
            }
            if (i5 != this._errorState) {
                emitFieldError(event3, XmlErrorCodes.ELEM_LOCALLY_VALID$XSI_TYPE_INVALID_QNAME, new Object[]{xsiType}, event3.getName(), schemaType, null, 3, state != null ? state._type : null);
                this._eatContent = 1;
                return;
            } else if (schemaType == null) {
                emitFieldError(event, XmlErrorCodes.ELEM_LOCALLY_VALID$XSI_TYPE_NOT_FOUND, new Object[]{xsiType}, event.getName(), null, null, 3, null);
                this._eatContent = 1;
                return;
            }
        } else {
            schemaType = null;
        }
        if (schemaType == null || schemaType.equals(schemaType6)) {
            schemaType = schemaType6;
        } else {
            if (!schemaType6.isAssignableFrom(schemaType)) {
                emitFieldError(event, XmlErrorCodes.ELEM_LOCALLY_VALID$XSI_TYPE_NOT_DERIVED, new Object[]{schemaType, schemaType6}, event.getName(), schemaType6, null, 3, state != null ? state._type : null);
                this._eatContent = 1;
                return;
            }
            if (schemaType6.blockExtension()) {
                for (SchemaType baseType = schemaType; !baseType.equals(schemaType6); baseType = baseType.getBaseType()) {
                    if (baseType.getDerivationType() == 2) {
                        emitFieldError(event, XmlErrorCodes.ELEM_LOCALLY_VALID$XSI_TYPE_BLOCK_EXTENSION, new Object[]{schemaType, schemaType6}, event.getName(), schemaType6, null, 3, state != null ? state._type : null);
                        this._eatContent = 1;
                        return;
                    }
                }
            }
            if (schemaType6.blockRestriction()) {
                for (SchemaType baseType2 = schemaType; !baseType2.equals(schemaType6); baseType2 = baseType2.getBaseType()) {
                    if (baseType2.getDerivationType() == 1) {
                        emitFieldError(event, XmlErrorCodes.ELEM_LOCALLY_VALID$XSI_TYPE_BLOCK_RESTRICTION, new Object[]{schemaType, schemaType6}, event.getName(), schemaType6, null, 3, state != null ? state._type : null);
                        this._eatContent = 1;
                        return;
                    }
                }
            }
            if (schemaField4 instanceof SchemaLocalElement) {
                SchemaLocalElement schemaLocalElement = (SchemaLocalElement) schemaField4;
                this._localElement = schemaLocalElement;
                if (schemaLocalElement.blockExtension() || schemaLocalElement.blockRestriction()) {
                    for (SchemaType baseType3 = schemaType; !baseType3.equals(schemaType6); baseType3 = baseType3.getBaseType()) {
                        if ((baseType3.getDerivationType() == 1 && schemaLocalElement.blockRestriction()) || (baseType3.getDerivationType() == 2 && schemaLocalElement.blockExtension())) {
                            emitFieldError(event, XmlErrorCodes.ELEM_LOCALLY_VALID$XSI_TYPE_PROHIBITED_SUBST, new Object[]{schemaType, QNameHelper.pretty(schemaLocalElement.getName())}, schemaLocalElement.getName(), null, null, 3, null);
                            this._eatContent = 1;
                            return;
                        }
                    }
                }
            }
        }
        boolean z7 = schemaField4 instanceof SchemaLocalElement;
        if (z7) {
            SchemaLocalElement schemaLocalElement2 = (SchemaLocalElement) schemaField4;
            this._localElement = schemaLocalElement2;
            if (schemaLocalElement2.isAbstract()) {
                emitError(event, XmlErrorCodes.ELEM_LOCALLY_VALID$ABSTRACT, new Object[]{QNameHelper.pretty(schemaLocalElement2.getName())}, schemaLocalElement2.getName(), null, 3, null);
                this._eatContent = 1;
                return;
            }
        }
        if (schemaType.isAbstract()) {
            emitError(event, XmlErrorCodes.ELEM_LOCALLY_VALID$ABSTRACT, new Object[]{schemaType}, event.getName(), schemaType, 3, state != null ? state._type : null);
            this._eatContent = 1;
            return;
        }
        String xsiNil = event.getXsiNil();
        if (xsiNil != null) {
            ValidatorVC validatorVC2 = this._vc;
            validatorVC2._event = event;
            zValidateLexical = JavaBooleanHolder.validateLexical(xsiNil, validatorVC2);
            z6 = true;
        } else {
            zValidateLexical = false;
        }
        if (z6 && (schemaField4 == null || !schemaField4.isNillable())) {
            emitFieldError(event, XmlErrorCodes.ELEM_LOCALLY_VALID$NOT_NILLABLE, null, schemaField4 == null ? null : schemaField4.getName(), schemaType, null, 3, state != null ? state._type : null);
            this._eatContent = 1;
            return;
        }
        if (zValidateLexical && schemaField4 != null && schemaField4.isFixed()) {
            event4 = event;
            emitFieldError(event4, XmlErrorCodes.ELEM_LOCALLY_VALID$NIL_WITH_FIXED, null, schemaField4.getName(), schemaType, null, 3, state == null ? null : state._type);
        } else {
            event4 = event;
        }
        newState(schemaType, schemaField4, zValidateLexical);
        this._constraintEngine.element(event4, schemaType, z7 ? ((SchemaLocalElement) schemaField4).getIdentityConstraints() : null);
    }

    private boolean derivedFromInteger(SchemaType schemaType) {
        int builtinTypeCode = schemaType.getBuiltinTypeCode();
        while (builtinTypeCode == 0) {
            schemaType = schemaType.getBaseType();
            builtinTypeCode = schemaType.getBuiltinTypeCode();
        }
        return builtinTypeCode >= 22 && builtinTypeCode <= 34;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emitError(ValidatorListener.Event event, String str, QName qName, SchemaType schemaType, int i5) {
        emitError(event, str, null, null, 0, null, qName, schemaType, null, i5, null);
    }

    private void emitFieldError(ValidatorListener.Event event, String str, Object[] objArr, QName qName, SchemaType schemaType, List<QName> list, int i5, SchemaType schemaType2) {
        SchemaField schemaField;
        State state = this._stateStack;
        emitError(event, null, str, objArr, 0, (state == null || (schemaField = state._field) == null) ? null : schemaField.getName(), qName, schemaType, list, i5, schemaType2);
    }

    private void endAttrsEvent(ValidatorListener.Event event) {
        State state = topState();
        SchemaAttributeModel schemaAttributeModel = state._attrModel;
        if (schemaAttributeModel != null) {
            for (SchemaLocalAttribute schemaLocalAttribute : schemaAttributeModel.getAttributes()) {
                HashSet<QName> hashSet = state._attrs;
                if (hashSet == null || !hashSet.contains(schemaLocalAttribute.getName())) {
                    if (schemaLocalAttribute.getUse() == 3) {
                        emitFieldError(event, XmlErrorCodes.ELEM_COMPLEX_TYPE_LOCALLY_VALID$MISSING_REQUIRED_ATTRIBUTE, new Object[]{QNameHelper.pretty(schemaLocalAttribute.getName())}, schemaLocalAttribute.getName(), null, null, 1000, state._type);
                    } else if (schemaLocalAttribute.isDefault() || schemaLocalAttribute.isFixed()) {
                        this._constraintEngine.attr(event, schemaLocalAttribute.getName(), schemaLocalAttribute.getType(), schemaLocalAttribute.getDefaultText());
                    }
                }
            }
        }
    }

    private void endEvent(ValidatorListener.Event event) {
        this._localElement = null;
        this._wildcardElement = null;
        State state = topState();
        if (!state._isNil) {
            if (!state.end()) {
                findDetailedErrorEnd(event, state);
            }
            if (state._isEmpty) {
                handleText(event, true, state._field);
            }
        }
        popState(event);
        this._constraintEngine.endElement(event);
    }

    private void findDetailedErrorBegin(ValidatorListener.Event event, State state, QName qName) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (SchemaProperty schemaProperty : state._type.getElementProperties()) {
            if (state.test(schemaProperty.getName())) {
                if (BigInteger.ZERO.compareTo(schemaProperty.getMinOccurs()) == 0) {
                    arrayList2.add(schemaProperty.getName());
                } else {
                    arrayList.add(schemaProperty.getName());
                }
            }
        }
        List<QName> list = arrayList.size() > 0 ? arrayList : arrayList2;
        if (list.size() > 0) {
            emitFieldError(event, XmlErrorCodes.ELEM_COMPLEX_TYPE_LOCALLY_VALID$EXPECTED_DIFFERENT_ELEMENT, new Object[]{Integer.valueOf(list.size()), (String) list.stream().map(new c(10)).collect(Collectors.joining(" ")), QNameHelper.pretty(qName)}, qName, null, list, 1, state._type);
        } else {
            emitFieldError(event, XmlErrorCodes.ELEM_COMPLEX_TYPE_LOCALLY_VALID$ELEMENT_NOT_ALLOWED, new Object[]{QNameHelper.pretty(qName)}, qName, null, null, 1, state._type);
        }
    }

    private void findDetailedErrorEnd(ValidatorListener.Event event, State state) {
        SchemaProperty[] elementProperties = state._type.getElementProperties();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (SchemaProperty schemaProperty : elementProperties) {
            if (state.test(schemaProperty.getName())) {
                if (BigInteger.ZERO.compareTo(schemaProperty.getMinOccurs()) == 0) {
                    arrayList2.add(schemaProperty.getName());
                } else {
                    arrayList.add(schemaProperty.getName());
                }
            }
        }
        List<QName> list = arrayList.size() > 0 ? arrayList : arrayList2;
        if (list.size() > 0) {
            emitFieldError(event, XmlErrorCodes.ELEM_COMPLEX_TYPE_LOCALLY_VALID$MISSING_ELEMENT, new Object[]{Integer.valueOf(list.size()), (String) list.stream().map(new c(10)).collect(Collectors.joining(" "))}, null, null, list, 1, state._type);
        } else {
            emitFieldError(event, XmlErrorCodes.ELEM_COMPLEX_TYPE_LOCALLY_VALID$EXPECTED_ELEMENT, null, null, null, null, 2, state._type);
        }
    }

    private void handleText(ValidatorListener.Event event, boolean z6, SchemaField schemaField) {
        Validator validator;
        ValidatorListener.Event event2;
        SchemaField schemaField2;
        String str;
        State state = topState();
        if (state._sawText) {
            validator = this;
            event2 = event;
            schemaField2 = schemaField;
        } else if (state._hasSimpleContent) {
            validator = this;
            schemaField2 = schemaField;
            event2 = event;
            validator._constraintEngine.text(event2, state._type, validator.validateSimpleType(state._type, schemaField2, event, z6, true), false);
        } else {
            validator = this;
            event2 = event;
            schemaField2 = schemaField;
            if (state._canHaveMixedContent) {
                SchemaType schemaType = XmlString.type;
                validator._constraintEngine.text(event2, schemaType, validator.validateSimpleType(schemaType, schemaField2, event2, z6, true), false);
            } else if (z6) {
                validator._constraintEngine.text(event2, state._type, null, true);
            } else {
                validator._constraintEngine.text(event2, state._type, "", false);
            }
        }
        if (!z6) {
            z6 = z6;
            z6 = z6;
            event2 = event2;
            z6 = z6;
            if (!state._canHaveMixedContent && !event2.textIsWhitespace() && !state._hasSimpleContent) {
                if (schemaField2 instanceof SchemaLocalElement) {
                    SchemaLocalElement schemaLocalElement = (SchemaLocalElement) schemaField2;
                    if (state._type.getContentType() == 1) {
                        z6 = z6;
                        str = XmlErrorCodes.ELEM_COMPLEX_TYPE_LOCALLY_VALID$EMPTY_WITH_CONTENT;
                    } else {
                        z6 = z6;
                        str = XmlErrorCodes.ELEM_COMPLEX_TYPE_LOCALLY_VALID$ELEMENT_ONLY_WITH_TEXT;
                    }
                    validator.emitError(event2, str, new Object[]{QNameHelper.pretty(schemaLocalElement.getName())}, schemaLocalElement.getName(), schemaField2.getType(), 3, null);
                } else {
                    z6 = z6;
                    emitError(event2, "Can't have mixed content", event2.getName(), state._type, 3);
                }
            }
        }
        if (z6) {
            return;
        }
        state._sawText = true;
    }

    private SchemaTypeVisitorImpl initVisitor(SchemaParticle schemaParticle) {
        if (this._visitorPool.isEmpty()) {
            return new SchemaTypeVisitorImpl(schemaParticle);
        }
        SchemaTypeVisitorImpl schemaTypeVisitorImpl = (SchemaTypeVisitorImpl) this._visitorPool.removeLast();
        schemaTypeVisitorImpl.init(schemaParticle);
        return schemaTypeVisitorImpl;
    }

    private void newState(SchemaType schemaType, SchemaField schemaField, boolean z6) {
        State state = new State();
        state._type = schemaType;
        state._field = schemaField;
        state._isEmpty = true;
        state._isNil = z6;
        if (schemaType.isSimpleType()) {
            state._hasSimpleContent = true;
        } else {
            state._canHaveAttrs = true;
            state._attrModel = schemaType.getAttributeModel();
            int contentType = schemaType.getContentType();
            if (contentType != 1) {
                if (contentType != 2) {
                    if (contentType != 3) {
                        if (contentType != 4) {
                            throw new RuntimeException("Unexpected content type");
                        }
                        state._canHaveMixedContent = true;
                    }
                    SchemaParticle contentModel = schemaType.getContentModel();
                    boolean z7 = contentModel != null;
                    state._canHaveElements = z7;
                    if (z7) {
                        state._visitor = initVisitor(contentModel);
                    }
                } else {
                    state._hasSimpleContent = true;
                }
            }
        }
        pushState(state);
    }

    private void poolVisitor(SchemaTypeVisitorImpl schemaTypeVisitorImpl) {
        this._visitorPool.add(schemaTypeVisitorImpl);
    }

    private void popState(ValidatorListener.Event event) {
        SchemaTypeVisitorImpl schemaTypeVisitorImpl = this._stateStack._visitor;
        if (schemaTypeVisitorImpl != null) {
            poolVisitor(schemaTypeVisitorImpl);
            this._stateStack._visitor = null;
        }
        this._stateStack = this._stateStack._next;
    }

    private void pushState(State state) {
        state._next = this._stateStack;
        this._stateStack = state;
    }

    private void resetValues() {
        this._localAttribute = null;
        this._wildcardAttribute = null;
        this._stringValue = null;
        this._decimalValue = null;
        this._booleanValue = false;
        this._floatValue = 0.0f;
        this._doubleValue = 0.0d;
        this._qnameValue = null;
        this._gdateValue = null;
        this._gdurationValue = null;
        this._byteArrayValue = null;
        this._listValue = null;
        this._listTypes = null;
        this._unionType = null;
    }

    private void textEvent(ValidatorListener.Event event) {
        State state = topState();
        if (state._isNil) {
            QName name = state._field.getName();
            SchemaType schemaType = state._type;
            emitFieldError(event, XmlErrorCodes.ELEM_LOCALLY_VALID$NIL_WITH_CONTENT, null, name, schemaType, null, 4, schemaType);
        } else {
            handleText(event, false, state._field);
        }
        state._isEmpty = false;
    }

    private State topState() {
        return this._stateStack;
    }

    private void validateAtomicType(SchemaType schemaType, String str, ValidatorListener.Event event) {
        int i5 = this._errorState;
        this._vc._event = event;
        switch (schemaType.getPrimitiveType().getBuiltinTypeCode()) {
            case 2:
                this._stringValue = str;
                return;
            case 3:
                this._booleanValue = JavaBooleanHolderEx.validateLexical(str, schemaType, this._vc);
                return;
            case 4:
                byte[] bArrValidateLexical = JavaBase64Holder.validateLexical(str, schemaType, this._vc);
                if (bArrValidateLexical != null) {
                    JavaBase64HolderEx.validateValue(bArrValidateLexical, schemaType, this._vc);
                }
                this._byteArrayValue = bArrValidateLexical;
                return;
            case 5:
                byte[] bArrValidateLexical2 = JavaHexBinaryHolder.validateLexical(str, schemaType, this._vc);
                if (bArrValidateLexical2 != null) {
                    JavaHexBinaryHolderEx.validateValue(bArrValidateLexical2, schemaType, this._vc);
                }
                this._byteArrayValue = bArrValidateLexical2;
                return;
            case 6:
                JavaUriHolderEx.validateLexical(str, schemaType, this._vc);
                if (this._strict) {
                    try {
                        XsTypeConverter.lexAnyURI(str);
                    } catch (InvalidLexicalValueException unused) {
                        this._vc.invalid(XmlErrorCodes.ANYURI, new Object[]{str});
                    }
                    break;
                }
                this._stringValue = str;
                return;
            case 7:
                QName qNameValidateLexical = JavaQNameHolderEx.validateLexical(str, schemaType, this._vc, event);
                if (i5 == this._errorState) {
                    JavaQNameHolderEx.validateValue(qNameValidateLexical, schemaType, this._vc);
                }
                this._qnameValue = qNameValidateLexical;
                return;
            case 8:
                QName qNameValidateLexical2 = JavaNotationHolderEx.validateLexical(str, schemaType, this._vc, event);
                if (i5 == this._errorState) {
                    JavaNotationHolderEx.validateValue(qNameValidateLexical2, schemaType, this._vc);
                }
                this._qnameValue = qNameValidateLexical2;
                return;
            case 9:
                float fValidateLexical = JavaFloatHolderEx.validateLexical(str, schemaType, this._vc);
                if (i5 == this._errorState) {
                    JavaFloatHolderEx.validateValue(fValidateLexical, schemaType, this._vc);
                }
                this._floatValue = fValidateLexical;
                return;
            case 10:
                double dValidateLexical = JavaDoubleHolderEx.validateLexical(str, schemaType, this._vc);
                if (i5 == this._errorState) {
                    JavaDoubleHolderEx.validateValue(dValidateLexical, schemaType, this._vc);
                }
                this._doubleValue = dValidateLexical;
                return;
            case 11:
                JavaDecimalHolderEx.validateLexical(str, schemaType, this._vc);
                if (derivedFromInteger(schemaType) && str.lastIndexOf(46) >= 0) {
                    this._vc.invalid("integer", new Object[]{str});
                }
                if (i5 == this._errorState) {
                    BigDecimal bigDecimal = new BigDecimal(str);
                    this._decimalValue = bigDecimal;
                    JavaDecimalHolderEx.validateValue(bigDecimal, schemaType, this._vc);
                    return;
                }
                return;
            case 12:
                JavaStringEnumerationHolderEx.validateLexical(str, schemaType, this._vc);
                this._stringValue = str;
                return;
            case 13:
                GDuration gDurationValidateLexical = JavaGDurationHolderEx.validateLexical(str, schemaType, this._vc);
                if (gDurationValidateLexical != null) {
                    JavaGDurationHolderEx.validateValue(gDurationValidateLexical, schemaType, this._vc);
                }
                this._gdurationValue = gDurationValidateLexical;
                return;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
                break;
            case 21:
                if (this._strict && str.length() == 6 && str.charAt(4) == '-' && str.charAt(5) == '-') {
                    this._vc.invalid(XmlErrorCodes.DATE, new Object[]{str});
                }
                break;
            default:
                throw new RuntimeException("Unexpected primitive type code");
        }
        GDate gDateValidateLexical = JavaGDateHolderEx.validateLexical(str, schemaType, this._vc);
        if (gDateValidateLexical != null) {
            JavaGDateHolderEx.validateValue(gDateValidateLexical, schemaType, this._vc);
        }
        this._gdateValue = gDateValidateLexical;
    }

    private void validateListType(SchemaType schemaType, String str, ValidatorListener.Event event) {
        int intValue;
        int intValue2;
        int intValue3;
        int i5 = this._errorState;
        if (!schemaType.matchPatternFacet(str)) {
            emitError(event, XmlErrorCodes.DATATYPE_VALID$PATTERN_VALID, new Object[]{XmlErrorCodes.LIST, str, QNameHelper.readable(schemaType)}, null, schemaType, 2000, null);
        }
        String[] strArrSplit_list = XmlListImpl.split_list(str);
        XmlAnySimpleType facet = schemaType.getFacet(0);
        if (facet != null && (intValue3 = ((SimpleValue) facet).getIntValue()) != strArrSplit_list.length) {
            emitError(event, XmlErrorCodes.DATATYPE_LENGTH_VALID$LIST_LENGTH, new Object[]{str, Integer.valueOf(strArrSplit_list.length), Integer.valueOf(intValue3), QNameHelper.readable(schemaType)}, null, schemaType, 2000, null);
        }
        XmlAnySimpleType facet2 = schemaType.getFacet(1);
        if (facet2 != null && (intValue2 = ((SimpleValue) facet2).getIntValue()) > strArrSplit_list.length) {
            emitError(event, XmlErrorCodes.DATATYPE_LENGTH_VALID$LIST_LENGTH, new Object[]{str, Integer.valueOf(strArrSplit_list.length), Integer.valueOf(intValue2), QNameHelper.readable(schemaType)}, null, schemaType, 2000, null);
        }
        XmlAnySimpleType facet3 = schemaType.getFacet(2);
        if (facet3 != null && (intValue = ((SimpleValue) facet3).getIntValue()) < strArrSplit_list.length) {
            emitError(event, XmlErrorCodes.DATATYPE_LENGTH_VALID$LIST_LENGTH, new Object[]{str, Integer.valueOf(strArrSplit_list.length), Integer.valueOf(intValue), QNameHelper.readable(schemaType)}, null, schemaType, 2000, null);
        }
        SchemaType listItemType = schemaType.getListItemType();
        this._listValue = new ArrayList();
        this._listTypes = new ArrayList();
        for (String str2 : strArrSplit_list) {
            validateSimpleType(listItemType, str2, event);
            addToList(listItemType);
        }
        if (i5 != this._errorState || schemaType.getEnumerationValues() == null) {
            return;
        }
        NamespaceContext.push(new NamespaceContext(event));
        try {
            ((SchemaTypeImpl) schemaType).newValidatingValue(str);
        } catch (XmlValueOutOfRangeException unused) {
            emitError(event, XmlErrorCodes.DATATYPE_ENUM_VALID, new Object[]{XmlErrorCodes.LIST, str, QNameHelper.readable(schemaType)}, null, schemaType, 2000, null);
        } finally {
            NamespaceContext.pop();
        }
    }

    private String validateSimpleType(SchemaType schemaType, SchemaField schemaField, ValidatorListener.Event event, boolean z6, boolean z7) {
        String text;
        String str;
        String str2;
        if (!schemaType.isSimpleType() && schemaType.getContentType() != 2) {
            return null;
        }
        if (schemaType.isNoType()) {
            emitError(event, schemaField.isAttribute() ? XmlErrorCodes.ATTR_LOCALLY_VALID$NO_TYPE : XmlErrorCodes.ELEM_LOCALLY_VALID$NO_TYPE, null, schemaField.getName(), schemaType, 3, null);
            return null;
        }
        if (z6) {
            text = "";
        } else {
            int whiteSpaceRule = schemaType.getWhiteSpaceRule();
            text = whiteSpaceRule == 1 ? event.getText() : event.getText(whiteSpaceRule);
        }
        if (text.length() == 0 && z7 && schemaField != null && (schemaField.isDefault() || schemaField.isFixed())) {
            if (!XmlQName.type.isAssignableFrom(schemaType)) {
                String strCollapse = XmlWhitespace.collapse(schemaField.getDefaultText(), schemaType.getWhiteSpaceRule());
                if (validateSimpleType(schemaType, strCollapse, event)) {
                    return strCollapse;
                }
                return null;
            }
            emitError(event, "Default QName values are unsupported for " + QNameHelper.readable(schemaType) + " - ignoring.", null, null, 2, schemaField.getName(), null, schemaType, null, 3, null);
            return null;
        }
        if (!validateSimpleType(schemaType, text, event)) {
            return null;
        }
        if (schemaField != null && schemaField.isFixed()) {
            String strCollapse2 = XmlWhitespace.collapse(schemaField.getDefaultText(), schemaType.getWhiteSpaceRule());
            if (!validateSimpleType(schemaType, strCollapse2, event)) {
                return null;
            }
            if (!schemaType.newValue(text).valueEquals(schemaType.newValue(strCollapse2))) {
                if (schemaField.isAttribute()) {
                    emitError(event, XmlErrorCodes.ATTR_LOCALLY_VALID$FIXED, new Object[]{text, strCollapse2, QNameHelper.pretty(event.getName())}, null, schemaField.getType(), 3, null);
                } else {
                    if (schemaField.getType().getContentType() == 4) {
                        str2 = XmlErrorCodes.ELEM_LOCALLY_VALID$FIXED_VALID_MIXED_CONTENT;
                    } else {
                        if (schemaType.isSimpleType()) {
                            str2 = XmlErrorCodes.ELEM_LOCALLY_VALID$FIXED_VALID_SIMPLE_TYPE;
                        } else {
                            str = null;
                        }
                        emitError(event, str, new Object[]{text, strCollapse2}, schemaField.getName(), schemaField.getType(), 3, null);
                    }
                    str = str2;
                    emitError(event, str, new Object[]{text, strCollapse2}, schemaField.getName(), schemaField.getType(), 3, null);
                }
                return null;
            }
        }
        return text;
    }

    private void validateUnionType(SchemaType schemaType, String str, ValidatorListener.Event event) {
        if (!schemaType.matchPatternFacet(str)) {
            emitError(event, XmlErrorCodes.DATATYPE_VALID$PATTERN_VALID, new Object[]{XmlErrorCodes.UNION, str, QNameHelper.readable(schemaType)}, null, schemaType, 3000, null);
        }
        SchemaType[] unionMemberTypes = schemaType.getUnionMemberTypes();
        int i5 = this._errorState;
        int i6 = 0;
        String strCollapse = str;
        int i7 = 0;
        int i8 = 1;
        while (i7 < unionMemberTypes.length) {
            int whiteSpaceRule = unionMemberTypes[i7].getWhiteSpaceRule();
            if (whiteSpaceRule == 0) {
                whiteSpaceRule = 1;
            }
            if (whiteSpaceRule != i8) {
                strCollapse = XmlWhitespace.collapse(str, whiteSpaceRule);
                i8 = whiteSpaceRule;
            }
            int i9 = this._errorState;
            this._suspendErrors++;
            try {
                validateSimpleType(unionMemberTypes[i7], strCollapse, event);
                this._suspendErrors--;
                if (i9 == this._errorState) {
                    this._unionType = unionMemberTypes[i7];
                    break;
                }
                i7++;
            } catch (Throwable th) {
                this._suspendErrors--;
                throw th;
            }
        }
        this._errorState = i5;
        if (i7 >= unionMemberTypes.length) {
            emitError(event, XmlErrorCodes.DATATYPE_VALID$UNION, new Object[]{str, QNameHelper.readable(schemaType)}, null, schemaType, 3000, null);
            return;
        }
        XmlAnySimpleType[] enumerationValues = schemaType.getEnumerationValues();
        if (enumerationValues != null) {
            NamespaceContext.push(new NamespaceContext(event));
            try {
                XmlAnySimpleType xmlAnySimpleTypeNewValue = schemaType.newValue(str);
                while (i6 < enumerationValues.length && !xmlAnySimpleTypeNewValue.valueEquals(enumerationValues[i6])) {
                    i6++;
                }
                if (i6 >= enumerationValues.length) {
                    emitError(event, XmlErrorCodes.DATATYPE_ENUM_VALID, new Object[]{XmlErrorCodes.UNION, str, QNameHelper.readable(schemaType)}, null, schemaType, 3000, null);
                }
            } catch (XmlValueOutOfRangeException unused) {
                emitError(event, XmlErrorCodes.DATATYPE_ENUM_VALID, new Object[]{XmlErrorCodes.UNION, str, QNameHelper.readable(schemaType)}, null, schemaType, 3000, null);
            } finally {
                NamespaceContext.pop();
            }
        }
    }

    public boolean getBooleanValue() {
        return this._booleanValue;
    }

    public byte[] getByteArrayValue() {
        return this._byteArrayValue;
    }

    public SchemaLocalAttribute getCurrentAttribute() {
        return this._localAttribute;
    }

    public SchemaLocalElement getCurrentElement() {
        State state;
        SchemaLocalElement schemaLocalElement = this._localElement;
        if (schemaLocalElement != null) {
            return schemaLocalElement;
        }
        if (this._eatContent <= 0 && (state = this._stateStack) != null) {
            SchemaField schemaField = state._field;
            if (schemaField instanceof SchemaLocalElement) {
                return (SchemaLocalElement) schemaField;
            }
        }
        return null;
    }

    public SchemaType getCurrentElementSchemaType() {
        State state = topState();
        if (state != null) {
            return state._type;
        }
        return null;
    }

    public SchemaAttributeModel getCurrentWildcardAttribute() {
        return this._wildcardAttribute;
    }

    public SchemaParticle getCurrentWildcardElement() {
        return this._wildcardElement;
    }

    public BigDecimal getDecimalValue() {
        return this._decimalValue;
    }

    public double getDoubleValue() {
        return this._doubleValue;
    }

    public float getFloatValue() {
        return this._floatValue;
    }

    public GDate getGDateValue() {
        return this._gdateValue;
    }

    public GDuration getGDurationValue() {
        return this._gdurationValue;
    }

    public List<SchemaType> getListTypes() {
        return this._listTypes;
    }

    public List<Object> getListValue() {
        return this._listValue;
    }

    public QName getQNameValue() {
        return this._qnameValue;
    }

    public String getStringValue() {
        return this._stringValue;
    }

    public SchemaType getUnionType() {
        return this._unionType;
    }

    public boolean isValid() {
        return !this._invalid && this._constraintEngine.isValid();
    }

    @Override // org.apache.xmlbeans.impl.common.ValidatorListener
    public void nextEvent(int i5, ValidatorListener.Event event) {
        resetValues();
        int i6 = this._eatContent;
        if (i6 > 0) {
            if (i5 == 1) {
                this._eatContent = i6 + 1;
                return;
            } else {
                if (i5 != 2) {
                    return;
                }
                this._eatContent = i6 - 1;
                return;
            }
        }
        if (i5 == 1) {
            beginEvent(event);
            return;
        }
        if (i5 == 2) {
            endEvent(event);
            return;
        }
        if (i5 == 3) {
            textEvent(event);
        } else if (i5 == 4) {
            attrEvent(event);
        } else {
            if (i5 != 5) {
                return;
            }
            endAttrsEvent(event);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emitError(ValidatorListener.Event event, String str, Object[] objArr, QName qName, SchemaType schemaType, int i5, SchemaType schemaType2) {
        emitError(event, null, str, objArr, 0, null, qName, schemaType, null, i5, schemaType2);
    }

    private void emitError(ValidatorListener.Event event, String str, String str2, Object[] objArr, int i5, QName qName, QName qName2, SchemaType schemaType, List<QName> list, int i6, SchemaType schemaType2) {
        XmlValidationError xmlValidationErrorForLocationWithDetails;
        this._errorState++;
        if (this._suspendErrors == 0) {
            if (i5 == 0) {
                this._invalid = true;
            }
            if (this._errorListener != null) {
                XmlCursor locationAsCursor = event.getLocationAsCursor();
                if (locationAsCursor != null) {
                    xmlValidationErrorForLocationWithDetails = XmlValidationError.forCursorWithDetails(str, str2, objArr, i5, locationAsCursor, qName, qName2, schemaType, list, i6, schemaType2);
                } else {
                    xmlValidationErrorForLocationWithDetails = XmlValidationError.forLocationWithDetails(str, str2, objArr, i5, event.getLocation(), qName, qName2, schemaType, list, i6, schemaType2);
                }
                this._errorListener.add(xmlValidationErrorForLocationWithDetails);
            }
        }
    }

    private boolean validateSimpleType(SchemaType schemaType, String str, ValidatorListener.Event event) {
        if (!schemaType.isSimpleType() && schemaType.getContentType() != 2) {
            throw new RuntimeException("Not a simple type");
        }
        int i5 = this._errorState;
        int simpleVariety = schemaType.getSimpleVariety();
        if (simpleVariety == 1) {
            validateAtomicType(schemaType, str, event);
        } else if (simpleVariety == 2) {
            validateUnionType(schemaType, str, event);
        } else if (simpleVariety == 3) {
            validateListType(schemaType, str, event);
        } else {
            throw new RuntimeException("Unexpected simple variety");
        }
        return i5 == this._errorState;
    }
}
