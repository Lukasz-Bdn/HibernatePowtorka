package lukasz.hibernate.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name="tweeter_tweet")
public class Tweet {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Size(min=5, max=50)
	private String title;
	@Size(max=160)
	private String tweetText;
	private Date created;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	public Tweet() {
		super();
	}

	public Tweet(String title, String tweetText, Date created) {
		super();
		this.title = title;
		this.tweetText = tweetText;
		this.created = created;
	}

	@Override
	public String toString() {
		return "Tweet [id=" + id + ", title=" + title + ", tweet_text=" + tweetText + ", created=" + created
				+ ", user=" + user + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTweetText() {
		return tweetText;
	}

	public void setTweetText(String tweetText) {
		this.tweetText = tweetText;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}