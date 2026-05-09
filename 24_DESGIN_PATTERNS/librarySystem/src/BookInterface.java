public interface BookInterface {
     void borrowBook() ;
     void returnBook() ;
     String getTitle();
     boolean isAvailable();
     void setAvailable(boolean availability);
}
