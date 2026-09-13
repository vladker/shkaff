package com.google.android.libraries.vision.visionkit.pipeline.alt;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.a;
import com.google.android.apps.common.proguard.UsedByNative;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbki;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbko;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbkx;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtp;
import com.google.android.libraries.vision.visionkit.pipeline.zbad;
import com.google.android.libraries.vision.visionkit.pipeline.zber;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Keep
@UsedByNative("pipeline_jni.cc")
public class PipelineException extends Exception {
    private static final String ROOT_CAUSE_DELIMITER = "#vk ";
    private final zbd statusCode;
    private final String statusMessage;

    @Nullable
    private final zber visionkitStatus;

    public PipelineException(int i5, @NonNull String str) {
        super(a.o(zbd.values()[i5].zba(), ": ", str));
        this.statusCode = zbd.values()[i5];
        this.statusMessage = str;
        this.visionkitStatus = null;
    }

    @NonNull
    public List<zbad> getComponentStatuses() {
        zber zberVar = this.visionkitStatus;
        return zberVar != null ? zberVar.zbf() : zbkx.zbh();
    }

    public zbki<String> getRootCauseMessage() {
        Object next;
        Object obj;
        if (!this.statusMessage.contains(ROOT_CAUSE_DELIMITER)) {
            return zbki.zbd();
        }
        List listZbb = zbko.zba(ROOT_CAUSE_DELIMITER).zbb(this.statusMessage);
        if (listZbb == null) {
            Iterator it = listZbb.iterator();
            do {
                next = it.next();
            } while (it.hasNext());
            obj = next;
        } else {
            if (listZbb.isEmpty()) {
                throw new NoSuchElementException();
            }
            obj = listZbb.get(listZbb.size() - 1);
        }
        return zbki.zbe((String) obj);
    }

    public zbd getStatusCode() {
        return this.statusCode;
    }

    @NonNull
    public String getStatusMessage() {
        return this.statusMessage;
    }

    private PipelineException(zber zberVar) {
        super(a.o(zbd.values()[zberVar.zba()].zba(), ": ", zberVar.zbe()));
        this.statusCode = zbd.values()[zberVar.zba()];
        this.statusMessage = zberVar.zbe();
        this.visionkitStatus = zberVar;
    }

    @Keep
    @UsedByNative("pipeline_jni.cc")
    public PipelineException(byte[] bArr) {
        this(zber.zbd(bArr, zbtp.zba()));
    }
}
