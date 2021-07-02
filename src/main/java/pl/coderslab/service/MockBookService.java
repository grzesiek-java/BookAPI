package pl.coderslab.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import pl.coderslab.model.Book;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Component
public class MockBookService {

    private List<Book> list;
    private static Long nextId = 4L;

    public MockBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        list.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }
    public void add(Book book){
        book.setId(nextId);
        list.add(book);
        nextId++;
    }

    public void removeBook(Long id){
        list.removeIf((el)->el.getId() == id);
    }

}
