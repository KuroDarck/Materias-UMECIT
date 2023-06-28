package test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImagingOpException;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    JMenuItem inicio, prducto, secion, salir;
    Font fuente = new Font("Monospace", Font.BOLD, 18);
    Font fuente2 = new Font("Monospace", Font.BOLD, 16);
    Color colorListaOpciones = new Color(3, 18, 255);

    public App() {
        super("App");
        setTitle("FerreV");
        setResizable(false);
        //menu
        barra = new JMenuBar();
        barra.setBackground(new Color(252, 67, 67));
        opciones = new JMenu("Options");
        opciones.setFont(fuente);
        inicio = new JMenuItem("Home");
        inicio.setFont(fuente2);
        inicio.setForeground(colorListaOpciones);
        prducto = new JMenuItem("Product");
        prducto.setFont(fuente2);
        prducto.setForeground(colorListaOpciones);
        secion = new JMenuItem("Account");
        secion.setFont(fuente2);
        secion.setForeground(colorListaOpciones);
        salir = new JMenuItem("Exit");
        salir.setFont(fuente2);
        salir.setForeground(colorListaOpciones);


        this.add(barra);
        barra.add(opciones);
        opciones.add(inicio);
        opciones.add(prducto);
        opciones.add(secion);
        opciones.add(salir);
        opciones.setForeground(new Color(0, 0, 0));
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

        Home home = new Home();
        add(home);
        inicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Home home1 = new Home();
                marcado(home1);
            }
        });
        prducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Product product = new Product();
                marcado(product);
            }
        });

        secion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = new User();
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


    public void marcado(JPanel panel) {
        getContentPane().removeAll();
        getContentPane().add(panel);
        getContentPane().repaint();
        getContentPane().revalidate();
    }
}

class User extends JPanel {
    Font fuente = new Font("Arial", Font.ITALIC, 16);
    Font fuente1 = new Font("Arial", Font.ITALIC, 20);
    private Image account, background;

    public User() {
        setLayout(null);
        setPreferredSize(new Dimension(getWidth(), getHeight())); // ajusta el tamaño

        JLabel titulo = new JLabel("Customer Log-Up");
        titulo.setFont(fuente1);
        titulo.setBounds(250, 305, 200, 40);

        JLabel name = new JLabel("Primer Nombre:");
        name.setFont(fuente);
        name.setBounds(150, 350, 150, 40);

        JLabel middleName = new JLabel("Segundo Nombre:");
        middleName.setFont(fuente);
        middleName.setBounds(150, 390, 150, 40);

        JLabel lastName = new JLabel("Primer Apellido:");
        lastName.setFont(fuente);
        lastName.setBounds(150, 430, 150, 40);

        JLabel secondLastName = new JLabel("Segundo Apellido:");
        secondLastName.setFont(fuente);
        secondLastName.setBounds(150, 470, 150, 40);

        JLabel personalId = new JLabel("ID:");
        personalId.setFont(fuente);
        personalId.setBounds(150, 510, 250, 40);

        JTextField firstNameField = new JTextField();
        firstNameField.setFont(fuente);
        firstNameField.setBounds(330, 350, 250, 30);

        JTextField middleNameField = new JTextField();
        middleNameField.setFont(fuente);
        middleNameField.setBounds(330, 390, 250, 30);

        JTextField lastNameField = new JTextField();
        lastNameField.setFont(fuente);
        lastNameField.setBounds(330, 430, 250, 30);

        JTextField secondLastNameField = new JTextField();
        secondLastNameField.setFont(fuente);
        secondLastNameField.setBounds(330, 470, 250, 30);

        JTextField personalIdField = new JTextField();
        personalIdField.setFont(fuente);
        personalIdField.setBounds(330, 510, 250, 30);

        // Boton de registro
        JButton entra = new JButton("Sign/In");
        entra.setFont(fuente);
        entra.setBounds(280, 580, 100, 30);
        entra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Registrar los datos en la base de datos
                boolean registroExitoso = registrarUsuario(
                        firstNameField.getText(),
                        middleNameField.getText(),
                        lastNameField.getText(),
                        secondLastNameField.getText(),
                        personalIdField.getText()
                );

                if (registroExitoso) {
                    JOptionPane.showMessageDialog(null, "¡Gracias por preferirnos y por completar el registro de usuario con éxito!");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo realizar el registro. Por favor, inténtelo de nuevo.");
                }
            }
        });

        try {
            background = ImageIO.read(new File("src/img/tools-fondo.jpg"));
            account = ImageIO.read(new File("src/img/circle-user.png"));
        } catch (IOException e) {
            e.printStackTrace(); // Imprime la pila de excepciones en la consola
        }

        add(titulo);
        add(name);
        add(firstNameField);
        add(middleName);
        add(middleNameField);
        add(lastName);
        add(lastNameField);
        add(secondLastName);
        add(secondLastNameField);
        add(personalId);
        add(personalIdField);

        add(entra);
    }

    private boolean registrarUsuario(String firstName, String middleName, String lastName, String secondLastName, String personalId) {
        String url = "jdbc:mysql://localhost:3306/nombre_base_de_datos";
        String usuario = "nombre_usuario";
        String contraseña = " ";

        try {
            // Establecer la conexión con la base de datos
            Connection conn = DriverManager.getConnection(url, usuario, contraseña);

            // Preparar la sentencia SQL para la inserción de datos
            String sql = "INSERT INTO Usuario_Ferreteria (primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, id) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, firstName);
            stmt.setString(2, middleName);
            stmt.setString(3, lastName);
            stmt.setString(4, secondLastName);
            stmt.setString(5, personalId);

            // Ejecutar la sentencia SQL
            int filasAfectadas = stmt.executeUpdate();

            // Cerrar la conexión y el statement
            stmt.close();
            conn.close();

            // Verificar si se insertó al menos una fila
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
        g.setColor(new Color(195, 246, 247));
        g.fillRect(95, 230, 500, 250);
        g.setColor(new Color(3, 18, 255));
        g.fillOval(getWidth() / 3, 40, 199, 150);
        g.drawImage(account, getWidth() / 3, 40, 200, 150, this);
    }
}


