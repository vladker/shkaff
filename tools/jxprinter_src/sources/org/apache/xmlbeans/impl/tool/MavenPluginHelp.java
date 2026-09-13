package org.apache.xmlbeans.impl.tool;

import A3.AbstractC0157z;
import androidx.exifinterface.media.ExifInterface;
import io.flutter.plugins.firebase.analytics.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.geometry.VectorFormat;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.logging.log4j.util.Chars;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.DocumentHelper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
@Mojo(name = "help", requiresProject = false, threadSafe = true)
public class MavenPluginHelp extends AbstractMojo {
    private static final int DEFAULT_LINE_LENGTH = 80;
    private static final String PLUGIN_HELP_PATH = "/META-INF/maven/plugin.xml";

    @Parameter(defaultValue = "false", property = "detail")
    private boolean detail;

    @Parameter(property = "goal")
    private String goal;

    @Parameter(defaultValue = ExifInterface.GPS_MEASUREMENT_2D, property = "indentSize")
    private int indentSize;

    @Parameter(defaultValue = "80", property = "lineLength")
    private int lineLength;

    private void append(StringBuilder sb, String str, int i5) {
        Iterator<String> it = toLines(str, i5, this.indentSize, this.lineLength).iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append('\n');
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.maven.plugin.MojoExecutionException */
    private Document build() throws MojoExecutionException {
        getLog().debug("load plugin-help.xml: /META-INF/maven/plugin.xml");
        try {
            InputStream resourceAsStream = getClass().getResourceAsStream(PLUGIN_HELP_PATH);
            try {
                Document document = DocumentHelper.readDocument(new XmlOptions(), resourceAsStream);
                if (resourceAsStream == null) {
                    return document;
                }
                resourceAsStream.close();
                return document;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (resourceAsStream != null) {
                        try {
                            resourceAsStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        } catch (IOException | SAXException e) {
            throw new MojoExecutionException(e.getMessage(), e);
        }
    }

    private List<Node> findNamedChild(Node node, String str) {
        ArrayList arrayList = new ArrayList();
        NodeList childNodes = node.getChildNodes();
        for (int i5 = 0; i5 < childNodes.getLength(); i5++) {
            Node nodeItem = childNodes.item(i5);
            if (str.equals(nodeItem.getNodeName())) {
                arrayList.add(nodeItem);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.maven.plugin.MojoExecutionException */
    private Node findSingleChild(Node node, String str) throws MojoExecutionException {
        List<Node> listFindNamedChild = findNamedChild(node, str);
        if (listFindNamedChild.isEmpty()) {
            return null;
        }
        if (listFindNamedChild.size() <= 1) {
            return listFindNamedChild.get(0);
        }
        throw new MojoExecutionException(AbstractC0157z.o("Multiple ", str, "in plugin.xml"));
    }

    private static int getIndentLevel(String str) {
        int i5 = 0;
        for (int i6 = 0; i6 < str.length() && str.charAt(i6) == '\t'; i6++) {
            i5++;
        }
        int i7 = i5 + 1;
        for (int i8 = i7; i8 <= i5 + 4 && i8 < str.length(); i8++) {
            if (str.charAt(i8) == '\t') {
                return i7;
            }
        }
        return i5;
    }

    private String getPropertyFromExpression(String str) {
        if (str == null || !str.startsWith("${") || !str.endsWith(VectorFormat.DEFAULT_SUFFIX) || str.substring(2).contains("${")) {
            return null;
        }
        return androidx.collection.a.g(1, 2, str);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.maven.plugin.MojoExecutionException */
    private Node getSingleChild(Node node, String str) throws MojoExecutionException {
        List<Node> listFindNamedChild = findNamedChild(node, str);
        if (listFindNamedChild.isEmpty()) {
            throw new MojoExecutionException(AbstractC0157z.o("Could not find ", str, " in plugin.xml"));
        }
        if (listFindNamedChild.size() <= 1) {
            return listFindNamedChild.get(0);
        }
        throw new MojoExecutionException(AbstractC0157z.o("Multiple ", str, " in plugin.xml"));
    }

    private String getValue(Node node, String str) {
        return getSingleChild(node, str).getTextContent();
    }

    private static boolean isNotEmpty(String str) {
        return str != null && str.length() > 0;
    }

    private static String repeat(String str, int i5) {
        StringBuilder sb = new StringBuilder(str.length() * i5);
        for (int i6 = 0; i6 < i5; i6++) {
            sb.append(str);
        }
        return sb.toString();
    }

    private static List<String> toLines(String str, int i5, int i6, int i7) {
        ArrayList arrayList = new ArrayList();
        String strRepeat = repeat("\t", i5);
        for (String str2 : str.split("(\r\n)|(\r)|(\n)")) {
            toLines(arrayList, androidx.collection.a.n(strRepeat, str2), i6, i7);
        }
        return arrayList;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.maven.plugin.MojoExecutionException */
    private void writeGoal(StringBuilder sb, String str, Element element) throws MojoExecutionException {
        String value = getValue(element, "goal");
        Node nodeFindSingleChild = findSingleChild(element, "configuration");
        Node nodeFindSingleChild2 = findSingleChild(element, "description");
        String str2 = this.goal;
        if (str2 == null || str2.length() <= 0 || value.equals(this.goal)) {
            append(sb, androidx.collection.a.o(str, ParameterizedMessage.ERROR_MSG_SEPARATOR, value), 0);
            Node nodeFindSingleChild3 = findSingleChild(element, "deprecated");
            if (nodeFindSingleChild3 != null && isNotEmpty(nodeFindSingleChild3.getTextContent())) {
                append(sb, "Deprecated. " + nodeFindSingleChild3.getTextContent(), 1);
                if (this.detail && nodeFindSingleChild2 != null) {
                    append(sb, "", 0);
                    append(sb, nodeFindSingleChild2.getTextContent(), 1);
                }
            } else if (nodeFindSingleChild2 != null) {
                append(sb, nodeFindSingleChild2.getTextContent(), 1);
            }
            append(sb, "", 0);
            if (this.detail) {
                List<Node> listFindNamedChild = findNamedChild(getSingleChild(element, Constants.PARAMETERS), "parameter");
                append(sb, "Available parameters:", 1);
                append(sb, "", 0);
                Iterator<Node> it = listFindNamedChild.iterator();
                while (it.hasNext()) {
                    writeParameter(sb, it.next(), nodeFindSingleChild);
                }
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.maven.plugin.MojoExecutionException */
    private void writeParameter(StringBuilder sb, Node node, Node node2) throws MojoExecutionException {
        String str;
        String value = getValue(node, "name");
        String value2 = getValue(node, "description");
        Element element = node2 != null ? (Element) findSingleChild(node2, value) : null;
        if (element == null || !element.hasAttribute("default-value")) {
            str = "";
        } else {
            str = " (Default: " + element.getAttribute("default-value") + ")";
        }
        append(sb, androidx.collection.a.n(value, str), 2);
        Node nodeFindSingleChild = findSingleChild(node, "deprecated");
        if (nodeFindSingleChild != null && isNotEmpty(nodeFindSingleChild.getTextContent())) {
            append(sb, "Deprecated. " + nodeFindSingleChild.getTextContent(), 3);
            append(sb, "", 0);
        }
        append(sb, value2, 3);
        if ("true".equals(getValue(node, "required"))) {
            append(sb, "Required: Yes", 3);
        }
        if (element != null && isNotEmpty(element.getTextContent())) {
            append(sb, AbstractC0157z.n("User property: ", getPropertyFromExpression(element.getTextContent())), 3);
        }
        append(sb, "", 0);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.maven.plugin.MojoExecutionException */
    public void execute() throws MojoExecutionException {
        if (this.lineLength <= 0) {
            getLog().warn("The parameter 'lineLength' should be positive, using '80' as default.");
            this.lineLength = 80;
        }
        if (this.indentSize <= 0) {
            getLog().warn("The parameter 'indentSize' should be positive, using '2' as default.");
            this.indentSize = 2;
        }
        Document documentBuild = build();
        StringBuilder sb = new StringBuilder();
        Node singleChild = getSingleChild(documentBuild, "plugin");
        String value = getValue(singleChild, "name");
        String value2 = getValue(singleChild, "version");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getValue(singleChild, "groupId"));
        sb2.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        String strR = androidx.exifinterface.media.a.r(sb2, getValue(singleChild, "artifactId"), ParameterizedMessage.ERROR_MSG_SEPARATOR, value2);
        if (isNotEmpty(value) && !value.contains(strR)) {
            append(sb, androidx.collection.a.o(value, " ", value2), 0);
        } else if (isNotEmpty(value)) {
            append(sb, value, 0);
        } else {
            append(sb, strR, 0);
        }
        append(sb, getValue(singleChild, "description"), 1);
        append(sb, "", 0);
        String value3 = getValue(singleChild, "goalPrefix");
        List<Node> listFindNamedChild = findNamedChild(getSingleChild(singleChild, "mojos"), "mojo");
        String str = this.goal;
        if (str == null || str.length() <= 0) {
            StringBuilder sb3 = new StringBuilder("This plugin has ");
            sb3.append(listFindNamedChild.size());
            sb3.append(listFindNamedChild.size() > 1 ? " goals:" : " goal:");
            append(sb, sb3.toString(), 0);
            append(sb, "", 0);
        }
        Iterator<Node> it = listFindNamedChild.iterator();
        while (it.hasNext()) {
            writeGoal(sb, value3, (Element) it.next());
        }
        if (getLog().isInfoEnabled()) {
            getLog().info(sb.toString());
        }
    }

    private static void toLines(List<String> list, String str, int i5, int i6) {
        int indentLevel = getIndentLevel(str);
        StringBuilder sb = new StringBuilder(256);
        for (String str2 : str.split(" +")) {
            if (sb.length() > 0) {
                if (str2.length() + sb.length() >= i6) {
                    list.add(sb.toString());
                    sb.setLength(0);
                    sb.append(repeat(" ", indentLevel * i5));
                } else {
                    sb.append(Chars.SPACE);
                }
            }
            for (int i7 = 0; i7 < str2.length(); i7++) {
                char cCharAt = str2.charAt(i7);
                if (cCharAt == '\t') {
                    sb.append(repeat(" ", i5 - (sb.length() % i5)));
                } else if (cCharAt == 160) {
                    sb.append(Chars.SPACE);
                } else {
                    sb.append(cCharAt);
                }
            }
        }
        list.add(sb.toString());
    }
}
