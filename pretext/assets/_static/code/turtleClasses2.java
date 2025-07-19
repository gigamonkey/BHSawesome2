<![CDATA[
import javax.swing.*;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.util.Observer;
import java.util.Random;

/**
 * Class that represents a Logo-style turtle.  The turtle
 * starts off facing north.
 * A turtle can have a name, has a starting x and y position,
 * has a heading, has a width, has a height, has a visible
 * flag, has a body color, can have a shell color, and has a pen.
 * The turtle will not go beyond the model display or picture
 * boundaries.
 *
 * You can display this turtle in either a picture or in
 * a class that implements ModelDisplay.
 *
 * Copyright Georgia Institute of Technology 2004
 * @author Barb Ericson ericson@cc.gatech.edu
 */
@SuppressWarnings("unchecked")
public class SimpleTurtle
{
  ///////////////// fields ////////////////////////

  /** count of the number of turtles created */
  private static int numTurtles = 0;

  /** array of colors to use for the turtles */
  private static Color[] colorArray = { Color.green, Color.cyan, new Color(204,0,204), Color.gray};

  /** who to notify about changes to this turtle */
  private ModelDisplay modelDisplay = null;

  /** picture to draw this turtle on */
  private Picture picture = null;

  /** width of turtle in pixels */
  private int width = 15;

  /** height of turtle in pixels */
  private int height = 18;

  /** current location in x (center) */
  private int xPos = 0;

  /** current location in y (center) */
  private int yPos = 0;

  /** heading angle */
  private double heading = 0;  // default is facing north

  /** pen to use for this turtle */
  private Pen pen = new Pen();

  /** color to draw the body in */
  private Color bodyColor = null;

  /** color to draw the shell in */
  private Color shellColor = null;

  /** color of information string */
  private Color infoColor = Color.black;

  /** flag to say if this turtle is visible */
  private boolean visible = true;

  /** flag to say if should show turtle info */
  private boolean showInfo = false;

  /** the name of this turtle */
  private String name = "No name";

  ////////////////// constructors ///////////////////

  /**
   * Constructor that takes the x and y position for the
   * turtle
   * @param x the x pos
   * @param y the y pos
   */
  public SimpleTurtle(int x, int y)
  {
    xPos = x;
    yPos = y;
    bodyColor = colorArray[numTurtles % colorArray.length];
    setPenColor(bodyColor);
    numTurtles++;
  }

  /**
   * Constructor that takes the x and y position and the
   * model displayer
   * @param x the x pos
   * @param y the y pos
   * @param display the model display
   */
  public SimpleTurtle(int x, int y, ModelDisplay display)
  {
    this(x,y); // invoke constructor that takes x and y
    modelDisplay = display;
    display.addModel(this);
  }

  /**
   * Constructor that takes a model display and adds
   * a turtle in the middle of it
   * @param display the model display
   */
  public SimpleTurtle(ModelDisplay display)
  {
    // invoke constructor that takes x and y
    this((int) (display.getWidth() / 2),
         (int) (display.getHeight() / 2));
    modelDisplay = display;
    display.addModel(this);

  }

  /**
   * Constructor that takes the x and y position and the
   * picture to draw on
   * @param x the x pos
   * @param y the y pos
   * @param picture the picture to draw on
   */
  public SimpleTurtle(int x, int y, Picture picture)
  {
    this(x,y); // invoke constructor that takes x and y
    this.picture = picture;
    this.visible = false; // default is not to see the turtle
  }

  /**
   * Constructor that takes the
   * picture to draw on and will appear in the middle
   * @param picture the picture to draw on
   */
  public SimpleTurtle(Picture picture)
  {
    // invoke constructor that takes x and y
    this((int) (picture.getWidth() / 2),
         (int) (picture.getHeight() / 2));
    this.picture = picture;
    this.visible = false; // default is not to see the turtle
  }

  //////////////////// methods /////////////////////////

  /**
   * Get the distance from the passed x and y location
   * @param x the x location
   * @param y the y location
   */
  public double getDistance(int x, int y)
  {
    int xDiff = x - xPos;
    int yDiff = y - yPos;
    return (Math.sqrt((xDiff * xDiff) + (yDiff * yDiff)));
  }

  /**
   * Method to turn to face another simple turtle
   */
  public void turnToFace(SimpleTurtle turtle)
  {
    turnToFace(turtle.xPos,turtle.yPos);
  }

   /**
   * Method to turn towards the given x and y
   * @param x the x to turn towards
   * @param y the y to turn towards
   */
  public void turnToFace(int x, int y)
  {
    double dx = x - this.xPos;
    double dy = y - this.yPos;
    double arcTan = 0.0;
    double angle = 0.0;

    // avoid a divide by 0
    if (dx == 0)
    {
      // if below the current turtle
      if (dy > 0)
        heading = 180;

      // if above the current turtle
      else if (dy < 0)
        heading = 0;
    }
    // dx isn't 0 so can divide by it
    else
    {
      arcTan = Math.toDegrees(Math.atan(dy / dx));
      if (dx < 0)
        heading = arcTan - 90;
      else
        heading = arcTan + 90;
    }

    // notify the display that we need to repaint
    updateDisplay();
  }

  /**
   * Method to get the picture for this simple turtle
   * @return the picture for this turtle (may be null)
   */
  public Picture getPicture() { return this.picture; }

  /**
   * Method to set the picture for this simple turtle
   * @param pict the picture to use
   */
  public void setPicture(Picture pict) { this.picture = pict; }

  /**
   * Method to set the speed of animation by setting the delay to between 0-100.
   * 50 is the default. We pass this to the World's setSpeed method.
   * @param d
   */
  public void setSpeed(int d) {
     ((World)modelDisplay).setSpeed(d);
  }

  /**
   * Method to get the model display for this simple turtle
   * @return the model display if there is one else null
   */
  public ModelDisplay getModelDisplay() { return this.modelDisplay; }

  /**
   * Method to set the model display for this simple turtle
   * @param theModelDisplay the model display to use
   */
  public void setModelDisplay(ModelDisplay theModelDisplay)
  { this.modelDisplay = theModelDisplay; }

  /**
   * Method to get value of show info
   * @return true if should show info, else false
   */
  public boolean getShowInfo() { return this.showInfo; }

  /**
   * Method to show the turtle information string
   * @param value the value to set showInfo to
   */
  public void setShowInfo(boolean value) { this.showInfo = value; }

  /**
   * Method to get the shell color
   * @return the shell color
   */
  public Color getShellColor()
  {
    Color color = null;
    if (this.shellColor == null && this.bodyColor != null)
      color = bodyColor.darker();
    else color = this.shellColor;
    return color;
  }

  /**
   * Method to set the shell color
   * @param color the color to use
   */
  public void setShellColor(Color color) {  this.shellColor = color; }

  /**
   * Method to get the body color
   * @return the body color
   */
  public Color getBodyColor() { return this.bodyColor; }

  /**
   * Method to set the body color which
   * will also set the pen color
   * @param color the color to use
   */
  public void setBodyColor(Color color)
  {
    this.bodyColor = color;
    setPenColor(this.bodyColor);
  }

  /**
   * Method to set the color of the turtle.
   * This will set the body color
   * @param color the color to use
   */
  public void setColor(Color color) { this.setBodyColor(color); }

  /**
   * Method to get the information color
   * @return the color of the information string
   */
  public Color getInfoColor() { return this.infoColor; }

  /**
   * Method to set the information color
   * @param color the new color to use
   */
  public void setInfoColor(Color color) { this.infoColor = color; }

  /**
   * Method to return the width of this object
   * @return the width in pixels
   */
  public int getWidth() { return this.width; }

  /**
   * Method to return the height of this object
   * @return the height in pixels
   */
  public int getHeight() { return this.height; }

  /**
   * Method to set the width of this object
   * @param theWidth in width in pixels
   */
  public void setWidth(int theWidth) { this.width = theWidth; }

  /**
   * Method to set the height of this object
   * @param theHeight the height in pixels
   */
  public void setHeight(int theHeight) { this.height = theHeight; }

  /**
   * Method to get the current x position
   * @return the x position (in pixels)
   */
  public int getXPos() { return this.xPos; }

  /**
   * Method to get the current y position
   * @return the y position (in pixels)
   */
  public int getYPos() { return this.yPos; }

  /**
   * Method to get the pen
   * @return the pen
   */
  public Pen getPen() { return this.pen; }

  /**
   * Method to set the pen
   * @param thePen the new pen to use
   */
  public void setPen(Pen thePen) { this.pen = thePen; }

  /**
   * Method to check if the pen is down
   * @return true if down else false
   */
  public boolean isPenDown() { return this.pen.isPenDown(); }

  /**
   * Method to set the pen down boolean variable
   * @param value the value to set it to
   */
  public void setPenDown(boolean value) { this.pen.setPenDown(value); }

  /**
   * Method to lift the pen up
   */
  public void penUp() { this.pen.setPenDown(false);}

  /**
   * Method to set the pen down
   */
  public void penDown() { this.pen.setPenDown(true);}

  /**
   * Method to get the pen color
   * @return the pen color
   */
  public Color getPenColor() { return this.pen.getColor(); }

  /**
   * Method to set the pen color
   * @param color the color for the pen ink
   */
  public void setPenColor(Color color) { this.pen.setColor(color); }

  /**
   * Method to set the pen width
   * @param width the width to use in pixels
   */
  public void setPenWidth(int width) { this.pen.setWidth(width); }

  /**
   * Method to get the pen width
   * @return the width of the pen in pixels
   */
  public int getPenWidth() { return this.pen.getWidth(); }

  /**
   * Method to clear the path (history of
   * where the turtle has been)
   */
  public void clearPath()
  {
    this.pen.clearPath();
  }

  /**
   * Method to get the current heading
   * @return the heading in degrees
   */
  public double getHeading() { return this.heading; }

  /**
   * Method to set the heading
   * @param heading the new heading to use
   */
  public void setHeading(double heading)
  {
    this.heading = heading;
  }

  /**
   * Method to get the name of the turtle
   * @return the name of this turtle
   */
  public String getName() { return this.name; }

  /**
   * Method to set the name of the turtle
   * @param theName the new name to use
   */
  public void setName(String theName)
  {
    this.name = theName;
  }

  /**
   * Method to get the value of the visible flag
   * @return true if visible else false
   */
  public boolean isVisible() { return this.visible;}

  /**
   * Method to hide the turtle (stop showing it)
   * This doesn't affect the pen status
   */
  public void hide() { this.setVisible(false); }

  /**
   * Method to show the turtle (doesn't affect
   * the pen status
   */
  public void show() { this.setVisible(true); }

  /**
   * Method to set the visible flag
   * @param value the value to set it to
   */
  public void setVisible(boolean value)
  {
    // if the turtle wasn't visible and now is
    if (visible == false && value == true)
    {
      // update the display
      this.updateDisplay();
    }

    // set the visibile flag to the passed value
    this.visible = value;
  }

  /**
   * Method to update the display of this turtle and
   * also check that the turtle is in the bounds
   */
  public synchronized void updateDisplay()
  {
    // check that x and y are at least 0
    if (xPos < 0)
      xPos = 0;
    if (yPos < 0)
      yPos = 0;

    // if picture
    if (picture != null)
    {
      if (xPos >= picture.getWidth())
        xPos = picture.getWidth() - 1;
      if (yPos >= picture.getHeight())
        yPos = picture.getHeight() - 1;
      Graphics g = picture.getGraphics();
      paintComponent(g);
    }
    else if (modelDisplay != null)
    {
      if (xPos >= modelDisplay.getWidth())
        xPos = modelDisplay.getWidth() - 1;
      if (yPos >= modelDisplay.getHeight())
        yPos = modelDisplay.getHeight() - 1;
      modelDisplay.modelChanged();
    }
  }

  /**
   * Method to move the turtle foward 100 pixels
   */
  public void forward() { forward(100); }

  /**
   * Method to move the turtle forward the given number of pixels
   * @param pixels the number of pixels to walk forward in the heading direction
   */
  public void forward(int pixels)
  {
    int oldX = xPos;
    int oldY = yPos;

    // change the current position
    xPos = oldX + (int) (pixels * Math.sin(Math.toRadians(heading)));
    yPos = oldY + (int) (pixels * -Math.cos(Math.toRadians(heading)));

    // add a move from the old position to the new position to the pen
    pen.addMove(oldX,oldY,xPos,yPos);

    // update the display to show the new line
    updateDisplay();
  }

  /**
   * Method to go backward by 100 pixels
   */
  public void backward()
  {
    backward(100);
  }

  /**
   * Method to go backward a given number of pixels
   * @param pixels the number of pixels to walk backward
   */
  public void backward(int pixels)
  {
    forward(-pixels);
  }

  /**
   * Method to move to turtle to the given x and y location
   * @param x the x value to move to
   * @param y the y value to move to
   */
  public void moveTo(int x, int y)
  {
    this.pen.addMove(xPos,yPos,x,y);
    this.xPos = x;
    this.yPos = y;
    this.updateDisplay();
  }

  /**
   * Method to turn left
   */
  public void turnLeft()
  {
   this.turn(-90);
  }

  /**
   * Method to turn right
   */
  public void turnRight()
  {
    this.turn(90);
  }

  /**
   * Method to turn the turtle the passed degrees
   * use negative to turn left and pos to turn right
   * @param degrees the amount to turn in degrees
   */
  public void turn(double degrees)
  {
    this.heading = (heading + degrees) % 360;
    this.updateDisplay();
  }

  /**
   * Method to draw a passed picture at the current turtle
   * location and rotation in a picture or model display
   * @param dropPicture the picture to drop
   */
  public synchronized void drop(Picture dropPicture)
  {
    Graphics2D g2 = null;

    // only do this if drawing on a picture
    if (picture != null)
      g2 = (Graphics2D) picture.getGraphics();
    else if (modelDisplay != null)
      g2 = (Graphics2D) modelDisplay.getGraphics();

    // if g2 isn't null
    if (g2 != null)
    {

      // save the current tranform
      AffineTransform oldTransform = g2.getTransform();

      // rotate to turtle heading and translate to xPos and yPos
      g2.rotate(Math.toRadians(heading),xPos,yPos);

      // draw the passed picture
      g2.drawImage(dropPicture.getImage(),xPos,yPos,null);

      // reset the tranformation matrix
      g2.setTransform(oldTransform);

      //  draw the pen
      pen.paintComponent(g2);
    }
  }

  /**
   * Method to paint the turtle
   * @param g the graphics context to paint on
   */
  public synchronized void paintComponent(Graphics g)
  {
    // cast to 2d object
    Graphics2D g2 = (Graphics2D) g;

    // if the turtle is visible
    if (visible)
    {
      // save the current tranform
      AffineTransform oldTransform = g2.getTransform();

      // rotate the turtle and translate to xPos and yPos
      g2.rotate(Math.toRadians(heading),xPos,yPos);

      // determine the half width and height of the shell
      int halfWidth = (int) (width/2); // of shell
      int halfHeight = (int) (height/2); // of shell
      int quarterWidth = (int) (width/4); // of shell
      int thirdHeight = (int) (height/3); // of shell
      int thirdWidth = (int) (width/3); // of shell

      // draw the body parts (head)
      g2.setColor(bodyColor);
      g2.fillOval(xPos - quarterWidth,
                  yPos - halfHeight - (int) (height/3),
                  halfWidth, thirdHeight);
      g2.fillOval(xPos - (2 * thirdWidth),
                  yPos - thirdHeight,
                  thirdWidth,thirdHeight);
      g2.fillOval(xPos - (int) (1.6 * thirdWidth),
                  yPos + thirdHeight,
                  thirdWidth,thirdHeight);
      g2.fillOval(xPos + (int) (1.3 * thirdWidth),
                  yPos - thirdHeight,
                  thirdWidth,thirdHeight);
      g2.fillOval(xPos + (int) (0.9 * thirdWidth),
                  yPos + thirdHeight,
                  thirdWidth,thirdHeight);


      // draw the shell
      g2.setColor(getShellColor());
      g2.fillOval(xPos - halfWidth,
                  yPos - halfHeight, width, height);

      // draw the info string if the flag is true
      if (showInfo)
        drawInfoString(g2);

      // reset the tranformation matrix
      g2.setTransform(oldTransform);
    }

    //  draw the pen
    pen.paintComponent(g);
  }

  /**
   * Method to draw the information string
   * @param g the graphics context
   */
  public synchronized void drawInfoString(Graphics g)
  {
    g.setColor(infoColor);
    g.drawString(this.toString(),xPos + (int) (width/2),yPos);
  }

  /**
   * Method to return a string with informaiton
   * about this turtle
   * @return a string with information about this object
   */
  public String toString()
  {
    return this.name + " turtle at " + this.xPos + ", " +
      this.yPos + " heading " + this.heading + ".";
  }

} // end of class
import java.util.*;
import java.awt.*;

/**
 * Class that represents a turtle which is similar to a Logo turtle.
 * This class inherts from SimpleTurtle and is for students
 * to add methods to.
 *
 * Copyright Georgia Institute of Technology 2004
 * @author Barb Ericson ericson@cc.gatech.edu
 */
@SuppressWarnings("unchecked")
public class Turtle extends SimpleTurtle
{
  ////////////////// constructors ///////////////////////

  /** Constructor that takes the x and y and a picture to
   * draw on
   * @param x the starting x position
   * @param y the starting y position
   * @param picture the picture to draw on
   */
  public Turtle (int x, int y, Picture picture)
  {
    // let the parent constructor handle it
    super(x,y,picture);
  }

  /** Constructor that takes the x and y and a model
   * display to draw it on
   * @param x the starting x position
   * @param y the starting y position
   * @param modelDisplayer the thing that displays the model
   */
  public Turtle (int x, int y,
                 ModelDisplay modelDisplayer)
  {
    // let the parent constructor handle it
    super(x,y,modelDisplayer);
  }

  /** Constructor that takes the model display
   * @param modelDisplay the thing that displays the model
   */
  public Turtle (ModelDisplay modelDisplay)
  {
    // let the parent constructor handle it
    super(modelDisplay);
  }

  /**
   * Constructor that takes a picture to draw on
   * @param p the picture to draw on
   */
  public Turtle (Picture p)
  {
    // let the parent constructor handle it
    super(p);
  }

} // this is the end of class Turtle, put all new methods before this
/**
 * https://github.com/ha-shine/Giffer
 */
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.IIOException;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.ImageWriter;
import javax.imageio.metadata.IIOInvalidTreeException;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import javax.imageio.stream.ImageOutputStream;

/*
 * Giffer is a simple java class to make my life easier in creating gif images.
 *
 * Usage :
 * There are two methods for creating gif images
 * To generate from files, just pass the array of filename Strings to this method
 * Giffer.generateFromFiles(String[] filenames, String output, int delay, boolean loop)
 *
 * Or as an alternative you can use this method which accepts an array of BufferedImage
 * Giffer.generateFromBI(BufferedImage[] images, String output, int delay, boolean loop)
 *
 * output is the name of the output file
 * delay is time between frames, accepts hundredth of a time. Yeah it's weird, blame Oracle
 * loop is the boolean for whether you want to make the image loopable.
 */

public abstract class Giffer {

    // Generate gif from an array of filenames
    // Make the gif loopable if loop is true
    // Set the delay for each frame according to the delay (ms)
    // Use the name given in String output for output file
    public static void generateFromFiles(String[] filenames, String output, int delay, boolean loop)
        throws IIOException, IOException
    {
        int length = filenames.length;
        BufferedImage[] img_list = new BufferedImage[length];

        for (int i = 0; i < length; i++)
        {
            BufferedImage img = ImageIO.read(new File(filenames[i]));
            img_list[i] = img;
        }

        generateFromBI(img_list, output, delay, loop);
    }

    // Generate gif from BufferedImage array
    // Make the gif loopable if loop is true
    // Set the delay for each frame according to the delay, 100 = 1s
    // Use the name given in String output for output file
    public static void generateFromBI(BufferedImage[] images, String output, int delay, boolean loop)
            throws IIOException, IOException
    {
        int maxWidth = 0;
        int maxHeight = 0;
        ImageWriter gifWriter = getWriter();
        ImageOutputStream ios = getImageOutputStream(output);
        IIOMetadata metadata = getMetadata(gifWriter, delay, loop);

        //Get bigger Width and Height
        for (BufferedImage img: images)
        {
            if(img.getHeight() > maxHeight){
                maxHeight = img.getHeight();
            }
            if(img.getWidth() > maxWidth){
                maxWidth = img.getWidth();
            }
        }

        gifWriter.setOutput(ios);
        gifWriter.prepareWriteSequence(null);
        for (BufferedImage img: images)
        {
            BufferedImage dimg = new BufferedImage(maxWidth, maxHeight, BufferedImage.TYPE_INT_ARGB);
            Image tmp = img.getScaledInstance(img.getWidth(), img.getHeight(), Image.SCALE_DEFAULT);
            Graphics2D g2d = dimg.createGraphics();
            int centerWidth = (maxWidth / 2) - (img.getWidth()/2) ;
            g2d.drawImage(tmp, centerWidth, 0, null);
            g2d.dispose();

            IIOImage temp = new IIOImage(dimg, null, metadata);
            gifWriter.writeToSequence(temp, null);
        }

        gifWriter.endWriteSequence();
    }

    // Retrieve gif writer
    private static ImageWriter getWriter() throws IIOException
    {
        Iterator<ImageWriter> itr = ImageIO.getImageWritersByFormatName("gif");
        if(itr.hasNext())
            return (ImageWriter)itr.next();

        throw new IIOException("GIF writer doesn't exist on this JVM!");
    }

    // Retrieve output stream from the given file name
    private static ImageOutputStream getImageOutputStream(String output) throws IOException
    {
        File outfile = new File(output);
        return ImageIO.createImageOutputStream(outfile);
    }

    // Prepare metadata from the user input, add the delays and make it loopable
    // based on the method parameters
    private static IIOMetadata getMetadata(ImageWriter writer, int delay, boolean loop)
        throws IIOInvalidTreeException
    {
        // Get the whole metadata tree node, the name is javax_imageio_gif_image_1.0
        // Not sure why I need the ImageTypeSpecifier, but it doesn't work without it
        ImageTypeSpecifier img_type = ImageTypeSpecifier.createFromBufferedImageType(BufferedImage.TYPE_INT_ARGB);
        IIOMetadata metadata = writer.getDefaultImageMetadata(img_type, null);
        String native_format = metadata.getNativeMetadataFormatName();
        IIOMetadataNode node_tree = (IIOMetadataNode)metadata.getAsTree(native_format);

        // Set the delay time you can see the format specification on this page
        // https://docs.oracle.com/javase/7/docs/api/javax/imageio/metadata/doc-files/gif_metadata.html
        IIOMetadataNode graphics_node = getNode("GraphicControlExtension", node_tree);
        graphics_node.setAttribute("delayTime", String.valueOf(delay));
        graphics_node.setAttribute("disposalMethod", "none");
        graphics_node.setAttribute("userInputFlag", "FALSE");

        if(loop)
            makeLoopy(node_tree);

        metadata.setFromTree(native_format, node_tree);

        return metadata;
    }

    // Add an extra Application Extension node if the user wants it to be loopable
    // I am not sure about this part, got the code from StackOverflow
    // TODO: Study about this
    private static void makeLoopy(IIOMetadataNode root)
    {
        IIOMetadataNode app_extensions = getNode("ApplicationExtensions", root);
        IIOMetadataNode app_node = getNode("ApplicationExtension", app_extensions);

        app_node.setAttribute("applicationID", "NETSCAPE");
        app_node.setAttribute("authenticationCode", "2.0");
        app_node.setUserObject(new byte[]{ 0x1, (byte) (0 & 0xFF), (byte) ((0 >> 8) & 0xFF)});

        app_extensions.appendChild(app_node);
        root.appendChild(app_extensions);
    }

    // Retrieve the node with the name from the parent root node
    // Append the node if the node with the given name doesn't exist
    private static IIOMetadataNode getNode(String node_name, IIOMetadataNode root)
    {
        IIOMetadataNode node = null;

        for (int i = 0; i < root.getLength(); i++)
        {
            if(root.item(i).getNodeName().compareToIgnoreCase(node_name) == 0)
            {
                node = (IIOMetadataNode) root.item(i);
                return node;
            }
        }

        // Append the node with the given name if it doesn't exist
        node = new IIOMetadataNode(node_name);
        root.appendChild(node);

        return node;
    }
}
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observer;
import java.awt.*;

import java.net.*;
import java.io.*;
// import javax.xml.bind.DatatypeConverter;
// Using java.util.Base64 instead of javax.xml.bind
import java.util.Base64;
import javax.imageio.*;
import java.awt.image.*;
import javax.imageio.stream.*;


/**
 * Class to represent a 2d world that can hold turtles and
 * display them
 *
 * Copyright Georgia Institute of Technology 2004
 * @author Barb Ericson ericson@cc.gatech.edu
 */
@SuppressWarnings("unchecked")
public class World implements ModelDisplay
{
  ////////////////// fields ///////////////////////

  /** should automatically repaint when model changed */
  private boolean autoRepaint = true;

  /** the background color for the world */
  private Color background = Color.white;

  /** the width of the world */
  private int width = 640;

  /** the height of the world */
  private int height = 480;

  /** speed/delay in drawing */
  private int delay = 50;

  /** the list of turtles in the world */
  private List<Turtle> turtleList = new ArrayList<Turtle>();

  /** background picture */
  private Picture picture = null;

  /* All world changes*/
  private List<Picture> worldHistory = new ArrayList<Picture>();


  ////////////////// the constructors ///////////////

  /**
   * Constructor that takes no arguments
   */
  public World()
  {
    // set up the world and make it visible
    initWorld(true);
  }

  /**
   * Constructor that takes a boolean to
   * say if this world should be visible
   * or not
   * @param visibleFlag if true will be visible
   * else if false will not be visible
   */
  public World(boolean visibleFlag)
  {
    initWorld(visibleFlag);
  }

  /**
   * Constructor that takes a width and height for this
   * world
   * @param w the width for the world
   * @param h the height for the world
   */
  public World(int w, int h)
  {
    width = w;
    height = h;

    // set up the world and make it visible
    initWorld(true);
  }

  ///////////////// methods ///////////////////////////

  /**
   * Method to initialize the world
   * @param visibleFlag the flag to make the world
   * visible or not
   */
  private void initWorld(boolean visibleFlag)
  {
    // create the background picture
    picture = new Picture(width,height);
    this.modelChanged();
  }

  /**
   * Method to get the graphics context for drawing on
   * @return the graphics context of the background picture
   */
  public Graphics getGraphics() { return picture.getGraphics(); }

  /**
   * Method to clear the background picture
   */
  public void clearBackground() { picture = new Picture(width,height); }

  /**
   * Method to get the background picture
   * @return the background picture
   */
  public Picture getPicture() { return picture; }

  /**
   * Method to set the background picture
   * @param pict the background picture to use
   */
  public void setPicture(Picture pict) { picture = pict; }

  /**
   * Method to paint this component
   * @param g the graphics context
   */
  public synchronized void paintComponent(Graphics g)
  {
    Turtle turtle = null;

    // draw the background image
    g.drawImage(picture.getImage(),0,0,null);

    // loop drawing each turtle on the background image
    Iterator iterator = turtleList.iterator();
    while (iterator.hasNext())
    {
      turtle = (Turtle) iterator.next();
      turtle.paintComponent(g);
    }
  }

  /**
   * Method to get the last turtle in this world
   * @return the last turtle added to this world
   */
  public Turtle getLastTurtle()
  {
    return (Turtle) turtleList.get(turtleList.size() - 1);
  }


  /**
   * Method to add a model to this model displayer
   * @param model the model object to add
   */
  public void addModel(Object model)
  {
    turtleList.add((Turtle) model);
  }

  /**
   * Method to check if this world contains the passed
   * turtle
   * @return true if there else false
   */
  public boolean containsTurtle(Turtle turtle)
  {
    return (turtleList.contains(turtle));
  }

  /**
   * Method to remove the passed object from the world
   * @param model the model object to remove
   */
  public void remove(Object model)
  {
    turtleList.remove(model);
  }

  /**
   * Method to get the width in pixels
   * @return the width in pixels
   */
  public int getWidth() { return width; }

  /**
   * Method to get the height in pixels
   * @return the height in pixels
   */
  public int getHeight() { return height; }

  /**
   * Method to set the speed of animation by setting the delay to between 0-100.
   * 50 is the default.
   * @param speed
   */
  public void setSpeed(int d) {
     if (d >= 0 && d <= 100)
         delay = d;
  }

  /**
   * Method that allows the model to notify the display
   */
  public void modelChanged()
  {
     Picture p = new Picture(this.width, this.height);
     this.paintComponent(p.getGraphics());
     this.worldHistory.add(p);
  }

  /**
   * Method to set the automatically repaint flag
   * @param value if true will auto repaint
   */
  public void setAutoRepaint(boolean value) { autoRepaint = value; }

  /**
   * Method to show the frame
   */
  public void show()
  {
    this.show(false);
  }

  public void show(boolean showHistory) {
      this.paintComponent(this.picture.getGraphics());
      if(showHistory) {
          try {
              BufferedImage[] images = new BufferedImage[this.worldHistory.size()];
              for(int i = 0; i < this.worldHistory.size(); i++) {
                  images[i] = ((Picture) this.worldHistory.get(i)).getBufferedImage();
              }
              Giffer.generateFromBI(images, "history.gif", delay, false);

              File history = new File("history.gif");

              URL url = history.toURI().toURL();

              byte[] imageBytes = downloadUrl(url);
              String result =
              //DatatypeConverter.printBase64Binary(imageBytes);
              //BH: using java.util.Base64 instead of javax.xml.bind.DataTypeConverter
              Base64.getEncoder().encodeToString(imageBytes);

              System.gc();
              history.delete();
              double rand = Math.random();
              System.out.println("&lt;img src=\'data:image/gif;base64," + result + "\'/>");

          } catch (IOException e) {
              e.printStackTrace();
          }

      } else {
          this.picture.show();
      }
  }

  private byte[] downloadUrl(URL toDownload) {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    try {
        byte[] chunk = new byte[4096];
        int bytesRead;
        InputStream stream = toDownload.openStream();

        while ((bytesRead = stream.read(chunk)) > 0) {
            outputStream.write(chunk, 0, bytesRead);
        }
        //toDownload.close();

    } catch (IOException e) {
        e.printStackTrace();
        return null;
    }

    return outputStream.toByteArray();
}

  /**
   * Method to get the list of turtles in the world
   * @return a list of turtles in the world
   */
  public List getTurtleList()
  { return turtleList;}

  /**
   * Method to get an iterator on the list of turtles
   * @return an iterator for the list of turtles
   */
  public Iterator getTurtleIterator()
  { return turtleList.iterator();}

  /**
   * Method that returns information about this world
   * in the form of a string
   * @return a string of information about this world
   */
  public String toString()
  {
    return "A " + getWidth() + " by " + getHeight() +
      " world with " + turtleList.size() + " turtles in it.";
  }

} // end of World class
]]>
