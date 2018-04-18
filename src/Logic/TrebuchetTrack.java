/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author andre
 */
public class TrebuchetTrack {
        int position ;

    public TrebuchetTrack() {
        position  = 3;
    }

    public void Forward() {
        if(position  > 0)
              position --;
        else
            throw new IndexOutOfBoundsException();
    }

    public void Backward() {
        if(position  < 3)
             position ++;
        else
             throw new IndexOutOfBoundsException();
    }

    public void Reset() {
        position  = 3;
    }
}
