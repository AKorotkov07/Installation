import java.io.*;
import java.util.Arrays;
import java.util.List;

public class GameInstallation {
	public static void main(String[] args) {
		File gamesDir = new File("C:\\Users\\Alex\\Desktop\\Games");

		if (!gamesDir.exists())
			gamesDir.mkdirs();

		StringBuilder log = new StringBuilder();

		List<String> directoriesToCreate = Arrays.asList(
				"src",
				"res",
				"savegames",
				"temp",
				"src/main",
				"src/test",
				"res/drawables",
				"res/vectors",
				"res/icons"
		);

		for (String dir : directoriesToCreate) {
			log.append(createDirectory(gamesDir, dir));
		}

		log.append(createFile(new File(gamesDir, "src/main"), "Main.java"));
		log.append(createFile(new File(gamesDir, "src/main"), "Utils.java"));

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