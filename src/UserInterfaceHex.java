import java.awt.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;


public class UserInterfaceHex extends UserInterface {
    /**
     * Create a user interface.
     *
     * @param engine The calculator engine.
     */
    public UserInterfaceHex(CalcEngineHex engine) {
        super(engine);
    }

    protected void makeFrame() {

        frame = new JFrame(calc.getTitle());

        JPanel contentPane = (JPanel)frame.getContentPane();
        contentPane.setLayout(new BorderLayout(8, 8));
        contentPane.setBorder(new EmptyBorder( 10, 10, 10, 10));

        display = new JTextField();
        contentPane.add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(6, 4));

        addButton(buttonPanel, "d");
        addButton(buttonPanel, "e");
        addButton(buttonPanel, "f");
        addButton(buttonPanel, "Dec");

        addButton(buttonPanel, "a");
        addButton(buttonPanel, "b");
        addButton(buttonPanel, "c");
        addButton(buttonPanel, "Hex");

        addButton(buttonPanel, "7");
        addButton(buttonPanel, "8");
        addButton(buttonPanel, "9");
        addButton(buttonPanel, "C");

        addButton(buttonPanel, "4");
        addButton(buttonPanel, "5");
        addButton(buttonPanel, "6");
        addButton(buttonPanel, "?");

        addButton(buttonPanel, "1");
        addButton(buttonPanel, "2");
        addButton(buttonPanel, "3");
        addButton(buttonPanel, "*");

        addButton(buttonPanel, "0");
        addButton(buttonPanel, "+");
        addButton(buttonPanel, "-");
        addButton(buttonPanel, "=");

        contentPane.add(buttonPanel, BorderLayout.CENTER);

        status = new JLabel(calc.getAuthor());
        contentPane.add(status, BorderLayout.SOUTH);

        frame.pack();

    }

    public void actionPerformed(ActionEvent event) {

        String command = event.getActionCommand();

        if(command.equals("0") ||
                command.equals("1") ||
                command.equals("2") ||
                command.equals("3") ||
                command.equals("4") ||
                command.equals("5") ||
                command.equals("6") ||
                command.equals("7") ||
                command.equals("8") ||
                command.equals("9")) {

            int number = Integer.parseInt(command);
            calc.numberPressed(number);
        }
        else if (command.equals("a")) {
                int number = 10;
                calc.numberPressed(number);
        }
        else if (command.equals("b")) {
            int number = 11;
            calc.numberPressed(number);
        }
        else if (command.equals("c")) {
            int number = 12;
            calc.numberPressed(number);
        }
        else if (command.equals("d")) {
            int number = 13;
            calc.numberPressed(number);
        }
        else if (command.equals("e")) {
            int number = 14;
            calc.numberPressed(number);
        }
        else if (command.equals("f")) {
            int number = 15;
            calc.numberPressed(number);
        }
        else if(command.equals("+")) {
            calc.plus();
        }
        else if(command.equals("-")) {
            calc.minus();
        }
        else if(command.equals("=")) {
            calc.equals();
        }
        else if(command.equals("*")) {
            calc.multiply();
        }
        else if(command.equals("C")) {
            calc.clear();
        }
        else if(command.equals("?")) {
            showInfo();
        }
        else if(command.equals("Dec")) {
            calc.changeIsDecCalc();
        }
        else if(command.equals("Hex")) {
            calc.changeIsDecCalc();
        }

        redisplay();

    }

    protected void redisplay() {
        if (calc.getIsDecCalcValue()) {
            display.setText("" + calc.getDisplayValue());
        }
        else {
            display.setText("0x" + Integer.toHexString(calc.getDisplayValue()));
        }
    }
}
