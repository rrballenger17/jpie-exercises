package example;


import java.text.MessageFormat;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        
    	// configuration
    	final Configuration configuration = new Configuration().configure();
        
        // 
        final StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        
        // session factory
        final SessionFactory factory = configuration.buildSessionFactory(builder.build());
        
        
        // session 
        final Session session = factory.openSession();
        
        
        
        
        final Book book = new Book("93939398948 ", "Java 8", "Author");
        
        // begin transaction
        session.beginTransaction();
        
        // save book to database
        session.save(book);
        
        // commit transaction
        session.getTransaction().commit();
        
        // look up books -> createCriteria(Book.class).list()
        final List<Book> books = session.createCriteria(Book.class).list();
        
        System.out.println("\n----\n");
        System.out.println(MessageFormat.format("Storing {0} books in the database", books.size()));
        
        
        for (final Book b : books) {
            System.out.println(b.toString());
        }
        
        
        System.out.println("\n----\n");
        session.close();
        factory.close();
    }
 }