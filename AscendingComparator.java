import java.util.Comparator;
//Ascending Comparator
public class AscendingComparator implements Comparator<Avenger>{

    public int compare(Avenger a1, Avenger a2){
        int compFreq= a1.getFreqMentioned() - a2.getFreqMentioned();


        if (compFreq==0){
            return a2.getAlias().compareTo(a1.getAlias());


        }
        else{
            return compFreq;
        }


        }
    }
