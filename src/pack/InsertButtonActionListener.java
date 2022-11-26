package pack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
//import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class InsertButtonActionListener  implements ActionListener {

    final JTextField TextField1;
    final JTextField TextField2;
    final JTextArea outputTextArea;
    

	
    public InsertButtonActionListener(JTextField TextField1, JTextField TextField2, JTextArea outputTextArea) {
		this.TextField1 = TextField1;
		this.TextField2 = TextField2;
		this.outputTextArea = outputTextArea;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		final String t1 = TextField1.getText().trim();
		final String t2 = TextField2.getText().trim();
		
		// CHECK & CONVERTDATA
		if (!isDataValid(t1, t2)) {
			final String errmsg = "Invalid Data !";
			this.outputTextArea.setText(errmsg);
		} else {
			
			///////////////////////////////////////////////////////////////

		      FileReader fr = null;
			try {
				fr = new FileReader(t1);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}  //Creation of File Reader object
		      BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
		      StringBuffer sb=new StringBuffer();
		      
		      //Make output file
		      File fout = new File("New_Text_File.txt");
		  	  FileOutputStream fos = null;
			try {
				fos = new FileOutputStream(fout);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		  	  BufferedWriter br2 = new BufferedWriter(new OutputStreamWriter(fos));
		  	
		  	  
		  	  int count=0;  
		  	  String s; 
		  	  int lastIndex = 0;
		      try {
				while((s=br.readLine())!=null){
					sb.append(s);  
					sb.append("\n");
				  }
				String  text = sb.toString();
				String text2= text.replaceAll("(?i)"+t2, t2.toUpperCase());
				String t3=t2.toUpperCase();
				
				while(lastIndex != -1){
				    lastIndex = text2.indexOf(t3,lastIndex);
				    if(lastIndex != -1){
				        count ++;
				        lastIndex += t3.length();
				    }
				}
				br2.write(text2);

				}
			 catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			 }
		     outputTextArea.setText("Number of times mentioned: "+count);
		      
		      try {
				fr.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		      try {
				br2.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			}
			
		}

		private boolean isDataValid(String t1, String t2) {
			final StringBuilder errorsSb = new StringBuilder();
			if (t1.isEmpty()) {
				errorsSb.append("path is empty !");
			}
			if (t2.isEmpty()) {
				if (!errorsSb.isEmpty()) errorsSb.append("\n");
				errorsSb.append("term is empty !");
			}
			
			if (!errorsSb.isEmpty()) {
				JOptionPane.showMessageDialog(null, errorsSb.toString(), "Invalid Data", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			
			return true;
		}
		
		public static String getUserInput() throws Exception {
			
			// InputStreamReader: Reads bytes from Standard Input and Decodes them into characters
			// BufferedReader: Buffers the characters - Enable efficient reading of text data
			final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 

			// Read a line of text
			final String line = reader.readLine(); 
		    
			return line;
			}
		
	}

