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

        JPanel buttonPanel = new JPanel(new GridLayout(1, 1));
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

        redisplay();

    }

    public void redisplay() {
        display.setText(calc.getStringDisplayValue());
    }



}