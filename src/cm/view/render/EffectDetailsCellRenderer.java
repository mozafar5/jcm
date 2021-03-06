package cm.view.render;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import cm.model.Effect;
import cm.util.Colors;

/**
 * Defines a JList cell renderer for an {@link Effect}.
 * 
 * @author Matthew Rinehart &lt;gomamon2k at yahoo.com&gt;
 * @since 1.0
 */
public class EffectDetailsCellRenderer extends JTextArea implements ListCellRenderer {
	/**
	 * Generated.
	 */
	private static final long serialVersionUID = 6111006684462051869L;

	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		Effect eff = (Effect) value;
		setOpaque(true);
		setText(eff.getName() + "\n" + "    Source: " + eff.getSourceHandle() + "\n" + "    Duration: " + eff.getDesc());
		setForeground(Color.WHITE);
		if (eff.isBeneficial()) {
			setBackground(Colors.ATWILL);
		} else {
			setBackground(Colors.ENCOUNTER);
		}

		if (isSelected) {
			setBackground(Color.BLACK);
		}

		return this;
	}

}
