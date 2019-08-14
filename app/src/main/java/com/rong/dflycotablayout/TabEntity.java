package com.rong.dflycotablayout;


import com.rong.flycotablayout.listener.CustomTabEntity;

/**
 * <pre>
 *     @author : spynokia
 *     e-mail : 782055421@qq.com
 *     time   : 2018/08/01/13:35
 *     desc   :
 * </pre>
 */
public class TabEntity implements CustomTabEntity {
    public String title;
    public int selectedIcon;
    public int unSelectedIcon;

    public TabEntity(String title, int selectedIcon, int unSelectedIcon) {
        this.title = title;
        this.selectedIcon = selectedIcon;
        this.unSelectedIcon = unSelectedIcon;
    }

    @Override
    public String getTabTitle() {
        return title;
    }

    @Override
    public int getTabSelectedIcon() {
        return selectedIcon;
    }

    @Override
    public int getTabUnselectedIcon() {
        return unSelectedIcon;
    }
}
