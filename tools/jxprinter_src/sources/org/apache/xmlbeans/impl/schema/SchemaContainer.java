package org.apache.xmlbeans.impl.schema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.xmlbeans.SchemaAnnotation;
import org.apache.xmlbeans.SchemaAttributeGroup;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaModelGroup;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeSystem;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
class SchemaContainer {
    boolean _immutable;
    private final String _namespace;
    private SchemaTypeSystem _typeSystem;
    private final List<SchemaGlobalElement.Ref> _globalElements = new ArrayList();
    private final List<SchemaGlobalAttribute.Ref> _globalAttributes = new ArrayList();
    private final List<SchemaModelGroup.Ref> _modelGroups = new ArrayList();
    private final List<SchemaModelGroup.Ref> _redefinedModelGroups = new ArrayList();
    private final List<SchemaAttributeGroup.Ref> _attributeGroups = new ArrayList();
    private final List<SchemaAttributeGroup.Ref> _redefinedAttributeGroups = new ArrayList();
    private final List<SchemaType.Ref> _globalTypes = new ArrayList();
    private final List<SchemaType.Ref> _redefinedGlobalTypes = new ArrayList();
    private final List<SchemaType.Ref> _documentTypes = new ArrayList();
    private final List<SchemaType.Ref> _attributeTypes = new ArrayList();
    private final List<SchemaIdentityConstraint.Ref> _identityConstraints = new ArrayList();
    private final List<SchemaAnnotation> _annotations = new ArrayList();

    public SchemaContainer(String str) {
        this._namespace = str;
    }

    private void check_immutable() {
        if (this._immutable) {
            throw new IllegalStateException("Cannot add components to immutable SchemaContainer");
        }
    }

    public void addAnnotation(SchemaAnnotation schemaAnnotation) {
        check_immutable();
        this._annotations.add(schemaAnnotation);
    }

    public void addAttributeGroup(SchemaAttributeGroup.Ref ref) {
        check_immutable();
        this._attributeGroups.add(ref);
    }

    public void addAttributeType(SchemaType.Ref ref) {
        check_immutable();
        this._attributeTypes.add(ref);
    }

    public void addDocumentType(SchemaType.Ref ref) {
        check_immutable();
        this._documentTypes.add(ref);
    }

    public void addGlobalAttribute(SchemaGlobalAttribute.Ref ref) {
        check_immutable();
        this._globalAttributes.add(ref);
    }

    public void addGlobalElement(SchemaGlobalElement.Ref ref) {
        check_immutable();
        this._globalElements.add(ref);
    }

    public void addGlobalType(SchemaType.Ref ref) {
        check_immutable();
        this._globalTypes.add(ref);
    }

    public void addIdentityConstraint(SchemaIdentityConstraint.Ref ref) {
        check_immutable();
        this._identityConstraints.add(ref);
    }

    public void addModelGroup(SchemaModelGroup.Ref ref) {
        check_immutable();
        this._modelGroups.add(ref);
    }

    public void addRedefinedAttributeGroup(SchemaAttributeGroup.Ref ref) {
        check_immutable();
        this._redefinedAttributeGroups.add(ref);
    }

    public void addRedefinedModelGroup(SchemaModelGroup.Ref ref) {
        check_immutable();
        this._redefinedModelGroups.add(ref);
    }

    public void addRedefinedType(SchemaType.Ref ref) {
        check_immutable();
        this._redefinedGlobalTypes.add(ref);
    }

    public List<SchemaAnnotation> annotations() {
        return Collections.unmodifiableList(this._annotations);
    }

    public List<SchemaAttributeGroup> attributeGroups() {
        return (List) this._attributeGroups.stream().map(new l(10)).collect(Collectors.toList());
    }

    public List<SchemaType> attributeTypes() {
        return (List) this._attributeTypes.stream().map(new l(8)).collect(Collectors.toList());
    }

    public List<SchemaType> documentTypes() {
        return (List) this._documentTypes.stream().map(new l(8)).collect(Collectors.toList());
    }

    public String getNamespace() {
        return this._namespace;
    }

    public synchronized SchemaTypeSystem getTypeSystem() {
        return this._typeSystem;
    }

    public List<SchemaGlobalAttribute> globalAttributes() {
        return (List) this._globalAttributes.stream().map(new l(12)).collect(Collectors.toList());
    }

    public List<SchemaGlobalElement> globalElements() {
        return (List) this._globalElements.stream().map(new l(13)).collect(Collectors.toList());
    }

    public List<SchemaType> globalTypes() {
        return (List) this._globalTypes.stream().map(new l(8)).collect(Collectors.toList());
    }

    public List<SchemaIdentityConstraint> identityConstraints() {
        return (List) this._identityConstraints.stream().map(new l(11)).collect(Collectors.toList());
    }

    public List<SchemaModelGroup> modelGroups() {
        return (List) this._modelGroups.stream().map(new l(9)).collect(Collectors.toList());
    }

    public List<SchemaAttributeGroup> redefinedAttributeGroups() {
        return (List) this._redefinedAttributeGroups.stream().map(new l(10)).collect(Collectors.toList());
    }

    public List<SchemaType> redefinedGlobalTypes() {
        return (List) this._redefinedGlobalTypes.stream().map(new l(8)).collect(Collectors.toList());
    }

    public List<SchemaModelGroup> redefinedModelGroups() {
        return (List) this._redefinedModelGroups.stream().map(new l(9)).collect(Collectors.toList());
    }

    public synchronized void setImmutable() {
        this._immutable = true;
    }

    public synchronized void setTypeSystem(SchemaTypeSystem schemaTypeSystem) {
        this._typeSystem = schemaTypeSystem;
    }

    public synchronized void unsetImmutable() {
        this._immutable = false;
    }
}
