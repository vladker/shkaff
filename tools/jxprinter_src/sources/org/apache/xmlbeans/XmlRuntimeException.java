package org.apache.xmlbeans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class XmlRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 1;
    private List<XmlError> _errors;

    public XmlRuntimeException(String str) {
        super(str);
    }

    public XmlError getError() {
        List<XmlError> list = this._errors;
        if (list == null || list.size() == 0) {
            return null;
        }
        return this._errors.get(0);
    }

    public Collection<XmlError> getErrors() {
        return this._errors;
    }

    public XmlRuntimeException(String str, Throwable th) {
        super(str, th);
    }

    public XmlRuntimeException(Throwable th) {
        super(th);
    }

    public XmlRuntimeException(String str, Throwable th, Collection<XmlError> collection) {
        super(str, th);
        if (collection != null) {
            this._errors = Collections.unmodifiableList(new ArrayList(collection));
        }
    }

    public XmlRuntimeException(XmlError xmlError) {
        this(xmlError.toString(), (Throwable) null, xmlError);
    }

    public XmlRuntimeException(String str, Throwable th, XmlError xmlError) {
        this(str, th, Collections.singletonList(xmlError));
    }

    public XmlRuntimeException(XmlException xmlException) {
        super(xmlException.getMessage(), xmlException.getCause());
        Collection<XmlError> errors = xmlException.getErrors();
        if (errors != null) {
            this._errors = Collections.unmodifiableList(new ArrayList(errors));
        }
    }
}
