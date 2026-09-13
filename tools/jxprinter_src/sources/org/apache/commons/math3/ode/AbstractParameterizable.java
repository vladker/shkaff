package org.apache.commons.math3.ode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractParameterizable implements Parameterizable {
    private final Collection<String> parametersNames;

    public AbstractParameterizable(String... strArr) {
        this.parametersNames = new ArrayList();
        for (String str : strArr) {
            this.parametersNames.add(str);
        }
    }

    public void complainIfNotSupported(String str) {
        if (!isSupported(str)) {
            throw new UnknownParameterException(str);
        }
    }

    @Override // org.apache.commons.math3.ode.Parameterizable
    public Collection<String> getParametersNames() {
        return this.parametersNames;
    }

    @Override // org.apache.commons.math3.ode.Parameterizable
    public boolean isSupported(String str) {
        Iterator<String> it = this.parametersNames.iterator();
        while (it.hasNext()) {
            if (it.next().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public AbstractParameterizable(Collection<String> collection) {
        ArrayList arrayList = new ArrayList();
        this.parametersNames = arrayList;
        arrayList.addAll(collection);
    }
}
