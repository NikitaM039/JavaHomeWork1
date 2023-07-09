package ContainerWithBoxes;

import java.util.Comparator;
public class ContainerCountComparator implements Comparator<Container> {

    @Override
    public int compare(Container container1, Container container2) {
        return Integer.compare(container1.sizeContainer(), container2.sizeContainer());
    }
}
