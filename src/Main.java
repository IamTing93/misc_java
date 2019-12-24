import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        File path = new File("C:\\Users\\Administrator\\Desktop\\other");
        String[] list;
        if (args.length == 0) {
            list = path.list();
        } else {
            list = path.list(new FilenameFilter() {

                private Pattern pattern = Pattern.compile(args[0]);

                @Override
                public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches();
                }
            });
        }

        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        long size = 0;
        for (String dirItem : list) {
            File tmp = new File(path.getPath() + "/" + dirItem);
            size += tmp.length();
            System.out.println(dirItem);
        }

        System.out.println(size);
    }
}
