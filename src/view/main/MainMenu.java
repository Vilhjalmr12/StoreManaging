package view.main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import java.awt.Color;
import view.client.ClientNew;
import view.client.ClientView;
import view.client.CtrlClients;
import view.reservations.CtrlReservations;
import view.reservations.NewReservation;
import view.reservations.ViewReservation;
import view.tasks.CtrlTasks;
import view.tasks.NewTask;
import view.tasks.ViewTask;
import view.zMessages.ErrorMessage;
import view.zMessages.RightMessage;
import view.zSignature.GulleSignature;

import java.awt.Dimension;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.Font;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import javax.swing.JSeparator;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;

public class MainMenu extends JFrame {
	//Attributes
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel titleLbl = new JLabel("");
	private JScrollPane displayScroll = new JScrollPane();
	private JButton allClientsBtn = new JButton("Seleccionar");
	private JButton addClientBtn = new JButton("Añadir");
	private JButton showReservations = new JButton("Seleccionar");
	private JButton addReservation = new JButton("Añadir");
	private JButton showTasksBtn = new JButton("Seleccionar");
	private JButton newTaskBtn = new JButton("Añadir");
	private JScrollPane nextEventScroll = new JScrollPane();
	private JLabel nextDateLbl = new JLabel("");
	private String currentDate;
	private JList<String> comingEventsList;

	//Show the message and block this frame until the message is closed
  	public void errorMessage(String text) {
  		ErrorMessage msg = new ErrorMessage(this, text);
  		msg.setAlwaysOnTop(true);
  		msg.setVisible(true);
  		setEnabled(false);
  	}
  	
  	public void rightMessage(String text) {
  		RightMessage msg = new RightMessage(this, text);
  		msg.setAlwaysOnTop(true);
  		msg.setVisible(true);
  		setEnabled(false);
  	}
	
	//Getters
	private MainMenu getSelf() {
		return this;
	}
	
	//Setters
	public void setMainDisplayTitle(String text) {
		titleLbl.setText(text);
	}
	
