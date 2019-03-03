package by.training.taskobject.repository;

public class Repository {
    private Repository() { }

    private static class RepositoryHolder { // nested class
        private final static Repository INSTANCE = new Repository();
    }

    public static Repository getInstance() {
        return RepositoryHolder.INSTANCE;
    }
}
