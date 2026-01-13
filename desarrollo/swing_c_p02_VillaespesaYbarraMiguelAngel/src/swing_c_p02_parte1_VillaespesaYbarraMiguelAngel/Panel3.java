/**
* Proyecto: 
* Archivo: 
* Autor/a: Miguel Ángel Villaespesa Ybarra
* Fecha: 30 nov 2025 19:10:50
*
* Descripción:
* [Resumen breve del propósito de este archivo/clase.]
*
* Licencia:
* [Indica la licencia o condiciones de uso si procede.]
*/
package swing_c_p02_parte1_VillaespesaYbarraMiguelAngel;

import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.classfile.instruction.NewMultiArrayInstruction;
import java.lang.reflect.Array;
import java.security.PublicKey;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Date;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.InputVerifier;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.MaskFormatter;



import java.time.format.ResolverStyle;



/**
 * Clase Panel3.
 */
public class Panel3 extends JPanel implements ChangeListener, FocusListener, ItemListener{
	
	/** Etiquetas. */
	private JLabel direccion, provincia, fechaAlta, fechaFinal, numHuespedes, numDormitorios, numBaños, numCamas, tipoCamas, edadNiños, dormitorioEtiqueta, bañoEtiqueta, balconEtiqueta, precioMinimo;
	
	/** Los campos de texto. */
	JTextField direccionField, extraNiñoField, precioMinimoField;
	
	/** El contador precio. */
	int contadorPrecio;
	
	/** Los campos con formato. */
	JFormattedTextField fechaAltaField, fechaFinalField;
	
	/** Los combobox. */
	private JComboBox<String> provinciaCombo, tipoCamasCombo, tipoCamasCombo2, tipoCamasCombo3, tipoCamasCombo4 ;
	
	/** Los spinners. */
	private JSpinner numHuespedesSpinner, numDormitorioSpinner, numBañosSpinner, numCamaSpinner, edadNiñosSpinner;
	
	/** La lista de provincias. */
	private String listaP[] = {"Álava", "Albacete", "Alicante", "Almería", "Asturias", "Ávila", "Badajoz", "Barcelona", "Burgos", "Cáceres", "Cádiz", "Cantabria", "Castellón", "Ciudad Real", "Córdoba", "Cuenca", "Gerona", "Granada", "Guadalajara", "Guipúzcoa", "Huelva", "Huesca", "Islas Baleares", "Jaén", "La Coruña", "La Rioja", "Las Palmas", "León", "Lérida", "Lugo", "Madrid", "Málaga", "Murcia", "Navarra", "Orense", "Palencia", "Pontevedra", "Salamanca", "Santa Cruz de Tenerife", "Segovia", "Sevilla", "Soria", "Tarragona", "Teruel", "Toledo", "Valencia", "Valladolid", "Vizcaya", "Zamora", "Zaragoza"};
	
	/** La lista de tipos de camas. */
	private String listaTipos[] = {"Cama simple", "Cama doble", "Sofá cama"};
	
	/** El panel tipos camas. */
	private JPanel panelTiposCamas;
	
	/**  niños check. */
	JCheckBox niñosCheck;
	
	/** panel imagenes y extra niños. */
	private JPanel extrasNiños, panelImagenes;
	
	/** Las fechas. */
	LocalDate minFecha, minFechaF;
	
	/** Los formatter para las fechas. */
	DateTimeFormatter formatter, formatterF;
	
	/**
	 * Panel3.
	 */
	public Panel3() {
		this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); 
        gbc.anchor = GridBagConstraints.WEST;
		direccion = new JLabel("Dirección");
		direccionField = new JTextField(20);
		provincia = new JLabel("Provincia");
		provinciaCombo = new JComboBox<String>(listaP);
		fechaAlta = new JLabel("Fecha de Alta");
		try {
			MaskFormatter formatoFecha = new MaskFormatter("##/##/####");
			formatoFecha.setPlaceholderCharacter('_');
			fechaAltaField = new JFormattedTextField(formatoFecha);
			
			} catch (ParseException e) {
			fechaAltaField= new JFormattedTextField();
			}
		
