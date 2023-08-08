package Notas;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class VentanaPrincipal extends JFrame implements ActionListener{
	private Container contenedor;
	private JLabel nota1, nota2, nota3, nota4, nota5, promedio, desviacion, mayor, menor;
	private JTextField campoNota1, campoNota2, campoNota3, campoNota4, campoNota5;
	private JButton calcular, limpiar;
	
	public VentanaPrincipal() {
		inicio();
		setTitle("Notas"); //Titulo ventana
		setSize(280, 380); //Tamaño ventana
		setLocationRelativeTo(null); //La ventana se posiciona en el centro de la pantalla
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);  //Establece que el tamaño de la ventana no se puede cambiar
		
	}
	
	private void inicio() {
		contenedor = getContentPane(); //Obtiene el panel de contenidos de la ventana
		contenedor.setLayout(null);  //Establece que el contenedor no tiene un layout
		
		nota1 = new JLabel();
		nota1.setText("Nota 1:");
		nota1.setBounds(20, 20, 135, 23);
		campoNota1 = new JTextField();
		campoNota1.setBounds(105, 20, 135, 23);
		
		nota2 = new JLabel();
		nota2.setText("Nota 2:");
		nota2.setBounds(20, 50, 135, 23);
		campoNota2 = new JTextField();
		campoNota2.setBounds(105, 50, 135, 23);
		
		nota3 = new JLabel();
		nota3.setText("Nota 3:");
		nota3.setBounds(20, 80, 135, 23);
		campoNota3 = new JTextField();
		campoNota3.setBounds(105, 80, 135, 23);
		
		nota4 = new JLabel();
		nota4.setText("Nota 4:");
		nota4.setBounds(20, 110, 135, 23);
		campoNota4 = new JTextField();
		campoNota4.setBounds(105, 110, 135, 23);
		
		nota5 = new JLabel();
		nota5.setText("Nota 5:");
		nota5.setBounds(20, 140, 135, 23);
		campoNota5 = new JTextField();
		campoNota5.setBounds(105, 140, 135, 23);
		
		//Establece el boton calcular
		calcular = new JButton();
		calcular.setText("Calcular");
		calcular.setBounds(20, 170, 100, 23);
		calcular.addActionListener(this); //gestiona eventos del boton
		
		//boton limpiar
		limpiar = new JButton();
		limpiar.setText("Limpiar");
		limpiar.setBounds(125, 170, 80, 23);
		limpiar.addActionListener(this);
		
		//Establece la etiqueta del promedio
		promedio = new JLabel();
		promedio.setText("Promedio: ");
		promedio.setBounds(20, 210, 135, 23);
		
		//Establece etiqueta desviacion
		desviacion = new JLabel();
		desviacion.setText("Desviacion = ");
		desviacion.setBounds(20, 240, 200, 23);
		
		//Establece etiqueta nota mayor
		mayor = new JLabel();
		mayor.setText("Nota mayor = ");
		mayor.setBounds(20, 270, 120, 23);
		
		//Establece etiqueta nota menor
		menor = new JLabel();
		menor.setText("Nota menor =");
		menor.setBounds(20, 300, 120, 23);
	
		//Se añade todos los componentes graficos al contenedor de la ventana
		contenedor.add(nota1);
		contenedor.add(campoNota1);
		contenedor.add(nota2);
		contenedor.add(campoNota2);
		contenedor.add(nota3);
		contenedor.add(campoNota3);
		contenedor.add(nota4);
		contenedor.add(campoNota4);
		contenedor.add(nota5);
		contenedor.add(campoNota5);
		contenedor.add(calcular);
		contenedor.add(limpiar);
		contenedor.add(promedio);
		contenedor.add(desviacion);
		contenedor.add(mayor);
		contenedor.add(menor);
	
	}
	
	//Metodo que gestiona los eventos generados en la ventana principal
	@Override
	public void actionPerformed(ActionEvent evento) {
		try {
			if(evento.getSource() == calcular) {
				Notas notas = new Notas();
				//Se obtiene objeto y convierte el valor numerico de la nota 1
				notas.listaNotas[0] = Double.parseDouble(campoNota1.getText());
				// Se obtiene y convierte el valor numérico de la nota 2
				notas.listaNotas[1] = Double.parseDouble(campoNota2.getText());
				// Se obtiene y convierte el valor numérico de la nota 3
				notas.listaNotas[2] = Double.parseDouble(campoNota3.getText());
				// Se obtiene y convierte el valor numérico de la nota 4
				notas.listaNotas[3] = Double.parseDouble(campoNota4.getText());
				// Se obtiene y convierte el valor numérico de la nota 5
				notas.listaNotas[4] = Double.parseDouble(campoNota5.getText());
			
				notas.calcularPromedio();
				notas.calcularDesviacion();
				promedio.setText("Promedio = " + String.valueOf(String.format("%.2f", notas.calcularPromedio())));
				double desv = notas.calcularDesviacion();
				desviacion.setText("Desviacion estandar = " + String.valueOf(String.format("%.2f", desv)));
				mayor.setText("Valor mayor = " + String.valueOf(notas.calcularMayor()));
				// Se muestra el valor menor formateado
				menor.setText("Valor menor = " + String.valueOf(notas.calcularMenor()));
			}
			
		}catch(NumberFormatException e) {
			 JOptionPane.showMessageDialog(null,"No se digitaron numeros. Intenta nuevamente");
			 limpiar();
		}
		
		
		
		if(evento.getSource() == limpiar) {
			limpiar();
		}
	}
	
	void limpiar(){
		campoNota1.setText("");
		campoNota2.setText("");
		campoNota3.setText("");
		campoNota4.setText("");
		campoNota5.setText("");
	}
}
