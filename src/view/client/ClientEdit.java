package view.client;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import view.main.MainMenu;
import view.zMessages.ErrorMessage;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;

public class ClientEdit extends JDialog {
	//Attributes
	private static final long serialVersionUID = 1L;
	private CtrlClients cont = new CtrlClients();
	private JTextField nameField;
	private JTextField telfField;
	private JTextField mailField;
	
	//Show the error message and block this frame until the message is closed
  	public void errorMessage(String text) {
  		ErrorMessage msg = new ErrorMessage(this, text);
  		msg.setAlwaysOnTop(true);
  		msg.setVisible(true);
  		setEnabled(false);
  	}

	//Create the Dialog
	public ClientEdit(MainMenu caller, String[] info) {
		getContentPane().setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		getContentPane().setBackground(new Color(69, 69, 69));
		setResizable(false);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBackground(new Color(69, 69, 69));
		setBounds(100, 100, 480, 450);
		setLocationRelativeTo(null);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				caller.setEnabled(true);
				dispose();
			}
		});
		
		//Initial SetUp
		setAlwaysOnTop(true);
		JLabel clientLbl = new JLabel(" Cliente Número:");
		clientLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		clientLbl.setForeground(new Color(252, 252, 252));
		JSeparator sep1 = new JSeparator();
		nameField = new JTextField();
		nameField.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		nameField.setForeground(new Color(252, 252, 252));
		nameField.setColumns(10);
		nameField.setBackground(new Color(36, 36, 36));
		JLabel nameLbl = new JLabel(" Nombre:");
		nameLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		nameLbl.setForeground(new Color(252, 252, 252));
		JLabel telfLbl = new JLabel(" Teléfono:");
		telfLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		telfLbl.setForeground(new Color(252, 252, 252));
		telfField = new JTextField();
		telfField.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		telfField.setForeground(new Color(252, 252, 252));
		telfField.setColumns(10);
		telfField.setBackground(new Color(36, 36, 36));
		JLabel mailLbl = new JLabel(" Mail:");
		mailLbl.setForeground(new Color(252, 252, 252));
		mailLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		mailField = new JTextField();
		mailField.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		mailField.setForeground(new Color(252, 252, 252));
		mailField.setBackground(new Color(36, 36, 36));
		mailField.setColumns(10);
		JSeparator sep2 = new JSeparator();
		JLabel interesLbl = new JLabel(" Detalles de Interes");
		interesLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		interesLbl.setForeground(new Color(252, 252, 252));
		JSeparator sep3 = new JSeparator();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setForeground(new Color(252, 252, 252));
		textArea.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		textArea.setBorder(null);
		textArea.setBackground(new Color(54, 54, 54));
		scrollPane.setViewportView(textArea);
		JLabel label = new JLabel("lllll");
		label.setOpaque(true);
		label.setForeground(new Color(54, 54, 54));
		label.setBackground(new Color(54, 54, 54));
		scrollPane.setRowHeaderView(label);
		clientLbl.setText(clientLbl.getText() + "  " + info[0]);
		nameField.setText(nameField.getText() + info[1]);
		telfField.setText(telfField.getText() + info[2]);
		mailField.setText(mailField.getText() + info[3]);
		textArea.setText(info[4]);
	
		//Save Button + Pressed Button Listener
		JButton saveRBtn = new JButton("Guardar");
		saveRBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (nameField.getText().trim().equals("") || nameField.getText() == null) {
						errorMessage("ERROR: Debes introducir un nombre");
						nameField.setText("");
					} else {
						boolean correct = true;
						for (int i=0; i<nameField.getText().length(); ++i) {
							if (!((nameField.getText().charAt(i) >= 'a' && nameField.getText().charAt(i) <= 'z') 
									|| (nameField.getText().charAt(i) >= 'A' && nameField.getText().charAt(i) <= 'Z') 
									|| nameField.getText().charAt(i) == ' ' || nameField.getText().charAt(i) == 'ñ'
									|| nameField.getText().charAt(i) == 'Ñ' || nameField.getText().charAt(i) == 'ç'
									|| nameField.getText().charAt(i) == 'Ç')) {
										correct = false;
									}
						}
						if (!correct) {
							errorMessage("ERROR: El nombre solo puede contener letras");
							nameField.setText("");
						} else {
							if (telfField.getText().trim().equals("") || telfField.getText() == null) {
								errorMessage("ERROR: Debes introducir un teléfono");
							} else {
								correct = true;
								for (int i=0; i<telfField.getText().length(); ++i) {
									if (!((telfField.getText().charAt(i) >= '0' && telfField.getText().charAt(i) <= '9')
											|| telfField.getText().charAt(i) == ' ')) {
										correct = false;
									}
								}
								if (!correct) {
									errorMessage("ERROR: El teléfono solo puede contener números");
									telfField.setText("");
								} else {
									if (mailField.getText().trim().equals("") || mailField.getText() == null) {
										errorMessage("ERROR: Debes introducir un correo electrónico");
										mailField.setText("");
									} else {
										String interests = textArea.getText();
										if (interests == null || interests.trim().equals("")) {
											interests = "#";
										}
										cont.removeClient(info);
										if (cont.createNewClient(info[0], nameField.getText(), telfField.getText(), mailField.getText(), interests)) {
											cont.setClients(caller);
											caller.rightMessage("KekoAmigo editado correctamente!");
											dispose();
										} else {
											errorMessage("INTERNAL ERROR!");
										}
									}
								}
							}
						}
					}
				} catch (IOException e1) {
					errorMessage("INTERNAL ERROR!");
				}
			}
		});
		
		//Cancel Button + Pressed Button Listener
		JButton cancelRBtn = new JButton("Cancelar");
		cancelRBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				caller.setEnabled(true);
				dispose();
			}
		});
		
		//Elements Distribution
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(sep1, GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(sep2, GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(6)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
										.addComponent(interesLbl, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE))
									.addGap(12)))
							.addGap(5))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(mailField, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE)
							.addGap(16))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(242)
							.addComponent(cancelRBtn, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(saveRBtn, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
							.addGap(15))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(sep3, GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
							.addGap(5))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addGap(6)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(telfLbl, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
										.addComponent(nameLbl, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
										.addComponent(mailLbl, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(nameField, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE)
										.addComponent(telfField, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE))
									.addGap(8))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addGap(8)
									.addComponent(clientLbl, GroupLayout.PREFERRED_SIZE, 458, GroupLayout.PREFERRED_SIZE)))
							.addGap(8))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(7)
					.addComponent(clientLbl, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(sep1, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(7)
							.addComponent(nameLbl, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(telfLbl, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(telfField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(mailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(mailLbl, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addComponent(sep2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(interesLbl)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(sep3, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cancelRBtn)
						.addComponent(saveRBtn))
					.addGap(16))
		);
		getContentPane().setLayout(groupLayout);
	}
}
