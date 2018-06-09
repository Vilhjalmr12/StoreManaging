package view.zMessages;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.main.MainMenu;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Font;

public class ErrorMessage extends JDialog {
	//Attributes
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	//Create the Frame When Called From a JFrame
	public ErrorMessage(JFrame caller, String text) {
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 405, 114);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		contentPanel.setBackground(new Color(69, 69, 69));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				caller.setEnabled(true);
				dispose();
			}
		});
		
		JLabel iconLbl = new JLabel("");
		iconLbl.setHorizontalAlignment(SwingConstants.CENTER);
		iconLbl.setIcon(new ImageIcon(MainMenu.class.getResource("/view/zMessages/error.png")));
		JTextArea textArea = new JTextArea();
		textArea.setForeground(new Color(252, 252, 252));
		textArea.setText(text);
		textArea.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textArea.setEditable(false);
		textArea.setFocusable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setBorder(null);
		textArea.setBackground(new Color(69, 69, 69));
		
		//Close Button + Pressed Button Listener
		JButton yesBtn = new JButton("Cerrar");
		yesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				caller.setEnabled(true);
				dispose();
			}
		});
		
		//Elements Distribution
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(iconLbl, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(yesBtn, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(yesBtn))
						.addComponent(iconLbl, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
					.addContainerGap())
		);
		contentPanel.setLayout(gl_contentPanel);
	}
	
	//Create the Frame When Called From a JDialog
	public ErrorMessage(JDialog caller, String text) {
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 405, 114);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		contentPanel.setBackground(new Color(69, 69, 69));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				caller.setEnabled(true);
				dispose();
			}
		});
		
		JLabel iconLbl = new JLabel("");
		iconLbl.setHorizontalAlignment(SwingConstants.CENTER);
		iconLbl.setIcon(new ImageIcon(MainMenu.class.getResource("/view/zMessages/error.png")));
		JTextArea textArea = new JTextArea();
		textArea.setForeground(new Color(252, 252, 252));
		textArea.setText(text);
		textArea.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textArea.setEditable(false);
		textArea.setFocusable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setBorder(null);
		textArea.setBackground(new Color(69, 69, 69));
		
		//Close Button + Pressed Button Listener
		JButton yesBtn = new JButton("Cerrar");
		yesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				caller.setEnabled(true);
				dispose();
			}
		});
		
		//Elements Distribution
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(iconLbl, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(yesBtn, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(yesBtn))
						.addComponent(iconLbl, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
					.addContainerGap())
		);
		contentPanel.setLayout(gl_contentPanel);
	}
}
