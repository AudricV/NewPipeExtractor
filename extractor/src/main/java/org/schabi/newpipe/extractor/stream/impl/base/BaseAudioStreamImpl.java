package org.schabi.newpipe.extractor.stream.impl.base;

import org.schabi.newpipe.extractor.stream.AudioTrackType;
import org.schabi.newpipe.extractor.stream.interfaces.base.BaseAudioStream;
import org.schabi.newpipe.extractor.stream.mediaformat.AudioMediaFormat;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Locale;
import java.util.Objects;

public class BaseAudioStreamImpl extends BaseDemuxedStreamImpl implements BaseAudioStream {

    @Nonnull
    private final AudioMediaFormat audioMediaFormat;
    @Nullable
    private final Integer averageBitrate;
    @Nullable
    private final Integer channelsCount;
    @Nullable
    private final AudioTrackType audioTrackType;
    @Nullable
    private final Boolean isUsingDrc;
    @Nullable
    private final String codec;

    public BaseAudioStreamImpl(@Nullable final String id,
                               @Nullable final String name,
                               @Nullable final Locale locale,
                               @Nullable final Boolean isAutomaticallyServiceGenerated,
                               @Nonnull final AudioMediaFormat audioMediaFormat,
                               @Nullable final Integer averageBitrate,
                               @Nullable final Integer channelsCount,
                               @Nullable final AudioTrackType audioTrackType,
                               @Nullable final Boolean isUsingDrc,
                               @Nullable final String codec) {
        super(id, name, locale, isAutomaticallyServiceGenerated);
        this.audioMediaFormat = audioMediaFormat;
        this.averageBitrate = averageBitrate;
        this.channelsCount = channelsCount;
        this.audioTrackType = audioTrackType;
        this.isUsingDrc = isUsingDrc;
        this.codec = codec;
    }

    @Nonnull
    @Override
    public AudioMediaFormat getMediaFormat() {
        return audioMediaFormat;
    }

    @Nullable
    @Override
    public Integer getAverageBitrate() {
        return averageBitrate;
    }

    @Nullable
    @Override
    public Integer getChannelsCount() {
        return channelsCount;
    }

    @Nullable
    @Override
    public AudioTrackType getTrackType() {
        return audioTrackType;
    }

    @Nullable
    @Override
    public Boolean isUsingDrc() {
        return isUsingDrc;
    }

    @Nullable
    @Override
    public String getCodec() {
        return codec;
    }

    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof BaseAudioStreamImpl) || !super.equals(o)) {
            return false;
        }

        final BaseAudioStreamImpl that = (BaseAudioStreamImpl) o;
        return audioMediaFormat.equals(that.audioMediaFormat)
                && Objects.equals(averageBitrate, that.averageBitrate)
                && Objects.equals(channelsCount, that.channelsCount)
                && audioTrackType == that.audioTrackType
                && Objects.equals(isUsingDrc, that.isUsingDrc)
                && Objects.equals(codec, that.codec);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + audioMediaFormat.hashCode();
        result = 31 * result + Objects.hashCode(averageBitrate);
        result = 31 * result + Objects.hashCode(channelsCount);
        result = 31 * result + Objects.hashCode(audioTrackType);
        result = 31 * result + Objects.hashCode(isUsingDrc);
        result = 31 * result + Objects.hashCode(codec);
        return result;
    }

    @Override
    public String toString() {
        return "BaseAudioStreamImpl{"
                + "id=" + getId()
                + ", name=" + getName()
                + ", locale=" + getLocale()
                + ", isAutomaticallyServiceGenerated=" + isAutomaticallyServiceGenerated()
                + ", audioMediaFormat=" + audioMediaFormat
                + ", averageBitrate=" + averageBitrate
                + ", channelsCount=" + channelsCount
                + ", audioTrackType=" + audioTrackType
                + ", isUsingDrc=" + isUsingDrc
                + ", codec=" + codec
                + "}";
    }
}
