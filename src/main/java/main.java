import dao.TweetDAO;
import dao.UserDAO;
import java.util.Date;
import java.util.List;
import model.Tweet;
import model.User;

public class main {

  public static void main(String[] args) {
    User user = new User();
    user.setLogin("Gabryska2");
    user.setLastName("simsowa");
    user.setName("dasd");
    user.setDateOfRegistration(new Date());
    user.setPassword("dd");

    User user2 = new User();
    user2.setLogin("Gabriella");
    user2.setLastName("simsowa22");
    user2.setName("dasd2");
    user2.setDateOfRegistration(new Date());
    user2.setPassword("dd");



    user.getFollows().add(user2);

    UserDAO userDAO = new UserDAO();

    userDAO.createUser(user);
    userDAO.createUser(user2);

    Tweet tweet = new Tweet();
    tweet.setMessage("sdasdasdas");
    tweet.setAuthor(user2);
    TweetDAO tweetDAO = new TweetDAO();

    tweetDAO.addTweet(user2.getLogin(), "asdasdasd");

    List<Tweet> followedTweets = tweetDAO.getFollowedTweets(user.getLogin());

    for(Tweet t : followedTweets){
      System.out.println(t.getAuthor() + " " + t.getMessage() + " " + t.getPublishedAt());
    }


  }


}
