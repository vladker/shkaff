package io.flutter.plugins.camera;

import android.media.Image;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class ImageSaver implements Runnable {
    private final Callback callback;
    private final File file;
    private final Image image;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface Callback {
        void onComplete(@NonNull String str);

        void onError(@NonNull String str, @NonNull String str2);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class FileOutputStreamFactory {
        @VisibleForTesting
        public static FileOutputStream create(File file) {
            return new FileOutputStream(file);
        }
    }

    public ImageSaver(@NonNull Image image, @NonNull File file, @NonNull Callback callback) {
        this.image = image;
        this.file = file;
        this.callback = callback;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // java.lang.Runnable
    public void run() {
        ByteBuffer buffer = this.image.getPlanes()[0].getBuffer();
        byte[] bArr = new byte[buffer.remaining()];
        buffer.get(bArr);
        FileOutputStream fileOutputStreamCreate = 0;
        fileOutputStreamCreate = 0;
        try {
            try {
                try {
                    fileOutputStreamCreate = FileOutputStreamFactory.create(this.file);
                    fileOutputStreamCreate.write(bArr);
                    this.callback.onComplete(this.file.getAbsolutePath());
                    this.image.close();
                    fileOutputStreamCreate.close();
                } catch (Throwable th) {
                    this.image.close();
                    if (fileOutputStreamCreate != 0) {
                        try {
                            fileOutputStreamCreate.close();
                        } catch (IOException e) {
                            this.callback.onError("cameraAccess", e.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (IOException unused) {
                this.callback.onError("IOError", "Failed saving image");
                this.image.close();
                fileOutputStreamCreate = fileOutputStreamCreate;
                if (fileOutputStreamCreate != 0) {
                    fileOutputStreamCreate.close();
                    fileOutputStreamCreate = fileOutputStreamCreate;
                }
            }
        } catch (IOException e6) {
            Callback callback = this.callback;
            String message = e6.getMessage();
            callback.onError("cameraAccess", message);
            fileOutputStreamCreate = message;
        }
    }
}