		fechaAlta.setLabelFor(fechaAltaField);
		fechaAltaField.setColumns(10);
		minFecha = LocalDate.now();
		formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		fechaAltaField.setText(minFecha.format(formatter));
		
		fechaAltaField.setInputVerifier(new StrictDateVerifier("dd/MM/uuuu", false, minFecha));
		fechaFinal = new JLabel("Fecha final de disponibilidad");
		try {
			MaskFormatter formatoFecha = new MaskFormatter("##/##/####");
			fechaFinalField = new JFormattedTextField(formatoFecha);
			} catch (ParseException e) {
			fechaFinalField= new JFormattedTextField();
			}
		
		fechaFinal.setLabelFor(fechaFinalField);
		fechaFinalField.setColumns(10);
		minFechaF = LocalDate.of(Year.now().getValue() + 1, LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth());
		
		formatterF = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		fechaFinalField.setText(minFechaF.format(formatterF));
		
		numHuespedes = new JLabel("Nº de huéspedes");
		numHuespedesSpinner = new JSpinner(new SpinnerNumberModel(1,1,8,1));
		numDormitorios = new JLabel("Nº de dormitorios");
		numDormitorioSpinner = new JSpinner(new SpinnerNumberModel(1,1,4,1));
		numBaños = new JLabel("Nº de baños");
		numBañosSpinner = new JSpinner(new SpinnerNumberModel(1,1,3,1));
		numCamas = new JLabel("Nº de camas");
		numCamaSpinner = new JSpinner(new SpinnerNumberModel(1,1,4,1));
		
		tipoCamas = new JLabel("Tipo de Camas: ");
		tipoCamasCombo = new JComboBox<String>(listaTipos);
		tipoCamasCombo2 = new JComboBox<String>(listaTipos);
		tipoCamasCombo3 = new JComboBox<String>(listaTipos);
		tipoCamasCombo4 = new JComboBox<String>(listaTipos);
		
		tipoCamasCombo2.setVisible(false);
		tipoCamasCombo3.setVisible(false);
		tipoCamasCombo4.setVisible(false);
		numCamaSpinner.addChangeListener(this);
		
		panelTiposCamas = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        panelTiposCamas.add(tipoCamasCombo);
        panelTiposCamas.add(tipoCamasCombo2);
        panelTiposCamas.add(tipoCamasCombo3);
        panelTiposCamas.add(tipoCamasCombo4);
        
        niñosCheck = new JCheckBox("¿Niños?");
        niñosCheck.addItemListener(this);
        extrasNiños = new JPanel();
        edadNiños = new JLabel("Edad de niños");
        edadNiñosSpinner = new JSpinner(new SpinnerNumberModel(0,0,10,1));
        extraNiñoField = new JTextField(20);
        extraNiñoField.addFocusListener(this);
        extrasNiños.add(edadNiños);
        extrasNiños.add(edadNiñosSpinner);
        extrasNiños.add(extraNiñoField);
        extrasNiños.setVisible(false);
        panelImagenes = new JPanel();
        ImageIcon dormitorio = new ImageIcon(getClass().getResource("recursos/dormitorio.jpg"));
		Image dormitorioImg = dormitorio.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		dormitorioEtiqueta = new JLabel(new ImageIcon(dormitorioImg));
        panelImagenes.add(dormitorioEtiqueta);
        ImageIcon baño = new ImageIcon(getClass().getResource("recursos/baño.jpg"));
		Image bañoImg = baño.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		bañoEtiqueta = new JLabel(new ImageIcon(bañoImg));
        panelImagenes.add(bañoEtiqueta);
        ImageIcon balcon = new ImageIcon(getClass().getResource("recursos/balcon.jpg"));
		Image balconImg = balcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		balconEtiqueta = new JLabel(new ImageIcon(balconImg));
        panelImagenes.add(balconEtiqueta);
        precioMinimo = new JLabel("Precio Minimo: ");
        precioMinimoField = new JTextField();
        numBañosSpinner.addChangeListener(this);
        tipoCamasCombo.addItemListener(this);
        tipoCamasCombo2.addItemListener(this);
        tipoCamasCombo3.addItemListener(this);
        tipoCamasCombo4.addItemListener(this);
        calcularPrecio();
        
        
        
        	
        
        
        
        
		
		
		
		
		
