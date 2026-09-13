package org.apache.xmlbeans.impl.schema;

import A3.AbstractC0157z;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.InterfaceExtension;
import org.apache.xmlbeans.PrePostExtension;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.QNameSetBuilder;
import org.apache.xmlbeans.SchemaAnnotation;
import org.apache.xmlbeans.SchemaAttributeModel;
import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaLocalAttribute;
import org.apache.xmlbeans.SchemaLocalElement;
import org.apache.xmlbeans.SchemaParticle;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaStringEnumEntry;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeElementSequencer;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.XBeanDebug;
import org.apache.xmlbeans.impl.regex.RegularExpression;
import org.apache.xmlbeans.impl.values.StringEnumValue;
import org.apache.xmlbeans.impl.values.TypeStoreUser;
import org.apache.xmlbeans.impl.values.TypeStoreUserFactory;
import org.apache.xmlbeans.impl.values.XmlAnySimpleTypeImpl;
import org.apache.xmlbeans.impl.values.XmlAnySimpleTypeRestriction;
import org.apache.xmlbeans.impl.values.XmlAnyTypeImpl;
import org.apache.xmlbeans.impl.values.XmlAnyUriImpl;
import org.apache.xmlbeans.impl.values.XmlAnyUriRestriction;
import org.apache.xmlbeans.impl.values.XmlBase64BinaryImpl;
import org.apache.xmlbeans.impl.values.XmlBase64BinaryRestriction;
import org.apache.xmlbeans.impl.values.XmlBooleanImpl;
import org.apache.xmlbeans.impl.values.XmlBooleanRestriction;
import org.apache.xmlbeans.impl.values.XmlByteImpl;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.values.XmlDateImpl;
import org.apache.xmlbeans.impl.values.XmlDateTimeImpl;
import org.apache.xmlbeans.impl.values.XmlDecimalImpl;
import org.apache.xmlbeans.impl.values.XmlDecimalRestriction;
import org.apache.xmlbeans.impl.values.XmlDoubleImpl;
import org.apache.xmlbeans.impl.values.XmlDoubleRestriction;
import org.apache.xmlbeans.impl.values.XmlDurationImpl;
import org.apache.xmlbeans.impl.values.XmlEntitiesImpl;
import org.apache.xmlbeans.impl.values.XmlEntityImpl;
import org.apache.xmlbeans.impl.values.XmlFloatImpl;
import org.apache.xmlbeans.impl.values.XmlFloatRestriction;
import org.apache.xmlbeans.impl.values.XmlGDayImpl;
import org.apache.xmlbeans.impl.values.XmlGMonthDayImpl;
import org.apache.xmlbeans.impl.values.XmlGMonthImpl;
import org.apache.xmlbeans.impl.values.XmlGYearImpl;
import org.apache.xmlbeans.impl.values.XmlGYearMonthImpl;
import org.apache.xmlbeans.impl.values.XmlHexBinaryImpl;
import org.apache.xmlbeans.impl.values.XmlHexBinaryRestriction;
import org.apache.xmlbeans.impl.values.XmlIdImpl;
import org.apache.xmlbeans.impl.values.XmlIdRefImpl;
import org.apache.xmlbeans.impl.values.XmlIdRefsImpl;
import org.apache.xmlbeans.impl.values.XmlIntImpl;
import org.apache.xmlbeans.impl.values.XmlIntRestriction;
import org.apache.xmlbeans.impl.values.XmlIntegerImpl;
import org.apache.xmlbeans.impl.values.XmlIntegerRestriction;
import org.apache.xmlbeans.impl.values.XmlLanguageImpl;
import org.apache.xmlbeans.impl.values.XmlListImpl;
import org.apache.xmlbeans.impl.values.XmlLongImpl;
import org.apache.xmlbeans.impl.values.XmlLongRestriction;
import org.apache.xmlbeans.impl.values.XmlNCNameImpl;
import org.apache.xmlbeans.impl.values.XmlNameImpl;
import org.apache.xmlbeans.impl.values.XmlNegativeIntegerImpl;
import org.apache.xmlbeans.impl.values.XmlNmTokenImpl;
import org.apache.xmlbeans.impl.values.XmlNmTokensImpl;
import org.apache.xmlbeans.impl.values.XmlNonNegativeIntegerImpl;
import org.apache.xmlbeans.impl.values.XmlNonPositiveIntegerImpl;
import org.apache.xmlbeans.impl.values.XmlNormalizedStringImpl;
import org.apache.xmlbeans.impl.values.XmlNotationImpl;
import org.apache.xmlbeans.impl.values.XmlNotationRestriction;
import org.apache.xmlbeans.impl.values.XmlObjectBase;
import org.apache.xmlbeans.impl.values.XmlPositiveIntegerImpl;
import org.apache.xmlbeans.impl.values.XmlQNameImpl;
import org.apache.xmlbeans.impl.values.XmlQNameRestriction;
import org.apache.xmlbeans.impl.values.XmlShortImpl;
import org.apache.xmlbeans.impl.values.XmlStringEnumeration;
import org.apache.xmlbeans.impl.values.XmlStringImpl;
import org.apache.xmlbeans.impl.values.XmlStringRestriction;
import org.apache.xmlbeans.impl.values.XmlTimeImpl;
import org.apache.xmlbeans.impl.values.XmlTokenImpl;
import org.apache.xmlbeans.impl.values.XmlUnionImpl;
import org.apache.xmlbeans.impl.values.XmlUnsignedByteImpl;
import org.apache.xmlbeans.impl.values.XmlUnsignedIntImpl;
import org.apache.xmlbeans.impl.values.XmlUnsignedLongImpl;
import org.apache.xmlbeans.impl.values.XmlUnsignedShortImpl;
import org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException;
import org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.Element;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class SchemaTypeImpl implements SchemaType, TypeStoreUserFactory {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int JAVAIZED = 6;
    private static final int JAVAIZING = 5;
    private static final SchemaProperty[] NO_PROPERTIES = new SchemaProperty[0];
    private static final int RESOLVED = 4;
    private static final int RESOLVED_SGS = 2;
    private static final int RESOLVING = 3;
    private static final int RESOLVING_SGS = 1;
    private static final int UNRESOLVED = 0;
    private boolean _abs;
    private SchemaAnnotation _annotation;
    private SchemaType.Ref[] _anonymousTyperefs;
    private int _anonymousUnionMemberOrdinal;
    private String _attFormDefault;
    private volatile Map<SchemaLocalAttribute, Integer> _attrToIndexMap;
    private SchemaAttributeModel _attributeModel;
    private int _baseDepth;
    private SchemaType.Ref _baseEnumTyperef;
    private SchemaType.Ref _baseTyperef;
    private boolean _blockExt;
    private boolean _blockRest;
    private int _builtinTypeCode;
    private boolean _chameleon;
    private int _complexTypeVariety;
    private SchemaContainer _container;
    private volatile SchemaField _containerField;
    private volatile int _containerFieldCode;
    private volatile int _containerFieldIndex;
    private volatile SchemaComponent.Ref _containerFieldRef;
    private SchemaType.Ref _contentBasedOnTyperef;
    private SchemaParticle _contentModel;
    private int _decimalSize;
    private int _derivationType;
    private String _documentation;
    private String _elemFormDefault;
    private volatile Map<SchemaLocalElement, Integer> _eltToIndexMap;
    private XmlValueRef[] _enumerationValues;
    private XmlValueRef[] _facetArray;
    private String _filename;
    private boolean _finalExt;
    private boolean _finalList;
    private boolean _finalRest;
    private boolean _finalUnion;
    private boolean[] _fixedFacetArray;
    private String _fullJavaImplName;
    private String _fullJavaName;
    private volatile QName[] _groupReferenceContext;
    private boolean _hasAllContent;
    private boolean _hasPatterns;
    private boolean _hasWildcardAttributes;
    private boolean _hasWildcardElements;
    private volatile boolean _implNotAvailable;
    private InterfaceExtension[] _interfaces;
    private boolean _isAttributeType;
    private boolean _isBounded;
    private boolean _isCompiled;
    private boolean _isDocumentType;
    private boolean _isFinite;
    private boolean _isNumeric;
    private boolean _isSimpleType;
    private boolean _isUnionOfLists;
    private volatile Class<? extends XmlObject> _javaClass;
    private volatile Class<? extends StringEnumAbstractBase> _javaEnumClass;
    private volatile Class<? extends XmlObjectBase> _javaImplClass;
    private volatile Constructor<? extends XmlObjectBase> _javaImplConstructor;
    private volatile Constructor<? extends XmlObjectBase> _javaImplConstructor2;
    private SchemaType.Ref _listItemTyperef;
    private volatile List<StringEnumAbstractBase> _listOfStringEnum;
    private volatile SchemaLocalElement[] _localElts;
    private volatile Map<String, StringEnumAbstractBase> _lookupStringEnum;
    private volatile Map<String, SchemaStringEnumEntry> _lookupStringEnumEntry;
    private QName _name;
    private boolean _orderSensitive;
    private int _ordered;
    private SchemaType.Ref _outerSchemaTypeRef;
    private XmlObject _parseObject;
    private String _parseTNS;
    private RegularExpression[] _patterns;
    private PrePostExtension _prepost;
    private SchemaType.Ref _primitiveTypeRef;
    private Map<QName, SchemaProperty> _propertyModelByAttributeName;
    private Map<QName, SchemaProperty> _propertyModelByElementName;
    private boolean _redefinition;
    private int _resolvePhase;
    private QName _sg;
    private String _shortJavaImplName;
    private String _shortJavaName;
    private int _simpleTypeVariety;
    private boolean _stringEnumEnsured;
    private SchemaStringEnumEntry[] _stringEnumEntries;
    private QNameSet _typedWildcardAttributes;
    private QNameSet _typedWildcardElements;
    private volatile SchemaType _unionCommonBaseType;
    private volatile SchemaType[] _unionConstituentTypes;
    private SchemaType.Ref[] _unionMemberTyperefs;
    private volatile SchemaType[] _unionSubTypes;
    private volatile boolean _unloaded;
    private volatile Object _userData;
    private String _userTypeHandler;
    private String _userTypeName;
    private int _whiteSpaceRule;
    private final Object[] _ctrArgs = {this};
    private Set<QName> _validSubstitutions = Collections.EMPTY_SET;
    private final List<QName> _sgMembers = new ArrayList();
    private final SchemaType.Ref _selfref = new SchemaType.Ref(this);

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class SequencerImpl implements SchemaTypeElementSequencer {
        private final SchemaTypeVisitorImpl _visitor;

        @Override // org.apache.xmlbeans.SchemaTypeElementSequencer
        public boolean next(QName qName) {
            SchemaTypeVisitorImpl schemaTypeVisitorImpl = this._visitor;
            if (schemaTypeVisitorImpl == null) {
                return false;
            }
            return schemaTypeVisitorImpl.visit(qName);
        }

        @Override // org.apache.xmlbeans.SchemaTypeElementSequencer
        public boolean peek(QName qName) {
            SchemaTypeVisitorImpl schemaTypeVisitorImpl = this._visitor;
            if (schemaTypeVisitorImpl == null) {
                return false;
            }
            return schemaTypeVisitorImpl.testValid(qName);
        }

        private SequencerImpl(SchemaTypeVisitorImpl schemaTypeVisitorImpl) {
            this._visitor = schemaTypeVisitorImpl;
        }
    }

    public SchemaTypeImpl(SchemaContainer schemaContainer) {
        this._container = schemaContainer;
    }

    private void assertJavaizing() {
        if (this._resolvePhase != 5 && !this._unloaded) {
            throw new IllegalStateException();
        }
    }

    private void assertResolved() {
        if (this._resolvePhase != 4 && !this._unloaded) {
            throw new IllegalStateException();
        }
    }

    private void assertResolving() {
        if (this._resolvePhase != 3 && !this._unloaded) {
            throw new IllegalStateException();
        }
    }

    private void assertSGResolved() {
        if (this._resolvePhase != 2 && !this._unloaded) {
            throw new IllegalStateException();
        }
    }

    private void assertSGResolving() {
        if (this._resolvePhase != 1 && !this._unloaded) {
            throw new IllegalStateException();
        }
    }

    private void assertUnresolved() {
        if (this._resolvePhase != 0 && !this._unloaded) {
            throw new IllegalStateException();
        }
    }

    private static boolean[] boaCopy(boolean[] zArr) {
        if (zArr == null) {
            return null;
        }
        boolean[] zArr2 = new boolean[zArr.length];
        System.arraycopy(zArr, 0, zArr2, 0, zArr.length);
        return zArr2;
    }

    private static void buildEltList(List<SchemaLocalElement> list, SchemaParticle schemaParticle) {
        if (schemaParticle == null) {
            return;
        }
        int particleType = schemaParticle.getParticleType();
        if (particleType == 1 || particleType == 2 || particleType == 3) {
            for (int i5 = 0; i5 < schemaParticle.countOfParticleChild(); i5++) {
                buildEltList(list, schemaParticle.getParticleChild(i5));
            }
        } else {
            if (particleType != 4) {
                return;
            }
            list.add((SchemaLocalElement) schemaParticle);
        }
    }

    private void buildLocalElts() {
        ArrayList arrayList = new ArrayList();
        buildEltList(arrayList, this._contentModel);
        this._localElts = (SchemaLocalElement[]) arrayList.toArray(new SchemaLocalElement[0]);
    }

    private static QNameSet computeAllContainedElements(SchemaParticle schemaParticle, Map<SchemaParticle, QNameSet> map) {
        QNameSet qNameSetAcceptedStartNames;
        QNameSet qNameSet = map.get(schemaParticle);
        if (qNameSet != null) {
            return qNameSet;
        }
        int particleType = schemaParticle.getParticleType();
        if (particleType == 4) {
            qNameSetAcceptedStartNames = schemaParticle.acceptedStartNames();
        } else if (particleType != 5) {
            QNameSetBuilder qNameSetBuilder = new QNameSetBuilder();
            for (int i5 = 0; i5 < schemaParticle.countOfParticleChild(); i5++) {
                qNameSetBuilder.addAll(computeAllContainedElements(schemaParticle.getParticleChild(i5), map));
            }
            qNameSetAcceptedStartNames = qNameSetBuilder.toQNameSet();
        } else {
            qNameSetAcceptedStartNames = schemaParticle.getWildcardSet();
        }
        map.put(schemaParticle, qNameSetAcceptedStartNames);
        return qNameSetAcceptedStartNames;
    }

    private void computeFlatUnionModel() {
        if (getSimpleVariety() != 2) {
            throw new IllegalStateException("Operation is only supported on union types");
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        linkedHashSet2.add(this);
        SchemaType commonBaseType = null;
        for (SchemaType.Ref ref : this._unionMemberTyperefs) {
            SchemaTypeImpl schemaTypeImpl = (SchemaTypeImpl) ref.get();
            int simpleVariety = schemaTypeImpl.getSimpleVariety();
            if (simpleVariety == 1) {
                linkedHashSet.add(schemaTypeImpl);
                linkedHashSet2.add(schemaTypeImpl);
                commonBaseType = schemaTypeImpl.getCommonBaseType(commonBaseType);
            } else if (simpleVariety == 2) {
                linkedHashSet.addAll(Arrays.asList(schemaTypeImpl.getUnionConstituentTypes()));
                linkedHashSet2.addAll(Arrays.asList(schemaTypeImpl.getUnionSubTypes()));
                SchemaType unionCommonBaseType = schemaTypeImpl.getUnionCommonBaseType();
                if (unionCommonBaseType != null) {
                    commonBaseType = unionCommonBaseType.getCommonBaseType(commonBaseType);
                }
            } else if (simpleVariety == 3) {
                linkedHashSet.add(schemaTypeImpl);
                linkedHashSet2.add(schemaTypeImpl);
                commonBaseType = schemaTypeImpl.getCommonBaseType(commonBaseType);
            }
        }
        SchemaType[] schemaTypeArr = StscState.EMPTY_ST_ARRAY;
        setUnionConstituentTypes((SchemaType[]) linkedHashSet.toArray(schemaTypeArr));
        setUnionSubTypes((SchemaType[]) linkedHashSet2.toArray(schemaTypeArr));
        setUnionCommonBaseType(commonBaseType);
    }

    private static QNameSet computeNondelimitingElements(QName qName, SchemaParticle schemaParticle, Map<SchemaParticle, QNameSet> map) {
        QNameSet qNameSetComputeAllContainedElements = computeAllContainedElements(schemaParticle, map);
        if (!qNameSetComputeAllContainedElements.contains(qName)) {
            return QNameSet.EMPTY;
        }
        if (schemaParticle.getMaxOccurs() != null && schemaParticle.getMaxOccurs().compareTo(BigInteger.ONE) <= 0) {
            int particleType = schemaParticle.getParticleType();
            int i5 = 0;
            if (particleType == 2) {
                QNameSetBuilder qNameSetBuilder = new QNameSetBuilder();
                while (i5 < schemaParticle.countOfParticleChild()) {
                    if (computeAllContainedElements(schemaParticle.getParticleChild(i5), map).contains(qName)) {
                        qNameSetBuilder.addAll(computeNondelimitingElements(qName, schemaParticle.getParticleChild(i5), map));
                    }
                    i5++;
                }
                return qNameSetBuilder.toQNameSet();
            }
            if (particleType == 3) {
                QNameSetBuilder qNameSetBuilder2 = new QNameSetBuilder();
                int iCountOfParticleChild = schemaParticle.countOfParticleChild();
                while (iCountOfParticleChild > 0) {
                    iCountOfParticleChild--;
                    QNameSet qNameSetComputeAllContainedElements2 = computeAllContainedElements(schemaParticle.getParticleChild(iCountOfParticleChild), map);
                    if (i5 != 0) {
                        qNameSetBuilder2.addAll(qNameSetComputeAllContainedElements2);
                    } else if (qNameSetComputeAllContainedElements2.contains(qName)) {
                        qNameSetBuilder2.addAll(computeNondelimitingElements(qName, schemaParticle.getParticleChild(iCountOfParticleChild), map));
                        i5 = 1;
                    }
                }
                return qNameSetBuilder2.toQNameSet();
            }
            if (particleType == 5) {
                return QNameSet.singleton(qName);
            }
        }
        return qNameSetComputeAllContainedElements;
    }

    private static void computeWildcardSet(SchemaParticle schemaParticle, QNameSetBuilder qNameSetBuilder) {
        if (schemaParticle.getParticleType() == 5) {
            qNameSetBuilder.addAll(schemaParticle.getWildcardSet());
            return;
        }
        for (int i5 = 0; i5 < schemaParticle.countOfParticleChild(); i5++) {
            computeWildcardSet(schemaParticle.getParticleChild(i5), qNameSetBuilder);
        }
    }

    private XmlObject createBuiltinInstance() {
        switch (getBuiltinTypeCode()) {
            case 0:
                return new XmlAnyTypeImpl(BuiltinSchemaTypeSystem.ST_NO_TYPE);
            case 1:
                return new XmlAnyTypeImpl();
            case 2:
                return new XmlAnySimpleTypeImpl();
            case 3:
                return new XmlBooleanImpl();
            case 4:
                return new XmlBase64BinaryImpl();
            case 5:
                return new XmlHexBinaryImpl();
            case 6:
                return new XmlAnyUriImpl();
            case 7:
                return new XmlQNameImpl();
            case 8:
                return new XmlNotationImpl();
            case 9:
                return new XmlFloatImpl();
            case 10:
                return new XmlDoubleImpl();
            case 11:
                return new XmlDecimalImpl();
            case 12:
                return new XmlStringImpl();
            case 13:
                return new XmlDurationImpl();
            case 14:
                return new XmlDateTimeImpl();
            case 15:
                return new XmlTimeImpl();
            case 16:
                return new XmlDateImpl();
            case 17:
                return new XmlGYearMonthImpl();
            case 18:
                return new XmlGYearImpl();
            case 19:
                return new XmlGMonthDayImpl();
            case 20:
                return new XmlGDayImpl();
            case 21:
                return new XmlGMonthImpl();
            case 22:
                return new XmlIntegerImpl();
            case 23:
                return new XmlLongImpl();
            case 24:
                return new XmlIntImpl();
            case 25:
                return new XmlShortImpl();
            case 26:
                return new XmlByteImpl();
            case 27:
                return new XmlNonPositiveIntegerImpl();
            case 28:
                return new XmlNegativeIntegerImpl();
            case 29:
                return new XmlNonNegativeIntegerImpl();
            case 30:
                return new XmlPositiveIntegerImpl();
            case 31:
                return new XmlUnsignedLongImpl();
            case 32:
                return new XmlUnsignedIntImpl();
            case 33:
                return new XmlUnsignedShortImpl();
            case 34:
                return new XmlUnsignedByteImpl();
            case 35:
                return new XmlNormalizedStringImpl();
            case 36:
                return new XmlTokenImpl();
            case 37:
                return new XmlNameImpl();
            case 38:
                return new XmlNCNameImpl();
            case 39:
                return new XmlLanguageImpl();
            case 40:
                return new XmlIdImpl();
            case 41:
                return new XmlIdRefImpl();
            case 42:
                return new XmlIdRefsImpl();
            case 43:
                return new XmlEntityImpl();
            case 44:
                return new XmlEntitiesImpl();
            case 45:
                return new XmlNmTokenImpl();
            case 46:
                return new XmlNmTokensImpl();
            default:
                throw new IllegalStateException("Unrecognized builtin type: " + getBuiltinTypeCode());
        }
    }

    private XmlObject createBuiltinSubclass(SchemaType schemaType) {
        boolean z6 = !schemaType.isSimpleType();
        switch (getBuiltinTypeCode()) {
            case 0:
                return new XmlAnyTypeImpl(BuiltinSchemaTypeSystem.ST_NO_TYPE);
            case 1:
            case 2:
                int simpleVariety = schemaType.getSimpleVariety();
                if (simpleVariety == 0) {
                    return new XmlComplexContentImpl(schemaType);
                }
                if (simpleVariety == 1) {
                    return new XmlAnySimpleTypeRestriction(schemaType, z6);
                }
                if (simpleVariety == 2) {
                    return new XmlUnionImpl(schemaType, z6);
                }
                if (simpleVariety == 3) {
                    return new XmlListImpl(schemaType, z6);
                }
                throw new IllegalStateException();
            case 3:
                return new XmlBooleanRestriction(schemaType, z6);
            case 4:
                return new XmlBase64BinaryRestriction(schemaType, z6);
            case 5:
                return new XmlHexBinaryRestriction(schemaType, z6);
            case 6:
                return new XmlAnyUriRestriction(schemaType, z6);
            case 7:
                return new XmlQNameRestriction(schemaType, z6);
            case 8:
                return new XmlNotationRestriction(schemaType, z6);
            case 9:
                return new XmlFloatRestriction(schemaType, z6);
            case 10:
                return new XmlDoubleRestriction(schemaType, z6);
            case 11:
                return new XmlDecimalRestriction(schemaType, z6);
            case 12:
                return schemaType.hasStringEnumValues() ? new XmlStringEnumeration(schemaType, z6) : new XmlStringRestriction(schemaType, z6);
            case 13:
                return new XmlDurationImpl(schemaType, z6);
            case 14:
                return new XmlDateTimeImpl(schemaType, z6);
            case 15:
                return new XmlTimeImpl(schemaType, z6);
            case 16:
                return new XmlDateImpl(schemaType, z6);
            case 17:
                return new XmlGYearMonthImpl(schemaType, z6);
            case 18:
                return new XmlGYearImpl(schemaType, z6);
            case 19:
                return new XmlGMonthDayImpl(schemaType, z6);
            case 20:
                return new XmlGDayImpl(schemaType, z6);
            case 21:
                return new XmlGMonthImpl(schemaType, z6);
            case 22:
                return new XmlIntegerRestriction(schemaType, z6);
            case 23:
                return new XmlLongRestriction(schemaType, z6);
            case 24:
                return new XmlIntRestriction(schemaType, z6);
            case 25:
                return new XmlShortImpl(schemaType, z6);
            case 26:
                return new XmlByteImpl(schemaType, z6);
            case 27:
                return new XmlNonPositiveIntegerImpl(schemaType, z6);
            case 28:
                return new XmlNegativeIntegerImpl(schemaType, z6);
            case 29:
                return new XmlNonNegativeIntegerImpl(schemaType, z6);
            case 30:
                return new XmlPositiveIntegerImpl(schemaType, z6);
            case 31:
                return new XmlUnsignedLongImpl(schemaType, z6);
            case 32:
                return new XmlUnsignedIntImpl(schemaType, z6);
            case 33:
                return new XmlUnsignedShortImpl(schemaType, z6);
            case 34:
                return new XmlUnsignedByteImpl(schemaType, z6);
            case 35:
                return new XmlNormalizedStringImpl(schemaType, z6);
            case 36:
                return new XmlTokenImpl(schemaType, z6);
            case 37:
                return new XmlNameImpl(schemaType, z6);
            case 38:
                return new XmlNCNameImpl(schemaType, z6);
            case 39:
                return new XmlLanguageImpl(schemaType, z6);
            case 40:
                return new XmlIdImpl(schemaType, z6);
            case 41:
                return new XmlIdRefImpl(schemaType, z6);
            case 42:
                return new XmlIdRefsImpl(schemaType, z6);
            case 43:
                return new XmlEntityImpl(schemaType, z6);
            case 44:
                return new XmlEntitiesImpl(schemaType, z6);
            case 45:
                return new XmlNmTokenImpl(schemaType, z6);
            case 46:
                return new XmlNmTokensImpl(schemaType, z6);
            default:
                throw new IllegalStateException("Unrecognized builtin type: " + getBuiltinTypeCode());
        }
    }

    private XmlObject createUnattachedNode(SchemaProperty schemaProperty) {
        XmlObject xmlObjectCreateBuiltinInstance;
        if (isBuiltinType() || isNoType()) {
            xmlObjectCreateBuiltinInstance = createBuiltinInstance();
        } else {
            Constructor<? extends XmlObjectBase> javaImplConstructor = getJavaImplConstructor();
            if (javaImplConstructor != null) {
                try {
                    return javaImplConstructor.newInstance(this._ctrArgs);
                } catch (Exception e) {
                    System.out.println("Exception trying to instantiate impl class.");
                    e.printStackTrace();
                }
            }
            xmlObjectCreateBuiltinInstance = null;
        }
        SchemaType baseType = this;
        while (xmlObjectCreateBuiltinInstance == null) {
            xmlObjectCreateBuiltinInstance = ((SchemaTypeImpl) baseType).createUnattachedSubclass(this);
            baseType = baseType.getBaseType();
        }
        ((XmlObjectBase) xmlObjectCreateBuiltinInstance).init_flags(schemaProperty);
        return xmlObjectCreateBuiltinInstance;
    }

    private XmlObject createUnattachedSubclass(SchemaType schemaType) {
        if (isBuiltinType() || isNoType()) {
            return createBuiltinSubclass(schemaType);
        }
        Constructor<? extends XmlObjectBase> javaImplConstructor2 = getJavaImplConstructor2();
        if (javaImplConstructor2 == null) {
            return null;
        }
        try {
            return javaImplConstructor2.newInstance(schemaType, Boolean.valueOf(!schemaType.isSimpleType()));
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            XBeanDebug.LOG.atDebug().withThrowable(e).log(e.getMessage());
            return null;
        }
    }

    private void ensureStringEnumInfo() {
        if (this._stringEnumEnsured) {
            return;
        }
        SchemaStringEnumEntry[] schemaStringEnumEntryArr = this._stringEnumEntries;
        if (schemaStringEnumEntryArr == null) {
            this._stringEnumEnsured = true;
            return;
        }
        HashMap map = new HashMap(schemaStringEnumEntryArr.length);
        ArrayList arrayList = new ArrayList(schemaStringEnumEntryArr.length + 1);
        HashMap map2 = new HashMap(schemaStringEnumEntryArr.length);
        for (SchemaStringEnumEntry schemaStringEnumEntry : schemaStringEnumEntryArr) {
            map2.put(schemaStringEnumEntry.getString(), schemaStringEnumEntry);
        }
        Class<? extends StringEnumAbstractBase> enumJavaClass = this._baseEnumTyperef.get().getEnumJavaClass();
        if (enumJavaClass != null) {
            try {
                StringEnumAbstractBase.Table table = (StringEnumAbstractBase.Table) enumJavaClass.getField("table").get(null);
                for (SchemaStringEnumEntry schemaStringEnumEntry2 : schemaStringEnumEntryArr) {
                    int intValue = schemaStringEnumEntry2.getIntValue();
                    StringEnumAbstractBase stringEnumAbstractBaseForInt = table.forInt(intValue);
                    map.put(schemaStringEnumEntry2.getString(), stringEnumAbstractBaseForInt);
                    while (arrayList.size() <= intValue) {
                        arrayList.add(null);
                    }
                    arrayList.set(intValue, stringEnumAbstractBaseForInt);
                }
            } catch (Exception unused) {
                System.err.println("Something wrong: could not locate enum table for " + enumJavaClass);
                map.clear();
                arrayList.clear();
                enumJavaClass = null;
            }
        }
        if (enumJavaClass == null) {
            for (SchemaStringEnumEntry schemaStringEnumEntry3 : schemaStringEnumEntryArr) {
                int intValue2 = schemaStringEnumEntry3.getIntValue();
                String string = schemaStringEnumEntry3.getString();
                StringEnumValue stringEnumValue = new StringEnumValue(string, intValue2);
                map.put(string, stringEnumValue);
                while (arrayList.size() <= intValue2) {
                    arrayList.add(null);
                }
                arrayList.set(intValue2, stringEnumValue);
            }
        }
        synchronized (this) {
            try {
                if (!this._stringEnumEnsured) {
                    this._lookupStringEnum = map;
                    this._listOfStringEnum = arrayList;
                    this._lookupStringEnumEntry = map2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this) {
            this._stringEnumEnsured = true;
        }
    }

    private static boolean eq(BigInteger bigInteger, BigInteger bigInteger2) {
        if (bigInteger == null && bigInteger2 == null) {
            return true;
        }
        if (bigInteger == null || bigInteger2 == null) {
            return false;
        }
        return bigInteger.equals(bigInteger2);
    }

    private void finishQuick() {
        this._resolvePhase = 6;
    }

    private boolean noElements() {
        return (getContentType() == 3 || getContentType() == 4) ? false : true;
    }

    private static String parseDocumentation(XmlObject xmlObject) {
        try {
            AnnotationDocument.Annotation annotation = Element.Factory.parse(xmlObject.toString()).getAnnotation();
            if (annotation != null && annotation.sizeOfDocumentationArray() != 0) {
                StringBuilder sb = new StringBuilder();
                for (DocumentationDocument.Documentation documentation : annotation.getDocumentationArray()) {
                    XmlCursor xmlCursorNewCursor = documentation.newCursor();
                    try {
                        if (xmlCursorNewCursor.getChars() != null) {
                            sb.append(xmlCursorNewCursor.getTextValue());
                        }
                        xmlCursorNewCursor.close();
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            if (xmlCursorNewCursor != null) {
                                try {
                                    xmlCursorNewCursor.close();
                                } catch (Throwable th3) {
                                    th.addSuppressed(th3);
                                }
                            }
                            throw th2;
                        }
                    }
                }
                return sb.toString();
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    private void setUnionCommonBaseType(SchemaType schemaType) {
        this._unionCommonBaseType = schemaType;
    }

    private void setUnionConstituentTypes(SchemaType[] schemaTypeArr) {
        this._unionConstituentTypes = schemaTypeArr;
    }

    private void setUnionSubTypes(SchemaType[] schemaTypeArr) {
        this._unionSubTypes = schemaTypeArr;
    }

    private static SchemaType[] staCopy(SchemaType[] schemaTypeArr) {
        if (schemaTypeArr == null) {
            return null;
        }
        SchemaType[] schemaTypeArr2 = new SchemaType[schemaTypeArr.length];
        System.arraycopy(schemaTypeArr, 0, schemaTypeArr2, 0, schemaTypeArr.length);
        return schemaTypeArr2;
    }

    public void addSubstitutionGroupMember(QName qName) {
        assertSGResolved();
        this._sgMembers.add(qName);
    }

    public synchronized void assignJavaElementSetterModel() {
        SchemaProperty[] elementProperties = getElementProperties();
        SchemaParticle contentModel = getContentModel();
        HashMap map = new HashMap();
        QNameSet qNameSetComputeAllContainedElements = computeAllContainedElements(contentModel, map);
        for (SchemaProperty schemaProperty : elementProperties) {
            SchemaPropertyImpl schemaPropertyImpl = (SchemaPropertyImpl) schemaProperty;
            QNameSet qNameSetComputeNondelimitingElements = computeNondelimitingElements(schemaPropertyImpl.getName(), contentModel, map);
            QNameSetBuilder qNameSetBuilder = new QNameSetBuilder(qNameSetComputeAllContainedElements);
            qNameSetBuilder.removeAll(qNameSetComputeNondelimitingElements);
            schemaPropertyImpl.setJavaSetterDelimiter(qNameSetBuilder.toQNameSet());
        }
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean blockExtension() {
        return this._blockExt;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean blockRestriction() {
        return this._blockRest;
    }

    public void copyEnumerationValues(SchemaTypeImpl schemaTypeImpl) {
        assertResolving();
        this._enumerationValues = schemaTypeImpl._enumerationValues;
        this._baseEnumTyperef = schemaTypeImpl._baseEnumTyperef;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0049  */
    /* JADX WARN: Code duplicated, block: B:25:0x004e A[RETURN] */
    public XmlObject createAttributeType(QName qName, SchemaTypeLoader schemaTypeLoader) {
        SchemaTypeImpl schemaTypeImpl;
        SchemaProperty schemaProperty;
        SchemaGlobalAttribute schemaGlobalAttributeFindAttribute;
        if (!isSimpleType() && !isNoType()) {
            if (isURType()) {
                schemaTypeImpl = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
            } else {
                schemaProperty = this._propertyModelByAttributeName.get(qName);
                if (schemaProperty != null) {
                    schemaTypeImpl = (SchemaTypeImpl) schemaProperty.getType();
                } else {
                    schemaTypeImpl = (this._typedWildcardAttributes.contains(qName) && (schemaGlobalAttributeFindAttribute = schemaTypeLoader.findAttribute(qName)) != null) ? (SchemaTypeImpl) schemaGlobalAttributeFindAttribute.getType() : BuiltinSchemaTypeSystem.ST_NO_TYPE;
                }
            }
            if (schemaTypeImpl != null) {
                return schemaTypeImpl.createUnattachedNode(schemaProperty);
            }
            return null;
        }
        schemaTypeImpl = BuiltinSchemaTypeSystem.ST_NO_TYPE;
        schemaProperty = null;
        if (schemaTypeImpl != null) {
            return schemaTypeImpl.createUnattachedNode(schemaProperty);
        }
        return null;
    }

    public XmlObject createElementType(QName qName, QName qName2, SchemaTypeLoader schemaTypeLoader) {
        SchemaType type;
        SchemaProperty elementProperty;
        SchemaGlobalElement schemaGlobalElementFindElement;
        SchemaType schemaTypeFindType;
        if (isSimpleType() || noElements() || isNoType()) {
            type = BuiltinSchemaTypeSystem.ST_NO_TYPE;
            elementProperty = null;
        } else {
            elementProperty = this._propertyModelByElementName.get(qName);
            if (elementProperty != null) {
                type = elementProperty.getType();
            } else if ((this._typedWildcardElements.contains(qName) || this._validSubstitutions.contains(qName)) && (schemaGlobalElementFindElement = schemaTypeLoader.findElement(qName)) != null) {
                SchemaType type2 = schemaGlobalElementFindElement.getType();
                SchemaType schemaTypeFindDocumentType = schemaTypeLoader.findDocumentType(qName);
                if (schemaTypeFindDocumentType != null) {
                    elementProperty = schemaTypeFindDocumentType.getElementProperty(qName);
                }
                type = type2;
            } else {
                type = BuiltinSchemaTypeSystem.ST_NO_TYPE;
            }
            if (qName2 != null && (schemaTypeFindType = schemaTypeLoader.findType(qName2)) != null && type.isAssignableFrom(schemaTypeFindType)) {
                type = schemaTypeFindType;
            }
        }
        if (type != null) {
            return ((SchemaTypeImpl) type).createUnattachedNode(elementProperty);
        }
        return null;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUserFactory
    public TypeStoreUser createTypeStoreUser() {
        return (TypeStoreUser) createUnattachedNode(null);
    }

    public XmlObject createUnwrappedNode() {
        return createUnattachedNode(null);
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaStringEnumEntry enumEntryForString(String str) {
        ensureStringEnumInfo();
        if (this._lookupStringEnumEntry == null) {
            return null;
        }
        return this._lookupStringEnumEntry.get(str);
    }

    @Override // org.apache.xmlbeans.SchemaType
    public StringEnumAbstractBase enumForInt(int i5) {
        ensureStringEnumInfo();
        if (this._listOfStringEnum == null || i5 < 0 || i5 >= this._listOfStringEnum.size()) {
            return null;
        }
        return this._listOfStringEnum.get(i5);
    }

    @Override // org.apache.xmlbeans.SchemaType
    public StringEnumAbstractBase enumForString(String str) {
        ensureStringEnumInfo();
        if (this._lookupStringEnum == null) {
            return null;
        }
        return this._lookupStringEnum.get(str);
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean finalExtension() {
        return this._finalExt;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean finalList() {
        return this._finalList;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean finalRestriction() {
        return this._finalRest;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean finalUnion() {
        return this._finalUnion;
    }

    public void finishJavaizing() {
        if (this._resolvePhase != 5) {
            throw new IllegalStateException();
        }
        this._resolvePhase = 6;
    }

    public void finishLoading() {
        this._unloaded = false;
    }

    public void finishResolving() {
        if (this._resolvePhase != 3) {
            throw new IllegalStateException();
        }
        this._resolvePhase = 4;
    }

    public void finishResolvingSGs() {
        if (this._resolvePhase != 1) {
            throw new IllegalStateException();
        }
        this._resolvePhase = 2;
    }

    @Override // org.apache.xmlbeans.SchemaAnnotated
    public SchemaAnnotation getAnnotation() {
        return this._annotation;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaType[] getAnonymousTypes() {
        int length = this._anonymousTyperefs.length;
        SchemaType[] schemaTypeArr = new SchemaType[length];
        for (int i5 = 0; i5 < length; i5++) {
            schemaTypeArr[i5] = this._anonymousTyperefs[i5].get();
        }
        return schemaTypeArr;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public int getAnonymousUnionMemberOrdinal() {
        return this._anonymousUnionMemberOrdinal;
    }

    public String getAttFormDefault() {
        return this._attFormDefault;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaAttributeModel getAttributeModel() {
        return this._attributeModel;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaProperty[] getAttributeProperties() {
        Map<QName, SchemaProperty> map = this._propertyModelByAttributeName;
        return map == null ? NO_PROPERTIES : (SchemaProperty[]) map.values().toArray(new SchemaProperty[0]);
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaProperty getAttributeProperty(QName qName) {
        Map<QName, SchemaProperty> map = this._propertyModelByAttributeName;
        if (map == null) {
            return null;
        }
        return map.get(qName);
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaType getAttributeType(QName qName, SchemaTypeLoader schemaTypeLoader) {
        if (isSimpleType() || isNoType()) {
            return BuiltinSchemaTypeSystem.ST_NO_TYPE;
        }
        if (isURType()) {
            return BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        }
        SchemaProperty schemaProperty = this._propertyModelByAttributeName.get(qName);
        if (schemaProperty != null) {
            return schemaProperty.getType();
        }
        if (!this._typedWildcardAttributes.contains(qName) || schemaTypeLoader == null) {
            return BuiltinSchemaTypeSystem.ST_NO_TYPE;
        }
        SchemaGlobalAttribute schemaGlobalAttributeFindAttribute = schemaTypeLoader.findAttribute(qName);
        return schemaGlobalAttributeFindAttribute == null ? BuiltinSchemaTypeSystem.ST_NO_TYPE : schemaGlobalAttributeFindAttribute.getType();
    }

    @Override // org.apache.xmlbeans.SchemaType
    public QName getAttributeTypeAttributeName() {
        SchemaAttributeModel attributeModel;
        SchemaLocalAttribute[] attributes;
        if (!this._isAttributeType || (attributeModel = getAttributeModel()) == null || (attributes = attributeModel.getAttributes()) == null || attributes.length <= 0) {
            return null;
        }
        return attributes[0].getName();
    }

    public int getBaseDepth() {
        return this._baseDepth;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaType getBaseEnumType() {
        SchemaType.Ref ref = this._baseEnumTyperef;
        if (ref == null) {
            return null;
        }
        return ref.get();
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaType getBaseType() {
        SchemaType.Ref ref = this._baseTyperef;
        if (ref == null) {
            return null;
        }
        return ref.get();
    }

    public XmlAnySimpleType[] getBasicFacets() {
        XmlAnySimpleType[] xmlAnySimpleTypeArr = new XmlAnySimpleType[12];
        for (int i5 = 0; i5 <= 11; i5++) {
            xmlAnySimpleTypeArr[i5] = getFacet(i5);
        }
        return xmlAnySimpleTypeArr;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public int getBuiltinTypeCode() {
        return this._builtinTypeCode;
    }

    public String getChameleonNamespace() {
        if (this._chameleon) {
            return this._parseTNS;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6, types: [org.apache.xmlbeans.impl.schema.SchemaTypeImpl] */
    @Override // org.apache.xmlbeans.SchemaType
    public SchemaType getCommonBaseType(SchemaType schemaType) {
        Object baseType;
        SchemaTypeImpl schemaTypeImpl = BuiltinSchemaTypeSystem.ST_ANY_TYPE;
        if (this == schemaTypeImpl || schemaType == 0 || schemaType.isNoType()) {
            return this;
        }
        if (schemaType != schemaTypeImpl && !isNoType()) {
            while (true) {
                baseType = schemaType;
                schemaType = (SchemaTypeImpl) baseType;
                if (schemaType.getBaseDepth() <= getBaseDepth()) {
                    break;
                }
                baseType = schemaType.getBaseType();
            }
            SchemaTypeImpl schemaTypeImpl2 = this;
            while (schemaTypeImpl2.getBaseDepth() > schemaType.getBaseDepth()) {
                schemaTypeImpl2 = (SchemaTypeImpl) schemaTypeImpl2.getBaseType();
            }
            while (!schemaType.equals(schemaTypeImpl2)) {
                schemaType = (SchemaTypeImpl) schemaType.getBaseType();
                schemaTypeImpl2 = (SchemaTypeImpl) schemaTypeImpl2.getBaseType();
            }
        }
        baseType = schemaType;
        return schemaType;
    }

    @Override // org.apache.xmlbeans.SchemaComponent
    public SchemaComponent.Ref getComponentRef() {
        return getRef();
    }

    @Override // org.apache.xmlbeans.SchemaComponent
    public int getComponentType() {
        return 0;
    }

    public SchemaContainer getContainer() {
        return this._container;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public synchronized SchemaField getContainerField() {
        try {
            if (this._containerFieldCode != -1) {
                SchemaType outerType = getOuterType();
                if (this._containerFieldCode == 0) {
                    this._containerField = this._containerFieldRef == null ? null : (SchemaField) this._containerFieldRef.getComponent();
                } else if (this._containerFieldCode == 1) {
                    this._containerField = outerType.getAttributeModel().getAttributes()[this._containerFieldIndex];
                } else {
                    this._containerField = ((SchemaTypeImpl) outerType).getLocalElementByIndex(this._containerFieldIndex);
                }
                this._containerFieldCode = -1;
            }
        } catch (Throwable th) {
            throw th;
        }
        return this._containerField;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaType getContentBasedOnType() {
        SchemaType.Ref ref = this._contentBasedOnTyperef;
        if (ref == null) {
            return null;
        }
        return ref.get();
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaParticle getContentModel() {
        return this._contentModel;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public int getContentType() {
        return this._complexTypeVariety;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public int getDecimalSize() {
        return this._decimalSize;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public int getDerivationType() {
        return this._derivationType;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaProperty[] getDerivedProperties() {
        SchemaType baseType = getBaseType();
        if (baseType == null) {
            return getProperties();
        }
        ArrayList arrayList = new ArrayList();
        Map<QName, SchemaProperty> map = this._propertyModelByElementName;
        if (map != null) {
            arrayList.addAll(map.values());
        }
        Map<QName, SchemaProperty> map2 = this._propertyModelByAttributeName;
        if (map2 != null) {
            arrayList.addAll(map2.values());
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            SchemaProperty schemaProperty = (SchemaProperty) it.next();
            SchemaProperty attributeProperty = schemaProperty.isAttribute() ? baseType.getAttributeProperty(schemaProperty.getName()) : baseType.getElementProperty(schemaProperty.getName());
            if (attributeProperty != null && eq(schemaProperty.getMinOccurs(), attributeProperty.getMinOccurs()) && eq(schemaProperty.getMaxOccurs(), attributeProperty.getMaxOccurs()) && schemaProperty.hasNillable() == attributeProperty.hasNillable() && eq(schemaProperty.getDefaultText(), attributeProperty.getDefaultText())) {
                it.remove();
            }
        }
        return (SchemaProperty[]) arrayList.toArray(new SchemaProperty[0]);
    }

    @Override // org.apache.xmlbeans.SchemaType
    public QName getDocumentElementName() {
        SchemaParticle contentModel;
        if (!this._isDocumentType || (contentModel = getContentModel()) == null) {
            return null;
        }
        return contentModel.getName();
    }

    @Override // org.apache.xmlbeans.SchemaType
    public String getDocumentation() {
        if (this._documentation == null) {
            this._documentation = parseDocumentation(this._parseObject);
        }
        return this._documentation;
    }

    public String getElemFormDefault() {
        return this._elemFormDefault;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaProperty[] getElementProperties() {
        Map<QName, SchemaProperty> map = this._propertyModelByElementName;
        return map == null ? NO_PROPERTIES : (SchemaProperty[]) map.values().toArray(new SchemaProperty[0]);
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaProperty getElementProperty(QName qName) {
        Map<QName, SchemaProperty> map = this._propertyModelByElementName;
        if (map == null) {
            return null;
        }
        return map.get(qName);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.xmlbeans.SchemaType
    public SchemaTypeElementSequencer getElementSequencer() {
        return this._complexTypeVariety == 0 ? new SequencerImpl(null) : new SequencerImpl(new SchemaTypeVisitorImpl(this._contentModel));
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaType getElementType(QName qName, QName qName2, SchemaTypeLoader schemaTypeLoader) {
        SchemaType type;
        SchemaType schemaTypeFindType;
        if (isSimpleType() || noElements() || isNoType()) {
            return BuiltinSchemaTypeSystem.ST_NO_TYPE;
        }
        SchemaProperty schemaProperty = this._propertyModelByElementName.get(qName);
        if (schemaProperty != null) {
            type = schemaProperty.getType();
        } else {
            if (schemaTypeLoader == null) {
                return BuiltinSchemaTypeSystem.ST_NO_TYPE;
            }
            if (!this._typedWildcardElements.contains(qName) && !this._validSubstitutions.contains(qName)) {
                return BuiltinSchemaTypeSystem.ST_NO_TYPE;
            }
            SchemaGlobalElement schemaGlobalElementFindElement = schemaTypeLoader.findElement(qName);
            if (schemaGlobalElementFindElement == null) {
                return BuiltinSchemaTypeSystem.ST_NO_TYPE;
            }
            type = schemaGlobalElementFindElement.getType();
        }
        return (qName2 == null || schemaTypeLoader == null || (schemaTypeFindType = schemaTypeLoader.findType(qName2)) == null || !type.isAssignableFrom(schemaTypeFindType)) ? type : schemaTypeFindType;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public Class<? extends StringEnumAbstractBase> getEnumJavaClass() {
        if (this._javaEnumClass == null && getBaseEnumType() != null) {
            try {
                this._javaEnumClass = Class.forName(getBaseEnumType().getFullJavaName() + "$Enum", false, getTypeSystem().getClassLoader());
            } catch (ClassNotFoundException unused) {
                this._javaEnumClass = null;
            }
        }
        return this._javaEnumClass;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public XmlAnySimpleType[] getEnumerationValues() {
        XmlValueRef[] xmlValueRefArr = this._enumerationValues;
        if (xmlValueRefArr == null) {
            return null;
        }
        int length = xmlValueRefArr.length;
        XmlAnySimpleType[] xmlAnySimpleTypeArr = new XmlAnySimpleType[length];
        for (int i5 = 0; i5 < length; i5++) {
            XmlValueRef xmlValueRef = this._enumerationValues[i5];
            xmlAnySimpleTypeArr[i5] = xmlValueRef == null ? null : xmlValueRef.get();
        }
        return xmlAnySimpleTypeArr;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public XmlAnySimpleType getFacet(int i5) {
        XmlValueRef xmlValueRef;
        XmlValueRef[] xmlValueRefArr = this._facetArray;
        if (xmlValueRefArr == null || (xmlValueRef = xmlValueRefArr[i5]) == null) {
            return null;
        }
        return xmlValueRef.get();
    }

    public boolean[] getFixedFacets() {
        return boaCopy(this._fixedFacetArray);
    }

    @Override // org.apache.xmlbeans.SchemaType
    public String getFullJavaImplName() {
        return this._fullJavaImplName;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public String getFullJavaName() {
        return this._fullJavaName;
    }

    public QName[] getGroupReferenceContext() {
        return this._groupReferenceContext;
    }

    public int getIndexForLocalAttribute(SchemaLocalAttribute schemaLocalAttribute) {
        Map<SchemaLocalAttribute, Integer> map = this._attrToIndexMap;
        Map map2 = map;
        if (map == null) {
            HashMap map3 = new HashMap();
            SchemaLocalAttribute[] attributes = this._attributeModel.getAttributes();
            for (int i5 = 0; i5 < attributes.length; i5++) {
                map3.put(attributes[i5], Integer.valueOf(i5));
            }
            this._attrToIndexMap = map3;
            map2 = map3;
        }
        return ((Integer) map2.get(schemaLocalAttribute)).intValue();
    }

    public int getIndexForLocalElement(SchemaLocalElement schemaLocalElement) {
        Map<SchemaLocalElement, Integer> map = this._eltToIndexMap;
        Map map2 = map;
        if (map == null) {
            if (this._localElts == null) {
                buildLocalElts();
            }
            HashMap map3 = new HashMap();
            for (int i5 = 0; i5 < this._localElts.length; i5++) {
                map3.put(this._localElts[i5], Integer.valueOf(i5));
            }
            this._eltToIndexMap = map3;
            map2 = map3;
        }
        return ((Integer) map2.get(schemaLocalElement)).intValue();
    }

    public InterfaceExtension[] getInterfaceExtensions() {
        return this._interfaces;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public Class<? extends XmlObject> getJavaClass() {
        if (this._javaClass == null && getFullJavaName() != null) {
            try {
                this._javaClass = Class.forName(getFullJavaName(), false, getTypeSystem().getClassLoader());
            } catch (ClassNotFoundException unused) {
                this._javaClass = null;
            }
        }
        return this._javaClass;
    }

    public Class<? extends XmlObjectBase> getJavaImplClass() {
        if (this._implNotAvailable) {
            return null;
        }
        if (this._javaImplClass == null) {
            try {
                if (getFullJavaImplName() != null) {
                    this._javaImplClass = Class.forName(getFullJavaImplName(), false, getTypeSystem().getClassLoader());
                } else {
                    this._implNotAvailable = true;
                }
            } catch (ClassNotFoundException unused) {
                this._implNotAvailable = true;
            }
        }
        return this._javaImplClass;
    }

    public Constructor<? extends XmlObjectBase> getJavaImplConstructor() {
        if (this._javaImplConstructor == null && !this._implNotAvailable) {
            Class<? extends XmlObjectBase> javaImplClass = getJavaImplClass();
            if (javaImplClass == null) {
                return null;
            }
            try {
                this._javaImplConstructor = javaImplClass.getConstructor(SchemaType.class);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return this._javaImplConstructor;
    }

    public Constructor<? extends XmlObjectBase> getJavaImplConstructor2() {
        if (this._javaImplConstructor2 == null && !this._implNotAvailable) {
            Class<? extends XmlObjectBase> javaImplClass = getJavaImplClass();
            if (javaImplClass == null) {
                return null;
            }
            try {
                this._javaImplConstructor2 = javaImplClass.getDeclaredConstructor(SchemaType.class, Boolean.TYPE);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return this._javaImplConstructor2;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaType getListItemType() {
        SchemaType.Ref ref = this._listItemTyperef;
        if (ref == null) {
            return null;
        }
        return ref.get();
    }

    public SchemaLocalElement getLocalElementByIndex(int i5) {
        SchemaLocalElement[] schemaLocalElementArr = this._localElts;
        if (schemaLocalElementArr == null) {
            buildLocalElts();
            schemaLocalElementArr = this._localElts;
        }
        return schemaLocalElementArr[i5];
    }

    @Override // org.apache.xmlbeans.SchemaType, org.apache.xmlbeans.SchemaComponent
    public QName getName() {
        return this._name;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaType getOuterType() {
        SchemaType.Ref ref = this._outerSchemaTypeRef;
        if (ref == null) {
            return null;
        }
        return ref.get();
    }

    public XmlObject getParseObject() {
        return this._parseObject;
    }

    public RegularExpression[] getPatternExpressions() {
        RegularExpression[] regularExpressionArr = this._patterns;
        if (regularExpressionArr == null) {
            return new RegularExpression[0];
        }
        RegularExpression[] regularExpressionArr2 = new RegularExpression[regularExpressionArr.length];
        System.arraycopy(regularExpressionArr, 0, regularExpressionArr2, 0, regularExpressionArr.length);
        return regularExpressionArr2;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public String[] getPatterns() {
        RegularExpression[] regularExpressionArr = this._patterns;
        int i5 = 0;
        if (regularExpressionArr == null) {
            return new String[0];
        }
        String[] strArr = new String[regularExpressionArr.length];
        while (true) {
            RegularExpression[] regularExpressionArr2 = this._patterns;
            if (i5 >= regularExpressionArr2.length) {
                return strArr;
            }
            strArr[i5] = regularExpressionArr2[i5].getPattern();
            i5++;
        }
    }

    public PrePostExtension getPrePostExtension() {
        return this._prepost;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaType getPrimitiveType() {
        SchemaType.Ref ref = this._primitiveTypeRef;
        if (ref == null) {
            return null;
        }
        return ref.get();
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaProperty[] getProperties() {
        if (this._propertyModelByElementName == null) {
            return getAttributeProperties();
        }
        if (this._propertyModelByAttributeName == null) {
            return getElementProperties();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this._propertyModelByElementName.values());
        arrayList.addAll(this._propertyModelByAttributeName.values());
        return (SchemaProperty[]) arrayList.toArray(new SchemaProperty[0]);
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaType.Ref getRef() {
        return this._selfref;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public String getShortJavaImplName() {
        return this._shortJavaImplName;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public String getShortJavaName() {
        return this._shortJavaName;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public int getSimpleVariety() {
        return this._simpleTypeVariety;
    }

    @Override // org.apache.xmlbeans.SchemaComponent
    public String getSourceName() {
        String str = this._filename;
        if (str != null) {
            return str;
        }
        if (getOuterType() != null) {
            return getOuterType().getSourceName();
        }
        SchemaField containerField = getContainerField();
        if (containerField == null) {
            return null;
        }
        if (containerField instanceof SchemaGlobalElement) {
            return ((SchemaGlobalElement) containerField).getSourceName();
        }
        if (containerField instanceof SchemaGlobalAttribute) {
            return ((SchemaGlobalAttribute) containerField).getSourceName();
        }
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaStringEnumEntry[] getStringEnumEntries() {
        SchemaStringEnumEntry[] schemaStringEnumEntryArr = this._stringEnumEntries;
        if (schemaStringEnumEntryArr == null) {
            return null;
        }
        int length = schemaStringEnumEntryArr.length;
        SchemaStringEnumEntry[] schemaStringEnumEntryArr2 = new SchemaStringEnumEntry[length];
        System.arraycopy(schemaStringEnumEntryArr, 0, schemaStringEnumEntryArr2, 0, length);
        return schemaStringEnumEntryArr2;
    }

    public QName getSubstitutionGroup() {
        return this._sg;
    }

    public QName[] getSubstitutionGroupMembers() {
        return (QName[]) this._sgMembers.toArray(new QName[0]);
    }

    public String getTargetNamespace() {
        return this._parseTNS;
    }

    @Override // org.apache.xmlbeans.SchemaType, org.apache.xmlbeans.SchemaComponent
    public SchemaTypeSystem getTypeSystem() {
        return this._container.getTypeSystem();
    }

    @Override // org.apache.xmlbeans.SchemaType
    public synchronized SchemaType getUnionCommonBaseType() {
        try {
            if (this._unionCommonBaseType == null) {
                computeFlatUnionModel();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this._unionCommonBaseType;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public synchronized SchemaType[] getUnionConstituentTypes() {
        try {
            if (this._unionCommonBaseType == null) {
                computeFlatUnionModel();
            }
        } catch (Throwable th) {
            throw th;
        }
        return staCopy(this._unionConstituentTypes);
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaType[] getUnionMemberTypes() {
        SchemaType.Ref[] refArr = this._unionMemberTyperefs;
        int length = refArr == null ? 0 : refArr.length;
        SchemaType[] schemaTypeArr = new SchemaType[length];
        for (int i5 = 0; i5 < length; i5++) {
            schemaTypeArr[i5] = this._unionMemberTyperefs[i5].get();
        }
        return schemaTypeArr;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public synchronized SchemaType[] getUnionSubTypes() {
        try {
            if (this._unionCommonBaseType == null) {
                computeFlatUnionModel();
            }
        } catch (Throwable th) {
            throw th;
        }
        return staCopy(this._unionSubTypes);
    }

    @Override // org.apache.xmlbeans.SchemaType
    public Object getUserData() {
        return this._userData;
    }

    public String getUserTypeHandlerName() {
        return this._userTypeHandler;
    }

    public String getUserTypeName() {
        return this._userTypeName;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public int getWhiteSpaceRule() {
        return this._whiteSpaceRule;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean hasAllContent() {
        return this._hasAllContent;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean hasAttributeWildcards() {
        return this._hasWildcardAttributes;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean hasElementWildcards() {
        return this._hasWildcardElements;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean hasPatternFacet() {
        return this._hasPatterns;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean hasStringEnumValues() {
        return this._stringEnumEntries != null;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean isAbstract() {
        return this._abs;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean isAnonymousType() {
        return this._name == null;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean isAssignableFrom(SchemaType schemaType) {
        if (schemaType == null || schemaType.isNoType()) {
            return true;
        }
        if (isNoType()) {
            return false;
        }
        if (getSimpleVariety() == 2) {
            for (SchemaType schemaType2 : getUnionMemberTypes()) {
                if (schemaType2.isAssignableFrom(schemaType)) {
                    return true;
                }
            }
        }
        int baseDepth = ((SchemaTypeImpl) schemaType).getBaseDepth() - getBaseDepth();
        if (baseDepth < 0) {
            return false;
        }
        while (baseDepth > 0) {
            schemaType = schemaType.getBaseType();
            baseDepth--;
        }
        return schemaType != null && schemaType.equals(this);
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean isAttributeType() {
        return this._isAttributeType;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean isBounded() {
        return this._isBounded;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean isBuiltinType() {
        return getBuiltinTypeCode() != 0;
    }

    public boolean isChameleon() {
        return this._chameleon;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean isCompiled() {
        return this._isCompiled;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean isDocumentType() {
        return this._isDocumentType;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean isFacetFixed(int i5) {
        return this._fixedFacetArray[i5];
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean isFinite() {
        return this._isFinite;
    }

    public boolean isJavaized() {
        return this._resolvePhase == 6;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean isNoType() {
        return this == BuiltinSchemaTypeSystem.ST_NO_TYPE;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean isNumeric() {
        return this._isNumeric;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean isOrderSensitive() {
        return this._orderSensitive;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean isPrimitiveType() {
        return getBuiltinTypeCode() >= 2 && getBuiltinTypeCode() <= 21;
    }

    public boolean isRedefinition() {
        return this._redefinition;
    }

    public boolean isResolved() {
        return this._resolvePhase >= 4;
    }

    public boolean isResolving() {
        return this._resolvePhase == 3;
    }

    public boolean isSGResolved() {
        return this._resolvePhase >= 2;
    }

    public boolean isSGResolving() {
        return this._resolvePhase >= 1;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean isSimpleType() {
        return this._isSimpleType;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean isSkippedAnonymousType() {
        SchemaType outerType = getOuterType();
        if (outerType != null) {
            return outerType.getBaseType() == this || outerType.getContentBasedOnType() == this;
        }
        return false;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean isURType() {
        int i5 = this._builtinTypeCode;
        return i5 == 1 || i5 == 2;
    }

    public boolean isUnionOfLists() {
        return this._isUnionOfLists;
    }

    public boolean isUnjavaized() {
        return this._resolvePhase < 6;
    }

    public boolean isUnloaded() {
        return this._unloaded;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean isValidSubstitution(QName qName) {
        return this._validSubstitutions.contains(qName);
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean matchPatternFacet(String str) {
        if (!this._hasPatterns) {
            return true;
        }
        RegularExpression[] regularExpressionArr = this._patterns;
        if (regularExpressionArr != null && regularExpressionArr.length > 0) {
            int i5 = 0;
            while (true) {
                RegularExpression[] regularExpressionArr2 = this._patterns;
                if (i5 >= regularExpressionArr2.length || regularExpressionArr2[i5].matches(str)) {
                    break;
                }
                i5++;
            }
            if (i5 >= this._patterns.length) {
                return false;
            }
        }
        return getBaseType().matchPatternFacet(str);
    }

    public XmlAnySimpleType newValidatingValue(Object obj) {
        return newValue(obj, true);
    }

    @Override // org.apache.xmlbeans.SchemaType
    public XmlAnySimpleType newValue(Object obj) {
        return newValue(obj, false);
    }

    @Override // org.apache.xmlbeans.SchemaType
    public int ordered() {
        return this._ordered;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public QNameSet qnameSetForWildcardAttributes() {
        QNameSet wildcardSet = getAttributeModel().getWildcardSet();
        if (wildcardSet == null) {
            return QNameSet.EMPTY;
        }
        QNameSetBuilder qNameSetBuilder = new QNameSetBuilder(wildcardSet);
        for (SchemaProperty schemaProperty : getAttributeProperties()) {
            qNameSetBuilder.remove(schemaProperty.getName());
        }
        return qNameSetBuilder.toQNameSet();
    }

    @Override // org.apache.xmlbeans.SchemaType
    public QNameSet qnameSetForWildcardElements() {
        SchemaParticle contentModel = getContentModel();
        QNameSetBuilder qNameSetBuilder = new QNameSetBuilder();
        computeWildcardSet(contentModel, qNameSetBuilder);
        QNameSetBuilder qNameSetBuilder2 = new QNameSetBuilder(qNameSetBuilder);
        for (SchemaProperty schemaProperty : getElementProperties()) {
            qNameSetBuilder2.remove(schemaProperty.getName());
        }
        return qNameSetBuilder2.toQNameSet();
    }

    public void setAbstractFinal(boolean z6, boolean z7, boolean z8, boolean z9, boolean z10) {
        assertResolving();
        this._abs = z6;
        this._finalExt = z7;
        this._finalRest = z8;
        this._finalList = z9;
        this._finalUnion = z10;
    }

    public void setAnnotation(SchemaAnnotation schemaAnnotation) {
        assertUnresolved();
        this._annotation = schemaAnnotation;
    }

    public void setAnonymousTypeRefs(SchemaType.Ref[] refArr) {
        this._anonymousTyperefs = refArr == null ? null : (SchemaType.Ref[]) refArr.clone();
    }

    public void setAnonymousUnionMemberOrdinal(int i5) {
        assertUnresolved();
        this._anonymousUnionMemberOrdinal = i5;
    }

    public void setAttributeType(boolean z6) {
        assertUnresolved();
        this._isAttributeType = z6;
    }

    public void setBaseDepth(int i5) {
        assertResolving();
        this._baseDepth = i5;
    }

    public void setBaseEnumTypeRef(SchemaType.Ref ref) {
        this._baseEnumTyperef = ref;
    }

    public void setBaseTypeRef(SchemaType.Ref ref) {
        assertResolving();
        this._baseTyperef = ref;
    }

    public void setBasicFacets(XmlValueRef[] xmlValueRefArr, boolean[] zArr) {
        assertResolving();
        this._facetArray = xmlValueRefArr == null ? null : (XmlValueRef[]) xmlValueRefArr.clone();
        this._fixedFacetArray = zArr != null ? (boolean[]) zArr.clone() : null;
    }

    public void setBlock(boolean z6, boolean z7) {
        assertResolving();
        this._blockExt = z6;
        this._blockRest = z7;
    }

    public void setBounded(boolean z6) {
        assertResolving();
        this._isBounded = z6;
    }

    public void setBuiltinTypeCode(int i5) {
        assertResolving();
        this._builtinTypeCode = i5;
    }

    public void setCompiled(boolean z6) {
        assertJavaizing();
        this._isCompiled = z6;
    }

    public void setComplexTypeVariety(int i5) {
        assertResolving();
        this._complexTypeVariety = i5;
    }

    public void setContainer(SchemaContainer schemaContainer) {
        this._container = schemaContainer;
    }

    public void setContainerField(SchemaField schemaField) {
        assertUnresolved();
        this._containerField = schemaField;
        this._containerFieldCode = -1;
    }

    public void setContainerFieldIndex(short s6, int i5) {
        assertUnresolved();
        this._containerFieldCode = s6;
        this._containerFieldIndex = i5;
    }

    public void setContainerFieldRef(SchemaComponent.Ref ref) {
        assertUnresolved();
        this._containerFieldRef = ref;
        this._containerFieldCode = 0;
    }

    public void setContentBasedOnTypeRef(SchemaType.Ref ref) {
        assertResolving();
        this._contentBasedOnTyperef = ref;
    }

    public void setContentModel(SchemaParticle schemaParticle, SchemaAttributeModel schemaAttributeModel, Map<QName, SchemaProperty> map, Map<QName, SchemaProperty> map2, boolean z6) {
        assertResolving();
        this._contentModel = schemaParticle;
        this._attributeModel = schemaAttributeModel;
        this._propertyModelByElementName = map;
        this._propertyModelByAttributeName = map2;
        this._hasAllContent = z6;
        if (map != null) {
            this._validSubstitutions = new LinkedHashSet();
            Iterator<SchemaProperty> it = this._propertyModelByElementName.values().iterator();
            while (it.hasNext()) {
                for (QName qName : it.next().acceptedNames()) {
                    if (!this._propertyModelByElementName.containsKey(qName)) {
                        this._validSubstitutions.add(qName);
                    }
                }
            }
        }
    }

    public void setDecimalSize(int i5) {
        assertResolving();
        this._decimalSize = i5;
    }

    public void setDerivationType(int i5) {
        assertResolving();
        this._derivationType = i5;
    }

    public void setDocumentType(boolean z6) {
        assertUnresolved();
        this._isDocumentType = z6;
    }

    public void setEnumerationValues(XmlValueRef[] xmlValueRefArr) {
        assertResolving();
        this._enumerationValues = xmlValueRefArr == null ? null : (XmlValueRef[]) xmlValueRefArr.clone();
    }

    public void setFilename(String str) {
        assertUnresolved();
        this._filename = str;
    }

    public void setFinite(boolean z6) {
        assertResolving();
        this._isFinite = z6;
    }

    public void setFullJavaImplName(String str) {
        assertResolved();
        this._fullJavaImplName = str;
        this._shortJavaImplName = this._fullJavaImplName.substring(Math.max(str.lastIndexOf(36), this._fullJavaImplName.lastIndexOf(46)) + 1);
    }

    public void setFullJavaName(String str) {
        assertResolved();
        this._fullJavaName = str;
        this._shortJavaName = this._fullJavaName.substring(Math.max(str.lastIndexOf(36), this._fullJavaName.lastIndexOf(46)) + 1);
    }

    public void setGroupReferenceContext(QName[] qNameArr) {
        assertUnresolved();
        this._groupReferenceContext = qNameArr;
    }

    public void setInterfaceExtensions(InterfaceExtension[] interfaceExtensionArr) {
        assertResolved();
        this._interfaces = interfaceExtensionArr == null ? null : (InterfaceExtension[]) interfaceExtensionArr.clone();
    }

    public void setJavaClass(Class<? extends XmlObject> cls) {
        assertResolved();
        this._javaClass = cls;
        setFullJavaName(cls.getName());
    }

    public void setListItemTypeRef(SchemaType.Ref ref) {
        assertResolving();
        this._listItemTyperef = ref;
    }

    public void setName(QName qName) {
        assertUnresolved();
        this._name = qName;
    }

    public void setNumeric(boolean z6) {
        assertResolving();
        this._isNumeric = z6;
    }

    public void setOrderSensitive(boolean z6) {
        assertJavaizing();
        this._orderSensitive = z6;
    }

    public void setOrdered(int i5) {
        assertResolving();
        this._ordered = i5;
    }

    public void setOuterSchemaTypeRef(SchemaType.Ref ref) {
        assertUnresolved();
        this._outerSchemaTypeRef = ref;
    }

    public void setParseContext(XmlObject xmlObject, String str, boolean z6, String str2, String str3, boolean z7) {
        this._parseObject = xmlObject;
        this._parseTNS = str;
        this._chameleon = z6;
        this._elemFormDefault = str2;
        this._attFormDefault = str3;
        this._redefinition = z7;
    }

    public void setPatternFacet(boolean z6) {
        assertResolving();
        this._hasPatterns = z6;
    }

    public void setPatterns(RegularExpression[] regularExpressionArr) {
        assertResolving();
        this._patterns = regularExpressionArr == null ? null : (RegularExpression[]) regularExpressionArr.clone();
    }

    public void setPrePostExtension(PrePostExtension prePostExtension) {
        assertResolved();
        this._prepost = prePostExtension;
    }

    public void setPrimitiveTypeRef(SchemaType.Ref ref) {
        assertResolving();
        this._primitiveTypeRef = ref;
    }

    public void setShortJavaImplName(String str) {
        assertResolved();
        this._shortJavaImplName = str;
        SchemaType outerType = this._outerSchemaTypeRef.get();
        while (outerType.getFullJavaImplName() == null) {
            outerType = outerType.getOuterType();
        }
        this._fullJavaImplName = outerType.getFullJavaImplName() + "$" + this._shortJavaImplName;
    }

    public void setShortJavaName(String str) {
        assertResolved();
        this._shortJavaName = str;
        SchemaType outerType = this._outerSchemaTypeRef.get();
        while (outerType.getFullJavaName() == null) {
            outerType = outerType.getOuterType();
        }
        this._fullJavaName = outerType.getFullJavaName() + "$" + this._shortJavaName;
    }

    public void setSimpleFinal(boolean z6, boolean z7, boolean z8) {
        assertResolving();
        this._finalRest = z6;
        this._finalList = z7;
        this._finalUnion = z8;
    }

    public void setSimpleType(boolean z6) {
        assertUnresolved();
        this._isSimpleType = z6;
    }

    public void setSimpleTypeVariety(int i5) {
        assertResolving();
        this._simpleTypeVariety = i5;
    }

    public void setStringEnumEntries(SchemaStringEnumEntry[] schemaStringEnumEntryArr) {
        assertJavaizing();
        this._stringEnumEntries = schemaStringEnumEntryArr == null ? null : (SchemaStringEnumEntry[]) schemaStringEnumEntryArr.clone();
    }

    public void setSubstitutionGroup(QName qName) {
        assertSGResolving();
        this._sg = qName;
    }

    public void setUnionMemberTypeRefs(SchemaType.Ref[] refArr) {
        assertResolving();
        this._unionMemberTyperefs = refArr == null ? null : (SchemaType.Ref[]) refArr.clone();
    }

    public void setUnionOfLists(boolean z6) {
        assertResolving();
        this._isUnionOfLists = z6;
    }

    public void setUserData(Object obj) {
        this._userData = obj;
    }

    public void setUserTypeHandlerName(String str) {
        this._userTypeHandler = str;
    }

    public void setUserTypeName(String str) {
        this._userTypeName = str;
    }

    public void setWhiteSpaceRule(int i5) {
        assertResolving();
        this._whiteSpaceRule = i5;
    }

    public void setWildcardSummary(QNameSet qNameSet, boolean z6, QNameSet qNameSet2, boolean z7) {
        assertResolving();
        this._typedWildcardElements = qNameSet;
        this._hasWildcardElements = z6;
        this._typedWildcardAttributes = qNameSet2;
        this._hasWildcardAttributes = z7;
    }

    public void startJavaizing() {
        if (this._resolvePhase != 4) {
            throw new IllegalStateException();
        }
        this._resolvePhase = 5;
    }

    public void startResolving() {
        boolean z6 = this._isDocumentType;
        if ((z6 && this._resolvePhase != 2) || (!z6 && this._resolvePhase != 0)) {
            throw new IllegalStateException();
        }
        this._resolvePhase = 3;
    }

    public void startResolvingSGs() {
        if (this._resolvePhase != 0) {
            throw new IllegalStateException();
        }
        this._resolvePhase = 1;
    }

    public String toString() {
        String string;
        String str;
        if (getName() != null) {
            return "T=" + QNameHelper.pretty(getName());
        }
        if (isDocumentType()) {
            return "D=" + QNameHelper.pretty(getDocumentElementName());
        }
        if (isAttributeType()) {
            return "R=" + QNameHelper.pretty(getAttributeTypeAttributeName());
        }
        if (getContainerField() != null) {
            StringBuilder sb = new StringBuilder();
            if (getContainerField().getName().getNamespaceURI().length() > 0) {
                str = getContainerField().isAttribute() ? "Q=" : "E=";
            } else {
                str = getContainerField().isAttribute() ? "A=" : "U=";
            }
            sb.append(str);
            sb.append(getContainerField().getName().getLocalPart());
            string = sb.toString();
            if (getOuterType() == null) {
                StringBuilder sbX = AbstractC0157z.x(string, "@");
                sbX.append(getContainerField().getName().getNamespaceURI());
                return sbX.toString();
            }
        } else {
            if (isNoType()) {
                return "N=";
            }
            if (getOuterType() == null) {
                return "noouter";
            }
            if (getOuterType().getBaseType() == this) {
                string = "B=";
            } else if (getOuterType().getContentBasedOnType() == this) {
                string = "S=";
            } else if (getOuterType().getSimpleVariety() == 3) {
                string = "I=";
            } else if (getOuterType().getSimpleVariety() == 2) {
                string = "M=" + getAnonymousUnionMemberOrdinal();
            } else {
                string = "strange=";
            }
        }
        StringBuilder sbX2 = AbstractC0157z.x(string, "|");
        sbX2.append(getOuterType().toString());
        return sbX2.toString();
    }

    private static boolean eq(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public XmlAnySimpleType newValue(Object obj, boolean z6) {
        if (!isSimpleType() && getContentType() != 2) {
            throw new XmlValueOutOfRangeException();
        }
        XmlObjectBase xmlObjectBase = (XmlObjectBase) createUnattachedNode(null);
        if (z6) {
            xmlObjectBase.setValidateOnSet();
        }
        if (obj instanceof XmlObject) {
            xmlObjectBase.set_newValue((XmlObject) obj);
        } else {
            xmlObjectBase.setObjectValue(obj);
        }
        xmlObjectBase.check_dated();
        xmlObjectBase.setImmutable();
        return (XmlAnySimpleType) xmlObjectBase;
    }

    public SchemaTypeImpl(SchemaContainer schemaContainer, boolean z6) {
        this._container = schemaContainer;
        this._unloaded = z6;
        if (z6) {
            finishQuick();
        }
    }
}
