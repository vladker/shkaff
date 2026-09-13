package p072m4;

import java.lang.annotation.Annotation;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface r {
    boolean a();

    int b();

    List<Annotation> getAnnotations();

    List<Annotation> getElementAnnotations(int i5);

    r getElementDescriptor(int i5);

    int getElementIndex(String str);

    String getElementName(int i5);

    z getKind();

    String getSerialName();

    boolean isElementOptional(int i5);

    boolean isInline();
}
