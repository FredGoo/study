package gyqw.xiaobaitu.list;

import java.util.*;

/**
 * @author fred
 * 2018-11-13 4:59 PM
 */
public class ListMain {
    public static void main(String[] args) {

    }

    public void desc() {
        Collection collection = new AbstractCollection() {
            @Override
            public Iterator iterator() {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }
        };

        List list = new AbstractList() {
            @Override
            public Object get(int i) {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }
        };

        List list1 = new ArrayList();
    }
}
