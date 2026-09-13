package org.apache.xmlbeans.impl.schema;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaParticle;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
import org.apache.xmlbeans.impl.xb.xsdschema.Element;
import org.apache.xmlbeans.impl.xb.xsdschema.KeyrefDocument;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class StscResolver {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SchemaType.Ref[] lambda$makeRefArray$0(int i5) {
        return new SchemaType.Ref[i5];
    }

    private static SchemaType.Ref[] makeRefArray(Collection<SchemaType> collection) {
        return (SchemaType.Ref[]) collection.stream().map(new m(1)).toArray(new f(12));
    }

    public static void resolveAll() {
        StscState stscState = StscState.get();
        for (SchemaType schemaType : stscState.documentTypes()) {
            resolveSubstitutionGroup((SchemaTypeImpl) schemaType);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(stscState.documentTypes()));
        arrayList.addAll(Arrays.asList(stscState.attributeTypes()));
        arrayList.addAll(Arrays.asList(stscState.redefinedGlobalTypes()));
        arrayList.addAll(Arrays.asList(stscState.globalTypes()));
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            SchemaType schemaType2 = (SchemaType) arrayList.get(i5);
            resolveType((SchemaTypeImpl) schemaType2);
            arrayList.addAll(Arrays.asList(schemaType2.getAnonymousTypes()));
        }
        resolveIdentityConstraints();
    }

    public static void resolveAttributeType(SchemaTypeImpl schemaTypeImpl) {
        ArrayList arrayList = new ArrayList();
        SchemaGlobalAttributeImpl schemaGlobalAttributeImpl = (SchemaGlobalAttributeImpl) StscTranslator.translateAttribute((Attribute) schemaTypeImpl.getParseObject(), schemaTypeImpl.getTargetNamespace(), null, schemaTypeImpl.isChameleon(), arrayList, schemaTypeImpl, null, false);
        SchemaAttributeModelImpl schemaAttributeModelImpl = new SchemaAttributeModelImpl();
        if (schemaGlobalAttributeImpl != null) {
            StscState.get().addGlobalAttribute(schemaGlobalAttributeImpl);
            SchemaLocalAttributeImpl schemaLocalAttributeImpl = new SchemaLocalAttributeImpl();
            StscTranslator.copyGlobalAttributeToLocalAttribute(schemaGlobalAttributeImpl, schemaLocalAttributeImpl);
            schemaAttributeModelImpl.addAttribute(schemaLocalAttributeImpl);
        }
        schemaTypeImpl.setBaseTypeRef(BuiltinSchemaTypeSystem.ST_ANY_TYPE.getRef());
        schemaTypeImpl.setBaseDepth(schemaTypeImpl.getBaseDepth() + 1);
        schemaTypeImpl.setDerivationType(1);
        schemaTypeImpl.setComplexTypeVariety(1);
        schemaTypeImpl.setContentModel(null, schemaAttributeModelImpl, Collections.EMPTY_MAP, StscComplexTypeResolver.buildAttributePropertyModelByQName(schemaAttributeModelImpl, schemaTypeImpl), false);
        QNameSet qNameSet = QNameSet.EMPTY;
        schemaTypeImpl.setWildcardSummary(qNameSet, false, qNameSet, false);
        schemaTypeImpl.setAnonymousTypeRefs(makeRefArray(arrayList));
    }

    public static void resolveDocumentType(SchemaTypeImpl schemaTypeImpl) {
        SchemaParticle schemaParticle;
        SchemaTypeImpl schemaTypeImplFindDocumentType;
        ArrayList arrayList = new ArrayList();
        SchemaGlobalElementImpl schemaGlobalElementImpl = (SchemaGlobalElementImpl) StscTranslator.translateElement((Element) schemaTypeImpl.getParseObject(), schemaTypeImpl.getTargetNamespace(), schemaTypeImpl.isChameleon(), null, null, arrayList, schemaTypeImpl);
        if (schemaGlobalElementImpl != null) {
            StscState.get().addGlobalElement(schemaGlobalElementImpl);
            SchemaLocalElementImpl schemaLocalElementImpl = new SchemaLocalElementImpl();
            schemaLocalElementImpl.setParticleType(4);
            StscTranslator.copyGlobalElementToLocalElement(schemaGlobalElementImpl, schemaLocalElementImpl);
            BigInteger bigInteger = BigInteger.ONE;
            schemaLocalElementImpl.setMinOccurs(bigInteger);
            schemaLocalElementImpl.setMaxOccurs(bigInteger);
            schemaLocalElementImpl.setTransitionNotes(QNameSet.EMPTY, true);
            schemaParticle = schemaLocalElementImpl;
        } else {
            schemaParticle = null;
        }
        Map<QName, SchemaProperty> mapBuildContentPropertyModelByQName = StscComplexTypeResolver.buildContentPropertyModelByQName(schemaParticle, schemaTypeImpl);
        if (schemaTypeImpl.getSubstitutionGroup() == null) {
            schemaTypeImplFindDocumentType = BuiltinSchemaTypeSystem.ST_ANY_TYPE;
        } else {
            schemaTypeImplFindDocumentType = StscState.get().findDocumentType(schemaTypeImpl.getSubstitutionGroup(), schemaTypeImpl.isChameleon() ? schemaTypeImpl.getTargetNamespace() : null, null);
        }
        schemaTypeImpl.setBaseTypeRef(schemaTypeImplFindDocumentType.getRef());
        schemaTypeImpl.setBaseDepth(schemaTypeImplFindDocumentType.getBaseDepth() + 1);
        schemaTypeImpl.setDerivationType(1);
        schemaTypeImpl.setComplexTypeVariety(3);
        schemaTypeImpl.setContentModel(schemaParticle, new SchemaAttributeModelImpl(), mapBuildContentPropertyModelByQName, Collections.EMPTY_MAP, false);
        QNameSet qNameSet = QNameSet.EMPTY;
        schemaTypeImpl.setWildcardSummary(qNameSet, false, qNameSet, false);
        schemaTypeImpl.setAnonymousTypeRefs(makeRefArray(arrayList));
    }

    public static void resolveIdentityConstraints() {
        StscState stscState = StscState.get();
        for (SchemaIdentityConstraintImpl schemaIdentityConstraintImpl : stscState.idConstraints()) {
            if (!schemaIdentityConstraintImpl.isResolved()) {
                KeyrefDocument.Keyref keyref = (KeyrefDocument.Keyref) schemaIdentityConstraintImpl.getParseObject();
                QName refer = keyref.getRefer();
                SchemaIdentityConstraintImpl schemaIdentityConstraintImplFindIdConstraint = stscState.findIdConstraint(refer, schemaIdentityConstraintImpl.getChameleonNamespace(), schemaIdentityConstraintImpl.getTargetNamespace());
                if (schemaIdentityConstraintImplFindIdConstraint == null) {
                    stscState.notFoundError(refer, 5, keyref, true);
                } else {
                    if (schemaIdentityConstraintImplFindIdConstraint.getConstraintCategory() == 2) {
                        stscState.error(XmlErrorCodes.IDENTITY_CONSTRAINT_PROPERTIES$KEYREF_REFERS_TO_KEYREF, (Object[]) null, schemaIdentityConstraintImpl.getParseObject());
                    }
                    if (schemaIdentityConstraintImplFindIdConstraint.getFields().length != schemaIdentityConstraintImpl.getFields().length) {
                        stscState.error(XmlErrorCodes.IDENTITY_CONSTRAINT_PROPERTIES$KEY_KEYREF_FIELD_COUNT_EQ, (Object[]) null, schemaIdentityConstraintImpl.getParseObject());
                    }
                    schemaIdentityConstraintImpl.setReferencedKey(schemaIdentityConstraintImplFindIdConstraint.getRef());
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0068  */
    /* JADX WARN: Code duplicated, block: B:19:0x0073  */
    /* JADX WARN: Code duplicated, block: B:22:0x007d  */
    /* JADX WARN: Code duplicated, block: B:27:0x0094 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:28:0x0094 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0068 -> B:18:0x0071). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:18:0x0071
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static boolean resolveSubstitutionGroup(org.apache.xmlbeans.impl.schema.SchemaTypeImpl r8) {
        /*
            boolean r0 = r8.isSGResolved()
            r1 = 1
            if (r0 == 0) goto L8
            return r1
        L8:
            boolean r0 = r8.isSGResolving()
            if (r0 == 0) goto L1f
            org.apache.xmlbeans.impl.schema.StscState r0 = org.apache.xmlbeans.impl.schema.StscState.get()
            r1 = 13
            org.apache.xmlbeans.XmlObject r8 = r8.getParseObject()
            java.lang.String r2 = "Cyclic dependency error"
            r0.error(r2, r1, r8)
            r8 = 0
            return r8
        L1f:
            r8.startResolvingSGs()
            org.apache.xmlbeans.XmlObject r0 = r8.getParseObject()
            org.apache.xmlbeans.impl.xb.xsdschema.TopLevelElement r0 = (org.apache.xmlbeans.impl.xb.xsdschema.TopLevelElement) r0
            javax.xml.namespace.QName r2 = new javax.xml.namespace.QName
            java.lang.String r3 = r8.getTargetNamespace()
            java.lang.String r4 = r0.getName()
            r2.<init>(r3, r4)
            boolean r3 = r0.isSetSubstitutionGroup()
            r4 = 0
            if (r3 == 0) goto L68
            org.apache.xmlbeans.impl.schema.StscState r3 = org.apache.xmlbeans.impl.schema.StscState.get()
            javax.xml.namespace.QName r5 = r0.getSubstitutionGroup()
            java.lang.String r6 = r8.getChameleonNamespace()
            java.lang.String r7 = r8.getTargetNamespace()
            org.apache.xmlbeans.impl.schema.SchemaTypeImpl r3 = r3.findDocumentType(r5, r6, r7)
            if (r3 != 0) goto L62
            org.apache.xmlbeans.impl.schema.StscState r5 = org.apache.xmlbeans.impl.schema.StscState.get()
            javax.xml.namespace.QName r6 = r0.getSubstitutionGroup()
            org.apache.xmlbeans.XmlQName r0 = r0.xgetSubstitutionGroup()
            r5.notFoundError(r6, r1, r0, r1)
            goto L71
        L62:
            boolean r5 = resolveSubstitutionGroup(r3)
            if (r5 != 0) goto L6a
        L68:
            r3 = r4
            goto L71
        L6a:
            javax.xml.namespace.QName r0 = r0.getSubstitutionGroup()
            r8.setSubstitutionGroup(r0)
        L71:
            if (r3 == 0) goto L94
            r3.addSubstitutionGroupMember(r2)
            javax.xml.namespace.QName r0 = r3.getSubstitutionGroup()
            if (r0 != 0) goto L7d
            goto L94
        L7d:
            org.apache.xmlbeans.impl.schema.StscState r0 = org.apache.xmlbeans.impl.schema.StscState.get()
            javax.xml.namespace.QName r5 = r3.getSubstitutionGroup()
            java.lang.String r3 = r3.getChameleonNamespace()
            org.apache.xmlbeans.impl.schema.SchemaTypeImpl r3 = r0.findDocumentType(r5, r3, r4)
            boolean r0 = resolveSubstitutionGroup(r3)
            if (r0 != 0) goto L71
            goto L68
        L94:
            r8.finishResolvingSGs()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.schema.StscResolver.resolveSubstitutionGroup(org.apache.xmlbeans.impl.schema.SchemaTypeImpl):boolean");
    }

    public static boolean resolveType(SchemaTypeImpl schemaTypeImpl) {
        if (schemaTypeImpl.isResolved()) {
            return true;
        }
        if (schemaTypeImpl.isResolving()) {
            StscState.get().error("Cyclic dependency error", 13, schemaTypeImpl.getParseObject());
            return false;
        }
        schemaTypeImpl.startResolving();
        if (schemaTypeImpl.isDocumentType()) {
            resolveDocumentType(schemaTypeImpl);
        } else if (schemaTypeImpl.isAttributeType()) {
            resolveAttributeType(schemaTypeImpl);
        } else if (schemaTypeImpl.isSimpleType()) {
            StscSimpleTypeResolver.resolveSimpleType(schemaTypeImpl);
        } else {
            StscComplexTypeResolver.resolveComplexType(schemaTypeImpl);
        }
        schemaTypeImpl.finishResolving();
        return true;
    }
}
