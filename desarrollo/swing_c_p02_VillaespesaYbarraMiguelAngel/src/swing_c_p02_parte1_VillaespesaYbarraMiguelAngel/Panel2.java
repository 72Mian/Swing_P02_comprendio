/**
* Proyecto: 
* Archivo: 
* Autor/a: Miguel Ángel Villaespesa Ybarra
* Fecha: 30 nov 2025 19:09:39
*
* Descripción:
* [Resumen breve del propósito de este archivo/clase.]
*
* Licencia:
* [Indica la licencia o condiciones de uso si procede.]
*/
package swing_c_p02_parte1_VillaespesaYbarraMiguelAngel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 * Clase Panel2.
 */
public class Panel2 extends JPanel {
	
	/**Etiquetas. */
	JLabel nombre, apellidos, dni, telefono;
	
	/** Campos de texto. */
	JTextField nombreField, apellidosField;
	
	/** Campos con formato */
	JFormattedTextField dniField, telefonoField;
	
	/**
	 * Panel2.
	 */
	public Panel2() {
		this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints(); 
        gbc.insets = new Insets(5, 5, 5, 5); 
        gbc.anchor = GridBagConstraints.WEST;
        
		nombre = new JLabel("Nombre: ");
		nombreField = new JTextField(20);
		nombre.setLabelFor(nombreField);
		nombre.setDisplayedMnemonic('N');
		apellidos = new JLabel("Apellidos: ");
		apellidosField = new JTextField(20);
		apellidos.setLabelFor(apellidosField);
		apellidos.setDisplayedMnemonic('A');
		dni = new JLabel("DNI:");
		try {
			MaskFormatter formatoDni = new MaskFormatter("########U");
			formatoDni.setPlaceholderCharacter('_');
			dniField = new JFormattedTextField(formatoDni);
			} catch (ParseException e) {
			dniField = new JFormattedTextField();
			}
		dni.setLabelFor(dniField);
		dni.setDisplayedMnemonic('D'); 
		telefono = new JLabel("Teléfono:");
		try {
			MaskFormatter formatoTelefono = new MaskFormatter("#########");
			telefonoField = new JFormattedTextField(formatoTelefono);
			telefonoField.setColumns(9);
			} catch (ParseException e) {
			telefonoField = new JFormattedTextField();
			}
		telefono.setLabelFor(telefonoField);
		telefono.setDisplayedMnemonic('T');
		gbc.gridx = 0; gbc.gridy = 0;
        gbc.fill = GridBagConstraints.NONE; 
        gbc.weightx = 0; // 
        this.add(nombre, gbc);

        gbc.gridx = 1; gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL; 
        gbc.weightx = 1.0; 
        this.add(nombreField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        this.add(apellidos, gbc);

        gbc.gridx = 1; gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        this.add(apellidosField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        this.add(dni, gbc);

        gbc.gridx = 1; gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        this.add(dniField, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        this.add(telefono, gbc);

        gbc.gridx = 1; gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        this.add(telefonoField, gbc);
		

		
	}
	
	/**
	 * getNombreField.
	 *
	 * @return the nombre field
	 */
	public JTextField getNombreField() {
		return nombreField;
	}
	
	/**
	 * getApellidosField.
	 *
	 * @return the apellidos field
	 */
	public JTextField getApellidosField() {
		return apellidosField;
	}
	
	/**
	 * getDniField.
	 *
	 * @return the dni field
	 */
	public JFormattedTextField getDniField() {
		return dniField;
	}
	
	/**
	 * getTelefonoField.
	 *
	 * @return the telefono field
	 */
	public JFormattedTextField getTelefonoField() {
		return telefonoField;
	}
	
	/**
	 * nuevoArrendador.
	 */
	public void nuevoArrendador() {
		nombreField.setText("");
		apellidosField.setText("");
		dniField.setText("");
		telefonoField.setText("");
		nombreField.requestFocus();
	}
	
	

}
