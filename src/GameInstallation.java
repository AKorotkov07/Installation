import java.io.*;

public class GameInstallation {
    public static void main(String[] args) {
        File gamesDir = new File("C:\\Users\\ЧПУ Программист\\Desktop\\Games");

        if (!gamesDir.exists())
            gamesDir.mkdirs();

        StringBuilder log = new StringBuilder();

        log.append(createDirectory(gamesDir, "src"));
        log.append(createDirectory(gamesDir, "res"));
        log.append(createDirectory(gamesDir, "savegames"));
        log.append(createDirectory(gamesDir, "temp"));

        File srcDir = new File(gamesDir, "src");
        log.append(createDirectory(srcDir, "main"));
        log.append(createDirectory(srcDir, "test"));

        File mainDir = new File(srcDir, "main");
        log.append(createFile(mainDir, "Main.java"));
        log.append(createFile(mainDir, "Utils.java"));

        File resDir = new File(gamesDir, "res");
        log.append(createDirectory(resDir, "drawables"));
        log.append(createDirectory(resDir, "vectors"));
        log.append(createDirectory(resDir, "icons"));

        File tempDir = new File(gamesDir, "temp");
        File tempFile = new File(tempDir, "temp.txt");
        log.append(createFile(tempDir, "temp.txt"));

        writeLogToFile(tempFile, log.toString());
    }

    private static String createDirectory(File parentDir, String dirName) {
        File dir = new File(parentDir, dirName);
        if (!dir.exists()) {
            if (dir.mkdir()) {
                return "Директория " + dirName + " успешно создана\n";
            } else {
                return "Ошибка при создании директории " + dirName + "\n";
            }
        }
        return "Директория " + dirName + " уже существует\n";
    }

    private static String createFile(File parentDir, String fileName) {
        File file = new File(parentDir, fileName);
        try {
            if (!file.exists()) {
                if (file.createNewFile()) {
                    return "Файл " + fileName + " успешно создан\n";
                } else {
                    return "Ошибка при создании файла " + fileName + "\n";
                }
            }
            return "Файл " + fileName + " уже существует\n";
        } catch (IOException e) {
            e.printStackTrace();
            return "Ошибка при создании файла " + fileName + "\n";
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