		gbc.gridx = 0; gbc.gridy = 0;
        this.add(direccion, gbc);
        
        gbc.gridx = 1; gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(direccionField, gbc);
        
        gbc.gridwidth = 1; 
        gbc.fill = GridBagConstraints.NONE;

        
        gbc.gridx = 0; gbc.gridy = 1;
        this.add(provincia, gbc);
        
        gbc.gridx = 1; gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(provinciaCombo, gbc);
        gbc.fill = GridBagConstraints.NONE; 

        gbc.gridx = 0; gbc.gridy = 2;
        this.add(fechaAlta, gbc);
        gbc.gridx = 1; gbc.gridy = 2;
        this.add(fechaAltaField, gbc);

        gbc.gridx = 2; gbc.gridy = 2;
        this.add(fechaFinal, gbc);
        gbc.gridx = 3; gbc.gridy = 2;
        this.add(fechaFinalField, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        this.add(numHuespedes, gbc);
        gbc.gridx = 1; gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        this.add(numHuespedesSpinner, gbc);

        gbc.gridx = 2; gbc.gridy = 3;
        this.add(numDormitorios, gbc);
        gbc.gridx = 3; gbc.gridy = 3;
        this.add(numDormitorioSpinner, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        this.add(numBaños, gbc);
        gbc.gridx = 1; gbc.gridy = 4;
        this.add(numBañosSpinner, gbc);

        gbc.gridx = 2; gbc.gridy = 4;
        this.add(numCamas, gbc);
        gbc.gridx = 3; gbc.gridy = 4;
        this.add(numCamaSpinner, gbc);

        gbc.gridx = 0; gbc.gridy = 5;
        this.add(tipoCamas, gbc);
        
        gbc.gridx = 1; gbc.gridy = 5;
        gbc.gridwidth = 3; 
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(panelTiposCamas, gbc);
        
        gbc.gridx = 1; gbc.gridy = 6;
        this.add(niñosCheck, gbc);
        
        gbc.gridx = 1; gbc.gridy = 7;
        this.add(extrasNiños, gbc);
        
        gbc.gridx = 1; gbc.gridy = 8;
        this.add(panelImagenes, gbc);
        
        gbc.gridx = 1; gbc.gridy = 9;
        this.add(precioMinimo, gbc);
        gbc.gridx = 2; gbc.gridy = 9;
        this.add(precioMinimoField, gbc);
        
		
		
		
	}
	
	/**
	 * stateChanged.
	 *
	 * @param e the e
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		
		if ((int)numCamaSpinner.getValue() == 1) {
			tipoCamasCombo.setVisible(true);
			tipoCamasCombo2.setVisible(false);
			tipoCamasCombo3.setVisible(false);
			tipoCamasCombo4.setVisible(false);
		}
		if ((int)numCamaSpinner.getValue() == 2) {
			tipoCamasCombo.setVisible(true);
			tipoCamasCombo2.setVisible(true);
			tipoCamasCombo3.setVisible(false);
			tipoCamasCombo4.setVisible(false);
		}
		if ((int)numCamaSpinner.getValue() == 3) {
			tipoCamasCombo.setVisible(true);
			tipoCamasCombo2.setVisible(true);
			tipoCamasCombo3.setVisible(true);
			tipoCamasCombo4.setVisible(false);
		}
		if ((int)numCamaSpinner.getValue() == 4) {
			tipoCamasCombo.setVisible(true);
			tipoCamasCombo2.setVisible(true);
			tipoCamasCombo3.setVisible(true);
			tipoCamasCombo4.setVisible(true);
		}
		calcularPrecio();
		
		
	}
	
	/**
	 * Clase StrictDateVerifier.
	 */
	public class StrictDateVerifier extends InputVerifier {
		 
 		/** El formatter. */
 		private final DateTimeFormatter fmt;
		 
 		/** Fecha. */
 		private final LocalDate minDate; 
		 
 		/** Permitir vacio. */
 		private final boolean allowEmpty;
		 
 		/**
		 * StrictDateVerifier.
		 *
		 * @param pattern    the pattern
		 * @param allowEmpty the allow empty
		 * @param minDate    the min date
		 */
 		public StrictDateVerifier(String pattern, boolean allowEmpty, LocalDate minDate) {
		 
		 this.fmt = DateTimeFormatter.ofPattern(pattern).withResolverStyle(ResolverStyle.STRICT);
		 this.allowEmpty = allowEmpty;
		 this.minDate = minDate;
		 }
		 
 		/**
		 * verify.
		 *
		 * @param input the input
		 * @return true, if verify
		 */
 		@Override
		 public boolean verify(JComponent input) {
		 String s = ((JTextField) input).getText().trim();
		 if (s.isEmpty()) return allowEmpty;
		 try {
		 LocalDate d = LocalDate.parse(s, fmt); 
		 if (minDate != null && d.isBefore(minDate)) throw new IllegalArgumentException("Fecha mínima: " + minDate);
		 ok(input); return true;
		 } catch (Exception ex) {
		 error(input, "Fecha inválida o fuera de rango.");
		 return false;
		 }
		 }
		 
 		/**
		 * ok.
		 *
		 * @param c the c
		 */
 		private void ok(JComponent c){ c.setBorder(UIManager.getBorder("TextField.border")); }
		 
 		/**
		 * error.
		 *
		 * @param c   the c
		 * @param msg the msg
		 */
 		private void error(JComponent c, String msg){
		 c.setBorder(BorderFactory.createLineBorder(java.awt.Color.RED));
		 Toolkit.getDefaultToolkit().beep();
		 JOptionPane.showMessageDialog(c, msg, "Validación", JOptionPane.WARNING_MESSAGE);
		 }
		}

	/**
	 * focusGained.
	 *
	 * @param e the e
	 */
	@Override
	public void focusGained(FocusEvent e) {
		
		if ((int)edadNiñosSpinner.getValue() < 4) {
			extraNiñoField.setText("cuna");
		} else 
		{
			extraNiñoField.setText("cama supletoria pequeña");
		}
		
	}
	
	/**
	 * focusLost.
	 *
	 * @param e the e
	 */
	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * itemStateChanged.
	 *
	 * @param e the e
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		calcularPrecio();
		if (niñosCheck.isSelected()) {
			extrasNiños.setVisible(true);
		} else {
			extrasNiños.setVisible(false);
		}
					
		
	}
	
