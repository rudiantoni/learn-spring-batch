package com.myapps.budgetstatementexercise.reader;

import com.myapps.budgetstatementexercise.domain.BudgetItem;
import org.springframework.batch.item.*;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.ResourceAwareItemReaderItemStream;
import org.springframework.core.io.Resource;

public class BudgetItemDelegatedReader implements ItemStreamReader<BudgetItem>, ResourceAwareItemReaderItemStream<BudgetItem>  {

    // This is the reader that can be used to read in fact the data from the source files
    private FlatFileItemReader<Object> delegate;
    // Stores the current reading objects
    private Object currentObject;

    public BudgetItemDelegatedReader(FlatFileItemReader<Object> delegate) {
        this.delegate = delegate;
    }


    @SuppressWarnings("NullableProblems")
    @Override
    public void setResource(Resource resource) {
        delegate.setResource(resource);
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        delegate.open(executionContext);
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {
        delegate.update(executionContext);
    }

    @Override
    public void close() throws ItemStreamException {
        delegate.close();
    }

    @Override
    public BudgetItem read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        // If there's no already read object set the currentObject
        if (currentObject == null) {
            currentObject = delegate.read(); // Reads next register
        }

        // Create new BudgetItem object and reset the read one
        BudgetItem budgetItem = (BudgetItem) currentObject;
        currentObject = null;

        // If there's still data to be read and no EOF
        /*
        if (budgetItem != null) {
            // Peek will read and add each Transaction to the Client transactions when the readen data is a Transaction
            while(peek() instanceof BudgetItem) {
                // Now currentObject is not null anymore, since it's receiving data from peek()
                budgetItem.getTransactions().add((Transaction) currentObject);
            }
        }
         */

        // Return the BudgetItem
        return budgetItem;
    }

    private Object peek() throws Exception {
        currentObject = delegate.read(); // Reads next register
        return currentObject;
    }
}
