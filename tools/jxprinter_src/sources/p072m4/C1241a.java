package p072m4;

import A3.AbstractC0157z;
import A3.I;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.E;

/* JADX INFO: renamed from: m4.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1241a {
    private List<? extends Annotation> annotations;
    private final List<List<Annotation>> elementAnnotations;
    private final List<r> elementDescriptors;
    private final List<String> elementNames;
    private final List<Boolean> elementOptionality;
    private final String serialName;
    private final Set<String> uniqueNames;

    public C1241a(String serialName) {
        E.f(serialName, "serialName");
        this.serialName = serialName;
        this.annotations = I.emptyList();
        this.elementNames = new ArrayList();
        this.uniqueNames = new HashSet();
        this.elementDescriptors = new ArrayList();
        this.elementAnnotations = new ArrayList();
        this.elementOptionality = new ArrayList();
    }

    public final void element(String elementName, r descriptor, List<? extends Annotation> annotations, boolean z6) {
        E.f(elementName, "elementName");
        E.f(descriptor, "descriptor");
        E.f(annotations, "annotations");
        if (!this.uniqueNames.add(elementName)) {
            StringBuilder sbY = AbstractC0157z.y("Element with name '", elementName, "' is already registered in ");
            sbY.append(this.serialName);
            throw new IllegalArgumentException(sbY.toString().toString());
        }
        this.elementNames.add(elementName);
        this.elementDescriptors.add(descriptor);
        this.elementAnnotations.add(annotations);
        this.elementOptionality.add(Boolean.valueOf(z6));
    }

    public final List<Annotation> getAnnotations() {
        return this.annotations;
    }

    public final List<List<Annotation>> getElementAnnotations$kotlinx_serialization_core() {
        return this.elementAnnotations;
    }

    public final List<r> getElementDescriptors$kotlinx_serialization_core() {
        return this.elementDescriptors;
    }

    public final List<String> getElementNames$kotlinx_serialization_core() {
        return this.elementNames;
    }

    public final List<Boolean> getElementOptionality$kotlinx_serialization_core() {
        return this.elementOptionality;
    }

    public final String getSerialName() {
        return this.serialName;
    }

    public final void setAnnotations(List<? extends Annotation> list) {
        E.f(list, "<set-?>");
        this.annotations = list;
    }

    public static /* synthetic */ void getAnnotations$annotations() {
    }

    public static /* synthetic */ void isNullable$annotations() {
    }
}
