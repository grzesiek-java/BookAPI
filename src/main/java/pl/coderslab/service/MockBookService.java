package pl.coderslab.service;

import lombok.*;
import org.springframework.stereotype.Component;
import pl.coderslab.model.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@ToString
@Component
public class MockBookService {

    private final List<Book> list;
    private static Long nextId = 4L;

    public MockBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        list.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }
    public List<Book> showBooks(){
        return list;
    }

    public void addBook(Book book){
        book.setId(nextId++);
        list.add(book);
    }
    public void updateBook(Book newBook){
        for(Book book: getList()){
            if(book.getId().equals(newBook.getId())){

                book.setIsbn(newBook.getIsbn());
                book.setTitle(newBook.getTitle());
                book.setAuthor(newBook.getAuthor());
                book.setPublisher(newBook.getPublisher());
                book.setType(newBook.getType());
            }
        }
    }
    

    public void removeBook(Long id){
        list.removeIf((el)->el.getId()==id);
    }

    public Optional<Book> getBookById(Long id) {
        return getList().stream().filter(i->i.getId()==id).findFirst();
    }
}
