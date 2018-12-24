package tokyo.monota.study.csvparser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CsvReader {

    public static void main(String[] args) throws Exception {

        Reader reader = Files.newBufferedReader(
                Paths.get(ClassLoader.getSystemResource("csv/sample-001.csv").toURI()));
        CsvToBean<Album> csvReader = new CsvToBeanBuilder<Album>(reader).withType(Album.class).build();
        List<Album> albums = csvReader.parse();
        System.out.println(albums);
    }
}