	/**
	 * calcularPrecio.
	 */
	private void calcularPrecio() {
		contadorPrecio = 0;
		if (tipoCamasCombo.getSelectedItem().equals("Cama simple") && tipoCamasCombo.isVisible()) {
			contadorPrecio += 15;
		}
		if (tipoCamasCombo.getSelectedItem().equals("Cama doble") && tipoCamasCombo.isVisible()) {
			contadorPrecio += 20;
		}
		if (tipoCamasCombo.getSelectedItem().equals("Sofá cama") && tipoCamasCombo.isVisible()) {
			contadorPrecio += 15;
		}
		
		
		if (tipoCamasCombo2.getSelectedItem().equals("Cama simple") && tipoCamasCombo2.isVisible()) {
			contadorPrecio += 15;
		}
		if (tipoCamasCombo2.getSelectedItem().equals("Cama doble") && tipoCamasCombo2.isVisible()) {
			contadorPrecio += 20;
		}
		if (tipoCamasCombo2.getSelectedItem().equals("Sofá cama") && tipoCamasCombo2.isVisible()) {
			contadorPrecio += 15;
		}
		
		
		if (tipoCamasCombo3.getSelectedItem().equals("Cama simple") && tipoCamasCombo3.isVisible()) {
			contadorPrecio += 15;
		}
		if (tipoCamasCombo3.getSelectedItem().equals("Cama doble") && tipoCamasCombo3.isVisible()) {
			contadorPrecio += 20;
		}
		if (tipoCamasCombo3.getSelectedItem().equals("Sofá cama") && tipoCamasCombo3.isVisible()) {
			contadorPrecio += 15;
		}
		
		
		if (tipoCamasCombo4.getSelectedItem().equals("Cama simple") && tipoCamasCombo4.isVisible()) {
			contadorPrecio += 15;
		}
		if (tipoCamasCombo4.getSelectedItem().equals("Cama doble") && tipoCamasCombo4.isVisible()) {
			contadorPrecio += 20;
		}
		if (tipoCamasCombo4.getSelectedItem().equals("Sofá cama") && tipoCamasCombo4.isVisible()) {
			contadorPrecio += 15;
		}
		
		
		if (niñosCheck.isSelected()) {
			contadorPrecio += 12;
		}
		contadorPrecio += (int)numBañosSpinner.getValue() * 25;
		precioMinimoField.setText(String.valueOf(contadorPrecio));
		
		
	}
	
