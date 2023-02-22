package com.mdp.cobalogin;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class KendaliLogin {
    private SharedPreferences sp;
    private SharedPreferences.Editor spe;

    public void setPref (Context ctx, String key, String value)
    {
        sp = PreferenceManager.getDefaultSharedPreferences(ctx);
        spe = sp.edit();
        spe.putString(key, value);
        spe.commit();
    }
    public String getPref (Context ctx, String key)
    {
        sp = PreferenceManager.getDefaultSharedPreferences(ctx);
        return sp.getString(key, null);
    }

    public Boolean isLogin(Context ctx, String key)
    {
        if (this.getPref(ctx,key) != null)
        {
            return true;
        }
        else {
            return false;
        }

    }
}
