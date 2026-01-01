package functionalandstream;

import java.util.Collection;

public class Author {
    private int id;
    private String firstName;
    private String lastName;
    public Author() {
        this.id = 0;
        this.firstName = "";
        this.lastName = ""; 
    }
    public Author(int id,String firstName,String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName; 
    }
    @Override
    public String toString() {
        return "Id: " + id + "Author Name: " + firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Author other = (Author) obj;
        return id == other.id &&
               firstName.equals(other.firstName) &&
               lastName.equals(other.lastName);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, firstName, lastName);
    }
}
