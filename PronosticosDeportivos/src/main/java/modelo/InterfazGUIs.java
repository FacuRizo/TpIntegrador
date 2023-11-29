package modelo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class InterfazGUIs extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inputPuntos;
	private JTextField inputPuntosExtras;
	private final ButtonGroup radioButtons = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazGUIs frame = new InterfazGUIs(args);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfazGUIs(String args[]) {
		
		SistemaPronostico sistemaPronostico = new SistemaPronostico();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelTitulo = new JLabel("Pronosticos Deportivos");
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelTitulo.setBounds(233, 9, 308, 64);
		contentPane.add(labelTitulo);
		
		inputPuntos = new JTextField();
		inputPuntos.setBounds(386, 110, 86, 20);
		contentPane.add(inputPuntos);
		inputPuntos.setColumns(10);
		
		JLabel lblPuntos = new JLabel("Puntos:");
		lblPuntos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPuntos.setBounds(295, 113, 46, 14);
		contentPane.add(lblPuntos);
		
		JLabel lblPuntosExtras = new JLabel("Puntos Extras:");
		lblPuntosExtras.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPuntosExtras.setBounds(295, 144, 81, 14);
		contentPane.add(lblPuntosExtras);
		
		inputPuntosExtras = new JTextField();
		inputPuntosExtras.setColumns(10);
		inputPuntosExtras.setBounds(386, 141, 86, 20);
		contentPane.add(inputPuntosExtras);
		
		JRadioButton rdbtnCSV = new JRadioButton("CSV");
		radioButtons.add(rdbtnCSV);
		rdbtnCSV.setBounds(386, 80, 56, 23);
		contentPane.add(rdbtnCSV);
		
		JRadioButton rdbtnSQL = new JRadioButton("SQL");
		radioButtons.add(rdbtnSQL);
		rdbtnSQL.setBounds(444, 80, 56, 23);
		contentPane.add(rdbtnSQL);
		
		JLabel lblLectura = new JLabel("Lectura:");
		lblLectura.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLectura.setBounds(295, 83, 46, 14);
		contentPane.add(lblLectura);
		
		JButton btnStart = new JButton("Comenzar");
		btnStart.setBounds(339, 191, 103, 28);
		contentPane.add(btnStart);
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int puntaje = Integer.parseInt(inputPuntos.getText());
				int puntajeExtra = Integer.parseInt(inputPuntosExtras.getText());
				
				Puntaje.setPuntaje(puntaje);
				Puntaje.setPuntajeExtra(puntajeExtra);
				
				if(rdbtnSQL.isSelected()) {
					sistemaPronostico.sistemaInicio(args, 2);
				} else if(rdbtnCSV.isSelected()) {
					sistemaPronostico.sistemaInicio(args, 1);
				}
				
			}
		});
	}}

