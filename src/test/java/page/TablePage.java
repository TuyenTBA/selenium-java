package page;

import herokuapp.Person;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import support.Browser;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TablePage {

    public void open(){
        Browser.visit("https://the-internet.herokuapp.com/tables");
    }

    private List<Person> getListPersonInTable1(){
        List<WebElement> rows = Browser.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

        return rows.stream()
                .map(this::toPerson).collect(Collectors.toList());

    }
    public List<String> getMaxDuePersonInTable1(){
           Person  person = getListPersonInTable1()
                .stream()
                .max(Comparator.comparing(Person::getDue))
                .get();
           return getListPersonInTable1()
                   .stream()
                   .filter(person1 -> person1.getDue()==person.getDue())
                .map(Person::getFullName)
                .collect(Collectors.toList());

    }

    public List<String> getMinDuePersonInTable1() {
        Person minDuePerson = getListPersonInTable1()
                .stream()
                .min(Comparator.comparing(Person::getDue))
                .get();
        return getListPersonInTable1()
                .stream().
                filter(person -> person.getDue()==minDuePerson.getDue())
                .map(Person::getFullName)
                .collect(Collectors.toList());
    }



    private Person toPerson(WebElement element) {
        String lastName = element.findElements(By.tagName("td")).get(0).getText();
        String firstname = element.findElements(By.tagName("td")).get(1).getText();
        String email = element.findElements(By.tagName("td")).get(2).getText();
        float due = Float.parseFloat(element.findElements(By.tagName("td")).get(3).getText().trim().replace("$", ""));
        String website = element.findElements(By.tagName("td")).get(4).getText();
        return new Person(firstname, lastName, email, website, due);
    }


}
