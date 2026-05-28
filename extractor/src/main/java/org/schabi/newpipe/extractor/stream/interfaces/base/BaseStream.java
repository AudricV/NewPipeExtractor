package org.schabi.newpipe.extractor.stream.interfaces.base;

import java.io.Serializable;

/**
 * Marker interface which represents the base of streams in the extractor.
 *
 * <p>
 * It is not meant to be directly used by clients, but by extractor sub-definitions and
 * custom implementations. See {@link org.schabi.newpipe.extractor.stream.interfaces.Stream
 * Stream} for an interface which is meant to be used.
 * </p>
 */
public interface BaseStream extends Serializable {
}
