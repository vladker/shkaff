package org.apache.xmlbeans.impl.schema;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaAttributeModel;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaLocalAttribute;
import org.apache.xmlbeans.SchemaLocalElement;
import org.apache.xmlbeans.SchemaParticle;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlNOTATION;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.XBeanDebug;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class StscChecker {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    private static boolean blockSetOK(SchemaLocalElement schemaLocalElement, SchemaLocalElement schemaLocalElement2, Collection<XmlError> collection, XmlObject xmlObject) {
        if (schemaLocalElement.blockRestriction() && !schemaLocalElement2.blockRestriction()) {
            collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_RESTRICTION_NAME_AND_TYPE$DISALLOWED_SUBSTITUTIONS, new Object[]{printParticle((SchemaParticle) schemaLocalElement2), "restriction", printParticle((SchemaParticle) schemaLocalElement)}, xmlObject));
            return false;
        }
        if (schemaLocalElement.blockExtension() && !schemaLocalElement2.blockExtension()) {
            collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_RESTRICTION_NAME_AND_TYPE$DISALLOWED_SUBSTITUTIONS, new Object[]{printParticle((SchemaParticle) schemaLocalElement2), "extension", printParticle((SchemaParticle) schemaLocalElement)}, xmlObject));
            return false;
        }
        if (!schemaLocalElement.blockSubstitution() || schemaLocalElement2.blockSubstitution()) {
            return true;
        }
        collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_RESTRICTION_NAME_AND_TYPE$DISALLOWED_SUBSTITUTIONS, new Object[]{printParticle((SchemaParticle) schemaLocalElement2), "substitution", printParticle((SchemaParticle) schemaLocalElement)}, xmlObject));
        return false;
    }

    public static void checkAll() {
        StscState stscState = StscState.get();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(stscState.documentTypes()));
        arrayList.addAll(Arrays.asList(stscState.attributeTypes()));
        arrayList.addAll(Arrays.asList(stscState.redefinedGlobalTypes()));
        arrayList.addAll(Arrays.asList(stscState.globalTypes()));
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            SchemaType schemaType = (SchemaType) arrayList.get(i5);
            if (!stscState.noPvr() && !schemaType.isDocumentType()) {
                checkRestriction((SchemaTypeImpl) schemaType);
            }
            checkFields((SchemaTypeImpl) schemaType);
            arrayList.addAll(Arrays.asList(schemaType.getAnonymousTypes()));
        }
        checkSubstitutionGroups(stscState.globalElements());
    }

    private static boolean checkAllDerivationsForRestriction(SchemaType schemaType, SchemaType schemaType2, Collection<XmlError> collection, XmlObject xmlObject) {
        HashSet hashSet = schemaType.getSimpleVariety() == 2 ? new HashSet(Arrays.asList(schemaType.getUnionConstituentTypes())) : null;
        for (SchemaType baseType = schemaType2; !schemaType.equals(baseType) && hashSet != null && !hashSet.contains(baseType); baseType = baseType.getBaseType()) {
            if (baseType.getDerivationType() != 1) {
                collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_RESTRICTION_NAME_AND_TYPE$TYPE_RESTRICTED, new Object[]{printType(schemaType2), printType(schemaType), printType(baseType)}, xmlObject));
                return false;
            }
        }
        return true;
    }

    private static void checkElementDefaults(SchemaParticle schemaParticle, XmlObject xmlObject, SchemaType schemaType) {
        String localPart;
        String localPart2;
        String str;
        if (schemaParticle == null) {
            return;
        }
        int particleType = schemaParticle.getParticleType();
        int i5 = 0;
        if (particleType == 1 || particleType == 2 || particleType == 3) {
            SchemaParticle[] particleChildren = schemaParticle.getParticleChildren();
            int length = particleChildren.length;
            while (i5 < length) {
                checkElementDefaults(particleChildren[i5], xmlObject, schemaType);
                i5++;
            }
            return;
        }
        if (particleType != 4) {
            return;
        }
        String defaultText = schemaParticle.getDefaultText();
        if (defaultText != null) {
            if (schemaParticle.getType().isSimpleType() || schemaParticle.getType().getContentType() == 2) {
                try {
                    XmlAnySimpleType defaultValue = schemaParticle.getDefaultValue();
                    XmlOptions xmlOptions = new XmlOptions();
                    xmlOptions.setValidateTextOnly();
                    if (!defaultValue.validate(xmlOptions)) {
                        throw new Exception();
                    }
                    SchemaPropertyImpl schemaPropertyImpl = (SchemaPropertyImpl) schemaType.getElementProperty(schemaParticle.getName());
                    if (schemaPropertyImpl != null && schemaPropertyImpl.getDefaultText() != null) {
                        schemaPropertyImpl.setDefaultValue(new XmlValueRef(defaultValue));
                    }
                } catch (Exception unused) {
                    str = schemaParticle.isFixed() ? "fixed" : "default";
                    XmlObject xmlObjectSelectAttribute = xmlObject.selectAttribute("", str);
                    StscState stscState = StscState.get();
                    Object[] objArr = {QNameHelper.pretty(schemaParticle.getName()), str, defaultText, QNameHelper.pretty(schemaParticle.getType().getName())};
                    if (xmlObjectSelectAttribute == null) {
                        xmlObjectSelectAttribute = xmlObject;
                    }
                    stscState.error(XmlErrorCodes.ELEM_PROPERTIES$CONSTRAINT_VALID, objArr, xmlObjectSelectAttribute);
                }
            } else if (schemaParticle.getType().getContentType() == 4) {
                if (schemaParticle.getType().getContentModel().isSkippable()) {
                    SchemaPropertyImpl schemaPropertyImpl2 = (SchemaPropertyImpl) schemaType.getElementProperty(schemaParticle.getName());
                    if (schemaPropertyImpl2 != null && schemaPropertyImpl2.getDefaultText() != null) {
                        schemaPropertyImpl2.setDefaultValue(new XmlValueRef(XmlString.type.newValue(defaultText)));
                    }
                } else {
                    str = schemaParticle.isFixed() ? "fixed" : "default";
                    XmlObject xmlObjectSelectAttribute2 = xmlObject.selectAttribute("", str);
                    StscState stscState2 = StscState.get();
                    Object[] objArr2 = {QNameHelper.pretty(schemaParticle.getName()), str, defaultText};
                    if (xmlObjectSelectAttribute2 == null) {
                        xmlObjectSelectAttribute2 = xmlObject;
                    }
                    stscState2.error(XmlErrorCodes.ELEM_DEFAULT_VALID$MIXED_AND_EMPTIABLE, objArr2, xmlObjectSelectAttribute2);
                }
            } else if (schemaParticle.getType().getContentType() == 3) {
                XmlObject xmlObjectSelectAttribute3 = xmlObject.selectAttribute("", "default");
                StscState stscState3 = StscState.get();
                Object[] objArr3 = {QNameHelper.pretty(schemaParticle.getName()), defaultText, "element"};
                if (xmlObjectSelectAttribute3 == null) {
                    xmlObjectSelectAttribute3 = xmlObject;
                }
                stscState3.error(XmlErrorCodes.ELEM_DEFAULT_VALID$SIMPLE_TYPE_OR_MIXED, objArr3, xmlObjectSelectAttribute3);
            } else if (schemaParticle.getType().getContentType() == 1) {
                XmlObject xmlObjectSelectAttribute4 = xmlObject.selectAttribute("", "default");
                StscState stscState4 = StscState.get();
                Object[] objArr4 = {QNameHelper.pretty(schemaParticle.getName()), defaultText, "empty"};
                if (xmlObjectSelectAttribute4 == null) {
                    xmlObjectSelectAttribute4 = xmlObject;
                }
                stscState4.error(XmlErrorCodes.ELEM_DEFAULT_VALID$SIMPLE_TYPE_OR_MIXED, objArr4, xmlObjectSelectAttribute4);
            }
        }
        SchemaTypeImpl schemaTypeImpl = BuiltinSchemaTypeSystem.ST_ID;
        if (schemaTypeImpl.isAssignableFrom(schemaParticle.getType())) {
            localPart = schemaTypeImpl.getName().getLocalPart();
        } else {
            SchemaTypeImpl schemaTypeImpl2 = BuiltinSchemaTypeSystem.ST_IDREF;
            if (schemaTypeImpl2.isAssignableFrom(schemaParticle.getType())) {
                localPart = schemaTypeImpl2.getName().getLocalPart();
            } else {
                SchemaTypeImpl schemaTypeImpl3 = BuiltinSchemaTypeSystem.ST_IDREFS;
                if (schemaTypeImpl3.isAssignableFrom(schemaParticle.getType())) {
                    localPart = schemaTypeImpl3.getName().getLocalPart();
                } else {
                    SchemaTypeImpl schemaTypeImpl4 = BuiltinSchemaTypeSystem.ST_ENTITY;
                    if (schemaTypeImpl4.isAssignableFrom(schemaParticle.getType())) {
                        localPart = schemaTypeImpl4.getName().getLocalPart();
                    } else {
                        SchemaTypeImpl schemaTypeImpl5 = BuiltinSchemaTypeSystem.ST_ENTITIES;
                        if (schemaTypeImpl5.isAssignableFrom(schemaParticle.getType())) {
                            localPart = schemaTypeImpl5.getName().getLocalPart();
                        } else if (BuiltinSchemaTypeSystem.ST_NOTATION.isAssignableFrom(schemaParticle.getType())) {
                            if (schemaParticle.getType().getBuiltinTypeCode() == 8) {
                                StscState stscState5 = StscState.get();
                                Object[] objArr5 = {QNameHelper.pretty(schemaParticle.getName())};
                                XmlObject xmlObject2 = ((SchemaLocalElementImpl) schemaParticle)._parseObject;
                                stscState5.recover(XmlErrorCodes.ELEM_NOTATION_TYPE_FORBIDDEN, objArr5, xmlObject2 == null ? xmlObject : xmlObject2.selectAttribute("", "type"));
                                localPart2 = null;
                            } else {
                                if (schemaParticle.getType().getSimpleVariety() == 2) {
                                    SchemaType[] unionConstituentTypes = schemaParticle.getType().getUnionConstituentTypes();
                                    int length2 = unionConstituentTypes.length;
                                    while (i5 < length2) {
                                        if (unionConstituentTypes[i5].getBuiltinTypeCode() == 8) {
                                            StscState stscState6 = StscState.get();
                                            Object[] objArr6 = {QNameHelper.pretty(schemaParticle.getName())};
                                            XmlObject xmlObject3 = ((SchemaLocalElementImpl) schemaParticle)._parseObject;
                                            stscState6.recover(XmlErrorCodes.ELEM_NOTATION_TYPE_FORBIDDEN, objArr6, xmlObject3 == null ? xmlObject : xmlObject3.selectAttribute("", "type"));
                                        }
                                        i5++;
                                    }
                                }
                                localPart2 = BuiltinSchemaTypeSystem.ST_NOTATION.getName().getLocalPart();
                            }
                            while (schemaType.getOuterType() != null) {
                                schemaType = schemaType.getOuterType();
                            }
                            if (!schemaType.isDocumentType() ? schemaType.getName().getNamespaceURI().length() > 0 : schemaType.getDocumentElementName().getNamespaceURI().length() > 0) {
                                StscState stscState7 = StscState.get();
                                Object[] objArr7 = {QNameHelper.pretty(schemaParticle.getName())};
                                XmlObject xmlObject4 = ((SchemaLocalElementImpl) schemaParticle)._parseObject;
                                if (xmlObject4 == null) {
                                    xmlObject4 = xmlObject;
                                }
                                stscState7.warning(XmlErrorCodes.ELEM_COMPATIBILITY_TARGETNS, objArr7, xmlObject4);
                            }
                            localPart = localPart2;
                        } else {
                            localPart = null;
                        }
                    }
                }
            }
        }
        if (localPart != null) {
            StscState stscState8 = StscState.get();
            Object[] objArr8 = {QNameHelper.pretty(schemaParticle.getName()), localPart};
            XmlObject xmlObject5 = ((SchemaLocalElementImpl) schemaParticle)._parseObject;
            if (xmlObject5 != null) {
                xmlObject = xmlObject5.selectAttribute("", "type");
            }
            stscState8.warning(XmlErrorCodes.ELEM_COMPATIBILITY_TYPE, objArr8, xmlObject);
        }
    }

    /* JADX WARN: Code duplicated, block: B:62:0x0118  */
    /* JADX WARN: Code duplicated, block: B:65:0x012b  */
    public static void checkFields(SchemaTypeImpl schemaTypeImpl) {
        if (schemaTypeImpl.isSimpleType()) {
            return;
        }
        XmlObject parseObject = schemaTypeImpl.getParseObject();
        SchemaAttributeModel attributeModel = schemaTypeImpl.getAttributeModel();
        if (attributeModel != null) {
            SchemaLocalAttribute[] attributes = attributeModel.getAttributes();
            int length = attributes.length;
            Object[] objArr = null;
            QName name = null;
            int i5 = 0;
            while (i5 < length) {
                SchemaLocalAttribute schemaLocalAttribute = attributes[i5];
                XmlObject xmlObject = ((SchemaLocalAttributeImpl) schemaLocalAttribute)._parseObject;
                if (XmlID.type.isAssignableFrom(schemaLocalAttribute.getType())) {
                    if (name == null) {
                        name = schemaLocalAttribute.getName();
                    } else {
                        StscState.get().error(XmlErrorCodes.ATTR_GROUP_PROPERTIES$TWO_IDS, new Object[]{QNameHelper.pretty(name), schemaLocalAttribute.getName()}, xmlObject != null ? xmlObject : parseObject);
                    }
                    if (schemaLocalAttribute.getDefaultText() != null) {
                        StscState stscState = StscState.get();
                        if (xmlObject == null) {
                            xmlObject = parseObject;
                        }
                        stscState.error(XmlErrorCodes.ATTR_PROPERTIES$ID_FIXED_OR_DEFAULT, objArr, xmlObject);
                    }
                } else if (!XmlNOTATION.type.isAssignableFrom(schemaLocalAttribute.getType())) {
                    String defaultText = schemaLocalAttribute.getDefaultText();
                    if (defaultText != null) {
                        try {
                            XmlAnySimpleType defaultValue = schemaLocalAttribute.getDefaultValue();
                            if (!defaultValue.validate()) {
                                throw new Exception();
                            }
                            SchemaPropertyImpl schemaPropertyImpl = (SchemaPropertyImpl) schemaTypeImpl.getAttributeProperty(schemaLocalAttribute.getName());
                            if (schemaPropertyImpl != null && schemaPropertyImpl.getDefaultText() != null) {
                                schemaPropertyImpl.setDefaultValue(new XmlValueRef(defaultValue));
                            }
                        } catch (Exception unused) {
                            String str = schemaLocalAttribute.isFixed() ? "fixed" : "default";
                            if (xmlObject != null) {
                                XmlObject xmlObjectSelectAttribute = xmlObject.selectAttribute("", str);
                                if (xmlObjectSelectAttribute != null) {
                                    xmlObject = xmlObjectSelectAttribute;
                                }
                            } else {
                                xmlObject = parseObject;
                            }
                            StscState.get().error(XmlErrorCodes.ATTR_PROPERTIES$CONSTRAINT_VALID, new Object[]{QNameHelper.pretty(schemaLocalAttribute.getName()), str, defaultText, QNameHelper.pretty(schemaLocalAttribute.getType().getName())}, xmlObject);
                        }
                    } else {
                        continue;
                    }
                } else if (schemaLocalAttribute.getType().getBuiltinTypeCode() == 8) {
                    StscState stscState2 = StscState.get();
                    Object[] objArr2 = {QNameHelper.pretty(schemaLocalAttribute.getName())};
                    if (xmlObject == null) {
                        xmlObject = parseObject;
                    }
                    stscState2.recover(XmlErrorCodes.ATTR_NOTATION_TYPE_FORBIDDEN, objArr2, xmlObject);
                } else {
                    if (schemaLocalAttribute.getType().getSimpleVariety() == 2) {
                        for (SchemaType schemaType : schemaLocalAttribute.getType().getUnionConstituentTypes()) {
                            if (schemaType.getBuiltinTypeCode() == 8) {
                                StscState.get().recover(XmlErrorCodes.ATTR_NOTATION_TYPE_FORBIDDEN, new Object[]{QNameHelper.pretty(schemaLocalAttribute.getName())}, xmlObject != null ? xmlObject : parseObject);
                            }
                        }
                    }
                    if (!schemaTypeImpl.isAttributeType()) {
                        SchemaType outerType = schemaTypeImpl;
                        while (outerType.getOuterType() != null) {
                            outerType = outerType.getOuterType();
                        }
                        if (outerType.isDocumentType()) {
                            if (outerType.getDocumentElementName().getNamespaceURI().length() > 0) {
                                StscState stscState3 = StscState.get();
                                Object[] objArr3 = {QNameHelper.pretty(schemaLocalAttribute.getName())};
                                if (xmlObject == null) {
                                    xmlObject = parseObject;
                                }
                                stscState3.warning(XmlErrorCodes.ATTR_COMPATIBILITY_TARGETNS, objArr3, xmlObject);
                            }
                        } else if (outerType.getName().getNamespaceURI().length() > 0) {
                            StscState stscState4 = StscState.get();
                            Object[] objArr4 = {QNameHelper.pretty(schemaLocalAttribute.getName())};
                            if (xmlObject == null) {
                                xmlObject = parseObject;
                            }
                            stscState4.warning(XmlErrorCodes.ATTR_COMPATIBILITY_TARGETNS, objArr4, xmlObject);
                        }
                    } else if (schemaLocalAttribute.getName().getNamespaceURI().length() > 0) {
                        StscState stscState5 = StscState.get();
                        Object[] objArr5 = {QNameHelper.pretty(schemaLocalAttribute.getName())};
                        if (xmlObject == null) {
                            xmlObject = parseObject;
                        }
                        stscState5.warning(XmlErrorCodes.ATTR_COMPATIBILITY_TARGETNS, objArr5, xmlObject);
                    }
                }
                i5++;
                objArr = null;
            }
        }
        checkElementDefaults(schemaTypeImpl.getContentModel(), parseObject, schemaTypeImpl);
    }

    private static boolean checkFixed(SchemaLocalElement schemaLocalElement, SchemaLocalElement schemaLocalElement2, Collection<XmlError> collection, XmlObject xmlObject) {
        if (!schemaLocalElement.isFixed() || schemaLocalElement.getDefaultText().equals(schemaLocalElement2.getDefaultText())) {
            return true;
        }
        collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_RESTRICTION_NAME_AND_TYPE$FIXED, new Object[]{printParticle((SchemaParticle) schemaLocalElement2), schemaLocalElement2.getDefaultText(), printParticle((SchemaParticle) schemaLocalElement), schemaLocalElement.getDefaultText()}, xmlObject));
        return false;
    }

    private static boolean checkForIdentityConstraintExistence(SchemaIdentityConstraint[] schemaIdentityConstraintArr, SchemaIdentityConstraint schemaIdentityConstraint) {
        for (SchemaIdentityConstraint schemaIdentityConstraint2 : schemaIdentityConstraintArr) {
            if (schemaIdentityConstraint2.getName().equals(schemaIdentityConstraint.getName())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001a  */
    private static boolean checkGroupOccurrenceOK(SchemaParticle schemaParticle, SchemaParticle schemaParticle2, Collection<XmlError> collection, XmlObject xmlObject) {
        BigInteger effectiveMaxRangeAllSeq;
        BigInteger effectiveMinRangeAllSeq = BigInteger.ZERO;
        int particleType = schemaParticle2.getParticleType();
        boolean z6 = true;
        if (particleType == 1) {
            effectiveMinRangeAllSeq = getEffectiveMinRangeAllSeq(schemaParticle2);
            effectiveMaxRangeAllSeq = getEffectiveMaxRangeAllSeq(schemaParticle2);
        } else if (particleType == 2) {
            effectiveMinRangeAllSeq = getEffectiveMinRangeChoice(schemaParticle2);
            effectiveMaxRangeAllSeq = getEffectiveMaxRangeChoice(schemaParticle2);
        } else if (particleType != 3) {
            effectiveMaxRangeAllSeq = effectiveMinRangeAllSeq;
        } else {
            effectiveMinRangeAllSeq = getEffectiveMinRangeAllSeq(schemaParticle2);
            effectiveMaxRangeAllSeq = getEffectiveMaxRangeAllSeq(schemaParticle2);
        }
        if (effectiveMinRangeAllSeq.compareTo(schemaParticle.getMinOccurs()) < 0) {
            collection.add(XmlError.forObject(XmlErrorCodes.OCCURRENCE_RANGE$MIN_GTE_MIN, new Object[]{printParticle(schemaParticle2), printParticle(schemaParticle)}, xmlObject));
            z6 = false;
        }
        if (schemaParticle.getMaxOccurs() != null) {
            if (effectiveMaxRangeAllSeq == null) {
                collection.add(XmlError.forObject(XmlErrorCodes.OCCURRENCE_RANGE$MAX_LTE_MAX, new Object[]{printParticle(schemaParticle2), printParticle(schemaParticle)}, xmlObject));
                return false;
            }
            if (effectiveMaxRangeAllSeq.compareTo(schemaParticle.getMaxOccurs()) > 0) {
                collection.add(XmlError.forObject(XmlErrorCodes.OCCURRENCE_RANGE$MAX_LTE_MAX, new Object[]{printParticle(schemaParticle2), printParticle(schemaParticle)}, xmlObject));
                return false;
            }
        }
        return z6;
    }

    private static boolean checkIdentityConstraints(SchemaLocalElement schemaLocalElement, SchemaLocalElement schemaLocalElement2, Collection<XmlError> collection, XmlObject xmlObject) {
        SchemaIdentityConstraint[] identityConstraints = schemaLocalElement.getIdentityConstraints();
        for (SchemaIdentityConstraint schemaIdentityConstraint : schemaLocalElement2.getIdentityConstraints()) {
            if (checkForIdentityConstraintExistence(identityConstraints, schemaIdentityConstraint)) {
                collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_RESTRICTION_NAME_AND_TYPE$IDENTITY_CONSTRAINTS, new Object[]{printParticle((SchemaParticle) schemaLocalElement2), printParticle((SchemaParticle) schemaLocalElement)}, xmlObject));
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0056  */
    /* JADX WARN: Code duplicated, block: B:25:0x005c  */
    /* JADX WARN: Code duplicated, block: B:27:0x0062  */
    /* JADX WARN: Code duplicated, block: B:29:0x0068  */
    /* JADX WARN: Multi-variable type inference failed */
    public static boolean checkRestriction(SchemaTypeImpl schemaTypeImpl) {
        SchemaParticle contentModel;
        SchemaParticle contentModel2;
        if (schemaTypeImpl.getDerivationType() == 1 && !schemaTypeImpl.isSimpleType()) {
            StscState stscState = StscState.get();
            XmlObject parseObject = schemaTypeImpl.getParseObject();
            SchemaType baseType = schemaTypeImpl.getBaseType();
            if (baseType.isSimpleType()) {
                stscState.error(XmlErrorCodes.SCHEMA_COMPLEX_TYPE$COMPLEX_CONTENT, new Object[]{QNameHelper.pretty(baseType.getName())}, parseObject);
                return false;
            }
            int contentType = schemaTypeImpl.getContentType();
            if (contentType == 1) {
                int contentType2 = baseType.getContentType();
                if (contentType2 != 1) {
                    if (contentType2 != 3 && contentType2 != 4) {
                        stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$EMPTY_AND_NOT_SIMPLE, (Object[]) null, parseObject);
                        return false;
                    }
                    if (baseType.getContentModel() != null && !baseType.getContentModel().isSkippable()) {
                        stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$EMPTY_AND_ELEMENT_OR_MIXED_EMPTIABLE, (Object[]) null, parseObject);
                        return false;
                    }
                }
            } else if (contentType == 2) {
                int contentType3 = baseType.getContentType();
                if (contentType3 == 2) {
                    SchemaType contentBasedOnType = schemaTypeImpl.getContentBasedOnType();
                    if (contentBasedOnType != baseType) {
                        while (baseType != null && !baseType.isSimpleType()) {
                            baseType = baseType.getContentBasedOnType();
                        }
                        if (baseType != null && !baseType.isAssignableFrom(contentBasedOnType)) {
                            stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$SC_NOT_DERIVED, (Object[]) null, parseObject);
                            return false;
                        }
                    }
                } else {
                    if (contentType3 != 4) {
                        stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$SC_AND_SIMPLE_TYPE_OR_MIXED, (Object[]) null, parseObject);
                        return false;
                    }
                    if (baseType.getContentModel() != null && !baseType.getContentModel().isSkippable()) {
                        stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$SC_AND_MIXED_EMPTIABLE, (Object[]) null, parseObject);
                        return false;
                    }
                }
            } else if (contentType == 3) {
                if (baseType.getContentType() == 1) {
                    stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$ELEMENT_OR_MIXED_AND_EMPTY, (Object[]) null, parseObject);
                    return false;
                }
                if (baseType.getContentType() == 2) {
                    stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$ELEMENT_OR_MIXED_AND_SIMPLE, (Object[]) null, parseObject);
                    return false;
                }
                contentModel = baseType.getContentModel();
                contentModel2 = schemaTypeImpl.getContentModel();
                if (contentModel2 != null && schemaTypeImpl.getDerivationType() == 1) {
                    return true;
                }
                if (contentModel != null || contentModel2 == null) {
                    XBeanDebug.LOG.atTrace().withThrowable(new Exception("Stacktrace")).log("Null models that weren't caught by EMPTY_CONTENT: {} ({}), {} ({})", baseType, contentModel, schemaTypeImpl, contentModel2);
                    stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$ELEMENT_OR_MIXED_AND_VALID, (Object[]) null, parseObject);
                    return false;
                }
                ArrayList arrayList = new ArrayList();
                if (!isParticleValidRestriction(contentModel, contentModel2, arrayList, parseObject)) {
                    if (arrayList.size() == 0) {
                        stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$ELEMENT_OR_MIXED_AND_VALID, (Object[]) null, parseObject);
                    } else {
                        stscState.getErrorListener().add(arrayList.get(arrayList.size() - 1));
                    }
                    return false;
                }
            } else if (contentType == 4) {
                if (baseType.getContentType() != 4) {
                    stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$ELEMENT_OR_MIXED_AND_MIXED, (Object[]) null, parseObject);
                    return false;
                }
                if (baseType.getContentType() == 1) {
                    stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$ELEMENT_OR_MIXED_AND_EMPTY, (Object[]) null, parseObject);
                    return false;
                }
                if (baseType.getContentType() == 2) {
                    stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$ELEMENT_OR_MIXED_AND_SIMPLE, (Object[]) null, parseObject);
                    return false;
                }
                contentModel = baseType.getContentModel();
                contentModel2 = schemaTypeImpl.getContentModel();
                if (contentModel2 != null) {
                }
                if (contentModel != null) {
                }
                XBeanDebug.LOG.atTrace().withThrowable(new Exception("Stacktrace")).log("Null models that weren't caught by EMPTY_CONTENT: {} ({}), {} ({})", baseType, contentModel, schemaTypeImpl, contentModel2);
                stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$ELEMENT_OR_MIXED_AND_VALID, (Object[]) null, parseObject);
                return false;
            }
        }
        return true;
    }

    private static void checkSubstitutionGroups(SchemaGlobalElement[] schemaGlobalElementArr) {
        StscState stscState = StscState.get();
        for (SchemaGlobalElement schemaGlobalElement : schemaGlobalElementArr) {
            SchemaGlobalElement schemaGlobalElementSubstitutionGroup = schemaGlobalElement.substitutionGroup();
            if (schemaGlobalElementSubstitutionGroup != null) {
                SchemaType type = schemaGlobalElementSubstitutionGroup.getType();
                SchemaType type2 = schemaGlobalElement.getType();
                XmlObject xmlObject = ((SchemaGlobalElementImpl) schemaGlobalElement)._parseObject;
                if (!type.isAssignableFrom(type2)) {
                    stscState.error(XmlErrorCodes.ELEM_PROPERTIES$SUBSTITUTION_VALID, new Object[]{QNameHelper.pretty(schemaGlobalElement.getName()), QNameHelper.pretty(schemaGlobalElementSubstitutionGroup.getName())}, xmlObject);
                } else if (schemaGlobalElementSubstitutionGroup.finalExtension() && schemaGlobalElementSubstitutionGroup.finalRestriction()) {
                    stscState.error(XmlErrorCodes.ELEM_PROPERTIES$SUBSTITUTION_FINAL, new Object[]{QNameHelper.pretty(schemaGlobalElement.getName()), QNameHelper.pretty(schemaGlobalElementSubstitutionGroup.getName()), "#all"}, xmlObject);
                } else if (!type.equals(type2)) {
                    if (schemaGlobalElementSubstitutionGroup.finalExtension() && type2.getDerivationType() == 2) {
                        stscState.error(XmlErrorCodes.ELEM_PROPERTIES$SUBSTITUTION_FINAL, new Object[]{QNameHelper.pretty(schemaGlobalElement.getName()), QNameHelper.pretty(schemaGlobalElementSubstitutionGroup.getName()), "extension"}, xmlObject);
                    } else if (schemaGlobalElementSubstitutionGroup.finalRestriction() && type2.getDerivationType() == 1) {
                        stscState.error(XmlErrorCodes.ELEM_PROPERTIES$SUBSTITUTION_FINAL, new Object[]{QNameHelper.pretty(schemaGlobalElement.getName()), QNameHelper.pretty(schemaGlobalElementSubstitutionGroup.getName()), "restriction"}, xmlObject);
                    }
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0049 A[PHI: r0
  0x0049: PHI (r0v6 java.math.BigInteger) = (r0v5 java.math.BigInteger), (r0v8 java.math.BigInteger) binds: [B:30:0x0055, B:25:0x0047] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:27:0x004b  */
    private static BigInteger getEffectiveMaxRangeAllSeq(SchemaParticle schemaParticle) {
        BigInteger effectiveMaxRangeAllSeq = BigInteger.ZERO;
        BigInteger bigIntegerAdd = effectiveMaxRangeAllSeq;
        boolean z6 = false;
        BigInteger bigInteger = bigIntegerAdd;
        for (SchemaParticle schemaParticle2 : schemaParticle.getParticleChildren()) {
            int particleType = schemaParticle2.getParticleType();
            if (particleType == 1) {
                effectiveMaxRangeAllSeq = getEffectiveMaxRangeAllSeq(schemaParticle2);
                if (effectiveMaxRangeAllSeq != null && effectiveMaxRangeAllSeq.compareTo(bigInteger) > 0) {
                    bigInteger = effectiveMaxRangeAllSeq;
                }
            } else if (particleType == 2) {
                effectiveMaxRangeAllSeq = getEffectiveMaxRangeChoice(schemaParticle2);
                if (effectiveMaxRangeAllSeq != null && effectiveMaxRangeAllSeq.compareTo(bigInteger) > 0) {
                    bigInteger = effectiveMaxRangeAllSeq;
                }
            } else if (particleType == 3) {
                effectiveMaxRangeAllSeq = getEffectiveMaxRangeAllSeq(schemaParticle2);
                if (effectiveMaxRangeAllSeq != null) {
                    bigInteger = effectiveMaxRangeAllSeq;
                }
            } else if (particleType == 4 || particleType == 5) {
                if (schemaParticle2.getMaxOccurs() == null) {
                    effectiveMaxRangeAllSeq = null;
                } else if (schemaParticle2.getIntMaxOccurs() > 0) {
                    bigIntegerAdd = bigIntegerAdd.add(schemaParticle2.getMaxOccurs());
                    z6 = true;
                }
            }
            if (effectiveMaxRangeAllSeq == null) {
                break;
            }
        }
        if (effectiveMaxRangeAllSeq == null) {
            return effectiveMaxRangeAllSeq;
        }
        if (z6 && schemaParticle.getMaxOccurs() == null) {
            return null;
        }
        return schemaParticle.getMaxOccurs().multiply(bigIntegerAdd.add(bigInteger));
    }

    /* JADX WARN: Code duplicated, block: B:29:0x004f A[PHI: r0
  0x004f: PHI (r0v6 java.math.BigInteger) = (r0v5 java.math.BigInteger), (r0v8 java.math.BigInteger) binds: [B:33:0x005b, B:28:0x004d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:30:0x0051  */
    private static BigInteger getEffectiveMaxRangeChoice(SchemaParticle schemaParticle) {
        BigInteger effectiveMaxRangeAllSeq = BigInteger.ZERO;
        BigInteger maxOccurs = effectiveMaxRangeAllSeq;
        boolean z6 = false;
        BigInteger bigInteger = maxOccurs;
        for (SchemaParticle schemaParticle2 : schemaParticle.getParticleChildren()) {
            int particleType = schemaParticle2.getParticleType();
            if (particleType == 1) {
                effectiveMaxRangeAllSeq = getEffectiveMaxRangeAllSeq(schemaParticle2);
                if (effectiveMaxRangeAllSeq != null && effectiveMaxRangeAllSeq.compareTo(bigInteger) > 0) {
                    bigInteger = effectiveMaxRangeAllSeq;
                }
            } else if (particleType == 2) {
                effectiveMaxRangeAllSeq = getEffectiveMaxRangeChoice(schemaParticle2);
                if (effectiveMaxRangeAllSeq != null && effectiveMaxRangeAllSeq.compareTo(bigInteger) > 0) {
                    bigInteger = effectiveMaxRangeAllSeq;
                }
            } else if (particleType == 3) {
                effectiveMaxRangeAllSeq = getEffectiveMaxRangeAllSeq(schemaParticle2);
                if (effectiveMaxRangeAllSeq != null) {
                    bigInteger = effectiveMaxRangeAllSeq;
                }
            } else if (particleType == 4 || particleType == 5) {
                if (schemaParticle2.getMaxOccurs() == null) {
                    effectiveMaxRangeAllSeq = null;
                } else if (schemaParticle2.getIntMaxOccurs() > 0) {
                    if (schemaParticle2.getMaxOccurs().compareTo(maxOccurs) > 0) {
                        maxOccurs = schemaParticle2.getMaxOccurs();
                    }
                    z6 = true;
                }
            }
            if (effectiveMaxRangeAllSeq == null) {
                break;
            }
        }
        if (effectiveMaxRangeAllSeq == null) {
            return effectiveMaxRangeAllSeq;
        }
        if (z6 && schemaParticle.getMaxOccurs() == null) {
            return null;
        }
        return schemaParticle.getMaxOccurs().multiply(maxOccurs.add(bigInteger));
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0032  */
    private static BigInteger getEffectiveMinRangeAllSeq(SchemaParticle schemaParticle) {
        SchemaParticle[] particleChildren = schemaParticle.getParticleChildren();
        BigInteger bigIntegerAdd = BigInteger.ZERO;
        for (SchemaParticle schemaParticle2 : particleChildren) {
            int particleType = schemaParticle2.getParticleType();
            if (particleType == 1) {
                bigIntegerAdd = bigIntegerAdd.add(getEffectiveMinRangeAllSeq(schemaParticle2));
            } else if (particleType == 2) {
                bigIntegerAdd = bigIntegerAdd.add(getEffectiveMinRangeChoice(schemaParticle2));
            } else if (particleType == 3) {
                bigIntegerAdd = bigIntegerAdd.add(getEffectiveMinRangeAllSeq(schemaParticle2));
            } else if (particleType == 4 || particleType == 5) {
                bigIntegerAdd = bigIntegerAdd.add(schemaParticle2.getMinOccurs());
            }
        }
        return schemaParticle.getMinOccurs().multiply(bigIntegerAdd);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0042 A[PHI: r4
  0x0042: PHI (r4v2 java.math.BigInteger) = (r4v1 java.math.BigInteger), (r4v1 java.math.BigInteger), (r4v3 java.math.BigInteger), (r4v3 java.math.BigInteger) binds: [B:29:0x0048, B:31:0x004e, B:24:0x003a, B:26:0x0040] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:28:0x0044  */
    private static BigInteger getEffectiveMinRangeChoice(SchemaParticle schemaParticle) {
        BigInteger effectiveMinRangeAllSeq;
        SchemaParticle[] particleChildren = schemaParticle.getParticleChildren();
        if (particleChildren.length == 0) {
            return BigInteger.ZERO;
        }
        BigInteger minOccurs = null;
        for (SchemaParticle schemaParticle2 : particleChildren) {
            int particleType = schemaParticle2.getParticleType();
            if (particleType == 1) {
                effectiveMinRangeAllSeq = getEffectiveMinRangeAllSeq(schemaParticle2);
                if (minOccurs != null || minOccurs.compareTo(effectiveMinRangeAllSeq) > 0) {
                    minOccurs = effectiveMinRangeAllSeq;
                }
            } else if (particleType == 2) {
                effectiveMinRangeAllSeq = getEffectiveMinRangeChoice(schemaParticle2);
                if (minOccurs == null || minOccurs.compareTo(effectiveMinRangeAllSeq) > 0) {
                    minOccurs = effectiveMinRangeAllSeq;
                }
            } else if (particleType == 3) {
                effectiveMinRangeAllSeq = getEffectiveMinRangeAllSeq(schemaParticle2);
                if (minOccurs != null) {
                    minOccurs = effectiveMinRangeAllSeq;
                } else {
                    minOccurs = effectiveMinRangeAllSeq;
                }
            } else if ((particleType == 4 || particleType == 5) && (minOccurs == null || minOccurs.compareTo(schemaParticle2.getMinOccurs()) > 0)) {
                minOccurs = schemaParticle2.getMinOccurs();
            }
        }
        if (minOccurs == null) {
            minOccurs = BigInteger.ZERO;
        }
        return schemaParticle.getMinOccurs().multiply(minOccurs);
    }

    public static boolean isParticleValidRestriction(SchemaParticle schemaParticle, SchemaParticle schemaParticle2, Collection<XmlError> collection, XmlObject xmlObject) {
        if (schemaParticle.equals(schemaParticle2)) {
            return true;
        }
        int particleType = schemaParticle.getParticleType();
        if (particleType == 1) {
            int particleType2 = schemaParticle2.getParticleType();
            if (particleType2 == 1) {
                return recurse(schemaParticle, schemaParticle2, collection, xmlObject);
            }
            if (particleType2 != 2) {
                if (particleType2 == 3) {
                    return recurseUnordered(schemaParticle, schemaParticle2, collection, xmlObject);
                }
                if (particleType2 == 4) {
                    return recurseAsIfGroup(schemaParticle, schemaParticle2, collection, xmlObject);
                }
                if (particleType2 != 5) {
                    XBeanDebug.LOG.atDebug().withThrowable(new Exception("stacktrace")).log("Unknown schema type for Derived Type");
                    return false;
                }
            }
            collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_RESTRICTION$INVALID_RESTRICTION, new Object[]{printParticle(schemaParticle2), printParticle(schemaParticle)}, xmlObject));
            return false;
        }
        if (particleType == 2) {
            int particleType3 = schemaParticle2.getParticleType();
            if (particleType3 != 1) {
                if (particleType3 == 2) {
                    return recurseLax(schemaParticle, schemaParticle2, collection, xmlObject);
                }
                if (particleType3 == 3) {
                    return mapAndSum(schemaParticle, schemaParticle2, collection, xmlObject);
                }
                if (particleType3 == 4) {
                    return recurseAsIfGroup(schemaParticle, schemaParticle2, collection, xmlObject);
                }
                if (particleType3 != 5) {
                    XBeanDebug.LOG.atDebug().withThrowable(new Exception("stacktrace")).log("Unknown schema type for Derived Type");
                    return false;
                }
            }
            collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_RESTRICTION$INVALID_RESTRICTION, new Object[]{printParticle(schemaParticle2), printParticle(schemaParticle)}, xmlObject));
            return false;
        }
        if (particleType == 3) {
            int particleType4 = schemaParticle2.getParticleType();
            if (particleType4 != 1 && particleType4 != 2) {
                if (particleType4 == 3) {
                    return recurse(schemaParticle, schemaParticle2, collection, xmlObject);
                }
                if (particleType4 == 4) {
                    return recurseAsIfGroup(schemaParticle, schemaParticle2, collection, xmlObject);
                }
                if (particleType4 != 5) {
                    XBeanDebug.LOG.atDebug().withThrowable(new Exception("stacktrace")).log("Unknown schema type for Derived Type");
                    return false;
                }
            }
            collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_RESTRICTION$INVALID_RESTRICTION, new Object[]{printParticle(schemaParticle2), printParticle(schemaParticle)}, xmlObject));
            return false;
        }
        if (particleType == 4) {
            int particleType5 = schemaParticle2.getParticleType();
            if (particleType5 != 1 && particleType5 != 2 && particleType5 != 3) {
                if (particleType5 == 4) {
                    return nameAndTypeOK((SchemaLocalElement) schemaParticle, (SchemaLocalElement) schemaParticle2, collection, xmlObject);
                }
                if (particleType5 != 5) {
                    XBeanDebug.LOG.atDebug().withThrowable(new Exception("stacktrace")).log("Unknown schema type for Derived Type");
                    return false;
                }
            }
            collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_RESTRICTION$INVALID_RESTRICTION, new Object[]{printParticle(schemaParticle2), printParticle(schemaParticle)}, xmlObject));
            return false;
        }
        if (particleType != 5) {
            XBeanDebug.LOG.atDebug().withThrowable(new Exception("stacktrace")).log("Unknown schema type for Base Type");
            return false;
        }
        int particleType6 = schemaParticle2.getParticleType();
        if (particleType6 == 1 || particleType6 == 2 || particleType6 == 3) {
            return nsRecurseCheckCardinality(schemaParticle, schemaParticle2, collection, xmlObject);
        }
        if (particleType6 == 4) {
            return nsCompat(schemaParticle, (SchemaLocalElement) schemaParticle2, collection, xmlObject);
        }
        if (particleType6 == 5) {
            return nsSubset(schemaParticle, schemaParticle2, collection, xmlObject);
        }
        XBeanDebug.LOG.atDebug().withThrowable(new Exception("stacktrace")).log("Unknown schema type for Derived Type");
        return false;
    }

    private static boolean mapAndSum(SchemaParticle schemaParticle, SchemaParticle schemaParticle2, Collection<XmlError> collection, XmlObject xmlObject) {
        SchemaParticle[] particleChildren = schemaParticle2.getParticleChildren();
        SchemaParticle[] particleChildren2 = schemaParticle.getParticleChildren();
        for (SchemaParticle schemaParticle3 : particleChildren) {
            int length = particleChildren2.length;
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_DERIVATION_MAP_AND_SUM$MAP, new Object[]{printParticle(schemaParticle3)}, xmlObject));
                    return false;
                }
                if (isParticleValidRestriction(particleChildren2[i5], schemaParticle3, collection, xmlObject)) {
                    break;
                }
                i5++;
            }
        }
        BigInteger bigIntegerMultiply = schemaParticle2.getMinOccurs().multiply(BigInteger.valueOf(schemaParticle2.getParticleChildren().length));
        BigInteger bigIntegerMultiply2 = schemaParticle2.getMaxOccurs() == null ? null : schemaParticle2.getMaxOccurs().multiply(BigInteger.valueOf(schemaParticle2.getParticleChildren().length));
        if (bigIntegerMultiply.compareTo(schemaParticle.getMinOccurs()) < 0) {
            collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_DERIVATION_MAP_AND_SUM$SUM_MIN_OCCURS_GTE_MIN_OCCURS, new Object[]{bigIntegerMultiply.toString(), schemaParticle.getMinOccurs().toString()}, xmlObject));
            return false;
        }
        if (schemaParticle.getMaxOccurs() == null) {
            return true;
        }
        if (bigIntegerMultiply2 != null && bigIntegerMultiply2.compareTo(schemaParticle.getMaxOccurs()) <= 0) {
            return true;
        }
        collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_DERIVATION_MAP_AND_SUM$SUM_MAX_OCCURS_LTE_MAX_OCCURS, new Object[]{bigIntegerMultiply2 == null ? "unbounded" : bigIntegerMultiply2.toString(), schemaParticle.getMaxOccurs().toString()}, xmlObject));
        return false;
    }

    private static boolean nameAndTypeOK(SchemaLocalElement schemaLocalElement, SchemaLocalElement schemaLocalElement2, Collection<XmlError> collection, XmlObject xmlObject) {
        SchemaParticle schemaParticle = (SchemaParticle) schemaLocalElement;
        if (!schemaParticle.canStartWithElement(schemaLocalElement2.getName())) {
            collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_RESTRICTION_NAME_AND_TYPE$NAME, new Object[]{printParticle((SchemaParticle) schemaLocalElement2), printParticle(schemaParticle)}, xmlObject));
            return false;
        }
        if (!schemaLocalElement.isNillable() && schemaLocalElement2.isNillable()) {
            collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_RESTRICTION_NAME_AND_TYPE$NILLABLE, new Object[]{printParticle((SchemaParticle) schemaLocalElement2), printParticle((SchemaParticle) schemaLocalElement)}, xmlObject));
            return false;
        }
        if (occurrenceRangeOK((SchemaParticle) schemaLocalElement, (SchemaParticle) schemaLocalElement2, collection, xmlObject) && checkFixed(schemaLocalElement, schemaLocalElement2, collection, xmlObject) && checkIdentityConstraints(schemaLocalElement, schemaLocalElement2, collection, xmlObject) && typeDerivationOK(schemaLocalElement.getType(), schemaLocalElement2.getType(), collection, xmlObject)) {
            return blockSetOK(schemaLocalElement, schemaLocalElement2, collection, xmlObject);
        }
        return false;
    }

    private static boolean nsCompat(SchemaParticle schemaParticle, SchemaLocalElement schemaLocalElement, Collection<XmlError> collection, XmlObject xmlObject) {
        if (schemaParticle.getWildcardSet().contains(schemaLocalElement.getName())) {
            return occurrenceRangeOK(schemaParticle, (SchemaParticle) schemaLocalElement, collection, xmlObject);
        }
        collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_DERIVATION_NS_COMPAT$WILDCARD_VALID, new Object[]{printParticle((SchemaParticle) schemaLocalElement), printParticle(schemaParticle)}, xmlObject));
        return false;
    }

    private static boolean nsRecurseCheckCardinality(SchemaParticle schemaParticle, SchemaParticle schemaParticle2, Collection<XmlError> collection, XmlObject xmlObject) {
        SchemaParticleImpl schemaParticleImpl = new SchemaParticleImpl();
        schemaParticleImpl.setParticleType(schemaParticle.getParticleType());
        schemaParticleImpl.setWildcardProcess(schemaParticle.getWildcardProcess());
        schemaParticleImpl.setWildcardSet(schemaParticle.getWildcardSet());
        schemaParticleImpl.setMinOccurs(BigInteger.ZERO);
        schemaParticleImpl.setMaxOccurs(null);
        schemaParticleImpl.setTransitionRules(schemaParticle.getWildcardSet(), true);
        schemaParticleImpl.setTransitionNotes(schemaParticle.getWildcardSet(), true);
        boolean zNsRecurseCheckCardinality = true;
        for (SchemaParticle schemaParticle3 : schemaParticle2.getParticleChildren()) {
            int particleType = schemaParticle3.getParticleType();
            if (particleType == 1 || particleType == 2 || particleType == 3) {
                zNsRecurseCheckCardinality = nsRecurseCheckCardinality(schemaParticleImpl, schemaParticle3, collection, xmlObject);
            } else if (particleType == 4) {
                zNsRecurseCheckCardinality = nsCompat(schemaParticleImpl, (SchemaLocalElement) schemaParticle3, collection, xmlObject);
            } else if (particleType == 5) {
                zNsRecurseCheckCardinality = nsSubset(schemaParticleImpl, schemaParticle3, collection, xmlObject);
            }
            if (!zNsRecurseCheckCardinality) {
                break;
            }
        }
        return zNsRecurseCheckCardinality ? checkGroupOccurrenceOK(schemaParticle, schemaParticle2, collection, xmlObject) : zNsRecurseCheckCardinality;
    }

    private static boolean nsSubset(SchemaParticle schemaParticle, SchemaParticle schemaParticle2, Collection<XmlError> collection, XmlObject xmlObject) {
        if (occurrenceRangeOK(schemaParticle, schemaParticle2, collection, xmlObject)) {
            if (schemaParticle.getWildcardSet().inverse().isDisjoint(schemaParticle2.getWildcardSet())) {
                return true;
            }
            collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_DERIVATION_NS_SUBST$WILDCARD_SUBSET, new Object[]{printParticle(schemaParticle2), printParticle(schemaParticle)}, xmlObject));
        }
        return false;
    }

    private static boolean occurrenceRangeOK(SchemaParticle schemaParticle, SchemaParticle schemaParticle2, Collection<XmlError> collection, XmlObject xmlObject) {
        if (schemaParticle2.getMinOccurs().compareTo(schemaParticle.getMinOccurs()) < 0) {
            collection.add(XmlError.forObject(XmlErrorCodes.OCCURRENCE_RANGE$MIN_GTE_MIN, new Object[]{printParticle(schemaParticle2), schemaParticle2.getMinOccurs().toString(), printParticle(schemaParticle), schemaParticle.getMinOccurs().toString()}, xmlObject));
            return false;
        }
        if (schemaParticle.getMaxOccurs() == null) {
            return true;
        }
        if (schemaParticle2.getMaxOccurs() != null && schemaParticle.getMaxOccurs() != null && schemaParticle2.getMaxOccurs().compareTo(schemaParticle.getMaxOccurs()) <= 0) {
            return true;
        }
        collection.add(XmlError.forObject(XmlErrorCodes.OCCURRENCE_RANGE$MAX_LTE_MAX, new Object[]{printParticle(schemaParticle2), printMaxOccurs(schemaParticle2.getMaxOccurs()), printParticle(schemaParticle), printMaxOccurs(schemaParticle.getMaxOccurs())}, xmlObject));
        return false;
    }

    private static String printMaxOccurs(BigInteger bigInteger) {
        return bigInteger == null ? "unbounded" : bigInteger.toString();
    }

    private static String printParticle(SchemaParticle schemaParticle) {
        int particleType = schemaParticle.getParticleType();
        if (particleType == 1) {
            return "<all>";
        }
        if (particleType == 2) {
            return "<choice>";
        }
        if (particleType == 3) {
            return "<sequence>";
        }
        if (particleType != 4) {
            return particleType != 5 ? "??" : "<any>";
        }
        return "<element name=\"" + QNameHelper.pretty(schemaParticle.getName()) + "\">";
    }

    private static String printParticles(List<SchemaParticle> list) {
        return printParticles((SchemaParticle[]) list.toArray(new SchemaParticle[0]));
    }

    private static String printType(SchemaType schemaType) {
        return schemaType.getName() != null ? QNameHelper.pretty(schemaType.getName()) : schemaType.toString();
    }

    private static boolean recurse(SchemaParticle schemaParticle, SchemaParticle schemaParticle2, Collection<XmlError> collection, XmlObject xmlObject) {
        boolean z6;
        if (!occurrenceRangeOK(schemaParticle, schemaParticle2, collection, xmlObject)) {
            return false;
        }
        SchemaParticle[] particleChildren = schemaParticle2.getParticleChildren();
        SchemaParticle[] particleChildren2 = schemaParticle.getParticleChildren();
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (i5 >= particleChildren.length || i6 >= particleChildren2.length) {
                z6 = true;
                break;
            }
            SchemaParticle schemaParticle3 = particleChildren[i5];
            SchemaParticle schemaParticle4 = particleChildren2[i6];
            if (!isParticleValidRestriction(schemaParticle4, schemaParticle3, collection, xmlObject)) {
                if (!schemaParticle4.isSkippable()) {
                    collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_DERIVATION_RECURSE$MAP_VALID, new Object[]{printParticle(schemaParticle3), printParticle(schemaParticle2), printParticle(schemaParticle4), printParticle(schemaParticle)}, xmlObject));
                    z6 = false;
                    break;
                }
            } else {
                i5++;
            }
            i6++;
        }
        if (i5 < particleChildren.length) {
            collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_DERIVATION_RECURSE$MAP, new Object[]{printParticle(schemaParticle2), printParticle(schemaParticle), printParticles(particleChildren, i5)}, xmlObject));
            return false;
        }
        if (i6 < particleChildren2.length) {
            ArrayList arrayList = new ArrayList(particleChildren2.length);
            while (i6 < particleChildren2.length) {
                if (!particleChildren2[i6].isSkippable()) {
                    arrayList.add(particleChildren2[i6]);
                }
                i6++;
            }
            if (arrayList.size() > 0) {
                collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_DERIVATION_RECURSE$UNMAPPED_ARE_EMPTIABLE, new Object[]{printParticle(schemaParticle), printParticle(schemaParticle2), printParticles(arrayList)}, xmlObject));
                return false;
            }
        }
        return z6;
    }

    private static boolean recurseAsIfGroup(SchemaParticle schemaParticle, SchemaParticle schemaParticle2, Collection<XmlError> collection, XmlObject xmlObject) {
        SchemaParticleImpl schemaParticleImpl = new SchemaParticleImpl();
        schemaParticleImpl.setParticleType(schemaParticle.getParticleType());
        BigInteger bigInteger = BigInteger.ONE;
        schemaParticleImpl.setMinOccurs(bigInteger);
        schemaParticleImpl.setMaxOccurs(bigInteger);
        schemaParticleImpl.setParticleChildren(new SchemaParticle[]{schemaParticle2});
        return isParticleValidRestriction(schemaParticle, schemaParticleImpl, collection, xmlObject);
    }

    private static boolean recurseLax(SchemaParticle schemaParticle, SchemaParticle schemaParticle2, Collection<XmlError> collection, XmlObject xmlObject) {
        if (!occurrenceRangeOK(schemaParticle, schemaParticle2, collection, xmlObject)) {
            return false;
        }
        SchemaParticle[] particleChildren = schemaParticle2.getParticleChildren();
        SchemaParticle[] particleChildren2 = schemaParticle.getParticleChildren();
        int i5 = 0;
        for (int i6 = 0; i5 < particleChildren.length && i6 < particleChildren2.length; i6++) {
            if (isParticleValidRestriction(particleChildren2[i6], particleChildren[i5], collection, xmlObject)) {
                i5++;
            }
        }
        if (i5 >= particleChildren.length) {
            return true;
        }
        collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_DERIVATION_RECURSE_LAX$MAP, new Object[]{printParticles(particleChildren2, i5)}, xmlObject));
        return false;
    }

    private static boolean recurseUnordered(SchemaParticle schemaParticle, SchemaParticle schemaParticle2, Collection<XmlError> collection, XmlObject xmlObject) {
        boolean z6;
        if (!occurrenceRangeOK(schemaParticle, schemaParticle2, collection, xmlObject)) {
            return false;
        }
        SchemaParticle[] particleChildren = schemaParticle.getParticleChildren();
        HashMap map = new HashMap(10);
        Object obj = new Object();
        for (SchemaParticle schemaParticle3 : particleChildren) {
            map.put(schemaParticle3.getName(), schemaParticle3);
        }
        SchemaParticle[] particleChildren2 = schemaParticle2.getParticleChildren();
        int length = particleChildren2.length;
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                z6 = true;
                break;
            }
            SchemaParticle schemaParticle4 = particleChildren2[i5];
            Object obj2 = map.get(schemaParticle4.getName());
            if (obj2 == null) {
                collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_DERIVATION_RECURSE_UNORDERED$MAP, new Object[]{printParticle(schemaParticle4)}, xmlObject));
            } else if (obj2 == obj) {
                collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_DERIVATION_RECURSE_UNORDERED$MAP_UNIQUE, new Object[]{printParticle(schemaParticle4)}, xmlObject));
            } else {
                SchemaParticle schemaParticle5 = (SchemaParticle) obj2;
                if (schemaParticle4.getMaxOccurs() == null || schemaParticle4.getMaxOccurs().compareTo(BigInteger.ONE) > 0) {
                    collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_DERIVATION_RECURSE_UNORDERED$MAP_MAX_OCCURS_1, new Object[]{printParticle(schemaParticle4), printMaxOccurs(schemaParticle4.getMinOccurs())}, xmlObject));
                } else if (isParticleValidRestriction(schemaParticle5, schemaParticle4, collection, xmlObject)) {
                    map.put(schemaParticle4.getName(), obj);
                    i5++;
                }
            }
            z6 = false;
            break;
        }
        if (z6) {
            for (QName qName : map.keySet()) {
                if (map.get(qName) != obj && !((SchemaParticle) map.get(qName)).isSkippable()) {
                    collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_DERIVATION_RECURSE_UNORDERED$UNMAPPED_ARE_EMPTIABLE, new Object[]{printParticle((SchemaParticle) map.get(qName))}, xmlObject));
                    z6 = false;
                }
            }
        }
        return z6;
    }

    private static boolean typeDerivationOK(SchemaType schemaType, SchemaType schemaType2, Collection<XmlError> collection, XmlObject xmlObject) {
        if (schemaType.isAssignableFrom(schemaType2)) {
            return checkAllDerivationsForRestriction(schemaType, schemaType2, collection, xmlObject);
        }
        collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_RESTRICTION_NAME_AND_TYPE$TYPE_VALID, new Object[]{printType(schemaType2), printType(schemaType)}, xmlObject));
        return false;
    }

    private static String printParticles(SchemaParticle[] schemaParticleArr) {
        return printParticles(schemaParticleArr, 0, schemaParticleArr.length);
    }

    private static String printParticles(SchemaParticle[] schemaParticleArr, int i5) {
        return printParticles(schemaParticleArr, i5, schemaParticleArr.length);
    }

    private static String printParticles(SchemaParticle[] schemaParticleArr, int i5, int i6) {
        StringBuilder sb = new StringBuilder(schemaParticleArr.length * 30);
        while (i5 < i6) {
            sb.append(printParticle(schemaParticleArr[i5]));
            i5++;
            if (i5 != i6) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