class Home extends JPanel {
    Image background;
    Font fuente = new Font("Monospace", Font.BOLD, 25);

    public Home() {
        setBackground(new Color(0, 0, 0));
        setLayout(null);

        JLabel slogan = new JLabel("¡Donde encontrarán todo lo que necesitan!");
        slogan.setForeground(new Color(255, 0, 0));

        slogan.setFont(fuente);
        slogan.setBounds(90, 400, 520, 300);


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

        g.drawImage(background, 0, 150, getWidth(), getHeight() / 2, null);
    }

}

class Product extends JPanel {
    Image producto1, producto2, producto3, producto4, producto5, producto6;
    Font fuente = new Font("Arial", Font.ITALIC, 20);

    public Product() {
        setBackground(new Color(0, 0, 0));
        setLayout(null);
        JLabel titulo = new JLabel(new ImageIcon("src/img/tituloProduct.jpg"));
        titulo.setBounds(25, 10, 600, 30);
        JLabel pie = new JLabel(new ImageIcon("src/img/pieProduct.jpg"));
        pie.setBounds(0, 550, 700, 200);
        JButton btn1 = new JButton("buy it");
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Agregado al carrito");
            }
        });
        btn1.setBounds(60, 235, 150, 25);
        JButton btn2 = new JButton("buy it");
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Agregado al carrito");
            }
        });
        btn2.setBounds(240, 235, 150, 25);
        JButton btn3 = new JButton("buy it");
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Agregado al carrito");
            }
        });
        btn3.setBounds(420, 235, 150, 25);
        JButton btn4 = new JButton("buy it");
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Agregado al carrito");
            }
        });
        btn4.setBounds(60, 480, 150, 25);
        JButton btn5 = new JButton("buy it");
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Agregado al carrito");
            }
        });
        btn5.setBounds(240, 480, 150, 25);
        JButton btn6 = new JButton("buy it");
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Agregado al carrito");
            }
        });
        btn6.setBounds(420, 480, 150, 25);
        add(titulo);
        add(pie);
        add(btn1);
        add(btn2);
        add(btn3);
        add(btn4);
        add(btn5);
        add(btn6);


        try {
            producto1 = ImageIO.read(new File("src/img/Producto1.jpg"));
            producto2 = ImageIO.read(new File("src/img/Producto2.jpg"));
            producto3 = ImageIO.read(new File("src/img/Producto3.jpg"));
            producto4 = ImageIO.read(new File("src/img/Producto4.jpg"));
            producto5 = ImageIO.read(new File("src/img/Producto5.jpg"));
            producto6 = ImageIO.read(new File("src/img/Producto6.jpg"));
        } catch (IOException e) {
            e.printStackTrace(); // Imprime la pila de excepciones en la consola
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(producto1, 60, 50, 150, 200, null);
        g.drawImage(producto2, 240, 50, 150, 190, null);
        g.drawImage(producto3, 420, 50, 150, 200, null);
        g.drawImage(producto4, 60, 280, 150, 200, null);
        g.drawImage(producto5, 240, 280, 150, 200, null);
        g.drawImage(producto6, 420, 280, 150, 200, null);
    }
}


