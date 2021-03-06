package cm.view;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

import org.dyno.visual.swing.layouts.Bilateral;
import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;

/**
 * Help -> About.
 * 
 * @author Matthew Rinehart &lt;gomamon2k at yahoo.com&gt;
 * @since 1.0
 */
// VS4E -- DO NOT REMOVE THIS LINE!
public class About extends JDialog {
	private static final long serialVersionUID = 1L;
	private JButton jButtonOK;
	private JLabel jLabelTitle;
	private JLabel jLabelVersion;
	private JTextPane jTextPaneDescription;

	/**
	 * Creates an About window.
	 */
	public About() {
		initComponents();
	}

	private void initComponents() {
		setTitle("About DnD 4e Combat Manager");
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setBackground(new Color(223, 223, 223));
		setModal(true);
		setForeground(Color.black);
		setLayout(new GroupLayout());
		add(getJLabelTitle(), new Constraints(new Bilateral(0, 0, 41), new Leading(0, 41, 12, 12)));
		add(getJLabelVersion(), new Constraints(new Bilateral(0, 1, 43), new Leading(47, 12, 12)));
		add(getJTextPaneDescription(), new Constraints(new Bilateral(0, 1, 41), new Leading(85, 75, 10, 10)));
		add(getJButtonOK(), new Constraints(new Bilateral(261, 262, 81), new Leading(166, 12, 12)));
		pack();
	}

	private JButton getJButtonOK() {
		if (jButtonOK == null) {
			jButtonOK = new JButton();
			jButtonOK.setText("OK");
			jButtonOK.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent event) {
					jButtonOKActionActionPerformed(event);
				}
			});
		}
		return jButtonOK;
	}

	private JLabel getJLabelTitle() {
		if (jLabelTitle == null) {
			jLabelTitle = new JLabel();
			jLabelTitle.setFont(new Font("Dialog", Font.BOLD, 24));
			jLabelTitle.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelTitle.setText("DnD 4e Combat Manager");
		}
		return jLabelTitle;
	}

	private JLabel getJLabelVersion() {
		if (jLabelVersion == null) {
			jLabelVersion = new JLabel();
			jLabelVersion.setFont(new Font("Dialog", Font.BOLD, 24));
			jLabelVersion.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelVersion.setText("Version " + cm.DnD4eCombatManager.VERSION);
		}
		return jLabelVersion;
	}

	private JTextPane getJTextPaneDescription() {
		if (jTextPaneDescription == null) {
			jTextPaneDescription = new JTextPane();
			jTextPaneDescription.setContentType("text/html");
			jTextPaneDescription.setBackground(this.getBackground());
			jTextPaneDescription.setEditable(false);
			jTextPaneDescription.setText("<html>DnD 4e Combat Manager is based on the program of the same name hosted at<br>"
					+ "<a href=\"http://www.dragonpro.com/index.php?option=com_jdownloads&view=viewcategory&catid=2&Itemid=53\">"
					+ "http://www.dragonpro.com/index.php?option=com_jdownloads&view=viewcategory&catid=2&Itemid=53</a>.<br>"
					+ "This is a Java port of an early source release, with some features from the original added and<br>"
					+ "other unique features implemented also.");
			jTextPaneDescription.addHyperlinkListener(new HyperlinkListener() {

				@Override
				public void hyperlinkUpdate(HyperlinkEvent event) {
					jTextPaneDescriptionHyperlinkHyperlinkUpdate(event);
				}
			});
		}
		return jTextPaneDescription;
	}

	private void jButtonOKActionActionPerformed(ActionEvent event) {
		this.setVisible(false);
	}

	private void jTextPaneDescriptionHyperlinkHyperlinkUpdate(HyperlinkEvent event) {
		if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
			try {
				URI uri = new URI(event.getDescription());
				if (Desktop.isDesktopSupported()) {
					Desktop.getDesktop().browse(uri);
				}
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Unable to launch your default browser: " + e.getLocalizedMessage(),
						"Error Launching Browser", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		}
	}
}
