import java.awt.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.border.*;


public class UserInterfacePost extends UserInterface {
    /**
     * Create a user interface.
     *
     * @param engine The calculator engine.
     */
    public UserInterfacePost(CalcEnginePost engine) {
        super(engine);

    }

    public void makeFrame() {
        frame = new JFrame(calc.getTitle());

        JPanel contentPane = (JPanel)frame.getContentPane();
        contentPane.setLayout(new BorderLayout(8, 8));
        contentPane.setBorder(new EmptyBorder( 10, 10, 10, 10));

        display = new JTextField();
        contentPane.add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        addButton(buttonPanel, "Hex / Dec");
        addButton(buttonPanel, "=");



        contentPane.add(buttonPanel, BorderLayout.CENTER);

        status = new JLabel(calc.getAuthor());
        contentPane.add(status, BorderLayout.SOUTH);

        frame.pack();
    }

    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();

        if(command.equals("=")) {
            calc.evaluateInfix(display.getText());
        }
        else if(command.equals("Hex / Dec")) {
            calc.changeIsDecCalc();
        }

        redisplay();

    }

    public void redisplay() {
        if (calc.getIsDecCalcValue()) {
            display.setText(calc.getStringDisplayValue());
        }
        else {
            if (calc.getStringDisplayValue().equals("")) {
                return;
            }
            display.setText("0x" + Integer.toHexString(Integer.parseInt(calc.getStringDisplayValue())));
        }

    }



}