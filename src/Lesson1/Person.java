package Lesson1;

public class Person {
    private final boolean man;
    private final String name;
    private Person spouse;
    public Person(boolean man, String name) {
        this.man = man;
        this.name = name;
    }

    /**
     * This method checks gender of persons. If genders are not equal - tries to marry.
     * If one of them has another spouse - execute divorce(sets spouse = null for husband and wife. Example: if both persons have spouses - then divorce will set 4 spouse to null) and then executes marry().
     * @param person - new husband/wife for this person.
     * @return - returns true if this person has another gender than passed person and they are not husband and wife, false otherwise
     */
    public boolean marry(Person person) {
        if (person.man != this.man){
                    if (spouse == null) {
                        spouse = person;
                        person.marry(this);
                        return true;
                    }
                    else
                        if (spouse.equals(person)){
                            person.marry(this);
                            return true;
                        }
                        else {
                           if (person.divorce() & this.divorce()) {
                               spouse = person;
                               person.marry(this);
                               return true;
                           }
                           else return false;
                        }

        }
        else return false;
    }

    /**
     * Sets spouse = null if spouse is not null
     * @return true - if person status has been changed
     */
    public boolean divorce() {
        Person tmpPerson = spouse;
        if (spouse != null){
            spouse = null;
            tmpPerson.divorce();
            return true;
        }
        else return false;
    }
}
