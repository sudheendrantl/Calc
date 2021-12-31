import java.awt.*;
import java.awt.event.*;
import java.lang.Math;
import javax.swing.*;

class Calc implements ActionListener, KeyListener {

	Integer operation=0;
	Double operand1=0.0, operand2=0.0;
	Double result=0.0;
	Boolean flushText = false;
	JFrame f;
	JPanel p1, p2;
	JButton b[];
	JTextField t;
	Dimension d;

	Calc() {

		f = new JFrame ("Calc");

		p1 = new JPanel(new BorderLayout());
		p2 = new JPanel(new GridLayout(5,4));

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		
		t = new JTextField (5);
		d = new Dimension();
		d.height = 30;
		t.setPreferredSize(d);
		t.addKeyListener(this);
		t.setEditable(false);

		b = new JButton[20];
		f.add(p1,BorderLayout.NORTH);
		f.add(p2);
		p1.add(t);

		p2.add(b[0] = new JButton("1") ); b[0].setActionCommand("1"); b[0].addActionListener(this);
		p2.add(b[1] = new JButton("2") ); b[1].setActionCommand("2"); b[1].addActionListener(this);
		p2.add(b[2] = new JButton("3") ); b[2].setActionCommand("3"); b[2].addActionListener(this);
		p2.add(b[3] = new JButton("/") ); b[3].setActionCommand("/"); b[3].addActionListener(this);

		p2.add(b[4] = new JButton("4") ); b[4].setActionCommand("4"); b[4].addActionListener(this);
		p2.add(b[5] = new JButton("5") ); b[5].setActionCommand("5"); b[5].addActionListener(this);
		p2.add(b[6] = new JButton("6") ); b[6].setActionCommand("6"); b[6].addActionListener(this);
		p2.add(b[7] = new JButton("*") ); b[7].setActionCommand("*"); b[7].addActionListener(this);

		p2.add(b[8] = new JButton("7") ); b[8].setActionCommand("7"); b[8].addActionListener(this);
		p2.add(b[9] = new JButton("8") ); b[9].setActionCommand("8"); b[9].addActionListener(this);
		p2.add(b[10] = new JButton("9") ); b[10].setActionCommand("9"); b[10].addActionListener(this);
		p2.add(b[11] = new JButton("+") ); b[11].setActionCommand("+"); b[11].addActionListener(this);

		p2.add(b[12] = new JButton("0") ); b[12].setActionCommand("0"); b[12].addActionListener(this);
		p2.add(b[13] = new JButton(".") ); b[13].setActionCommand("."); b[13].addActionListener(this);
		p2.add(b[14] = new JButton("Clr") ); b[14].setActionCommand("Clr"); b[14].addActionListener(this);
		p2.add(b[15] = new JButton("-") ); b[15].setActionCommand("-"); b[15].addActionListener(this);

		p2.add(b[16] = new JButton("\u221A") ); b[16].setActionCommand("\u221A"); b[16].addActionListener(this);
		p2.add(b[17] = new JButton("%") ); b[17].setActionCommand("%"); b[17].addActionListener(this);
		p2.add(b[18] = new JButton("1/x") ); b[18].setActionCommand("1/x"); b[18].addActionListener(this);
		p2.add(b[19] = new JButton("=") ); b[19].setActionCommand("="); b[19].addActionListener(this);

		f.pack();
		f.setVisible(true);
	}

