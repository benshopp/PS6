package domain;


import java.time.LocalDate;
import java.util.UUID;


import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import util.LocalDateAdapter;

public class PersonDomainModel {
	private UUID PersonID;
    private  String firstName;
    private  String lastName;
    private  String street;
    private  Integer postalCode;
    private  String city;
    private  LocalDate birthday;

    /**
     * Default constructor.
     */
    public PersonDomainModel()
    {
    	this.PersonID = UUID.randomUUID();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public UUID getPersonID()
    {
    	return this.PersonID;
    }
    public void setPersonID(UUID personID) {
		PersonID = personID;
	}
}