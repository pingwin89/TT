package pl.pawc.jokes;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import pl.pawc.jokes.model.Joke;

public class Main{

	public static void main(String args[]){
		String command;
		Scanner sc = new Scanner(System.in);
		while((command = sc.nextLine()) != null){
			
			switch(command){
				case "quit" : System.exit(0);
				case "list" : printJokes(Database.getJokes()); break;							 
				case "add" : {
					String j = sc.nextLine();
					Joke joke = new Joke(j);
					HashMap<Integer, Joke> jokes = Database.getJokes();
					int size = jokes.size()+1;
					jokes.put(size, joke);
					Database.writeJokes(jokes);
					break;
				}
				case "remove" : {
					int i = Integer.parseInt(sc.nextLine());
					HashMap<Integer, Joke> jokes = Database.getJokes();
					Joke jokeToRemove = jokes.get(i);
					jokes.remove(i, jokeToRemove);
					log("to write:");
					printJokes(jokes);
					Database.writeJokes(jokes);
					break;
				}
				case "comment" : {
					log("number:");
					int choice = Integer.parseInt(sc.nextLine());
					log("your comment: ");
					String comment = sc.nextLine();
					HashMap<Integer, Joke> jokes = Database.getJokes();
					jokes.get(choice).addComment(comment);
					Database.writeJokes(jokes);
					break;
				}				
				case "top" : {
					HashMap<Integer, Joke> map = Database.getJokes();
					ArrayList<Joke> listToSort = new ArrayList<Joke>();
					for(int i : map.keySet()){
						listToSort.add(map.get(i));
					}
					Collections.sort(listToSort);
					for(Joke joke : listToSort){
						log(joke.toString());
					}
					break;
				}
				case "worst" : {
				}
			}	
	
		}
	
	}

	public static void log(String message){
		System.out.println(message);
	}

	public static void printJokes(HashMap<Integer, Joke> map){
		for(int i=1; i<=map.size(); i++){
			if(map.get(i)==null) continue;
			log(i+": "+map.get(i).toString());
		}
	}

}
