package org.apache.xmlbeans;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamReader;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface SchemaTypeLoader {
    String compilePath(String str, XmlOptions xmlOptions);

    String compileQuery(String str, XmlOptions xmlOptions);

    SchemaGlobalAttribute findAttribute(QName qName);

    SchemaAttributeGroup findAttributeGroup(QName qName);

    SchemaAttributeGroup.Ref findAttributeGroupRef(QName qName);

    SchemaGlobalAttribute.Ref findAttributeRef(QName qName);

    SchemaType findAttributeType(QName qName);

    SchemaType.Ref findAttributeTypeRef(QName qName);

    SchemaType findDocumentType(QName qName);

    SchemaType.Ref findDocumentTypeRef(QName qName);

    SchemaGlobalElement findElement(QName qName);

    SchemaGlobalElement.Ref findElementRef(QName qName);

    SchemaIdentityConstraint.Ref findIdentityConstraintRef(QName qName);

    SchemaModelGroup findModelGroup(QName qName);

    SchemaModelGroup.Ref findModelGroupRef(QName qName);

    SchemaType findType(QName qName);

    SchemaType.Ref findTypeRef(QName qName);

    InputStream getSourceAsStream(String str);

    boolean isNamespaceDefined(String str);

    DOMImplementation newDomImplementation(XmlOptions xmlOptions);

    XmlObject newInstance(SchemaType schemaType, XmlOptions xmlOptions);

    XmlSaxHandler newXmlSaxHandler(SchemaType schemaType, XmlOptions xmlOptions);

    XmlObject parse(File file, SchemaType schemaType, XmlOptions xmlOptions);

    XmlObject parse(InputStream inputStream, SchemaType schemaType, XmlOptions xmlOptions);

    XmlObject parse(Reader reader, SchemaType schemaType, XmlOptions xmlOptions);

    XmlObject parse(String str, SchemaType schemaType, XmlOptions xmlOptions);

    XmlObject parse(URL url, SchemaType schemaType, XmlOptions xmlOptions);

    XmlObject parse(XMLStreamReader xMLStreamReader, SchemaType schemaType, XmlOptions xmlOptions);

    XmlObject parse(Node node, SchemaType schemaType, XmlOptions xmlOptions);

    SchemaType typeForClassname(String str);

    SchemaType typeForSignature(String str);
}
