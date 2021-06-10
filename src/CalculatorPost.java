/**
 * The main class of a simple calculator. Create one of these and you'll
 * get the calculator on screen.
 *
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class CalculatorPost
{

    private CalcEnginePost engine;
    private UserInterfacePost gui;

    /**
     * Create a new calculator and show it.
     */
    public CalculatorPost()
    {
        engine = new CalcEnginePost();
        gui = new UserInterfacePost(engine);
    }

    /**
     * In case the window was closed, show it again.
     */
    public void show()
    {
        gui.setVisible(true);
    }

    public static void main(String args []) {

        CalculatorPost c = new CalculatorPost();
//        String s = " 1 + 2";
//        c.engine.evaluateInfix(s);
    }
}