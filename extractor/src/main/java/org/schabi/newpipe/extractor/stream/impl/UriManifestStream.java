package org.schabi.newpipe.extractor.stream.impl;

import org.schabi.newpipe.extractor.stream.StreamingProtocol;
import org.schabi.newpipe.extractor.stream.deliverysource.DeliverySource;
import org.schabi.newpipe.extractor.stream.interfaces.ManifestStream;

import javax.annotation.Nonnull;

/**
 * An {@link ManifestStream} implementation supporting URIs.
 */
public class UriManifestStream implements ManifestStream {

    @Nonnull
    private final DeliverySource deliverySource;
    @Nonnull
    private final StreamingProtocol streamingProtocol;

    public UriManifestStream(@Nonnull final DeliverySource deliverySource,
                             @Nonnull final StreamingProtocol streamingProtocol) {
        this.deliverySource = deliverySource;
        this.streamingProtocol = streamingProtocol;
    }

    @Nonnull
    @Override
    public DeliverySource getDeliverySource() {
        return deliverySource;
    }

    @Nonnull
    @Override
    public StreamingProtocol getStreamingProtocol() {
        return streamingProtocol;
    }

    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof UriManifestStream)) {
            return false;
        }

        final UriManifestStream that = (UriManifestStream) o;
        return deliverySource.equals(that.deliverySource)
                && streamingProtocol == that.streamingProtocol;
    }

    @Override
    public int hashCode() {
        int result = deliverySource.hashCode();
        result = 31 * result + streamingProtocol.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UriManifestStream{"
                + "deliverySource=" + deliverySource
                + ", streamingProtocol=" + streamingProtocol
                + "}";
    }
}
