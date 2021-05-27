public class Runner {

    public static void main(String args []) {


        CalcEngineHex calcEngineHex = new CalcEngineHex();
        UserInterfaceHex userInterfaceHex = new UserInterfaceHex(calcEngineHex);
        userInterfaceHex.setVisible(true);


        CalcEngine calcEngine = new CalcEngine();
        UserInterface userInterface = new UserInterface(calcEngine);
        userInterface.setVisible(true);
    }
}
