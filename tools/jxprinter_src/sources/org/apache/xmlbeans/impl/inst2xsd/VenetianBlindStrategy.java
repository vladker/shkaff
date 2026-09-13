package org.apache.xmlbeans.impl.inst2xsd;

import A3.AbstractC0157z;
import javax.xml.namespace.QName;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.xmlbeans.impl.inst2xsd.util.Element;
import org.apache.xmlbeans.impl.inst2xsd.util.Type;
import org.apache.xmlbeans.impl.inst2xsd.util.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class VenetianBlindStrategy extends RussianDollStrategy implements XsdGenStrategy {
    private boolean compatibleTypes(Type type, Type type2) {
        return true;
    }

    @Override // org.apache.xmlbeans.impl.inst2xsd.RussianDollStrategy
    public void checkIfReferenceToGlobalTypeIsNeeded(Element element, TypeSystemHolder typeSystemHolder, Inst2XsdOptions inst2XsdOptions) {
        Type type = element.getType();
        QName name = element.getName();
        if (type.isGlobal() || !type.isComplexType()) {
            return;
        }
        int i5 = 0;
        while (true) {
            String namespaceURI = name.getNamespaceURI();
            StringBuilder sb = new StringBuilder();
            sb.append(name.getLocalPart());
            sb.append(PackageRelationship.TYPE_ATTRIBUTE_NAME);
            sb.append(i5 != 0 ? AbstractC0157z.k(i5, "") : "");
            type.setName(new QName(namespaceURI, sb.toString()));
            Type globalType = typeSystemHolder.getGlobalType(type.getName());
            if (globalType == null) {
                type.setGlobal(true);
                typeSystemHolder.addGlobalType(type);
                return;
            } else {
                if (compatibleTypes(globalType, type)) {
                    combineTypes(globalType, type, inst2XsdOptions);
                    element.setType(globalType);
                    return;
                }
                i5++;
            }
        }
    }
}
