package test;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImagingOpException;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        App marco1 = new App();
        marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco1.setVisible(true);
    }

}

class App extends JFrame {


    JMenuBar barra;
    JMenu opciones;
    JMenuItem inicio,prducto,secion,salir;
    Font fuente=new Font("Monospace", Font.BOLD, 16);

    public App() {
        super("App");
        setTitle("FerreV");
        setResizable(false);
        //menu
        barra =new JMenuBar();
        opciones=new JMenu("Options");
        opciones.setFont(fuente);
        inicio=new JMenuItem("Home");
        inicio.setFont(fuente);
        prducto=new JMenuItem("Product");
        prducto.setFont(fuente);
        secion=new JMenuItem("Account");
        secion.setFont(fuente);
        salir=new JMenuItem("Exit");
        salir.setFont(fuente);


        this.add(barra);
        barra.add(opciones);
        opciones.add(inicio);
        opciones.add(prducto);
        opciones.add(secion);
        opciones.add(salir);
        setJMenuBar(barra);

        //menu
        Toolkit pantalla = Toolkit.getDefaultToolkit();
        Dimension anchoLargo = pantalla.getScreenSize();
        int altura = anchoLargo.height;
        int ancho = anchoLargo.width;
        setSize(ancho / 2, altura);// Dimencion Generada obteniendi resolucion
        setLocation(ancho / 4, 0);

        try {
            Image icono = pantalla.getImage("src/img/erramientas.jpg");
            setIconImage(icono);
        } catch (ImagingOpException e) {
            e.notify();
        }

        Home home=new Home();
        add(home);
        inicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Home home1=new Home();
                marcado(home1);
            }
        });
        prducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Product product=new Product();
               marcado(product);
            }
        });

        secion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user=new User();
                marcado(user);
            }
        });
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);



    }



    public void marcado(JPanel panel){
        getContentPane().removeAll();
        getContentPane().add(panel);
        getContentPane().repaint();
        getContentPane().revalidate();
    }
}

class User extends JPanel {
    Font fuente=new Font("Arial", Font.ITALIC, 16);
    Font fuente1=new Font("Arial", Font.ITALIC, 20);
    private Image account,background;
    public User() {

        setLayout(null);

        setPreferredSize(new Dimension(getWidth(), getHeight())); // ajusta el tamaño



        JLabel titulo=new JLabel("Customer Login");
        titulo.setFont(fuente1);
        titulo.setBounds(250,305,200,40);
        JLabel name = new JLabel("Name");
        name.setFont(fuente);
        name.setBounds(150,350,100,40);
        JLabel contracena = new JLabel("Passowrd");
        contracena.setFont(fuente);
        contracena.setBounds(150,390,100,40);
        JTextField naMe = new JTextField();
        naMe.setFont(fuente);
        naMe.setBounds(250,350,250,30);
        JTextField contraCena = new JTextField();
        contraCena.setFont(fuente);

        contraCena.setBounds(250,390,250,30);
        JButton entra=new JButton("Sign/In");
        entra.setFont(fuente);
        entra.setBounds(280,450,100,30);
        entra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Gracia por Preferirnos "+naMe.getText());

            }
        });

        try {
            background=ImageIO.read(new File("src/img/tools-fondo.jpg"));
            account = ImageIO.read(new File("src/img/circle-user.png"));
        } catch (IOException e) {
            e.printStackTrace(); // Imprime la pila de excepciones en la consola
        }
        add(titulo);
        add(name);
        add(naMe);
        add(contracena);
        add(contraCena);
        add(entra);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(background,0,0,getWidth(),getHeight(),null);
        g.setColor(new Color(210, 222, 234));
        g.fillRect(100, 300, 450, 200);
        g.setColor(new Color(255, 255, 255));
        g.fillOval(getWidth()/3, 50, 249, 199);
        g.drawImage(account, getWidth()/3, 50, 250, 200, this);
    }
}

class Home extends JPanel{
    Image background;
    Font fuente=new Font("Monospace", Font.BOLD, 25);

    public Home() {
        setBackground(new Color(0,0,0));
        setLayout(null);

        JLabel slogan=new JLabel("¡Donde encontrarán todo lo que necesitan!");
        slogan.setForeground(new Color(255,0,0));

        slogan.setFont(fuente);
        slogan.setBounds(90,400,520,300);


        try {
            background = ImageIO.read(new File("src/img/Welcome1.jpg"));

        } catch (IOException e) {
            e.printStackTrace(); // Imprime la pila de excepciones en la consola
        }
        add(slogan);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(background,0,150,getWidth(),getHeight()/2,null);
    }

}

class Product extends JPanel{
    Image producto1,producto2,producto3,producto4,producto5,producto6;
    Font fuente=new Font("Arial", Font.ITALIC, 20);
    public Product(){
        setBackground(new Color(0,0,0));
        setLayout(null);
        JLabel titulo=new JLabel(new ImageIcon("src/img/tituloProduct.jpg"));
        titulo.setBounds(25,10,600,30);
        JLabel pie=new JLabel(new ImageIcon("src/img/pieProduct.jpg"));
        pie.setBounds(0,550,700,200);
        JButton btn1=new JButton("buy it");
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Agregado al carrito");
            }
        });
        btn1.setBounds(60,235,150,25);
        JButton btn2=new JButton("buy it");
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Agregado al carrito");
            }
        });
        btn2.setBounds(240,235,150,25);
        JButton btn3=new JButton("buy it");
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Agregado al carrito");
            }
        });
        btn3.setBounds(420,235,150,25);
        JButton btn4=new JButton("buy it");
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Agregado al carrito");
            }
        });
        btn4.setBounds(60,480,150,25);
        JButton btn5=new JButton("buy it");
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Agregado al carrito");
            }
        });
        btn5.setBounds(240,480,150,25);
        JButton btn6=new JButton("buy it");
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Agregado al carrito");
            }
        });
        btn6.setBounds(420,480,150,25);
        add(titulo);
        add(pie);
        add(btn1);
        add(btn2);
        add(btn3);
        add(btn4);
        add(btn5);
        add(btn6);


        try {
            producto1=ImageIO.read(new File("src/img/Producto1.jpg"));
            producto2 = ImageIO.read(new File("src/img/Producto2.jpg"));
            producto3=ImageIO.read(new File("src/img/Producto3.jpg"));
            producto4 = ImageIO.read(new File("src/img/Producto4.jpg"));
            producto5=ImageIO.read(new File("src/img/Producto5.jpg"));
            producto6 = ImageIO.read(new File("src/img/Producto6.jpg"));
        } catch (IOException e) {
            e.printStackTrace(); // Imprime la pila de excepciones en la consola
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(producto1,60,50,150,200,null);
        g.drawImage(producto2,240,50,150,190,null);
        g.drawImage(producto3,420,50,150,200,null);
        g.drawImage(producto4,60,280,150,200,null);
        g.drawImage(producto5,240,280,150,200,null);
        g.drawImage(producto6,420,280,150,200,null);
    }
}


