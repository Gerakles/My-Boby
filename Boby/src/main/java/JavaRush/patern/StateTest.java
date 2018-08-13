package JavaRush.patern;

interface State {
    void doAction();
}
class StartPlay implements State {
    public void doAction() {
        System.out.println("start play");
    }
}
class StopPlay implements State {
    public void doAction() {
        System.out.println("stop play");
    }
}
class PlayContext implements State {
    private State state;
    public void setState(State state){
        this.state = state;
    }
    public void doAction() {
        this.state.doAction();
    }
}

public class StateTest {//тест
    public static void main(String[] args) {
        PlayContext playContext = new PlayContext();
        State startPlay = new StartPlay();
        State stopPlay = new StopPlay();
        playContext.setState(startPlay);
        playContext.doAction();
        playContext.setState(stopPlay);
        playContext.doAction();
    }
}