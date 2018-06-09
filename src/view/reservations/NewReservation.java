package view.reservations;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import view.main.MainMenu;
import view.zMessages.ErrorMessage;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Calendar;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

public class NewReservation extends JDialog {
	//Attributes
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField enField;
	private JTextField treField;
	private JTextField femField;
	private JTextField sjuField;
	private JTextField nioField;
	private JTextField tvaField;
	private JTextField fyraField;
	private JTextField sexField;
	private JTextField ottaField;
	private JTextField tioField;

	//Show the error message and block this frame until the message is closed
  	public void errorMessage(String text) {
  		ErrorMessage msg = new ErrorMessage(this, text);
  		msg.setAlwaysOnTop(true);
  		msg.setVisible(true);
  		setEnabled(false);
  	}
	
  	private boolean isCorrect(String text) {
		boolean correct = true;
		for (int i=0; i<text.length(); ++i) {
			if (!((text.charAt(i) >= 'a' && text.charAt(i) <= 'z') 
					|| (text.charAt(i) >= 'A' && text.charAt(i) <= 'Z') 
					|| text.charAt(i) == ' ' || text.charAt(i) == 'ñ'
					|| text.charAt(i) == 'Ñ' || text.charAt(i) == 'ç'
					|| text.charAt(i) == 'Ç' || text.charAt(i) == '+'
					|| text.charAt(i) == '-' || text.charAt(i) == '('
					|| text.charAt(i) == ')' || (text.charAt(i) >= '0' && text.charAt(i) <= '9'))) {
						correct = false;
					}
		}
		return correct;
	}
	
