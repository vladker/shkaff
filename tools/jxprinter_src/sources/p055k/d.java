package p055k;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import p067m.c;
import p079o.c0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface d {
    boolean alphabetic() default true;

    boolean asm() default true;

    Class builder() default Void.class;

    Class deserializer() default Void.class;

    String[] ignores() default {};

    String[] includes() default {};

    Class mappingTo() default Void.class;

    String[] orders() default {};

    c[] parseFeatures() default {};

    Class[] seeAlso() default {};

    boolean serializeEnumAsJavaBean() default false;

    Class serializer() default Void.class;

    c0[] serialzeFeatures() default {};

    String typeName() default "";
}
