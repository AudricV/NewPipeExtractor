package org.schabi.newpipe.extractor.services.youtube.localization;

import org.schabi.newpipe.extractor.localization.Localization;
import org.schabi.newpipe.extractor.utils.Parser;

import javax.annotation.Nonnull;

/**
 * Utility class managing localization support of YouTube localized texts elements, except for view
 * counts and dates, delegating parsing to internal language subclasses.
 */
public final class LocalizationHelper {

    private LocalizationHelper() {
    }

    /**
     * Enum listing all language-dependent strings YouTube extractors rely on.
     */
    public enum StringId {
        ACCOUNT_TERMINATED,
        CHANNEL_REMOVED,
        INFRINGEMENT,
        NO_VIEWS_CONTAINS,
        NO_VIEWS_ENDS_WITH,
        NO_VIEWS_EQUALS,
        LICENSE,
        LIST_ITEMS_DELETED_VIDEO,
        LIST_ITEMS_PRIVATE_VIDEO,
        PLAYER_RESPONSE_ERROR_AGE_RESTRICTED,
        PLAYER_RESPONSE_ERROR_ANTI_BOT_SIGN_IN,
        PLAYER_RESPONSE_ERROR_CHANNEL_MEMBERS_FIRST_OR_ONLY,
        PLAYER_RESPONSE_ERROR_GEORESTRICTED,
        PLAYER_RESPONSE_ERROR_MUSIC_PREMIUM,
        PLAYER_RESPONSE_ERROR_PAID,
        PLAYER_RESPONSE_ERROR_PRIVATE,
        PREMIERED,
        PREMIERED_ON,
        VIDEO_DESCRIPTION_ACCESSIBILITY_TEXT_CHANNEL_LINK,
        VIDEO_DESCRIPTION_ACCESSIBILITY_TEXT_YOUTUBE,
        VIOLATED,
        VIOLATING,
        VIOLATION
    }

    /**
     * Enum listing all language-dependent regular expressions YouTube extractors rely on.
     */
    public enum RegexId {
        STREAM_ITEM_ACCESSIBILITY_DATA_VIEWS
    }

    /**
     * Compare the given string to the string matching the given {@link StringId} in the given
     * {@link Localization}.
     *
     * <p>
     * Comparaisons are up to the language implementation, and can be for instance checking whether
     * the given string starts with the string ID, ends with it or contains it, made lowercase,
     * uppercase, ...
     * </p>
     *
     * @param givenString  the string given by YouTube
     * @param stringId     the {@link StringId} to use
     * @param localization the {@link Localization} to use
     * @return whether the comparaison returns true or false
     * @throws UnsupportedOperationException if localization is invalid or unsupported
     * @throws IllegalArgumentException if stringId is invalid
     */
    public static boolean compare(@Nonnull final String givenString,
                                  @Nonnull final StringId stringId,
                                  @Nonnull final Localization localization) {
        final String localizationCode = localization.getLocalizationCode();
        switch (localizationCode) {
            case "en-GB":
                return EnGbLocalizationHelper.compare(givenString, stringId);
            default:
                throw new UnsupportedOperationException("Unsupported locale: " + localizationCode);
        }
    }

    /**
     * Get a new string from the given string without the string matching the given
     * {@link StringId} in the given {@link Localization}.
     *
     * <p>
     * Partial strings are up to the language implementation.
     * </p>
     *
     * @param givenString  the string given by YouTube
     * @param stringId     the {@link StringId} to use
     * @param localization the {@link Localization} to use
     * @return a new string from the given string without the string matching the given
     * {@link StringId} in the given {@link Localization}
     * @throws UnsupportedOperationException if getting a partial string from the given
     * {@link StringId} is unsupported or if localization is invalid or unsupported
     * @throws IllegalArgumentException if stringId is invalid
     */
    public static String getPartialString(@Nonnull final String givenString,
                                          @Nonnull final StringId stringId,
                                          @Nonnull final Localization localization) {
        final String localizationCode = localization.getLocalizationCode();
        switch (localizationCode) {
            case "en-GB":
                return EnGbLocalizationHelper.getPartialString(givenString, stringId);
            default:
                throw new UnsupportedOperationException("Unsupported locale: " + localizationCode);
        }
    }

    public static String parseStringWithRegex(@Nonnull final String givenString,
                                              @Nonnull final RegexId regexId,
                                              @Nonnull final Localization localization)
            throws Parser.RegexException {
        final String localizationCode = localization.getLocalizationCode();
        switch (localizationCode) {
            case "en-GB":
                return EnGbLocalizationHelper.parseStringWithRegex(givenString, regexId);
            default:
                throw new UnsupportedOperationException("Unsupported locale: " + localizationCode);
        }
    }
}
