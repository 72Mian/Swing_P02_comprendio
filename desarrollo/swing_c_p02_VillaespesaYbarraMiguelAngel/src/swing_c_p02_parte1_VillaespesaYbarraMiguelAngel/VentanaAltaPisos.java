/**
* Proyecto: 
* Archivo: 
* Autor/a: Miguel Ángel Villaespesa Ybarra
* Fecha: 30 nov 2025 19:15:02
*
* Descripción:
* [Resumen breve del propósito de este archivo/clase.]
*
* Licencia:
* [Indica la licencia o condiciones de uso si procede.]
*/
package swing_c_p02_parte1_VillaespesaYbarraMiguelAngel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

/**
 * Clase VentanaAltaPisos.
 */
public class VentanaAltaPisos extends JDialog {
	
	/** El tamaño de la pantalla */
	private Dimension tamañoP = Toolkit.getDefaultToolkit().getScreenSize();
	
	/** panel 1. */
	Panel1 panel1;
	
	/** panel 2. */
	Panel2 panel2;
	
	/** panel 3. */
	Panel3 panel3;
	
	/** panel 4. */
	Panel4 panel4;
	
	/** panel botones. */
	JPanel panelBotones;
	
	/** Los botones. */
	private JButton imprimir, nuevo, guardar, colores;
	
	/**
	 * VentanaAltaPisos.
	 *
	 * @param parent the parent
	 * @param titulo the titulo
	 * @param modal  the modal
	 */
	public VentanaAltaPisos(JFrame parent, String titulo, boolean modal) {
		super(parent, titulo, modal);
		this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
		try {
			Image icono = ImageIO.read(getClass().getResource("recursos/IconoMS.png"));
			this.setIconImage(icono);
		} catch (Exception e) {
			System.err.println("Error al cargar el icono de la ventana: " + e.getMessage());
		}
		panel1 = new Panel1();
		panel2 = new Panel2();
		panel3 = new Panel3();
		panel4 = new Panel4(panel2, panel3);
		panelBotones = new JPanel();
		panel1.setBorder(new TitledBorder("Cabecera"));
        panel2.setBorder(new TitledBorder("Datos Personales"));
        panel3.setBorder(new TitledBorder("Datos del Alojamiento"));
        panel4.setBorder(new TitledBorder("Resumen"));
        panelBotones.setBorder(new TitledBorder("Botones de Acción"));
        
        imprimir = new JButton("Imprimir a Documento");
		ImageIcon imprimirIcon = new ImageIcon(getClass().getResource("recursos/imprimir.png"));
		Image imgImprimir = imprimirIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		imprimir.setIcon(new ImageIcon(imgImprimir));
		imprimir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (panel4.validarTodosLosDatos()) {
					panel4.volcarDatos();
				}
				
			}
		});
		
		nuevo = new JButton("Nuevo");
		ImageIcon nuevoIcon = new ImageIcon(getClass().getResource("recursos/AltaPisos.png"));
		Image imgNuevo = nuevoIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		nuevo.setIcon(new ImageIcon(imgNuevo));
		nuevo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel2.nuevoArrendador();
				panel3.nuevoInmueble();
				
				
			}
		});
		
		guardar = new JButton("Guardar");
		ImageIcon guardarIcon = new ImageIcon(getClass().getResource("recursos/guardar.png"));
		Image imgGuardar = guardarIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		guardar.setIcon(new ImageIcon(imgGuardar));
		guardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (panel4.validarTodosLosDatos()) {
					JOptionPane.showMessageDialog(null, "Registro Guardado", "Guardar", JOptionPane.INFORMATION_MESSAGE);                  
				}
				
			}
		});
		getRootPane().setDefaultButton(guardar);
		colores = new JButton("Paleta de Colores");
		ImageIcon paletaIcono = new ImageIcon(getClass().getResource("recursos/paleta.png"));
		Image imgPaleta = paletaIcono.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		colores.setIcon(new ImageIcon(imgPaleta));
		colores.setToolTipText("Paleta de colores para cambiar el color de fondo de la cabecera");
		colores.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Color nuevoColor = JColorChooser.showDialog(panel1, "Elige un color", Color.WHITE);
  
			    if (nuevoColor != null) {		
			        panel1.setBackground(nuevoColor);
			    }
			}
		});
		
		panelBotones.add(imprimir);
		panelBotones.add(nuevo);
		panelBotones.add(guardar);
		panelBotones.add(colores);
        
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int ancho = tamañoP.width;
		int alto = tamañoP.height;
		this.setMinimumSize(new Dimension(ancho, alto));
		pack();
		setLocationRelativeTo(parent);
		gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 0.0; 
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 0, 0);
        this.add(panel1, gbc);
        
        
        
        JPanel panelCuerpo = new JPanel(new GridLayout(1, 2, 10, 0));
        panelCuerpo.add(panel3);
        JPanel panelDerechaContainer = new JPanel(new GridLayout(2, 1, 0, 10)); 

        panelDerechaContainer.add(panel2); 
        panelDerechaContainer.add(panel4);
        panelCuerpo.add(panelDerechaContainer);

        
        gbc.gridx = 0; 
        gbc.gridy = 1;
        gbc.weightx = 1.0; 
        gbc.weighty = 1.0; 
        gbc.fill = GridBagConstraints.BOTH; 
        this.add(panelCuerpo, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 0.0; 
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(panelBotones, gbc);
		
	}

	
}