	/**
	 * getDireccionField.
	 *
	 * @return the direccion field
	 */
	public JTextField getDireccionField() {
		return direccionField;
	}
	
	/**
	 * getPrecioMinimoField.
	 *
	 * @return the precio minimo field
	 */
	public JTextField getPrecioMinimoField() {
		return precioMinimoField;
	}
	
	/**
	 * getFechaAltaField.
	 *
	 * @return the fecha alta field
	 */
	public JFormattedTextField getFechaAltaField() {
		return fechaAltaField;
	}
	
	/**
	 * getFechaFinalField.
	 *
	 * @return the fecha final field
	 */
	public JFormattedTextField getFechaFinalField() {
		return fechaFinalField;
	}
	
	/**
	 * getProvinciaCombo.
	 *
	 * @return the provincia combo
	 */
	public String getProvinciaCombo() {
		return (String)provinciaCombo.getSelectedItem();
	}
	
	/**
	 * getTipoCamasCombo.
	 *
	 * @return the tipo camas combo
	 */
	public JComboBox<String> getTipoCamasCombo() {
		return tipoCamasCombo;
	}
	
	/**
	 * getTipoCamasCombo2.
	 *
	 * @return the tipo camas combo 2
	 */
	public JComboBox<String> getTipoCamasCombo2() {
		return tipoCamasCombo2;
	}
	
	/**
	 * getTipoCamasCombo3.
	 *
	 * @return the tipo camas combo 3
	 */
	public JComboBox<String> getTipoCamasCombo3() {
		return tipoCamasCombo3;
	}
	
	/**
	 * getTipoCamasCombo4.
	 *
	 * @return the tipo camas combo 4
	 */
	public JComboBox<String> getTipoCamasCombo4() {
		return tipoCamasCombo4;
	}
	
	/**
	 * getNumHuespedesSpinner.
	 *
	 * @return the num huespedes spinner
	 */
	public int getNumHuespedesSpinner() {
		return (int)numHuespedesSpinner.getValue();
	}
	
	/**
	 * getNumDormitorioSpinner.
	 *
	 * @return the num dormitorio spinner
	 */
	public int getNumDormitorioSpinner() {
		return (int)numDormitorioSpinner.getValue();
	}
	
	/**
	 * getNumBañosSpinner.
	 *
	 * @return the num baños spinner
	 */
	public int getNumBañosSpinner() {
		return (int)numBañosSpinner.getValue();
	}
	
	/**
	 * getNumCamaSpinner.
	 *
	 * @return the num cama spinner
	 */
	public int getNumCamaSpinner() {
		return (int)numCamaSpinner.getValue();
	}
	
	
	/**
	 * getNiñosCheck.
	 *
	 * @return the niños check
	 */
	public JCheckBox getNiñosCheck() {
		return niñosCheck;
	}
	
	/**
	 * nuevoInmueble.
	 */
	public void nuevoInmueble() {
		direccionField.setText("");
		provinciaCombo.setSelectedItem(listaP[0]);
		fechaAltaField.setText(minFecha.format(formatter));
		fechaFinalField.setText(minFechaF.format(formatterF));
		numHuespedesSpinner.setValue(1);
		numDormitorioSpinner.setValue(1);
		numBañosSpinner.setValue(1);
		numCamaSpinner.setValue(1);
		tipoCamasCombo.setSelectedItem(listaTipos[0]);
		tipoCamasCombo2.setSelectedItem(listaTipos[0]);
		tipoCamasCombo3.setSelectedItem(listaTipos[0]);
		tipoCamasCombo4.setSelectedItem(listaTipos[0]);
		niñosCheck.setSelected(false);
		
		
		
	}
	
		
	}


