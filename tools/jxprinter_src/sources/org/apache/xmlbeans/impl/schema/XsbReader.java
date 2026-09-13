package org.apache.xmlbeans.impl.schema;

import A3.AbstractC0157z;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.namespace.QName;
import org.apache.poi.hssf.record.DimensionsRecord;
import org.apache.poi.hssf.record.pivottable.ExtendedPivotTableViewFieldsRecord;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaAnnotation;
import org.apache.xmlbeans.SchemaAttributeGroup;
import org.apache.xmlbeans.SchemaAttributeModel;
import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaLocalAttribute;
import org.apache.xmlbeans.SchemaLocalElement;
import org.apache.xmlbeans.SchemaModelGroup;
import org.apache.xmlbeans.SchemaParticle;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaStringEnumEntry;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoaderException;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.regex.RegularExpression;
import org.apache.xmlbeans.impl.util.LongUTFDataInputStream;
import org.apache.xmlbeans.impl.util.LongUTFDataOutputStream;
import org.apache.xmlbeans.impl.values.XmlObjectBase;
import org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroupDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.GroupDocument;
import org.apache.xmlbeans.soap.SOAPArrayType;
import org.apache.xmlbeans.soap.SchemaWSDLArrayType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
class XsbReader {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int MAX_UNSIGNED_SHORT = 65535;
    int _actualfiletype;
    private String _handle;
    private LongUTFDataInputStream _input;
    private int _majorver;
    private int _minorver;
    private LongUTFDataOutputStream _output;
    private int _releaseno;
    private SchemaTypeSystemImpl.StringPool _stringPool;
    private final SchemaTypeSystemImpl typeSystem;

