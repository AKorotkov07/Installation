import java.io.*;

public class GameInstallation {
    public static void main(String[] args) {
        File gamesDir = new File("C:\\Users\\ЧПУ Программист\\Desktop\\Games");

        if (!gamesDir.exists())
            gamesDir.mkdirs();

        createDirectory(gamesDir, "src");
        createDirectory(gamesDir, "res");
        createDirectory(gamesDir, "savegames");
        createDirectory(gamesDir, "temp");

        File srcDir = new File(gamesDir, "src");
        createDirectory(srcDir, "main");
        createDirectory(srcDir, "test");

        File mainDir = new File(srcDir, "main");
        createFile(mainDir, "Main.java");
        createFile(mainDir, "Utils.java");

        File resDir = new File(gamesDir, "res");
        createDirectory(resDir, "drawables");
        createDirectory(resDir, "vectors");
        createDirectory(resDir, "icons");

        File tempDir = new File(gamesDir, "temp");
        File tempFile = new File(tempDir, "temp.txt");
        createFile(tempDir, "temp.txt");

        StringBuilder log = new StringBuilder();
        log.append("Файлы и папки успешно созданы");
        writeLogToFile(tempFile, log.toString());
    }

    private static void createDirectory(File parentDir, String dirName) {
        File dir = new File(parentDir, dirName);
        if (!dir.exists())
            dir.mkdir();
    }

    private static void createFile(File parentDir, String fileName) {
        File file = new File(parentDir, fileName);
        try {
            if (!file.exists())
                file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeLogToFile(File file, String log) {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(log);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}