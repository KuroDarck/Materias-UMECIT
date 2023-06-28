import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImagingOpException;
import java.math.RoundingMode;
import java.text.DecimalFormat;


public class Calculadora implements ActionListener {

    JFrame frame; // Creación de la variable frame para la creación del formulario que se muestra al usuario
    JTextField entrada; // Creación de la variable entrada para la entrada de datos
    JButton[] Number = new JButton[10]; // Creación de el array Number[]
    JButton[] Operators = new JButton[10]; // Creación del array Operators[]


    Font styleFont = new Font("Times New Roman", Font.ITALIC, 25);

    JButton sumbutton, restButton, multButton, divButton, equButton, dotButton, clsButton, delButton, avrButton, negaButton;
    JPanel panel;
    double dato1 = 0, dato2 = 0, resultado = 0;
    char signo;

    Calculadora() { // constructor de la clase calculadora

        frame = new JFrame("Calculator RHM");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setResizable(false);
        frame.setLayout(null);
        entrada = new JTextField();
        entrada.setFont(styleFont);
        entrada.setBackground(new Color(205, 205, 205));
        entrada.setForeground(new Color(0, 0, 0));
        entrada.setBorder(null);
        entrada.setBounds(40, 50, 300, 40);


        // Creación de los Botones de Operaciones
        sumbutton = new JButton("+");
        restButton = new JButton("-");
        multButton = new JButton("X");
        divButton = new JButton("/");
        dotButton = new JButton(".");
        equButton = new JButton("=");
        clsButton = new JButton("AC");
        delButton = new JButton("C");
        avrButton = new JButton("%");
        negaButton = new JButton("(-)");

        //Colocando los botones en el Array operators
        Operators[0] = sumbutton;
        Operators[1] = restButton;
        Operators[2] = multButton;
        Operators[3] = divButton;
        Operators[4] = dotButton;
        Operators[5] = equButton;
        Operators[6] = clsButton;
        Operators[7] = delButton;
        Operators[8] = avrButton;
        Operators[9] = negaButton;

        //for para trabajar con todos los botones del Array Operators[]
        for (int i = 0; i < 10; i++) {
            Operators[i].addActionListener(this);
            Operators[i].setFocusable(false);
            Operators[i].setBackground(new Color(12, 255, 0));
            Operators[i].setForeground(new Color(0, 0, 0));
            Operators[i].setFont(styleFont);
            Operators[i].setBorder(null);
        }

        //for para trabajar con todos los botones del Array Number[]
        for (int i = 0; i < 10; i++) {
            Number[i] = new JButton(String.valueOf(i));
            Number[i].addActionListener(this);
            Number[i].setFocusable(false);
            Number[i].setBackground(new Color(255, 0, 0));
            Number[i].setForeground(new Color(0, 0, 0));
            Number[i].setFont(styleFont);
            Number[i].setBorder(null);
        }

        panel = new JPanel(); //Creación del nuevo panel
        panel.setBounds(40, 110, 300, 300); // Posicionamiento del grid o panel
        panel.setLayout(new GridLayout(5, 4, 10, 10)); // Dimensionamiento del grid
        panel.setBackground(new Color(186, 187, 186)); // color de fondo del grid
        panel.setBorder(null);

        //Agregando los botones al panel del grid
        panel.add(clsButton);
        panel.add(delButton);
        panel.add(avrButton);
        panel.add(divButton);
        panel.add(Number[7]);
        panel.add(Number[8]);
        panel.add(Number[9]);
        panel.add(multButton);
        panel.add(Number[6]);
        panel.add(Number[5]);
        panel.add(Number[4]);
        panel.add(restButton);
        panel.add(Number[3]);
        panel.add(Number[2]);
        panel.add(Number[1]);
        panel.add(sumbutton);
        panel.add(dotButton);
        panel.add(Number[0]);
        panel.add(negaButton);
        panel.add(equButton);


        frame.add(panel); //Agregando el grid panel al form
        frame.add(entrada); // agregando en la entrada de texto al form
        frame.setVisible(true); // activa la visibilidad del form

        //Icono de la ventana
        Toolkit pantalla = Toolkit.getDefaultToolkit();

        try {
            Image icono = pantalla.getImage("src/Icon-Calculadora.png");
            frame.setIconImage(icono);
        } catch (ImagingOpException e) {
            e.notify();
        }

    }

