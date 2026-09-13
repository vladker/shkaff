package org.apache.xmlbeans.impl.validator;

import java.util.Collection;
import javax.xml.namespace.QName;
import javax.xml.stream.Location;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.impl.common.PrefixResolver;
import org.apache.xmlbeans.impl.common.ValidatorListener;
import org.apache.xmlbeans.impl.common.XmlWhitespace;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class ValidatorUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class EventImpl implements ValidatorListener.Event {
        PrefixResolver _prefixResolver;
        String _text;

        public EventImpl(PrefixResolver prefixResolver, String str) {
            this._prefixResolver = prefixResolver;
            this._text = str;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public Location getLocation() {
            return null;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public XmlCursor getLocationAsCursor() {
            return null;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public QName getName() {
            return null;
        }

        @Override // org.apache.xmlbeans.impl.common.PrefixResolver
        public String getNamespaceForPrefix(String str) {
            return this._prefixResolver.getNamespaceForPrefix(str);
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getText() {
            return this._text;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getXsiLoc() {
            return null;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getXsiNil() {
            return null;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getXsiNoLoc() {
            return null;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getXsiType() {
            return null;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public boolean textIsWhitespace() {
            return false;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getText(int i5) {
            return XmlWhitespace.collapse(this._text, i5);
        }
    }

    public static boolean validateSimpleType(SchemaType schemaType, String str, Collection<XmlError> collection, PrefixResolver prefixResolver) {
        if (!schemaType.isSimpleType() && schemaType.getContentType() != 2) {
            throw new RuntimeException("Not a simple type");
        }
        Validator validator = new Validator(schemaType, null, schemaType.getTypeSystem(), null, collection);
        EventImpl eventImpl = new EventImpl(prefixResolver, str);
        validator.nextEvent(1, eventImpl);
        validator.nextEvent(3, eventImpl);
        validator.nextEvent(2, eventImpl);
        return validator.isValid();
    }
}