	public void setClients(String[] clients) {
		Arrays.sort(clients);
		JList<String> clientsList = new JList<String>(clients);
		clientsList.setBackground(new Color(69, 69, 69));
		clientsList.setForeground(new Color(252, 252, 252));
		clientsList.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		clientsList.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getClickCount() == 2 && !e.isConsumed()) {
				     e.consume();
				     ClientView viewC = new ClientView(getSelf(), clientsList.getSelectedValue());
				     viewC.setVisible(true);
				     setEnabled(false);
				}
			}
		});
		displayScroll.setViewportView(clientsList);
	}
	
	public void setComingNotes(String[] tasks) {
		if (tasks.length == 0) {
			JLabel l = new JLabel("  -No hay notas pendientes");
			l.setBackground(new Color(54, 54, 54));
			l.setForeground(new Color(252, 252, 252));
			l.setVerticalAlignment(SwingConstants.TOP);
			l.setOpaque(true);
			nextEventScroll.setViewportView(l);
			nextDateLbl.setText("");
		} else {
			Arrays.sort(tasks);
			String s = "";
			for (int i=0; i<tasks.length; ++i) {
				if (!(tasks[i].compareTo(currentDate) < 0)) {
					if (!(s.equals("")) && (tasks[i].split(" - ")[0].equals(s.split(">>>")[0].split(" - ")[0]))) {
						s += tasks[i] + ">>>";
					} else if (s.equals("")) {
						s += tasks[i] + ">>>";
					}
				}
			}
			if (s.length() > 0) {
				String[] t = s.split(">>>");
				if (t[0].split(" - ")[0].equals("Ind")) {
					JLabel l = new JLabel("  -No hay notas pendientes");
					l.setBackground(new Color(54, 54, 54));
					l.setForeground(new Color(252, 252, 252));
					l.setVerticalAlignment(SwingConstants.TOP);
					l.setOpaque(true);
					nextEventScroll.setViewportView(l);
					nextDateLbl.setText("");
				} else {
					nextDateLbl.setText("       " + t[0].split(" - ")[0]);
					for (int i=0; i<t.length; ++i) {
						t[i] = " -" + t[i].split(" - ")[1];
					}
					comingEventsList = new JList<String>(t);
					comingEventsList.setBackground(new Color(54, 54, 54));
					comingEventsList.setForeground(new Color(252, 252, 252));
					comingEventsList.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
					nextEventScroll.setViewportView(comingEventsList);
					comingEventsList.addMouseListener(new MouseAdapter() {
						@Override
						public void mousePressed(MouseEvent e) {
							if (e.getClickCount() == 2 && !e.isConsumed()) {
							    e.consume();
							    String selected = comingEventsList.getSelectedValue();
							    selected = selected.replaceAll(" -", "");
							    selected = nextDateLbl.getText() + " - " + selected;
							    ViewTask task = new ViewTask(getSelf(), selected);
							    task.setAlwaysOnTop(true);
							    setEnabled(false);
							    task.setVisible(true);
							}
						}
					});
				}
			} else {
				JLabel l = new JLabel("  -No hay notas pendientes");
				l.setBackground(new Color(54, 54, 54));
				l.setForeground(new Color(252, 252, 252));
				l.setVerticalAlignment(SwingConstants.TOP);
				l.setOpaque(true);
				nextEventScroll.setViewportView(l);
				nextDateLbl.setText("");
			}
		}
	}
	
	public void setTasks(String[] tasks) {
		Arrays.sort(tasks);
		for (int i=0; i<tasks.length; ++i) {
			if (tasks[i].compareTo(currentDate) < 0) {
				tasks[i] = ">>>" + tasks[i];
			}
		}
		JList<String> tasksList = new JList<String>(tasks);
		tasksList.setBackground(new Color(69, 69, 69));
		tasksList.setForeground(new Color(252, 252, 252));
		tasksList.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		tasksList.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getClickCount() == 2 && !e.isConsumed()) {
					e.consume();
					String selected = tasksList.getSelectedValue();
				     if (selected.charAt(0) == '>') {
				    	 selected = selected.replaceAll(">>>", "");
				     }
				    ViewTask task = new ViewTask(getSelf(), selected);
				    task.setAlwaysOnTop(true);
				    setEnabled(false);
				    task.setVisible(true);
				}
			}
		});
		displayScroll.setViewportView(tasksList);
	}
	
	public void setReservations(String[] reservations) {
		Arrays.sort(reservations);
		for (int i=0; i<reservations.length; ++i) {
			if (reservations[i].compareTo(currentDate) < 0) {
				reservations[i] = ">>>" + reservations[i];
			}
		}
		JList<String> reservationsList = new JList<String>(reservations);
		reservationsList.setBackground(new Color(69, 69, 69));
		reservationsList.setForeground(new Color(252, 252, 252));
		reservationsList.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		reservationsList.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getClickCount() == 2 && !e.isConsumed()) {
				     e.consume();
				     String selected = reservationsList.getSelectedValue();
				     if (selected.charAt(0) == '>') {
				    	 selected = selected.replaceAll(">>>", "");
				     }
				     ViewReservation viewR = new ViewReservation(getSelf(), selected);
				     viewR.setVisible(true);
				     setEnabled(false);
				}
			}
		});
		displayScroll.setViewportView(reservationsList);
	}
	
	//Create the Frame
	public MainMenu() {
		setMinimumSize(new Dimension(747, 540));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 747, 540);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(69, 69, 69));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		//Main Display
		JLabel iconLbl = new JLabel("");
		iconLbl.setHorizontalAlignment(SwingConstants.CENTER);
		iconLbl.setIcon(new ImageIcon(MainMenu.class.getResource("/view/main/icon.png")));
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(138, 138, 138));
		displayScroll.setBackground(new Color(69, 69, 69));
		displayScroll.setBorder(null);
		
		//Initial SetUp
		JLabel welcomeLbl = new JLabel(" ");
		welcomeLbl.setForeground(new Color(252, 252, 252));
		welcomeLbl.setBackground(new Color(69, 69, 69));
		welcomeLbl.setOpaque(true);
		welcomeLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 36));
		welcomeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		titleLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		titleLbl.setBackground(new Color(69, 69, 69));
		titleLbl.setForeground(new Color(252, 252, 252));
		titleLbl.setOpaque(true);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		currentDate = dtf.format(localDate);
		titleLbl.setText(currentDate);
		displayScroll.setColumnHeaderView(titleLbl);
		displayScroll.setViewportView(welcomeLbl);
		try {
			CtrlTasks cont = new CtrlTasks();
			cont.setComingNotes(getSelf());
		} catch (Exception e2) {
			errorMessage("INTERNAL ERROR");
		}
		
		//Menu Bar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu fileMenu = new JMenu("Archivo");
		menuBar.add(fileMenu);
		JPanel runePanel = new JPanel();
		runePanel.setOpaque(false);
		runePanel.setBorder(null);
		JLabel runeLbl = new JLabel("");
		runeLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		runeLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		menuBar.add(runePanel);
		JMenuItem informationBtn = new JMenuItem("Infomación");
		fileMenu.add(informationBtn);
		informationBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Information info = new Information(getSelf());
				info.setAlwaysOnTop(true);
				info.setVisible(true);
				setEnabled(false);
			}
		});
		
		//Buttons Panel
		JPanel panel = new JPanel();
		panel.setBackground(new Color(54, 54, 54));
		JLabel lblClientes = new JLabel("KekoAmigos");
		lblClientes.setForeground(new Color(252, 252, 252));
		JLabel reservationsLbl = new JLabel("Reservas");
		reservationsLbl.setForeground(new Color(252, 252, 252));
		JLabel soonLbl = new JLabel("Proximamente");
		soonLbl.setForeground(new Color(252, 252, 252));
		JLabel tasksLbl = new JLabel("Notas");
		tasksLbl.setForeground(new Color(252, 252, 252));
		nextDateLbl.setOpaque(true);
		nextDateLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		nextDateLbl.setBackground(new Color(54, 54, 54));
		nextDateLbl.setForeground(new Color(252, 252, 252));
		nextDateLbl.setHorizontalAlignment(SwingConstants.LEFT);
		nextEventScroll.setBackground(new Color(54, 54, 54));
		nextEventScroll.setBorder(null);
		nextEventScroll.setColumnHeaderView(nextDateLbl);
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(138, 138, 138));
		allClientsBtn.setHorizontalAlignment(SwingConstants.LEFT);
		
		//Rune Button + Pressed Button Listener
		JButton runeBtn = new JButton("ᛟ");
		runeBtn.setFont(new Font("SansSerif", Font.PLAIN, 15));
		runeBtn.setBorder(null);
		runeBtn.setContentAreaFilled(false);
		runeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GulleSignature rune = new GulleSignature(getSelf());
				rune.setAlwaysOnTop(true);
				setEnabled(false);
				rune.setVisible(true);
			}
		});
		
		//All Clients Button + Pressed Button Listener
		allClientsBtn.setIcon(new ImageIcon(MainMenu.class.getResource("/view/main/view.png")));
		allClientsBtn.setBackground(new Color(66, 99, 126));
		allClientsBtn.setBorder(null);
		allClientsBtn.setContentAreaFilled(false);
		allClientsBtn.setForeground(new Color(252, 252, 252));
		allClientsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectBtn(allClientsBtn);
				try {
					CtrlClients cont = new CtrlClients();
					cont.setClients(getSelf());
				} catch (IOException e1) {
					errorMessage("INTERNAL ERROR");
				}
			}
		});
		addClientBtn.setHorizontalAlignment(SwingConstants.LEFT);
		
		//Add Client Button + Pressed Button Listener
		addClientBtn.setIcon(new ImageIcon(MainMenu.class.getResource("/view/main/add.png")));
		addClientBtn.setBackground(new Color(66, 99, 126));
		addClientBtn.setBorder(null);
		addClientBtn.setContentAreaFilled(false);
		addClientBtn.setForeground(new Color(252, 252, 252));
		addClientBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectBtn(addClientBtn);
				ClientNew client = new ClientNew(getSelf());
				client.setAlwaysOnTop(true);
				setEnabled(false);
				client.setVisible(true);
			}
		});
		showReservations.setHorizontalAlignment(SwingConstants.LEFT);
		
		//Show Reservations + Pressed Button Listener
		showReservations.setIcon(new ImageIcon(MainMenu.class.getResource("/view/main/view.png")));
		showReservations.setForeground(new Color(252, 252, 252));
		showReservations.setContentAreaFilled(false);
		showReservations.setBorder(null);
		showReservations.setBackground(new Color(66, 99, 126));
		showReservations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectBtn(showReservations);
				
				try {
					CtrlReservations cont = new CtrlReservations();
					cont.setReservations(getSelf());
				} catch (Exception e1) {
					errorMessage("INTERNAL ERROR");
				}
			}
		});
		addReservation.setHorizontalAlignment(SwingConstants.LEFT);
		
		//Add Reservation Button + Pressed Button Listener
		addReservation.setIcon(new ImageIcon(MainMenu.class.getResource("/view/main/add.png")));
		addReservation.setForeground(new Color(252, 252, 252));
		addReservation.setContentAreaFilled(false);
		addReservation.setBorder(null);
		addReservation.setBackground(new Color(66, 99, 126));
		addReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectBtn(addReservation);
				NewReservation reserv = new NewReservation(getSelf());
				reserv.setAlwaysOnTop(true);
				setEnabled(false);
				reserv.setVisible(true);
			}
		});
		showTasksBtn.setHorizontalAlignment(SwingConstants.LEFT);
		
		//Show Tasks Button + Pressed Button Listener
		showTasksBtn.setIcon(new ImageIcon(MainMenu.class.getResource("/view/main/view.png")));
		showTasksBtn.setForeground(new Color(252, 252, 252));
		showTasksBtn.setContentAreaFilled(false);
		showTasksBtn.setBorder(null);
		showTasksBtn.setBackground(new Color(66, 99, 126));
		showTasksBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectBtn(showTasksBtn);
				try {
					CtrlTasks cont = new CtrlTasks();
					cont.setTasks(getSelf());
				} catch (Exception e1) {
					errorMessage("INTERNAL ERROR");
				}
			}
		});
		newTaskBtn.setHorizontalAlignment(SwingConstants.LEFT);
		
		//Create New Task Button + Pressed Button Listener
		newTaskBtn.setIcon(new ImageIcon(MainMenu.class.getResource("/view/main/add.png")));
		newTaskBtn.setForeground(new Color(252, 252, 252));
		newTaskBtn.setContentAreaFilled(false);
		newTaskBtn.setBorder(null);
		newTaskBtn.setBackground(new Color(66, 99, 126));
		newTaskBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectBtn(newTaskBtn);
				NewTask task = new NewTask(getSelf());
				task.setAlwaysOnTop(true);
				setEnabled(false);
				task.setVisible(true);
			}
		});
		
		//Elements Distribution
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(12)
							.addComponent(separator, GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(displayScroll, GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
								.addComponent(iconLbl, GroupLayout.PREFERRED_SIZE, 537, Short.MAX_VALUE))
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(iconLbl, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(displayScroll, GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE))
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
		);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(nextEventScroll, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
						.addComponent(lblClientes, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
						.addComponent(addClientBtn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
						.addComponent(allClientsBtn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
						.addComponent(reservationsLbl, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
						.addComponent(addReservation, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
						.addComponent(showReservations, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
						.addComponent(tasksLbl, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
						.addComponent(newTaskBtn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
						.addComponent(showTasksBtn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
						.addComponent(separator_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
						.addComponent(soonLbl, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblClientes)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(addClientBtn)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(allClientsBtn)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tasksLbl)
					.addGap(6)
					.addComponent(newTaskBtn, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(showTasksBtn, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(reservationsLbl)
					.addGap(7)
					.addComponent(addReservation, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(showReservations, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(soonLbl)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(nextEventScroll, GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		
		GroupLayout gl_runePanel = new GroupLayout(runePanel);
		gl_runePanel.setHorizontalGroup(
			gl_runePanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_runePanel.createSequentialGroup()
					.addContainerGap(595, Short.MAX_VALUE)
					.addComponent(runeLbl, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(runeBtn, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
		);
		gl_runePanel.setVerticalGroup(
			gl_runePanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_runePanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(runeLbl, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
					.addComponent(runeBtn, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
		);
		runePanel.setLayout(gl_runePanel);
		setContentPane(contentPane);
	}
	
	private void selectBtn(JButton b) {
		allClientsBtn.setEnabled(false);
		addClientBtn.setEnabled(false);
		showReservations.setEnabled(false);
		addReservation.setEnabled(false);
		showTasksBtn.setEnabled(false);
		newTaskBtn.setEnabled(false);
		
		allClientsBtn.setOpaque(false);
		addClientBtn.setOpaque(false);
		showReservations.setOpaque(false);
		addReservation.setOpaque(false);
		showTasksBtn.setOpaque(false);
		newTaskBtn.setOpaque(false);
		
		b.setOpaque(true);
		
		allClientsBtn.setEnabled(true);
		addClientBtn.setEnabled(true);
		showReservations.setEnabled(true);
		addReservation.setEnabled(true);
		showTasksBtn.setEnabled(true);
		newTaskBtn.setEnabled(true);
	}
}
