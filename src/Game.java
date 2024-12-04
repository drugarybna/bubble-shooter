/*
 * File: Game.java
 * -------------------
 * Author: Volodymyr "drugarybna" Stepanov
 *
 * This file will eventually implement the game of Bubble Shooter.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.RandomGenerator;

import java.awt.*;

/** Bubble Shooter Game Program */
public class Game extends GraphicsProgram {

    public final int APPLICATION_WIDTH = 400;
    public final int APPLICATION_HEIGHT = 600;

    public final int BALL_RADIUS = 20;

    public final int BALLS_PER_ROW = 10;
    public final int ROWS_ON_START = 3;

    /** Runs the Bubble Shooter */
    public void run() {
        setup();
        build();
    }
    /** Builds the game board from 0 */
    private void build() {
        addGun();
        generateBalls();
    }
    /** Adds randomized balls to the game board */
    private void generateBalls() {
        for (int i = 0; i < ROWS_ON_START; i++) {
            for (int j = 0; j < BALLS_PER_ROW; j++) {
                double x = j * BALL_RADIUS*2;
                double y = i * BALL_RADIUS*2;
                ball = new GOval(x, y, BALL_RADIUS*2, BALL_RADIUS*2);
                ball.setFilled(true);
                ball.setColor(generateColor());
                add(ball);
            }
        }
    }
    /** Generates random color among the 4 colors */
    private Color generateColor() {
        int colIndex = rgen.nextInt(1, 4);
        return switch (colIndex) {
            case 1 -> Color.red;
            case 2 -> Color.green;
            case 3 -> Color.blue;
            default -> Color.yellow;
        };
    }
    /** Adds the gun to the game board */
    private void addGun() {
        gun = new GImage("gun.png");
        double x = (double)APPLICATION_WIDTH/2 - gun.getWidth()/2;
        double y = APPLICATION_HEIGHT - gun.getHeight()/2;
        add(gun, x, y);
        generateBullet();
    }
    /** Generates the bullet at the rear of the gun */
    private void generateBullet() {
        bullet = new GOval(BALL_RADIUS *2, BALL_RADIUS *2);
        bullet.setFilled(true);
        bullet.setColor(generateColor());
        double x = gun.getX() + gun.getWidth()/2 - bullet.getWidth()/2;
        double y = gun.getY() - bullet.getHeight()/2;
        add(bullet, x, y);
        bullet.sendBackward();
    }
    /** Setups the initial game config */
    private void setup() {
        this.setTitle("Bubble Shooter v1.0");
        this.setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
        this.setFont(new Font("Arial", Font.PLAIN, 16));
        GImage bg = new GImage("bg.png");
        add(bg);
    }

    private final RandomGenerator rgen = RandomGenerator.getInstance();

    // Main objects of the game
    GImage gun;
    GOval bullet;
    GOval ball;

}
