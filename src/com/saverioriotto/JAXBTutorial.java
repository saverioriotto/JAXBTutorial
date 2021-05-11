package com.saverioriotto;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXBTutorial {

	public static void main(String[] args) {	
		JAXBMarshalling();
		JAXBUnmarshalling();
	}

	
	public static void JAXBMarshalling() {
		
		JAXBContext jaxbContext = null;
       
		try {

            //jaxbContext = JAXBContext.newInstance(Company.class);

            // EclipseLink MOXy needs jaxb.properties at the same package with Company.class or Staff.class
            // Alternative, I prefer define this via eclipse JAXBContextFactory manually.
            jaxbContext = org.eclipse.persistence.jaxb.JAXBContextFactory
                    .createContext(new Class[] {User.class}, null);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            //jaxbMarshaller.marshal(createCompanyObject(), new File("C:\\test\\company.xml"));

            jaxbMarshaller.marshal(CreateUserObject(), System.out);

            // XML Unmarshalling
            /*File file = new File("C:\\test\\company.xml");
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Company o = (Company) jaxbUnmarshaller.unmarshal(file);
            System.out.println(o);*/

        } catch (JAXBException e) {
            e.printStackTrace();
        }
	}
	
	public static void JAXBUnmarshalling() {
		
		String XMLString = 	 " <user id=\"1\">"
							+"  <name>Mario</name>"
							+"  <surname>Rossi</surname>"
							+"  <age>31</age>"
							+"  <username>m.rossi</username>"
							+"  <email>m.rossi@email.it</email>"							
							+" </user>";		
		
		
		JAXBContext jaxbContext = null;
		try {
	          // Normal JAXB RI
	          //jaxbContext = JAXBContext.newInstance(Fruit.class);

	          // EclipseLink MOXy needs jaxb.properties at the same package with Fruit.class
	          // Alternative, I prefer define this via eclipse JAXBContextFactory manually.
	          jaxbContext = org.eclipse.persistence.jaxb.JAXBContextFactory
	                  .createContext(new Class[]{User.class}, null);

	          Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();	          
	         
	          User u = (User) jaxbUnmarshaller.unmarshal(new StringReader(XMLString));

	          System.out.println(u.toString());

	      } catch (JAXBException e) {
	          e.printStackTrace();
	      }
	}
	
	
	public static User CreateUserObject() {		
		User u = new User();
		u.setId(1);
		u.setName("Mario");
		u.setSurname("Rossi");
		u.setAge(31);
		u.setEmail("m.rossi@email.it");
		u.setUsername("m.rossi");
		u.setPhone("+000 231 2345");
		
		return u;
	}
	
}
