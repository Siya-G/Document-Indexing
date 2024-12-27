import java.util.ArrayList;

public class DocumentIndex extends ArrayList<IndexEntry>
{
  public DocumentIndex()
  {
    super();
  }

  public DocumentIndex(int givenCapacity)
  {
    super(givenCapacity);
  }

  private int foundOrInserted(String word)
  {
    String upperCaseWord = word.toUpperCase();
    IndexEntry newEnt = new IndexEntry(upperCaseWord);

    if(this.isEmpty())
    {
      this.add(newEnt);
      return 0;
    }

    for(int i = 0; i < this.size(); i++)
    {
      String curr = this.get(i).getWord();

      if(upperCaseWord.compareToIgnoreCase(curr) < 0)
      {
        this.add(i, newEnt);
        return i;
      }

      if(upperCaseWord.compareToIgnoreCase(curr) == 0)
      {
        return i;
      }
    }
    this.add(newEnt);
    return this.size() - 1;
  }

  public void addWord(String word, int num)
  {
    int ind = foundOrInserted(word);
    IndexEntry entry = this.get(ind);
    entry.add(num);
  }

  public void addAllWords(String str, int num)
  {
    String words[] = str.split("\\W+");

    for(String trial : words)
    {
      if(!trial.isEmpty())
      {
        addWord(trial, num);
      }
    }
  }

}