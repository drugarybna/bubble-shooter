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

    public final int BULLET_RADIUS = 18;

    /* Runs the Bubble Shooter */
    public void run() {
        setup();
        build();
    }

    private void build() {
        addGun();
        generateBullet();
    }

    private void generateBullet() {
        bullet = new GOval(BULLET_RADIUS*2, BULLET_RADIUS*2);
        bullet.setFilled(true);
        bullet.setColor(Color.red);
        double x = gun.getX() + gun.getWidth()/2 - bullet.getWidth()/2;
        double y = gun.getY() - bullet.getHeight()/2;
        add(bullet, x, y);
        bullet.sendBackward();
    }

    private void addGun() {
        gun = new GImage("gun.png");
        double x = (double)APPLICATION_WIDTH/2 - gun.getWidth()/2;
        double y = APPLICATION_HEIGHT - gun.getHeight()/2;
        add(gun, x, y);
    }

    private void setup() {
        this.setTitle("Bubble Shooter v1.0");
        this.setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
        this.setFont(new Font("Arial", Font.PLAIN, 16));
        GImage bg = new GImage("bg.png");
        add(bg);
    }

    GImage gun;
    GOval bullet;

}
