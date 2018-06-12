/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author andre
 */
public interface Constants {

    static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int DIM_X_FRAME = (int) screenSize.getWidth();
    public static final int DIM_Y_FRAME = (int) screenSize.getHeight();

    public static final int DIM_X_HOMEPAGE = (int) screenSize.getWidth() - 100;
    public static final int DIM_Y_HOMEPAGE = (int) screenSize.getHeight() - 100;

    public static final int DIM_X_MENU = 500;
    public static final int DIM_Y_MENU = 550;

    public static final int DIM_X_LOGOMENU = (255 * DIM_X_FRAME) / 1366;
    public static final int DIM_Y_LOGOMENU = (320 * DIM_Y_FRAME) / 768;

    public static final int DIM_X_CARDDECK = (470 * DIM_X_FRAME) / 1366;
    public static final int DIM_Y_CARDDECK = (900 * DIM_Y_FRAME) / 768;

    public static final int DIM_X_ENEMYSTATUS = (470 * DIM_X_FRAME) / 1366;
    public static final int DIM_Y_ENEMYSTATUS = (900 * DIM_Y_FRAME) / 768;
}
