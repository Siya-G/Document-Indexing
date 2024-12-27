import java.util.ArrayList;
public class IndexEntry
{
  private String word;
  private ArrayList <Integer> numsList;

  public IndexEntry(String str)
  {
    word = str.toUpperCase();
    numsList = new ArrayList<>();
  }

  public void add(int num)
  {
    if(numsList.contains(num) == false)
    {
      numsList.add(num);
    }
  }

  public String getWord()
  {
    return word;
  }

  public String toString()
  { 
    String result = "";
    result += word;
    for(int i = 0; i < numsList.size(); i++)
    {
      String indexNum = numsList.get(i).toString();
      if(!result.isEmpty())
      {
        result += " ,";
      }
      result += indexNum;
    }
    return result;
  }
}