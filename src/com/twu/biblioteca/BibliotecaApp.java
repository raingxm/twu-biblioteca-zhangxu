package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class BibliotecaApp {
    private List<Book> books = new ArrayList<Book>();

    private List<Movie> movies = new ArrayList<Movie>();

    private User loginUser = null;

    private List<User> users = new ArrayList<User>();

    public BibliotecaApp() {
        addSomeBooksToLib();
        addSomeMoviesToLib();
        addInitUsers();
    }

    private void addInitUsers() {
        this.users.add(new User("zhangxv", "xian-001", "123456"));
        this.users.add(new User("liuhuimin", "bei-002", "01234"));
        this.users.add(new User("yehua", "hei-003", "88888888"));
    }

    public List<Book> getBooksList() {
        return books;
    }

    public List<Movie> getMoviesList() {
        return movies;
    }

    public static void main(String[] args) {
        new BibliotecaApp().run();
    }

    public void run() {
        libraryHomePage();
        letUserChooseOption();
    }

    public User getLoginUser() {
        return loginUser;
    }

    private void letUserChooseOption() {
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        while(!option.equals("quit")) {
            if(isValidIntOption(option)) {
                selectMenuOption(parseInt(option));
                option = scanner.nextLine();
            } else {
                MainMenu.invalidOptionPromptMessage();
            }
        }
    }

    public void loginPage() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("please input username(library num)");
            String userLibraryNum = scanner.nextLine();
            System.out.println("please input password");
            String password = scanner.nextLine();
            User loginUser = findUser(userLibraryNum, password);
            if(loginUser != null) {
                System.out.println("login success");
                setLoginUser(loginUser);
                MainMenu.show();
                break;
            } else {
                System.out.println("login fail, user not exist");
            }
        }
    }

    private User findUser(String libraryNum, String password) {
        for(User user : users) {
            if(user.checkUser(libraryNum, password)) {
                return user;
            }
        }
        return null;
    }

    public void selectMenuOption(int option) {
        switch (option) {
            case MainMenu.SHOW_BOOK_LIST_OPTION:
                showBookList();
                break;
            case MainMenu.CHECKOUT_BOOK_OPTION:
                enterCheckoutBookMenu();
                break;
            case MainMenu.RETURN_BOOK_OPTION:
                enterReturnBookMenu();
                break;
            case MainMenu.SHOW_MOVIE_LIST_OPTION:
                showMovieList();
                break;
            case MainMenu.CHECKOUT_MOVIE_OPTION:
                enterCheckoutMovieMenu();
                break;
            default:
                MainMenu.invalidOptionPromptMessage();
        }
    }

    private void enterCheckoutMovieMenu() {
        showCheckMoviePromptMessage();
        Scanner checkoutScanner = new Scanner(System.in);
        String movieName = checkoutScanner.nextLine();
        checkoutMovie(movieName);
    }

    public void checkoutMovie(String movieName) {
        Movie checkoutMovie = findMovieInMovieListByName(movieName);
        if(findMovieInMovieListByName(movieName) != null) {
            checkoutMovie.borrowOut(getLoginUser());
            showCheckMovieSuccessMessage();
        } else {
            showCheckMovieFailMessage();
        }
    }

    private void showCheckMovieFailMessage() {
        System.out.println("That movie is not available.");
    }

    private void showCheckMovieSuccessMessage() {
        System.out.println("enjoy movie at home");
    }

    private void showCheckMoviePromptMessage() {
        System.out.println("please checkout movie, input movie name");
    }

    public void showBookList() {
        System.out.println("Book List:");
        for(Book book : books) {
            if(!book.isBorrowOut()){
                System.out.println(book);
            }
        }
    }

    public void showMovieList() {
        System.out.println("Movie List:");
        for(Movie movie : movies) {
            if(!movie.isBorrowOut()) {
                System.out.println(movie);
            }
        }
    }

    public void enterCheckoutBookMenu() {
        showCheckBookPromptMessage();
        Scanner checkoutScanner = new Scanner(System.in);
        String bookName = checkoutScanner.nextLine();
        checkoutBook(bookName);
    }

    public void checkoutBook(String bookName) {
        Book checkout = findBookInBookListByName(bookName);
        if(checkout != null){
            checkout.borrowOut(getLoginUser());
            showBorrowBookSuccessMessage();
        } else {
            showBorrowBookFailMessage();
        }
    }

    public void enterReturnBookMenu() {
        showReturnBookPromptMessage();
        Scanner returnScanner = new Scanner(System.in);
        String bookName = returnScanner.nextLine();
        returnBook(bookName);
    }

    public void returnBook(String bookName) {
        Book checkout = findBookInBookListByName(bookName);
        if(checkout != null){
            checkout.returnBack();
            showReturnBookSuccessMessage();
        } else {
            showReturnBookFailMessage();
        }
    }

    public void showWelcomeMessage() {
        System.out.println("welcome to use biblioteca");
    }

    public void showMainMenu() {
        MainMenu.show();
    }

    public void libraryHomePage() {
        showWelcomeMessage();
        MainMenu.show();
    }

    public void addSomeBooksToLib() {
        addANewBookToLibrary("C++ Primer", "Bob", 1998);
        addANewBookToLibrary("Java HeadFirst", "Luce", 2007);
    }

    public void addANewBookToLibrary(String name, String author, int publishYear) {
        this.books.add(new Book(name, author, publishYear));
    }

    public void addSomeMoviesToLib() {
        addANewMovieToLibrary("Tomorrow", 2010, "Speberg", 9);
        addANewMovieToLibrary("Spring", 2003, "Steve");
        addANewMovieToLibrary("Money Ball", 2007, "Royn Smith", 8);
    }

    public void addANewMovieToLibrary(String name, int year, String director, int rating) {
        this.movies.add(new Movie(name, year, director, rating));
    }

    public void addANewMovieToLibrary(String name, int year, String director) {
        this.movies.add(new Movie(name, year, director));
    }

    private Book findBookInBookListByName(String bookName) {
        for(Book book: books) {
            if(book.getName().equalsIgnoreCase(bookName)) {
                return book;
            }
        }
        return null;
    }

    private Movie findMovieInMovieListByName(String movieName) {
        for(Movie movie: movies) {
            if(movie.getName().equalsIgnoreCase(movieName)) {
                return movie;
            }
        }
        return null;
    }

    public void setLoginUser(User user) {
        this.loginUser = user;
    }

    private void showReturnBookSuccessMessage() {
        System.out.println("Thank you for returning the book.");
    }

    private void showReturnBookFailMessage() {
        System.out.println("That is not a valid book to return.");
    }

    private void showBorrowBookFailMessage() {
        System.out.println("That book is not available.");
    }

    private void showBorrowBookSuccessMessage() {
        System.out.println("Thank you! Enjoy the book");
    }

    private void showReturnBookPromptMessage() {
        System.out.println("please return book(type book name)");
    }

    private void showCheckBookPromptMessage() {
        System.out.println("please checkout book(type book name)");
    }

    private boolean isValidIntOption(String option) {
        try {
            parseInt(option);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
