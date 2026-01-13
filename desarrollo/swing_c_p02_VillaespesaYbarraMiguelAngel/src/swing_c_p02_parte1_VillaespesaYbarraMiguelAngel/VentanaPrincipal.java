/**
* Proyecto: 
* Archivo: 
* Autor/a: Miguel Ángel Villaespesa Ybarra
* Fecha: 30 nov 2025 19:15:49
*
* Descripción:
* [Resumen breve del propósito de este archivo/clase.]
*
* Licencia:
* [Indica la licencia o condiciones de uso si procede.]
*/
package swing_c_p02_parte1_VillaespesaYbarraMiguelAngel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 * Clase VentanaPrincipal.
 */
public class VentanaPrincipal extends JFrame {
	
	/** panel. */
	private JPanel panel;
	
	/** El menubar mi barra. */
	private JMenuBar miBarra;
	
	/** Los menus. */
	private JMenu archivo, registro, ayuda;
	
	/** Los items de los menus*/
	private JMenuItem salir, altaPisos, bajaPisos, acercaDe;
	
	/** Tamaño de la pantalla */
	private Dimension tamañoP = Toolkit.getDefaultToolkit().getScreenSize();
	
	/** Boton alta piso. */
	private JButton altaPiso;
	
	/** Boton baja piso. */
	private JButton bajaPiso;
	
	/**
	 * VentanaPrincipal.
	 */
	public VentanaPrincipal() {
		super("Gestión Apartamentos Turísticos MalosSon");
		try {
			Image icono = ImageIO.read(getClass().getResource("recursos/IconoMS.png"));
			this.setIconImage(icono);
		} catch (Exception e) {
			System.err.println("Error al cargar el icono de la ventana: " + e.getMessage());
		}
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int ancho = tamañoP.width / 2;
		int alto = tamañoP.height / 2;
		this.setMinimumSize(new Dimension(ancho, alto));
		this.setLocationRelativeTo(null);
		this.setLayout(new GridBagLayout());
		iniciarComponentes();
		this.pack();
		this.setVisible(true);
	}
	
	/**
	 * iniciarComponentes.
	 */
	public void iniciarComponentes() {
		
		panel = new JPanel();
		miBarra = new JMenuBar();
		archivo = new JMenu("Archivo");
		archivo.setMnemonic(KeyEvent.VK_A);
		registro = new JMenu("Registro");
		registro.setMnemonic(KeyEvent.VK_R);
		ayuda = new JMenu("Ayuda");
		ayuda.setMnemonic(KeyEvent.VK_H);
		salir = new JMenuItem("Salir");
		salir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK ));
		salir.setMnemonic(KeyEvent.VK_F4);
		salir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
				
			}
		});
		altaPisos = new JMenuItem("Alta Pisos");
		altaPisos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK ));
		altaPisos.setMnemonic(KeyEvent.VK_N);
		altaPisos.addActionListener(e -> abrirDialogo());
		bajaPisos = new JMenuItem("Baja Pisos");
		bajaPisos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_DOWN_MASK ));
		bajaPisos.setMnemonic(KeyEvent.VK_W);
		bajaPisos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "No esta implementado todavía", "Error", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		acercaDe = new JMenuItem("Acerca De...");
		acercaDe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_DOWN_MASK ));
		acercaDe.setMnemonic(KeyEvent.VK_M);
		acercaDe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Empresa: MalosSon - Versión: 1.0 - Autor: Miguel Ángel Villaespesa Ybarra", "Acerca de...", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		archivo.add(salir);
		registro.add(altaPisos);
		registro.add(bajaPisos);
		ayuda.add(acercaDe);
		miBarra.add(archivo);
		miBarra.add(registro);
		miBarra.add(ayuda);
		this.setJMenuBar(miBarra);
		altaPiso = new JButton("Alta Pisos");
		altaPiso.setToolTipText("Ctrl + N");
		
		bajaPiso = new JButton("Baja Pisos");
		bajaPiso.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "No esta implementado todavía", "Error", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		ImageIcon nuevoPiso = new ImageIcon(getClass().getResource("recursos/AltaPisos.png"));
		Image imgAlta = nuevoPiso.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		ImageIcon eliminarPiso = new ImageIcon(getClass().getResource("recursos/BajaPisos.png"));
		Image imgBaja = eliminarPiso.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		altaPiso.setIcon(new ImageIcon(imgAlta));
//		altaPiso.setPreferredSize(new Dimension(100,100));
		bajaPiso.setIcon(new ImageIcon(imgBaja));
//		bajaPiso.setPreferredSize(new Dimension(100,100));
		getRootPane().setDefaultButton(altaPiso);
		altaPiso.addActionListener(e -> abrirDialogo());
		panel.add(altaPiso);
		panel.add(bajaPiso);
		this.add(panel);
//		altaPiso.setIcon(getClass().getResource("recursos/IconoMS.png"));
		
	}
	
	/**
	 * abrirDialogo.
	 */
	public void abrirDialogo() {
		VentanaAltaPisos dialogoAltaPisos = new VentanaAltaPisos(this, "Alta Pisos", true);
		dialogoAltaPisos.setVisible(true);
	}
}