    public XsbReader(SchemaTypeSystemImpl schemaTypeSystemImpl, String str) {
        this.typeSystem = schemaTypeSystemImpl;
        this._handle = str;
        this._stringPool = new SchemaTypeSystemImpl.StringPool(str, schemaTypeSystemImpl.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$writeClassnameMap$0(String str, SchemaComponent.Ref ref) {
        writeString(str);
        writeHandle(((SchemaType.Ref) ref).get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$writeIdConstraintData$1(String str, String str2) {
        writeString(str);
        writeString(str2);
    }

    public boolean atLeast(int i5, int i6, int i7) {
        int i8 = this._majorver;
        if (i8 > i5) {
            return true;
        }
        if (i8 < i5) {
            return false;
        }
        int i9 = this._minorver;
        if (i9 > i6) {
            return true;
        }
        return i9 >= i6 && this._releaseno >= i7;
    }

    public boolean atMost(int i5, int i6, int i7) {
        int i8 = this._majorver;
        if (i8 > i5) {
            return false;
        }
        if (i8 < i5) {
            return true;
        }
        int i9 = this._minorver;
        if (i9 > i6) {
            return false;
        }
        return i9 < i6 || this._releaseno <= i7;
    }

    public void checkContainerNotNull(SchemaContainer schemaContainer, QName qName) {
        if (schemaContainer != null) {
            return;
        }
        throw new LinkageError("Loading of resource " + qName + '.' + this._handle + "failed, information from " + qName + ".index.xsb is  out of sync (or conflicting index files found)");
    }

    public SchemaGlobalAttribute finishLoadingAttribute() {
        try {
            try {
                try {
                    QName qName = readQName();
                    SchemaContainer container = this.typeSystem.getContainer(qName.getNamespaceURI());
                    checkContainerNotNull(container, qName);
                    SchemaGlobalAttributeImpl schemaGlobalAttributeImpl = new SchemaGlobalAttributeImpl(container);
                    loadAttribute(schemaGlobalAttributeImpl, qName, container);
                    schemaGlobalAttributeImpl.setFilename(readString());
                    readEnd();
                    return schemaGlobalAttributeImpl;
                } catch (Exception e) {
                    throw new SchemaTypeLoaderException("Cannot load type from typesystem", this.typeSystem.getName(), this._handle, 14, e);
                }
            } catch (SchemaTypeLoaderException e6) {
                throw e6;
            }
        } catch (Throwable th) {
            readEnd();
            throw th;
        }
    }

    public SchemaAttributeGroup finishLoadingAttributeGroup() {
        QName qName = readQName();
        SchemaContainer container = this.typeSystem.getContainer(qName.getNamespaceURI());
        checkContainerNotNull(container, qName);
        SchemaAttributeGroupImpl schemaAttributeGroupImpl = new SchemaAttributeGroupImpl(container);
        try {
            try {
                String string = readString();
                boolean z6 = true;
                boolean z7 = readShort() == 1;
                String string2 = atLeast(2, 22, 0) ? readString() : null;
                if (!atLeast(2, 15, 0) || readShort() != 1) {
                    z6 = false;
                }
                schemaAttributeGroupImpl.init(qName, string, z7, string2, z6, AttributeGroupDocument.Factory.parse(readString()).getAttributeGroup(), readAnnotation(container), null);
                if (atLeast(2, 21, 0)) {
                    schemaAttributeGroupImpl.setFilename(readString());
                }
                readEnd();
                return schemaAttributeGroupImpl;
            } catch (SchemaTypeLoaderException e) {
                throw e;
            } catch (Exception e6) {
                throw new SchemaTypeLoaderException("Cannot load type from typesystem", this.typeSystem.getName(), this._handle, 14, e6);
            }
        } catch (Throwable th) {
            readEnd();
            throw th;
        }
    }

    public SchemaGlobalElement finishLoadingElement() {
        try {
            try {
                int i5 = readShort();
                if (i5 != 4) {
                    throw new SchemaTypeLoaderException("Wrong particle type ", this.typeSystem.getName(), this._handle, 11);
                }
                int i6 = readShort();
                BigInteger bigInteger = readBigInteger();
                BigInteger bigInteger2 = readBigInteger();
                QNameSet qNameSet = readQNameSet();
                QName qName = readQName();
                SchemaContainer container = this.typeSystem.getContainer(qName.getNamespaceURI());
                checkContainerNotNull(container, qName);
                SchemaGlobalElementImpl schemaGlobalElementImpl = new SchemaGlobalElementImpl(container);
                schemaGlobalElementImpl.setParticleType(i5);
                schemaGlobalElementImpl.setMinOccurs(bigInteger);
                schemaGlobalElementImpl.setMaxOccurs(bigInteger2);
                boolean z6 = true;
                schemaGlobalElementImpl.setTransitionRules(qNameSet, (i6 & 1) != 0);
                schemaGlobalElementImpl.setNameAndTypeRef(qName, readTypeRef());
                schemaGlobalElementImpl.setDefault(readString(), (i6 & 4) != 0, null);
                if (atLeast(2, 16, 0)) {
                    schemaGlobalElementImpl.setDefaultValue(readXmlValueObject());
                }
                schemaGlobalElementImpl.setNillable((i6 & 8) != 0);
                schemaGlobalElementImpl.setBlock((i6 & 16) != 0, (i6 & 32) != 0, (i6 & 64) != 0);
                schemaGlobalElementImpl.setWsdlArrayType(readSOAPArrayType());
                schemaGlobalElementImpl.setAbstract((i6 & 128) != 0);
                schemaGlobalElementImpl.setAnnotation(readAnnotation(container));
                boolean z7 = (i6 & 256) != 0;
                if ((i6 & 512) == 0) {
                    z6 = false;
                }
                schemaGlobalElementImpl.setFinal(z7, z6);
                if (atLeast(2, 17, 0)) {
                    schemaGlobalElementImpl.setSubstitutionGroup((SchemaGlobalElement.Ref) readHandle());
                }
                int i7 = readShort();
                for (int i8 = 0; i8 < i7; i8++) {
                    schemaGlobalElementImpl.addSubstitutionGroupMember(readQName());
                }
                int i9 = readShort();
                SchemaIdentityConstraint.Ref[] refArr = new SchemaIdentityConstraint.Ref[i9];
                for (int i10 = 0; i10 < i9; i10++) {
                    refArr[i10] = (SchemaIdentityConstraint.Ref) readHandle();
                }
                schemaGlobalElementImpl.setIdentityConstraints(refArr);
                schemaGlobalElementImpl.setFilename(readString());
                readEnd();
                return schemaGlobalElementImpl;
            } catch (SchemaTypeLoaderException e) {
                throw e;
            } catch (Exception e6) {
                throw new SchemaTypeLoaderException("Cannot load type from typesystem", this.typeSystem.getName(), null, 14, e6);
            }
        } catch (Throwable th) {
            readEnd();
            throw th;
        }
    }

    public SchemaIdentityConstraint finishLoadingIdentityConstraint() {
        try {
            try {
                try {
                    QName qName = readQName();
                    SchemaContainer container = this.typeSystem.getContainer(qName.getNamespaceURI());
                    checkContainerNotNull(container, qName);
                    SchemaIdentityConstraintImpl schemaIdentityConstraintImpl = new SchemaIdentityConstraintImpl(container);
                    schemaIdentityConstraintImpl.setName(qName);
                    schemaIdentityConstraintImpl.setConstraintCategory(readShort());
                    schemaIdentityConstraintImpl.setSelector(readString());
                    schemaIdentityConstraintImpl.setAnnotation(readAnnotation(container));
                    int i5 = readShort();
                    String[] strArr = new String[i5];
                    for (int i6 = 0; i6 < i5; i6++) {
                        strArr[i6] = readString();
                    }
                    schemaIdentityConstraintImpl.setFields(strArr);
                    if (schemaIdentityConstraintImpl.getConstraintCategory() == 2) {
                        schemaIdentityConstraintImpl.setReferencedKey((SchemaIdentityConstraint.Ref) readHandle());
                    }
                    int i7 = readShort();
                    HashMap map = new HashMap();
                    for (int i8 = 0; i8 < i7; i8++) {
                        map.put(readString(), readString());
                    }
                    schemaIdentityConstraintImpl.setNSMap(map);
                    if (atLeast(2, 21, 0)) {
                        schemaIdentityConstraintImpl.setFilename(readString());
                    }
                    readEnd();
                    return schemaIdentityConstraintImpl;
                } catch (SchemaTypeLoaderException e) {
                    throw e;
                }
            } catch (Exception e6) {
                throw new SchemaTypeLoaderException("Cannot load type from typesystem", this.typeSystem.getName(), this._handle, 14, e6);
            }
        } catch (Throwable th) {
            readEnd();
            throw th;
        }
    }

    public SchemaModelGroup finishLoadingModelGroup() {
        QName qName = readQName();
        SchemaContainer container = this.typeSystem.getContainer(qName.getNamespaceURI());
        checkContainerNotNull(container, qName);
        SchemaModelGroupImpl schemaModelGroupImpl = new SchemaModelGroupImpl(container);
        try {
            try {
                schemaModelGroupImpl.init(qName, readString(), readShort() == 1, atLeast(2, 22, 0) ? readString() : null, atLeast(2, 22, 0) ? readString() : null, atLeast(2, 15, 0) && readShort() == 1, GroupDocument.Factory.parse(readString()).getGroup(), readAnnotation(container), null);
                if (atLeast(2, 21, 0)) {
                    schemaModelGroupImpl.setFilename(readString());
                }
                readEnd();
                return schemaModelGroupImpl;
            } catch (SchemaTypeLoaderException e) {
                throw e;
            } catch (Exception e6) {
                throw new SchemaTypeLoaderException("Cannot load type from typesystem", this.typeSystem.getName(), this._handle, 14, e6);
            }
        } catch (Throwable th) {
            readEnd();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SchemaType finishLoadingType() {
        int i5;
        int i6;
        QName attributeTypeAttributeName;
        int i7;
        SchemaParticle schemaParticle;
        Map<QName, SchemaProperty> linkedHashMap;
        String str = "";
        try {
            try {
                try {
                    SchemaTypeImpl schemaTypeImpl = new SchemaTypeImpl(this.typeSystem.getContainerNonNull(""), true);
                    schemaTypeImpl.setName(readQName());
                    schemaTypeImpl.setOuterSchemaTypeRef(readTypeRef());
                    schemaTypeImpl.setBaseDepth(readShort());
                    schemaTypeImpl.setBaseTypeRef(readTypeRef());
                    schemaTypeImpl.setDerivationType(readShort());
                    schemaTypeImpl.setAnnotation(readAnnotation(null));
                    int i8 = readShort();
                    if (i8 == 1) {
                        schemaTypeImpl.setContainerFieldRef(readHandle());
                    } else if (i8 == 2) {
                        schemaTypeImpl.setContainerFieldIndex((short) 1, readShort());
                    } else if (i8 == 3) {
                        schemaTypeImpl.setContainerFieldIndex((short) 2, readShort());
                    }
                    String string = readString();
                    if (string == null) {
                        string = "";
                    }
                    schemaTypeImpl.setFullJavaName(string);
                    String string2 = readString();
                    if (string2 != null) {
                        str = string2;
                    }
                    schemaTypeImpl.setFullJavaImplName(str);
                    schemaTypeImpl.setAnonymousTypeRefs(readTypeRefArray());
                    schemaTypeImpl.setAnonymousUnionMemberOrdinal(readShort());
                    int i9 = readInt();
                    int i10 = 0;
                    boolean z6 = (i9 & 1) == 0;
                    schemaTypeImpl.setCompiled((i9 & 2048) != 0);
                    schemaTypeImpl.setDocumentType((i9 & 2) != 0);
                    schemaTypeImpl.setAttributeType((524288 & i9) != 0);
                    schemaTypeImpl.setSimpleType(!z6);
                    int i11 = 65536;
                    int i12 = 131072;
                    if (z6) {
                        schemaTypeImpl.setAbstractFinal((262144 & i9) != 0, (i9 & 16384) != 0, (i9 & 32768) != 0, (i9 & 131072) != 0, (i9 & 65536) != 0);
                        schemaTypeImpl.setBlock((i9 & 4096) != 0, (i9 & 8192) != 0);
                        schemaTypeImpl.setOrderSensitive((i9 & 512) != 0);
                        int i13 = readShort();
                        schemaTypeImpl.setComplexTypeVariety(i13);
                        if (atLeast(2, 23, 0)) {
                            schemaTypeImpl.setContentBasedOnTypeRef(readTypeRef());
                        }
                        SchemaAttributeModelImpl schemaAttributeModelImpl = new SchemaAttributeModelImpl();
                        int i14 = readShort();
                        for (int i15 = 0; i15 < i14; i15++) {
                            schemaAttributeModelImpl.addAttribute(readAttributeData());
                        }
                        schemaAttributeModelImpl.setWildcardSet(readQNameSet());
                        schemaAttributeModelImpl.setWildcardProcess(readShort());
                        Map<QName, SchemaProperty> linkedHashMap2 = new LinkedHashMap<>();
                        int i16 = readShort();
                        int i17 = 0;
                        while (i17 < i16) {
                            int i18 = i10;
                            SchemaProperty propertyData = readPropertyData();
                            if (!propertyData.isAttribute()) {
                                throw new SchemaTypeLoaderException("Attribute property " + i17 + " is not an attribute", this.typeSystem.getName(), this._handle, 6);
                            }
                            linkedHashMap2.put(propertyData.getName(), propertyData);
                            i17++;
                            i10 = i18;
                        }
                        i5 = i10;
                        if (i13 == 3 || i13 == 4) {
                            i7 = readShort();
                            SchemaParticle[] particleArray = readParticleArray();
                            if (particleArray.length == 1) {
                                schemaParticle = particleArray[i5];
                            } else {
                                if (particleArray.length != 0) {
                                    throw new SchemaTypeLoaderException("Content model not well-formed", this.typeSystem.getName(), this._handle, 7);
                                }
                                schemaParticle = null;
                            }
                            linkedHashMap = new LinkedHashMap<>();
                            int i19 = readShort();
                            for (int i20 = i5; i20 < i19; i20++) {
                                SchemaProperty propertyData2 = readPropertyData();
                                if (propertyData2.isAttribute()) {
                                    throw new SchemaTypeLoaderException("Element property " + i20 + " is not an element", this.typeSystem.getName(), this._handle, 6);
                                }
                                linkedHashMap.put(propertyData2.getName(), propertyData2);
                            }
                        } else {
                            i7 = i5;
                            schemaParticle = null;
                            linkedHashMap = null;
                        }
                        SchemaParticle schemaParticle2 = schemaParticle;
                        schemaTypeImpl.setContentModel(schemaParticle2, schemaAttributeModelImpl, linkedHashMap, linkedHashMap2, i7 == 1 ? 1 : i5);
                        StscComplexTypeResolver.WildcardResult wildcardResultSummarizeEltWildcards = StscComplexTypeResolver.summarizeEltWildcards(schemaParticle2);
                        StscComplexTypeResolver.WildcardResult wildcardResultSummarizeAttrWildcards = StscComplexTypeResolver.summarizeAttrWildcards(schemaAttributeModelImpl);
                        schemaTypeImpl.setWildcardSummary(wildcardResultSummarizeEltWildcards.typedWildcards, wildcardResultSummarizeEltWildcards.hasWildcards, wildcardResultSummarizeAttrWildcards.typedWildcards, wildcardResultSummarizeAttrWildcards.hasWildcards);
                        i6 = i13;
                    } else {
                        i5 = 0;
                        i11 = 65536;
                        i12 = 131072;
                        i6 = 0;
                    }
                    if (!z6 || i6 == 2) {
                        int i21 = readShort();
                        schemaTypeImpl.setSimpleTypeVariety(i21);
                        int i22 = (i9 & 64) != 0 ? 1 : i5;
                        schemaTypeImpl.setOrdered((i9 & 4) != 0 ? i5 : (i9 & 1024) != 0 ? 2 : 1);
                        schemaTypeImpl.setBounded((i9 & 8) != 0 ? 1 : i5);
                        schemaTypeImpl.setFinite((i9 & 16) != 0 ? 1 : i5);
                        schemaTypeImpl.setNumeric((i9 & 32) != 0 ? 1 : i5);
                        schemaTypeImpl.setUnionOfLists((i9 & 128) != 0 ? 1 : i5);
                        schemaTypeImpl.setSimpleFinal((i9 & 32768) != 0 ? 1 : i5, (i9 & i12) != 0 ? 1 : i5, (i9 & i11) != 0 ? 1 : i5);
                        XmlValueRef[] xmlValueRefArr = new XmlValueRef[12];
                        boolean[] zArr = new boolean[12];
                        int i23 = readShort();
                        for (int i24 = i5; i24 < i23; i24++) {
                            int i25 = readShort();
                            xmlValueRefArr[i25] = readXmlValueObject();
                            zArr[i25] = readShort() == 1 ? true : i5;
                        }
                        schemaTypeImpl.setBasicFacets(xmlValueRefArr, zArr);
                        schemaTypeImpl.setWhiteSpaceRule(readShort());
                        schemaTypeImpl.setPatternFacet((i9 & 256) != 0 ? 1 : i5);
                        int i26 = readShort();
                        RegularExpression[] regularExpressionArr = new RegularExpression[i26];
                        for (int i27 = i5; i27 < i26; i27++) {
                            regularExpressionArr[i27] = new RegularExpression(readString(), "X");
                        }
                        schemaTypeImpl.setPatterns(regularExpressionArr);
                        int i28 = readShort();
                        XmlValueRef[] xmlValueRefArr2 = new XmlValueRef[i28];
                        for (int i29 = i5; i29 < i28; i29++) {
                            xmlValueRefArr2[i29] = readXmlValueObject();
                        }
                        if (i28 == 0) {
                            xmlValueRefArr2 = null;
                        }
                        schemaTypeImpl.setEnumerationValues(xmlValueRefArr2);
                        schemaTypeImpl.setBaseEnumTypeRef(readTypeRef());
                        if (i22 != 0) {
                            int unsignedShortOrInt = readUnsignedShortOrInt();
                            SchemaStringEnumEntry[] schemaStringEnumEntryArr = new SchemaStringEnumEntry[unsignedShortOrInt];
                            for (int i30 = i5; i30 < unsignedShortOrInt; i30++) {
                                schemaStringEnumEntryArr[i30] = new SchemaStringEnumEntryImpl(readString(), readShort(), readString());
                            }
                            schemaTypeImpl.setStringEnumEntries(schemaStringEnumEntryArr);
                        }
                        if (i21 == 1) {
                            schemaTypeImpl.setPrimitiveTypeRef(readTypeRef());
                            schemaTypeImpl.setDecimalSize(readInt());
                        } else if (i21 == 2) {
                            schemaTypeImpl.setPrimitiveTypeRef(BuiltinSchemaTypeSystem.ST_ANY_SIMPLE.getRef());
                            schemaTypeImpl.setUnionMemberTypeRefs(readTypeRefArray());
                        } else {
                            if (i21 != 3) {
                                throw new SchemaTypeLoaderException("Simple type does not have a recognized variety", this.typeSystem.getName(), this._handle, 8);
                            }
                            schemaTypeImpl.setPrimitiveTypeRef(BuiltinSchemaTypeSystem.ST_ANY_SIMPLE.getRef());
                            schemaTypeImpl.setListItemTypeRef(readTypeRef());
                        }
                    }
                    schemaTypeImpl.setFilename(readString());
                    if (schemaTypeImpl.getName() != null) {
                        SchemaContainer container = this.typeSystem.getContainer(schemaTypeImpl.getName().getNamespaceURI());
                        checkContainerNotNull(container, schemaTypeImpl.getName());
                        schemaTypeImpl.setContainer(container);
                    } else if (schemaTypeImpl.isDocumentType()) {
                        QName documentElementName = schemaTypeImpl.getDocumentElementName();
                        if (documentElementName != null) {
                            SchemaContainer container2 = this.typeSystem.getContainer(documentElementName.getNamespaceURI());
                            checkContainerNotNull(container2, documentElementName);
                            schemaTypeImpl.setContainer(container2);
                        }
                    } else if (schemaTypeImpl.isAttributeType() && (attributeTypeAttributeName = schemaTypeImpl.getAttributeTypeAttributeName()) != null) {
                        SchemaContainer container3 = this.typeSystem.getContainer(attributeTypeAttributeName.getNamespaceURI());
                        checkContainerNotNull(container3, attributeTypeAttributeName);
                        schemaTypeImpl.setContainer(container3);
                    }
                    readEnd();
                    return schemaTypeImpl;
                } catch (SchemaTypeLoaderException e) {
                    throw e;
                }
            } catch (Exception e6) {
                throw new SchemaTypeLoaderException("Cannot load type from typesystem", this.typeSystem.getName(), this._handle, 14, e6);
            }
        } catch (Throwable th) {
            readEnd();
            throw th;
        }
    }

    public int getActualFiletype() {
        return this._actualfiletype;
    }

    public void loadAttribute(SchemaLocalAttributeImpl schemaLocalAttributeImpl, QName qName, SchemaContainer schemaContainer) {
        schemaLocalAttributeImpl.init(qName, readTypeRef(), readShort(), readString(), null, atLeast(2, 16, 0) ? readXmlValueObject() : null, readShort() == 1, readSOAPArrayType(), readAnnotation(schemaContainer), null);
    }

    public void loadParticle(SchemaParticleImpl schemaParticleImpl, int i5) {
        int i6 = readShort();
        schemaParticleImpl.setParticleType(i5);
        schemaParticleImpl.setMinOccurs(readBigInteger());
        schemaParticleImpl.setMaxOccurs(readBigInteger());
        schemaParticleImpl.setTransitionRules(readQNameSet(), (i6 & 1) != 0);
        if (i5 == 1 || i5 == 2 || i5 == 3) {
            schemaParticleImpl.setParticleChildren(readParticleArray());
            return;
        }
        if (i5 != 4) {
            if (i5 != 5) {
                throw new SchemaTypeLoaderException("Unrecognized particle type ", this.typeSystem.getName(), this._handle, 11);
            }
            schemaParticleImpl.setWildcardSet(readQNameSet());
            schemaParticleImpl.setWildcardProcess(readShort());
            return;
        }
        SchemaLocalElementImpl schemaLocalElementImpl = (SchemaLocalElementImpl) schemaParticleImpl;
        schemaLocalElementImpl.setNameAndTypeRef(readQName(), readTypeRef());
        schemaLocalElementImpl.setDefault(readString(), (i6 & 4) != 0, null);
        if (atLeast(2, 16, 0)) {
            schemaLocalElementImpl.setDefaultValue(readXmlValueObject());
        }
        schemaLocalElementImpl.setNillable((i6 & 8) != 0);
        schemaLocalElementImpl.setBlock((i6 & 16) != 0, (i6 & 32) != 0, (i6 & 64) != 0);
        schemaLocalElementImpl.setWsdlArrayType(readSOAPArrayType());
        schemaLocalElementImpl.setAbstract((i6 & 128) != 0);
        schemaLocalElementImpl.setAnnotation(readAnnotation(null));
        int i7 = readShort();
        SchemaIdentityConstraint.Ref[] refArr = new SchemaIdentityConstraint.Ref[i7];
        for (int i8 = 0; i8 < i7; i8++) {
            refArr[i8] = (SchemaIdentityConstraint.Ref) readHandle();
        }
        schemaLocalElementImpl.setIdentityConstraints(refArr);
    }

    public SchemaAnnotation readAnnotation(SchemaContainer schemaContainer) {
        int i5;
        if (!atLeast(2, 19, 0) || (i5 = readInt()) == -1) {
            return null;
        }
        SchemaAnnotation.Attribute[] attributeArr = new SchemaAnnotation.Attribute[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            attributeArr[i6] = new SchemaAnnotationImpl.AttributeImpl(readQName(), readString(), atLeast(2, 24, 0) ? readString() : null);
        }
        int i7 = readInt();
        String[] strArr = new String[i7];
        for (int i8 = 0; i8 < i7; i8++) {
            strArr[i8] = readString();
        }
        int i9 = readInt();
        String[] strArr2 = new String[i9];
        for (int i10 = 0; i10 < i9; i10++) {
            strArr2[i10] = readString();
        }
        return new SchemaAnnotationImpl(schemaContainer, strArr2, strArr, attributeArr);
    }

    public List<SchemaAnnotation> readAnnotations() {
        int i5 = readInt();
        ArrayList arrayList = new ArrayList(i5);
        SchemaContainer containerNonNull = this.typeSystem.getContainerNonNull("");
        for (int i6 = 0; i6 < i5; i6++) {
            arrayList.add(readAnnotation(containerNonNull));
        }
        return arrayList;
    }

    public SchemaLocalAttribute readAttributeData() {
        SchemaLocalAttributeImpl schemaLocalAttributeImpl = new SchemaLocalAttributeImpl();
        loadAttribute(schemaLocalAttributeImpl, readQName(), null);
        return schemaLocalAttributeImpl;
    }

    public BigInteger readBigInteger() {
        byte[] byteArray = readByteArray();
        if (byteArray.length == 0) {
            return null;
        }
        if (byteArray.length == 1 && byteArray[0] == 0) {
            return BigInteger.ZERO;
        }
        return (byteArray.length == 1 && byteArray[0] == 1) ? BigInteger.ONE : new BigInteger(byteArray);
    }

    public byte[] readByteArray() {
        try {
            byte[] bArr = new byte[this._input.readShort()];
            this._input.readFully(bArr);
            return bArr;
        } catch (IOException e) {
            throw new SchemaTypeLoaderException(e.getMessage(), this.typeSystem.getName(), this._handle, 9, e);
        }
    }

    public Map<String, SchemaComponent.Ref> readClassnameRefMap() {
        HashMap map = new HashMap();
        int i5 = readShort();
        for (int i6 = 0; i6 < i5; i6++) {
            map.put(readString(), readHandle());
        }
        return map;
    }

    public double readDouble() {
        try {
            return this._input.readDouble();
        } catch (IOException e) {
            throw new SchemaTypeLoaderException(e.getMessage(), this.typeSystem.getName(), this._handle, 9, e);
        }
    }

    public void readEnd() {
        try {
            LongUTFDataInputStream longUTFDataInputStream = this._input;
            if (longUTFDataInputStream != null) {
                longUTFDataInputStream.close();
            }
        } catch (IOException unused) {
        }
        this._input = null;
        this._stringPool = null;
        this._handle = null;
    }

    public SchemaComponent.Ref readHandle() {
        String string = readString();
        if (string == null) {
            return null;
        }
        if (string.charAt(0) != '_') {
            return this.typeSystem.getTypePool().refForHandle(string);
        }
        char cCharAt = string.charAt(2);
        if (cCharAt == 'A') {
            return this.typeSystem.getLinker().findAttributeRef(QNameHelper.forPretty(string, 4));
        }
        if (cCharAt == 'I') {
            SchemaType schemaType = (SchemaType) BuiltinSchemaTypeSystem.get().resolveHandle(string);
            return schemaType != null ? schemaType.getRef() : ((SchemaType) XQuerySchemaTypeSystem.get().resolveHandle(string)).getRef();
        }
        if (cCharAt == 'Y') {
            SchemaType schemaTypeTypeForSignature = this.typeSystem.getLinker().typeForSignature(string.substring(4));
            if (schemaTypeTypeForSignature != null) {
                return schemaTypeTypeForSignature.getRef();
            }
            throw new SchemaTypeLoaderException("Cannot resolve type for handle ".concat(string), this.typeSystem.getName(), this._handle, 13);
        }
        if (cCharAt == 'D') {
            return this.typeSystem.getLinker().findIdentityConstraintRef(QNameHelper.forPretty(string, 4));
        }
        if (cCharAt == 'E') {
            return this.typeSystem.getLinker().findElementRef(QNameHelper.forPretty(string, 4));
        }
        switch (cCharAt) {
            case 'M':
                return this.typeSystem.getLinker().findModelGroupRef(QNameHelper.forPretty(string, 4));
            case 'N':
                return this.typeSystem.getLinker().findAttributeGroupRef(QNameHelper.forPretty(string, 4));
            case 'O':
                return this.typeSystem.getLinker().findDocumentTypeRef(QNameHelper.forPretty(string, 4));
            default:
                switch (cCharAt) {
                    case 'R':
                        SchemaGlobalAttribute schemaGlobalAttributeFindAttribute = this.typeSystem.getLinker().findAttribute(QNameHelper.forPretty(string, 4));
                        if (schemaGlobalAttributeFindAttribute != null) {
                            return schemaGlobalAttributeFindAttribute.getType().getRef();
                        }
                        throw new SchemaTypeLoaderException("Cannot resolve attribute for handle ".concat(string), this.typeSystem.getName(), this._handle, 13);
                    case 'S':
                        SchemaGlobalElement schemaGlobalElementFindElement = this.typeSystem.getLinker().findElement(QNameHelper.forPretty(string, 4));
                        if (schemaGlobalElementFindElement != null) {
                            return schemaGlobalElementFindElement.getType().getRef();
                        }
                        throw new SchemaTypeLoaderException("Cannot resolve element for handle ".concat(string), this.typeSystem.getName(), this._handle, 13);
                    case 'T':
                        return this.typeSystem.getLinker().findTypeRef(QNameHelper.forPretty(string, 4));
                    default:
                        throw new SchemaTypeLoaderException("Cannot resolve handle ".concat(string), this.typeSystem.getName(), this._handle, 13);
                }
        }
    }

    public int readInt() {
        try {
            return this._input.readInt();
        } catch (IOException e) {
            throw new SchemaTypeLoaderException(e.getMessage(), this.typeSystem.getName(), this._handle, 9, e);
        }
    }

    public Set<String> readNamespaces() {
        HashSet hashSet = new HashSet();
        int i5 = readShort();
        for (int i6 = 0; i6 < i5; i6++) {
            hashSet.add(readString());
        }
        return hashSet;
    }

    public SchemaParticle[] readParticleArray() {
        int i5 = readShort();
        SchemaParticle[] schemaParticleArr = new SchemaParticle[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            schemaParticleArr[i6] = readParticleData();
        }
        return schemaParticleArr;
    }

    public SchemaParticle readParticleData() {
        int i5 = readShort();
        SchemaParticleImpl schemaParticleImpl = i5 != 4 ? new SchemaParticleImpl() : new SchemaLocalElementImpl();
        loadParticle(schemaParticleImpl, i5);
        return schemaParticleImpl;
    }

    public SchemaProperty readPropertyData() {
        SchemaPropertyImpl schemaPropertyImpl = new SchemaPropertyImpl();
        schemaPropertyImpl.setName(readQName());
        schemaPropertyImpl.setTypeRef(readTypeRef());
        int i5 = readShort();
        schemaPropertyImpl.setAttribute((i5 & 1) != 0);
        schemaPropertyImpl.setContainerTypeRef(readTypeRef());
        schemaPropertyImpl.setMinOccurs(readBigInteger());
        schemaPropertyImpl.setMaxOccurs(readBigInteger());
        schemaPropertyImpl.setNillable(readShort());
        schemaPropertyImpl.setDefault(readShort());
        schemaPropertyImpl.setFixed(readShort());
        schemaPropertyImpl.setDefaultText(readString());
        schemaPropertyImpl.setJavaPropertyName(readString());
        schemaPropertyImpl.setJavaTypeCode(readShort());
        schemaPropertyImpl.setExtendsJava(readTypeRef(), (i5 & 2) != 0, (i5 & 4) != 0, (i5 & 8) != 0);
        if (atMost(2, 19, 0)) {
            schemaPropertyImpl.setJavaSetterDelimiter(readQNameSet());
        }
        if (atLeast(2, 16, 0)) {
            schemaPropertyImpl.setDefaultValue(readXmlValueObject());
        }
        if (!schemaPropertyImpl.isAttribute() && atLeast(2, 17, 0)) {
            int i6 = readShort();
            LinkedHashSet linkedHashSet = new LinkedHashSet(i6);
            for (int i7 = 0; i7 < i6; i7++) {
                linkedHashSet.add(readQName());
            }
            schemaPropertyImpl.setAcceptedNames(linkedHashSet);
        }
        schemaPropertyImpl.setImmutable();
        return schemaPropertyImpl;
    }

    public QName readQName() {
        String string = readString();
        String string2 = readString();
        if (string2 == null) {
            return null;
        }
        return new QName(string, string2);
    }

    public Map<QName, SchemaComponent.Ref> readQNameRefMap() {
        HashMap map = new HashMap();
        int i5 = readShort();
        for (int i6 = 0; i6 < i5; i6++) {
            map.put(readQName(), readHandle());
        }
        return map;
    }

    public List<SchemaComponent.Ref> readQNameRefMapAsList(List<QName> list) {
        int i5 = readShort();
        ArrayList arrayList = new ArrayList(i5);
        for (int i6 = 0; i6 < i5; i6++) {
            QName qName = readQName();
            arrayList.add(readHandle());
            list.add(qName);
        }
        return arrayList;
    }

    public QNameSet readQNameSet() {
        int i5 = readShort();
        HashSet hashSet = new HashSet();
        int i6 = readShort();
        for (int i7 = 0; i7 < i6; i7++) {
            hashSet.add(readString());
        }
        HashSet hashSet2 = new HashSet();
        int i8 = readShort();
        for (int i9 = 0; i9 < i8; i9++) {
            hashSet2.add(readQName());
        }
        HashSet hashSet3 = new HashSet();
        int i10 = readShort();
        for (int i11 = 0; i11 < i10; i11++) {
            hashSet3.add(readQName());
        }
        return i5 == 1 ? QNameSet.forSets(hashSet, null, hashSet2, hashSet3) : QNameSet.forSets(null, hashSet, hashSet3, hashSet2);
    }

    public SOAPArrayType readSOAPArrayType() {
        QName qName = readQName();
        String string = readString();
        if (qName == null) {
            return null;
        }
        return new SOAPArrayType(qName, string);
    }

    public int readShort() {
        try {
            return this._input.readUnsignedShort();
        } catch (IOException e) {
            throw new SchemaTypeLoaderException(e.getMessage(), this.typeSystem.getName(), this._handle, 9, e);
        }
    }

    public String readString() {
        return this._stringPool.stringForCode(readUnsignedShortOrInt());
    }

    public SchemaType.Ref readTypeRef() {
        return (SchemaType.Ref) readHandle();
    }

    public SchemaType.Ref[] readTypeRefArray() {
        int i5 = readShort();
        SchemaType.Ref[] refArr = new SchemaType.Ref[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            refArr[i6] = readTypeRef();
        }
        return refArr;
    }

    public int readUnsignedShortOrInt() {
        try {
            return this._input.readUnsignedShortOrInt();
        } catch (IOException e) {
            throw new SchemaTypeLoaderException(e.getMessage(), this.typeSystem.getName(), this._handle, 9, e);
        }
    }

    public XmlValueRef readXmlValueObject() {
        SchemaType.Ref typeRef = readTypeRef();
        if (typeRef == null) {
            return null;
        }
        int i5 = readShort();
        if (i5 != 0) {
            if (i5 != 65535) {
                switch (i5) {
                    case 2:
                    case 3:
                    case 6:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                        return new XmlValueRef(typeRef, readString());
                    case 4:
                    case 5:
                        return new XmlValueRef(typeRef, readByteArray());
                    case 7:
                    case 8:
                        return new XmlValueRef(typeRef, readQName());
                    case 9:
                    case 10:
                        return new XmlValueRef(typeRef, Double.valueOf(readDouble()));
                }
            }
            int i6 = readShort();
            ArrayList arrayList = new ArrayList();
            writeShort(i6);
            for (int i7 = 0; i7 < i6; i7++) {
                arrayList.add(readXmlValueObject());
            }
            return new XmlValueRef(typeRef, arrayList);
        }
        return new XmlValueRef(typeRef, null);
    }

    public void writeAnnotation(SchemaAnnotation schemaAnnotation) {
        if (schemaAnnotation == null) {
            writeInt(-1);
            return;
        }
        SchemaAnnotation.Attribute[] attributes = schemaAnnotation.getAttributes();
        writeInt(attributes.length);
        for (SchemaAnnotation.Attribute attribute : attributes) {
            QName name = attribute.getName();
            String value = attribute.getValue();
            String valueUri = attribute.getValueUri();
            writeQName(name);
            writeString(value);
            writeString(valueUri);
        }
        XmlObject[] userInformation = schemaAnnotation.getUserInformation();
        writeInt(userInformation.length);
        XmlOptions saveAggressiveNamespaces = new XmlOptions().setSaveOuter().setSaveAggressiveNamespaces();
        for (XmlObject xmlObject : userInformation) {
            writeString(xmlObject.xmlText(saveAggressiveNamespaces));
        }
        XmlObject[] applicationInformation = schemaAnnotation.getApplicationInformation();
        writeInt(applicationInformation.length);
        for (XmlObject xmlObject2 : applicationInformation) {
            writeString(xmlObject2.xmlText(saveAggressiveNamespaces));
        }
    }

    public void writeAnnotations(SchemaAnnotation[] schemaAnnotationArr) {
        writeInt(schemaAnnotationArr.length);
        for (SchemaAnnotation schemaAnnotation : schemaAnnotationArr) {
            writeAnnotation(schemaAnnotation);
        }
    }

    public void writeAttributeData(SchemaLocalAttribute schemaLocalAttribute) {
        writeQName(schemaLocalAttribute.getName());
        writeType(schemaLocalAttribute.getType());
        writeShort(schemaLocalAttribute.getUse());
        writeString(schemaLocalAttribute.getDefaultText());
        writeXmlValueObject(schemaLocalAttribute.getDefaultValue());
        writeShort(schemaLocalAttribute.isFixed() ? 1 : 0);
        writeSOAPArrayType(((SchemaWSDLArrayType) schemaLocalAttribute).getWSDLArrayType());
        writeAnnotation(schemaLocalAttribute.getAnnotation());
    }

    public void writeAttributeGroupData(SchemaAttributeGroup schemaAttributeGroup) {
        SchemaAttributeGroupImpl schemaAttributeGroupImpl = (SchemaAttributeGroupImpl) schemaAttributeGroup;
        writeQName(schemaAttributeGroupImpl.getName());
        writeString(schemaAttributeGroupImpl.getTargetNamespace());
        writeShort(schemaAttributeGroupImpl.getChameleonNamespace() != null ? 1 : 0);
        writeString(schemaAttributeGroupImpl.getFormDefault());
        writeShort(schemaAttributeGroupImpl.isRedefinition() ? 1 : 0);
        writeString(schemaAttributeGroupImpl.getParseObject().xmlText(new XmlOptions().setSaveOuter()));
        writeAnnotation(schemaAttributeGroupImpl.getAnnotation());
        writeString(schemaAttributeGroupImpl.getSourceName());
    }

    public void writeAttributeTypeMap(SchemaType[] schemaTypeArr) {
        writeShort(schemaTypeArr.length);
        for (SchemaType schemaType : schemaTypeArr) {
            writeQName(schemaType.getAttributeTypeAttributeName());
            writeHandle(schemaType);
        }
    }

    public void writeBigInteger(BigInteger bigInteger) {
        if (bigInteger == null) {
            writeShort(0);
        } else if (bigInteger.signum() == 0) {
            writeByteArray(SchemaTypeSystemImpl.SINGLE_ZERO_BYTE);
        } else {
            writeByteArray(bigInteger.toByteArray());
        }
    }

    public void writeByteArray(byte[] bArr) {
        try {
            writeShort(bArr.length);
            LongUTFDataOutputStream longUTFDataOutputStream = this._output;
            if (longUTFDataOutputStream != null) {
                longUTFDataOutputStream.write(bArr);
            }
        } catch (IOException e) {
            throw new SchemaTypeLoaderException(e.getMessage(), this.typeSystem.getName(), this._handle, 9, e);
        }
    }

    public void writeClassnameMap(Map<String, SchemaComponent.Ref> map) {
        writeShort(map.size());
        map.forEach(new r(this, 0));
    }

    public void writeDocumentTypeMap(SchemaType[] schemaTypeArr) {
        writeShort(schemaTypeArr.length);
        for (SchemaType schemaType : schemaTypeArr) {
            writeQName(schemaType.getDocumentElementName());
            writeHandle(schemaType);
        }
    }

    public void writeDouble(double d) {
        LongUTFDataOutputStream longUTFDataOutputStream = this._output;
        if (longUTFDataOutputStream != null) {
            try {
                longUTFDataOutputStream.writeDouble(d);
            } catch (IOException e) {
                throw new SchemaTypeLoaderException(e.getMessage(), this.typeSystem.getName(), this._handle, 9, e);
            }
        }
    }

    public void writeEnd() {
        try {
            LongUTFDataOutputStream longUTFDataOutputStream = this._output;
            if (longUTFDataOutputStream != null) {
                longUTFDataOutputStream.flush();
                this._output.close();
            }
            this._output = null;
            this._stringPool = null;
            this._handle = null;
        } catch (IOException e) {
            throw new SchemaTypeLoaderException(e.getMessage(), this.typeSystem.getName(), this._handle, 9, e);
        }
    }

    public void writeHandle(SchemaComponent schemaComponent) {
        if (schemaComponent == null || schemaComponent.getTypeSystem() == this.typeSystem) {
            writeString(this.typeSystem.getTypePool().handleForComponent(schemaComponent));
            return;
        }
        int componentType = schemaComponent.getComponentType();
        if (componentType == 0) {
            SchemaType schemaType = (SchemaType) schemaComponent;
            if (schemaType.isBuiltinType()) {
                writeString("_BI_" + schemaType.getName().getLocalPart());
                return;
            } else if (schemaType.getName() != null) {
                writeString("_XT_" + QNameHelper.pretty(schemaType.getName()));
                return;
            } else if (schemaType.isDocumentType()) {
                writeString("_XO_" + QNameHelper.pretty(schemaType.getDocumentElementName()));
                return;
            } else {
                writeString("_XY_" + schemaType);
                return;
            }
        }
        if (componentType == 1) {
            writeString("_XE_" + QNameHelper.pretty(schemaComponent.getName()));
            return;
        }
        if (componentType == 3) {
            writeString("_XA_" + QNameHelper.pretty(schemaComponent.getName()));
            return;
        }
        if (componentType == 4) {
            writeString("_XN_" + QNameHelper.pretty(schemaComponent.getName()));
        } else if (componentType == 5) {
            writeString("_XD_" + QNameHelper.pretty(schemaComponent.getName()));
        } else {
            if (componentType != 6) {
                throw new SchemaTypeLoaderException("Cannot write handle for component " + schemaComponent, this.typeSystem.getName(), this._handle, 13);
            }
            writeString("_XM_" + QNameHelper.pretty(schemaComponent.getName()));
        }
    }

    public void writeIdConstraintData(SchemaIdentityConstraint schemaIdentityConstraint) {
        writeQName(schemaIdentityConstraint.getName());
        writeShort(schemaIdentityConstraint.getConstraintCategory());
        writeString(schemaIdentityConstraint.getSelector());
        writeAnnotation(schemaIdentityConstraint.getAnnotation());
        String[] fields = schemaIdentityConstraint.getFields();
        writeShort(fields.length);
        for (String str : fields) {
            writeString(str);
        }
        if (schemaIdentityConstraint.getConstraintCategory() == 2) {
            writeHandle(schemaIdentityConstraint.getReferencedKey());
        }
        Map<String, String> nSMap = schemaIdentityConstraint.getNSMap();
        writeShort(nSMap.size());
        nSMap.forEach(new r(this, 1));
        writeString(schemaIdentityConstraint.getSourceName());
    }

    public void writeIndexData() {
        this.typeSystem.getTypePool().writeHandlePool(this);
        writeQNameMap(this.typeSystem.globalElements());
        writeQNameMap(this.typeSystem.globalAttributes());
        writeQNameMap(this.typeSystem.modelGroups());
        writeQNameMap(this.typeSystem.attributeGroups());
        writeQNameMap(this.typeSystem.identityConstraints());
        writeQNameMap(this.typeSystem.globalTypes());
        writeDocumentTypeMap(this.typeSystem.documentTypes());
        writeAttributeTypeMap(this.typeSystem.attributeTypes());
        writeClassnameMap(this.typeSystem.getTypeRefsByClassname());
        writeNamespaces(this.typeSystem.getNamespaces());
        writeQNameMap(this.typeSystem.redefinedGlobalTypes());
        writeQNameMap(this.typeSystem.redefinedModelGroups());
        writeQNameMap(this.typeSystem.redefinedAttributeGroups());
        writeAnnotations(this.typeSystem.annotations());
    }

    public void writeInt(int i5) {
        LongUTFDataOutputStream longUTFDataOutputStream = this._output;
        if (longUTFDataOutputStream != null) {
            try {
                longUTFDataOutputStream.writeInt(i5);
            } catch (IOException e) {
                throw new SchemaTypeLoaderException(e.getMessage(), this.typeSystem.getName(), this._handle, 9, e);
            }
        }
    }

    public void writeModelGroupData(SchemaModelGroup schemaModelGroup) {
        SchemaModelGroupImpl schemaModelGroupImpl = (SchemaModelGroupImpl) schemaModelGroup;
        writeQName(schemaModelGroupImpl.getName());
        writeString(schemaModelGroupImpl.getTargetNamespace());
        writeShort(schemaModelGroupImpl.getChameleonNamespace() != null ? 1 : 0);
        writeString(schemaModelGroupImpl.getElemFormDefault());
        writeString(schemaModelGroupImpl.getAttFormDefault());
        writeShort(schemaModelGroupImpl.isRedefinition() ? 1 : 0);
        writeString(schemaModelGroupImpl.getParseObject().xmlText(new XmlOptions().setSaveOuter()));
        writeAnnotation(schemaModelGroupImpl.getAnnotation());
        writeString(schemaModelGroupImpl.getSourceName());
    }

    public void writeNamespaces(Set<String> set) {
        writeShort(set.size());
        set.forEach(new q(this, 0));
    }

    public void writeParticleArray(SchemaParticle[] schemaParticleArr) {
        writeShort(schemaParticleArr.length);
        for (SchemaParticle schemaParticle : schemaParticleArr) {
            writeParticleData(schemaParticle);
        }
    }

    public void writeParticleData(SchemaParticle schemaParticle) {
        writeShort(schemaParticle.getParticleType());
        short s6 = schemaParticle.isSkippable() ? (short) 1 : (short) 0;
        if (schemaParticle.getParticleType() == 4) {
            SchemaLocalElement schemaLocalElement = (SchemaLocalElement) schemaParticle;
            if (schemaLocalElement.isFixed()) {
                s6 = (short) (s6 | 4);
            }
            if (schemaLocalElement.isNillable()) {
                s6 = (short) (s6 | 8);
            }
            if (schemaLocalElement.blockExtension()) {
                s6 = (short) (s6 | 16);
            }
            if (schemaLocalElement.blockRestriction()) {
                s6 = (short) (s6 | 32);
            }
            if (schemaLocalElement.blockSubstitution()) {
                s6 = (short) (s6 | 64);
            }
            if (schemaLocalElement.isAbstract()) {
                s6 = (short) (s6 | 128);
            }
            if (schemaLocalElement instanceof SchemaGlobalElement) {
                SchemaGlobalElement schemaGlobalElement = (SchemaGlobalElement) schemaLocalElement;
                if (schemaGlobalElement.finalExtension()) {
                    s6 = (short) (s6 | ExtendedPivotTableViewFieldsRecord.sid);
                }
                if (schemaGlobalElement.finalRestriction()) {
                    s6 = (short) (s6 | DimensionsRecord.sid);
                }
            }
        }
        writeShort(s6);
        writeBigInteger(schemaParticle.getMinOccurs());
        writeBigInteger(schemaParticle.getMaxOccurs());
        writeQNameSet(schemaParticle.acceptedStartNames());
        int particleType = schemaParticle.getParticleType();
        if (particleType == 1 || particleType == 2 || particleType == 3) {
            writeParticleArray(schemaParticle.getParticleChildren());
            return;
        }
        if (particleType != 4) {
            if (particleType != 5) {
                throw new SchemaTypeLoaderException("Unrecognized particle type ", this.typeSystem.getName(), this._handle, 11);
            }
            writeQNameSet(schemaParticle.getWildcardSet());
            writeShort(schemaParticle.getWildcardProcess());
            return;
        }
        SchemaLocalElement schemaLocalElement2 = (SchemaLocalElement) schemaParticle;
        writeQName(schemaLocalElement2.getName());
        writeType(schemaLocalElement2.getType());
        writeString(schemaLocalElement2.getDefaultText());
        writeXmlValueObject(schemaLocalElement2.getDefaultValue());
        writeSOAPArrayType(((SchemaWSDLArrayType) schemaLocalElement2).getWSDLArrayType());
        writeAnnotation(schemaLocalElement2.getAnnotation());
        if (schemaLocalElement2 instanceof SchemaGlobalElement) {
            SchemaGlobalElement schemaGlobalElement2 = (SchemaGlobalElement) schemaLocalElement2;
            writeHandle(schemaGlobalElement2.substitutionGroup());
            QName[] qNameArrSubstitutionGroupMembers = schemaGlobalElement2.substitutionGroupMembers();
            writeShort(qNameArrSubstitutionGroupMembers.length);
            for (QName qName : qNameArrSubstitutionGroupMembers) {
                writeQName(qName);
            }
        }
        SchemaIdentityConstraint[] identityConstraints = schemaLocalElement2.getIdentityConstraints();
        writeShort(identityConstraints.length);
        for (SchemaIdentityConstraint schemaIdentityConstraint : identityConstraints) {
            writeHandle(schemaIdentityConstraint);
        }
    }

    public void writePropertyData(SchemaProperty schemaProperty) {
        writeQName(schemaProperty.getName());
        writeType(schemaProperty.getType());
        writeShort((schemaProperty.isAttribute() ? 1 : 0) | (schemaProperty.extendsJavaSingleton() ? 2 : 0) | (schemaProperty.extendsJavaOption() ? 4 : 0) | (schemaProperty.extendsJavaArray() ? 8 : 0));
        writeType(schemaProperty.getContainerType());
        writeBigInteger(schemaProperty.getMinOccurs());
        writeBigInteger(schemaProperty.getMaxOccurs());
        writeShort(schemaProperty.hasNillable());
        writeShort(schemaProperty.hasDefault());
        writeShort(schemaProperty.hasFixed());
        writeString(schemaProperty.getDefaultText());
        writeString(schemaProperty.getJavaPropertyName());
        writeShort(schemaProperty.getJavaTypeCode());
        writeType(schemaProperty.javaBasedOnType());
        writeXmlValueObject(schemaProperty.getDefaultValue());
        if (schemaProperty.isAttribute()) {
            return;
        }
        QName[] qNameArrAcceptedNames = schemaProperty.acceptedNames();
        writeShort(qNameArrAcceptedNames.length);
        for (QName qName : qNameArrAcceptedNames) {
            writeQName(qName);
        }
    }

    public void writeQName(QName qName) {
        if (qName == null) {
            writeString(null);
            writeString(null);
        } else {
            writeString(qName.getNamespaceURI());
            writeString(qName.getLocalPart());
        }
    }

    public void writeQNameMap(SchemaComponent[] schemaComponentArr) {
        writeShort(schemaComponentArr.length);
        for (SchemaComponent schemaComponent : schemaComponentArr) {
            writeQName(schemaComponent.getName());
            writeHandle(schemaComponent);
        }
    }

    public void writeQNameSet(QNameSet qNameSet) {
        int i5 = qNameSet.excludedURIs() != null ? 1 : 0;
        writeShort(i5);
        Set<String> setExcludedURIs = i5 != 0 ? qNameSet.excludedURIs() : qNameSet.includedURIs();
        writeShort(setExcludedURIs.size());
        setExcludedURIs.forEach(new q(this, 0));
        Set<QName> setExcludedQNamesInIncludedURIs = i5 != 0 ? qNameSet.excludedQNamesInIncludedURIs() : qNameSet.includedQNamesInExcludedURIs();
        writeShort(setExcludedQNamesInIncludedURIs.size());
        setExcludedQNamesInIncludedURIs.forEach(new q(this, 1));
        Set<QName> setIncludedQNamesInExcludedURIs = i5 != 0 ? qNameSet.includedQNamesInExcludedURIs() : qNameSet.excludedQNamesInIncludedURIs();
        writeShort(setIncludedQNamesInExcludedURIs.size());
        setIncludedQNamesInExcludedURIs.forEach(new q(this, 1));
    }

    public void writeRealHeader(String str, int i5) {
        String strConcat;
        if (str.indexOf(47) >= 0) {
            strConcat = str.concat(".xsb");
        } else {
            strConcat = this.typeSystem.getBasePackage() + str + ".xsb";
        }
        OutputStream saverStream = this.typeSystem.getSaverStream(strConcat, this._handle);
        if (saverStream == null) {
            throw new SchemaTypeLoaderException(AbstractC0157z.n("Could not write compiled schema resource ", strConcat), this.typeSystem.getName(), str, 12);
        }
        this._output = new LongUTFDataOutputStream(saverStream);
        this._handle = str;
        writeInt(-629491010);
        writeShort(2);
        writeShort(24);
        writeShort(0);
        writeShort(i5);
        this._stringPool.writeTo(this._output);
    }

    public void writeSOAPArrayType(SOAPArrayType sOAPArrayType) {
        if (sOAPArrayType == null) {
            writeQName(null);
            writeString(null);
        } else {
            writeQName(sOAPArrayType.getQName());
            writeString(sOAPArrayType.soap11DimensionString());
        }
    }

    public void writeShort(int i5) {
        if (i5 >= 65535 || i5 < -1) {
            throw new SchemaTypeLoaderException(androidx.collection.a.i(i5, "Value ", " out of range: must fit in a 16-bit unsigned short."), this.typeSystem.getName(), this._handle, 10);
        }
        LongUTFDataOutputStream longUTFDataOutputStream = this._output;
        if (longUTFDataOutputStream != null) {
            try {
                longUTFDataOutputStream.writeShort(i5);
            } catch (IOException e) {
                throw new SchemaTypeLoaderException(e.getMessage(), this.typeSystem.getName(), this._handle, 9, e);
            }
        }
    }

    public void writeShortOrInt(int i5) {
        LongUTFDataOutputStream longUTFDataOutputStream = this._output;
        if (longUTFDataOutputStream != null) {
            try {
                longUTFDataOutputStream.writeShortOrInt(i5);
            } catch (IOException e) {
                throw new SchemaTypeLoaderException(e.getMessage(), this.typeSystem.getName(), this._handle, 9, e);
            }
        }
    }

    public void writeString(String str) {
        writeShortOrInt(this._stringPool.codeForString(str));
    }

    public void writeType(SchemaType schemaType) {
        writeHandle(schemaType);
    }

    public void writeTypeArray(SchemaType[] schemaTypeArr) {
        writeShort(schemaTypeArr.length);
        for (SchemaType schemaType : schemaTypeArr) {
            writeHandle(schemaType);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v109 */
    /* JADX WARN: Type inference failed for: r1v110 */
    /* JADX WARN: Type inference failed for: r1v111 */
    /* JADX WARN: Type inference failed for: r1v112 */
    /* JADX WARN: Type inference failed for: r1v113 */
    /* JADX WARN: Type inference failed for: r1v114 */
    /* JADX WARN: Type inference failed for: r1v115 */
    /* JADX WARN: Type inference failed for: r1v116 */
    /* JADX WARN: Type inference failed for: r1v117 */
    /* JADX WARN: Type inference failed for: r1v118 */
    /* JADX WARN: Type inference failed for: r1v119 */
    /* JADX WARN: Type inference failed for: r1v120 */
    /* JADX WARN: Type inference failed for: r1v121 */
    /* JADX WARN: Type inference failed for: r1v122 */
    /* JADX WARN: Type inference failed for: r1v123 */
    /* JADX WARN: Type inference failed for: r1v124 */
    /* JADX WARN: Type inference failed for: r1v125 */
    /* JADX WARN: Type inference failed for: r1v126 */
    /* JADX WARN: Type inference failed for: r1v127 */
    /* JADX WARN: Type inference failed for: r1v128 */
    /* JADX WARN: Type inference failed for: r1v129 */
    /* JADX WARN: Type inference failed for: r1v130 */
    /* JADX WARN: Type inference failed for: r1v131 */
    /* JADX WARN: Type inference failed for: r1v132 */
    /* JADX WARN: Type inference failed for: r1v133 */
    /* JADX WARN: Type inference failed for: r1v134 */
    /* JADX WARN: Type inference failed for: r1v135 */
    /* JADX WARN: Type inference failed for: r1v136 */
    /* JADX WARN: Type inference failed for: r1v137 */
    /* JADX WARN: Type inference failed for: r1v138 */
    /* JADX WARN: Type inference failed for: r1v139 */
    /* JADX WARN: Type inference failed for: r1v140 */
    /* JADX WARN: Type inference failed for: r1v141 */
    /* JADX WARN: Type inference failed for: r1v142 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v40 */
    public void writeTypeData(SchemaType schemaType) {
        writeQName(schemaType.getName());
        writeType(schemaType.getOuterType());
        SchemaTypeImpl schemaTypeImpl = (SchemaTypeImpl) schemaType;
        writeShort(schemaTypeImpl.getBaseDepth());
        writeType(schemaType.getBaseType());
        writeShort(schemaType.getDerivationType());
        writeAnnotation(schemaType.getAnnotation());
        if (schemaType.getContainerField() == null) {
            writeShort(0);
        } else if (schemaType.getOuterType().isAttributeType() || schemaType.getOuterType().isDocumentType()) {
            writeShort(1);
            writeHandle((SchemaComponent) schemaType.getContainerField());
        } else if (schemaType.getContainerField().isAttribute()) {
            writeShort(2);
            writeShort(((SchemaTypeImpl) schemaType.getOuterType()).getIndexForLocalAttribute((SchemaLocalAttribute) schemaType.getContainerField()));
        } else {
            writeShort(3);
            writeShort(((SchemaTypeImpl) schemaType.getOuterType()).getIndexForLocalElement((SchemaLocalElement) schemaType.getContainerField()));
        }
        writeString(schemaType.getFullJavaName());
        writeString(schemaType.getFullJavaImplName());
        writeTypeArray(schemaType.getAnonymousTypes());
        writeShort(schemaType.getAnonymousUnionMemberOrdinal());
        boolean zIsSimpleType = schemaType.isSimpleType();
        ?? r6 = zIsSimpleType;
        if (schemaType.isDocumentType()) {
            r6 = (zIsSimpleType ? 1 : 0) | 2;
        }
        ?? r7 = r6;
        if (schemaType.isAttributeType()) {
            r7 = (r6 == true ? 1 : 0) | 524288;
        }
        ?? r8 = r7;
        if (schemaType.ordered() != 0) {
            r8 = (r7 == true ? 1 : 0) | 4;
        }
        ?? r9 = r8;
        if (schemaType.ordered() == 2) {
            r9 = (r8 == true ? 1 : 0) | 1024;
        }
        ?? r10 = r9;
        if (schemaType.isBounded()) {
            r10 = (r9 == true ? 1 : 0) | 8;
        }
        ?? r11 = r10;
        if (schemaType.isFinite()) {
            r11 = (r10 == true ? 1 : 0) | 16;
        }
        ?? r12 = r11;
        if (schemaType.isNumeric()) {
            r12 = (r11 == true ? 1 : 0) | 32;
        }
        ?? r13 = r12;
        if (schemaType.hasStringEnumValues()) {
            r13 = (r12 == true ? 1 : 0) | 64;
        }
        ?? r14 = r13;
        if (schemaTypeImpl.isUnionOfLists()) {
            r14 = (r13 == true ? 1 : 0) | 128;
        }
        ?? r15 = r14;
        if (schemaType.hasPatternFacet()) {
            r15 = (r14 == true ? 1 : 0) | 256;
        }
        ?? r16 = r15;
        if (schemaType.isOrderSensitive()) {
            r16 = (r15 == true ? 1 : 0) | 512;
        }
        ?? r17 = r16;
        if (schemaType.blockExtension()) {
            r17 = (r16 == true ? 1 : 0) | 4096;
        }
        ?? r18 = r17;
        if (schemaType.blockRestriction()) {
            r18 = (r17 == true ? 1 : 0) | 8192;
        }
        ?? r19 = r18;
        if (schemaType.finalExtension()) {
            r19 = (r18 == true ? 1 : 0) | 16384;
        }
        ?? r20 = r19;
        if (schemaType.finalRestriction()) {
            r20 = (r19 == true ? 1 : 0) | 16384;
        }
        ?? r21 = r20;
        if (schemaType.finalList()) {
            r21 = (r20 == true ? 1 : 0) | 131072;
        }
        ?? r22 = r21;
        if (schemaType.finalUnion()) {
            r22 = (r21 == true ? 1 : 0) | 65536;
        }
        int i5 = r22;
        if (schemaType.isAbstract()) {
            i5 = (r22 == true ? 1 : 0) | 262144;
        }
        writeInt(i5);
        if (!schemaType.isSimpleType()) {
            writeShort(schemaType.getContentType());
            writeType(schemaType.getContentBasedOnType());
            SchemaAttributeModel attributeModel = schemaType.getAttributeModel();
            SchemaLocalAttribute[] attributes = attributeModel.getAttributes();
            writeShort(attributes.length);
            for (SchemaLocalAttribute schemaLocalAttribute : attributes) {
                writeAttributeData(schemaLocalAttribute);
            }
            writeQNameSet(attributeModel.getWildcardSet());
            writeShort(attributeModel.getWildcardProcess());
            SchemaProperty[] attributeProperties = schemaType.getAttributeProperties();
            writeShort(attributeProperties.length);
            for (SchemaProperty schemaProperty : attributeProperties) {
                writePropertyData(schemaProperty);
            }
            if (schemaType.getContentType() == 3 || schemaType.getContentType() == 4) {
                writeShort(schemaType.hasAllContent() ? 1 : 0);
                writeParticleArray(schemaType.getContentModel() != null ? new SchemaParticle[]{schemaType.getContentModel()} : new SchemaParticle[0]);
                SchemaProperty[] elementProperties = schemaType.getElementProperties();
                writeShort(elementProperties.length);
                for (SchemaProperty schemaProperty2 : elementProperties) {
                    writePropertyData(schemaProperty2);
                }
            }
        }
        if (schemaType.isSimpleType() || schemaType.getContentType() == 2) {
            writeShort(schemaType.getSimpleVariety());
            int i6 = 0;
            for (int i7 = 0; i7 <= 11; i7++) {
                if (schemaType.getFacet(i7) != null) {
                    i6++;
                }
            }
            writeShort(i6);
            for (int i8 = 0; i8 <= 11; i8++) {
                XmlAnySimpleType facet = schemaType.getFacet(i8);
                if (facet != null) {
                    writeShort(i8);
                    writeXmlValueObject(facet);
                    writeShort(schemaType.isFacetFixed(i8) ? 1 : 0);
                }
            }
            writeShort(schemaType.getWhiteSpaceRule());
            RegularExpression[] patternExpressions = schemaTypeImpl.getPatternExpressions();
            writeShort(patternExpressions.length);
            for (RegularExpression regularExpression : patternExpressions) {
                writeString(regularExpression.getPattern());
            }
            XmlAnySimpleType[] enumerationValues = schemaType.getEnumerationValues();
            if (enumerationValues == null) {
                writeShort(0);
            } else {
                writeShortOrInt(enumerationValues.length);
                for (XmlAnySimpleType xmlAnySimpleType : enumerationValues) {
                    writeXmlValueObject(xmlAnySimpleType);
                }
            }
            writeType(schemaType.getBaseEnumType());
            if (schemaType.hasStringEnumValues()) {
                SchemaStringEnumEntry[] stringEnumEntries = schemaType.getStringEnumEntries();
                writeShort(stringEnumEntries.length);
                for (SchemaStringEnumEntry schemaStringEnumEntry : stringEnumEntries) {
                    writeString(schemaStringEnumEntry.getString());
                    writeShort(schemaStringEnumEntry.getIntValue());
                    writeString(schemaStringEnumEntry.getEnumName());
                }
            }
            int simpleVariety = schemaType.getSimpleVariety();
            if (simpleVariety == 1) {
                writeType(schemaType.getPrimitiveType());
                writeInt(schemaType.getDecimalSize());
            } else if (simpleVariety == 2) {
                writeTypeArray(schemaType.getUnionMemberTypes());
            } else if (simpleVariety == 3) {
                writeType(schemaType.getListItemType());
            }
        }
        writeString(schemaType.getSourceName());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void writeXmlValueObject(XmlAnySimpleType xmlAnySimpleType) {
        SchemaType schemaType = xmlAnySimpleType == 0 ? null : xmlAnySimpleType.schemaType();
        writeType(schemaType);
        if (schemaType == null) {
            return;
        }
        SimpleValue simpleValue = (SimpleValue) xmlAnySimpleType;
        SchemaType schemaTypeInstanceType = simpleValue.instanceType();
        if (schemaTypeInstanceType == null) {
            writeShort(0);
        }
        if (schemaTypeInstanceType.getSimpleVariety() == 3) {
            writeShort(-1);
            List<? extends XmlAnySimpleType> listXgetListValue = ((XmlObjectBase) xmlAnySimpleType).xgetListValue();
            writeShort(listXgetListValue.size());
            listXgetListValue.forEach(new q(this, 2));
            return;
        }
        int builtinTypeCode = schemaTypeInstanceType.getPrimitiveType().getBuiltinTypeCode();
        writeShort(builtinTypeCode);
        switch (builtinTypeCode) {
            case 2:
            case 3:
            case 6:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                writeString(xmlAnySimpleType.getStringValue());
                break;
            case 4:
            case 5:
                writeByteArray(simpleValue.getByteArrayValue());
                break;
            case 7:
            case 8:
                writeQName(simpleValue.getQNameValue());
                break;
            case 9:
                writeDouble(simpleValue.getFloatValue());
                break;
            case 10:
                writeDouble(simpleValue.getDoubleValue());
                break;
        }
    }

    public XsbReader(SchemaTypeSystemImpl schemaTypeSystemImpl, String str, int i5) {
        this.typeSystem = schemaTypeSystemImpl;
        String str2 = schemaTypeSystemImpl.getBasePackage() + str + ".xsb";
        InputStream loaderStream = schemaTypeSystemImpl.getLoaderStream(str2);
        if (loaderStream != null) {
            this._input = new LongUTFDataInputStream(loaderStream);
            this._handle = str;
            if (readInt() == -629491010) {
                this._majorver = readShort();
                int i6 = readShort();
                this._minorver = i6;
                if (this._majorver != 2) {
                    throw new SchemaTypeLoaderException("XML-BEANS compiled schema: Wrong major version - expecting 2, got " + this._majorver, schemaTypeSystemImpl.getName(), str, 2);
                }
                if (i6 > 24) {
                    throw new SchemaTypeLoaderException("XML-BEANS compiled schema: Incompatible minor version - expecting up to 24, got " + this._minorver, schemaTypeSystemImpl.getName(), str, 3);
                }
                if (i6 >= 14) {
                    if (atLeast(2, 18, 0)) {
                        this._releaseno = readShort();
                    }
                    int i7 = readShort();
                    if (i7 != i5 && i5 != 65535) {
                        throw new SchemaTypeLoaderException(androidx.collection.a.h(i5, i7, "XML-BEANS compiled schema: File has the wrong type - expecting type ", ", got type "), schemaTypeSystemImpl.getName(), str, 4);
                    }
                    SchemaTypeSystemImpl.StringPool stringPool = new SchemaTypeSystemImpl.StringPool(this._handle, schemaTypeSystemImpl.getName());
                    this._stringPool = stringPool;
                    stringPool.readFrom(this._input);
                    this._actualfiletype = i7;
                    return;
                }
                throw new SchemaTypeLoaderException("XML-BEANS compiled schema: Incompatible minor version - expecting at least 14, got " + this._minorver, schemaTypeSystemImpl.getName(), str, 3);
            }
            throw new SchemaTypeLoaderException("XML-BEANS compiled schema: Wrong magic cookie", schemaTypeSystemImpl.getName(), str, 1);
        }
        throw new SchemaTypeLoaderException(AbstractC0157z.n("XML-BEANS compiled schema: Could not locate compiled schema resource ", str2), schemaTypeSystemImpl.getName(), str, 0);
    }
}
