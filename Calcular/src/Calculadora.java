import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.event.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;




public class Calculadora implements ActionListener {

    JFrame frame; //creacion de la variable Frame para la creacion del form que se nmuestra al usuario
    JTextField entrada; //creacion de la variable entrada para la entrada de datos.
    JButton[] Number=new JButton[10]; // Creacion de el array Number[]
    JButton[] Operators=new JButton[10]; // Creacion de el array Operatos[]


    Font styleFont=new Font("Times New Roman", Font.ITALIC, 25);

    JButton sumbutton,restButton,multButton,divButton,equButton,dotButton,clsButton,delButton,avrButton,negaButton;
    JPanel panel;
    double dato1=0,dato2=0, resultado=0;
    char signo;

    Calculadora(){ // constructor de la clase calculadora

    frame = new JFrame("Calculator RHM");
    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    frame.setSize(400,500);
    frame.setResizable(false);

    frame.setLayout(null);
    entrada=new JTextField();
    entrada.setFont(styleFont);
    entrada.setBackground(Color.DARK_GRAY);
    entrada.setForeground(Color.RED);
    entrada.setBounds(40,50,300,40);


    // Creacion de los Botones de Opreraciones
    sumbutton=new JButton("+");
    restButton=new JButton("-");
    multButton=new JButton("X");
    divButton=new JButton("/");
    dotButton=new JButton(".");
    equButton=new JButton("=");
    clsButton=new JButton("AC");
    delButton=new JButton("C");
    avrButton=new JButton("%");
    negaButton=new JButton("(-)");

    //Colocando los botones en el Array operators
    Operators[0]=sumbutton;
    Operators[1]=restButton;
    Operators[2]=multButton;
    Operators[3]=divButton;
    Operators[4]=dotButton;
    Operators[5]=equButton;
    Operators[6]=clsButton;
    Operators[7]=delButton;
    Operators[8]=avrButton;
    Operators[9]=negaButton;

        //for para trabahar con todos los botones de el Array Operators[]
    for (int i=0;i<10;i++){
        Operators[i].addActionListener(this);
        Operators[i].setFocusable(false);
        Operators[i].setBackground(Color.GREEN);
        Operators[i].setForeground(Color.BLACK);
        Operators[i].setFont(styleFont);
    }

    //for para trabahar con todos los botones de el Array Number[]
    for (int i=0;i<10;i++){
        Number[i]= new JButton(String.valueOf(i));
        Number[i].addActionListener(this);
        Number[i].setFocusable(false);
        Number[i].setFont(styleFont);
    }

    panel=new JPanel(); //creacion del nuevo panel
    panel.setBounds(40,110,300,300); // pocicionamiento del grid o panel
    panel.setLayout(new GridLayout(5,4,10,10)); //dimencionamiento del grid
    panel.setBackground(Color.darkGray); // color de fondo del grid

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
    frame.add(entrada); // agregando el la entrada de texto al form
    frame.setVisible(true); // activa la visibilidad del form

    }

    public static void main(String[] args) {
        Calculadora calculator=new Calculadora(); //creacion del Objeto en la clase main
    }


    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        //bucle For con el cual capturamos el numero escrito por el usuario
        for (int i=0;i<10;i++){
            if (e.getSource()==Number[i]){
            entrada.setText(entrada.getText().concat(String.valueOf(i)));
            }
    }

        //Boton de punto .
        if (e.getSource()==dotButton){
            entrada.setText(entrada.getText().concat("."));
        }

        //Boton de Suma +
        if (e.getSource()==sumbutton){
            dato1=Double.parseDouble(entrada.getText());
            signo='+';
            entrada.setText("");
        }

        //Boton de resta -
        if (e.getSource()==restButton){
            dato1=Double.parseDouble(entrada.getText());
            signo='-';
            entrada.setText("");
        }

        //Boton de Multiplicacion
        if (e.getSource()==multButton){
            dato1=Double.parseDouble(entrada.getText());
            signo='x';
            entrada.setText(" ");
        }

        //Boton de Divicion /
        if (e.getSource()==divButton){
            dato1=Double.parseDouble(entrada.getText());
            signo='/';
            entrada.setText(" ");
        }

        // Boton para calcular el Porcentage %
        if (e.getSource()==avrButton){
            dato1=Double.parseDouble(entrada.getText());
            signo='%';
            entrada.setText(" ");
        }

        //boon de de resultado o igual =
        if (e.getSource()==equButton){
            dato2=Double.parseDouble(entrada.getText());

            //Switch de decicion de operaciones
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

            //Mensaje de Error a divicion por 0
            if (signo=='/' && dato2==0){
                entrada.setText("¡Error DIV/0!");
            }else if (signo=='/' || signo=='%'){
                entrada.setText(String.valueOf(redondear(resultado))); // Aplicacionb del redondeo de decimales
            }
            else {
            entrada.setText(String.valueOf(resultado));

            }

            dato1=resultado; // asignando valor de resultado a dato1 para seguir calculando con forme al resultado
        }

        //boton para eliminar todo los datos en pantalla
        if (e.getSource()==clsButton){
            entrada.setText("");
        }

        //boton para eliminar dato por dato en pantalla
        if (e.getSource()==delButton){
            String elimina=entrada.getText();
            entrada.setText("");
            for(int i=0;i<elimina.length()-1;i++){
               entrada.setText(entrada.getText()+elimina.charAt(i));
            }
        }

        //boton para signo negativo
        if (e.getSource()==negaButton){
           double negative= Double.parseDouble(entrada.getText());
           negative*=-1;
           entrada.setText(String.valueOf(negative));
        }

}
    //toString sobrescrito para trasformado a decimal un entero
    private String toString(int valu) {
        if (valu<=9) {
            return "0.0" + valu;
        }else {
            return "0." + valu;
        }

    }

    // funcion de redondeo a dos decimales
    private static String redondear(double value) {
        DecimalFormat df = new DecimalFormat("0.00");  df.setRoundingMode(RoundingMode.FLOOR);
        return df.format(value);
    }

}
