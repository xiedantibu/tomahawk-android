/* == This file is part of Tomahawk Player - <http://tomahawk-player.org> ===
 *
 *   Copyright 2013, Enno Gottschalk <mrmaffen@googlemail.com>
 *
 *   Tomahawk is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   Tomahawk is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with Tomahawk. If not, see <http://www.gnu.org/licenses/>.
 */
package org.tomahawk.libtomahawk.hatchet;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class MembershipInfo implements Info {

    private final static String TAG = MembershipInfo.class.getName();

    public static final String MEMBERSHIPINFO_KEY_ARTIST = "artist";

    public static final String MEMBERSHIPINFO_KEY_TIMESPAN = "timespan";

    private ArtistInfo mArtist;

    private TimeSpanInfo mTimeSpan;

    public MembershipInfo(JSONObject rawInfo) {
        try {
            if (!rawInfo.isNull(MEMBERSHIPINFO_KEY_ARTIST)) {
                mArtist = new ArtistInfo(rawInfo.getJSONObject(MEMBERSHIPINFO_KEY_ARTIST));
            }
            if (!rawInfo.isNull(MEMBERSHIPINFO_KEY_TIMESPAN)) {
                mTimeSpan = new TimeSpanInfo(rawInfo.getJSONObject(MEMBERSHIPINFO_KEY_TIMESPAN));
            }
        } catch (JSONException e) {
            Log.e(TAG, "parseInfo: " + e.getClass() + ": " + e.getLocalizedMessage());
        }
    }

    public ArtistInfo getArtist() {
        return mArtist;
    }

    public TimeSpanInfo getTimeSpan() {
        return mTimeSpan;
    }
}
