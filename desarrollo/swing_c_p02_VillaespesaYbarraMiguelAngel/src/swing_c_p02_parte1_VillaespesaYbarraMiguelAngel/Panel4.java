/**
* Proyecto: 
* Archivo: 
* Autor/a: Miguel Ángel Villaespesa Ybarra
* Fecha: 30 nov 2025 19:14:06
*
* Descripción:
* [Resumen breve del propósito de este archivo/clase.]
*
* Licencia:
* [Indica la licencia o condiciones de uso si procede.]
*/
package swing_c_p02_parte1_VillaespesaYbarraMiguelAngel;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;



/**
 * Clase Panel4.
 */
public class Panel4  extends JPanel {
	
	/** El tabbedPane para el resumen. */
	private JTabbedPane resumen;
	
	/** Etiquetas. */
	private JLabel nombre, apellidos, dni, telefono, direccion, precioMinimo, fechaAlta, fechaFinal, provincia, tipoCamas, huespedes, dormitorio, baños, camas, niños;
	
	/** panel 2. */
	private Panel2 panel2;
	
	/** panel 3. */
	private Panel3 panel3;
	
	/** panel inmueble y arrendador. */
	private JPanel panelArrendador, panelInmueble;
	
	/**
	 * Panel4.
	 *
	 * @param datosA the datos A
	 * @param datosI the datos I
	 */
	public Panel4(Panel2 datosA, Panel3 datosI) {
		this.panel2 = datosA;
		this.panel3 = datosI;
		resumen = new JTabbedPane();
		panelArrendador = new JPanel();
		panelInmueble = new JPanel();
		inicializarComponentesPanelArrendador();
		inicializarComponentesPanelInmueble();
		
		resumen.addTab("Arrendador", panelArrendador);
		resumen.addTab("Inmueble", panelInmueble);
		this.add(resumen);
		
	}
	
	/**
	 * inicializarComponentesPanelArrendador.
	 */
	public void inicializarComponentesPanelArrendador() {
		
		panelArrendador.setLayout(new GridLayout(0, 1, 0, 5));
		nombre = new JLabel("Nombre: ");
		apellidos = new JLabel("Apellidos: ");
		dni = new JLabel("DNI: ");
		telefono = new JLabel("Telefono: ");
		panelArrendador.add(nombre);
		panelArrendador.add(apellidos);
		panelArrendador.add(dni);
		panelArrendador.add(telefono);
	}
	
	/**
	 * inicializarComponentesPanelInmueble.
	 */
	public void inicializarComponentesPanelInmueble() {
		
		panelInmueble.setLayout(new GridLayout(0, 1, 0, 5));
		direccion = new JLabel("Direccion: ");
		provincia = new JLabel("Provincia: ");
		fechaAlta = new JLabel("Fecha Alta: ");
		fechaFinal = new JLabel("Fecha Final Disponibilidad: ");
		huespedes = new JLabel("Nº de Huéspedes: ");
		dormitorio = new JLabel("Nº de Dormitorios: ");
		baños = new JLabel("Nº de Baños: ");
		camas = new JLabel("Nº de Camas: ");
		tipoCamas = new JLabel("Tipo de Camas: ");
		precioMinimo = new JLabel("Precio Mínimo: ");
		
		panelInmueble.add(direccion);
		panelInmueble.add(provincia);
		panelInmueble.add(fechaAlta);
		panelInmueble.add(fechaFinal);
		panelInmueble.add(huespedes);
		panelInmueble.add(dormitorio);
		panelInmueble.add(baños);
		panelInmueble.add(camas);
		panelInmueble.add(tipoCamas);
		panelInmueble.add(precioMinimo);
		
		
	}
	
	/**
	 * validarTodosLosDatos.
	 *
	 * @return true, if validar todos los datos
	 */
	public boolean validarTodosLosDatos() {
        
        if (!esValido(panel2.getNombreField())) return false;
        if (!esValido(panel2.getApellidosField())) return false;
        if (!esValido(panel2.getDniField())) return false;
        if (!esValido(panel2.getTelefonoField())) return false;
 
        if (!esValido(panel3.getDireccionField())) return false;
        
        return true;
    }

    /**
	 * esValido.
	 *
	 * @param campo the campo
	 * @return true, if es valido
	 */
    private boolean esValido(JComponent campo) {
    	JTextField tf = (JTextField) campo;
        String texto = tf.getText().trim();
        if (texto.isEmpty()) {
            campo.setBorder(BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(campo, "Este campo es obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        campo.setBorder(UIManager.getBorder("TextField.border"));
        return true;
    }


    /**
	 * volcarDatos.
	 */
    public void volcarDatos() {
        nombre.setText("Nombre: " + panel2.getNombreField().getText());
        apellidos.setText("Apellidos: " + panel2.getApellidosField().getText());
        dni.setText("DNI: " + panel2.getDniField().getText());
        telefono.setText("Teléfono: " + panel2.getTelefonoField().getText());

        direccion.setText("Dirección: " + panel3.getDireccionField().getText());
        
 
        provincia.setText("Provincia: " + panel3.getProvinciaCombo());
        
        fechaAlta.setText("Fecha Alta: " + panel3.getFechaAltaField().getText());
        fechaFinal.setText("Fecha Final: " + panel3.getFechaFinalField().getText());
        
        // Spinners
        huespedes.setText("Huéspedes: " + panel3.getNumHuespedesSpinner());
        dormitorio.setText("Dormitorios: " + panel3.getNumDormitorioSpinner());
        baños.setText("Baños: " + panel3.getNumBañosSpinner());
        camas.setText("Camas: " + panel3.getNumCamaSpinner());

        String tipos = "";
        tipos += panel3.getTipoCamasCombo().getSelectedItem();
        if (panel3.getTipoCamasCombo2().isVisible()) {
        	tipos += ", " + panel3.getTipoCamasCombo2().getSelectedItem();
        }
        if (panel3.getTipoCamasCombo3().isVisible()) {
        	tipos += ", " + panel3.getTipoCamasCombo3().getSelectedItem();
        }
        if (panel3.getTipoCamasCombo4().isVisible()) {
        	tipos += ", " + panel3.getTipoCamasCombo4().getSelectedItem();
        }
        
        tipoCamas.setText("Tipos cama: " + tipos);
        
       
        precioMinimo.setText("Precio Minimo: " + panel3.getPrecioMinimoField().getText());
    }

}
