package main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Supplier;

public class TestUtil {
    private static String CacheDir = "I:/Microsoft/LogNet - General/RawLogsCache/";

    private static String getDataPath(String fileId) {
        return CacheDir + fileId + ".csv";
    }

    static void writeUseragentFile(String path, ArrayList<String> useragents) {
        try {
            FileWriter fw = new FileWriter(path);

            for (String ua: useragents) {
                fw.write(String.format("1,1,0,%s\n", ua));
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void generateRandomUseragents(String name, Supplier<String> genFunc, int count) {
        String fileId = String.format("useragent/logs_java_%s_%d", name, count);
        String dataPath = getDataPath(fileId);

        ArrayList<String> res = new ArrayList<>();
        System.out.print("Generating UserAgents..\n");
        for (int i = 0; i < count; i ++) {
            String ua = genFunc.get();
            if (res.contains(ua)) {
                i --;
                continue;
            }
            System.out.printf("%d: %s\n", i, ua);
            res.add(ua);
        }

        writeUseragentFile(dataPath, res);
    }
}
