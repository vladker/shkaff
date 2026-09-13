package io.flutter.plugins.camera.media;

import android.media.CamcorderProfile;
import android.media.EncoderProfiles;
import android.media.MediaRecorder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.plugin.platform.f;
import io.flutter.plugins.camera.SdkCapabilityChecker;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class MediaRecorderBuilder {
    private final CamcorderProfile camcorderProfile;
    private boolean enableAudio;
    private final EncoderProfiles encoderProfiles;
    private int mediaOrientation;

    @NonNull
    private final RecordingParameters parameters;
    private final MediaRecorderFactory recorderFactory;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class MediaRecorderFactory {
        public MediaRecorder makeMediaRecorder() {
            return new MediaRecorder();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class RecordingParameters {

        @Nullable
        public final Integer audioBitrate;

        @Nullable
        public final Integer fps;

        @NonNull
        public final String outputFilePath;

        @Nullable
        public final Integer videoBitrate;

        public RecordingParameters(@NonNull String str) {
            this(str, null, null, null);
        }

        public RecordingParameters(@NonNull String str, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3) {
            this.outputFilePath = str;
            this.fps = num;
            this.videoBitrate = num2;
            this.audioBitrate = num3;
        }
    }

    public MediaRecorderBuilder(@NonNull CamcorderProfile camcorderProfile, @NonNull RecordingParameters recordingParameters) {
        this(camcorderProfile, new MediaRecorderFactory(), recordingParameters);
    }

    @NonNull
    public MediaRecorder build() throws IOException {
        EncoderProfiles encoderProfiles;
        MediaRecorder mediaRecorderMakeMediaRecorder = this.recorderFactory.makeMediaRecorder();
        if (this.enableAudio) {
            mediaRecorderMakeMediaRecorder.setAudioSource(1);
        }
        mediaRecorderMakeMediaRecorder.setVideoSource(2);
        if (!SdkCapabilityChecker.supportsEncoderProfiles() || (encoderProfiles = this.encoderProfiles) == null) {
            CamcorderProfile camcorderProfile = this.camcorderProfile;
            if (camcorderProfile != null) {
                mediaRecorderMakeMediaRecorder.setOutputFormat(camcorderProfile.fileFormat);
                if (this.enableAudio) {
                    mediaRecorderMakeMediaRecorder.setAudioEncoder(this.camcorderProfile.audioCodec);
                    Integer num = this.parameters.audioBitrate;
                    mediaRecorderMakeMediaRecorder.setAudioEncodingBitRate((num == null || num.intValue() <= 0) ? this.camcorderProfile.audioBitRate : this.parameters.audioBitrate.intValue());
                    mediaRecorderMakeMediaRecorder.setAudioSamplingRate(this.camcorderProfile.audioSampleRate);
                }
                mediaRecorderMakeMediaRecorder.setVideoEncoder(this.camcorderProfile.videoCodec);
                Integer num2 = this.parameters.videoBitrate;
                mediaRecorderMakeMediaRecorder.setVideoEncodingBitRate((num2 == null || num2.intValue() <= 0) ? this.camcorderProfile.videoBitRate : this.parameters.videoBitrate.intValue());
                Integer num3 = this.parameters.fps;
                mediaRecorderMakeMediaRecorder.setVideoFrameRate((num3 == null || num3.intValue() <= 0) ? this.camcorderProfile.videoFrameRate : this.parameters.fps.intValue());
                CamcorderProfile camcorderProfile2 = this.camcorderProfile;
                mediaRecorderMakeMediaRecorder.setVideoSize(camcorderProfile2.videoFrameWidth, camcorderProfile2.videoFrameHeight);
            }
        } else {
            mediaRecorderMakeMediaRecorder.setOutputFormat(encoderProfiles.getRecommendedFileFormat());
            EncoderProfiles.VideoProfile videoProfileF = f.f(this.encoderProfiles.getVideoProfiles().get(0));
            if (this.enableAudio) {
                EncoderProfiles.AudioProfile audioProfileE = f.e(this.encoderProfiles.getAudioProfiles().get(0));
                mediaRecorderMakeMediaRecorder.setAudioEncoder(audioProfileE.getCodec());
                Integer num4 = this.parameters.audioBitrate;
                mediaRecorderMakeMediaRecorder.setAudioEncodingBitRate((num4 == null || num4.intValue() <= 0) ? audioProfileE.getBitrate() : this.parameters.audioBitrate.intValue());
                mediaRecorderMakeMediaRecorder.setAudioSamplingRate(audioProfileE.getSampleRate());
            }
            mediaRecorderMakeMediaRecorder.setVideoEncoder(videoProfileF.getCodec());
            Integer num5 = this.parameters.videoBitrate;
            mediaRecorderMakeMediaRecorder.setVideoEncodingBitRate((num5 == null || num5.intValue() <= 0) ? videoProfileF.getBitrate() : this.parameters.videoBitrate.intValue());
            Integer num6 = this.parameters.fps;
            mediaRecorderMakeMediaRecorder.setVideoFrameRate((num6 == null || num6.intValue() <= 0) ? videoProfileF.getFrameRate() : this.parameters.fps.intValue());
            mediaRecorderMakeMediaRecorder.setVideoSize(videoProfileF.getWidth(), videoProfileF.getHeight());
        }
        mediaRecorderMakeMediaRecorder.setOutputFile(this.parameters.outputFilePath);
        mediaRecorderMakeMediaRecorder.setOrientationHint(this.mediaOrientation);
        mediaRecorderMakeMediaRecorder.prepare();
        return mediaRecorderMakeMediaRecorder;
    }

    @NonNull
    public MediaRecorderBuilder setEnableAudio(boolean z6) {
        this.enableAudio = z6;
        return this;
    }

    @NonNull
    public MediaRecorderBuilder setMediaOrientation(int i5) {
        this.mediaOrientation = i5;
        return this;
    }

    public MediaRecorderBuilder(@NonNull EncoderProfiles encoderProfiles, @NonNull RecordingParameters recordingParameters) {
        this(encoderProfiles, new MediaRecorderFactory(), recordingParameters);
    }

    public MediaRecorderBuilder(@NonNull CamcorderProfile camcorderProfile, MediaRecorderFactory mediaRecorderFactory, @NonNull RecordingParameters recordingParameters) {
        this.camcorderProfile = camcorderProfile;
        this.encoderProfiles = null;
        this.recorderFactory = mediaRecorderFactory;
        this.parameters = recordingParameters;
    }

    public MediaRecorderBuilder(@NonNull EncoderProfiles encoderProfiles, MediaRecorderFactory mediaRecorderFactory, @NonNull RecordingParameters recordingParameters) {
        this.encoderProfiles = encoderProfiles;
        this.camcorderProfile = null;
        this.recorderFactory = mediaRecorderFactory;
        this.parameters = recordingParameters;
    }
}
