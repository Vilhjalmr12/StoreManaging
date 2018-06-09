package view.client;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import view.main.MainMenu;
import view.zMessages.ErrorMessage;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientRemove extends JDialog {
	//Attributes
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField wordField;
	private CtrlClients cont = new CtrlClients();

	//Show the error message and block this frame until the message is closed
  	public void errorMessage(String text) {
  		ErrorMessage msg = new ErrorMessage(this, text);
  		msg.setAlwaysOnTop(true);
  		msg.setVisible(true);
  		setEnabled(false);
  	}
	
	//Create the Dialog
	public ClientRemove(MainMenu caller, String[] info) {
		setResizable(false);
		setBounds(100, 100, 390, 219);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(69, 69, 69));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				caller.setEnabled(true);
				dispose();
			}
		});
		
		//Initial SetUp
		JLabel msgLbl1 = new JLabel("Para confirmar la eliminación de este KekoAmigo");
		msgLbl1.setForeground(new Color(252, 252, 252));
		msgLbl1.setFont(new Font("SansSerif", Font.PLAIN, 13));
		msgLbl1.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel msgLbl2 = new JLabel("escribe 'ELIMINAR' en el campo inferior");
		msgLbl2.setForeground(new Color(252, 252, 252));
		msgLbl2.setFont(new Font("SansSerif", Font.PLAIN, 13));
		msgLbl2.setHorizontalAlignment(SwingConstants.CENTER);
		JTextArea clientArea = new JTextArea();
		clientArea.setFocusable(false);
		clientArea.setEditable(false);
		clientArea.setBackground(new Color(69, 69, 69));
		clientArea.setForeground(new Color(252, 252, 252));
		clientArea.setBorder(null);
		clientArea.setFont(new Font("SansSerif", Font.PLAIN, 14));
		clientArea.setText("KekoAmigo:  " + info[1]);
		wordField = new JTextField();
		wordField.setHorizontalAlignment(SwingConstants.CENTER);
		wordField.setBackground(new Color(36, 36, 36));
		wordField.setForeground(new Color(252, 252, 252));
		wordField.setColumns(10);
		
		//Remove Button + Pressed Button Listener
		JButton removeBtn = new JButton("Eliminar");
		removeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (wordField.getText().equals("ELIMINAR")) {
					try {
						cont.removeClient(info);
						cont.setClients(caller);
						caller.rightMessage("KekoAmigo eliminado correctamente!");
						dispose();
					} catch (IOException e1) {
						errorMessage("INTERNAL ERROR!");
					}
				} else {
					errorMessage("ERROR: La palabra no se corresponde");
				}
			}
		});
		
		//Elements Distribution
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(clientArea, GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
						.addComponent(msgLbl2, GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
						.addComponent(msgLbl1, GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
						.addComponent(wordField, GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
						.addComponent(removeBtn, Alignment.TRAILING))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(clientArea, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(msgLbl1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(msgLbl2)
					.addGap(18)
					.addComponent(wordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
					.addComponent(removeBtn)
					.addContainerGap())
		);
		contentPanel.setLayout(gl_contentPanel);
	}
}
