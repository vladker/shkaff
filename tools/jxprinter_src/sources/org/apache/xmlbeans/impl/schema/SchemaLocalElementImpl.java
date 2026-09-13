package org.apache.xmlbeans.impl.schema;

import org.apache.xmlbeans.SchemaAnnotation;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaLocalElement;
import org.apache.xmlbeans.soap.SOAPArrayType;
import org.apache.xmlbeans.soap.SchemaWSDLArrayType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class SchemaLocalElementImpl extends SchemaParticleImpl implements SchemaLocalElement, SchemaWSDLArrayType {
    protected boolean _abs;
    private SchemaAnnotation _annotation;
    private boolean _blockExt;
    private boolean _blockRest;
    private boolean _blockSubst;
    private SchemaIdentityConstraint.Ref[] _constraints = new SchemaIdentityConstraint.Ref[0];
    private SOAPArrayType _wsdlArrayType;

    public SchemaLocalElementImpl() {
        setParticleType(4);
    }

    @Override // org.apache.xmlbeans.SchemaLocalElement
    public boolean blockExtension() {
        return this._blockExt;
    }

    @Override // org.apache.xmlbeans.SchemaLocalElement
    public boolean blockRestriction() {
        return this._blockRest;
    }

    @Override // org.apache.xmlbeans.SchemaLocalElement
    public boolean blockSubstitution() {
        return this._blockSubst;
    }

    @Override // org.apache.xmlbeans.SchemaAnnotated
    public SchemaAnnotation getAnnotation() {
        return this._annotation;
    }

    public SchemaIdentityConstraint.Ref[] getIdentityConstraintRefs() {
        SchemaIdentityConstraint.Ref[] refArr = this._constraints;
        int length = refArr.length;
        SchemaIdentityConstraint.Ref[] refArr2 = new SchemaIdentityConstraint.Ref[length];
        System.arraycopy(refArr, 0, refArr2, 0, length);
        return refArr2;
    }

    @Override // org.apache.xmlbeans.SchemaLocalElement
    public SchemaIdentityConstraint[] getIdentityConstraints() {
        int length = this._constraints.length;
        SchemaIdentityConstraint[] schemaIdentityConstraintArr = new SchemaIdentityConstraint[length];
        for (int i5 = 0; i5 < length; i5++) {
            schemaIdentityConstraintArr[i5] = this._constraints[i5].get();
        }
        return schemaIdentityConstraintArr;
    }

    @Override // org.apache.xmlbeans.soap.SchemaWSDLArrayType
    public SOAPArrayType getWSDLArrayType() {
        return this._wsdlArrayType;
    }

    @Override // org.apache.xmlbeans.SchemaLocalElement
    public boolean isAbstract() {
        return this._abs;
    }

    public void setAbstract(boolean z6) {
        this._abs = z6;
    }

    public void setAnnotation(SchemaAnnotation schemaAnnotation) {
        this._annotation = schemaAnnotation;
    }

    public void setBlock(boolean z6, boolean z7, boolean z8) {
        mutate();
        this._blockExt = z6;
        this._blockRest = z7;
        this._blockSubst = z8;
    }

    public void setIdentityConstraints(SchemaIdentityConstraint.Ref[] refArr) {
        mutate();
        this._constraints = refArr == null ? null : (SchemaIdentityConstraint.Ref[]) refArr.clone();
    }

    public void setWsdlArrayType(SOAPArrayType sOAPArrayType) {
        this._wsdlArrayType = sOAPArrayType;
    }
}
