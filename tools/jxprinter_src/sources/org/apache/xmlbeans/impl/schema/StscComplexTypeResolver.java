package org.apache.xmlbeans.impl.schema;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.xml.namespace.QName;
import org.apache.commons.codec.language.bm.Languages;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.QNameSetBuilder;
import org.apache.xmlbeans.QNameSetSpecification;
import org.apache.xmlbeans.SchemaAttributeModel;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaLocalAttribute;
import org.apache.xmlbeans.SchemaLocalElement;
import org.apache.xmlbeans.SchemaParticle;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlNonNegativeInteger;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.xb.xsdschema.AllNNI;
import org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
import org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroupRef;
import org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.ComplexRestrictionType;
import org.apache.xmlbeans.impl.xb.xsdschema.ComplexType;
import org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType;
import org.apache.xmlbeans.impl.xb.xsdschema.Group;
import org.apache.xmlbeans.impl.xb.xsdschema.LocalElement;
import org.apache.xmlbeans.impl.xb.xsdschema.NamespaceList;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SimpleExtensionType;
import org.apache.xmlbeans.impl.xb.xsdschema.SimpleRestrictionType;
import org.apache.xmlbeans.impl.xb.xsdschema.Wildcard;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class StscComplexTypeResolver {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ANY_ATTRIBUTE_CODE = 102;
    private static final int ATTRIBUTE_CODE = 100;
    private static final int ATTRIBUTE_GROUP_CODE = 101;
    private static final int MODEL_GROUP_CODE = 100;
    private static final Map<QName, Integer> attributeCodeMap;
    private static final CodeForNameEntry[] attributeCodes;
    private static final Map<QName, Integer> particleCodeMap;
    private static final CodeForNameEntry[] particleCodes;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class CodeForNameEntry {
        public int code;
        public QName name;

        public CodeForNameEntry(QName qName, int i5) {
            this.name = qName;
            this.code = i5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class RedefinitionForGroup {
        private final SchemaModelGroupImpl group;
        private boolean seenRedefinition = false;

        public RedefinitionForGroup(SchemaModelGroupImpl schemaModelGroupImpl) {
            this.group = schemaModelGroupImpl;
        }

        public SchemaModelGroupImpl getGroup() {
            return this.group;
        }

        public boolean isSeenRedefinition() {
            return this.seenRedefinition;
        }

        public void setSeenRedefinition(boolean z6) {
            this.seenRedefinition = z6;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class WildcardResult {
        boolean hasWildcards;
        QNameSet typedWildcards;

        public WildcardResult(QNameSet qNameSet, boolean z6) {
            this.typedWildcards = qNameSet;
            this.hasWildcards = z6;
        }
    }

    static {
        CodeForNameEntry[] codeForNameEntryArr = {new CodeForNameEntry(QNameHelper.forLNS("all", "http://www.w3.org/2001/XMLSchema"), 1), new CodeForNameEntry(QNameHelper.forLNS("sequence", "http://www.w3.org/2001/XMLSchema"), 3), new CodeForNameEntry(QNameHelper.forLNS("choice", "http://www.w3.org/2001/XMLSchema"), 2), new CodeForNameEntry(QNameHelper.forLNS("element", "http://www.w3.org/2001/XMLSchema"), 4), new CodeForNameEntry(QNameHelper.forLNS(Languages.ANY, "http://www.w3.org/2001/XMLSchema"), 5), new CodeForNameEntry(QNameHelper.forLNS("group", "http://www.w3.org/2001/XMLSchema"), 100)};
        particleCodes = codeForNameEntryArr;
        particleCodeMap = (Map) Stream.of((Object[]) codeForNameEntryArr).collect(Collectors.toMap(new l(0), new l(1)));
        CodeForNameEntry[] codeForNameEntryArr2 = {new CodeForNameEntry(QNameHelper.forLNS("attribute", "http://www.w3.org/2001/XMLSchema"), 100), new CodeForNameEntry(QNameHelper.forLNS("attributeGroup", "http://www.w3.org/2001/XMLSchema"), 101), new CodeForNameEntry(QNameHelper.forLNS("anyAttribute", "http://www.w3.org/2001/XMLSchema"), 102)};
        attributeCodes = codeForNameEntryArr2;
        attributeCodeMap = (Map) Stream.of((Object[]) codeForNameEntryArr2).collect(Collectors.toMap(new l(2), new l(3)));
    }

    public static void addMinusPointlessParticles(List<SchemaParticle> list, SchemaParticle schemaParticle, int i5) {
        if (schemaParticle == null) {
            return;
        }
        int particleType = schemaParticle.getParticleType();
        if (particleType != 2) {
            if (particleType == 3 && i5 == 3 && schemaParticle.isSingleton()) {
                list.addAll(Arrays.asList(schemaParticle.getParticleChildren()));
                return;
            }
        } else if (i5 == 2 && schemaParticle.isSingleton()) {
            list.addAll(Arrays.asList(schemaParticle.getParticleChildren()));
            return;
        }
        list.add(schemaParticle);
    }

    private static boolean afterMapSubsumedByStartMap(Map<SchemaParticle, QNameSet> map, Map<SchemaParticle, QNameSet> map2) {
        if (map2.size() > map.size()) {
            return false;
        }
        if (map2.isEmpty()) {
            return true;
        }
        for (SchemaParticle schemaParticle : map.keySet()) {
            if (schemaParticle.getParticleType() == 5 && map2.containsKey(schemaParticle) && !map.get(schemaParticle).containsAll(map2.get(schemaParticle))) {
                return false;
            }
            map2.remove(schemaParticle);
            if (map2.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public static Map<QName, SchemaProperty> buildAttributePropertyModelByQName(SchemaAttributeModel schemaAttributeModel, SchemaType schemaType) {
        return (Map) Stream.of((Object[]) schemaAttributeModel.getAttributes()).collect(Collectors.toMap(new l(28), new a(schemaType, 2), throwingMerger(), new d(1)));
    }

    /* JADX WARN: Code duplicated, block: B:21:0x002e  */
    /* JADX WARN: Code duplicated, block: B:43:0x00b0  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.Map<javax.xml.namespace.QName, org.apache.xmlbeans.SchemaProperty>] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.LinkedHashMap, java.util.Map] */
    public static Map<QName, SchemaProperty> buildContentPropertyModelByQName(SchemaParticle schemaParticle, SchemaType schemaType) {
        ?? linkedHashMap;
        Map<QName, SchemaProperty> mapBuildElementPropertyModel;
        if (schemaParticle == null) {
            return Collections.EMPTY_MAP;
        }
        int particleType = schemaParticle.getParticleType();
        boolean z6 = true;
        if (particleType == 1) {
            linkedHashMap = 0;
        } else {
            if (particleType == 2) {
                mapBuildElementPropertyModel = null;
            } else if (particleType == 3) {
                linkedHashMap = 0;
            } else if (particleType == 4) {
                mapBuildElementPropertyModel = buildElementPropertyModel((SchemaLocalElement) schemaParticle, schemaType);
            } else {
                if (particleType != 5) {
                    throw new IllegalStateException();
                }
                mapBuildElementPropertyModel = Collections.EMPTY_MAP;
            }
            z6 = false;
            linkedHashMap = mapBuildElementPropertyModel;
        }
        if (linkedHashMap == 0) {
            linkedHashMap = new LinkedHashMap();
            for (SchemaParticle schemaParticle2 : schemaParticle.getParticleChildren()) {
                for (SchemaProperty schemaProperty : buildContentPropertyModelByQName(schemaParticle2, schemaType).values()) {
                    SchemaPropertyImpl schemaPropertyImpl = (SchemaPropertyImpl) linkedHashMap.get(schemaProperty.getName());
                    if (schemaPropertyImpl == null) {
                        if (!z6) {
                            ((SchemaPropertyImpl) schemaProperty).setMinOccurs(BigInteger.ZERO);
                        }
                        linkedHashMap.put(schemaProperty.getName(), schemaProperty);
                    } else {
                        mergeProperties(schemaPropertyImpl, schemaProperty, z6);
                    }
                }
            }
            BigInteger minOccurs = schemaParticle.getMinOccurs();
            BigInteger maxOccurs = schemaParticle.getMaxOccurs();
            for (SchemaProperty schemaProperty2 : linkedHashMap.values()) {
                BigInteger minOccurs2 = schemaProperty2.getMinOccurs();
                BigInteger maxOccurs2 = schemaProperty2.getMaxOccurs();
                BigInteger bigIntegerMultiply = minOccurs2.multiply(minOccurs);
                if (maxOccurs != null) {
                    BigInteger bigInteger = BigInteger.ZERO;
                    if (maxOccurs.equals(bigInteger)) {
                        maxOccurs2 = bigInteger;
                    } else if (maxOccurs2 == null && !maxOccurs2.equals(BigInteger.ZERO)) {
                        maxOccurs2 = maxOccurs == null ? null : maxOccurs2.multiply(maxOccurs);
                    }
                } else if (maxOccurs2 == null) {
                }
                SchemaPropertyImpl schemaPropertyImpl2 = (SchemaPropertyImpl) schemaProperty2;
                schemaPropertyImpl2.setMinOccurs(bigIntegerMultiply);
                schemaPropertyImpl2.setMaxOccurs(maxOccurs2);
            }
        }
        return linkedHashMap;
    }

    public static Map<QName, SchemaProperty> buildElementPropertyModel(SchemaLocalElement schemaLocalElement, SchemaType schemaType) {
        SchemaProperty schemaPropertyBuildUseProperty = buildUseProperty(schemaLocalElement, schemaType);
        return Collections.singletonMap(schemaPropertyBuildUseProperty.getName(), schemaPropertyBuildUseProperty);
    }

    /* JADX WARN: Code duplicated, block: B:116:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:122:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:129:0x01df  */
    /* JADX WARN: Code duplicated, block: B:133:0x01ea  */
    public static void buildStateMachine(SchemaParticle schemaParticle) {
        boolean z6;
        boolean zAfterMapSubsumedByStartMap;
        BigInteger maxOccurs;
        boolean z7;
        boolean z8;
        if (schemaParticle == null) {
            return;
        }
        SchemaParticleImpl schemaParticleImpl = (SchemaParticleImpl) schemaParticle;
        if (schemaParticleImpl.hasTransitionNotes()) {
            return;
        }
        QNameSetBuilder qNameSetBuilder = new QNameSetBuilder();
        QNameSetBuilder qNameSetBuilder2 = new QNameSetBuilder();
        boolean z9 = schemaParticleImpl.getMinOccurs().signum() == 0;
        int particleType = schemaParticleImpl.getParticleType();
        if (particleType == 1) {
            SchemaParticle[] schemaParticleArrEnsureStateMachine = ensureStateMachine(schemaParticleImpl.getParticleChildren());
            int length = schemaParticleArrEnsureStateMachine.length;
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    z6 = true;
                    break;
                } else {
                    if (!schemaParticleArrEnsureStateMachine[i5].isSkippable()) {
                        z6 = false;
                        break;
                    }
                    i5++;
                }
            }
            int length2 = schemaParticleArrEnsureStateMachine.length;
            int i6 = 0;
            while (true) {
                if (i6 >= length2) {
                    zAfterMapSubsumedByStartMap = true;
                    break;
                } else {
                    if (!((SchemaParticleImpl) schemaParticleArrEnsureStateMachine[i6]).isDeterministic()) {
                        zAfterMapSubsumedByStartMap = false;
                        break;
                    }
                    i6++;
                }
            }
            for (SchemaParticle schemaParticle2 : schemaParticleArrEnsureStateMachine) {
                if (zAfterMapSubsumedByStartMap && !qNameSetBuilder.isDisjoint(schemaParticle2.acceptedStartNames())) {
                    zAfterMapSubsumedByStartMap = false;
                }
                qNameSetBuilder.addAll(schemaParticle2.acceptedStartNames());
                qNameSetBuilder2.addAll(((SchemaParticleImpl) schemaParticle2).getExcludeNextSet());
            }
            if (z6) {
                qNameSetBuilder2.addAll(qNameSetBuilder);
            }
        } else {
            if (particleType != 2) {
                if (particleType != 3) {
                    if (particleType != 4) {
                        if (particleType != 5) {
                            throw new IllegalStateException("Unrecognized schema particle");
                        }
                        qNameSetBuilder.addAll(schemaParticleImpl.getWildcardSet());
                    } else if (schemaParticleImpl.hasTransitionRules()) {
                        qNameSetBuilder.addAll(schemaParticleImpl.acceptedStartNames());
                    } else {
                        qNameSetBuilder.add(schemaParticleImpl.getName());
                    }
                    zAfterMapSubsumedByStartMap = true;
                } else {
                    SchemaParticle[] schemaParticleArrEnsureStateMachine2 = ensureStateMachine(schemaParticleImpl.getParticleChildren());
                    z6 = true;
                    for (int i7 = 0; z6 && i7 < schemaParticleArrEnsureStateMachine2.length; i7++) {
                        if (!schemaParticleArrEnsureStateMachine2[i7].isSkippable()) {
                            z6 = false;
                        }
                    }
                    int length3 = schemaParticleArrEnsureStateMachine2.length;
                    int i8 = 0;
                    while (true) {
                        if (i8 >= length3) {
                            zAfterMapSubsumedByStartMap = true;
                            break;
                        } else {
                            if (!((SchemaParticleImpl) schemaParticleArrEnsureStateMachine2[i8]).isDeterministic()) {
                                zAfterMapSubsumedByStartMap = false;
                                break;
                            }
                            i8++;
                        }
                    }
                    for (int i9 = 1; i9 < schemaParticleArrEnsureStateMachine2.length; i9++) {
                        qNameSetBuilder2.addAll(((SchemaParticleImpl) schemaParticleArrEnsureStateMachine2[i9 - 1]).getExcludeNextSet());
                        if (zAfterMapSubsumedByStartMap && !qNameSetBuilder2.isDisjoint(schemaParticleArrEnsureStateMachine2[i9].acceptedStartNames())) {
                            zAfterMapSubsumedByStartMap = false;
                        }
                        if (schemaParticleArrEnsureStateMachine2[i9].isSkippable()) {
                            qNameSetBuilder2.addAll(schemaParticleArrEnsureStateMachine2[i9].acceptedStartNames());
                        } else {
                            qNameSetBuilder2.clear();
                        }
                    }
                    for (SchemaParticle schemaParticle3 : schemaParticleArrEnsureStateMachine2) {
                        qNameSetBuilder.addAll(schemaParticle3.acceptedStartNames());
                        if (!schemaParticle3.isSkippable()) {
                            break;
                        }
                    }
                }
                BigInteger minOccurs = schemaParticleImpl.getMinOccurs();
                maxOccurs = schemaParticleImpl.getMaxOccurs();
                if (maxOccurs != null || maxOccurs.compareTo(BigInteger.ONE) > 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (maxOccurs != null || minOccurs.compareTo(maxOccurs) < 0) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (z7 && zAfterMapSubsumedByStartMap && !qNameSetBuilder2.isDisjoint(qNameSetBuilder)) {
                    QNameSet qNameSetIntersect = qNameSetBuilder2.intersect(qNameSetBuilder);
                    HashMap map = new HashMap();
                    particlesMatchingStart(schemaParticleImpl, qNameSetIntersect, map, new QNameSetBuilder());
                    HashMap map2 = new HashMap();
                    particlesMatchingAfter(schemaParticleImpl, qNameSetIntersect, map2, new QNameSetBuilder(), true);
                    zAfterMapSubsumedByStartMap = afterMapSubsumedByStartMap(map, map2);
                }
                if (z8) {
                    qNameSetBuilder2.addAll(qNameSetBuilder);
                }
                schemaParticleImpl.setTransitionRules(qNameSetBuilder.toQNameSet(), !z9 || minOccurs.signum() == 0);
                schemaParticleImpl.setTransitionNotes(qNameSetBuilder2.toQNameSet(), zAfterMapSubsumedByStartMap);
            }
            SchemaParticle[] schemaParticleArrEnsureStateMachine3 = ensureStateMachine(schemaParticleImpl.getParticleChildren());
            int length4 = schemaParticleArrEnsureStateMachine3.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length4) {
                    z6 = false;
                    break;
                } else {
                    if (schemaParticleArrEnsureStateMachine3[i10].isSkippable()) {
                        z6 = true;
                        break;
                    }
                    i10++;
                }
            }
            int length5 = schemaParticleArrEnsureStateMachine3.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length5) {
                    zAfterMapSubsumedByStartMap = true;
                    break;
                } else {
                    if (!((SchemaParticleImpl) schemaParticleArrEnsureStateMachine3[i11]).isDeterministic()) {
                        zAfterMapSubsumedByStartMap = false;
                        break;
                    }
                    i11++;
                }
            }
            for (SchemaParticle schemaParticle4 : schemaParticleArrEnsureStateMachine3) {
                if (zAfterMapSubsumedByStartMap && !qNameSetBuilder.isDisjoint(schemaParticle4.acceptedStartNames())) {
                    zAfterMapSubsumedByStartMap = false;
                }
                qNameSetBuilder.addAll(schemaParticle4.acceptedStartNames());
                qNameSetBuilder2.addAll(((SchemaParticleImpl) schemaParticle4).getExcludeNextSet());
            }
        }
        z9 = z6;
        BigInteger minOccurs2 = schemaParticleImpl.getMinOccurs();
        maxOccurs = schemaParticleImpl.getMaxOccurs();
        if (maxOccurs != null) {
            z7 = true;
        } else {
            z7 = true;
        }
        if (maxOccurs != null) {
            z8 = true;
        } else {
            z8 = true;
        }
        if (z7) {
            QNameSet qNameSetIntersect2 = qNameSetBuilder2.intersect(qNameSetBuilder);
            HashMap map3 = new HashMap();
            particlesMatchingStart(schemaParticleImpl, qNameSetIntersect2, map3, new QNameSetBuilder());
            HashMap map4 = new HashMap();
            particlesMatchingAfter(schemaParticleImpl, qNameSetIntersect2, map4, new QNameSetBuilder(), true);
            zAfterMapSubsumedByStartMap = afterMapSubsumedByStartMap(map3, map4);
        }
        if (z8) {
            qNameSetBuilder2.addAll(qNameSetBuilder);
        }
        schemaParticleImpl.setTransitionRules(qNameSetBuilder.toQNameSet(), !z9 || minOccurs2.signum() == 0);
        schemaParticleImpl.setTransitionNotes(qNameSetBuilder2.toQNameSet(), zAfterMapSubsumedByStartMap);
    }

    public static SchemaProperty buildUseProperty(SchemaField schemaField, SchemaType schemaType) {
        SchemaPropertyImpl schemaPropertyImpl = new SchemaPropertyImpl();
        schemaPropertyImpl.setName(schemaField.getName());
        schemaPropertyImpl.setContainerTypeRef(schemaType.getRef());
        schemaPropertyImpl.setTypeRef(schemaField.getType().getRef());
        schemaPropertyImpl.setAttribute(schemaField.isAttribute());
        schemaPropertyImpl.setDefault(schemaField.isDefault() ? 2 : 0);
        schemaPropertyImpl.setFixed(schemaField.isFixed() ? 2 : 0);
        schemaPropertyImpl.setNillable(schemaField.isNillable() ? 2 : 0);
        schemaPropertyImpl.setDefaultText(schemaField.getDefaultText());
        schemaPropertyImpl.setMinOccurs(schemaField.getMinOccurs());
        schemaPropertyImpl.setMaxOccurs(schemaField.getMaxOccurs());
        if (schemaField instanceof SchemaParticle) {
            schemaPropertyImpl.setDocumentation(((SchemaParticle) schemaField).getDocumentation());
        }
        if (schemaField instanceof SchemaLocalElementImpl) {
            schemaPropertyImpl.setAcceptedNames(((SchemaLocalElementImpl) schemaField).acceptedStartNames());
        }
        return schemaPropertyImpl;
    }

    public static SchemaParticle[] ensureStateMachine(SchemaParticle[] schemaParticleArr) {
        for (SchemaParticle schemaParticle : schemaParticleArr) {
            buildStateMachine(schemaParticle);
        }
        return schemaParticleArr;
    }

    public static SchemaParticle extendContentModel(SchemaParticle schemaParticle, SchemaParticle schemaParticle2, XmlObject xmlObject) {
        if (schemaParticle2 == null) {
            return schemaParticle;
        }
        if (schemaParticle == null) {
            return schemaParticle2;
        }
        SchemaParticleImpl schemaParticleImpl = new SchemaParticleImpl();
        schemaParticleImpl.setParticleType(3);
        ArrayList arrayList = new ArrayList();
        addMinusPointlessParticles(arrayList, schemaParticle, 3);
        addMinusPointlessParticles(arrayList, schemaParticle2, 3);
        BigInteger bigInteger = BigInteger.ONE;
        schemaParticleImpl.setMinOccurs(bigInteger);
        schemaParticleImpl.setMaxOccurs(bigInteger);
        schemaParticleImpl.setParticleChildren((SchemaParticle[]) arrayList.toArray(new SchemaParticle[0]));
        return filterPointlessParticlesAndVerifyAllParticles(schemaParticleImpl, xmlObject);
    }

    public static Map<QName, SchemaType> extractElementModel(SchemaType schemaType) {
        return schemaType == null ? new HashMap() : (Map) Stream.of((Object[]) schemaType.getProperties()).filter(new b(2)).collect(Collectors.toMap(new l(29), new m(0)));
    }

    public static BigInteger extractMaxOccurs(AllNNI allNNI) {
        if (allNNI == null) {
            return BigInteger.ONE;
        }
        if (allNNI.instanceType().getPrimitiveType().getBuiltinTypeCode() == 11) {
            return ((XmlInteger) allNNI).getBigIntegerValue();
        }
        return null;
    }

    public static BigInteger extractMinOccurs(XmlNonNegativeInteger xmlNonNegativeInteger) {
        if (xmlNonNegativeInteger == null) {
            return BigInteger.ONE;
        }
        BigInteger bigIntegerValue = xmlNonNegativeInteger.getBigIntegerValue();
        return bigIntegerValue == null ? BigInteger.ONE : bigIntegerValue;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0053  */
    /* JADX WARN: Code duplicated, block: B:32:0x005a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:33:0x005b  */
    /* JADX WARN: Code duplicated, block: B:41:0x0072  */
    /* JADX WARN: Code duplicated, block: B:42:0x0074  */
    /* JADX WARN: Code duplicated, block: B:44:0x0077  */
    /* JADX WARN: Code duplicated, block: B:51:0x0098  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:54:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:55:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:67:0x00cf A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    public static SchemaParticle filterPointlessParticlesAndVerifyAllParticles(SchemaParticle schemaParticle, XmlObject xmlObject) {
        boolean z6;
        SchemaParticle particleChild;
        if (schemaParticle.getMaxOccurs() != null && schemaParticle.getMaxOccurs().signum() == 0) {
            return null;
        }
        int particleType = schemaParticle.getParticleType();
        if (particleType == 1) {
            if (schemaParticle.getParticleChildren().length == 0) {
                return null;
            }
            if (schemaParticle.isSingleton() && schemaParticle.countOfParticleChild() == 1) {
                return schemaParticle.getParticleChild(0);
            }
            if (schemaParticle.getParticleType() == 1) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (z6 && (schemaParticle.getMaxOccurs() == null || schemaParticle.getMaxOccurs().compareTo(BigInteger.ONE) > 0)) {
                StscState.get().error(XmlErrorCodes.ALL_GROUP_LIMITED$IN_MIN_MAX_1_PARTICLE, (Object[]) null, xmlObject);
            }
            for (int i5 = 0; i5 < schemaParticle.countOfParticleChild(); i5++) {
                particleChild = schemaParticle.getParticleChild(i5);
                if (particleChild.getParticleType() == 1) {
                    StscState.get().error(XmlErrorCodes.ALL_GROUP_LIMITED$IN_COMPLEX_TYPE_DEF_PARTICLE, (Object[]) null, xmlObject);
                } else if (!z6 && (particleChild.getParticleType() != 4 || particleChild.getMaxOccurs() == null || particleChild.getMaxOccurs().compareTo(BigInteger.ONE) > 0)) {
                    StscState.get().error(XmlErrorCodes.ALL_GROUP_LIMITED$CHILD_PARTICLES_MAX_LTE_1, (Object[]) null, xmlObject);
                }
            }
        } else if (particleType == 2) {
            if (schemaParticle.getParticleChildren().length == 0 && schemaParticle.getMinOccurs().compareTo(BigInteger.ZERO) == 0) {
                return null;
            }
            if (schemaParticle.isSingleton() && schemaParticle.countOfParticleChild() == 1) {
                return schemaParticle.getParticleChild(0);
            }
            if (schemaParticle.getParticleType() == 1) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (z6) {
                StscState.get().error(XmlErrorCodes.ALL_GROUP_LIMITED$IN_MIN_MAX_1_PARTICLE, (Object[]) null, xmlObject);
            }
            while (i5 < schemaParticle.countOfParticleChild()) {
                particleChild = schemaParticle.getParticleChild(i5);
                if (particleChild.getParticleType() == 1) {
                    StscState.get().error(XmlErrorCodes.ALL_GROUP_LIMITED$IN_COMPLEX_TYPE_DEF_PARTICLE, (Object[]) null, xmlObject);
                } else if (!z6) {
                }
            }
        } else if (particleType == 3) {
            if (schemaParticle.getParticleChildren().length == 0) {
                return null;
            }
            if (schemaParticle.isSingleton()) {
                return schemaParticle.getParticleChild(0);
            }
            if (schemaParticle.getParticleType() == 1) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (z6) {
                StscState.get().error(XmlErrorCodes.ALL_GROUP_LIMITED$IN_MIN_MAX_1_PARTICLE, (Object[]) null, xmlObject);
            }
            while (i5 < schemaParticle.countOfParticleChild()) {
                particleChild = schemaParticle.getParticleChild(i5);
                if (particleChild.getParticleType() == 1) {
                    StscState.get().error(XmlErrorCodes.ALL_GROUP_LIMITED$IN_COMPLEX_TYPE_DEF_PARTICLE, (Object[]) null, xmlObject);
                } else if (!z6) {
                }
            }
        } else if (particleType != 4 && particleType != 5) {
            throw new IllegalStateException();
        }
        return schemaParticle;
    }

    public static Group getContentModel(final ComplexType complexType) {
        complexType.getClass();
        final int i5 = 0;
        final int i6 = 1;
        final int i7 = 2;
        final int i8 = 3;
        return getContentModel((Supplier<? extends Group>[]) new Supplier[]{new Supplier() { // from class: org.apache.xmlbeans.impl.schema.j
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return complexType.getAll();
                    case 1:
                        return complexType.getSequence();
                    case 2:
                        return complexType.getChoice();
                    default:
                        return complexType.getGroup();
                }
            }
        }, new Supplier() { // from class: org.apache.xmlbeans.impl.schema.j
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return complexType.getAll();
                    case 1:
                        return complexType.getSequence();
                    case 2:
                        return complexType.getChoice();
                    default:
                        return complexType.getGroup();
                }
            }
        }, new Supplier() { // from class: org.apache.xmlbeans.impl.schema.j
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return complexType.getAll();
                    case 1:
                        return complexType.getSequence();
                    case 2:
                        return complexType.getChoice();
                    default:
                        return complexType.getGroup();
                }
            }
        }, new Supplier() { // from class: org.apache.xmlbeans.impl.schema.j
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return complexType.getAll();
                    case 1:
                        return complexType.getSequence();
                    case 2:
                        return complexType.getChoice();
                    default:
                        return complexType.getGroup();
                }
            }
        }});
    }

    public static SchemaDocument.Schema getSchema(XmlObject xmlObject) {
        XmlCursor xmlCursorNewCursor = xmlObject.newCursor();
        while (xmlCursorNewCursor.toParent()) {
            try {
                XmlObject object = xmlCursorNewCursor.getObject();
                if (object.schemaType().equals(SchemaDocument.Schema.type)) {
                    SchemaDocument.Schema schema = (SchemaDocument.Schema) object;
                    xmlCursorNewCursor.close();
                    return schema;
                }
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
        xmlCursorNewCursor.close();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SchemaProperty lambda$buildAttributePropertyModelByQName$3(SchemaType schemaType, SchemaLocalAttribute schemaLocalAttribute) {
        return buildUseProperty(schemaLocalAttribute, schemaType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$extractElementModel$1(SchemaProperty schemaProperty) {
        return !schemaProperty.isAttribute();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SchemaType.Ref[] lambda$makeRefArray$0(int i5) {
        return new SchemaType.Ref[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer lambda$static$5(CodeForNameEntry codeForNameEntry) {
        return Integer.valueOf(codeForNameEntry.code);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer lambda$static$7(CodeForNameEntry codeForNameEntry) {
        return Integer.valueOf(codeForNameEntry.code);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$throwingMerger$2(Object obj, Object obj2) {
        throw new IllegalStateException("Duplicate key " + obj.toString());
    }

    private static SchemaType.Ref[] makeRefArray(Collection<SchemaType> collection) {
        return (SchemaType.Ref[]) collection.stream().map(new m(1)).toArray(new f(11));
    }

    /* JADX WARN: Code duplicated, block: B:8:0x001b A[PHI: r5
  0x001b: PHI (r5v11 java.math.BigInteger) = (r5v2 java.math.BigInteger), (r5v13 java.math.BigInteger) binds: [B:14:0x0035, B:7:0x0019] A[DONT_GENERATE, DONT_INLINE]] */
    public static void mergeProperties(SchemaPropertyImpl schemaPropertyImpl, SchemaProperty schemaProperty, boolean z6) {
        BigInteger bigIntegerMin;
        BigInteger bigIntegerMax;
        BigInteger minOccurs = schemaPropertyImpl.getMinOccurs();
        BigInteger maxOccurs = schemaPropertyImpl.getMaxOccurs();
        if (z6) {
            bigIntegerMin = minOccurs.add(schemaProperty.getMinOccurs());
            if (maxOccurs != null) {
                if (schemaProperty.getMaxOccurs() == null) {
                    maxOccurs = null;
                } else {
                    bigIntegerMax = maxOccurs.add(schemaProperty.getMaxOccurs());
                    maxOccurs = bigIntegerMax;
                }
            }
        } else {
            bigIntegerMin = minOccurs.min(schemaProperty.getMinOccurs());
            if (maxOccurs != null) {
                if (schemaProperty.getMaxOccurs() == null) {
                    maxOccurs = null;
                } else {
                    bigIntegerMax = maxOccurs.max(schemaProperty.getMaxOccurs());
                    maxOccurs = bigIntegerMax;
                }
            }
        }
        schemaPropertyImpl.setMinOccurs(bigIntegerMin);
        schemaPropertyImpl.setMaxOccurs(maxOccurs);
        if (schemaProperty.hasNillable() != schemaPropertyImpl.hasNillable()) {
            schemaPropertyImpl.setNillable(1);
        }
        if (schemaProperty.hasDefault() != schemaPropertyImpl.hasDefault()) {
            schemaPropertyImpl.setDefault(1);
        }
        if (schemaProperty.hasFixed() != schemaPropertyImpl.hasFixed()) {
            schemaPropertyImpl.setFixed(1);
        }
        if (schemaPropertyImpl.getDefaultText() != null) {
            if (schemaProperty.getDefaultText() == null || !schemaPropertyImpl.getDefaultText().equals(schemaProperty.getDefaultText())) {
                schemaPropertyImpl.setDefaultText(null);
            }
        }
    }

    private static void particlesMatchingAfter(SchemaParticle schemaParticle, QNameSetSpecification qNameSetSpecification, Map<SchemaParticle, QNameSet> map, QNameSetBuilder qNameSetBuilder, boolean z6) {
        int particleType = schemaParticle.getParticleType();
        if (particleType == 1 || particleType == 2) {
            for (SchemaParticle schemaParticle2 : schemaParticle.getParticleChildren()) {
                particlesMatchingAfter(schemaParticle2, qNameSetSpecification, map, qNameSetBuilder, false);
            }
        } else if (particleType == 3) {
            SchemaParticle[] particleChildren = schemaParticle.getParticleChildren();
            if (particleChildren.length != 0) {
                if (particleChildren[particleChildren.length - 1].isSkippable()) {
                    QNameSetBuilder qNameSetBuilder2 = new QNameSetBuilder(qNameSetSpecification);
                    QNameSetBuilder qNameSetBuilder3 = new QNameSetBuilder();
                    for (int length = particleChildren.length - 1; length >= 0; length--) {
                        particlesMatchingAfter(particleChildren[length], qNameSetBuilder2, map, qNameSetBuilder3, false);
                        qNameSetBuilder.addAll(qNameSetBuilder3);
                        if (!particleChildren[length].isSkippable()) {
                            break;
                        }
                        qNameSetBuilder2.removeAll(qNameSetBuilder3);
                        if (qNameSetBuilder2.isEmpty()) {
                            break;
                        }
                        qNameSetBuilder3.clear();
                    }
                } else {
                    particlesMatchingAfter(particleChildren[0], qNameSetSpecification, map, qNameSetBuilder, false);
                }
            }
        }
        if (z6) {
            return;
        }
        BigInteger minOccurs = schemaParticle.getMinOccurs();
        BigInteger maxOccurs = schemaParticle.getMaxOccurs();
        if (maxOccurs == null || minOccurs.compareTo(maxOccurs) < 0) {
            particlesMatchingStart(schemaParticle, qNameSetSpecification, map, qNameSetBuilder);
        }
    }

    private static void particlesMatchingStart(SchemaParticle schemaParticle, QNameSetSpecification qNameSetSpecification, Map<SchemaParticle, QNameSet> map, QNameSetBuilder qNameSetBuilder) {
        int particleType = schemaParticle.getParticleType();
        int i5 = 0;
        if (particleType == 1 || particleType == 2) {
            SchemaParticle[] particleChildren = schemaParticle.getParticleChildren();
            int length = particleChildren.length;
            while (i5 < length) {
                particlesMatchingStart(particleChildren[i5], qNameSetSpecification, map, qNameSetBuilder);
                i5++;
            }
            return;
        }
        if (particleType != 3) {
            if (particleType == 4) {
                if (qNameSetSpecification.contains(schemaParticle.getName())) {
                    map.put(schemaParticle, null);
                    qNameSetBuilder.add(schemaParticle.getName());
                    return;
                }
                return;
            }
            if (particleType == 5 && !qNameSetSpecification.isDisjoint(schemaParticle.getWildcardSet())) {
                map.put(schemaParticle, schemaParticle.getWildcardSet().intersect(qNameSetSpecification));
                qNameSetBuilder.addAll(schemaParticle.getWildcardSet());
                return;
            }
            return;
        }
        SchemaParticle[] particleChildren2 = schemaParticle.getParticleChildren();
        if (particleChildren2.length == 0) {
            return;
        }
        if (!particleChildren2[0].isSkippable()) {
            particlesMatchingStart(particleChildren2[0], qNameSetSpecification, map, qNameSetBuilder);
            return;
        }
        QNameSetBuilder qNameSetBuilder2 = new QNameSetBuilder(qNameSetSpecification);
        QNameSetBuilder qNameSetBuilder3 = new QNameSetBuilder();
        int length2 = particleChildren2.length;
        while (i5 < length2) {
            SchemaParticle schemaParticle2 = particleChildren2[i5];
            particlesMatchingStart(schemaParticle2, qNameSetBuilder2, map, qNameSetBuilder3);
            qNameSetBuilder.addAll(qNameSetBuilder3);
            if (!schemaParticle2.isSkippable()) {
                return;
            }
            qNameSetBuilder2.removeAll(qNameSetBuilder3);
            if (qNameSetBuilder2.isEmpty()) {
                return;
            }
            qNameSetBuilder3.clear();
            i5++;
        }
    }

    public static void resolveBasicComplexType(SchemaTypeImpl schemaTypeImpl) {
        int i5;
        ArrayList arrayList = new ArrayList();
        ComplexType complexType = (ComplexType) schemaTypeImpl.getParseObject();
        String targetNamespace = schemaTypeImpl.getTargetNamespace();
        boolean z6 = false;
        boolean z7 = schemaTypeImpl.getChameleonNamespace() != null;
        Group contentModel = getContentModel(complexType);
        if (schemaTypeImpl.isRedefinition()) {
            StscState.get().error(XmlErrorCodes.SCHEMA_REDEFINE$EXTEND_OR_RESTRICT, new Object[]{"<complexType>"}, complexType);
        }
        boolean z8 = z7;
        SchemaParticle schemaParticleTranslateContentModel = translateContentModel(schemaTypeImpl, contentModel, targetNamespace, z8, schemaTypeImpl.getElemFormDefault(), schemaTypeImpl.getAttFormDefault(), translateParticleCode(contentModel), arrayList, new LinkedHashMap(), false, null);
        if (schemaParticleTranslateContentModel != null && schemaParticleTranslateContentModel.getParticleType() == 1) {
            z6 = true;
        }
        SchemaAttributeModelImpl schemaAttributeModelImpl = new SchemaAttributeModelImpl();
        translateAttributeModel(complexType, targetNamespace, z8, schemaTypeImpl.getAttFormDefault(), arrayList, schemaTypeImpl, null, schemaAttributeModelImpl, null, true, null);
        WildcardResult wildcardResultSummarizeEltWildcards = summarizeEltWildcards(schemaParticleTranslateContentModel);
        WildcardResult wildcardResultSummarizeAttrWildcards = summarizeAttrWildcards(schemaAttributeModelImpl);
        if (schemaParticleTranslateContentModel != null) {
            buildStateMachine(schemaParticleTranslateContentModel);
            if (!StscState.get().noUpa() && !((SchemaParticleImpl) schemaParticleTranslateContentModel).isDeterministic()) {
                StscState.get().error(XmlErrorCodes.UNIQUE_PARTICLE_ATTRIBUTION, (Object[]) null, contentModel);
            }
        }
        Map<QName, SchemaProperty> mapBuildContentPropertyModelByQName = buildContentPropertyModelByQName(schemaParticleTranslateContentModel, schemaTypeImpl);
        Map<QName, SchemaProperty> mapBuildAttributePropertyModelByQName = buildAttributePropertyModelByQName(schemaAttributeModelImpl, schemaTypeImpl);
        if (complexType.getMixed()) {
            i5 = 4;
        } else {
            i5 = schemaParticleTranslateContentModel == null ? 1 : 3;
        }
        SchemaTypeImpl schemaTypeImpl2 = BuiltinSchemaTypeSystem.ST_ANY_TYPE;
        schemaTypeImpl.setBaseTypeRef(schemaTypeImpl2.getRef());
        schemaTypeImpl.setBaseDepth(schemaTypeImpl2.getBaseDepth() + 1);
        schemaTypeImpl.setDerivationType(2);
        schemaTypeImpl.setComplexTypeVariety(i5);
        schemaTypeImpl.setContentModel(schemaParticleTranslateContentModel, schemaAttributeModelImpl, mapBuildContentPropertyModelByQName, mapBuildAttributePropertyModelByQName, z6);
        schemaTypeImpl.setAnonymousTypeRefs(makeRefArray(arrayList));
        schemaTypeImpl.setWildcardSummary(wildcardResultSummarizeEltWildcards.typedWildcards, wildcardResultSummarizeEltWildcards.hasWildcards, wildcardResultSummarizeAttrWildcards.typedWildcards, wildcardResultSummarizeAttrWildcards.hasWildcards);
    }

    public static void resolveCcExtension(SchemaTypeImpl schemaTypeImpl, ExtensionType extensionType, boolean z6) {
        SchemaTypeImpl schemaTypeImplFindGlobalType;
        SchemaTypeImpl schemaTypeImpl2;
        boolean z7;
        int i5;
        StscState stscState = StscState.get();
        String targetNamespace = schemaTypeImpl.getTargetNamespace();
        boolean z8 = schemaTypeImpl.getChameleonNamespace() != null;
        if (extensionType.getBase() == null) {
            stscState.error("A complexContent must define a base type", 28, extensionType);
            schemaTypeImplFindGlobalType = null;
        } else {
            if (schemaTypeImpl.isRedefinition()) {
                schemaTypeImplFindGlobalType = stscState.findRedefinedGlobalType(extensionType.getBase(), schemaTypeImpl.getChameleonNamespace(), schemaTypeImpl);
                if (schemaTypeImplFindGlobalType != null && !schemaTypeImplFindGlobalType.getName().equals(schemaTypeImpl.getName())) {
                    stscState.error(XmlErrorCodes.SCHEMA_REDEFINE$SAME_TYPE, new Object[]{"<complexType>", QNameHelper.pretty(schemaTypeImplFindGlobalType.getName()), QNameHelper.pretty(schemaTypeImpl.getName())}, extensionType);
                }
            } else {
                schemaTypeImplFindGlobalType = stscState.findGlobalType(extensionType.getBase(), schemaTypeImpl.getChameleonNamespace(), targetNamespace);
            }
            if (schemaTypeImplFindGlobalType == null) {
                stscState.notFoundError(extensionType.getBase(), 0, extensionType.xgetBase(), true);
            }
        }
        if (schemaTypeImplFindGlobalType != null && !StscResolver.resolveType(schemaTypeImplFindGlobalType)) {
            schemaTypeImplFindGlobalType = null;
        }
        if (schemaTypeImplFindGlobalType != null && schemaTypeImplFindGlobalType.isSimpleType()) {
            stscState.recover(XmlErrorCodes.SCHEMA_COMPLEX_TYPE$COMPLEX_CONTENT, new Object[]{QNameHelper.pretty(schemaTypeImplFindGlobalType.getName())}, extensionType.xgetBase());
            schemaTypeImplFindGlobalType = null;
        }
        if (schemaTypeImplFindGlobalType != null && schemaTypeImplFindGlobalType.finalExtension()) {
            stscState.error(XmlErrorCodes.COMPLEX_TYPE_EXTENSION$FINAL, new Object[]{QNameHelper.pretty(schemaTypeImplFindGlobalType.getName()), QNameHelper.pretty(schemaTypeImpl.getName())}, extensionType.xgetBase());
        }
        SchemaParticle contentModel = schemaTypeImplFindGlobalType == null ? null : schemaTypeImplFindGlobalType.getContentModel();
        ArrayList arrayList = new ArrayList();
        Map<QName, SchemaType> mapExtractElementModel = extractElementModel(schemaTypeImplFindGlobalType);
        Group contentModel2 = getContentModel(extensionType);
        if (schemaTypeImplFindGlobalType == null || schemaTypeImplFindGlobalType.getContentType() != 2) {
            schemaTypeImpl2 = schemaTypeImplFindGlobalType;
        } else if (contentModel2 == null) {
            resolveScExtensionPart2(schemaTypeImpl, schemaTypeImplFindGlobalType, extensionType, targetNamespace, z8);
            return;
        } else {
            stscState.recover(XmlErrorCodes.COMPLEX_TYPE_EXTENSION$EXTENDING_SIMPLE_CONTENT, new Object[]{QNameHelper.pretty(schemaTypeImplFindGlobalType.getName())}, extensionType.xgetBase());
            schemaTypeImpl2 = null;
        }
        SchemaParticle schemaParticle = contentModel;
        boolean z9 = z8;
        SchemaParticle schemaParticleTranslateContentModel = translateContentModel(schemaTypeImpl, contentModel2, targetNamespace, z9, schemaTypeImpl.getElemFormDefault(), schemaTypeImpl.getAttFormDefault(), translateParticleCode(contentModel2), arrayList, mapExtractElementModel, false, null);
        if (schemaParticleTranslateContentModel != null || z6) {
            z7 = z6;
        } else {
            z7 = schemaTypeImpl2 != null && schemaTypeImpl2.getContentType() == 4;
        }
        if (schemaTypeImpl2 != null && schemaTypeImpl2.getContentType() != 1) {
            if ((schemaTypeImpl2.getContentType() == 4) != z7) {
                stscState.error(XmlErrorCodes.COMPLEX_TYPE_EXTENSION$BOTH_ELEMEMENT_OR_MIXED, (Object[]) null, extensionType.xgetBase());
            }
        }
        if (schemaTypeImpl2 != null && schemaTypeImpl2.hasAllContent() && schemaParticleTranslateContentModel != null) {
            stscState.error("Cannot extend a type with 'all' content model", 42, extensionType.xgetBase());
            schemaParticleTranslateContentModel = null;
        }
        SchemaParticle schemaParticleExtendContentModel = extendContentModel(schemaParticle, schemaParticleTranslateContentModel, extensionType);
        boolean z10 = schemaParticleExtendContentModel != null && schemaParticleExtendContentModel.getParticleType() == 1;
        SchemaAttributeModelImpl schemaAttributeModelImpl = schemaTypeImpl2 == null ? new SchemaAttributeModelImpl() : new SchemaAttributeModelImpl(schemaTypeImpl2.getAttributeModel());
        int i6 = 4;
        SchemaTypeImpl schemaTypeImpl3 = schemaTypeImpl2;
        boolean z11 = z7;
        translateAttributeModel(extensionType, targetNamespace, z9, schemaTypeImpl.getAttFormDefault(), arrayList, schemaTypeImpl, null, schemaAttributeModelImpl, schemaTypeImpl3, true, null);
        WildcardResult wildcardResultSummarizeEltWildcards = summarizeEltWildcards(schemaParticleExtendContentModel);
        WildcardResult wildcardResultSummarizeAttrWildcards = summarizeAttrWildcards(schemaAttributeModelImpl);
        if (schemaParticleExtendContentModel != null) {
            buildStateMachine(schemaParticleExtendContentModel);
            if (!StscState.get().noUpa() && !((SchemaParticleImpl) schemaParticleExtendContentModel).isDeterministic()) {
                StscState.get().error(XmlErrorCodes.UNIQUE_PARTICLE_ATTRIBUTION, (Object[]) null, contentModel2);
            }
        }
        Map<QName, SchemaProperty> mapBuildContentPropertyModelByQName = buildContentPropertyModelByQName(schemaParticleExtendContentModel, schemaTypeImpl);
        Map<QName, SchemaProperty> mapBuildAttributePropertyModelByQName = buildAttributePropertyModelByQName(schemaAttributeModelImpl, schemaTypeImpl);
        if (schemaParticleExtendContentModel == null && schemaTypeImpl3 != null && schemaTypeImpl3.getContentType() == 2) {
            schemaTypeImpl.setContentBasedOnTypeRef(schemaTypeImpl3.getContentBasedOnType().getRef());
            i5 = 2;
        } else {
            if (!z11) {
                i6 = schemaParticleExtendContentModel == null ? 1 : 3;
            }
            i5 = i6;
        }
        SchemaType schemaType = schemaTypeImpl3 == null ? XmlObject.type : schemaTypeImpl3;
        schemaTypeImpl.setBaseTypeRef(schemaType.getRef());
        schemaTypeImpl.setBaseDepth(((SchemaTypeImpl) schemaType).getBaseDepth() + 1);
        schemaTypeImpl.setDerivationType(2);
        schemaTypeImpl.setComplexTypeVariety(i5);
        schemaTypeImpl.setContentModel(schemaParticleExtendContentModel, schemaAttributeModelImpl, mapBuildContentPropertyModelByQName, mapBuildAttributePropertyModelByQName, z10);
        schemaTypeImpl.setAnonymousTypeRefs(makeRefArray(arrayList));
        schemaTypeImpl.setWildcardSummary(wildcardResultSummarizeEltWildcards.typedWildcards, wildcardResultSummarizeEltWildcards.hasWildcards, wildcardResultSummarizeAttrWildcards.typedWildcards, wildcardResultSummarizeAttrWildcards.hasWildcards);
    }

    public static void resolveCcRestriction(SchemaTypeImpl schemaTypeImpl, ComplexRestrictionType complexRestrictionType, boolean z6) {
        SchemaTypeImpl schemaTypeImplFindGlobalType;
        int i5;
        StscState stscState = StscState.get();
        String targetNamespace = schemaTypeImpl.getTargetNamespace();
        boolean z7 = false;
        boolean z8 = schemaTypeImpl.getChameleonNamespace() != null;
        if (complexRestrictionType.getBase() == null) {
            stscState.error("A complexContent must define a base type", 28, complexRestrictionType);
            schemaTypeImplFindGlobalType = null;
        } else {
            if (schemaTypeImpl.isRedefinition()) {
                schemaTypeImplFindGlobalType = stscState.findRedefinedGlobalType(complexRestrictionType.getBase(), schemaTypeImpl.getChameleonNamespace(), schemaTypeImpl);
                if (schemaTypeImplFindGlobalType != null && !schemaTypeImplFindGlobalType.getName().equals(schemaTypeImpl.getName())) {
                    stscState.error(XmlErrorCodes.SCHEMA_REDEFINE$SAME_TYPE, new Object[]{"<complexType>", QNameHelper.pretty(schemaTypeImplFindGlobalType.getName()), QNameHelper.pretty(schemaTypeImpl.getName())}, complexRestrictionType);
                }
            } else {
                schemaTypeImplFindGlobalType = stscState.findGlobalType(complexRestrictionType.getBase(), schemaTypeImpl.getChameleonNamespace(), targetNamespace);
            }
            if (schemaTypeImplFindGlobalType == null) {
                stscState.notFoundError(complexRestrictionType.getBase(), 0, complexRestrictionType.xgetBase(), true);
            }
        }
        if (schemaTypeImplFindGlobalType == null) {
            schemaTypeImplFindGlobalType = BuiltinSchemaTypeSystem.ST_ANY_TYPE;
        }
        if (schemaTypeImplFindGlobalType != null && schemaTypeImplFindGlobalType.finalRestriction()) {
            stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$FINAL, new Object[]{QNameHelper.pretty(schemaTypeImplFindGlobalType.getName()), QNameHelper.pretty(schemaTypeImpl.getName())}, complexRestrictionType.xgetBase());
        }
        SchemaTypeImpl schemaTypeImpl2 = (schemaTypeImplFindGlobalType == null || StscResolver.resolveType(schemaTypeImplFindGlobalType)) ? schemaTypeImplFindGlobalType : null;
        ArrayList arrayList = new ArrayList();
        Group contentModel = getContentModel(complexRestrictionType);
        SchemaParticle schemaParticleTranslateContentModel = translateContentModel(schemaTypeImpl, contentModel, targetNamespace, z8, schemaTypeImpl.getElemFormDefault(), schemaTypeImpl.getAttFormDefault(), translateParticleCode(contentModel), arrayList, new LinkedHashMap(), false, null);
        boolean z9 = z8;
        if (schemaParticleTranslateContentModel != null && schemaParticleTranslateContentModel.getParticleType() == 1) {
            z7 = true;
        }
        SchemaTypeImpl schemaTypeImpl3 = schemaTypeImpl2;
        SchemaAttributeModelImpl schemaAttributeModelImpl = schemaTypeImpl2 == null ? new SchemaAttributeModelImpl() : new SchemaAttributeModelImpl(schemaTypeImpl2.getAttributeModel());
        translateAttributeModel(complexRestrictionType, targetNamespace, z9, schemaTypeImpl.getAttFormDefault(), arrayList, schemaTypeImpl, null, schemaAttributeModelImpl, schemaTypeImpl3, false, null);
        WildcardResult wildcardResultSummarizeEltWildcards = summarizeEltWildcards(schemaParticleTranslateContentModel);
        WildcardResult wildcardResultSummarizeAttrWildcards = summarizeAttrWildcards(schemaAttributeModelImpl);
        if (schemaParticleTranslateContentModel != null) {
            buildStateMachine(schemaParticleTranslateContentModel);
            if (!StscState.get().noUpa() && !((SchemaParticleImpl) schemaParticleTranslateContentModel).isDeterministic()) {
                StscState.get().error(XmlErrorCodes.UNIQUE_PARTICLE_ATTRIBUTION, (Object[]) null, contentModel);
            }
        }
        Map<QName, SchemaProperty> mapBuildContentPropertyModelByQName = buildContentPropertyModelByQName(schemaParticleTranslateContentModel, schemaTypeImpl);
        Map<QName, SchemaProperty> mapBuildAttributePropertyModelByQName = buildAttributePropertyModelByQName(schemaAttributeModelImpl, schemaTypeImpl);
        if (z6) {
            i5 = 4;
        } else {
            i5 = schemaParticleTranslateContentModel == null ? 1 : 3;
        }
        if (schemaTypeImpl3 != null) {
            schemaTypeImpl.setBaseTypeRef(schemaTypeImpl3.getRef());
            schemaTypeImpl.setBaseDepth(schemaTypeImpl3.getBaseDepth() + 1);
        }
        schemaTypeImpl.setDerivationType(1);
        schemaTypeImpl.setComplexTypeVariety(i5);
        schemaTypeImpl.setContentModel(schemaParticleTranslateContentModel, schemaAttributeModelImpl, mapBuildContentPropertyModelByQName, mapBuildAttributePropertyModelByQName, z7);
        schemaTypeImpl.setAnonymousTypeRefs(makeRefArray(arrayList));
        schemaTypeImpl.setWildcardSummary(wildcardResultSummarizeEltWildcards.typedWildcards, wildcardResultSummarizeEltWildcards.hasWildcards, wildcardResultSummarizeAttrWildcards.typedWildcards, wildcardResultSummarizeAttrWildcards.hasWildcards);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0065  */
    /* JADX WARN: Code duplicated, block: B:49:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:66:0x00d5  */
    public static void resolveComplexType(SchemaTypeImpl schemaTypeImpl) {
        Object finalDefault;
        boolean zContains;
        boolean z6;
        boolean z7;
        boolean zContains2;
        Object blockDefault;
        boolean z8;
        boolean zContains3;
        SimpleContentDocument.SimpleContent simpleContent;
        ComplexType complexType = (ComplexType) schemaTypeImpl.getParseObject();
        StscState stscState = StscState.get();
        SchemaDocument.Schema schema = getSchema(complexType);
        boolean z9 = complexType.isSetAbstract() && complexType.getAbstract();
        if (complexType.isSetFinal()) {
            finalDefault = complexType.getFinal();
        } else {
            finalDefault = (schema == null || !schema.isSetFinalDefault()) ? null : schema.getFinalDefault();
        }
        if (finalDefault == null) {
            zContains = false;
            zContains2 = zContains;
            z7 = zContains2;
            z6 = z7;
        } else if ((finalDefault instanceof String) && finalDefault.equals("#all")) {
            zContains = true;
            zContains2 = zContains;
            z7 = zContains2;
            z6 = z7;
        } else if (finalDefault instanceof List) {
            List list = (List) finalDefault;
            zContains = list.contains("extension");
            zContains2 = list.contains("restriction");
            z7 = false;
            z6 = false;
            schemaTypeImpl = schemaTypeImpl;
        } else {
            zContains = false;
            zContains2 = zContains;
            z7 = zContains2;
            z6 = z7;
        }
        schemaTypeImpl.setAbstractFinal(z9, zContains, zContains2, z7, z6);
        if (complexType.isSetBlock()) {
            blockDefault = complexType.getBlock();
        } else {
            blockDefault = (schema == null || !schema.isSetBlockDefault()) ? null : schema.getBlockDefault();
        }
        if (blockDefault == null) {
            z8 = false;
            zContains3 = z8;
        } else if ((blockDefault instanceof String) && blockDefault.equals("#all")) {
            z8 = true;
            zContains3 = z8;
        } else if (blockDefault instanceof List) {
            List list2 = (List) blockDefault;
            zContains3 = list2.contains("extension");
            z8 = list2.contains("restriction");
        } else {
            z8 = false;
            zContains3 = z8;
        }
        schemaTypeImpl.setBlock(zContains3, z8);
        ComplexContentDocument.ComplexContent complexContent = complexType.getComplexContent();
        SimpleContentDocument.SimpleContent simpleContent2 = complexType.getSimpleContent();
        if ((complexContent != null ? 1 : 0) + (simpleContent2 != null ? 1 : 0) + (getContentModel(complexType) != null ? 1 : 0) > 1) {
            stscState.error("A complex type must define either a content model, or a simpleContent or complexContent derivation: more than one found.", 26, complexType);
            simpleContent = (complexContent == null || simpleContent2 == null) ? simpleContent2 : null;
        }
        if (complexContent != null) {
            if (complexContent.getExtension() != null && complexContent.getRestriction() != null) {
                stscState.error("Restriction conflicts with extension", 26, complexContent.getRestriction());
            }
            boolean mixed = complexContent.isSetMixed() ? complexContent.getMixed() : complexType.getMixed();
            if (complexContent.getExtension() != null) {
                resolveCcExtension(schemaTypeImpl, complexContent.getExtension(), mixed);
                return;
            } else if (complexContent.getRestriction() != null) {
                resolveCcRestriction(schemaTypeImpl, complexContent.getRestriction(), mixed);
                return;
            } else {
                stscState.error("Missing restriction or extension", 27, complexContent);
                resolveErrorType(schemaTypeImpl);
                return;
            }
        }
        if (simpleContent == null) {
            resolveBasicComplexType(schemaTypeImpl);
            return;
        }
        if (simpleContent.getExtension() != null && simpleContent.getRestriction() != null) {
            stscState.error("Restriction conflicts with extension", 26, simpleContent.getRestriction());
        }
        if (simpleContent.getExtension() != null) {
            resolveScExtension(schemaTypeImpl, simpleContent.getExtension());
        } else if (simpleContent.getRestriction() != null) {
            resolveScRestriction(schemaTypeImpl, simpleContent.getRestriction());
        } else {
            stscState.error("Missing restriction or extension", 27, simpleContent);
            resolveErrorType(schemaTypeImpl);
        }
    }

    public static void resolveErrorType(SchemaTypeImpl schemaTypeImpl) {
        throw new RuntimeException("This type of error recovery not yet implemented.");
    }

    public static void resolveScExtension(SchemaTypeImpl schemaTypeImpl, SimpleExtensionType simpleExtensionType) {
        SchemaTypeImpl schemaTypeImplFindGlobalType;
        SchemaTypeImpl schemaTypeImpl2;
        StscState stscState = StscState.get();
        String targetNamespace = schemaTypeImpl.getTargetNamespace();
        boolean z6 = schemaTypeImpl.getChameleonNamespace() != null;
        if (simpleExtensionType.getBase() == null) {
            stscState.error("A simpleContent extension must define a base type", 28, simpleExtensionType);
            schemaTypeImpl2 = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        } else {
            if (schemaTypeImpl.isRedefinition()) {
                schemaTypeImplFindGlobalType = stscState.findRedefinedGlobalType(simpleExtensionType.getBase(), schemaTypeImpl.getChameleonNamespace(), schemaTypeImpl);
                if (schemaTypeImplFindGlobalType != null && !schemaTypeImplFindGlobalType.getName().equals(schemaTypeImpl.getName())) {
                    stscState.error(XmlErrorCodes.SCHEMA_REDEFINE$SAME_TYPE, new Object[]{"<simpleType>", QNameHelper.pretty(schemaTypeImplFindGlobalType.getName()), QNameHelper.pretty(schemaTypeImpl.getName())}, simpleExtensionType);
                }
            } else {
                schemaTypeImplFindGlobalType = stscState.findGlobalType(simpleExtensionType.getBase(), schemaTypeImpl.getChameleonNamespace(), targetNamespace);
            }
            if (schemaTypeImplFindGlobalType == null) {
                stscState.notFoundError(simpleExtensionType.getBase(), 0, simpleExtensionType.xgetBase(), true);
                schemaTypeImpl2 = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
            } else {
                schemaTypeImpl2 = schemaTypeImplFindGlobalType;
            }
        }
        StscResolver.resolveType(schemaTypeImpl2);
        if (!schemaTypeImpl2.isSimpleType() && schemaTypeImpl2.getContentType() != 2) {
            stscState.error(XmlErrorCodes.SCHEMA_COMPLEX_TYPE$SIMPLE_CONTENT, new Object[]{QNameHelper.pretty(schemaTypeImpl2.getName())}, simpleExtensionType);
            schemaTypeImpl2 = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        }
        if (schemaTypeImpl2 != null && schemaTypeImpl2.finalExtension()) {
            stscState.error(XmlErrorCodes.COMPLEX_TYPE_EXTENSION$FINAL, new Object[]{QNameHelper.pretty(schemaTypeImpl2.getName()), QNameHelper.pretty(schemaTypeImpl.getName())}, simpleExtensionType.xgetBase());
        }
        resolveScExtensionPart2(schemaTypeImpl, schemaTypeImpl2, simpleExtensionType, targetNamespace, z6);
    }

    public static void resolveScExtensionPart2(SchemaTypeImpl schemaTypeImpl, SchemaType schemaType, ExtensionType extensionType, String str, boolean z6) {
        ArrayList arrayList = new ArrayList();
        SchemaAttributeModelImpl schemaAttributeModelImpl = new SchemaAttributeModelImpl(schemaType.getAttributeModel());
        translateAttributeModel(extensionType, str, z6, schemaTypeImpl.getAttFormDefault(), arrayList, schemaTypeImpl, null, schemaAttributeModelImpl, schemaType, true, null);
        WildcardResult wildcardResultSummarizeAttrWildcards = summarizeAttrWildcards(schemaAttributeModelImpl);
        Map<QName, SchemaProperty> mapBuildAttributePropertyModelByQName = buildAttributePropertyModelByQName(schemaAttributeModelImpl, schemaTypeImpl);
        schemaTypeImpl.setBaseTypeRef(schemaType.getRef());
        SchemaTypeImpl schemaTypeImpl2 = (SchemaTypeImpl) schemaType;
        schemaTypeImpl.setBaseDepth(schemaTypeImpl2.getBaseDepth() + 1);
        schemaTypeImpl.setContentBasedOnTypeRef(schemaType.getRef());
        schemaTypeImpl.setDerivationType(2);
        schemaTypeImpl.setAnonymousTypeRefs(makeRefArray(arrayList));
        schemaTypeImpl.setWildcardSummary(QNameSet.EMPTY, false, wildcardResultSummarizeAttrWildcards.typedWildcards, wildcardResultSummarizeAttrWildcards.hasWildcards);
        schemaTypeImpl.setComplexTypeVariety(2);
        schemaTypeImpl.setContentModel(null, schemaAttributeModelImpl, null, mapBuildAttributePropertyModelByQName, false);
        schemaTypeImpl.setSimpleTypeVariety(schemaType.getSimpleVariety());
        schemaTypeImpl.setPrimitiveTypeRef(schemaType.getPrimitiveType() == null ? null : schemaType.getPrimitiveType().getRef());
        int simpleVariety = schemaTypeImpl.getSimpleVariety();
        if (simpleVariety == 2) {
            schemaTypeImpl.setUnionMemberTypeRefs(makeRefArray(Arrays.asList(schemaType.getUnionMemberTypes())));
        } else if (simpleVariety == 3) {
            schemaTypeImpl.setListItemTypeRef(schemaType.getListItemType().getRef());
        }
        StscSimpleTypeResolver.resolveFacets(schemaTypeImpl, null, schemaTypeImpl2);
        StscSimpleTypeResolver.resolveFundamentalFacets(schemaTypeImpl);
    }

    public static void resolveScRestriction(SchemaTypeImpl schemaTypeImpl, SimpleRestrictionType simpleRestrictionType) {
        SchemaTypeImpl schemaTypeImpl2;
        SchemaTypeImpl schemaTypeImplTranslateAnonymousSimpleType;
        SchemaTypeImpl schemaTypeImplFindGlobalType;
        SchemaTypeImpl schemaTypeImpl3;
        SchemaType listItemType;
        StscState stscState = StscState.get();
        String targetNamespace = schemaTypeImpl.getTargetNamespace();
        boolean z6 = schemaTypeImpl.getChameleonNamespace() != null;
        ArrayList arrayList = new ArrayList();
        if (simpleRestrictionType.getSimpleType() != null) {
            schemaTypeImplTranslateAnonymousSimpleType = StscTranslator.translateAnonymousSimpleType(simpleRestrictionType.getSimpleType(), targetNamespace, z6, schemaTypeImpl.getElemFormDefault(), schemaTypeImpl.getAttFormDefault(), arrayList, schemaTypeImpl);
            arrayList = arrayList;
            schemaTypeImpl2 = schemaTypeImpl;
        } else {
            schemaTypeImpl2 = schemaTypeImpl;
            schemaTypeImplTranslateAnonymousSimpleType = null;
        }
        if (simpleRestrictionType.getBase() == null) {
            stscState.error("A simpleContent restriction must define a base type", 28, simpleRestrictionType);
            schemaTypeImplFindGlobalType = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        } else if (schemaTypeImpl2.isRedefinition()) {
            schemaTypeImplFindGlobalType = stscState.findRedefinedGlobalType(simpleRestrictionType.getBase(), schemaTypeImpl2.getChameleonNamespace(), schemaTypeImpl2);
            if (schemaTypeImplFindGlobalType != null && !schemaTypeImplFindGlobalType.getName().equals(schemaTypeImpl2.getName())) {
                stscState.error(XmlErrorCodes.SCHEMA_REDEFINE$SAME_TYPE, new Object[]{"<simpleType>", QNameHelper.pretty(schemaTypeImplFindGlobalType.getName()), QNameHelper.pretty(schemaTypeImpl2.getName())}, simpleRestrictionType);
            }
        } else {
            schemaTypeImplFindGlobalType = stscState.findGlobalType(simpleRestrictionType.getBase(), schemaTypeImpl2.getChameleonNamespace(), targetNamespace);
        }
        if (schemaTypeImplFindGlobalType == null) {
            stscState.notFoundError(simpleRestrictionType.getBase(), 0, simpleRestrictionType.xgetBase(), true);
            schemaTypeImplFindGlobalType = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        }
        StscResolver.resolveType(schemaTypeImplFindGlobalType);
        if (schemaTypeImplTranslateAnonymousSimpleType != null) {
            StscResolver.resolveType(schemaTypeImplTranslateAnonymousSimpleType);
            schemaTypeImpl3 = schemaTypeImplTranslateAnonymousSimpleType;
        } else {
            schemaTypeImpl3 = schemaTypeImplFindGlobalType;
        }
        if (schemaTypeImplFindGlobalType.isSimpleType()) {
            stscState.recover(XmlErrorCodes.COMPLEX_TYPE_PROPERTIES$SIMPLE_TYPE_EXTENSION, new Object[]{QNameHelper.pretty(schemaTypeImplFindGlobalType.getName())}, simpleRestrictionType);
            schemaTypeImplFindGlobalType = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        }
        if (schemaTypeImplFindGlobalType != null && schemaTypeImplFindGlobalType.finalRestriction()) {
            stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$FINAL, new Object[]{QNameHelper.pretty(schemaTypeImplFindGlobalType.getName()), QNameHelper.pretty(schemaTypeImpl2.getName())}, simpleRestrictionType.xgetBase());
        }
        SchemaTypeImpl schemaTypeImpl4 = schemaTypeImplFindGlobalType;
        SchemaAttributeModelImpl schemaAttributeModelImpl = schemaTypeImplFindGlobalType == null ? new SchemaAttributeModelImpl() : new SchemaAttributeModelImpl(schemaTypeImplFindGlobalType.getAttributeModel());
        translateAttributeModel(simpleRestrictionType, targetNamespace, z6, schemaTypeImpl2.getAttFormDefault(), arrayList, schemaTypeImpl2, null, schemaAttributeModelImpl, schemaTypeImpl4, false, null);
        WildcardResult wildcardResultSummarizeAttrWildcards = summarizeAttrWildcards(schemaAttributeModelImpl);
        ArrayList arrayList2 = arrayList;
        Map<QName, SchemaProperty> mapBuildAttributePropertyModelByQName = buildAttributePropertyModelByQName(schemaAttributeModelImpl, schemaTypeImpl2);
        if (schemaTypeImpl4 != null) {
            schemaTypeImpl2.setBaseTypeRef(schemaTypeImpl4.getRef());
            schemaTypeImpl2.setBaseDepth(schemaTypeImpl4.getBaseDepth() + 1);
        }
        schemaTypeImpl2.setContentBasedOnTypeRef(schemaTypeImpl3.getRef());
        schemaTypeImpl2.setDerivationType(1);
        schemaTypeImpl2.setAnonymousTypeRefs(makeRefArray(arrayList2));
        schemaTypeImpl2.setWildcardSummary(QNameSet.EMPTY, false, wildcardResultSummarizeAttrWildcards.typedWildcards, wildcardResultSummarizeAttrWildcards.hasWildcards);
        schemaTypeImpl2.setComplexTypeVariety(2);
        schemaTypeImpl.setContentModel(null, schemaAttributeModelImpl, null, mapBuildAttributePropertyModelByQName, false);
        schemaTypeImpl.setSimpleTypeVariety(schemaTypeImpl3.getSimpleVariety());
        schemaTypeImpl.setPrimitiveTypeRef(schemaTypeImpl3.getPrimitiveType() != null ? schemaTypeImpl3.getPrimitiveType().getRef() : null);
        int simpleVariety = schemaTypeImpl.getSimpleVariety();
        if (simpleVariety == 2) {
            schemaTypeImpl.setUnionMemberTypeRefs(makeRefArray(Arrays.asList(schemaTypeImpl3.getUnionMemberTypes())));
        } else if (simpleVariety == 3 && (listItemType = schemaTypeImpl3.getListItemType()) != null) {
            schemaTypeImpl.setListItemTypeRef(listItemType.getRef());
        }
        StscSimpleTypeResolver.resolveFacets(schemaTypeImpl, simpleRestrictionType, schemaTypeImpl3);
        StscSimpleTypeResolver.resolveFundamentalFacets(schemaTypeImpl);
    }

    public static WildcardResult summarizeAttrWildcards(SchemaAttributeModel schemaAttributeModel) {
        if (schemaAttributeModel.getWildcardProcess() == 0) {
            return new WildcardResult(QNameSet.EMPTY, false);
        }
        return schemaAttributeModel.getWildcardProcess() == 3 ? new WildcardResult(QNameSet.EMPTY, true) : new WildcardResult(schemaAttributeModel.getWildcardSet(), true);
    }

    public static WildcardResult summarizeEltWildcards(SchemaParticle schemaParticle) {
        if (schemaParticle == null) {
            return new WildcardResult(QNameSet.EMPTY, false);
        }
        int particleType = schemaParticle.getParticleType();
        if (particleType != 1 && particleType != 2 && particleType != 3) {
            if (particleType != 5) {
                return new WildcardResult(QNameSet.EMPTY, false);
            }
            return new WildcardResult(schemaParticle.getWildcardProcess() == 3 ? QNameSet.EMPTY : schemaParticle.getWildcardSet(), true);
        }
        QNameSetBuilder qNameSetBuilder = new QNameSetBuilder();
        boolean z6 = false;
        for (int i5 = 0; i5 < schemaParticle.countOfParticleChild(); i5++) {
            WildcardResult wildcardResultSummarizeEltWildcards = summarizeEltWildcards(schemaParticle.getParticleChild(i5));
            qNameSetBuilder.addAll(wildcardResultSummarizeEltWildcards.typedWildcards);
            z6 |= wildcardResultSummarizeEltWildcards.hasWildcards;
        }
        return new WildcardResult(qNameSetBuilder.toQNameSet(), z6);
    }

    private static <T> BinaryOperator<T> throwingMerger() {
        return new i(1);
    }

    public static int translateAttributeCode(QName qName) {
        return attributeCodeMap.getOrDefault(qName, 0).intValue();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:34:0x008b A[Catch: all -> 0x0052, TryCatch #0 {all -> 0x0052, blocks: (B:11:0x0022, B:13:0x002f, B:14:0x0038, B:121:0x0288, B:16:0x0042, B:18:0x004a, B:21:0x0056, B:25:0x0063, B:28:0x006b, B:30:0x0071, B:31:0x0077, B:33:0x0081, B:34:0x008b, B:36:0x0099, B:38:0x00a2, B:39:0x00b1, B:24:0x005f, B:41:0x00c4, B:43:0x00d0, B:48:0x00e0, B:50:0x00e6, B:53:0x00f6, B:61:0x0119, B:62:0x0122, B:64:0x0128, B:67:0x0145, B:69:0x014b, B:75:0x015b, B:80:0x016a, B:59:0x0112, B:81:0x0188, B:84:0x01a3, B:86:0x01ad, B:87:0x01cc, B:89:0x01d5, B:92:0x01e1, B:94:0x01ef, B:96:0x020b, B:98:0x0211, B:99:0x021d, B:101:0x0224, B:103:0x022a, B:104:0x0243, B:106:0x0249, B:107:0x0250, B:109:0x0256, B:113:0x0263, B:115:0x0269, B:117:0x026f, B:119:0x0276, B:110:0x025a, B:112:0x0260), top: B:137:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x0099 A[Catch: all -> 0x0052, TryCatch #0 {all -> 0x0052, blocks: (B:11:0x0022, B:13:0x002f, B:14:0x0038, B:121:0x0288, B:16:0x0042, B:18:0x004a, B:21:0x0056, B:25:0x0063, B:28:0x006b, B:30:0x0071, B:31:0x0077, B:33:0x0081, B:34:0x008b, B:36:0x0099, B:38:0x00a2, B:39:0x00b1, B:24:0x005f, B:41:0x00c4, B:43:0x00d0, B:48:0x00e0, B:50:0x00e6, B:53:0x00f6, B:61:0x0119, B:62:0x0122, B:64:0x0128, B:67:0x0145, B:69:0x014b, B:75:0x015b, B:80:0x016a, B:59:0x0112, B:81:0x0188, B:84:0x01a3, B:86:0x01ad, B:87:0x01cc, B:89:0x01d5, B:92:0x01e1, B:94:0x01ef, B:96:0x020b, B:98:0x0211, B:99:0x021d, B:101:0x0224, B:103:0x022a, B:104:0x0243, B:106:0x0249, B:107:0x0250, B:109:0x0256, B:113:0x0263, B:115:0x0269, B:117:0x026f, B:119:0x0276, B:110:0x025a, B:112:0x0260), top: B:137:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00a0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:38:0x00a2 A[Catch: all -> 0x0052, TryCatch #0 {all -> 0x0052, blocks: (B:11:0x0022, B:13:0x002f, B:14:0x0038, B:121:0x0288, B:16:0x0042, B:18:0x004a, B:21:0x0056, B:25:0x0063, B:28:0x006b, B:30:0x0071, B:31:0x0077, B:33:0x0081, B:34:0x008b, B:36:0x0099, B:38:0x00a2, B:39:0x00b1, B:24:0x005f, B:41:0x00c4, B:43:0x00d0, B:48:0x00e0, B:50:0x00e6, B:53:0x00f6, B:61:0x0119, B:62:0x0122, B:64:0x0128, B:67:0x0145, B:69:0x014b, B:75:0x015b, B:80:0x016a, B:59:0x0112, B:81:0x0188, B:84:0x01a3, B:86:0x01ad, B:87:0x01cc, B:89:0x01d5, B:92:0x01e1, B:94:0x01ef, B:96:0x020b, B:98:0x0211, B:99:0x021d, B:101:0x0224, B:103:0x022a, B:104:0x0243, B:106:0x0249, B:107:0x0250, B:109:0x0256, B:113:0x0263, B:115:0x0269, B:117:0x026f, B:119:0x0276, B:110:0x025a, B:112:0x0260), top: B:137:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00b1 A[Catch: all -> 0x0052, TryCatch #0 {all -> 0x0052, blocks: (B:11:0x0022, B:13:0x002f, B:14:0x0038, B:121:0x0288, B:16:0x0042, B:18:0x004a, B:21:0x0056, B:25:0x0063, B:28:0x006b, B:30:0x0071, B:31:0x0077, B:33:0x0081, B:34:0x008b, B:36:0x0099, B:38:0x00a2, B:39:0x00b1, B:24:0x005f, B:41:0x00c4, B:43:0x00d0, B:48:0x00e0, B:50:0x00e6, B:53:0x00f6, B:61:0x0119, B:62:0x0122, B:64:0x0128, B:67:0x0145, B:69:0x014b, B:75:0x015b, B:80:0x016a, B:59:0x0112, B:81:0x0188, B:84:0x01a3, B:86:0x01ad, B:87:0x01cc, B:89:0x01d5, B:92:0x01e1, B:94:0x01ef, B:96:0x020b, B:98:0x0211, B:99:0x021d, B:101:0x0224, B:103:0x022a, B:104:0x0243, B:106:0x0249, B:107:0x0250, B:109:0x0256, B:113:0x0263, B:115:0x0269, B:117:0x026f, B:119:0x0276, B:110:0x025a, B:112:0x0260), top: B:137:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x0119 A[Catch: all -> 0x0052, TryCatch #0 {all -> 0x0052, blocks: (B:11:0x0022, B:13:0x002f, B:14:0x0038, B:121:0x0288, B:16:0x0042, B:18:0x004a, B:21:0x0056, B:25:0x0063, B:28:0x006b, B:30:0x0071, B:31:0x0077, B:33:0x0081, B:34:0x008b, B:36:0x0099, B:38:0x00a2, B:39:0x00b1, B:24:0x005f, B:41:0x00c4, B:43:0x00d0, B:48:0x00e0, B:50:0x00e6, B:53:0x00f6, B:61:0x0119, B:62:0x0122, B:64:0x0128, B:67:0x0145, B:69:0x014b, B:75:0x015b, B:80:0x016a, B:59:0x0112, B:81:0x0188, B:84:0x01a3, B:86:0x01ad, B:87:0x01cc, B:89:0x01d5, B:92:0x01e1, B:94:0x01ef, B:96:0x020b, B:98:0x0211, B:99:0x021d, B:101:0x0224, B:103:0x022a, B:104:0x0243, B:106:0x0249, B:107:0x0250, B:109:0x0256, B:113:0x0263, B:115:0x0269, B:117:0x026f, B:119:0x0276, B:110:0x025a, B:112:0x0260), top: B:137:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x0122 A[Catch: all -> 0x0052, TryCatch #0 {all -> 0x0052, blocks: (B:11:0x0022, B:13:0x002f, B:14:0x0038, B:121:0x0288, B:16:0x0042, B:18:0x004a, B:21:0x0056, B:25:0x0063, B:28:0x006b, B:30:0x0071, B:31:0x0077, B:33:0x0081, B:34:0x008b, B:36:0x0099, B:38:0x00a2, B:39:0x00b1, B:24:0x005f, B:41:0x00c4, B:43:0x00d0, B:48:0x00e0, B:50:0x00e6, B:53:0x00f6, B:61:0x0119, B:62:0x0122, B:64:0x0128, B:67:0x0145, B:69:0x014b, B:75:0x015b, B:80:0x016a, B:59:0x0112, B:81:0x0188, B:84:0x01a3, B:86:0x01ad, B:87:0x01cc, B:89:0x01d5, B:92:0x01e1, B:94:0x01ef, B:96:0x020b, B:98:0x0211, B:99:0x021d, B:101:0x0224, B:103:0x022a, B:104:0x0243, B:106:0x0249, B:107:0x0250, B:109:0x0256, B:113:0x0263, B:115:0x0269, B:117:0x026f, B:119:0x0276, B:110:0x025a, B:112:0x0260), top: B:137:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x0128 A[Catch: all -> 0x0052, TryCatch #0 {all -> 0x0052, blocks: (B:11:0x0022, B:13:0x002f, B:14:0x0038, B:121:0x0288, B:16:0x0042, B:18:0x004a, B:21:0x0056, B:25:0x0063, B:28:0x006b, B:30:0x0071, B:31:0x0077, B:33:0x0081, B:34:0x008b, B:36:0x0099, B:38:0x00a2, B:39:0x00b1, B:24:0x005f, B:41:0x00c4, B:43:0x00d0, B:48:0x00e0, B:50:0x00e6, B:53:0x00f6, B:61:0x0119, B:62:0x0122, B:64:0x0128, B:67:0x0145, B:69:0x014b, B:75:0x015b, B:80:0x016a, B:59:0x0112, B:81:0x0188, B:84:0x01a3, B:86:0x01ad, B:87:0x01cc, B:89:0x01d5, B:92:0x01e1, B:94:0x01ef, B:96:0x020b, B:98:0x0211, B:99:0x021d, B:101:0x0224, B:103:0x022a, B:104:0x0243, B:106:0x0249, B:107:0x0250, B:109:0x0256, B:113:0x0263, B:115:0x0269, B:117:0x026f, B:119:0x0276, B:110:0x025a, B:112:0x0260), top: B:137:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x0145 A[Catch: all -> 0x0052, TryCatch #0 {all -> 0x0052, blocks: (B:11:0x0022, B:13:0x002f, B:14:0x0038, B:121:0x0288, B:16:0x0042, B:18:0x004a, B:21:0x0056, B:25:0x0063, B:28:0x006b, B:30:0x0071, B:31:0x0077, B:33:0x0081, B:34:0x008b, B:36:0x0099, B:38:0x00a2, B:39:0x00b1, B:24:0x005f, B:41:0x00c4, B:43:0x00d0, B:48:0x00e0, B:50:0x00e6, B:53:0x00f6, B:61:0x0119, B:62:0x0122, B:64:0x0128, B:67:0x0145, B:69:0x014b, B:75:0x015b, B:80:0x016a, B:59:0x0112, B:81:0x0188, B:84:0x01a3, B:86:0x01ad, B:87:0x01cc, B:89:0x01d5, B:92:0x01e1, B:94:0x01ef, B:96:0x020b, B:98:0x0211, B:99:0x021d, B:101:0x0224, B:103:0x022a, B:104:0x0243, B:106:0x0249, B:107:0x0250, B:109:0x0256, B:113:0x0263, B:115:0x0269, B:117:0x026f, B:119:0x0276, B:110:0x025a, B:112:0x0260), top: B:137:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x014b A[Catch: all -> 0x0052, TryCatch #0 {all -> 0x0052, blocks: (B:11:0x0022, B:13:0x002f, B:14:0x0038, B:121:0x0288, B:16:0x0042, B:18:0x004a, B:21:0x0056, B:25:0x0063, B:28:0x006b, B:30:0x0071, B:31:0x0077, B:33:0x0081, B:34:0x008b, B:36:0x0099, B:38:0x00a2, B:39:0x00b1, B:24:0x005f, B:41:0x00c4, B:43:0x00d0, B:48:0x00e0, B:50:0x00e6, B:53:0x00f6, B:61:0x0119, B:62:0x0122, B:64:0x0128, B:67:0x0145, B:69:0x014b, B:75:0x015b, B:80:0x016a, B:59:0x0112, B:81:0x0188, B:84:0x01a3, B:86:0x01ad, B:87:0x01cc, B:89:0x01d5, B:92:0x01e1, B:94:0x01ef, B:96:0x020b, B:98:0x0211, B:99:0x021d, B:101:0x0224, B:103:0x022a, B:104:0x0243, B:106:0x0249, B:107:0x0250, B:109:0x0256, B:113:0x0263, B:115:0x0269, B:117:0x026f, B:119:0x0276, B:110:0x025a, B:112:0x0260), top: B:137:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x0155  */
    /* JADX WARN: Code duplicated, block: B:72:0x0156  */
    /* JADX WARN: Code duplicated, block: B:74:0x0159  */
    /* JADX WARN: Code duplicated, block: B:77:0x0164  */
    /* JADX WARN: Code duplicated, block: B:79:0x0168  */
    /* JADX WARN: Multi-variable type inference failed */
    public static void translateAttributeModel(XmlObject xmlObject, String str, boolean z6, String str2, List<SchemaType> list, SchemaType schemaType, Set<QName> set, SchemaAttributeModelImpl schemaAttributeModelImpl, SchemaType schemaType2, boolean z7, SchemaAttributeGroupImpl schemaAttributeGroupImpl) {
        boolean z8;
        boolean z9;
        SchemaAttributeGroupImpl schemaAttributeGroupImplFindAttributeGroup;
        boolean z10;
        boolean z11;
        String targetNamespace;
        SchemaAttributeGroupImpl schemaAttributeGroupImpl2;
        boolean z12;
        int iTranslateWildcardProcess;
        boolean z13;
        StscState stscState = StscState.get();
        Set<QName> hashSet = set == null ? new HashSet() : set;
        Object[] objArr = null;
        SchemaAttributeModel attributeModel = schemaType2 != null ? schemaType2.getAttributeModel() : null;
        XmlCursor xmlCursorNewCursor = xmlObject.newCursor();
        try {
            boolean z14 = false;
            boolean firstChild = xmlCursorNewCursor.toFirstChild();
            boolean z15 = false;
            boolean z16 = false;
            boolean z17 = z6;
            while (firstChild) {
                boolean z18 = true;
                switch (translateAttributeCode(xmlCursorNewCursor.getName())) {
                    case 100:
                        z8 = z14;
                        Attribute attribute = (Attribute) xmlCursorNewCursor.getObject();
                        SchemaAttributeModel schemaAttributeModel = attributeModel;
                        z9 = z17;
                        SchemaLocalAttributeImpl schemaLocalAttributeImplTranslateAttribute = StscTranslator.translateAttribute(attribute, str, str2, z9, list, schemaType, schemaAttributeModel, true);
                        attributeModel = schemaAttributeModel;
                        if (schemaLocalAttributeImplTranslateAttribute != null) {
                            if (hashSet.contains(schemaLocalAttributeImplTranslateAttribute.getName())) {
                                stscState.error(XmlErrorCodes.COMPLEX_TYPE_PROPERTIES$DUPLICATE_ATTRIBUTE, new Object[]{QNameHelper.pretty(schemaLocalAttributeImplTranslateAttribute.getName()), QNameHelper.pretty(schemaType.getName())}, attribute.xgetName());
                            } else {
                                hashSet.add(schemaLocalAttributeImplTranslateAttribute.getName());
                                if (attributeModel != null) {
                                    SchemaLocalAttribute attribute2 = attributeModel.getAttribute(schemaLocalAttributeImplTranslateAttribute.getName());
                                    if (attribute2 == null) {
                                        if (!z7 && !attributeModel.getWildcardSet().contains(schemaLocalAttributeImplTranslateAttribute.getName())) {
                                            stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$ATTR_IN_BASE_WILDCARD_SET, new Object[]{QNameHelper.pretty(schemaLocalAttributeImplTranslateAttribute.getName()), QNameHelper.pretty(schemaType.getName())}, attribute);
                                        }
                                    } else if (z7) {
                                        if (schemaLocalAttributeImplTranslateAttribute.getUse() == 1) {
                                            stscState.error("An extension cannot prohibit an attribute from the base type; use restriction instead.", 37, attribute.xgetUse());
                                        }
                                    } else if (schemaLocalAttributeImplTranslateAttribute.getUse() != 3) {
                                        if (attribute2.getUse() == 3) {
                                            stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$ATTR_REQUIRED, new Object[]{QNameHelper.pretty(schemaLocalAttributeImplTranslateAttribute.getName()), QNameHelper.pretty(schemaType.getName())}, attribute);
                                        }
                                        if (schemaLocalAttributeImplTranslateAttribute.getUse() == 1) {
                                            schemaAttributeModelImpl.removeProhibitedAttribute(schemaLocalAttributeImplTranslateAttribute.getName());
                                        }
                                    }
                                }
                                if (schemaLocalAttributeImplTranslateAttribute.getUse() != 1) {
                                    schemaAttributeModelImpl.addAttribute(schemaLocalAttributeImplTranslateAttribute);
                                } else {
                                    SchemaType type = schemaLocalAttributeImplTranslateAttribute.getType();
                                    if (list != null) {
                                        list.remove(type);
                                    }
                                }
                                if (schemaLocalAttributeImplTranslateAttribute.getDefaultText() != null && !schemaLocalAttributeImplTranslateAttribute.isFixed() && schemaLocalAttributeImplTranslateAttribute.getUse() != 2) {
                                    stscState.error(XmlErrorCodes.SCHEMA_ATTR$DEFAULT_AND_USE_OPTIONAL, new Object[]{QNameHelper.pretty(schemaLocalAttributeImplTranslateAttribute.getName())}, attribute);
                                }
                            }
                        }
                        z17 = z9;
                        z12 = z15;
                        z13 = z16;
                        break;
                    case 101:
                        AttributeGroupRef attributeGroupRef = (AttributeGroupRef) xmlCursorNewCursor.getObject();
                        QName ref = attributeGroupRef.getRef();
                        if (ref != null) {
                            if (schemaAttributeGroupImpl != 0) {
                                schemaAttributeGroupImplFindAttributeGroup = stscState.findRedefinedAttributeGroup(ref, z17 ? str : objArr, schemaAttributeGroupImpl);
                                if (schemaAttributeGroupImplFindAttributeGroup != null && schemaAttributeGroupImpl.getName().equals(schemaAttributeGroupImplFindAttributeGroup.getName())) {
                                    if (z15) {
                                        stscState.error(XmlErrorCodes.SCHEMA_REDEFINE$ATTR_GROUP_SELF_REF, new Object[]{QNameHelper.pretty(schemaAttributeGroupImpl.getName())}, attributeGroupRef);
                                    }
                                    z10 = true;
                                }
                                if (schemaAttributeGroupImplFindAttributeGroup == null) {
                                    if (stscState.isProcessing(schemaAttributeGroupImplFindAttributeGroup)) {
                                        stscState.error(XmlErrorCodes.SCHEMA_ATTR_GROUP$SELF_REF, new Object[]{QNameHelper.pretty(schemaAttributeGroupImplFindAttributeGroup.getName())}, schemaAttributeGroupImplFindAttributeGroup.getParseObject());
                                    } else {
                                        if (schemaAttributeGroupImplFindAttributeGroup.getTargetNamespace() != null) {
                                            targetNamespace = schemaAttributeGroupImplFindAttributeGroup.getTargetNamespace();
                                            if (schemaAttributeGroupImplFindAttributeGroup.getChameleonNamespace() != null) {
                                                z18 = z14;
                                            }
                                            z11 = z18;
                                        } else {
                                            z11 = z17;
                                            targetNamespace = str;
                                        }
                                        stscState.startProcessing(schemaAttributeGroupImplFindAttributeGroup);
                                        if (schemaAttributeGroupImplFindAttributeGroup.isRedefinition()) {
                                            schemaAttributeGroupImpl2 = schemaAttributeGroupImplFindAttributeGroup;
                                        } else {
                                            schemaAttributeGroupImpl2 = objArr;
                                        }
                                        z8 = z14;
                                        translateAttributeModel(schemaAttributeGroupImplFindAttributeGroup.getParseObject(), targetNamespace, z11, schemaAttributeGroupImplFindAttributeGroup.getFormDefault(), list, schemaType, hashSet, schemaAttributeModelImpl, schemaType2, z7, schemaAttributeGroupImpl2);
                                        stscState.finishProcessing(schemaAttributeGroupImplFindAttributeGroup);
                                        z17 = z11;
                                    }
                                    z12 = z10;
                                    z13 = z16;
                                } else {
                                    stscState.notFoundError(ref, 4, attributeGroupRef.xgetRef(), true);
                                }
                                z8 = z14;
                                z12 = z10;
                                z13 = z16;
                            } else {
                                schemaAttributeGroupImplFindAttributeGroup = stscState.findAttributeGroup(ref, z17 ? str : objArr, str);
                            }
                            z10 = z15;
                            if (schemaAttributeGroupImplFindAttributeGroup == null) {
                                if (stscState.isProcessing(schemaAttributeGroupImplFindAttributeGroup)) {
                                    stscState.error(XmlErrorCodes.SCHEMA_ATTR_GROUP$SELF_REF, new Object[]{QNameHelper.pretty(schemaAttributeGroupImplFindAttributeGroup.getName())}, schemaAttributeGroupImplFindAttributeGroup.getParseObject());
                                } else {
                                    if (schemaAttributeGroupImplFindAttributeGroup.getTargetNamespace() != null) {
                                        targetNamespace = schemaAttributeGroupImplFindAttributeGroup.getTargetNamespace();
                                        if (schemaAttributeGroupImplFindAttributeGroup.getChameleonNamespace() != null) {
                                            z18 = z14;
                                        }
                                        z11 = z18;
                                    } else {
                                        z11 = z17;
                                        targetNamespace = str;
                                    }
                                    stscState.startProcessing(schemaAttributeGroupImplFindAttributeGroup);
                                    if (schemaAttributeGroupImplFindAttributeGroup.isRedefinition()) {
                                        schemaAttributeGroupImpl2 = schemaAttributeGroupImplFindAttributeGroup;
                                    } else {
                                        schemaAttributeGroupImpl2 = objArr;
                                    }
                                    z8 = z14;
                                    translateAttributeModel(schemaAttributeGroupImplFindAttributeGroup.getParseObject(), targetNamespace, z11, schemaAttributeGroupImplFindAttributeGroup.getFormDefault(), list, schemaType, hashSet, schemaAttributeModelImpl, schemaType2, z7, schemaAttributeGroupImpl2);
                                    stscState.finishProcessing(schemaAttributeGroupImplFindAttributeGroup);
                                    z17 = z11;
                                }
                                z12 = z10;
                                z13 = z16;
                            } else {
                                stscState.notFoundError(ref, 4, attributeGroupRef.xgetRef(), true);
                            }
                            z8 = z14;
                            z12 = z10;
                            z13 = z16;
                        } else {
                            stscState.error("Attribute group reference must have a ref attribute", 39, attributeGroupRef);
                            attributeModel = attributeModel;
                            z8 = z14;
                            z9 = z17;
                            z17 = z9;
                            z12 = z15;
                            z13 = z16;
                        }
                        break;
                    case 102:
                        Wildcard wildcard = (Wildcard) xmlCursorNewCursor.getObject();
                        if (!z16) {
                            NamespaceList namespaceListXgetNamespace = wildcard.xgetNamespace();
                            String stringValue = namespaceListXgetNamespace == null ? "##any" : namespaceListXgetNamespace.getStringValue();
                            QNameSet qNameSetForWildcardNamespaceString = QNameSet.forWildcardNamespaceString(stringValue, str);
                            if (attributeModel == null || z7) {
                                iTranslateWildcardProcess = translateWildcardProcess(wildcard.xgetProcessContents());
                                if (schemaAttributeModelImpl.getWildcardProcess() == 0) {
                                    schemaAttributeModelImpl.setWildcardSet(qNameSetForWildcardNamespaceString);
                                    schemaAttributeModelImpl.setWildcardProcess(iTranslateWildcardProcess);
                                } else if (z7) {
                                    schemaAttributeModelImpl.setWildcardSet(qNameSetForWildcardNamespaceString.union(schemaAttributeModelImpl.getWildcardSet()));
                                    schemaAttributeModelImpl.setWildcardProcess(iTranslateWildcardProcess);
                                } else {
                                    schemaAttributeModelImpl.setWildcardSet(qNameSetForWildcardNamespaceString.intersect(schemaAttributeModelImpl.getWildcardSet()));
                                }
                            } else if (attributeModel.getWildcardSet() == null) {
                                stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$BASE_HAS_ATTR_WILDCARD, objArr, wildcard);
                            } else if (attributeModel.getWildcardSet().containsAll(qNameSetForWildcardNamespaceString)) {
                                iTranslateWildcardProcess = translateWildcardProcess(wildcard.xgetProcessContents());
                                if (schemaAttributeModelImpl.getWildcardProcess() == 0) {
                                    schemaAttributeModelImpl.setWildcardSet(qNameSetForWildcardNamespaceString);
                                    schemaAttributeModelImpl.setWildcardProcess(iTranslateWildcardProcess);
                                } else if (z7) {
                                    schemaAttributeModelImpl.setWildcardSet(qNameSetForWildcardNamespaceString.union(schemaAttributeModelImpl.getWildcardSet()));
                                    schemaAttributeModelImpl.setWildcardProcess(iTranslateWildcardProcess);
                                } else {
                                    schemaAttributeModelImpl.setWildcardSet(qNameSetForWildcardNamespaceString.intersect(schemaAttributeModelImpl.getWildcardSet()));
                                }
                            } else {
                                stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$ATTR_WILDCARD_SUBSET, new Object[]{stringValue}, wildcard);
                            }
                            attributeModel = attributeModel;
                            z8 = z14;
                            z13 = true;
                            z12 = z15;
                        } else {
                            stscState.error("Only one attribute wildcard allowed", 38, wildcard);
                            attributeModel = attributeModel;
                            z8 = z14;
                            z9 = z17;
                            z17 = z9;
                            z12 = z15;
                            z13 = z16;
                        }
                        break;
                    default:
                        attributeModel = attributeModel;
                        z8 = z14;
                        z9 = z17;
                        z17 = z9;
                        z12 = z15;
                        z13 = z16;
                        break;
                }
                firstChild = xmlCursorNewCursor.toNextSibling();
                z14 = z8;
                attributeModel = attributeModel;
                objArr = null;
                z15 = z12;
                z16 = z13;
            }
            boolean z19 = z14;
            xmlCursorNewCursor.close();
            if (z7 || z16) {
                return;
            }
            schemaAttributeModelImpl.setWildcardSet(null);
            schemaAttributeModelImpl.setWildcardProcess(z19 ? 1 : 0);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursor == null) {
                    throw th2;
                }
                try {
                    xmlCursorNewCursor.close();
                    throw th2;
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                    throw th2;
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:115:0x025c  */
    /* JADX WARN: Code duplicated, block: B:123:0x0281  */
    /* JADX WARN: Code duplicated, block: B:125:0x028a  */
    /* JADX WARN: Code duplicated, block: B:126:0x0291  */
    /* JADX WARN: Code duplicated, block: B:128:0x0294  */
    /* JADX WARN: Code duplicated, block: B:131:0x02a3 A[Catch: all -> 0x02ce, TryCatch #5 {all -> 0x02ce, blocks: (B:129:0x029d, B:131:0x02a3, B:135:0x02c4, B:134:0x02af), top: B:164:0x029d }] */
    /* JADX WARN: Code duplicated, block: B:133:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:134:0x02af A[Catch: all -> 0x02ce, TryCatch #5 {all -> 0x02ce, blocks: (B:129:0x029d, B:131:0x02a3, B:135:0x02c4, B:134:0x02af), top: B:164:0x029d }] */
    /* JADX WARN: Code duplicated, block: B:151:0x02f5  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15, types: [java.lang.Object[], org.apache.xmlbeans.SchemaParticle] */
    /* JADX WARN: Type inference failed for: r7v19 */
    public static SchemaParticle translateContentModel(SchemaType schemaType, XmlObject xmlObject, String str, boolean z6, String str2, String str3, int i5, List<SchemaType> list, Map<QName, SchemaType> map, boolean z7, RedefinitionForGroup redefinitionForGroup) {
        String str4;
        SchemaParticle schemaParticle;
        boolean z8;
        String elemFormDefault;
        String attFormDefault;
        BigInteger bigIntegerExtractMaxOccurs;
        boolean z9;
        SchemaParticleImpl schemaParticleImpl;
        XmlObject xmlObject2;
        BigInteger bigInteger;
        SchemaModelGroupImpl schemaModelGroupImpl;
        String str5;
        String str6;
        boolean z10;
        SchemaParticleImpl schemaParticleImpl2;
        BigInteger bigIntegerExtractMinOccurs;
        ?? r7;
        ArrayList arrayList;
        XmlCursor xmlCursorNewCursor;
        boolean firstChild;
        int iTranslateParticleCode;
        RedefinitionForGroup redefinitionForGroup2;
        Object[] objArr;
        XmlObject object = xmlObject;
        int iTranslateParticleCode2 = i5;
        Map<QName, SchemaType> map2 = map;
        RedefinitionForGroup redefinitionForGroup3 = redefinitionForGroup;
        SchemaModelGroupImpl schemaModelGroupImplFindModelGroup = null;
        if (object == null || iTranslateParticleCode2 == 0) {
            return null;
        }
        StscState stscState = StscState.get();
        if (iTranslateParticleCode2 != 4) {
            str4 = str;
            if (iTranslateParticleCode2 == 5) {
                if (!z7) {
                    stscState.error("Must be a sequence, choice or all here", 32, object);
                }
                AnyDocument.Any any = (AnyDocument.Any) object;
                schemaParticleImpl2 = new SchemaParticleImpl();
                schemaParticleImpl2.setParticleType(5);
                NamespaceList namespaceListXgetNamespace = any.xgetNamespace();
                schemaParticleImpl2.setWildcardSet(namespaceListXgetNamespace == null ? QNameSet.ALL : QNameSet.forWildcardNamespaceString(namespaceListXgetNamespace.getStringValue(), str4));
                schemaParticleImpl2.setWildcardProcess(translateWildcardProcess(any.xgetProcessContents()));
                bigIntegerExtractMinOccurs = extractMinOccurs(any.xgetMinOccurs());
                bigIntegerExtractMaxOccurs = extractMaxOccurs(any.xgetMaxOccurs());
            } else {
                Group group = (Group) object;
                SchemaParticleImpl schemaParticleImpl3 = new SchemaParticleImpl();
                BigInteger bigIntegerExtractMinOccurs2 = extractMinOccurs(group.xgetMinOccurs());
                BigInteger bigIntegerExtractMaxOccurs2 = extractMaxOccurs(group.xgetMaxOccurs());
                if (iTranslateParticleCode2 == 100) {
                    QName ref = group.getRef();
                    if (ref == null) {
                        stscState.error("Group reference must have a ref attribute", 33, object);
                        return null;
                    }
                    if (redefinitionForGroup3 != null) {
                        schemaParticle = null;
                        schemaModelGroupImplFindModelGroup = stscState.findRedefinedModelGroup(ref, z6 ? str4 : null, redefinitionForGroup3.getGroup());
                        if (schemaModelGroupImplFindModelGroup != null && schemaModelGroupImplFindModelGroup.getName().equals(redefinitionForGroup3.getGroup().getName())) {
                            if (redefinitionForGroup3.isSeenRedefinition()) {
                                stscState.error(XmlErrorCodes.SCHEMA_REDEFINE$GROUP_SELF_REF, new Object[]{QNameHelper.pretty(schemaModelGroupImplFindModelGroup.getName())}, object);
                            }
                            BigInteger bigInteger2 = BigInteger.ONE;
                            if (!bigInteger2.equals(bigIntegerExtractMaxOccurs2) || !bigInteger2.equals(bigIntegerExtractMinOccurs2)) {
                                stscState.error(XmlErrorCodes.SCHEMA_REDEFINE$GROUP_SELF_REF_MIN_MAX_1, new Object[]{QNameHelper.pretty(schemaModelGroupImplFindModelGroup.getName())}, object);
                            }
                            redefinitionForGroup3.setSeenRedefinition(true);
                        }
                    } else {
                        schemaParticle = null;
                        schemaModelGroupImplFindModelGroup = stscState.findModelGroup(ref, z6 ? str4 : null, str4);
                    }
                    if (schemaModelGroupImplFindModelGroup == null) {
                        stscState.notFoundError(ref, 6, group.xgetRef(), true);
                        return schemaParticle;
                    }
                    if (stscState.isProcessing(schemaModelGroupImplFindModelGroup)) {
                        stscState.error(XmlErrorCodes.MODEL_GROUP_PROPERTIES$CIRCULAR, new Object[]{QNameHelper.pretty(schemaModelGroupImplFindModelGroup.getName())}, schemaModelGroupImplFindModelGroup.getParseObject());
                        return schemaParticle;
                    }
                    XmlCursor xmlCursorNewCursor2 = schemaModelGroupImplFindModelGroup.getParseObject().newCursor();
                    try {
                        for (boolean firstChild2 = xmlCursorNewCursor2.toFirstChild(); firstChild2; firstChild2 = xmlCursorNewCursor2.toNextSibling()) {
                            iTranslateParticleCode2 = translateParticleCode(xmlCursorNewCursor2.getName());
                            if (iTranslateParticleCode2 != 0) {
                                object = xmlCursorNewCursor2.getObject();
                                break;
                            }
                        }
                        xmlCursorNewCursor2.close();
                        if (iTranslateParticleCode2 == 0) {
                            stscState.error("Model group " + QNameHelper.pretty(schemaModelGroupImplFindModelGroup.getName()) + " is empty", 32, schemaModelGroupImplFindModelGroup.getParseObject());
                            return schemaParticle;
                        }
                        if (iTranslateParticleCode2 != 1 && iTranslateParticleCode2 != 3 && iTranslateParticleCode2 != 2) {
                            stscState.error("Model group " + QNameHelper.pretty(schemaModelGroupImplFindModelGroup.getName()) + " is not a sequence, all, or choice", 32, schemaModelGroupImplFindModelGroup.getParseObject());
                        }
                        String targetNamespace = schemaModelGroupImplFindModelGroup.getTargetNamespace();
                        if (targetNamespace != null) {
                            str4 = targetNamespace;
                        }
                        elemFormDefault = schemaModelGroupImplFindModelGroup.getElemFormDefault();
                        attFormDefault = schemaModelGroupImplFindModelGroup.getAttFormDefault();
                        z8 = schemaModelGroupImplFindModelGroup.getChameleonNamespace() != null;
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            if (xmlCursorNewCursor2 == null) {
                                throw th2;
                            }
                            try {
                                xmlCursorNewCursor2.close();
                                throw th2;
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                                throw th2;
                            }
                        }
                    }
                } else {
                    schemaParticle = null;
                    z8 = z6;
                    elemFormDefault = str2;
                    attFormDefault = str3;
                }
                if (iTranslateParticleCode2 != 1 && iTranslateParticleCode2 != 2 && iTranslateParticleCode2 != 3) {
                    throw new IllegalStateException();
                }
                schemaParticleImpl3.setParticleType(iTranslateParticleCode2);
                bigIntegerExtractMaxOccurs = bigIntegerExtractMaxOccurs2;
                z9 = true;
                schemaParticleImpl = schemaParticleImpl3;
                xmlObject2 = object;
                bigInteger = bigIntegerExtractMinOccurs2;
                schemaModelGroupImpl = schemaModelGroupImplFindModelGroup;
                str5 = attFormDefault;
                str6 = elemFormDefault;
                z10 = z8;
            }
            if (bigIntegerExtractMaxOccurs != null || bigInteger.compareTo(bigIntegerExtractMaxOccurs) <= 0) {
                r7 = schemaParticle;
            } else {
                objArr = schemaParticle;
                stscState.error(XmlErrorCodes.PARTICLE_PROPERTIES$MIN_LTE_MAX, objArr, xmlObject2);
                bigIntegerExtractMaxOccurs = bigInteger;
            }
            if (bigIntegerExtractMaxOccurs == null && bigIntegerExtractMaxOccurs.compareTo(BigInteger.ONE) < 0) {
                r7 = objArr;
                stscState.warning(XmlErrorCodes.PARTICLE_PROPERTIES$MAX_GTE_1, (Object[]) r7, xmlObject2);
                list.remove(schemaParticleImpl.getType());
                return r7;
            }
            r7 = objArr;
            r7 = objArr;
            schemaParticleImpl.setMinOccurs(bigInteger);
            schemaParticleImpl.setMaxOccurs(bigIntegerExtractMaxOccurs);
            if (schemaModelGroupImpl != null) {
                stscState.startProcessing(schemaModelGroupImpl);
                if (schemaModelGroupImpl.isRedefinition()) {
                    redefinitionForGroup3 = new RedefinitionForGroup(schemaModelGroupImpl);
                } else {
                    redefinitionForGroup3 = null;
                }
            }
            if (z9) {
                arrayList = new ArrayList();
                xmlCursorNewCursor = xmlObject2.newCursor();
                try {
                    firstChild = xmlCursorNewCursor.toFirstChild();
                    while (firstChild) {
                        iTranslateParticleCode = translateParticleCode(xmlCursorNewCursor.getName());
                        if (iTranslateParticleCode == 0) {
                            redefinitionForGroup2 = redefinitionForGroup3;
                        } else {
                            redefinitionForGroup2 = redefinitionForGroup3;
                            addMinusPointlessParticles(arrayList, translateContentModel(schemaType, xmlCursorNewCursor.getObject(), str4, z10, str6, str5, iTranslateParticleCode, list, map2, true, redefinitionForGroup2), schemaParticleImpl.getParticleType());
                        }
                        firstChild = xmlCursorNewCursor.toNextSibling();
                        map2 = map;
                        redefinitionForGroup3 = redefinitionForGroup2;
                    }
                    xmlCursorNewCursor.close();
                    schemaParticleImpl.setParticleChildren((SchemaParticle[]) arrayList.toArray(new SchemaParticle[0]));
                } catch (Throwable th4) {
                    try {
                        throw th4;
                    } catch (Throwable th5) {
                        if (xmlCursorNewCursor == null) {
                            throw th5;
                        }
                        try {
                            xmlCursorNewCursor.close();
                            throw th5;
                        } catch (Throwable th6) {
                            th4.addSuppressed(th6);
                            throw th5;
                        }
                    }
                }
            }
            SchemaParticle schemaParticleFilterPointlessParticlesAndVerifyAllParticles = filterPointlessParticlesAndVerifyAllParticles(schemaParticleImpl, xmlObject2);
            if (schemaModelGroupImpl != null) {
                stscState.finishProcessing(schemaModelGroupImpl);
            }
            return schemaParticleFilterPointlessParticlesAndVerifyAllParticles;
        }
        if (!z7) {
            stscState.error("Must be a sequence, choice or all here", 32, object);
        }
        LocalElement localElement = (LocalElement) object;
        str4 = str;
        schemaParticleImpl2 = StscTranslator.translateElement(localElement, str4, z6, str2, str3, list, schemaType);
        if (schemaParticleImpl2 == null) {
            return null;
        }
        bigIntegerExtractMinOccurs = extractMinOccurs(localElement.xgetMinOccurs());
        bigIntegerExtractMaxOccurs = extractMaxOccurs(localElement.xgetMaxOccurs());
        SchemaType schemaType2 = map2.get(schemaParticleImpl2.getName());
        if (schemaType2 == null) {
            map2.put(schemaParticleImpl2.getName(), schemaParticleImpl2.getType());
        } else if (!schemaParticleImpl2.getType().equals(schemaType2)) {
            stscState.error(XmlErrorCodes.ELEM_CONSISTANT, new Object[]{QNameHelper.pretty(schemaParticleImpl2.getName())}, object);
            return null;
        }
        str6 = str2;
        str5 = str3;
        xmlObject2 = object;
        bigInteger = bigIntegerExtractMinOccurs;
        schemaParticle = null;
        schemaParticleImpl = schemaParticleImpl2;
        z9 = false;
        z10 = z6;
        schemaModelGroupImpl = null;
        if (bigIntegerExtractMaxOccurs != null) {
            r7 = schemaParticle;
        } else {
            r7 = schemaParticle;
        }
        if (bigIntegerExtractMaxOccurs == null) {
        }
        r7 = objArr;
        r7 = objArr;
        schemaParticleImpl.setMinOccurs(bigInteger);
        schemaParticleImpl.setMaxOccurs(bigIntegerExtractMaxOccurs);
        if (schemaModelGroupImpl != null) {
            stscState.startProcessing(schemaModelGroupImpl);
            if (schemaModelGroupImpl.isRedefinition()) {
                redefinitionForGroup3 = new RedefinitionForGroup(schemaModelGroupImpl);
            } else {
                redefinitionForGroup3 = null;
            }
        }
        if (z9) {
            arrayList = new ArrayList();
            xmlCursorNewCursor = xmlObject2.newCursor();
            firstChild = xmlCursorNewCursor.toFirstChild();
            while (firstChild) {
                iTranslateParticleCode = translateParticleCode(xmlCursorNewCursor.getName());
                if (iTranslateParticleCode == 0) {
                    redefinitionForGroup2 = redefinitionForGroup3;
                } else {
                    redefinitionForGroup2 = redefinitionForGroup3;
                    addMinusPointlessParticles(arrayList, translateContentModel(schemaType, xmlCursorNewCursor.getObject(), str4, z10, str6, str5, iTranslateParticleCode, list, map2, true, redefinitionForGroup2), schemaParticleImpl.getParticleType());
                }
                firstChild = xmlCursorNewCursor.toNextSibling();
                map2 = map;
                redefinitionForGroup3 = redefinitionForGroup2;
            }
            xmlCursorNewCursor.close();
            schemaParticleImpl.setParticleChildren((SchemaParticle[]) arrayList.toArray(new SchemaParticle[0]));
        }
        SchemaParticle schemaParticleFilterPointlessParticlesAndVerifyAllParticles2 = filterPointlessParticlesAndVerifyAllParticles(schemaParticleImpl, xmlObject2);
        if (schemaModelGroupImpl != null) {
            stscState.finishProcessing(schemaModelGroupImpl);
        }
        return schemaParticleFilterPointlessParticlesAndVerifyAllParticles2;
    }

    private static int translateParticleCode(Group group) {
        if (group == null) {
            return 0;
        }
        XmlCursor xmlCursorNewCursor = group.newCursor();
        try {
            int iTranslateParticleCode = translateParticleCode(xmlCursorNewCursor.getName());
            xmlCursorNewCursor.close();
            return iTranslateParticleCode;
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

    public static int translateWildcardProcess(Wildcard.ProcessContents processContents) {
        if (processContents == null) {
            return 1;
        }
        String stringValue = processContents.getStringValue();
        if ("lax".equals(stringValue)) {
            return 2;
        }
        return "skip".equals(stringValue) ? 3 : 1;
    }

    public static Group getContentModel(final ComplexRestrictionType complexRestrictionType) {
        complexRestrictionType.getClass();
        final int i5 = 0;
        final int i6 = 1;
        final int i7 = 2;
        final int i8 = 3;
        return getContentModel((Supplier<? extends Group>[]) new Supplier[]{new Supplier() { // from class: org.apache.xmlbeans.impl.schema.n
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return complexRestrictionType.getAll();
                    case 1:
                        return complexRestrictionType.getSequence();
                    case 2:
                        return complexRestrictionType.getChoice();
                    default:
                        return complexRestrictionType.getGroup();
                }
            }
        }, new Supplier() { // from class: org.apache.xmlbeans.impl.schema.n
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return complexRestrictionType.getAll();
                    case 1:
                        return complexRestrictionType.getSequence();
                    case 2:
                        return complexRestrictionType.getChoice();
                    default:
                        return complexRestrictionType.getGroup();
                }
            }
        }, new Supplier() { // from class: org.apache.xmlbeans.impl.schema.n
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return complexRestrictionType.getAll();
                    case 1:
                        return complexRestrictionType.getSequence();
                    case 2:
                        return complexRestrictionType.getChoice();
                    default:
                        return complexRestrictionType.getGroup();
                }
            }
        }, new Supplier() { // from class: org.apache.xmlbeans.impl.schema.n
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return complexRestrictionType.getAll();
                    case 1:
                        return complexRestrictionType.getSequence();
                    case 2:
                        return complexRestrictionType.getChoice();
                    default:
                        return complexRestrictionType.getGroup();
                }
            }
        }});
    }

    public static Group getContentModel(final ExtensionType extensionType) {
        extensionType.getClass();
        final int i5 = 0;
        final int i6 = 1;
        final int i7 = 2;
        final int i8 = 3;
        return getContentModel((Supplier<? extends Group>[]) new Supplier[]{new Supplier() { // from class: org.apache.xmlbeans.impl.schema.k
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return extensionType.getAll();
                    case 1:
                        return extensionType.getSequence();
                    case 2:
                        return extensionType.getChoice();
                    default:
                        return extensionType.getGroup();
                }
            }
        }, new Supplier() { // from class: org.apache.xmlbeans.impl.schema.k
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return extensionType.getAll();
                    case 1:
                        return extensionType.getSequence();
                    case 2:
                        return extensionType.getChoice();
                    default:
                        return extensionType.getGroup();
                }
            }
        }, new Supplier() { // from class: org.apache.xmlbeans.impl.schema.k
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return extensionType.getAll();
                    case 1:
                        return extensionType.getSequence();
                    case 2:
                        return extensionType.getChoice();
                    default:
                        return extensionType.getGroup();
                }
            }
        }, new Supplier() { // from class: org.apache.xmlbeans.impl.schema.k
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return extensionType.getAll();
                    case 1:
                        return extensionType.getSequence();
                    case 2:
                        return extensionType.getChoice();
                    default:
                        return extensionType.getGroup();
                }
            }
        }});
    }

    @SafeVarargs
    private static Group getContentModel(Supplier<? extends Group>... supplierArr) {
        return (Group) Stream.of((Object[]) supplierArr).map(new l(27)).filter(new b(1)).findFirst().orElse(null);
    }

    private static int translateParticleCode(QName qName) {
        return particleCodeMap.getOrDefault(qName, 0).intValue();
    }
}
