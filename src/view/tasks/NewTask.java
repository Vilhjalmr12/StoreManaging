package view.tasks;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import view.main.MainMenu;
import view.zMessages.ErrorMessage;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Calendar;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

public class NewTask extends JDialog {
	//Attributes
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField nameField;

	public void errorMessage(String text) {
  		ErrorMessage msg = new ErrorMessage(this, text);
  		msg.setAlwaysOnTop(true);
  		msg.setVisible(true);
  		setEnabled(false);
  	}
	
	//Create the Dialog
	public NewTask(MainMenu caller) {
		setResizable(false);
		setBounds(100, 100, 600, 540);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(69, 69, 69));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				caller.setEnabled(true);
				dispose();
			}
		});
		
		JLabel nameLbl = new JLabel("Nombre de la tarea:");
		nameLbl.setForeground(new Color(252, 252, 252));
		nameLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		JTextArea notesArea = new JTextArea();
		notesArea.setFont(new Font("SansSerif", Font.PLAIN, 14));
		notesArea.setLineWrap(true);
		notesArea.setWrapStyleWord(true);
		notesArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		notesArea.setBackground(new Color(54, 54, 54));
		notesArea.setForeground(new Color(252, 252, 252));
		scrollPane.setViewportView(notesArea);
		nameField = new JTextField();
		nameField.setForeground(new Color(252, 252, 252));
		nameField.setBackground(new Color(36, 36, 36));
		nameField.setFont(new Font("SansSerif", Font.PLAIN, 14));
		nameField.setColumns(10);
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setForeground(new Color(252, 252, 252));
		lblFecha.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy/MM/dd");
		dateChooser.getDateEditor().setEnabled(false);
		dateChooser.setForeground(new Color(0, 0, 0));
		dateChooser.setBackground(new Color(69, 69, 69));
		
		//Save Button + Pressed Button Listener
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
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
							CtrlTasks cont = new CtrlTasks();
							if (!cont.checkTask(nameField.getText())) {
								errorMessage("ERROR: Ya hay una tarea con este nombre");
							} else {
								if (notesArea.getText().trim().equals("") || notesArea.getText() == null) {
									notesArea.setText("#");
								}
								String d;
								if (!(dateChooser.getDate() == null)) {
									Calendar c = Calendar.getInstance();
									c.setTime(dateChooser.getDate());
									String year = Integer.toString(c.get(Calendar.YEAR));
									String month = Integer.toString(c.get(Calendar.MONTH) + 1);
									if (month.length() == 1) {month = "0" + month;}
									String day = Integer.toString(c.get(Calendar.DAY_OF_MONTH));
									if (day.length() == 1) {day = "0" + day;}
									d = year + "/" + month + "/" + day;
								} else {
									d = "Ind";
								}
								String[] task = {d, nameField.getText(), notesArea.getText()};
								if (cont.addTask(task)) {
									cont.setTasks(caller);
									caller.rightMessage("Tarea introducida correctamente!");
									dispose();
								} else {
									errorMessage("INTERNAL ERROR!");
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
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
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
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(nameLbl)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(nameField, GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
							.addComponent(lblFecha, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
							.addGap(297)))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(nameLbl)
						.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblFecha, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnGuardar)
						.addComponent(btnCancelar))
					.addGap(14))
		);
		contentPanel.setLayout(gl_contentPanel);
	}
}
