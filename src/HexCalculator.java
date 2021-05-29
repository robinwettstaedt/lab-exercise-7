/**
 * The main class of a simple calculator. Create one of these and you'll
 * get the calculator on screen.
 *
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class HexCalculator
{
    private CalcEngineHex engine;
    private UserInterfaceHex gui;

    /**
     * Create a new calculator and show it.
     */
    public HexCalculator()
    {
        engine = new CalcEngineHex();
        gui = new UserInterfaceHex(engine);
    }

    /**
     * In case the window was closed, show it again.
     */
    public void show()
    {
        gui.setVisible(true);
    }

    public static void main(String args []) {

        HexCalculator c = new HexCalculator();
    }
}