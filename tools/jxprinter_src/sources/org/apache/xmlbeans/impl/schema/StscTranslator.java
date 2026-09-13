package org.apache.xmlbeans.impl.schema;

import A3.AbstractC0157z;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.QNameSetBuilder;
import org.apache.xmlbeans.SchemaAttributeModel;
import org.apache.xmlbeans.SchemaBookmark;
import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaParticle;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlNonNegativeInteger;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlPositiveInteger;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.Sax2Dom;
import org.apache.xmlbeans.impl.common.XMLChar;
import org.apache.xmlbeans.impl.regex.RegularExpression;
import org.apache.xmlbeans.impl.values.NamespaceContext;
import org.apache.xmlbeans.impl.values.XmlNonNegativeIntegerImpl;
import org.apache.xmlbeans.impl.values.XmlPositiveIntegerImpl;
import org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException;
import org.apache.xmlbeans.impl.xb.xsdschema.Annotated;
import org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
import org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.Element;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.FormChoice;
import org.apache.xmlbeans.impl.xb.xsdschema.Keybase;
import org.apache.xmlbeans.impl.xb.xsdschema.KeyrefDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.LocalElement;
import org.apache.xmlbeans.impl.xb.xsdschema.LocalSimpleType;
import org.apache.xmlbeans.impl.xb.xsdschema.NamedAttributeGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.NamedGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SimpleType;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelAttribute;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelComplexType;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelElement;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelSimpleType;
import org.apache.xmlbeans.impl.xpath.XPath;
import org.apache.xmlbeans.soap.SOAPArrayType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class StscTranslator {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String FORM_QUALIFIED = "qualified";
    private static final QName WSDL_ARRAYTYPE_NAME = QNameHelper.forLNS(SoapEncSchemaTypeSystem.ARRAY_TYPE, "http://schemas.xmlsoap.org/wsdl/");
    public static final RegularExpression XPATH_REGEXP = new RegularExpression("(\\.//)?((((child::)?((\\i\\c*:)?(\\i\\c*|\\*)))|\\.)/)*((((child::)?((\\i\\c*:)?(\\i\\c*|\\*)))|\\.)|((attribute::|@)((\\i\\c*:)?(\\i\\c*|\\*))))(\\|(\\.//)?((((child::)?((\\i\\c*:)?(\\i\\c*|\\*)))|\\.)/)*((((child::)?((\\i\\c*:)?(\\i\\c*|\\*)))|\\.)|((attribute::|@)((\\i\\c*:)?(\\i\\c*|\\*)))))*", "X");

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class RedefinitionHolder {
        private Map<String, NamedAttributeGroup> agRedefinitions;
        private Map<String, TopLevelComplexType> ctRedefinitions;
        private Map<String, NamedGroup> mgRedefinitions;
        private String schemaLocation;
        private final StscImporter.SchemaToProcess schemaRedefined;
        private Map<String, TopLevelSimpleType> stRedefinitions;

        public RedefinitionHolder(StscImporter.SchemaToProcess schemaToProcess, RedefineDocument.Redefine redefine) {
            Map map = Collections.EMPTY_MAP;
            this.stRedefinitions = map;
            this.ctRedefinitions = map;
            this.agRedefinitions = map;
            this.mgRedefinitions = map;
            this.schemaLocation = "";
            this.schemaRedefined = schemaToProcess;
            if (redefine != null) {
                StscState stscState = StscState.get();
                this.stRedefinitions = new HashMap();
                this.ctRedefinitions = new HashMap();
                this.agRedefinitions = new HashMap();
                this.mgRedefinitions = new HashMap();
                if (redefine.getSchemaLocation() != null) {
                    this.schemaLocation = redefine.getSchemaLocation();
                }
                for (TopLevelComplexType topLevelComplexType : redefine.getComplexTypeArray()) {
                    if (topLevelComplexType.getName() != null) {
                        if (this.ctRedefinitions.containsKey(topLevelComplexType.getName())) {
                            stscState.error("Duplicate type redefinition: " + topLevelComplexType.getName(), 49, (XmlObject) null);
                        } else {
                            this.ctRedefinitions.put(topLevelComplexType.getName(), topLevelComplexType);
                        }
                    }
                }
                for (TopLevelSimpleType topLevelSimpleType : redefine.getSimpleTypeArray()) {
                    if (topLevelSimpleType.getName() != null) {
                        if (this.stRedefinitions.containsKey(topLevelSimpleType.getName())) {
                            stscState.error("Duplicate type redefinition: " + topLevelSimpleType.getName(), 49, (XmlObject) null);
                        } else {
                            this.stRedefinitions.put(topLevelSimpleType.getName(), topLevelSimpleType);
                        }
                    }
                }
                for (NamedGroup namedGroup : redefine.getGroupArray()) {
                    if (namedGroup.getName() != null) {
                        if (this.mgRedefinitions.containsKey(namedGroup.getName())) {
                            stscState.error("Duplicate type redefinition: " + namedGroup.getName(), 49, (XmlObject) null);
                        } else {
                            this.mgRedefinitions.put(namedGroup.getName(), namedGroup);
                        }
                    }
                }
                for (NamedAttributeGroup namedAttributeGroup : redefine.getAttributeGroupArray()) {
                    if (namedAttributeGroup.getName() != null) {
                        if (this.agRedefinitions.containsKey(namedAttributeGroup.getName())) {
                            stscState.error("Duplicate type redefinition: " + namedAttributeGroup.getName(), 49, (XmlObject) null);
                        } else {
                            this.agRedefinitions.put(namedAttributeGroup.getName(), namedAttributeGroup);
                        }
                    }
                }
            }
        }

        public void complainAboutMissingDefinitions() {
            if (this.stRedefinitions.isEmpty() && this.ctRedefinitions.isEmpty() && this.agRedefinitions.isEmpty() && this.mgRedefinitions.isEmpty()) {
                return;
            }
            StscState stscState = StscState.get();
            for (String str : this.stRedefinitions.keySet()) {
                StringBuilder sbY = AbstractC0157z.y("Redefined simple type ", str, " not found in ");
                sbY.append(this.schemaLocation);
                stscState.error(sbY.toString(), 60, this.stRedefinitions.get(str));
            }
            for (String str2 : this.ctRedefinitions.keySet()) {
                StringBuilder sbY2 = AbstractC0157z.y("Redefined complex type ", str2, " not found in ");
                sbY2.append(this.schemaLocation);
                stscState.error(sbY2.toString(), 60, this.ctRedefinitions.get(str2));
            }
            for (String str3 : this.agRedefinitions.keySet()) {
                StringBuilder sbY3 = AbstractC0157z.y("Redefined attribute group ", str3, " not found in ");
                sbY3.append(this.schemaLocation);
                stscState.error(sbY3.toString(), 60, this.agRedefinitions.get(str3));
            }
            for (String str4 : this.mgRedefinitions.keySet()) {
                StringBuilder sbY4 = AbstractC0157z.y("Redefined model group ", str4, " not found in ");
                sbY4.append(this.schemaLocation);
                stscState.error(sbY4.toString(), 60, this.mgRedefinitions.get(str4));
            }
        }

        public NamedAttributeGroup redefineAttributeGroup(String str) {
            if (str == null || !this.agRedefinitions.containsKey(str)) {
                return null;
            }
            return this.agRedefinitions.remove(str);
        }

        public TopLevelComplexType redefineComplexType(String str) {
            if (str == null || !this.ctRedefinitions.containsKey(str)) {
                return null;
            }
            return this.ctRedefinitions.remove(str);
        }

        public NamedGroup redefineModelGroup(String str) {
            if (str == null || !this.mgRedefinitions.containsKey(str)) {
                return null;
            }
            return this.mgRedefinitions.remove(str);
        }

        public TopLevelSimpleType redefineSimpleType(String str) {
            if (str == null || !this.stRedefinitions.containsKey(str)) {
                return null;
            }
            return this.stRedefinitions.remove(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class RedefinitionMaster {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final short ATTRIBUTE_GROUP = 4;
        private static final short COMPLEX_TYPE = 2;
        private static final RedefinitionHolder[] EMPTY_REDEFINTION_HOLDER_ARRAY = new RedefinitionHolder[0];
        private static final short MODEL_GROUP = 3;
        private static final short SIMPLE_TYPE = 1;
        private Map<String, List<RedefinitionHolder>> agRedefinitions;
        private Map<String, List<RedefinitionHolder>> ctRedefinitions;
        private Map<String, List<RedefinitionHolder>> mgRedefinitions;
        private Map<String, List<RedefinitionHolder>> stRedefinitions;

        public RedefinitionMaster(RedefinitionHolder[] redefinitionHolderArr) {
            Map<String, List<RedefinitionHolder>> map = Collections.EMPTY_MAP;
            this.stRedefinitions = map;
            this.ctRedefinitions = map;
            this.agRedefinitions = map;
            this.mgRedefinitions = map;
            if (redefinitionHolderArr.length > 0) {
                this.stRedefinitions = new HashMap();
                this.ctRedefinitions = new HashMap();
                this.agRedefinitions = new HashMap();
                this.mgRedefinitions = new HashMap();
                for (RedefinitionHolder redefinitionHolder : redefinitionHolderArr) {
                    Iterator it = redefinitionHolder.stRedefinitions.keySet().iterator();
                    while (it.hasNext()) {
                        this.stRedefinitions.computeIfAbsent((String) it.next(), new l(4)).add(redefinitionHolder);
                    }
                    Iterator it2 = redefinitionHolder.ctRedefinitions.keySet().iterator();
                    while (it2.hasNext()) {
                        this.ctRedefinitions.computeIfAbsent((String) it2.next(), new l(5)).add(redefinitionHolder);
                    }
                    Iterator it3 = redefinitionHolder.agRedefinitions.keySet().iterator();
                    while (it3.hasNext()) {
                        this.agRedefinitions.computeIfAbsent((String) it3.next(), new l(6)).add(redefinitionHolder);
                    }
                    Iterator it4 = redefinitionHolder.mgRedefinitions.keySet().iterator();
                    while (it4.hasNext()) {
                        this.mgRedefinitions.computeIfAbsent((String) it4.next(), new l(7)).add(redefinitionHolder);
                    }
                }
            }
        }

        private String componentNameFromCode(short s6) {
            if (s6 == 1) {
                return "simple type";
            }
            if (s6 == 2) {
                return "complex type";
            }
            if (s6 != 3) {
                return s6 != 4 ? "" : "attribute group";
            }
            return "model group";
        }

        private RedefinitionHolder[] doTopologicalSort(List<RedefinitionHolder> list, StscImporter.SchemaToProcess schemaToProcess, String str, short s6) {
            int i5;
            int i6;
            int i7;
            RedefinitionHolder[] redefinitionHolderArr = new RedefinitionHolder[list.size()];
            int i8 = 0;
            for (RedefinitionHolder redefinitionHolder : list) {
                if (redefinitionHolder.schemaRedefined == schemaToProcess || redefinitionHolder.schemaRedefined.indirectIncludes(schemaToProcess)) {
                    redefinitionHolderArr[i8] = redefinitionHolder;
                    i8++;
                }
            }
            RedefinitionHolder[] redefinitionHolderArr2 = new RedefinitionHolder[i8];
            int[] iArr = new int[i8];
            int i9 = 0;
            while (true) {
                i5 = 1;
                if (i9 >= i8 - 1) {
                    break;
                }
                RedefinitionHolder redefinitionHolder2 = redefinitionHolderArr[i9];
                int i10 = i9 + 1;
                for (int i11 = i10; i11 < i8; i11++) {
                    if (redefinitionHolder2.schemaRedefined.indirectIncludes(redefinitionHolderArr[i11].schemaRedefined)) {
                        iArr[i9] = iArr[i9] + 1;
                    }
                    if (redefinitionHolderArr[i11].schemaRedefined.indirectIncludes(redefinitionHolder2.schemaRedefined)) {
                        iArr[i11] = iArr[i11] + 1;
                    }
                }
                i9 = i10;
            }
            int i12 = 0;
            int i13 = 0;
            while (true) {
                XmlObject xmlObjectLocationFromRedefinitionAndCode = null;
                if (i12 >= i8) {
                    break;
                }
                int i14 = -1;
                for (int i15 = 0; i15 < i8; i15++) {
                    if (iArr[i15] == 0 && i14 < 0) {
                        i14 = i15;
                    }
                }
                if (i14 < 0) {
                    if (i13 == 0) {
                        StringBuilder sb = new StringBuilder();
                        int i16 = 0;
                        while (i16 < i8) {
                            RedefinitionHolder redefinitionHolder3 = redefinitionHolderArr[i16];
                            int i17 = i5;
                            if (redefinitionHolder3 != null) {
                                sb.append(redefinitionHolder3.schemaLocation);
                                sb.append(", ");
                                if (xmlObjectLocationFromRedefinitionAndCode == null) {
                                    xmlObjectLocationFromRedefinitionAndCode = locationFromRedefinitionAndCode(redefinitionHolderArr[i16], str, s6);
                                }
                            }
                            i16++;
                            i5 = i17;
                        }
                        i7 = i5;
                        StscState stscState = StscState.get();
                        StringBuilder sb2 = new StringBuilder("Detected circular redefinition of ");
                        androidx.collection.a.y(sb2, componentNameFromCode(s6), " \"", str, "\"; Files involved: ");
                        sb2.append(sb.toString());
                        stscState.error(sb2.toString(), 60, xmlObjectLocationFromRedefinitionAndCode);
                        i13 = i7;
                    } else {
                        i7 = i5;
                    }
                    int i18 = i8;
                    for (int i19 = 0; i19 < i8; i19++) {
                        int i20 = iArr[i19];
                        if (i20 > 0 && i20 < i18) {
                            i14 = i19;
                            i18 = i20;
                        }
                    }
                    iArr[i14] = iArr[i14] - 1;
                } else {
                    i7 = i5;
                    int i21 = i12 + 1;
                    redefinitionHolderArr2[i12] = redefinitionHolderArr[i14];
                    for (int i22 = 0; i22 < i8; i22++) {
                        RedefinitionHolder redefinitionHolder4 = redefinitionHolderArr[i22];
                        if (redefinitionHolder4 != null && redefinitionHolder4.schemaRedefined.indirectIncludes(redefinitionHolderArr[i14].schemaRedefined)) {
                            iArr[i22] = iArr[i22] - 1;
                        }
                    }
                    redefinitionHolderArr[i14] = null;
                    iArr[i14] = iArr[i14] - 1;
                    i12 = i21;
                }
                i5 = i7;
            }
            int i23 = i5;
            int i24 = i23;
            while (i24 < i8) {
                int i25 = i24 - 1;
                while (i25 >= 0 && redefinitionHolderArr2[i25] == null) {
                    i25--;
                }
                if (redefinitionHolderArr2[i24].schemaRedefined.indirectIncludes(redefinitionHolderArr2[i25].schemaRedefined)) {
                    i6 = i23;
                } else {
                    StscState stscState2 = StscState.get();
                    StringBuilder sb3 = new StringBuilder("Detected multiple redefinitions of ");
                    androidx.collection.a.y(sb3, componentNameFromCode(s6), " \"", str, "\"; Files involved: ");
                    sb3.append(redefinitionHolderArr2[i25].schemaRedefined.getSourceName());
                    sb3.append(", ");
                    sb3.append(redefinitionHolderArr2[i24].schemaRedefined.getSourceName());
                    stscState2.error(sb3.toString(), 49, locationFromRedefinitionAndCode(redefinitionHolderArr2[i24], str, s6));
                    i6 = i23;
                    if (s6 == i6) {
                        redefinitionHolderArr2[i24].redefineSimpleType(str);
                    } else if (s6 == 2) {
                        redefinitionHolderArr2[i24].redefineComplexType(str);
                    } else if (s6 == 3) {
                        redefinitionHolderArr2[i24].redefineModelGroup(str);
                    } else if (s6 == 4) {
                        redefinitionHolderArr2[i24].redefineAttributeGroup(str);
                    }
                    redefinitionHolderArr2[i24] = null;
                }
                i24++;
                i23 = i6;
            }
            return redefinitionHolderArr2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ List lambda$new$0(String str) {
            return new ArrayList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ List lambda$new$1(String str) {
            return new ArrayList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ List lambda$new$2(String str) {
            return new ArrayList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ List lambda$new$3(String str) {
            return new ArrayList();
        }

        private XmlObject locationFromRedefinitionAndCode(RedefinitionHolder redefinitionHolder, String str, short s6) {
            if (s6 == 1) {
                return (XmlObject) redefinitionHolder.stRedefinitions.get(str);
            }
            if (s6 == 2) {
                return (XmlObject) redefinitionHolder.ctRedefinitions.get(str);
            }
            if (s6 == 3) {
                return (XmlObject) redefinitionHolder.mgRedefinitions.get(str);
            }
            if (s6 != 4) {
                return null;
            }
            return (XmlObject) redefinitionHolder.agRedefinitions.get(str);
        }

        public RedefinitionHolder[] getAttributeGroupRedefinitions(String str, StscImporter.SchemaToProcess schemaToProcess) {
            List<RedefinitionHolder> list = this.agRedefinitions.get(str);
            return list == null ? EMPTY_REDEFINTION_HOLDER_ARRAY : doTopologicalSort(list, schemaToProcess, str, (short) 4);
        }

        public RedefinitionHolder[] getComplexTypeRedefinitions(String str, StscImporter.SchemaToProcess schemaToProcess) {
            List<RedefinitionHolder> list = this.ctRedefinitions.get(str);
            return list == null ? EMPTY_REDEFINTION_HOLDER_ARRAY : doTopologicalSort(list, schemaToProcess, str, (short) 2);
        }

        public RedefinitionHolder[] getModelGroupRedefinitions(String str, StscImporter.SchemaToProcess schemaToProcess) {
            List<RedefinitionHolder> list = this.mgRedefinitions.get(str);
            return list == null ? EMPTY_REDEFINTION_HOLDER_ARRAY : doTopologicalSort(list, schemaToProcess, str, (short) 3);
        }

        public RedefinitionHolder[] getSimpleTypeRedefinitions(String str, StscImporter.SchemaToProcess schemaToProcess) {
            List<RedefinitionHolder> list = this.stRedefinitions.get(str);
            return list == null ? EMPTY_REDEFINTION_HOLDER_ARRAY : doTopologicalSort(list, schemaToProcess, str, (short) 1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void addAllDefinitions(StscImporter.SchemaToProcess[] schemaToProcessArr) {
        boolean z6;
        StscImporter.SchemaToProcess[] schemaToProcessArr2 = schemaToProcessArr;
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        for (StscImporter.SchemaToProcess schemaToProcess : schemaToProcessArr2) {
            List<StscImporter.SchemaToProcess> redefines = schemaToProcess.getRedefines();
            if (redefines != null) {
                List<RedefineDocument.Redefine> redefineObjects = schemaToProcess.getRedefineObjects();
                Iterator<StscImporter.SchemaToProcess> it = redefines.iterator();
                Iterator<RedefineDocument.Redefine> it2 = redefineObjects.iterator();
                while (it.hasNext()) {
                    arrayList.add(new RedefinitionHolder(it.next(), it2.next()));
                }
            }
        }
        RedefinitionMaster redefinitionMaster = new RedefinitionMaster((RedefinitionHolder[]) arrayList.toArray(new RedefinitionHolder[0]));
        StscState stscState = StscState.get();
        int length = schemaToProcessArr2.length;
        int i6 = 0;
        while (i6 < length) {
            StscImporter.SchemaToProcess schemaToProcess2 = schemaToProcessArr2[i6];
            SchemaDocument.Schema schema = schemaToProcess2.getSchema();
            String chameleonNamespace = schemaToProcess2.getChameleonNamespace();
            if (schema.sizeOfNotationArray() > 0) {
                stscState.warning("Schema <notation> is not yet supported for this release.", 51, schema.getNotationArray(i5));
            }
            String targetNamespace = schema.getTargetNamespace();
            if (chameleonNamespace == null || targetNamespace != null) {
                chameleonNamespace = targetNamespace;
                z6 = i5;
            } else {
                z6 = 1;
            }
            if (chameleonNamespace == null) {
                chameleonNamespace = "";
            }
            if (chameleonNamespace.length() > 0 || !isEmptySchema(schema)) {
                stscState.registerContribution(chameleonNamespace, schema.documentProperties().getSourceName());
                stscState.addNewContainer(chameleonNamespace);
            }
            ArrayList arrayList2 = new ArrayList();
            TopLevelComplexType[] complexTypeArray = schema.getComplexTypeArray();
            int length2 = complexTypeArray.length;
            for (int i7 = i5; i7 < length2; i7++) {
                TopLevelComplexType topLevelComplexType = complexTypeArray[i7];
                RedefinitionHolder[] complexTypeRedefinitions = redefinitionMaster.getComplexTypeRedefinitions(topLevelComplexType.getName(), schemaToProcess2);
                int length3 = complexTypeRedefinitions.length;
                TopLevelComplexType topLevelComplexType2 = topLevelComplexType;
                int i8 = 0;
                while (i8 < length3) {
                    int i9 = i8;
                    RedefinitionHolder redefinitionHolder = complexTypeRedefinitions[i9];
                    int i10 = length3;
                    if (redefinitionHolder != null) {
                        TopLevelComplexType topLevelComplexTypeRedefineComplexType = redefinitionHolder.redefineComplexType(topLevelComplexType2.getName());
                        arrayList2.add(topLevelComplexType2);
                        topLevelComplexType2 = topLevelComplexTypeRedefineComplexType;
                    }
                    i8 = i9 + 1;
                    length3 = i10;
                }
                SchemaTypeImpl schemaTypeImplTranslateGlobalComplexType = translateGlobalComplexType(topLevelComplexType2, chameleonNamespace, z6, arrayList2.size() > 0);
                stscState.addGlobalType(schemaTypeImplTranslateGlobalComplexType, null);
                int size = arrayList2.size() - 1;
                while (size >= 0) {
                    int i11 = size;
                    SchemaTypeImpl schemaTypeImplTranslateGlobalComplexType2 = translateGlobalComplexType((TopLevelComplexType) arrayList2.remove(size), chameleonNamespace, z6, size > 0);
                    stscState.addGlobalType(schemaTypeImplTranslateGlobalComplexType2, schemaTypeImplTranslateGlobalComplexType);
                    size = i11 - 1;
                    schemaTypeImplTranslateGlobalComplexType = schemaTypeImplTranslateGlobalComplexType2;
                }
            }
            TopLevelSimpleType[] simpleTypeArray = schema.getSimpleTypeArray();
            int length4 = simpleTypeArray.length;
            int i12 = 0;
            while (i12 < length4) {
                TopLevelSimpleType topLevelSimpleType = simpleTypeArray[i12];
                RedefinitionHolder[] simpleTypeRedefinitions = redefinitionMaster.getSimpleTypeRedefinitions(topLevelSimpleType.getName(), schemaToProcess2);
                int length5 = simpleTypeRedefinitions.length;
                TopLevelSimpleType[] topLevelSimpleTypeArr = simpleTypeArray;
                int i13 = 0;
                while (i13 < length5) {
                    int i14 = i13;
                    RedefinitionHolder redefinitionHolder2 = simpleTypeRedefinitions[i14];
                    int i15 = length4;
                    if (redefinitionHolder2 != null) {
                        TopLevelSimpleType topLevelSimpleTypeRedefineSimpleType = redefinitionHolder2.redefineSimpleType(topLevelSimpleType.getName());
                        arrayList2.add(topLevelSimpleType);
                        topLevelSimpleType = topLevelSimpleTypeRedefineSimpleType;
                    }
                    i13 = i14 + 1;
                    length4 = i15;
                }
                int i16 = length4;
                SchemaTypeImpl schemaTypeImplTranslateGlobalSimpleType = translateGlobalSimpleType(topLevelSimpleType, chameleonNamespace, z6, arrayList2.size() > 0);
                stscState.addGlobalType(schemaTypeImplTranslateGlobalSimpleType, null);
                int size2 = arrayList2.size() - 1;
                while (size2 >= 0) {
                    SchemaTypeImpl schemaTypeImplTranslateGlobalSimpleType2 = translateGlobalSimpleType((TopLevelSimpleType) arrayList2.remove(size2), chameleonNamespace, z6, size2 > 0);
                    stscState.addGlobalType(schemaTypeImplTranslateGlobalSimpleType2, schemaTypeImplTranslateGlobalSimpleType);
                    size2--;
                    schemaTypeImplTranslateGlobalSimpleType = schemaTypeImplTranslateGlobalSimpleType2;
                }
                i12++;
                simpleTypeArray = topLevelSimpleTypeArr;
                length4 = i16;
            }
            for (TopLevelElement topLevelElement : schema.getElementArray()) {
                stscState.addDocumentType(translateDocumentType(topLevelElement, chameleonNamespace, z6), QNameHelper.forLNS(topLevelElement.getName(), chameleonNamespace));
            }
            for (TopLevelAttribute topLevelAttribute : schema.getAttributeArray()) {
                stscState.addAttributeType(translateAttributeType(topLevelAttribute, chameleonNamespace, z6), QNameHelper.forLNS(topLevelAttribute.getName(), chameleonNamespace));
            }
            NamedGroup[] groupArray = schema.getGroupArray();
            int length6 = groupArray.length;
            int i17 = 0;
            while (i17 < length6) {
                NamedGroup namedGroup = groupArray[i17];
                RedefinitionHolder[] modelGroupRedefinitions = redefinitionMaster.getModelGroupRedefinitions(namedGroup.getName(), schemaToProcess2);
                int length7 = modelGroupRedefinitions.length;
                NamedGroup[] namedGroupArr = groupArray;
                int i18 = 0;
                while (i18 < length7) {
                    int i19 = i18;
                    RedefinitionHolder redefinitionHolder3 = modelGroupRedefinitions[i19];
                    int i20 = length6;
                    if (redefinitionHolder3 != null) {
                        NamedGroup namedGroupRedefineModelGroup = redefinitionHolder3.redefineModelGroup(namedGroup.getName());
                        arrayList2.add(namedGroup);
                        namedGroup = namedGroupRedefineModelGroup;
                    }
                    i18 = i19 + 1;
                    length6 = i20;
                }
                int i21 = length6;
                SchemaModelGroupImpl schemaModelGroupImplTranslateModelGroup = translateModelGroup(namedGroup, chameleonNamespace, z6, arrayList2.size() > 0);
                stscState.addModelGroup(schemaModelGroupImplTranslateModelGroup, null);
                int size3 = arrayList2.size() - 1;
                while (size3 >= 0) {
                    SchemaModelGroupImpl schemaModelGroupImplTranslateModelGroup2 = translateModelGroup((NamedGroup) arrayList2.remove(size3), chameleonNamespace, z6, size3 > 0);
                    stscState.addModelGroup(schemaModelGroupImplTranslateModelGroup2, schemaModelGroupImplTranslateModelGroup);
                    size3--;
                    schemaModelGroupImplTranslateModelGroup = schemaModelGroupImplTranslateModelGroup2;
                }
                i17++;
                groupArray = namedGroupArr;
                length6 = i21;
            }
            NamedAttributeGroup[] attributeGroupArray = schema.getAttributeGroupArray();
            int length8 = attributeGroupArray.length;
            int i22 = 0;
            while (i22 < length8) {
                NamedAttributeGroup namedAttributeGroup = attributeGroupArray[i22];
                RedefinitionHolder[] attributeGroupRedefinitions = redefinitionMaster.getAttributeGroupRedefinitions(namedAttributeGroup.getName(), schemaToProcess2);
                int length9 = attributeGroupRedefinitions.length;
                NamedAttributeGroup[] namedAttributeGroupArr = attributeGroupArray;
                int i23 = 0;
                while (i23 < length9) {
                    int i24 = i23;
                    RedefinitionHolder redefinitionHolder4 = attributeGroupRedefinitions[i24];
                    RedefinitionMaster redefinitionMaster2 = redefinitionMaster;
                    if (redefinitionHolder4 != null) {
                        NamedAttributeGroup namedAttributeGroupRedefineAttributeGroup = redefinitionHolder4.redefineAttributeGroup(namedAttributeGroup.getName());
                        arrayList2.add(namedAttributeGroup);
                        namedAttributeGroup = namedAttributeGroupRedefineAttributeGroup;
                    }
                    i23 = i24 + 1;
                    redefinitionMaster = redefinitionMaster2;
                }
                RedefinitionMaster redefinitionMaster3 = redefinitionMaster;
                SchemaAttributeGroupImpl schemaAttributeGroupImplTranslateAttributeGroup = translateAttributeGroup(namedAttributeGroup, chameleonNamespace, z6, arrayList2.size() > 0);
                stscState.addAttributeGroup(schemaAttributeGroupImplTranslateAttributeGroup, null);
                int size4 = arrayList2.size() - 1;
                while (size4 >= 0) {
                    SchemaAttributeGroupImpl schemaAttributeGroupImplTranslateAttributeGroup2 = translateAttributeGroup((NamedAttributeGroup) arrayList2.remove(size4), chameleonNamespace, z6, size4 > 0);
                    stscState.addAttributeGroup(schemaAttributeGroupImplTranslateAttributeGroup2, schemaAttributeGroupImplTranslateAttributeGroup);
                    size4--;
                    schemaAttributeGroupImplTranslateAttributeGroup = schemaAttributeGroupImplTranslateAttributeGroup2;
                }
                i22++;
                attributeGroupArray = namedAttributeGroupArr;
                redefinitionMaster = redefinitionMaster3;
            }
            RedefinitionMaster redefinitionMaster4 = redefinitionMaster;
            for (AnnotationDocument.Annotation annotation : schema.getAnnotationArray()) {
                stscState.addAnnotation(SchemaAnnotationImpl.getAnnotation(stscState.getContainer(chameleonNamespace), schema, annotation), chameleonNamespace);
            }
            i6++;
            schemaToProcessArr2 = schemaToProcessArr;
            redefinitionMaster = redefinitionMaster4;
            i5 = 0;
        }
        int size5 = arrayList.size();
        int i25 = 0;
        while (i25 < size5) {
            Object obj = arrayList.get(i25);
            i25++;
            ((RedefinitionHolder) obj).complainAboutMissingDefinitions();
        }
    }

    public static BigInteger buildBigInt(XmlAnySimpleType xmlAnySimpleType) {
        if (xmlAnySimpleType == null) {
            return null;
        }
        String stringValue = xmlAnySimpleType.getStringValue();
        try {
            BigInteger bigInteger = new BigInteger(stringValue);
            if (bigInteger.signum() >= 0) {
                return bigInteger;
            }
            StscState.get().error(XmlErrorCodes.INVALID_VALUE, new Object[]{stringValue, "nonNegativeInteger"}, xmlAnySimpleType);
            return null;
        } catch (NumberFormatException e) {
            StscState.get().error(XmlErrorCodes.INVALID_VALUE_DETAIL, new Object[]{stringValue, "nonNegativeInteger", e.getMessage()}, xmlAnySimpleType);
            return null;
        }
    }

    public static XmlNonNegativeInteger buildNnInteger(XmlAnySimpleType xmlAnySimpleType) {
        BigInteger bigIntegerBuildBigInt = buildBigInt(xmlAnySimpleType);
        try {
            XmlNonNegativeIntegerImpl xmlNonNegativeIntegerImpl = new XmlNonNegativeIntegerImpl();
            xmlNonNegativeIntegerImpl.setBigIntegerValue(bigIntegerBuildBigInt);
            xmlNonNegativeIntegerImpl.setImmutable();
            return xmlNonNegativeIntegerImpl;
        } catch (XmlValueOutOfRangeException unused) {
            StscState.get().error("Internal error processing number", 21, xmlAnySimpleType);
            return null;
        }
    }

    public static XmlPositiveInteger buildPosInteger(XmlAnySimpleType xmlAnySimpleType) {
        BigInteger bigIntegerBuildBigInt = buildBigInt(xmlAnySimpleType);
        try {
            XmlPositiveIntegerImpl xmlPositiveIntegerImpl = new XmlPositiveIntegerImpl();
            xmlPositiveIntegerImpl.setBigIntegerValue(bigIntegerBuildBigInt);
            xmlPositiveIntegerImpl.setImmutable();
            return xmlPositiveIntegerImpl;
        } catch (XmlValueOutOfRangeException unused) {
            StscState.get().error("Internal error processing number", 21, xmlAnySimpleType);
            return null;
        }
    }

    private static SchemaType checkRecursiveGroupReference(QName[] qNameArr, QName qName, SchemaTypeImpl schemaTypeImpl) {
        QName[] groupReferenceContext;
        if (qNameArr.length < 1) {
            return null;
        }
        while (schemaTypeImpl != null && schemaTypeImpl.getName() == null && !schemaTypeImpl.isDocumentType()) {
            if (qName.equals(schemaTypeImpl.getContainerField().getName()) && (groupReferenceContext = schemaTypeImpl.getGroupReferenceContext()) != null && groupReferenceContext.length == qNameArr.length) {
                for (int i5 = 0; i5 < qNameArr.length; i5++) {
                    QName qName2 = qNameArr[i5];
                    if ((qName2 == null && groupReferenceContext[i5] == null) || (qName2 != null && qName2.equals(groupReferenceContext[i5]))) {
                    }
                }
                return schemaTypeImpl;
            }
            schemaTypeImpl = (SchemaTypeImpl) schemaTypeImpl.getOuterType();
        }
        return null;
    }

    private static boolean checkXPathSyntax(String str) {
        boolean zMatches;
        if (str == null) {
            return false;
        }
        String strRemoveWhitespace = removeWhitespace(str);
        RegularExpression regularExpression = XPATH_REGEXP;
        synchronized (regularExpression) {
            zMatches = regularExpression.matches(strRemoveWhitespace);
        }
        return zMatches;
    }

    public static void copyGlobalAttributeToLocalAttribute(SchemaGlobalAttributeImpl schemaGlobalAttributeImpl, SchemaLocalAttributeImpl schemaLocalAttributeImpl) {
        schemaLocalAttributeImpl.init(schemaGlobalAttributeImpl.getName(), schemaGlobalAttributeImpl.getTypeRef(), schemaGlobalAttributeImpl.getUse(), schemaGlobalAttributeImpl.getDefaultText(), schemaGlobalAttributeImpl.getParseObject(), schemaGlobalAttributeImpl._defaultValue, schemaGlobalAttributeImpl.isFixed(), schemaGlobalAttributeImpl.getWSDLArrayType(), schemaGlobalAttributeImpl.getAnnotation(), null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void copyGlobalElementToLocalElement(SchemaGlobalElement schemaGlobalElement, SchemaLocalElementImpl schemaLocalElementImpl) {
        schemaLocalElementImpl.setNameAndTypeRef(schemaGlobalElement.getName(), schemaGlobalElement.getType().getRef());
        schemaLocalElementImpl.setNillable(schemaGlobalElement.isNillable());
        schemaLocalElementImpl.setDefault(schemaGlobalElement.getDefaultText(), schemaGlobalElement.isFixed(), ((SchemaGlobalElementImpl) schemaGlobalElement).getParseObject());
        schemaLocalElementImpl.setIdentityConstraints(((SchemaLocalElementImpl) schemaGlobalElement).getIdentityConstraintRefs());
        schemaLocalElementImpl.setBlock(schemaGlobalElement.blockExtension(), schemaGlobalElement.blockRestriction(), schemaGlobalElement.blockSubstitution());
        schemaLocalElementImpl.setAbstract(schemaGlobalElement.isAbstract());
        SchemaParticle schemaParticle = (SchemaParticle) schemaGlobalElement;
        schemaLocalElementImpl.setTransitionRules(schemaParticle.acceptedStartNames(), schemaParticle.isSkippable());
        schemaLocalElementImpl.setAnnotation(schemaGlobalElement.getAnnotation());
    }

    public static FormChoice findAttributeFormDefault(XmlObject xmlObject) {
        XmlCursor xmlCursorNewCursor = xmlObject.newCursor();
        while (xmlCursorNewCursor.getObject().schemaType() != SchemaDocument.Schema.type) {
            try {
                if (!xmlCursorNewCursor.toParent()) {
                    xmlCursorNewCursor.close();
                    return null;
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
        FormChoice formChoiceXgetAttributeFormDefault = ((SchemaDocument.Schema) xmlCursorNewCursor.getObject()).xgetAttributeFormDefault();
        xmlCursorNewCursor.close();
        return formChoiceXgetAttributeFormDefault;
    }

    public static FormChoice findElementFormDefault(XmlObject xmlObject) {
        XmlCursor xmlCursorNewCursor = xmlObject.newCursor();
        while (xmlCursorNewCursor.getObject().schemaType() != SchemaDocument.Schema.type) {
            try {
                if (!xmlCursorNewCursor.toParent()) {
                    xmlCursorNewCursor.close();
                    return null;
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
        FormChoice formChoiceXgetElementFormDefault = ((SchemaDocument.Schema) xmlCursorNewCursor.getObject()).xgetElementFormDefault();
        xmlCursorNewCursor.close();
        return formChoiceXgetElementFormDefault;
    }

    private static String findFilename(XmlObject xmlObject) {
        return StscState.get().sourceNameForUri(xmlObject.documentProperties().getSourceName());
    }

    private static Object getUserData(XmlObject xmlObject) {
        XmlCursor xmlCursorNewCursor = xmlObject.newCursor();
        try {
            XmlCursor.XmlBookmark bookmark = xmlCursorNewCursor.getBookmark(SchemaBookmark.class);
            xmlCursorNewCursor.close();
            if (bookmark instanceof SchemaBookmark) {
                return ((SchemaBookmark) bookmark).getValue();
            }
            return null;
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

    private static boolean isEmptySchema(SchemaDocument.Schema schema) {
        XmlCursor xmlCursorNewCursor = schema.newCursor();
        try {
            boolean z6 = !xmlCursorNewCursor.toFirstChild();
            xmlCursorNewCursor.close();
            return z6;
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

    private static boolean isReservedTypeName(QName qName) {
        return BuiltinSchemaTypeSystem.get().findType(qName) != null;
    }

    private static String removeWhitespace(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i5 = 0; i5 < str.length(); i5++) {
            char cCharAt = str.charAt(i5);
            if (!XMLChar.isSpace(cCharAt)) {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    public static SchemaTypeImpl translateAnonymousSimpleType(SimpleType simpleType, String str, boolean z6, String str2, String str3, List<SchemaType> list, SchemaType schemaType) {
        StscState stscState = StscState.get();
        SchemaTypeImpl schemaTypeImpl = new SchemaTypeImpl(stscState.getContainer(str));
        schemaTypeImpl.setSimpleType(true);
        schemaTypeImpl.setParseContext(simpleType, str, z6, str2, str3, false);
        schemaTypeImpl.setOuterSchemaTypeRef(schemaType.getRef());
        schemaTypeImpl.setAnnotation(SchemaAnnotationImpl.getAnnotation(stscState.getContainer(str), simpleType));
        schemaTypeImpl.setUserData(getUserData(simpleType));
        list.add(schemaTypeImpl);
        return schemaTypeImpl;
    }

    public static SchemaLocalAttributeImpl translateAttribute(Attribute attribute, String str, String str2, boolean z6, List<SchemaType> list, SchemaType schemaType, SchemaAttributeModel schemaAttributeModel, boolean z7) {
        SchemaLocalAttributeImpl schemaLocalAttributeImpl;
        QName qNameForLNS;
        SchemaTypeImpl schemaTypeImpl;
        boolean z8;
        SchemaType type;
        boolean zIsSetFixed;
        String defaultText;
        String str3;
        int iTranslateUseCode;
        boolean zEquals;
        SchemaType schemaType2;
        boolean zIsFixed;
        StscState stscState = StscState.get();
        String name = attribute.getName();
        QName ref = attribute.getRef();
        SOAPArrayType sOAPArrayType = null;
        if (ref != null && name != null) {
            if (name.equals(ref.getLocalPart()) && uriMatch(str, ref.getNamespaceURI())) {
                stscState.warning(XmlErrorCodes.SCHEMA_ATTR$REF_OR_NAME_HAS_BOTH, new Object[]{name}, attribute.xgetRef());
            } else {
                stscState.error(XmlErrorCodes.SCHEMA_ATTR$REF_OR_NAME_HAS_BOTH, new Object[]{name}, attribute.xgetRef());
            }
            name = null;
        }
        if (ref == null && name == null) {
            stscState.error(XmlErrorCodes.SCHEMA_ATTR$REF_OR_NAME_HAS_NEITHER, (Object[]) null, attribute);
            return null;
        }
        if (name != null && !XMLChar.isValidNCName(name)) {
            stscState.error(XmlErrorCodes.INVALID_VALUE, new Object[]{name, "name"}, attribute.xgetName());
        }
        if (z7) {
            schemaLocalAttributeImpl = new SchemaLocalAttributeImpl();
        } else {
            SchemaGlobalAttributeImpl schemaGlobalAttributeImpl = new SchemaGlobalAttributeImpl(StscState.get().getContainer(str));
            schemaGlobalAttributeImpl.setParseContext(attribute, str, z6);
            schemaLocalAttributeImpl = schemaGlobalAttributeImpl;
        }
        SchemaLocalAttributeImpl schemaLocalAttributeImpl2 = schemaLocalAttributeImpl;
        if (ref != null) {
            if (attribute.getType() != null) {
                stscState.error(XmlErrorCodes.SCHEMA_ATTR$REF_FEATURES, new Object[]{"type"}, attribute.xgetType());
            }
            if (attribute.getSimpleType() != null) {
                stscState.error(XmlErrorCodes.SCHEMA_ATTR$REF_FEATURES, new Object[]{"<simpleType>"}, attribute.getSimpleType());
            }
            if (attribute.getForm() != null) {
                stscState.error(XmlErrorCodes.SCHEMA_ATTR$REF_FEATURES, new Object[]{"form"}, attribute.xgetForm());
            }
            SchemaGlobalAttributeImpl schemaGlobalAttributeImplFindGlobalAttribute = stscState.findGlobalAttribute(ref, z6 ? str : null, str);
            if (schemaGlobalAttributeImplFindGlobalAttribute == null) {
                stscState.notFoundError(ref, 3, attribute.xgetRef(), true);
                return null;
            }
            iTranslateUseCode = schemaGlobalAttributeImplFindGlobalAttribute.getUse();
            SchemaType type2 = schemaGlobalAttributeImplFindGlobalAttribute.getType();
            defaultText = schemaGlobalAttributeImplFindGlobalAttribute.getDefaultText();
            if (defaultText != null) {
                zIsFixed = schemaGlobalAttributeImplFindGlobalAttribute.isFixed();
                if (zIsFixed) {
                    str3 = defaultText;
                }
                zIsSetFixed = zIsFixed;
                schemaType2 = type2;
                z8 = false;
            } else {
                zIsFixed = false;
            }
            str3 = null;
            zIsSetFixed = zIsFixed;
            schemaType2 = type2;
            z8 = false;
        } else {
            if (z7) {
                FormChoice formChoiceXgetForm = attribute.xgetForm();
                if (formChoiceXgetForm != null) {
                    zEquals = formChoiceXgetForm.getStringValue().equals(FORM_QUALIFIED);
                } else if (str2 != null) {
                    zEquals = str2.equals(FORM_QUALIFIED);
                } else {
                    FormChoice formChoiceFindAttributeFormDefault = findAttributeFormDefault(attribute);
                    zEquals = formChoiceFindAttributeFormDefault != null && formChoiceFindAttributeFormDefault.getStringValue().equals(FORM_QUALIFIED);
                }
                qNameForLNS = zEquals ? QNameHelper.forLNS(name, str) : QNameHelper.forLN(name);
            } else {
                qNameForLNS = QNameHelper.forLNS(name, str);
            }
            ref = qNameForLNS;
            if (attribute.getType() != null) {
                SchemaTypeImpl schemaTypeImplFindGlobalType = stscState.findGlobalType(attribute.getType(), z6 ? str : null, str);
                schemaTypeImpl = schemaTypeImplFindGlobalType;
                if (schemaTypeImplFindGlobalType == null) {
                    stscState.notFoundError(attribute.getType(), 0, attribute.xgetType(), true);
                    schemaTypeImpl = schemaTypeImplFindGlobalType;
                }
            } else {
                schemaTypeImpl = null;
            }
            if (ref.getNamespaceURI().equals("http://www.w3.org/2001/XMLSchema-instance")) {
                stscState.error(XmlErrorCodes.NO_XSI, new Object[]{"http://www.w3.org/2001/XMLSchema-instance"}, attribute.xgetName());
            }
            if (ref.getNamespaceURI().length() == 0 && ref.getLocalPart().equals(Sax2Dom.XMLNS_PREFIX)) {
                stscState.error(XmlErrorCodes.NO_XMLNS, (Object[]) null, attribute.xgetName());
            }
            LocalSimpleType simpleType = attribute.getSimpleType();
            if (schemaTypeImpl != null && simpleType != null) {
                stscState.error(XmlErrorCodes.SCHEMA_ATTR$TYPE_ATTR_OR_NESTED_TYPE, (Object[]) null, simpleType);
                simpleType = null;
            }
            if (simpleType != null) {
                SchemaTypeImpl schemaTypeImpl2 = new SchemaTypeImpl(stscState.getContainer(str));
                schemaTypeImpl2.setContainerField(schemaLocalAttributeImpl2);
                schemaTypeImpl2.setOuterSchemaTypeRef(schemaType == null ? null : schemaType.getRef());
                list.add(schemaTypeImpl2);
                schemaTypeImpl2.setSimpleType(true);
                LocalSimpleType localSimpleType = simpleType;
                z8 = false;
                schemaTypeImpl2.setParseContext(localSimpleType, str, z6, null, null, false);
                schemaTypeImpl2.setAnnotation(SchemaAnnotationImpl.getAnnotation(stscState.getContainer(str), localSimpleType));
                schemaTypeImpl2.setUserData(getUserData(localSimpleType));
                type = schemaTypeImpl2;
            } else {
                z8 = false;
            }
            if (type == null && schemaAttributeModel != null && schemaAttributeModel.getAttribute(ref) != null) {
                type = schemaAttributeModel.getAttribute(ref).getType();
            }
            type = schemaTypeImpl;
            zIsSetFixed = z8;
            defaultText = null;
            str3 = null;
            iTranslateUseCode = 2;
            schemaType2 = type;
        }
        if (schemaType2 == null) {
            schemaType2 = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        }
        boolean zIsSimpleType = schemaType2.isSimpleType();
        SchemaType schemaType3 = schemaType2;
        if (!zIsSimpleType) {
            stscState.error("Attributes must have a simple type (not complex).", 46, attribute);
            schemaType3 = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        }
        if (attribute.isSetUse() && (iTranslateUseCode = translateUseCode(attribute.xgetUse())) != 2 && !zIsSetFixed) {
            defaultText = null;
        }
        if (attribute.isSetDefault() || attribute.isSetFixed()) {
            if (zIsSetFixed && !attribute.isSetFixed()) {
                stscState.error("A use of a fixed attribute definition must also be fixed", 9, attribute.xgetFixed());
            }
            zIsSetFixed = attribute.isSetFixed();
            if (attribute.isSetDefault() && zIsSetFixed) {
                stscState.error(XmlErrorCodes.SCHEMA_ATTR$DEFAULT_OR_FIXED, (Object[]) null, attribute.xgetFixed());
                zIsSetFixed = z8;
            }
            Object fixed = zIsSetFixed ? attribute.getFixed() : attribute.getDefault();
            if (str3 == null || str3.equals(fixed)) {
                str3 = fixed;
            } else {
                stscState.error(XmlErrorCodes.SCHEMA_ATTR$FIXED_NOT_MATCH, (Object[]) null, attribute.xgetFixed());
            }
        } else {
            str3 = defaultText;
        }
        if (!z7) {
            ((SchemaGlobalAttributeImpl) schemaLocalAttributeImpl2).setFilename(findFilename(attribute));
        }
        XmlCursor xmlCursorNewCursor = attribute.newCursor();
        try {
            String attributeText = xmlCursorNewCursor.getAttributeText(WSDL_ARRAYTYPE_NAME);
            xmlCursorNewCursor.close();
            if (attributeText != null) {
                try {
                    sOAPArrayType = new SOAPArrayType(attributeText, new NamespaceContext(attribute));
                } catch (XmlValueOutOfRangeException unused) {
                    stscState.error(XmlErrorCodes.SOAPARRAY, new Object[]{attributeText}, attribute);
                }
            }
            schemaLocalAttributeImpl2.init(ref, schemaType3.getRef(), iTranslateUseCode, str3, attribute, null, zIsSetFixed, sOAPArrayType, SchemaAnnotationImpl.getAnnotation(stscState.getContainer(str), attribute), getUserData(attribute));
            return schemaLocalAttributeImpl2;
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

    public static SchemaAttributeGroupImpl translateAttributeGroup(AttributeGroup attributeGroup, String str, boolean z6, boolean z7) {
        String name = attributeGroup.getName();
        if (name == null) {
            StscState.get().error(XmlErrorCodes.MISSING_NAME, new Object[]{"attribute group"}, attributeGroup);
            return null;
        }
        SchemaContainer container = StscState.get().getContainer(str);
        SchemaAttributeGroupImpl schemaAttributeGroupImpl = new SchemaAttributeGroupImpl(container);
        SchemaAnnotationImpl annotation = SchemaAnnotationImpl.getAnnotation(container, attributeGroup);
        FormChoice formChoiceFindAttributeFormDefault = findAttributeFormDefault(attributeGroup);
        schemaAttributeGroupImpl.init(QNameHelper.forLNS(name, str), str, z6, formChoiceFindAttributeFormDefault != null ? formChoiceFindAttributeFormDefault.getStringValue() : null, z7, attributeGroup, annotation, getUserData(attributeGroup));
        schemaAttributeGroupImpl.setFilename(findFilename(attributeGroup));
        return schemaAttributeGroupImpl;
    }

    private static SchemaTypeImpl translateAttributeType(TopLevelAttribute topLevelAttribute, String str, boolean z6) {
        SchemaTypeImpl schemaTypeImpl = new SchemaTypeImpl(StscState.get().getContainer(str));
        schemaTypeImpl.setAttributeType(true);
        schemaTypeImpl.setParseContext(topLevelAttribute, str, z6, null, null, false);
        schemaTypeImpl.setFilename(findFilename(topLevelAttribute));
        return schemaTypeImpl;
    }

    private static SchemaTypeImpl translateDocumentType(TopLevelElement topLevelElement, String str, boolean z6) {
        SchemaTypeImpl schemaTypeImpl = new SchemaTypeImpl(StscState.get().getContainer(str));
        schemaTypeImpl.setDocumentType(true);
        schemaTypeImpl.setParseContext(topLevelElement, str, z6, null, null, false);
        schemaTypeImpl.setFilename(findFilename(topLevelElement));
        return schemaTypeImpl;
    }

    /* JADX WARN: Code duplicated, block: B:107:0x0219  */
    /* JADX WARN: Code duplicated, block: B:136:0x02b3 A[PHI: r1
  0x02b3: PHI (r1v11 org.apache.xmlbeans.SchemaType) = (r1v10 org.apache.xmlbeans.SchemaType), (r1v39 org.apache.xmlbeans.SchemaType) binds: [B:127:0x0282, B:135:0x02b1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:182:0x039d  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r25v0, types: [java.util.List, java.util.List<org.apache.xmlbeans.SchemaType>] */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7, types: [int] */
    /* JADX WARN: Type inference failed for: r6v20, types: [int] */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v22, types: [int] */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v24, types: [int] */
    /* JADX WARN: Type inference failed for: r6v49 */
    /* JADX WARN: Type inference failed for: r6v50 */
    /* JADX WARN: Type inference failed for: r6v51 */
    /* JADX WARN: Type inference failed for: r6v52 */
    /* JADX WARN: Type inference failed for: r7v21, types: [int] */
    /* JADX WARN: Type inference failed for: r7v22, types: [int] */
    /* JADX WARN: Type inference failed for: r7v50 */
    /* JADX WARN: Type inference failed for: r7v51 */
    /* JADX WARN: Type inference failed for: r7v52 */
    /* JADX WARN: Type inference failed for: r7v53 */
    public static SchemaLocalElementImpl translateElement(Element element, String str, boolean z6, String str2, String str3, List<SchemaType> list, SchemaType schemaType) {
        SchemaTypeImpl schemaTypeImpl;
        QName qNameForLNS;
        boolean z7;
        boolean zContains;
        SchemaLocalElementImpl schemaLocalElementImpl;
        boolean z8;
        SchemaType schemaTypeCheckRecursiveGroupReference;
        boolean z9;
        boolean z10;
        SchemaType type;
        SOAPArrayType sOAPArrayType;
        boolean z11;
        boolean zContains2;
        boolean zContains3;
        boolean zEquals;
        StscState stscState = StscState.get();
        if (element.isSetSubstitutionGroup()) {
            SchemaTypeImpl schemaTypeImplFindDocumentType = stscState.findDocumentType(element.getSubstitutionGroup(), ((SchemaTypeImpl) schemaType).getChameleonNamespace(), str);
            if (schemaTypeImplFindDocumentType != null) {
                StscResolver.resolveType(schemaTypeImplFindDocumentType);
            }
            schemaTypeImpl = schemaTypeImplFindDocumentType;
        } else {
            schemaTypeImpl = null;
        }
        String name = element.getName();
        QName ref = element.getRef();
        if (ref != null && name != null) {
            stscState.error(XmlErrorCodes.SCHEMA_ELEM$REF_OR_NAME_HAS_BOTH, new Object[]{name}, element.xgetRef());
            name = null;
        }
        if (ref == null && name == null) {
            stscState.error(XmlErrorCodes.SCHEMA_ELEM$REF_OR_NAME_HAS_NEITHER, (Object[]) null, element);
            return null;
        }
        if (name != null && !XMLChar.isValidNCName(name)) {
            stscState.error(XmlErrorCodes.INVALID_VALUE, new Object[]{name, "name"}, element.xgetName());
        }
        if (ref != null) {
            if (element.getType() != null) {
                stscState.error(XmlErrorCodes.SCHEMA_ELEM$REF_FEATURES, new Object[]{"type"}, element.xgetType());
            }
            if (element.getSimpleType() != null) {
                stscState.error(XmlErrorCodes.SCHEMA_ELEM$REF_FEATURES, new Object[]{"<simpleType>"}, element.getSimpleType());
            }
            if (element.getComplexType() != null) {
                stscState.error(XmlErrorCodes.SCHEMA_ELEM$REF_FEATURES, new Object[]{"<complexType>"}, element.getComplexType());
            }
            if (element.getForm() != null) {
                stscState.error(XmlErrorCodes.SCHEMA_ELEM$REF_FEATURES, new Object[]{"form"}, element.xgetForm());
            }
            if (element.sizeOfKeyArray() > 0) {
                stscState.warning(XmlErrorCodes.SCHEMA_ELEM$REF_FEATURES, new Object[]{"<key>"}, element);
            }
            if (element.sizeOfKeyrefArray() > 0) {
                stscState.warning(XmlErrorCodes.SCHEMA_ELEM$REF_FEATURES, new Object[]{"<keyref>"}, element);
            }
            if (element.sizeOfUniqueArray() > 0) {
                stscState.warning(XmlErrorCodes.SCHEMA_ELEM$REF_FEATURES, new Object[]{"<unique>"}, element);
            }
            if (element.isSetDefault()) {
                stscState.warning(XmlErrorCodes.SCHEMA_ELEM$REF_FEATURES, new Object[]{"default"}, element.xgetDefault());
            }
            if (element.isSetFixed()) {
                stscState.warning(XmlErrorCodes.SCHEMA_ELEM$REF_FEATURES, new Object[]{"fixed"}, element.xgetFixed());
            }
            if (element.isSetBlock()) {
                stscState.warning(XmlErrorCodes.SCHEMA_ELEM$REF_FEATURES, new Object[]{"block"}, element.xgetBlock());
            }
            if (element.isSetNillable()) {
                stscState.warning(XmlErrorCodes.SCHEMA_ELEM$REF_FEATURES, new Object[]{"nillable"}, element.xgetNillable());
            }
            SchemaGlobalElementImpl schemaGlobalElementImplFindGlobalElement = stscState.findGlobalElement(ref, z6 ? str : null, str);
            if (schemaGlobalElementImplFindGlobalElement == null) {
                stscState.notFoundError(ref, 1, element.xgetRef(), true);
                return null;
            }
            SchemaLocalElementImpl schemaLocalElementImpl2 = new SchemaLocalElementImpl();
            schemaLocalElementImpl2.setParticleType(4);
            schemaLocalElementImpl2.setUserData(getUserData(element));
            copyGlobalElementToLocalElement(schemaGlobalElementImplFindGlobalElement, schemaLocalElementImpl2);
            return schemaLocalElementImpl2;
        }
        if (element instanceof LocalElement) {
            SchemaLocalElementImpl schemaLocalElementImpl3 = new SchemaLocalElementImpl();
            FormChoice formChoiceXgetForm = element.xgetForm();
            if (formChoiceXgetForm != null) {
                zEquals = formChoiceXgetForm.getStringValue().equals(FORM_QUALIFIED);
            } else if (str2 != null) {
                zEquals = str2.equals(FORM_QUALIFIED);
            } else {
                FormChoice formChoiceFindElementFormDefault = findElementFormDefault(element);
                zEquals = formChoiceFindElementFormDefault != null && formChoiceFindElementFormDefault.getStringValue().equals(FORM_QUALIFIED);
            }
            if (zEquals) {
                qNameForLNS = QNameHelper.forLNS(name, str);
                schemaLocalElementImpl = schemaLocalElementImpl3;
            } else {
                qNameForLNS = QNameHelper.forLN(name);
                schemaLocalElementImpl = schemaLocalElementImpl3;
            }
        } else {
            SchemaGlobalElementImpl schemaGlobalElementImpl = new SchemaGlobalElementImpl(stscState.getContainer(str));
            if (schemaTypeImpl != null) {
                SchemaGlobalElementImpl schemaGlobalElementImplFindGlobalElement2 = stscState.findGlobalElement(element.getSubstitutionGroup(), z6 ? str : null, str);
                if (schemaGlobalElementImplFindGlobalElement2 != null) {
                    schemaGlobalElementImpl.setSubstitutionGroup(schemaGlobalElementImplFindGlobalElement2.getRef());
                }
            }
            qNameForLNS = QNameHelper.forLNS(name, str);
            QName[] substitutionGroupMembers = ((SchemaTypeImpl) schemaType).getSubstitutionGroupMembers();
            QNameSetBuilder qNameSetBuilder = new QNameSetBuilder();
            qNameSetBuilder.add(qNameForLNS);
            for (QName qName : substitutionGroupMembers) {
                schemaGlobalElementImpl.addSubstitutionGroupMember(qName);
                qNameSetBuilder.add(qName);
            }
            schemaGlobalElementImpl.setTransitionRules(QNameSet.forSpecification(qNameSetBuilder), false);
            schemaGlobalElementImpl.setTransitionNotes(QNameSet.EMPTY, true);
            Object obj = element.getFinal();
            if (obj == null) {
                z7 = false;
                zContains = false;
            } else if ((obj instanceof String) && obj.equals("#all")) {
                z7 = true;
                zContains = true;
            } else if (obj instanceof List) {
                List list2 = (List) obj;
                zContains = list2.contains("extension");
                z7 = list2.contains("restriction");
            } else {
                z7 = false;
                zContains = false;
            }
            schemaGlobalElementImpl.setFinal(zContains, z7);
            schemaGlobalElementImpl.setAbstract(element.getAbstract());
            schemaGlobalElementImpl.setFilename(findFilename(element));
            schemaGlobalElementImpl.setParseContext(element, str, z6);
            schemaLocalElementImpl = schemaGlobalElementImpl;
        }
        QName qName2 = qNameForLNS;
        SchemaLocalElementImpl schemaLocalElementImpl4 = schemaLocalElementImpl;
        schemaLocalElementImpl4.setAnnotation(SchemaAnnotationImpl.getAnnotation(stscState.getContainer(str), element));
        schemaLocalElementImpl4.setUserData(getUserData(element));
        if (element.getType() != null) {
            SchemaTypeImpl schemaTypeImplFindGlobalType = stscState.findGlobalType(element.getType(), z6 ? str : null, str);
            if (schemaTypeImplFindGlobalType == null) {
                z8 = false;
                stscState.notFoundError(element.getType(), 0, element.xgetType(), true);
                schemaTypeCheckRecursiveGroupReference = schemaTypeImplFindGlobalType;
            } else {
                z8 = false;
                schemaTypeCheckRecursiveGroupReference = schemaTypeImplFindGlobalType;
            }
        } else {
            z8 = false;
            schemaTypeCheckRecursiveGroupReference = null;
        }
        Annotated complexType = element.getComplexType();
        if (complexType == null) {
            complexType = element.getSimpleType();
            z9 = true;
        } else {
            z9 = z8;
        }
        if (schemaTypeCheckRecursiveGroupReference != null && complexType != null) {
            stscState.error(XmlErrorCodes.SCHEMA_ELEM$TYPE_ATTR_OR_NESTED_TYPE, (Object[]) null, complexType);
            complexType = null;
        }
        if (complexType != null) {
            SchemaComponent[] currentProcessing = stscState.getCurrentProcessing();
            int length = currentProcessing.length;
            QName[] qNameArr = new QName[length];
            int i5 = 0;
            while (i5 < length) {
                int i6 = i5;
                SchemaComponent schemaComponent = currentProcessing[i6];
                Annotated annotated = complexType;
                if (schemaComponent instanceof SchemaModelGroupImpl) {
                    qNameArr[i6] = ((SchemaModelGroupImpl) schemaComponent).getName();
                }
                i5 = i6 + 1;
                complexType = annotated;
            }
            Annotated annotated2 = complexType;
            schemaTypeCheckRecursiveGroupReference = checkRecursiveGroupReference(qNameArr, qName2, (SchemaTypeImpl) schemaType);
            if (schemaTypeCheckRecursiveGroupReference != null) {
                z10 = false;
                type = schemaTypeCheckRecursiveGroupReference;
            } else {
                SchemaTypeImpl schemaTypeImpl2 = new SchemaTypeImpl(stscState.getContainer(str));
                schemaTypeImpl2.setContainerField(schemaLocalElementImpl4);
                schemaTypeImpl2.setOuterSchemaTypeRef(schemaType == null ? null : schemaType.getRef());
                schemaTypeImpl2.setGroupReferenceContext(qNameArr);
                list.add(schemaTypeImpl2);
                schemaTypeImpl2.setSimpleType(z9);
                z10 = false;
                schemaTypeImpl2.setParseContext(annotated2, str, z6, str2, str3, false);
                schemaTypeImpl2.setAnnotation(SchemaAnnotationImpl.getAnnotation(stscState.getContainer(str), annotated2));
                schemaTypeImpl2.setUserData(getUserData(annotated2));
                type = schemaTypeImpl2;
            }
        } else {
            z10 = false;
            type = schemaTypeCheckRecursiveGroupReference;
        }
        if (type == null && schemaTypeImpl != null) {
            SchemaGlobalElementImpl schemaGlobalElementImplFindGlobalElement3 = stscState.findGlobalElement(element.getSubstitutionGroup(), z6 ? str : null, str);
            if (schemaGlobalElementImplFindGlobalElement3 != null) {
                type = schemaGlobalElementImplFindGlobalElement3.getType();
            }
        }
        if (type == null) {
            type = BuiltinSchemaTypeSystem.ST_ANY_TYPE;
        }
        XmlCursor xmlCursorNewCursor = element.newCursor();
        try {
            String attributeText = xmlCursorNewCursor.getAttributeText(WSDL_ARRAYTYPE_NAME);
            xmlCursorNewCursor.close();
            if (attributeText != null) {
                try {
                    sOAPArrayType = new SOAPArrayType(attributeText, new NamespaceContext(element));
                } catch (XmlValueOutOfRangeException unused) {
                    stscState.error(XmlErrorCodes.SOAPARRAY, new Object[]{attributeText}, element);
                    sOAPArrayType = null;
                }
            } else {
                sOAPArrayType = null;
            }
            schemaLocalElementImpl4.setWsdlArrayType(sOAPArrayType);
            boolean zIsSetFixed = element.isSetFixed();
            if (element.isSetDefault() && zIsSetFixed) {
                stscState.error(XmlErrorCodes.SCHEMA_ELEM$DEFAULT_OR_FIXED, (Object[]) null, element.xgetFixed());
                zIsSetFixed = z10;
            }
            schemaLocalElementImpl4.setParticleType(4);
            schemaLocalElementImpl4.setNameAndTypeRef(qName2, type.getRef());
            schemaLocalElementImpl4.setNillable(element.getNillable());
            schemaLocalElementImpl4.setDefault(zIsSetFixed ? element.getFixed() : element.getDefault(), zIsSetFixed, element);
            Object block = element.getBlock();
            if (block == null) {
                z11 = z10;
                zContains2 = z11;
                zContains3 = zContains2;
            } else if ((block instanceof String) && block.equals("#all")) {
                z11 = true;
                zContains2 = true;
                zContains3 = true;
            } else if (block instanceof List) {
                List list3 = (List) block;
                zContains3 = list3.contains("extension");
                zContains2 = list3.contains("restriction");
                z11 = list3.contains("substitution") ? true : z10;
            } else {
                z11 = z10;
                zContains2 = z11;
                zContains3 = zContains2;
            }
            schemaLocalElementImpl4.setBlock(zContains3, zContains2, z11);
            int iSizeOfUniqueArray = element.sizeOfUniqueArray() + element.sizeOfKeyrefArray() + element.sizeOfKeyArray();
            SchemaIdentityConstraintImpl[] schemaIdentityConstraintImplArr = new SchemaIdentityConstraintImpl[iSizeOfUniqueArray];
            Keybase[] keyArray = element.getKeyArray();
            boolean z12 = z10;
            boolean z13 = z12;
            boolean z14 = z13;
            ?? r6 = z12;
            ?? r7 = z13;
            while (r6 < keyArray.length) {
                SchemaIdentityConstraintImpl schemaIdentityConstraintImplTranslateIdentityConstraint = translateIdentityConstraint(keyArray[r6], str, z6);
                schemaIdentityConstraintImplArr[r7] = schemaIdentityConstraintImplTranslateIdentityConstraint;
                if (schemaIdentityConstraintImplTranslateIdentityConstraint != null) {
                    schemaIdentityConstraintImplTranslateIdentityConstraint.setConstraintCategory(1);
                } else {
                    z14 = true;
                }
                r6++;
                r7++;
                z14 = z14;
            }
            Keybase[] uniqueArray = element.getUniqueArray();
            ?? r8 = z10;
            ?? r9 = r7;
            boolean z15 = z14;
            while (r8 < uniqueArray.length) {
                SchemaIdentityConstraintImpl schemaIdentityConstraintImplTranslateIdentityConstraint2 = translateIdentityConstraint(uniqueArray[r8], str, z6);
                schemaIdentityConstraintImplArr[r9] = schemaIdentityConstraintImplTranslateIdentityConstraint2;
                if (schemaIdentityConstraintImplTranslateIdentityConstraint2 != null) {
                    schemaIdentityConstraintImplTranslateIdentityConstraint2.setConstraintCategory(3);
                } else {
                    z15 = true;
                }
                r8++;
                r9++;
                z15 = z15;
            }
            KeyrefDocument.Keyref[] keyrefArray = element.getKeyrefArray();
            ?? r10 = r9;
            boolean z16 = z15 ? 1 : 0;
            ?? r11 = z10;
            while (r11 < keyrefArray.length) {
                SchemaIdentityConstraintImpl schemaIdentityConstraintImplTranslateIdentityConstraint3 = translateIdentityConstraint(keyrefArray[r11], str, z6);
                schemaIdentityConstraintImplArr[r10] = schemaIdentityConstraintImplTranslateIdentityConstraint3;
                if (schemaIdentityConstraintImplTranslateIdentityConstraint3 != null) {
                    schemaIdentityConstraintImplTranslateIdentityConstraint3.setConstraintCategory(2);
                } else {
                    z16 = true;
                }
                r10++;
                r11++;
                z16 = z16;
            }
            if (!z16) {
                SchemaIdentityConstraint.Ref[] refArr = new SchemaIdentityConstraint.Ref[iSizeOfUniqueArray];
                for (int i7 = z10; i7 < iSizeOfUniqueArray; i7++) {
                    refArr[i7] = schemaIdentityConstraintImplArr[i7].getRef();
                }
                schemaLocalElementImpl4.setIdentityConstraints(refArr);
            }
            return schemaLocalElementImpl4;
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

    private static SchemaTypeImpl translateGlobalComplexType(TopLevelComplexType topLevelComplexType, String str, boolean z6, boolean z7) {
        StscState stscState = StscState.get();
        String name = topLevelComplexType.getName();
        if (name == null) {
            stscState.error(XmlErrorCodes.MISSING_NAME, new Object[]{"global type"}, topLevelComplexType);
            return null;
        }
        if (!XMLChar.isValidNCName(name)) {
            stscState.error(XmlErrorCodes.INVALID_VALUE, new Object[]{name, "name"}, topLevelComplexType.xgetName());
        }
        QName qNameForLNS = QNameHelper.forLNS(name, str);
        if (isReservedTypeName(qNameForLNS)) {
            stscState.warning(XmlErrorCodes.RESERVED_TYPE_NAME, new Object[]{QNameHelper.pretty(qNameForLNS)}, topLevelComplexType);
            return null;
        }
        SchemaTypeImpl schemaTypeImpl = new SchemaTypeImpl(stscState.getContainer(str));
        schemaTypeImpl.setParseContext(topLevelComplexType, str, z6, null, null, z7);
        schemaTypeImpl.setFilename(findFilename(topLevelComplexType));
        schemaTypeImpl.setName(QNameHelper.forLNS(name, str));
        schemaTypeImpl.setAnnotation(SchemaAnnotationImpl.getAnnotation(stscState.getContainer(str), topLevelComplexType));
        schemaTypeImpl.setUserData(getUserData(topLevelComplexType));
        return schemaTypeImpl;
    }

    private static SchemaTypeImpl translateGlobalSimpleType(TopLevelSimpleType topLevelSimpleType, String str, boolean z6, boolean z7) {
        StscState stscState = StscState.get();
        String name = topLevelSimpleType.getName();
        if (name == null) {
            stscState.error(XmlErrorCodes.MISSING_NAME, new Object[]{"global type"}, topLevelSimpleType);
            return null;
        }
        if (!XMLChar.isValidNCName(name)) {
            stscState.error(XmlErrorCodes.INVALID_VALUE, new Object[]{name, "name"}, topLevelSimpleType.xgetName());
        }
        QName qNameForLNS = QNameHelper.forLNS(name, str);
        if (isReservedTypeName(qNameForLNS)) {
            stscState.warning(XmlErrorCodes.RESERVED_TYPE_NAME, new Object[]{QNameHelper.pretty(qNameForLNS)}, topLevelSimpleType);
            return null;
        }
        SchemaTypeImpl schemaTypeImpl = new SchemaTypeImpl(stscState.getContainer(str));
        schemaTypeImpl.setSimpleType(true);
        schemaTypeImpl.setParseContext(topLevelSimpleType, str, z6, null, null, z7);
        schemaTypeImpl.setFilename(findFilename(topLevelSimpleType));
        schemaTypeImpl.setName(qNameForLNS);
        schemaTypeImpl.setAnnotation(SchemaAnnotationImpl.getAnnotation(stscState.getContainer(str), topLevelSimpleType));
        schemaTypeImpl.setUserData(getUserData(topLevelSimpleType));
        return schemaTypeImpl;
    }

    private static SchemaIdentityConstraintImpl translateIdentityConstraint(Keybase keybase, String str, boolean z6) {
        StscState stscState = StscState.get();
        String xpath = keybase.getSelector() == null ? null : keybase.getSelector().getXpath();
        if (!checkXPathSyntax(xpath)) {
            stscState.error(XmlErrorCodes.SELECTOR_XPATH, new Object[]{xpath}, keybase.getSelector().xgetXpath());
            return null;
        }
        FieldDocument.Field[] fieldArray = keybase.getFieldArray();
        for (FieldDocument.Field field : fieldArray) {
            if (!checkXPathSyntax(field.getXpath())) {
                stscState.error(XmlErrorCodes.FIELDS_XPATH, new Object[]{field.getXpath()}, field.xgetXpath());
                return null;
            }
        }
        SchemaIdentityConstraintImpl schemaIdentityConstraintImpl = new SchemaIdentityConstraintImpl(stscState.getContainer(str));
        schemaIdentityConstraintImpl.setName(QNameHelper.forLNS(keybase.getName(), str));
        schemaIdentityConstraintImpl.setSelector(keybase.getSelector().getXpath());
        schemaIdentityConstraintImpl.setParseContext(keybase, str, z6);
        schemaIdentityConstraintImpl.setAnnotation(SchemaAnnotationImpl.getAnnotation(stscState.getContainer(str), keybase));
        schemaIdentityConstraintImpl.setUserData(getUserData(keybase));
        HashMap map = new HashMap();
        XmlCursor xmlCursorNewCursor = keybase.newCursor();
        try {
            xmlCursorNewCursor.getAllNamespaces(map);
            xmlCursorNewCursor.close();
            map.remove("");
            schemaIdentityConstraintImpl.setNSMap(map);
            int length = fieldArray.length;
            String[] strArr = new String[length];
            for (int i5 = 0; i5 < length; i5++) {
                strArr[i5] = fieldArray[i5].getXpath();
            }
            schemaIdentityConstraintImpl.setFields(strArr);
            try {
                schemaIdentityConstraintImpl.buildPaths();
                stscState.addIdConstraint(schemaIdentityConstraintImpl);
                schemaIdentityConstraintImpl.setFilename(findFilename(keybase));
                return stscState.findIdConstraint(schemaIdentityConstraintImpl.getName(), str, null);
            } catch (XPath.XPathCompileException e) {
                stscState.error(XmlErrorCodes.INVALID_XPATH, new Object[]{e.getMessage()}, keybase);
                return null;
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

    public static SchemaModelGroupImpl translateModelGroup(NamedGroup namedGroup, String str, boolean z6, boolean z7) {
        String name = namedGroup.getName();
        if (name == null) {
            StscState.get().error(XmlErrorCodes.MISSING_NAME, new Object[]{"model group"}, namedGroup);
            return null;
        }
        SchemaContainer container = StscState.get().getContainer(str);
        SchemaModelGroupImpl schemaModelGroupImpl = new SchemaModelGroupImpl(container);
        SchemaAnnotationImpl annotation = SchemaAnnotationImpl.getAnnotation(container, namedGroup);
        FormChoice formChoiceFindElementFormDefault = findElementFormDefault(namedGroup);
        FormChoice formChoiceFindAttributeFormDefault = findAttributeFormDefault(namedGroup);
        schemaModelGroupImpl.init(QNameHelper.forLNS(name, str), str, z6, formChoiceFindElementFormDefault == null ? null : formChoiceFindElementFormDefault.getStringValue(), formChoiceFindAttributeFormDefault != null ? formChoiceFindAttributeFormDefault.getStringValue() : null, z7, namedGroup, annotation, getUserData(namedGroup));
        schemaModelGroupImpl.setFilename(findFilename(namedGroup));
        return schemaModelGroupImpl;
    }

    public static int translateUseCode(Attribute.Use use) {
        if (use == null) {
            return 2;
        }
        String stringValue = use.getStringValue();
        if (stringValue.equals("optional")) {
            return 2;
        }
        if (stringValue.equals("required")) {
            return 3;
        }
        return stringValue.equals("prohibited") ? 1 : 2;
    }

    public static boolean uriMatch(String str, String str2) {
        if (str == null) {
            return str2 == null || str2.equals("");
        }
        return str2 == null ? str.equals("") : str.equals(str2);
    }
}
