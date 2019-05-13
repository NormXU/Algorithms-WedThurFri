import java.lang.Enum;

enum RainbowColor{
  RED,
  ORANGE,
  YELLOW,
  GREEN,
  CYAN,
  BLUE,
  PURPLE
}

for (RainbowColor c : RainbowColor.values()) {
 // Do What you want to do
}


Example 2:

public enum NewsRSSFeedEnum{
  YAHOO("http://rss.news.yahoo.com"),
  CBS("http://feeds.com"),
  LATIMES("http://feeds.latimes.com");

  private String rssUrl;

  private NewsRSSFeedEnum(String rss){
    this.rssUrl = rss;
  }

  public String getRssURL(){
    return this.rssUrl;
  }

  public String fetch(){
    HttpReader myReader = new HttpReader(this.rssUrl);
    try {
      return myReader.fetch();
    } catch(IOException ioe) {
      LOG.warn(ioe);
    } finally {
      myReader.close();
    }
    return null;
  }
}
