<h1> Problem 2 </h1>
<h2> Minecraft tweets </h2>
<br>
<h2> Guide </h2>
<p> Description</p>
<p>Network Description </p>
<p>Java File Description </p>
<p>Answering Questions </p>
<br>
<h2> Description </h2>
<a name = "description"> </a>
<p> I decided to make a gossip network on minecraft tweets. My first step was to gather the minecraft tweets (I explain my process in the questions). After I had enough tweets I needed to clean the tweets for spam. I did this by using hashmaps to keep count of recurring tweets. I also utilized ragex to find characters that most likely meant the tweet was spam. After this I had to decide how to format my data for the network. The approach I took was to use a source word and a target word. I did this by using a hashmap to store j word and store j+1 word as the value. Since there was so many target words I decided to make the value of my original hashmap to another hashmap that stored the source word as the key and the count as the value. I did this after I realized that my network would be way to cluttered. After completing this I needed to shorten my list to the most frequent words so on the source words I used a threshold of >200 target words. I made three different networks with this threshold which included the top target word, the top two target words and the top five target words. I explain the networks in the network description.</p>
<br>
<h2> Network Description </h2>
<a name = "network"> </a>
<p> I have three different networks <a href = "./networkPDFs"> here </a>. The way the networks work is that there is a target and source node. The target node is j and the source node is j+1. I did this by using a hashmap to store j word and store j+1 word as the value. Since there were so many target words I decided to make the value of my original hashmap to another hashmap that stored the source word as the key and the count as the value. Each network is a directed graph which is equivalent to us reading from left to right. This lets me see different combinations of words that are most likely to appear next to one another. This also allows the separation of different languages. In networkFive you can really tell that there is a cluster of spanish words on the right side of the network. networkOne is a network with 1 target node and 1 source node. This network is smaller and easier to read. networkTwo is a network with one source node and two target nodes. networkFive is a network with one source node and five target nodes. This network is the most complicated and is hard to read. Also this network takes into account the occurrence of the target words and the words that are the most frequent targets will be bigger than other nodes. </p>
<br>
<h2> Java File Description </h2>
<p> CleanTweets.java is the first java file I made to clean the scraped tweets. The input file is tweets.txt and the output file is clean_tweets.txt </p>
<p> TweetCount.java is used to get a count for each word. This wasn't used for the network but was used to help answer what people talk about on twitter about minecraft. The input file is clean_tweets.txt and the output file is topWords.txt. </p>
<p> Popular.java was used to get the data ready to build the networks. The network description explains my thought process on how this program would work. The input file is clean_tweets.txt and the output file is ready_data.csv </p>
<br>
<h2> Answering Questions </h2>
<a name="questions"> </a>
<br>
<h4> Can you use Cytoscape to visualize the network? </h4>
<p> Yes, by creating a csv file with my discovered data I was able to create easy columns that included source words, target words, and their occurrence. This made it easy to generate directed networks. You can see my generated networks <a href = "./networkPDFs"> here </a>.</p>
<br>
<h4> What are the things that people also talk about the most when they talk about Minecraft </h4>
<p> As you would think the most freqeunt word is minecraft. The next most frequent words are also words you would guess (the, to, and, is, in, you, it, etc..). Aside from these words there are some top frequent words that apply more to Minecraft. play was mentioned 4164 times, server was mentioned 1340 times and some more (fortnite 1070, dungeons 923, steve 593, pc 467, friends 454, bedrock 405, etc..). You can look at the full word frequency <a href = "./textFiles/topWords.txt">here</a> (there is a threshold at >100 mentions). Looking into networkFive we can find what most people are talking about. One of the most frequent phrases is a series of words that ends with "play minecraft." That lets us know that a lot of people on twitter are using the platform to ask other users to play minecraft are generally saying they play minecraft. Another interesting phrase is a series of words and then "fortnite or minecraft." When I say series of words I am talking about multiple combinations of words that lead up to this phrase. Another phrase off of minecraft is "minecraft steve" which I thought was cool because he is the main character you start out with in minecraft. So overall the most talked about stuff on twitter regarding minecraft is usually about playing the game or stating an opinion about the game. To learn more about the networks visit network description. </p>
<br>
<h4> How many days have you tracked to collect the tweets? </h4>
<p> I decided to scrape twitter myself with a Python package I was already familiar with <a href = "https://github.com/taspinar/twitterscraper"> here </a>. I scraped a full year worth of tweets which came to 148476 tweets (Not a complete year of tweets, but random patches of tweets in a year span). You can see these files <a href = "./tweetScraper"> here </a>. Due to the amount of spamming that is done on twitter I tried to filter out spam tweets by using a hashmap "key = tweet, value = count", which got rid of duplicate tweets. This helped, but I still had to do some more tweet cleaning to try to get real tweets. After getting rid of spam tweets, I ended up with 38758 clean tweets</p>
<br>
<p> </p>
<h4> Are there other questions that you would like to ask given the gossip network you construct? </h4>
<p> Even though I tried my hardest to remove spam tweets I wonder how many got through and caused noise in my network. </p>
<p> Would another social media network like reddit have better quality networks since they dont have a char count? </p>
<p> It seems as if most users are using twitter to give quick opinions on minecraft or asking for other users to play with them. Since twitter isn't as community driven as reddit I wonder if the network lacks more personal character that other social media platforms might provide on minecraft. </p>