    public static void main(String[] args) {
        Calculadora calculator = new Calculadora(); //Creación del Objeto en la clase main
    }


    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        //bucle For con el cual capturamos el numero escrito por el usuario
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == Number[i]) {
                entrada.setText(entrada.getText().concat(String.valueOf(i)));
            }
        }

        //Boton de punto .
        if (e.getSource() == dotButton) {
            entrada.setText(entrada.getText().concat("."));
        }

        //Boton de Suma +
        if (e.getSource() == sumbutton) {
            dato1 = Double.parseDouble(entrada.getText());
            signo = '+';
            entrada.setText("");
        }

        //Boton de resta -
        if (e.getSource() == restButton) {
            dato1 = Double.parseDouble(entrada.getText());
            signo = '-';
            entrada.setText("");
        }

        // Boton de Multiplicación x
        if (e.getSource() == multButton) {
            dato1 = Double.parseDouble(entrada.getText());
            signo = 'x';
            entrada.setText(" ");
        }

        //Boton de Division /
        if (e.getSource() == divButton) {
            dato1 = Double.parseDouble(entrada.getText());
            signo = '/';
            entrada.setText(" ");
        }

        // Boton para calcular el Porcentaje %
        if (e.getSource() == avrButton) {
            dato1 = Double.parseDouble(entrada.getText());
            signo = '%';
            entrada.setText(" ");
        }

        //boon de de resultado o igual =
        if (e.getSource() == equButton) {
            dato2 = Double.parseDouble(entrada.getText());

            //Switch de decisión de operaciones
            switch (signo) {
                case '+' -> resultado = dato1 + dato2;
                case '-' -> resultado = dato1 - dato2;
                case 'x' -> resultado = dato1 * dato2;
                case '/' -> resultado = dato1 / dato2;
                case '%' -> {
                    int dato0 = (int) dato2;
                    String porce = toString(dato0);
                    dato2 = Double.parseDouble(porce);
                    resultado = dato1 * dato2;
                }
                default -> throw new IllegalStateException("Unexpected value: " + signo);
            }

            //Mensaje de Error a division por 0
            if (signo == '/' && dato2 == 0) {
                entrada.setText("¡Error DIV/0!");
            } else if (signo == '/' || signo == '%') {
                // Verificar si el resultado es entero o decimal para impresión en pantalla
                if (resultado % 1 == 0) {
                    entrada.setText(String.valueOf((int) resultado));
                } else {
                    entrada.setText(String.valueOf(redondear(resultado)));
                }
            } else {
                // Verificar si el resultado es entero o decimal para impresión en pantalla
                if (resultado % 1 == 0) {
                    entrada.setText(String.valueOf((int) resultado));
                } else {
                    entrada.setText(String.valueOf(redondear(resultado)));
                }

            }

            dato1 = resultado; // asignando valor de resultado a dato1 para seguir calculando con forme al resultado

        }

        //boton para eliminar todo los datos en pantalla
        if (e.getSource() == clsButton) {
            entrada.setText("");
        }

        //boton para eliminar dato por dato en pantalla
        if (e.getSource() == delButton) {
            String elimina = entrada.getText();
            entrada.setText("");
            for (int i = 0; i < elimina.length() - 1; i++) {
                entrada.setText(entrada.getText() + elimina.charAt(i));
            }
        }

        //boton para signo negativo
        if (e.getSource() == negaButton) {
            double negative = Double.parseDouble(entrada.getText());
            negative *= -1;
            // Verificar si el resultado es entero o decimal
            if (negative % 1 == 0) {
                entrada.setText(String.valueOf((int) negative));
            } else {
                entrada.setText(String.valueOf(redondear(negative)));
            }
        }

    }

    //toString sobrescrito para trasformado a decimal un entero
    private String toString(int valu) {
        if (valu <= 9) {
            return "0.0" + valu;
        } else {
            return "0." + valu;
        }

    }

    // Función de redondeo a dos decimales
    private static String redondear(double value) {
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.FLOOR);
        return df.format(value);
    }


}
