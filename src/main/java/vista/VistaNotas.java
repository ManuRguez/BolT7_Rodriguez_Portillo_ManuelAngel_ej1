package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import modelo.ModeloNotas;
import modelo.Nota;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VistaNotas extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public JTextField TfTitulo;
    public JTextField tfCategoria;
    public JTextField TfContenido;
    public List list;
    public JCheckBox chckbxNewCheckBox;
    public JButton btnAdd;
    public JButton btnSalir;
    public JButton btnLimpiar;
    public JButton btnEliminar;
    public ModeloNotas modeloNotas = new ModeloNotas();
    public Color colorFondoNormal = new Color(83, 173, 235);
    public Color colorTextoNormal = Color.BLACK;
    public JLabel lblTitulo,lblCategoria,lblContenido;


    private Color colorFondoModoOscuro = Color.DARK_GRAY;
    private Color colorTextoModoOscuro = Color.WHITE;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VistaNotas frame = new VistaNotas();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public VistaNotas() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 677, 393);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        menuBar.setBackground(new Color(255, 236, 204));
        
        JMenu mnNewMenu = new JMenu("Opciones");
        mnNewMenu.setBackground(new Color(255, 236, 204));
        menuBar.add(mnNewMenu);
      
       

        JMenuItem menuGuardar = new JMenuItem("Guardar");
        mnNewMenu.add(menuGuardar);
        menuGuardar.setBackground(new Color(255, 236, 204));
        menuGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarNota();
            }
        });

        JMenuItem menuLimpiar = new JMenuItem("Limpiar");
        mnNewMenu.add(menuLimpiar);
        menuLimpiar.setBackground(new Color(255, 236, 204));
        menuLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });

        JMenuItem menuSalir = new JMenuItem("Salir");
        mnNewMenu.add(menuSalir);
        menuSalir.setBackground(new Color(255, 236, 204));
        menuSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JMenu mnModoOscuro = new JMenu("Modo oscuro");
        menuBar.add(mnModoOscuro);
        mnModoOscuro.setBackground(new Color(255, 236, 204));

        chckbxNewCheckBox = new JCheckBox("Activar Modo Oscuro");
        mnModoOscuro.add(chckbxNewCheckBox);
        chckbxNewCheckBox.setBackground(new Color(255, 236, 204));
        chckbxNewCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cambiarModoOscuro();
            }
        });

        chckbxNewCheckBox.requestFocusInWindow();

        JMenu mnAcercaDe = new JMenu("Acerca de");
        menuBar.add(mnAcercaDe);
        mnAcercaDe.setBackground(new Color(255, 236, 204));

        JPanel acercaDePanel = new JPanel();
        acercaDePanel.setBackground(new Color(83, 173, 235));
        acercaDePanel.setLayout(new BorderLayout());

        String acercaDeTexto = "<html><div style='text-align: rigth;'>"
                + "Es una aplicación simple y práctica para gestionar y organizar tus notas personales<br><br>"
                + "Permite agregar, guardar y limpiar notas de manera fácil, proporcionando una interfaz amigable para una experiencia eficiente.<br><br>"
                + "Version: 1.0.0.</div></html>";

        JLabel lblAcercaDe = new JLabel(acercaDeTexto);
        lblAcercaDe.setBackground(new Color(255, 236, 204));
        lblAcercaDe.setOpaque(true);

        acercaDePanel.add(lblAcercaDe, BorderLayout.CENTER);

        mnAcercaDe.add(acercaDePanel);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(83, 173, 235));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblTitulo = new JLabel("Titulo");
        lblTitulo.setFont(new Font("Sylfaen", Font.PLAIN, 18));
        lblTitulo.setBounds(32, 11, 85, 27);
        contentPane.add(lblTitulo);

        TfTitulo = new JTextField();
        TfTitulo.setBounds(131, 12, 235, 20);
        contentPane.add(TfTitulo);
        TfTitulo.setColumns(10);

        lblCategoria = new JLabel("Categoria");
        lblCategoria.setFont(new Font("Sylfaen", Font.PLAIN, 18));
        lblCategoria.setBounds(32, 61, 100, 38);
        contentPane.add(lblCategoria);

        tfCategoria = new JTextField();
        tfCategoria.setColumns(10);
        tfCategoria.setBounds(131, 68, 235, 20);
        contentPane.add(tfCategoria);

        lblContenido = new JLabel("Contenido");
        lblContenido.setFont(new Font("Sylfaen", Font.PLAIN, 18));
        lblContenido.setBounds(32, 110, 100, 30);
        contentPane.add(lblContenido);

        TfContenido = new JTextField();
        TfContenido.setColumns(10);
        TfContenido.setBounds(131, 110, 235, 96);
        contentPane.add(TfContenido);

        btnAdd = new JButton("Añadir Nota");
        btnAdd.setBackground(new Color(255, 236, 204));
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarNota();
            }
        });

        btnAdd.setBounds(249, 224, 114, 23);
        contentPane.add(btnAdd);

        btnSalir = new JButton("Salir");
        btnSalir.setBackground(new Color(255, 236, 204));
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnSalir.setBounds(562, 298, 89, 23);
        contentPane.add(btnSalir);

        list = new List();
        list.setBackground(new Color(255, 255, 255));
        list.setBounds(426, 11, 225, 223);
        contentPane.add(list);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBackground(new Color(255, 236, 204));
        btnLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });
        btnLimpiar.setBounds(141, 224, 88, 23);
        contentPane.add(btnLimpiar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBackground(new Color(255, 236, 204));
        btnEliminar.setBounds(502, 250, 89, 23);
        contentPane.add(btnEliminar);

        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarNotaSeleccionada();
            }
        });
        btnAdd.setToolTipText("Añadir una nueva nota.");
        btnSalir.setToolTipText("Salir de la aplicación.");
        btnLimpiar.setToolTipText("Limpiar los campos de entrada.");
        btnEliminar.setToolTipText("Eliminar la nota seleccionada.");
        TfTitulo.setToolTipText("Titulo para la nota");
        tfCategoria.setToolTipText("Categoria de la nota");
        TfContenido.setToolTipText("Contenido de la nota");

        // Inicializar la lista con las notas existentes
        actualizarLista();

        // Agregar menú emergente al hacer clic derecho
        contentPane.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    mostrarMenuEmergente(e);
                }
            }

            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    mostrarMenuEmergente(e);
                }
            }

            private void mostrarMenuEmergente(MouseEvent e) {
                JPopupMenu menuEmergente = new JPopupMenu();

                JMenuItem guardarItem = new JMenuItem("Guardar");
                guardarItem.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        guardarNota();
                    }
                });
                menuEmergente.add(guardarItem);

                JMenuItem limpiarItem = new JMenuItem("Limpiar");
                limpiarItem.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        limpiarCampos();
                    }
                });
                menuEmergente.add(limpiarItem);

                JMenuItem salirItem = new JMenuItem("Salir");
                salirItem.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        dispose();
                    }
                });
                menuEmergente.add(salirItem);

                menuEmergente.show(VistaNotas.this, e.getX(), e.getY());
            }
        });
    }

    // Método para guardar una nota
    public void guardarNota() {
        // Obtener la información del usuario
        String titulo = TfTitulo.getText();
        String categoria = tfCategoria.getText();
        String contenido = TfContenido.getText();

        // Crear una nueva instancia de Nota
        Nota nuevaNota = new Nota(titulo, categoria, contenido);

        // Agregar la nota al modelo de notas
        modeloNotas.agregarNota(nuevaNota);

        // Actualizar la lista con las notas existentes
        actualizarLista();

        // Limpiar los campos de texto
        TfTitulo.setText("");
        tfCategoria.setText("");
        TfContenido.setText("");
    }

    // Método para limpiar los campos de texto
    public void limpiarCampos() {
        TfTitulo.setText("");
        tfCategoria.setText("");
        TfContenido.setText("");
    }

    // Método para cambiar al modo oscuro
    private void cambiarModoOscuro() {
        boolean modoOscuroActivado = chckbxNewCheckBox.isSelected();

        // Seleccionar los colores según el modo
        Color colorFondo = modoOscuroActivado ? colorFondoModoOscuro : colorFondoNormal;
        Color colorTexto = modoOscuroActivado ? colorTextoModoOscuro : colorTextoNormal;

        // Aplicar los colores
        contentPane.setBackground(colorFondo);
        TfTitulo.setBackground(new Color(255,255,255));
        tfCategoria.setBackground(new Color(255,255,255));
        TfContenido.setBackground(new Color(255,255,255));
        list.setBackground(new Color(255,255,255));
        btnAdd.setBackground(new Color(210, 245, 255));
        btnSalir.setBackground(new Color(210, 245, 255));
        btnLimpiar.setBackground(new Color(210, 245, 255));
        btnEliminar.setBackground(new Color(210, 245, 255));
        lblTitulo.setForeground(new Color(255,255,255));
        lblCategoria.setForeground(new Color(255,255,255));
        lblContenido.setForeground(new Color(255,255,255));
    }

    // Método para actualizar la lista con las notas existentes
    public void actualizarLista() {
        list.removeAll(); 
        for (Nota nota : modeloNotas.getNotas()) {
            list.add(nota.getTitulo());
        }
    }

    public void eliminarNotaSeleccionada() {
        int indiceSeleccionado = list.getSelectedIndex();

        if (indiceSeleccionado != -1) { // Verificar si se ha seleccionado un elemento
            modeloNotas.eliminarNota(indiceSeleccionado); // Eliminar del modelo
            actualizarLista(); // Actualizar la interfaz gráfica
        } else {
            JOptionPane.showMessageDialog(VistaNotas.this, "Seleccione una nota para eliminar", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
