package org.schabi.newpipe.extractor.services.youtube.localization;

import org.schabi.newpipe.extractor.utils.Parser;

import javax.annotation.Nonnull;

import java.util.regex.Pattern;

import static org.schabi.newpipe.extractor.services.youtube.localization.LocalizationHelper.StringId;

final class EnGbLocalizationHelper {
    private static final Pattern ACCESSIBILITY_DATA_VIEW_COUNT_REGEX =
            Pattern.compile("([\\d,]+) views$");

    private EnGbLocalizationHelper() {
    }

    static boolean compare(@Nonnull final String givenString,
                           @Nonnull final StringId stringId) {
        final String resourceString = getStringFromStringId(stringId);
        switch (stringId) {
            case LICENSE:
            case LIST_ITEMS_DELETED_VIDEO:
            case LIST_ITEMS_PRIVATE_VIDEO:
                return givenString.equals(resourceString);
            case NO_VIEWS_ENDS_WITH:
                return givenString.toLowerCase().endsWith(resourceString);
            case NO_VIEWS_EQUALS:
                return givenString.toLowerCase().equals(resourceString);
            case PREMIERED:
            case PREMIERED_ON:
            case VIDEO_DESCRIPTION_ACCESSIBILITY_TEXT_YOUTUBE:
                return givenString.startsWith(resourceString);
            default:
                return givenString.contains(resourceString);
        }
    }

    static String getPartialString(@Nonnull final String givenString,
                                   @Nonnull final StringId stringId) {
        final String resourceString = getStringFromStringId(stringId);
        switch (stringId) {
            case PREMIERED:
            case PREMIERED_ON:
                return givenString.substring(resourceString.length());
            default:
                throw new UnsupportedOperationException();
        }
    }

    static String parseStringWithRegex(@Nonnull final String givenString,
                                       @Nonnull final LocalizationHelper.RegexId regexId) throws Parser.RegexException {
        switch (regexId) {
            case STREAM_ITEM_ACCESSIBILITY_DATA_VIEWS:
                return Parser.matchGroup1(ACCESSIBILITY_DATA_VIEW_COUNT_REGEX, givenString);
            default:
                throw new UnsupportedOperationException();
        }
    }

    private static String getStringFromStringId(@Nonnull final StringId compareStringId) {
        switch (compareStringId) {
            case ACCOUNT_TERMINATED:
                return "This account has been terminated";
            case CHANNEL_REMOVED:
                return "This channel was removed";
            case INFRINGEMENT:
                return "infringement";
            case LICENSE:
                return "Licence";
            case LIST_ITEMS_DELETED_VIDEO:
                return "[Deleted video]";
            case LIST_ITEMS_PRIVATE_VIDEO:
                return "[Private video]";
            case NO_VIEWS_CONTAINS:
            case NO_VIEWS_ENDS_WITH:
            case NO_VIEWS_EQUALS:
                return "no views";
            case PLAYER_RESPONSE_ERROR_AGE_RESTRICTED:
                return "inappropriate for some users";
            case PLAYER_RESPONSE_ERROR_ANTI_BOT_SIGN_IN:
                return "a bot";
            case PLAYER_RESPONSE_ERROR_CHANNEL_MEMBERS_FIRST_OR_ONLY:
                return "members";
            case PLAYER_RESPONSE_ERROR_GEORESTRICTED:
                return "country";
            case PLAYER_RESPONSE_ERROR_MUSIC_PREMIUM:
                return "Music Premium";
            case PLAYER_RESPONSE_ERROR_PAID:
                return "payment";
            case PLAYER_RESPONSE_ERROR_PRIVATE:
                return "private";
            case PREMIERED_ON:
                return "Premiered on ";
            case VIDEO_DESCRIPTION_ACCESSIBILITY_TEXT_CHANNEL_LINK:
                return " Channel Link";
            case VIDEO_DESCRIPTION_ACCESSIBILITY_TEXT_YOUTUBE:
                return "YouTube: ";
            case VIOLATED:
                return "violated";
            case VIOLATING:
                return "violating";
            case VIOLATION:
                return "violation";
            default:
                throw new IllegalArgumentException("Invalid StringId: " + compareStringId);
        }
    }
}
