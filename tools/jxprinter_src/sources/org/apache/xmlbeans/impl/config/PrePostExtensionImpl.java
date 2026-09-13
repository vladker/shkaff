package org.apache.xmlbeans.impl.config;

import A3.AbstractC0157z;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.type.PrimitiveType;
import org.apache.xmlbeans.PrePostExtension;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class PrePostExtensionImpl implements PrePostExtension {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String[] PARAMTYPES_STRING;
    private static final String SIGNATURE;
    private ClassOrInterfaceDeclaration _delegateToClass;
    private String _delegateToClassName;
    private MethodDeclaration _postSet;
    private MethodDeclaration _preSet;
    private NameSet _xbeanSet;

    static {
        String[] strArr = {XmlErrorCodes.INT, "org.apache.xmlbeans.XmlObject", "javax.xml.namespace.QName", "boolean", XmlErrorCodes.INT};
        PARAMTYPES_STRING = strArr;
        SIGNATURE = AbstractC0157z.s(new StringBuilder("("), String.join(", ", strArr), ")");
    }

    private boolean lookAfterPreAndPost(Parser parser, XmlObject xmlObject) {
        ClassOrInterfaceDeclaration classOrInterfaceDeclaration = this._delegateToClass;
        String[] strArr = PARAMTYPES_STRING;
        MethodDeclaration method = InterfaceExtensionImpl.getMethod(classOrInterfaceDeclaration, "preSet", strArr);
        this._preSet = method;
        if (method != null && !method.getType().equals(PrimitiveType.booleanType())) {
            BindingConfigImpl.warning("Method '" + this._delegateToClass.getNameAsString() + ".preSet" + SIGNATURE + "' should return boolean to be considered for a preSet handler.", xmlObject);
            this._preSet = null;
        }
        MethodDeclaration method2 = InterfaceExtensionImpl.getMethod(this._delegateToClass, "postSet", strArr);
        this._postSet = method2;
        if (this._preSet != null || method2 != null) {
            return true;
        }
        StringBuilder sb = new StringBuilder("prePostSet handler specified '");
        sb.append(this._delegateToClass.getNameAsString());
        sb.append("' but no preSet");
        String str = SIGNATURE;
        BindingConfigImpl.error(androidx.exifinterface.media.a.s(sb, str, " or postSet", str, " methods found."), xmlObject);
        return false;
    }

    public static PrePostExtensionImpl newInstance(Parser parser, NameSet nameSet, Extensionconfig.PrePostSet prePostSet) {
        if (prePostSet == null) {
            return null;
        }
        PrePostExtensionImpl prePostExtensionImpl = new PrePostExtensionImpl();
        prePostExtensionImpl._xbeanSet = nameSet;
        String staticHandler = prePostSet.getStaticHandler();
        prePostExtensionImpl._delegateToClassName = staticHandler;
        ClassOrInterfaceDeclaration classOrInterfaceDeclarationValidateClass = InterfaceExtensionImpl.validateClass(parser, staticHandler, prePostSet);
        prePostExtensionImpl._delegateToClass = classOrInterfaceDeclarationValidateClass;
        if (classOrInterfaceDeclarationValidateClass != null) {
            if (prePostExtensionImpl.lookAfterPreAndPost(parser, prePostSet)) {
                return prePostExtensionImpl;
            }
            return null;
        }
        BindingConfigImpl.warning("Handler class '" + prePostSet.getStaticHandler() + "' not found on classpath, skip validation.", prePostSet);
        return prePostExtensionImpl;
    }

    public boolean contains(String str) {
        return this._xbeanSet.contains(str);
    }

    public String getHandlerNameForJavaSource() {
        ClassOrInterfaceDeclaration classOrInterfaceDeclaration = this._delegateToClass;
        if (classOrInterfaceDeclaration == null) {
            return null;
        }
        return classOrInterfaceDeclaration.getNameAsString();
    }

    public NameSet getNameSet() {
        return this._xbeanSet;
    }

    @Override // org.apache.xmlbeans.PrePostExtension
    public String getStaticHandler() {
        return this._delegateToClassName;
    }

    public boolean hasNameSetIntersection(PrePostExtensionImpl prePostExtensionImpl) {
        return !NameSet.EMPTY.equals(this._xbeanSet.intersect(prePostExtensionImpl._xbeanSet));
    }

    @Override // org.apache.xmlbeans.PrePostExtension
    public boolean hasPostCall() {
        return this._postSet != null;
    }

    @Override // org.apache.xmlbeans.PrePostExtension
    public boolean hasPreCall() {
        return this._preSet != null;
    }
}
