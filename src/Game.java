/*
 * File: Game.java
 * -------------------
 * Author: Volodymyr "drugarybna" Stepanov
 *
 * This file will eventually implement the game of Bubble Shooter.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import javax.sound.sampled.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/** Bubble Shooter Game Program */
public class Game extends GraphicsProgram {

    public final int APPLICATION_WIDTH = 400;
    public final int APPLICATION_HEIGHT = 600;

    /* Runs the Bubble Shooter */
    public void run() {
        setup();
        build();
    }

    private void build() {

    }

    private void setup() {
        this.setTitle("Bubble Shooter v1.0");
        this.setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
        this.setFont(new Font("Arial", Font.PLAIN, 16));
        GImage bg = new GImage("bg.png");
        add(bg);
    }

}
