import java.util.Comparator;
//DescendingComparator
public class DescendingComparator implements Comparator<Avenger> {

	public int compare(Avenger a1, Avenger a2) {
		int compFrequency = a2.getFreqMentioned() - a1.getFreqMentioned();
		
		if (compFrequency == 0) {
			return a1.getAlias().compareTo(a2.getAlias());
			
		} else {
            return compFrequency;
		}
	}
}