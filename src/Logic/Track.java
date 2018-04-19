package Logic;

public class Track {

    private int position ;

    public Track() {
        position  = 4;
    }

    public void Forward(){
        if(position  >= 0)
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
    
    public void Remove()
    {
        position = -1;
    }
    
    public boolean CircleSpace()
    {
        if(position == 1)
            return true;
        else
            return false;
    }

    public int getPosition() {
        return position;
    }
        
    public void Reset() {
        position  = 5;
    }
    
}