	//Create the Dialog
	public NewReservation(MainMenu caller) {
		setResizable(false);
		setBounds(100, 100, 652, 612);
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
		
		//Initial SetUp
		JLabel tablesLbl = new JLabel("");
		tablesLbl.setBorder(null);
		tablesLbl.setHorizontalAlignment(SwingConstants.CENTER);
		tablesLbl.setIcon(new ImageIcon(MainMenu.class.getResource("/view/reservations/image3.png")));
		JLabel yearLbl = new JLabel("Fecha:");
		yearLbl.setForeground(new Color(252, 252, 252));
		yearLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		yearLbl.setFont(new Font("SansSerif", Font.PLAIN, 14));
		JLabel turnLbl = new JLabel("Turno:");
		turnLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		turnLbl.setForeground(new Color(252, 252, 252));
		turnLbl.setFont(new Font("SansSerif", Font.PLAIN, 14));
		String[] turns = {"Mañana", "Tarde"};
		JComboBox<String> turnCombo = new JComboBox<String>(turns);
		turnCombo.setFont(new Font("SansSerif", Font.PLAIN, 13));
		enField = new JTextField();
		enField.setFocusable(false);
		enField.setEditable(false);
		enField.setBackground(new Color(36, 36, 36));
		enField.setForeground(new Color(252, 252, 252));
		enField.setColumns(10);
		treField = new JTextField();
		treField.setEditable(false);
		treField.setFocusable(false);
		treField.setBackground(new Color(36, 36, 36));
		treField.setForeground(new Color(252, 252, 252));
		treField.setColumns(10);
		femField = new JTextField();
		femField.setEditable(false);
		femField.setFocusable(false);
		femField.setBackground(new Color(36, 36, 36));
		femField.setForeground(new Color(252, 252, 252));
		femField.setColumns(10);
		sjuField = new JTextField();
		sjuField.setEditable(false);
		sjuField.setFocusable(false);
		sjuField.setBackground(new Color(36, 36, 36));
		sjuField.setForeground(new Color(252, 252, 252));
		sjuField.setColumns(10);
		nioField = new JTextField();
		nioField.setEditable(false);
		nioField.setFocusable(false);
		nioField.setBackground(new Color(36, 36, 36));
		nioField.setForeground(new Color(252, 252, 252));
		nioField.setColumns(10);
		tvaField = new JTextField();
		tvaField.setEditable(false);
		tvaField.setFocusable(false);
		tvaField.setBackground(new Color(36, 36, 36));
		tvaField.setForeground(new Color(252, 252, 252));
		tvaField.setColumns(10);
		fyraField = new JTextField();
		fyraField.setEditable(false);
		fyraField.setFocusable(false);
		fyraField.setBackground(new Color(36, 36, 36));
		fyraField.setForeground(new Color(252, 252, 252));
		fyraField.setColumns(10);
		sexField = new JTextField();
		sexField.setEditable(false);
		sexField.setFocusable(false);
		sexField.setBackground(new Color(36, 36, 36));
		sexField.setForeground(new Color(252, 252, 252));
		sexField.setColumns(10);
		ottaField = new JTextField();
		ottaField.setEditable(false);
		ottaField.setFocusable(false);
		ottaField.setBackground(new Color(36, 36, 36));
		ottaField.setForeground(new Color(252, 252, 252));
		ottaField.setColumns(10);
		tioField = new JTextField();
		tioField.setEditable(false);
		tioField.setFocusable(false);
		tioField.setBackground(new Color(36, 36, 36));
		tioField.setForeground(new Color(252, 252, 252));
		tioField.setColumns(10);
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy/MM/dd");
		dateChooser.getDateEditor().setEnabled(false);
		dateChooser.setForeground(new Color(0, 0, 0));
		dateChooser.setBackground(new Color(69, 69, 69));
		
		//Client Field 1
		JRadioButton enRBtn = new JRadioButton("1");
		enRBtn.setHorizontalAlignment(SwingConstants.RIGHT);
		enRBtn.setForeground(new Color(252, 252, 252));
		enRBtn.setBackground(new Color(252, 252, 252));
		enRBtn.setFont(new Font("SansSerif", Font.PLAIN, 14));
		enRBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(enRBtn.isSelected()) {enField.setFocusable(true); enField.setEditable(true);}
				else {enField.setFocusable(false); enField.setEditable(false);}
			}
		});

		//Client Field 2
		JRadioButton tvaRBtn = new JRadioButton("2");
		tvaRBtn.setForeground(new Color(252, 252, 252));
		tvaRBtn.setBackground(new Color(252, 252, 252));
		tvaRBtn.setHorizontalAlignment(SwingConstants.RIGHT);
		tvaRBtn.setFont(new Font("SansSerif", Font.PLAIN, 14));
		tvaRBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tvaRBtn.isSelected()) {tvaField.setFocusable(true); tvaField.setEditable(true);}
				else {tvaField.setFocusable(false); tvaField.setEditable(false);}
			}
		});
		
		//Client Field 3
		JRadioButton treRBtn = new JRadioButton("3");
		treRBtn.setForeground(new Color(252, 252, 252));
		treRBtn.setHorizontalAlignment(SwingConstants.RIGHT);
		treRBtn.setFont(new Font("SansSerif", Font.PLAIN, 14));
		treRBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(treRBtn.isSelected()) {treField.setFocusable(true); treField.setEditable(true);}
				else {treField.setFocusable(false); treField.setEditable(false);}
			}
		});
		
		//Client Field 4
		JRadioButton fyraRBtn = new JRadioButton("4");
		fyraRBtn.setForeground(new Color(252, 252, 252));
		fyraRBtn.setHorizontalAlignment(SwingConstants.RIGHT);
		fyraRBtn.setFont(new Font("SansSerif", Font.PLAIN, 14));
		fyraRBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fyraRBtn.isSelected()) {fyraField.setFocusable(true); fyraField.setEditable(true);}
				else {fyraField.setFocusable(false); fyraField.setEditable(false);}
			}
		});
		
		//Client Field 5
		JRadioButton femRBtn = new JRadioButton("5");
		femRBtn.setForeground(new Color(252, 252, 252));
		femRBtn.setHorizontalAlignment(SwingConstants.RIGHT);
		femRBtn.setFont(new Font("SansSerif", Font.PLAIN, 14));
		femRBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(femRBtn.isSelected()) {femField.setFocusable(true); femField.setEditable(true);}
				else {femField.setFocusable(false); femField.setEditable(false);}
			}
		});
		
		//Client Field 6
		JRadioButton sexRBtn = new JRadioButton("6");
		sexRBtn.setForeground(new Color(252, 252, 252));
		sexRBtn.setHorizontalAlignment(SwingConstants.RIGHT);
		sexRBtn.setFont(new Font("SansSerif", Font.PLAIN, 14));
		sexRBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sexRBtn.isSelected()) {sexField.setFocusable(true); sexField.setEditable(true);}
				else {sexField.setFocusable(false); sexField.setEditable(false);}
			}
		});
		
		//Client Field 7
		JRadioButton sjuRBtn = new JRadioButton("7");
		sjuRBtn.setForeground(new Color(252, 252, 252));
		sjuRBtn.setHorizontalAlignment(SwingConstants.RIGHT);
		sjuRBtn.setFont(new Font("SansSerif", Font.PLAIN, 14));
		sjuRBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sjuRBtn.isSelected()) {sjuField.setFocusable(true); sjuField.setEditable(true);}
				else {sjuField.setFocusable(false); sjuField.setEditable(false);}
			}
		});
		
		//Client Field 8
		JRadioButton ottaRBtn = new JRadioButton("8");
		ottaRBtn.setForeground(new Color(252, 252, 252));
		ottaRBtn.setHorizontalAlignment(SwingConstants.RIGHT);
		ottaRBtn.setFont(new Font("SansSerif", Font.PLAIN, 14));
		ottaRBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ottaRBtn.isSelected()) {ottaField.setFocusable(true); ottaField.setEditable(true);}
				else {ottaField.setFocusable(false); ottaField.setEditable(false);}
			}
		});
		
		//Client Field 9
		JRadioButton nioRBtn = new JRadioButton("9");
		nioRBtn.setHorizontalAlignment(SwingConstants.RIGHT);
		nioRBtn.setFont(new Font("SansSerif", Font.PLAIN, 14));
		nioRBtn.setForeground(new Color(252, 252, 252));
		nioRBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nioRBtn.isSelected()) {nioField.setFocusable(true); nioField.setEditable(true);}
				else {nioField.setFocusable(false); nioField.setEditable(false);}
			}
		});
		
		//Client Field 10
		JRadioButton tioRBtn = new JRadioButton("0");
		tioRBtn.setHorizontalAlignment(SwingConstants.RIGHT);
		tioRBtn.setFont(new Font("SansSerif", Font.PLAIN, 14));
		tioRBtn.setForeground(new Color(252, 252, 252));
		tioRBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tioRBtn.isSelected()) {tioField.setFocusable(true); tioField.setEditable(true);}
				else {tioField.setFocusable(false); tioField.setEditable(false);}
			}
		});
		
		//Confirm Button + Pressed Button Listener
		JButton confirmBtn = new JButton("Confirmar");
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean areReserved = false, allOk = true;
				String names = "";
				if (enRBtn.isSelected()) {
					if (isCorrect(enField.getText())) {
						if (!(enField.getText().trim().equals("")) && !(enField.getText() == null)) {
							names += (enField.getText().trim() + ",");
							areReserved = true;
						} else {
							errorMessage("ERROR en 1: Nombre vacio");
							allOk = false;
						}
					} else {
						errorMessage("ERROR en 1: Solo caracteres del alfabeto ingles");
						allOk = false;
					}
				} else {names += ".,";}
				if (tvaRBtn.isSelected()) {
					if (isCorrect(tvaField.getText())) {
						if (!(tvaField.getText().trim().equals("")) && !(tvaField.getText() == null)) {
							names += (tvaField.getText().trim() + ",");
							areReserved = true;
						} else {
							errorMessage("ERROR en 2: Nombre vacio");
							allOk = false;
						}
					} else {
						errorMessage("ERROR en 2: Solo caracteres del alfabeto ingles");
						allOk = false;
					}
				} else {names += ".,";}
				if (treRBtn.isSelected()) {
					if (isCorrect(treField.getText())) {
						if (!(treField.getText().trim().equals("")) && !(treField.getText() == null)) {
							names += (treField.getText().trim() + ",");
							areReserved = true;
						} else {
							errorMessage("ERROR en 3: Nombre vacio");
							allOk = false;
						}
					} else {
						errorMessage("ERROR en 3: Solo caracteres del alfabeto ingles");
						allOk = false;
					}
				} else {names += ".,";}
				if (fyraRBtn.isSelected()) {
					if (isCorrect(fyraField.getText())) {
						if (!(fyraField.getText().trim().equals("")) && !(fyraField.getText() == null)) {
							names += (fyraField.getText().trim() + ",");
							areReserved = true;
						} else {
							errorMessage("ERROR en 4: Nombre vacio");
							allOk = false;
						}
					} else {
						errorMessage("ERROR en 4: Solo caracteres del alfabeto ingles");
						allOk = false;
					}
				} else {names += ".,";}
				if (femRBtn.isSelected()) {
					if (isCorrect(femField.getText())) {
						if (!(femField.getText().trim().equals("")) && !(femField.getText() == null)) {
							names += (femField.getText().trim() + ",");
							areReserved = true;
						} else {
							errorMessage("ERROR en 5: Nombre vacio");
							allOk = false;
						}
					} else {
						errorMessage("ERROR en 5: Solo caracteres del alfabeto ingles");
						allOk = false;
					}
				} else {names += ".,";}
				if (sexRBtn.isSelected()) {
					if (isCorrect(sexField.getText())) {
						if (!(sexField.getText().trim().equals("")) && !(sexField.getText() == null)) {
							names += (sexField.getText().trim() + ",");
							areReserved = true;
						} else {
							errorMessage("ERROR en 6: Nombre vacio");
							allOk = false;
						}
					} else {
						errorMessage("ERROR en 6: Solo caracteres del alfabeto ingles");
						allOk = false;
					}
				} else {names += ".,";}
				if (sjuRBtn.isSelected()) {
					if (isCorrect(sjuField.getText())) {
						if (!(sjuField.getText().trim().equals("")) && !(sjuField.getText() == null)) {
							names += (sjuField.getText().trim() + ",");
							areReserved = true;
						} else {
							errorMessage("ERROR en 7: Nombre vacio");
							allOk = false;
						}
					} else {
						errorMessage("ERROR en 7: Solo caracteres del alfabeto ingles");
						allOk = false;
					}
				} else {names += ".,";}
				if (ottaRBtn.isSelected()) {
					if (isCorrect(ottaField.getText())) {
						if (!(ottaField.getText().trim().equals("")) && !(ottaField.getText() == null)) {
							names += (ottaField.getText().trim() + ",");
							areReserved = true;
						} else {
							errorMessage("ERROR en 8: Nombre vacio");
							allOk = false;
						}
					} else {
						errorMessage("ERROR en 8: Solo caracteres del alfabeto ingles");
						allOk = false;
					}
				} else {names += ".,";}
				if (nioRBtn.isSelected()) {
					if (isCorrect(nioField.getText())) {
						if (!(nioField.getText().trim().equals("")) && !(nioField.getText() == null)) {
							names += (nioField.getText().trim() + ",");
							areReserved = true;
						} else {
							errorMessage("ERROR en 9: Nombre vacio");
							allOk = false;
						}
					} else {
						errorMessage("ERROR en 9: Solo caracteres del alfabeto ingles");
						allOk = false;
					}
				} else {names += ".,";}
				if (tioRBtn.isSelected()) {
					if (isCorrect(tioField.getText())) {
						if (!(tioField.getText().trim().equals("")) && !(tioField.getText() == null)) {
							names += (tioField.getText().trim() + ",");
							areReserved = true;
						} else {
							errorMessage("ERROR en 10: Nombre vacio");
							allOk = false;
						}
					} else {
						errorMessage("ERROR en 10: Solo caracteres del alfabeto ingles");
						allOk = false;
					}
				} else {names += ".,";}
				if (areReserved) {
					try {
						if (allOk) {
							CtrlReservations cont = new CtrlReservations();
							String[] res = new String[4];
							if (!(dateChooser.getDate() == null)) {
								Calendar c = Calendar.getInstance();
								c.setTime(dateChooser.getDate());
								String year = Integer.toString(c.get(Calendar.YEAR));
								String month = Integer.toString(c.get(Calendar.MONTH) + 1);
								if (month.length() == 1) {month = "0" + month;}
								String day = Integer.toString(c.get(Calendar.DAY_OF_MONTH));
								if (day.length() == 1) {day = "0" + day;}
								res[0] = year + "/" + month + "/" + day;
								int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
								if (dayOfWeek == 2) {res[1] = "Lunes";}
								else if (dayOfWeek == 3) {res[1] = "Martes";}
								else if (dayOfWeek == 4) {res[1] = "Miercoles";}
								else if (dayOfWeek == 5) {res[1] = "Jueves";}
								else if (dayOfWeek == 6) {res[1] = "Viernes";}
								else if (dayOfWeek == 7) {res[1] = "Sabado";}
								else if (dayOfWeek == 1) {res[1] = "Domingo";}
								res[2] = turnCombo.getSelectedItem().toString();
								if(cont.checkReservation(res)) {
									res[3] = names;
									cont.addReservation(res);
									cont.setReservations(caller);
									caller.setEnabled(true);
									caller.rightMessage("Reserva realizada correctamente!");
									dispose();
								} else {
									errorMessage("ERROR: Ya hay reservas para ese turno y ese dia");
								}
							} else {
								errorMessage("ERROR: Debes seleccionar una fecha");
							}
						}
					} catch (IOException e1) {
						errorMessage("INTERNAL ERROR!");
					}
				} else {
					errorMessage("ERROR: No has reservado ninguna mesa");
				}
			}
		});
		
		//Cancel Button + Pressed Button Listener
		JButton cancelBtn = new JButton("Cancelar");
		cancelBtn.addActionListener(new ActionListener() {
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
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(tablesLbl, GroupLayout.PREFERRED_SIZE, 630, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(yearLbl, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
									.addGap(28)
									.addComponent(turnLbl, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(turnCombo, 0, 122, Short.MAX_VALUE)
									.addGap(119))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGroup(gl_contentPanel.createSequentialGroup()
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
											.addComponent(nioRBtn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
											.addComponent(sjuRBtn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
											.addComponent(femRBtn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
											.addComponent(treRBtn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
											.addComponent(enRBtn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
											.addComponent(enField, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
											.addComponent(treField, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
											.addComponent(femField, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
											.addComponent(sjuField, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
											.addComponent(nioField, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPanel.createSequentialGroup()
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
											.addComponent(tioRBtn, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
											.addComponent(ottaRBtn, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
											.addComponent(sexRBtn, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
											.addComponent(fyraRBtn, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
											.addComponent(tvaRBtn, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
											.addComponent(tvaField, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
											.addComponent(fyraField, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
											.addComponent(sexField, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
											.addComponent(ottaField, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
											.addComponent(tioField, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE))))))
						.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
							.addGap(409)
							.addComponent(cancelBtn, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(confirmBtn, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(tablesLbl, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(yearLbl)
							.addComponent(turnLbl)
							.addComponent(turnCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(enRBtn, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(tvaRBtn, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(enField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(tvaField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(treRBtn)
						.addComponent(fyraRBtn)
						.addComponent(treField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(fyraField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(femRBtn)
						.addComponent(sexRBtn)
						.addComponent(femField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(sexField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(sjuRBtn)
						.addComponent(ottaRBtn)
						.addComponent(sjuField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ottaField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(nioRBtn)
						.addComponent(tioRBtn)
						.addComponent(nioField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tioField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(cancelBtn)
						.addComponent(confirmBtn))
					.addGap(141))
		);
		
		contentPanel.setLayout(gl_contentPanel);
	}
}
