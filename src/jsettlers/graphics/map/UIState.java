package jsettlers.graphics.map;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

import jsettlers.common.position.ShortPoint2D;

public class UIState implements Serializable {

	/**
	 * The player that uses the ui.
	 */
	private final int player;
	
	/**
	 * The center point of the screen.
	 */
	private final ShortPoint2D screenCenter;

	public UIState(int player, ShortPoint2D startPoint) {
		this.player = player;
		this.screenCenter = startPoint;
    }
	
	public ShortPoint2D getScreenCenter() {
	    return screenCenter;
    }
	
	public int getPlayer() {
	    return player;
    }
	
	public void writeTo(OutputStream stream) throws IOException {
		new ObjectOutputStream(stream).writeObject(this);
	}

	/**
	 * Reads the ui state from the given stream.
	 * @param stream
	 * @return
	 * @throws IOException 
	 */
	public static UIState readFrom(InputStream stream) throws IOException {
		try {
	        return (UIState) new ObjectInputStream(stream).readObject();
        } catch (ClassNotFoundException e) {
	        throw new IOException(e);
        }
    }

}
