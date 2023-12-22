package ies.rodriguez.portillo.manuelangel.BolT7_Rodriguez_Portillo_ManuelAngel_ej1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.swing.JTextField;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Nota;
import vista.Loging;
import vista.VistaNotas;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private Loging loging;
    private VistaNotas vista;
    
    
    @BeforeEach
    void setUp() {
        loging = new Loging();
        vista = new VistaNotas();
    }
    
    
    @Test
    void testInicioSesionCorrecto() {
        loging.textFieldUsuario.setText("usuario");
        loging.passwordField.setText("1234");

        loging.btnIniciarSesion.doClick();

        assertFalse(loging.isVisible());
    }
    
    @Test
    void testInicioSesionIncorrecto() {
        loging.textFieldUsuario.setText("usuario");
        loging.passwordField.setText("contrasenaIncorrecta");

        loging.btnIniciarSesion.doClick();

        assertTrue(loging.isVisible());
    }
    
    @Test
    void testCrearInstancia() {
        assertNotNull(loging);
    }
    
    @Test
    void testGuardarNota() {

        vista.TfTitulo.setText("Título de prueba");
        vista.tfCategoria.setText("Categoría de prueba");
        vista.TfContenido.setText("Contenido de prueba");


        vista.guardarNota();

        assertEquals(1, vista.modeloNotas.getNotas().size());
        assertTrue(vista.TfTitulo.getText().isEmpty());
        assertTrue(vista.tfCategoria.getText().isEmpty());
        assertTrue(vista.TfContenido.getText().isEmpty());
    }
    
    @Test
    void testLimpiarCampos() {
        vista.TfTitulo.setText("Título de prueba");
        vista.tfCategoria.setText("Categoría de prueba");
        vista.TfContenido.setText("Contenido de prueba");

        vista.limpiarCampos();

        assertTrue(vista.TfTitulo.getText().isEmpty());
        assertTrue(vista.tfCategoria.getText().isEmpty());
        assertTrue(vista.TfContenido.getText().isEmpty());
    }
    
    @Test
    void testEliminarNotaSeleccionada() {
        Nota notaPrueba = new Nota("Título prueba", "Categoría prueba", "Contenido prueba");
        vista.modeloNotas.agregarNota(notaPrueba);

        vista.list.select(0);

        vista.eliminarNotaSeleccionada();

        assertEquals(0, vista.modeloNotas.getNotas().size());
    }
    
    @Test
    void testSalir() {
        vista.dispose();


        assertFalse(vista.isVisible());
    }
    
    @Test
    void testActualizarLista() {

        Nota nota1 = new Nota("Título 1", "Categoría 1", "Contenido 1");
        Nota nota2 = new Nota("Título 2", "Categoría 2", "Contenido 2");
        vista.modeloNotas.agregarNota(nota1);
        vista.modeloNotas.agregarNota(nota2);


        vista.actualizarLista();

        assertEquals(2, vista.list.getItemCount());
        assertEquals("Título 1", vista.list.getItem(0));
        assertEquals("Título 2", vista.list.getItem(1));
    }


}