public class PersonFinder {

    public String getPerson(int userId) {
        DataBaseWorker worker = new DataBaseWorker();
        User user = worker.getUserFromDb(userId);
        String result = "";
        if (user != null) {
            result = user.toString();
        } else {
            result = "User with same ID is not exist!";
        }
        return result;
    }
}
