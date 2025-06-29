import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

public abstract class Sprite implements Drawable{
    
    //fields
    protected Room currentRoom;
    protected ImageIcon icon;

    //default constructor
    public Sprite() {
        currentRoom = null;
        icon = null;
    }

    //setter method for currentRoom
    public void setCurrentRoom(Room r) {
        this.currentRoom = r;
    }

    //getter method for currentRoom
    public Room getCurrentRoom() {
        return currentRoom;
    }

    //draw method for sprite in currentRoom
    // draw method for sprite in currentRoom
public void draw(Graphics g) {
    int roomWidth = Room.SIZE;
    int roomHeight = Room.SIZE;
    int offsetX = 30;
    int offsetY = 70;

    if (currentRoom == null || icon == null) {
        return; // DO NOT draw if no room or no icon
    }

    //get current room position
    Point pos = currentRoom.getPosition();

    // image size
    Image iconSize = icon.getImage();
    int iconWidth = iconSize.getWidth(null);
    int iconHeight = iconSize.getHeight(null);

    // place image in center
    int x = pos.x + (roomWidth + offsetX - iconWidth) / 2;
    int y = pos.y + (roomHeight + offsetY - iconHeight) / 2;

    g.drawImage(iconSize, x, y, null);
}


    //4 new methods
    public void moveSouth() {
        if (currentRoom != null && currentRoom.hasSouthExit()) {
            currentRoom = currentRoom.getSouthExit();
        }
    }

    public void moveNorth() {
        if (currentRoom != null && currentRoom.hasNorthExit()) {
            currentRoom = currentRoom.getNorthExit();
        }
    }

    public void moveEast() {
        if (currentRoom != null && currentRoom.hasEastExit()) {
            currentRoom = currentRoom.getEastExit();
        }
    }
    
    public void moveWest() {
        if (currentRoom != null && currentRoom.hasWestExit()) {
            currentRoom = currentRoom.getWestExit();
        }
    }

    //override equals() method
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Sprite) {
            Sprite other = (Sprite) obj;
            return this.currentRoom == other.currentRoom;
        }
        return false;
    }
}
