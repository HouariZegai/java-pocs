package org.zegai.jooq;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.zegai.jooq.gen.jooq.tables.pojos.Author;
import org.zegai.jooq.gen.jooq.tables.pojos.Book;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.zegai.jooq.gen.jooq.Tables.AUTHOR;
import static org.zegai.jooq.gen.jooq.Tables.BOOK;


public class App {

    public static void main(String[] args) {
        App app = new App();

        var url = "jdbc:postgresql://localhost:5432/mydb";
        var user = "postgres";
        var password = "postgres";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            DSLContext dsl = DSL.using(conn, SQLDialect.POSTGRES);

            int resultCreateAuthor = app.createAuthor(dsl);
            System.out.println("Auth - Inserted " + resultCreateAuthor + " record(s)");

            int resultCreateBook = app.createBook(dsl);
            System.out.println("Book - Inserted " + resultCreateBook + " record(s)");

            // Fetch all books
            Result<Record> result = dsl.select().from(BOOK).fetch();
            for (Record record : result) {
                Integer id = record.getValue(BOOK.ID);
                String title = record.getValue(BOOK.TITLE);
                Integer publishedIn = record.getValue(BOOK.PUBLISHED_IN);
                Integer languageId = record.getValue(BOOK.LANGUAGE_ID);

                System.out.println("ID: " + id + " Title: " + title + " Published in: " + publishedIn + " Language ID: " + languageId);
            }

            // Delete a book
            int resultDeleteBook = dsl.delete(BOOK).where(BOOK.ID.eq(1)).execute();
            System.out.println("Book - Deleted " + resultDeleteBook + " record(s)");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void demo() {

    }

    private int createBook(DSLContext dsl) {
        var book = new Book();
        book.setId(1);
        book.setAuthorId(1);
        book.setTitle("1984");
        book.setPublishedIn(1948);
        book.setLanguageId(1);

        return dsl.insertInto(BOOK)
                .columns(BOOK.ID, BOOK.AUTHOR_ID, BOOK.TITLE, BOOK.PUBLISHED_IN, BOOK.LANGUAGE_ID)
                .values(book.getId(), book.getAuthorId(), book.getTitle(), book.getPublishedIn(), book.getLanguageId())
                .execute();
    }

    private int createAuthor(DSLContext dsl) {
        var author = new Author();
        author.setId(1);
        author.setName("George");

        return dsl.insertInto(AUTHOR)
                .columns(AUTHOR.ID, AUTHOR.NAME)
                .values(author.getId(), author.getName())
                .execute();
    }
}
