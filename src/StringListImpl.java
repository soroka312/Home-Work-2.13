public class StringListImpl implements StringList {

    private String[] arr;
    private int pos = 0;

    public StringListImpl(int initialSize) {
        arr = new String[initialSize];
    }

    public StringListImpl() {
        this(10);
    }

    private void extendArrayIfNeeded() {
        if (pos == arr.length - 1) {
            int length = (int) (arr.length * 1.25);
            String[] tempArr = new String[length];
            System.arraycopy(arr, 0, tempArr, 0, arr.length);
            arr = tempArr;
        }
    }


    @Override
    public String add(String item) {
        extendArrayIfNeeded();
        arr[pos] = item;
        pos++;
        return item;
    }

    @Override
    public String add(int index, String item) {
        if (index > pos - 1) {
            throw new IndexOutOfBoundsException();
        }
        extendArrayIfNeeded();

        for (int i = pos; i > index; i--) {
            arr[i] = arr[i - 1];

        }
        arr[index] = item;

        pos++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (index > pos - 1) {
            throw new IndexOutOfBoundsException();
        }
        arr[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        for (int i = 0; i <= pos; i++) {
            if (arr[i].equals(item)) {
                return remove(i);
            }
        }
        throw new IllegalStateException();
    }

    @Override
    public String remove(int index) {
        if (index > pos - 1) {
            throw new IndexOutOfBoundsException();
        }

        String item = arr[index];

        for (int i = index; i < arr.length; i++) {
            if (i == arr.length - 1) {
                arr[i] = null;
            } else {
                arr[i] = arr[i + 1];
            }

        }
        pos--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < pos; i++) {
            if (arr[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = pos - 1; i >= 0; i--) {
            if (arr[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index > pos - 1) {
            throw new IndexOutOfBoundsException();
        }
        return arr[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) return false;
        if (otherList.size() != this.size()) {
            return false;
        }
        for (int i = 0; i < this.size(); i++) {
            if (!this.get(i).equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return pos;
    }

    @Override
    public boolean isEmpty() {
        return pos == 0;
    }

    @Override
    public void clear() {
        pos = 0;
    }

    @Override
    public String[] toArray() {
        String[] temp = new String[pos];
        System.arraycopy(arr, 0, temp, 0, arr.length);
        return temp;
    }
}