	public void keyTyped ( KeyEvent e ) {

		Character ch = e.getKeyChar();

		switch ( ch ) {
			case '/':
				if ( t.getText().equals("")){
					operand1 = 0.0;
				} else {
					operand1 = Double.parseDouble(t.getText());
				}
				operation = 0;
				t.setText("");
				break;

			case '*':
				if ( t.getText().equals("")){
					operand1 = 0.0;
				} else {
					operand1 = Double.parseDouble(t.getText());
				}
				operation = 1;
				t.setText("");
				break;

			case '+':
				if ( t.getText().equals("")){
					operand1 = 0.0;
				} else {
					operand1 = Double.parseDouble(t.getText());
				}
				operation = 2;
				t.setText("");
				break;

			case '-':
				if ( t.getText().equals("")){
					operand1 = 0.0;
				} else {
					operand1 = Double.parseDouble(t.getText());
				}
				operation = 3;
				t.setText("");
				break;

			case '%':
				if ( t.getText().equals("")){
					operand1 = 0.0;
				} else {
					operand1 = Double.parseDouble(t.getText());
				}
				operation = 4;
				t.setText("");
				break;

			case '=':
				if ( t.getText().equals("")){
					operand2 = 0.0;
				} else {
					operand2 = Double.parseDouble(t.getText());
				}
				switch ( operation ) {
					case 0:
						result = operand1 / operand2;
						break;
					case 1:
						result = operand1 * operand2;
						break;
					case 2:
						result = operand1 + operand2;
						break;
					case 3:
						result = operand1 - operand2;
						break;
					case 4:
						result = operand1 % operand2;
						break;
					default:
						result = operand2;
						break;
				}
				t.setText(result.toString()); operand1 = result; flushText = true; operation=-1;
				break;

			default:
				if ( true == flushText ) {
					flushText = false;
					t.setText("");
				}
				if ( ( ch >= '0' ) && ( ch <= '9' ) ) {
					t.setText(t.getText()+ch.toString());
				}
				else{
					t.setText("");
				}

				break;
		} 
	}

	public void keyPressed ( KeyEvent e ) {}

	public void keyReleased ( KeyEvent e ) {}

	public void actionPerformed(ActionEvent e) {

		String s = e.getActionCommand();

		if ( s.equals("Clr") ) {
			operand1 = 0.0;
			operation = -1;
			t.setText("");

		} else if ( s.equals("/") ) {
			if(t.getText().equals("")){
				operand1 = 0.0;
			} else {
				operand1 = Double.parseDouble(t.getText());
			}
			operation = 0;
			t.setText("");

		} else if ( s.equals("*") ) {
			if(t.getText().equals("")){
				operand1 = 0.0;
			} else {
				operand1 = Double.parseDouble(t.getText());
			}
			operation = 1;
			t.setText("");

		} else if ( s.equals("+") ) {
			if(t.getText().equals("")){
				operand1 = 0.0;
			} else {
				operand1 = Double.parseDouble(t.getText());
			}
			operation = 2;
			t.setText("");

		} else if ( s.equals("-") ) {
			if(t.getText().equals("")){
				operand1 = 0.0;
			} else {
				operand1 = Double.parseDouble(t.getText());
			}
			operation = 3;
			t.setText("");

		} else if ( s.equals("%") ) {
			if(t.getText().equals("")){
				operand1 = 0.0;
			} else {
				operand1 = Double.parseDouble(t.getText());
			}
			operation = 4;
			t.setText("");

		} else if ( s.equals("\u221A") ) {
			if(t.getText().equals("")){
				operand1 = 0.0;
			} else {
				operand1 = Double.parseDouble(t.getText());
			}
			result = Math.sqrt(operand1);
			t.setText(result.toString()); operand1 = result; flushText = true;

		} else if ( s.equals("1/x") ) {
			if(t.getText().equals("")){
				operand1 = 0.0;
			} else {
				operand1 = Double.parseDouble(t.getText());
			}
			if( operand1 != 0 ){
				result = 1.0/operand1;
			} else {
				result = 0.0;
			}

			t.setText(result.toString()); operand1 = result; flushText = true;

		} else if ( s.equals("=") ) {

			if(t.getText().equals("")){
				operand2 = operand1;
			} else {
				operand2 = Double.parseDouble(t.getText());
			}
			switch ( operation ) {
				case 0:
					if ( operand2 != 0 ) {
						result = operand1 / operand2;
					} else {
						result = 0.0;
						t.setText("Infinity"); operand1 = result; flushText = true; operation=-1;
						return;
					}
					break;
				case 1:
					result = operand1 * operand2;
					break;
				case 2:
					result = operand1 + operand2;
					break;
				case 3:
					result = operand1 - operand2;
					break;
				case 4:
					result = operand1 % operand2;
					break;
				default:
					result = operand2;
					break;
			}

			t.setText(result.toString()); operand1 = result; flushText = true; operation=-1;

		} else {
			if ( true == flushText ) {
				flushText = false;
				t.setText("");
			}
			t.setText(t.getText()+s);
		}
	}

	public static void main( String[] args ) {
		Calc obj = new Calc();
	}
}
