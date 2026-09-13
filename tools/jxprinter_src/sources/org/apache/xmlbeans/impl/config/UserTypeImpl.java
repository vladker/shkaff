package org.apache.xmlbeans.impl.config;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.UserType;
import org.apache.xmlbeans.impl.xb.xmlconfig.Usertypeconfig;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class UserTypeImpl implements UserType {
    private String _javaName;
    private QName _name;
    private String _staticHandler;

    public static UserTypeImpl newInstance(Parser parser, Usertypeconfig usertypeconfig) {
        UserTypeImpl userTypeImpl = new UserTypeImpl();
        userTypeImpl._name = usertypeconfig.getName();
        userTypeImpl._javaName = usertypeconfig.getJavaname();
        userTypeImpl._staticHandler = usertypeconfig.getStaticHandler();
        return userTypeImpl;
    }

    @Override // org.apache.xmlbeans.UserType
    public String getJavaName() {
        return this._javaName;
    }

    @Override // org.apache.xmlbeans.UserType
    public QName getName() {
        return this._name;
    }

    @Override // org.apache.xmlbeans.UserType
    public String getStaticHandler() {
        return this._staticHandler;
    }
}
