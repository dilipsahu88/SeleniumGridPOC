public class AustrelianTraffic  implements CentralTraffic, UnitedStatesTraffic {

    public void main (String [] args) {

        //Creating object for CentralTraffic interface
        CentralTraffic a = new AustrelianTraffic();
        a.greenGo();
        a.redStop();
        a.yellowWait();

        //Creating object for AustrelianTraffic class
        AustrelianTraffic at= new AustrelianTraffic();
        at.walkSymbol();

        //Creating object for UnitedStates interface
        UnitedStatesTraffic ut = new AustrelianTraffic();
        ut.pressWalkButton();
    }

    public void walkSymbol() {
        System.out.println("hand Signal on please walk");
        System.out.println("Watach both side before crossing the road");
    }
    @Override
    public void greenGo() {
        System.out.println("Green Light Go");
    }

    @Override
    public void redStop() {
        System.out.println("red light Stop");
    }

    @Override
    public void yellowWait() {
        System.out.println("Yellow light wait");

    }

    @Override
    public void pressWalkButton() {
        System.out.println("press walk button to cross the road");
    }
}
