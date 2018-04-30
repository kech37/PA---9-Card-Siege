package Logic.Cards.Tracks;

import java.io.Serializable;

public class Track implements Serializable {

    private int position;

    public Track() {
        position = 4;
    }

    public void Forward() {
        if (position > 0) {
            position--;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void Backward() {
        if (position < 4) {
            position++;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void Remove() {
        position = -1;
    }

    public boolean CircleSpace() {
        if (position == 1) {
            return true;
        } else {
            return false;
        }
    }

    public int getPosition() {
        return position;
    }

    public void Reset() {
        position = 5;
    }

}
