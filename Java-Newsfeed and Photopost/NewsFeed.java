/* *
 * Use static array for NewsFeed
 * with constant MAX_SIZE
 * */

public class NewsFeed {

    private Post[] messages;
    private int size;
    public static final int MAX_SIZE = 25;

    public NewsFeed() {
    	this.messages = new Post[MAX_SIZE];
        this.size = 0;
    }

    public void add(Post message) {
        if (this.size < MAX_SIZE) {
            messages[size()] = message;
			this.size++;
        }
		else {
            System.out.println("Can't add post, news feed is full.");
		}
    }

    public Post get(int index) {
	    return messages[index];
    }

    public int size() {
	    return size;
    }

	public void sort(){
		int i, j, argMin;
		Post tmp;
		for (i = 0; i < size() - 1; i++) {
			argMin = i;
			for (j = i + 1; j < size(); j++) {
				if (messages[j].compareTo(messages[argMin]) < 0) {
					argMin = j;
				}
			}

			tmp = messages[argMin];
			messages[argMin] = messages[i];
			messages[i] = tmp;
		}

	}

  	public NewsFeed getPhotoPost(){
  		NewsFeed result = new NewsFeed();
        for (int i = 0; i < size(); i++) {
            if (messages[i] instanceof PhotoPost) {
                result.add(messages[i]);
            }
        }
        return result;
  	}

  	public NewsFeed plus(NewsFeed other){
		NewsFeed newFeed = new NewsFeed();
        for (int i = 0; i < size(); i++) {
            newFeed.add(messages[i]);
        }
		for (int i = 0; i < other.size(); i++) {
			newFeed.add(other.get(i));
		}
		newFeed.sort();
		return newFeed;
  	}

}
