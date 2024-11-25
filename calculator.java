import java.awt.*;
import java.awt.event.*;

public class calculator extends Frame implements ActionListener {
    TextField tf;
    String input = "";
    
    calculator() {
        setSize(400, 400);
        setLayout(null);
        setVisible(true);

        Button b = new Button("0");
        b.setBounds(10, 50, 50, 50);
        add(b);

        Button b1 = new Button("1");
        b1.setBounds(90, 50, 50, 50);
        add(b1);

        Button b2 = new Button("2");
        b2.setBounds(170, 50, 50, 50);
        add(b2);

        Button b3 = new Button("3");
        b3.setBounds(10, 110, 50, 50);
        add(b3);

        Button b4 = new Button("4");
        b4.setBounds(90, 110, 50, 50);
        add(b4);

        Button b5 = new Button("5");
        b5.setBounds(170, 110, 50, 50);
        add(b5);

        Button b6 = new Button("6");
        b6.setBounds(10, 170, 50, 50);
        add(b6);

        Button b7 = new Button("7");
        b7.setBounds(90, 170, 50, 50);
        add(b7);

        Button b8 = new Button("8");
        b8.setBounds(170, 170, 50, 50);
        add(b8);

        Button b9 = new Button("9");
        b9.setBounds(10, 230, 50, 50);
        add(b9);

        Button bdot = new Button(".");
        bdot.setBounds(90, 230, 50, 50);
        add(bdot);

        Button bC = new Button("C");
        bC.setBounds(170, 230, 50, 50);
        add(bC);

        Button bplus = new Button("+");
        bplus.setBounds(220, 50, 50, 50);
        add(bplus);

        Button bmin = new Button("-");
        bmin.setBounds(220, 110, 50, 50);
        add(bmin);

        Button bprd = new Button("*");
        bprd.setBounds(220, 170, 50, 50);
        add(bprd);

        Button bdiv = new Button("/");
        bdiv.setBounds(220, 230, 50, 50);
        add(bdiv);

        Button beqal = new Button("=");
        beqal.setBounds(270, 230, 50, 50);
        add(beqal);

        tf = new TextField();
        tf.setBounds(10, 300, 255, 50);
        add(tf);

        b.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        bdot.addActionListener(this);
        bC.addActionListener(this);
        bplus.addActionListener(this);
        bmin.addActionListener(this);
        bprd.addActionListener(this);
        bdiv.addActionListener(this);
        beqal.addActionListener(this);

        this.addWindowListener(new WindowListener() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }

            @Override
            public void windowOpened(WindowEvent e) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'windowOpened'");
            }

            @Override
            public void windowClosed(WindowEvent e) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'windowClosed'");
            }

            @Override
            public void windowIconified(WindowEvent e) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'windowIconified'");
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'windowDeiconified'");
            }

            @Override
            public void windowActivated(WindowEvent e) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'windowActivated'");
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'windowDeactivated'");
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("C")) {
            input = "";
            tf.setText("");
        } else if (command.equals("=")) {
            try {
                String result = evaluate(input);
                tf.setText(result);
                input = result; 
            } catch (Exception ex) {
                tf.setText("Error");
            }
        } else if ("+-*/".contains(command)) {
            input += " " + command + " ";
            tf.setText(input);
        } else {
            input += command;
            tf.setText(input);
        }
    }

    private String evaluate(String expression) {
        String[] tokens = expression.split(" ");// token is the number or operator
        double result = Double.parseDouble(tokens[0]);//this is for 1st number
        for (int i = 1; i < tokens.length; i += 2) {
            String operator = tokens[i];
            double operand = Double.parseDouble(tokens[i + 1]);
            switch (operator) {
                case "+" -> result += operand;
                case "-" -> result -= operand;
                case "*" -> result *= operand;
                case "/" -> result /= operand;
            }
        }
        return String.valueOf(result);
    }

    public static void main(String[] args) {
        new calculator();
    }
}
