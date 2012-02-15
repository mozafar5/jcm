package cm.view.render;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import cm.model.Effect;
import cm.utils.Colors;

public class EffectDetailsCellRenderer extends JTextArea implements ListCellRenderer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EffectDetailsCellRenderer() {
		setOpaque(true);
	}

	@Override
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		Effect eff = (Effect) value;
		setText(eff.getName() + "\n" 
				+ "    Source: " + eff.getSourceHandle() + "\n"
				+ "    Duration: " + eff.getDesc());
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
