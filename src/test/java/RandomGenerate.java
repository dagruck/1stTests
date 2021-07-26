import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RandomGenerate {

    @Test
    public void getNum() throws IOException {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(3)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        String ran = String.format("%06d",new Random().nextInt(999999));
        File file = new File(ran +"data.txt");
        file.createNewFile();                // Создание объекта FileWriter
        for (int i = 0; i < 1000; i++) {
            Random generatedint = new Random();
            String int_random = String.format("%06d",generatedint.nextInt(999999));
            String number = generatedString + int_random;
            System.out.println("INT   " + number);
            FileWriter fStream;
                fStream = new FileWriter(file, true);
                fStream.append(number);
                fStream.append("\n");
                fStream.flush();
                fStream.close();
            }
        }
    }

