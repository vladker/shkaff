package p055k;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import p067m.c;
import p079o.c0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface b {
    String[] alternateNames() default {};

    boolean deserialize() default true;

    Class deserializeUsing() default Void.class;

    String format() default "";

    boolean jsonDirect() default false;

    String label() default "";

    String name() default "";

    int ordinal() default 0;

    c[] parseFeatures() default {};

    boolean serialize() default true;

    Class serializeUsing() default Void.class;

    c0[] serialzeFeatures() default {};

    boolean unwrapped() default false;
}
