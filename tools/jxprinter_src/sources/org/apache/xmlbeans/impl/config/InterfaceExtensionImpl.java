package org.apache.xmlbeans.impl.config;

import A3.AbstractC0157z;
import androidx.core.os.EnvironmentCompat;
import com.alibaba.android.arouter.utils.Consts;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.type.ReferenceType;
import com.github.javaparser.ast.type.TypeParameter;
import com.github.javaparser.resolution.MethodUsage;
import com.github.javaparser.resolution.types.ResolvedType;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.xmlbeans.InterfaceExtension;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class InterfaceExtensionImpl implements InterfaceExtension {
    private String _delegateToClassName;
    private String _interfaceClassName;
    private MethodSignatureImpl[] _methods;
    private NameSet _xbeanSet;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class MethodSignatureImpl implements InterfaceExtension.MethodSignature {
        private final String[] _exceptions;
        private final String _intfName;
        private final String _name;
        private final String[] _paramNames;
        private final String[] _params;
        private final String _return;
        private String _signature;
        private final int NOTINITIALIZED = -1;
        private int _hashCode = -1;

        public MethodSignatureImpl(String str, MethodDeclaration methodDeclaration) {
            if (str == null || methodDeclaration == null) {
                throw new IllegalArgumentException("Interface: " + str + " method: " + methodDeclaration);
            }
            this._intfName = str;
            this._signature = null;
            this._name = methodDeclaration.getName().asString();
            String str2 = (String) methodDeclaration.getTypeParameters().stream().map(new m()).collect(Collectors.joining(", "));
            StringBuilder sb = new StringBuilder();
            sb.append(str2.length() == 0 ? "" : AbstractC0157z.o(" <", str2, "> "));
            sb.append(replaceInner(methodDeclaration.getType().resolve().describe()));
            this._return = sb.toString();
            int i5 = 0;
            this._params = (String[]) methodDeclaration.getParameters().stream().map(new n()).map(new o(i5)).toArray(new p(i5));
            this._exceptions = (String[]) methodDeclaration.getThrownExceptions().stream().map(new q()).map(new o(i5)).toArray(new p(1));
            this._paramNames = (String[]) methodDeclaration.getParameters().stream().map(new r()).toArray(new p(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ String lambda$new$0(Parameter parameter) {
            return parameter.getType().resolve().describe();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ String[] lambda$new$1(int i5) {
            return new String[i5];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ String lambda$new$2(ReferenceType referenceType) {
            return referenceType.resolve().describe();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ String[] lambda$new$3(int i5) {
            return new String[i5];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ String[] lambda$new$5(int i5) {
            return new String[i5];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String replaceInner(String str) {
            return str.replace('$', '.');
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof MethodSignatureImpl)) {
                return false;
            }
            MethodSignatureImpl methodSignatureImpl = (MethodSignatureImpl) obj;
            return methodSignatureImpl.getName().equals(getName()) && this._intfName.equals(methodSignatureImpl._intfName) && Arrays.equals(getParameterTypes(), methodSignatureImpl.getParameterTypes());
        }

        @Override // org.apache.xmlbeans.InterfaceExtension.MethodSignature
        public String[] getExceptionTypes() {
            return this._exceptions;
        }

        public String getInterfaceName() {
            return this._intfName;
        }

        @Override // org.apache.xmlbeans.InterfaceExtension.MethodSignature
        public String getName() {
            return this._name;
        }

        @Override // org.apache.xmlbeans.InterfaceExtension.MethodSignature
        public String[] getParameterNames() {
            return this._paramNames;
        }

        @Override // org.apache.xmlbeans.InterfaceExtension.MethodSignature
        public String[] getParameterTypes() {
            return this._params;
        }

        @Override // org.apache.xmlbeans.InterfaceExtension.MethodSignature
        public String getReturnType() {
            return this._return;
        }

        public String getSignature() {
            String str = this._signature;
            if (str != null) {
                return str;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this._name);
            sb.append("(");
            String strS = AbstractC0157z.s(sb, String.join(" ,", this._params), ")");
            this._signature = strS;
            return strS;
        }

        public int hashCode() {
            int i5 = this._hashCode;
            if (i5 != -1) {
                return i5;
            }
            int iHash = Objects.hash(getName(), Integer.valueOf(Arrays.hashCode(getParameterTypes())), this._intfName);
            this._hashCode = iHash;
            return iHash;
        }

        public String toString() {
            return getReturnType() + " " + getSignature();
        }
    }

    public static MethodDeclaration getMethod(ClassOrInterfaceDeclaration classOrInterfaceDeclaration, String str, final String[] strArr) {
        return (MethodDeclaration) classOrInterfaceDeclaration.getMethodsByName(str).stream().filter(new Predicate() { // from class: org.apache.xmlbeans.impl.config.d
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return InterfaceExtensionImpl.lambda$getMethod$7(strArr, (MethodDeclaration) obj);
            }
        }).findFirst().orElse(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getMethod$7(String[] strArr, MethodDeclaration methodDeclaration) {
        return parameterMatches(paramStrings(methodDeclaration.getParameters()), strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$paramStrings$8(Node node) {
        if (node instanceof Parameter) {
            return ((Parameter) node).getType().resolve().describe();
        }
        return node instanceof TypeParameter ? ((TypeParameter) node).getNameAsString() : EnvironmentCompat.MEDIA_UNKNOWN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String[] lambda$paramStrings$9(int i5) {
        return new String[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String[] lambda$validateMethod$5(int i5) {
        return new String[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String[] lambda$validateMethod$6(int i5) {
        return new String[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$validateMethods$0(MethodUsage methodUsage) {
        return !Object.class.getName().equals(methodUsage.declaringType().getQualifiedName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ MethodSignatureImpl lambda$validateMethods$2(MethodDeclaration methodDeclaration) {
        if (methodDeclaration == null) {
            return null;
        }
        return new MethodSignatureImpl(getStaticHandler(), methodDeclaration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ MethodSignatureImpl[] lambda$validateMethods$3(int i5) {
        return new MethodSignatureImpl[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean matchParams(MethodUsage methodUsage, MethodDeclaration methodDeclaration) {
        List paramTypes = methodUsage.getParamTypes();
        NodeList parameters = methodDeclaration.getParameters();
        if (parameters.size() != paramTypes.size() + 1 || !XmlObject.class.getName().equals(parameters.get(0).resolve().describeType())) {
            return false;
        }
        Iterator it = paramTypes.iterator();
        int i5 = 1;
        while (it.hasNext()) {
            int i6 = i5 + 1;
            if (!((ResolvedType) it.next()).describe().equals(parameters.get(i5).resolve().describeType())) {
                return false;
            }
            i5 = i6;
        }
        return true;
    }

    public static InterfaceExtensionImpl newInstance(Parser parser, NameSet nameSet, Extensionconfig.Interface r6) {
        InterfaceExtensionImpl interfaceExtensionImpl = new InterfaceExtensionImpl();
        interfaceExtensionImpl._xbeanSet = nameSet;
        ClassOrInterfaceDeclaration classOrInterfaceDeclarationValidateInterface = validateInterface(parser, r6.getName(), r6);
        if (classOrInterfaceDeclarationValidateInterface == null) {
            BindingConfigImpl.error("Interface '" + r6.getStaticHandler() + "' not found.", r6);
            return null;
        }
        interfaceExtensionImpl._interfaceClassName = (String) classOrInterfaceDeclarationValidateInterface.getFullyQualifiedName().get();
        String staticHandler = r6.getStaticHandler();
        interfaceExtensionImpl._delegateToClassName = staticHandler;
        ClassOrInterfaceDeclaration classOrInterfaceDeclarationValidateClass = validateClass(parser, staticHandler, r6);
        if (classOrInterfaceDeclarationValidateClass != null) {
            if (interfaceExtensionImpl.validateMethods(parser, classOrInterfaceDeclarationValidateInterface, classOrInterfaceDeclarationValidateClass, r6)) {
                return interfaceExtensionImpl;
            }
            return null;
        }
        BindingConfigImpl.warning("Handler class '" + r6.getStaticHandler() + "' not found on classpath, skip validation.", r6);
        return interfaceExtensionImpl;
    }

    private static String[] paramStrings(NodeList<?> nodeList) {
        return (String[]) nodeList.stream().map(new f()).toArray(new p(7));
    }

    private static boolean parameterMatches(String[] strArr, String[] strArr2) {
        if (strArr.length != strArr2.length) {
            return false;
        }
        for (int i5 = 0; i5 < strArr.length; i5++) {
            String str = strArr[i5];
            String str2 = strArr2[i5];
            if (!str.contains(Consts.DOT)) {
                str2 = str;
                str = str2;
            }
            if (!str.endsWith(str2)) {
                return false;
            }
        }
        return true;
    }

    public static ClassOrInterfaceDeclaration validateClass(Parser parser, String str, XmlObject xmlObject) {
        return validateJava(parser, str, false, xmlObject);
    }

    private static ClassOrInterfaceDeclaration validateInterface(Parser parser, String str, XmlObject xmlObject) {
        return validateJava(parser, str, true, xmlObject);
    }

    public static ClassOrInterfaceDeclaration validateJava(Parser parser, String str, boolean z6, XmlObject xmlObject) {
        if (parser == null) {
            return null;
        }
        String str2 = z6 ? "Interface" : "Class";
        ClassOrInterfaceDeclaration classOrInterfaceDeclarationLoadSource = parser.loadSource(str);
        if (classOrInterfaceDeclarationLoadSource == null) {
            BindingConfigImpl.error(str2 + " '" + str + "' not found.", xmlObject);
            return null;
        }
        if (z6 != classOrInterfaceDeclarationLoadSource.isInterface()) {
            StringBuilder sbY = AbstractC0157z.y("'", str, "' must be ");
            sbY.append(z6 ? "an interface" : "a class");
            sbY.append(Consts.DOT);
            BindingConfigImpl.error(sbY.toString(), xmlObject);
        }
        if (!classOrInterfaceDeclarationLoadSource.isPublic()) {
            BindingConfigImpl.error(str2 + " '" + str + "' is not public.", xmlObject);
        }
        return classOrInterfaceDeclarationLoadSource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: validateMethod, reason: merged with bridge method [inline-methods] */
    public MethodDeclaration lambda$validateMethods$1(ClassOrInterfaceDeclaration classOrInterfaceDeclaration, ClassOrInterfaceDeclaration classOrInterfaceDeclaration2, final MethodUsage methodUsage, XmlObject xmlObject) {
        String name = methodUsage.getName();
        MethodDeclaration methodDeclaration = (MethodDeclaration) classOrInterfaceDeclaration2.getMethodsByName(name).stream().filter(new Predicate() { // from class: org.apache.xmlbeans.impl.config.k
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return InterfaceExtensionImpl.matchParams(methodUsage, (MethodDeclaration) obj);
            }
        }).findFirst().orElse(null);
        String str = (String) classOrInterfaceDeclaration2.getFullyQualifiedName().orElse("");
        StringBuilder sbX = AbstractC0157z.x(name, "(");
        sbX.append(methodUsage.getParamTypes().toString());
        sbX.append(")");
        String string = sbX.toString();
        String str2 = (String) classOrInterfaceDeclaration.getFullyQualifiedName().orElse("");
        if (methodDeclaration == null) {
            BindingConfigImpl.error("Handler class '" + str + "' does not contain method " + string, xmlObject);
            return null;
        }
        if (!Arrays.equals((String[]) methodUsage.getDeclaration().getSpecifiedExceptions().stream().map(new l()).sorted().toArray(new p(5)), (String[]) methodDeclaration.getThrownExceptions().stream().map(new e()).map(new l()).sorted().toArray(new p(6)))) {
            StringBuilder sbU = androidx.collection.a.u("Handler method '", str, Consts.DOT, name, "' must declare the same exceptions as the interface method '");
            sbU.append(str2);
            sbU.append(Consts.DOT);
            sbU.append(string);
            BindingConfigImpl.error(sbU.toString(), xmlObject);
            return null;
        }
        if (!methodDeclaration.isPublic() || !methodDeclaration.isStatic()) {
            BindingConfigImpl.error(androidx.collection.a.p("Method '", str, Consts.DOT, string, "' must be declared public and static."), xmlObject);
            return null;
        }
        if (methodUsage.getDeclaration().getReturnType().equals(methodDeclaration.resolve().getReturnType())) {
            return methodDeclaration;
        }
        String strDescribe = methodUsage.getDeclaration().getReturnType().describe();
        BindingConfigImpl.error(androidx.exifinterface.media.a.s(androidx.collection.a.u("Return type for method '", strDescribe, " ", str, Consts.DOT), name, "(...)' does not match the return type of the interface method :'", strDescribe, "'."), xmlObject);
        return null;
    }

    private boolean validateMethods(Parser parser, final ClassOrInterfaceDeclaration classOrInterfaceDeclaration, final ClassOrInterfaceDeclaration classOrInterfaceDeclaration2, final XmlObject xmlObject) {
        MethodSignatureImpl[] methodSignatureImplArr = (MethodSignatureImpl[]) classOrInterfaceDeclaration.resolve().getAllMethods().stream().filter(new g()).map(new Function() { // from class: org.apache.xmlbeans.impl.config.h
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f7355a.lambda$validateMethods$1(classOrInterfaceDeclaration, classOrInterfaceDeclaration2, xmlObject, (MethodUsage) obj);
            }
        }).map(new Function() { // from class: org.apache.xmlbeans.impl.config.i
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f7356a.lambda$validateMethods$2((MethodDeclaration) obj);
            }
        }).toArray(new p(8));
        this._methods = methodSignatureImplArr;
        return Stream.of((Object[]) methodSignatureImplArr).allMatch(new j(0));
    }

    public boolean contains(String str) {
        return this._xbeanSet.contains(str);
    }

    @Override // org.apache.xmlbeans.InterfaceExtension
    public String getInterface() {
        return this._interfaceClassName;
    }

    @Override // org.apache.xmlbeans.InterfaceExtension
    public InterfaceExtension.MethodSignature[] getMethods() {
        return this._methods;
    }

    @Override // org.apache.xmlbeans.InterfaceExtension
    public String getStaticHandler() {
        return this._delegateToClassName;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("  static handler: ");
        sb.append(this._delegateToClassName);
        sb.append("\n  interface: ");
        sb.append(this._interfaceClassName);
        sb.append("\n  name set: ");
        sb.append(this._xbeanSet);
        sb.append("\n");
        for (int i5 = 0; i5 < this._methods.length; i5++) {
            sb.append("  method[");
            sb.append(i5);
            sb.append("]=");
            sb.append(this._methods[i5]);
            sb.append("\n");
        }
        return sb.toString();
    }
}
