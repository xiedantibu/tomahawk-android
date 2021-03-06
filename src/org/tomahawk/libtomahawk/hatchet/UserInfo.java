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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Author Enno Gottschalk <mrmaffen@googlemail.com> Date: 04.05.13
 */
public class UserInfo implements Info {

    private final static String TAG = UserInfo.class.getName();

    public static final String USERINFO_KEY_ID = "id";

    public static final String USERINFO_KEY_NAME = "name";

    public static final String USERINFO_KEY_LINKS = "links";

    public static final String USERINFO_PARAM_IDARRAY = "ids%5B%5D";

    public static final String USERINFO_PARAM_NAME = "name";

    public static final String USERINFO_PARAM_RANDOM = "random";

    public static final String USERINFO_PARAM_COUNT = "count";

    private String mId;

    private String mName;

    private HashMap<String, String> mLinks;

    public UserInfo(JSONObject rawInfo) {
        try {
            if (!rawInfo.isNull(USERINFO_KEY_ID)) {
                mId = rawInfo.getString(USERINFO_KEY_ID);
            }
            if (!rawInfo.isNull(USERINFO_KEY_NAME)) {
                mName = rawInfo.getString(USERINFO_KEY_NAME);
            }
            if (!rawInfo.isNull(USERINFO_KEY_LINKS)) {
                JSONObject links = rawInfo.getJSONObject(USERINFO_KEY_LINKS);
                Iterator<?> keys = links.keys();
                mLinks = new HashMap<String, String>();
                while (keys.hasNext()) {
                    String key = (String) keys.next();
                    mLinks.put(key, (String) links.get(key));
                }
            }
        } catch (JSONException e) {
            Log.e(TAG, "parseInfo: " + e.getClass() + ": " + e.getLocalizedMessage());
        }
    }

    public String getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public HashMap<String, String> getLinks() {
        return mLinks;
    }
}
