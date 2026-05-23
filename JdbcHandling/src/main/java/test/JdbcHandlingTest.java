package test;

import data.JdbcPerson;
import domain.Person;
import java.util.List;

public class JdbcHandlingTest {

    public static void main(String[] args) {

        JdbcPerson jdbcPerson = new JdbcPerson();	
        
        jdbcPerson.update(1,"John");
        
      

        List<Person> people = jdbcPerson.select();

        for (Person person : people) {
            System.out.print(person);
            System.out.println("");
        }
    }
}