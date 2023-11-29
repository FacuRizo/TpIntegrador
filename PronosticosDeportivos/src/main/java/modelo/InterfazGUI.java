package modelo;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;

public class InterfazGUI extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inputPuntos;
	private JTextField inputPuntosExtras;
	private final ButtonGroup radioButtons = new ButtonGroup();
	private SistemaPronostico sistemaPronostico = new SistemaPronostico();
	

	private JTable GanadorTabla;
	private JTextField GanadorField;
	private JButton btnFase;
	private JButton btnRondas;
	private JButton btnPartidos;
	private JButton btnPronosticos;
	private JTable fasesTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazGUI frame = new InterfazGUI(args);
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
	public InterfazGUI(String args[]) {
		

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
		//
		GanadorTabla = new JTable();
		GanadorTabla.setEnabled(false);
		GanadorTabla.setBounds(31, 230, 510, 118);
		contentPane.add(GanadorTabla);
		
		JLabel lblGanador = new JLabel("Ganador");
		lblGanador.setBounds(31, 363, 72, 14);
		contentPane.add(lblGanador);
		
		GanadorField = new JTextField();
		GanadorField.setBounds(91, 359, 86, 20);
		contentPane.add(GanadorField);
		GanadorField.setColumns(10);
		

        btnFase = new JButton("Fases");
        btnFase.setEnabled(false);
        btnFase.setBounds(551, 226, 89, 23);
        contentPane.add(btnFase);

        btnRondas = new JButton("Rondas");
        btnRondas.setEnabled(false);
        btnRondas.setBounds(551, 260, 89, 23);
        contentPane.add(btnRondas);

        btnPartidos = new JButton("Partidos");
        btnPartidos.setEnabled(false);
        btnPartidos.setBounds(551, 294, 89, 23);
        contentPane.add(btnPartidos);

        btnPronosticos = new JButton("Pronosticos");
        btnPronosticos.setEnabled(false);
        btnPronosticos.setBounds(551, 328, 89, 23);
        contentPane.add(btnPronosticos);

		btnStart.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				int puntaje = Integer.parseInt(inputPuntos.getText());
				int puntajeExtra = Integer.parseInt(inputPuntosExtras.getText());
				
				Puntaje.setPuntaje(puntaje);
				Puntaje.setPuntajeExtra(puntajeExtra);
				
				if(rdbtnSQL.isSelected()) {
					sistemaPronostico.sistemaInicio(args, 2);
					mostrarResultadoDummy(GanadorTabla, lblGanador, GanadorField);
					activarBotones();

					mostrarResultado(GanadorTabla, lblGanador, GanadorField);
				} else if(rdbtnCSV.isSelected()) {
					sistemaPronostico.sistemaInicio(args, 1);
					//mostrarResultadoDummy(GanadorTabla, lblGanador, GanadorField);
					activarBotones();

					mostrarResultado(GanadorTabla, lblGanador, GanadorField);

				}
				
			}
		}
		);
	}
	
	private void activarBotones() 
	{
		
	    btnFase.setEnabled(true);
	    btnRondas.setEnabled(true);
	    btnPartidos.setEnabled(true);
	    btnPronosticos.setEnabled(true);
	    
	    btnFase.addActionListener(new ActionListener() 
	    {
	        public void actionPerformed(ActionEvent e) 
	        {
	            mostrarFases();
	        }
	    });

	   btnRondas.addActionListener(new ActionListener() 
	   {
	        public void actionPerformed(ActionEvent e)
	        {
	            mostrarRondas();
	        }

	    });

	    btnPartidos.addActionListener(new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	            mostrarPartidos();
	        }
	    });

	    btnPronosticos.addActionListener(new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e) 
	        {
	            mostrarPronosticos();
	        }
	    });
	}
	
	
	private void mostrarResultado(JTable table, JLabel ganadorLabel, JTextField ganadorField) {
	   
	    String ganador = null;	  
	    DefaultTableModel tableModel = new DefaultTableModel();
	    Map<String, ArrayList<Pronostico>> pronosticoHash = GestorCompetencia.listaPronosticoHash(sistemaPronostico.pronosticoFinal);	
		Map<String, ArrayList<ArrayList<Integer>>>  puntosPorParticipante = GestorCompetencia.puntosPartyAcertadas(pronosticoHash, sistemaPronostico.rondaOrdenada, sistemaPronostico.faseOrdenada); 
		
		tableModel.addColumn("Participante");
	    tableModel.addColumn("Puntos Totales");


	    for (String nombre : puntosPorParticipante.keySet()) 
	    {
	        int puntosTotales = GestorCompetencia.puntosTotales(puntosPorParticipante, nombre);

	        tableModel.addRow(new Object[]{nombre, puntosTotales});
	    }

	    table.setModel(tableModel);
	    table.repaint();

	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(31, 230, 510, 118);
	    contentPane.add(scrollPane);

	    contentPane.revalidate();
	    contentPane.repaint();

	    ganador =GestorCompetencia.ganador(puntosPorParticipante);
	    ganadorField.setText(ganador);
	}
	
	private void mostrarResultadoDummy(JTable table, JLabel ganadorLabel, JTextField ganadorField) 
	{
	    String ganador = "Dummy Winner"; 
	    DefaultTableModel tableModel = new DefaultTableModel();
	    
	    tableModel.addColumn("Nombre");
	    tableModel.addColumn("Puntos Totales");

	    tableModel.addRow(new Object[]{"Player1", 100});
	    tableModel.addRow(new Object[]{"Player2", 85});
	    tableModel.addRow(new Object[]{"Player3", 120});

	    table.setModel(tableModel);
	    table.repaint();

	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(31, 230, 510, 118);
	    contentPane.add(scrollPane);	    
	    contentPane.revalidate();
	    contentPane.repaint();

	    ganadorField.setText(ganador);
	}
	
	private void mostrarRondas()
	{
		
		    JFrame rondasFrame = new JFrame("Rondas");
		    rondasFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    rondasFrame.setBounds(100, 100, 600, 400);  
		    rondasFrame.setLocationRelativeTo(null);
		  
		    DefaultTableModel rondasTableModel = new DefaultTableModel();
		    rondasTableModel.addColumn("Ronda");
		    rondasTableModel.addColumn("Partido");

		    ArrayList<Ronda> listaRonda = sistemaPronostico.rondaOrdenada;
	
		    for (Ronda rondaIndividual : listaRonda) 
		    {
		    	
		    	int nroRonda = rondaIndividual.getNro();
		        for (Partido partidoIndividual : rondaIndividual.getListaPartidos()) 
		        {
		            String partido1Nombre = partidoIndividual.getEquipo1().getNombre();
		            String part2Nombre = partidoIndividual.getEquipo2().getNombre();
		            
		            String partidoVS = partido1Nombre + " vs " + part2Nombre;

		            rondasTableModel.addRow(new Object[]{nroRonda, partidoVS});
		        }
		    }

		    JTable rondasTable = new JTable(rondasTableModel);
		    JScrollPane rondasScrollPane = new JScrollPane(rondasTable);
		    rondasFrame.getContentPane().add(rondasScrollPane);
		    rondasFrame.setVisible(true);
	}
	
	private void mostrarPronosticos()
	{	
		
		    JFrame pronosticosFrame = new JFrame("Pronosticos");
		    pronosticosFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    pronosticosFrame.setBounds(100, 100, 800, 600);  
		    pronosticosFrame.setLocationRelativeTo(null);
	
		    DefaultTableModel pronosticosTableModel = new DefaultTableModel();
		    pronosticosTableModel.addColumn("Partido");
		    pronosticosTableModel.addColumn("Equipo Seleccionado");
		    pronosticosTableModel.addColumn("Resultado");
		    pronosticosTableModel.addColumn("Participante");

		    ArrayList<Pronostico> listaPronostico = sistemaPronostico.pronosticoFinal; 

		    for (Pronostico pronosticoIndividual : listaPronostico) 
		    {
		        String part1Nombre = pronosticoIndividual.getPartido().getEquipo1().getNombre();
		        String part2Nombre = pronosticoIndividual.getPartido().getEquipo2().getNombre();
		        String equipoNombre = pronosticoIndividual.getEquipo().getNombre();
		        String persona = pronosticoIndividual.getParticipante();
		        ResultadoEnum res = pronosticoIndividual.getResultado();
		        pronosticosTableModel.addRow(new Object[]{part1Nombre + " vs " + part2Nombre, equipoNombre, res, persona});
		    }

		    JTable pronosticosTable = new JTable(pronosticosTableModel);
		    JScrollPane pronosticosScrollPane = new JScrollPane(pronosticosTable);
		    pronosticosFrame.getContentPane().add(pronosticosScrollPane);
		    pronosticosFrame.setVisible(true);
}
	
	private void mostrarPartidos() {
	
	    JFrame partidosFrame = new JFrame("Partidos");
	    partidosFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    partidosFrame.setBounds(100, 100, 600, 400);  
	    partidosFrame.setLocationRelativeTo(null);
	    
	    DefaultTableModel partidosTableModel = new DefaultTableModel();	    
	    partidosTableModel.addColumn("Equipo 1");
	    partidosTableModel.addColumn("Goles 1");
	    partidosTableModel.addColumn("Goles 2");
	    partidosTableModel.addColumn("Equipo 2");
	    partidosTableModel.addColumn("Fase");

	    ArrayList<Partido> listaPartido = sistemaPronostico.partidosFinal;
	    
	    for (Partido partidoIndividual : listaPartido) 
	    {
	        String equipo1 = partidoIndividual.getEquipo1().getNombre();
	        int goles1 = partidoIndividual.getGolesEquipo1();
	        int goles2 = partidoIndividual.getGolesEquipo2();
	        String equipo2 = partidoIndividual.getEquipo2().getNombre();
	        FaseEnum fase = partidoIndividual.getFase();
	        partidosTableModel.addRow(new Object[]{equipo1, goles1, goles2, equipo2, fase});
	    }
	    
	    JTable partidosTable = new JTable(partidosTableModel);
	    JScrollPane partidosScrollPane = new JScrollPane(partidosTable);
	    partidosFrame.getContentPane().add(partidosScrollPane);
	    partidosFrame.setVisible(true);
	}

		
			   
			 

	private void mostrarFases() 
	{
	    JFrame fasesFrame = new JFrame("Fases");
	    fasesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    fasesFrame.setBounds(100, 100, 600, 400);
	    fasesFrame.setLocationRelativeTo(null);

	    DefaultTableModel fasesTableModel = new DefaultTableModel();
	    fasesTableModel.addColumn("Fase");
	    fasesTableModel.addColumn("Ronda");

	    ArrayList<Fase> faseOrdenada = GestorCompetencia.crearFases(sistemaPronostico.rondaOrdenada);

	    for (Fase fase : faseOrdenada) 
	    {
	        FaseEnum nombre = fase.getNombreFase();
	        for (Ronda ronda : fase.getListaRonda()) 
	        {
	            int numero = ronda.getNro();
	            fasesTableModel.addRow(new Object[]{nombre, numero});
	        }
	    }

	    fasesTable = new JTable(fasesTableModel);
	    JScrollPane fasesScrollPane = new JScrollPane(fasesTable);
	    fasesScrollPane.setBounds(31, 30, 510, 300); 
	    fasesFrame.getContentPane().add(fasesScrollPane);

	    fasesFrame.setVisible(true);
	}
}
