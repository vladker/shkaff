package org.apache.xmlbeans.impl.schema;

import A3.AbstractC0157z;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.xml.namespace.QName;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.xmlbeans.SchemaAttributeGroup;
import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaModelGroup;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoaderException;
import org.apache.xmlbeans.impl.common.NameUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
class SchemaTypePool {
    private boolean _started;
    private final SchemaTypeSystemImpl typeSystem;
    private final Map<String, SchemaComponent.Ref> _handlesToRefs = new LinkedHashMap();
    private final Map<SchemaComponent, String> _componentsToHandles = new LinkedHashMap();

    public SchemaTypePool(SchemaTypeSystemImpl schemaTypeSystemImpl) {
        this.typeSystem = schemaTypeSystemImpl;
    }

    private String addUniqueHandle(SchemaComponent schemaComponent, String str) {
        String lowerCase = str.toLowerCase(Locale.ROOT);
        int i5 = 2;
        String str2 = lowerCase;
        while (this._handlesToRefs.containsKey(str2)) {
            str2 = lowerCase + i5;
            i5++;
        }
        this._handlesToRefs.put(str2, schemaComponent.getComponentRef());
        this._componentsToHandles.put(schemaComponent, str2);
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$writeHandlePool$0(XsbReader xsbReader, SchemaComponent schemaComponent, String str) {
        xsbReader.writeString(str);
        xsbReader.writeShort(fileTypeFromComponentType(schemaComponent.getComponentType()));
    }

    public int fileTypeFromComponentType(int i5) {
        if (i5 == 0) {
            return 2;
        }
        if (i5 == 1) {
            return 3;
        }
        if (i5 == 3) {
            return 4;
        }
        if (i5 == 4) {
            return 7;
        }
        if (i5 == 5) {
            return 8;
        }
        if (i5 == 6) {
            return 6;
        }
        throw new IllegalStateException("Unexpected component type");
    }

    public String handleForAttribute(SchemaGlobalAttribute schemaGlobalAttribute) {
        if (schemaGlobalAttribute == null) {
            return null;
        }
        if (schemaGlobalAttribute.getTypeSystem() != this.typeSystem) {
            throw new IllegalArgumentException("Cannot supply handles for types from another type system");
        }
        String str = this._componentsToHandles.get(schemaGlobalAttribute);
        if (str != null) {
            return str;
        }
        return addUniqueHandle(schemaGlobalAttribute, NameUtil.upperCamelCase(schemaGlobalAttribute.getName().getLocalPart()) + "Attribute");
    }

    public String handleForAttributeGroup(SchemaAttributeGroup schemaAttributeGroup) {
        if (schemaAttributeGroup == null) {
            return null;
        }
        if (schemaAttributeGroup.getTypeSystem() != this.typeSystem) {
            throw new IllegalArgumentException("Cannot supply handles for types from another type system");
        }
        String str = this._componentsToHandles.get(schemaAttributeGroup);
        if (str != null) {
            return str;
        }
        return addUniqueHandle(schemaAttributeGroup, NameUtil.upperCamelCase(schemaAttributeGroup.getName().getLocalPart()) + "AttributeGroup");
    }

    public String handleForComponent(SchemaComponent schemaComponent) {
        if (schemaComponent == null) {
            return null;
        }
        if (schemaComponent.getTypeSystem() != this.typeSystem) {
            throw new IllegalArgumentException("Cannot supply handles for types from another type system");
        }
        if (schemaComponent instanceof SchemaType) {
            return handleForType((SchemaType) schemaComponent);
        }
        if (schemaComponent instanceof SchemaGlobalElement) {
            return handleForElement((SchemaGlobalElement) schemaComponent);
        }
        if (schemaComponent instanceof SchemaGlobalAttribute) {
            return handleForAttribute((SchemaGlobalAttribute) schemaComponent);
        }
        if (schemaComponent instanceof SchemaModelGroup) {
            return handleForModelGroup((SchemaModelGroup) schemaComponent);
        }
        if (schemaComponent instanceof SchemaAttributeGroup) {
            return handleForAttributeGroup((SchemaAttributeGroup) schemaComponent);
        }
        if (schemaComponent instanceof SchemaIdentityConstraint) {
            return handleForIdentityConstraint((SchemaIdentityConstraint) schemaComponent);
        }
        throw new IllegalStateException("Component type cannot have a handle");
    }

    public String handleForElement(SchemaGlobalElement schemaGlobalElement) {
        if (schemaGlobalElement == null) {
            return null;
        }
        if (schemaGlobalElement.getTypeSystem() != this.typeSystem) {
            throw new IllegalArgumentException("Cannot supply handles for types from another type system");
        }
        String str = this._componentsToHandles.get(schemaGlobalElement);
        if (str != null) {
            return str;
        }
        return addUniqueHandle(schemaGlobalElement, NameUtil.upperCamelCase(schemaGlobalElement.getName().getLocalPart()) + "Element");
    }

    public String handleForIdentityConstraint(SchemaIdentityConstraint schemaIdentityConstraint) {
        if (schemaIdentityConstraint == null) {
            return null;
        }
        if (schemaIdentityConstraint.getTypeSystem() != this.typeSystem) {
            throw new IllegalArgumentException("Cannot supply handles for types from another type system");
        }
        String str = this._componentsToHandles.get(schemaIdentityConstraint);
        if (str != null) {
            return str;
        }
        return addUniqueHandle(schemaIdentityConstraint, NameUtil.upperCamelCase(schemaIdentityConstraint.getName().getLocalPart()) + "IdentityConstraint");
    }

    public String handleForModelGroup(SchemaModelGroup schemaModelGroup) {
        if (schemaModelGroup == null) {
            return null;
        }
        if (schemaModelGroup.getTypeSystem() != this.typeSystem) {
            throw new IllegalArgumentException("Cannot supply handles for types from another type system");
        }
        String str = this._componentsToHandles.get(schemaModelGroup);
        if (str != null) {
            return str;
        }
        return addUniqueHandle(schemaModelGroup, NameUtil.upperCamelCase(schemaModelGroup.getName().getLocalPart()) + "ModelGroup");
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0054  */
    public String handleForType(SchemaType schemaType) {
        String str;
        String strO;
        if (schemaType == null) {
            return null;
        }
        if (schemaType.getTypeSystem() != this.typeSystem) {
            throw new IllegalArgumentException("Cannot supply handles for types from another type system");
        }
        String str2 = this._componentsToHandles.get(schemaType);
        if (str2 != null) {
            return str2;
        }
        QName name = schemaType.getName();
        if (name != null) {
            str = "";
        } else if (schemaType.isDocumentType()) {
            name = schemaType.getDocumentElementName();
            str = "Doc";
        } else if (schemaType.isAttributeType()) {
            name = schemaType.getAttributeTypeAttributeName();
            str = "AttrType";
        } else if (schemaType.getContainerField() != null) {
            name = schemaType.getContainerField().getName();
            str = schemaType.getContainerField().isAttribute() ? "Attr" : "Elem";
        } else {
            str = "";
        }
        String upperCase = Integer.toHexString(schemaType.toString().hashCode() | Integer.MIN_VALUE).substring(4).toUpperCase(Locale.ROOT);
        if (name == null) {
            strO = AbstractC0157z.o("Anon", upperCase, PackageRelationship.TYPE_ATTRIBUTE_NAME);
        } else {
            strO = NameUtil.upperCamelCase(name.getLocalPart()) + upperCase + str + PackageRelationship.TYPE_ATTRIBUTE_NAME;
        }
        return addUniqueHandle(schemaType, strO);
    }

    public void readHandlePool(XsbReader xsbReader) {
        SchemaComponent.Ref ref;
        if (this._handlesToRefs.size() != 0 || this._started) {
            throw new IllegalStateException("Nonempty handle set before read");
        }
        int i5 = xsbReader.readShort();
        for (int i6 = 0; i6 < i5; i6++) {
            String string = xsbReader.readString();
            int i7 = xsbReader.readShort();
            if (i7 == 2) {
                ref = new SchemaType.Ref(this.typeSystem, string);
            } else if (i7 == 3) {
                ref = new SchemaGlobalElement.Ref(this.typeSystem, string);
            } else if (i7 == 4) {
                ref = new SchemaGlobalAttribute.Ref(this.typeSystem, string);
            } else if (i7 == 6) {
                ref = new SchemaModelGroup.Ref(this.typeSystem, string);
            } else if (i7 == 7) {
                ref = new SchemaAttributeGroup.Ref(this.typeSystem, string);
            } else {
                if (i7 != 8) {
                    throw new SchemaTypeLoaderException(AbstractC0157z.k(i7, "Schema index has an unrecognized entry of type "), this.typeSystem.getName(), string, 5);
                }
                ref = new SchemaIdentityConstraint.Ref(this.typeSystem, string);
            }
            this._handlesToRefs.put(string, ref);
        }
    }

    public SchemaComponent.Ref refForHandle(String str) {
        if (str == null) {
            return null;
        }
        return this._handlesToRefs.get(str);
    }

    public void startWriteMode() {
        this._started = true;
        this._componentsToHandles.clear();
        for (String str : this._handlesToRefs.keySet()) {
            this._componentsToHandles.put(this._handlesToRefs.get(str).getComponent(), str);
        }
    }

    public void writeHandlePool(XsbReader xsbReader) {
        xsbReader.writeShort(this._componentsToHandles.size());
        this._componentsToHandles.forEach(new e(this, xsbReader, 0));
    }
}
