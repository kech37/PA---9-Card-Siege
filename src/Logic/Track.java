package Logic;

public class Track {

    int position ;

    public Track() {
        position  = 5;
    }

    public void Forward() {
        if(position  > 0)
              position --;
        else
            throw new IndexOutOfBoundsException();
    }

    public void Backward() {
        if(position  < 5)
             position ++;
        else
             throw new IndexOutOfBoundsException();
    }

    public void Reset() {
        position  = 5;
    }
}
