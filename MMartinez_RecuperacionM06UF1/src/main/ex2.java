package main;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInput;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ex2 {
	static ArrayList<videojuego> arrayVideojuego= new ArrayList<videojuego>();
	public static void main(String[] args) throws IOException, ParserConfigurationException, TransformerException {
		cargarDatos();

	}
		public static void cargarDatos() throws IOException, ParserConfigurationException, TransformerException {
		videojuego vj = new videojuego(); 
		FileInputStream fis=null;
		 DataInputStream entrada = null;
		 File f = new File("..\\MMartinez_RecuperacionM06UF1\\src\\main\\videojocs.dat");
		 try {
			 fis= new FileInputStream(f);
			 entrada = new  DataInputStream(fis);
			 for(int i =0;i<3;i++) {
					vj = new videojuego(entrada.readInt(), entrada.readUTF(), entrada.readUTF(), entrada.readDouble());
					arrayVideojuego.add(vj);
				}
			 DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			  DocumentBuilder db = dbf.newDocumentBuilder();
			  Document doc =  db.newDocument();
			// definimos el elemento raíz del documento
			  Element eRaiz=  doc.createElement("Videoconsolas");
			  doc.appendChild(eRaiz);
			  try {
				// definimos cada uno de los elementos y le asignamos un valor
				  Element eXbox = doc.createElement("XboxOne");
				  eRaiz.appendChild(eXbox);
				  Element ePS4 = doc.createElement("PS4");
				  eRaiz.appendChild(ePS4);
				  Element ePC = doc.createElement("PC");
				  eRaiz.appendChild(ePC);
				  Element eSWITCH = doc.createElement("switch");
				  eRaiz.appendChild(eSWITCH);
				  for (videojuego videojuego : arrayVideojuego) {
					if(videojuego.getPlataforma().equalsIgnoreCase("XboxOne")) {
						Element eJocs= doc.createElement("Jocs");
						eXbox.appendChild(eJocs);
						Element eJoc= doc.createElement("Joc");
						eJocs.appendChild(eJoc);
						Element eID = doc.createElement("id");
						eJoc.appendChild(eID);
						Element enom = doc.createElement("nombre");
						eJoc.appendChild(enom);
						Element epreu = doc.createElement("preu");
						eJoc.appendChild(epreu);
						eID.setTextContent(String.valueOf(videojuego.getNumeroVidiojuego()));
						enom.setTextContent(videojuego.getNombreVidiojuego());
						epreu.setTextContent(String.valueOf(videojuego.getPrecio()));
					}
					if(videojuego.getPlataforma().equalsIgnoreCase("PS4")) {
						Element eJocs= doc.createElement("Jocs");
						eXbox.appendChild(eJocs);
						Element eJoc= doc.createElement("Joc");
						eJocs.appendChild(eJoc);
						Element eID = doc.createElement("id");
						eJoc.appendChild(eID);
						Element enom = doc.createElement("nombre");
						eJoc.appendChild(enom);
						Element epreu = doc.createElement("preu");
						eJoc.appendChild(epreu);
						eID.setTextContent(String.valueOf(videojuego.getNumeroVidiojuego()));
						enom.setTextContent(videojuego.getNombreVidiojuego());
						epreu.setTextContent(String.valueOf(videojuego.getPrecio()));
					}
					if(videojuego.getPlataforma().equalsIgnoreCase("PC")) {
						Element eJocs= doc.createElement("Jocs");
						eXbox.appendChild(eJocs);
						Element eJoc= doc.createElement("Joc");
						eJocs.appendChild(eJoc);
						Element eID = doc.createElement("id");
						eJoc.appendChild(eID);
						Element enom = doc.createElement("nombre");
						eJoc.appendChild(enom);
						Element epreu = doc.createElement("preu");
						eJoc.appendChild(epreu);
						eID.setTextContent(String.valueOf(videojuego.getNumeroVidiojuego()));
						enom.setTextContent(videojuego.getNombreVidiojuego());
						epreu.setTextContent(String.valueOf(videojuego.getPrecio()));
					}
					if(videojuego.getPlataforma().equalsIgnoreCase("switch")) {
						Element eJocs= doc.createElement("Jocs");
						eXbox.appendChild(eJocs);
						Element eJoc= doc.createElement("Joc");
						eJocs.appendChild(eJoc);
						Element eID = doc.createElement("id");
						eJoc.appendChild(eID);
						Element enom = doc.createElement("nombre");
						eJoc.appendChild(enom);
						Element epreu = doc.createElement("preu");
						eJoc.appendChild(epreu);
						eID.setTextContent(String.valueOf(videojuego.getNumeroVidiojuego()));
						enom.setTextContent(videojuego.getNombreVidiojuego());
						epreu.setTextContent(String.valueOf(videojuego.getPrecio()));
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			// clases necesarias finalizar la creación del archivo XML
			  TransformerFactory transformerFactory = TransformerFactory.newInstance();
			  Transformer transformer = transformerFactory.newTransformer();
			  DOMSource source = new DOMSource(doc);
			  StreamResult result = new StreamResult(f);
		
			  transformer.transform(source, result);
			  fis.close();
			  entrada.close();
			  System.out.println("escritura y creacion ficheor XML LISTO.");
		}  catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(fis!=null) {
				fis.close();
			}if( entrada!=null) {
				entrada.close();
			}
			
			
		}
		
	}
}
