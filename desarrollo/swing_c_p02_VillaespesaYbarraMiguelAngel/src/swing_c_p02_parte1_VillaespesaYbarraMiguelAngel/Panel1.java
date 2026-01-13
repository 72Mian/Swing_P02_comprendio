/**
* Proyecto: 
* Archivo: 
* Autor/a: Miguel Ángel Villaespesa Ybarra
* Fecha: 30 nov 2025 19:09:25
*
* Descripción:
* [Resumen breve del propósito de este archivo/clase.]
*
* Licencia:
* [Indica la licencia o condiciones de uso si procede.]
*/
package swing_c_p02_parte1_VillaespesaYbarraMiguelAngel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 * Clase Panel1.
 */
public class Panel1 extends JPanel {
	
	/**
	 * Panel1.
	 */
	public Panel1() {
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 0 , 30));
		this.setBackground(Color.LIGHT_GRAY);
		JLabel texto = new JLabel("Malos Son");
		texto.setFont(new Font("Arial", Font.BOLD, 20));
		texto.setForeground(Color.BLUE);
		this.setBorder(new LineBorder(Color.RED));
		this.add(texto);
		
	}

}
