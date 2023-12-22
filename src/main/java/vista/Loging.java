package vista;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class Loging extends JFrame {

    private static final long serialVersionUID = 1L;
    public JPanel contentPane;
    public JTextField textFieldUsuario;
    public JPasswordField passwordField;
    public JButton btnIniciarSesion;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Loging frame = new Loging();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Loging() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 622, 496);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        textFieldUsuario = new JTextField();
        textFieldUsuario.setBackground(new Color(231, 231, 231));
        textFieldUsuario.setBounds(158, 166, 342, 44);
        contentPane.add(textFieldUsuario);
        textFieldUsuario.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBackground(new Color(231, 231, 231));
        passwordField.setBounds(158, 252, 342, 44);
        contentPane.add(passwordField);

        btnIniciarSesion = new JButton("LOGIN");
        btnIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnIniciarSesion.setBackground(new Color(32, 121, 179));
        btnIniciarSesion.setBounds(111, 346, 389, 50);
        btnIniciarSesion.setForeground(new Color(255, 255, 255));

        contentPane.add(btnIniciarSesion);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBackground(new Color(255, 255, 255));
        lblNewLabel.setIcon(new ImageIcon(Loging.class.getResource("/imagenes/login2.jpg")));
        lblNewLabel.setBounds(0, -20, 617, 500);
        contentPane.add(lblNewLabel);

        btnIniciarSesion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Verificar usuario y contraseña
                String usuario = textFieldUsuario.getText();
                String contraseña = new String(passwordField.getPassword());

                if (usuario.equals("usuario") && contraseña.equals("1234")) {
                    dispose();
                    JOptionPane.showMessageDialog(null, "Inicio de sesión correcto");
                    VistaNotas vista2 = new VistaNotas();
                    vista2.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                }
            }
        });
    }
}
