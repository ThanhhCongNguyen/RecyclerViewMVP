package com.example.recyclerviewmvp.model;

public class DarkMode {
    private Boolean isDark = false;

    public DarkMode() {
    }

    public DarkMode(Boolean isDark) {
        this.isDark = isDark;
    }

    public Boolean getDark() {
        return isDark;
    }

    public void setDark(Boolean dark) {
        isDark = dark;
    }
}
