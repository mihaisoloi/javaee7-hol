package org.javaee7.movieplex7.batch;

import org.javaee7.movieplex7.entities.Sales;

import javax.batch.api.chunk.ItemProcessor;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import java.util.StringTokenizer;

@Named
@Dependent
public class SalesProcessor implements ItemProcessor {

    @Override
    public Object processItem(Object o) throws Exception {
        Sales sales = new Sales();
        StringTokenizer tokens = new StringTokenizer((String)o, ",");
        sales.setId(Integer.parseInt(tokens.nextToken()));
        sales.setAmount(Float.parseFloat(tokens.nextToken()));
        return sales;
    }
}
