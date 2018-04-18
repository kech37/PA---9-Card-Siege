package Logic;

public class Track {

    int posicao;

    public Track() {
        posicao = 5;
    }

    public void Forward() {
        posicao++;
    }

    public void Backward() {
        posicao--;
    }

    public void Reset() {
        posicao = 1;
    }
}
