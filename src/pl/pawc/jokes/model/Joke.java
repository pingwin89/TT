package pl.pawc.jokes.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Comparator;

public class Joke implements Comparable<Joke>{
	
	private String content;
	private ArrayList<String> comments;
	private Date date;
	private int likeCount;

	public Joke(){
		content = "";
		comments = new ArrayList<String>();
		date = null;
		likeCount = 0;
	}

	public Joke(String content){
		this.content=content;
		comments = new ArrayList<String>();
		date = new Date();
		likeCount = 0;
	}	

	public String getContent(){
		return content;
	}

	public ArrayList<String> getComments(){
		return comments;
	}

	public int getLikeCount(){
		return likeCount;
	} 

	public Date getDate(){
		return date;
	}

	public void addComment(String comment){
		comments.add(comment);
	}

	public void addLike(){
		likeCount++;
	}

	public void setContent(String content){
		this.content = content;
	}

	public void setDate(int date){
		this.date = new Date(date);
	}

	public void setComments(String c){
		String[] cTab = c.split("#");
		comments.clear();
		for(String c2 : cTab){
			comments.add(c2);
		}
	}

	public void setLikeCount(int likeCount){
		this.likeCount = likeCount;
	}

	public String toString(){
		String result = "";
		result+=content+" | comments: ";
		for(String comment : comments){
			result+=comment+", ";
		}
		result+=" | Date: ";
		result+=date.toString()+" | Likes: ";
		result+=likeCount;
		return result;
	}

	public int compareTo(Joke joke){
		return joke.getLikeCount()-likeCount;
	}

}
