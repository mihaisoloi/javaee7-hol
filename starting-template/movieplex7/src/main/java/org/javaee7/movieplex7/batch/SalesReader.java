package org.javaee7.movieplex7.batch;

import javax.batch.api.chunk.AbstractItemReader;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

@Named
@Dependent
public class SalesReader extends AbstractItemReader {

    private BufferedReader reader;

    @Override
    public void open(Serializable checkpoint) throws IOException {
        reader = new BufferedReader(
            new InputStreamReader(
            Thread.currentThread()
                  .getContextClassLoader()
                  .getResourceAsStream("META-INF/sales.csv")));
    }
    @Override
    public Object readItem() throws Exception {
        String line = null;
        try {
            line = reader.readLine();
        }catch(IOException ex) {
            ex.printStackTrace();
        }
        return line;
    }
}
