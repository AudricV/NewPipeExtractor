package org.schabi.newpipe.extractor.stream.impl.base;

import org.schabi.newpipe.extractor.stream.interfaces.base.BaseAudioStream;
import org.schabi.newpipe.extractor.stream.interfaces.base.BaseMuxedStream;
import org.schabi.newpipe.extractor.stream.interfaces.base.BaseSubtitlesStream;
import org.schabi.newpipe.extractor.stream.interfaces.base.BaseVideoStream;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

public class BaseMuxedStreamImpl implements BaseMuxedStream {

    @Nullable
    private final List<BaseAudioStream> demuxedAudioStreams;
    @Nullable
    private final List<BaseVideoStream> demuxedVideoStreams;
    @Nullable
    private final List<BaseSubtitlesStream> demuxedSubtitlesStreams;
    @Nullable
    private final List<BaseMuxedStream> muxedStreams;

    public BaseMuxedStreamImpl(@Nullable final List<BaseAudioStream> demuxedAudioStreams,
                               @Nullable final List<BaseVideoStream> demuxedVideoStreams,
                               @Nullable final List<BaseSubtitlesStream> demuxedSubtitlesStreams,
                               @Nullable final List<BaseMuxedStream> muxedStreams) {
        this.demuxedAudioStreams = demuxedAudioStreams;
        this.demuxedVideoStreams = demuxedVideoStreams;
        this.demuxedSubtitlesStreams = demuxedSubtitlesStreams;
        this.muxedStreams = muxedStreams;
    }


    @Nullable
    @Override
    public List<BaseAudioStream> getDemuxedAudioStreams() {
        return demuxedAudioStreams;
    }

    @Nullable
    @Override
    public List<BaseVideoStream> getDemuxedVideoStreams() {
        return demuxedVideoStreams;
    }

    @Nullable
    @Override
    public List<BaseSubtitlesStream> getDemuxedSubtitlesStreams() {
        return demuxedSubtitlesStreams;
    }

    @Nullable
    @Override
    public List<BaseMuxedStream> getMuxedStreams() {
        return muxedStreams;
    }

    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof BaseMuxedStreamImpl)) {
            return false;
        }

        final BaseMuxedStreamImpl that = (BaseMuxedStreamImpl) o;
        return Objects.equals(demuxedAudioStreams, that.demuxedAudioStreams)
                && Objects.equals(demuxedVideoStreams, that.demuxedVideoStreams)
                && Objects.equals(demuxedSubtitlesStreams, that.demuxedSubtitlesStreams)
                && Objects.equals(muxedStreams, that.muxedStreams);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(demuxedAudioStreams);
        result = 31 * result + Objects.hashCode(demuxedVideoStreams);
        result = 31 * result + Objects.hashCode(demuxedSubtitlesStreams);
        result = 31 * result + Objects.hashCode(muxedStreams);
        return result;
    }

    @Override
    public String toString() {
        return "BaseMuxedStreamImpl{"
                + "demuxedAudioStreams=" + demuxedAudioStreams
                + ", demuxedVideoStreams=" + demuxedVideoStreams
                + ", demuxedSubtitlesStreams=" + demuxedSubtitlesStreams
                + ", muxedStreams=" + muxedStreams
                + "}";
    }
}
