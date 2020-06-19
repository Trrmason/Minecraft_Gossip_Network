from twitterscraper import query_tweets
import datetime as dt
import time

def get_tweets():
    tweets = query_tweets("Minecraft", 100000,begindate=dt.date(2018, 11, 5))
    file = open("tweets.txt", "a")
    for tweet in tweets:
        file.write(str(tweet.text.encode('utf-8')) + "\n")
    file.close()
for i in range(1):
    get_tweets()
    time.sleep(1)